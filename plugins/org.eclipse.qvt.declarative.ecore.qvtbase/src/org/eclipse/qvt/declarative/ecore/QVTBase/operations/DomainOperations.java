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
 * $Id: DomainOperations.java,v 1.2 2008/12/31 17:42:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.operations;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.operations.EPackageOperations;

public class DomainOperations extends AbstractQVTBaseOperations
{
	public static DomainOperations INSTANCE = new DomainOperations();

	/**
	 * Validates the CheckableOrEnforceable constraint of '<em>Domain</em>'.
	 */
	public boolean checkCheckableOrEnforceable(Domain domain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!domain.isIsCheckable() && !domain.isIsEnforceable()) {
			Object[] messageSubstitutions = new Object[] { getObjectLabel(domain, context) };
			appendError(diagnostics, domain, QVTBaseMessages._UI_Domain_IsNotCheckableOrEnforceable, messageSubstitutions);
			return false;
		}
		return true;
	}

	/**
	 * Validates the TypedModelExistsWarning constraint of '<em>Domain</em>'.
	 */
	public boolean checkTypedModelExistsWarning(Domain domain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		TypedModel typedModel = domain.getTypedModel();
		if (typedModel != null)
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(domain, context) };
		appendWarning(diagnostics, domain, QVTBaseMessages._UI_Domain_TypedModelDoesNotExistWarning, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the TypedModelDefinedByTransformation constraint of '<em>Domain</em>'.
	 */
	public boolean checkTypedModelDefinedByTransformation(Domain domain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Transformation transformation = domain.getRule().getTransformation();
		TypedModel typedModel = domain.getTypedModel();
		if (typedModel == null)
			return true;	// TypedModelExistsWarning
		if (TransformationOperations.INSTANCE.definesModel(transformation, typedModel))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(typedModel, context), getObjectLabel(domain, context), getObjectLabel(transformation, context) };
		appendError(diagnostics, domain, QVTBaseMessages._UI_Domain_TypedModelIsNotDefinedByTransformation, messageSubstitutions);
		return false;
	}

	public boolean declaresType(Domain domain, EClassifier type) {
		return isPredefinedType(type) || getDeclaredPackages(domain).contains(type.getEPackage());
	}

	public Set<EPackage> getDeclaredPackages(Domain domain) {
		Set<EPackage> declaredPackages = new HashSet<EPackage>();
		TypedModel typedModel = domain.getTypedModel();
		if (typedModel != null) {
			for (EPackage usedPackage : typedModel.getUsedPackage()) {
				Set<EPackage> allUsedPackages = EPackageOperations.INSTANCE.getAllEPackages(usedPackage);
				declaredPackages.addAll(allUsedPackages);
			}
		}
		return declaredPackages;
	}
}