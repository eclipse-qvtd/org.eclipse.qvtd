/**
 */
package org.eclipse.qvtd.doc.miniocl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.doc.miniocl.MiniOCLPackage;
import org.eclipse.qvtd.doc.miniocl.OCLExpression;
import org.eclipse.qvtd.doc.miniocl.TypedElement;
import org.eclipse.qvtd.doc.miniocl.Variable;
import org.eclipse.qvtd.doc.miniocl.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.impl.VariableImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.impl.VariableImpl#getOwnedInitExp <em>Owned Init Exp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableImpl extends NamedElementImpl implements Variable {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.qvtd.doc.miniocl.Class type;

	/**
	 * The cached value of the '{@link #getOwnedInitExp() <em>Owned Init Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedInitExp()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedInitExp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.qvtd.doc.miniocl.Class getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (org.eclipse.qvtd.doc.miniocl.Class)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniOCLPackage.VARIABLE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.qvtd.doc.miniocl.Class basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(org.eclipse.qvtd.doc.miniocl.Class newType) {
		org.eclipse.qvtd.doc.miniocl.Class oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.VARIABLE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getOwnedInitExp() {
		return ownedInitExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedInitExp(OCLExpression newOwnedInitExp, NotificationChain msgs) {
		OCLExpression oldOwnedInitExp = ownedInitExp;
		ownedInitExp = newOwnedInitExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniOCLPackage.VARIABLE__OWNED_INIT_EXP, oldOwnedInitExp, newOwnedInitExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedInitExp(OCLExpression newOwnedInitExp) {
		if (newOwnedInitExp != ownedInitExp) {
			NotificationChain msgs = null;
			if (ownedInitExp != null)
				msgs = ((InternalEObject)ownedInitExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniOCLPackage.VARIABLE__OWNED_INIT_EXP, null, msgs);
			if (newOwnedInitExp != null)
				msgs = ((InternalEObject)newOwnedInitExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniOCLPackage.VARIABLE__OWNED_INIT_EXP, null, msgs);
			msgs = basicSetOwnedInitExp(newOwnedInitExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.VARIABLE__OWNED_INIT_EXP, newOwnedInitExp, newOwnedInitExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MiniOCLPackage.VARIABLE__OWNED_INIT_EXP:
				return basicSetOwnedInitExp(null, msgs);
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
			case MiniOCLPackage.VARIABLE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case MiniOCLPackage.VARIABLE__OWNED_INIT_EXP:
				return getOwnedInitExp();
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
			case MiniOCLPackage.VARIABLE__TYPE:
				setType((org.eclipse.qvtd.doc.miniocl.Class)newValue);
				return;
			case MiniOCLPackage.VARIABLE__OWNED_INIT_EXP:
				setOwnedInitExp((OCLExpression)newValue);
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
			case MiniOCLPackage.VARIABLE__TYPE:
				setType((org.eclipse.qvtd.doc.miniocl.Class)null);
				return;
			case MiniOCLPackage.VARIABLE__OWNED_INIT_EXP:
				setOwnedInitExp((OCLExpression)null);
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
			case MiniOCLPackage.VARIABLE__TYPE:
				return type != null;
			case MiniOCLPackage.VARIABLE__OWNED_INIT_EXP:
				return ownedInitExp != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == TypedElement.class) {
			switch (derivedFeatureID) {
				case MiniOCLPackage.VARIABLE__TYPE: return MiniOCLPackage.TYPED_ELEMENT__TYPE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == TypedElement.class) {
			switch (baseFeatureID) {
				case MiniOCLPackage.TYPED_ELEMENT__TYPE: return MiniOCLPackage.VARIABLE__TYPE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitVariable(this);
	}

} //VariableImpl
