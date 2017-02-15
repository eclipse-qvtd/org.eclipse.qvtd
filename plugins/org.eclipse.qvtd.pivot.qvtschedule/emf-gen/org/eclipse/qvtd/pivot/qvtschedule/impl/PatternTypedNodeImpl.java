/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Typed Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PatternTypedNodeImpl extends NodeImpl implements PatternTypedNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternTypedNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.PATTERN_TYPED_NODE;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitPatternTypedNode(this);
	}

	public static @NonNull PatternTypedNodeImpl create(@NonNull Role nodeRole, @NonNull Region region, @NonNull String name, @NonNull ClassDatum classDatum, boolean isMatched) {
		PatternTypedNodeImpl node = new PatternTypedNodeImpl();
		node.initialize(nodeRole, region, name, classDatum);
		node.isMatched = isMatched;
		return node;
	}

	private boolean isMatched;

	@Override
	public @NonNull Node createNode(@NonNull Role nodeRole, @NonNull Region region) {
		return create(nodeRole, region, QVTscheduleUtil.getName(this), QVTscheduleUtil.getClassDatum(this), isMatched);
	}

	@Override
	public boolean isMatched() {
		return isMatched;
	}

	@Override
	public boolean isPattern() {
		return true;
	}
} //PatternTypedNodeImpl
