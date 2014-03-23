package org.eclipse.qvtd.debug.evaluator;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.evaluator.XtextEvaluator;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.xtext.qvtimperative.utilities.QVTiXtextEvaluator;

public class QVTiXtextEvaluator2 extends QVTiXtextEvaluator implements XtextEvaluator<Transformation>
{
	public QVTiXtextEvaluator2(@NonNull QVTiEnvironmentFactory envFactory, @NonNull URI transformationURI) throws IOException {
		super(envFactory, transformationURI);
	}

	@Override
	public @NonNull Transformation getDebuggable() {
		return getTransformation();
	}
}
