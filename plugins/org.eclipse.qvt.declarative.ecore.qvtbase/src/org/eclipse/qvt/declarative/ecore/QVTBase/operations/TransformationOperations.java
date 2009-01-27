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
 * $Id: TransformationOperations.java,v 1.4 2009/01/27 21:17:57 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.operations;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.operations.EPackageOperations;

public class TransformationOperations extends AbstractQVTBaseOperations
{
	public static TransformationOperations INSTANCE = new TransformationOperations();

	/**
	 * Validates the EveryModelParameterUsedPackagesIsCompatibleWithExtension constraint of '<em>Transformation</em>'.
	 */
	public boolean checkEveryModelParameterUsedPackagesIsCompatibleWithExtension(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (transformation.getExtends() == null)
			return true;
		boolean allOk = true;
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
					appendError(diagnostics, transformation, QVTBaseMessages._UI_Transformation_ModelParameterUsedPackagesAreNotCompatibleWithExtension, messageSubstitutions);
				}
			}
			allOk = false;
		}
		return allOk;
	}

	/**
	 * Validates the ExtendsIsAcyclic constraint of '<em>Transformation</em>'.
	 */
	public boolean checkExtendsIsAcyclic(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Set<Transformation> allExtends = getAllExtends(transformation);
		if (!allExtends.contains(transformation))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(transformation, context) };
		appendError(diagnostics, transformation, QVTBaseMessages._UI_Transformation_ExtendsContainsACycle, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the ExtendsIsCompatible constraint of '<em>Transformation</em>'.
	 */
	public boolean checkExtendsIsCompatible(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (transformation.getExtends() == null)
			return true;
		Set<EPackage> declaredPackages = getDeclaredPackages(transformation);
		Set<EPackage> extendedDeclaredPackages = getDeclaredPackages(transformation.getExtends());
		if (!declaredPackages.equals(extendedDeclaredPackages)) {
			Object[] messageSubstitutions = new Object[] { "ExtendsIsCompatible", getObjectLabel(transformation, context) };
			appendError(diagnostics, transformation, QVTBaseMessages._UI_Transformation_UsedPackagesAreNotCompatibleWithExtends, messageSubstitutions);
		}
		return false;
	}

	/**
	 * Validates the ModelParameterNamesAreCompatibleWithExtension constraint of '<em>Transformation</em>'.
	 */
	public boolean checkModelParameterNamesAreCompatibleWithExtension(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (transformation.getExtends() == null)
			return true;
		Map<String, TypedModel> names = getNames(transformation.getModelParameter());
		Map<String, TypedModel> extendedNames = getNames(transformation.getExtends().getModelParameter());
		if (names.keySet().equals(extendedNames.keySet()))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(transformation, context), getObjectLabel(transformation.getExtends(), context) };
		appendError(diagnostics, transformation, QVTBaseMessages._UI_Transformation_ModelParameterNameIsNotCompatibleWithExtension, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the ModelParameterNamesAreUnique constraint of '<em>Transformation</em>'.
	 */
	public boolean checkModelParameterNamesAreUnique(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return checkUniqueNames(transformation, transformation.getModelParameter(), QVTBaseMessages._UI_Transformation_ModelParameterNameIsNotUnique, diagnostics, context);
	}

	/**
	 * Validates the RuleNamesAreUnique constraint of '<em>Transformation</em>'.
	 */
	public boolean checkRuleNamesAreUnique(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return checkUniqueNames(transformation, transformation.getRule(), QVTBaseMessages._UI_Transformation_RuleNameIsNotUnique, diagnostics, context);
	}

	/**
	 * Validates the SynthesizedTypesAreOwned constraint of '<em>Transformation</em>'.
	 */
	public boolean checkSynthesizedTypesAreOwned(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Set<CollectionType> synthesizedTypes = getSynthesizedTypes(transformation);
		if (synthesizedTypes == null)
			return true;
		boolean allOk = true;
		List<EClassifier> classifiers = transformation.getEClassifiers();
		for (CollectionType synthesizedType : synthesizedTypes) {
			if (!classifiers.contains(synthesizedType)) {
				Object[] messageSubstitutions = new Object[] { getObjectLabel(synthesizedType, context), getObjectLabel(transformation, context) };
				appendError(diagnostics, transformation, QVTBaseMessages._UI_Transformation_SynthesizedTypeIsNotOwned, messageSubstitutions);
				allOk = false;
			}
		}
		return allOk;
	}

	/**
	 * Validates the SynthesizedTypesAreUnique constraint of '<em>Transformation</em>'.
	 *
	public boolean checkSynthesizedTypesAreUnique(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Set<CollectionType> synthesizedTypes = getSynthesizedTypes(transformation);
		if (synthesizedTypes == null)
			return true;
		boolean allOk = true;
		Map<String, CollectionType> name2CollectionType = new HashMap<String, CollectionType>();
		for (CollectionType synthesizedType : synthesizedTypes)
		{
			String name = getObjectLabel(synthesizedType, context);
			CollectionType firstCollectionType = name2CollectionType.get(name);
			if (firstCollectionType == null)
				name2CollectionType.put(name, synthesizedType);
			else {
				allOk = false;
				Object[] messageSubstitutions = new Object[] { name, getObjectLabel(transformation, context) };
				appendError(diagnostics, transformation, QVTBaseMessages._UI_Transformation_SynthesizedTypeIsNotUnique, messageSubstitutions);
			}
		}
		return allOk;
	} */

	public void computeAllExtends(Transformation transformation, Set<Transformation> allExtends) {
		if (allExtends.contains(transformation))
			return;
		allExtends.add(transformation);
		if (transformation.getExtends() == null)
			return;
		computeAllExtends(transformation.getExtends(), allExtends);
	}

	public boolean declaresRule(Transformation transformation, Rule rule) {
		if (transformation.getRule().contains(rule))
			return true;
		if (transformation.getExtends() == null)
			return false;
		return declaresRule(transformation.getExtends(), rule);
	}

	public boolean declaresType(Transformation transformation, EClass type) {
		if (type == null)
			return false;
		Set<EPackage> declaredPackages = getDeclaredPackages(transformation);
		if (declaredPackages.contains(type.getEPackage()))
			return true;
		if (isUnresolved(type))
			return true;
		return false;
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
		for (TypedModel modelParameter : transformation.getModelParameter()) {
			for (EPackage usedPackage : modelParameter.getUsedPackage()) {
				Set<EPackage> allUsedPackages = EPackageOperations.INSTANCE.getAllEPackages(usedPackage);
				declaredPackages.addAll(allUsedPackages);
			}
		}
		return declaredPackages;
	}

	public Set<CollectionType> getSynthesizedTypes(Transformation transformation) {
		Set<CollectionType> synthesizedTypes = null;
		for (TreeIterator<EObject> i = transformation.eAllContents(); i.hasNext(); ) {
			EObject eObject = i.next();
			if (eObject instanceof ETypedElement) {
				for (EClassifier type = ((ETypedElement)eObject).getEType(); type instanceof CollectionType; type = ((CollectionType)type).getElementType()) {
					if (synthesizedTypes == null)
						synthesizedTypes = new HashSet<CollectionType>();
					synthesizedTypes.add((CollectionType) type);
				}
			}			
		}
		return synthesizedTypes;
	}
}