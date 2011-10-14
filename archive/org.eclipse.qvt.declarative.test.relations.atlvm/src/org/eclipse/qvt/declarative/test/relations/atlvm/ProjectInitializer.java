package org.eclipse.qvt.declarative.test.relations.atlvm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collections;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class ProjectInitializer {

	private static File testProject;
	private static File sourceFolder;
	private static File binFolder;
	private static File transformationFile;
	private static File umlMetamodelFile;
	private static File rdbmsMetamodelFile;
	private static File asmFile;
	private static Resource transformationResource;
	private static Resource umlModelResource;
	private static Resource rdbmsModelResource;
	private static File modelFolder;

	public static File getUmlMetamodelFile() {
		return umlMetamodelFile;
	}

	public static File getRdbmsMetamodelFile() {
		return rdbmsMetamodelFile;
	}

	public static Resource getTransformationResource() {
		return transformationResource;
	}

	public static File getModelFolder() {
		return modelFolder;
	}

	private static File umlModelFile;

	protected static Resource importEcoreFileToWorkspace(String pluginPath,
			File destinationFile, ResourceSet resourceSet) throws IOException {
		importToWorkspace(pluginPath, destinationFile);
		return resourceSet.createResource(URI.createURI(destinationFile.toURI()
				.toURL().toString()));
	}

	public static Resource getUmlModelResource() {
		return umlModelResource;
	}

	public static Resource getRdbmsModelResource() {
		return rdbmsModelResource;
	}

	protected static void importToWorkspace(String pluginPath,
			File destinationFile) throws IOException {
		URL fileURL = FileLocator.find(Activator.getDefault().getBundle(),
				new Path(pluginPath), Collections.EMPTY_MAP);
		if (!destinationFile.exists()) {
			destinationFile.createNewFile();
		}
		final byte[] buffer = new byte[8192];

		InputStream inputStream = fileURL.openStream();
		OutputStream outputStream = new FileOutputStream(destinationFile);
		int bytesRead = -1;
		while ((bytesRead = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outputStream.close();
	}

	public static File getFile(File folder, String fileName) {
		if (folder.isDirectory()) {
			File result = new File(folder.getPath().concat(File.separator)
					.concat(fileName));
			result.deleteOnExit();
			return result;
		}
		return null;
	}

	public static void createProject() {
		testProject = new File("test");
		if (!testProject.exists()) {
			testProject.mkdir();
		}
		sourceFolder = getFile(testProject, "src");
		if (!sourceFolder.exists()) {
			sourceFolder.mkdir();
		}
		binFolder = getFile(testProject, "bin");
		if (!binFolder.exists()) {
			binFolder.mkdir();
		}
		modelFolder = getFile(testProject, "model");
		if (!modelFolder.exists()) {
			modelFolder.mkdir();
		}
	}

	public static void addSources(ResourceSet testResourceSet)
			throws IOException, CoreException {
		transformationFile = getFile(sourceFolder, "transfo.xmi");
		transformationResource = importEcoreFileToWorkspace(
				"/resources/SimpleUMLtoRDBMS.eqvtrelation", transformationFile,
				testResourceSet);
		umlMetamodelFile = getFile(sourceFolder, "SimpleUml.ecore");
		umlModelResource = importEcoreFileToWorkspace(
				"/resources/SimpleUml.ecore", umlMetamodelFile, testResourceSet);
		rdbmsMetamodelFile = getFile(sourceFolder, "SimpleRdbms.ecore");
		rdbmsModelResource = importEcoreFileToWorkspace(
				"/resources/SimpleRdbms.ecore", rdbmsMetamodelFile,
				testResourceSet);
		transformationResource.load(Collections.EMPTY_MAP);
	}

	public static void addExecutable() {
		asmFile = getFile(binFolder, "transfo.rdbms.asm");
	}

	public static void addModels(ResourceSet resourceSet) throws IOException,
			CoreException {
		umlModelFile = getFile(modelFolder, "Package.xmi");
		umlModelResource = importEcoreFileToWorkspace("/resources/Package.xmi",
				umlModelFile, resourceSet);

	}

	public static File getTransformationFile() {
		return transformationFile;
	}

	public static File getUmlModelFile() {
		return umlMetamodelFile;
	}

	public static File getRdbmsModelFile() {
		return rdbmsMetamodelFile;
	}

	public static Object getAsmFile() {
		return asmFile;
	}

	public static File getTestProject() {
		return testProject;
	}

	public static File getSourceFolder() {
		return sourceFolder;
	}

	public static File getBinFolder() {
		return binFolder;
	}

}
