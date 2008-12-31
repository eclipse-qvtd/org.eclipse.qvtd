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
 * $Id: EcoreValidatorWithOperations.java,v 1.1 2008/12/31 17:38:40 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;

public class EcoreValidatorWithOperations implements EValidatorWithOperations
{
	public static final String ECORE_DIAGNOSTIC_SOURCE = EObjectValidator.DIAGNOSTIC_SOURCE;
	public static final EcoreValidatorWithOperations INSTANCE = new EcoreValidatorWithOperations();

	public String getDiagnosticSource() {
		return ECORE_DIAGNOSTIC_SOURCE;
	}

	public ResourceLocator getResourceLocator() {
		return EcorePlugin.INSTANCE;
	}

	public boolean validate(EObject object, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean validate(EClass class1, EObject object,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean validate(EDataType dataType, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO Auto-generated method stub
		return false;
	}
}