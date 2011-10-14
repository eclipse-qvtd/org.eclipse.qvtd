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
 * $Id: AbstractEcoreOperations.java,v 1.1 2008/12/31 17:38:40 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.operations;

import org.eclipse.emf.ecore.util.EObjectValidator;

public abstract class AbstractEcoreOperations extends AbstractOperations
{
	public static final String DIAGNOSTIC_SOURCE = EObjectValidator.DIAGNOSTIC_SOURCE;
}