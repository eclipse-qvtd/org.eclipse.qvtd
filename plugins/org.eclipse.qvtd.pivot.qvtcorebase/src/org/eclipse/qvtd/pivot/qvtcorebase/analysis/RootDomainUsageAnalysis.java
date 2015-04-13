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
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

public class RootDomainUsageAnalysis extends AbstractDomainUsageAnalysis
{
	private static final @NonNull Long NONE_USAGE_BIT_MASK = 0L;
	private static final @NonNull Long PRIMITIVE_USAGE_BIT_MASK = 1L;

	/**
	 * The allocated bit mask per typed model.
	 */
	protected final @NonNull Map<TypedModel, Integer> typedModel2bit = new HashMap<TypedModel, Integer>();

	/**
	 * The allocated bit mask per typed model.
	 */
	protected final @NonNull Map<String, Integer> name2bit = new HashMap<String, Integer>();

	/**
	 * The allocated typed model per bit.
	 */
	protected final @NonNull List<TypedModel> bit2typedModel = new ArrayList<TypedModel>();
	
	/**
	 * Map from Integer to all possible Constant Usages
	 */
	private final @NonNull Map<Long, DomainUsageConstant> constantUsages = new HashMap<Long, DomainUsageConstant>();

	/**
	 * Map from Integer to all valid Constant Usages
	 */
	private final @NonNull Map<Long, DomainUsageConstant> validUsages = new HashMap<Long, DomainUsageConstant>();

	private long checkableMask = 0;

	private long enforceableMask = 0;
	
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
	protected final @NonNull Map<Operation, NestedDomainUsageAnalysis> operation2analysis = new HashMap<Operation, NestedDomainUsageAnalysis>();
	
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
		typedModel2bit.put(typedModel, nextBit);
		name2bit.put(typedModel.getName(), nextBit);
		return nextBit;
	}

	public @NonNull NestedDomainUsageAnalysis analyzeOperation(@NonNull Operation object) {
		NestedDomainUsageAnalysis analysis = operation2analysis.get(object);
		if (analysis == null) {
			analysis = createNestedAnalysis();
			operation2analysis.put(object, analysis);
			DomainUsage usage = analysis.visit(object);
			setUsage(object, usage);
		}
		return analysis;
	}

	
	public @NonNull Map<Element, DomainUsage> analyzeTransformation(@NonNull Transformation transformation) {
		CompleteModelInternal completeModel = context.getCompleteModel();
		for (@SuppressWarnings("null")@NonNull TypedModel typedModel : transformation.getModelParameter()) {
			int nextBit = add(typedModel);
			long bitMask = 1 << nextBit;
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
//										else {
//											mask |= ERROR_BIT;
//										}
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
		visit(transformation);
		return element2usage;
	}

	/*	public @NonNull Map<Element, DomainUsage> analyzeTransformation(@NonNull Transformation transformation) {
		CompleteModelInternal completeModel = context.getCompleteModel();
		for (@SuppressWarnings("null")@NonNull TypedModel typedModel : transformation.getModelParameter()) {
			typedModel2bit.put(typedModel, typedModel2bit.size());
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
			DomainUsageConstant usage = isCheckable == isEnforceable ? DomainUsageConstant.MIDDLE : isCheckable ? DomainUsageConstant.SOURCE : DomainUsageConstant.TARGET; 
			setUsage(typedModel, usage);
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
					DomainUsageConstant newUsage = oldUsage != null ? usage.union(oldUsage) : usage;
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
									try {
										for (String value : detail.getValues()) {
											DomainUsage.Domain enumValue = DomainUsage.Domain.valueOf(value.trim());
											mask |= 1 << enumValue.ordinal();
										}
									}
									catch (Throwable e) {
										mask = DomainUsage.Domain.ERROR.ordinal();
									}
									referredTypeUsage = DomainUsageConstant.getUsage(mask);
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
		class2usage.put(context.getStandardLibrary().getOclTypeType(), DomainUsageConstant.ANY);		// Needed by oclIsKindOf() etc
		visit(transformation);
		return element2usage;
	} */

	protected @NonNull NestedDomainUsageAnalysis createNestedAnalysis() {
		return new NestedDomainUsageAnalysis(this);
	}

	public @NonNull NestedDomainUsageAnalysis getAnalysis(@NonNull Operation operation) {
		NestedDomainUsageAnalysis analysis = operation2analysis.get(operation);
		if (analysis == null) {
			analysis = analyzeOperation(operation);
		}
		return analysis;
	}

	protected long getAnyMask() {
		return (1L << bit2typedModel.size()) - 1;
	}

	public @NonNull DomainUsageConstant getAnyUsage() {
		return getConstantUsage(getAnyMask());
	}

	public @NonNull DomainUsageConstant getConstantUsage(long bitMask) {
		DomainUsageConstant usage = constantUsages.get(bitMask);
		if (usage == null) {
			usage = new DomainUsageConstant(this, bitMask);
			constantUsages.put(bitMask, usage);
		}
		return usage;
	}

	public @NonNull DomainUsage getMiddleUsage() {
		DomainUsageConstant middleUsage2 = middleUsage;
		if (middleUsage2 == null) {
			middleUsage = middleUsage2 = getConstantUsage(getAnyMask() & ~enforceableMask & ~checkableMask);
		}
		return middleUsage2;
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

	public @Nullable DomainUsageConstant getValidUsage(long bitMask) {
		return validUsages.get(bitMask);
	}

	public String toString(long bitMask) {
		StringBuilder s = new StringBuilder();
		boolean first = true;
		for (int i = 0; i < bit2typedModel.size(); i++) {
			long iMask = 1L << i;
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
