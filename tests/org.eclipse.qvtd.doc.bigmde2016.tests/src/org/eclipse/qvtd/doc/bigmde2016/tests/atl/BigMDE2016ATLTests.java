/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.bigmde2016.tests.atl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.eclipse.qvtd.doc.bigmde2016.tests.FamiliesGenerator;
import org.eclipse.qvtd.doc.bigmde2016.tests.PrintAndLog;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.BigMDE2016CGTests;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families.FamiliesPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Persons.PersonsPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Source code for ATL results in BigMDE 2016, Eclipse QVTC First Results paper.
 */
public class BigMDE2016ATLTests extends TestCase
{ 
	@Before
    public void setUp() throws Exception {
		super.setUp();
    }

    @After
    public void tearDown() throws Exception {
		super.tearDown();
    }
    
    static class NullInputStream extends InputStream {
        static final NullInputStream INSTANCE = new NullInputStream();
        private NullInputStream() {}
        public int read()      { return -1; }
        public int available() { return 0; }
    }
    
    @Test
    public void testQVTcCompiler_Families2Persons_ATL() throws Exception {
    	PrintAndLog logger = new PrintAndLog(getName());
    	logger.printf("%s\n", getName());
		/*
		 * Initializations
		 */
		ILauncher transformationLauncher = new EMFVMLauncher();
		EMFModelFactory modelFactory = new EMFModelFactory();
		ResourceSet resourceSet = modelFactory.getResourceSet();
		resourceSet.getPackageRegistry().put(FamiliesPackage.eNS_URI, FamiliesPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(PersonsPackage.eNS_URI, PersonsPackage.eINSTANCE);
		IInjector injector = new EMFInjector();
		/*
		 * Load metamodels
		 */
		EMFReferenceModel familiesMetamodel = (EMFReferenceModel)modelFactory.newReferenceModel();
		injector.inject(familiesMetamodel, FamiliesPackage.eNS_URI);
		EMFReferenceModel personsMetamodel = (EMFReferenceModel)modelFactory.newReferenceModel();
		injector.inject(personsMetamodel, PersonsPackage.eNS_URI);
		try {
	        int[] tests = PrintAndLog.getTestSizes();
	        for (int testSize : tests) {
	    		/*
	    		 * Load models
	    		 */
	    		EMFModel familiesModel = (EMFModel)modelFactory.newModel(familiesMetamodel);
	    		Resource familiesResource = resourceSet.createResource(URI.createURI("src/org/eclipse/qvtd/doc/bigmde2016/tests/atl/samples-Families.xmi"));
	    		try {
	    			familiesResource.load(new InputStream() {
	    		        public int read()      { return -1; }
	    		        public int available() { return 0; }
	    		    }, null);
	    		}
	    		catch(Throwable e) {}
	    		injector.inject(familiesModel,"src/org/eclipse/qvtd/doc/bigmde2016/tests/atl/samples-Families.xmi");
				Collection<@NonNull ? extends EObject> rootObjects = FamiliesGenerator.createFamiliesModel(testSize, 9);
				familiesResource.getContents().clear();
				familiesResource.getContents().addAll(rootObjects);
				EMFModel personsModel = (EMFModel)modelFactory.newModel(personsMetamodel);
				
				transformationLauncher.initialize(new HashMap<String,Object>());
				transformationLauncher.addInModel(familiesModel, "IN", "Families");
				transformationLauncher.addOutModel(personsModel, "OUT", "Persons");

				logger.printf("%9d, ", 10*testSize);
				BigMDE2016CGTests.garbageCollect();
				long startTime = System.nanoTime();
				transformationLauncher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), new HashMap<String,Object>(),
					new FileInputStream("src/org/eclipse/qvtd/doc/bigmde2016/tests/atl/Families2Persons.asm"));
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
				
				Resource personsResource = personsModel.getResource();
				Collection<@NonNull EObject> rootObjects2 = personsResource.getContents();
				assert rootObjects2.size() == 9*testSize;
				/*
				 * Unload all models
				 */
				modelFactory.unload(personsModel);
				modelFactory.unload(familiesModel);
	        }
		}
		finally {
			/*
			 * Unload all metamodels
			 */
			modelFactory.unload(familiesMetamodel);
			modelFactory.unload(personsMetamodel);
			logger.dispose();
		}
	}
    
    @Test
    public void testQVTcCompiler_Families2Persons_EMFTVM() throws Exception {
    	PrintAndLog logger = new PrintAndLog(getName());
    	logger.printf("%s\n", getName());
		try {
	        int[] tests = PrintAndLog.getTestSizes();
	        for (int testSize : tests) {

    	ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
    	ResourceSet resourceSet = new ResourceSetImpl();
		EPackage.Registry.INSTANCE.put(FamiliesPackage.eNS_URI, FamiliesPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(PersonsPackage.eNS_URI, PersonsPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("emftvm", new EMFTVMResourceFactoryImpl());

    	// Load metamodels
    	Metamodel metaModel = EmftvmFactory.eINSTANCE.createMetamodel();
    	metaModel.setResource(resourceSet.getResource(URI.createURI("http://www.eclipse.org/m2m/atl/2011/EMFTVM"), true));
    	env.registerMetaModel("METAMODEL", metaModel);
    	metaModel = EmftvmFactory.eINSTANCE.createMetamodel();
    	metaModel.setResource(resourceSet.getResource(URI.createURI(FamiliesPackage.eNS_URI), true));
    	env.registerMetaModel("Families", metaModel);
    	metaModel = EmftvmFactory.eINSTANCE.createMetamodel();
    	metaModel.setResource(resourceSet.getResource(URI.createURI(PersonsPackage.eNS_URI), true));
    	env.registerMetaModel("Persons", metaModel);
		Resource familiesResource = resourceSet.createResource(URI.createURI("src/org/eclipse/qvtd/doc/bigmde2016/tests/atl/samples-Families.xmi"));
		try {
			familiesResource.load(new InputStream() {
		        public int read()      { return -1; }
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
				familiesResource.getContents().clear();
				outModel.getResource().getContents().clear();
				env.clearModels();
				BigMDE2016CGTests.garbageCollect();
				Collection<@NonNull ? extends EObject> rootObjects = FamiliesGenerator.createFamiliesModel(testSize, 9);
				familiesResource.getContents().addAll(rootObjects);
		    	inModel.setResource(familiesResource);
		    	env.registerInputModel("IN", inModel);
		    	env.registerOutputModel("OUT", outModel);
		
		    	// Load and run module
		    	ModuleResolver mr = new DefaultModuleResolver("src/org/eclipse/qvtd/doc/bigmde2016/tests/atl/", new ResourceSetImpl());
		    	TimingData td = new TimingData();
		    	env.loadModule(mr, "Families2Persons");
		    	td.finishLoading();
				logger.printf("%9d, ", 10*testSize);
				BigMDE2016CGTests.garbageCollect();
				long startTime = System.nanoTime();
		    	env.run(td);
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
		    	td.finish();
		
				Resource personsResource = outModel.getResource();
				Collection<@NonNull EObject> rootObjects2 = personsResource.getContents();
				assert rootObjects2.size() == 9*testSize;
			}
		}
		finally {
			logger.dispose();
		}
    }
}
