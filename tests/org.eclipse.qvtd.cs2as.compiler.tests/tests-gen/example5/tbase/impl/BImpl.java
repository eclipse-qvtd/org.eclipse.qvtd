/**
 */
package example5.tbase.impl;

import example5.tbase.B;
import example5.tbase.C;
import example5.tbase.TbasePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>B</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example5.tbase.impl.BImpl#getOwnsC <em>Owns C</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BImpl extends NamedElementImpl implements B {
	/**
	 * The cached value of the '{@link #getOwnsC() <em>Owns C</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnsC()
	 * @generated
	 * @ordered
	 */
	protected C ownsC;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TbasePackage.Literals.B;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C getOwnsC() {
		return ownsC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnsC(C newOwnsC, NotificationChain msgs) {
		C oldOwnsC = ownsC;
		ownsC = newOwnsC;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TbasePackage.B__OWNS_C, oldOwnsC, newOwnsC);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnsC(C newOwnsC) {
		if (newOwnsC != ownsC) {
			NotificationChain msgs = null;
			if (ownsC != null)
				msgs = ((InternalEObject)ownsC).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TbasePackage.B__OWNS_C, null, msgs);
			if (newOwnsC != null)
				msgs = ((InternalEObject)newOwnsC).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TbasePackage.B__OWNS_C, null, msgs);
			msgs = basicSetOwnsC(newOwnsC, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TbasePackage.B__OWNS_C, newOwnsC, newOwnsC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TbasePackage.B__OWNS_C:
				return basicSetOwnsC(null, msgs);
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
			case TbasePackage.B__OWNS_C:
				return getOwnsC();
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
			case TbasePackage.B__OWNS_C:
				setOwnsC((C)newValue);
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
			case TbasePackage.B__OWNS_C:
				setOwnsC((C)null);
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
			case TbasePackage.B__OWNS_C:
				return ownsC != null;
		}
		return super.eIsSet(featureID);
	}


} //BImpl
