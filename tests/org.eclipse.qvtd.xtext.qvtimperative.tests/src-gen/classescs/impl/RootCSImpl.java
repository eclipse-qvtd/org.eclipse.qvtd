/**
 */
package classescs.impl;

import classescs.ClassescsPackage;
import classescs.PackageCS;
import classescs.RootCS;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link classescs.impl.RootCSImpl#getOwnedPackage <em>Owned Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootCSImpl extends ElementCSImpl implements RootCS {
	/**
	 * The cached value of the '{@link #getOwnedPackage() <em>Owned Package</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPackage()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageCS> ownedPackage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassescsPackage.Literals.ROOT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageCS> getOwnedPackage() {
		if (ownedPackage == null) {
			ownedPackage = new EObjectContainmentEList<PackageCS>(PackageCS.class, this, ClassescsPackage.ROOT_CS__OWNED_PACKAGE);
		}
		return ownedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassescsPackage.ROOT_CS__OWNED_PACKAGE:
				return ((InternalEList<?>)getOwnedPackage()).basicRemove(otherEnd, msgs);
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
			case ClassescsPackage.ROOT_CS__OWNED_PACKAGE:
				return getOwnedPackage();
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
			case ClassescsPackage.ROOT_CS__OWNED_PACKAGE:
				getOwnedPackage().clear();
				getOwnedPackage().addAll((Collection<? extends PackageCS>)newValue);
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
			case ClassescsPackage.ROOT_CS__OWNED_PACKAGE:
				getOwnedPackage().clear();
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
			case ClassescsPackage.ROOT_CS__OWNED_PACKAGE:
				return ownedPackage != null && !ownedPackage.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RootCSImpl
