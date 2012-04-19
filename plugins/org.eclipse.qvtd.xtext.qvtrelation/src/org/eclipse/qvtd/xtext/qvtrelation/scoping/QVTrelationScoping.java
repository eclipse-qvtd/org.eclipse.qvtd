/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtrelation.scoping;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.examples.pivot.scoping.Attribution;
import org.eclipse.qvtd.xtext.qvtrelation.attributes.PivotCSAttribution;
import org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage;

public class QVTrelationScoping
{	
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(QVTrelationCSTPackage.Literals.KEY_DECL_CS, PivotCSAttribution.INSTANCE);
		registry.put(QVTrelationCSTPackage.Literals.MODEL_DECL_CS, PivotCSAttribution.INSTANCE);
	}
}
