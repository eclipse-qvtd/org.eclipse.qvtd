/*******************************************************************************
 * Copyright (c) 2013 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.build.etl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;

// TODO: Auto-generated Javadoc
/**
 * The Pivot Model extends the EmfModel to provide access to the utilities
 * provided by the OCL framework.
 */
public class PivotModel extends EmfModel {
	
	/** The meta model manager. */
	private MetamodelManager metamodelManager;
	
	private boolean isASResource;
	
	/**
	 * Instantiates a new pivot model.
	 *
	 * @param metamodelManager the meta model manager
	 */
	public PivotModel(MetamodelManager metamodelManager, boolean isASResource) {
		
		this.isASResource = isASResource;
		this.metamodelManager = metamodelManager;
	}
	
	public PivotModel(PivotModel pModel) {
		this.aliases = pModel.aliases;
		this.cachingEnabled = pModel.cachingEnabled;
		this.expand = pModel.expand;
		this.modelImpl = pModel.modelImpl;
		this.readOnLoad = pModel.readOnLoad;
		this.registry = pModel.registry;
		this.metamodelUris = pModel.metamodelUris;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.emf.EmfModel#loadModelFromUri()
	 */
	@Override
	public void loadModelFromUri() throws EolModelLoadingException {

		ResourceSet resourceSet = isASResource ? metamodelManager.getASResourceSet() : metamodelManager.getExternalResourceSet();
		determinePackagesFrom(resourceSet);
		try {
			if (readOnLoad) {
				modelImpl = resourceSet.getResource(modelUri, true);
				if (expand) {
					EcoreUtil.resolveAll(modelImpl);
				}
			} else {
				modelImpl = resourceSet.createResource(modelUri);
			}
		} catch (RuntimeException e) {
			throw new EolModelLoadingException(e, this);
		}
	}
	
	protected EClass classForName(String name, Registry registry) {	
		boolean absolute = name.indexOf("::") > -1;
		EClass epClass = null;
		for (EPackage ePackage : packages) {
			epClass = classForName(name, absolute, ePackage);
			if (epClass != null) {
				break;
			}
		}
		return epClass;
	}
	
	private EClass classForName(String name, boolean absolute, EPackage pkg) {
		for (EClassifier eClassifier : EmfUtil.getAllEClassifiers(pkg)) {
			if (eClassifier instanceof EClass) {
				String eClassifierName = "";
				if (absolute) {
					eClassifierName = getFullyQualifiedName(eClassifier);
				}
				else {
					eClassifierName = eClassifier.getName();
				}
				
				if (eClassifierName.compareTo(name) == 0) {
					return (EClass) eClassifier;
				}
			}
		}
		return null;
	}
	
	@Override
	protected void determinePackagesFrom(ResourceSet resourceSet) throws EolModelLoadingException {
		packages = new ArrayList<EPackage>();
		
		// FIXME this should also check for file based metamodels too but some of the operations needed are private
	
		for (URI metamodelUri : this.metamodelUris) {
			EPackage ePackage =  resourceSet.getPackageRegistry().getEPackage(metamodelUri.toString());//  EPackage.Registry.INSTANCE.getEPackage(metamodelUri.toString());
			if (ePackage == null) {
				throw new EolModelLoadingException(new IllegalArgumentException("Could not locate a metamodel with the URI '" + metamodelUri + "'. Please ensure that this metamodel has been registered with Epsilon."), this);
			}
			packages.add(ePackage);
			EmfUtil.collectDependencies(ePackage, packages);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.emf.AbstractEmfModel#getEnumerationValue(java.lang.String, java.lang.String)
	 */
	@Override
	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException {
		
		for (EPackage ePackage : packages) {
			for (EClassifier classifier : EmfUtil.getAllEClassifiers(ePackage)) {
				if (classifier instanceof EEnum && 
						(((EEnum) classifier).getName().equals(enumeration) ||
						getFullyQualifiedName(classifier).equals(enumeration))){
					EEnum eEnum = (EEnum) classifier;
					EEnumLiteral literal = eEnum.getEEnumLiteral(label);
					
					if (literal != null) return literal.getInstance();
				}
			}
		}
		throw new EolEnumerationValueNotFoundException(enumeration,label,this.getName());
	}
	
	@Override
	protected Collection<EObject> allContentsFromModel(){
		final List<EObject> allInstances = new ArrayList<EObject>();
		List<Resource> resources = new ArrayList<Resource>();
		if (expand && modelImpl.getResourceSet() != null) {
			resources.addAll(modelImpl.getResourceSet().getResources());
		} else {
			resources.add(modelImpl);
		}
		for (Resource resource : resources) {
			Iterator<EObject> it = resource.getAllContents();
			while (it.hasNext()){
				EObject o = it.next();
				if (packages.contains(o.eClass().getEPackage())) {
					allInstances.add(o);
				}
			}
		}			
		return allInstances;
	}
	
	
	/**
	 * Gets the root eObject.
	 *
	 * @return the roote object
	 */
	public EObject getRooteObject() {
		return modelImpl.getContents().get(0);
	}
	
	public Transformation getTransformation() throws Exception {
		for (EObject eContent : modelImpl.getContents()) {
			if (eContent instanceof ImperativeModel) {
	    		for (org.eclipse.ocl.pivot.Package aPackage : ((ImperativeModel)eContent).getOwnedPackages()) {
	    			for (Class aClass : aPackage.getOwnedClasses()) {
	    				if (aClass instanceof Transformation) {
		                    return (Transformation) aClass;
		    			}	
	    			}
	    		}
			}
		}
		throw new Exception("The QVTi model does not have a Transformation element.");
	}
	
}
