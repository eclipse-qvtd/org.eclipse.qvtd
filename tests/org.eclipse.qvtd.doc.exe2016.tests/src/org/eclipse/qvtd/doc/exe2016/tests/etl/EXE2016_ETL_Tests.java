package org.eclipse.qvtd.doc.exe2016.tests.etl;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfModelFactory;
import org.eclipse.epsilon.emc.emf.EmfModelFactory.AccessMode;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.doc.exe2016.tests.AbstractEXE2016CGTests;
import org.eclipse.qvtd.doc.exe2016.tests.DoublyLinkedListGenerator;
import org.eclipse.qvtd.doc.exe2016.tests.PrintAndLog;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublylinkedlistPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EXE2016_ETL_Tests extends AbstractEXE2016CGTests
{
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
	public void testQVTcCompiler_Forward2Reverse_ETL() throws Exception {
		DoublyLinkedListGenerator doublyLinkedListGenerator = new DoublyLinkedListGenerator();
		PrintAndLog logger = new PrintAndLog(getName());
		logger.printf("%s\n", getName());
		/*
		 * Initializations
		 */
		try {
			int[] tests = PrintAndLog.getTestSizes();
			boolean isFirst = true;
			for (int testSize : tests) {
				if (isFirst) {
					isFirst = false;
					testSize = 500;		// Avoid Stack Overflow on warmup
				}
				EtlModule transformationLauncher = new EtlModule();
				EmfModelFactory modelFactory = EmfModelFactory.getInstance();
				String etlpath = "src/org/eclipse/qvtd/doc/exe2016/tests/etl/Forward2Reverse.etl";
				File file = new File(etlpath);
				transformationLauncher.parse(file);
				/*
				 * Load models
				 */
				EmfModel forwardListModel = new EmfModel();
				forwardListModel.setName("ForwardList");
				forwardListModel.setMetamodelFileBased(false);
				forwardListModel.setMetamodelUri(DoublylinkedlistPackage.eINSTANCE.getNsURI());
				forwardListModel.setResource(new XMIResourceImpl());
				AccessMode.READ_ONLY.applyTo(forwardListModel);
				Collection<@NonNull ? extends EObject> rootObjects = doublyLinkedListGenerator.createDoublyLinkedListModel(testSize);
				forwardListModel.getResource().getContents().clear();
				forwardListModel.getResource().getContents().addAll(rootObjects);
				//				file = new File("src/org/eclipse/qvtd/doc/bigmde2016/tests/atl/samples-Persons.xmi");
				//				EmfModel personsModel = modelFactory.createEmfModel("Persons", file, PersonsPackage.eINSTANCE, AccessMode.WRITE_ONLY);
				EmfModel reverseListModel = new EmfModel();
				reverseListModel.setName("ReverseList");
				reverseListModel.setMetamodelFileBased(false);
				reverseListModel.setMetamodelUri(DoublylinkedlistPackage.eINSTANCE.getNsURI());
				reverseListModel.setResource(new XMIResourceImpl());
				AccessMode.WRITE_ONLY.applyTo(reverseListModel);
				reverseListModel.setStoredOnDisposal(false);
				transformationLauncher.getContext().getModelRepository().addModel(forwardListModel);
				transformationLauncher.getContext().getModelRepository().addModel(reverseListModel);
				/*
				 * Execute
				 */
				logger.printf("%9d, ", testSize);
				garbageCollect();
				long startTime = System.nanoTime();
				transformationLauncher.execute();
				long endTime = System.nanoTime();

				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);

				Resource reverseListResource = reverseListModel.getResource();
				Collection<@NonNull EObject> rootObjects2 = reverseListResource.getContents();
				Iterator<@NonNull EObject> it = rootObjects2.iterator();
				Object rootObject = it.next();
				assert !it.hasNext();
				assert ((DoublyLinkedList)rootObject).getOwnedElements().size() == testSize-1;
				doublyLinkedListGenerator.checkModel((DoublyLinkedList) rootObject, testSize);
				/*
				 * Unload all models
				 */
				transformationLauncher.getContext().getModelRepository().dispose();
				transformationLauncher.getContext().dispose();
				transformationLauncher.reset();
			}
		}
		finally {
			logger.dispose();
		}
	}

}
