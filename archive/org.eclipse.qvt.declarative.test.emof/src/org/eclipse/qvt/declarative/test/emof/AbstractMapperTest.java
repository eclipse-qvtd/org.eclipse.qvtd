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
package org.eclipse.qvt.declarative.test.emof;

import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EMOFResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingEObject;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingXMIResource;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.ecore.utils.XMIUtils;
import org.eclipse.qvt.declarative.ecore.utils.XMIUtils.ExcludedEClassIdFilter;
import org.eclipse.qvt.declarative.ecore.utils.XMIUtils.ShortPrefixedIdCreator;
import org.eclipse.qvt.declarative.emof.EMOF.util.HierachicalNamedElementIdCreator;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceMap;

public abstract class AbstractMapperTest extends AbstractTestCase
{
	protected boolean doReloadedEcoreSave = true;
	protected boolean doReloadAndCompare = true;
	
	/**
	 * Load reference EMOF by adaption
	 * Debug save adapted EMOF as Ecore
	 * Load reference Ecore directly
	 * Compare adapted EMOF with reference Ecore
	 * @param mapper
	 * @param prefixName
	 * @param dotEcore
	 * @param dotEmof
	 * @throws IOException
	 * @throws MappingConfigurationException 
	 */
	public void adaptedEMOFLoad(String prefixName, String dotEcore, String dotEmof) throws IOException, MappingConfigurationException {
		String ecoreContentTypeIdentifier = getEcoreContentTypeIdentifier();
		IMappingMetaDataRegistry mappingMetaDataRegistry = getMappingMetaDataRegistry();
		URI ecoreRefURI = getProjectFileURI(prefixName + dotEcore);
		URI emofLoadURI = getProjectFileURI(prefixName + dotEmof);		
		URI ecoreLoadSaveURI = getProjectFileURI(prefixName + dotEmof + dotEcore);
		//
		//	Load the EMOF resource
		//
		Resource ecoreLoadResource = resourceSet.createResource(ecoreLoadSaveURI, ecoreContentTypeIdentifier);
		Resource emofLoadResource = mappingMetaDataRegistry.getAdapter(ecoreLoadResource, emofLoadURI);
		emofLoadResource.load(null);
		if (doReloadAndCompare) {
			//
			//	Save the loaded Ecore resource for debugging
			//
			XMIUtils.assignIds(ecoreLoadResource, new ShortPrefixedIdCreator("ec"), getIdFilter());
			if (doReloadedEcoreSave)
				ecoreLoadResource.save(null);		
			//
			//	Load the reference Ecore resource
			//
			Resource ecoreRefResource = resourceSet.getResource(ecoreRefURI, true);
			//
			//	Compare the reference Ecore with the loaded EMOF as Ecore 
			//
			EquivalenceMap ecoreComparator = new EquivalenceMap(ecoreRefResource, ecoreLoadResource);
			assertNoDifferences(ecoreComparator, ecoreRefURI, ecoreLoadSaveURI);
		}
		else
			fail("doReloadAndCompare set false");
	}

