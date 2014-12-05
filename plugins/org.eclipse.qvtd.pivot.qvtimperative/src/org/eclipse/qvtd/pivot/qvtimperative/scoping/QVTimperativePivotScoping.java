/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.scoping;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.pivot.scoping.Attribution;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.MappingAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.MappingCallBindingAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.MappingLoopAttribution;

public class QVTimperativePivotScoping
{	
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(QVTimperativePackage.Literals.MAPPING, MappingAttribution.INSTANCE);
		registry.put(QVTimperativePackage.Literals.MAPPING_CALL_BINDING, MappingCallBindingAttribution.INSTANCE);
		registry.put(QVTimperativePackage.Literals.MAPPING_LOOP, MappingLoopAttribution.INSTANCE);
	}
}
