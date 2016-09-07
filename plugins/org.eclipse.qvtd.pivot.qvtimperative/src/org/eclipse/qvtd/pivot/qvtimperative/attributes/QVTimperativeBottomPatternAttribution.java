/*******************************************************************************
 * Copyright (c) 2010, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.Area;
import org.eclipse.qvtd.pivot.qvtimperative.BottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.CoreDomain;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;

public class QVTimperativeBottomPatternAttribution extends AbstractAttribution
{
	public static final QVTimperativeBottomPatternAttribution INSTANCE = new QVTimperativeBottomPatternAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		Area area = ((BottomPattern)target).getArea();
		Mapping mapping;
		if (area instanceof Mapping) {
			mapping = (Mapping)area;;
		}
		else {
			CoreDomain domain = (CoreDomain)area;
			mapping = (Mapping) domain.getRule();
		}
		QVTimperativeEnvironmentUtil.addMiddleBottomVariables(environmentView, mapping);
		if (!environmentView.hasFinalResult() && (area instanceof Mapping)) {
			Transformation transformation = QVTbaseUtil.getContainingTransformation(mapping);
			if (transformation != null) {
				for (TypedModel typedModel : transformation.getModelParameter()) {
					for (org.eclipse.ocl.pivot.Package pPackage : typedModel.getUsedPackage()) {
						environmentView.addNamedElement(pPackage);
						environmentView.addNamedElements(pPackage.getOwnedClasses());
					}
				}
			}
		}
		return scopeView.getParent();
	}
}
