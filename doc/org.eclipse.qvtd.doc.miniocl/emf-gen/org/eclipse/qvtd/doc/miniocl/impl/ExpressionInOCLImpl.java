/**
 */
package org.eclipse.qvtd.doc.miniocl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.doc.miniocl.ExpressionInOCL;
import org.eclipse.qvtd.doc.miniocl.MiniOCLPackage;
import org.eclipse.qvtd.doc.miniocl.OCLExpression;
import org.eclipse.qvtd.doc.miniocl.Variable;
import org.eclipse.qvtd.doc.miniocl.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression In OCL</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.impl.ExpressionInOCLImpl#getOwnedSelfVar <em>Owned Self Var</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.impl.ExpressionInOCLImpl#getOwnedBody <em>Owned Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpressionInOCLImpl extends OpaqueExpressionImpl implements ExpressionInOCL {
	/**
	 * The cached value of the '{@link #getOwnedSelfVar() <em>Owned Self Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSelfVar()
	 * @generated
	 * @ordered
	 */
	protected Variable ownedSelfVar;

	/**
	 * The cached value of the '{@link #getOwnedBody() <em>Owned Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBody()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedBody;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionInOCLImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.EXPRESSION_IN_OCL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getOwnedSelfVar() {
		return ownedSelfVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedSelfVar(Variable newOwnedSelfVar, NotificationChain msgs) {
		Variable oldOwnedSelfVar = ownedSelfVar;
		ownedSelfVar = newOwnedSelfVar;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniOCLPackage.EXPRESSION_IN_OCL__OWNED_SELF_VAR, oldOwnedSelfVar, newOwnedSelfVar);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedSelfVar(Variable newOwnedSelfVar) {
		if (newOwnedSelfVar != ownedSelfVar) {
			NotificationChain msgs = null;
			if (ownedSelfVar != null)
				msgs = ((InternalEObject)ownedSelfVar).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniOCLPackage.EXPRESSION_IN_OCL__OWNED_SELF_VAR, null, msgs);
			if (newOwnedSelfVar != null)
				msgs = ((InternalEObject)newOwnedSelfVar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniOCLPackage.EXPRESSION_IN_OCL__OWNED_SELF_VAR, null, msgs);
			msgs = basicSetOwnedSelfVar(newOwnedSelfVar, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.EXPRESSION_IN_OCL__OWNED_SELF_VAR, newOwnedSelfVar, newOwnedSelfVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getOwnedBody() {
		return ownedBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedBody(OCLExpression newOwnedBody, NotificationChain msgs) {
		OCLExpression oldOwnedBody = ownedBody;
		ownedBody = newOwnedBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniOCLPackage.EXPRESSION_IN_OCL__OWNED_BODY, oldOwnedBody, newOwnedBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedBody(OCLExpression newOwnedBody) {
		if (newOwnedBody != ownedBody) {
			NotificationChain msgs = null;
			if (ownedBody != null)
				msgs = ((InternalEObject)ownedBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniOCLPackage.EXPRESSION_IN_OCL__OWNED_BODY, null, msgs);
			if (newOwnedBody != null)
				msgs = ((InternalEObject)newOwnedBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniOCLPackage.EXPRESSION_IN_OCL__OWNED_BODY, null, msgs);
			msgs = basicSetOwnedBody(newOwnedBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.EXPRESSION_IN_OCL__OWNED_BODY, newOwnedBody, newOwnedBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MiniOCLPackage.EXPRESSION_IN_OCL__OWNED_SELF_VAR:
				return basicSetOwnedSelfVar(null, msgs);
			case MiniOCLPackage.EXPRESSION_IN_OCL__OWNED_BODY:
				return basicSetOwnedBody(null, msgs);
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
			case MiniOCLPackage.EXPRESSION_IN_OCL__OWNED_SELF_VAR:
				return getOwnedSelfVar();
			case MiniOCLPackage.EXPRESSION_IN_OCL__OWNED_BODY:
				return getOwnedBody();
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
			case MiniOCLPackage.EXPRESSION_IN_OCL__OWNED_SELF_VAR:
				setOwnedSelfVar((Variable)newValue);
				return;
			case MiniOCLPackage.EXPRESSION_IN_OCL__OWNED_BODY:
				setOwnedBody((OCLExpression)newValue);
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
			case MiniOCLPackage.EXPRESSION_IN_OCL__OWNED_SELF_VAR:
				setOwnedSelfVar((Variable)null);
				return;
			case MiniOCLPackage.EXPRESSION_IN_OCL__OWNED_BODY:
				setOwnedBody((OCLExpression)null);
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
			case MiniOCLPackage.EXPRESSION_IN_OCL__OWNED_SELF_VAR:
				return ownedSelfVar != null;
			case MiniOCLPackage.EXPRESSION_IN_OCL__OWNED_BODY:
				return ownedBody != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitExpressionInOCL(this);
	}

} //ExpressionInOCLImpl
