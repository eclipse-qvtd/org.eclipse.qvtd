/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;

public class CoreDomainAttribution extends AbstractAttribution
{
	public static final CoreDomainAttribution INSTANCE = new CoreDomainAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		CoreDomain targetElement = (CoreDomain)target;
		TypedModel typedModel = targetElement.getTypedModel();
		if (typedModel != null) {
			for (org.eclipse.ocl.pivot.Package pPackage : ClassUtil.nullFree(typedModel.getUsedPackage())) {
				environmentView.addNamedElement(pPackage);
				PivotUtil.addAllClasses(environmentView, pPackage);
			}
		}
		for (ScopeView parentScopeView = scopeView.getParent(); true; parentScopeView  = parentScopeView.getParent()) {
			EObject parentTarget = parentScopeView.getTarget();
			if (parentTarget == null) {
				return null;					// No parent transformation should be impossible - avoid a crash
			}
			if (parentTarget instanceof Transformation) {
				return parentScopeView;			// Continue search in the transformation skipping the mapping
			}
		}
	}
}
