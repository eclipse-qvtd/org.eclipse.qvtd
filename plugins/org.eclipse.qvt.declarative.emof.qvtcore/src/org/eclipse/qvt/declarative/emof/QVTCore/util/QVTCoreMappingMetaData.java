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
package org.eclipse.qvt.declarative.emof.QVTCore.util;

import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCoreFactory;
import org.eclipse.qvt.declarative.ecore.mappings.EcoreFeatureElement;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.emof.EMOF.util.AbstractEMOFMappingMetaData;
import org.eclipse.qvt.declarative.emof.EMOF.util.EReferenceToPropertyMap;
import org.eclipse.qvt.declarative.emof.QVTBase.util.QVTBaseMappingMetaData;

/**
 * QVTCoreMappingMetaData defines the mapping between an EMOF-based QVT Core
 * adapting model and an Ecore-based QVT Core model.
 * The mapping is established by adapting model elements that adapt their Ecore counterparts.
 * The mapping is established lazily, typically by invoking load or save on an
 * AdaptingXMIResource.
 */
public class QVTCoreMappingMetaData extends AbstractEMOFMappingMetaData
{
	protected static class Factory extends AbstractEMOFMappingMetaData.Factory
	{	
		protected Factory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, QVTCoreMappingMetaData mappingMetaData) {
			super(mappingMetaDataRegistry, mappingMetaData);
		}
		
		@Override
		public EObject create(EClass ecoreClass) {
			if (ecoreClass.getEPackage() == org.eclipse.qvt.declarative.emof.QVTCore.QVTCorePackage.eINSTANCE) {
				switch (ecoreClass.getClassifierID()) {
					case org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.BOTTOM_PATTERN: return getAdapter(QVTCoreFactory.eINSTANCE.createBottomPattern());
					case org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.CORE_DOMAIN: return getAdapter(QVTCoreFactory.eINSTANCE.createCoreDomain());
					case org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.CORE_PATTERN: return getAdapter(QVTCoreFactory.eINSTANCE.createCorePattern());
					case org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.ENFORCEMENT_OPERATION: return getAdapter(QVTCoreFactory.eINSTANCE.createEnforcementOperation());
					case org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.GUARD_PATTERN: return getAdapter(QVTCoreFactory.eINSTANCE.createGuardPattern());
					case org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.MAPPING: return getAdapter(QVTCoreFactory.eINSTANCE.createMapping());
					case org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.PROPERTY_ASSIGNMENT: return getAdapter(QVTCoreFactory.eINSTANCE.createPropertyAssignment());
					case org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.REALIZED_VARIABLE: return getAdapter(QVTCoreFactory.eINSTANCE.createRealizedVariable());
					case org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.VARIABLE_ASSIGNMENT: return getAdapter(QVTCoreFactory.eINSTANCE.createVariableAssignment());
				}
			}
			return super.create(ecoreClass);
		}
	}
	
	public static final QVTCoreMappingMetaData INSTANCE = new QVTCoreMappingMetaData(
			org.eclipse.qvt.declarative.emof.QVTCore.QVTCorePackage.eINSTANCE,
			org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.eINSTANCE, null);
	
	protected QVTCoreMappingMetaData(EPackage adaptingEPackage, EPackage ecoreEPackage, String[] uriAliases) {
		super(adaptingEPackage,  ecoreEPackage, uriAliases);
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
		return org.eclipse.qvt.declarative.emof.QVTCore.QVTCorePackage.eCONTENT_TYPE;
	}
	
	@Override
	public Resource.Factory getAdaptingResourceFactory(IMappingMetaDataRegistry mappingMetaDataRegistry) {
		return new QVTCoreResourceFactoryImpl(mappingMetaDataRegistry);
	}
	
	@Override
	public String getEcoreContentTypeIdentifier() {
		return org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.eCONTENT_TYPE;
	}
	
	public void initialize(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
	    //
	    // Must resolve imported properties to determine EAttribute or EReference
	    //
		mappingMetaDataRegistry.install(new EReferenceToPropertyMap(mappingMetaDataRegistry,
	    	EcoreFeatureElement.create(org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.Literals.PROPERTY_ASSIGNMENT__TARGET_PROPERTY),
	    	EcoreFeatureElement.create(org.eclipse.qvt.declarative.emof.QVTCore.QVTCorePackage.Literals.PROPERTY_ASSIGNMENT__TARGET_PROPERTY))
	    );    
	    //
	    // Move slotExpression to logical class
	    //
//		mappingMetaDataRegistry.installFeatureToFeatureMap(org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.Literals.PROPERTY_ASSIGNMENT__SLOT_EXPRESSION,
//				org.eclipse.qvt.declarative.emof.QVTCore.QVTCorePackage.Literals.ASSIGNMENT__SLOT_EXPRESSION);

	    mappingMetaDataRegistry.installPackagePair(this,
	    		org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.eINSTANCE,
	    		org.eclipse.qvt.declarative.emof.QVTCore.QVTCorePackage.eINSTANCE);
	}
}