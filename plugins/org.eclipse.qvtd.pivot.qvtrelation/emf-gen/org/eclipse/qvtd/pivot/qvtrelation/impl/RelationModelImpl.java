/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.impl.BaseModelImpl;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class RelationModelImpl extends BaseModelImpl implements RelationModel {
	/**
	 * The number of structural features of the '<em>Relation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RELATION_MODEL_FEATURE_COUNT = BaseModelImpl.BASE_MODEL_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Relation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RELATION_MODEL_OPERATION_COUNT = BaseModelImpl.BASE_MODEL_OPERATION_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationPackage.Literals.RELATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		if (visitor instanceof QVTrelationVisitor) {
			return (R) ((QVTrelationVisitor<?>)visitor).visitRelationModel(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //RelationModelImpl
