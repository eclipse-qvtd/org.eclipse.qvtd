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
package org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrFactory
 * @model kind="package"
 * @generated
 */
public interface PATL2QVTrPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PATL2QVTr";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvtd-example/org/eclipse/qvtd/atl/atl2qvtr/ATL2QVTr";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "PATL2QVTr";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PATL2QVTrPackage eINSTANCE = org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.THelper2FunctionImpl <em>THelper2 Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.THelper2FunctionImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTHelper2Function()
	 * @generated
	 */
	int THELPER2_FUNCTION = 0;

	/**
	 * The feature id for the '<em><b>ADef</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THELPER2_FUNCTION__ADEF = 0;

	/**
	 * The feature id for the '<em><b>AFeat</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THELPER2_FUNCTION__AFEAT = 1;

	/**
	 * The feature id for the '<em><b>AModule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THELPER2_FUNCTION__AMODULE = 2;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THELPER2_FUNCTION__FUNCTION = 3;

	/**
	 * The feature id for the '<em><b>Helper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THELPER2_FUNCTION__HELPER = 4;

	/**
	 * The feature id for the '<em><b>Rel Tx</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THELPER2_FUNCTION__REL_TX = 5;

	/**
	 * The feature id for the '<em><b>Tx Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THELPER2_FUNCTION__TX_NAME = 6;

	/**
	 * The number of structural features of the '<em>THelper2 Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THELPER2_FUNCTION_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>THelper2 Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THELPER2_FUNCTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TModel2RelationalTransformationImpl <em>TModel2 Relational Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TModel2RelationalTransformationImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTModel2RelationalTransformation()
	 * @generated
	 */
	int TMODEL2_RELATIONAL_TRANSFORMATION = 1;

	/**
	 * The feature id for the '<em><b>3</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODEL2_RELATIONAL_TRANSFORMATION__3 = 0;

	/**
	 * The feature id for the '<em><b>4</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODEL2_RELATIONAL_TRANSFORMATION__4 = 1;

	/**
	 * The feature id for the '<em><b>Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODEL2_RELATIONAL_TRANSFORMATION__MODULE = 2;

	/**
	 * The feature id for the '<em><b>Rel Tx</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODEL2_RELATIONAL_TRANSFORMATION__REL_TX = 3;

	/**
	 * The feature id for the '<em><b>Tx Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODEL2_RELATIONAL_TRANSFORMATION__TX_NAME = 4;

	/**
	 * The number of structural features of the '<em>TModel2 Relational Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODEL2_RELATIONAL_TRANSFORMATION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>TModel2 Relational Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODEL2_RELATIONAL_TRANSFORMATION_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function <em>THelper2 Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>THelper2 Function</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function
	 * @generated
	 */
	EClass getTHelper2Function();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getADef <em>ADef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>ADef</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getADef()
	 * @see #getTHelper2Function()
	 * @generated
	 */
	EReference getTHelper2Function_ADef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getAFeat <em>AFeat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>AFeat</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getAFeat()
	 * @see #getTHelper2Function()
	 * @generated
	 */
	EReference getTHelper2Function_AFeat();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getAModule <em>AModule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>AModule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getAModule()
	 * @see #getTHelper2Function()
	 * @generated
	 */
	EReference getTHelper2Function_AModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getFunction()
	 * @see #getTHelper2Function()
	 * @generated
	 */
	EReference getTHelper2Function_Function();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getHelper <em>Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getHelper()
	 * @see #getTHelper2Function()
	 * @generated
	 */
	EReference getTHelper2Function_Helper();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getRelTx <em>Rel Tx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rel Tx</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getRelTx()
	 * @see #getTHelper2Function()
	 * @generated
	 */
	EReference getTHelper2Function_RelTx();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getTxName <em>Tx Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tx Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getTxName()
	 * @see #getTHelper2Function()
	 * @generated
	 */
	EAttribute getTHelper2Function_TxName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation <em>TModel2 Relational Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TModel2 Relational Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation
	 * @generated
	 */
	EClass getTModel2RelationalTransformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#get_3 <em>3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>3</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#get_3()
	 * @see #getTModel2RelationalTransformation()
	 * @generated
	 */
	EReference getTModel2RelationalTransformation__3();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#get_4 <em>4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>4</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#get_4()
	 * @see #getTModel2RelationalTransformation()
	 * @generated
	 */
	EReference getTModel2RelationalTransformation__4();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#getModule()
	 * @see #getTModel2RelationalTransformation()
	 * @generated
	 */
	EReference getTModel2RelationalTransformation_Module();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#getRelTx <em>Rel Tx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rel Tx</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#getRelTx()
	 * @see #getTModel2RelationalTransformation()
	 * @generated
	 */
	EReference getTModel2RelationalTransformation_RelTx();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#getTxName <em>Tx Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tx Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#getTxName()
	 * @see #getTModel2RelationalTransformation()
	 * @generated
	 */
	EAttribute getTModel2RelationalTransformation_TxName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PATL2QVTrFactory getPATL2QVTrFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.THelper2FunctionImpl <em>THelper2 Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.THelper2FunctionImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTHelper2Function()
		 * @generated
		 */
		EClass THELPER2_FUNCTION = eINSTANCE.getTHelper2Function();

		/**
		 * The meta object literal for the '<em><b>ADef</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THELPER2_FUNCTION__ADEF = eINSTANCE.getTHelper2Function_ADef();

		/**
		 * The meta object literal for the '<em><b>AFeat</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THELPER2_FUNCTION__AFEAT = eINSTANCE.getTHelper2Function_AFeat();

		/**
		 * The meta object literal for the '<em><b>AModule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THELPER2_FUNCTION__AMODULE = eINSTANCE.getTHelper2Function_AModule();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THELPER2_FUNCTION__FUNCTION = eINSTANCE.getTHelper2Function_Function();

		/**
		 * The meta object literal for the '<em><b>Helper</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THELPER2_FUNCTION__HELPER = eINSTANCE.getTHelper2Function_Helper();

		/**
		 * The meta object literal for the '<em><b>Rel Tx</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THELPER2_FUNCTION__REL_TX = eINSTANCE.getTHelper2Function_RelTx();

		/**
		 * The meta object literal for the '<em><b>Tx Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THELPER2_FUNCTION__TX_NAME = eINSTANCE.getTHelper2Function_TxName();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TModel2RelationalTransformationImpl <em>TModel2 Relational Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TModel2RelationalTransformationImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTModel2RelationalTransformation()
		 * @generated
		 */
		EClass TMODEL2_RELATIONAL_TRANSFORMATION = eINSTANCE.getTModel2RelationalTransformation();

		/**
		 * The meta object literal for the '<em><b>3</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMODEL2_RELATIONAL_TRANSFORMATION__3 = eINSTANCE.getTModel2RelationalTransformation__3();

		/**
		 * The meta object literal for the '<em><b>4</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMODEL2_RELATIONAL_TRANSFORMATION__4 = eINSTANCE.getTModel2RelationalTransformation__4();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMODEL2_RELATIONAL_TRANSFORMATION__MODULE = eINSTANCE.getTModel2RelationalTransformation_Module();

		/**
		 * The meta object literal for the '<em><b>Rel Tx</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMODEL2_RELATIONAL_TRANSFORMATION__REL_TX = eINSTANCE.getTModel2RelationalTransformation_RelTx();

		/**
		 * The meta object literal for the '<em><b>Tx Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMODEL2_RELATIONAL_TRANSFORMATION__TX_NAME = eINSTANCE.getTModel2RelationalTransformation_TxName();

	}

} //PATL2QVTrPackage
