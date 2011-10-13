/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtcorecst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedElementCSImpl;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;

import org.eclipse.qvtd.xtext.qvtcorecst.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage;
import org.eclipse.qvtd.xtext.qvtcorecst.QueryCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.QueryCSImpl#getInputParamDeclaration <em>Input Param Declaration</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.QueryCSImpl#getOclExpression <em>Ocl Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryCSImpl extends TypedElementCSImpl implements QueryCS {
	/**
	 * The cached value of the '{@link #getInputParamDeclaration() <em>Input Param Declaration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputParamDeclaration()
	 * @generated
	 * @ordered
	 */
	protected EList<ParamDeclarationCS> inputParamDeclaration;

	/**
	 * The cached value of the '{@link #getOclExpression() <em>Ocl Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpCS oclExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QueryCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcoreCSTPackage.Literals.QUERY_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParamDeclarationCS> getInputParamDeclaration() {
		if (inputParamDeclaration == null) {
			inputParamDeclaration = new EObjectContainmentEList<ParamDeclarationCS>(ParamDeclarationCS.class, this, QVTcoreCSTPackage.QUERY_CS__INPUT_PARAM_DECLARATION);
		}
		return inputParamDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getOclExpression() {
		return oclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOclExpression(ExpCS newOclExpression, NotificationChain msgs) {
		ExpCS oldOclExpression = oclExpression;
		oclExpression = newOclExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcoreCSTPackage.QUERY_CS__OCL_EXPRESSION, oldOclExpression, newOclExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOclExpression(ExpCS newOclExpression) {
		if (newOclExpression != oclExpression) {
			NotificationChain msgs = null;
			if (oclExpression != null)
				msgs = ((InternalEObject)oclExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcoreCSTPackage.QUERY_CS__OCL_EXPRESSION, null, msgs);
			if (newOclExpression != null)
				msgs = ((InternalEObject)newOclExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcoreCSTPackage.QUERY_CS__OCL_EXPRESSION, null, msgs);
			msgs = basicSetOclExpression(newOclExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreCSTPackage.QUERY_CS__OCL_EXPRESSION, newOclExpression, newOclExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTcoreCSTPackage.QUERY_CS__INPUT_PARAM_DECLARATION:
				return ((InternalEList<?>)getInputParamDeclaration()).basicRemove(otherEnd, msgs);
			case QVTcoreCSTPackage.QUERY_CS__OCL_EXPRESSION:
				return basicSetOclExpression(null, msgs);
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
			case QVTcoreCSTPackage.QUERY_CS__INPUT_PARAM_DECLARATION:
				return getInputParamDeclaration();
			case QVTcoreCSTPackage.QUERY_CS__OCL_EXPRESSION:
				return getOclExpression();
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
			case QVTcoreCSTPackage.QUERY_CS__INPUT_PARAM_DECLARATION:
				getInputParamDeclaration().clear();
				getInputParamDeclaration().addAll((Collection<? extends ParamDeclarationCS>)newValue);
				return;
			case QVTcoreCSTPackage.QUERY_CS__OCL_EXPRESSION:
				setOclExpression((ExpCS)newValue);
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
			case QVTcoreCSTPackage.QUERY_CS__INPUT_PARAM_DECLARATION:
				getInputParamDeclaration().clear();
				return;
			case QVTcoreCSTPackage.QUERY_CS__OCL_EXPRESSION:
				setOclExpression((ExpCS)null);
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
			case QVTcoreCSTPackage.QUERY_CS__INPUT_PARAM_DECLARATION:
				return inputParamDeclaration != null && !inputParamDeclaration.isEmpty();
			case QVTcoreCSTPackage.QUERY_CS__OCL_EXPRESSION:
				return oclExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //QueryCSImpl
