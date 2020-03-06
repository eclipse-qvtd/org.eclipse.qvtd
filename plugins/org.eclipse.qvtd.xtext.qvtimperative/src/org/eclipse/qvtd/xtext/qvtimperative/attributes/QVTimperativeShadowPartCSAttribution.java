/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.Pivotable;
import org.eclipse.ocl.xtext.essentialocl.attributes.ShadowPartCSAttribution;
import org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.xtext.qvtimperative.cs2as.QVTimperativeCS2AS;

public class QVTimperativeShadowPartCSAttribution extends ShadowPartCSAttribution
{
	public static final @NonNull QVTimperativeShadowPartCSAttribution INSTANCE = new QVTimperativeShadowPartCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY) {
			ShadowPartCS targetElement = (ShadowPartCS)target;
			if (QVTimperativeCS2AS.isNewStatementPartCS(targetElement)) {
				CurlyBracketedClauseCS csCurlyBracketClause = targetElement.getOwningCurlyBracketClause();
				Pivotable eContainer = (Pivotable) csCurlyBracketClause.eContainer().eContainer();
				NewStatement pivot = PivotUtil.getPivot(NewStatement.class, eContainer);
				if (pivot != null) {
					Type type = pivot.getType();
					if (type instanceof org.eclipse.ocl.pivot.Class) {
						environmentView.addAllProperties((org.eclipse.ocl.pivot.Class)type, FeatureFilter.SELECT_NON_STATIC);
					}
				}
				return null;
			}
		}
		return super.computeLookup(target, environmentView, scopeView);
	}
}
