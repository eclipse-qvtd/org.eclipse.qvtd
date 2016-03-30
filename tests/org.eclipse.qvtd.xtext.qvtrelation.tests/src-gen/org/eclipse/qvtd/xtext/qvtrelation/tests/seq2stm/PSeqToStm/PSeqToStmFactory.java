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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmPackage
 * @generated
 */
public interface PSeqToStmFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PSeqToStmFactory eINSTANCE = org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.PSeqToStmFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>TInteraction To State Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TInteraction To State Machine</em>'.
	 * @generated
	 */
	TInteractionToStateMachine createTInteractionToStateMachine();

	/**
	 * Returns a new object of class '<em>TState To State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TState To State</em>'.
	 * @generated
	 */
	TStateToState createTStateToState();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PSeqToStmPackage getPSeqToStmPackage();

} //PSeqToStmFactory