	/**
	 * Load reference EMOF directly
	 * Load reference Ecore directly
	 * Compare loaded EMOF with reference Ecore
	 * @param mapper
	 * @param prefixName
	 * @param dotEcore
	 * @param dotEmof
	 * @throws IOException
	 * @throws MappingConfigurationException 
	 */
	public void directEMOFLoad(String prefixName, String dotEcore, String dotEmof) throws IOException, MappingConfigurationException {
		String ecoreContentTypeIdentifier = getEcoreContentTypeIdentifier();
		URI ecoreRefURI = getProjectFileURI(prefixName + dotEcore);
		URI emofLoadURI = getProjectFileURI(prefixName + dotEmof);		
		URI ecoreLoadSaveURI = getProjectFileURI(prefixName + dotEmof + ".as" + dotEcore);
		//
		//	Load the EMOF resource
		//
		ResourceSet standardResourceSet = new ResourceSetImpl();
		standardResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		standardResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emof", new EMOFResourceFactoryImpl());
		Resource emofLoadResource = standardResourceSet.getResource(emofLoadURI, true);
		//
		//	Load the reference Ecore resource
		//
		Resource ecoreRefResource = standardResourceSet.getResource(ecoreRefURI, true);
		//
		//	Compare the reference Ecore with the loaded EMOF as Ecore 
		//
		EquivalenceMap ecoreComparator = new EquivalenceMap(ecoreRefResource, emofLoadResource);
		assertNoDifferences(ecoreComparator, ecoreRefURI, ecoreLoadSaveURI);
		//
		//	Save the loaded EMOF as Ecore resource for debugging
		//
		Resource ecoreSaveResource = standardResourceSet.createResource(ecoreLoadSaveURI, ecoreContentTypeIdentifier);
		ecoreSaveResource.getContents().addAll(emofLoadResource.getContents());
		ecoreSaveResource.save(null);		
	}
	/**
	 * Load reference Ecore directly
	 * Save Ecore via adaption as EMOF
	 * Reload EMOF via adaption
	 * Compare reloaded adapted EMOF with reference Ecore
	 * 
	 * @param prefixName
	 * @param dotEcore
	 * @param dotEmof
	 * @throws IOException
	 * @throws MappingConfigurationException
	 */
	public void ecoreToAdaptedEMOF(String prefixName, String dotEcore, String dotEmof) throws IOException, MappingConfigurationException {
		String ecoreContentTypeIdentifier = getEcoreContentTypeIdentifier();
		IMappingMetaDataRegistry mappingMetaDataRegistry = getMappingMetaDataRegistry();
		PrintWriter writer = new PrintWriter(System.out);
		mappingMetaDataRegistry.validate(writer);
		writer.flush();
		URI ecoreRefURI = getProjectFileURI(prefixName + dotEcore);
		URI emofSaveURI = getProjectFileURI(prefixName + dotEcore + dotEmof);
		URI ecoreLoadURI = getProjectFileURI(prefixName + dotEcore + dotEcore);
		//
		//	Load the reference Ecore
		//
		Resource ecoreRefResource = resourceSet.getResource(ecoreRefURI, true);
		//
		//	Save the reference Ecore as EMOF
		//
		AdaptingXMIResource emofRefResource = mappingMetaDataRegistry.getAdapter(ecoreRefResource, emofSaveURI);
		XMIUtils.assignIds(emofRefResource, new HierachicalNamedElementIdCreator(), getIdFilter());
		emofRefResource.save(null);
		if (doReloadAndCompare) {
			//
			//	Reload the saved EMOF as an adapted Ecore
			//
			Resource ecoreLoadResource = resourceSet.createResource(ecoreLoadURI, ecoreContentTypeIdentifier);
			AdaptingXMIResource emofLoadResource = mappingMetaDataRegistry.getAdapter(ecoreLoadResource, emofSaveURI);
			emofLoadResource.load(null);
			if (doReloadedEcoreSave)
				ecoreLoadResource.save(null);
			//
			//	Compare the original Ecore with the reloaded Ecore
			//
			EquivalenceMap emofComparator = new EquivalenceMap(emofRefResource.getTarget(), emofLoadResource.getTarget());
			assertNoDifferences(emofComparator, ecoreRefURI, ecoreLoadURI);
		}
		else
			fail("doReloadAndCompare set false");
/*	
		URI ecore2URI = getProjectFileURI(prefixName + dotEcore + dotEcore);
		XMIResource ecore2Resource = mapper.createResource(AbstractMapping.Direction.ALIEN_TO_ECORE, ecore2URI, emofGen2Resource);
		ecore2Resource.save(null);
		
		EcoreComparator ecoreComparator = new EquivalenceMap(ecoreResource, ecore2Resource);
		List<EcoreDifference> ecoreDifferences = ecoreComparator.computeDifferences();
		int ecoreDifferenceCount = ecoreDifferences != null ? ecoreDifferences.size() : 0;
		if (ecoreDifferenceCount > 0) {
			System.out.println(ecoreURI.toString() + " : " + ecore2URI.toString());
			for (EcoreDifference ecoreDifference : ecoreDifferences)
				System.out.println(ecoreDifference);
		}
		assertEquals(prefixName + dotEcore + " Model differences", 0, ecoreDifferenceCount); */
	}
	
