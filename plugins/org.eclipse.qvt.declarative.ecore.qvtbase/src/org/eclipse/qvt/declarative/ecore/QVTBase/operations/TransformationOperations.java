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
 * $Id: TransformationOperations.java,v 1.1 2008/12/12 15:31:45 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.operations;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;

public class TransformationOperations extends AbstractQVTBaseOperations
{
	public static TransformationOperations INSTANCE = new TransformationOperations();

	/**
	 * Validates the ExtendsIsAcyclic constraint of '<em>Transformation</em>'.
	 */
	public boolean checkExtendsIsAcyclic(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Set<Transformation> allExtends = getAllExtends(transformation);
		if (allExtends.contains(transformation)) {
			Object[] messageSubstitutions = new Object[] { getObjectLabel(transformation, context) };
			appendError(diagnostics, transformation, "_UI_ExtendsIsAcyclic", messageSubstitutions);
			return false;
		}
		return true;
	}

	/**
	 * Validates the ExtendsIsCompatible constraint of '<em>Transformation</em>'.
	 */
	public boolean checkExtendsIsCompatible(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (transformation.getExtends() != null) {
			Set<EPackage> declaredPackages = getDeclaredPackages(transformation);
			Set<EPackage> extendedDeclaredPackages = getDeclaredPackages(transformation.getExtends());
			if (!declaredPackages.equals(extendedDeclaredPackages)) {
				Object[] messageSubstitutions = new Object[] { "ExtendsIsCompatible", getObjectLabel(transformation, context) };
				appendError(diagnostics, transformation, "_UI_ExtendsIsCompatible", messageSubstitutions);
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the ModelParameterNamesAreCompatibleWithExtension constraint of '<em>Transformation</em>'.
	 */
	public boolean checkModelParameterNamesAreCompatibleWithExtension(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (transformation.getExtends() != null) {
			Map<String, TypedModel> names = getNames(transformation.getModelParameter());
			Map<String, TypedModel> extendedNames = getNames(transformation.getExtends().getModelParameter());
			if (!names.keySet().equals(extendedNames.keySet())) {
				Object[] messageSubstitutions = new Object[] { getObjectLabel(transformation, context), getObjectLabel(transformation.getExtends(), context) };
				appendError(diagnostics, transformation, "_UI_ModelParameterNamesAreCompatibleWithExtension", messageSubstitutions);
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the EveryModelParameterUsedPackagesIsCompatibleWithExtension constraint of '<em>Transformation</em>'.
	 */
	public boolean checkEveryModelParameterUsedPackagesIsCompatibleWithExtension(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		if (transformation.getExtends() != null) {
			Map<String, TypedModel> names = getNames(transformation.getModelParameter());
			Map<String, TypedModel> extendedNames = getNames(transformation.getExtends().getModelParameter());
			for (String name : names.keySet()) {
				TypedModel typedModel = names.get(name);
				TypedModel extendedTypedModel = extendedNames.get(name);
				if (extendedTypedModel != null) {	// If null diagnostic is produced by checkModelParameterNamesAreCompatibleWithExtension
					Set<EPackage> declaredPackages = new HashSet<EPackage>(typedModel.getUsedPackage());
					Set<EPackage> extendedDeclaredPackages = new HashSet<EPackage>(extendedTypedModel.getUsedPackage());
					if (!declaredPackages.equals(extendedDeclaredPackages)) {
						Object[] messageSubstitutions = new Object[] { getObjectLabel(typedModel, context), getObjectLabel(extendedTypedModel, context) };
						appendError(diagnostics, transformation, "_UI_EveryModelParameterUsedPackagesIsCompatibleWithExtension", messageSubstitutions);
					}
				}
				allOk = false;
			}
		}
		return allOk;
	}

	/**
	 * Validates the ModelParameterNamesAreUnique constraint of '<em>Transformation</em>'.
	 */
	public boolean checkModelParameterNamesAreUnique(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return checkUniqueNames(transformation, transformation.getModelParameter(), "_UI_ModelParameterNamesAreUnique", diagnostics, context);
	}

	/**
	 * Validates the RuleNamesAreUnique constraint of '<em>Transformation</em>'.
	 */
	public boolean checkRuleNamesAreUnique(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return checkUniqueNames(transformation, transformation.getRule(), "_UI_RuleNamesAreUnique", diagnostics, context);
	}

	/**
	 * Validates the SynthesizedTypesAreOwned constraint of '<em>Transformation</em>'.
	 */
	public boolean checkSynthesizedTypesAreOwned(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			Object[] messageSubstitutions = new Object[] { getObjectLabel(transformation, context) };
			appendError(diagnostics, transformation, "_UI_SynthesizedTypesAreOwned", messageSubstitutions);
			return false;
		}
		return true;
	}

	public boolean computeAllExtends(Transformation transformation, Set<Transformation> allExtends) {
		if (allExtends.contains(transformation))
			return false;
		allExtends.add(transformation);
		if (transformation.getExtends() == null)
			return true;
		return computeAllExtends(transformation.getExtends(), allExtends);
	}

	public boolean declaresRule(Transformation transformation, Rule rule) {
		if (transformation.getRule().contains(rule))
			return true;
		if (transformation.getExtends() == null)
			return false;
		return declaresRule(transformation.getExtends(), rule);
	}

	public boolean definesModel(Transformation transformation, TypedModel typedModel) {
		return transformation.getModelParameter().contains(typedModel);
	}

	public Set<Transformation> getAllExtends(Transformation transformation) {
		Set<Transformation> allExtends = new HashSet<Transformation>();
		if (transformation.getExtends() != null)
			computeAllExtends(transformation.getExtends(), allExtends);
		return allExtends;
	}

	public Set<EPackage> getDeclaredPackages(Transformation transformation) {
		Set<EPackage> declaredPackages = new HashSet<EPackage>();
		for (TypedModel modelParameter : transformation.getModelParameter())
			declaredPackages.addAll(modelParameter.getUsedPackage());
		return declaredPackages;
	}
}