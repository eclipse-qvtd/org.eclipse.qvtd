package org.eclipse.qvtd.doc.bigmde2016.tests.etl;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfModelFactory;
import org.eclipse.epsilon.emc.emf.EmfModelFactory.AccessMode;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.epl.EplModule;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.doc.bigmde2016.tests.FamiliesGenerator;
import org.eclipse.qvtd.doc.bigmde2016.tests.PrintAndLog;
import org.eclipse.qvtd.doc.bigmde2016.tests.SimpleUMLGenerator;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.BigMDE2016CGTests;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.QVTcSimpleUMLGenerator;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families.FamiliesPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Persons.PersonsPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simplerdbms.SimplerdbmsPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.SimpleumlPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class BigMDE2016ETLTests extends TestCase {
	
	
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
    public void testQVTcCompiler_Families2Persons_ETL() throws Exception {
    	PrintAndLog logger = new PrintAndLog(getName());
    	logger.printf("%s\n", getName());
		/*
		 * Initializations
		 */
		try {
	        int[] tests = PrintAndLog.getTestSizes();
	        for (int testSize : tests) {
	    		EtlModule transformationLauncher = new EtlModule();
	    		EmfModelFactory modelFactory = EmfModelFactory.getInstance();
	    		String etlpath = "src/org/eclipse/qvtd/doc/bigmde2016/tests/etl/Families2Persons.etl";
	    		File file = new File(etlpath);
	    		transformationLauncher.parse(file);
	    		/*
	    		 * Load models
	    		 */
//	        	file = new File("src/org/eclipse/qvtd/doc/bigmde2016/tests/atl/samples-Families.xmi");
//	        	EmfModel familiesModel = modelFactory.loadEmfModel("Families", file, FamiliesPackage.eINSTANCE, AccessMode.READ_ONLY);
	        	EmfModel familiesModel = new EmfModel();
	        	familiesModel.setName("Families");
	        	familiesModel.setMetamodelFileBased(false);
	        	familiesModel.setMetamodelUri(FamiliesPackage.eINSTANCE.getNsURI());
	        	familiesModel.setResource(new XMIResourceImpl());
	        	AccessMode.READ_ONLY.applyTo(familiesModel);
	    		Collection<@NonNull ? extends EObject> rootObjects = FamiliesGenerator.createFamiliesModel(testSize, 9);
				familiesModel.getResource().getContents().clear();
				familiesModel.getResource().getContents().addAll(rootObjects);
//				file = new File("src/org/eclipse/qvtd/doc/bigmde2016/tests/atl/samples-Persons.xmi");
//				EmfModel personsModel = modelFactory.createEmfModel("Persons", file, PersonsPackage.eINSTANCE, AccessMode.WRITE_ONLY);
				EmfModel personsModel = new EmfModel();
				personsModel.setName("Persons");
				personsModel.setMetamodelFileBased(false);
				personsModel.setMetamodelUri(PersonsPackage.eINSTANCE.getNsURI());
				personsModel.setResource(new XMIResourceImpl());
	        	AccessMode.WRITE_ONLY.applyTo(personsModel);
				transformationLauncher.getContext().getModelRepository().addModel(familiesModel);
				transformationLauncher.getContext().getModelRepository().addModel(personsModel);
				/*
				 * Execute
				 */
				logger.printf("%9d, ", 10*testSize);
				BigMDE2016CGTests.garbageCollect();
				long startTime = System.nanoTime();
				transformationLauncher.execute();
				long endTime = System.nanoTime();
				
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
				
				Resource personsResource = personsModel.getResource();
				Collection<@NonNull EObject> rootObjects2 = personsResource.getContents();
				assert rootObjects2.size() == 9*testSize;
				/*
				 * Unload all models
				 */
				transformationLauncher.reset();
				transformationLauncher.getContext().getModelRepository().dispose();
				transformationLauncher.getContext().dispose();
	        }
		}
		finally {
			logger.dispose();
		}
	}
    
    @Test
    public void testQVTcCompiler_UML2RDBMS_ETL() throws Exception {
    	PrintAndLog logger = new PrintAndLog(getName());
    	logger.printf("%s\n", getName());
		/*
		 * Initializations
		 */
		try {
	        int[] tests = PrintAndLog.getTestSizes();
	        QVTcSimpleUMLGenerator generator = new QVTcSimpleUMLGenerator();
	        for (int testSize : tests) {
	        	// Test model generation
	        	int nPackages = testSize;
	           	int nClasses = testSize * 8;
	           	int nTypes = 0;//testSize;
	           	int nProperties = 0;//testSize * 45;
	           	int nAssociations = 0;//testSize * 45;
	        	int nElements = nPackages + nClasses + nTypes + nProperties + nAssociations;
				Collection<@NonNull ? extends EObject> rootObjects = generator.createSimpleUMLModel(nPackages, nClasses, nTypes, nProperties, nAssociations);
	        	
	        	EmfModelFactory modelFactory = EmfModelFactory.getInstance();
	        	EplModule matchLauncher = new EplModule();
	    		String eplpath = "src/org/eclipse/qvtd/doc/bigmde2016/tests/etl/UML2RDBMSa.epl";
	    		File eplfile = new File(eplpath);
	    		EtlModule transformationLauncher = new EtlModule();
	    		String etlpath = "src/org/eclipse/qvtd/doc/bigmde2016/tests/etl/UML2RDBMSb.etl";
	    		File etlfile = new File(etlpath);
	    		/*
	    		 * Load models
	    		 */
	        	EmfModel familiesModel = new EmfModel();
	        	familiesModel.setName("uml");
	        	familiesModel.setMetamodelFileBased(false);
	        	familiesModel.setMetamodelUri(SimpleumlPackage.eINSTANCE.getNsURI());
	        	familiesModel.setResource(new XMIResourceImpl());
	        	AccessMode.READ_ONLY.applyTo(familiesModel);
				familiesModel.getResource().getContents().clear();
				familiesModel.getResource().getContents().addAll(rootObjects);
				EmfModel personsModel = new EmfModel();
				personsModel.setName("rdbms");
				personsModel.setMetamodelFileBased(false);
				personsModel.setMetamodelUri(SimplerdbmsPackage.eINSTANCE.getNsURI());
				personsModel.setResource(new XMIResourceImpl());
	        	AccessMode.WRITE_ONLY.applyTo(personsModel);
				transformationLauncher.getContext().getModelRepository().addModel(personsModel);
				transformationLauncher.getContext().getModelRepository().addModel(familiesModel);
				matchLauncher.getContext().getModelRepository().addModel(familiesModel);
				matchLauncher.parse(eplfile);
				transformationLauncher.parse(etlfile);
				/*
				 * Execute
				 */
				logger.printf("%9d, ", 10*testSize);
				BigMDE2016CGTests.garbageCollect();
				long startTime = System.nanoTime();
				IModel matchModel = (IModel) matchLauncher.execute();
				matchModel.setName("Patterns");
				transformationLauncher.getContext().getModelRepository().addModel(matchModel);
				transformationLauncher.execute();
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
				Resource personsResource = personsModel.getResource();
				Collection<@NonNull EObject> rootObjects2 = personsResource.getContents();
				assert rootObjects2.size() == 9*testSize;
				/*
				 * Unload all models
				 */
				transformationLauncher.reset();
				transformationLauncher.getContext().getModelRepository().dispose();
				transformationLauncher.getContext().dispose();
	        }
		}
		finally {
			logger.dispose();
		}
	}

}
