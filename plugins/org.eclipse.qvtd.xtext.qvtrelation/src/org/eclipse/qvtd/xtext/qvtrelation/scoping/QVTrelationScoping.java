/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.scoping;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.pivot.internal.scoping.Attribution;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;

public class QVTrelationScoping
{	
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(QVTrelationCSPackage.Literals.ELEMENT_TEMPLATE_CS, ElementTemplateCSAttribution.INSTANCE);
		registry.put(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS, QVTrelationNavigatingArgCSAttribution.INSTANCE);
		registry.put(BaseCSPackage.Literals.PATH_ELEMENT_CS, QVTrelationPathElementCSAttribution.INSTANCE);
	}
}
