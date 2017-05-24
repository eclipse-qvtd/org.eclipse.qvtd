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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.jdt.annotation.Nullable;

import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage
 * @generated
 */
public class PATL2QVTrAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PATL2QVTrPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PATL2QVTrAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PATL2QVTrPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PATL2QVTrSwitch<@Nullable Adapter> modelSwitch =
		new PATL2QVTrSwitch<@Nullable Adapter>() {
			@Override
			public Adapter caseTHelper2Function(THelper2Function object) {
				return createTHelper2FunctionAdapter();
			}
			@Override
			public Adapter caseTInPattern2RelationDomain(TInPattern2RelationDomain object) {
				return createTInPattern2RelationDomainAdapter();
			}
			@Override
			public Adapter caseTInPattern2RelationDomain_guard(TInPattern2RelationDomain_guard object) {
				return createTInPattern2RelationDomain_guardAdapter();
			}
			@Override
			public Adapter caseTMatchedRule2Relation(TMatchedRule2Relation object) {
				return createTMatchedRule2RelationAdapter();
			}
			@Override
			public Adapter caseTModel2RelationalTransformation(TModel2RelationalTransformation object) {
				return createTModel2RelationalTransformationAdapter();
			}
			@Override
			public Adapter caseTOclExpression2OCLExpression(TOclExpression2OCLExpression object) {
				return createTOclExpression2OCLExpressionAdapter();
			}
			@Override
			public Adapter caseTOclModel2ModelParameter_create(TOclModel2ModelParameter_create object) {
				return createTOclModel2ModelParameter_createAdapter();
			}
			@Override
			public Adapter caseTOclModel2ModelParameter_from(TOclModel2ModelParameter_from object) {
				return createTOclModel2ModelParameter_fromAdapter();
			}
			@Override
			public Adapter caseTOperationCallExp2OperationCallExp(TOperationCallExp2OperationCallExp object) {
				return createTOperationCallExp2OperationCallExpAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function <em>THelper2 Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function
	 * @generated
	 */
	public Adapter createTHelper2FunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain <em>TIn Pattern2 Relation Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain
	 * @generated
	 */
	public Adapter createTInPattern2RelationDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard <em>TIn Pattern2 Relation Domain guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard
	 * @generated
	 */
	public Adapter createTInPattern2RelationDomain_guardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TMatchedRule2Relation <em>TMatched Rule2 Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TMatchedRule2Relation
	 * @generated
	 */
	public Adapter createTMatchedRule2RelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation <em>TModel2 Relational Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation
	 * @generated
	 */
	public Adapter createTModel2RelationalTransformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclExpression2OCLExpression <em>TOcl Expression2 OCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclExpression2OCLExpression
	 * @generated
	 */
	public Adapter createTOclExpression2OCLExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_create <em>TOcl Model2 Model Parameter create</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_create
	 * @generated
	 */
	public Adapter createTOclModel2ModelParameter_createAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from <em>TOcl Model2 Model Parameter from</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from
	 * @generated
	 */
	public Adapter createTOclModel2ModelParameter_fromAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOperationCallExp2OperationCallExp <em>TOperation Call Exp2 Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOperationCallExp2OperationCallExp
	 * @generated
	 */
	public Adapter createTOperationCallExp2OperationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //PATL2QVTrAdapterFactory
