/*******************************************************************************
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.attributes.ModelAttribution;
import org.eclipse.ocl.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvtbase.Unit;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;

public class RelationModelAttribution extends ModelAttribution
{
	public static final RelationModelAttribution INSTANCE = new RelationModelAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		super.computeLookup(target, environmentView, scopeView);
		RelationModel targetElement = (RelationModel)target;
		for (Unit unit : targetElement.getUnit()) {
			environmentView.addElement(unit.getName(), unit.getUsedPackage());
		}
		return scopeView.getParent();
	}
}
