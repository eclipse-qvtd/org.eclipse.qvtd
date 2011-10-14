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
package org.eclipse.qvt.declarative.test.emof.tools;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

public class EcoreComparatorTests extends TestCase
{
	protected EPackage addPackage(Resource resource, String name) {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		if (name != null)
			ePackage.setName(name);
		resource.getContents().add(ePackage);
		return ePackage;
	}

	public void testEmpty() throws IOException {
		Resource leftResource = new XMIResourceImpl();
		Resource rightResource = new XMIResourceImpl();
		EcoreComparator ecoreComparator = new EquivalenceMap(leftResource, rightResource);
		Collection<EcoreDifference> differences = ecoreComparator.computeDifferences();
		int differenceCount = differences.size();
		assertEquals("Model differences", 0, differenceCount);
	}
	
	public void testSingleContent() throws IOException {
		Resource leftResource = new XMIResourceImpl();
		addPackage(leftResource, null);
		Resource rightResource = new XMIResourceImpl();
		addPackage(rightResource, null);
		EcoreComparator ecoreComparator = new EquivalenceMap(leftResource, rightResource);
		List<EcoreDifference> differences = ecoreComparator.computeDifferences();
		int differenceCount = differences.size();
		assertEquals("Model differences", 0, differenceCount);
	}
	
	public void testJustLeft() throws IOException {
		Resource leftResource = new XMIResourceImpl();
		EPackage leftPackage = addPackage(leftResource, null);
		Resource rightResource = new XMIResourceImpl();
		EcoreComparator ecoreComparator = new EquivalenceMap(leftResource, rightResource);
		List<EcoreDifference> differences = ecoreComparator.computeDifferences();
		int differenceCount = differences.size();
		assertEquals("Model differences", 1, differenceCount);
		differences.get(0).assertDifference(null, leftPackage, null, null);
	}
	
	public void testJustRight() throws IOException {
		Resource leftResource = new XMIResourceImpl();
		Resource rightResource = new XMIResourceImpl();
		EPackage rightPackage = addPackage(rightResource, null);
		EcoreComparator ecoreComparator = new EquivalenceMap(leftResource, rightResource);
		List<EcoreDifference> differences = ecoreComparator.computeDifferences();
		int differenceCount = differences.size();
		assertEquals("Model differences", 1, differenceCount);
		differences.get(0).assertDifference(null, null, rightPackage, null);
	}
	
	public void testChangedAttributeWrtNull() throws IOException {
		Resource leftResource = new XMIResourceImpl();
		addPackage(leftResource, "left");
		Resource rightResource = new XMIResourceImpl();
		addPackage(rightResource, null);
		EcoreComparator ecoreComparator = new EquivalenceMap(leftResource, rightResource);
		List<EcoreDifference> differences = ecoreComparator.computeDifferences();
		int differenceCount = differences.size();
		assertEquals("Model differences", 1, differenceCount);
		differences.get(0).assertDifference(EcorePackage.eINSTANCE.getENamedElement_Name(), "left", null, null);
	}
	
	public void testChangedAttributeValue() throws IOException {
		Resource leftResource = new XMIResourceImpl();
		addPackage(leftResource, "left");
		Resource rightResource = new XMIResourceImpl();
		addPackage(rightResource, "right");
		EcoreComparator ecoreComparator = new EquivalenceMap(leftResource, rightResource);
		List<EcoreDifference> differences = ecoreComparator.computeDifferences();
		int differenceCount = differences.size();
		assertEquals("Model differences", 1, differenceCount);
		Collections.sort(differences);
		differences.get(0).assertDifference(EcorePackage.eINSTANCE.getENamedElement_Name(), "left", "right", null);
	}
	
	public void testSameOrderContent() throws IOException {
		Resource leftResource = new XMIResourceImpl();
		addPackage(leftResource, "one");
		addPackage(leftResource, "two");
		Resource rightResource = new XMIResourceImpl();
		addPackage(rightResource, "one");
		addPackage(rightResource, "two");
		EcoreComparator ecoreComparator = new EquivalenceMap(leftResource, rightResource);
		List<EcoreDifference> differences = ecoreComparator.computeDifferences();
		int differenceCount = differences.size();
		assertEquals("Model differences", 0, differenceCount);
	}
	
	public void testExtraLeftContent() throws IOException {
		Resource leftResource = new XMIResourceImpl();
		addPackage(leftResource, "one");
		addPackage(leftResource, "two");
		EPackage leftPackage = addPackage(leftResource, "three");
		Resource rightResource = new XMIResourceImpl();
		addPackage(rightResource, "one");
		addPackage(rightResource, "two");
		EcoreComparator ecoreComparator = new EquivalenceMap(leftResource, rightResource);
		List<EcoreDifference> differences = ecoreComparator.computeDifferences();
		int differenceCount = differences.size();
		assertEquals("Model differences", 1, differenceCount);
		differences.get(0).assertDifference(null, leftPackage, null, null);
	}
	
	public void testExtraRightContent() throws IOException {
		Resource leftResource = new XMIResourceImpl();
		addPackage(leftResource, "one");
		addPackage(leftResource, "two");
		Resource rightResource = new XMIResourceImpl();
		addPackage(rightResource, "one");
		addPackage(rightResource, "two");
		EPackage rightPackage = addPackage(rightResource, "three");
		EcoreComparator ecoreComparator = new EquivalenceMap(leftResource, rightResource);
		List<EcoreDifference> differences = ecoreComparator.computeDifferences();
		int differenceCount = differences.size();
		assertEquals("Model differences", 1, differenceCount);
		differences.get(0).assertDifference(null, null, rightPackage, null);
	}
	
	public void testMisMatchInOrderContent() throws IOException {
		Resource leftResource = new XMIResourceImpl();
		addPackage(leftResource, "one");
		addPackage(leftResource, "two");
		addPackage(leftResource, "left");
		Resource rightResource = new XMIResourceImpl();
		addPackage(rightResource, "one");
		addPackage(rightResource, "two");
		addPackage(rightResource, "right");
		EcoreComparator ecoreComparator = new EquivalenceMap(leftResource, rightResource);
		List<EcoreDifference> differences = ecoreComparator.computeDifferences();
		int differenceCount = differences.size();
		assertEquals("Model differences", 1, differenceCount);
		differences.get(0).assertDifference(EcorePackage.eINSTANCE.getENamedElement_Name(), "left", "right", null);
	}
	
	public void testMisMatchOutOfOrderContent() throws IOException {
		Resource leftResource = new XMIResourceImpl();
		addPackage(leftResource, "one");
		addPackage(leftResource, "left");
		addPackage(leftResource, "two");
		Resource rightResource = new XMIResourceImpl();
		addPackage(rightResource, "two");
		addPackage(rightResource, "one");
		addPackage(rightResource, "right");
		EcoreComparator ecoreComparator = new EquivalenceMap(leftResource, rightResource);
		List<EcoreDifference> differences = ecoreComparator.computeDifferences();
		int differenceCount = differences.size();
		assertEquals("Model differences", 1, differenceCount);
		differences.get(0).assertDifference(EcorePackage.eINSTANCE.getENamedElement_Name(), "left", "right", null);
	}
}
