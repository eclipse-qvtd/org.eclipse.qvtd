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
import org.eclipse.qvt.declarative.execution.LabelledModel;
import org.eclipse.qvt.declarative.execution.LabelledModelFactory;
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
	protected static IFile umlMetamodelFile;
	protected static IFile unknownFile;
	protected static IFile rdbmsMetamodelFile;
	protected static ResourceSet testResourceSet;
	protected static Resource workspaceAbstractSyntaxTree;
	protected static Resource unknownResource;
	protected static Resource umlMetamodelResource;

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
		umlMetamodelFile = sourceFolder.getFile("SimpleUml.ecore");
		rdbmsMetamodelFile = sourceFolder.getFile("SimpleRdbms.ecore");
		unknownFile = sourceFolder.getFile("My.simpleuml");

		buildFolder = testProject.getFolder("build");
		if (!buildFolder.exists()) {
			buildFolder.create(true, true, null);
		}
		testResourceSet = new ResourceSetImpl();

		workspaceAbstractSyntaxTree = importEcoreFileToWorkspace(
				"/resources/SimpleUMLtoRDBMS.eqvtrelation", transformationFile,
				testResourceSet);
		umlMetamodelResource = importEcoreFileToWorkspace(
				"/resources/SimpleUml.ecore", umlMetamodelFile, testResourceSet);
		importEcoreFileToWorkspace("/resources/SimpleRdbms.ecore",
				rdbmsMetamodelFile, testResourceSet);
		unknownResource = importEcoreFileToWorkspace("/resources/My.simpleuml",
				unknownFile, testResourceSet);

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
		ASMEMFModel model = ASMEMFModelUtils.getASMEMFModelFrom(package1, null);
		Assert.assertEquals(model.getName(), "QVTRelation");
		Assert.assertEquals(model.getExtent().getURI().toString(),
				QVTRelationPackage.eNS_URI);
	}

	@Test
	public void testgetASMEMFModelFromLabeledModelBoolean() throws Exception {
		LabelledModel namedMetamodel = LabelledModelFactory.INSTANCE
				.createLabelledMetamodel("QVTR", QVTRelationPackage.eNS_URI);
		LabelledModel namedModel = LabelledModelFactory.INSTANCE
				.createLabelledModel("uml2rdbms", workspaceAbstractSyntaxTree
						.getURI().toString(), namedMetamodel);

		ASMEMFModel model = ASMEMFModelUtils.getASMEMFModelFrom(namedModel,
				false);
		Assert.assertNotNull(model);
		Assert.assertEquals("uml2rdbms", model.getName());
		Assert.assertEquals("QVTR", model.getMetamodel().getName());
		Assert.assertEquals(QVTRelationPackage.eINSTANCE.eResource(),
				((ASMEMFModel) model.getMetamodel()).getExtent());
	
		namedMetamodel = LabelledModelFactory.INSTANCE.createLabelledMetamodel("SimpleUML", umlMetamodelResource.getURI().toString());
		namedModel = LabelledModelFactory.INSTANCE.createLabelledModel("aliasUML", unknownResource.getURI().toString(), namedMetamodel);
		model = ASMEMFModelUtils.getASMEMFModelFrom(namedModel, false);
		Assert.assertNotNull(model);
		Assert.assertEquals("aliasUML", model.getName());
		Assert.assertEquals("SimpleUML", model.getMetamodel().getName());
		Assert.assertEquals(umlMetamodelResource.getURI(),((ASMEMFModel) model.getMetamodel()).getExtent().getURI());
		Assert.assertTrue(model.getElementsByType("EObject").size() > 0);
	}

}
