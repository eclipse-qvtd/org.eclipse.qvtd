/*******************************************************************************
 * Copyright (c) 2012,2013 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.TransformationInstance;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.TypedModelInstance;

/**
 * QVTc Domain Manager is the class responsible for managing the QVTc virtual
 * machine meta-models and models. 
 * A QVTc Domain Manager object encapsulates the domain information need to 
 * modify the domains's models. 
 */
public class QVTiModelManager implements ModelManager
{
	protected final @NonNull QVTiTransformationAnalysis transformationAnalysis;
	protected final @NonNull MetamodelManager metamodelManager;
	// TODO how to manage aliases?
	/** Map a typed model to its resource (model). */
	private @NonNull Map<TypedModel, Resource> modelResourceMap = new HashMap<TypedModel, Resource>();
	
	private @NonNull Map<TypedModel, List<EObject>> modelElementsMap = new HashMap<TypedModel, List<EObject>>();

	/**
	 * The types upon which execution of the transformation may invoke allInstances().
	 */
	private @NonNull Set<org.eclipse.ocl.pivot.Class> allInstancesClasses;

	/**
	 * Array of caches for the un-navigable opposite of each used property. 
	 * The array index is allocated by the QVTiTransformationAnalysis; it identifies the property
	 * of interest. Each cache is from the sourceObject to the un-navigable targetObject.
	 */
	private @NonNull Map<?, ?> unnavigableOpposites[];
	
	
	/**
	 * Instantiates a new QVTi Domain Manager. Responsible for creating new
	 * instances of the middle model and the middle model EFactory.
	 */
	public QVTiModelManager(@NonNull QVTiTransformationAnalysis transformationAnalysis) {
	    this.transformationAnalysis = transformationAnalysis;
	    this.metamodelManager = transformationAnalysis.getMetamodelManager();
	    this.allInstancesClasses = transformationAnalysis.getAllInstancesClasses();
	    int cacheIndexes = transformationAnalysis.getCacheIndexes();
		this.unnavigableOpposites = new Map<?, ?>[cacheIndexes];
		for (int i = 0; i < cacheIndexes; i++) {
			this.unnavigableOpposites[i] = new HashMap<Object, Object>();
		}
	}

	/**
	 * Adds the model to the list of models managed by this domain manager. The
	 * domain manager supports only one root resource per typed model, this means that
	 * if a model was already binded to the TypedModel it will be replaced.
	 *
	 * @param typedModel the type model associated to the model
	 * @param model the resource
	 */
	// TODO support multiple model instances by alias
	public void addModel(@NonNull TypedModel typedModel, @NonNull Resource model) {
	    modelResourceMap.put(typedModel, model);
	}

	/**
	 * Adds the model element to the resource of the given TypeModel
	 *
	 * @param tm the TypeModel
	 * @param element the element
	 */
	public void addModelElement(@NonNull TypedModel model, @NonNull Object element) {
	    
	    List<EObject> elements = modelElementsMap.get(model);
	    if (elements == null) {
	        elements = new ArrayList<EObject>(modelResourceMap.get(model).getContents());
		    modelElementsMap.put(model, elements);
	    }
	    elements.add((EObject) element);
	}

	/**
	 * Dispose.
	 */
	public void dispose() {
		modelElementsMap.clear();
		modelResourceMap.clear();
		allInstancesClasses.clear();
		for (Map<?, ?> unnavigableOpposite : unnavigableOpposites) {
			unnavigableOpposite.clear();
		}
	}

	@Override
	public @NonNull Set<EObject> get(@NonNull org.eclipse.ocl.pivot.Class type) {
		
		Set<EObject> elements = new HashSet<EObject>();
		// Find the typed model for the type
		org.eclipse.ocl.pivot.Package p = type.getOwningPackage();
		for (TypedModel d : modelResourceMap.keySet()) {
			for (org.eclipse.ocl.pivot.Package up : d.getUsedPackage()) {
				if (up.equals(p)) {
					for (Object o : getElementsByType(d, type)) {
						elements.add((EObject) o);
					}
				}
			}
		}
		return elements;
	}

