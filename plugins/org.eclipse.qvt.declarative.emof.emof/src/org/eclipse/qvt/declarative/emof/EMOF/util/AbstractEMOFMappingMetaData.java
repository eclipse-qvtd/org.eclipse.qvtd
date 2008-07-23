/*******************************************************************************
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.emof.EMOF.util;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.MappingMetaData;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;

/**
 * EMOFMappingMetaData defines the mapping between an EMOF adapting model and an Ecore model.
 * The mapping is established by adapting model elements that adapt their Ecore counterparts.
 * The mapping is established lazily, typically by invoking load or save on an
 * AdaptingXMIResource.
 */
public abstract class AbstractEMOFMappingMetaData extends MappingMetaData
{
	protected abstract static class Factory extends MappingMetaData.Factory
	{
		public Factory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, AbstractEMOFMappingMetaData mappingMetaData) {
			super(mappingMetaDataRegistry, mappingMetaData);
		}
	}
	
	protected AbstractEMOFMappingMetaData(EPackage adaptingEPackage, EPackage ecoreEPackage, String[] uriAliases) {
		super(adaptingEPackage, ecoreEPackage, uriAliases);
	}

	public EPackage getRootEPackage() {
		return EMOFPackage.eINSTANCE;
	}
}
