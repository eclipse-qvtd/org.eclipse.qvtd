package org.eclipse.qvt.declarative.common.framework.service;

/**
 * Base interface for providers. This interface is intended to be specialized to
 * described a service. A service delegates call to the provider implementation.
 * 
 * @author Quentin Glineur
 * 
 */
public interface Provider {

	/**
	 * Indicates whether the provider support the given operation .
	 * 
	 * @param operation
	 *            The operation to test for support.
	 * @return true if the providers support the operation, false otherwise.
	 */
	public boolean provides(Operation operation);

}
