package org.eclipse.qvtd.doc.bigmde2016.tests.etl;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfModelFactory;
import org.eclipse.epsilon.emc.emf.EmfModelFactory.AccessMode;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.doc.bigmde2016.tests.FamiliesGenerator;
import org.eclipse.qvtd.doc.bigmde2016.tests.PrintAndLog;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.BigMDE2016CGTests;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families.FamiliesPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Persons.PersonsPackage;
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
		EtlModule transformationLauncher = new EtlModule();
		EmfModelFactory modelFactory = EmfModelFactory.getInstance();
		String etlpath = "src/org/eclipse/qvtd/doc/bigmde2016/tests/etl/Families2Persons.etl";
		File file = new File(etlpath);
		transformationLauncher.parse(file);
		try {
	        int[] tests = PrintAndLog.getTestSizes();
	        for (int testSize : tests) {
	    		/*
	    		 * Load models
	    		 */
	        	file = new File("src/org/eclipse/qvtd/doc/bigmde2016/tests/atl/samples-Families.xmi");
	        	EmfModel familiesModel = modelFactory.loadEmfModel("Families", file, FamiliesPackage.eINSTANCE, AccessMode.READ_ONLY);
	    		Collection<@NonNull ? extends EObject> rootObjects = FamiliesGenerator.createFamiliesModel(testSize, 9);
				familiesModel.getResource().getContents().clear();
				familiesModel.getResource().getContents().addAll(rootObjects);
				file = new File("src/org/eclipse/qvtd/doc/bigmde2016/tests/atl/samples-Persosns.xmi");
				EmfModel personsModel = modelFactory.createEmfModel("Persons", file, PersonsPackage.eINSTANCE, AccessMode.WRITE_ONLY);
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

}
