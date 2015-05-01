/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example1.source;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path Name CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example1.source.PathNameCS#getPath <em>Path</em>}</li>
 *   <li>{@link example1.source.PathNameCS#getContext <em>Context</em>}</li>
 * </ul>
 *
 * @see example1.source.SourcePackage#getPathNameCS()
 * @model
 * @generated
 */
public interface PathNameCS extends SElement {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' containment reference list.
	 * The list contents are of type {@link example1.source.PathElementCS}.
	 * It is bidirectional and its opposite is '{@link example1.source.PathElementCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' containment reference list.
	 * @see example1.source.SourcePackage#getPathNameCS_Path()
	 * @see example1.source.PathElementCS#getPathName
	 * @model opposite="pathName" containment="true" required="true"
	 * @generated
	 */
	EList<PathElementCS> getPath();

	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(SElement)
	 * @see example1.source.SourcePackage#getPathNameCS_Context()
	 * @model
	 * @generated
	 */
	SElement getContext();

	/**
	 * Sets the value of the '{@link example1.source.PathNameCS#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(SElement value);

} // PathNameCS
