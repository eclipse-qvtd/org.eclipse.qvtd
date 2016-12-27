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
package delphi;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.unit#getPort <em>Port</em>}</li>
 *   <li>{@link delphi.unit#getInterfaceSect <em>Interface Sect</em>}</li>
 *   <li>{@link delphi.unit#getImplementationSect <em>Implementation Sect</em>}</li>
 *   <li>{@link delphi.unit#getInitSect <em>Init Sect</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getunit()
 * @model
 * @generated
 */
public interface unit extends file {
	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(String)
	 * @see delphi.DelphiPackage#getunit_Port()
	 * @model
	 * @generated
	 */
	String getPort();

	/**
	 * Sets the value of the '{@link delphi.unit#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(String value);

	/**
	 * Returns the value of the '<em><b>Interface Sect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface Sect</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface Sect</em>' containment reference.
	 * @see #setInterfaceSect(interfaceSection)
	 * @see delphi.DelphiPackage#getunit_InterfaceSect()
	 * @model containment="true"
	 * @generated
	 */
	interfaceSection getInterfaceSect();

	/**
	 * Sets the value of the '{@link delphi.unit#getInterfaceSect <em>Interface Sect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface Sect</em>' containment reference.
	 * @see #getInterfaceSect()
	 * @generated
	 */
	void setInterfaceSect(interfaceSection value);

	/**
	 * Returns the value of the '<em><b>Implementation Sect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Sect</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation Sect</em>' containment reference.
	 * @see #setImplementationSect(implementationSection)
	 * @see delphi.DelphiPackage#getunit_ImplementationSect()
	 * @model containment="true"
	 * @generated
	 */
	implementationSection getImplementationSect();

	/**
	 * Sets the value of the '{@link delphi.unit#getImplementationSect <em>Implementation Sect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Sect</em>' containment reference.
	 * @see #getImplementationSect()
	 * @generated
	 */
	void setImplementationSect(implementationSection value);

	/**
	 * Returns the value of the '<em><b>Init Sect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Sect</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Sect</em>' containment reference.
	 * @see #setInitSect(initSection)
	 * @see delphi.DelphiPackage#getunit_InitSect()
	 * @model containment="true"
	 * @generated
	 */
	initSection getInitSect();

	/**
	 * Sets the value of the '{@link delphi.unit#getInitSect <em>Init Sect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Sect</em>' containment reference.
	 * @see #getInitSect()
	 * @generated
	 */
	void setInitSect(initSection value);

} // unit
