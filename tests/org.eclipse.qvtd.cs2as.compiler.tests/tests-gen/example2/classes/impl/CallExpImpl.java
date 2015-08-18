/**
 */
package example2.classes.impl;

import example2.classes.CallExp;
import example2.classes.ClassesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example2.classes.impl.CallExpImpl#getOwnedCallExp <em>Owned Call Exp</em>}</li>
 *   <li>{@link example2.classes.impl.CallExpImpl#getOwningSource <em>Owning Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CallExpImpl extends TypedElementImpl implements CallExp {
	/**
	 * The cached value of the '{@link #getOwnedCallExp() <em>Owned Call Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedCallExp()
	 * @generated
	 * @ordered
	 */
	protected CallExp ownedCallExp;
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
		return ClassesPackage.Literals.CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallExp getOwnedCallExp() {
		return ownedCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedCallExp(CallExp newOwnedCallExp, NotificationChain msgs) {
		CallExp oldOwnedCallExp = ownedCallExp;
		ownedCallExp = newOwnedCallExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.CALL_EXP__OWNED_CALL_EXP, oldOwnedCallExp, newOwnedCallExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedCallExp(CallExp newOwnedCallExp) {
		if (newOwnedCallExp != ownedCallExp) {
			NotificationChain msgs = null;
			if (ownedCallExp != null)
				msgs = ((InternalEObject)ownedCallExp).eInverseRemove(this, ClassesPackage.CALL_EXP__OWNING_SOURCE, CallExp.class, msgs);
			if (newOwnedCallExp != null)
				msgs = ((InternalEObject)newOwnedCallExp).eInverseAdd(this, ClassesPackage.CALL_EXP__OWNING_SOURCE, CallExp.class, msgs);
			msgs = basicSetOwnedCallExp(newOwnedCallExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.CALL_EXP__OWNED_CALL_EXP, newOwnedCallExp, newOwnedCallExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallExp getOwningSource() {
		if (eContainerFeatureID() != ClassesPackage.CALL_EXP__OWNING_SOURCE) return null;
		return (CallExp)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningSource(CallExp newOwningSource, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningSource, ClassesPackage.CALL_EXP__OWNING_SOURCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningSource(CallExp newOwningSource) {
		if (newOwningSource != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.CALL_EXP__OWNING_SOURCE && newOwningSource != null)) {
			if (EcoreUtil.isAncestor(this, newOwningSource))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningSource != null)
				msgs = ((InternalEObject)newOwningSource).eInverseAdd(this, ClassesPackage.CALL_EXP__OWNED_CALL_EXP, CallExp.class, msgs);
			msgs = basicSetOwningSource(newOwningSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.CALL_EXP__OWNING_SOURCE, newOwningSource, newOwningSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassesPackage.CALL_EXP__OWNED_CALL_EXP:
				if (ownedCallExp != null)
					msgs = ((InternalEObject)ownedCallExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.CALL_EXP__OWNED_CALL_EXP, null, msgs);
				return basicSetOwnedCallExp((CallExp)otherEnd, msgs);
			case ClassesPackage.CALL_EXP__OWNING_SOURCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningSource((CallExp)otherEnd, msgs);
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
			case ClassesPackage.CALL_EXP__OWNED_CALL_EXP:
				return basicSetOwnedCallExp(null, msgs);
			case ClassesPackage.CALL_EXP__OWNING_SOURCE:
				return basicSetOwningSource(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ClassesPackage.CALL_EXP__OWNING_SOURCE:
				return eInternalContainer().eInverseRemove(this, ClassesPackage.CALL_EXP__OWNED_CALL_EXP, CallExp.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassesPackage.CALL_EXP__OWNED_CALL_EXP:
				return getOwnedCallExp();
			case ClassesPackage.CALL_EXP__OWNING_SOURCE:
				return getOwningSource();
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
			case ClassesPackage.CALL_EXP__OWNED_CALL_EXP:
				setOwnedCallExp((CallExp)newValue);
				return;
			case ClassesPackage.CALL_EXP__OWNING_SOURCE:
				setOwningSource((CallExp)newValue);
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
			case ClassesPackage.CALL_EXP__OWNED_CALL_EXP:
				setOwnedCallExp((CallExp)null);
				return;
			case ClassesPackage.CALL_EXP__OWNING_SOURCE:
				setOwningSource((CallExp)null);
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
			case ClassesPackage.CALL_EXP__OWNED_CALL_EXP:
				return ownedCallExp != null;
			case ClassesPackage.CALL_EXP__OWNING_SOURCE:
				return getOwningSource() != null;
		}
		return super.eIsSet(featureID);
	}


} //CallExpImpl
