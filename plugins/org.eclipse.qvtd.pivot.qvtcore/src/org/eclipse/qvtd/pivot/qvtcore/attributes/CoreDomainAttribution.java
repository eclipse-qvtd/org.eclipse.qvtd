/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EnumCSAttribution.java,v 1.3 2011/04/25 09:50:02 ewillink Exp $
 */
package org.eclipse.qvtd.pivot.qvtcore.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
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
			for (org.eclipse.ocl.examples.pivot.Package pPackage : typedModel.getUsedPackage()) {
				environmentView.addNamedElement(pPackage);
				environmentView.addNamedElements(pPackage.getOwnedType());
			}
		}
		for (EObject eContainer = targetElement.eContainer(); eContainer != null; eContainer = eContainer.eContainer()) {
			if (eContainer instanceof Transformation) {
				Transformation transformation = (Transformation) eContainer;
				environmentView.addNamedElements(transformation.getModelParameter());
				environmentView.addNamedElements(transformation.getOwnedOperation());
				break;
			}
		}
		return null;
	}
}
