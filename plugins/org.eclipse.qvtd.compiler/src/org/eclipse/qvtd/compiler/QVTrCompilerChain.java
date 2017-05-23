/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
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

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
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
			//			Transformation loadTransformation = QVTrelationUtil.loadTransformation(environmentFactory, txURI, false);
			//			Resource rResource = ClassUtil.nonNullState(loadTransformation.eResource());
			Resource rResource = QVTrelationUtil.loadTransformations(environmentFactory, txURI, false);
			// FIXME Following code fixes up missing source. Should be fixed earlier.
			List<OperationCallExp> missingOperationCallSources = QVTbaseUtil.rewriteMissingOperationCallSources(environmentFactory, rResource);
			if (missingOperationCallSources != null) {
				System.err.println("Missing OperationCallExp sources were fixed up for '" + txURI + "'");
			}
			compiled(rResource);
			//			saveResource(rResource, QVTR_STEP); -- causes test failures
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

		public @NonNull Resource execute(@NonNull QVTr2QVTc t, @NonNull Resource rResource, @NonNull Resource cResource) throws IOException {
			CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTrEnvironmentFactory.CREATE_STRATEGY);
			try {
				// FIXME next few lines should be classURI != null, but a test fails in combination (? due to global registry leakage)
				//		URI classURI = getURI(CLASS_STEP, URI_KEY);
				//				URI classURI = compilerChain.getOption(CLASS_STEP, URI_KEY);
				//				URI qvtcURI = compilerChain.getURI(QVTC_STEP, URI_KEY);
				//
				t.transformToCoreTransformations();
				Map<Object, Object> saveOptions;
				saveOptions = compilerChain.getOption(QVTR_STEP, SAVE_OPTIONS_KEY);
				if (saveOptions == null) {
					saveOptions = XMIUtil.createSaveOptions();
				}
				t.saveCore(cResource, saveOptions);
				assertNoResourceSetErrors("Core save", cResource);
				compiled(cResource);

				if (getOption(DEBUG_KEY) == Boolean.TRUE) {
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

		public void execute(@NonNull QVTr2QVTc t) throws IOException {
			CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTrEnvironmentFactory.CREATE_STRATEGY);
			try {
				URI genModelURI = compilerChain.getURI(GENMODEL_STEP, URI_KEY);
				URI traceURI = compilerChain.getURI(TRACE_STEP, URI_KEY);
				Map<@NonNull String, @Nullable String> traceOptions = compilerChain.getOption(TRACE_STEP, TRACE_OPTIONS_KEY);
				String traceNsURI = traceOptions != null ? traceOptions.get(TRACE_NS_URI) : null;
				Resource traceResource = createResource(PivotUtilInternal.getASURI(traceURI));
				if (traceNsURI != null) {
					t.setTraceNsURI(traceNsURI);
				}
				//
				t.transformToTracePackages();
				Map<Object, Object> saveOptions = compilerChain.getOption(TRACE_STEP, SAVE_OPTIONS_KEY);
				if (saveOptions == null) {
					saveOptions = XMIUtil.createSaveOptions();
				}
				t.saveTrace(traceResource, traceURI, genModelURI, traceOptions, saveOptions);
				assertNoResourceSetErrors("Trace save", traceResource);
				compiled(traceResource);
				saveOptions = compilerChain.getOption(GENMODEL_STEP, SAVE_OPTIONS_KEY);
				if (saveOptions == null) {
					saveOptions = XMIUtil.createSaveOptions();
				}
				saveOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
				Collection<@NonNull ? extends GenPackage> usedGenPackages = compilerChain.getOption(GENMODEL_STEP, GENMODEL_USED_GENPACKAGES_KEY);
				t.saveGenModel(this, traceResource, traceURI, genModelURI, compilerChain.getOption(GENMODEL_STEP, GENMODEL_OPTIONS_KEY), saveOptions, usedGenPackages);
			}
			finally {
				environmentFactory.setCreateStrategy(savedStrategy);
			}
		}

		protected @NonNull GenModel executeCreateGenModel(@NonNull QVTr2QVTc t, @NonNull Resource traceResource) throws IOException {
			URI genModelURI = compilerChain.getURI(GENMODEL_STEP, URI_KEY);
			URI traceURI = compilerChain.getURI(TRACE_STEP, URI_KEY);
			Map<Object, Object> saveOptions = compilerChain.getOption(GENMODEL_STEP, SAVE_OPTIONS_KEY);
			if (saveOptions == null) {
				saveOptions = XMIUtil.createSaveOptions();
			}
			saveOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
			Collection<@NonNull ? extends GenPackage> usedGenPackages = compilerChain.getOption(GENMODEL_STEP, GENMODEL_USED_GENPACKAGES_KEY);
			GenModel genModel = t.saveGenModel(this, traceResource, traceURI, genModelURI, compilerChain.getOption(GENMODEL_STEP, GENMODEL_OPTIONS_KEY), saveOptions, usedGenPackages);
			return genModel;
		}
	}

	protected final @NonNull Xtext2QVTrCompilerStep xtext2qvtrCompilerStep;
	protected final @NonNull QVTr2QVTcCompilerStep qvtr2qvtcCompilerStep;
	protected final @NonNull GenModelCompilerStep genmodelCompilerStep;
	protected final @NonNull TraceCompilerStep traceCompilerStep;

	public QVTrCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI txURI, @Nullable Map<@NonNull String, @Nullable Map<@NonNull Key<Object>, @Nullable Object>> options) {
		super(environmentFactory, txURI, options);
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
		URI qvtcURI = getURI(QVTC_STEP, URI_KEY);
		Resource cResource1 = createResource(qvtcURI);
		QVTr2QVTc t = new QVTr2QVTc(environmentFactory, rResource, cResource1);
		t.prepare();
		traceCompilerStep.execute(t);
		Resource cResource = qvtr2qvtcCompilerStep.execute(t, rResource, cResource1);
		QVTuConfiguration qvtuConfiguration = createQVTuConfiguration(cResource, QVTuConfiguration.Mode.ENFORCE, enforcedOutputName);
		//		setOption(QVTU_STEP, QVTU_CONFIGURATION_KEY, qvtuConfiguration);
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
