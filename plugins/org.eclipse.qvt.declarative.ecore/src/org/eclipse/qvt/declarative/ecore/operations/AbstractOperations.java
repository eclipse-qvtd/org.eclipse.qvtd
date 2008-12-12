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
 * $Id: AbstractOperations.java,v 1.2 2008/12/12 15:30:23 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.operations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * AbstractOperations provides shared functionality that derived classes
 * implementing Validator checking may find useful.
 */
public abstract class AbstractOperations
{
	public static final String ECORE_DIAGNOSTIC_SOURCE = EObjectValidator.DIAGNOSTIC_SOURCE;

	protected final EValidatorWithOperations validator;
	protected final Map<String, Integer> messageToCode = new HashMap<String, Integer>();
	
	protected AbstractOperations(EValidatorWithOperations validator) {
		this.validator = validator;
	}

	protected void appendDiagnostic(DiagnosticChain diagnostics, Object astNode, int severity, String errorMessage, Object[] messageSubstitutions) {
		appendDiagnostic(diagnostics, new Object[] { astNode }, severity, errorMessage, messageSubstitutions);
	}

	protected void appendDiagnostic(DiagnosticChain diagnostics, Object[] astNodes, int severity, String errorMessage, Object[] messageSubstitutions) {
		appendDiagnostic(diagnostics, astNodes, validator.getDiagnosticSource(), severity, errorMessage, messageSubstitutions);
	}

	protected void appendDiagnostic(DiagnosticChain diagnostics, Object[] astNodes, String diagnosticSource, int severity, String errorMessage, Object[] messageSubstitutions) {
		if (diagnostics != null) {
			int errorCode = getErrorCode(errorMessage);
			String message = getString(errorMessage, messageSubstitutions);
			Diagnostic diagnostic = new BasicDiagnostic(severity, diagnosticSource, errorCode, message, astNodes);
			diagnostics.add(diagnostic);
		}
	}

	protected void appendError(DiagnosticChain diagnostics, Object astNode, String errorMessage, Object[] messageSubstitutions) {
		appendDiagnostic(diagnostics, astNode, Diagnostic.ERROR, errorMessage, messageSubstitutions);
	}

	protected void appendError(DiagnosticChain diagnostics, Object[] astNodes, String errorMessage, Object[] messageSubstitutions) {
		appendDiagnostic(diagnostics, astNodes, Diagnostic.ERROR, errorMessage, messageSubstitutions);
	}

	protected void appendWarning(DiagnosticChain diagnostics, Object astNode, String errorMessage, Object[] messageSubstitutions) {
		appendDiagnostic(diagnostics, astNode, Diagnostic.WARNING, errorMessage, messageSubstitutions);
	}

	protected void appendWarning(DiagnosticChain diagnostics, Object[] astNodes, String errorMessage, Object[] messageSubstitutions) {
		appendDiagnostic(diagnostics, astNodes, Diagnostic.WARNING, errorMessage, messageSubstitutions);
	}
	
	public boolean checkUniqueNames(Object parent, List<? extends ENamedElement> eNamedElements, String errorMessage, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		boolean allOk = true;
		Map<String, ENamedElement> nameToFirst = new HashMap<String, ENamedElement>();
		for (ENamedElement eNamedElement : eNamedElements)
		{
			String name = eNamedElement.getName();
			ENamedElement firstENamedElement = nameToFirst.get(name);
			if (firstENamedElement == null)
				nameToFirst.put(name, eNamedElement);
			else {
				allOk = false;
				Object objectLabel = getObjectLabel(eNamedElement, context);
				Object firstObjectLabel = getObjectLabel(firstENamedElement, context);
				Object[] messageSubstitutions = new Object[] { name, objectLabel, firstObjectLabel };
				appendError(diagnostics, parent, errorMessage, messageSubstitutions);
			}
		}
		return allOk;
	}

	@Deprecated
	protected Diagnostic createDiagnostic(int severity, String source, int code, String messageKey, Object[] messageSubstitutions, Object[] data, Map<Object, Object> context) {
		String message = ECORE_DIAGNOSTIC_SOURCE.equals(source) ?
					getEcoreString(messageKey, messageSubstitutions) :
						getString(messageKey, messageSubstitutions);
					return new BasicDiagnostic(severity, source, code, message, data);
	}
	
	protected String getEcoreString(String key, Object [] substitutions) {
		return getString(EcorePlugin.INSTANCE, key, substitutions);
	}

	/**
	 * Return the integer error code associated with errorMessage, or
	 * zero if the errorMessage has not been registered.
	 */
	public int getErrorCode(String message) {
		Integer code = messageToCode.get(message);
		return code != null ? code.intValue() : 0;
	}
	
	public <T extends ENamedElement> Map<String, T> getNames(List<T> eNamedElements)
	{
		Map<String, T> map = new HashMap<String, T>();
		for (T eNamedElement : eNamedElements)
			map.put(eNamedElement.getName(), eNamedElement);
		return map;
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

	/**
	 * Return the integer error code associated with errorMessage, or
	 * zero if the errorMessage has not been registered.
	 * 
	 * Return non-null for a previous registration.
	 */
	public Integer registerErrorCode(String message, int errorCode) {
		return messageToCode.put(message, Integer.valueOf(errorCode));
	}
}