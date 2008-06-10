package org.eclipse.qvt.declarative.test.relations.atlvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import junit.framework.Assert;

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
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.compilation.CompileOperation;
import org.eclipse.qvt.declarative.compilation.DeclarativeQVTCompilationException;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBaseFactory;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationFactory;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.relations.atlvm.ATLVMCompiler;
import org.junit.Test;

public class ATLVMCompilerTest extends ATLVMCompiler {

	protected IProject testProject;
	protected IFolder sourceFolder;
	protected IFolder buildFolder;
	protected IFile transformationFile;
	protected IFile umlModelFile;
	protected IFile rdbmsModelFile;
	protected ResourceSet testResourceSet;
	protected Resource workspaceAbstractSyntaxTree;

	protected Resource importEcoreFileToWorkspace(String pluginPath,
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

	protected Resource createResource(ResourceSet resourceSet, String pluginPath)
			throws URISyntaxException {
		URL astURL = FileLocator.find(Activator.getDefault().getBundle(),
				new Path(pluginPath), Collections.EMPTY_MAP);
		return resourceSet.createResource(URI.createURI(astURL.toURI()
				.toString()));
	}

	public ATLVMCompilerTest() {
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
			umlModelFile = sourceFolder.getFile("SimpleUml.ecore");
			rdbmsModelFile = sourceFolder.getFile("SimpleRdbms.ecore");

			buildFolder = testProject.getFolder("build");
			if (!buildFolder.exists()) {
				buildFolder.create(true, true, null);
			}
			testResourceSet = new ResourceSetImpl();

			workspaceAbstractSyntaxTree = importEcoreFileToWorkspace(
					"/resources/SimpleUMLtoRDBMS.eqvtrelation",
					transformationFile, testResourceSet);
			importEcoreFileToWorkspace("/resources/SimpleUml.ecore",
					umlModelFile, testResourceSet);
			importEcoreFileToWorkspace("/resources/SimpleRdbms.ecore",
					rdbmsModelFile, testResourceSet);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetPrefixURI() {
		Assert.assertTrue(getPrefixURI(sourceFolder).isPrefix());
		Assert.assertTrue(getPrefixURI(buildFolder).isPrefix());
	}

	@Test
	public void testGetDefaultExecutablePath() {
		String actual = getDefaultExecutablePath(workspaceAbstractSyntaxTree, "rdbms",
				sourceFolder, buildFolder);
		String expected = ResourcesPlugin.getWorkspace().getRoot()
				.getLocation().append(new Path("test/build/transfo.rdbms.asm"))
				.toOSString();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLoadQVTTransformation() throws Exception {
		URL astURL = FileLocator.find(Activator.getDefault().getBundle(),
				new Path("/resources/SimpleUMLtoRDBMS.eqvtrelation"),
				Collections.EMPTY_MAP);
		ResourceSet resourceSet = new ResourceSetImpl();

		Resource resource = resourceSet.createResource(URI.createURI(astURL
				.toURI().toString()));
		ASMEMFModel model = loadQVTTransformation(resource);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getName(),
				ATLVMCompiler.TRANSFORMATION_MODEL_NAME);
		Assert.assertEquals(((ASMEMFModel) model.getMetamodel()).getExtent(),
				QVTRelationPackage.eINSTANCE.eResource());
		Assert.assertFalse(model.getElementsByType("EObject").isEmpty());

	}

	@Test
	public void testCreateProblemModel() throws Exception {
		Assert.assertNotNull(createProblemModel(workspaceAbstractSyntaxTree));
	}

	@Test
	public void testCreateCompilationsProperties() {
		Map<String, String> parameters = new HashMap<String, String>();
		Properties result = createCompilationsProperties(
				workspaceAbstractSyntaxTree, parameters, "", sourceFolder,
				buildFolder);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.size() > 0);
	}

	@Test
	public void testCompileObjectMapOfStringStringIFolderIFolder()
			throws DeclarativeQVTCompilationException {
		Map<String, String> parameters = new HashMap<String, String>();

		try {
			compile("", parameters, sourceFolder, buildFolder);
			Assert.fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			compile(workspaceAbstractSyntaxTree, parameters, sourceFolder,
					buildFolder);
			Assert.fail();
		} catch (IllegalArgumentException e) {
		}
		parameters.put(ATLVMCompiler.DIRECTION_PARAMETER_NAME, "rdbms");
		List<IFile> actual = compile(workspaceAbstractSyntaxTree, parameters,
				sourceFolder, buildFolder);
		Assert.assertTrue(actual.get(0) instanceof IFile);
	}

	@Test
	public void testProvides() {
		Map<String, String> parameters = new HashMap<String, String>();
		Operation operation = new CompileOperation(workspaceAbstractSyntaxTree,
				parameters, sourceFolder, buildFolder);
		Assert.assertFalse(provides(operation));
		parameters.put(ATLVMCompiler.DIRECTION_PARAMETER_NAME, "toto");
		Assert.assertFalse(provides(operation));
		RelationalTransformation relationalTransformation = QVTRelationFactory.eINSTANCE
				.createRelationalTransformation();
		workspaceAbstractSyntaxTree.getContents().add(relationalTransformation);
		Assert.assertFalse(provides(operation));
		TypedModel typedModel = QVTBaseFactory.eINSTANCE.createTypedModel();
		typedModel.setName("toto");
		relationalTransformation.getModelParameter().add(typedModel);
		Assert.assertTrue(provides(operation));
	}

}
