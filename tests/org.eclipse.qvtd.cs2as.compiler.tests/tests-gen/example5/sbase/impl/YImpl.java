/**
 */
package example5.sbase.impl;

import example5.sbase.SbasePackage;
import example5.sbase.X;
import example5.sbase.Y;
import example5.sbase.Z;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Y</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example5.sbase.impl.YImpl#getOwnsZ <em>Owns Z</em>}</li>
 *   <li>{@link example5.sbase.impl.YImpl#getName <em>Name</em>}</li>
 *   <li>{@link example5.sbase.impl.YImpl#getToX <em>To X</em>}</li>
 * </ul>
 *
 * @generated
 */
public class YImpl extends SElementImpl implements Y {
	/**
	 * The cached value of the '{@link #getOwnsZ() <em>Owns Z</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnsZ()
	 * @generated
	 * @ordered
	 */
	protected Z ownsZ;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected YImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SbasePackage.Literals.Y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Z getOwnsZ() {
		return ownsZ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnsZ(Z newOwnsZ, NotificationChain msgs) {
		Z oldOwnsZ = ownsZ;
		ownsZ = newOwnsZ;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SbasePackage.Y__OWNS_Z, oldOwnsZ, newOwnsZ);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnsZ(Z newOwnsZ) {
		if (newOwnsZ != ownsZ) {
			NotificationChain msgs = null;
			if (ownsZ != null)
				msgs = ((InternalEObject)ownsZ).eInverseRemove(this, SbasePackage.Z__TO_Y, Z.class, msgs);
			if (newOwnsZ != null)
				msgs = ((InternalEObject)newOwnsZ).eInverseAdd(this, SbasePackage.Z__TO_Y, Z.class, msgs);
			msgs = basicSetOwnsZ(newOwnsZ, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SbasePackage.Y__OWNS_Z, newOwnsZ, newOwnsZ));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SbasePackage.Y__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public X getToX() {
		if (eContainerFeatureID() != SbasePackage.Y__TO_X) return null;
		return (X)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetToX(X newToX, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newToX, SbasePackage.Y__TO_X, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToX(X newToX) {
		if (newToX != eInternalContainer() || (eContainerFeatureID() != SbasePackage.Y__TO_X && newToX != null)) {
			if (EcoreUtil.isAncestor(this, newToX))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newToX != null)
				msgs = ((InternalEObject)newToX).eInverseAdd(this, SbasePackage.X__OWNS_Y, X.class, msgs);
			msgs = basicSetToX(newToX, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SbasePackage.Y__TO_X, newToX, newToX));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SbasePackage.Y__OWNS_Z:
				if (ownsZ != null)
					msgs = ((InternalEObject)ownsZ).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SbasePackage.Y__OWNS_Z, null, msgs);
				return basicSetOwnsZ((Z)otherEnd, msgs);
			case SbasePackage.Y__TO_X:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetToX((X)otherEnd, msgs);
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
			case SbasePackage.Y__OWNS_Z:
				return basicSetOwnsZ(null, msgs);
			case SbasePackage.Y__TO_X:
				return basicSetToX(null, msgs);
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
			case SbasePackage.Y__TO_X:
				return eInternalContainer().eInverseRemove(this, SbasePackage.X__OWNS_Y, X.class, msgs);
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
			case SbasePackage.Y__OWNS_Z:
				return getOwnsZ();
			case SbasePackage.Y__NAME:
				return getName();
			case SbasePackage.Y__TO_X:
				return getToX();
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
			case SbasePackage.Y__OWNS_Z:
				setOwnsZ((Z)newValue);
				return;
			case SbasePackage.Y__NAME:
				setName((String)newValue);
				return;
			case SbasePackage.Y__TO_X:
				setToX((X)newValue);
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
			case SbasePackage.Y__OWNS_Z:
				setOwnsZ((Z)null);
				return;
			case SbasePackage.Y__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SbasePackage.Y__TO_X:
				setToX((X)null);
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
			case SbasePackage.Y__OWNS_Z:
				return ownsZ != null;
			case SbasePackage.Y__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SbasePackage.Y__TO_X:
				return getToX() != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}


} //YImpl
