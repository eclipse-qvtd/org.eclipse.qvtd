/*******************************************************************************
 * Copyright (c) 2013, 2015 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 *     Adolfo Sanchez-Barbudo Herrera - Some enhancements
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.etl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.schedule.Schedule;

/**
 * The Pivot Model extends the EmfModel to provide access to the utilities
 * provided by the OCL framework.
 */
public class PivotModel extends EmfModel {
	

	/** The meta model manager. */
	private @NonNull EnvironmentFactory environmentFactory;
	
	private boolean isASResource;
	
	private @Nullable Map<?, ?> savingOptions;
	


	public PivotModel(@NonNull EnvironmentFactory environmentFactory, boolean isASResource) {
		this(environmentFactory, isASResource, null);
	}
	
	
	public PivotModel(@NonNull EnvironmentFactory environmentFactory, boolean isASResource, @Nullable Map<?, ?> savingOptions) {
		this.isASResource = isASResource;
		this.environmentFactory = environmentFactory;
		this.savingOptions = savingOptions;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.emf.EmfModel#loadModelFromUri()
	 */
	@Override
	public void loadModelFromUri() throws EolModelLoadingException {

		ResourceSet rSet = isASResource ? environmentFactory.getMetamodelManager().getASResourceSet() : environmentFactory.getResourceSet();
		determinePackagesFrom(rSet);
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
	
	@Override
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
	protected Collection<EObject> allContentsFromModel() {
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
	
	public @NonNull Transformation getTransformation() throws Exception {
		for (EObject eContent : modelImpl.getContents()) {
			if (eContent instanceof ImperativeModel) {
	    		for (org.eclipse.ocl.pivot.Package aPackage : ((ImperativeModel)eContent).getOwnedPackages()) {
	    			for (org.eclipse.ocl.pivot.Class aClass : aPackage.getOwnedClasses()) {
	    				if (aClass instanceof Transformation) {
		                    return (Transformation) aClass;
		    			}	
	    			}
	    		}
			}
		}
		throw new Exception("The QVTd model does not have a Transformation element.");
	}
	
	
	public MetamodelManagerInternal getMetaModelManager() {
		return (MetamodelManagerInternal) environmentFactory.getMetamodelManager();
	}
	
	@Override
	// FIXME Raise epsilon bugzilla
	public boolean store() {

		if (modelImpl == null) return false;
		
		try {
			modelImpl.save(savingOptions);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}


	public Schedule getSchedule() throws Exception {
		for (EObject eContent : modelImpl.getContents()) {
			if (eContent instanceof Schedule) {
	    		return (Schedule) eContent;
			}
		}
		throw new Exception("The QVTs model does not have a Schedule element.");
	}
}
