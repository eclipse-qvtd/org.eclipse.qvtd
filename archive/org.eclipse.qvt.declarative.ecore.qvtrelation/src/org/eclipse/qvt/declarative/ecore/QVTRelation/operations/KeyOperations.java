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
 * $Id: KeyOperations.java,v 1.4 2009/01/14 21:02:27 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.TransformationOperations;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Key;

public class KeyOperations extends AbstractQVTRelationOperations
{
	public static KeyOperations INSTANCE = new KeyOperations();

	/**
	 * Validates the AtLeastOnePart constraint of '<em>Key</em>'.
	 */
    public boolean checkAtLeastOnePart(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int partCount = key.getPart().size() + key.getOppositePart().size();
		if (partCount > 0)
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(key, context) };
		appendError(diagnostics, key, QVTRelationMessages._UI_Key_NoParts, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the IdentifiesTypeIsDeclaredByTransformation constraint of '<em>Key</em>'.
	 */
	public boolean checkIdentifiesTypeIsDeclaredByTransformation(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		EClass identifiedClass = key.getIdentifies();
		if (identifiedClass == null)
			return true;		// Error from multiplicity	
		Transformation transformation = key.getTransformation();
		if (TransformationOperations.INSTANCE.declaresType(transformation, identifiedClass))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(identifiedClass, context), getObjectLabel(transformation, context) };
		appendError(diagnostics, key, QVTRelationMessages._UI_Key_IdentifiesTypeIsNotDeclaredByTransformation, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the EveryPartIsDeclaredByIdentifies constraint of '<em>Key</em>'.
	 */
	public boolean checkEveryPartIsDeclaredByIdentifies(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		EClass identifiedClass = key.getIdentifies();
		if (identifiedClass == null)
			return true;		// Error from multiplicity	
		boolean allOk = true;
		for (EStructuralFeature part : key.getPart()) {
			if (!definesProperty(identifiedClass, part)) {
				allOk = false;
				Object[] messageSubstitutions = new Object[] { getObjectLabel(part, context), getObjectLabel(key, context), getObjectLabel(identifiedClass, context) };
				appendError(diagnostics, key, QVTRelationMessages._UI_Key_PartIsNotDeclaredByIdentifies, messageSubstitutions);
			}				
		}
		return allOk;
	}

	/**
	 * Validates the EveryOppositePartReferencesIdentifies constraint of '<em>Key</em>'.
	 */
	public boolean checkEveryOppositePartReferencesIdentifies(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		EClass identifiedClass = key.getIdentifies();
		if (identifiedClass == null)
			return true;		// Error from multiplicity	
		boolean allOk = true;
		for (EReference oppositePart : key.getOppositePart()) {
			if (!definesOppositeProperty(identifiedClass, oppositePart)) {
				allOk = false;
				Object[] messageSubstitutions = new Object[] { getObjectLabel(oppositePart, context), getObjectLabel(key, context), getObjectLabel(identifiedClass, context) };
				appendError(diagnostics, key, QVTRelationMessages._UI_Key_OppositePartDoesNotReferenceIdentifies, messageSubstitutions);
			}				
		}
		return allOk;
	}
}