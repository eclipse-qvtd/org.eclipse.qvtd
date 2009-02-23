/**
 * <copyright>
 * </copyright>
 *
 * $Id: TSubTemplateToTraceClassPropsImpl.java,v 1.1 2009/02/23 18:14:57 qglineur Exp $
 */
package org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.ocl.ecore.Variable;

import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;

import org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage;
import org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TSub Template To Trace Class Props</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TSubTemplateToTraceClassPropsImpl#getC <em>C</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TSubTemplateToTraceClassPropsImpl#getTv <em>Tv</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TSubTemplateToTraceClassPropsImpl#getTp <em>Tp</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TSubTemplateToTraceClassPropsImpl#getPt <em>Pt</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TSubTemplateToTraceClassPropsImpl#getT <em>T</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TSubTemplateToTraceClassPropsImpl#getA <em>A</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TSubTemplateToTraceClassPropsImpl#getRc <em>Rc</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TSubTemplateToTraceClassPropsImpl extends EObjectImpl implements TSubTemplateToTraceClassProps {
	/**
	 * The cached value of the '{@link #getC() <em>C</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getC()
	 * @generated
	 * @ordered
	 */
	protected EClass c;

	/**
	 * The cached value of the '{@link #getTv() <em>Tv</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTv()
	 * @generated
	 * @ordered
	 */
	protected Variable tv;

	/**
	 * The cached value of the '{@link #getTp() <em>Tp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTp()
	 * @generated
	 * @ordered
	 */
	protected ObjectTemplateExp tp;

	/**
	 * The cached value of the '{@link #getPt() <em>Pt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPt()
	 * @generated
	 * @ordered
	 */
	protected PropertyTemplateItem pt;

	/**
	 * The cached value of the '{@link #getT() <em>T</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT()
	 * @generated
	 * @ordered
	 */
	protected ObjectTemplateExp t;

	/**
	 * The cached value of the '{@link #getA() <em>A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA()
	 * @generated
	 * @ordered
	 */
	protected EReference a;

	/**
	 * The cached value of the '{@link #getRc() <em>Rc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRc()
	 * @generated
	 * @ordered
	 */
	protected EClass rc;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TSubTemplateToTraceClassPropsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationsToTraceClassPackage.Literals.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getC() {
		if (c != null && c.eIsProxy()) {
			InternalEObject oldC = (InternalEObject)c;
			c = (EClass)eResolveProxy(oldC);
			if (c != oldC) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__C, oldC, c));
			}
		}
		return c;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetC() {
		return c;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setC(EClass newC) {
		EClass oldC = c;
		c = newC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__C, oldC, c));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getTv() {
		if (tv != null && tv.eIsProxy()) {
			InternalEObject oldTv = (InternalEObject)tv;
			tv = (Variable)eResolveProxy(oldTv);
			if (tv != oldTv) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__TV, oldTv, tv));
			}
		}
		return tv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetTv() {
		return tv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTv(Variable newTv) {
		Variable oldTv = tv;
		tv = newTv;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__TV, oldTv, tv));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateExp getTp() {
		if (tp != null && tp.eIsProxy()) {
			InternalEObject oldTp = (InternalEObject)tp;
			tp = (ObjectTemplateExp)eResolveProxy(oldTp);
			if (tp != oldTp) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__TP, oldTp, tp));
			}
		}
		return tp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateExp basicGetTp() {
		return tp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTp(ObjectTemplateExp newTp) {
		ObjectTemplateExp oldTp = tp;
		tp = newTp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__TP, oldTp, tp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyTemplateItem getPt() {
		if (pt != null && pt.eIsProxy()) {
			InternalEObject oldPt = (InternalEObject)pt;
			pt = (PropertyTemplateItem)eResolveProxy(oldPt);
			if (pt != oldPt) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__PT, oldPt, pt));
			}
		}
		return pt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyTemplateItem basicGetPt() {
		return pt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPt(PropertyTemplateItem newPt) {
		PropertyTemplateItem oldPt = pt;
		pt = newPt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__PT, oldPt, pt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateExp getT() {
		if (t != null && t.eIsProxy()) {
			InternalEObject oldT = (InternalEObject)t;
			t = (ObjectTemplateExp)eResolveProxy(oldT);
			if (t != oldT) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__T, oldT, t));
			}
		}
		return t;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateExp basicGetT() {
		return t;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT(ObjectTemplateExp newT) {
		ObjectTemplateExp oldT = t;
		t = newT;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__T, oldT, t));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getA() {
		if (a != null && a.eIsProxy()) {
			InternalEObject oldA = (InternalEObject)a;
			a = (EReference)eResolveProxy(oldA);
			if (a != oldA) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__A, oldA, a));
			}
		}
		return a;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetA() {
		return a;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setA(EReference newA) {
		EReference oldA = a;
		a = newA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__A, oldA, a));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRc() {
		if (rc != null && rc.eIsProxy()) {
			InternalEObject oldRc = (InternalEObject)rc;
			rc = (EClass)eResolveProxy(oldRc);
			if (rc != oldRc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__RC, oldRc, rc));
			}
		}
		return rc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetRc() {
		return rc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRc(EClass newRc) {
		EClass oldRc = rc;
		rc = newRc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__RC, oldRc, rc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__C:
				if (resolve) return getC();
				return basicGetC();
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__TV:
				if (resolve) return getTv();
				return basicGetTv();
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__TP:
				if (resolve) return getTp();
				return basicGetTp();
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__PT:
				if (resolve) return getPt();
				return basicGetPt();
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__T:
				if (resolve) return getT();
				return basicGetT();
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__A:
				if (resolve) return getA();
				return basicGetA();
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__RC:
				if (resolve) return getRc();
				return basicGetRc();
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
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__C:
				setC((EClass)newValue);
				return;
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__TV:
				setTv((Variable)newValue);
				return;
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__TP:
				setTp((ObjectTemplateExp)newValue);
				return;
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__PT:
				setPt((PropertyTemplateItem)newValue);
				return;
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__T:
				setT((ObjectTemplateExp)newValue);
				return;
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__A:
				setA((EReference)newValue);
				return;
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__RC:
				setRc((EClass)newValue);
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
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__C:
				setC((EClass)null);
				return;
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__TV:
				setTv((Variable)null);
				return;
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__TP:
				setTp((ObjectTemplateExp)null);
				return;
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__PT:
				setPt((PropertyTemplateItem)null);
				return;
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__T:
				setT((ObjectTemplateExp)null);
				return;
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__A:
				setA((EReference)null);
				return;
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__RC:
				setRc((EClass)null);
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
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__C:
				return c != null;
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__TV:
				return tv != null;
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__TP:
				return tp != null;
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__PT:
				return pt != null;
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__T:
				return t != null;
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__A:
				return a != null;
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__RC:
				return rc != null;
		}
		return super.eIsSet(featureID);
	}

} //TSubTemplateToTraceClassPropsImpl
