/*******************************************************************************
 * Copyright (c) 2015, 2022 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.evaluation;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.ClassId;

/**
 * A TypedModelInstance makes an input or output model of an executing transformation
 * accessible as a model instance.
 *
 * @noimplement clients should derive from AbstractTypedModelInstance
 */
public interface TypedModelInstance
{
	/**
	 * @deprecated provide isContained argument
	 */
	@Deprecated
	default void add(@NonNull EObject eObject) {
		add(eObject, false);
	}

	/**
	 * Add the newly realized eObject to the TypedModelInstance.
	 * If isContainer is true, the caller undertakes to provide
	 * a container for the EObject relieving the TypedModelInstance of the responibility of tracking
	 * the potential orphan and allocating it to the model root prior to save.
	 */
	void add(@NonNull EObject eObject, boolean isContained);

	/**
	 * Add inputResource to the list of input Resources whose containment and reference hierarchies provide loaded model elements.
	 */
	void addInputResource(@NonNull Resource inputResource);

	/**
	 * Add outputResource to the list of output Resources whose containment and reference hierarchies save realized model elements.
	 */
	void addOutputResource(@NonNull Resource outputResource);

	/**
	 * Add eRootObjects to the list of input elements whose containment and reference hierarchies provide loaded model elements.
	 */
	@Deprecated /* @deprecated pass root objects in a Resource */
	void addRootObjects(@NonNull Iterable<@NonNull ? extends Object> eRootObjects);

	/**
	 * Add the contents of the inputResources to this model's caches and connections.
	 */
	void analyzeInputResources();

	/**
	 * Add the potential orphans as contents of the first outputResource.
	 */
	void analyzeOutputResources();

	/**
	 * This is solely used by the Model::allObjects Operation which is not needed by synthesized QVTr.
	 * @deprecated
	 */
	@Deprecated
	@NonNull Iterable<@NonNull ? extends Object> getAllObjects();

	/**
	 * Return the Connection that passes loaded values conformant to the ClassId corresponding to the classIndex.
	 */
	@NonNull Connection getConnection(int classIndex);

	@NonNull ModelsManager getModelsManager();

	/**
	 * Get the name of the underlying TypedModel.
	 * May be null where the legacy usage of null for the unnamed middle model persists.
	 */
	@Nullable String getName();

	/**
	 * Return all objects in the model that conform to type.
	 */
	@NonNull Iterable<@NonNull Object> getObjectsOfKind(org.eclipse.ocl.pivot.@NonNull Class type);

	/**
	 * This is solely used by the Model::objectsOfType Operation which is not needed by synthesized QVTr.
	 * @deprecated
	 */
	@Deprecated
	@NonNull Collection<@NonNull ? extends Object> getObjectsOfType(org.eclipse.ocl.pivot.@NonNull Class type);

	@NonNull Collection<@NonNull EObject> getRootEObjects();

	/**
	 * Initialize the instance analysis structures to suppoty a simple linear classIndex for each ClassId of interest
	 * and a list of all super classIndexes per classIndex.
	 */
	@NonNull TypedModelInstance initClassIds(@NonNull ClassId @NonNull [] classIndex2classId, int @Nullable [] @NonNull [] classIndex2allClassIndexes);

	/**
	 * Createthe Connections to pass the type conformant elements produced by the loaded input models to
	 * the corresponding consumers.
	 */
	void initConnections(@NonNull Interval rootInterval, @NonNull ModeFactory modeFactory);

	<K,V> void initExtent(int extentClassIndex, @Nullable Map<K, V> extentOpposites);

	/**
	 * Remove all input resources preparatory to a fresh use of the executor.
	 */
	@Deprecated /* @deprecated removing resources is a dubious experimental capability */
	void removeInputResources();

	/**
	 * Remove all output resources preparatory to a fresh use of the executor.
	 */
	@Deprecated /* @deprecated removing resources is a dubious experimental capability */
	void removeOutputResources();

	void saveResources(@Nullable Map<?, ?> saveOptions) throws IOException;
}
