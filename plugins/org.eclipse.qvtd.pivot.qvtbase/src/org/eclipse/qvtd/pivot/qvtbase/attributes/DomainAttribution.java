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
 * $Id: PackageAttribution.java,v 1.4 2011/04/20 19:02:27 ewillink Exp $
 */
package org.eclipse.qvtd.pivot.qvtbase.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
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
			for (org.eclipse.ocl.examples.pivot.Package targetPackage : typedModel.getUsedPackage()) {
				assert targetPackage != null;
				environmentView.addAllPackages(targetPackage);
				environmentView.addAllTypes(targetPackage);
			}
		}
		return scopeView.getParent();
	}
}
