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
 * $Id: AbstractOperations.java,v 1.3 2008/12/31 17:38:40 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.operations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;


/**
 * AbstractOperations provides shared functionality that derived classes
 * implementing Validator checking may find useful.
 */
public abstract class AbstractOperations
{
	public static final String UNRESOLVED_PACKAGE_NAME = "$unresolved$";
	
	/**
	 * Return true if eObject is an unresolved object. i.e. if eObject has the
	 * root unresolved package as an ancestor.
	 */
	public boolean isUnresolved(EObject eObject) {
		if (eObject == null)
			return false;
		EObject rootObject = eObject;
		for (; (rootObject.eContainer()) != null; rootObject = rootObject.eContainer())
			;
		return (rootObject instanceof EPackage) && UNRESOLVED_PACKAGE_NAME.equals(((EPackage) rootObject).getName());
	}
}