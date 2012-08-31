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
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.Area;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;

public class BottomPatternAttribution extends AbstractAttribution
{
	public static final BottomPatternAttribution INSTANCE = new BottomPatternAttribution();

	@Override
	public ScopeView computeLookup(EObject target, EnvironmentView environmentView, ScopeView scopeView) {
		Area area = ((BottomPattern)target).getArea();
		if (area instanceof Mapping) {
			Mapping mapping = (Mapping)area;;
			Transformation transformation = QVTbaseUtil.getContainingTransformation(mapping);
			TypedModel middleModel = transformation.getModelParameter(null);
			if (middleModel != null) {
				for (org.eclipse.ocl.examples.pivot.Package pPackage : middleModel.getUsedPackage()) {
					environmentView.addNamedElement(pPackage);
					environmentView.addNamedElements(pPackage.getOwnedType());
				}
			}
			for (; mapping != null; mapping = mapping.getContext()) {
				addMiddleBottomVariables(environmentView, mapping);
			}
		}
		else {
			CoreDomain domain = (CoreDomain)area;
			TypedModel typedModel = domain.getTypedModel();
			for (Mapping mapping = (Mapping) domain.getRule(); mapping != null; mapping = mapping.getContext()) {
				addSideBottomVariables(environmentView, mapping, typedModel);
			}
		}
		return scopeView.getParent();
	}

	protected void addMiddleBottomVariables(EnvironmentView environmentView, Mapping mapping) {
		BottomPattern bottomPattern = mapping.getBottomPattern();
		if (bottomPattern != null) {
			environmentView.addNamedElements(bottomPattern.getRealizedVariable());
			environmentView.addNamedElements(bottomPattern.getVariable());
		}
		GuardPattern guardPattern = mapping.getGuardPattern();
		if (guardPattern != null) {
			environmentView.addNamedElements(guardPattern.getVariable());
		}
		for (Domain domain : mapping.getDomain()) {
			if (domain instanceof Area) {
				bottomPattern = ((Area)domain).getBottomPattern();
				if (bottomPattern != null) {
					environmentView.addNamedElements(bottomPattern.getRealizedVariable());
					environmentView.addNamedElements(bottomPattern.getVariable());
				}
				guardPattern = ((Area)domain).getGuardPattern();
				if (guardPattern != null) {
					environmentView.addNamedElements(guardPattern.getVariable());
				}
			}
		}
		for (Mapping refinedMapping : mapping.getRefinement()) {
			addMiddleBottomVariables(environmentView, refinedMapping);
		}
	}

	protected void addSideBottomVariables(EnvironmentView environmentView, Mapping mapping, TypedModel typedModel) {
		for (Domain aDomain : mapping.getDomain()) {
			if (aDomain instanceof CoreDomain) {
				CoreDomain domain = (CoreDomain)aDomain;
				if (domain.getTypedModel() == typedModel) {
					BottomPattern bottomPattern = domain.getBottomPattern();
					if (bottomPattern != null) {
						environmentView.addNamedElements(bottomPattern.getRealizedVariable());
						environmentView.addNamedElements(bottomPattern.getVariable());
					}
					GuardPattern guardPattern = domain.getGuardPattern();
					if (guardPattern != null) {
						environmentView.addNamedElements(guardPattern.getVariable());
					}
					break;
				}
			}
		}
		for (Mapping refinedMapping : mapping.getRefinement()) {
			addSideBottomVariables(environmentView, refinedMapping, typedModel);
		}
	}
}
