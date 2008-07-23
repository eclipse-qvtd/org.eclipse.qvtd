/*******************************************************************************
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.importer.roseuml.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EMOFResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.qvt.declarative.importer.roseuml.RoseUMLImporterPlugin;

/**
 * PackageManager provides facilities top save a list of packages in EMOF and Ecore,
 * using one resource per package, all packages in a single resource and all package
 * contents flattened into a single package in a single resource. 
 */
public class PackageManager
{   
	/**
	 * SharedIdHierarchicalENamedElementIdCreator allocates xmi:id's re-using entries from an
	 * EObject to xmi:id map where possible, creating hierarchical names where necessary.
	 */
	public static class SharedIdHierarchicalENamedElementIdCreator extends
			XMIUtils.HierachicalENamedElementIdCreator
	{
		private final Map<EObject, String> idMap;

		private SharedIdHierarchicalENamedElementIdCreator(Map<EObject, String> idMap) {
			this.idMap = idMap;
		}

		@Override public String createId(EObject object, Set<String> knownIds) {
			String id = idMap.get(object);
			if (id == null) {
				id = super.createId(object, knownIds);
				if (id != null) {
					idMap.put(object, id);
				}
			}
			return id;
		}
	}

	protected final Resource.Factory emofFactory = new EMOFResourceFactoryImpl();
	protected final Resource.Factory ecoreFactory = new XMIResourceFactoryImpl();
	private final IProject project;
	private final IPath modelPath ;
	private final String modelStem;
	private IPath ecorePath;
	private IPath emofPath;
	private String ecoreExtension;
	private String emofExtension;
	private ResourceSet resourceSet = null;
	private Map<EObject, String> idMap = null;
	
	public PackageManager(IFile modelFile) {
        this.project = modelFile.getProject();
        IPath path = modelFile.getProjectRelativePath();
        modelPath = path.removeLastSegments(1);
        modelStem = path.removeFileExtension().lastSegment();
        setEcorePath("ecore");
        setEMOFPath("emof");
        setEcoreExtension("ecore");
        setEMOFExtension("xml");
	}
	
