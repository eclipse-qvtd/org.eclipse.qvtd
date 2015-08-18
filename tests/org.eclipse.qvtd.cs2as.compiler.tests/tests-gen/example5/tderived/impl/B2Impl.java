/**
 */
package example5.tderived.impl;

import example5.tbase.impl.BImpl;

import example5.tderived.B2;
import example5.tderived.TderivedPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>B2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example5.tderived.impl.B2Impl#getAnotherName <em>Another Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class B2Impl extends BImpl implements B2 {
	/**
	 * The default value of the '{@link #getAnotherName() <em>Another Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnotherName()
	 * @generated
	 * @ordered
	 */
	protected static final String ANOTHER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAnotherName() <em>Another Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnotherName()
	 * @generated
	 * @ordered
	 */
	protected String anotherName = ANOTHER_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B2Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TderivedPackage.Literals.B2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAnotherName() {
		return anotherName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnotherName(String newAnotherName) {
		String oldAnotherName = anotherName;
		anotherName = newAnotherName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TderivedPackage.B2__ANOTHER_NAME, oldAnotherName, anotherName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TderivedPackage.B2__ANOTHER_NAME:
				return getAnotherName();
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
			case TderivedPackage.B2__ANOTHER_NAME:
				setAnotherName((String)newValue);
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
			case TderivedPackage.B2__ANOTHER_NAME:
				setAnotherName(ANOTHER_NAME_EDEFAULT);
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
			case TderivedPackage.B2__ANOTHER_NAME:
				return ANOTHER_NAME_EDEFAULT == null ? anotherName != null : !ANOTHER_NAME_EDEFAULT.equals(anotherName);
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
		result.append(" (anotherName: ");
		result.append(anotherName);
		result.append(')');
		return result.toString();
	}


} //B2Impl
