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
 * $Id: AbstractQVTTemplateOperations.java,v 1.2 2009/01/14 21:01:48 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTTemplate.operations;

import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.AbstractQVTBaseOperations;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.util.QVTTemplateConstants;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.util.QVTTemplateValidator;
import org.eclipse.qvt.declarative.ecore.operations.EValidatorWithOperations;

public class AbstractQVTTemplateOperations extends AbstractQVTBaseOperations
{
	protected AbstractQVTTemplateOperations() {
		this(QVTTemplateValidator.INSTANCE);
	}

	public AbstractQVTTemplateOperations(EValidatorWithOperations validator) {
		super(validator);
	}

	public boolean isSpecialVariable(Variable variable) {
		if (variable == null)
			return false;
		return QVTTemplateConstants.WILDCARD_VARIABLE_NAME.equals(variable.getName());
	}

	public boolean isSpecialVariableReference(OCLExpression expression) {
		if (!(expression instanceof VariableExp))
			return false;
		return isSpecialVariable((Variable) ((VariableExp)expression).getReferredVariable());
	}
}