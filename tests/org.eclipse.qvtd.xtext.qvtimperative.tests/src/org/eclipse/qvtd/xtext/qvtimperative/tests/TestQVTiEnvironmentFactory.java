package org.eclipse.qvtd.xtext.qvtimperative.tests;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

public class TestQVTiEnvironmentFactory extends QVTiEnvironmentFactory
{
	public TestQVTiEnvironmentFactory(@NonNull ProjectManager projectMap, @Nullable ResourceSet externalResourceSet) {
		super(projectMap, externalResourceSet);
    	setEvaluationTracingEnabled(true);
	}
}