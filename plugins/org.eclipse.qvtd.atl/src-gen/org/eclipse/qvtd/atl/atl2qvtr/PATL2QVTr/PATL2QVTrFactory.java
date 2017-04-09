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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage
 * @generated
 */
public interface PATL2QVTrFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PATL2QVTrFactory eINSTANCE = org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>THelper2 Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>THelper2 Function</em>'.
	 * @generated
	 */
	THelper2Function createTHelper2Function();

	/**
	 * Returns a new object of class '<em>TMatched Rule2 Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TMatched Rule2 Relation</em>'.
	 * @generated
	 */
	TMatchedRule2Relation createTMatchedRule2Relation();

	/**
	 * Returns a new object of class '<em>TModel2 Relational Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TModel2 Relational Transformation</em>'.
	 * @generated
	 */
	TModel2RelationalTransformation createTModel2RelationalTransformation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PATL2QVTrPackage getPATL2QVTrPackage();

} //PATL2QVTrFactory
