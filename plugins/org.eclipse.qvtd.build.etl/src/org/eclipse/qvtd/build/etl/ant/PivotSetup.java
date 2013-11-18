package org.eclipse.qvtd.build.etl.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.PivotStandaloneSetup;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;

public class PivotSetup extends Task {
	
	private MetaModelManager metaModelManager;
	protected ResourceSet resourceSet;

	public void execute() throws BuildException {
		
		PivotStandaloneSetup.doSetup();
		//metaModelManager = new MetaModelManager();
        //MetaModelManagerResourceSetAdapter.getAdapter(DomainUtil.nonNullState(resourceSet), metaModelManager);
		//resourceSet = new ResourceSetImpl();
		//MetaModelManager.initializeASResourceSet(resourceSet);
		System.out.println("Pivot Setup done.");
        
    }

}
