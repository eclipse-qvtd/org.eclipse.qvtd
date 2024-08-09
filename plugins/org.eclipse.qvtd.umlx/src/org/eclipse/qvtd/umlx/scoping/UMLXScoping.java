/*******************************************************************************
 * Copyright (c) 2024 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.umlx.scoping;

import org.eclipse.ocl.pivot.internal.scoping.Attribution;
import org.eclipse.ocl.pivot.internal.scoping.Attribution.AttributionRegistryInstaller;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.qvtd.umlx.attributes.ContextualContextCSAttribution;

public class UMLXScoping
{
	public static void init() {
		AttributionRegistryInstaller registryInstaller = Attribution.REGISTRY.getInstaller(UMLXScoping.class);
		registryInstaller.install(EssentialOCLCSPackage.Literals.CONTEXT_CS, ContextualContextCSAttribution.INSTANCE);
	}
}
