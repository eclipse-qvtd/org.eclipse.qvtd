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
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

public class RootDomainUsageAnalysis extends AbstractDomainUsageAnalysis
{
	/**
	 * THe nested analyses for unspecialized operations.
	 */
	protected final @NonNull Map<Operation, NestedDomainUsageAnalysis> operation2analysis = new HashMap<Operation, NestedDomainUsageAnalysis>();

	protected final @NonNull Map<org.eclipse.ocl.pivot.Class, DomainUsage> class2usage = new HashMap<org.eclipse.ocl.pivot.Class, DomainUsage>();

	/**
	 * The usage of the property source.
	 */
	protected final @NonNull Map<Property, DomainUsage> property2source = new HashMap<Property, DomainUsage>();

	/**
	 * The usage of the property target.
	 */
	protected final @NonNull Map<Property, DomainUsage> property2target = new HashMap<Property, DomainUsage>();
	
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
			DomainUsage usage = isCheckable == isEnforceable ? DomainUsageConstant.MIDDLE : isCheckable ? DomainUsageConstant.SOURCE : DomainUsageConstant.TARGET; 
			setUsage(typedModel, usage);
			for (org.eclipse.ocl.pivot.Package asPackage : QVTbaseUtil.getAllUsedPackages(typedModel)) {
				for (org.eclipse.ocl.pivot.Class asClass : asPackage.getOwnedClasses()) {
					DomainUsage oldUsage = class2usage.get(asClass);
					DomainUsage newUsage = oldUsage != null ? intersection(usage, oldUsage) : usage;
					class2usage.put(asClass, newUsage);
				}
			}
		}
		for (org.eclipse.ocl.pivot.Class asClass : class2usage.keySet()) {
			DomainUsage newUsage = class2usage.get(asClass);
			for (Property property : asClass.getOwnedProperties()) {	// FIXME allProperties
				property2source.put(property, newUsage);
				DomainUsage sideUsage = visit(property.getType());
				property2target.put(property, sideUsage);
			}
		}
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
