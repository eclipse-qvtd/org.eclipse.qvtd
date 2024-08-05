/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.scoping;

import org.eclipse.ocl.pivot.internal.scoping.Attribution;
import org.eclipse.ocl.pivot.internal.scoping.Attribution.AttributionRegistryInstaller;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.AppendParameterBindingAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.GuardParameterAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.GuardParameterBindingAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.LoopParameterBindingAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.MappingAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.MappingLoopAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.NewStatementAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.SetStatementAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.SimpleParameterAttribution;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.SimpleParameterBindingAttribution;

public class QVTimperativePivotScoping
{
	public static void init() {
		AttributionRegistryInstaller registryInstaller = Attribution.REGISTRY.getInstaller(QVTimperativePivotScoping.class);
		registryInstaller.install(QVTimperativePackage.Literals.APPEND_PARAMETER_BINDING, AppendParameterBindingAttribution.INSTANCE);
		registryInstaller.install(QVTimperativePackage.Literals.GUARD_PARAMETER, GuardParameterAttribution.INSTANCE);
		registryInstaller.install(QVTimperativePackage.Literals.GUARD_PARAMETER_BINDING, GuardParameterBindingAttribution.INSTANCE);
		registryInstaller.install(QVTimperativePackage.Literals.LOOP_PARAMETER_BINDING, LoopParameterBindingAttribution.INSTANCE);
		registryInstaller.install(QVTimperativePackage.Literals.MAPPING, MappingAttribution.INSTANCE);
		registryInstaller.install(QVTimperativePackage.Literals.MAPPING_LOOP, MappingLoopAttribution.INSTANCE);
		registryInstaller.install(QVTimperativePackage.Literals.NEW_STATEMENT, NewStatementAttribution.INSTANCE);
		registryInstaller.install(QVTimperativePackage.Literals.SET_STATEMENT, SetStatementAttribution.INSTANCE);
		registryInstaller.install(QVTimperativePackage.Literals.SIMPLE_PARAMETER, SimpleParameterAttribution.INSTANCE);
		registryInstaller.install(QVTimperativePackage.Literals.SIMPLE_PARAMETER_BINDING, SimpleParameterBindingAttribution.INSTANCE);
	}
}
