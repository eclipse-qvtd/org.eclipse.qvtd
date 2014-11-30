/**
 */
package classescstraces.impl;

import classescs.PackageCS;

import classescstraces.ClassescstracesPackage;
import classescstraces.PackageCS2Package;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package CS2 Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link classescstraces.impl.PackageCS2PackageImpl#getPackageCS <em>Package CS</em>}</li>
 *   <li>{@link classescstraces.impl.PackageCS2PackageImpl#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageCS2PackageImpl extends MinimalEObjectImpl.Container implements PackageCS2Package {
	/**
	 * The cached value of the '{@link #getPackageCS() <em>Package CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageCS()
	 * @generated
	 * @ordered
	 */
	protected PackageCS packageCS;

	/**
	 * The cached value of the '{@link #getPackage() <em>Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected classes.Package package_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageCS2PackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassescstracesPackage.Literals.PACKAGE_CS2_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageCS getPackageCS() {
		if (packageCS != null && packageCS.eIsProxy()) {
			InternalEObject oldPackageCS = (InternalEObject)packageCS;
			packageCS = (PackageCS)eResolveProxy(oldPackageCS);
			if (packageCS != oldPackageCS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassescstracesPackage.PACKAGE_CS2_PACKAGE__PACKAGE_CS, oldPackageCS, packageCS));
			}
		}
		return packageCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageCS basicGetPackageCS() {
		return packageCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackageCS(PackageCS newPackageCS) {
		PackageCS oldPackageCS = packageCS;
		packageCS = newPackageCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassescstracesPackage.PACKAGE_CS2_PACKAGE__PACKAGE_CS, oldPackageCS, packageCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public classes.Package getPackage() {
		if (package_ != null && package_.eIsProxy()) {
			InternalEObject oldPackage = (InternalEObject)package_;
			package_ = (classes.Package)eResolveProxy(oldPackage);
			if (package_ != oldPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassescstracesPackage.PACKAGE_CS2_PACKAGE__PACKAGE, oldPackage, package_));
			}
		}
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public classes.Package basicGetPackage() {
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackage(classes.Package newPackage) {
		classes.Package oldPackage = package_;
		package_ = newPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassescstracesPackage.PACKAGE_CS2_PACKAGE__PACKAGE, oldPackage, package_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassescstracesPackage.PACKAGE_CS2_PACKAGE__PACKAGE_CS:
				if (resolve) return getPackageCS();
				return basicGetPackageCS();
			case ClassescstracesPackage.PACKAGE_CS2_PACKAGE__PACKAGE:
				if (resolve) return getPackage();
				return basicGetPackage();
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
			case ClassescstracesPackage.PACKAGE_CS2_PACKAGE__PACKAGE_CS:
				setPackageCS((PackageCS)newValue);
				return;
			case ClassescstracesPackage.PACKAGE_CS2_PACKAGE__PACKAGE:
				setPackage((classes.Package)newValue);
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
			case ClassescstracesPackage.PACKAGE_CS2_PACKAGE__PACKAGE_CS:
				setPackageCS((PackageCS)null);
				return;
			case ClassescstracesPackage.PACKAGE_CS2_PACKAGE__PACKAGE:
				setPackage((classes.Package)null);
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
			case ClassescstracesPackage.PACKAGE_CS2_PACKAGE__PACKAGE_CS:
				return packageCS != null;
			case ClassescstracesPackage.PACKAGE_CS2_PACKAGE__PACKAGE:
				return package_ != null;
		}
		return super.eIsSet(featureID);
	}

} //PackageCS2PackageImpl
