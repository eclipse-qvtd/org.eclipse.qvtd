/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: NotAdapterException.java,v 1.2 2008/08/08 17:00:10 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.adapters;

import org.eclipse.emf.ecore.EObject;

public class NotAdapterException extends IllegalStateException
{
	private static final long serialVersionUID = 1L;

	public NotAdapterException(EObject object) {
		super("Adapter not in use for '" + object.eClass().getEPackage().getNsURI() + "':" + object.eClass().getName());
	}
}
