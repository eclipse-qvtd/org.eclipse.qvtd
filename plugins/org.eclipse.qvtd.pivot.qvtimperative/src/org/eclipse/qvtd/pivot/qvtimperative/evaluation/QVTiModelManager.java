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
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.internal.manager.MetaModelManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * QVTc Domain Manager is the class responsible for managing the QVTc virtual
 * machine meta-models and models. 
 * A QVTc Domain Manager object encapsulates the domain information need to 
 * modify the domains's models. 
 */
public class QVTiModelManager implements ModelManager
{
	protected final @NonNull MetaModelManager metaModelManager;
	// TODO how to manage aliases?
	/** Map a typed model to its resource (model). */
	private @NonNull Map<TypedModel, Resource> modelResourceMap = new HashMap<TypedModel, Resource>();
	
	private @NonNull Map<TypedModel, List<EObject>> modelElementsMap = new HashMap<TypedModel, List<EObject>>();

	/**
	 * The types upon which execution of the transformation may invoke allInstances().
	 */
	private @NonNull Set<Type> allInstancesTypes;

	/**
	 * Array of caches for the un-navigable opposite of each used navigable middle to outer property. 
	 * The array index is allocated by the QVTiTransformationAanaysis; it identifies the middle2outerProperty
	 * of interest. Each cache is from outerObject to middleObject.
	 */
	private @NonNull Map<?, ?> middleOpposites[];
	
	/**
	 * Instantiates a new QVTc Domain Manager. Responsible for creating new
	 * instances of the middle model and the middle model EFactory.
	 */
	public QVTiModelManager(@NonNull QVTiTransformationAnalysis transformationAnalysis) {
	    this.metaModelManager = transformationAnalysis.getMetaModelManager();
	    this.allInstancesTypes = transformationAnalysis.getAllInstancesTypes();
	    int cacheIndexes = transformationAnalysis.getCacheIndexes();
		this.middleOpposites = new Map<?, ?>[cacheIndexes];
		for (int i = 0; i < cacheIndexes; i++) {
			this.middleOpposites[i] = new HashMap<Object, Object>();
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
		allInstancesTypes.clear();
		for (Map<?, ?> middleOpposite : middleOpposites) {
			middleOpposite.clear();
		}
	}

	@Override
	public @NonNull Set<EObject> get(@NonNull org.eclipse.ocl.pivot.Class type) {
		
		Set<EObject> elements = new HashSet<EObject>();
		// Find the typed model for the type
		org.eclipse.ocl.pivot.Package p = type.getOwningPackage();
		for (TypedModel d : modelResourceMap.keySet()) {
			for (Package up : d.getUsedPackage()) {
				if (up.equals(p)) {
					for (Object o : getElementsByType(d, type)) {
						elements.add((EObject) o);
					}
				}
			}
		}
		return elements;
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
	 * Retrieve the unnavigable opposite of the cacheIndex of outerObject.
	 */
	public Object getMiddleOpposite(@NonNull Integer cacheIndex, @NonNull Object outerObject) {
		return middleOpposites[cacheIndex].get(outerObject);
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
			objectType = metaModelManager.getPivotType(name);
		}
		else {
			try {
				objectType = metaModelManager.getPivotOf(Type.class,  eClass);
			} catch (ParserException e) {
// FIXME				if (!generatedErrorMessage) {
//					generatedErrorMessage = true;
//					logger.error("Failed to load an '" + eClass.getName() + "'", e);
//				}
			}
		}
	    return (objectType != null) && objectType.conformsTo(metaModelManager.getStandardLibrary(), requiredType);
	}
	
	public List<EObject> getTypeModelEObjectList(TypedModel model) {
		
		if (modelElementsMap.containsKey(model)) {
			return  modelElementsMap.get(model);
		} else {
			return new ArrayList<EObject>();
		}
		
	}

	/**
	 * Saves all the models managed by the domain manager.
	 */
    public void saveModels() {
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
                    Map<Object, Object> options = new HashMap<Object, Object>();
                    options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
                    model.save(options);
                   } catch (IOException e) {
                      e.printStackTrace();
                   }
            }
        }
    }

    public void saveMiddleModel(@NonNull URI uri) {
/*        Resource r = metaModelManager.getExternalResourceSet().createResource(uri);
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
	 * Register middleObject as the unnavigable opposite of the cacheIndex of outerObject.
	 */
	@SuppressWarnings("unchecked")
	public void setMiddleOpposite(@NonNull Integer cacheIndex, @NonNull Object middleObject, Object outerObject) {
		((Map<Object, Object>)middleOpposites[cacheIndex]).put(outerObject, middleObject);
	}
}
