package org.eclipse.qvtd.debug.launching;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.debug.core.QVTiEvaluationContext;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.xtext.qvtimperative.utilities.QVTiXtextEvaluator;

/**
 * Internal transformation executor
 * 
 * @since 3.0
 */
public class QVTiInternalDebuggableExecutor extends InternalDebuggableExecutor
{
	protected final @NonNull QVTiEvaluationContext evaluationContext;
	
	public QVTiInternalDebuggableExecutor(@NonNull QVTiEvaluationContext evaluationContext, @NonNull QVTiEnvironmentFactory envFactory) {
		super(envFactory, evaluationContext.getTransformationURI());
		this.evaluationContext = evaluationContext;
	}

	protected @NonNull QVTiXtextEvaluator createEvaluator() throws IOException {
		QVTiXtextEvaluator evaluator = new QVTiXtextEvaluator((QVTiEnvironmentFactory) envFactory, evaluationContext.getTransformationURI());
		for (Map.Entry<String, URI> inEntry : evaluationContext.getInputURIs().entrySet()) {
			@SuppressWarnings("null")@NonNull String inKey = inEntry.getKey();
			@SuppressWarnings("null")@NonNull URI inURI = inEntry.getValue();
			evaluator.loadModel(inKey, inURI, null);
		}
		for (Map.Entry<String, URI> outEntry : evaluationContext.getOutputURIs().entrySet()) {
			@SuppressWarnings("null")@NonNull String outKey = outEntry.getKey();
			@SuppressWarnings("null")@NonNull URI outURI = outEntry.getValue();
			evaluator.createModel(outKey, outURI, null);
		}
		return evaluator;
	}
}
