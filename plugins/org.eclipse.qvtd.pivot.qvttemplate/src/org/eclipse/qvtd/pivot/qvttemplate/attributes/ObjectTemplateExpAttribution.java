/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvttemplate.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;

public class ObjectTemplateExpAttribution extends TemplateExpAttribution
{
	public static final ObjectTemplateExpAttribution INSTANCE = new ObjectTemplateExpAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		ObjectTemplateExp targetElement = (ObjectTemplateExp)target;
		org.eclipse.ocl.pivot.Class referredClass = targetElement.getReferredClass();
		if (referredClass != null) {
			environmentView.addAllProperties(referredClass, FeatureFilter.SELECT_NON_STATIC);
		}
		return super.computeLookup(target, environmentView, scopeView);
	}
}
