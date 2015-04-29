package org.eclipse.qvtd.pivot.qvtbase.utilities;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.pivot.qvtbase.model.QVTbaseLibrary;

public class QVTbase extends OCLInternal
{	
	public static @NonNull QVTbase newInstance(@NonNull ProjectManager projectManager, @Nullable ResourceSet externalResourceSet) {	
		EnvironmentFactoryInternal environmentFactory = ASResourceFactoryRegistry.INSTANCE.createEnvironmentFactory(projectManager, externalResourceSet);
		environmentFactory.getStandardLibrary().setDefaultStandardLibraryURI(QVTbaseLibrary.STDLIB_URI);
		QVTbase qvt = new QVTbase(environmentFactory);
		if (externalResourceSet != null) {
			environmentFactory.adapt(externalResourceSet);
		}
		return qvt;
	}
	public QVTbase(@NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory);
	}
}