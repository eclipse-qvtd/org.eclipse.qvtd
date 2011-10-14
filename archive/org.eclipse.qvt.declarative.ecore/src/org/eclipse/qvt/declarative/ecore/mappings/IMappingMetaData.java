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
 * $Id: IMappingMetaData.java,v 1.2 2008/08/08 17:00:10 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.mappings;

import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * IMappingMetaData defines the behaviour of a non-Ecore package to an equivalent Ecore-based package.
 *
 * MappingMetaData's are stateless and so IMappingMetaDataRegistry.REGISTRY gradually
 * builds a map of IMappingMetaData for each non-Ecore package. During this registration
 * the stronger IMappingMetaData.Install interface provides additional functionality.
 * 
 * An IMappingMetaDataRegistry defines the mapping behaviour for the set of IMappingMetaDat
 * appropriate for a particular model. A stateful IMappingMetData.Factory instance is
 * maintained by the IMappingMetaDataRegistry to create the non-Ecore adapters for
 * each Ecore model element.
 */
public interface IMappingMetaData
{
	public interface Factory extends EFactory
	{
		public IMappingMetaData getMappingMetaData();
		public IMappingMetaDataRegistry getMappingMetaDataRegistry();
	}
	public interface Install extends IMappingMetaData
	{
		public List<IMappingMetaData> getImports(Stack<IMappingMetaData> forMappingMetaDatas);
	}
	public void configure(ResourceSet resourceSet, IMappingMetaDataRegistry mappingMetaDataRegistry);
	public Factory createFactory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry);
	public String getAdaptingContentTypeIdentifier();
	public EPackage getAdaptingEPackage();
	public Resource.Factory getAdaptingResourceFactory(IMappingMetaDataRegistry mappingMetaDataRegistry);
	public String getEcoreContentTypeIdentifier();
	public EPackage getEcoreEPackage();
	public Resource.Factory getEcoreResourceFactory();
	public Factory getFactory(IMappingMetaDataRegistry mappingMetaDataRegistry);
	public List<IMappingMetaData> getImports();
	public List<IMappingMetaData> getMerges();	
	public EPackage getRootEPackage();
	public void initialize(IMappingMetaDataRegistry.Install mappingMetaDataRegistry);
}
