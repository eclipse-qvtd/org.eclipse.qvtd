/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
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
 * $Id: AdaptingXMIResourceFactory.java,v 1.2 2008/08/08 17:00:10 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.adapters;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.MappingMetaData;

public class AdaptingXMIResourceFactory extends XMIResourceFactoryImpl
{
	/**
	 * AdaptedXMIResourceImpl is created for an adapted content. It redirects
	 * its first load to the adpting resource.
	 */
	protected final class AdaptedXMIResourceImpl extends XMIResourceImpl
	{
		protected AdaptingXMIResource adapter;
		
		private AdaptedXMIResourceImpl(URI uri) {
			super(uri);
			adapter = mappingMetaDataRegistry.getAdapter(this, uri);
		}

		@Override
		public void load(Map<?, ?> options) throws IOException {
			if (adapter != null) {
				adapter.load(options);
				adapter = null;
			}
			else
				super.load(options);
		}
	}

	protected final IMappingMetaDataRegistry mappingMetaDataRegistry;
	
	public AdaptingXMIResourceFactory(IMappingMetaDataRegistry mappingMetaDataRegistry, MappingMetaData... mappingMetaData) {
		this.mappingMetaDataRegistry = mappingMetaDataRegistry;
	}
	
	/**
	 * Create a ResourceFactory for ResourceAdapters based on rootAdaptingEPackage,
	 * which is usually EMOFPackage.eINSTANCE. Additional mappingMetaData arguments
	 * are not used, but should be specified to ensure that MappingMetaData has been
	 * initialised.
	 */
	public AdaptingXMIResourceFactory(EPackage rootAdaptingEPackage, MappingMetaData... mappingMetaData) {
		this.mappingMetaDataRegistry = IMappingMetaDataRegistry.REGISTRY.createMappingMetaDataRegistry(rootAdaptingEPackage, this);
	}
	
	@Override public Resource createResource(URI uri) {
		return new AdaptedXMIResourceImpl(uri);
	}

	public IMappingMetaDataRegistry getMappingMetaDataRegistry() {
		return mappingMetaDataRegistry;
	}
}
