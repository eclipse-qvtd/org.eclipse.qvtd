package org.eclipse.qvt.declarative.test.relations.atlvm;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.qvt.declarative.execution.ExecutionContext;
import org.eclipse.qvt.declarative.execution.ExecutionContextImpl;
import org.eclipse.qvt.declarative.execution.LabelledModel;
import org.eclipse.qvt.declarative.execution.LabelledModelFactory;
import org.eclipse.qvt.declarative.execution.ExecutionContextImpl.ExecutionMode;
import org.eclipse.qvt.declarative.relations.atlvm.ATLVMExecutor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ATLVMExecutorTest extends ATLVMExecutor {

	protected static IProject testProject;
	protected static IFolder sourceFolder;
	protected static IFolder buildFolder;
	protected static IFolder modelFolder;
	protected static IFile transformationFile;
	protected static IFile umlMetamodelFile;
	protected static IFile rdbmsMetamodelFile;
	protected static ResourceSet testResourceSet;
	protected static Resource workspaceAbstractSyntaxTree;
	protected static IFile asmFile;
	protected static IFile umlModel;
	protected static IFile rdbmsModel;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			testProject = ResourcesPlugin.getWorkspace().getRoot().getProject(
					"test");
			if (!testProject.exists()) {
				testProject.create(null);
			}
			testProject.open(null);
			sourceFolder = testProject.getFolder("src");
			if (!sourceFolder.exists()) {
				sourceFolder.create(true, true, null);
			}
			transformationFile = sourceFolder.getFile("transfo.xmi");
			umlMetamodelFile = sourceFolder.getFile("SimpleUml.ecore");
			rdbmsMetamodelFile = sourceFolder.getFile("SimpleRdbms.ecore");

			buildFolder = testProject.getFolder("build");
			if (!buildFolder.exists()) {
				buildFolder.create(true, true, null);
			}
			asmFile = buildFolder.getFile("transfo.rdbms.asm");
			setWorkspaceFileContent("/resources/transfo.rdbms.asm", asmFile);

			modelFolder = testProject.getFolder("models");
			if (!modelFolder.exists()) {
				modelFolder.create(true, true, null);
			}
			umlModel = modelFolder.getFile("Package.xmi");
			setWorkspaceFileContent("/resources/Package.xmi", umlModel);

			testResourceSet = new ResourceSetImpl();

			workspaceAbstractSyntaxTree = importEcoreFileToWorkspace(
					"/resources/SimpleUMLtoRDBMS.eqvtrelation",
					transformationFile, testResourceSet);
			importEcoreFileToWorkspace("/resources/SimpleUml.ecore",
					umlMetamodelFile, testResourceSet);
			importEcoreFileToWorkspace("/resources/SimpleRdbms.ecore",
					rdbmsMetamodelFile, testResourceSet);

			workspaceAbstractSyntaxTree.load(Collections.EMPTY_MAP);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static Resource importEcoreFileToWorkspace(String pluginPath,
			IFile workspaceFile, ResourceSet resourceSet) throws IOException,
			CoreException {
		setWorkspaceFileContent(pluginPath, workspaceFile);
		return resourceSet.createResource(URI.createURI(workspaceFile
				.getLocationURI().toURL().toString()));
	}

	protected static void setWorkspaceFileContent(String pluginPath,
			IFile workspaceFile) throws IOException, CoreException {
		File file;
		URL fileURL = FileLocator.find(Activator.getDefault().getBundle(),
				new Path(pluginPath), Collections.EMPTY_MAP);
		if (!workspaceFile.exists()) {
			file = workspaceFile.getLocation().toFile();
			file.createNewFile();
			workspaceFile.create(new FileInputStream(file), true, null);
		}
		workspaceFile.setContents(fileURL.openStream(), false, false, null);
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
				.createLabelledMetamodel("SimpleUML", umlMetamodelFile
						.getLocationURI().toString());
		LabelledModel inputModel = LabelledModelFactory.INSTANCE
				.createLabelledModel("uml", umlModel.getLocationURI()
						.toString(), inputMetaModel);

		List<LabelledModel> inputModels = new ArrayList<LabelledModel>();
		inputModels.add(inputModel);
		IFile outFile = modelFolder.getFile("my.rdbms");

		LabelledModel outputMetaModel = LabelledModelFactory.INSTANCE
				.createLabelledMetamodel("SimpleRDBMS", rdbmsMetamodelFile
						.getLocationURI().toString());
		LabelledModel outputModel = LabelledModelFactory.INSTANCE
				.createLabelledModel("rdbms", outFile.getLocationURI()
						.toString(), outputMetaModel);

		ExecutionContext parameters = new ExecutionContextImpl(inputModels,
				outputModel, ExecutionMode.enforcement);

		execute(transformationFile, parameters, sourceFolder, buildFolder);
	}

	@Test
	public void testExecuteASMListOfASMEMFModelListOfASMMapOfStringStringDebugger() {
		fail("Not yet implemented");
	}

}
