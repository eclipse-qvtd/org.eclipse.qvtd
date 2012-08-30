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
package org.eclipse.qvtd.pivot.qvtrelation.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.attributes.RootAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvtbase.Unit;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;

public class RelationModelAttribution extends RootAttribution
{
	public static final RelationModelAttribution INSTANCE = new RelationModelAttribution();

	@Override
	public ScopeView computeLookup(EObject target, EnvironmentView environmentView, ScopeView scopeView) {
		super.computeLookup(target, environmentView, scopeView);
		RelationModel targetElement = (RelationModel)target;
		for (Unit unit : targetElement.getUnit()) {
			environmentView.addElement(unit.getName(), unit.getUsedPackage());
		}
		return scopeView.getParent();
	}
}
