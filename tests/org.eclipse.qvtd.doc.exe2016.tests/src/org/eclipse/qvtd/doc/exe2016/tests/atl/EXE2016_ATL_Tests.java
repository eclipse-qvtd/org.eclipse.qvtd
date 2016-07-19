/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.exe2016.tests.atl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.doc.exe2016.tests.DoublyLinkedListGenerator;
import org.eclipse.qvtd.doc.exe2016.tests.PrintAndLog;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.EXE2016CGTests;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.doublylinkedlist.DoublylinkedlistFactory;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.doublylinkedlist.DoublylinkedlistPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.doublylinkedlist.Element;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Source code for CG results in EXE 2016, Micro-Mappings paper.
 */
public class EXE2016_ATL_Tests extends TestCase
{
	public static void garbageCollect() throws InterruptedException {
		for (int y = 0; y < 5; y++) {
			System.gc();
			Thread.sleep(100);
		}
	}

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		QVTimperativePivotStandaloneSetup.doSetup();
	}

	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	/*    @Test
    public void testQVTcCompiler_Families_EcoreUtilCopy() throws Exception {
    	PrintAndLog logger = new PrintAndLog("results/" + getName());
    	logger.printf("%s\n", getName());
		QVTiEnvironmentFactory environmentFactory = new QVTiEnvironmentFactory(ProjectManager.NO_PROJECTS, null);
		try {
	        int[] tests = PrintAndLog.getTestSizes();
	        for (int testSize : tests) {
				Collection<@NonNull ? extends EObject> rootObjects = DoublyLinkedListGenerator.createFamiliesModel(testSize, 9);
				garbageCollect();
				logger.printf("%9d, ", 10*testSize);
				long startTime = System.nanoTime();
				Collection<@NonNull Object> rootObjects2 = EcoreUtil.copyAll(rootObjects);
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
				assert rootObjects2.size() == testSize;
	        }
		}
		finally {
			environmentFactory.dispose();
			logger.dispose();
		}
	} */

	@Test
	public void testQVTcCompiler_Forward2Reverse_ATL() throws Exception {
		PrintAndLog logger = new PrintAndLog(getName());
		logger.printf("%s\n", getName());
		/*
		 * Initializations
		 */
		ILauncher transformationLauncher = new EMFVMLauncher();
		EMFModelFactory modelFactory = new EMFModelFactory();
		ResourceSet resourceSet = modelFactory.getResourceSet();
		resourceSet.getPackageRegistry().put(DoublylinkedlistPackage.eNS_URI, DoublylinkedlistPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(DoublylinkedlistPackage.eNS_URI, DoublylinkedlistPackage.eINSTANCE);
		IInjector injector = new EMFInjector();
		/*
		 * Load metamodels
		 */
		EMFReferenceModel forwardListMetamodel = (EMFReferenceModel)modelFactory.newReferenceModel();
		injector.inject(forwardListMetamodel, DoublylinkedlistPackage.eNS_URI);
		EMFReferenceModel reverseListMetamodel = (EMFReferenceModel)modelFactory.newReferenceModel();
		injector.inject(reverseListMetamodel, DoublylinkedlistPackage.eNS_URI);
		try {
			int[] tests = PrintAndLog.getTestSizes();
			for (int testSize : tests) {
				/*
				 * Load models
				 */
				EMFModel forwardListModel = (EMFModel)modelFactory.newModel(forwardListMetamodel);
				Resource forwardListResource = resourceSet.createResource(URI.createURI("src/org/eclipse/qvtd/doc/exe2016/tests/atl/EmptyList.xmi"));
				try {
					forwardListResource.load(new InputStream() {
						@Override
						public int read()      { return -1; }
						@Override
						public int available() { return 0; }
					}, null);
				}
				catch(Throwable e) {}
				injector.inject(forwardListModel,"src/org/eclipse/qvtd/doc/exe2016/tests/atl/EmptyList.xmi");
				Collection<@NonNull ? extends EObject> rootObjects = DoublyLinkedListGenerator.createDoublyLinkedListModel(testSize);
				forwardListResource.getContents().clear();
				forwardListResource.getContents().addAll(rootObjects);
				EMFModel reverseListModel = (EMFModel)modelFactory.newModel(reverseListMetamodel);

				transformationLauncher.initialize(new HashMap<String,Object>());
				transformationLauncher.addInModel(forwardListModel, "IN", "ForwardList");
				transformationLauncher.addOutModel(reverseListModel, "OUT", "ReverseList");

				logger.printf("%9d, ", 10*testSize);
				EXE2016CGTests.garbageCollect();
				long startTime = System.nanoTime();
				transformationLauncher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), new HashMap<String,Object>(),
					new FileInputStream("src/org/eclipse/qvtd/doc/exe2016/tests/atl/Forward2Reverse.asm"));
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);

				Resource reverseListResource = reverseListModel.getResource();
				Collection<@NonNull EObject> rootObjects2 = reverseListResource.getContents();
				Iterator<@NonNull EObject> it = rootObjects2.iterator();
				Object rootObject = it.next();
				assert !it.hasNext();
				assert ((DoublyLinkedList)rootObject).getOwnedElements().size() == testSize-1;
				DoublyLinkedListGenerator.checkModel((DoublyLinkedList) rootObject, testSize);
				/*
				 * Unload all models
				 */
				modelFactory.unload(reverseListModel);
				modelFactory.unload(forwardListModel);
			}
		}
		finally {
			/*
			 * Unload all metamodels
			 */
			modelFactory.unload(forwardListMetamodel);
			modelFactory.unload(reverseListMetamodel);
			logger.dispose();
		}
	}

	/*    @Test
    public void testQVTcCompiler_Families2Persons_ManualInPlace() throws Exception {
    	PrintAndLog logger = new PrintAndLog(getName());
    	logger.printf("%s\n", getName());
		QVTiEnvironmentFactory environmentFactory = new QVTiEnvironmentFactory(ProjectManager.NO_PROJECTS, null);
		try {
	        int[] tests = PrintAndLog.getTestSizes();
	        for (int testSize : tests) {
				Iterable<@NonNull ? extends EObject> rootObjects = DoublyLinkedListGenerator.createFamiliesModel(testSize, 9);
				garbageCollect();
				logger.printf("%9d, ", 10*testSize);
				long startTime = System.nanoTime();
				List<Member> members = new ArrayList<Member>(9*testSize);
				for (EObject eObject : rootObjects) {
					Family family = (Family)eObject;
					members.add(family.getFather());
					members.add(family.getMother());
					members.addAll(family.getSons());
					members.addAll(family.getDaughters());
				}
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
				assert members.size() == 9*testSize;
	        }
		}
		finally {
			environmentFactory.dispose();
			logger.dispose();
		}
	} */

	@Test
	public void testQVTcCompiler_Families2Persons_EcoreUtil() throws Exception {
		PrintAndLog logger = new PrintAndLog(getName());
		logger.printf("%s\n", getName());
		QVTiEnvironmentFactory environmentFactory = new QVTiEnvironmentFactory(ProjectManager.NO_PROJECTS, null);
		try {
			int[] tests = PrintAndLog.getTestSizes();
			for (int testSize : tests) {
				Iterable<@NonNull ? extends Object> rootObjects = DoublyLinkedListGenerator.createDoublyLinkedListModel(testSize);
				garbageCollect();
				logger.printf("%9d, ", testSize);
				long startTime = System.nanoTime();
				DoublyLinkedList oldList = (DoublyLinkedList) rootObjects.iterator().next();
				Copier copier = new EcoreUtil.Copier();
				DoublyLinkedList newList = (DoublyLinkedList) copier.copy(oldList);
				for (Element oldElement : oldList.getOwnedElements()) {
					Element newElement = (Element) copier.get(oldElement);
					assert newElement != null;
					Element oldTarget = oldElement.getTarget();
					Element newSource = (Element) copier.get(oldTarget);
					assert newSource != null;
					newElement.setSource(newSource);
				}
				newList.setHeadElement((Element) copier.get(oldList.getHeadElement()));
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
				DoublyLinkedListGenerator.checkModel(newList, testSize);
			}
		}
		finally {
			environmentFactory.dispose();
			logger.dispose();
		}
	}

	@Test
	public void testQVTcCompiler_Families2Persons_Manual() throws Exception {
		PrintAndLog logger = new PrintAndLog(getName());
		logger.printf("%s\n", getName());
		QVTiEnvironmentFactory environmentFactory = new QVTiEnvironmentFactory(ProjectManager.NO_PROJECTS, null);
		try {
			int[] tests = PrintAndLog.getTestSizes();
			for (int testSize : tests) {
				Iterable<@NonNull ? extends Object> rootObjects = DoublyLinkedListGenerator.createDoublyLinkedListModel(testSize);
				garbageCollect();
				logger.printf("%9d, ", testSize);
				long startTime = System.nanoTime();
				DoublyLinkedList oldList = (DoublyLinkedList) rootObjects.iterator().next();
				List<Element> oldElements = oldList.getOwnedElements();
				//
				DoublyLinkedList newList = DoublylinkedlistFactory.eINSTANCE.createDoublyLinkedList();
				int iSize = oldElements.size();
				List<Element> newElements = new ArrayList<>(iSize);
				newList.setName(oldList.getName());

				Element prevElement = null;
				for (Element oldElement : oldElements) {
					Element newElement = DoublylinkedlistFactory.eINSTANCE.createElement();
					newElement.setName(oldElement.getName());
					newElement.setTarget(prevElement);
					newElements.add(newElement);
					prevElement = newElement;
				}
				if (prevElement != null) {
					Element firstElement = newElements.get(0);
					firstElement.setTarget(prevElement);
					newList.setHeadElement(firstElement);
				}
				newList.getOwnedElements().addAll(newElements);
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
				DoublyLinkedListGenerator.checkModel(newList, testSize);
			}
		}
		finally {
			environmentFactory.dispose();
			logger.dispose();
		}
	}

	/*    private Member manualCopy(@NonNull Member oldMember) {
		Member newMember = FamiliesFactory.eINSTANCE.createMember();
		newMember.setFirstName(oldMember.getFirstName());
		return newMember;
	} */
}
