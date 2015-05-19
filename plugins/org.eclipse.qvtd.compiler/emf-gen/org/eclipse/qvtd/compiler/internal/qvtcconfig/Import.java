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
package org.eclipse.qvtd.compiler.internal.qvtcconfig;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Import#getMetamodelFile <em>Metamodel File</em>}</li>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Import#getMetamodelUri <em>Metamodel Uri</em>}</li>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Import#getPackage <em>Package</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.QVTcConfigPackage#getImport()
 * @model
 * @generated
 */
public interface Import extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Metamodel File</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel File</em>' attribute.
	 * @see #setMetamodelFile(String)
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.QVTcConfigPackage#getImport_MetamodelFile()
	 * @model default=""
	 * @generated
	 */
	String getMetamodelFile();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Import#getMetamodelFile <em>Metamodel File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel File</em>' attribute.
	 * @see #getMetamodelFile()
	 * @generated
	 */
	void setMetamodelFile(String value);

	/**
	 * Returns the value of the '<em><b>Metamodel Uri</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel Uri</em>' attribute.
	 * @see #setMetamodelUri(String)
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.QVTcConfigPackage#getImport_MetamodelUri()
	 * @model default=""
	 * @generated
	 */
	String getMetamodelUri();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Import#getMetamodelUri <em>Metamodel Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel Uri</em>' attribute.
	 * @see #getMetamodelUri()
	 * @generated
	 */
	void setMetamodelUri(String value);

	/**
	 * Returns the value of the '<em><b>Package</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' attribute list.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.QVTcConfigPackage#getImport_Package()
	 * @model default=""
	 * @generated
	 */
	EList<String> getPackage();

} // Import
