/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * </copyright>
 * 
 * Contributors:
 *     Quentin Glineur - initial API and implementation
 *
 * $Id: Operation.java,v 1.4 2008/10/09 17:21:03 qglineur Exp $
 */
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
