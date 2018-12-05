/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.scoping;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.pivot.internal.scoping.Attribution;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.attributes.BaseModelAttribution;
import org.eclipse.qvtd.pivot.qvtbase.attributes.DomainAttribution;
import org.eclipse.qvtd.pivot.qvtbase.attributes.FunctionAttribution;
import org.eclipse.qvtd.pivot.qvtbase.attributes.TransformationAttribution;

public class QVTbasePivotScoping
{
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(QVTbasePackage.Literals.BASE_MODEL, BaseModelAttribution.INSTANCE);
		registry.put(QVTbasePackage.Literals.DOMAIN, DomainAttribution.INSTANCE);
		registry.put(QVTbasePackage.Literals.FUNCTION, FunctionAttribution.INSTANCE);
		registry.put(QVTbasePackage.Literals.TRANSFORMATION, TransformationAttribution.INSTANCE);
	}
}
