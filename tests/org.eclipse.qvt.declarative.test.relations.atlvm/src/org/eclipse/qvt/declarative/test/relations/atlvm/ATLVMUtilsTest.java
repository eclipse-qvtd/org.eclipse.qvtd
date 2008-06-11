package org.eclipse.qvt.declarative.test.relations.atlvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage;
import org.eclipse.qvt.declarative.relations.atlvm.utils.ASMEMFModelUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ATLVMUtilsTest {

	protected static IProject testProject;
	protected static IFolder sourceFolder;
	protected static IFolder buildFolder;
	protected static IFile transformationFile;
	protected static IFile umlModelFile;
	protected static IFile rdbmsModelFile;
	protected static ResourceSet testResourceSet;
	protected static Resource workspaceAbstractSyntaxTree;

	protected static Resource importEcoreFileToWorkspace(String pluginPath,
			IFile workspaceFile, ResourceSet resourceSet) throws IOException,
			CoreException {
		File file;
		URL astURL = FileLocator.find(Activator.getDefault().getBundle(),
				new Path(pluginPath), Collections.EMPTY_MAP);
		if (!workspaceFile.exists()) {
			file = workspaceFile.getLocation().toFile();
			file.createNewFile();
			workspaceFile.create(new FileInputStream(file), true, null);
		}
		workspaceFile.setContents(astURL.openStream(), false, false, null);
		return resourceSet.createResource(URI.createURI(workspaceFile
				.getLocationURI().toURL().toString()));
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
		umlModelFile = sourceFolder.getFile("SimpleUml.ecore");
		rdbmsModelFile = sourceFolder.getFile("SimpleRdbms.ecore");

		buildFolder = testProject.getFolder("build");
		if (!buildFolder.exists()) {
			buildFolder.create(true, true, null);
		}
		testResourceSet = new ResourceSetImpl();

		workspaceAbstractSyntaxTree = importEcoreFileToWorkspace(
				"/resources/SimpleUMLtoRDBMS.eqvtrelation", transformationFile,
				testResourceSet);
		importEcoreFileToWorkspace("/resources/SimpleUml.ecore", umlModelFile,
				testResourceSet);
		importEcoreFileToWorkspace("/resources/SimpleRdbms.ecore",
				rdbmsModelFile, testResourceSet);

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
	public void testGetASMEMFModelFromEPackage() {
		EPackage package1 = QVTRelationPackage.eINSTANCE;
		ASMEMFModel model = ASMEMFModelUtils.getASMEMFModelFrom(package1);
		Assert.assertEquals(model.getName(), "QVTRelation");
		Assert.assertEquals(model.getExtent().getURI().toString(),
				QVTRelationPackage.eNS_URI);
	}

	@Test
	public void testGetASMEMFModelFromResourceString() throws Exception {
		ASMEMFModel model = ASMEMFModelUtils.getASMEMFModelFrom(
				workspaceAbstractSyntaxTree, "uml2Rdbms");
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getName(), "uml2Rdbms");
		Assert.assertEquals(model.getMetamodel().getName(), "QVTRelation");
	}

	@Test
	public void testGetASMEMFModelFromIFileString() throws Exception {
		ASMEMFModel model = ASMEMFModelUtils.getASMEMFModelFrom(
				transformationFile, "uml2Rdbms");
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getName(), "uml2Rdbms");
		Assert.assertEquals(model.getMetamodel().getName(), "QVTRelation");
	}

}
