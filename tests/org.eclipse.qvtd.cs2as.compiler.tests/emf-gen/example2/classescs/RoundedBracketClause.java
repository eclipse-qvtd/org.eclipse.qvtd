/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
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
package example2.classescs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rounded Bracket Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example2.classescs.RoundedBracketClause#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @see example2.classescs.ClassescsPackage#getRoundedBracketClause()
 * @model
 * @generated
 */
public interface RoundedBracketClause extends ElementCS {
	/**
	 * Returns the value of the '<em><b>Args</b></em>' containment reference list.
	 * The list contents are of type {@link example2.classescs.ArgumentCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Args</em>' containment reference list.
	 * @see example2.classescs.ClassescsPackage#getRoundedBracketClause_Args()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArgumentCS> getArgs();

} // RoundedBracketClause
