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
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Phase;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.VariableNode;

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

	public @NonNull VariableDeclaration getVariable() {
		return ClassUtil.nonNullState(variable);
	}

	protected void initialize(@NonNull Role nodeRole, @NonNull Region region, @NonNull VariableDeclaration variable) {
		initialize(nodeRole, region, ClassUtil.nonNullState(variable.getName()), region.getScheduleModel().getClassDatum(variable));
		this.variable = variable;
		assert variable.eContainer() != null;
		assert variable.getName() != null;
		addTypedElement(variable);
		region.addVariableNode(variable, this);
	}

	@Override
	public @NonNull String toString() {
		Role nodeRole = getNodeRole();
		Phase phase = nodeRole != null ? nodeRole.getPhase() : null;
		return phase + "-" + getClass().getSimpleName().replace("Impl",  "") + "(" + (variable != null ? variable.toString() : getName()) + ")";
	}
} //VariableNodeImpl
