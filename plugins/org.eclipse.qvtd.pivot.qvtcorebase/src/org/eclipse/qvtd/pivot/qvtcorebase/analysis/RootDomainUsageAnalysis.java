/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcorebase.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

public class RootDomainUsageAnalysis extends AbstractDomainUsageAnalysis
{
	protected abstract class AbstractDomainUsage implements DomainUsage.Internal
	{
		protected final int bitMask;
		
		protected AbstractDomainUsage(int bitMask) {
			this.bitMask = bitMask;
		}

		@Override
		public int compareTo(DomainUsage.Internal o) {
			return getMask() - o.getMask();
		}

		@Override
		public int getMask() {
			return bitMask;
		}

		@Override
		public @Nullable TypedModel getTypedModel() throws IllegalStateException {
			int residue = bitMask;
			for (int i = 0; residue != 0; i++) {
				int bit = 1 << i;
				if ((residue & bit) != 0) {
					residue &= ~bit;
					if (residue == 0) {
						return RootDomainUsageAnalysis.this.getTypedModel(i);
					}
					throw new IllegalStateException("Amiguous TypedModel: " + this);
				}
			}
			return null;
		}

		@Override
		public @NonNull Iterable<TypedModel> getTypedModels() {
			List<TypedModel> typedModels = new ArrayList<TypedModel>();
			int residue = bitMask;
			for (int i = 0; residue != 0; i++) {
				int bit = 1 << i;
				if ((residue & bit) != 0) {
					residue &= ~bit;
					typedModels.add(RootDomainUsageAnalysis.this.getTypedModel(i));
				}
			}
			return typedModels;
		}

		protected String toString(@NonNull String prefix) {
			StringBuilder s = new StringBuilder();
			s.append(prefix);
			boolean first = true;
			for (int i = 0; i < bit2typedModel.size(); i++) {
				int iMask = 1 << i;
				if ((bitMask & iMask) != 0) {
					if (!first) {
						s.append("|");
					}
					s.append(bit2typedModel.get(i).getName());
					first = false;
				}
			}
			if (first) {
				s.append("$none$");
			}
			return s.toString();
		}
	}
	
	/**
	 * A DomainUsageConstant identifies a specific domain result from the DomainUsageAnalysis of an OCL AST node.
	 */
	protected class DomainUsageConstant extends AbstractDomainUsage
	{
		protected DomainUsageConstant(int bitMask) {
			super(bitMask);
		}

		@Override
		public void addUsedBy(@NonNull Element element) {}

		@Override
		public @NonNull DomainUsage cloneVariable() {
			return this;
		}

		@Override
		public @Nullable Iterable<Element> getElements() {
			return null;
		}

		@Override
		public boolean isConstant() {
			return true;
		}
	
		@Override
		public String toString() {
			return toString("Constant ");
		}
	
		public @NonNull DomainUsageConstant union(@NonNull DomainUsageConstant usage) {
			return RootDomainUsageAnalysis.this.getConstantUsage(bitMask | usage.bitMask);
		}
	}
	
	/**
	 * A DomainUsageVariable identifies a constrained domain result from the DomainUsageAnalysis of an OCL AST node.
	 */
	protected class DomainUsageVariable extends AbstractDomainUsage
	{
		protected final @NonNull List<Element> usedBy = new ArrayList<Element>();
		
		protected DomainUsageVariable(int bitMask) {
			super(bitMask);
			assert bitMask != 0;
		}

		@Override
		public void addUsedBy(@NonNull Element element) {
			usedBy.add(element);
		}

		@Override
		public @NonNull DomainUsage cloneVariable() {
			return new DomainUsageVariable(bitMask);
		}

		@Override
		public @Nullable Iterable<Element> getElements() {
			return usedBy;
		}

		@Override
		public boolean isConstant() {
			return false;
		}

		@Override
		public String toString() {
			return toString("Variable ");
		}
	}

	/**
	 * A Nested DomainUsageAnalysis is used for a nested context such as an operation which is analyzed without
	 * regard to its invocation parameters. The invoking context is responsible for 'specializing' the generic
	 * domain analysis to suit the invocations.
	 */
	protected class Nested extends AbstractDomainUsageAnalysis
	{
		protected Nested() {
			super(RootDomainUsageAnalysis.this.getEnvironmentFactory());
		}

		@Override
		protected @NonNull RootDomainUsageAnalysis getRootAnalysis() {
			return RootDomainUsageAnalysis.this;
		}
	}
	
