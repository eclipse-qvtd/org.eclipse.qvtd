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
import org.eclipse.ocl.examples.xtext.base.attributes.RootPackageCSAttribution;

public class TopLevelCSAttribution extends RootPackageCSAttribution
{
	public static final @NonNull TopLevelCSAttribution INSTANCE = new TopLevelCSAttribution();

	@Override
	public ScopeView computeLookup(EObject target, EnvironmentView environmentView, ScopeView scopeView) {
//		MappingCS targetElement = (MappingCS)target;
//		EReference targetReference = scopeView.getTargetReference();
//		if (targetReference == QVTcoreCSTPackage.Literals.DOMAIN_CS__DIRECTION) {
//			environmentView.computeLookups(targetElement.getIn(), null, null, targetReference);
//			return null;
//		}
//		return scopeView.getParent();
		return super.computeLookup(target, environmentView, scopeView);
	}
}
