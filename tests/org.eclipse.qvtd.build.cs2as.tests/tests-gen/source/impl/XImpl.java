/**
 */
package source.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import source.SourcePackage;
import source.X;
import source.Y;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>X</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link source.impl.XImpl#getOwnsY <em>Owns Y</em>}</li>
 *   <li>{@link source.impl.XImpl#isIsA1 <em>Is A1</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XImpl extends SElementImpl implements X {
	/**
	 * The cached value of the '{@link #getOwnsY() <em>Owns Y</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnsY()
	 * @generated
	 * @ordered
	 */
	protected EList<Y> ownsY;

	/**
	 * The default value of the '{@link #isIsA1() <em>Is A1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsA1()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_A1_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsA1() <em>Is A1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsA1()
	 * @generated
	 * @ordered
	 */
	protected boolean isA1 = IS_A1_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SourcePackage.Literals.X;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Y> getOwnsY() {
		if (ownsY == null) {
			ownsY = new EObjectContainmentWithInverseEList<Y>(Y.class, this, SourcePackage.X__OWNS_Y, SourcePackage.Y__TO_X);
		}
		return ownsY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsA1() {
		return isA1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsA1(boolean newIsA1) {
		boolean oldIsA1 = isA1;
		isA1 = newIsA1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SourcePackage.X__IS_A1, oldIsA1, isA1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SourcePackage.X__OWNS_Y:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnsY()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SourcePackage.X__OWNS_Y:
				return ((InternalEList<?>)getOwnsY()).basicRemove(otherEnd, msgs);
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
			case SourcePackage.X__OWNS_Y:
				return getOwnsY();
			case SourcePackage.X__IS_A1:
				return isIsA1();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SourcePackage.X__OWNS_Y:
				getOwnsY().clear();
				getOwnsY().addAll((Collection<? extends Y>)newValue);
				return;
			case SourcePackage.X__IS_A1:
				setIsA1((Boolean)newValue);
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
			case SourcePackage.X__OWNS_Y:
				getOwnsY().clear();
				return;
			case SourcePackage.X__IS_A1:
				setIsA1(IS_A1_EDEFAULT);
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
			case SourcePackage.X__OWNS_Y:
				return ownsY != null && !ownsY.isEmpty();
			case SourcePackage.X__IS_A1:
				return isA1 != IS_A1_EDEFAULT;
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
		result.append(" (isA1: ");
		result.append(isA1);
		result.append(')');
		return result.toString();
	}

} //XImpl
