/*******************************************************************************
 * Copyright (c) 2010, 2014 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

public class DomainAttribution extends AbstractAttribution
{
	public static final DomainAttribution INSTANCE = new DomainAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		Domain domain = (Domain)target;
		TypedModel typedModel = domain.getTypedModel();
		if (typedModel != null) {
			for (org.eclipse.ocl.pivot.Package targetPackage : typedModel.getUsedPackage()) {
				assert targetPackage != null;
				environmentView.addAllPackages(targetPackage);
				environmentView.addAllTypes(targetPackage);
			}
		}
		return scopeView.getParent();
	}
}
