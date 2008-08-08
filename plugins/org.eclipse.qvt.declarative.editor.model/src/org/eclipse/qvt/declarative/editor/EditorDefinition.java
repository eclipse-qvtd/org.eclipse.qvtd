/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
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
 * $Id: EditorDefinition.java,v 1.1 2008/08/08 16:39:54 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.editor.EditorDefinition#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.editor.EditorPackage#getEditorDefinition()
 * @model
 * @generated
 */
public interface EditorDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Node</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.editor.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.editor.EditorPackage#getEditorDefinition_Node()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Node> getNode();

} // EditorDefinition
