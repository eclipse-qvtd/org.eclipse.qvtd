/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSV2HSLPackage
 * @generated
 */
public interface HSV2HSLFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HSV2HSLFactory eINSTANCE = org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.impl.HSV2HSLFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>HSV Node2 HSL Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HSV Node2 HSL Node</em>'.
	 * @generated
	 */
	HSVNode2HSLNode createHSVNode2HSLNode();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	HSV2HSLPackage getHSV2HSLPackage();

} //HSV2HSLFactory
