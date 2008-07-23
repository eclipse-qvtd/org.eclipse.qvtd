/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: ReflectiveSequence.java,v 1.1 2008/07/23 09:55:17 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.EMOF;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reflective Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage#getReflectiveSequence()
 * @model
 * @generated
 */
public interface ReflectiveSequence extends ReflectiveCollection {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model indexDataType="org.eclipse.qvt.declarative.emof.EMOF.Integer"
	 * @generated
	 */
	void add(Integer index, org.eclipse.qvt.declarative.emof.EMOF.Object object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model indexDataType="org.eclipse.qvt.declarative.emof.EMOF.Integer"
	 * @generated
	 */
	org.eclipse.qvt.declarative.emof.EMOF.Object get(Integer index);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model indexDataType="org.eclipse.qvt.declarative.emof.EMOF.Integer"
	 * @generated
	 */
	org.eclipse.qvt.declarative.emof.EMOF.Object remove(Integer index);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model indexDataType="org.eclipse.qvt.declarative.emof.EMOF.Integer"
	 * @generated
	 */
	org.eclipse.qvt.declarative.emof.EMOF.Object set(Integer index, org.eclipse.qvt.declarative.emof.EMOF.Object object);

} // ReflectiveSequence
