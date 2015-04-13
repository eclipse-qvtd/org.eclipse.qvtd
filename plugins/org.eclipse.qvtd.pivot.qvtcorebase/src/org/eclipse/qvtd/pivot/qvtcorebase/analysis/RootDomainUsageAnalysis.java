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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

public class RootDomainUsageAnalysis extends AbstractDomainUsageAnalysis
{
	/**
	 * The nested analyses for declared operations.
	 */
	protected final @NonNull Map<Operation, NestedDomainUsageAnalysis> operation2analysis = new HashMap<Operation, NestedDomainUsageAnalysis>();

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
	
	protected RootDomainUsageAnalysis(@NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory);
	}

	@NonNull NestedDomainUsageAnalysis analyzeOperation(@NonNull Operation object) {
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
	}

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

	@Override
	protected @NonNull RootDomainUsageAnalysis getRootAnalysis() {
		return this;
	}
}
