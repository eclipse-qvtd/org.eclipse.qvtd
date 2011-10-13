/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtcorecst.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.qvtd.xtext.qvtcorecst.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.DomainCSImpl#isCheck <em>Check</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.DomainCSImpl#isEnforce <em>Enforce</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainCSImpl extends AreaCSImpl implements DomainCS {
	/**
	 * The default value of the '{@link #isCheck() <em>Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCheck()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHECK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCheck() <em>Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCheck()
	 * @generated
	 * @ordered
	 */
	protected boolean check = CHECK_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnforce() <em>Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnforce()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENFORCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnforce() <em>Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnforce()
	 * @generated
	 * @ordered
	 */
	protected boolean enforce = ENFORCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcoreCSTPackage.Literals.DOMAIN_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCheck() {
		return check;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheck(boolean newCheck) {
		boolean oldCheck = check;
		check = newCheck;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreCSTPackage.DOMAIN_CS__CHECK, oldCheck, check));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnforce() {
		return enforce;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnforce(boolean newEnforce) {
		boolean oldEnforce = enforce;
		enforce = newEnforce;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreCSTPackage.DOMAIN_CS__ENFORCE, oldEnforce, enforce));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTcoreCSTPackage.DOMAIN_CS__CHECK:
				return isCheck();
			case QVTcoreCSTPackage.DOMAIN_CS__ENFORCE:
				return isEnforce();
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
			case QVTcoreCSTPackage.DOMAIN_CS__CHECK:
				setCheck((Boolean)newValue);
				return;
			case QVTcoreCSTPackage.DOMAIN_CS__ENFORCE:
				setEnforce((Boolean)newValue);
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
			case QVTcoreCSTPackage.DOMAIN_CS__CHECK:
				setCheck(CHECK_EDEFAULT);
				return;
			case QVTcoreCSTPackage.DOMAIN_CS__ENFORCE:
				setEnforce(ENFORCE_EDEFAULT);
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
			case QVTcoreCSTPackage.DOMAIN_CS__CHECK:
				return check != CHECK_EDEFAULT;
			case QVTcoreCSTPackage.DOMAIN_CS__ENFORCE:
				return enforce != ENFORCE_EDEFAULT;
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
		result.append(" (check: ");
		result.append(check);
		result.append(", enforce: ");
		result.append(enforce);
		result.append(')');
		return result.toString();
	}

} //DomainCSImpl
