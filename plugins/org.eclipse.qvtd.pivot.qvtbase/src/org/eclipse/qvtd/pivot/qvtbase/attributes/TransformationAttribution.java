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
 * $Id: PackageAttribution.java,v 1.4 2011/04/20 19:02:27 ewillink Exp $
 */
package org.eclipse.qvtd.pivot.qvtbase.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.attributes.PackageAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

public class TransformationAttribution extends PackageAttribution
{
	public static final TransformationAttribution INSTANCE = new TransformationAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		Transformation transformation = (Transformation)target;
		environmentView.addNamedElements(transformation.getModelParameter());
		QVTbaseUtil.addAllNamedElements(environmentView, transformation.getOwnedOperation());
		environmentView.addNamedElements(transformation.getRule());
		return super.computeLookup(target, environmentView, scopeView);
	}
}
