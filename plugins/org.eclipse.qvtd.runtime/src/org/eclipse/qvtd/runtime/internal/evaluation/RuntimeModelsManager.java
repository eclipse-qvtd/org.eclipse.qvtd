/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.internal.evaluation;


import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ArrayIterable;
import org.eclipse.qvtd.runtime.evaluation.AbstractModelsManager;
import org.eclipse.qvtd.runtime.evaluation.AbstractObjectManager;
import org.eclipse.qvtd.runtime.evaluation.AbstractTypedModelInstance;
import org.eclipse.qvtd.runtime.evaluation.InvalidEvaluationException;
import org.eclipse.qvtd.runtime.evaluation.TypedModelInstance;
import org.eclipse.qvtd.runtime.qvtruntimelibrary.Extent;
import org.eclipse.qvtd.runtime.qvtruntimelibrary.QVTruntimeLibraryFactory;

/**
 * The abstract implementation of an auto-generated transformation provides the shared infrastructure for maintaining
 * models and deferring invocation of not-ready mapping invocations.
 */
public class RuntimeModelsManager extends AbstractModelsManager
{
	public static class Model extends AbstractTypedModelInstance
	{
		public static class Incremental extends Model
		{
			public Incremental(@NonNull RuntimeModelsManager transformer, @NonNull String name) {
				super(transformer, name);
			}

			@Override
			public void remove(@NonNull EObject eObject) {
				super.remove(eObject);
				rootObjects.remove(eObject);
				if (classIndex2connection != null) {
					getEClassAnalysis(eObject).unpropagate(eObject);
				}
			}
		}

		public Model(@NonNull RuntimeModelsManager modelsManager, @NonNull String name) { // FIXME Bug 540500 per-model classIndex2classId etc
			super(modelsManager, name);
		}

		@Override
		protected void addExtent() {
			Extent extent = QVTruntimeLibraryFactory.eINSTANCE.createExtent();
			List<Object> elements = extent.getElements();
			assert elements != null;
			addExtent(extent, elements);
		}

		/**
		 * Return the elements of a root Extent object, iff rootObject is an Extent.
		 * Return null otherwise.
		 */
		@Override
		protected @Nullable Iterable<@NonNull EObject> getExtentElements(@NonNull EObject rootObject) {
			if (rootObject instanceof Extent) {
				@SuppressWarnings("unchecked")
				Iterable<@NonNull EObject> elements = (Iterable<@NonNull EObject>)(Object)((Extent)rootObject).getElements();
				return elements;
			}
			else {
				return null;
			}
		}
	}

	protected final @NonNull Model @NonNull [] models;

	protected RuntimeModelsManager(int models) {
		this.models = new @NonNull Model [models];

	}

	public @NonNull Model @NonNull [] getModels() {
		return models;
	}

	@Override
	public @NonNull Model getTypedModelInstance(@NonNull String modelName) {
		for (@NonNull Model model : models) {
			if (modelName.equals(model.getName())) {
				return model;
			}
		}
		throw new IllegalStateException("Unknown model name '" + modelName + "'");
	}

	public int getTypedModelIndex(@NonNull String targetModelName) {
		int index = 0;
		for (@NonNull Model model : models) {
			if (targetModelName.equals(model.getName())) {
				return index;
			}
			index++;
		}
		throw new IllegalStateException("Unknown model name '" + targetModelName + "'");
	}

	@Override
	public @NonNull Iterable<@NonNull TypedModelInstance> getTypedModelInstances() {
		return new ArrayIterable<@NonNull TypedModelInstance>(models);
	}

	public void initTypedModelInstance(int i, @NonNull Model model) {
		models[i] = model;
	}

	public @NonNull Object throwInvalidEvaluationException(@NonNull String message, Object... bindings) {
		throw new InvalidEvaluationException(message, bindings);
	}

	/**
	 * Return the string rendering of object for use in debug messages. The default just invokes String.valueOf().
	 * Derived implementations may provide metamodel-specific content.
	 */
	protected @NonNull String toDebugString(@Nullable Object object) {
		return AbstractObjectManager.toDebugString(object);
	}
}
