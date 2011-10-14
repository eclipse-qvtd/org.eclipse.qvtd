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
package org.eclipse.qvt.declarative.emof.QVTRelation.util;

import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationFactory;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.emof.EMOF.util.AbstractEMOFMappingMetaData;
import org.eclipse.qvt.declarative.emof.QVTTemplate.util.QVTTemplateMappingMetaData;

/**
 * QVTRelationMappingMetaData defines the mapping between an EMOF-based QVT Relation
 * adapting model and an Ecore-based QVT Relation model.
 * The mapping is established by adapting model elements that adapt their Ecore counterparts.
 * The mapping is established lazily, typically by invoking load or save on an
 * AdaptingXMIResource.
 */
public class QVTRelationMappingMetaData extends AbstractEMOFMappingMetaData
{
	protected static class Factory extends AbstractEMOFMappingMetaData.Factory
	{
		protected Factory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, QVTRelationMappingMetaData mappingMetaData) {
			super(mappingMetaDataRegistry, mappingMetaData);
		}
		
		@Override
		public EObject create(EClass ecoreClass) {
			if (ecoreClass.getEPackage() == org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage.eINSTANCE) {
				switch (ecoreClass.getClassifierID()) {
					case org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage.DOMAIN_PATTERN: return getAdapter(QVTRelationFactory.eINSTANCE.createDomainPattern());
					case org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage.KEY: return getAdapter(QVTRelationFactory.eINSTANCE.createKey());
					case org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage.RELATION: return getAdapter(QVTRelationFactory.eINSTANCE.createRelation());
					case org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage.RELATIONAL_TRANSFORMATION: return getAdapter(QVTRelationFactory.eINSTANCE.createRelationalTransformation());
					case org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage.RELATION_CALL_EXP: return getAdapter(QVTRelationFactory.eINSTANCE.createRelationCallExp());
					case org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage.RELATION_DOMAIN: return getAdapter(QVTRelationFactory.eINSTANCE.createRelationDomain());
					case org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage.RELATION_DOMAIN_ASSIGNMENT: return getAdapter(QVTRelationFactory.eINSTANCE.createRelationDomainAssignment());
					case org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage.RELATION_IMPLEMENTATION: return getAdapter(QVTRelationFactory.eINSTANCE.createRelationImplementation());
				}
			}
			return super.create(ecoreClass);
		}
	}
	
	public static final QVTRelationMappingMetaData INSTANCE = new QVTRelationMappingMetaData(
			org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage.eINSTANCE,
			org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.eINSTANCE,
			null);
	
	protected QVTRelationMappingMetaData(EPackage adaptingEPackage, EPackage ecoreEPackage, String[] uriAliases) {
		super(adaptingEPackage, ecoreEPackage, uriAliases);
	}

	@Override
	protected List<IMappingMetaData> computeImports(Stack<IMappingMetaData> forMappingMetaDatas) {
		List<IMappingMetaData> imports = super.computeImports(forMappingMetaDatas);
		return computeImports(forMappingMetaDatas, imports, QVTTemplateMappingMetaData.INSTANCE);
	}

	public Factory createFactory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		return new Factory(mappingMetaDataRegistry, this);
	}
	
	@Override
	public String getAdaptingContentTypeIdentifier() {
		return org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage.eCONTENT_TYPE;
	}
	
	@Override
	public Resource.Factory getAdaptingResourceFactory(IMappingMetaDataRegistry mappingMetaDataRegistry) {
		return new QVTRelationResourceFactoryImpl(mappingMetaDataRegistry);
	}
	
	@Override
	public String getEcoreContentTypeIdentifier() {
		return org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.eCONTENT_TYPE;
	}
	
	public void initialize(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		mappingMetaDataRegistry.installPackagePair(this,
				org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.eINSTANCE,
				org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage.eINSTANCE);
	}
}