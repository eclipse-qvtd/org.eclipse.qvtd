/**
 */
package org.eclipse.qvtd.doc.miniocl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.qvtd.doc.miniocl.CallExp;
import org.eclipse.qvtd.doc.miniocl.MiniOCLPackage;
import org.eclipse.qvtd.doc.miniocl.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.impl.CallExpImpl#getOwnedSource <em>Owned Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CallExpImpl extends OCLExpressionImpl implements CallExp {
	/**
	 * The cached value of the '{@link #getOwnedSource() <em>Owned Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSource()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedSource;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getOwnedSource() {
		return ownedSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedSource(OCLExpression newOwnedSource, NotificationChain msgs) {
		OCLExpression oldOwnedSource = ownedSource;
		ownedSource = newOwnedSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniOCLPackage.CALL_EXP__OWNED_SOURCE, oldOwnedSource, newOwnedSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedSource(OCLExpression newOwnedSource) {
		if (newOwnedSource != ownedSource) {
			NotificationChain msgs = null;
			if (ownedSource != null)
				msgs = ((InternalEObject)ownedSource).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniOCLPackage.CALL_EXP__OWNED_SOURCE, null, msgs);
			if (newOwnedSource != null)
				msgs = ((InternalEObject)newOwnedSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniOCLPackage.CALL_EXP__OWNED_SOURCE, null, msgs);
			msgs = basicSetOwnedSource(newOwnedSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.CALL_EXP__OWNED_SOURCE, newOwnedSource, newOwnedSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MiniOCLPackage.CALL_EXP__OWNED_SOURCE:
				return basicSetOwnedSource(null, msgs);
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
			case MiniOCLPackage.CALL_EXP__OWNED_SOURCE:
				return getOwnedSource();
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
			case MiniOCLPackage.CALL_EXP__OWNED_SOURCE:
				setOwnedSource((OCLExpression)newValue);
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
			case MiniOCLPackage.CALL_EXP__OWNED_SOURCE:
				setOwnedSource((OCLExpression)null);
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
			case MiniOCLPackage.CALL_EXP__OWNED_SOURCE:
				return ownedSource != null;
		}
		return super.eIsSet(featureID);
	}


} //CallExpImpl
