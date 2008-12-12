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
 * $Id: KeyOperations.java,v 1.2 2008/12/12 15:32:44 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Key;

public class KeyOperations extends AbstractQVTRelationOperations
{
	public static KeyOperations INSTANCE = new KeyOperations();

	/**
	 * Validates the AtLeastOnePart constraint of '<em>Key</em>'.
	 */
    public boolean checkAtLeastOnePart(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int partCount = key.getPart().size() + key.getOppositePart().size();
		if (partCount <= 0) {
			Object[] messageSubstitutions = new Object[] { getObjectLabel(key, context) };
			appendError(diagnostics, key, "_UI_KeyMustHaveAtLeastOnePart_diagnostic", messageSubstitutions);
			return false;
		}
		return true;
	}

	/**
	 * Validates the PartSourceIsIdentifiedClass constraint of '<em>Key</em>'.
	 */
	public boolean checkPartSourceIsIdentifiedClass(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		EClass identifiedClass = key.getIdentifies();
		for (EStructuralFeature part : key.getPart()) {
			EClass partSource = part.getEContainingClass();
			if (!partSource.isSuperTypeOf(identifiedClass)) {
				allOk = false;
				Object[] messageSubstitutions = new Object[] { getObjectLabel(part, context), getObjectLabel(key, context), getObjectLabel(identifiedClass, context) };
				appendError(diagnostics, part, "_UI_KeyPartSourceMustBeKeyIdentifies_diagnostic", messageSubstitutions);
			}				
		}
		return allOk;
	}

	/**
	 * Validates the OppositePartTargetIsIdentifiedClass constraint of '<em>Key</em>'.
	 */
	public boolean checkOppositePartTargetIsIdentifiedClass(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		EClass identifiedClass = key.getIdentifies();
		for (EReference oppositePart : key.getOppositePart()) {
			EClass partTarget = oppositePart.getEReferenceType();
			if (!partTarget.isSuperTypeOf(identifiedClass)) {
				allOk = false;
				Object[] messageSubstitutions = new Object[] { getObjectLabel(oppositePart, context), getObjectLabel(key, context), getObjectLabel(identifiedClass, context) };
				appendError(diagnostics, oppositePart, "_UI_KeyOppositePartTargetMustBeKeyIdentifies_diagnostic", messageSubstitutions);
			}				
		}
		return allOk;
	}
}