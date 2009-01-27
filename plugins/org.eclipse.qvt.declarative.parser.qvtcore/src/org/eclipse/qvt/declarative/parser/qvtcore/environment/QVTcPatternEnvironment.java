/*******************************************************************************
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtcore.environment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.qvt.declarative.ecore.QVTCore.BottomPattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.CorePattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.GuardPattern;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.PatternCS;

public abstract class QVTcPatternEnvironment<AST extends CorePattern> extends QVTcEnvironment<IQVTcNodeEnvironment, QVTcAreaEnvironment<?>, AST, PatternCS> implements IQVTcEnvironment
{
	protected final Map<String, Variable> variableDefinitions = new HashMap<String, Variable>();	

	public QVTcPatternEnvironment(QVTcAreaEnvironment<?> domainEnvironment, AST astNode, PatternCS patternCS) {
		super(domainEnvironment, astNode, patternCS);
	}

	public void computeBindsTo() {
		List<Variable> bindsTo = ast.getBindsTo();
		for (QVTcPatternEnvironment<?> env : getPatternEnvironmentClosure()) {
			if ((env != this) && (env != null)) {
				for (Variable var : env.getASTNode().getBindsTo()) {
					if (!bindsTo.contains(var))
						bindsTo.add(var);
				}	
			}
		}
	}

	public Variable createUnrealizedVariableDefinition(String name, EClassifier type, CSTNode cstNode) {
		Variable variable = variableDefinitions.get(name);
		if (variable != null) {
			if (variable.getType() != type) {
				String message = "Conflicting type '" + formatType(type) + "' for variable of type '" + formatType(variable.getType()) + "'";
				analyzerError(message, "explicit varDeclarationCS", cstNode);
			}
		}
		else {
			variable = EcoreFactory.eINSTANCE.createVariable();
			initASTMapping(variable, cstNode);
			UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> uml = getUMLReflection();
			uml.setName(variable, name);
			uml.setType(variable, type);
			variableDefinitions.put(name, variable);
			ast.getVariable().add(variable);
			addElement(name, variable, true);
			ast.getBindsTo().add(variable);
		}
		return variable;
	}
	
	@Override
	public String formatName(Object object) {
		if (object instanceof BottomPattern)
			return "bottom";
		else if (object instanceof GuardPattern)
			return "guard";
		else
			return super.formatName(object);
	}

	/**
	 * Return the set of all guard and bottom patterns that contribute to this pattern.
	 */
	public abstract Set<? extends QVTcPatternEnvironment<?>> getPatternEnvironmentClosure();

	public Variable getVariable(String name) {
		return variableDefinitions.get(name);
	}

	@Override
	public org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> lookup(String name) {
		try {
			return tryLookupVariable(name);
		} catch (LookupException e) {
			analyzerError(formatLookupException(e), "lookup", getCSTNode());
			List<?> ambiguousMatches = e.getAmbiguousMatches();
			if (ambiguousMatches.size() <= 0)
				return null;
			// Return an arbitrary selection to avoid unrecognised variable errors (Bug 224322)
			// Arbitrary selection must be deterministic to avoid JUnit indeterminacy
			// FIXME Is this why the badmaps test fails intermittently?
			List<?> sortedMatches = getFormatter().sort(ambiguousMatches);
			@SuppressWarnings("unchecked")
			org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> firstMatch = (org.eclipse.ocl.expressions.Variable<EClassifier, EParameter>) sortedMatches.get(0);
			return firstMatch;
		}
	}

	@Override
	public Variable tryLookupVariable(String name) throws LookupException {
		Set<? extends QVTcPatternEnvironment<?>> patterns = getPatternEnvironmentClosure();
		Variable variable = null;
		List<Variable> variables = null;
		for (QVTcPatternEnvironment<?> pattern : patterns) {
			Variable v = pattern.getVariable(name);
			if (v == null)
				;
			else if (variables != null)
				variables.add(v);
			else if (variable != null) {
				variables = new ArrayList<Variable>();
				variables.add(variable);
				variables.add(v);
				variable = null;
			}
			else
				variable = v;
		}
		if (variables != null)
			throw new LookupException("Ambiguous variable", variables);
		return variable;
	}
}
