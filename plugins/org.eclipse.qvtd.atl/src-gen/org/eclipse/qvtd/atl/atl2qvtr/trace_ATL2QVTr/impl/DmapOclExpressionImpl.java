/**
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclType;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.runtime.qvttrace.impl.DispatchImpl;
import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dmap Ocl Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getD3atlExpression <em>D3atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getD4qvtrExpression <em>D4qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapBooleanExp <em>Domap Boolean Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapIfExp <em>Domap If Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapIntegerExp <em>Domap Integer Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapNavigationOrAttributeCallExp_Helper <em>Domap Navigation Or Attribute Call Exp Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapNavigationOrAttributeCallExp_Property <em>Domap Navigation Or Attribute Call Exp Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapOclType <em>Domap Ocl Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapOperationCallExp_Helper <em>Domap Operation Call Exp Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapOperationCallExp_Operation <em>Domap Operation Call Exp Operation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapOperatorCallExp <em>Domap Operator Call Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapStringExp <em>Domap String Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getDomapVariableExp <em>Domap Variable Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl#getS0global <em>S0global</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DmapOclExpressionImpl extends DispatchImpl implements DmapOclExpression {
	/**
	 * The number of structural features of the '<em>Dmap Ocl Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DMAP_OCL_EXPRESSION_FEATURE_COUNT = DispatchImpl.DISPATCH_FEATURE_COUNT + 15;

	/**
	 * The number of operations of the '<em>Dmap Ocl Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DMAP_OCL_EXPRESSION_OPERATION_COUNT = DispatchImpl.DISPATCH_OPERATION_COUNT + 0;


	/**
	 * The cached value of the '{@link #getD3atlExpression() <em>D3atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD3atlExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression d3atlExpression;

	/**
	 * The cached value of the '{@link #getD4qvtrExpression() <em>D4qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD4qvtrExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression d4qvtrExpression;

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
	 * The cached value of the '{@link #getDomapOclType() <em>Domap Ocl Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomapOclType()
	 * @generated
	 * @ordered
	 */
	protected TmapOclType domapOclType;

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
	 * The default value of the '{@link #getS0global() <em>S0global</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS0global()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean S0GLOBAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getS0global() <em>S0global</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS0global()
	 * @generated
	 * @ordered
	 */
	protected Boolean s0global = S0GLOBAL_EDEFAULT;

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
	public OclExpression getD3atlExpression() {
		if (d3atlExpression != null && d3atlExpression.eIsProxy()) {
			InternalEObject oldD3atlExpression = d3atlExpression;
			d3atlExpression = (OclExpression)eResolveProxy(oldD3atlExpression);
			if (d3atlExpression != oldD3atlExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DispatchImpl.DISPATCH_FEATURE_COUNT + 0, oldD3atlExpression, d3atlExpression));
			}
		}
		return d3atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetD3atlExpression() {
		return d3atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setD3atlExpression(OclExpression newD3atlExpression) {
		OclExpression oldD3atlExpression = d3atlExpression;
		d3atlExpression = newD3atlExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 0, oldD3atlExpression, d3atlExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getD4qvtrExpression() {
		if (d4qvtrExpression != null && d4qvtrExpression.eIsProxy()) {
			InternalEObject oldD4qvtrExpression = (InternalEObject)d4qvtrExpression;
			d4qvtrExpression = (OCLExpression)eResolveProxy(oldD4qvtrExpression);
			if (d4qvtrExpression != oldD4qvtrExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DispatchImpl.DISPATCH_FEATURE_COUNT + 1, oldD4qvtrExpression, d4qvtrExpression));
			}
		}
		return d4qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetD4qvtrExpression() {
		return d4qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setD4qvtrExpression(OCLExpression newD4qvtrExpression) {
		OCLExpression oldD4qvtrExpression = d4qvtrExpression;
		d4qvtrExpression = newD4qvtrExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 1, oldD4qvtrExpression, d4qvtrExpression));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 2, oldDomapBooleanExp, newDomapBooleanExp);
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
				msgs = ((InternalEObject)domapBooleanExp).eInverseRemove(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapBooleanExp.class, msgs);
			if (newDomapBooleanExp != null)
				msgs = ((InternalEObject)newDomapBooleanExp).eInverseAdd(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapBooleanExp.class, msgs);
			msgs = basicSetDomapBooleanExp(newDomapBooleanExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 2, newDomapBooleanExp, newDomapBooleanExp));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 3, oldDomapIfExp, newDomapIfExp);
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
				msgs = ((InternalEObject)domapIfExp).eInverseRemove(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapIfExp.class, msgs);
			if (newDomapIfExp != null)
				msgs = ((InternalEObject)newDomapIfExp).eInverseAdd(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapIfExp.class, msgs);
			msgs = basicSetDomapIfExp(newDomapIfExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 3, newDomapIfExp, newDomapIfExp));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 4, oldDomapIntegerExp, newDomapIntegerExp);
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
				msgs = ((InternalEObject)domapIntegerExp).eInverseRemove(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapIntegerExp.class, msgs);
			if (newDomapIntegerExp != null)
				msgs = ((InternalEObject)newDomapIntegerExp).eInverseAdd(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapIntegerExp.class, msgs);
			msgs = basicSetDomapIntegerExp(newDomapIntegerExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 4, newDomapIntegerExp, newDomapIntegerExp));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 5, oldDomapNavigationOrAttributeCallExp_Helper, newDomapNavigationOrAttributeCallExp_Helper);
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
				msgs = ((InternalEObject)domapNavigationOrAttributeCallExp_Helper).eInverseRemove(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapNavigationOrAttributeCallExp_Helper.class, msgs);
			if (newDomapNavigationOrAttributeCallExp_Helper != null)
				msgs = ((InternalEObject)newDomapNavigationOrAttributeCallExp_Helper).eInverseAdd(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapNavigationOrAttributeCallExp_Helper.class, msgs);
			msgs = basicSetDomapNavigationOrAttributeCallExp_Helper(newDomapNavigationOrAttributeCallExp_Helper, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 5, newDomapNavigationOrAttributeCallExp_Helper, newDomapNavigationOrAttributeCallExp_Helper));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 6, oldDomapNavigationOrAttributeCallExp_Property, newDomapNavigationOrAttributeCallExp_Property);
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
				msgs = ((InternalEObject)domapNavigationOrAttributeCallExp_Property).eInverseRemove(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapNavigationOrAttributeCallExp_Property.class, msgs);
			if (newDomapNavigationOrAttributeCallExp_Property != null)
				msgs = ((InternalEObject)newDomapNavigationOrAttributeCallExp_Property).eInverseAdd(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapNavigationOrAttributeCallExp_Property.class, msgs);
			msgs = basicSetDomapNavigationOrAttributeCallExp_Property(newDomapNavigationOrAttributeCallExp_Property, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 6, newDomapNavigationOrAttributeCallExp_Property, newDomapNavigationOrAttributeCallExp_Property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapOclType getDomapOclType() {
		return domapOclType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomapOclType(TmapOclType newDomapOclType, NotificationChain msgs) {
		TmapOclType oldDomapOclType = domapOclType;
		domapOclType = newDomapOclType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 7, oldDomapOclType, newDomapOclType);
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
	public void setDomapOclType(TmapOclType newDomapOclType) {
		if (newDomapOclType != domapOclType) {
			NotificationChain msgs = null;
			if (domapOclType != null)
				msgs = ((InternalEObject)domapOclType).eInverseRemove(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapOclType.class, msgs);
			if (newDomapOclType != null)
				msgs = ((InternalEObject)newDomapOclType).eInverseAdd(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapOclType.class, msgs);
			msgs = basicSetDomapOclType(newDomapOclType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 7, newDomapOclType, newDomapOclType));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 8, oldDomapOperationCallExp_Helper, newDomapOperationCallExp_Helper);
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
				msgs = ((InternalEObject)domapOperationCallExp_Helper).eInverseRemove(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapOperationCallExp_Helper.class, msgs);
			if (newDomapOperationCallExp_Helper != null)
				msgs = ((InternalEObject)newDomapOperationCallExp_Helper).eInverseAdd(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapOperationCallExp_Helper.class, msgs);
			msgs = basicSetDomapOperationCallExp_Helper(newDomapOperationCallExp_Helper, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 8, newDomapOperationCallExp_Helper, newDomapOperationCallExp_Helper));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 9, oldDomapOperationCallExp_Operation, newDomapOperationCallExp_Operation);
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
				msgs = ((InternalEObject)domapOperationCallExp_Operation).eInverseRemove(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapOperationCallExp_Operation.class, msgs);
			if (newDomapOperationCallExp_Operation != null)
				msgs = ((InternalEObject)newDomapOperationCallExp_Operation).eInverseAdd(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapOperationCallExp_Operation.class, msgs);
			msgs = basicSetDomapOperationCallExp_Operation(newDomapOperationCallExp_Operation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 9, newDomapOperationCallExp_Operation, newDomapOperationCallExp_Operation));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 10, oldDomapOperatorCallExp, newDomapOperatorCallExp);
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
				msgs = ((InternalEObject)domapOperatorCallExp).eInverseRemove(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapOperatorCallExp.class, msgs);
			if (newDomapOperatorCallExp != null)
				msgs = ((InternalEObject)newDomapOperatorCallExp).eInverseAdd(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapOperatorCallExp.class, msgs);
			msgs = basicSetDomapOperatorCallExp(newDomapOperatorCallExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 10, newDomapOperatorCallExp, newDomapOperatorCallExp));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 11, oldDomapStringExp, newDomapStringExp);
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
				msgs = ((InternalEObject)domapStringExp).eInverseRemove(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapStringExp.class, msgs);
			if (newDomapStringExp != null)
				msgs = ((InternalEObject)newDomapStringExp).eInverseAdd(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapStringExp.class, msgs);
			msgs = basicSetDomapStringExp(newDomapStringExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 11, newDomapStringExp, newDomapStringExp));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 12, oldDomapVariableExp, newDomapVariableExp);
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
				msgs = ((InternalEObject)domapVariableExp).eInverseRemove(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapVariableExp.class, msgs);
			if (newDomapVariableExp != null)
				msgs = ((InternalEObject)newDomapVariableExp).eInverseAdd(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapVariableExp.class, msgs);
			msgs = basicSetDomapVariableExp(newDomapVariableExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 12, newDomapVariableExp, newDomapVariableExp));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DispatchImpl.DISPATCH_FEATURE_COUNT + 13, oldResult, result));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 13, oldResult, result));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getS0global() {
		return s0global;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setS0global(Boolean newS0global) {
		Boolean oldS0global = s0global;
		s0global = newS0global;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 14, oldS0global, s0global));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				if (domapBooleanExp != null)
					msgs = ((InternalEObject)domapBooleanExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 2), null, msgs);
				return basicSetDomapBooleanExp((TmapBooleanExp)otherEnd, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				if (domapIfExp != null)
					msgs = ((InternalEObject)domapIfExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 3), null, msgs);
				return basicSetDomapIfExp((TmapIfExp)otherEnd, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 4:
				if (domapIntegerExp != null)
					msgs = ((InternalEObject)domapIntegerExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 4), null, msgs);
				return basicSetDomapIntegerExp((TmapIntegerExp)otherEnd, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 5:
				if (domapNavigationOrAttributeCallExp_Helper != null)
					msgs = ((InternalEObject)domapNavigationOrAttributeCallExp_Helper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 5), null, msgs);
				return basicSetDomapNavigationOrAttributeCallExp_Helper((TmapNavigationOrAttributeCallExp_Helper)otherEnd, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 6:
				if (domapNavigationOrAttributeCallExp_Property != null)
					msgs = ((InternalEObject)domapNavigationOrAttributeCallExp_Property).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 6), null, msgs);
				return basicSetDomapNavigationOrAttributeCallExp_Property((TmapNavigationOrAttributeCallExp_Property)otherEnd, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 7:
				if (domapOclType != null)
					msgs = ((InternalEObject)domapOclType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 7), null, msgs);
				return basicSetDomapOclType((TmapOclType)otherEnd, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 8:
				if (domapOperationCallExp_Helper != null)
					msgs = ((InternalEObject)domapOperationCallExp_Helper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 8), null, msgs);
				return basicSetDomapOperationCallExp_Helper((TmapOperationCallExp_Helper)otherEnd, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 9:
				if (domapOperationCallExp_Operation != null)
					msgs = ((InternalEObject)domapOperationCallExp_Operation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 9), null, msgs);
				return basicSetDomapOperationCallExp_Operation((TmapOperationCallExp_Operation)otherEnd, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 10:
				if (domapOperatorCallExp != null)
					msgs = ((InternalEObject)domapOperatorCallExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 10), null, msgs);
				return basicSetDomapOperatorCallExp((TmapOperatorCallExp)otherEnd, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 11:
				if (domapStringExp != null)
					msgs = ((InternalEObject)domapStringExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 11), null, msgs);
				return basicSetDomapStringExp((TmapStringExp)otherEnd, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 12:
				if (domapVariableExp != null)
					msgs = ((InternalEObject)domapVariableExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 12), null, msgs);
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
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				return basicSetDomapBooleanExp(null, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				return basicSetDomapIfExp(null, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 4:
				return basicSetDomapIntegerExp(null, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 5:
				return basicSetDomapNavigationOrAttributeCallExp_Helper(null, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 6:
				return basicSetDomapNavigationOrAttributeCallExp_Property(null, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 7:
				return basicSetDomapOclType(null, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 8:
				return basicSetDomapOperationCallExp_Helper(null, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 9:
				return basicSetDomapOperationCallExp_Operation(null, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 10:
				return basicSetDomapOperatorCallExp(null, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 11:
				return basicSetDomapStringExp(null, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 12:
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
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 0:
				if (resolve) return getD3atlExpression();
				return basicGetD3atlExpression();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				if (resolve) return getD4qvtrExpression();
				return basicGetD4qvtrExpression();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				return getDomapBooleanExp();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				return getDomapIfExp();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 4:
				return getDomapIntegerExp();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 5:
				return getDomapNavigationOrAttributeCallExp_Helper();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 6:
				return getDomapNavigationOrAttributeCallExp_Property();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 7:
				return getDomapOclType();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 8:
				return getDomapOperationCallExp_Helper();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 9:
				return getDomapOperationCallExp_Operation();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 10:
				return getDomapOperatorCallExp();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 11:
				return getDomapStringExp();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 12:
				return getDomapVariableExp();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 13:
				if (resolve) return getResult();
				return basicGetResult();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 14:
				return getS0global();
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
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 0:
				setD3atlExpression((OclExpression)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				setD4qvtrExpression((OCLExpression)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				setDomapBooleanExp((TmapBooleanExp)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				setDomapIfExp((TmapIfExp)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 4:
				setDomapIntegerExp((TmapIntegerExp)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 5:
				setDomapNavigationOrAttributeCallExp_Helper((TmapNavigationOrAttributeCallExp_Helper)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 6:
				setDomapNavigationOrAttributeCallExp_Property((TmapNavigationOrAttributeCallExp_Property)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 7:
				setDomapOclType((TmapOclType)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 8:
				setDomapOperationCallExp_Helper((TmapOperationCallExp_Helper)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 9:
				setDomapOperationCallExp_Operation((TmapOperationCallExp_Operation)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 10:
				setDomapOperatorCallExp((TmapOperatorCallExp)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 11:
				setDomapStringExp((TmapStringExp)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 12:
				setDomapVariableExp((TmapVariableExp)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 13:
				setResult((ImapOclExpression)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 14:
				setS0global((Boolean)newValue);
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
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 0:
				setD3atlExpression((OclExpression)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				setD4qvtrExpression((OCLExpression)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				setDomapBooleanExp((TmapBooleanExp)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				setDomapIfExp((TmapIfExp)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 4:
				setDomapIntegerExp((TmapIntegerExp)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 5:
				setDomapNavigationOrAttributeCallExp_Helper((TmapNavigationOrAttributeCallExp_Helper)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 6:
				setDomapNavigationOrAttributeCallExp_Property((TmapNavigationOrAttributeCallExp_Property)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 7:
				setDomapOclType((TmapOclType)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 8:
				setDomapOperationCallExp_Helper((TmapOperationCallExp_Helper)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 9:
				setDomapOperationCallExp_Operation((TmapOperationCallExp_Operation)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 10:
				setDomapOperatorCallExp((TmapOperatorCallExp)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 11:
				setDomapStringExp((TmapStringExp)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 12:
				setDomapVariableExp((TmapVariableExp)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 13:
				setResult((ImapOclExpression)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 14:
				setS0global(S0GLOBAL_EDEFAULT);
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
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 0:
				return d3atlExpression != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				return d4qvtrExpression != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				return domapBooleanExp != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				return domapIfExp != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 4:
				return domapIntegerExp != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 5:
				return domapNavigationOrAttributeCallExp_Helper != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 6:
				return domapNavigationOrAttributeCallExp_Property != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 7:
				return domapOclType != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 8:
				return domapOperationCallExp_Helper != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 9:
				return domapOperationCallExp_Operation != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 10:
				return domapOperatorCallExp != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 11:
				return domapStringExp != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 12:
				return domapVariableExp != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 13:
				return result != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 14:
				return S0GLOBAL_EDEFAULT == null ? s0global != null : !S0GLOBAL_EDEFAULT.equals(s0global);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (s0global: ");
		result.append(s0global);
		result.append(')');
		return result.toString();
	}


} //DmapOclExpressionImpl
