/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.genmodel;

import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenPackageGeneratorAdapter;

//
//	Overridden to fix EMF bugs affecting synthesized models.
//
public class QVTdGenPackageGeneratorAdapter extends GenPackageGeneratorAdapter
{
	private static JETEmitterDescriptor[] JET_EMITTER_DESCRIPTORS = null;

	public QVTdGenPackageGeneratorAdapter(GeneratorAdapterFactory generatorAdapterFactory) {
		super(generatorAdapterFactory);
	}

	@Override
	protected JETEmitterDescriptor[] getJETEmitterDescriptors() {
		if (JET_EMITTER_DESCRIPTORS == null) {
			JETEmitterDescriptor[] superJETEmitterDescriptors = super.getJETEmitterDescriptors();
			JET_EMITTER_DESCRIPTORS = new JETEmitterDescriptor[superJETEmitterDescriptors.length];
			System.arraycopy(superJETEmitterDescriptors, 0, JET_EMITTER_DESCRIPTORS, 0, superJETEmitterDescriptors.length);
			JET_EMITTER_DESCRIPTORS[PACKAGE_CLASS_ID] = new JETEmitterDescriptor("model/PackageClass.javajet", "org.eclipse.qvtd.compiler.internal.templates.model.PackageClass");  // FIXME BUG 485764
			JET_EMITTER_DESCRIPTORS[SWITCH_CLASS_ID] = new JETEmitterDescriptor("model/SwitchClass.javajet", "org.eclipse.qvtd.compiler.internal.templates.model.SwitchClass");  // FIXME BUG 485089
			JET_EMITTER_DESCRIPTORS[ADAPTER_FACTORY_CLASS_ID] = new JETEmitterDescriptor("model/AdapterFactoryClass.javajet", "org.eclipse.qvtd.compiler.internal.templates.model.AdapterFactoryClass");  // FIXME BUG 485089
		}
		return JET_EMITTER_DESCRIPTORS;
	}
}
