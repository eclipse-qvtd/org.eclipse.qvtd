/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.ReferringElement;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Area;
import org.eclipse.qvtd.pivot.qvtimperative.Assignment;
import org.eclipse.qvtd.pivot.qvtimperative.BottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.BottomStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.GuardPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativePattern;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage
 * @generated
 */
public class QVTimperativeSwitch<@Nullable T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QVTimperativePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTimperativeSwitch() {
		if (modelPackage == null) {
			modelPackage = QVTimperativePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case QVTimperativePackage.ADD_STATEMENT: {
				AddStatement addStatement = (AddStatement)theEObject;
				T result = caseAddStatement(addStatement);
				if (result == null) result = caseMappingStatement(addStatement);
				if (result == null) result = caseStatement(addStatement);
				if (result == null) result = caseNamedElement(addStatement);
				if (result == null) result = caseElement(addStatement);
				if (result == null) result = caseNameable(addStatement);
				if (result == null) result = caseVisitable(addStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.AREA: {
				Area area = (Area)theEObject;
				T result = caseArea(area);
				if (result == null) result = caseElement(area);
				if (result == null) result = caseVisitable(area);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.ASSIGNMENT: {
				Assignment assignment = (Assignment)theEObject;
				T result = caseAssignment(assignment);
				if (result == null) result = caseElement(assignment);
				if (result == null) result = caseVisitable(assignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.BOTTOM_PATTERN: {
				BottomPattern bottomPattern = (BottomPattern)theEObject;
				T result = caseBottomPattern(bottomPattern);
				if (result == null) result = caseImperativePattern(bottomPattern);
				if (result == null) result = casePattern(bottomPattern);
				if (result == null) result = caseElement(bottomPattern);
				if (result == null) result = caseVisitable(bottomPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.BOTTOM_STATEMENT: {
				BottomStatement bottomStatement = (BottomStatement)theEObject;
				T result = caseBottomStatement(bottomStatement);
				if (result == null) result = caseStatement(bottomStatement);
				if (result == null) result = caseNamedElement(bottomStatement);
				if (result == null) result = caseElement(bottomStatement);
				if (result == null) result = caseNameable(bottomStatement);
				if (result == null) result = caseVisitable(bottomStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.CONNECTION_VARIABLE: {
				ConnectionVariable connectionVariable = (ConnectionVariable)theEObject;
				T result = caseConnectionVariable(connectionVariable);
				if (result == null) result = caseVariable(connectionVariable);
				if (result == null) result = caseVariableDeclaration(connectionVariable);
				if (result == null) result = caseTypedElement(connectionVariable);
				if (result == null) result = caseNamedElement(connectionVariable);
				if (result == null) result = caseElement(connectionVariable);
				if (result == null) result = caseNameable(connectionVariable);
				if (result == null) result = caseVisitable(connectionVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.GUARD_PATTERN: {
				GuardPattern guardPattern = (GuardPattern)theEObject;
				T result = caseGuardPattern(guardPattern);
				if (result == null) result = caseImperativePattern(guardPattern);
				if (result == null) result = casePattern(guardPattern);
				if (result == null) result = caseElement(guardPattern);
				if (result == null) result = caseVisitable(guardPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.IMPERATIVE_DOMAIN: {
				ImperativeDomain imperativeDomain = (ImperativeDomain)theEObject;
				T result = caseImperativeDomain(imperativeDomain);
				if (result == null) result = caseDomain(imperativeDomain);
				if (result == null) result = caseArea(imperativeDomain);
				if (result == null) result = caseNamedElement(imperativeDomain);
				if (result == null) result = caseReferringElement(imperativeDomain);
				if (result == null) result = caseElement(imperativeDomain);
				if (result == null) result = caseNameable(imperativeDomain);
				if (result == null) result = caseVisitable(imperativeDomain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.IMPERATIVE_MODEL: {
				ImperativeModel imperativeModel = (ImperativeModel)theEObject;
				T result = caseImperativeModel(imperativeModel);
				if (result == null) result = caseBaseModel(imperativeModel);
				if (result == null) result = caseModel(imperativeModel);
				if (result == null) result = caseNamespace(imperativeModel);
				if (result == null) result = caseNamedElement(imperativeModel);
				if (result == null) result = caseElement(imperativeModel);
				if (result == null) result = caseNameable(imperativeModel);
				if (result == null) result = caseVisitable(imperativeModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.IMPERATIVE_PATTERN: {
				ImperativePattern imperativePattern = (ImperativePattern)theEObject;
				T result = caseImperativePattern(imperativePattern);
				if (result == null) result = casePattern(imperativePattern);
				if (result == null) result = caseElement(imperativePattern);
				if (result == null) result = caseVisitable(imperativePattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.MAPPING: {
				Mapping mapping = (Mapping)theEObject;
				T result = caseMapping(mapping);
				if (result == null) result = caseRule(mapping);
				if (result == null) result = caseArea(mapping);
				if (result == null) result = caseNamedElement(mapping);
				if (result == null) result = caseElement(mapping);
				if (result == null) result = caseNameable(mapping);
				if (result == null) result = caseVisitable(mapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.MAPPING_CALL: {
				MappingCall mappingCall = (MappingCall)theEObject;
				T result = caseMappingCall(mappingCall);
				if (result == null) result = caseMappingStatement(mappingCall);
				if (result == null) result = caseReferringElement(mappingCall);
				if (result == null) result = caseStatement(mappingCall);
				if (result == null) result = caseNamedElement(mappingCall);
				if (result == null) result = caseElement(mappingCall);
				if (result == null) result = caseNameable(mappingCall);
				if (result == null) result = caseVisitable(mappingCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.MAPPING_CALL_BINDING: {
				MappingCallBinding mappingCallBinding = (MappingCallBinding)theEObject;
				T result = caseMappingCallBinding(mappingCallBinding);
				if (result == null) result = caseElement(mappingCallBinding);
				if (result == null) result = caseVisitable(mappingCallBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.MAPPING_LOOP: {
				MappingLoop mappingLoop = (MappingLoop)theEObject;
				T result = caseMappingLoop(mappingLoop);
				if (result == null) result = caseMappingStatement(mappingLoop);
				if (result == null) result = caseStatement(mappingLoop);
				if (result == null) result = caseNamedElement(mappingLoop);
				if (result == null) result = caseElement(mappingLoop);
				if (result == null) result = caseNameable(mappingLoop);
				if (result == null) result = caseVisitable(mappingLoop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.MAPPING_STATEMENT: {
				MappingStatement mappingStatement = (MappingStatement)theEObject;
				T result = caseMappingStatement(mappingStatement);
				if (result == null) result = caseStatement(mappingStatement);
				if (result == null) result = caseNamedElement(mappingStatement);
				if (result == null) result = caseElement(mappingStatement);
				if (result == null) result = caseNameable(mappingStatement);
				if (result == null) result = caseVisitable(mappingStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.REALIZED_VARIABLE: {
				RealizedVariable realizedVariable = (RealizedVariable)theEObject;
				T result = caseRealizedVariable(realizedVariable);
				if (result == null) result = caseVariable(realizedVariable);
				if (result == null) result = caseVariableDeclaration(realizedVariable);
				if (result == null) result = caseTypedElement(realizedVariable);
				if (result == null) result = caseNamedElement(realizedVariable);
				if (result == null) result = caseElement(realizedVariable);
				if (result == null) result = caseNameable(realizedVariable);
				if (result == null) result = caseVisitable(realizedVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.SET_STATEMENT: {
				SetStatement setStatement = (SetStatement)theEObject;
				T result = caseSetStatement(setStatement);
				if (result == null) result = caseBottomStatement(setStatement);
				if (result == null) result = caseStatement(setStatement);
				if (result == null) result = caseNamedElement(setStatement);
				if (result == null) result = caseElement(setStatement);
				if (result == null) result = caseNameable(setStatement);
				if (result == null) result = caseVisitable(setStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = caseNamedElement(statement);
				if (result == null) result = caseElement(statement);
				if (result == null) result = caseNameable(statement);
				if (result == null) result = caseVisitable(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.VARIABLE_ASSIGNMENT: {
				VariableAssignment variableAssignment = (VariableAssignment)theEObject;
				T result = caseVariableAssignment(variableAssignment);
				if (result == null) result = caseAssignment(variableAssignment);
				if (result == null) result = caseElement(variableAssignment);
				if (result == null) result = caseVisitable(variableAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.VARIABLE_PREDICATE: {
				VariablePredicate variablePredicate = (VariablePredicate)theEObject;
				T result = caseVariablePredicate(variablePredicate);
				if (result == null) result = casePredicate(variablePredicate);
				if (result == null) result = caseElement(variablePredicate);
				if (result == null) result = caseVisitable(variablePredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddStatement(AddStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Area</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Area</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArea(Area object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignment(Assignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bottom Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bottom Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBottomPattern(BottomPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bottom Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bottom Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBottomStatement(BottomStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectionVariable(ConnectionVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guard Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guard Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuardPattern(GuardPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativeDomain(ImperativeDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativeModel(ImperativeModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativePattern(ImperativePattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapping(Mapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingCall(MappingCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Call Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Call Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingCallBinding(MappingCallBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingLoop(MappingLoop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingStatement(MappingStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Realized Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Realized Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealizedVariable(RealizedVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetStatement(SetStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatement(Statement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableAssignment(VariableAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariablePredicate(VariablePredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitable(Visitable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePattern(Pattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameable(Nameable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespace(Namespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModel(Model object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseModel(BaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRule(Rule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElement(TypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDeclaration(VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariable(Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Referring Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Referring Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferringElement(ReferringElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomain(Domain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePredicate(Predicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //QVTimperativeSwitch
