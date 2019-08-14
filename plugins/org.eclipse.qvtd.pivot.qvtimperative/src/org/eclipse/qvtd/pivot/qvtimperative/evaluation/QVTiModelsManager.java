/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractModelsManager;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformationInstance;
import org.eclipse.qvtd.runtime.evaluation.AbstractTypedModelInstance;
import org.eclipse.qvtd.runtime.evaluation.TransformationInstance;
import org.eclipse.qvtd.runtime.evaluation.TypedModelInstance;
import org.eclipse.qvtd.runtime.qvtruntimelibrary.QVTruntimeLibraryPackage;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * QVTiModelsManager manager the source, middle and target models during a QVTi transformation.
 */
public class QVTiModelsManager extends AbstractModelsManager
{
	@SuppressWarnings("null")
	public static final @NonNull ClassId EXTENT_CLASSID = IdManager.getClassId(QVTruntimeLibraryPackage.Literals.EXTENT);

	protected final @NonNull EntryPointAnalysis entryPointAnalysis;
	protected final @NonNull EntryPointsAnalysis entryPointsAnalysis;
	protected final @NonNull EnvironmentFactoryInternalExtension environmentFactory;

	/**
	 * Array of caches for the un-navigable opposite of each used property.
	 * The array index is allocated by the QVTiTransformationAnalysis; it identifies the property
	 * of interest. Each cache is from the sourceObject to the un-navigable targetObject.
	 * <p>
	 * Keys and values cannot be null, since null cannot participate in a 'bidirectional' relationship.
	 */
	private final @NonNull Map<?, ?> unnavigableOpposites @NonNull [];

	/**
	 * The run-time instance of the transformation.
	 */
	private /*@LazyNonNull*/ TransformationInstance transformationInstance = null;

	/**
	 * The run-time instance of each TypedModel.
	 *
	 * More than four typedModelInstances is very unlikley so use of a Map to accelerate lookup is unjustified.
	 */
	private @NonNull List<@NonNull QVTiTypedModelInstance> typedModelInstances = new ArrayList<>();

	/**
	 * Instantiates a new QVTi Domain Manager. Responsible for creating new
	 * instances of the middle model and the middle model EFactory.
	 */
	public QVTiModelsManager(@NonNull EntryPointAnalysis entryPointAnalysis) {
		this.entryPointAnalysis = entryPointAnalysis;
		this.entryPointsAnalysis = entryPointAnalysis.getEntryPointsAnalysis();
		this.environmentFactory = (EnvironmentFactoryInternalExtension) entryPointsAnalysis.getEnvironmentFactory();
		//	this.allInstancesClasses = entryPointsAnalysis.getAllInstancesClasses();
		int cacheIndexes = entryPointsAnalysis.getCacheIndexes();
		this.unnavigableOpposites = new @NonNull Map<?, ?>[cacheIndexes];
		for (int i = 0; i < cacheIndexes; i++) {
			this.unnavigableOpposites[i] = new HashMap<>();
		}
	}

	/**
	 * Dispose.
	 */
	public void dispose() {
		for (@NonNull QVTiTypedModelInstance typedModelInstance : typedModelInstances) {
			typedModelInstance.dispose();
		}
		for (Map<?, ?> unnavigableOpposite : unnavigableOpposites) {
			unnavigableOpposite.clear();
		}
	}

	/**
	 * The inherited 'allInstances' behavior is implemented as an accumulation of all instances from all input models.
	 */
	public @NonNull Set<@NonNull Object> get(org.eclipse.ocl.pivot.@NonNull Class type) {
		Set<@NonNull Object> elements = new HashSet<>();
		for (@NonNull TypedModel typedModel : QVTimperativeUtil.getCheckedTypedModels(entryPointAnalysis.getEntryPoint())) {
			TypedModelInstance typedModelInstance = getTypedModelInstance(typedModel);
			Iterables.addAll(elements, typedModelInstance.getObjectsOfKind(type));
		}
		return elements;
	}

	public @Nullable Map<@NonNull Object, Object> getExtentOpposites() {
		int propertyIndex = getOppositePropertyIndex(QVTruntimeLibraryPackage.Literals.EXTENT__ELEMENTS);
		return (Map<@NonNull Object, Object>)unnavigableOpposites[propertyIndex];
	}

