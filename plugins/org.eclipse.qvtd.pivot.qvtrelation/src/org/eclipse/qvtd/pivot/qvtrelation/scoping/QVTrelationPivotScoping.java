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
package org.eclipse.qvtd.pivot.qvtrelation.scoping;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.examples.pivot.scoping.Attribution;
import org.eclipse.ocl.examples.pivot.scoping.EmptyAttribution;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.attributes.KeyAttribution;

public class QVTrelationPivotScoping
{	
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(QVTrelationPackage.Literals.KEY, KeyAttribution.INSTANCE);
//		registry.put(QVTrelationPackage.Literals.CORE_DOMAIN, CoreDomainAttribution.INSTANCE);
//		registry.put(QVTrelationPackage.Literals.CORE_MODEL, CoreModelAttribution.INSTANCE);
//		registry.put(QVTrelationPackage.Literals.GUARD_PATTERN, GuardPatternAttribution.INSTANCE);
	}
}
