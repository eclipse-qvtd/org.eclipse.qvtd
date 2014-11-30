/**
 */
package classescstraces.impl;

import classescs.ClassCS;

import classescstraces.ClassCS2Class;
import classescstraces.ClassescstracesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class CS2 Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link classescstraces.impl.ClassCS2ClassImpl#getClassCS <em>Class CS</em>}</li>
 *   <li>{@link classescstraces.impl.ClassCS2ClassImpl#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassCS2ClassImpl extends MinimalEObjectImpl.Container implements ClassCS2Class {
	/**
	 * The cached value of the '{@link #getClassCS() <em>Class CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassCS()
	 * @generated
	 * @ordered
	 */
	protected ClassCS classCS;

	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected classes.Class class_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassCS2ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassescstracesPackage.Literals.CLASS_CS2_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassCS getClassCS() {
		if (classCS != null && classCS.eIsProxy()) {
			InternalEObject oldClassCS = (InternalEObject)classCS;
			classCS = (ClassCS)eResolveProxy(oldClassCS);
			if (classCS != oldClassCS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassescstracesPackage.CLASS_CS2_CLASS__CLASS_CS, oldClassCS, classCS));
			}
		}
		return classCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassCS basicGetClassCS() {
		return classCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassCS(ClassCS newClassCS) {
		ClassCS oldClassCS = classCS;
		classCS = newClassCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassescstracesPackage.CLASS_CS2_CLASS__CLASS_CS, oldClassCS, classCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public classes.Class getClass_() {
		if (class_ != null && class_.eIsProxy()) {
			InternalEObject oldClass = (InternalEObject)class_;
			class_ = (classes.Class)eResolveProxy(oldClass);
			if (class_ != oldClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassescstracesPackage.CLASS_CS2_CLASS__CLASS, oldClass, class_));
			}
		}
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public classes.Class basicGetClass() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(classes.Class newClass) {
		classes.Class oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassescstracesPackage.CLASS_CS2_CLASS__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassescstracesPackage.CLASS_CS2_CLASS__CLASS_CS:
				if (resolve) return getClassCS();
				return basicGetClassCS();
			case ClassescstracesPackage.CLASS_CS2_CLASS__CLASS:
				if (resolve) return getClass_();
				return basicGetClass();
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
			case ClassescstracesPackage.CLASS_CS2_CLASS__CLASS_CS:
				setClassCS((ClassCS)newValue);
				return;
			case ClassescstracesPackage.CLASS_CS2_CLASS__CLASS:
				setClass((classes.Class)newValue);
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
			case ClassescstracesPackage.CLASS_CS2_CLASS__CLASS_CS:
				setClassCS((ClassCS)null);
				return;
			case ClassescstracesPackage.CLASS_CS2_CLASS__CLASS:
				setClass((classes.Class)null);
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
			case ClassescstracesPackage.CLASS_CS2_CLASS__CLASS_CS:
				return classCS != null;
			case ClassescstracesPackage.CLASS_CS2_CLASS__CLASS:
				return class_ != null;
		}
		return super.eIsSet(featureID);
	}

} //ClassCS2ClassImpl
