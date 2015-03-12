package org.eclipse.qvtd.debug.evaluator;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.xtext.qvtimperative.utilities.QVTiXtextEvaluator;

/**
 * A QVTrXtextEvaluator supports loading a QVTr transformation as source then loading models, performing a transformation
 * and then saving the models.
 * 
 * @see QVTiXtextEvaluator
 */
public class QVTrXtextEvaluator extends QVTiXtextEvaluator
{
    public QVTrXtextEvaluator(@NonNull QVTiEnvironmentFactory envFactory, @NonNull URI transformationURI) throws IOException {
    	super(envFactory, loadTransformation(RelationModel.class, envFactory, transformationURI, envFactory.keepDebug()));
    }
}
