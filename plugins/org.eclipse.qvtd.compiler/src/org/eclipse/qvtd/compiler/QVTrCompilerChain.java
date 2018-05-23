/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.qvtd.compiler.internal.qvtc2qvtu.QVTuConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTc;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory.CreateStrategy;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.runtime.evaluation.Transformer;

/**
 * The QVTcCompilerChain supports generation of a QVTi Transformation from a QVTc Transformation.
 */
public class QVTrCompilerChain extends AbstractCompilerChain
{
	protected static class Xtext2QVTrCompilerStep extends AbstractCompilerStep
	{
		public Xtext2QVTrCompilerStep(@NonNull CompilerChain compilerChain) {
			super(compilerChain, QVTR_STEP);
		}

		public @NonNull Resource execute(@NonNull URI txURI) throws IOException {
			ASResource rResource = QVTrelationUtil.loadTransformations(environmentFactory, txURI, false);
			rResource.setURI(getURI());
			// FIXME Following code fixes up missing source. Should be fixed earlier.
			List<OperationCallExp> missingOperationCallSources = QVTbaseUtil.rewriteMissingOperationCallSources(environmentFactory, rResource);
			if (missingOperationCallSources != null) {
				System.err.println("Missing OperationCallExp sources were fixed up for '" + txURI + "'");
			}
			checkForProxyURIs(rResource);
			saveResource(rResource);
			return rResource;
		}
	}

	protected static class QVTr2QVTcCompilerStep extends AbstractCompilerStep
	{
		public QVTr2QVTcCompilerStep(@NonNull CompilerChain compilerChain) {
			super(compilerChain, QVTC_STEP);
		}

		/**
		 * A derived implementation with Xtext support can override to convert asURI to csURI.
		 * @throws IOException
		 */
		protected void doQVTcSerializeAndLoad(@NonNull URI asURI, @NonNull URI csURI) throws IOException {}

