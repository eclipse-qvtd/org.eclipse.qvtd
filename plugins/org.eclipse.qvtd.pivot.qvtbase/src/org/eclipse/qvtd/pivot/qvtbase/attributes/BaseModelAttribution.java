/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.internal.attributes.ModelAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;

public class BaseModelAttribution extends ModelAttribution
{
	public static final BaseModelAttribution INSTANCE = new BaseModelAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		BaseModel targetElement = (BaseModel)target;
		org.eclipse.ocl.pivot.Package unnamedPackage = NameUtil.getNameable(targetElement.getOwnedPackages(), "");
		if (unnamedPackage != null) {
			environmentView.addAllTypes(unnamedPackage);
		}
		for (Import asUnit : targetElement.getOwnedImports()) {			
			environmentView.addElement(asUnit.getName(), asUnit.getImportedNamespace());
		}
		return super.computeLookup(target, environmentView, scopeView);
	}
}
