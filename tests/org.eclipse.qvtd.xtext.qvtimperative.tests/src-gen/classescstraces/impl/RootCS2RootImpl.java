/**
 */
package classescstraces.impl;

import classes.Root;

import classescs.RootCS;

import classescstraces.ClassescstracesPackage;
import classescstraces.RootCS2Root;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root CS2 Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link classescstraces.impl.RootCS2RootImpl#getRootCS <em>Root CS</em>}</li>
 *   <li>{@link classescstraces.impl.RootCS2RootImpl#getRoot <em>Root</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootCS2RootImpl extends MinimalEObjectImpl.Container implements RootCS2Root {
	/**
	 * The cached value of the '{@link #getRootCS() <em>Root CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootCS()
	 * @generated
	 * @ordered
	 */
	protected RootCS rootCS;

	/**
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
	protected Root root;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootCS2RootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassescstracesPackage.Literals.ROOT_CS2_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootCS getRootCS() {
		if (rootCS != null && rootCS.eIsProxy()) {
			InternalEObject oldRootCS = (InternalEObject)rootCS;
			rootCS = (RootCS)eResolveProxy(oldRootCS);
			if (rootCS != oldRootCS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassescstracesPackage.ROOT_CS2_ROOT__ROOT_CS, oldRootCS, rootCS));
			}
		}
		return rootCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootCS basicGetRootCS() {
		return rootCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootCS(RootCS newRootCS) {
		RootCS oldRootCS = rootCS;
		rootCS = newRootCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassescstracesPackage.ROOT_CS2_ROOT__ROOT_CS, oldRootCS, rootCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Root getRoot() {
		if (root != null && root.eIsProxy()) {
			InternalEObject oldRoot = (InternalEObject)root;
			root = (Root)eResolveProxy(oldRoot);
			if (root != oldRoot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassescstracesPackage.ROOT_CS2_ROOT__ROOT, oldRoot, root));
			}
		}
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Root basicGetRoot() {
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoot(Root newRoot) {
		Root oldRoot = root;
		root = newRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassescstracesPackage.ROOT_CS2_ROOT__ROOT, oldRoot, root));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassescstracesPackage.ROOT_CS2_ROOT__ROOT_CS:
				if (resolve) return getRootCS();
				return basicGetRootCS();
			case ClassescstracesPackage.ROOT_CS2_ROOT__ROOT:
				if (resolve) return getRoot();
				return basicGetRoot();
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
			case ClassescstracesPackage.ROOT_CS2_ROOT__ROOT_CS:
				setRootCS((RootCS)newValue);
				return;
			case ClassescstracesPackage.ROOT_CS2_ROOT__ROOT:
				setRoot((Root)newValue);
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
			case ClassescstracesPackage.ROOT_CS2_ROOT__ROOT_CS:
				setRootCS((RootCS)null);
				return;
			case ClassescstracesPackage.ROOT_CS2_ROOT__ROOT:
				setRoot((Root)null);
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
			case ClassescstracesPackage.ROOT_CS2_ROOT__ROOT_CS:
				return rootCS != null;
			case ClassescstracesPackage.ROOT_CS2_ROOT__ROOT:
				return root != null;
		}
		return super.eIsSet(featureID);
	}

} //RootCS2RootImpl
