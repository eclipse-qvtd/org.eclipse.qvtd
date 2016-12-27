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
 * A representation of the model object '<em><b>Annotation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.AnnotationExpression#getAnnotationType <em>Annotation Type</em>}</li>
 *   <li>{@link astm.AnnotationExpression#getMemberValues <em>Member Values</em>}</li>
 * </ul>
 *
 * @see astm.AstmPackage#getAnnotationExpression()
 * @model
 * @generated
 */
public interface AnnotationExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Annotation Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation Type</em>' containment reference.
	 * @see #setAnnotationType(TypeReference)
	 * @see astm.AstmPackage#getAnnotationExpression_AnnotationType()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!AnnotationExpression!annotationType'"
	 * @generated
	 */
	TypeReference getAnnotationType();

	/**
	 * Sets the value of the '{@link astm.AnnotationExpression#getAnnotationType <em>Annotation Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation Type</em>' containment reference.
	 * @see #getAnnotationType()
	 * @generated
	 */
	void setAnnotationType(TypeReference value);

	/**
	 * Returns the value of the '<em><b>Member Values</b></em>' containment reference list.
	 * The list contents are of type {@link astm.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member Values</em>' containment reference list.
	 * @see astm.AstmPackage#getAnnotationExpression_MemberValues()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!AnnotationExpression!memberValues'"
	 * @generated
	 */
	EList<Expression> getMemberValues();

} // AnnotationExpression
