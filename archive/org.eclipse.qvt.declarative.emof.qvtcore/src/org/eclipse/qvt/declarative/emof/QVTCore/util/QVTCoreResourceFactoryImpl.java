/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.emof.QVTCore.util;

import org.eclipse.qvt.declarative.ecore.adapters.AdaptingXMIResourceFactory;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;

public class QVTCoreResourceFactoryImpl extends AdaptingXMIResourceFactory
{	
	public QVTCoreResourceFactoryImpl() {
		super(EMOFPackage.eINSTANCE, QVTCoreMappingMetaData.INSTANCE);
	}

	public QVTCoreResourceFactoryImpl(IMappingMetaDataRegistry mappingMetaDataRegistry) {
		super(mappingMetaDataRegistry, QVTCoreMappingMetaData.INSTANCE);
	}
}
