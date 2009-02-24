/**
 * <copyright>
 * </copyright>
 *
 * $Id: TRelationToTraceClassImpl.java,v 1.2 2009/02/24 17:31:29 qglineur Exp $
 */
package org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.ocl.ecore.Variable;

import org.eclipse.qvt.declarative.ecore.QVTRelation.DomainPattern;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;

import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;

import org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage;
import org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TRelation To Trace Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TRelationToTraceClassImpl#getA <em>A</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TRelationToTraceClassImpl#getRc <em>Rc</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TRelationToTraceClassImpl#getC <em>C</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TRelationToTraceClassImpl#getP <em>P</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TRelationToTraceClassImpl#getTv <em>Tv</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TRelationToTraceClassImpl#getT <em>T</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TRelationToTraceClassImpl#getRdp <em>Rdp</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TRelationToTraceClassImpl#getRd <em>Rd</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TRelationToTraceClassImpl#getR <em>R</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TRelationToTraceClassImpl#getRt <em>Rt</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TRelationToTraceClassImpl extends EObjectImpl implements TRelationToTraceClass {
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
	 * The cached value of the '{@link #getC() <em>C</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getC()
	 * @generated
	 * @ordered
	 */
	protected EClass c;

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
	 * The cached value of the '{@link #getTv() <em>Tv</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTv()
	 * @generated
	 * @ordered
	 */
	protected Variable tv;

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
	 * The cached value of the '{@link #getRdp() <em>Rdp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRdp()
	 * @generated
	 * @ordered
	 */
	protected DomainPattern rdp;

	/**
	 * The cached value of the '{@link #getRd() <em>Rd</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRd()
	 * @generated
	 * @ordered
	 */
	protected RelationDomain rd;

	/**
	 * The cached value of the '{@link #getR() <em>R</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR()
	 * @generated
	 * @ordered
	 */
	protected Relation r;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TRelationToTraceClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationsToTraceClassPackage.Literals.TRELATION_TO_TRACE_CLASS;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__A, oldA, a));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__A, oldA, a));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RC, oldRc, rc));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RC, oldRc, rc));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__C, oldC, c));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__C, oldC, c));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__P, oldP, p));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__P, oldP, p));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__TV, oldTv, tv));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__TV, oldTv, tv));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__T, oldT, t));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__T, oldT, t));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainPattern getRdp() {
		if (rdp != null && rdp.eIsProxy()) {
			InternalEObject oldRdp = (InternalEObject)rdp;
			rdp = (DomainPattern)eResolveProxy(oldRdp);
			if (rdp != oldRdp) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RDP, oldRdp, rdp));
			}
		}
		return rdp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainPattern basicGetRdp() {
		return rdp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRdp(DomainPattern newRdp) {
		DomainPattern oldRdp = rdp;
		rdp = newRdp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RDP, oldRdp, rdp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDomain getRd() {
		if (rd != null && rd.eIsProxy()) {
			InternalEObject oldRd = (InternalEObject)rd;
			rd = (RelationDomain)eResolveProxy(oldRd);
			if (rd != oldRd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RD, oldRd, rd));
			}
		}
		return rd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDomain basicGetRd() {
		return rd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRd(RelationDomain newRd) {
		RelationDomain oldRd = rd;
		rd = newRd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RD, oldRd, rd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation getR() {
		if (r != null && r.eIsProxy()) {
			InternalEObject oldR = (InternalEObject)r;
			r = (Relation)eResolveProxy(oldR);
			if (r != oldR) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__R, oldR, r));
			}
		}
		return r;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetR() {
		return r;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setR(Relation newR) {
		Relation oldR = r;
		r = newR;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__R, oldR, r));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RT, oldRt, rt));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RT, oldRt, rt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__A:
				if (resolve) return getA();
				return basicGetA();
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RC:
				if (resolve) return getRc();
				return basicGetRc();
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__C:
				if (resolve) return getC();
				return basicGetC();
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__P:
				if (resolve) return getP();
				return basicGetP();
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__TV:
				if (resolve) return getTv();
				return basicGetTv();
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__T:
				if (resolve) return getT();
				return basicGetT();
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RDP:
				if (resolve) return getRdp();
				return basicGetRdp();
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RD:
				if (resolve) return getRd();
				return basicGetRd();
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__R:
				if (resolve) return getR();
				return basicGetR();
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RT:
				if (resolve) return getRt();
				return basicGetRt();
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
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__A:
				setA((EReference)newValue);
				return;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RC:
				setRc((EClass)newValue);
				return;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__C:
				setC((EClass)newValue);
				return;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__P:
				setP((EPackage)newValue);
				return;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__TV:
				setTv((Variable)newValue);
				return;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__T:
				setT((ObjectTemplateExp)newValue);
				return;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RDP:
				setRdp((DomainPattern)newValue);
				return;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RD:
				setRd((RelationDomain)newValue);
				return;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__R:
				setR((Relation)newValue);
				return;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RT:
				setRt((RelationalTransformation)newValue);
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
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__A:
				setA((EReference)null);
				return;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RC:
				setRc((EClass)null);
				return;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__C:
				setC((EClass)null);
				return;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__P:
				setP((EPackage)null);
				return;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__TV:
				setTv((Variable)null);
				return;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__T:
				setT((ObjectTemplateExp)null);
				return;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RDP:
				setRdp((DomainPattern)null);
				return;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RD:
				setRd((RelationDomain)null);
				return;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__R:
				setR((Relation)null);
				return;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RT:
				setRt((RelationalTransformation)null);
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
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__A:
				return a != null;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RC:
				return rc != null;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__C:
				return c != null;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__P:
				return p != null;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__TV:
				return tv != null;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__T:
				return t != null;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RDP:
				return rdp != null;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RD:
				return rd != null;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__R:
				return r != null;
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS__RT:
				return rt != null;
		}
		return super.eIsSet(featureID);
	}

} //TRelationToTraceClassImpl
