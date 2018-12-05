/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.attributes.ModelAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

public class BaseModelAttribution extends ModelAttribution
{
	public static final BaseModelAttribution INSTANCE = new BaseModelAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		ScopeView nextScopeView = super.computeLookup(target, environmentView, scopeView);
		if (!environmentView.hasFinalResult()) {
			BaseModel targetElement = (BaseModel)target;
			environmentView.addNamedElements(QVTbaseUtil.getAllTransformations(targetElement));
		}
		return nextScopeView;
	}
}
