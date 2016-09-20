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
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.scoping.EmptyAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;

public class SimpleParameterAttribution extends EmptyAttribution
{
	public static final @NonNull SimpleParameterAttribution INSTANCE = new SimpleParameterAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		SimpleParameter asSimpleParameter = (SimpleParameter)target;
		if (environmentView.getRequiredType() == PivotPackage.Literals.TYPE) {		// FIXME should be detecting ancestor
			ImperativeTypedModel asTypedModel = asSimpleParameter.getReferredTypedModel();
			for (org.eclipse.ocl.pivot.@NonNull Package asPackage : ClassUtil.nullFree(asTypedModel.getUsedPackage())) {
				environmentView.addAllTypes(asPackage);
			}
			return null;
		}
		else {
			return super.computeLookup(target, environmentView, scopeView);
		}
	}
}
