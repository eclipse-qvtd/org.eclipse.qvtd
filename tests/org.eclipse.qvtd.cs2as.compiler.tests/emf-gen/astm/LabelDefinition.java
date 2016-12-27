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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Label Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.LabelDefinition#getLabelName <em>Label Name</em>}</li>
 *   <li>{@link astm.LabelDefinition#getLabelType <em>Label Type</em>}</li>
 * </ul>
 *
 * @see astm.AstmPackage#getLabelDefinition()
 * @model
 * @generated
 */
public interface LabelDefinition extends DefinitionObject {
	/**
	 * Returns the value of the '<em><b>Label Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Name</em>' containment reference.
	 * @see #setLabelName(Name)
	 * @see astm.AstmPackage#getLabelDefinition_LabelName()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!LabelDefinition!labelName'"
	 * @generated
	 */
	Name getLabelName();

	/**
	 * Sets the value of the '{@link astm.LabelDefinition#getLabelName <em>Label Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Name</em>' containment reference.
	 * @see #getLabelName()
	 * @generated
	 */
	void setLabelName(Name value);

	/**
	 * Returns the value of the '<em><b>Label Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Type</em>' containment reference.
	 * @see #setLabelType(LabelType)
	 * @see astm.AstmPackage#getLabelDefinition_LabelType()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!LabelDefinition!labelType'"
	 * @generated
	 */
	LabelType getLabelType();

	/**
	 * Sets the value of the '{@link astm.LabelDefinition#getLabelType <em>Label Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Type</em>' containment reference.
	 * @see #getLabelType()
	 * @generated
	 */
	void setLabelType(LabelType value);

} // LabelDefinition
