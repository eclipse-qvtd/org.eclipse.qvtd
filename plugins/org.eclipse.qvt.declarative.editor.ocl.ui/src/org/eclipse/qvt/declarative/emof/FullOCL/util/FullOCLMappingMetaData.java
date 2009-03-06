/**
 * <copyright>
 * 
 * Copyright (c) 2007,2009 E.D.Willink and others.
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
 * $Id: FullOCLMappingMetaData.java,v 1.1 2009/03/06 17:35:28 ewillink Exp $
 */
package org.eclipse.qvt.declarative.emof.FullOCL.util;

import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.emof.EssentialOCL.util.EssentialOCLMappingMetaData;
import org.eclipse.qvt.declarative.emof.FullOCL.FullOCLPackage;

/**
 * FullOCLMappingMetaData defines the mapping between an EMOF-based OCL
 * adapting model and an Ecore-based MDT OCL model.
 * The mapping is established by adapting model elements that adapt their Ecore counterparts.
 * The mapping is established lazily, typically by invoking load or save on an
 * AdaptingXMIResource.
 */
public class FullOCLMappingMetaData extends EssentialOCLMappingMetaData
{
	protected static class Factory extends EssentialOCLMappingMetaData.Factory
	{
		protected Factory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, FullOCLMappingMetaData mappingMetaData) {
			super(mappingMetaDataRegistry, mappingMetaData);
		}
		
		@Override
		public EObject create(EClass ecoreClass) {
			final EcoreFactory oclFactoryInstance = org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE;
			if (ecoreClass.getEPackage() == FullOCLPackage.eINSTANCE) {
				switch (ecoreClass.getClassifierID()) {
//					case EssentialoclPackage.AS: return getAdapter(oclFactoryInstance.createAssociationClassCallExp());
//					case EssentialoclPackage.CA: return getAdapter(oclFactoryInstance.createCallOperationAction());
					case FullOCLPackage.CONSTRAINT: return getAdapter(oclFactoryInstance.createConstraint());
//					case EssentialoclPackage.EL: return getAdapter(oclFactoryInstance.createElementType());
//					case EssentialoclPackage.ME: return getAdapter(oclFactoryInstance.createMessageExp());
//					case EssentialoclPackage.ME: return getAdapter(oclFactoryInstance.createMessageType());
//					case EssentialoclPackage.PR: return getAdapter(oclFactoryInstance.createPrimitiveType());
//					case EssentialoclPackage.SE: return getAdapter(oclFactoryInstance.createSendSignalAction());
//					case EssentialoclPackage.ST: return getAdapter(oclFactoryInstance.createStateExp());
//					case EssentialoclPackage.TY: return getAdapter(oclFactoryInstance.createTypeType());
//					case EssentialoclPackage.UN: return getAdapter(oclFactoryInstance.createUnspecifiedValueExp());
				}
			}
			return super.create(ecoreClass);
		}
	}
	
	public static final FullOCLMappingMetaData INSTANCE = new FullOCLMappingMetaData(
			FullOCLPackage.eINSTANCE, org.eclipse.ocl.ecore.EcorePackage.eINSTANCE, null);

	protected FullOCLMappingMetaData(EPackage adaptingEPackage, EPackage ecoreEPackage, String[] uriAliases) {
		super(adaptingEPackage, ecoreEPackage, uriAliases);
	}

	@Override
	protected List<IMappingMetaData> computeImports(Stack<IMappingMetaData> forMappingMetaDatas) {
		List<IMappingMetaData> imports = super.computeImports(forMappingMetaDatas);
		return computeImports(forMappingMetaDatas, imports, EssentialOCLMappingMetaData.INSTANCE);
	}

	@Override
	protected List<IMappingMetaData> computeMerges() {
		List<IMappingMetaData> merges = super.computeMerges();
		merges.add(0, EssentialOCLMappingMetaData.INSTANCE);
		return merges;
	}

	@Override
	public Factory createFactory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		return new Factory(mappingMetaDataRegistry, this);
	}

	@Override
	public void initialize(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		mappingMetaDataRegistry.removeEcoreEClassMap(org.eclipse.ocl.ecore.EcorePackage.Literals.CONSTRAINT);
		mappingMetaDataRegistry.installClassPair(this, org.eclipse.ocl.ecore.EcorePackage.Literals.CONSTRAINT, FullOCLPackage.Literals.CONSTRAINT);
	}
}