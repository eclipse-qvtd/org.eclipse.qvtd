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
package org.eclipse.qvtd.xtext.qvtcorebase.scoping;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.examples.pivot.scoping.Attribution;
import org.eclipse.ocl.examples.xtext.base.attributes.PivotCSAttribution;
import org.eclipse.qvtd.xtext.qvtcorebase.attributes.DirectionCSAttribution;
import org.eclipse.qvtd.xtext.qvtcorebase.attributes.QueryCSAttribution;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QVTcoreBaseCSPackage;

public class QVTcoreBaseScoping
{	
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(QVTcoreBaseCSPackage.Literals.DIRECTION_CS, DirectionCSAttribution.INSTANCE);
		registry.put(QVTcoreBaseCSPackage.Literals.DOMAIN_CS, PivotCSAttribution.INSTANCE);
		registry.put(QVTcoreBaseCSPackage.Literals.PATTERN_CS, PivotCSAttribution.INSTANCE);
		registry.put(QVTcoreBaseCSPackage.Literals.QUERY_CS, QueryCSAttribution.INSTANCE);
		registry.put(QVTcoreBaseCSPackage.Literals.TRANSFORMATION_CS, PivotCSAttribution.INSTANCE);
	}
}
