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
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;

public class BottomPatternAttribution extends AbstractAttribution
{
	public static final BottomPatternAttribution INSTANCE = new BottomPatternAttribution();

	@Override
	public ScopeView computeLookup(EObject target, EnvironmentView environmentView, ScopeView scopeView) {
		BottomPattern bottomPattern = (BottomPattern)target;
		environmentView.addNamedElements(bottomPattern.getRealizedVariable());
		environmentView.addNamedElements(bottomPattern.getVariable());
		GuardPattern guardPattern = bottomPattern.getArea().getGuardPattern();
		environmentView.addNamedElements(guardPattern.getVariable());
		return scopeView.getParent();
	}
}
