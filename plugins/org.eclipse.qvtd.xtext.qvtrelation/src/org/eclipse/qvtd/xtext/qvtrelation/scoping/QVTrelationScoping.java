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
package org.eclipse.qvtd.xtext.qvtrelation.scoping;

import org.eclipse.ocl.pivot.internal.scoping.Attribution;
import org.eclipse.ocl.pivot.internal.scoping.Attribution.AttributionRegistryInstaller;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;

public class QVTrelationScoping
{
	public static void init() {
		AttributionRegistryInstaller registryInstaller = Attribution.REGISTRY.getInstaller(QVTrelationScoping.class);
		registryInstaller.install(QVTrelationCSPackage.Literals.ELEMENT_TEMPLATE_CS, ElementTemplateCSAttribution.INSTANCE);
		registryInstaller.install(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS, QVTrelationNavigatingArgCSAttribution.INSTANCE);
		registryInstaller.install(BaseCSPackage.Literals.PATH_ELEMENT_CS, QVTrelationPathElementCSAttribution.INSTANCE);
	}
}
