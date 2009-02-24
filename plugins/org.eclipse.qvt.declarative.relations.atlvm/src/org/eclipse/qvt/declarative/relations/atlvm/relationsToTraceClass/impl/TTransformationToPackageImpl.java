/**
 * <copyright>
 * </copyright>
 *
 * $Id: TTransformationToPackageImpl.java,v 1.1 2009/02/24 17:31:29 qglineur Exp $
 */
package org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;

import org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage;
import org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TTransformationToPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TTransformation To Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TTransformationToPackageImpl#getRt <em>Rt</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TTransformationToPackageImpl#getP <em>P</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TTransformationToPackageImpl extends EObjectImpl implements TTransformationToPackage {
	/**
	 * The cached value of the '{@link #getRt() <em>Rt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRt()
	 * @generated
	 * @ordered
	 */
	protected RelationalTransformation rt;

	/**
	 * The cached value of the '{@link #getP() <em>P</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getP()
	 * @generated
	 * @ordered
	 */
	protected EPackage p;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TTransformationToPackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationsToTraceClassPackage.Literals.TTRANSFORMATION_TO_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation getRt() {
		if (rt != null && rt.eIsProxy()) {
			InternalEObject oldRt = (InternalEObject)rt;
			rt = (RelationalTransformation)eResolveProxy(oldRt);
			if (rt != oldRt) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TTRANSFORMATION_TO_PACKAGE__RT, oldRt, rt));
			}
		}
		return rt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation basicGetRt() {
		return rt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRt(RelationalTransformation newRt) {
		RelationalTransformation oldRt = rt;
		rt = newRt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TTRANSFORMATION_TO_PACKAGE__RT, oldRt, rt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getP() {
		if (p != null && p.eIsProxy()) {
			InternalEObject oldP = (InternalEObject)p;
			p = (EPackage)eResolveProxy(oldP);
			if (p != oldP) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TTRANSFORMATION_TO_PACKAGE__P, oldP, p));
			}
		}
		return p;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetP() {
		return p;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setP(EPackage newP) {
		EPackage oldP = p;
		p = newP;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TTRANSFORMATION_TO_PACKAGE__P, oldP, p));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RelationsToTraceClassPackage.TTRANSFORMATION_TO_PACKAGE__RT:
				if (resolve) return getRt();
				return basicGetRt();
			case RelationsToTraceClassPackage.TTRANSFORMATION_TO_PACKAGE__P:
				if (resolve) return getP();
				return basicGetP();
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
			case RelationsToTraceClassPackage.TTRANSFORMATION_TO_PACKAGE__RT:
				setRt((RelationalTransformation)newValue);
				return;
			case RelationsToTraceClassPackage.TTRANSFORMATION_TO_PACKAGE__P:
				setP((EPackage)newValue);
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
			case RelationsToTraceClassPackage.TTRANSFORMATION_TO_PACKAGE__RT:
				setRt((RelationalTransformation)null);
				return;
			case RelationsToTraceClassPackage.TTRANSFORMATION_TO_PACKAGE__P:
				setP((EPackage)null);
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
			case RelationsToTraceClassPackage.TTRANSFORMATION_TO_PACKAGE__RT:
				return rt != null;
			case RelationsToTraceClassPackage.TTRANSFORMATION_TO_PACKAGE__P:
				return p != null;
		}
		return super.eIsSet(featureID);
	}

} //TTransformationToPackageImpl
