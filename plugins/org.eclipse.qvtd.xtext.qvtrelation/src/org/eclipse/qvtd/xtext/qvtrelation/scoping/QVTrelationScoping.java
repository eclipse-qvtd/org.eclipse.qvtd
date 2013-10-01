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
import org.eclipse.ocl.examples.xtext.base.attributes.PivotCSAttribution;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.qvtd.xtext.qvtrelation.attributes.RelationCallExpCSAttribution;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.QVTrelationCSPackage;

public class QVTrelationScoping
{	
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(EssentialOCLCSPackage.Literals.INVOCATION_EXP_CS, RelationCallExpCSAttribution.INSTANCE);
		registry.put(QVTrelationCSPackage.Literals.COLLECTION_TEMPLATE_CS, PivotCSAttribution.INSTANCE);
		registry.put(QVTrelationCSPackage.Literals.DOMAIN_CS, PivotCSAttribution.INSTANCE);
		registry.put(QVTrelationCSPackage.Literals.KEY_DECL_CS, PivotCSAttribution.INSTANCE);
		registry.put(QVTrelationCSPackage.Literals.MODEL_DECL_CS, PivotCSAttribution.INSTANCE);
		registry.put(QVTrelationCSPackage.Literals.OBJECT_TEMPLATE_CS, PivotCSAttribution.INSTANCE);
		registry.put(QVTrelationCSPackage.Literals.PARAM_DECLARATION_CS, PivotCSAttribution.INSTANCE);
		registry.put(QVTrelationCSPackage.Literals.PATTERN_CS, PivotCSAttribution.INSTANCE);
		registry.put(QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS, PivotCSAttribution.INSTANCE);
		registry.put(QVTrelationCSPackage.Literals.QUERY_CS, PivotCSAttribution.INSTANCE);
		registry.put(QVTrelationCSPackage.Literals.RELATION_CS, PivotCSAttribution.INSTANCE);
		registry.put(QVTrelationCSPackage.Literals.TOP_LEVEL_CS, PivotCSAttribution.INSTANCE);
		registry.put(QVTrelationCSPackage.Literals.TRANSFORMATION_CS, PivotCSAttribution.INSTANCE);
	}
}
