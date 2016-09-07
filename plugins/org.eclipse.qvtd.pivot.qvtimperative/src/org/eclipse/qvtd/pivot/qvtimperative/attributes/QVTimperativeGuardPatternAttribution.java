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
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.GuardPattern;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;

public class QVTimperativeGuardPatternAttribution extends AbstractAttribution
{
	public static final QVTimperativeGuardPatternAttribution INSTANCE = new QVTimperativeGuardPatternAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		Area area = ((GuardPattern)target).getArea();
		Mapping mapping;
		if (area instanceof Mapping) {
			mapping = (Mapping)area;;
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
		else {
			ImperativeDomain domain = (ImperativeDomain)area;
			mapping = (Mapping) domain.getRule();
		}
		QVTimperativeEnvironmentUtil.addMiddleGuardVariables(environmentView, mapping);
		return scopeView.getParent();
	}
}
