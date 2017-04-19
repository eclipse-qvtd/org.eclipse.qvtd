/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * ;All rights reserved. This program and the accompanying materials
 * ;are made available under the terms of the Eclipse Public License v1.0
 * ;which accompanies this distribution, and is available at
 * ;http://www.eclipse.org/legal/epl-v10.html
 * ;
 * ;Contributors:
 * ;  E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.jdt.annotation.Nullable;

import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.*;

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
 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage
 * @generated
 */
public class PATL2QVTrSwitch<@Nullable T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PATL2QVTrPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PATL2QVTrSwitch() {
		if (modelPackage == null) {
			modelPackage = PATL2QVTrPackage.eINSTANCE;
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
			case PATL2QVTrPackage.SIN_PATTERN2_RELATION_DOMAIN_GUARD: {
				SInPattern2RelationDomain_guard sInPattern2RelationDomain_guard = (SInPattern2RelationDomain_guard)theEObject;
				T result = caseSInPattern2RelationDomain_guard(sInPattern2RelationDomain_guard);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PATL2QVTrPackage.SOCL_EXPRESSION2_OCL_EXPRESSION: {
				SOclExpression2OCLExpression sOclExpression2OCLExpression = (SOclExpression2OCLExpression)theEObject;
				T result = caseSOclExpression2OCLExpression(sOclExpression2OCLExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PATL2QVTrPackage.THELPER2_FUNCTION: {
				THelper2Function tHelper2Function = (THelper2Function)theEObject;
				T result = caseTHelper2Function(tHelper2Function);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN: {
				TInPattern2RelationDomain tInPattern2RelationDomain = (TInPattern2RelationDomain)theEObject;
				T result = caseTInPattern2RelationDomain(tInPattern2RelationDomain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD: {
				TInPattern2RelationDomain_guard tInPattern2RelationDomain_guard = (TInPattern2RelationDomain_guard)theEObject;
				T result = caseTInPattern2RelationDomain_guard(tInPattern2RelationDomain_guard);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION: {
				TMatchedRule2Relation tMatchedRule2Relation = (TMatchedRule2Relation)theEObject;
				T result = caseTMatchedRule2Relation(tMatchedRule2Relation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION: {
				TModel2RelationalTransformation tModel2RelationalTransformation = (TModel2RelationalTransformation)theEObject;
				T result = caseTModel2RelationalTransformation(tModel2RelationalTransformation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PATL2QVTrPackage.TOCL_EXPRESSION2_OCL_EXPRESSION: {
				TOclExpression2OCLExpression tOclExpression2OCLExpression = (TOclExpression2OCLExpression)theEObject;
				T result = caseTOclExpression2OCLExpression(tOclExpression2OCLExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_CREATE: {
				TOclModel2ModelParameter_create tOclModel2ModelParameter_create = (TOclModel2ModelParameter_create)theEObject;
				T result = caseTOclModel2ModelParameter_create(tOclModel2ModelParameter_create);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM: {
				TOclModel2ModelParameter_from tOclModel2ModelParameter_from = (TOclModel2ModelParameter_from)theEObject;
				T result = caseTOclModel2ModelParameter_from(tOclModel2ModelParameter_from);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP: {
				TOperationCallExp2OperationCallExp tOperationCallExp2OperationCallExp = (TOperationCallExp2OperationCallExp)theEObject;
				T result = caseTOperationCallExp2OperationCallExp(tOperationCallExp2OperationCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SIn Pattern2 Relation Domain guard</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SIn Pattern2 Relation Domain guard</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSInPattern2RelationDomain_guard(SInPattern2RelationDomain_guard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SOcl Expression2 OCL Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SOcl Expression2 OCL Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSOclExpression2OCLExpression(SOclExpression2OCLExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>THelper2 Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>THelper2 Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTHelper2Function(THelper2Function object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TIn Pattern2 Relation Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TIn Pattern2 Relation Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTInPattern2RelationDomain(TInPattern2RelationDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TIn Pattern2 Relation Domain guard</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TIn Pattern2 Relation Domain guard</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTInPattern2RelationDomain_guard(TInPattern2RelationDomain_guard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TMatched Rule2 Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TMatched Rule2 Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTMatchedRule2Relation(TMatchedRule2Relation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TModel2 Relational Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TModel2 Relational Transformation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTModel2RelationalTransformation(TModel2RelationalTransformation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TOcl Expression2 OCL Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TOcl Expression2 OCL Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTOclExpression2OCLExpression(TOclExpression2OCLExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TOcl Model2 Model Parameter create</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TOcl Model2 Model Parameter create</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTOclModel2ModelParameter_create(TOclModel2ModelParameter_create object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TOcl Model2 Model Parameter from</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TOcl Model2 Model Parameter from</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTOclModel2ModelParameter_from(TOclModel2ModelParameter_from object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TOperation Call Exp2 Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TOperation Call Exp2 Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTOperationCallExp2OperationCallExp(TOperationCallExp2OperationCallExp object) {
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

} //PATL2QVTrSwitch
