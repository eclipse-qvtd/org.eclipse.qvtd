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
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.emc.emf.ContainmentChangeAdapter;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
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

		ResourceSet rSet = isASResource ? metamodelManager.getASResourceSet() : metamodelManager.getExternalResourceSet();
		try {
			if (readOnLoad) {
				modelImpl = rSet.getResource(modelUri, true);
				if (expand) {
					EcoreUtil.resolveAll(modelImpl);
				}
			} else {
				modelImpl = rSet.createResource(modelUri);
			}
		} catch (RuntimeException e) {
			throw new EolModelLoadingException(e, this);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.emf.AbstractEmfModel#createInstanceInModel(java.lang.String)
	 */
	protected EObject createInstanceInModel(String type) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		
		EClass eClass = classForName(type);
		//if (eClass == null) throw new EolModelElementTypeNotFoundException(this.getName(), type);
		if (eClass.isAbstract()) throw new EolNotInstantiableModelElementTypeException(this.name, type);
		
		EObject instance = eClass.getEPackage().getEFactoryInstance().create(eClass);
		modelImpl.getContents().add(instance);
		instance.eAdapters().add(new ContainmentChangeAdapter(instance, modelImpl));
		return instance;
		
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.emf.AbstractEmfModel#classForName(java.lang.String, org.eclipse.emf.ecore.EPackage.Registry)
	 */
	@Override
	protected EClass classForName(String name, Registry registry) {	
		boolean absolute = name.indexOf("::") > -1;
		
		for (String nsURI : getMetamodelUris()) {
			EClass eClass = classForName(name, absolute, registry.getEPackage(nsURI));
			if (eClass != null) {
				return eClass;
			}
		}
		return null;
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.emf.AbstractEmfModel#getEnumerationValue(java.lang.String, java.lang.String)
	 */
	@Override
	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException {
		
		for (String nsURI : getMetamodelUris()) {
			for (EClassifier classifier : EmfUtil.getAllEClassifiers(getPackageRegistry().getEPackage(nsURI))) {
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
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.emf.AbstractEmfModel#getAllTypeNamesOf(java.lang.Object)
	 */
	@Override
	public Collection<String> getAllTypeNamesOf(Object instance) {
		final Collection<String> allTypeNames = new ArrayList<String>();
		
		if (isModelElement(instance)) {
			final EClass type = (EClass)getTypeOf(instance);
			
			allTypeNames.add(type.getName());
			
			for (EClass supertype : type.getEAllSuperTypes()) {
				if (!supertype.isInterface())
					allTypeNames.add(supertype.getName());
			}
		}
		
		return allTypeNames;
	}
	
	@Override
	protected Collection<EObject> allContentsFromModel(){
		final List<EObject> allInstances = new ArrayList<EObject>();
		TreeIterator<Object> it = EcoreUtil.getAllContents(modelImpl, expand);
		while(it.hasNext()) {
			allInstances.add((EObject) it.next());
		}
		return allInstances;
	}
	
	
	/**
	 * Class for name.
	 *
	 * @param name the name
	 * @param absolute the absolute
	 * @param pkg the pkg
	 * @return the e class
	 */
	private EClass classForName(String name, boolean absolute, EPackage pkg) {
		if (pkg != null) {
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
		}
		return null;
	}
	

	/**
	 * Gets the root eObject.
	 *
	 * @return the roote object
	 */
	public EObject getRooteObject() {
		return modelImpl.getContents().get(0);
	}
	
	// FIXME this method is not suitable for a PivotModel
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
