/**
 * <copyright>
 * 
 * Copyright (c) 2009 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: FullOCLResourceFactoryImpl.java,v 1.1 2009/03/06 17:35:28 ewillink Exp $
 */
package org.eclipse.qvt.declarative.emof.FullOCL.util;

import org.eclipse.qvt.declarative.ecore.adapters.AdaptingXMIResourceFactory;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;

public class FullOCLResourceFactoryImpl extends AdaptingXMIResourceFactory
{
	public FullOCLResourceFactoryImpl() {
		super(EMOFPackage.eINSTANCE, FullOCLMappingMetaData.INSTANCE);
	}

	public FullOCLResourceFactoryImpl(IMappingMetaDataRegistry mappingMetaDataRegistry) {
		super(mappingMetaDataRegistry, FullOCLMappingMetaData.INSTANCE);
	}
}