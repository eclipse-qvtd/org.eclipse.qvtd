package org.eclipse.qvtd.debug.evaluator;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.xtext.qvtimperative.utilities.QVTiXtextEvaluator;

/**
 * A QVTcXtextEvaluator supports loading a QVTc transformation as source then loading models, performing a transformation
 * and then saving the models.
 * 
 * @see QVTiXtextEvaluator
 */
public class QVTcXtextEvaluator extends QVTiXtextEvaluator
{
    public QVTcXtextEvaluator(@NonNull QVTiEnvironmentFactory envFactory, @NonNull URI transformationURI) throws IOException {
    	super(envFactory, loadTransformation(CoreModel.class, envFactory, transformationURI, envFactory.keepDebug()));
    }
}
