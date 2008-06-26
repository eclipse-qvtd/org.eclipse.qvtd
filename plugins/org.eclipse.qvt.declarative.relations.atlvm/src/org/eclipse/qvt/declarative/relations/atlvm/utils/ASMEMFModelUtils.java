package org.eclipse.qvt.declarative.relations.atlvm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.qvt.declarative.execution.LabelledModel;

public class ASMEMFModelUtils {

	/**
	 * Returns the EPackage of the EClass of first element in a given Resource
	 * 
	 * @param resource
	 * @return
	 */
	public static EPackage getMetamodel(Resource resource) {
		EPackage result = null;
		List<EObject> contents = resource.getContents();
		if (contents.isEmpty())
			throw new IllegalArgumentException(
					"Cannot find metamodel of the empty resource: " + resource);
		result = resource.getContents().get(0).eClass().getEPackage();
		return result;
	}

	public static String getManageableURI(EPackage ePackage) {
		return "uri:" + ePackage.getNsURI(); //$NON-NLS-1$
	}

	/**
	 * Create an ASMEMFModel from a registered EPackage
	 * 
	 * @param ePackage
	 * @return the created ASMEMFModel
	 */
	public static ASMEMFModel getASMEMFModelFrom(EPackage ePackage) {
		try {
			ASMEMFModel result = ASMEMFModel.loadASMEMFModel(
					ePackage.getName(), ASMEMFModel.createMOF(null),
					getManageableURI(ePackage), null);
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Create an ASMEMFModel from a resource whose metamodel is registered
	 * 
	 * @param resource
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public static ASMEMFModel getASMEMFModelFrom(Resource resource,
			String name, URI metamodelURI) throws Exception {
		resource.load(Collections.EMPTY_MAP);

		ASMEMFModel metamodel = metamodelURI == null ? getASMEMFModelFrom(getMetamodel(resource))
				: ASMEMFModel.newASMEMFModel(name, metamodelURI.toString(),
						ASMEMFModel.createMOF(null), null);
		return ASMEMFModel.loadASMEMFModel(name, metamodel, resource.getURI(),
				null);
	}

	// private static Resource getResourceFrom (URI uri) {
	// Resource resource = ASMEMFModel.getResourceSet().getResource(uri, true);
	// return resource;
	// }
	//

	// FIXME: getResource loadOnDemand
	protected static Resource getResourceFrom(IFile file, boolean autoCreate)
			throws IOException, CoreException {
		URI fileURI = URI.createFileURI(file.getLocation().toString());
		if (!file.exists() && autoCreate) {
			File newFile = file.getLocation().toFile();
			newFile.createNewFile();
			file.create(new FileInputStream(newFile), true, null);
			Resource resource = ASMEMFModel.getResourceSet().createResource(
					fileURI);
			// Map<String, Boolean> options = new HashMap<String, Boolean>();
			// options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
			resource.save(null);
			return resource;
		}

		Resource resource = ASMEMFModel.getResourceSet().getResource(fileURI,
				true);
		return resource;
	}

	// public static ASMEMFModel getASMEMFModelFrom (IFile file, String name)
	// throws Exception {
	// Resource resource = getResourceFrom(file);
	// return getASMEMFModelFrom(resource, name);
	// }

	protected static IFile getFileFrom(URI uri) throws Exception {
		String fileString = uri.toFileString();
		IPath filePath = new Path(fileString);
		IFile[] files = ResourcesPlugin.getWorkspace().getRoot()
				.findFilesForLocation(filePath);
		if (files.length > 0)
			return files[0];
		throw new Exception("Cannot find file from uri: " + uri);
	}

	// TODO implement
	public static ASMEMFModel getASMEMFModelFrom(LabelledModel namedModel,
			boolean autoCreate) throws Exception {
		URI modelURI = URI.createURI(namedModel.getAccessor());
		ASMEMFModel metamodel = null;
		String modelName = namedModel.getName();
		URI metamodelURI = URI.createURI(namedModel.getMetamodel()
				.getAccessor());

		// load the metamodel if needed
		if (metamodelURI != null) {
			Resource metamodelResource = ASMEMFModel.getResourceSet()
					.getResource(metamodelURI, true);
			for (EObject object : metamodelResource.getContents()) {
				if (object instanceof EPackage) {
					EPackage metamodelPackage = (EPackage) object;
					String metamodelNsURI = metamodelPackage.getNsURI();
					if (metamodelNsURI == null)
						throw new IllegalArgumentException(
								"Invalid metamodel with no NS URI:"
										+ metamodelResource);
					ASMEMFModel.getResourceSet().getPackageRegistry().put(
							metamodelNsURI, metamodelPackage);
				}
			}
			// metamodel =
			// ASMEMFModel.loadASMEMFModel(namedModel.getName()+"_MM",
			// ASMEMFModel.createMOF(null), namedModel.getMetamodel(), null);
		}

		if (modelURI.isFile()) {
			IFile modelFile = getFileFrom(modelURI);
			Resource modelResource = getResourceFrom(modelFile, autoCreate);
			return getASMEMFModelFrom(modelResource, modelName, metamodelURI);
		}
		throw new Exception("Invalid model URI: " + modelURI);
	}

}
