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
package org.eclipse.qvtd.pivot.qvtcore.scoping;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.examples.pivot.scoping.Attribution;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.attributes.BottomPatternAttribution;
import org.eclipse.qvtd.pivot.qvtcore.attributes.CoreDomainAttribution;
import org.eclipse.qvtd.pivot.qvtcore.attributes.CoreModelAttribution;
import org.eclipse.qvtd.pivot.qvtcore.attributes.GuardPatternAttribution;
import org.eclipse.qvtd.pivot.qvtcore.attributes.MappingCallBindingAttribution;

public class QVTcorePivotScoping
{	
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(QVTcorePackage.Literals.BOTTOM_PATTERN, BottomPatternAttribution.INSTANCE);
		registry.put(QVTcorePackage.Literals.CORE_DOMAIN, CoreDomainAttribution.INSTANCE);
		registry.put(QVTcorePackage.Literals.CORE_MODEL, CoreModelAttribution.INSTANCE);
		registry.put(QVTcorePackage.Literals.GUARD_PATTERN, GuardPatternAttribution.INSTANCE);
		registry.put(QVTcorePackage.Literals.MAPPING_CALL_BINDING, MappingCallBindingAttribution.INSTANCE);
	}
}
