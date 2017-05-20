/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.scoping.EmptyAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;

public class GuardParameterAttribution extends EmptyAttribution
{
	public static final @NonNull GuardParameterAttribution INSTANCE = new GuardParameterAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		GuardParameter asGuardParameter = (GuardParameter)target;
		if (environmentView.getRequiredType() == PivotPackage.Literals.TYPE) {		// FIXME should be detecting ancestor
			ImperativeTypedModel asTypedModel = asGuardParameter.getReferredTypedModel();
			for (org.eclipse.ocl.pivot.@NonNull Package asPackage : ClassUtil.nullFree(asTypedModel.getUsedPackage())) {
				environmentView.addAllTypes(asPackage);
			}
			return null;
		}
		else if (environmentView.getRequiredType() == PivotPackage.Literals.PROPERTY) {
			org.eclipse.ocl.pivot.Class asClass = (org.eclipse.ocl.pivot.Class) asGuardParameter.getType();
			if (asClass != null) {
				CompleteClass asCompleteClass = environmentView.getEnvironmentFactory().getCompleteModel().getCompleteClass(asClass);
				String name = environmentView.getName();
				if (name != null) {
					Property property = asCompleteClass.getProperty(name);
					if (property != null) {
						environmentView.addNamedElement(property);
					}
				}
				else {
					environmentView.addAllProperties(asClass, FeatureFilter.SELECT_NON_STATIC);
				}
			}
			return null;
		}
		else {
			return super.computeLookup(target, environmentView, scopeView);
		}
	}
}
