/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.bigmde2016.tests.etl;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfModelFactory;
import org.eclipse.epsilon.emc.emf.EmfModelFactory.AccessMode;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.execute.context.EtlContext;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.doc.bigmde2016.tests.FamiliesGenerator;
import org.eclipse.qvtd.doc.bigmde2016.tests.PrintAndLog;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.BigMDE2016CGTests;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.FamiliesPackage;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Persons.PersonsPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class BigMDE2016ETLTests extends TestCase {


	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	static class NullInputStream extends InputStream {
		static final NullInputStream INSTANCE = new NullInputStream();
		private NullInputStream() {}
		@Override
		public int read()      { return -1; }
		@Override
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
				EmfModelFactory zmodelFactory = EmfModelFactory.getInstance();
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
				//	transformationLauncher.reset(); -- following lines workaround Bug 538062/538065
				transformationLauncher.getImports().clear();
				transformationLauncher.getDeclaredOperations().clear();
				transformationLauncher.getOperations().clear();
				transformationLauncher.getDeclaredPost().clear();
				transformationLauncher.getDeclaredPre().clear();
				transformationLauncher.getPost().clear();
				transformationLauncher.getPre().clear();
				transformationLauncher.getDeclaredTransformationRules().clear();
				transformationLauncher.getTransformationRules().clear();
				transformationLauncher.setContext(new EtlContext());
				transformationLauncher.getContext().getModelRepository().dispose();
				transformationLauncher.getContext().dispose();
			}
		}
		finally {
			logger.dispose();
		}
	}
}
