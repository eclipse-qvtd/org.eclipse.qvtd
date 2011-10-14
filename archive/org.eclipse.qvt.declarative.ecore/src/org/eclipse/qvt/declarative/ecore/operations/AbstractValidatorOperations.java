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
 * $Id: AbstractValidatorOperations.java,v 1.2 2009/01/14 20:58:50 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.operations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.osgi.util.NLS;

/**
 * AbstractOperations provides shared functionality that derived classes
 * implementing Validator checking may find useful.
 */
public abstract class AbstractValidatorOperations extends AbstractOperations
{
	public static final String ECORE_DIAGNOSTIC_SOURCE = EObjectValidator.DIAGNOSTIC_SOURCE;

	public abstract class UniquenessChecker<K extends EObject,V extends EObject>
	{
		/*
		 * Check that each value has a distinct getKey(), appending an
		 * error for each uniqueness failure. (If there are N same-keyed
		 * values, N-1 errors are appended.)
		 */
		public boolean check(List<? extends V> values, String errorMessage, EObject contextObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
			boolean allOk = true;
			Map<K, V> keyToFirstValue = new HashMap<K, V>();
			for (V value : values)
			{
				K key = getKey(value);
				V firstValue = keyToFirstValue.get(key);
				if (firstValue == null)
					keyToFirstValue.put(key, value);
				else {
					allOk = false;
					Object typedModelLabel = getObjectLabel(key, context);
					Object objectLabel = getObjectLabel(value, context);
					Object firstObjectLabel = getObjectLabel(firstValue, context);
					Object[] messageSubstitutions = new Object[] { typedModelLabel, objectLabel, firstObjectLabel };
					appendDiagnostic(diagnostics, contextObject, getSeverity(), errorMessage, messageSubstitutions);

				}
			}
			return allOk;
		}
		
		/* 
		 * Implement to provide the 'unique' key for a value.
		 */
		protected abstract K getKey(V value);

		protected int getSeverity() {
			return Diagnostic.ERROR;
		}
	}

	protected final EValidatorWithOperations validator;
	protected final Map<String, Integer> messageToCode = new HashMap<String, Integer>();
	
	protected AbstractValidatorOperations(EValidatorWithOperations validator) {
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
			String message = NLS.bind(errorMessage, messageSubstitutions);
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

	public boolean definesOppositeProperty(EClass eClass, EReference property) {
		return property != null && isSuperClassOf(property.getEReferenceType(), eClass);
	}

	public boolean definesProperty(EClass eClass, EStructuralFeature property) {
		return property != null && isSuperClassOf(property.getEContainingClass(), eClass);
	}

	protected <T extends EObject> T getAncestor(EObject eObject, Class<T> requiredClass) {
		if (eObject == null)
			return null;
		else if (requiredClass.isAssignableFrom(eObject.getClass())) {
			@SuppressWarnings("unchecked")
			T object = (T) eObject;
			return object;
		} else
			return getAncestor(eObject.eContainer(), requiredClass);
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

	protected String getObjectLabel(EObject eObject, Map<Object, Object> context) {
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

	public EValidatorWithOperations getValidator() {
		return validator;
	}

	public boolean hasAncestor(EObject childObject, EObject parentObject) {
		for (EObject eObject = childObject; eObject != null; eObject = eObject.eContainer())
			if (eObject == parentObject)
				return true;
		return false;			
	}

	public boolean isSuperClassOf(EClass targetClass, EClass queryClass) {
		if (targetClass == null)
			return false;
		if (queryClass == null)
			return false;
		return targetClass.isSuperTypeOf(queryClass);
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