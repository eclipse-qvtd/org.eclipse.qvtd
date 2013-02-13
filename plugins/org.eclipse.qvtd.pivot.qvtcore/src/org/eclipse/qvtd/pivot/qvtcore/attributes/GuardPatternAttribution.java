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
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.Area;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;

public class GuardPatternAttribution extends AbstractAttribution
{
	public static final GuardPatternAttribution INSTANCE = new GuardPatternAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		Area area = ((GuardPattern)target).getArea();
		if (area instanceof Mapping) {
			Mapping mapping = (Mapping)area;;
			Transformation transformation = QVTbaseUtil.getContainingTransformation(mapping);
			if (transformation != null) {
				for (TypedModel typedModel : transformation.getModelParameter()) {
					for (org.eclipse.ocl.examples.pivot.Package pPackage : typedModel.getUsedPackage()) {
						environmentView.addNamedElement(pPackage);
						environmentView.addNamedElements(pPackage.getOwnedType());
					}
				}
			}
			QVTcoreEnvironmentUtil.addMiddleGuardVariables(environmentView, mapping);
		}
		else {
			CoreDomain domain = (CoreDomain)area;
			TypedModel typedModel = domain.getTypedModel();
			Mapping mapping = (Mapping) domain.getRule();
			QVTcoreEnvironmentUtil.addSideGuardVariables(environmentView, mapping, typedModel);
		}
		return scopeView.getParent();
	}
}
