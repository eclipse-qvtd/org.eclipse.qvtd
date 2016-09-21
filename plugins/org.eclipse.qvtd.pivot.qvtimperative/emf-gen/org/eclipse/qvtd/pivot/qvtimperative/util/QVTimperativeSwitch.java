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
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.*;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;

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
				if (result == null) result = caseObservableStatement(addStatement);
				if (result == null) result = caseStatement(addStatement);
				if (result == null) result = caseNamedElement(addStatement);
				if (result == null) result = caseElement(addStatement);
				if (result == null) result = caseNameable(addStatement);
				if (result == null) result = caseVisitable(addStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.APPEND_PARAMETER: {
				AppendParameter appendParameter = (AppendParameter)theEObject;
				T result = caseAppendParameter(appendParameter);
				if (result == null) result = caseConnectionVariable(appendParameter);
				if (result == null) result = caseMappingParameter(appendParameter);
				if (result == null) result = caseVariableDeclaration(appendParameter);
				if (result == null) result = caseTypedElement(appendParameter);
				if (result == null) result = caseNamedElement(appendParameter);
				if (result == null) result = caseElement(appendParameter);
				if (result == null) result = caseNameable(appendParameter);
				if (result == null) result = caseVisitable(appendParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.APPEND_PARAMETER_BINDING: {
				AppendParameterBinding appendParameterBinding = (AppendParameterBinding)theEObject;
				T result = caseAppendParameterBinding(appendParameterBinding);
				if (result == null) result = caseMappingParameterBinding(appendParameterBinding);
				if (result == null) result = caseElement(appendParameterBinding);
				if (result == null) result = caseVisitable(appendParameterBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.BUFFER_STATEMENT: {
				BufferStatement bufferStatement = (BufferStatement)theEObject;
				T result = caseBufferStatement(bufferStatement);
				if (result == null) result = caseConnectionVariable(bufferStatement);
				if (result == null) result = caseVariableStatement(bufferStatement);
				if (result == null) result = caseObservableStatement(bufferStatement);
				if (result == null) result = caseVariableDeclaration(bufferStatement);
				if (result == null) result = caseStatement(bufferStatement);
				if (result == null) result = caseTypedElement(bufferStatement);
				if (result == null) result = caseNamedElement(bufferStatement);
				if (result == null) result = caseElement(bufferStatement);
				if (result == null) result = caseNameable(bufferStatement);
				if (result == null) result = caseVisitable(bufferStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.CHECK_STATEMENT: {
				CheckStatement checkStatement = (CheckStatement)theEObject;
				T result = caseCheckStatement(checkStatement);
				if (result == null) result = caseObservableStatement(checkStatement);
				if (result == null) result = caseStatement(checkStatement);
				if (result == null) result = caseNamedElement(checkStatement);
				if (result == null) result = caseElement(checkStatement);
				if (result == null) result = caseNameable(checkStatement);
				if (result == null) result = caseVisitable(checkStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.CONNECTION_VARIABLE: {
				ConnectionVariable connectionVariable = (ConnectionVariable)theEObject;
				T result = caseConnectionVariable(connectionVariable);
				if (result == null) result = caseVariableDeclaration(connectionVariable);
				if (result == null) result = caseTypedElement(connectionVariable);
				if (result == null) result = caseNamedElement(connectionVariable);
				if (result == null) result = caseElement(connectionVariable);
				if (result == null) result = caseNameable(connectionVariable);
				if (result == null) result = caseVisitable(connectionVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.DECLARE_STATEMENT: {
				DeclareStatement declareStatement = (DeclareStatement)theEObject;
				T result = caseDeclareStatement(declareStatement);
				if (result == null) result = caseVariableStatement(declareStatement);
				if (result == null) result = caseObservableStatement(declareStatement);
				if (result == null) result = caseVariableDeclaration(declareStatement);
				if (result == null) result = caseStatement(declareStatement);
				if (result == null) result = caseTypedElement(declareStatement);
				if (result == null) result = caseNamedElement(declareStatement);
				if (result == null) result = caseElement(declareStatement);
				if (result == null) result = caseNameable(declareStatement);
				if (result == null) result = caseVisitable(declareStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.GUARD_PARAMETER: {
				GuardParameter guardParameter = (GuardParameter)theEObject;
				T result = caseGuardParameter(guardParameter);
				if (result == null) result = caseMappingParameter(guardParameter);
				if (result == null) result = caseVariableDeclaration(guardParameter);
				if (result == null) result = caseTypedElement(guardParameter);
				if (result == null) result = caseNamedElement(guardParameter);
				if (result == null) result = caseElement(guardParameter);
				if (result == null) result = caseNameable(guardParameter);
				if (result == null) result = caseVisitable(guardParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.GUARD_PARAMETER_BINDING: {
				GuardParameterBinding guardParameterBinding = (GuardParameterBinding)theEObject;
				T result = caseGuardParameterBinding(guardParameterBinding);
				if (result == null) result = caseMappingParameterBinding(guardParameterBinding);
				if (result == null) result = caseElement(guardParameterBinding);
				if (result == null) result = caseVisitable(guardParameterBinding);
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
			case QVTimperativePackage.IMPERATIVE_TRANSFORMATION: {
				ImperativeTransformation imperativeTransformation = (ImperativeTransformation)theEObject;
				T result = caseImperativeTransformation(imperativeTransformation);
				if (result == null) result = caseTransformation(imperativeTransformation);
				if (result == null) result = caseClass(imperativeTransformation);
				if (result == null) result = caseType(imperativeTransformation);
				if (result == null) result = caseNamespace(imperativeTransformation);
				if (result == null) result = caseTemplateableElement(imperativeTransformation);
				if (result == null) result = caseNamedElement(imperativeTransformation);
				if (result == null) result = caseElement(imperativeTransformation);
				if (result == null) result = caseNameable(imperativeTransformation);
				if (result == null) result = caseVisitable(imperativeTransformation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.IMPERATIVE_TYPED_MODEL: {
				ImperativeTypedModel imperativeTypedModel = (ImperativeTypedModel)theEObject;
				T result = caseImperativeTypedModel(imperativeTypedModel);
				if (result == null) result = caseTypedModel(imperativeTypedModel);
				if (result == null) result = caseNamedElement(imperativeTypedModel);
				if (result == null) result = caseElement(imperativeTypedModel);
				if (result == null) result = caseNameable(imperativeTypedModel);
				if (result == null) result = caseVisitable(imperativeTypedModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.LOOP_PARAMETER_BINDING: {
				LoopParameterBinding loopParameterBinding = (LoopParameterBinding)theEObject;
				T result = caseLoopParameterBinding(loopParameterBinding);
				if (result == null) result = caseMappingParameterBinding(loopParameterBinding);
				if (result == null) result = caseElement(loopParameterBinding);
				if (result == null) result = caseVisitable(loopParameterBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.LOOP_VARIABLE: {
				LoopVariable loopVariable = (LoopVariable)theEObject;
				T result = caseLoopVariable(loopVariable);
				if (result == null) result = caseVariableDeclaration(loopVariable);
				if (result == null) result = caseTypedElement(loopVariable);
				if (result == null) result = caseNamedElement(loopVariable);
				if (result == null) result = caseElement(loopVariable);
				if (result == null) result = caseNameable(loopVariable);
				if (result == null) result = caseVisitable(loopVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.MAPPING: {
				Mapping mapping = (Mapping)theEObject;
				T result = caseMapping(mapping);
				if (result == null) result = caseRule(mapping);
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
			case QVTimperativePackage.MAPPING_LOOP: {
				MappingLoop mappingLoop = (MappingLoop)theEObject;
				T result = caseMappingLoop(mappingLoop);
				if (result == null) result = caseMappingStatement(mappingLoop);
				if (result == null) result = caseObservableStatement(mappingLoop);
				if (result == null) result = caseStatement(mappingLoop);
				if (result == null) result = caseNamedElement(mappingLoop);
				if (result == null) result = caseElement(mappingLoop);
				if (result == null) result = caseNameable(mappingLoop);
				if (result == null) result = caseVisitable(mappingLoop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.MAPPING_PARAMETER: {
				MappingParameter mappingParameter = (MappingParameter)theEObject;
				T result = caseMappingParameter(mappingParameter);
				if (result == null) result = caseVariableDeclaration(mappingParameter);
				if (result == null) result = caseTypedElement(mappingParameter);
				if (result == null) result = caseNamedElement(mappingParameter);
				if (result == null) result = caseElement(mappingParameter);
				if (result == null) result = caseNameable(mappingParameter);
				if (result == null) result = caseVisitable(mappingParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING: {
				MappingParameterBinding mappingParameterBinding = (MappingParameterBinding)theEObject;
				T result = caseMappingParameterBinding(mappingParameterBinding);
				if (result == null) result = caseElement(mappingParameterBinding);
				if (result == null) result = caseVisitable(mappingParameterBinding);
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
			case QVTimperativePackage.NEW_STATEMENT: {
				NewStatement newStatement = (NewStatement)theEObject;
				T result = caseNewStatement(newStatement);
				if (result == null) result = caseVariableStatement(newStatement);
				if (result == null) result = caseObservableStatement(newStatement);
				if (result == null) result = caseVariableDeclaration(newStatement);
				if (result == null) result = caseStatement(newStatement);
				if (result == null) result = caseTypedElement(newStatement);
				if (result == null) result = caseNamedElement(newStatement);
				if (result == null) result = caseElement(newStatement);
				if (result == null) result = caseNameable(newStatement);
				if (result == null) result = caseVisitable(newStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.OBSERVABLE_STATEMENT: {
				ObservableStatement observableStatement = (ObservableStatement)theEObject;
				T result = caseObservableStatement(observableStatement);
				if (result == null) result = caseStatement(observableStatement);
				if (result == null) result = caseNamedElement(observableStatement);
				if (result == null) result = caseElement(observableStatement);
				if (result == null) result = caseNameable(observableStatement);
				if (result == null) result = caseVisitable(observableStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.SET_STATEMENT: {
				SetStatement setStatement = (SetStatement)theEObject;
				T result = caseSetStatement(setStatement);
				if (result == null) result = caseObservableStatement(setStatement);
				if (result == null) result = caseStatement(setStatement);
				if (result == null) result = caseNamedElement(setStatement);
				if (result == null) result = caseElement(setStatement);
				if (result == null) result = caseNameable(setStatement);
				if (result == null) result = caseVisitable(setStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.SIMPLE_PARAMETER: {
				SimpleParameter simpleParameter = (SimpleParameter)theEObject;
				T result = caseSimpleParameter(simpleParameter);
				if (result == null) result = caseMappingParameter(simpleParameter);
				if (result == null) result = caseVariableDeclaration(simpleParameter);
				if (result == null) result = caseTypedElement(simpleParameter);
				if (result == null) result = caseNamedElement(simpleParameter);
				if (result == null) result = caseElement(simpleParameter);
				if (result == null) result = caseNameable(simpleParameter);
				if (result == null) result = caseVisitable(simpleParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativePackage.SIMPLE_PARAMETER_BINDING: {
				SimpleParameterBinding simpleParameterBinding = (SimpleParameterBinding)theEObject;
				T result = caseSimpleParameterBinding(simpleParameterBinding);
				if (result == null) result = caseMappingParameterBinding(simpleParameterBinding);
				if (result == null) result = caseElement(simpleParameterBinding);
				if (result == null) result = caseVisitable(simpleParameterBinding);
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
			case QVTimperativePackage.VARIABLE_STATEMENT: {
				VariableStatement variableStatement = (VariableStatement)theEObject;
				T result = caseVariableStatement(variableStatement);
				if (result == null) result = caseVariableDeclaration(variableStatement);
				if (result == null) result = caseStatement(variableStatement);
				if (result == null) result = caseTypedElement(variableStatement);
				if (result == null) result = caseNamedElement(variableStatement);
				if (result == null) result = caseElement(variableStatement);
				if (result == null) result = caseNameable(variableStatement);
				if (result == null) result = caseVisitable(variableStatement);
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
	 * Returns the result of interpreting the object as an instance of '<em>Append Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Append Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAppendParameter(AppendParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Append Parameter Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Append Parameter Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAppendParameterBinding(AppendParameterBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBufferStatement(BufferStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Check Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Check Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCheckStatement(CheckStatement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Declare Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declare Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclareStatement(DeclareStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guard Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guard Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuardParameter(GuardParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guard Parameter Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guard Parameter Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuardParameterBinding(GuardParameterBinding object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Transformation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativeTransformation(ImperativeTransformation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Typed Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Typed Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativeTypedModel(ImperativeTypedModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Parameter Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Parameter Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopParameterBinding(LoopParameterBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopVariable(LoopVariable object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingParameter(MappingParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Parameter Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Parameter Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingParameterBinding(MappingParameterBinding object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>New Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewStatement(NewStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Observable Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Observable Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObservableStatement(ObservableStatement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Simple Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleParameter(SimpleParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Parameter Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Parameter Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleParameterBinding(SimpleParameterBinding object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Variable Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableStatement(VariableStatement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Templateable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Templateable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateableElement(TemplateableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClass(org.eclipse.ocl.pivot.Class object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transformation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransformation(Transformation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedModel(TypedModel object) {
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
