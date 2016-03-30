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
package org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PSeqToStmFactoryImpl extends EFactoryImpl implements PSeqToStmFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PSeqToStmFactory init() {
		try {
			PSeqToStmFactory thePSeqToStmFactory = (PSeqToStmFactory)EPackage.Registry.INSTANCE.getEFactory(PSeqToStmPackage.eNS_URI);
			if (thePSeqToStmFactory != null) {
				return thePSeqToStmFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PSeqToStmFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PSeqToStmFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PSeqToStmPackage.TINTERACTION_TO_STATE_MACHINE: return createTInteractionToStateMachine();
			case PSeqToStmPackage.TSTATE_TO_STATE: return createTStateToState();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TInteractionToStateMachine createTInteractionToStateMachine() {
		TInteractionToStateMachineImpl tInteractionToStateMachine = new TInteractionToStateMachineImpl();
		return tInteractionToStateMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TStateToState createTStateToState() {
		TStateToStateImpl tStateToState = new TStateToStateImpl();
		return tStateToState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PSeqToStmPackage getPSeqToStmPackage() {
		return (PSeqToStmPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PSeqToStmPackage getPackage() {
		return PSeqToStmPackage.eINSTANCE;
	}

} //PSeqToStmFactoryImpl
