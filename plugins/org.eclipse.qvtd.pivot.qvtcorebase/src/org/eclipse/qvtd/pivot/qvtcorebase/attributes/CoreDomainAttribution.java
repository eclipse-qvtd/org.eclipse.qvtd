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
package org.eclipse.qvtd.pivot.qvtcorebase.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;

public class CoreDomainAttribution extends AbstractAttribution
{
	public static final CoreDomainAttribution INSTANCE = new CoreDomainAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		CoreDomain targetElement = (CoreDomain)target;
		TypedModel typedModel = targetElement.getTypedModel();
		if (typedModel != null) {
			for (org.eclipse.ocl.pivot.Package pPackage : typedModel.getUsedPackage()) {
				environmentView.addNamedElement(pPackage);
				environmentView.addNamedElements(pPackage.getOwnedClasses());
			}
		}
		for (EObject eContainer = targetElement.eContainer(); eContainer != null; eContainer = eContainer.eContainer()) {
			if (eContainer instanceof Transformation) {
				Transformation transformation = (Transformation) eContainer;
				environmentView.addNamedElements(transformation.getModelParameter());
				QVTbaseUtil.addAllNamedElements(environmentView, transformation.getOwnedOperations());
				break;
			}
		}
		return null;
	}
}
