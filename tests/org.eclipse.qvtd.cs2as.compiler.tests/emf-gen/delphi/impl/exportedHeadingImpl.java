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
package delphi.impl;

import delphi.DelphiPackage;
import delphi.directive;
import delphi.exportedHeading;
import delphi.functionHeading;
import delphi.procedureHeading;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>exported Heading</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.exportedHeadingImpl#getPHeading <em>PHeading</em>}</li>
 *   <li>{@link delphi.impl.exportedHeadingImpl#getDirective <em>Directive</em>}</li>
 *   <li>{@link delphi.impl.exportedHeadingImpl#getFHeading <em>FHeading</em>}</li>
 * </ul>
 *
 * @generated
 */
public class exportedHeadingImpl extends interfaceDeclImpl implements exportedHeading {
	/**
	 * The cached value of the '{@link #getPHeading() <em>PHeading</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPHeading()
	 * @generated
	 * @ordered
	 */
	protected procedureHeading pHeading;

	/**
	 * The cached value of the '{@link #getDirective() <em>Directive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirective()
	 * @generated
	 * @ordered
	 */
	protected directive directive;

	/**
	 * The cached value of the '{@link #getFHeading() <em>FHeading</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFHeading()
	 * @generated
	 * @ordered
	 */
	protected functionHeading fHeading;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected exportedHeadingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.EXPORTED_HEADING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public procedureHeading getPHeading() {
		return pHeading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPHeading(procedureHeading newPHeading, NotificationChain msgs) {
		procedureHeading oldPHeading = pHeading;
		pHeading = newPHeading;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.EXPORTED_HEADING__PHEADING, oldPHeading, newPHeading);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPHeading(procedureHeading newPHeading) {
		if (newPHeading != pHeading) {
			NotificationChain msgs = null;
			if (pHeading != null)
				msgs = ((InternalEObject)pHeading).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.EXPORTED_HEADING__PHEADING, null, msgs);
			if (newPHeading != null)
				msgs = ((InternalEObject)newPHeading).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.EXPORTED_HEADING__PHEADING, null, msgs);
			msgs = basicSetPHeading(newPHeading, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.EXPORTED_HEADING__PHEADING, newPHeading, newPHeading));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public directive getDirective() {
		return directive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDirective(directive newDirective, NotificationChain msgs) {
		directive oldDirective = directive;
		directive = newDirective;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.EXPORTED_HEADING__DIRECTIVE, oldDirective, newDirective);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirective(directive newDirective) {
		if (newDirective != directive) {
			NotificationChain msgs = null;
			if (directive != null)
				msgs = ((InternalEObject)directive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.EXPORTED_HEADING__DIRECTIVE, null, msgs);
			if (newDirective != null)
				msgs = ((InternalEObject)newDirective).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.EXPORTED_HEADING__DIRECTIVE, null, msgs);
			msgs = basicSetDirective(newDirective, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.EXPORTED_HEADING__DIRECTIVE, newDirective, newDirective));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public functionHeading getFHeading() {
		return fHeading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFHeading(functionHeading newFHeading, NotificationChain msgs) {
		functionHeading oldFHeading = fHeading;
		fHeading = newFHeading;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.EXPORTED_HEADING__FHEADING, oldFHeading, newFHeading);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFHeading(functionHeading newFHeading) {
		if (newFHeading != fHeading) {
			NotificationChain msgs = null;
			if (fHeading != null)
				msgs = ((InternalEObject)fHeading).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.EXPORTED_HEADING__FHEADING, null, msgs);
			if (newFHeading != null)
				msgs = ((InternalEObject)newFHeading).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.EXPORTED_HEADING__FHEADING, null, msgs);
			msgs = basicSetFHeading(newFHeading, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.EXPORTED_HEADING__FHEADING, newFHeading, newFHeading));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.EXPORTED_HEADING__PHEADING:
				return basicSetPHeading(null, msgs);
			case DelphiPackage.EXPORTED_HEADING__DIRECTIVE:
				return basicSetDirective(null, msgs);
			case DelphiPackage.EXPORTED_HEADING__FHEADING:
				return basicSetFHeading(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DelphiPackage.EXPORTED_HEADING__PHEADING:
				return getPHeading();
			case DelphiPackage.EXPORTED_HEADING__DIRECTIVE:
				return getDirective();
			case DelphiPackage.EXPORTED_HEADING__FHEADING:
				return getFHeading();
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
			case DelphiPackage.EXPORTED_HEADING__PHEADING:
				setPHeading((procedureHeading)newValue);
				return;
			case DelphiPackage.EXPORTED_HEADING__DIRECTIVE:
				setDirective((directive)newValue);
				return;
			case DelphiPackage.EXPORTED_HEADING__FHEADING:
				setFHeading((functionHeading)newValue);
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
			case DelphiPackage.EXPORTED_HEADING__PHEADING:
				setPHeading((procedureHeading)null);
				return;
			case DelphiPackage.EXPORTED_HEADING__DIRECTIVE:
				setDirective((directive)null);
				return;
			case DelphiPackage.EXPORTED_HEADING__FHEADING:
				setFHeading((functionHeading)null);
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
			case DelphiPackage.EXPORTED_HEADING__PHEADING:
				return pHeading != null;
			case DelphiPackage.EXPORTED_HEADING__DIRECTIVE:
				return directive != null;
			case DelphiPackage.EXPORTED_HEADING__FHEADING:
				return fHeading != null;
		}
		return super.eIsSet(featureID);
	}


} //exportedHeadingImpl
