/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
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
 * $Id: OppositePropertyCallExpImpl.java,v 1.1 2008/09/09 21:00:31 ewillink Exp $
 */
package org.eclipse.qvt.declarative.emof.QVTRelation.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.qvt.declarative.emof.EssentialOCL.impl.PropertyCallExpImpl;

import org.eclipse.qvt.declarative.emof.QVTRelation.OppositePropertyCallExp;
import org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Opposite Property Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OppositePropertyCallExpImpl extends PropertyCallExpImpl implements OppositePropertyCallExp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OppositePropertyCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTRelationPackage.Literals.OPPOSITE_PROPERTY_CALL_EXP;
	}

} //OppositePropertyCallExpImpl
