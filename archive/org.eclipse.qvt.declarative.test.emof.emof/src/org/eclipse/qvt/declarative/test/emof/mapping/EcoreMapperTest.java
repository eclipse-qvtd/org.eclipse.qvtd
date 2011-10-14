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
package org.eclipse.qvt.declarative.test.emof.mapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EMOFResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;
import org.eclipse.qvt.declarative.test.emof.UtilityTestCase;
import org.eclipse.qvt.declarative.test.emof.tools.EcoreComparator;
import org.eclipse.qvt.declarative.test.emof.tools.EcoreDifference;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceMap;

public class EcoreMapperTest extends UtilityTestCase
{	
	private ResourceSet resourceSet;
	
	public void directEMOFLoad(String prefixName) throws IOException {
		directEMOFLoad(prefixName, ".ecore", ".emof");
	}
	
	public void ecoreToDirectEMOF(String prefixName) throws IOException {
		ecoreToDirectEMOF(prefixName, ".ecore", ".direct.emof");
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
	public void directEMOFLoad(String prefixName, String dotEcore, String dotEmof) throws IOException {
		URI ecoreRefURI = getProjectFileURI(prefixName + dotEcore);
		URI emofLoadURI = getProjectFileURI(prefixName + dotEmof);		
		URI ecoreLoadSaveURI = getProjectFileURI(prefixName + dotEmof + dotEcore);
		//
		//	Load the EMOF resource
		//
		Resource emofLoadResource = resourceSet.getResource(emofLoadURI, true);
		//
		//	Load the reference Ecore resource
		//
		Resource ecoreRefResource = resourceSet.getResource(ecoreRefURI, true);
		//
		//	Compare the reference Ecore with the loaded EMOF as Ecore 
		//
		EcoreComparator ecoreComparator = new EquivalenceMap(ecoreRefResource, emofLoadResource);
		List<EcoreDifference> ecoreDifferences = ecoreComparator.computeDifferences();
		int ecoreDifferenceCount = ecoreDifferences.size();
		if (ecoreDifferenceCount > 0) {
			System.out.println(ecoreRefURI.toString() + " : " + ecoreLoadSaveURI.toString());
			for (EcoreDifference ecoreDifference : ecoreDifferences)
				System.out.println(ecoreDifference);
		}
		assertEquals(prefixName + dotEcore + " Model differences", 0, ecoreDifferenceCount);
	}
	
	/**
	 * Load reference Ecore directly
	 * Save Ecore directly as EMOF
	 * Reload EMOF directly
	 * Compare reloaded Ecore with reference Ecore
	 * 
	 * @param prefixName
	 * @param dotEcore
	 * @param dotEmof
	 * @throws IOException
	 * @throws MappingConfigurationException
	 */
	public void ecoreToDirectEMOF(String prefixName, String dotEcore, String dotEmof) throws IOException {
		String emofContentTypeIdentifier = getEMOFContentTypeIdentifier();
		URI ecoreRefURI = getProjectFileURI(prefixName + dotEcore);
		URI emofURI = getProjectFileURI(prefixName + dotEcore + dotEmof);
		//
		//	Load the reference Ecore
		//
		Resource ecoreRefResource = resourceSet.getResource(ecoreRefURI, true);
		//
		//	Save the reference Ecore as EMOF
		//
		Resource emofSaveResource = resourceSet.createResource(emofURI, emofContentTypeIdentifier);
		emofSaveResource.getContents().addAll(ecoreRefResource.getContents());
		emofSaveResource.save(null);
		ecoreRefResource.getContents().addAll(emofSaveResource.getContents());
		//
		//	Reload the EMOF resource
		//
		resourceSet.getResources().remove(emofSaveResource);
		Resource emofLoadResource = resourceSet.getResource(emofURI, true);
		
		EcoreComparator emofComparator = new EquivalenceMap(ecoreRefResource, emofLoadResource);
		List<EcoreDifference> emofDifferences = emofComparator.computeDifferences();
		int emofDifferenceCount = emofDifferences.size();
		if (emofDifferenceCount > 0) {
			System.out.println(ecoreRefURI.toString() + " : " + emofURI.toString());
			for (EcoreDifference emofDifference : emofDifferences)
				System.out.println(emofDifference);
		}
		assertEquals(prefixName + dotEmof + " Model differences", 0, emofDifferenceCount);
	}
	
	protected String getEMOFContentTypeIdentifier() {
		return EMOFPackage.eCONTENT_TYPE;
	}

	@Override protected void setUp() throws Exception {
		super.setUp();
		resourceSet = new ResourceSetImpl();
		Map<String,Object> factoryMap = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
		factoryMap.put("ecore", new XMIResourceFactoryImpl());
		factoryMap.put("emof", new EMOFResourceFactoryImpl());
	}

	public void testEcoreToAsEMOF_Ecore() throws IOException { ecoreToDirectEMOF("Ecore"); }
	public void testEmofLoadFrom_Ecore() throws IOException { directEMOFLoad("Ecore"); }
}