		public @NonNull Resource execute(@NonNull QVTr2QVTc t, @NonNull Resource rResource) throws IOException {

			/*			QVTr2QVTrOverrides noOverrides = new QVTr2QVTrOverrides(environmentFactory);
			URI noOverridesURI = compilerChain.getURI(QVTC_STEP, URI_KEY).trimFileExtension().appendFileExtension("nooverrides.qvtras");
			Map<@NonNull String, @Nullable String> noOverridesOptions = null;//compilerChain.getOption(QVTC_STEP, QVTC_OPTIONS_KEY);
			//			String noOverridesNsURI = null;//noOverridesOptions != null ? noOverridesOptions.get(QVTC_NS_URI) : null;
			Resource noOverridesResource = createResource(noOverridesURI);
			//			if (noOverridesNsURI != null) {
			//				t.setTraceNsURI(noOverridesNsURI);
			//			}
			noOverrides.transform((ASResource)rResource, (ASResource)noOverridesResource);
			compilerChain.saveResource(noOverridesResource, name);
			//
			URI invocationsURI = compilerChain.getURI(QVTC_STEP, URI_KEY).trimFileExtension().appendFileExtension("invocations.ecore");
			Resource invocationsResource = createResource(PivotUtilInternal.getASURI(invocationsURI));
			QVTr2QVTrTops noNonTops = new QVTr2QVTrTops(environmentFactory, (ASResource)invocationsResource);
			URI noNonTopsURI = compilerChain.getURI(QVTC_STEP, URI_KEY).trimFileExtension().appendFileExtension("nonontops.qvtras");
			Map<@NonNull String, @Nullable String> noNonTopsOptions = null;//compilerChain.getOption(QVTC_STEP, QVTC_OPTIONS_KEY);
			//			String noNonTopsNsURI = null;//noOverridesOptions != null ? noOverridesOptions.get(QVTC_NS_URI) : null;
			Resource noNonTopsResource = createResource(noNonTopsURI);
			//			if (noNonTopsNsURI != null) {
			//				t.setTraceNsURI(noNonTopsNsURI);
			//			}
			noNonTops.transform((ASResource)noOverridesResource, (ASResource)noNonTopsResource);
			compilerChain.saveResource(noNonTopsResource, name);
			invocationsResource.save(null);
			AS2Ecore as2ecore = new AS2Ecore(environmentFactory, invocationsURI, null);
			XMLResource ecoreResource = as2ecore.convertResource(invocationsResource, invocationsURI);
			ecoreResource.save(null); */
			//
			CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTrEnvironmentFactory.CREATE_STRATEGY);
			try {
				URI qvtcURI = compilerChain.getURI(QVTC_STEP, URI_KEY);
				t.transformToCoreTransformations();
				Map<Object, Object> saveOptions;
				saveOptions = compilerChain.basicGetOption(QVTC_STEP, SAVE_OPTIONS_KEY);
				if (saveOptions == null) {
					saveOptions = XMIUtil.createSaveOptions();
				}
				Resource cResource = compilerChain.createResource(qvtcURI);
				t.saveCore(cResource, saveOptions);
				assertNoResourceSetErrors("Core save", cResource);
				compiled(cResource);

				if (basicGetOption(DEBUG_KEY) == Boolean.TRUE) {
					URI txURI = cResource.getURI();
					if (txURI != null) {
						URI inputURI = txURI;
						URI serializedURI = txURI.trimFileExtension().appendFileExtension("serialized.qvtc");
						doQVTcSerializeAndLoad(inputURI, serializedURI);
					}
				}
				return cResource;
			}
			finally {
				environmentFactory.setCreateStrategy(savedStrategy);
			}
		}
	}

	protected static class TraceCompilerStep extends AbstractCompilerStep
	{
		public TraceCompilerStep(@NonNull CompilerChain compilerChain) {
			super(compilerChain, TRACE_STEP);
		}

		public @NonNull Resource execute(@NonNull QVTr2QVTc t) throws IOException {
			CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTrEnvironmentFactory.CREATE_STRATEGY);
			try {
				URI traceURI = compilerChain.getURI(TRACE_STEP, URI_KEY);
				Map<@NonNull String, @Nullable String> traceOptions = compilerChain.basicGetOption(TRACE_STEP, TRACE_OPTIONS_KEY);
				String traceNsURI = traceOptions != null ? traceOptions.get(TRACE_NS_URI) : null;
				Resource traceResource = createResource(PivotUtilInternal.getASURI(traceURI));
				if (traceNsURI != null) {
					t.setTraceNsURI(traceNsURI);
				}
				//
				t.transformToTracePackages();
				Map<Object, Object> saveOptions = compilerChain.basicGetOption(TRACE_STEP, SAVE_OPTIONS_KEY);
				if (saveOptions == null) {
					saveOptions = XMIUtil.createSaveOptions();
				}
				t.saveTrace(traceResource, traceURI, traceOptions, saveOptions);
				assertNoResourceSetErrors("Trace save", traceResource);
				compiled(traceResource);
				URI genModelURI = compilerChain.basicGetURI(GENMODEL_STEP, URI_KEY);
				if (genModelURI != null) {		// FIXME Move to GenModelCompilerStep once traceResource passable
					saveOptions = compilerChain.basicGetOption(GENMODEL_STEP, SAVE_OPTIONS_KEY);
					if (saveOptions == null) {
						saveOptions = XMIUtil.createSaveOptions();
					}
					saveOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
					String modelDirectory = compilerChain.basicGetOption(GENMODEL_STEP, GENMODEL_MODEL_DIRECTORY_KEY);
					Map<@NonNull String, @Nullable String> genmodelOptions = compilerChain.basicGetOption(GENMODEL_STEP, GENMODEL_OPTIONS_KEY);
					Collection<@NonNull ? extends GenPackage> usedGenPackages = compilerChain.basicGetOption(GENMODEL_STEP, GENMODEL_USED_GENPACKAGES_KEY);
					t.saveGenModel(this, traceResource, traceURI, genModelURI, modelDirectory, genmodelOptions, saveOptions, usedGenPackages);
				}
				return traceResource;
			}
			finally {
				environmentFactory.setCreateStrategy(savedStrategy);
			}
		}

		/*		protected @NonNull GenModel executeCreateGenModel(@NonNull QVTr2QVTc t, @NonNull Resource traceResource) throws IOException {
			URI genModelURI = compilerChain.getURI(GENMODEL_STEP, URI_KEY);
			URI traceURI = compilerChain.getURI(TRACE_STEP, URI_KEY);
			Map<Object, Object> saveOptions = compilerChain.getOption(GENMODEL_STEP, SAVE_OPTIONS_KEY);
			if (saveOptions == null) {
				saveOptions = XMIUtil.createSaveOptions();
			}
			saveOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
			String modelDirectory = compilerChain.getOption(GENMODEL_STEP, GENMODEL_MODEL_DIRECTORY_KEY);
			Map<@NonNull String, @Nullable String> genmodelOptions = compilerChain.getOption(GENMODEL_STEP, GENMODEL_OPTIONS_KEY);
			Collection<@NonNull ? extends GenPackage> usedGenPackages = compilerChain.getOption(GENMODEL_STEP, GENMODEL_USED_GENPACKAGES_KEY);
			GenModel genModel = t.saveGenModel(this, traceResource, traceURI, genModelURI, modelDirectory, genmodelOptions, saveOptions, usedGenPackages);
			return genModel;
		} */
	}

	protected final @NonNull Xtext2QVTrCompilerStep xtext2qvtrCompilerStep;
	protected final @NonNull QVTr2QVTcCompilerStep qvtr2qvtcCompilerStep;
	protected final @NonNull GenModelCompilerStep genmodelCompilerStep;
	protected final @NonNull TraceCompilerStep traceCompilerStep;

	public QVTrCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI txURI, @NonNull URI prefixURI, @NonNull CompilerOptions options) {
		super(environmentFactory, txURI, prefixURI, options);
		this.xtext2qvtrCompilerStep = createXtext2QVTrCompilerStep();
		this.qvtr2qvtcCompilerStep = createQVTr2QVTcCompilerStep();
		this.genmodelCompilerStep = createGenModelCompilerStep();
		this.traceCompilerStep = createTraceCompilerStep();
	}

	@Override
	public @NonNull ImperativeTransformation compile(@NonNull String enforcedOutputName) throws IOException {
		Resource rResource = xtext2qvtrCompilerStep.execute(txURI);
		return compileQVTrAS(rResource, enforcedOutputName);
	}

	protected @NonNull ImperativeTransformation compileQVTrAS(@NonNull Resource rResource, @NonNull String enforcedOutputName) throws IOException {
		QVTr2QVTc t = new QVTr2QVTc(environmentFactory, rResource);
		t.analyze();
		@SuppressWarnings("unused")Resource traceResource = traceCompilerStep.execute(t);
		Resource cResource = qvtr2qvtcCompilerStep.execute(t, rResource);
		QVTuConfiguration qvtuConfiguration = createQVTuConfiguration(cResource, QVTuConfiguration.Mode.ENFORCE, enforcedOutputName);
		Resource pResource = qvtc2qvtm(cResource, qvtuConfiguration);
		return qvtm2qvti(pResource);
	}

	protected @NonNull GenModelCompilerStep createGenModelCompilerStep() {
		return new GenModelCompilerStep(this);
	}

	protected @NonNull QVTr2QVTcCompilerStep createQVTr2QVTcCompilerStep() {
		return new QVTr2QVTcCompilerStep(this);
	}

	protected @NonNull TraceCompilerStep createTraceCompilerStep() {
		return new TraceCompilerStep(this);
	}

	protected @NonNull Xtext2QVTrCompilerStep createXtext2QVTrCompilerStep() {
		return new Xtext2QVTrCompilerStep(this);
	}

	@Override
	public @NonNull Class<? extends Transformer> generate(@NonNull ImperativeTransformation asTransformation, @NonNull String... genModelFiles) throws Exception {
		genmodelCompilerStep.execute();
		return super.generate(asTransformation, genModelFiles);
	}
}
