/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtrelationcs.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

import org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainPatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;

import org.eclipse.qvtd.xtext.qvtrelationcs.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type Domain Pattern CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PrimitiveTypeDomainPatternCSImpl extends TemplateVariableCSImpl implements PrimitiveTypeDomainPatternCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveTypeDomainPatternCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationCSPackage.Literals.PRIMITIVE_TYPE_DOMAIN_PATTERN_CS;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((QVTrelationCSVisitor<?>)visitor).visitPrimitiveTypeDomainPatternCS(this);
	}

} //PrimitiveTypeDomainPatternCSImpl
