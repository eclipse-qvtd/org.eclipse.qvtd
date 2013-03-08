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
package org.eclipse.qvtd.pivot.qvtcorebase.scoping;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.examples.pivot.scoping.Attribution;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.attributes.BottomPatternAttribution;
import org.eclipse.qvtd.pivot.qvtcorebase.attributes.CoreDomainAttribution;
import org.eclipse.qvtd.pivot.qvtcorebase.attributes.GuardPatternAttribution;

public class QVTcoreBasePivotScoping
{	
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(QVTcoreBasePackage.Literals.BOTTOM_PATTERN, BottomPatternAttribution.INSTANCE);
		registry.put(QVTcoreBasePackage.Literals.CORE_DOMAIN, CoreDomainAttribution.INSTANCE);
		registry.put(QVTcoreBasePackage.Literals.GUARD_PATTERN, GuardPatternAttribution.INSTANCE);
	}
}
