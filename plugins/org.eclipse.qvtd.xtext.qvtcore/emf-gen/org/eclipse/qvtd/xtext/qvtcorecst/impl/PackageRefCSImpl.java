/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtcorecst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.ocl.examples.pivot.Namespace;

import org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSImpl;

import org.eclipse.qvtd.xtext.qvtcorecst.PackageRefCS;
import org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Ref CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.PackageRefCSImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.PackageRefCSImpl#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageRefCSImpl extends ModelElementCSImpl implements PackageRefCS {
	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected EList<Namespace> namespace;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.examples.pivot.Package element;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageRefCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcoreCSTPackage.Literals.PACKAGE_REF_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Namespace> getNamespace() {
		if (namespace == null) {
			namespace = new EObjectResolvingEList<Namespace>(Namespace.class, this, QVTcoreCSTPackage.PACKAGE_REF_CS__NAMESPACE);
		}
		return namespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.examples.pivot.Package getElement() {
		if (element != null && ((EObject)element).eIsProxy()) {
			InternalEObject oldElement = (InternalEObject)element;
			element = (org.eclipse.ocl.examples.pivot.Package)eResolveProxy(oldElement);
			if (element != oldElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTcoreCSTPackage.PACKAGE_REF_CS__ELEMENT, oldElement, element));
			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.examples.pivot.Package basicGetElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(org.eclipse.ocl.examples.pivot.Package newElement) {
		org.eclipse.ocl.examples.pivot.Package oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreCSTPackage.PACKAGE_REF_CS__ELEMENT, oldElement, element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTcoreCSTPackage.PACKAGE_REF_CS__NAMESPACE:
				return getNamespace();
			case QVTcoreCSTPackage.PACKAGE_REF_CS__ELEMENT:
				if (resolve) return getElement();
				return basicGetElement();
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
			case QVTcoreCSTPackage.PACKAGE_REF_CS__NAMESPACE:
				getNamespace().clear();
				getNamespace().addAll((Collection<? extends Namespace>)newValue);
				return;
			case QVTcoreCSTPackage.PACKAGE_REF_CS__ELEMENT:
				setElement((org.eclipse.ocl.examples.pivot.Package)newValue);
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
			case QVTcoreCSTPackage.PACKAGE_REF_CS__NAMESPACE:
				getNamespace().clear();
				return;
			case QVTcoreCSTPackage.PACKAGE_REF_CS__ELEMENT:
				setElement((org.eclipse.ocl.examples.pivot.Package)null);
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
			case QVTcoreCSTPackage.PACKAGE_REF_CS__NAMESPACE:
				return namespace != null && !namespace.isEmpty();
			case QVTcoreCSTPackage.PACKAGE_REF_CS__ELEMENT:
				return element != null;
		}
		return super.eIsSet(featureID);
	}

} //PackageRefCSImpl
