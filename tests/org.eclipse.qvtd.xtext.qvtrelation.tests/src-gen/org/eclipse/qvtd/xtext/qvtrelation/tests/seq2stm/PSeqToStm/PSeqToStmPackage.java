/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm;

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
 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmFactory
 * @model kind="package"
 * @generated
 */
public interface PSeqToStmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PSeqToStm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "PSeqToStm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "s2s";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PSeqToStmPackage eINSTANCE = org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.PSeqToStmPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TInteractionToStateMachineImpl <em>TInteraction To State Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TInteractionToStateMachineImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.PSeqToStmPackageImpl#getTInteractionToStateMachine()
	 * @generated
	 */
	int TINTERACTION_TO_STATE_MACHINE = 0;

	/**
	 * The feature id for the '<em><b>Sn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERACTION_TO_STATE_MACHINE__SN = 0;

	/**
	 * The feature id for the '<em><b>I</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERACTION_TO_STATE_MACHINE__I = 1;

	/**
	 * The feature id for the '<em><b>S</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERACTION_TO_STATE_MACHINE__S = 2;

	/**
	 * The number of structural features of the '<em>TInteraction To State Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERACTION_TO_STATE_MACHINE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>TInteraction To State Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINTERACTION_TO_STATE_MACHINE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TStateToStateImpl <em>TState To State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TStateToStateImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.PSeqToStmPackageImpl#getTStateToState()
	 * @generated
	 */
	int TSTATE_TO_STATE = 1;

	/**
	 * The feature id for the '<em><b>Sn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTATE_TO_STATE__SN = 0;

	/**
	 * The feature id for the '<em><b>St1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTATE_TO_STATE__ST1 = 1;

	/**
	 * The feature id for the '<em><b>L</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTATE_TO_STATE__L = 2;

	/**
	 * The feature id for the '<em><b>I</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTATE_TO_STATE__I = 3;

	/**
	 * The feature id for the '<em><b>St2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTATE_TO_STATE__ST2 = 4;

	/**
	 * The feature id for the '<em><b>S</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTATE_TO_STATE__S = 5;

	/**
	 * The number of structural features of the '<em>TState To State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTATE_TO_STATE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>TState To State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSTATE_TO_STATE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TInteractionToStateMachine <em>TInteraction To State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TInteraction To State Machine</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TInteractionToStateMachine
	 * @generated
	 */
	EClass getTInteractionToStateMachine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TInteractionToStateMachine#getSn <em>Sn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sn</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TInteractionToStateMachine#getSn()
	 * @see #getTInteractionToStateMachine()
	 * @generated
	 */
	EAttribute getTInteractionToStateMachine_Sn();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TInteractionToStateMachine#getI <em>I</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>I</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TInteractionToStateMachine#getI()
	 * @see #getTInteractionToStateMachine()
	 * @generated
	 */
	EReference getTInteractionToStateMachine_I();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TInteractionToStateMachine#getS <em>S</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>S</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TInteractionToStateMachine#getS()
	 * @see #getTInteractionToStateMachine()
	 * @generated
	 */
	EReference getTInteractionToStateMachine_S();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState <em>TState To State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TState To State</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState
	 * @generated
	 */
	EClass getTStateToState();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getSn <em>Sn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sn</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getSn()
	 * @see #getTStateToState()
	 * @generated
	 */
	EAttribute getTStateToState_Sn();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getSt1 <em>St1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>St1</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getSt1()
	 * @see #getTStateToState()
	 * @generated
	 */
	EReference getTStateToState_St1();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getL <em>L</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>L</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getL()
	 * @see #getTStateToState()
	 * @generated
	 */
	EReference getTStateToState_L();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getI <em>I</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>I</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getI()
	 * @see #getTStateToState()
	 * @generated
	 */
	EReference getTStateToState_I();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getSt2 <em>St2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>St2</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getSt2()
	 * @see #getTStateToState()
	 * @generated
	 */
	EReference getTStateToState_St2();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getS <em>S</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>S</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getS()
	 * @see #getTStateToState()
	 * @generated
	 */
	EReference getTStateToState_S();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PSeqToStmFactory getPSeqToStmFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TInteractionToStateMachineImpl <em>TInteraction To State Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TInteractionToStateMachineImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.PSeqToStmPackageImpl#getTInteractionToStateMachine()
		 * @generated
		 */
		EClass TINTERACTION_TO_STATE_MACHINE = eINSTANCE.getTInteractionToStateMachine();

		/**
		 * The meta object literal for the '<em><b>Sn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TINTERACTION_TO_STATE_MACHINE__SN = eINSTANCE.getTInteractionToStateMachine_Sn();

		/**
		 * The meta object literal for the '<em><b>I</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TINTERACTION_TO_STATE_MACHINE__I = eINSTANCE.getTInteractionToStateMachine_I();

		/**
		 * The meta object literal for the '<em><b>S</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TINTERACTION_TO_STATE_MACHINE__S = eINSTANCE.getTInteractionToStateMachine_S();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TStateToStateImpl <em>TState To State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TStateToStateImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.PSeqToStmPackageImpl#getTStateToState()
		 * @generated
		 */
		EClass TSTATE_TO_STATE = eINSTANCE.getTStateToState();

		/**
		 * The meta object literal for the '<em><b>Sn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TSTATE_TO_STATE__SN = eINSTANCE.getTStateToState_Sn();

		/**
		 * The meta object literal for the '<em><b>St1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSTATE_TO_STATE__ST1 = eINSTANCE.getTStateToState_St1();

		/**
		 * The meta object literal for the '<em><b>L</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSTATE_TO_STATE__L = eINSTANCE.getTStateToState_L();

		/**
		 * The meta object literal for the '<em><b>I</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSTATE_TO_STATE__I = eINSTANCE.getTStateToState_I();

		/**
		 * The meta object literal for the '<em><b>St2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSTATE_TO_STATE__ST2 = eINSTANCE.getTStateToState_St2();

		/**
		 * The meta object literal for the '<em><b>S</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSTATE_TO_STATE__S = eINSTANCE.getTStateToState_S();

	}

} //PSeqToStmPackage
