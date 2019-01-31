/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
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
	 * The number of structural features of the '<em>Dmap Ocl Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DMAP_OCL_EXPRESSION_FEATURE_COUNT = DispatchImpl.DISPATCH_FEATURE_COUNT + 13;

	/**
	 * The number of operations of the '<em>Dmap Ocl Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DMAP_OCL_EXPRESSION_OPERATION_COUNT = DispatchImpl.DISPATCH_OPERATION_COUNT + 0;


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
			InternalEObject oldD1atlExpression = d1atlExpression;
			d1atlExpression = (OclExpression)eResolveProxy(oldD1atlExpression);
			if (d1atlExpression != oldD1atlExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DispatchImpl.DISPATCH_FEATURE_COUNT + 0, oldD1atlExpression, d1atlExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 0, oldD1atlExpression, d1atlExpression));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DispatchImpl.DISPATCH_FEATURE_COUNT + 1, oldD2qvtrExpression, d2qvtrExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 1, oldD2qvtrExpression, d2qvtrExpression));
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
				msgs = ((InternalEObject)domapBooleanExp).eInverseRemove(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapBooleanExp.class, msgs);
			if (newDomapBooleanExp != null)
				msgs = ((InternalEObject)newDomapBooleanExp).eInverseAdd(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapBooleanExp.class, msgs);
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
				msgs = ((InternalEObject)domapIfExp).eInverseRemove(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapIfExp.class, msgs);
			if (newDomapIfExp != null)
				msgs = ((InternalEObject)newDomapIfExp).eInverseAdd(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapIfExp.class, msgs);
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
				msgs = ((InternalEObject)domapIntegerExp).eInverseRemove(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapIntegerExp.class, msgs);
			if (newDomapIntegerExp != null)
				msgs = ((InternalEObject)newDomapIntegerExp).eInverseAdd(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapIntegerExp.class, msgs);
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
				msgs = ((InternalEObject)domapNavigationOrAttributeCallExp_Helper).eInverseRemove(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapNavigationOrAttributeCallExp_Helper.class, msgs);
			if (newDomapNavigationOrAttributeCallExp_Helper != null)
				msgs = ((InternalEObject)newDomapNavigationOrAttributeCallExp_Helper).eInverseAdd(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapNavigationOrAttributeCallExp_Helper.class, msgs);
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
				msgs = ((InternalEObject)domapNavigationOrAttributeCallExp_Property).eInverseRemove(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapNavigationOrAttributeCallExp_Property.class, msgs);
			if (newDomapNavigationOrAttributeCallExp_Property != null)
				msgs = ((InternalEObject)newDomapNavigationOrAttributeCallExp_Property).eInverseAdd(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapNavigationOrAttributeCallExp_Property.class, msgs);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 7, oldDomapOperationCallExp_Helper, newDomapOperationCallExp_Helper);
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
				msgs = ((InternalEObject)domapOperationCallExp_Helper).eInverseRemove(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapOperationCallExp_Helper.class, msgs);
			if (newDomapOperationCallExp_Helper != null)
				msgs = ((InternalEObject)newDomapOperationCallExp_Helper).eInverseAdd(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapOperationCallExp_Helper.class, msgs);
			msgs = basicSetDomapOperationCallExp_Helper(newDomapOperationCallExp_Helper, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 7, newDomapOperationCallExp_Helper, newDomapOperationCallExp_Helper));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 8, oldDomapOperationCallExp_Operation, newDomapOperationCallExp_Operation);
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
				msgs = ((InternalEObject)domapOperationCallExp_Operation).eInverseRemove(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapOperationCallExp_Operation.class, msgs);
			if (newDomapOperationCallExp_Operation != null)
				msgs = ((InternalEObject)newDomapOperationCallExp_Operation).eInverseAdd(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapOperationCallExp_Operation.class, msgs);
			msgs = basicSetDomapOperationCallExp_Operation(newDomapOperationCallExp_Operation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 8, newDomapOperationCallExp_Operation, newDomapOperationCallExp_Operation));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 9, oldDomapOperatorCallExp, newDomapOperatorCallExp);
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
				msgs = ((InternalEObject)domapOperatorCallExp).eInverseRemove(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapOperatorCallExp.class, msgs);
			if (newDomapOperatorCallExp != null)
				msgs = ((InternalEObject)newDomapOperatorCallExp).eInverseAdd(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapOperatorCallExp.class, msgs);
			msgs = basicSetDomapOperatorCallExp(newDomapOperatorCallExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 9, newDomapOperatorCallExp, newDomapOperatorCallExp));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 10, oldDomapStringExp, newDomapStringExp);
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
				msgs = ((InternalEObject)domapStringExp).eInverseRemove(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapStringExp.class, msgs);
			if (newDomapStringExp != null)
				msgs = ((InternalEObject)newDomapStringExp).eInverseAdd(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapStringExp.class, msgs);
			msgs = basicSetDomapStringExp(newDomapStringExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 10, newDomapStringExp, newDomapStringExp));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 11, oldDomapVariableExp, newDomapVariableExp);
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
				msgs = ((InternalEObject)domapVariableExp).eInverseRemove(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapVariableExp.class, msgs);
			if (newDomapVariableExp != null)
				msgs = ((InternalEObject)newDomapVariableExp).eInverseAdd(this, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, TmapVariableExp.class, msgs);
			msgs = basicSetDomapVariableExp(newDomapVariableExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 11, newDomapVariableExp, newDomapVariableExp));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DispatchImpl.DISPATCH_FEATURE_COUNT + 12, oldResult, result));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 12, oldResult, result));
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
				if (domapOperationCallExp_Helper != null)
					msgs = ((InternalEObject)domapOperationCallExp_Helper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 7), null, msgs);
				return basicSetDomapOperationCallExp_Helper((TmapOperationCallExp_Helper)otherEnd, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 8:
				if (domapOperationCallExp_Operation != null)
					msgs = ((InternalEObject)domapOperationCallExp_Operation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 8), null, msgs);
				return basicSetDomapOperationCallExp_Operation((TmapOperationCallExp_Operation)otherEnd, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 9:
				if (domapOperatorCallExp != null)
					msgs = ((InternalEObject)domapOperatorCallExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 9), null, msgs);
				return basicSetDomapOperatorCallExp((TmapOperatorCallExp)otherEnd, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 10:
				if (domapStringExp != null)
					msgs = ((InternalEObject)domapStringExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 10), null, msgs);
				return basicSetDomapStringExp((TmapStringExp)otherEnd, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 11:
				if (domapVariableExp != null)
					msgs = ((InternalEObject)domapVariableExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 11), null, msgs);
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
				return basicSetDomapOperationCallExp_Helper(null, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 8:
				return basicSetDomapOperationCallExp_Operation(null, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 9:
				return basicSetDomapOperatorCallExp(null, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 10:
				return basicSetDomapStringExp(null, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 11:
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
				if (resolve) return getD1atlExpression();
				return basicGetD1atlExpression();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				if (resolve) return getD2qvtrExpression();
				return basicGetD2qvtrExpression();
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
				return getDomapOperationCallExp_Helper();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 8:
				return getDomapOperationCallExp_Operation();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 9:
				return getDomapOperatorCallExp();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 10:
				return getDomapStringExp();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 11:
				return getDomapVariableExp();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 12:
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
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 0:
				setD1atlExpression((OclExpression)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				setD2qvtrExpression((OCLExpression)newValue);
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
				setDomapOperationCallExp_Helper((TmapOperationCallExp_Helper)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 8:
				setDomapOperationCallExp_Operation((TmapOperationCallExp_Operation)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 9:
				setDomapOperatorCallExp((TmapOperatorCallExp)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 10:
				setDomapStringExp((TmapStringExp)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 11:
				setDomapVariableExp((TmapVariableExp)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 12:
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
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 0:
				setD1atlExpression((OclExpression)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				setD2qvtrExpression((OCLExpression)null);
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
				setDomapOperationCallExp_Helper((TmapOperationCallExp_Helper)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 8:
				setDomapOperationCallExp_Operation((TmapOperationCallExp_Operation)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 9:
				setDomapOperatorCallExp((TmapOperatorCallExp)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 10:
				setDomapStringExp((TmapStringExp)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 11:
				setDomapVariableExp((TmapVariableExp)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 12:
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
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 0:
				return d1atlExpression != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				return d2qvtrExpression != null;
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
				return domapOperationCallExp_Helper != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 8:
				return domapOperationCallExp_Operation != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 9:
				return domapOperatorCallExp != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 10:
				return domapStringExp != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 11:
				return domapVariableExp != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 12:
				return result != null;
		}
		return super.eIsSet(featureID);
	}


} //DmapOclExpressionImpl
