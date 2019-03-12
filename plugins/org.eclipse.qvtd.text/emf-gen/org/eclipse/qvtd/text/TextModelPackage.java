/**
 * <copyright>
 * 
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.text;

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
 * @see org.eclipse.qvtd.text.TextModelFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/qvt/2018/PostProcess raw='org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl' processed='org.eclipse.qvtd.text.utilities.TextModelResourceFactoryImpl'"
 * @generated
 */
public interface TextModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "text";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/2018/TextModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "text";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TextModelPackage eINSTANCE = org.eclipse.qvtd.text.impl.TextModelPackageImpl.init();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.text.StringNode <em>String Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Node</em>'.
	 * @see org.eclipse.qvtd.text.StringNode
	 * @generated
	 */
	EClass getStringNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.text.StringNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.qvtd.text.StringNode#getChildren()
	 * @see #getStringNode()
	 * @generated
	 */
	EReference getStringNode_Children();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.text.StringNode#getEndText <em>End Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Text</em>'.
	 * @see org.eclipse.qvtd.text.StringNode#getEndText()
	 * @see #getStringNode()
	 * @generated
	 */
	EAttribute getStringNode_EndText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.text.StringNode#getIndent <em>Indent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indent</em>'.
	 * @see org.eclipse.qvtd.text.StringNode#getIndent()
	 * @see #getStringNode()
	 * @generated
	 */
	EAttribute getStringNode_Indent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.text.StringNode#getNonBreakingSpace <em>Non Breaking Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Non Breaking Space</em>'.
	 * @see org.eclipse.qvtd.text.StringNode#getNonBreakingSpace()
	 * @see #getStringNode()
	 * @generated
	 */
	EAttribute getStringNode_NonBreakingSpace();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.text.StringNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.eclipse.qvtd.text.StringNode#getParent()
	 * @see #getStringNode()
	 * @generated
	 */
	EReference getStringNode_Parent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.text.StringNode#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.eclipse.qvtd.text.StringNode#getPrefix()
	 * @see #getStringNode()
	 * @generated
	 */
	EAttribute getStringNode_Prefix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.text.StringNode#getSeparator <em>Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Separator</em>'.
	 * @see org.eclipse.qvtd.text.StringNode#getSeparator()
	 * @see #getStringNode()
	 * @generated
	 */
	EAttribute getStringNode_Separator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.text.StringNode#getSuffix <em>Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suffix</em>'.
	 * @see org.eclipse.qvtd.text.StringNode#getSuffix()
	 * @see #getStringNode()
	 * @generated
	 */
	EAttribute getStringNode_Suffix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.text.StringNode#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.qvtd.text.StringNode#getText()
	 * @see #getStringNode()
	 * @generated
	 */
	EAttribute getStringNode_Text();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TextModelFactory getTextModelFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.text.impl.StringNodeImpl <em>String Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.text.impl.StringNodeImpl
		 * @see org.eclipse.qvtd.text.impl.TextModelPackageImpl#getStringNode()
		 * @generated
		 */
		EClass STRING_NODE = eINSTANCE.getStringNode();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_NODE__CHILDREN = eINSTANCE.getStringNode_Children();

		/**
		 * The meta object literal for the '<em><b>End Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_NODE__END_TEXT = eINSTANCE.getStringNode_EndText();

		/**
		 * The meta object literal for the '<em><b>Indent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_NODE__INDENT = eINSTANCE.getStringNode_Indent();

		/**
		 * The meta object literal for the '<em><b>Non Breaking Space</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_NODE__NON_BREAKING_SPACE = eINSTANCE.getStringNode_NonBreakingSpace();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_NODE__PARENT = eINSTANCE.getStringNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_NODE__PREFIX = eINSTANCE.getStringNode_Prefix();

		/**
		 * The meta object literal for the '<em><b>Separator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_NODE__SEPARATOR = eINSTANCE.getStringNode_Separator();

		/**
		 * The meta object literal for the '<em><b>Suffix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_NODE__SUFFIX = eINSTANCE.getStringNode_Suffix();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_NODE__TEXT = eINSTANCE.getStringNode_Text();

	}

} //TextModelPackage
