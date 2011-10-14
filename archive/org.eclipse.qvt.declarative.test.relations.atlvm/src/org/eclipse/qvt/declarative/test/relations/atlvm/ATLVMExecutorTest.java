package org.eclipse.qvt.declarative.test.relations.atlvm;

import static org.junit.Assert.fail;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.qvt.declarative.execution.ExecutionContext;
import org.eclipse.qvt.declarative.execution.ExecutionContextFactory;
import org.eclipse.qvt.declarative.execution.LabelledModel;
import org.eclipse.qvt.declarative.execution.LabelledModelFactory;
import org.eclipse.qvt.declarative.execution.ExecutionContext.ExecutionMode;
import org.eclipse.qvt.declarative.relations.atlvm.ATLVMExecutor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ATLVMExecutorTest extends ATLVMExecutor {


	protected static File transformationFile;
	protected static File umlMetamodelFile;
	protected static File rdbmsMetamodelFile;
	protected static ResourceSet testResourceSet;
	protected static File umlModelFile;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			testResourceSet = new ResourceSetImpl();
			ProjectInitializer.createProject();
			ProjectInitializer.addSources(testResourceSet);
			ProjectInitializer.addExecutable();
			ProjectInitializer.addModels(testResourceSet);
			umlMetamodelFile = ProjectInitializer.getUmlMetamodelFile();
			umlModelFile = ProjectInitializer.getUmlModelFile();
			rdbmsMetamodelFile = ProjectInitializer.getRdbmsMetamodelFile();
			transformationFile = ProjectInitializer.getTransformationFile();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testProvides() {
		fail("Not yet implemented");
	}

	@Test
	public void testExecuteIFileExecutionContextOfURIIFolderIFolder()
			throws MalformedURLException {
		LabelledModel inputMetaModel = LabelledModelFactory.INSTANCE
				.createLabelledMetamodel("SimpleUML", umlMetamodelFile.toURI()
						.toString());
		LabelledModel inputModel = LabelledModelFactory.INSTANCE
				.createLabelledModel("uml", umlModelFile.toURI().toString(), inputMetaModel);

		List<LabelledModel> inputModels = new ArrayList<LabelledModel>();
		inputModels.add(inputModel);
		File outFile = ProjectInitializer.getFile(ProjectInitializer.getModelFolder(), "my.rdbms");
		outFile.deleteOnExit();
		
		LabelledModel outputMetaModel = LabelledModelFactory.INSTANCE
				.createLabelledMetamodel("SimpleRDBMS", rdbmsMetamodelFile.toURI().toString());
		LabelledModel outputModel = LabelledModelFactory.INSTANCE
				.createLabelledModel("rdbms", outFile.toURI().toString(), outputMetaModel);

		ExecutionContext parameters = ExecutionContextFactory.INSTANCE.createExecutionContext(inputModels,
				outputModel, ExecutionMode.enforcement);

		execute(transformationFile, parameters);
	}

	@Test
	public void testExecuteASMListOfASMEMFModelListOfASMMapOfStringStringDebugger() {
		fail("Not yet implemented");
	}

}
