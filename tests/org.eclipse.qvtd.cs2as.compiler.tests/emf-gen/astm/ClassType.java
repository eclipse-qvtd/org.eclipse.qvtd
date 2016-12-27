/**
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 */
package astm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.ClassType#getDerivesFrom <em>Derives From</em>}</li>
 * </ul>
 *
 * @see astm.AstmPackage#getClassType()
 * @model
 * @generated
 */
public interface ClassType extends AggregateType {
	/**
	 * Returns the value of the '<em><b>Derives From</b></em>' containment reference list.
	 * The list contents are of type {@link astm.DerivesFrom}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derives From</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derives From</em>' containment reference list.
	 * @see astm.AstmPackage#getClassType_DerivesFrom()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!ClassType!derivesFrom'"
	 * @generated
	 */
	EList<DerivesFrom> getDerivesFrom();

} // ClassType
