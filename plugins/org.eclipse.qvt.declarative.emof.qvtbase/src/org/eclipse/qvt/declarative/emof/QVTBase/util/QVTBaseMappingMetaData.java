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
package org.eclipse.qvt.declarative.emof.QVTBase.util;

import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBaseFactory;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.emof.EMOF.util.AbstractEMOFMappingMetaData;
import org.eclipse.qvt.declarative.emof.EssentialOCL.util.EssentialOCLMappingMetaData;

/**
 * QVTBaseMappingMetaData defines the mapping between an EMOF-based QVT Base
 * adapting model and an Ecore-based QVT Base model.
 * The mapping is established by adapting model elements that adapt their Ecore counterparts.
 * The mapping is established lazily, typically by invoking load or save on an
 * AdaptingXMIResource.
 */
public class QVTBaseMappingMetaData extends AbstractEMOFMappingMetaData
{
	protected static class Factory extends AbstractEMOFMappingMetaData.Factory
	{
		protected Factory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, QVTBaseMappingMetaData mappingMetaData) {
			super(mappingMetaDataRegistry, mappingMetaData);
		}
		
		@Override
		public EObject create(EClass ecoreClass) {
			if (ecoreClass.getEPackage() == org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage.eINSTANCE) {
				switch (ecoreClass.getClassifierID()) {
					case org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage.FUNCTION: return getAdapter(QVTBaseFactory.eINSTANCE.createFunction());
					case org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage.FUNCTION_PARAMETER: return getAdapter(QVTBaseFactory.eINSTANCE.createFunctionParameter());
					case org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage.PATTERN: return getAdapter(QVTBaseFactory.eINSTANCE.createPattern());
					case org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage.PREDICATE: return getAdapter(QVTBaseFactory.eINSTANCE.createPredicate());
					case org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage.TRANSFORMATION: return getAdapter(QVTBaseFactory.eINSTANCE.createTransformation());
					case org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage.TYPED_MODEL: return getAdapter(QVTBaseFactory.eINSTANCE.createTypedModel());
				}
			}
			return super.create(ecoreClass);
		}
	}

	public static final QVTBaseMappingMetaData INSTANCE = new QVTBaseMappingMetaData(
			org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage.eINSTANCE,
			org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.eINSTANCE,
			null);
	
	protected QVTBaseMappingMetaData(EPackage adaptingEPackage, EPackage ecoreEPackage, String[] uriAliases) {
		super(adaptingEPackage, ecoreEPackage, uriAliases);
	}

	@Override
	protected List<IMappingMetaData> computeImports(Stack<IMappingMetaData> forMappingMetaDatas) {
		List<IMappingMetaData> imports = super.computeImports(forMappingMetaDatas);
		return computeImports(forMappingMetaDatas, imports, EssentialOCLMappingMetaData.INSTANCE);
	}

	public Factory createFactory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		return new Factory(mappingMetaDataRegistry, this);
	}
	
	@Override
	public String getAdaptingContentTypeIdentifier() {
		return org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage.eCONTENT_TYPE;
	}
	
	@Override
	public Resource.Factory getAdaptingResourceFactory(IMappingMetaDataRegistry mappingMetaDataRegistry) {
		return new QVTBaseResourceFactoryImpl(mappingMetaDataRegistry);
	}
	
	@Override
	public String getEcoreContentTypeIdentifier() {
		return org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.eCONTENT_TYPE;
	}
	
	public void initialize(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		mappingMetaDataRegistry.installPackagePair(this,
				org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.eINSTANCE,
				org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage.eINSTANCE);
	}
}