	public @NonNull MetamodelManager getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}

	/**
	 * Gets the model (resource) for a given TypedModel.
	 *
	 * @param typedModel the typed model
	 * @return the resource
	 */
	// FIXME Change API for multiple extents
	public Resource getModel(@NonNull ImperativeTypedModel typedModel) {
		QVTiTypedModelInstance typedModelInstance = getTypedModelInstance(typedModel);
		return typedModelInstance.getModel();
	}

	public @NonNull Iterable<@NonNull Object> getOpposite(@NonNull Property target2sourceProperty, @NonNull Object sourceObject) {
		//	return modelsManager.getOpposite(target2sourceProperty, sourceObject);
		throw new UnsupportedOperationException();
	}

	public @NonNull EntryPointsAnalysis getTransformationAnalysis() {
		return entryPointsAnalysis;
	}

	/*	public List<EObject> getTypeModelEObjectList(@NonNull ImperativeTypedModel model) {
		if (modelElementsMap.containsKey(model)) {
			return  modelElementsMap.get(model);
		} else {
			return new ArrayList<>();
		}
	} */

	public @NonNull TransformationInstance getTransformationInstance(@NonNull ImperativeTransformation transformation) {
		TransformationInstance transformationInstance2 = transformationInstance;
		if (transformationInstance2 == null) {
			transformationInstance = transformationInstance2 = new QVTiTransformationInstance(this, transformation);
		}
		return transformationInstance2;
	}

	public @NonNull QVTiTypedModelInstance getTypedModelInstance(@NonNull TypedModel typedModel) {
		String modelName = typedModel.getName();
		assert modelName != null;
		return getTypedModelInstance(modelName);
	}

	@Override
	public @NonNull QVTiTypedModelInstance getTypedModelInstance(@NonNull String modelName) {
		for (@NonNull QVTiTypedModelInstance typedModelInstance : typedModelInstances) {
			if (modelName.equals(typedModelInstance.getName())) {
				return typedModelInstance;
			}
		}
		throw new IllegalStateException("Unknown model name '" + modelName + "'");
	}

	@Override
	public @NonNull Iterable<@NonNull QVTiTypedModelInstance> getTypedModelInstances() {
		return typedModelInstances;
	}

	//	public @Nullable ImperativeTypedModel getTypedModel(@NonNull Resource resource) {
	//		return resource2typedModel.get(resource);
	//	}

	/**
	 * Return the target object of the unnavigable property, associated with cacheIndex, navigation from sourceObject.
	 */
	public Object getUnnavigableOpposite(@NonNull Integer cacheIndex, @NonNull Object sourceObject) {
		return unnavigableOpposites[cacheIndex].get(sourceObject);
	}

	public void initTypedModelInstance(/*int i,*/@NonNull QVTiTypedModelInstance model) {
		typedModelInstances.add(model);
	}

	/**
	 * Register targetObject as the target of the unnavigable property, associated with cacheIndex, navigation from sourceObject.
	 */
	@SuppressWarnings("unchecked")
	public void setUnnavigableOpposite(@NonNull Integer cacheIndex, @NonNull Object targetObject, Object sourceObject) {
		((Map<Object, Object>)unnavigableOpposites[cacheIndex]).put(sourceObject, targetObject);
	}

	public static class QVTiTransformationInstance extends AbstractTransformationInstance
	{
		protected final @NonNull QVTiModelsManager modelManager;
		protected final @NonNull ImperativeTransformation transformation;

		public QVTiTransformationInstance(@NonNull QVTiModelsManager modelManager, @NonNull ImperativeTransformation transformation) {
			this.modelManager = modelManager;
			this.transformation = transformation;
		}

		public @NonNull QVTiModelsManager getModelManager() {
			return modelManager;
		}

		@Override
		public @Nullable String getName() {
			return transformation.getName();
		}

		public @NonNull ImperativeTransformation getTransformation() {
			return transformation;
		}
	}

	public static class QVTiTypedModelInstance extends AbstractTypedModelInstance	// FIXME reimplement using CG variant
	{
		protected final @NonNull EnvironmentFactoryInternalExtension environmentFactory;
		protected final @NonNull ImperativeTypedModel typedModel;
		private @Nullable EClass extentEClass = null;

		public QVTiTypedModelInstance(@NonNull QVTiModelsManager modelsManager, @NonNull ImperativeTypedModel typedModel) {
			super(modelsManager, QVTimperativeUtil.getName(typedModel));
			this.environmentFactory = modelsManager.environmentFactory;
			this.typedModel = typedModel;
		}

		@Override
		protected void addExtent() {
			EClass extentEClass2 = extentEClass;
			assert extentEClass2 != null;
			EObject extent = extentEClass2.getEPackage().getEFactoryInstance().create(extentEClass2);
			EStructuralFeature elementsFeature = extentEClass2.getEStructuralFeature(QVTruntimeLibraryPackage.Literals.EXTENT__ELEMENTS.getFeatureID());
			assert elementsFeature != null;
			@SuppressWarnings("unchecked")
			List<Object> elements = (List<Object>) extent.eGet(elementsFeature);
			assert elements != null;
			addExtent(extent, elements);
		}

		public void addInputResource(@NonNull URI modelURI, @Nullable String contentType) {
			Resource resource;
			ResourceSet resourceSet = environmentFactory.getResourceSet();
			if (contentType == null) {
				resource = resourceSet.getResource(modelURI, true);
			}
			else {
				resource = resourceSet.createResource(modelURI, contentType);
				try {
					resource.load(null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (resource != null) {
				addInputResource(resource);
			}
		}

		public void addOutputResource(@NonNull URI modelURI, @Nullable String contentType) {
			Resource resource = environmentFactory.getResourceSet().createResource(modelURI, null);
			if (resource != null) {
				addOutputResource(resource);
			}
		}

		/**
		 * Return the elements of a root Extent object, iff rootObject is an Extent.
		 * Return null otherwise.
		 */
		@Override
		protected @Nullable Iterable<@NonNull EObject> getExtentElements(@NonNull EObject rootObject) {
			EClass eClass = rootObject.eClass();
			TypeId classId = IdManager.getClassId(eClass);
			if (classId != EXTENT_CLASSID) {
				return null;
			}
			EStructuralFeature elementsFeature = eClass.getEStructuralFeature(QVTruntimeLibraryPackage.Literals.EXTENT__ELEMENTS.getFeatureID());
			assert elementsFeature != null;
			@SuppressWarnings("unchecked")
			List<@NonNull EObject> elements = (List<@NonNull EObject>) rootObject.eGet(elementsFeature);
			return elements;
		}

		/**
		 * Gets the model (resource) for a given TypedModel.
		 *
		 * @param typedModel the typed model
		 * @return the resource
		 */
		// FIXME Change API for multiple extents
		public @Nullable Resource getModel() {
			List<@NonNull Resource> inputResources = basicGetInputResources();
			return (inputResources != null) && !inputResources.isEmpty() ? inputResources.get(0) : null;
		}

		public @NonNull QVTiModelsManager getModelManager() {
			return (QVTiModelsManager) modelsManager;
		}

		public @NonNull ImperativeTypedModel getTypedModel() {
			return typedModel;
		}

		@Override
		public <K,V> void initExtent(int extentClassIndex, @Nullable Map<K, V> extentOpposites) {
			super.initExtent(extentClassIndex, extentOpposites);
			ImperativeTypedModel typedModel = getTypedModel();
			Set<org.eclipse.ocl.pivot.@NonNull Class> usedClasses = Sets.newHashSet(QVTimperativeUtil.getUsedClasses(typedModel));
			ClassId[] classIndex2classId2 = classIndex2classId;
			assert classIndex2classId2 != null;
			ClassId extentClassId = classIndex2classId2[extentClassIndex];
			for (org.eclipse.ocl.pivot.@NonNull Class usedClass : usedClasses) {
				if (usedClass.getTypeId() == extentClassId) {
					extentEClass = (EClass) usedClass.getESObject();
					break;
				}
			}
			assert extentEClass != null;
		}
	}
}
