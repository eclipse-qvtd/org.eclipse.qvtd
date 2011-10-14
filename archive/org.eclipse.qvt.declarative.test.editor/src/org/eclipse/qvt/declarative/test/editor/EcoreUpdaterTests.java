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
package org.eclipse.qvt.declarative.test.editor;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.qvt.declarative.test.emof.mapping.models.MappingModels;
import org.eclipse.qvt.declarative.test.parser.models.ParserModels;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;
import org.eclipse.qvt.declarative.ecore.utils.XMIUtils;
import org.eclipse.qvt.declarative.editor.ui.utils.EcoreUpdater;
import org.eclipse.qvt.declarative.editor.ui.utils.MissingElementException;
import org.eclipse.qvt.declarative.editor.ui.utils.MissingXmiIdException;
import org.eclipse.qvt.declarative.emof.QVTRelation.util.QVTRelationMappingMetaData;
import org.eclipse.qvt.declarative.test.emof.AbstractModels;
import org.eclipse.qvt.declarative.test.emof.AbstractTestCase;
import org.eclipse.qvt.declarative.test.emof.tools.EcoreComparator;
import org.eclipse.qvt.declarative.test.emof.tools.EcoreDifference;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceMap;

public class EcoreUpdaterTests extends AbstractTestCase
{
	protected static final AbstractModels MAPPING_MODELS = MappingModels.INSTANCE;
	protected static final AbstractModels PARSER_MODELS = ParserModels.INSTANCE;

	/**
	 * Asserts that two objects are equal. If they are not
	 * an AssertionFailedError is thrown with the given message.
	 */
	static public void assertEquals(String message, XMLResource expected, XMLResource actual) {
//		assertEquals("URI", expected.getURI(), actual.getURI());
		EcoreComparator ecoreComparator = new EquivalenceMap(expected, actual);
		List<EcoreDifference> ecoreDifferences = ecoreComparator.computeDifferences();
		int ecoreDifferenceCount = 0;
		if (ecoreDifferences != null) {
			ecoreDifferenceCount = ecoreDifferences.size();
			if (ecoreDifferenceCount > 0) {
				System.out.println("URI : " + expected.getURI());
				for (EcoreDifference ecoreDifference : ecoreDifferences)
					System.out.println(ecoreDifference);
			}
		}
		assertEquals("Model differences", 0, ecoreDifferenceCount);
	}

	/**
	 * Asserts that two objects are equal. If they are not
	 * an AssertionFailedError is thrown with the given message.
	 */
	static public void assertNotEquals(String message, XMLResource expected, XMLResource actual, int differences) {
		assertEquals("URI", expected.getURI(), actual.getURI());
		EcoreComparator ecoreComparator = new EquivalenceMap(expected, actual);
		List<EcoreDifference> ecoreDifferences = ecoreComparator.computeDifferences();
		int ecoreDifferenceCount = 0;
		if (ecoreDifferences != null) {
			ecoreDifferenceCount = ecoreDifferences.size();
			if ((ecoreDifferenceCount != differences)  && (differences >= 0)) {
				System.out.println("URI : " + expected.getURI());
				for (EcoreDifference ecoreDifference : ecoreDifferences)
					System.out.println(ecoreDifference);
			}
		}
		if (differences >= 0)
			assertEquals("Model differences", differences, ecoreDifferenceCount);
		else if (ecoreDifferenceCount <= 0)
			fail("Model differences expected");
	}

	protected void replacementTest(URI oldURI, URI newURI) throws IOException, MissingElementException {
		XMLResource oldResource = (XMLResource) resourceSet.createResource(oldURI, EcorePackage.eCONTENT_TYPE);
		XMLResource newResource = (XMLResource) resourceSet.getResource(newURI, true);
		XMIUtils.assignIds(newResource, "test");
		XMLResource savedOldResource = EcoreUpdater.copy(oldResource);
		assertEquals("Saved working context", oldResource, savedOldResource);
		XMLResource savedNewResource = EcoreUpdater.copy(newResource);
		assertEquals("Saved update context", newResource, savedNewResource);
		EcoreUpdater.update(oldResource, newResource);
		assertEquals("Post update", oldResource, newResource);
		assertEquals("Saved Post update", savedNewResource, newResource);
		EcoreUpdater.update(oldResource, savedOldResource);
		assertEquals("Post restore", oldResource, savedOldResource);
		assertEquals("Saved Post restore", savedNewResource, newResource);
	}

