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
package org.eclipse.qvtd.doc.exe2016.tests.emftvm;

import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.qvtd.doc.exe2016.tests.AbstractEXE2016CGTests;
import org.eclipse.qvtd.doc.exe2016.tests.DoublyLinkedListGenerator;
import org.eclipse.qvtd.doc.exe2016.tests.PrintAndLog;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePivotStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.doublylinkedlist.DoublylinkedlistPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Source code for CG results in EXE 2016, Micro-Mappings paper.
 */
public class EXE2016_EMFTVM_Tests extends AbstractEXE2016CGTests
{
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

	@Test
	public void testQVTcCompiler_Forward2Reverse_EMFTVM() throws Exception {
		DoublyLinkedListGenerator doublyLinkedListGenerator = new DoublyLinkedListGenerator();
		PrintAndLog logger = new PrintAndLog(getName());
		logger.printf("%s\n", getName());
		try {
			int[] tests = PrintAndLog.getTestSizes();
			for (int testSize : tests) {

				ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
				ResourceSet resourceSet = new ResourceSetImpl();
				resourceSet.getPackageRegistry().put(DoublylinkedlistPackage.eNS_URI, DoublylinkedlistPackage.eINSTANCE);
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("emftvm", new EMFTVMResourceFactoryImpl());

				// Load metamodels
				Metamodel metaModel = EmftvmFactory.eINSTANCE.createMetamodel();
				metaModel.setResource(resourceSet.getResource(URI.createURI("http://www.eclipse.org/m2m/atl/2011/EMFTVM"), true));
				env.registerMetaModel("METAMODEL", metaModel);
				metaModel = EmftvmFactory.eINSTANCE.createMetamodel();
				metaModel.setResource(resourceSet.getResource(URI.createURI(DoublylinkedlistPackage.eNS_URI), true));
				env.registerMetaModel("ForwardList", metaModel);
				env.registerMetaModel("ReverseList", metaModel);
				Resource forwardResource = resourceSet.createResource(URI.createURI("src/org/eclipse/qvtd/doc/exe2016/tests/emftvm/samples-Families.xmi"));
				try {
					forwardResource.load(new InputStream() {
						@Override
						public int read()      { return -1; }
						@Override
						public int available() { return 0; }
					}, null);
				}
				catch(Throwable e) {}
				Model outModel = EmftvmFactory.eINSTANCE.createModel();
				outModel.setResource(resourceSet.createResource(URI.createFileURI("out.xmi")));

				//		try {
				//	        int[] tests = PrintAndLog.getTestSizes();
				//	        for (int testSize : tests) {
				// Load models
				Model inModel = EmftvmFactory.eINSTANCE.createModel();
				forwardResource.getContents().clear();
				outModel.getResource().getContents().clear();
				env.clearModels();
				garbageCollect();
				Collection<@NonNull ? extends EObject> rootObjects = doublyLinkedListGenerator.createDoublyLinkedListModel(testSize);
				forwardResource.getContents().addAll(rootObjects);
				inModel.setResource(forwardResource);
				env.registerInputModel("IN", inModel);
				env.registerOutputModel("OUT", outModel);

				// Load and run module
				ModuleResolver mr = new DefaultModuleResolver("src/org/eclipse/qvtd/doc/exe2016/tests/emftvm/", new ResourceSetImpl());
				TimingData td = new TimingData();
				env.loadModule(mr, "Forward2Reverse");
				td.finishLoading();
				logger.printf("%9d, ", testSize);
				garbageCollect();
				long startTime = System.nanoTime();
				env.run(td);
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
				td.finish();

				Resource reverseListResource = outModel.getResource();
				Collection<@NonNull EObject> rootObjects2 = reverseListResource.getContents();
				Iterator<@NonNull EObject> it = rootObjects2.iterator();
				Object rootObject = it.next();
				assert !it.hasNext();
				assert ((DoublyLinkedList)rootObject).getOwnedElements().size() == testSize-1;
				doublyLinkedListGenerator.checkModel((DoublyLinkedList) rootObject, testSize);
			}
		}
		finally {
			logger.dispose();
		}
	}
}
