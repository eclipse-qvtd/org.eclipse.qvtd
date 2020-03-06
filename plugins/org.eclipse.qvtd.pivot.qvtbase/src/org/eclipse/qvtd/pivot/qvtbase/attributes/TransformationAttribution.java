/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.attributes.ClassAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

public class TransformationAttribution extends ClassAttribution
{
	public static final TransformationAttribution INSTANCE = new TransformationAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		Transformation transformation = (Transformation)target;
		environmentView.addNamedElement(QVTbaseUtil.getContextVariable(environmentView.getStandardLibrary(), transformation));
		environmentView.addNamedElements(transformation.getModelParameter());
		PivotUtil.addAllNamedElements(environmentView, transformation.getOwnedOperations());
		PivotUtil.addAllNamedElements(environmentView, transformation.getOwnedProperties());
		environmentView.addNamedElements(transformation.getRule());
		return super.computeLookup(target, environmentView, scopeView);
	}
}
