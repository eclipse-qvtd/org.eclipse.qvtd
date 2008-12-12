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
 * $Id: AbstractQVTBaseOperations.java,v 1.1 2008/12/12 15:31:45 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.operations;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.qvt.declarative.ecore.QVTBase.util.QVTBaseValidator;
import org.eclipse.qvt.declarative.ecore.operations.AbstractOperations;

public class AbstractQVTBaseOperations extends AbstractOperations
{
	public static final String DIAGNOSTIC_SOURCE = QVTBaseValidator.INSTANCE.getDiagnosticSource();

	private static final EcoreEnvironment ecoreEnvironment = (EcoreEnvironment) EcoreEnvironmentFactory.INSTANCE.createEnvironment();
	private static final OCLStandardLibrary<EClassifier> oclStandardLibrary = ecoreEnvironment.getOCLStandardLibrary();
	private static final EClassifier booleanType = oclStandardLibrary.getBoolean();

	protected AbstractQVTBaseOperations() {
		super(QVTBaseValidator.INSTANCE);
	}

	public Set<Variable> getAllReferencedVariables(EObject eObject) {
		Set<Variable> referencedVariables = new HashSet<Variable>();
		if (eObject instanceof VariableExp)
			referencedVariables.add((Variable)((VariableExp)eObject).getReferredVariable());
		for (TreeIterator<EObject> i = eObject.eAllContents(); i.hasNext(); ) {
			EObject element = i.next();
			if (element instanceof VariableExp)
				referencedVariables.add((Variable)((VariableExp)element).getReferredVariable());
		}
		return referencedVariables;
	}

	public Set<VariableExp> getAllVariableExps(EObject eObject) {
		Set<VariableExp> variableExps = new HashSet<VariableExp>();
		if (eObject instanceof VariableExp)
			variableExps.add((VariableExp)eObject);
		for (TreeIterator<EObject> i = eObject.eAllContents(); i.hasNext(); ) {
			EObject element = i.next();
			if (element instanceof VariableExp)
				variableExps.add((VariableExp)element);
		}
		return variableExps;
	}

	public EClassifier getBooleanType() {
		return booleanType;
	}
}