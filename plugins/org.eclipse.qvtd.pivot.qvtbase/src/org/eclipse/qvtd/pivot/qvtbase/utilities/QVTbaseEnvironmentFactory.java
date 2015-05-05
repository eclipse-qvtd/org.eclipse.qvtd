package org.eclipse.qvtd.pivot.qvtbase.utilities;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.pivot.qvtbase.model.QVTbaseLibrary;

public class QVTbaseEnvironmentFactory extends PivotEnvironmentFactory {

	public QVTbaseEnvironmentFactory(@NonNull ProjectManager projectManager,
			@Nullable ResourceSet externalResourceSet) {
		super(projectManager, externalResourceSet);
		getStandardLibrary().setDefaultStandardLibraryURI(QVTbaseLibrary.STDLIB_URI);
	}

}
