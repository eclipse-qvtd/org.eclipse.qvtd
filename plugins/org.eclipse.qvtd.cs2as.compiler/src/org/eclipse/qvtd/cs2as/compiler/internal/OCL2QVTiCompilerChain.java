/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.AbstractCompilerChain;
import org.eclipse.qvtd.compiler.AbstractCompilerStep;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.internal.common.SimpleConfigurations;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfigurations;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;

public class OCL2QVTiCompilerChain extends AbstractCompilerChain {

	public static class OCL2QVTmCompilerStep extends AbstractCompilerStep  // FIXME split into multiple steps
	{
		private @NonNull URI oclASUri;
		private @NonNull List<@NonNull URI> extendedASUris = new ArrayList<>();
		private @NonNull String traceabilityPropName;

		public OCL2QVTmCompilerStep(@NonNull CompilerChain compilerChain, @NonNull QVTimperative qvti,
				@Nullable CompilerOptions options, @NonNull URI oclDocURI, @NonNull URI... extendedDocURIs) throws CompilerChainException {
			super(compilerChain, QVTM_STEP);
			this.traceabilityPropName = getTraceabilityPropertyName();
			ResourceSet externalResourceSet = qvti.getResourceSet();
			CSResource csResource = (CSResource) externalResourceSet.getResource(oclDocURI, true);
			if (csResource == null) {
				throw new CompilerChainException("Failed to parse " + oclDocURI);
			}
			ASResource asResource = qvti.cs2as(csResource);
			this.oclASUri = ClassUtil.nonNullState(asResource.getURI());
			for (@NonNull URI extendedDocURI : extendedDocURIs) {
				csResource = (CSResource) externalResourceSet.getResource(extendedDocURI, true);
				if (csResource == null) {
					throw new CompilerChainException("Failed to parse " + extendedDocURI);
				}
				asResource = qvti.cs2as(csResource);
				this.extendedASUris.add(ClassUtil.nonNullState(asResource.getURI())); // We add the AS URI
			}
			StringBuilder s = null;
			for (/*@NonNull*/ Resource resource : externalResourceSet.getResources()) {
				if (resource.getErrors().size() > 0) {
					if (s == null) {
						s = new StringBuilder();
					}
					s.append(PivotUtil.formatResourceDiagnostics(resource.getErrors(), "\nErrors in " + resource.getURI(), "\n\t"));
				}
			}
			if (s != null) {
				throw new CompilerChainException(s.toString());
			}
		}

		public @NonNull Resource ocl2qvtm(@NonNull URI oclURI) throws IOException {
			QVTbaseEnvironmentFactory environmentFactory = getEnvironmentFactory();
			OCL2QVTm ocl2qvtm = new OCL2QVTm(environmentFactory, traceabilityPropName);
			Resource pResource = ocl2qvtm.run(environmentFactory.getMetamodelManager().getASResourceSet(), oclURI, getURI());
			saveResource(pResource);
			return pResource;
		}

		protected @NonNull Resource execute(@NonNull QVTbaseEnvironmentFactory environmentFactory) throws IOException {
			Resource mModel = ocl2qvtm(oclASUri);
			if (!extendedASUris.isEmpty()) {
				List<Resource> qvtmModels = new ArrayList<Resource>();
				for (URI extendedQVTpModel : extendedASUris) {
					qvtmModels.add(ocl2qvtm(extendedQVTpModel));
				}
				QVTmModelsMerger.merge(environmentFactory , mModel, qvtmModels);
				saveResource(mModel);
				for(Resource qvtmModel : qvtmModels) {	// unload unnecessary qvtmModels
					qvtmModel.unload();
				}
			}
			return mModel;
		}

		private @NonNull String getTraceabilityPropertyName() {
			String tracePropName = compilerChain.basicGetOption(QVTM_STEP, TRACE_PROPERTY_NAME_KEY);
			return tracePropName == null ? DEFAULT_TRACE_PROPERTY_NAME : tracePropName;
		}
	}

	public static final @NonNull String DEFAULT_TRACE_PROPERTY_NAME = "ast";
	public static final CompilerOptions.@NonNull Key<String> TRACE_PROPERTY_NAME_KEY = new CompilerOptions.Key<String>("ocl2qvtm.tracePropName");

	public final @NonNull OCL2QVTmCompilerStep ocl2qvtmCompilerStep;

	/**
	 * To provide a different traceabilityPropName different to the default {@link OCL2QVTiCompilerChain#DEFAULT_TRACE_PROPERTY_NAME "ast"} one,
	 * it must be passed as an option using the {@link #TRACE_PROPERTY_NAME_KEY TRACE_PROPERTY_NAME_KEY} and the {@link CompilerChain#QVTP_STEP QVTP_STEP}
	 *
	 * @param qvti mandatory {@link QVTimperative} instance
	 * @param options optional options
	 * @param oclDocURI the mandatory main OCL document URI to compile
	 * @param extendedDocURIs optional OCL document URIs that the main one extends
	 * @throws CompilerChainException
	 */
	public OCL2QVTiCompilerChain(@NonNull QVTimperative qvti, @NonNull CompilerOptions options,
			@NonNull URI oclDocURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull URI... extendedDocURIs) throws CompilerChainException {
		super(oclDocURI, intermediateFileNamePrefixURI, options);
		this.ocl2qvtmCompilerStep = new OCL2QVTmCompilerStep(this, qvti, options, oclDocURI, extendedDocURIs);
	}

	@Override
	public @NonNull ImperativeTransformation compile(@NonNull TypedModelsConfigurations typedModelsConfigurations) throws IOException {
		QVTbaseEnvironmentFactory environmentFactory = ocl2qvtmCompilerStep.getEnvironmentFactory();
		TypedModelsConfiguration typedModelsConfiguration = typedModelsConfigurations.iterator().next();
		return qvtm2qvti(environmentFactory, ocl2qvtmCompilerStep.execute(environmentFactory), typedModelsConfiguration);
	}

	public @NonNull ImperativeTransformation compile(@NonNull String enforcedModelName) throws IOException {
		SimpleConfigurations typedModelsConfigurations = new SimpleConfigurations(enforcedModelName);
		return compile(typedModelsConfigurations);
	}

	@Override
	protected @NonNull ImperativeTransformation qvtm2qvti(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull Resource pResource, @NonNull TypedModelsConfiguration typedModelsConfiguration) throws IOException {
		rewriteSafeNavigations(environmentFactory, pResource);
		return super.qvtm2qvti(environmentFactory, pResource, typedModelsConfiguration);
	}

	// FIXME this workaround produces a new traversal of the resource
	private void rewriteSafeNavigations(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull Resource resource) {
		QVTcoreHelper helper = new QVTcoreHelper(environmentFactory);		// FIXME Re-use a helper
		for (EObject rootObject : resource.getContents()) {
			if (rootObject instanceof Element) {
				helper.rewriteSafeNavigations((Element) rootObject);
			}
		}
	}
}