	/**
	 * Load reference Ecore directly
	 * Save Ecore directly as EMOF
	 * Reload EMOF via adaption
	 * Compare reloaded adapted EMOF with reference Ecore
	 * 
	 * @param prefixName
	 * @param dotEcore
	 * @param dotEmof
	 * @throws IOException
	 * @throws MappingConfigurationException
	 */
	public void ecoreToDirectEMOF(String prefixName, String dotEcore, String dotEmof) throws IOException, MappingConfigurationException {
		String ecoreContentTypeIdentifier = getEcoreContentTypeIdentifier();
		IMappingMetaDataRegistry mappingMetaDataRegistry = getMappingMetaDataRegistry();
		PrintWriter writer = new PrintWriter(System.out);
		mappingMetaDataRegistry.validate(writer);
		writer.flush();
		URI ecoreRefURI = getProjectFileURI(prefixName + dotEcore);
		URI emofSaveURI = getProjectFileURI(prefixName + dotEcore + dotEmof);
		URI ecoreLoadURI = getProjectFileURI(prefixName + dotEcore + dotEcore);
		//
		//	Load the reference Ecore
		//
		Resource ecoreRefResource = resourceSet.getResource(ecoreRefURI, true);
		//
		//	Save the reference Ecore as EMOF
		//
		ResourceSet standardResourceSet = new ResourceSetImpl();
		standardResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emof", new EMOFResourceFactoryImpl());
		Resource emofResource = standardResourceSet.createResource(emofSaveURI, null);
		emofResource.getContents().addAll(ecoreRefResource.getContents());
		emofResource.save(null);
		ecoreRefResource.getContents().addAll(emofResource.getContents());
		
		Resource ecoreLoadResource = resourceSet.createResource(ecoreLoadURI, ecoreContentTypeIdentifier);
		AdaptingXMIResource emofLoadResource = mappingMetaDataRegistry.getAdapter(ecoreLoadResource, emofSaveURI);
		emofLoadResource.load(null);
		if (doReloadedEcoreSave)
			ecoreLoadResource.save(null);
		
		EquivalenceMap emofComparator = new EquivalenceMap(ecoreRefResource, emofLoadResource.getTarget());
		assertNoDifferences(emofComparator, ecoreRefURI, emofSaveURI);
/*	
		URI ecore2URI = getProjectFileURI(prefixName + dotEcore + dotEcore);
		XMIResource ecore2Resource = mapper.createResource(AbstractMapping.Direction.ALIEN_TO_ECORE, ecore2URI, emofGen2Resource);
		ecore2Resource.save(null);
		
		EcoreComparator ecoreComparator = new EquivalenceMap(ecoreResource, ecore2Resource);
		List<EcoreDifference> ecoreDifferences = ecoreComparator.computeDifferences();
		int ecoreDifferenceCount = ecoreDifferences != null ? ecoreDifferences.size() : 0;
		if (ecoreDifferenceCount > 0) {
			System.out.println(ecoreURI.toString() + " : " + ecore2URI.toString());
			for (EcoreDifference ecoreDifference : ecoreDifferences)
				System.out.println(ecoreDifference);
		}
		assertEquals(prefixName + dotEcore + " Model differences", 0, ecoreDifferenceCount); */
	}

	protected abstract String getEcoreContentTypeIdentifier();

	protected ExcludedEClassIdFilter getIdFilter() {
		return new XMIUtils.ExcludedEClassIdFilter(new EClass[] {
				EcorePackage.Literals.EANNOTATION,
				EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY })
		{
			@Override
			public boolean createId(EObject object) {
				if (object instanceof AdaptingEObject)
					object = ((AdaptingEObject)object).getTarget();
				return super.createId(object);
			}
		};
	}
}
