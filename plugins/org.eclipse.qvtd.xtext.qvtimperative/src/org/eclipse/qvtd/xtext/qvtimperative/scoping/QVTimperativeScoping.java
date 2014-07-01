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
package org.eclipse.qvtd.xtext.qvtimperative.scoping;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.examples.pivot.scoping.Attribution;
import org.eclipse.ocl.examples.xtext.base.attributes.PivotCSAttribution;
import org.eclipse.qvtd.xtext.qvtimperative.attributes.MappingCallBindingCSAttribution;
import org.eclipse.qvtd.xtext.qvtimperative.attributes.MappingLoopCSAttribution;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.QVTimperativeCSPackage;

public class QVTimperativeScoping
{	
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(QVTimperativeCSPackage.Literals.MAPPING_CALL_BINDING_CS, MappingCallBindingCSAttribution.INSTANCE);
		registry.put(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS, PivotCSAttribution.INSTANCE);
		registry.put(QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS, MappingLoopCSAttribution.INSTANCE);
	}
}
