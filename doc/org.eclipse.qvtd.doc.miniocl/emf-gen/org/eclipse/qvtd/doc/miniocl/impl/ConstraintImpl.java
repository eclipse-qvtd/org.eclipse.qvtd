/**
 */
package org.eclipse.qvtd.doc.miniocl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.doc.miniocl.Constraint;
import org.eclipse.qvtd.doc.miniocl.ExpressionInOCL;
import org.eclipse.qvtd.doc.miniocl.MiniOCLPackage;
import org.eclipse.qvtd.doc.miniocl.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.impl.ConstraintImpl#getOwnedSpecification <em>Owned Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstraintImpl extends NamedElementImpl implements Constraint {
	/**
	 * The cached value of the '{@link #getOwnedSpecification() <em>Owned Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSpecification()
	 * @generated
	 * @ordered
	 */
	protected ExpressionInOCL ownedSpecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionInOCL getOwnedSpecification() {
		if (ownedSpecification != null && ownedSpecification.eIsProxy()) {
			InternalEObject oldOwnedSpecification = (InternalEObject)ownedSpecification;
			ownedSpecification = (ExpressionInOCL)eResolveProxy(oldOwnedSpecification);
			if (ownedSpecification != oldOwnedSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniOCLPackage.CONSTRAINT__OWNED_SPECIFICATION, oldOwnedSpecification, ownedSpecification));
			}
		}
		return ownedSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionInOCL basicGetOwnedSpecification() {
		return ownedSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedSpecification(ExpressionInOCL newOwnedSpecification) {
		ExpressionInOCL oldOwnedSpecification = ownedSpecification;
		ownedSpecification = newOwnedSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.CONSTRAINT__OWNED_SPECIFICATION, oldOwnedSpecification, ownedSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniOCLPackage.CONSTRAINT__OWNED_SPECIFICATION:
				if (resolve) return getOwnedSpecification();
				return basicGetOwnedSpecification();
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
			case MiniOCLPackage.CONSTRAINT__OWNED_SPECIFICATION:
				setOwnedSpecification((ExpressionInOCL)newValue);
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
			case MiniOCLPackage.CONSTRAINT__OWNED_SPECIFICATION:
				setOwnedSpecification((ExpressionInOCL)null);
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
			case MiniOCLPackage.CONSTRAINT__OWNED_SPECIFICATION:
				return ownedSpecification != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitConstraint(this);
	}

} //ConstraintImpl
