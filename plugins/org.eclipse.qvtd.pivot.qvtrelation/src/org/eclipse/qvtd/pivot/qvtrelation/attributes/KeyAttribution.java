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
package org.eclipse.qvtd.pivot.qvtrelation.attributes;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

public class KeyAttribution extends AbstractAttribution
{
	public static final KeyAttribution INSTANCE = new KeyAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		Key targetElement = (Key)target;
		RelationalTransformation transformation = targetElement.getTransformation();
		if (transformation != null) {
			Set<org.eclipse.ocl.pivot.Package> allPackages = QVTbaseUtil.getAllUsedPackages(transformation);
			for (org.eclipse.ocl.pivot.Package usedPackage : allPackages) {
				environmentView.addNamedElement(usedPackage);
			}
			if (!environmentView.hasFinalResult()) {
				for (org.eclipse.ocl.pivot.Package usedPackage : allPackages) {
					assert usedPackage != null;
					environmentView.addAllTypes(usedPackage);
				}
			}
		}
		org.eclipse.ocl.pivot.Class identifies = targetElement.getIdentifies();
		if (identifies != null) {
			environmentView.addAllProperties(identifies, FeatureFilter.SELECT_NON_STATIC);
		}
		return scopeView.getParent();
	}
}