	public void testEmptyNoChange() throws IOException, MissingElementException {
		XMLResource workingResource = new XMIResourceImpl();
		XMLResource savedResource = EcoreUpdater.copy(workingResource);
		assertEquals("Saved context", workingResource, savedResource);
		XMLResource copiedResource = EcoreUpdater.copy(savedResource);
		assertEquals("Copied context", workingResource, copiedResource);
		EcoreUpdater.update(workingResource, copiedResource);
		assertEquals("Post update", workingResource, savedResource);
		assertEquals("Saved Post update", savedResource, savedResource);
	}

	public void testMissingXmiId() throws IOException {
		URI ecoreURI = MAPPING_MODELS.getURI("Ecore.ecore");
		XMLResource workingResource = (XMLResource) resourceSet.getResource(ecoreURI, true);
		try {
			@SuppressWarnings("unused")
			XMLResource savedResource = EcoreUpdater.copy(workingResource);
			fail("MissingXmiIdException expected");
		} catch (MissingXmiIdException e) {		
		}
	}

	public void testEcoreNoChange() throws IOException, MissingElementException {
		URI ecoreURI = MAPPING_MODELS.getURI("Ecore.ecore");
		XMLResource workingResource = (XMLResource) resourceSet.getResource(ecoreURI, true);
		XMIUtils.assignIds(workingResource, "test");
		XMLResource savedResource = EcoreUpdater.copy(workingResource);
		assertEquals("Saved context", workingResource, savedResource);
		XMLResource copiedResource = EcoreUpdater.copy(savedResource);
		assertEquals("Copied context", workingResource, copiedResource);
		EcoreUpdater.update(workingResource, copiedResource);
		assertEquals("Post update", workingResource, savedResource);
		assertEquals("Saved Post update", savedResource, savedResource);
	}

	public void testReplacement_EObject() throws IOException, MissingElementException {
		replacementTest(MAPPING_MODELS.getURI("Empty1.ecore"), MAPPING_MODELS.getURI("EObject.ecore"));
	}

	public void testReplacement_Ecore() throws IOException, MissingElementException {
		replacementTest(MAPPING_MODELS.getURI("Empty1.ecore"), MAPPING_MODELS.getURI("Ecore.ecore"));
	}

	public void testReplacement_SeqToStm() throws IOException, MissingElementException {
		QVTRelationMappingMetaData.INSTANCE.configure(resourceSet, getMappingMetaDataRegistry());
		replacementTest(MAPPING_MODELS.getURI("Empty1.ecore"), PARSER_MODELS.getURI("SeqToStm.reference.eqvtrelation"));
	}

