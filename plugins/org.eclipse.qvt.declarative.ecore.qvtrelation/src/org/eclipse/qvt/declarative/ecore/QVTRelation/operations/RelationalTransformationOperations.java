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
 * $Id: RelationalTransformationOperations.java,v 1.6 2009/02/17 21:41:53 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Key;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;

public class RelationalTransformationOperations extends AbstractQVTRelationOperations
{
	public static RelationalTransformationOperations INSTANCE = new RelationalTransformationOperations();

	/**
	 * Validates the EveryRuleIsARelation constraint of '<em>Relational Transformation</em>'.
	 */
	public boolean checkEveryRuleIsARelation(RelationalTransformation relationalTransformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		for (Rule rule : relationalTransformation.getRule()) {
			if (!(rule instanceof Relation)) {
				Object[] messageSubstitutions = new Object[] { getObjectLabel(rule, context) };
				appendError(diagnostics, rule, QVTRelationMessages._UI_RelationalTransformation_RuleIsNotARelation, messageSubstitutions);
				allOk = false;
			}
		}
		return allOk;
	}

	/**
	 * Validates the KeysAreUnique constraint of '<em>Relational Transformation</em>'.
	 */
	public boolean checkKeysAreUnique(RelationalTransformation relationalTransformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		UniquenessChecker<EClass, Key> checker = new UniquenessChecker<EClass, Key>()
		{
			@Override
			protected EClass getKey(Key key) {
				return key.getIdentifies();
			}
		};
		return checker.check(relationalTransformation.getOwnedKey(), QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique, relationalTransformation, diagnostics, context);
	}

	/**
	 * Validates the UniqueClassifierNames constraint of '<em>Relational Transformation</em>'.
	 * <br>
	 * This reimplementation of EcoreValidator.validateEPackage_UniqueClassifierNames relaxes the
	 * diagnostic on colliding collection names to a warning, since this is just a gratuitous
	 * OCL 2.0 pedantry.
	 */
	public boolean checkUniqueClassifierNames(RelationalTransformation relationalTransformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		List<String> names = new ArrayList<String>();
		EList<EClassifier> eClassifiers = relationalTransformation.getEClassifiers();
		for (EClassifier eClassifier : eClassifiers)
		{
			String name = eClassifier.getName();
			if (name != null)
			{
				String key = name.replace("_", "").toUpperCase();
				int index = names.indexOf(key);
				if (index != -1)
				{
					if (diagnostics == null)
					{
						return false;
					}
					else
					{
						result = false;
						EClassifier otherEClassifier = eClassifiers.get(index);
						String otherName = otherEClassifier.getName();
						Object[] astNodes = new Object[] { eClassifier, otherEClassifier };
						if (!name.equals(otherName)) {
							Object[] messageSubstitutions = new Object[] { name, otherName };
							appendWarning(diagnostics, astNodes, QVTRelationMessages._UI_RelationalTransformation_ClassifierNameIsSimilar, messageSubstitutions);
						}
						else if ((eClassifier instanceof CollectionType<?,?>)
							 && (otherEClassifier instanceof CollectionType<?,?>)
							 && (((CollectionType<?,?>)eClassifier).getElementType() != ((CollectionType<?,?>)otherEClassifier).getElementType())) {
							Object[] messageSubstitutions = new Object[] { ((CollectionType<?,?>)eClassifier).getKind(),
											   EcoreUtils.formatQualifiedName(((CollectionType<?,?>)eClassifier).getElementType()),
											   ((CollectionType<?,?>)otherEClassifier).getKind(),
											   EcoreUtils.formatQualifiedName(((CollectionType<?,?>)otherEClassifier).getElementType()) };
							appendWarning(diagnostics, astNodes, QVTRelationMessages._UI_RelationalTransformation_CollectionNameIsNotUnique, messageSubstitutions);
						}
						else {
							Object[] messageSubstitutions = new Object[] { name };
							appendError(diagnostics, astNodes, QVTRelationMessages._UI_RelationalTransformation_ClassifierNameIsNotUnique, messageSubstitutions);
						}
					}
				}
				names.add(key);
			}
			else
			{
				names.add(null);
			}
		}
		return result;
	}
}