	/**
	 * No TypedModels is used by control infrastructure such as MappingLoops.
	 */
	private static final @NonNull Integer NONE_USAGE_BIT_MASK = 0;
	
	/**
	 * The first bit is reserved for the primitive TypedModel that is used by DataTypes.
	 */
	private static final @NonNull Integer PRIMITIVE_USAGE_BIT_MASK = 1;

	/**
	 * The model name to typed model bit mapping.
	 */
	protected final @NonNull Map<String, Integer> name2bit = new HashMap<String, Integer>();

	/**
	 * The bit number to typed model 'mapping'.
	 */
	protected final @NonNull List<TypedModel> bit2typedModel = new ArrayList<TypedModel>();
	
	/**
	 * Map from Integer to all in-use Constant Usages
	 */
	private final @NonNull Map<Integer, DomainUsageConstant> constantUsages = new HashMap<Integer, DomainUsageConstant>();

	/**
	 * Map from Integer to all single TypedModel Constant Usages
	 */
	private final @NonNull Map<Integer, DomainUsageConstant> validUsages = new HashMap<Integer, DomainUsageConstant>();

	/**
	 * The TypedModels that are not primitive and not checkable and not enforceable.
	 */
	private DomainUsageConstant middleUsage = null;

	/**
	 * The domains in which each class may be used.
	 */
	protected final @NonNull Map<org.eclipse.ocl.pivot.Class, DomainUsageConstant> class2usage = new HashMap<org.eclipse.ocl.pivot.Class, DomainUsageConstant>();

	/**
	 * The domains in which the containing class of a property may be used.
	 */
	protected final @NonNull Map<Property, DomainUsage> property2containingClassUsage = new HashMap<Property, DomainUsage>();

	/**
	 * The domains in which the referred type of a property may be used.
	 */
	protected final @NonNull Map<Property, DomainUsage> property2referredTypeUsage = new HashMap<Property, DomainUsage>();
	
	/**
	 * The nested analyses for declared operations.
	 */
	protected final @NonNull Map<Operation, DomainUsageAnalysis.Internal> operation2analysis = new HashMap<Operation, DomainUsageAnalysis.Internal>();
	