	public @NonNull MetamodelManager getMetamodelManager() {
		return metamodelManager;
	}

	/**
	 * Gets the model (resource) for a given TypedModel.
	 *
	 * @param typedModel the typed model
	 * @return the resource
	 */
	public Resource getModel(@NonNull TypedModel typedModel) {
		return modelResourceMap.get(typedModel);
	}

	/**
	 * Gets the resources for all the models.
	 *
	 * @return a collection of all the resources
	 */
	public Collection<Resource> getAllModelResources() {
		return modelResourceMap.values();
	}

	/**
     * Gets the all the instances of the specified Type in the given TypeModel
     *
     * @param tm the TypeModel (can be null if it is the middle model)
     * @param type the type of the elements that are retrieved
     * @return the instances
     */
    public List<Object> getElementsByType(@Nullable TypedModel model, @NonNull Type type) {
        
        List<Object> elements = new ArrayList<Object>();
        // Is the TypedModel the middle or output, hence we have elements in the elementsMap
        if (modelElementsMap.containsKey(model)) {
            for (EObject root :  modelElementsMap.get(model)) {
                if (root != null) {
					//if (root.eClass().getName().equals(type.getName())) {
					if (isInstance(type, root)) {
						elements.add(root);
					}
					for (TreeIterator<EObject> contents = root.eAllContents(); contents
						.hasNext();) {
						EObject element = contents.next();
						if ((element != null) && isInstance(type, element)) {
							//                    if (((EClass) type.getETarget()).getName().equals(element.eClass().getName())) {
							elements.add(element);
						}
					}
				}
            }
        }
        else {
            for (TreeIterator<EObject> contents = modelResourceMap.get(model).getAllContents(); contents.hasNext();) {
                EObject element = contents.next();
                //System.out.println(type.getETarget());
                //System.out.println(((EClassifier) type.getETarget()).getName());
                //System.out.println(object.eClass().getName());
                if ((element != null) && isInstance(type, element)) {
//                if (((EClass) type.getETarget()).getName().equals(element.eClass().getName())) {
                    elements.add(element);
                }
            }
        }
        return elements;
    }

	/**
	 * Return the target object of the unnavigable property, associated with cacheIndex, navigation from sourceObject.
	 */
	public Object getUnnavigableOpposite(@NonNull Integer cacheIndex, @NonNull Object sourceObject) {
		return unnavigableOpposites[cacheIndex].get(sourceObject);
	}

	/**
	 * Implemented by subclasses to determine whether the specified element
	 * is an instance of the specified class, according to the metamodel
	 * semantics implemented by the environment that created this extent map.
	 *
	 * @param type the type
	 * @param element a potential run-time (M0) instance of that class
	 * @return <code>true</code> if this element is an instance of the given
	 * class; <code>false</code> otherwise
	 */
	protected boolean isInstance(@NonNull Type requiredType, @NonNull EObject eObject) {
		EClass eClass = eObject.eClass();
		EPackage ePackage = eClass.getEPackage();
		Type objectType = null;
		if (ePackage == PivotPackage.eINSTANCE) {
			String name = ClassUtil.nonNullEMF(eClass.getName());
			objectType = metamodelManager.getASClass(name);
		}
		else {
			try {
				objectType = metamodelManager.getASOf(Type.class,  eClass);
			} catch (ParserException e) {
// FIXME				if (!generatedErrorMessage) {
//					generatedErrorMessage = true;
//					logger.error("Failed to load an '" + eClass.getName() + "'", e);
//				}
			}
		}
	    return (objectType != null) && objectType.conformsTo(metamodelManager.getStandardLibrary(), requiredType);
	}

	public @NonNull QVTiTransformationAnalysis getTransformationAnalysis() {
		return transformationAnalysis;
	}
	
	public List<EObject> getTypeModelEObjectList(TypedModel model) {
		
		if (modelElementsMap.containsKey(model)) {
			return  modelElementsMap.get(model);
		} else {
			return new ArrayList<EObject>();
		}
		
	}

