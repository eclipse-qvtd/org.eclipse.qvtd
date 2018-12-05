/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
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
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.Area;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;

public class BottomPatternAttribution extends AbstractAttribution
{
	public static final BottomPatternAttribution INSTANCE = new BottomPatternAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		Area area = ((BottomPattern)target).getArea();
		if (area instanceof Mapping) {
			Mapping mapping = (Mapping)area;;
			Transformation transformation = QVTbaseUtil.getContainingTransformation(mapping);
			for (TypedModel typedModel : transformation.getModelParameter()) {
				for (org.eclipse.ocl.pivot.Package pPackage : typedModel.getUsedPackage()) {
					environmentView.addNamedElement(pPackage);
					environmentView.addNamedElements(pPackage.getOwnedClasses());
				}
			}
			QVTcoreEnvironmentUtil.addMiddleBottomVariables(environmentView, mapping);
		}
		else {
			CoreDomain domain = (CoreDomain)area;
			TypedModel typedModel = domain.getTypedModel();
			Mapping mapping = (Mapping) domain.getRule();
			QVTcoreEnvironmentUtil.addSideBottomVariables(environmentView, mapping, typedModel);
		}
		return scopeView.getParent();
	}
}
