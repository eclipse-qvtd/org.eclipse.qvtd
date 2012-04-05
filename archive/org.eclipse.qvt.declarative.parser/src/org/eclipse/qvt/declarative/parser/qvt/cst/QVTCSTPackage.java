/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: QVTCSTPackage.java,v 1.5 2008/11/28 17:23:01 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvt.cst;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.cst.CSTPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.parser.qvt.cst.QVTCSTFactory
 * @model kind="package"
 * @generated
 */
public interface QVTCSTPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cst";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/1.0/QVTcst";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "eqvtrcst";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTCSTPackage eINSTANCE = org.eclipse.qvt.declarative.parser.qvt.cst.impl.QVTCSTPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvt.cst.impl.ErrorNodeImpl <em>Error Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.impl.ErrorNodeImpl
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.impl.QVTCSTPackageImpl#getErrorNode()
	 * @generated
	 */
	int ERROR_NODE = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__MESSAGE = 0;

	/**
	 * The number of structural features of the '<em>Error Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvt.cst.impl.IdentifiedCSImpl <em>Identified CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.impl.IdentifiedCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.impl.QVTCSTPackageImpl#getIdentifiedCS()
	 * @generated
	 */
	int IDENTIFIED_CS = 1;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIED_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIED_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIED_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIED_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIED_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIED_CS__IDENTIFIER = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ast Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIED_CS__AST_NODE = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Identified CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIED_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvt.cst.impl.IdentifierCSImpl <em>Identifier CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.impl.IdentifierCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.impl.QVTCSTPackageImpl#getIdentifierCS()
	 * @generated
	 */
	int IDENTIFIER_CS = 2;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_CS__VALUE = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ast Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_CS__AST_NODE = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Identifier CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.environment.IHasName <em>IHas Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.environment.IHasName
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.impl.QVTCSTPackageImpl#getIHasName()
	 * @generated
	 */
	int IHAS_NAME = 3;

	/**
	 * The number of structural features of the '<em>IHas Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHAS_NAME_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvt.cst.ErrorNode <em>Error Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Node</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.ErrorNode
	 * @generated
	 */
	EClass getErrorNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.parser.qvt.cst.ErrorNode#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.ErrorNode#getMessage()
	 * @see #getErrorNode()
	 * @generated
	 */
	EAttribute getErrorNode_Message();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS <em>Identified CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identified CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS
	 * @generated
	 */
	EClass getIdentifiedCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identifier</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS#getIdentifier()
	 * @see #getIdentifiedCS()
	 * @generated
	 */
	EReference getIdentifiedCS_Identifier();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS#getAstNode <em>Ast Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ast Node</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS#getAstNode()
	 * @see #getIdentifiedCS()
	 * @generated
	 */
	EReference getIdentifiedCS_AstNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS <em>Identifier CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS
	 * @generated
	 */
	EClass getIdentifierCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS#getValue()
	 * @see #getIdentifierCS()
	 * @generated
	 */
	EAttribute getIdentifierCS_Value();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS#getAstNode <em>Ast Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ast Node</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS#getAstNode()
	 * @see #getIdentifierCS()
	 * @generated
	 */
	EReference getIdentifierCS_AstNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.environment.IHasName <em>IHas Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IHas Name</em>'.
	 * @see org.eclipse.qvt.declarative.parser.environment.IHasName
	 * @model instanceClass="org.eclipse.qvt.declarative.parser.environment.IHasName"
	 * @generated
	 */
	EClass getIHasName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTCSTFactory getQVTCSTFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvt.cst.impl.ErrorNodeImpl <em>Error Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvt.cst.impl.ErrorNodeImpl
		 * @see org.eclipse.qvt.declarative.parser.qvt.cst.impl.QVTCSTPackageImpl#getErrorNode()
		 * @generated
		 */
		EClass ERROR_NODE = eINSTANCE.getErrorNode();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_NODE__MESSAGE = eINSTANCE.getErrorNode_Message();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvt.cst.impl.IdentifiedCSImpl <em>Identified CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvt.cst.impl.IdentifiedCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvt.cst.impl.QVTCSTPackageImpl#getIdentifiedCS()
		 * @generated
		 */
		EClass IDENTIFIED_CS = eINSTANCE.getIdentifiedCS();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIED_CS__IDENTIFIER = eINSTANCE.getIdentifiedCS_Identifier();

		/**
		 * The meta object literal for the '<em><b>Ast Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIED_CS__AST_NODE = eINSTANCE.getIdentifiedCS_AstNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvt.cst.impl.IdentifierCSImpl <em>Identifier CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvt.cst.impl.IdentifierCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvt.cst.impl.QVTCSTPackageImpl#getIdentifierCS()
		 * @generated
		 */
		EClass IDENTIFIER_CS = eINSTANCE.getIdentifierCS();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIER_CS__VALUE = eINSTANCE.getIdentifierCS_Value();

		/**
		 * The meta object literal for the '<em><b>Ast Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIER_CS__AST_NODE = eINSTANCE.getIdentifierCS_AstNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.environment.IHasName <em>IHas Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.environment.IHasName
		 * @see org.eclipse.qvt.declarative.parser.qvt.cst.impl.QVTCSTPackageImpl#getIHasName()
		 * @generated
		 */
		EClass IHAS_NAME = eINSTANCE.getIHasName();

	}

} //EqvtCSTPackage
