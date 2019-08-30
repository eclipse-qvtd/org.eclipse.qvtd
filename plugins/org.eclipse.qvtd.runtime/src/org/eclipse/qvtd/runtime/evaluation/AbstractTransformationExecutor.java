/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.evaluation;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.AbstractModelManager;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorManager;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractTransformerInternal;
import org.eclipse.qvtd.runtime.qvttrace.TransformationExecution;

public abstract class AbstractTransformationExecutor extends ExecutorManager implements TransformationExecutor
{
	/**
	 * WrappedModelManager enables the unhelpful model access API to be observed without infecting the
	 * more streamlined QVTi accesses.
	 */
	private class WrappedModelManager extends AbstractModelManager implements ModelManager.ModelManagerExtension2
	{
		@Override
		public @NonNull Set<@NonNull ? extends Object> get(org.eclipse.ocl.pivot.@NonNull Class type) {
			return new IterableAsSet<@NonNull Object>(((AbstractTransformerInternal)transformer).get(type));
		}

		@Override
		public @NonNull Iterable<@NonNull Object> getOpposite(@NonNull Property target2sourceProperty, @NonNull Object sourceObject) {
			throw new UnsupportedOperationException();		// FIXME
		}
	}

	protected final @NonNull EnvironmentFactory environmentFactory;
	protected final @NonNull Transformer transformer;
	private WrappedModelManager wrappedModelManager = null;
	protected boolean suppressFailureDiagnosis = false;

	private AbstractTransformationExecutor(@NonNull EnvironmentFactory environmentFactory, @NonNull Constructor<? extends Transformer> txConstructor)
			throws ReflectiveOperationException {
		super(environmentFactory.getCompleteEnvironment());
		this.environmentFactory = environmentFactory;
		transformer = ClassUtil.nonNullState(txConstructor.newInstance(this));
	}

	protected AbstractTransformationExecutor(@NonNull EnvironmentFactory environmentFactory, @NonNull Class<? extends Transformer> txClass)
			throws ReflectiveOperationException {
		this(environmentFactory, ClassUtil.nonNullState(txClass.getConstructor(TransformationExecutor.class)));
	}

	@Override
	public @Nullable Resource addInputURI(@NonNull String modelName, @NonNull URI modelURI) {
		ResourceSet resourceSet = environmentFactory.getResourceSet();		// FIXME get package registrations in exteranl RespurcSet
		PivotUtil.initializeLoadOptionsToSupportSelfReferences(resourceSet);
		Resource inputResource = ClassUtil.nonNullState(resourceSet.getResource(modelURI, true));
		TypedModelInstance typedModelInstance = getTypedModelInstance(modelName);
		typedModelInstance.addInputResource(inputResource);
		return inputResource;
	}

	@Override
	public @NonNull Resource addOutputURI(@NonNull String modelName, @NonNull URI modelURI) {
		ResourceSet resourceSet;
		if (PivotUtilInternal.isASURI(modelURI)) {
			resourceSet = environmentFactory.getMetamodelManager().getASResourceSet();	// Need PivotSave to allocate xmi:ids
		}
		else {
			resourceSet = environmentFactory.getResourceSet();
		}
		TypedModelInstance typedModelInstance = getTypedModelInstance(modelName);
		Resource outputResource = ClassUtil.nonNullState(resourceSet.createResource(modelURI));
		typedModelInstance.addOutputResource(outputResource);
		return outputResource;
	}

	@Override
	public final Boolean execute(@Nullable Integer targetTypedModelIndex) throws Exception {
		transformer.analyzeInputResources();
		if (targetTypedModelIndex != null ? transformer.run(targetTypedModelIndex) : transformer.run()) {
			return Boolean.TRUE;
		}
		if (!suppressFailureDiagnosis) {						// FIXME BUG 511028
			StringBuilder s = new StringBuilder();
			transformer.getInvocationManager().diagnoseWorkLists(s);
			throw new Exception("Failed to execute" + s.toString());
		}
		return Boolean.FALSE;
	}

	@Override
	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	@Override
	public @NonNull IdResolver getIdResolver() {
		return environmentFactory.getIdResolver();
	}

	@Override
	public @NonNull MetamodelManager getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}

	@Override
	public @NonNull WrappedModelManager getModelManager() {
		WrappedModelManager wrappedModelManager2 = wrappedModelManager ;
		if (wrappedModelManager2 == null) {
			wrappedModelManager2 = wrappedModelManager = new WrappedModelManager();
		}
		return wrappedModelManager2;
	}

	@Override
	public @NonNull ModelsManager getModelsManager() {
		return transformer.getModelsManager();
	}

	@Override
	public @NonNull Transformer getTransformer() {
		return transformer;
	}

	@Override
	public int getTypedModelIndex(@NonNull String targetModelName) {
		return transformer.getTypedModelIndex(targetModelName);
	}

	@Override
	public @NonNull TypedModelInstance getTypedModelInstance(@NonNull String modelName) {
		return transformer.getTypedModelInstance(modelName);
	}

	@Override
	public @Nullable TransformationExecution getTransformationExecution() {
		return transformer.getTransformationExecution();
	}

	@Override
	public void saveModels(@Nullable Map<?, ?> saveOptions)throws IOException {
		getModelsManager().saveModels(saveOptions);
	}

	@Override
	public void setContextualProperty(@NonNull String propertyName, Object value) {
		TransformationExecution txInstance = getTransformationExecution();
		if (txInstance == null) {
			throw new IllegalArgumentException("No contextual instance available");
		}
		EClass txEClass = txInstance.eClass();
		EStructuralFeature eStructuralFeature = txEClass.getEStructuralFeature(propertyName);
		if (eStructuralFeature == null) {
			throw new IllegalArgumentException("No '" + propertyName + "' contextual property in '" + txEClass.getName());
		}
		txInstance.eSet(eStructuralFeature, value);
	}

	@Override
	public void setSuppressFailureDiagnosis(boolean suppressFailureDiagnosis) {
		this.suppressFailureDiagnosis = suppressFailureDiagnosis;
	}
}