/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.test.emof.emof;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;

public abstract class AbstractEMOFValidationTest extends TestCase
{
	public static final org.eclipse.emf.ecore.EcoreFactory Ecore_Factory = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE;

	protected EParameter createEParameter(EOperation eOperation, String name, EClassifier eType) {
		EParameter eParameter = Ecore_Factory.createEParameter();
		eParameter.setName(name);
		eParameter.setEType(eType);
		if (eOperation != null)
			eOperation.getEParameters().add(eParameter);
		return eParameter;
	}
}
