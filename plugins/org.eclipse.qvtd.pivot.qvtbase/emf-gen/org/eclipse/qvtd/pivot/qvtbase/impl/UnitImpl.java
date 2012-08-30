/**
 */
package org.eclipse.qvtd.pivot.qvtbase.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.internal.impl.NamedElementImpl;
import org.eclipse.ocl.examples.pivot.util.Visitor;

import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Unit;
import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.UnitImpl#getUsedPackage <em>Used Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnitImpl extends NamedElementImpl implements Unit {
	/**
	 * The cached value of the '{@link #getUsedPackage() <em>Used Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedPackage()
	 * @generated
	 * @ordered
	 */
	protected Namespace usedPackage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTbasePackage.Literals.UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Namespace getUsedPackage() {
		if (usedPackage != null && ((EObject)usedPackage).eIsProxy()) {
			InternalEObject oldUsedPackage = (InternalEObject)usedPackage;
			usedPackage = (Namespace)eResolveProxy(oldUsedPackage);
			if (usedPackage != oldUsedPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTbasePackage.UNIT__USED_PACKAGE, oldUsedPackage, usedPackage));
			}
		}
		return usedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Namespace basicGetUsedPackage() {
		return usedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsedPackage(Namespace newUsedPackage) {
		Namespace oldUsedPackage = usedPackage;
		usedPackage = newUsedPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.UNIT__USED_PACKAGE, oldUsedPackage, usedPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTbasePackage.UNIT__USED_PACKAGE:
				if (resolve) return getUsedPackage();
				return basicGetUsedPackage();
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
			case QVTbasePackage.UNIT__USED_PACKAGE:
				setUsedPackage((Namespace)newValue);
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
			case QVTbasePackage.UNIT__USED_PACKAGE:
				setUsedPackage((Namespace)null);
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
			case QVTbasePackage.UNIT__USED_PACKAGE:
				return usedPackage != null;
		}
		return super.eIsSet(featureID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(Visitor<R> visitor) {
		return (R) visitor.getAdapter(QVTbaseVisitor.class).visitUnit(this);
	}
} //UnitImpl
