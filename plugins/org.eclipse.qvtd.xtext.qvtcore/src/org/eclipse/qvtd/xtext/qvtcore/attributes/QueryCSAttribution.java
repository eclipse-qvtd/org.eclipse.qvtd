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
package org.eclipse.qvtd.xtext.qvtcore.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.attributes.PivotCSAttribution;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.xtext.qvtcorecst.QueryCS;

public class QueryCSAttribution extends PivotCSAttribution
{
	public static final @NonNull QueryCSAttribution INSTANCE = new QueryCSAttribution();

	@Override
	public ScopeView computeLookup(EObject target, EnvironmentView environmentView, ScopeView scopeView) {
		QueryCS targetElement = (QueryCS)target;
		Function pivot = PivotUtil.getPivot(Function.class, targetElement);
		if (pivot != null) {
			environmentView.addNamedElements(pivot.getOwnedParameter());
			Transformation transformation = (Transformation) pivot.eContainer();
			if (transformation != null) {
				environmentView.addNamedElements(transformation.getOwnedOperation());
				environmentView.addNamedElements(transformation.getOwnedAttribute());
//				environmentView.addAllOperations(transformation, false);
//				environmentView.addAllOperations(transformation, true);
//				environmentView.addAllProperties(transformation, false);
//				environmentView.addAllProperties(transformation, true);
			}
		}
//		EReference targetReference = scopeView.getTargetReference();
//		if (targetReference != QVTcoreCSTPackage.Literals.QUERY_CS__EXPRESSION) {
			return scopeView.getParent();
//		}
//		return super.computeLookup(target, environmentView, scopeView);
	}
}
