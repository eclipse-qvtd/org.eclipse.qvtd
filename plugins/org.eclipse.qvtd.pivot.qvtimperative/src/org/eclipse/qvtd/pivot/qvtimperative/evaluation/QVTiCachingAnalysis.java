package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.internal.evaluation.CachingAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

/**
 * The CachingAnalysis sets VariableDeclaration.cacheNeeded for colletion variables that are accessed more than once.
 */
public class QVTiCachingAnalysis extends CachingAnalysis
{
	public static void analyze(@NonNull Transformation qvtiTransformation) {
		for (@NonNull Rule rule : QVTbaseUtil.getRule(qvtiTransformation)) {
			QVTiCachingAnalysis cachingAnalysis = new QVTiCachingAnalysis(rule);
			cachingAnalysis.analyze();
		}
	}

	protected QVTiCachingAnalysis(@NonNull Element rootElement) {
		super(rootElement);
	}
}