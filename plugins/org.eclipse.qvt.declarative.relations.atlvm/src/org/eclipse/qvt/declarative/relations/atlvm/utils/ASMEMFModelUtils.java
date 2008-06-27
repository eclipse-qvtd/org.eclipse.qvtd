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
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.qvt.declarative.execution.LabelledModel;

/**
 * Utility class with conversion methods between EMF and ASMModel
 * 
 * @author Quentin Glineur
 */
public class ASMEMFModelUtils {

	/**
	 * Returns the EPackage of the EClass of first element in a given Resource
	 * 
	 * @param resource
	 * @return
	 */
	protected static EPackage getMetamodel(Resource resource) {
		EPackage result = null;
		List<EObject> contents = resource.getContents();
		if (contents.isEmpty())
			throw new IllegalArgumentException(
					"Cannot find metamodel of the empty resource: " + resource);
		result = resource.getContents().get(0).eClass().getEPackage();
		return result;
	}

	protected static String getManageableURI(String uri) {
		return "uri:" + uri; //$NON-NLS-1$
	}

	protected static String getManageableURI(EPackage ePackage) {
		return getManageableURI(ePackage.getNsURI());
	}

	/**
	 * Create an ASMEMFModel from a registered EPackage
	 * 
	 * @param ePackage
	 * @return the created ASMEMFModel
	 */
	public static ASMEMFModel getASMEMFModelFrom(EPackage ePackage, String alias) {

		String name = alias != null ? alias : ePackage.getName();

		try {
			ASMEMFModel result = ASMEMFModel.loadASMEMFModel(name, ASMEMFModel
					.createMOF(null), getManageableURI(ePackage), null);
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Trivial facility creating an ASMEMFModel from a non empty resource. The
	 * metamodel is guessed from the first element of the resource
	 * 
	 * @param resource
	 *            the resource to containing the model
	 * @param name
	 *            the wanted alias
	 * @return
	 * @throws Exception
	 */
	public static ASMEMFModel getASMEMFModelFrom(Resource resource, String name)
			throws Exception {
		resource.load(Collections.EMPTY_MAP);

		ASMEMFModel metamodel = getASMEMFModelFrom(getMetamodel(resource), null);
		return ASMEMFModel.loadASMEMFModel(name, metamodel, resource.getURI(),
				null);
	}

	/**
	 * Trivial method creating an ASMEMFModel wrapping a given resource.
	 * 
	 * @param resource
	 *            The EMF resource to wrap
	 * @param name
	 *            The model alias
	 * @param metamodel
	 *            The ASMEMFModel wrapping the metamodel
	 * @return The corresponding ASMEMFModel
	 * @throws Exception
	 */
	protected static ASMEMFModel getASMEMFModelFrom(Resource resource,
			String name, ASMEMFModel metamodel) throws Exception {
		return ASMEMFModel.loadASMEMFModel(name, metamodel, resource.getURI(),
				null);
	}

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
			resource.save(null);
			return resource;
		}

		Resource resource = ASMEMFModel.getResourceSet().getResource(fileURI,
				true);
		return resource;
	}

	protected static IFile getFileFrom(URI uri) throws Exception {
		String fileString = uri.toFileString();
		IPath filePath = new Path(fileString);
		IFile[] files = ResourcesPlugin.getWorkspace().getRoot()
				.findFilesForLocation(filePath);
		if (files.length > 0)
			return files[0];
		throw new Exception("Cannot find file from uri: " + uri);
	}

	protected static ASMEMFModel getASMEMFModelFromDynamicEcore(URI modelURI,
			String name) {
		Resource modelResource = ASMEMFModel.getResourceSet().getResource(
				modelURI, true);
		EPackage mainPackage = null;
		for (EObject object : modelResource.getContents()) {
			if (object instanceof EPackage) {
				EPackage ePackage = (EPackage) object;
				if (mainPackage == null) {
					mainPackage = ePackage;
				}
				String nsURI = ePackage.getNsURI();
				if (nsURI == null)
					throw new IllegalArgumentException(
							"Invalid metamodel with no NS URI:" + modelResource);
				ASMEMFModel.getResourceSet().getPackageRegistry().put(nsURI,
						ePackage);
			}
		}
		ASMEMFModel result = getASMEMFModelFrom(mainPackage, name);
		return result;
	}

	/**
	 * A utility method to build an ASMEMFModel from a LabelledModel
	 * 
	 * @param labelledModel
	 *            the labeled model from which to build the ASMEMFModel
	 * @param autoCreate
	 *            if set to true, the model will be created if it does not exist
	 * @return the associated ASMEMFModel
	 * @throws Exception
	 */
	public static ASMEMFModel getASMEMFModelFrom(LabelledModel labelledModel,
			boolean autoCreate) throws Exception {
		URI modelURI = URI.createURI(labelledModel.getAccessor());
		URI metamodelURI = URI.createURI(labelledModel.getMetamodel()
				.getAccessor());

		ASMEMFModel metamodel = null;
		String modelName = labelledModel.getName();
		String metamodelName = labelledModel.getMetamodel().getName();

		// load the metamodel if needed
		if (metamodelURI.isFile()) {
			metamodel = getASMEMFModelFromDynamicEcore(metamodelURI,
					labelledModel.getMetamodel().getName());
		} else {
			if (metamodelURI.toString().equals(EcorePackage.eNS_URI)) {
				metamodel = ASMEMFModel.createMOF(null);
			} else {
				metamodel = ASMEMFModel.loadASMEMFModel(metamodelName,
						ASMEMFModel.createMOF(null),
						getManageableURI(metamodelURI.toString()), null);
			}
		}

		if (modelURI.isFile()) {
			IFile modelFile = getFileFrom(modelURI);
			Resource modelResource = getResourceFrom(modelFile, autoCreate);
			ASMEMFModel result = getASMEMFModelFrom(modelResource, modelName,
					metamodel);
			result.setIsTarget(true);
			return result;
		}
		throw new Exception("Invalid model URI: " + modelURI);
	}

}
