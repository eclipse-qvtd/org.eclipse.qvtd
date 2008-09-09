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
 * $Id: KeyOperations.java,v 1.1 2008/09/09 20:59:19 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
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
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_KeyMustHaveAtLeastOnePart_diagnostic",
						 new Object[] { getObjectLabel(key, context) },
						 new Object[] { key },
						 context));
			}
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
				if (diagnostics != null) {
					diagnostics.add
						(createDiagnostic
							(Diagnostic.ERROR,
							 DIAGNOSTIC_SOURCE,
							 0,
							 "_UI_KeyPartSourceMustBeKeyIdentifies_diagnostic",
							 new Object[] { getObjectLabel(part, context), getObjectLabel(key, context), getObjectLabel(identifiedClass, context) },
							 new Object[] { part },
							 context));
				}
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
				if (diagnostics != null) {
					diagnostics.add
						(createDiagnostic
							(Diagnostic.ERROR,
							 DIAGNOSTIC_SOURCE,
							 0,
							 "_UI_KeyOppositePartTargetMustBeKeyIdentifies_diagnostic",
							 new Object[] { getObjectLabel(oppositePart, context), getObjectLabel(key, context), getObjectLabel(identifiedClass, context) },
							 new Object[] { oppositePart },
							 context));
				}
			}				
		}
		return allOk;
	}
}