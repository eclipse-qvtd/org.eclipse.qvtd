/**
 */
package test.umltordbms.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import test.umltordbms.FromAttribute;
import test.umltordbms.FromAttributeOwner;
import test.umltordbms.UmltordbmsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>From Attribute Owner</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link test.umltordbms.impl.FromAttributeOwnerImpl#getFromAttributes <em>From Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FromAttributeOwnerImpl extends MinimalEObjectImpl.Container implements FromAttributeOwner {
	/**
	 * The cached value of the '{@link #getFromAttributes() <em>From Attributes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromAttributes()
	 * @generated
	 * @ordered
	 */
	protected FromAttribute fromAttributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FromAttributeOwnerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmltordbmsPackage.Literals.FROM_ATTRIBUTE_OWNER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromAttribute getFromAttributes() {
		return fromAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFromAttributes(FromAttribute newFromAttributes, NotificationChain msgs) {
		FromAttribute oldFromAttributes = fromAttributes;
		fromAttributes = newFromAttributes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmltordbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES, oldFromAttributes, newFromAttributes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromAttributes(FromAttribute newFromAttributes) {
		if (newFromAttributes != fromAttributes) {
			NotificationChain msgs = null;
			if (fromAttributes != null)
				msgs = ((InternalEObject)fromAttributes).eInverseRemove(this, UmltordbmsPackage.FROM_ATTRIBUTE__OWNER, FromAttribute.class, msgs);
			if (newFromAttributes != null)
				msgs = ((InternalEObject)newFromAttributes).eInverseAdd(this, UmltordbmsPackage.FROM_ATTRIBUTE__OWNER, FromAttribute.class, msgs);
			msgs = basicSetFromAttributes(newFromAttributes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmltordbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES, newFromAttributes, newFromAttributes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UmltordbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES:
				if (fromAttributes != null)
					msgs = ((InternalEObject)fromAttributes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmltordbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES, null, msgs);
				return basicSetFromAttributes((FromAttribute)otherEnd, msgs);
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
			case UmltordbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES:
				return basicSetFromAttributes(null, msgs);
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
			case UmltordbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES:
				return getFromAttributes();
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
			case UmltordbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES:
				setFromAttributes((FromAttribute)newValue);
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
			case UmltordbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES:
				setFromAttributes((FromAttribute)null);
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
			case UmltordbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES:
				return fromAttributes != null;
		}
		return super.eIsSet(featureID);
	}

} //FromAttributeOwnerImpl
