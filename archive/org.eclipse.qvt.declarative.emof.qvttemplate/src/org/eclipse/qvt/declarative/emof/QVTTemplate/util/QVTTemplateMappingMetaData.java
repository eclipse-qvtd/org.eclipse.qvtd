/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.emof.QVTTemplate.util;

import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplateFactory;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.emof.EMOF.util.AbstractEMOFMappingMetaData;
import org.eclipse.qvt.declarative.emof.QVTBase.util.QVTBaseMappingMetaData;

/**
 * QVTTemplateMappingMetaData defines the mapping between an EMOF-based QVT Template
 * adapting model and an Ecore-based QVT Template model.
 * The mapping is established by adapting model elements that adapt their Ecore counterparts.
 * The mapping is established lazily, typically by invoking load or save on an
 * AdaptingXMIResource.
 */
public class QVTTemplateMappingMetaData extends AbstractEMOFMappingMetaData
{
	protected static class Factory extends AbstractEMOFMappingMetaData.Factory
	{
		protected Factory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, QVTTemplateMappingMetaData mappingMetaData) {
			super(mappingMetaDataRegistry, mappingMetaData);
		}
		
		@Override
		public EObject create(EClass ecoreClass) {
			if (ecoreClass.getEPackage() == org.eclipse.qvt.declarative.emof.QVTTemplate.QVTTemplatePackage.eINSTANCE) {
				switch (ecoreClass.getClassifierID()) {
					case org.eclipse.qvt.declarative.emof.QVTTemplate.QVTTemplatePackage.COLLECTION_TEMPLATE_EXP: return getAdapter(QVTTemplateFactory.eINSTANCE.createCollectionTemplateExp());
					case org.eclipse.qvt.declarative.emof.QVTTemplate.QVTTemplatePackage.OBJECT_TEMPLATE_EXP: return getAdapter(QVTTemplateFactory.eINSTANCE.createObjectTemplateExp());
					case org.eclipse.qvt.declarative.emof.QVTTemplate.QVTTemplatePackage.PROPERTY_TEMPLATE_ITEM: return getAdapter(QVTTemplateFactory.eINSTANCE.createPropertyTemplateItem());
				}
			}
			return super.create(ecoreClass);
		}
	}
	
	public static final QVTTemplateMappingMetaData INSTANCE = new QVTTemplateMappingMetaData(
			org.eclipse.qvt.declarative.emof.QVTTemplate.QVTTemplatePackage.eINSTANCE,
			org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage.eINSTANCE,
			null);
	
	protected QVTTemplateMappingMetaData(EPackage adaptingEPackage, EPackage ecoreEPackage, String[] uriAliases) {
		super(adaptingEPackage, ecoreEPackage, uriAliases);
	}

	@Override
	protected List<IMappingMetaData> computeImports(Stack<IMappingMetaData> forMappingMetaDatas) {
		List<IMappingMetaData> imports = super.computeImports(forMappingMetaDatas);
		return computeImports(forMappingMetaDatas, imports, QVTBaseMappingMetaData.INSTANCE);
	}

	public Factory createFactory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		return new Factory(mappingMetaDataRegistry, this);
	}
	
	@Override
	public String getAdaptingContentTypeIdentifier() {
		return org.eclipse.qvt.declarative.emof.QVTTemplate.QVTTemplatePackage.eCONTENT_TYPE;
	}
	
	@Override
	public Resource.Factory getAdaptingResourceFactory(IMappingMetaDataRegistry mappingMetaDataRegistry) {
		return new QVTTemplateResourceFactoryImpl(mappingMetaDataRegistry);
	}
	
	@Override
	public String getEcoreContentTypeIdentifier() {
		return org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage.eCONTENT_TYPE;
	}
	
	public void initialize(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		mappingMetaDataRegistry.installPackagePair(this,
				org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage.eINSTANCE,
				org.eclipse.qvt.declarative.emof.QVTTemplate.QVTTemplatePackage.eINSTANCE);
	}
}