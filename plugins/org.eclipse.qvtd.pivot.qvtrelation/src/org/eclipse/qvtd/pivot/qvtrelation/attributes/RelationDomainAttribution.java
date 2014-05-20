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
 */
package org.eclipse.qvtd.pivot.qvtrelation.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;

public class RelationDomainAttribution extends AbstractAttribution
{
	public static final RelationDomainAttribution INSTANCE = new RelationDomainAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		RelationDomain targetElement = (RelationDomain)target;
		TypedModel typedModel = targetElement.getTypedModel();
		if (typedModel != null) {
			for (org.eclipse.ocl.examples.pivot.Package pPackage : typedModel.getUsedPackage()) {
				environmentView.addNamedElement(pPackage);
				environmentView.addNamedElements(pPackage.getOwnedType());
			}
		}
		return scopeView.getParent();
	}
}
