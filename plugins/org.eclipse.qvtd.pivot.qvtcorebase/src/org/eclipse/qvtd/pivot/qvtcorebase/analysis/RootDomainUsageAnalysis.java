/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
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

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.util.QVTcoreBaseVisitor;

public class RootDomainUsageAnalysis extends AbstractDomainUsageAnalysis implements QVTcoreBaseVisitor<DomainUsage>
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
					System.err.println("Ambiguous TypedModel: " + this);
//					throw new IllegalStateException("Ambiguous TypedModel: " + this);
					return RootDomainUsageAnalysis.this.getTypedModel(i);
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

		@Override
		public boolean isCheckable() {
			return (bitMask & checkableUsage.bitMask) != 0;
		}

		@Override
		public boolean isEnforceable() {
			return (bitMask & enforceableUsage.bitMask) != 0;
		}

		@Override
		public boolean isMiddle() {
			return (bitMask & middleUsage.bitMask) != 0;
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
					String name = bit2typedModel.get(i).getName();
					s.append(name != null ? name : "$middle$");
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
			return toString("«constant»");
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
			return toString("«variable»");
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
	private final @NonNull Map<Integer, @NonNull DomainUsageConstant> constantUsages = new HashMap<Integer, @NonNull DomainUsageConstant>();

	/**
	 * Map from Integer to all single TypedModel Constant Usages
	 */
	private final @NonNull Map<Integer, DomainUsageConstant> validUsages = new HashMap<Integer, DomainUsageConstant>();

	/**
	 * The TypedModels that are not primitive and not checkable and not enforceable.
	 */
	private DomainUsageConstant middleUsage = null;

	/**
	 * The TypedModels that are checkable.
	 */
	private DomainUsageConstant checkableUsage = null;

	/**
	 * The TypedModels that are enforceable.
	 */
	private DomainUsageConstant enforceableUsage = null;

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
	protected final @NonNull Map<Property, @NonNull DomainUsage> property2referredTypeUsage = new HashMap<Property, @NonNull DomainUsage>();
	
	/**
	 * The nested analyses for declared operations.
	 */
	protected final @NonNull Map<Operation, DomainUsageAnalysis.Internal> operation2analysis = new HashMap<Operation, DomainUsageAnalysis.Internal>();

	@SuppressWarnings("null")
	private final @NonNull TypedModel primitiveTypeModel = QVTbaseFactory.eINSTANCE.createTypedModel();

	private /*@LazyNonNull*/ OperationId oclAnyEqualsOperationId;
	private /*@LazyNonNull*/ OperationId oclAnyNotEqualsOperationId;
	private /*@LazyNonNull*/ OperationId oclElementOclContainerId;
	private /*@LazyNonNull*/ OperationId oclElementOclContentsId;
	private /*@LazyNonNull*/ Property oclElementOclContainerProperty;
	private /*@LazyNonNull*/ Property oclElementOclContentsProperty;
	/**
	 * The properties of the input models that are assigned by mappings and which cannot therefore
	 * be trusted to be loaded from the input models.
	 */
	private final @NonNull Set<Property> dirtyProperties = new HashSet<Property>();
	private final @NonNull Set<EReference> dirtyEReferences = new HashSet<EReference>();


	protected RootDomainUsageAnalysis(@NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory);
		primitiveTypeModel.setName("$primitive$");
		add(primitiveTypeModel);
		validUsages.put(NONE_USAGE_BIT_MASK, getConstantUsage(NONE_USAGE_BIT_MASK));
		validUsages.put(PRIMITIVE_USAGE_BIT_MASK, getConstantUsage(PRIMITIVE_USAGE_BIT_MASK));
		setUsage(primitiveTypeModel, getPrimitiveUsage());
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

	protected void analyzePropertyAssignments(@NonNull Transformation transformation) {
		for (TreeIterator<EObject> tit = transformation.eAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof PropertyAssignment) {
				PropertyAssignment propertyAssignment = (PropertyAssignment)eObject;
				OCLExpression slotExpression = propertyAssignment.getSlotExpression();
				assert slotExpression != null;
				DomainUsage domainUsage = getUsage(slotExpression);
				if (!domainUsage.isEnforceable() && !domainUsage.isMiddle()) {
					Property targetProperty = propertyAssignment.getTargetProperty();
//					System.out.println("Dirty " + targetProperty + " for " + eObject);
					dirtyProperties.add(targetProperty);
					EObject eProperty = targetProperty.getESObject();
					if (eProperty instanceof EReference) {
						dirtyEReferences.add((EReference) eProperty);
					}
				}
			}
		}
		for (Property dirtyProperty : dirtyProperties) {
			if (!dirtyProperty.isIsTransient()) {
				System.out.println("Dirty " + dirtyProperty + " is not transient");
			}
			if (dirtyProperty.isIsReadOnly()) {
				System.out.println("Dirty " + dirtyProperty + " is readonly");
			}
			if (dirtyProperty.isIsRequired()) {
				System.out.println("Dirty " + dirtyProperty + " is required");
			}
		}
	}

	public @NonNull Map<Element, DomainUsage> analyzeTransformation(@NonNull Transformation transformation) {
		int checkableMask = 0;
		int enforceableMask = 0;
		CompleteModelInternal completeModel = context.getCompleteModel();
		for (@SuppressWarnings("null")@NonNull TypedModel typedModel : transformation.getModelParameter()) {
			int nextBit = add(typedModel);
			int bitMask = 1 << nextBit;
			DomainUsageConstant typedModelUsage = getConstantUsage(bitMask);
			validUsages.put(bitMask, typedModelUsage);
			boolean isCheckable = false;
			boolean isEnforceable = false;
			for (Rule rule : transformation.getRule()) {
				for (Domain domain : rule.getDomain()) {
					if (domain.getTypedModel() == typedModel) {
						if (domain.isIsCheckable()) {
							isCheckable = true;
						}
						if (domain.isIsEnforceable()) {
							isEnforceable = true;
						}
					}
				}
			}
			if (isCheckable) {
				checkableMask |= bitMask;
			}
			if (isEnforceable) {
				enforceableMask |= bitMask;
			}
			setUsage(typedModel, typedModelUsage);
			Variable ownedContext = typedModel.getOwnedContext();
			if (ownedContext != null) {
				setUsage(ownedContext, typedModelUsage);
			}
			Set<CompleteClass> completeClasses = new HashSet<CompleteClass>();
// TODO		There is an issue with extending transformations, because just classes extended by the
//			the extending metamodel are tracked. Following code tries to workaround this issue. Also take into account
//			that pivot/ocl are filtered. This might be an issue, when the transformations involve the own pivot metamodel 
//			(e.g. the CS2AS transformation for QVTo, Pivot-based QVTo AS extends Pivot metamodel).
//			Set<Package> allPackages = QVTbaseUtil.getAllUsedPackages(typedModel);
//			Deque<Package> pckQueue = new LinkedList<Package>();	// To track new discovered packages
//			pckQueue.addAll(allPackages);
//			while (!pckQueue.isEmpty()) {
//			Package asPackage = pckQueue.pop();
			for (org.eclipse.ocl.pivot.Package asPackage : QVTbaseUtil.getAllUsedPackages(typedModel)) {
				for (org.eclipse.ocl.pivot.Class asClass : asPackage.getOwnedClasses()) {
					if (asClass != null) {
						for (CompleteClass completeClass : completeModel.getCompleteClass(asClass).getSuperCompleteClasses()) {
							completeClasses.add(completeClass);
//							Package superClassPackage = completeClass.getPrimaryClass().getOwningPackage();
//							if (!allPackages.contains(superClassPackage)
//									&& !isPivotMMPackage(superClassPackage)) {
//								pckQueue.push(superClassPackage);
//								allPackages.add(superClassPackage);
//							}
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
//				System.out.println(property + " => " + referredTypeUsage);
				property2referredTypeUsage.put(property, referredTypeUsage);
			}
		}
		class2usage.put(context.getStandardLibrary().getOclTypeType(), getAnyUsage());		// Needed by oclIsKindOf() etc
		checkableUsage = getConstantUsage(getAnyMask() & checkableMask);
		enforceableUsage = getConstantUsage(getAnyMask() & enforceableMask);
		middleUsage = getConstantUsage(getAnyMask() & ~checkableMask & ~enforceableMask);
		Variable ownedContext = transformation.getOwnedContext();
		if (ownedContext != null) {
			setUsage(ownedContext, getAnyUsage());
		}
		visit(transformation);
		analyzePropertyAssignments(transformation);
		return element2usage;
	}

	@Override
	public @Nullable DomainUsage basicGetUsage(@Nullable EObject element) {
		DomainUsage usage = super.basicGetUsage(element);
		if (usage != null) {
			return usage;
		}
		Operation operation = PivotUtil.getContainingOperation(element);
		if (operation == null) {
			return null;
		}
		DomainUsageAnalysis analyzeOperation = analyzeOperation(operation);
		usage = analyzeOperation.basicGetUsage(element);
		return usage;
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

	public @NonNull DomainUsage getCheckableUsage() {
		return ClassUtil.nonNullState(checkableUsage);
	}

	public @NonNull DomainUsageConstant getConstantUsage(int bitMask) {
		DomainUsageConstant usage = constantUsages.get(bitMask);
		if (usage == null) {
			usage = new DomainUsageConstant(bitMask);
			constantUsages.put(bitMask, usage);
		}
		return usage;
	}

	public @NonNull DomainUsage getEnforceableUsage() {
		return ClassUtil.nonNullState(enforceableUsage);
	}

	public @NonNull DomainUsage getMiddleUsage() {
		return ClassUtil.nonNullState(middleUsage);
	}

	public @NonNull DomainUsage getNoneUsage() {
		DomainUsageConstant noneUsage = constantUsages.get(NONE_USAGE_BIT_MASK);
		assert noneUsage != null;
		return noneUsage;
	}
	
//	public @NonNull TypedModel getPrimitiveTypeModel() {
//		return primitiveTypeModel;
//	}

	public @NonNull OperationId getOclContainerId() {
		OperationId oclElementOclContainerId2 = oclElementOclContainerId;
		if (oclElementOclContainerId2 == null) {
			StandardLibrary standardLibrary = context.getStandardLibrary();
			org.eclipse.ocl.pivot.Class oclElementType = standardLibrary.getOclElementType();
			Operation operation = NameUtil.getNameable(oclElementType.getOwnedOperations(), "oclContainer");
			assert operation != null;
			oclElementOclContainerId = oclElementOclContainerId2 = operation.getOperationId();
		}
		return oclElementOclContainerId2;
	}

	public @NonNull Property getOclContainerProperty() {
		Property oclElementOclContainerProperty2 = oclElementOclContainerProperty;
		if (oclElementOclContainerProperty2 == null) {
			StandardLibrary standardLibrary = context.getStandardLibrary();
			org.eclipse.ocl.pivot.Class oclElementType = standardLibrary.getOclElementType();
			oclElementOclContainerProperty2 = NameUtil.getNameable(oclElementType.getOwnedProperties(), "oclContainer");
			assert oclElementOclContainerProperty2 != null;
			oclElementOclContainerProperty = oclElementOclContainerProperty2;
		}
		return oclElementOclContainerProperty2;
	}

	public @NonNull OperationId getOclContentsId() {
		OperationId oclElementOclContentsId2 = oclElementOclContentsId;
		if (oclElementOclContentsId2 == null) {
			StandardLibrary standardLibrary = context.getStandardLibrary();
			org.eclipse.ocl.pivot.Class oclElementType = standardLibrary.getOclElementType();
			Operation operation = NameUtil.getNameable(oclElementType.getOwnedOperations(), "oclContents");
			assert operation != null;
			oclElementOclContentsId = oclElementOclContentsId2 = operation.getOperationId();
		}
		return oclElementOclContentsId2;
	}

	public @NonNull Property getOclContentsProperty() {
		Property oclElementOclContentsProperty2 = oclElementOclContentsProperty;
		if (oclElementOclContentsProperty2 == null) {
			StandardLibrary standardLibrary = context.getStandardLibrary();
			org.eclipse.ocl.pivot.Class oclElementType = standardLibrary.getOclElementType();
			oclElementOclContentsProperty2 = NameUtil.getNameable(oclElementType.getOwnedProperties(), "oclContents");
			assert oclElementOclContentsProperty2 != null;
			oclElementOclContentsProperty = oclElementOclContentsProperty2;
		}
		return oclElementOclContentsProperty2;
	}

	public @NonNull OperationId getOclAnyEqualsOperationId() {
		OperationId oclAnyEqualsOperationId2 = oclAnyEqualsOperationId;
		if (oclAnyEqualsOperationId2 == null) {
			StandardLibrary standardLibrary = context.getStandardLibrary();
			org.eclipse.ocl.pivot.Class oclAnyType = standardLibrary.getOclAnyType();
			Operation operation = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "=");
			assert operation != null;
			oclAnyEqualsOperationId = oclAnyEqualsOperationId2 = operation.getOperationId();
		}
		return oclAnyEqualsOperationId2;
	}

	public @NonNull OperationId getOclAnyNotEqualsOperationId() {
		OperationId oclAnyNotEqualsOperationId2 = oclAnyNotEqualsOperationId;
		if (oclAnyNotEqualsOperationId2 == null) {
			StandardLibrary standardLibrary = context.getStandardLibrary();
			org.eclipse.ocl.pivot.Class oclAnyType = standardLibrary.getOclAnyType();
			Operation operation = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "<>");
			assert operation != null;
			oclAnyNotEqualsOperationId = oclAnyNotEqualsOperationId2 = operation.getOperationId();
		}
		return oclAnyNotEqualsOperationId2;
	}
	
	public @NonNull TypedModel getPrimitiveTypeModel() {
		return primitiveTypeModel;
	}

	public @NonNull DomainUsage getPrimitiveUsage() {
		DomainUsageConstant primitiveUsage = constantUsages.get(PRIMITIVE_USAGE_BIT_MASK);
		assert primitiveUsage != null;
		return primitiveUsage;
	}

	@Override
	protected @NonNull RootDomainUsageAnalysis getRootAnalysis() {
		return this;
	}

	@SuppressWarnings("null")
	public @NonNull TypedModel getTypedModel(int i) {
		return bit2typedModel.get(i);
	}

/*	@Override
	public @Nullable DomainUsage getUsage(@Nullable EObject element) {
		DomainUsage domainUsage = super.getUsage(element);
		if ((domainUsage == null) && (element instanceof Property)) {
			domainUsage = property2referredTypeUsage.get(element);
		}
		return domainUsage;
	} */

	public @NonNull DomainUsage getUsage(@NonNull Element element) {
		DomainUsage usage = super.basicGetUsage(element);
		if (usage != null) {
			return usage;
		}
		Operation operation = ClassUtil.nonNullState(PivotUtil.getContainingOperation(element));
		DomainUsageAnalysis analyzeOperation = analyzeOperation(operation);
		usage = ClassUtil.nonNullState(analyzeOperation.getUsage(element));
		return usage;
	}

	/**
	 * Return a corresponding non-null usage if bitMask identifies a single domain.
	 */
	public @Nullable DomainUsageConstant getValidUsage(int bitMask) {
		return validUsages.get(bitMask);
	}

	/**
	 * Return either a constant usage if usage is for a single domain,
	 * else re-use a variable usgae else or create
	 * a variable usage for the multiple domains.
	 */
	public @NonNull DomainUsage getValidOrVariableUsage(@NonNull DomainUsage usage) {
		int bitMask = ((DomainUsage.Internal)usage).getMask();
		DomainUsage validUsage = getValidUsage(bitMask);
		if (validUsage != null) {
			return validUsage;
		}
		else if (!usage.isConstant()) {
			return usage;
		}
		else {
			return createVariableUsage(bitMask);
		}
	}

	/**
	 * Return true if a mapping may assign this property in an input model.
	 */
	public boolean isDirty(@NonNull EReference eReference) {
		return dirtyEReferences.contains(eReference);
	}

	/**
	 * Return true if a mapping may assign this property in an input model.
	 */
	public boolean isDirty(@NonNull Property property) {
		return dirtyProperties.contains(property);
	}
	
//	private boolean isPivotMMPackage(Package p) {
//		String pURI = p.getURI();
//		return PivotPackage.eNS_URI.equals(pURI) ||
//				OCLstdlib.STDLIB_URI.equals(pURI);
//	}
}
