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
package astm.impl;

import astm.AstmPackage;
import astm.Negate;

import astm.util.Visitor;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Negate</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class NegateImpl extends UnaryOperatorImpl implements Negate {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NegateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.NEGATE;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitNegate(this);
	}

} //NegateImpl
