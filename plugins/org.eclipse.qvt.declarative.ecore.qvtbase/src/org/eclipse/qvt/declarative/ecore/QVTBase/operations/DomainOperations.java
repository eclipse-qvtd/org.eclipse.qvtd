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
 * $Id: DomainOperations.java,v 1.1 2008/12/12 15:31:45 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;

public class DomainOperations extends AbstractQVTBaseOperations
{
	public static DomainOperations INSTANCE = new DomainOperations();

	/**
	 * Validates the NotBothCheckableAndEnforceable constraint of '<em>Domain</em>'.
	 */
	public boolean checkNotBothCheckableAndEnforceable(Domain domain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (domain.isIsCheckable() && domain.isIsEnforceable()) {
			Object[] messageSubstitutions = new Object[] { getObjectLabel(domain, context) };
			appendError(diagnostics, domain, "_UI_NotBothCheckableAndEnforceable", messageSubstitutions);
			return false;
		}
		return true;
	}

	/**
	 * Validates the TypedModelDefinedByTransformation constraint of '<em>Domain</em>'.
	 */
	public boolean checkTypedModelDefinedByTransformation(Domain domain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Transformation transformation = domain.getRule().getTransformation();
		TypedModel typedModel = domain.getTypedModel();
		if ((typedModel != null) && !TransformationOperations.INSTANCE.definesModel(transformation, typedModel)) {
			Object[] messageSubstitutions = new Object[] { getObjectLabel(typedModel, context), getObjectLabel(domain, context), getObjectLabel(transformation, context) };
			appendError(diagnostics, domain, "_UI_TypedModelDefinedByTransformation", messageSubstitutions);
			return false;
		}
		return true;
	}
}