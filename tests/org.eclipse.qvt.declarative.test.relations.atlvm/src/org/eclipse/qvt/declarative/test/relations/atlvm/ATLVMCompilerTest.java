package org.eclipse.qvt.declarative.test.relations.atlvm;

import java.io.File;
import java.io.FileInputStream;
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
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.compilation.CompileOperation;
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
	protected IFile testFile;
	protected ResourceSet testResourceSet;
	protected Resource workspaceAbstractSyntaxTree;
	protected Resource contentAbstractSyntaxTree;
	protected File file;

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
			testFile = sourceFolder.getFile("transfo.xmi");
			buildFolder = testProject.getFolder("build");
			if (!buildFolder.exists()) {
				buildFolder.create(true, true, null);
			}
			testResourceSet = new ResourceSetImpl();
			URL astURL = FileLocator.find(Activator.getDefault().getBundle(),
					new Path("/resources/SimpleUMLtoRDBMS.eqvtrelation"),
					Collections.EMPTY_MAP);
			if (!testFile.exists()) {
				file = new File(testFile.getLocationURI().toURL().getFile());
				file.createNewFile();
				testFile.create(new FileInputStream(file), true, null);
			}
			testFile.setContents(astURL.openStream(), false, false, null);
			ResourceSet resourceSet = new ResourceSetImpl();
			contentAbstractSyntaxTree = resourceSet.createResource(URI
					.createURI(astURL.toURI().toString()));
			workspaceAbstractSyntaxTree = testResourceSet.createResource(URI
					.createURI(testFile.getLocationURI().toString()));
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
		String actual = getDefaultExecutablePath(workspaceAbstractSyntaxTree,
				sourceFolder, buildFolder);
		String expected = ResourcesPlugin.getWorkspace().getRoot()
				.getLocationURI().toString()
				+ "/test/build/transfo.asm";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLoadQVTTransformation() {
		URL astURL = FileLocator.find(Activator.getDefault().getBundle(),
				new Path("/resources/SimpleUMLtoRDBMS.eqvtrelation"),
				Collections.EMPTY_MAP);
		ResourceSet resourceSet = new ResourceSetImpl();
		try {
			Resource resource = resourceSet.createResource(URI.createURI(astURL
					.toURI().toString()));
			ASMEMFModel model = loadQVTTransformation(resource);
			Assert.assertNotNull(model);
			Assert.assertEquals(model.getName(),
					ATLVMCompiler.TRANSFORMATION_MODEL_NAME);
			Assert.assertEquals(((ASMEMFModel) model.getMetamodel())
					.getExtent(), QVTRelationPackage.eINSTANCE.eResource());
			Assert.assertFalse(model.getElementsByType("EObject").isEmpty());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testCreateProblemModel() {
		try {
			Assert
					.assertNotNull(createProblemModel(workspaceAbstractSyntaxTree));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testCreateCompilationsProperties() {
		Map<String, String> parameters = new HashMap<String, String>();
		Properties result = createCompilationsProperties(
				workspaceAbstractSyntaxTree, parameters, sourceFolder,
				buildFolder);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.size() > 0);
	}

	@Test
	public void testCompileObjectMapOfStringStringIFolderIFolder() {
		Map<String, String> parameters = new HashMap<String, String>();

		// try {
		// compile("", parameters, sourceFolder, buildFolder);
		// Assert.fail();
		// } catch (IllegalArgumentException e) {}
		// try {
		// compile(contentAbstractSyntaxTree, parameters, sourceFolder,
		// buildFolder);
		// Assert.fail();
		// } catch (IllegalArgumentException e) {}
		parameters.put(ATLVMCompiler.DIRECTION_PARAMETER_NAME, "SimpleRDBMS");
		List<IFile> actual = compile(workspaceAbstractSyntaxTree, parameters,
				sourceFolder, buildFolder);
		Assert.assertFalse(actual.isEmpty());
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

	@Test
	public void testCompileASMEMFModelASMASMEMFModelDebuggerProperties() {
		Assert.fail("Not yet implemented");
	}

}
