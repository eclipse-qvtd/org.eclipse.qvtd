/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.attributes.ModelAttribution;
import org.eclipse.ocl.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Unit;

public class BaseModelAttribution extends ModelAttribution
{
	public static final BaseModelAttribution INSTANCE = new BaseModelAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		BaseModel targetElement = (BaseModel)target;
		org.eclipse.ocl.pivot.Package unnamedPackage = ClassUtil.getNamedElement(targetElement.getOwnedPackages(), "");
		if (unnamedPackage != null) {
			environmentView.addAllTypes(unnamedPackage);
		}
		for (Unit asUnit : targetElement.getUnit()) {
			environmentView.addElement(asUnit.getName(), asUnit.getUsedPackage());
		}
		return super.computeLookup(target, environmentView, scopeView);
	}
}
