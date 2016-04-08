/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.qvtd.compiler.internal.etl.mtc.QVTuConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrToQVTc;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * The QVTcCompilerChain supports generation of a QVTi Transformation from a QVTc Transformation.
 */
public class QVTrCompilerChain extends AbstractCompilerChain
{
	public QVTrCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI prefixURI, @Nullable Map<@NonNull String, @NonNull Map<@NonNull Key<?>, @Nullable Object>> options) {
		super(environmentFactory, prefixURI, options);
	}

	@Override
	public @NonNull Transformation compile(@NonNull String enforcedOutputName) throws IOException {
//		Transformation loadTransformation = QVTrelationUtil.loadTransformation(environmentFactory, txURI, false);
//		Resource rResource = ClassUtil.nonNullState(loadTransformation.eResource());
		Resource rResource = QVTrelationUtil.loadTransformations(environmentFactory, txURI, false);
        // FIXME Following code fixes up missing source. Should be fixed earlier.
        List<OperationCallExp> missingOperationCallSources = QVTbaseUtil.rewriteMissingOperationCallSources(environmentFactory, rResource);
        if (missingOperationCallSources != null) {
        	System.err.println("Missing OperationCallExp sources  were fixed up for '" + txURI + "'");
        }
//		compiled(QVTR_STEP, rResource);
		Resource cResource = qvtr2qvtc(rResource);
		assert cResource != null;
		QVTuConfiguration qvtuConfiguration = createQVTuConfiguration(cResource, QVTuConfiguration.Mode.ENFORCE, enforcedOutputName);
		Resource pResource = qvtc2qvtp(cResource, qvtuConfiguration);
		return qvtp2qvti(pResource);
	}

	private @NonNull Resource qvtr2qvtc(@NonNull Resource rResource) throws IOException {
		URI qvtcURI = getURI(QVTC_STEP, URI_KEY);
		URI traceURI = getURI(TRACE_STEP, URI_KEY);
		URI genModelURI = getURI(GENMODEL_STEP, URI_KEY);
		Map<@NonNull String, @Nullable String> traceOptions = getOption(TRACE_STEP, TRACE_OPTIONS_KEY);
		String traceNsURI = traceOptions != null ? traceOptions.get(TRACE_NS_URI) : null;
		Resource cResource = createResource(qvtcURI);
		Resource traceResource = createResource(PivotUtilInternal.getASURI(traceURI));
    	QVTrToQVTc t = new QVTrToQVTc(environmentFactory, rResource, cResource);
    	if (traceNsURI != null) {
    		t.setTraceNsURI(traceNsURI);
    	}
		t.prepare();
		t.execute();
		Map<Object, Object> saveOptions = getOption(TRACE_STEP, SAVE_OPTIONS_KEY);
		if (saveOptions == null) {
			saveOptions = XMIUtil.createSaveOptions();
		}
		t.saveTrace(traceResource, traceURI, genModelURI, traceOptions, saveOptions);
        assertNoResourceErrors("Trace save", traceResource);
		compiled(TRACE_STEP, cResource);
		saveOptions = getOption(QVTR_STEP, SAVE_OPTIONS_KEY);
		if (saveOptions == null) {
			saveOptions = XMIUtil.createSaveOptions();
		}
        t.saveCore(cResource, saveOptions);
        assertNoResourceErrors("Core save", cResource);
		compiled(QVTC_STEP, cResource);
//		if (genModelURI != null) {
			saveOptions = getOption(GENMODEL_STEP, SAVE_OPTIONS_KEY);
			if (saveOptions == null) {
				saveOptions = XMIUtil.createSaveOptions();
			}
			saveOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
		    t.saveGenModel(traceResource, traceURI, genModelURI, getOption(GENMODEL_STEP, GENMODEL_OPTIONS_KEY), saveOptions);
			compiled(GENMODEL_STEP, cResource);
//		}
		return cResource;
	}
}
