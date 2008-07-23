/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtcore.environment;

import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.qvt.declarative.ecore.QVTCore.Area;
import org.eclipse.qvt.declarative.ecore.QVTCore.BottomPattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCoreFactory;
import org.eclipse.qvt.declarative.ecore.QVTCore.RealizedVariable;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.PatternCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.RealizedVariableCS;

public class QVTcBottomPatternEnvironment extends QVTcPatternEnvironment
{
	private final BottomPattern pattern;
	
	public QVTcBottomPatternEnvironment(QVTcAreaEnvironment domainEnvironment, PatternCS patternCS) {
		super(domainEnvironment, patternCS);
		Area area = domainEnvironment.getArea();
		BottomPattern bottomPattern = QVTCoreFactory.eINSTANCE.createBottomPattern();
		initASTMapping(bottomPattern, patternCS);
		area.setBottomPattern(bottomPattern);
		pattern = bottomPattern;
	}

	public Variable createRealizedVariableDefinition(String name, EClassifier type, RealizedVariableCS cstNode) {
		Variable variable = variableDefinitions.get(name);
		if (variable != null) {
			if (variable.getType() != type) {
				String message = "Conflicting type '" + formatType(type) + "' for variable of type '" + formatType(variable.getType()) + "'";
				analyzerError(message, "explicit varDeclarationCS", cstNode);
			}
		}
		else {
			RealizedVariable realizedVariable = QVTCoreFactory.eINSTANCE.createRealizedVariable();
			initASTMapping(realizedVariable, cstNode);
			variable = realizedVariable;
			UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> uml = getUMLReflection();
			uml.setName(variable, name);
			uml.setType(variable, type);
			variableDefinitions.put(name, variable);
			getPattern().getRealizedVariable().add(realizedVariable);
			addElement(name, variable, true);
		}
		return variable;
	}

	@Override public BottomPattern getPattern() { return pattern; }

	@Override
	public Set<QVTcPatternEnvironment> getPatternEnvironmentClosure() {
		return getParentEnvironment().getBottomPatternEnvironmentClosure();
	}
	
	@Override
	public String toString() {
		String parentString = getInternalParent() != null ? (getInternalParent().toString() + ".") : "";
		return parentString + "bottom";
	}
}
