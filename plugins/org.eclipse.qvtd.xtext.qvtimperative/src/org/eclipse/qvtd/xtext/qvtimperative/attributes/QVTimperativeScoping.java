/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.attributes;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.pivot.internal.scoping.Attribution;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;

public class QVTimperativeScoping
{
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(EssentialOCLCSPackage.Literals.SHADOW_PART_CS, QVTimperativeShadowPartCSAttribution.INSTANCE);
	}
}