	/**
	 * Create an XMLResource at path within the current project, and prepare to save
	 * ePackages therein, by sorting packages, classifiers, structural features
	 * and operations into alphabetical order and assigning each a hierrachical xmi:id
	 * re-using xmi:ids from idMap wherever possible.
	 * 
	 * @param ePackages
	 * @param path
	 * @return the resource
	 */
	protected XMLResource createResource(List<EPackage> ePackages, IPath path) {
		IFile file = project.getFile(path);
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		XMLResource resource = (XMLResource) getResourceSet().createResource(uri);
		if (resource == null)
			return null;
		for (EPackage ePackage : ePackages) {
			resource.getContents().add(ePackage);
			Utils.sort(ePackage.getEClassifiers());
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					Utils.sort(((EClass) eClassifier).getEStructuralFeatures());
					Utils.sort(((EClass) eClassifier).getEOperations());
				}
			}
		}
		XMIUtils.IdFilter idFilter = new XMIUtils.IdFilter()
		{
			public boolean createId(EObject object) {
				if (object == null)
					return false;
				if (object.eClass() == EcorePackage.Literals.EANNOTATION)
					return false;
				if (object.eClass() == EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY)
					return false;
				return true;
			}
		};
		XMIUtils.assignIds(resource, new SharedIdHierarchicalENamedElementIdCreator(getXMIidMap()), idFilter);
		return resource;
	}

	public String getEMOFExtension() {
		return emofExtension;
	}

	public IPath getEMOFPath() {
		return emofPath;
	}

	public String getEcoreExtension() {
		return ecoreExtension;
	}

	public IPath getEcorePath() {
		return ecorePath;
	}

	public ResourceSet getResourceSet() {
    	if (resourceSet == null)
            setResourceSet(new ResourceSetImpl());
		return resourceSet;
	}

	public Map<EObject, String> getXMIidMap() {
        if (idMap == null)
        	setXMIidMap(new HashMap<EObject, String>());   		
		return idMap;
	}
    
	/**
	 * Save all ePackages in Ecore an EMOF format to a separate file for each package,
	 * named as 
	 * @param ePackages
	 * @param midFix
	 */
    public void save(IProgressMonitor monitor, List<EPackage> ePackages, String midFix) {
    	//
        //	Save all the packages to a composite file.
        //
        if (ePackages.size() > 1) {
            saveAsEcore(monitor, ePackages, modelStem + midFix + "." + ecoreExtension);
            saveAsEMOF(monitor, ePackages, modelStem + midFix + "." + emofExtension);
        }
        //
        //	Save the packages one by one to individual files.
        //
		if (monitor.isCanceled())
			return;
        if (ecorePath != null) {
	    	List<XMLResource> ecoreResources = new ArrayList<XMLResource>();
	    	getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", ecoreFactory);
	        for (EPackage ePackage : ePackages) {
	        	List<EPackage> saveList = new ArrayList<EPackage>();
	        	saveList.add(ePackage);
	        	ecoreResources.add(createResource(saveList, ecorePath.append(ePackage.getName() + midFix + "." + ecoreExtension)));
	        }
	        for (XMLResource resource : ecoreResources)
	        	saveResource(monitor, resource);
        }
		if (monitor.isCanceled())
			return;
        if (emofPath != null) {
	    	List<XMLResource> emofResources = new ArrayList<XMLResource>();
	    	getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", emofFactory);
	        for (EPackage ePackage : ePackages) {
	        	List<EPackage> saveList = new ArrayList<EPackage>();
	        	saveList.add(ePackage);
	        	emofResources.add(createResource(saveList, emofPath.append(ePackage.getName() + midFix + "." + emofExtension)));
	        }
	        for (XMLResource resource : emofResources)
	        	saveResource(monitor, resource);
        }
        //
        //	Create a package containing the contents of all packages and save it to a flattened file.
        //
		if (monitor.isCanceled())
			return;
        if (ePackages.size() > 1)
        	saveAsFlatPackage(monitor, ePackages, midFix);
     }

    /**
     * Save the ePackages as an EMOF file named fileName on the emofPath, creating/re-using
     * xmi:id's in/from idMap.
     * 
     * @param ePackages to save
     * @param fileName to save to
     */
	protected void saveAsEMOF(IProgressMonitor monitor, List<EPackage> ePackages, String fileName) {
		if (monitor.isCanceled())
			return;
		if (emofPath != null) {
			getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", emofFactory);
		    XMLResource emofResource = createResource(ePackages, emofPath.append(fileName));
		    saveResource(monitor, emofResource);
		}
	}

    /**
     * Save the ePackages as an Ecore file named fileName on the ecorePath, creating/re-using
     * xmi:id's in/from idMap.
     * 
     * @param ePackages to save
     * @param fileName to save to
     */
    protected void saveAsEcore(IProgressMonitor monitor, List<EPackage> ePackages, String fileName) {
		if (monitor.isCanceled())
			return;
		if (ecorePath != null) {
			getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", ecoreFactory);
		    XMLResource ecoreResource = createResource(ePackages, ecorePath.append(fileName));
		    saveResource(monitor, ecoreResource);
		}
	}

    /**
     * Save the contents of all ePackages in a single flattened package named as the modeltem followed
     * by midFix, sharing xmi:ids via idMap.
     * 
     * @param ePackages to save
     * @param midFix middle section of file name
     */
	protected void saveAsFlatPackage(IProgressMonitor monitor, List<EPackage> ePackages, String midFix) {
		//
		//	Save the incoming package contents
		//
		Map<EPackage, List<EAnnotation>> oldAnnotations = new HashMap<EPackage, List<EAnnotation>>();
		Map<EPackage, List<EClassifier>> oldClassifiers = new HashMap<EPackage, List<EClassifier>>();
		Map<EPackage, List<EPackage>> oldSubpackages = new HashMap<EPackage, List<EPackage>>();
		for (EPackage ePackage : ePackages) {
			oldAnnotations.put(ePackage, new ArrayList<EAnnotation>(ePackage.getEAnnotations()));
			oldClassifiers.put(ePackage, new ArrayList<EClassifier>(ePackage.getEClassifiers()));
			oldSubpackages.put(ePackage, new ArrayList<EPackage>(ePackage.getESubpackages()));
		}
		//
		//	Create a Flat package to receive all contents
		//
		String name = "Flat" + modelStem;
		String nsURI = ePackages.get(ePackages.size()-1).getNsURI();
		IPath nsPath = new Path(nsURI);
		nsPath = nsPath.removeLastSegments(1).append(name.toLowerCase() + ".xml");
		EPackage flatPackage = EcoreFactory.eINSTANCE.createEPackage();
		flatPackage.setName(name);
		flatPackage.setNsURI(nsPath.toString());
		flatPackage.setNsPrefix(name.toLowerCase());
		//
		//	Move all contents into the Flat package
		//
		for (EPackage ePackage : ePackages) {
			flatPackage.getEAnnotations().addAll(ePackage.getEAnnotations());
			flatPackage.getEClassifiers().addAll(ePackage.getEClassifiers());
			flatPackage.getESubpackages().addAll(ePackage.getESubpackages());
		}
		//
		//	Save the Flat package
		//
		List<EPackage> saveList = new ArrayList<EPackage>();
		saveList.add(flatPackage);
		saveAsEcore(monitor, saveList, name + midFix + "." + ecoreExtension);
		saveAsEMOF(monitor, saveList, name + midFix + "." + emofExtension);
		//
		//	Restore the incoming package contents
		//
		for (EPackage ePackage : ePackages) {
			ePackage.getEAnnotations().addAll(oldAnnotations.get(ePackage));
			ePackage.getEClassifiers().addAll(oldClassifiers.get(ePackage));
			ePackage.getESubpackages().addAll(oldSubpackages.get(ePackage));
		}
	}
	
    public void saveResource(IProgressMonitor monitor, XMLResource resource) {
		if (monitor.isCanceled())
			return;
		try {
			monitor.subTask("Saving " + resource.getURI());
			resource.save(null);
		} catch (IOException e) {
			RoseUMLImporterPlugin.showError("Failed to save '" + resource.getURI() + "'", e);
		}
	}

	public void setEMOFExtension(String emofExtension) {
		this.emofExtension = emofExtension;
	}

	public void setEMOFPath(String emofPath) {
		this.emofPath = emofPath != null ? modelPath.append(emofPath) : null;
	}

	public void setEcoreExtension(String ecoreExtension) {
		this.ecoreExtension = ecoreExtension;
	}

	public void setEcorePath(String ecorePath) {
		this.ecorePath = ecorePath != null ? modelPath.append(ecorePath) : null;
	}

	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	public void setXMIidMap(Map<EObject, String> idMap) {
		this.idMap = idMap;
	}	
}
