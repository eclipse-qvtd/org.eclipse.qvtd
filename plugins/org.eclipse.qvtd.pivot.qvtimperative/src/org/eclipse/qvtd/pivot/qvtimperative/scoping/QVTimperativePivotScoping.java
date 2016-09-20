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
package org.eclipse.qvtd.pivot.qvtimperative.scoping;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.pivot.internal.scoping.Attribution;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.AppendParameterBindingAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.GuardParameterAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.GuardParameterBindingAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.LoopParameterBindingAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.MappingAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.MappingLoopAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.SetStatementAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.SimpleParameterAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.SimpleParameterBindingAttribution;

public class QVTimperativePivotScoping
{
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(QVTimperativePackage.Literals.APPEND_PARAMETER_BINDING, AppendParameterBindingAttribution.INSTANCE);
		registry.put(QVTimperativePackage.Literals.GUARD_PARAMETER, GuardParameterAttribution.INSTANCE);
		registry.put(QVTimperativePackage.Literals.GUARD_PARAMETER_BINDING, GuardParameterBindingAttribution.INSTANCE);
		registry.put(QVTimperativePackage.Literals.LOOP_PARAMETER_BINDING, LoopParameterBindingAttribution.INSTANCE);
		registry.put(QVTimperativePackage.Literals.MAPPING, MappingAttribution.INSTANCE);
		registry.put(QVTimperativePackage.Literals.MAPPING_LOOP, MappingLoopAttribution.INSTANCE);
		registry.put(QVTimperativePackage.Literals.SET_STATEMENT, SetStatementAttribution.INSTANCE);
		registry.put(QVTimperativePackage.Literals.SIMPLE_PARAMETER, SimpleParameterAttribution.INSTANCE);
		registry.put(QVTimperativePackage.Literals.SIMPLE_PARAMETER_BINDING, SimpleParameterBindingAttribution.INSTANCE);
	}
}
