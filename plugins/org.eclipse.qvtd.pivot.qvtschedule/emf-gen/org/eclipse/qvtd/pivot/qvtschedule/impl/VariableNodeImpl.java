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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtschedule.NodeRole;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.VariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.Visitor2;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class VariableNodeImpl extends NodeImpl implements VariableNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.VARIABLE_NODE;
	}

	private @Nullable VariableDeclaration variable;			// null is only permitted during construction

	@Override
	public <R> R accept(@NonNull Visitor2<R> visitor) {
		return visitor.visitVariableNode(this);
	}

	public @NonNull VariableDeclaration getVariable() {
		return ClassUtil.nonNullState(variable);
	}

	protected void initialize(@NonNull NodeRole nodeRole, @NonNull Region region, @NonNull VariableDeclaration variable) {
		initialize(nodeRole, region, ClassUtil.nonNullState(variable.getName()), region.getClassDatumAnalysis(variable));
		this.variable = variable;
		assert variable.eContainer() != null;
		assert variable.getName() != null;
		addTypedElement(variable);
		region.addVariableNode(variable, this);
	}

	@Override
	public @NonNull String toString() {
		return getNodeRole().getPhase() + "-" + getClass().getSimpleName().replace("Impl",  "") + "(" + (variable != null ? variable.toString() : getName()) + ")";
	}
} //VariableNodeImpl
