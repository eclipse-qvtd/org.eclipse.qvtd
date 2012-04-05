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
 * $Id: GuardPatternCSImpl.java,v 1.1 2008/07/23 10:06:41 qglineur Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.GuardPatternCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guard Pattern CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class GuardPatternCSImpl extends PatternCSImpl implements GuardPatternCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GuardPatternCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcCSTPackage.Literals.GUARD_PATTERN_CS;
	}

} //GuardPatternCSImpl
