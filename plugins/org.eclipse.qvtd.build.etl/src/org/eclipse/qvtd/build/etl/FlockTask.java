package org.eclipse.qvtd.build.etl;

import java.net.URI;
import java.util.ArrayList;

import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.flock.FlockModule;

public class FlockTask extends EpsilonTask {
	
	
	public FlockTask(URI etlSourceURI) {
		super();
		this.sourceURI = etlSourceURI;
		models = new ArrayList<IModel>();
	}

	public FlockTask(String etlSourcePath) {
		super();
		this.sourceURI = URI.create(etlSourcePath);
		models = new ArrayList<IModel>();
	}
	
	@Override
	public IEolExecutableModule createModule() {
		// TODO Auto-generated method stub
		return new FlockModule();
	}
	
}
