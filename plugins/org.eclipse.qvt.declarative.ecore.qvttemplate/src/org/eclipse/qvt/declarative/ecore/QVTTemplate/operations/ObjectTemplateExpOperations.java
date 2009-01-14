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
 * $Id: ObjectTemplateExpOperations.java,v 1.2 2009/01/14 21:01:48 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTTemplate.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.DomainOperations;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;



public class ObjectTemplateExpOperations extends TemplateExpOperations
{
	public static ObjectTemplateExpOperations INSTANCE = new ObjectTemplateExpOperations();

	/**
	 * Validates the EveryEnforceablePartIsEnforced constraint of '<em>Object Template Exp</em>'.
	 *
	public boolean checkEveryEnforceablePartIsEnforced(ObjectTemplateExp objectTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Domain domain = getDomain(objectTemplateExp);
		if (domain == null)
			return true;		// DomainExists failure
		if (!domain.isIsEnforceable())
			return true;
		EClass referredClass = objectTemplateExp.getReferredClass();
		if (referredClass == null)
			return true;		// Multiplicity failure
		boolean allOk = true;
		for (EStructuralFeature feature : referredClass.getEAllStructuralFeatures()) {
			if (!feature.isRequired())
				continue;
			if (feature.isVolatile())
				continue;
			if (feature.isTransient())
				continue;
			if (feature.isDerived())
				continue;
			if ((feature instanceof EReference) && ((EReference)feature).isContainer())
				continue;
			if (feature.getDefaultValue() != null)
				continue;
			PropertyTemplateItem gotIt = null;
			for (PropertyTemplateItem part : objectTemplateExp.getPart()) {
				if (part.getReferredProperty() == feature) {
					gotIt = part;
					break;
				}
			}
			if (gotIt == null) {
				allOk = false;
				Object[] messageSubstitutions = new Object[] {getObjectLabel(objectTemplateExp, context), feature.getName() };
				appendWarning(diagnostics, objectTemplateExp, QVTTemplateMessages._UI_ObjectTemplateExp_EnforceablePartIsNotEnforced, messageSubstitutions);
			}
		}
		return allOk;
	} */

	/**
	 * Validates the PartsAreUnique constraint of '<em>Object Template Exp</em>'.
	 */
	public boolean checkPartsAreUnique(ObjectTemplateExp objectTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		UniquenessChecker<EStructuralFeature, PropertyTemplateItem> checker = new UniquenessChecker<EStructuralFeature, PropertyTemplateItem>()
		{
			@Override
			protected EStructuralFeature getKey(PropertyTemplateItem value) {
				return value.getReferredProperty();
			}
		};
		return checker.check(objectTemplateExp.getPart(), QVTTemplateMessages._UI_ObjectTemplateExp_PartIsNotUnique, objectTemplateExp, diagnostics, context);
	}

	/**
	 * Validates the ReferredClassIsDeclaredByDomain constraint of '<em>Object Template Exp</em>'.
	 */
	public boolean checkReferredClassIsDeclaredByDomain(ObjectTemplateExp objectTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Domain domain = getDomain(objectTemplateExp);
		if (domain == null)
			return true;		// DomainExists error
		EClass referredClass = objectTemplateExp.getReferredClass();
		if (referredClass == null)
			return true;		// Multiplicity error
		if (DomainOperations.INSTANCE.declaresType(domain, referredClass))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(referredClass, context), getObjectLabel(domain, context) };
		appendError(diagnostics, objectTemplateExp, QVTTemplateMessages._UI_ObjectTemplateExp_ReferredClassIsNotDeclaredByDomain, messageSubstitutions);
		return false;
	}
}