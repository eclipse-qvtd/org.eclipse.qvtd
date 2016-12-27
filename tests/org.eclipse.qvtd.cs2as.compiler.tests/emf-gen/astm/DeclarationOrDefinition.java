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

import java.lang.String;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declaration Or Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.DeclarationOrDefinition#isIsRegister <em>Is Register</em>}</li>
 *   <li>{@link astm.DeclarationOrDefinition#getLinkageSpecifier <em>Linkage Specifier</em>}</li>
 *   <li>{@link astm.DeclarationOrDefinition#getStorageSpecifiers <em>Storage Specifiers</em>}</li>
 *   <li>{@link astm.DeclarationOrDefinition#getAccessKind <em>Access Kind</em>}</li>
 * </ul>
 *
 * @see astm.AstmPackage#getDeclarationOrDefinition()
 * @model abstract="true"
 * @generated
 */
public interface DeclarationOrDefinition extends DefinitionObject {
	/**
	 * Returns the value of the '<em><b>Is Register</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Register</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Register</em>' attribute.
	 * @see #setIsRegister(boolean)
	 * @see astm.AstmPackage#getDeclarationOrDefinition_IsRegister()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!DeclarationOrDefinition!isRegister'"
	 * @generated
	 */
	boolean isIsRegister();

	/**
	 * Sets the value of the '{@link astm.DeclarationOrDefinition#isIsRegister <em>Is Register</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Register</em>' attribute.
	 * @see #isIsRegister()
	 * @generated
	 */
	void setIsRegister(boolean value);

	/**
	 * Returns the value of the '<em><b>Linkage Specifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linkage Specifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linkage Specifier</em>' attribute.
	 * @see #setLinkageSpecifier(String)
	 * @see astm.AstmPackage#getDeclarationOrDefinition_LinkageSpecifier()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!DeclarationOrDefinition!linkageSpecifier'"
	 * @generated
	 */
	String getLinkageSpecifier();

	/**
	 * Sets the value of the '{@link astm.DeclarationOrDefinition#getLinkageSpecifier <em>Linkage Specifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linkage Specifier</em>' attribute.
	 * @see #getLinkageSpecifier()
	 * @generated
	 */
	void setLinkageSpecifier(String value);

	/**
	 * Returns the value of the '<em><b>Storage Specifiers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Storage Specifiers</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Storage Specifiers</em>' containment reference.
	 * @see #setStorageSpecifiers(OtherSyntaxObject)
	 * @see astm.AstmPackage#getDeclarationOrDefinition_StorageSpecifiers()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!DeclarationOrDefinition!storageSpecifiers'"
	 * @generated
	 */
	OtherSyntaxObject getStorageSpecifiers();

	/**
	 * Sets the value of the '{@link astm.DeclarationOrDefinition#getStorageSpecifiers <em>Storage Specifiers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Storage Specifiers</em>' containment reference.
	 * @see #getStorageSpecifiers()
	 * @generated
	 */
	void setStorageSpecifiers(OtherSyntaxObject value);

	/**
	 * Returns the value of the '<em><b>Access Kind</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Kind</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Kind</em>' containment reference.
	 * @see #setAccessKind(OtherSyntaxObject)
	 * @see astm.AstmPackage#getDeclarationOrDefinition_AccessKind()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!DeclarationOrDefinition!accessKind'"
	 * @generated
	 */
	OtherSyntaxObject getAccessKind();

	/**
	 * Sets the value of the '{@link astm.DeclarationOrDefinition#getAccessKind <em>Access Kind</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access Kind</em>' containment reference.
	 * @see #getAccessKind()
	 * @generated
	 */
	void setAccessKind(OtherSyntaxObject value);

} // DeclarationOrDefinition
