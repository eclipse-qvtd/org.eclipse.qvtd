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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.emc.emf.ContainmentChangeAdapter;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * The Pivot Model extends the EmfModel to provide access to the utilities
 * provided by the OCL framework
 */
public class PivotModel extends EmfModel {
	
	private MetaModelManager metaModelManager;
	
	public PivotModel(MetaModelManager metaModelManager) {
		
		this.metaModelManager = metaModelManager;
	}
	
	@Override
	public void loadModelFromUri() throws EolModelLoadingException {
		
		Resource model = metaModelManager.getExternalResourceSet().createResource(modelUri);// getResource(modelUri, false);
		if (this.readOnLoad) {
			try {
				model.load(null);
				if (expand) {
					EcoreUtil.resolveAll(model);
				}
			} catch (IOException e) {
				throw new EolModelLoadingException(e, this);
			}
		}
		modelImpl = model;
	}
	
	protected EObject createInstanceInModel(String type) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		
		EClass eClass = classForName(type);
		//if (eClass == null) throw new EolModelElementTypeNotFoundException(this.getName(), type);
		if (eClass.isAbstract()) throw new EolNotInstantiableModelElementTypeException(this.name, type);
		
		EObject instance = eClass.getEPackage().getEFactoryInstance().create(eClass);
		modelImpl.getContents().add(instance);
		instance.eAdapters().add(new ContainmentChangeAdapter(instance, modelImpl));
		return instance;
		
	}
	
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
	
	

}
