package org.eclipse.qvt.declarative.test.relations.atlvm;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import junit.framework.Assert;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.compilation.CompileOperation;
import org.eclipse.qvt.declarative.compilation.DeclarativeQVTCompilationException;
import org.eclipse.qvt.declarative.relations.atlvm.ATLVMCompiler;
import org.junit.BeforeClass;
import org.junit.Test;

public class ATLVMCompilerTest extends ATLVMCompiler {

	protected static List<File> sourceFolders;
	protected static File binFolder;
	protected static File transformationFile;

	protected static ResourceSet testResourceSet;
	protected static Resource transformationResource;

	@BeforeClass
	public static void setUpBeforeClass() {
		try {
			testResourceSet = new ResourceSetImpl();
			ProjectInitializer.createProject();
			ProjectInitializer.addSources(testResourceSet);
			transformationResource = ProjectInitializer
					.getTransformationResource();
			sourceFolders = Collections.singletonList(ProjectInitializer.getSourceFolder());
			binFolder = ProjectInitializer.getBinFolder();
			transformationFile = ProjectInitializer.getTransformationFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateProblemModel() throws Exception {
		Assert.assertNotNull(createProblemModelFor(transformationResource));
	}

	@Test
	public void testCreateCompilationsProperties() {
		Map<String, String> parameters = new HashMap<String, String>();
		URI binFolderURI = URI.createFileURI(binFolder.getAbsolutePath());
		Properties result = createCompilationsProperties(transformationResource
				.getURI(), parameters, "", binFolderURI);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.size() > 0);
	}

	@Test
	public void testCompileObjectMapOfStringStringIFolderIFolder()
			throws DeclarativeQVTCompilationException {
		Map<String, String> parameters = new HashMap<String, String>();

		try {
			compile("", parameters, sourceFolders, binFolder);
			Assert.fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			compile(transformationResource, parameters, sourceFolders, binFolder);
			Assert.fail();
		} catch (IllegalArgumentException e) {
		}
		parameters.put(ATLVMCompiler.DIRECTION_PARAMETER_NAME, "rdbms");
		List<File> actual = compile(transformationFile, parameters,
				sourceFolders, binFolder);
		Assert.assertFalse(actual.isEmpty());
		Assert.assertTrue(actual.get(0) instanceof File);
	}

	@Test
	public void testProvides() {
		Map<String, String> parameters = new HashMap<String, String>();
		Operation operation = new CompileOperation("",
				parameters, sourceFolders, binFolder);
		Assert.assertFalse(provides(operation));
		operation = new CompileOperation(transformationFile,
				parameters, sourceFolders, binFolder);
		Assert.assertTrue(provides(operation));
	}

}
