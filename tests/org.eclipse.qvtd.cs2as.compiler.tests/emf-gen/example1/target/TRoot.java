/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example1.target;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import example1.target.util.Visitable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TRoot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example1.target.TRoot#getOwnedA <em>Owned A</em>}</li>
 * </ul>
 *
 * @see example1.target.TargetPackage#getTRoot()
 * @model superTypes="example1.target.Visitable"
 * @generated
 */
public interface TRoot extends EObject, Visitable {
	/**
	 * Returns the value of the '<em><b>Owned A</b></em>' containment reference list.
	 * The list contents are of type {@link example1.target.A}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned A</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned A</em>' containment reference list.
	 * @see example1.target.TargetPackage#getTRoot_OwnedA()
	 * @model containment="true"
	 * @generated
	 */
	EList<A> getOwnedA();

} // TRoot
