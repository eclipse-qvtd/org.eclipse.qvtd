package org.eclipse.qvt.declarative.execution;

public interface NamedModel<M> {
	
	public String getName();
	
	public M getModel();
	
	public M getMetamodel();

}
