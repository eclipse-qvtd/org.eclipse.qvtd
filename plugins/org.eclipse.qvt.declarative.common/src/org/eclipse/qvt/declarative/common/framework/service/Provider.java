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
 * $Id: Provider.java,v 1.3 2008/10/09 17:21:03 qglineur Exp $
 */
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
