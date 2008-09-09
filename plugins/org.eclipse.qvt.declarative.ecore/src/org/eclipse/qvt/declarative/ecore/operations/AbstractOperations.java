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
 * $Id: AbstractOperations.java,v 1.1 2008/09/09 20:53:23 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * AbstractOperations provides shared functionality that derived classes
 * implementing Validator checking may find useful.
 */
public class AbstractOperations
{
	public static final String ECORE_DIAGNOSTIC_SOURCE = EObjectValidator.DIAGNOSTIC_SOURCE;

	protected final EValidatorWithOperations validator;
	
	protected AbstractOperations(EValidatorWithOperations validator) {
		this.validator = validator;
	}

	protected Diagnostic createDiagnostic(int severity, String source, int code, String messageKey, Object[] messageSubstitutions, Object[] data, Map<Object, Object> context) {
		String message = ECORE_DIAGNOSTIC_SOURCE.equals(source) ?
					getEcoreString(messageKey, messageSubstitutions) :
						getString(messageKey, messageSubstitutions);
					return new BasicDiagnostic(severity, source, code, message, data);
	}
	
	protected String getEcoreString(String key, Object [] substitutions) {
		return getString(EcorePlugin.INSTANCE, key, substitutions);
	}

	protected Object getObjectLabel(EObject eObject, Map<Object, Object> context) {
		return EObjectValidator.getObjectLabel(eObject, context);
	}
	
	protected String getString(String key, Object [] substitutions) {
		if ("_UI_GenericConstraint_diagnostic".equals(key))
			return getString(EcorePlugin.INSTANCE, key, substitutions);
		else
			return getString(validator.getResourceLocator(), key, substitutions);
	}

	private String getString(ResourceLocator resourceLocator, String key, Object [] substitutions) {
		if (substitutions == null)
			return resourceLocator.getString(key);
		else
			return resourceLocator.getString(key, substitutions);
	}
}