package org.eclipse.qvt.declarative.test.relations.atlvm;

import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import junit.framework.Assert;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.compilation.CompileOperation;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBaseFactory;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationFactory;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.relations.atlvm.ATLVMCompiler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ATLVMCompilerTest extends ATLVMCompiler {

	protected IProject testProject;
	protected IFolder sourceFolder;
	protected IFolder buildFolder;
	protected IFile testFile;
	protected ResourceSet testResourceSet;
	protected Resource abstractSyntaxTree;

	@Before
	public void setUp() throws Exception {
		testProject = ResourcesPlugin.getWorkspace().getRoot().getProject(
				"test");
		testProject.create(null);
		testProject.open(null);
		sourceFolder = testProject.getFolder("src");
		sourceFolder.create(true, true, null);
		testFile = sourceFolder.getFile("transfo.xmi");
		// testFile.create(new FileInputStream(new
		// File(testFile.getLocation().toOSString())), true, null);
		buildFolder = testProject.getFolder("build");
		buildFolder.create(true, false, null);
		testResourceSet = new ResourceSetImpl();
		abstractSyntaxTree = testResourceSet.createResource(URI
				.createURI(testFile.getLocationURI().toString()));
	}

	@After
	public void tearDown() throws Exception {
		abstractSyntaxTree.delete(Collections.EMPTY_MAP);
		testResourceSet = null;
		buildFolder.delete(false, null);
		testFile.delete(true, null);
		sourceFolder.delete(false, null);
		testProject.delete(true, false, null);
	}

	@Test
	public void testGetPrefixURI() {
		Assert.assertTrue(getPrefixURI(sourceFolder).isPrefix());
		Assert.assertTrue(getPrefixURI(buildFolder).isPrefix());
	}

	@Test
	public void testGetDefaultExecutablePath() {
		String actual = getDefaultExecutablePath(abstractSyntaxTree,
				sourceFolder, buildFolder);
		String expected = ResourcesPlugin.getWorkspace().getRoot()
				.getLocationURI().toString()
				+ "/test/build/transfo.asm";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLoadQVTTransformation() {
		RelationalTransformation relationalTransformation = QVTRelationFactory.eINSTANCE
				.createRelationalTransformation();
		abstractSyntaxTree.getContents().add(relationalTransformation);
		TypedModel typedModel = QVTBaseFactory.eINSTANCE.createTypedModel();
		typedModel.setName("toto");
		relationalTransformation.getModelParameter().add(typedModel);
		try {
			Assert.assertNotNull(loadQVTTransformation(abstractSyntaxTree));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testCreateProblemModel() {
		try {
			Assert.assertNotNull(createProblemModel(abstractSyntaxTree));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testCreateCompilationsProperties() {
		Map<String, String> parameters = new HashMap<String, String>();
		Properties result = createCompilationsProperties(abstractSyntaxTree,
				parameters, sourceFolder, buildFolder);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.size() > 0);
	}

	@Test
	public void testCompileObjectMapOfStringStringIFolderIFolder() {
		fail("Not yet implemented");
	}

	@Test
	public void testProvides() {
		Map<String, String> parameters = new HashMap<String, String>();
		Operation operation = new CompileOperation(abstractSyntaxTree,
				parameters, sourceFolder, buildFolder);
		Assert.assertFalse(provides(operation));
		parameters.put(ATLVMCompiler.DIRECTION_PARAMETER_NAME, "toto");
		Assert.assertFalse(provides(operation));
		RelationalTransformation relationalTransformation = QVTRelationFactory.eINSTANCE
				.createRelationalTransformation();
		abstractSyntaxTree.getContents().add(relationalTransformation);
		Assert.assertFalse(provides(operation));
		TypedModel typedModel = QVTBaseFactory.eINSTANCE.createTypedModel();
		typedModel.setName("toto");
		relationalTransformation.getModelParameter().add(typedModel);
		Assert.assertTrue(provides(operation));
	}

	@Test
	public void testCompileASMEMFModelASMASMEMFModelDebuggerProperties() {
		fail("Not yet implemented");
	}

}
