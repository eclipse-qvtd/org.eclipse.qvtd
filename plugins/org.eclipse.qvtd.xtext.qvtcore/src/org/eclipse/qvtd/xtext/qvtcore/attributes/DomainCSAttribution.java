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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.Attribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.scoping.BaseScopeView;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.xtext.qvtcorecst.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage;

public class DomainCSAttribution extends AbstractAttribution
{
	public static final DomainCSAttribution INSTANCE = new DomainCSAttribution();

	@Override
	public ScopeView computeLookup(EObject target, EnvironmentView environmentView, ScopeView scopeView) {
		EReference targetReference = scopeView.getTargetReference();
		if (targetReference == QVTcoreCSTPackage.Literals.DOMAIN_CS__DIRECTION) {
			return scopeView.getParent();
		}
		DomainCS targetElement = (DomainCS)target;
		CoreDomain pivot = PivotUtil.getPivot(CoreDomain.class, targetElement);
		if (pivot != null) {
			Attribution attribution = PivotUtil.getAttribution(pivot);
			ScopeView innerScopeView = new BaseScopeView(environmentView.getMetaModelManager(), pivot, attribution, null, null, targetReference);
			environmentView.computeLookups(innerScopeView);
		}
		return null;
	}
}