	public void testEcoreChangedAttribute() throws IOException, MissingElementException {
		URI ecoreURI = MAPPING_MODELS.getURI("Ecore.ecore");
		XMLResource workingResource = (XMLResource) resourceSet.getResource(ecoreURI, true);
		XMIUtils.assignIds(workingResource, "test");
		XMLResource savedResource = EcoreUpdater.copy(workingResource);
		assertEquals("Saved context", workingResource, savedResource);
		XMLResource copiedResource = EcoreUpdater.copy(savedResource);
		assertEquals("Copied context", workingResource, copiedResource);
		EPackage ecorePackage = (EPackage) workingResource.getContents().get(0);
		EClassifier attributeClass = EcoreUtils.getNamedElement(ecorePackage.getEClassifiers(), "EAttribute");
		attributeClass.setName("NotEAttribute");
		assertNotEquals("Modified context", workingResource, copiedResource, 1);
		EcoreUpdater.update(workingResource, copiedResource);
		assertEquals("Post update", workingResource, savedResource);
		assertEquals("Saved Post update", savedResource, savedResource);
	}

/* FIXME	public void testEcoreChangeSuperType() throws IOException, MissingElementException {
		URI ecoreURI = MappingModels.INSTANCE.getURI("Ecore.ecore");
		XMLResource workingResource = (XMLResource) resourceSet.getResource(ecoreURI, true);
		XMIUtils.assignIds(workingResource, "test");
		XMLResource savedResource = XMIUtils.copy(workingResource);
		assertEquals("Saved context", workingResource, savedResource);
		XMLResource copiedResource = XMIUtils.copy(savedResource);
		assertEquals("Copied context", workingResource, copiedResource);
		EPackage ecorePackage = (EPackage) workingResource.getContents().get(0);
		EClass attributeClass = (EClass) CSTUtils.getNamedElement(ecorePackage.getEClassifiers(), "EAttribute");
		EClass objectClass = (EClass) CSTUtils.getNamedElement(ecorePackage.getEClassifiers(), "EObject");
		attributeClass.getESuperTypes().clear();
		attributeClass.getESuperTypes().add(objectClass);
		assertNotEquals("Modified context", workingResource, copiedResource, 1);
		XMIUtils.update(workingResource, copiedResource);
		assertEquals("Post update", workingResource, savedResource);
		assertEquals("Saved Post update", savedResource, savedResource);
	} */

	public void testEcoreChangeReference() throws IOException, MissingElementException {
		URI ecoreURI = MAPPING_MODELS.getURI("Ecore.ecore");
		XMLResource workingResource = (XMLResource) resourceSet.getResource(ecoreURI, true);
		XMIUtils.assignIds(workingResource, "test");
		XMLResource savedResource = EcoreUpdater.copy(workingResource);
		assertEquals("Saved context", workingResource, savedResource);
		XMLResource copiedResource = EcoreUpdater.copy(savedResource);
		assertEquals("Copied context", workingResource, copiedResource);
		EPackage ecorePackage = (EPackage) workingResource.getContents().get(0);
		EPackage nestedPackage = EcoreFactory.eINSTANCE.createEPackage();
		nestedPackage.setName("nested");
		ecorePackage.getESubpackages().add(nestedPackage);
		EClass factoryClass = (EClass) EcoreUtils.getNamedElement(ecorePackage.getEClassifiers(), "EFactory");
		nestedPackage.getEClassifiers().add(factoryClass);
		XMIUtils.assignIds(workingResource, "extra");
		assertNotEquals("Modified context", workingResource, copiedResource, -1);
		EcoreUpdater.update(workingResource, copiedResource);
		assertEquals("Post update", workingResource, savedResource);
		assertEquals("Saved Post update", savedResource, savedResource);
	}

	public void testEcoreReorderReference() throws IOException, MissingElementException {
		URI ecoreURI = MAPPING_MODELS.getURI("Ecore.ecore");
		XMLResource workingResource = (XMLResource) resourceSet.getResource(ecoreURI, true);
		XMIUtils.assignIds(workingResource, "test");
		XMLResource savedResource = EcoreUpdater.copy(workingResource);
		assertEquals("Saved context", workingResource, savedResource);
		XMLResource copiedResource = EcoreUpdater.copy(savedResource);
		assertEquals("Copied context", workingResource, copiedResource);
		EPackage ecorePackage = (EPackage) workingResource.getContents().get(0);
		EPackage nestedPackage = EcoreFactory.eINSTANCE.createEPackage();
		nestedPackage.setName("nested");
		ecorePackage.getESubpackages().add(nestedPackage);
		EClass factoryClass = (EClass) EcoreUtils.getNamedElement(ecorePackage.getEClassifiers(), "EFactory");
		nestedPackage.getEClassifiers().add(factoryClass);
		ecorePackage.getEClassifiers().add(factoryClass);
		XMIUtils.assignIds(workingResource, "extra");
		assertNotEquals("Modified context", workingResource, copiedResource, -1);
		EcoreUpdater.update(workingResource, copiedResource);
		assertEquals("Post update", workingResource, savedResource);
		assertEquals("Saved Post update", savedResource, savedResource);
	}
}
