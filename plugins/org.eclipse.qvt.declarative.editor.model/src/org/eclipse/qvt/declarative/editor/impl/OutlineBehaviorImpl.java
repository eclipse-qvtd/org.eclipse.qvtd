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
 * $Id: OutlineBehaviorImpl.java,v 1.2 2008/08/09 17:33:58 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.qvt.declarative.editor.EditorPackage;
import org.eclipse.qvt.declarative.editor.OutlineBehavior;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Outline Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.editor.impl.OutlineBehaviorImpl#isContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.editor.impl.OutlineBehaviorImpl#isTerminal <em>Terminal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutlineBehaviorImpl extends BehaviorImpl implements OutlineBehavior {
	/**
	 * The default value of the '{@link #isContainer() <em>Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainer()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTAINER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContainer() <em>Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainer()
	 * @generated
	 * @ordered
	 */
	protected boolean container = CONTAINER_EDEFAULT;

	/**
	 * The default value of the '{@link #isTerminal() <em>Terminal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTerminal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TERMINAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTerminal() <em>Terminal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTerminal()
	 * @generated
	 * @ordered
	 */
	protected boolean terminal = TERMINAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutlineBehaviorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EditorPackage.Literals.OUTLINE_BEHAVIOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(boolean newContainer) {
		boolean oldContainer = container;
		container = newContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.OUTLINE_BEHAVIOR__CONTAINER, oldContainer, container));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTerminal() {
		return terminal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTerminal(boolean newTerminal) {
		boolean oldTerminal = terminal;
		terminal = newTerminal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.OUTLINE_BEHAVIOR__TERMINAL, oldTerminal, terminal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EditorPackage.OUTLINE_BEHAVIOR__CONTAINER:
				return isContainer() ? Boolean.TRUE : Boolean.FALSE;
			case EditorPackage.OUTLINE_BEHAVIOR__TERMINAL:
				return isTerminal() ? Boolean.TRUE : Boolean.FALSE;
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
			case EditorPackage.OUTLINE_BEHAVIOR__CONTAINER:
				setContainer(((Boolean)newValue).booleanValue());
				return;
			case EditorPackage.OUTLINE_BEHAVIOR__TERMINAL:
				setTerminal(((Boolean)newValue).booleanValue());
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
			case EditorPackage.OUTLINE_BEHAVIOR__CONTAINER:
				setContainer(CONTAINER_EDEFAULT);
				return;
			case EditorPackage.OUTLINE_BEHAVIOR__TERMINAL:
				setTerminal(TERMINAL_EDEFAULT);
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
			case EditorPackage.OUTLINE_BEHAVIOR__CONTAINER:
				return container != CONTAINER_EDEFAULT;
			case EditorPackage.OUTLINE_BEHAVIOR__TERMINAL:
				return terminal != TERMINAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (container: ");
		result.append(container);
		result.append(", terminal: ");
		result.append(terminal);
		result.append(')');
		return result.toString();
	}

} //OutlineBehaviorImpl
