package org.eclipse.qvtd.cs2as.compiler.qvti;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.TransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiPivotEvaluator;

public class QVTiFacade extends OCL {
	
	protected QVTiFacade(@NonNull QVTiEnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	@Override
	public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
		return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
	}
	
	public @NonNull QVTiPivotEvaluator createEvaluator(Transformation transformation) {
		return new QVTiPivotEvaluator(getEnvironmentFactory(), transformation);
	}
	
	
	public @NonNull QVTiTxEvaluator createTxEvaluator(Class<? extends TransformationExecutor> txClass)
			throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return new QVTiTxEvaluator(environmentFactory.getCompleteEnvironment(), txClass);
	}	
	
	public static QVTiFacade createInstance(ProjectManager projectManager, ResourceSet rSet) {
		return new QVTiFacade(new QVTiEnvironmentFactory(projectManager, rSet));
	}
}
