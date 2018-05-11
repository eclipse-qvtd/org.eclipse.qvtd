/**
 * <copyright>
 * 
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.text;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A tree of StringNodes provides a hierarchical text structure with an optional cumulative indent, prefix, separator and suffix for child nodes.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.text.StringNode#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.qvtd.text.StringNode#getIndent <em>Indent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.text.StringNode#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.text.StringNode#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.qvtd.text.StringNode#getSeparator <em>Separator</em>}</li>
 *   <li>{@link org.eclipse.qvtd.text.StringNode#getSuffix <em>Suffix</em>}</li>
 *   <li>{@link org.eclipse.qvtd.text.StringNode#getText <em>Text</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.text.TextModelPackage#getStringNode()
 * @model
 * @generated
 */
public interface StringNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.text.StringNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.text.StringNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The child nodes to be preceded by an optional prefix, separated by an optional separatpr and followed by an optional suffix, with all lines preceded by the cumulative indent.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.qvtd.text.TextModelPackage#getStringNode_Children()
	 * @see org.eclipse.qvtd.text.StringNode#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<StringNode> getChildren();

	/**
	 * Returns the value of the '<em><b>Indent</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Optional additional indent for each child StringTree, in addition to the cumulative indent of all parent StringTrees.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Indent</em>' attribute.
	 * @see #setIndent(String)
	 * @see org.eclipse.qvtd.text.TextModelPackage#getStringNode_Indent()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getIndent();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.text.StringNode#getIndent <em>Indent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indent</em>' attribute.
	 * @see #getIndent()
	 * @generated
	 */
	void setIndent(String value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.text.StringNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The parent node that provides the cumulative indent.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(StringNode)
	 * @see org.eclipse.qvtd.text.TextModelPackage#getStringNode_Parent()
	 * @see org.eclipse.qvtd.text.StringNode#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	StringNode getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.text.StringNode#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(StringNode value);

	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Optional prefix to precede the first child, if there is one.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(String)
	 * @see org.eclipse.qvtd.text.TextModelPackage#getStringNode_Prefix()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.text.StringNode#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Separator</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Optional separator between eah child, if there are any.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Separator</em>' attribute.
	 * @see #setSeparator(String)
	 * @see org.eclipse.qvtd.text.TextModelPackage#getStringNode_Separator()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getSeparator();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.text.StringNode#getSeparator <em>Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Separator</em>' attribute.
	 * @see #getSeparator()
	 * @generated
	 */
	void setSeparator(String value);

	/**
	 * Returns the value of the '<em><b>Suffix</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Optional suffix to follow the last child, if there is one.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Suffix</em>' attribute.
	 * @see #setSuffix(String)
	 * @see org.eclipse.qvtd.text.TextModelPackage#getStringNode_Suffix()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getSuffix();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.text.StringNode#getSuffix <em>Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suffix</em>' attribute.
	 * @see #getSuffix()
	 * @generated
	 */
	void setSuffix(String value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Optional text of this StringTree to precede all chidren (and prefix).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.eclipse.qvtd.text.TextModelPackage#getStringNode_Text()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.text.StringNode#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

} // StringNode
