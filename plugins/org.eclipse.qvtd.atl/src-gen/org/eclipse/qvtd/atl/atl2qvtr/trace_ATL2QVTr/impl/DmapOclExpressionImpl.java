/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.runtime.qvttrace.impl.DispatchImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dmap Ocl Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getD1atlExpression <em>D1atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getD2qvtrExpression <em>D2qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapBooleanExp <em>Domap Boolean Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapIfExp <em>Domap If Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapIntegerExp <em>Domap Integer Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapNavigationOrAttributeCallExp_Helper <em>Domap Navigation Or Attribute Call Exp Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapNavigationOrAttributeCallExp_Property <em>Domap Navigation Or Attribute Call Exp Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapOperationCallExp_Helper <em>Domap Operation Call Exp Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapOperationCallExp_Operation <em>Domap Operation Call Exp Operation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapOperatorCallExp <em>Domap Operator Call Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapStringExp <em>Domap String Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapVariableExp <em>Domap Variable Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getResult <em>Result</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DmapOclExpressionImpl extends DispatchImpl implements DmapOclExpression {
	/**
	 * The cached value of the '{@link #getD1atlExpression() <em>D1atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD1atlExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression d1atlExpression;

	/**
	 * The cached value of the '{@link #getD2qvtrExpression() <em>D2qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD2qvtrExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression d2qvtrExpression;

	/**
	 * The cached value of the '{@link #getDomapBooleanExp() <em>Domap Boolean Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomapBooleanExp()
	 * @generated
	 * @ordered
	 */
	protected TmapBooleanExp domapBooleanExp;

	/**
	 * The cached value of the '{@link #getDomapIfExp() <em>Domap If Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomapIfExp()
	 * @generated
	 * @ordered
	 */
	protected TmapIfExp domapIfExp;

	/**
	 * The cached value of the '{@link #getDomapIntegerExp() <em>Domap Integer Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomapIntegerExp()
	 * @generated
	 * @ordered
	 */
	protected TmapIntegerExp domapIntegerExp;

	/**
	 * The cached value of the '{@link #getDomapNavigationOrAttributeCallExp_Helper() <em>Domap Navigation Or Attribute Call Exp Helper</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 * @ordered
	 */
	protected TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper;

	/**
	 * The cached value of the '{@link #getDomapNavigationOrAttributeCallExp_Property() <em>Domap Navigation Or Attribute Call Exp Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomapNavigationOrAttributeCallExp_Property()
	 * @generated
	 * @ordered
	 */
	protected TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property;

	/**
	 * The cached value of the '{@link #getDomapOperationCallExp_Helper() <em>Domap Operation Call Exp Helper</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomapOperationCallExp_Helper()
	 * @generated
	 * @ordered
	 */
	protected TmapOperationCallExp_Helper domapOperationCallExp_Helper;

	/**
	 * The cached value of the '{@link #getDomapOperationCallExp_Operation() <em>Domap Operation Call Exp Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomapOperationCallExp_Operation()
	 * @generated
	 * @ordered
	 */
	protected TmapOperationCallExp_Operation domapOperationCallExp_Operation;

	/**
	 * The cached value of the '{@link #getDomapOperatorCallExp() <em>Domap Operator Call Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomapOperatorCallExp()
	 * @generated
	 * @ordered
	 */
	protected TmapOperatorCallExp domapOperatorCallExp;

	/**
	 * The cached value of the '{@link #getDomapStringExp() <em>Domap String Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomapStringExp()
	 * @generated
	 * @ordered
	 */
	protected TmapStringExp domapStringExp;

	/**
	 * The cached value of the '{@link #getDomapVariableExp() <em>Domap Variable Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomapVariableExp()
	 * @generated
	 * @ordered
	 */
	protected TmapVariableExp domapVariableExp;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected ImapOclExpression result;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DmapOclExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getD1atlExpression() {
		if (d1atlExpression != null && d1atlExpression.eIsProxy()) {
			InternalEObject oldD1atlExpression = (InternalEObject)d1atlExpression;
			d1atlExpression = (OclExpression)eResolveProxy(oldD1atlExpression);
			if (d1atlExpression != oldD1atlExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__D1ATL_EXPRESSION, oldD1atlExpression, d1atlExpression));
			}
		}
		return d1atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetD1atlExpression() {
		return d1atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setD1atlExpression(OclExpression newD1atlExpression) {
		OclExpression oldD1atlExpression = d1atlExpression;
		d1atlExpression = newD1atlExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__D1ATL_EXPRESSION, oldD1atlExpression, d1atlExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getD2qvtrExpression() {
		if (d2qvtrExpression != null && d2qvtrExpression.eIsProxy()) {
			InternalEObject oldD2qvtrExpression = (InternalEObject)d2qvtrExpression;
			d2qvtrExpression = (OCLExpression)eResolveProxy(oldD2qvtrExpression);
			if (d2qvtrExpression != oldD2qvtrExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__D2QVTR_EXPRESSION, oldD2qvtrExpression, d2qvtrExpression));
			}
		}
		return d2qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetD2qvtrExpression() {
		return d2qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setD2qvtrExpression(OCLExpression newD2qvtrExpression) {
		OCLExpression oldD2qvtrExpression = d2qvtrExpression;
		d2qvtrExpression = newD2qvtrExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__D2QVTR_EXPRESSION, oldD2qvtrExpression, d2qvtrExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapBooleanExp getDomapBooleanExp() {
		return domapBooleanExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomapBooleanExp(TmapBooleanExp newDomapBooleanExp, NotificationChain msgs) {
		TmapBooleanExp oldDomapBooleanExp = domapBooleanExp;
		domapBooleanExp = newDomapBooleanExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_BOOLEAN_EXP, oldDomapBooleanExp, newDomapBooleanExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomapBooleanExp(TmapBooleanExp newDomapBooleanExp) {
		if (newDomapBooleanExp != domapBooleanExp) {
			NotificationChain msgs = null;
			if (domapBooleanExp != null)
				msgs = ((InternalEObject)domapBooleanExp).eInverseRemove(this, trace_ATL2QVTrPackage.TMAP_BOOLEAN_EXP__DISPATCHER, TmapBooleanExp.class, msgs);
			if (newDomapBooleanExp != null)
				msgs = ((InternalEObject)newDomapBooleanExp).eInverseAdd(this, trace_ATL2QVTrPackage.TMAP_BOOLEAN_EXP__DISPATCHER, TmapBooleanExp.class, msgs);
			msgs = basicSetDomapBooleanExp(newDomapBooleanExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_BOOLEAN_EXP, newDomapBooleanExp, newDomapBooleanExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapIfExp getDomapIfExp() {
		return domapIfExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomapIfExp(TmapIfExp newDomapIfExp, NotificationChain msgs) {
		TmapIfExp oldDomapIfExp = domapIfExp;
		domapIfExp = newDomapIfExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_IF_EXP, oldDomapIfExp, newDomapIfExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomapIfExp(TmapIfExp newDomapIfExp) {
		if (newDomapIfExp != domapIfExp) {
			NotificationChain msgs = null;
			if (domapIfExp != null)
				msgs = ((InternalEObject)domapIfExp).eInverseRemove(this, trace_ATL2QVTrPackage.TMAP_IF_EXP__DISPATCHER, TmapIfExp.class, msgs);
			if (newDomapIfExp != null)
				msgs = ((InternalEObject)newDomapIfExp).eInverseAdd(this, trace_ATL2QVTrPackage.TMAP_IF_EXP__DISPATCHER, TmapIfExp.class, msgs);
			msgs = basicSetDomapIfExp(newDomapIfExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_IF_EXP, newDomapIfExp, newDomapIfExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapIntegerExp getDomapIntegerExp() {
		return domapIntegerExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomapIntegerExp(TmapIntegerExp newDomapIntegerExp, NotificationChain msgs) {
		TmapIntegerExp oldDomapIntegerExp = domapIntegerExp;
		domapIntegerExp = newDomapIntegerExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_INTEGER_EXP, oldDomapIntegerExp, newDomapIntegerExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomapIntegerExp(TmapIntegerExp newDomapIntegerExp) {
		if (newDomapIntegerExp != domapIntegerExp) {
			NotificationChain msgs = null;
			if (domapIntegerExp != null)
				msgs = ((InternalEObject)domapIntegerExp).eInverseRemove(this, trace_ATL2QVTrPackage.TMAP_INTEGER_EXP__DISPATCHER, TmapIntegerExp.class, msgs);
			if (newDomapIntegerExp != null)
				msgs = ((InternalEObject)newDomapIntegerExp).eInverseAdd(this, trace_ATL2QVTrPackage.TMAP_INTEGER_EXP__DISPATCHER, TmapIntegerExp.class, msgs);
			msgs = basicSetDomapIntegerExp(newDomapIntegerExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_INTEGER_EXP, newDomapIntegerExp, newDomapIntegerExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapNavigationOrAttributeCallExp_Helper getDomapNavigationOrAttributeCallExp_Helper() {
		return domapNavigationOrAttributeCallExp_Helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomapNavigationOrAttributeCallExp_Helper(TmapNavigationOrAttributeCallExp_Helper newDomapNavigationOrAttributeCallExp_Helper, NotificationChain msgs) {
		TmapNavigationOrAttributeCallExp_Helper oldDomapNavigationOrAttributeCallExp_Helper = domapNavigationOrAttributeCallExp_Helper;
		domapNavigationOrAttributeCallExp_Helper = newDomapNavigationOrAttributeCallExp_Helper;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER, oldDomapNavigationOrAttributeCallExp_Helper, newDomapNavigationOrAttributeCallExp_Helper);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomapNavigationOrAttributeCallExp_Helper(TmapNavigationOrAttributeCallExp_Helper newDomapNavigationOrAttributeCallExp_Helper) {
		if (newDomapNavigationOrAttributeCallExp_Helper != domapNavigationOrAttributeCallExp_Helper) {
			NotificationChain msgs = null;
			if (domapNavigationOrAttributeCallExp_Helper != null)
				msgs = ((InternalEObject)domapNavigationOrAttributeCallExp_Helper).eInverseRemove(this, trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__DISPATCHER, TmapNavigationOrAttributeCallExp_Helper.class, msgs);
			if (newDomapNavigationOrAttributeCallExp_Helper != null)
				msgs = ((InternalEObject)newDomapNavigationOrAttributeCallExp_Helper).eInverseAdd(this, trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__DISPATCHER, TmapNavigationOrAttributeCallExp_Helper.class, msgs);
			msgs = basicSetDomapNavigationOrAttributeCallExp_Helper(newDomapNavigationOrAttributeCallExp_Helper, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER, newDomapNavigationOrAttributeCallExp_Helper, newDomapNavigationOrAttributeCallExp_Helper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapNavigationOrAttributeCallExp_Property getDomapNavigationOrAttributeCallExp_Property() {
		return domapNavigationOrAttributeCallExp_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomapNavigationOrAttributeCallExp_Property(TmapNavigationOrAttributeCallExp_Property newDomapNavigationOrAttributeCallExp_Property, NotificationChain msgs) {
		TmapNavigationOrAttributeCallExp_Property oldDomapNavigationOrAttributeCallExp_Property = domapNavigationOrAttributeCallExp_Property;
		domapNavigationOrAttributeCallExp_Property = newDomapNavigationOrAttributeCallExp_Property;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY, oldDomapNavigationOrAttributeCallExp_Property, newDomapNavigationOrAttributeCallExp_Property);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomapNavigationOrAttributeCallExp_Property(TmapNavigationOrAttributeCallExp_Property newDomapNavigationOrAttributeCallExp_Property) {
		if (newDomapNavigationOrAttributeCallExp_Property != domapNavigationOrAttributeCallExp_Property) {
			NotificationChain msgs = null;
			if (domapNavigationOrAttributeCallExp_Property != null)
				msgs = ((InternalEObject)domapNavigationOrAttributeCallExp_Property).eInverseRemove(this, trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__DISPATCHER, TmapNavigationOrAttributeCallExp_Property.class, msgs);
			if (newDomapNavigationOrAttributeCallExp_Property != null)
				msgs = ((InternalEObject)newDomapNavigationOrAttributeCallExp_Property).eInverseAdd(this, trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__DISPATCHER, TmapNavigationOrAttributeCallExp_Property.class, msgs);
			msgs = basicSetDomapNavigationOrAttributeCallExp_Property(newDomapNavigationOrAttributeCallExp_Property, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY, newDomapNavigationOrAttributeCallExp_Property, newDomapNavigationOrAttributeCallExp_Property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapOperationCallExp_Helper getDomapOperationCallExp_Helper() {
		return domapOperationCallExp_Helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomapOperationCallExp_Helper(TmapOperationCallExp_Helper newDomapOperationCallExp_Helper, NotificationChain msgs) {
		TmapOperationCallExp_Helper oldDomapOperationCallExp_Helper = domapOperationCallExp_Helper;
		domapOperationCallExp_Helper = newDomapOperationCallExp_Helper;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_HELPER, oldDomapOperationCallExp_Helper, newDomapOperationCallExp_Helper);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomapOperationCallExp_Helper(TmapOperationCallExp_Helper newDomapOperationCallExp_Helper) {
		if (newDomapOperationCallExp_Helper != domapOperationCallExp_Helper) {
			NotificationChain msgs = null;
			if (domapOperationCallExp_Helper != null)
				msgs = ((InternalEObject)domapOperationCallExp_Helper).eInverseRemove(this, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__DISPATCHER, TmapOperationCallExp_Helper.class, msgs);
			if (newDomapOperationCallExp_Helper != null)
				msgs = ((InternalEObject)newDomapOperationCallExp_Helper).eInverseAdd(this, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__DISPATCHER, TmapOperationCallExp_Helper.class, msgs);
			msgs = basicSetDomapOperationCallExp_Helper(newDomapOperationCallExp_Helper, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_HELPER, newDomapOperationCallExp_Helper, newDomapOperationCallExp_Helper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapOperationCallExp_Operation getDomapOperationCallExp_Operation() {
		return domapOperationCallExp_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomapOperationCallExp_Operation(TmapOperationCallExp_Operation newDomapOperationCallExp_Operation, NotificationChain msgs) {
		TmapOperationCallExp_Operation oldDomapOperationCallExp_Operation = domapOperationCallExp_Operation;
		domapOperationCallExp_Operation = newDomapOperationCallExp_Operation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_OPERATION, oldDomapOperationCallExp_Operation, newDomapOperationCallExp_Operation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomapOperationCallExp_Operation(TmapOperationCallExp_Operation newDomapOperationCallExp_Operation) {
		if (newDomapOperationCallExp_Operation != domapOperationCallExp_Operation) {
			NotificationChain msgs = null;
			if (domapOperationCallExp_Operation != null)
				msgs = ((InternalEObject)domapOperationCallExp_Operation).eInverseRemove(this, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__DISPATCHER, TmapOperationCallExp_Operation.class, msgs);
			if (newDomapOperationCallExp_Operation != null)
				msgs = ((InternalEObject)newDomapOperationCallExp_Operation).eInverseAdd(this, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__DISPATCHER, TmapOperationCallExp_Operation.class, msgs);
			msgs = basicSetDomapOperationCallExp_Operation(newDomapOperationCallExp_Operation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_OPERATION, newDomapOperationCallExp_Operation, newDomapOperationCallExp_Operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapOperatorCallExp getDomapOperatorCallExp() {
		return domapOperatorCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomapOperatorCallExp(TmapOperatorCallExp newDomapOperatorCallExp, NotificationChain msgs) {
		TmapOperatorCallExp oldDomapOperatorCallExp = domapOperatorCallExp;
		domapOperatorCallExp = newDomapOperatorCallExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATOR_CALL_EXP, oldDomapOperatorCallExp, newDomapOperatorCallExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomapOperatorCallExp(TmapOperatorCallExp newDomapOperatorCallExp) {
		if (newDomapOperatorCallExp != domapOperatorCallExp) {
			NotificationChain msgs = null;
			if (domapOperatorCallExp != null)
				msgs = ((InternalEObject)domapOperatorCallExp).eInverseRemove(this, trace_ATL2QVTrPackage.TMAP_OPERATOR_CALL_EXP__DISPATCHER, TmapOperatorCallExp.class, msgs);
			if (newDomapOperatorCallExp != null)
				msgs = ((InternalEObject)newDomapOperatorCallExp).eInverseAdd(this, trace_ATL2QVTrPackage.TMAP_OPERATOR_CALL_EXP__DISPATCHER, TmapOperatorCallExp.class, msgs);
			msgs = basicSetDomapOperatorCallExp(newDomapOperatorCallExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATOR_CALL_EXP, newDomapOperatorCallExp, newDomapOperatorCallExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapStringExp getDomapStringExp() {
		return domapStringExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomapStringExp(TmapStringExp newDomapStringExp, NotificationChain msgs) {
		TmapStringExp oldDomapStringExp = domapStringExp;
		domapStringExp = newDomapStringExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_STRING_EXP, oldDomapStringExp, newDomapStringExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomapStringExp(TmapStringExp newDomapStringExp) {
		if (newDomapStringExp != domapStringExp) {
			NotificationChain msgs = null;
			if (domapStringExp != null)
				msgs = ((InternalEObject)domapStringExp).eInverseRemove(this, trace_ATL2QVTrPackage.TMAP_STRING_EXP__DISPATCHER, TmapStringExp.class, msgs);
			if (newDomapStringExp != null)
				msgs = ((InternalEObject)newDomapStringExp).eInverseAdd(this, trace_ATL2QVTrPackage.TMAP_STRING_EXP__DISPATCHER, TmapStringExp.class, msgs);
			msgs = basicSetDomapStringExp(newDomapStringExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_STRING_EXP, newDomapStringExp, newDomapStringExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapVariableExp getDomapVariableExp() {
		return domapVariableExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomapVariableExp(TmapVariableExp newDomapVariableExp, NotificationChain msgs) {
		TmapVariableExp oldDomapVariableExp = domapVariableExp;
		domapVariableExp = newDomapVariableExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_VARIABLE_EXP, oldDomapVariableExp, newDomapVariableExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomapVariableExp(TmapVariableExp newDomapVariableExp) {
		if (newDomapVariableExp != domapVariableExp) {
			NotificationChain msgs = null;
			if (domapVariableExp != null)
				msgs = ((InternalEObject)domapVariableExp).eInverseRemove(this, trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__DISPATCHER, TmapVariableExp.class, msgs);
			if (newDomapVariableExp != null)
				msgs = ((InternalEObject)newDomapVariableExp).eInverseAdd(this, trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__DISPATCHER, TmapVariableExp.class, msgs);
			msgs = basicSetDomapVariableExp(newDomapVariableExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_VARIABLE_EXP, newDomapVariableExp, newDomapVariableExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImapOclExpression getResult() {
		if (result != null && result.eIsProxy()) {
			InternalEObject oldResult = (InternalEObject)result;
			result = (ImapOclExpression)eResolveProxy(oldResult);
			if (result != oldResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__RESULT, oldResult, result));
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImapOclExpression basicGetResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResult(ImapOclExpression newResult) {
		ImapOclExpression oldResult = result;
		result = newResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__RESULT, oldResult, result));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_BOOLEAN_EXP:
				if (domapBooleanExp != null)
					msgs = ((InternalEObject)domapBooleanExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_BOOLEAN_EXP, null, msgs);
				return basicSetDomapBooleanExp((TmapBooleanExp)otherEnd, msgs);
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_IF_EXP:
				if (domapIfExp != null)
					msgs = ((InternalEObject)domapIfExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_IF_EXP, null, msgs);
				return basicSetDomapIfExp((TmapIfExp)otherEnd, msgs);
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_INTEGER_EXP:
				if (domapIntegerExp != null)
					msgs = ((InternalEObject)domapIntegerExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_INTEGER_EXP, null, msgs);
				return basicSetDomapIntegerExp((TmapIntegerExp)otherEnd, msgs);
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER:
				if (domapNavigationOrAttributeCallExp_Helper != null)
					msgs = ((InternalEObject)domapNavigationOrAttributeCallExp_Helper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER, null, msgs);
				return basicSetDomapNavigationOrAttributeCallExp_Helper((TmapNavigationOrAttributeCallExp_Helper)otherEnd, msgs);
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY:
				if (domapNavigationOrAttributeCallExp_Property != null)
					msgs = ((InternalEObject)domapNavigationOrAttributeCallExp_Property).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY, null, msgs);
				return basicSetDomapNavigationOrAttributeCallExp_Property((TmapNavigationOrAttributeCallExp_Property)otherEnd, msgs);
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_HELPER:
				if (domapOperationCallExp_Helper != null)
					msgs = ((InternalEObject)domapOperationCallExp_Helper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_HELPER, null, msgs);
				return basicSetDomapOperationCallExp_Helper((TmapOperationCallExp_Helper)otherEnd, msgs);
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_OPERATION:
				if (domapOperationCallExp_Operation != null)
					msgs = ((InternalEObject)domapOperationCallExp_Operation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_OPERATION, null, msgs);
				return basicSetDomapOperationCallExp_Operation((TmapOperationCallExp_Operation)otherEnd, msgs);
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATOR_CALL_EXP:
				if (domapOperatorCallExp != null)
					msgs = ((InternalEObject)domapOperatorCallExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATOR_CALL_EXP, null, msgs);
				return basicSetDomapOperatorCallExp((TmapOperatorCallExp)otherEnd, msgs);
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_STRING_EXP:
				if (domapStringExp != null)
					msgs = ((InternalEObject)domapStringExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_STRING_EXP, null, msgs);
				return basicSetDomapStringExp((TmapStringExp)otherEnd, msgs);
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_VARIABLE_EXP:
				if (domapVariableExp != null)
					msgs = ((InternalEObject)domapVariableExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_VARIABLE_EXP, null, msgs);
				return basicSetDomapVariableExp((TmapVariableExp)otherEnd, msgs);
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
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_BOOLEAN_EXP:
				return basicSetDomapBooleanExp(null, msgs);
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_IF_EXP:
				return basicSetDomapIfExp(null, msgs);
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_INTEGER_EXP:
				return basicSetDomapIntegerExp(null, msgs);
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER:
				return basicSetDomapNavigationOrAttributeCallExp_Helper(null, msgs);
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY:
				return basicSetDomapNavigationOrAttributeCallExp_Property(null, msgs);
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_HELPER:
				return basicSetDomapOperationCallExp_Helper(null, msgs);
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_OPERATION:
				return basicSetDomapOperationCallExp_Operation(null, msgs);
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATOR_CALL_EXP:
				return basicSetDomapOperatorCallExp(null, msgs);
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_STRING_EXP:
				return basicSetDomapStringExp(null, msgs);
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_VARIABLE_EXP:
				return basicSetDomapVariableExp(null, msgs);
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
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__D1ATL_EXPRESSION:
				if (resolve) return getD1atlExpression();
				return basicGetD1atlExpression();
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__D2QVTR_EXPRESSION:
				if (resolve) return getD2qvtrExpression();
				return basicGetD2qvtrExpression();
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_BOOLEAN_EXP:
				return getDomapBooleanExp();
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_IF_EXP:
				return getDomapIfExp();
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_INTEGER_EXP:
				return getDomapIntegerExp();
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER:
				return getDomapNavigationOrAttributeCallExp_Helper();
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY:
				return getDomapNavigationOrAttributeCallExp_Property();
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_HELPER:
				return getDomapOperationCallExp_Helper();
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_OPERATION:
				return getDomapOperationCallExp_Operation();
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATOR_CALL_EXP:
				return getDomapOperatorCallExp();
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_STRING_EXP:
				return getDomapStringExp();
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_VARIABLE_EXP:
				return getDomapVariableExp();
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__RESULT:
				if (resolve) return getResult();
				return basicGetResult();
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
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__D1ATL_EXPRESSION:
				setD1atlExpression((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__D2QVTR_EXPRESSION:
				setD2qvtrExpression((OCLExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_BOOLEAN_EXP:
				setDomapBooleanExp((TmapBooleanExp)newValue);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_IF_EXP:
				setDomapIfExp((TmapIfExp)newValue);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_INTEGER_EXP:
				setDomapIntegerExp((TmapIntegerExp)newValue);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER:
				setDomapNavigationOrAttributeCallExp_Helper((TmapNavigationOrAttributeCallExp_Helper)newValue);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY:
				setDomapNavigationOrAttributeCallExp_Property((TmapNavigationOrAttributeCallExp_Property)newValue);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_HELPER:
				setDomapOperationCallExp_Helper((TmapOperationCallExp_Helper)newValue);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_OPERATION:
				setDomapOperationCallExp_Operation((TmapOperationCallExp_Operation)newValue);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATOR_CALL_EXP:
				setDomapOperatorCallExp((TmapOperatorCallExp)newValue);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_STRING_EXP:
				setDomapStringExp((TmapStringExp)newValue);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_VARIABLE_EXP:
				setDomapVariableExp((TmapVariableExp)newValue);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__RESULT:
				setResult((ImapOclExpression)newValue);
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
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__D1ATL_EXPRESSION:
				setD1atlExpression((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__D2QVTR_EXPRESSION:
				setD2qvtrExpression((OCLExpression)null);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_BOOLEAN_EXP:
				setDomapBooleanExp((TmapBooleanExp)null);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_IF_EXP:
				setDomapIfExp((TmapIfExp)null);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_INTEGER_EXP:
				setDomapIntegerExp((TmapIntegerExp)null);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER:
				setDomapNavigationOrAttributeCallExp_Helper((TmapNavigationOrAttributeCallExp_Helper)null);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY:
				setDomapNavigationOrAttributeCallExp_Property((TmapNavigationOrAttributeCallExp_Property)null);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_HELPER:
				setDomapOperationCallExp_Helper((TmapOperationCallExp_Helper)null);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_OPERATION:
				setDomapOperationCallExp_Operation((TmapOperationCallExp_Operation)null);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATOR_CALL_EXP:
				setDomapOperatorCallExp((TmapOperatorCallExp)null);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_STRING_EXP:
				setDomapStringExp((TmapStringExp)null);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_VARIABLE_EXP:
				setDomapVariableExp((TmapVariableExp)null);
				return;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__RESULT:
				setResult((ImapOclExpression)null);
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
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__D1ATL_EXPRESSION:
				return d1atlExpression != null;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__D2QVTR_EXPRESSION:
				return d2qvtrExpression != null;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_BOOLEAN_EXP:
				return domapBooleanExp != null;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_IF_EXP:
				return domapIfExp != null;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_INTEGER_EXP:
				return domapIntegerExp != null;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER:
				return domapNavigationOrAttributeCallExp_Helper != null;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY:
				return domapNavigationOrAttributeCallExp_Property != null;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_HELPER:
				return domapOperationCallExp_Helper != null;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_OPERATION:
				return domapOperationCallExp_Operation != null;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATOR_CALL_EXP:
				return domapOperatorCallExp != null;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_STRING_EXP:
				return domapStringExp != null;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_VARIABLE_EXP:
				return domapVariableExp != null;
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__RESULT:
				return result != null;
		}
		return super.eIsSet(featureID);
	}

} //DmapOclExpressionImpl
