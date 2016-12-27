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
 * A representation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.ForStatement#getInitBody <em>Init Body</em>}</li>
 *   <li>{@link astm.ForStatement#getIterationBody <em>Iteration Body</em>}</li>
 * </ul>
 *
 * @see astm.AstmPackage#getForStatement()
 * @model abstract="true"
 * @generated
 */
public interface ForStatement extends LoopStatement {
	/**
	 * Returns the value of the '<em><b>Init Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Body</em>' containment reference.
	 * @see #setInitBody(Expression)
	 * @see astm.AstmPackage#getForStatement_InitBody()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!ForStatement!initBody'"
	 * @generated
	 */
	Expression getInitBody();

	/**
	 * Sets the value of the '{@link astm.ForStatement#getInitBody <em>Init Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Body</em>' containment reference.
	 * @see #getInitBody()
	 * @generated
	 */
	void setInitBody(Expression value);

	/**
	 * Returns the value of the '<em><b>Iteration Body</b></em>' containment reference list.
	 * The list contents are of type {@link astm.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iteration Body</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iteration Body</em>' containment reference list.
	 * @see astm.AstmPackage#getForStatement_IterationBody()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!ForStatement!iterationBody'"
	 * @generated
	 */
	EList<Expression> getIterationBody();

} // ForStatement
