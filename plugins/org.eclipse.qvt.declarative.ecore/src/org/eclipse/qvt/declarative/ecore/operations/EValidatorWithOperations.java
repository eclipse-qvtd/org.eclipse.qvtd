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
 * $Id: EValidatorWithOperations.java,v 1.1 2008/09/09 20:53:23 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.operations;

import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EValidator;

/**
 * EValidatorWithOperations provides an extended interface for a derived EObjectValidator
 * that is useful when the validation functionality is placed in separate Operations
 * classes and also useful for test harnesses.
 */
public interface EValidatorWithOperations extends EValidator
{
	public String getDiagnosticSource();
	public ResourceLocator getResourceLocator();
}
