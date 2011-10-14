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
 * $Id: RuleOperations.java,v 1.3 2009/01/14 21:01:33 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;

public class RuleOperations extends AbstractQVTBaseOperations
{
	public static RuleOperations INSTANCE = new RuleOperations();

	/**
	 * Validates the OverridesIsCompatible constraint of '<em>Rule</em>'.
	 *
	public boolean checkOverridesIsCompatible(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Rule overrides = rule.getOverrides();
		if (overrides == null)
			return true;
		List<Domain> overridingDomains = rule.getDomain();
		List<Domain> overridenDomains = overrides.getDomain();
		if (overridingDomains.size() != overridenDomains.size()) {
			Object[] messageSubstitutions = new Object[] { overridingDomains.size(), overridenDomains.size(), getObjectLabel(overrides, context) };
			appendError(diagnostics, rule, QVTBaseMessages._UI_Rule_OverridenDomainCountIsNotCompatible, messageSubstitutions);
			return false;
		}
		boolean allOk = true;
		for (Domain domain : overridingDomains)
		{
			Domain overriddenDomain = EcoreUtils.getNamedElement(overridenDomains, domain.getName());
			if (overriddenDomain == null) {
				Object[] messageSubstitutions = new Object[] { getObjectLabel(domain, context), getObjectLabel(overrides, context) };
				appendError(diagnostics, rule, QVTBaseMessages._UI_Rule_OverridenDomainDoesNotExist, messageSubstitutions);
				allOk = false;
			}
			else {
				Set<EPackage> overridingPackages = TypedModelOperations.INSTANCE.getDeclaredPackages(domain.getTypedModel());
				Set<EPackage> overridenPackages = TypedModelOperations.INSTANCE.getDeclaredPackages(overriddenDomain.getTypedModel());
				if (!overridingPackages.equals(overridenPackages)) {
					Object[] messageSubstitutions = new Object[] { getObjectLabel(domain, context), getObjectLabel(overriddenDomain, context) };
					appendError(diagnostics, rule, QVTBaseMessages._UI_Rule_OverridenDomainPackagesAreNotCompatible, messageSubstitutions);
					allOk = false;
				}
			}
		}
		return allOk;
	} */

	/**
	 * Validates the OverridesDefinedByTransformation constraint of '<em>Rule</em>'.
	 */
	public boolean checkOverridesDefinedByTransformation(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Rule overrides = rule.getOverrides();
		if (overrides == null)
			return true;
		Transformation transformation = rule.getTransformation();
		if (!TransformationOperations.INSTANCE.declaresRule(transformation, overrides)) {
			Object[] messageSubstitutions = new Object[] { getObjectLabel(rule, context), getObjectLabel(transformation, context) };
			appendError(diagnostics, rule, QVTBaseMessages._UI_Rule_OverridesIsNotDefinedByTransformation, messageSubstitutions);
			return false;
		}
		return true;
	}

	/**
	 * Validates the DomainNamesAreUnique constraint of '<em>Rule</em>'.
	 */
	public boolean checkDomainNamesAreUnique(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return checkUniqueNames(rule, rule.getDomain(), QVTBaseMessages._UI_Rule_DomainNameIsNotUnique, diagnostics, context);
	}

	/**
	 * Validates the TypedModelsAreUnique constraint of '<em>Rule</em>'.
	 */
	public boolean checkTypedModelsAreUnique(final Rule rule, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		UniquenessChecker<TypedModel, Domain> checker = new UniquenessChecker<TypedModel, Domain>()
		{
			@Override
			protected TypedModel getKey(Domain value) {
				return value.getTypedModel();
			}
		};
		return checker.check(rule.getDomain(), QVTBaseMessages._UI_Rule_DomainTypedModelIsNotUnique, rule, diagnostics, context);
	}	
}