	/**
	 * Saves all the models managed by the domain manager
	 */
    public void saveModels() {
    	this.saveModels(null);
    }
	/**
	 * Saves all the models managed by the domain manager using the provided (optional) 
	 * saving options.
	 */
    public void saveModels(@Nullable Map<?, ?> savingOptions) {
        for (Map.Entry<TypedModel, Resource> entry : modelResourceMap.entrySet()) {
            Resource model = entry.getValue();
            TypedModel key = entry.getKey();
            if (modelElementsMap.containsKey(key)) {       // Only save modified models
                // Move elements without container to the resource contents
                for (EObject e : modelElementsMap.get(key)) {
                    if (e.eContainer() == null) {
                        model.getContents().add(e);
                    }
                }
            }
        }
        for (Map.Entry<TypedModel, Resource> entry : modelResourceMap.entrySet()) {
            Resource model = entry.getValue();
            TypedModel key = entry.getKey();
            if (modelElementsMap.containsKey(key)) {       // Only save modified models
                try{
                	model.save(savingOptions);
                } catch (IOException e) {
                      e.printStackTrace();
                }
            }
        }
    }
    
    public void saveMiddleModel(@NonNull URI uri) {
    	this.saveMiddleModel(uri, null);
    }
    
    public void saveMiddleModel(@NonNull URI uri, Map<?, ?> savingOptions) {
    	// TODO
/*        Resource r = metamodelManager.getExternalResourceSet().createResource(uri);
        for (EObject e : modelElementsMap.get(MIDDLE_MODEL)) {
            if (e.eContainer() == null) {
                r.getContents().add(e);
            }
        }
        try{
            Map<Object, Object> options = new HashMap<Object, Object>();
            options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
            r.save(options);
           } catch (IOException e) {
              e.printStackTrace();
           } */
    }

	/**
	 * Register targetObject as the target of the unnavigable property, associated with cacheIndex, navigation from sourceObject.
	 */
	@SuppressWarnings("unchecked")
	public void setUnnavigableOpposite(@NonNull Integer cacheIndex, @NonNull Object targetObject, Object sourceObject) {
		((Map<Object, Object>)unnavigableOpposites[cacheIndex]).put(sourceObject, targetObject);
	}

	public static class QVTiTransformationInstance implements TransformationInstance
	{
		protected final @NonNull QVTiModelManager modelManager;
		protected final @NonNull Transformation transformation;
		
		public QVTiTransformationInstance(@NonNull QVTiModelManager modelManager, @NonNull Transformation transformation) {
			this.modelManager = modelManager;
			this.transformation = transformation;
		}
	}

	public static class QVTiTypedModelInstance implements TypedModelInstance
	{
		protected final @NonNull QVTiModelManager modelManager;
		protected final @NonNull TypedModel typedModel;
		
		public QVTiTypedModelInstance(@NonNull QVTiModelManager modelManager, @NonNull TypedModel typedModel) {
			this.modelManager = modelManager;
			this.typedModel = typedModel;
		}

		@Override
		public @NonNull Set<EObject> getAllObjects() {
			throw new UnsupportedOperationException();
		}

		@Override
		public @NonNull Set<EObject> getObjectsOfKind(@NonNull org.eclipse.ocl.pivot.Class type) {
			IdResolver idResolver = modelManager.getMetamodelManager().getEnvironmentFactory().getIdResolver();
			Set<EObject> results = new HashSet<EObject>(); 
			Set<?> instances = modelManager.get(type);
			for (Object instance : instances) {
				if (instance != null) {
					results.add((EObject) idResolver.ecoreValueOf(null, instance));	// FIXME Move to model manager
				}
			}
			return results;
		}

		@Override
		public @NonNull Set<EObject> getObjectsOfType(@NonNull org.eclipse.ocl.pivot.Class type) {
			throw new UnsupportedOperationException();
		}

		@Override
		public @NonNull Collection<EObject> getRootObjects() {
			throw new UnsupportedOperationException();
		}
	}
	
	public Object getTransformationInstance(@NonNull Transformation transformation) {
		return new QVTiTransformationInstance(this, transformation);
	}

	public Object getTypedModelInstance(@NonNull TypedModel typedModel) {
		return new QVTiTypedModelInstance(this, typedModel);
	}
}
