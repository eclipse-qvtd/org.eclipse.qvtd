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

import org.eclipse.ocl.pivot.internal.scoping.Attribution;
import org.eclipse.ocl.pivot.internal.scoping.Attribution.AttributionRegistryInstaller;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.attributes.BaseModelAttribution;
import org.eclipse.qvtd.pivot.qvtbase.attributes.DomainAttribution;
import org.eclipse.qvtd.pivot.qvtbase.attributes.FunctionAttribution;
import org.eclipse.qvtd.pivot.qvtbase.attributes.TransformationAttribution;

public class QVTbasePivotScoping
{
	public static void init() {
		AttributionRegistryInstaller registryInstaller = Attribution.REGISTRY.getInstaller(QVTbasePivotScoping.class);
		registryInstaller.install(QVTbasePackage.Literals.BASE_MODEL, BaseModelAttribution.INSTANCE);
		registryInstaller.install(QVTbasePackage.Literals.DOMAIN, DomainAttribution.INSTANCE);
		registryInstaller.install(QVTbasePackage.Literals.FUNCTION, FunctionAttribution.INSTANCE);
		registryInstaller.install(QVTbasePackage.Literals.TRANSFORMATION, TransformationAttribution.INSTANCE);
	}
}
