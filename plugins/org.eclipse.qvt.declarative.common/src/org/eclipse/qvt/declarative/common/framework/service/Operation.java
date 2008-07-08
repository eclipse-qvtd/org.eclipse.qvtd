package org.eclipse.qvt.declarative.common.framework.service;

/**
 * An operation represent a call to a provider functionality.
 * 
 * @author Quentin Glineur
 * 
 */
public interface Operation {

	/**
	 * Effectively call the operation by delegating to a given provider.
	 * 
	 * @param provider
	 *            The provider that will perform the action represented by the
	 *            operation.
	 * @return Whatever the delegated execution should return.
	 * @throws Exception
	 *             Any exception the delegated execution should raise.
	 */
	public Object execute(Provider provider) throws Exception;

}
