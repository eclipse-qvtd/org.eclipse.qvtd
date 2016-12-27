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

import astm.util.Visitable;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Member Attributes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.FunctionMemberAttributes#isIsFriend <em>Is Friend</em>}</li>
 *   <li>{@link astm.FunctionMemberAttributes#isIsInline <em>Is Inline</em>}</li>
 *   <li>{@link astm.FunctionMemberAttributes#isIsThisConst <em>Is This Const</em>}</li>
 *   <li>{@link astm.FunctionMemberAttributes#getVirtualSpecifier <em>Virtual Specifier</em>}</li>
 * </ul>
 *
 * @see astm.AstmPackage#getFunctionMemberAttributes()
 * @model superTypes="astm.Visitable"
 * @generated
 */
public interface FunctionMemberAttributes extends EObject, Visitable {
	/**
	 * Returns the value of the '<em><b>Is Friend</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Friend</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Friend</em>' attribute.
	 * @see #setIsFriend(boolean)
	 * @see astm.AstmPackage#getFunctionMemberAttributes_IsFriend()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!FunctionMemberAttributes!isFriend'"
	 * @generated
	 */
	boolean isIsFriend();

	/**
	 * Sets the value of the '{@link astm.FunctionMemberAttributes#isIsFriend <em>Is Friend</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Friend</em>' attribute.
	 * @see #isIsFriend()
	 * @generated
	 */
	void setIsFriend(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Inline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Inline</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Inline</em>' attribute.
	 * @see #setIsInline(boolean)
	 * @see astm.AstmPackage#getFunctionMemberAttributes_IsInline()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!FunctionMemberAttributes!isInline'"
	 * @generated
	 */
	boolean isIsInline();

	/**
	 * Sets the value of the '{@link astm.FunctionMemberAttributes#isIsInline <em>Is Inline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Inline</em>' attribute.
	 * @see #isIsInline()
	 * @generated
	 */
	void setIsInline(boolean value);

	/**
	 * Returns the value of the '<em><b>Is This Const</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is This Const</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is This Const</em>' attribute.
	 * @see #setIsThisConst(boolean)
	 * @see astm.AstmPackage#getFunctionMemberAttributes_IsThisConst()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!FunctionMemberAttributes!isThisConst'"
	 * @generated
	 */
	boolean isIsThisConst();

	/**
	 * Sets the value of the '{@link astm.FunctionMemberAttributes#isIsThisConst <em>Is This Const</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is This Const</em>' attribute.
	 * @see #isIsThisConst()
	 * @generated
	 */
	void setIsThisConst(boolean value);

	/**
	 * Returns the value of the '<em><b>Virtual Specifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Virtual Specifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Virtual Specifier</em>' containment reference.
	 * @see #setVirtualSpecifier(VirtualSpecification)
	 * @see astm.AstmPackage#getFunctionMemberAttributes_VirtualSpecifier()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!FunctionMemberAttributes!virtualSpecifier'"
	 * @generated
	 */
	VirtualSpecification getVirtualSpecifier();

	/**
	 * Sets the value of the '{@link astm.FunctionMemberAttributes#getVirtualSpecifier <em>Virtual Specifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Virtual Specifier</em>' containment reference.
	 * @see #getVirtualSpecifier()
	 * @generated
	 */
	void setVirtualSpecifier(VirtualSpecification value);

} // FunctionMemberAttributes