	protected RootDomainUsageAnalysis(@NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory);
		TypedModel primitiveTypeModel = QVTbaseFactory.eINSTANCE.createTypedModel();
		primitiveTypeModel.setName("$primitive$");
		add(primitiveTypeModel);
		validUsages.put(NONE_USAGE_BIT_MASK, getConstantUsage(NONE_USAGE_BIT_MASK));
		validUsages.put(PRIMITIVE_USAGE_BIT_MASK, getConstantUsage(PRIMITIVE_USAGE_BIT_MASK));
	}

	protected int add(@NonNull TypedModel typedModel) {
		int nextBit = bit2typedModel.size();
		bit2typedModel.add(typedModel);
		name2bit.put(typedModel.getName(), nextBit);
		return nextBit;
	}

	public @NonNull DomainUsageAnalysis analyzeOperation(@NonNull Operation object) {
		DomainUsageAnalysis.Internal analysis = operation2analysis.get(object);
		if (analysis == null) {
			analysis = createNestedAnalysis();
			operation2analysis.put(object, analysis);
			DomainUsage usage = analysis.visit(object);
			setUsage(object, usage);
		}
		return analysis;
	}

	
	public @NonNull Map<Element, DomainUsage> analyzeTransformation(@NonNull Transformation transformation) {
		int notMiddleMask = PRIMITIVE_USAGE_BIT_MASK;
		CompleteModelInternal completeModel = context.getCompleteModel();
		for (@SuppressWarnings("null")@NonNull TypedModel typedModel : transformation.getModelParameter()) {
			int nextBit = add(typedModel);
			int bitMask = 1 << nextBit;
			DomainUsageConstant typedModelUsage = getConstantUsage(bitMask);
			validUsages.put(bitMask, typedModelUsage);
			boolean gotIt = false;
			for (Rule rule : transformation.getRule()) {
				for (Domain domain : rule.getDomain()) {
					if ((domain.getTypedModel() == typedModel) && (domain.isIsCheckable() || domain.isIsEnforceable())) {
						gotIt = true;
						break;
					}
				}
				if (gotIt) {
					notMiddleMask |= bitMask;
					break;
				}
			}
			setUsage(typedModel, typedModelUsage);
			Set<CompleteClass> completeClasses = new HashSet<CompleteClass>();
			for (org.eclipse.ocl.pivot.Package asPackage : QVTbaseUtil.getAllUsedPackages(typedModel)) {
				for (org.eclipse.ocl.pivot.Class asClass : asPackage.getOwnedClasses()) {
					if (asClass != null) {
						for (CompleteClass completeClass : completeModel.getCompleteClass(asClass).getSuperCompleteClasses()) {
							completeClasses.add(completeClass);
						}
					}
				}
			}
			for (CompleteClass completeClass : completeClasses) {
				for (org.eclipse.ocl.pivot.Class asClass : completeClass.getPartialClasses()) {
					DomainUsageConstant oldUsage = class2usage.get(asClass);
					DomainUsageConstant newUsage = oldUsage != null ? typedModelUsage.union(oldUsage) : typedModelUsage;
					class2usage.put(asClass, newUsage);
				}
			}
		}
		for (org.eclipse.ocl.pivot.Class asClass : class2usage.keySet()) {
			DomainUsage newUsage = class2usage.get(asClass);
			for (Property property : asClass.getOwnedProperties()) {
				property2containingClassUsage.put(property, newUsage);
				DomainUsage referredTypeUsage = null;
				for (Element annotation : property.getOwnedAnnotations()) {
					if (annotation instanceof Annotation) {
						Annotation annotation2 = (Annotation)annotation;
						if (DomainUsage.QVT_DOMAINS_ANNOTATION_SOURCE.equals(annotation2.getName())) {
							for (Detail detail : annotation2.getOwnedDetails()) {
								if (DomainUsage.QVT_DOMAINS_ANNOTATION_REFERRED_DOMAIN.equals(detail.getName())) {
									int mask = 0;
									for (String value : detail.getValues()) {
										Integer bit = name2bit.get(value.trim());
										if (bit != null) {
											mask |= 1 << bit;
										}
									}
									referredTypeUsage = getValidUsage(mask);
								}
							}
						}
						
					}
				}
				if (referredTypeUsage == null) {
					referredTypeUsage = visit(property.getType());
				}
				property2referredTypeUsage.put(property, referredTypeUsage);
			}
		}
		class2usage.put(context.getStandardLibrary().getOclTypeType(), getAnyUsage());		// Needed by oclIsKindOf() etc
		middleUsage = getConstantUsage(getAnyMask() & ~notMiddleMask);
		visit(transformation);
		return element2usage;
	}

	protected @NonNull Nested createNestedAnalysis() {
		return new Nested();
	}

	public @NonNull DomainUsage createVariableUsage(int intersectionMask) {
		return new DomainUsageVariable(intersectionMask);
	}

	public @NonNull DomainUsageAnalysis getAnalysis(@NonNull Operation operation) {
		DomainUsageAnalysis analysis = operation2analysis.get(operation);
		if (analysis == null) {
			analysis = analyzeOperation(operation);
		}
		return analysis;
	}

	protected int getAnyMask() {
		return (1 << bit2typedModel.size()) - 1;
	}

	public @NonNull DomainUsageConstant getAnyUsage() {
		return getConstantUsage(getAnyMask());
	}

	public @NonNull DomainUsageConstant getConstantUsage(int bitMask) {
		DomainUsageConstant usage = constantUsages.get(bitMask);
		if (usage == null) {
			usage = new DomainUsageConstant(bitMask);
			constantUsages.put(bitMask, usage);
		}
		return usage;
	}

	public @NonNull DomainUsage getMiddleUsage() {
		return ClassUtil.nonNullState(middleUsage);
	}

	@SuppressWarnings("null")
	public @NonNull DomainUsage getNoneUsage() {
		return constantUsages.get(NONE_USAGE_BIT_MASK);
	}

	@SuppressWarnings("null")
	public @NonNull DomainUsage getPrimitiveUsage() {
		return constantUsages.get(PRIMITIVE_USAGE_BIT_MASK);
	}

	@Override
	protected @NonNull RootDomainUsageAnalysis getRootAnalysis() {
		return this;
	}

	@SuppressWarnings("null")
	public @NonNull TypedModel getTypedModel(int i) {
		return bit2typedModel.get(i);
	}

	public @Nullable DomainUsageConstant getValidUsage(int bitMask) {
		return validUsages.get(bitMask);
	}
}
