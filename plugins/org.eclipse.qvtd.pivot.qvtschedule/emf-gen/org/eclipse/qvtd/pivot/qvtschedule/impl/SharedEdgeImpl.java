/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;

import org.eclipse.ocl.pivot.internal.ElementImpl;

import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToGraphHelper;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.SharedEdge;

import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Shared Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.SharedEdgeImpl#getReferredOppositeProperty <em>Referred Opposite Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SharedEdgeImpl extends NavigableEdgeImpl implements SharedEdge {
	/**
	 * The number of structural features of the '<em>Shared Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SHARED_EDGE_FEATURE_COUNT = NavigableEdgeImpl.NAVIGABLE_EDGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Shared Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SHARED_EDGE_OPERATION_COUNT = NavigableEdgeImpl.NAVIGABLE_EDGE_OPERATION_COUNT + 0;


	/**
	 * The cached value of the '{@link #getReferredOppositeProperty() <em>Referred Opposite Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredOppositeProperty()
	 * @generated
	 * @ordered
	 */
	protected Property referredOppositeProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SharedEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.SHARED_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getReferredOppositeProperty() {
		if (referredOppositeProperty != null && referredOppositeProperty.eIsProxy()) {
			InternalEObject oldReferredOppositeProperty = (InternalEObject)referredOppositeProperty;
			referredOppositeProperty = (Property)eResolveProxy(oldReferredOppositeProperty);
			if (referredOppositeProperty != oldReferredOppositeProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 8, oldReferredOppositeProperty, referredOppositeProperty));
			}
		}
		return referredOppositeProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetReferredOppositeProperty() {
		return referredOppositeProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredOppositeProperty(Property newReferredOppositeProperty) {
		Property oldReferredOppositeProperty = referredOppositeProperty;
		referredOppositeProperty = newReferredOppositeProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 8, oldReferredOppositeProperty, referredOppositeProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
				if (resolve) return getReferredOppositeProperty();
			return basicGetReferredOppositeProperty();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
				setReferredOppositeProperty((Property)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
				setReferredOppositeProperty((Property)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
				return referredOppositeProperty != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitSharedEdge(this);
	}

	@Override
	public void appendEdgeAttributes(@NonNull ToGraphHelper toGraphHelper, @NonNull String sourceName, @NonNull String targetName) {
		GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
		toGraphHelper.setColor(this);
		@Nullable
		NavigationEdge oppositeEdge2 = null; //oppositeEdge;
		if (oppositeEdge2 != null) {
			String oppositeLabel = oppositeEdge2.getLabel();
			ClassDatum sourceClassDatum = QVTscheduleUtil.getClassDatum(QVTscheduleUtil.getSourceNode(this));
			for (@NonNull CompleteClass completeClass : QVTscheduleUtil.getCompleteClasses(sourceClassDatum)) {
				if ((oppositeLabel != null) && !oppositeEdge2.getReferredProperty().getName().equals(completeClass.getName())) {
					s.setTaillabel(oppositeLabel);
					break;
				}
			}
		}
		String label = getLabel();
		if (label != null) {
			s.setHeadlabel(label);
		}
		String style = getStyle();
		if (style != null) {
			s.setStyle(style);
		}
		if (!isSecondary() && (oppositeEdge2 != null)) {
			s.setDir("both");
			s.setArrowtail("vee");
		}
		s.setArrowhead("normal");
		s.setPenwidth(getPenwidth());
		s.appendAttributedEdge(sourceName, this, targetName);
	}

	@Override
	public @NonNull String getDisplayName() {
		Property target2sourceProperty2 = getReferredOppositeProperty();
		if (target2sourceProperty2 != null) {
			return "~" + target2sourceProperty2.getName();
		}
		else {
			return "null";
		}
	}

	@Override
	public @Nullable String getLabel() {
		Property target2sourceProperty2 = getReferredOppositeProperty();
		if (target2sourceProperty2 == null) {
			return "null";
		}
		else {
			return "~" + target2sourceProperty2.getName();
		}
	}

	@Override
	public Property getProperty() {
		throw new UnsupportedOperationException();
	}
} //SharedEdgeImpl
