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
package org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage
 * @generated
 */
public interface Simpleuml2rdbmsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Simpleuml2rdbmsFactory eINSTANCE = org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.impl.Simpleuml2rdbmsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Attribute To Column</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute To Column</em>'.
	 * @generated
	 */
	AttributeToColumn createAttributeToColumn();

	/**
	 * Returns a new object of class '<em>Association To Foreign Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association To Foreign Key</em>'.
	 * @generated
	 */
	AssociationToForeignKey createAssociationToForeignKey();

	/**
	 * Returns a new object of class '<em>Boolean To Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean To Boolean</em>'.
	 * @generated
	 */
	BooleanToBoolean createBooleanToBoolean();

	/**
	 * Returns a new object of class '<em>Class To Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class To Table</em>'.
	 * @generated
	 */
	ClassToTable createClassToTable();

	/**
	 * Returns a new object of class '<em>Integer To Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer To Number</em>'.
	 * @generated
	 */
	IntegerToNumber createIntegerToNumber();

	/**
	 * Returns a new object of class '<em>Non Leaf Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Non Leaf Attribute</em>'.
	 * @generated
	 */
	NonLeafAttribute createNonLeafAttribute();

	/**
	 * Returns a new object of class '<em>Package To Schema</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package To Schema</em>'.
	 * @generated
	 */
	PackageToSchema createPackageToSchema();

	/**
	 * Returns a new object of class '<em>String To Varchar</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String To Varchar</em>'.
	 * @generated
	 */
	StringToVarchar createStringToVarchar();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Simpleuml2rdbmsPackage getSimpleuml2rdbmsPackage();

} //Simpleuml2rdbmsFactory
