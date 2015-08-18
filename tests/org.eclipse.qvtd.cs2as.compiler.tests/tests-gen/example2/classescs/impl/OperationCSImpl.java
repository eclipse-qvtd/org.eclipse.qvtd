/**
 */
package example2.classescs.impl;

import example2.classescs.ClassescsPackage;
import example2.classescs.NameExpCS;
import example2.classescs.OperationCS;

import example2.classescs.PathNameCS;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example2.classescs.impl.OperationCSImpl#getParams <em>Params</em>}</li>
 *   <li>{@link example2.classescs.impl.OperationCSImpl#getBodyExps <em>Body Exps</em>}</li>
 *   <li>{@link example2.classescs.impl.OperationCSImpl#getResultRef <em>Result Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationCSImpl extends NamedElementCSImpl implements OperationCS {
	/**
	 * The cached value of the '{@link #getParams() <em>Params</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParams()
	 * @generated
	 * @ordered
	 */
	protected EList<String> params;
	/**
	 * The cached value of the '{@link #getBodyExps() <em>Body Exps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyExps()
	 * @generated
	 * @ordered
	 */
	protected EList<NameExpCS> bodyExps;
	/**
	 * The cached value of the '{@link #getResultRef() <em>Result Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultRef()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS resultRef;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassescsPackage.Literals.OPERATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getParams() {
		if (params == null) {
			params = new EDataTypeUniqueEList<String>(String.class, this, ClassescsPackage.OPERATION_CS__PARAMS);
		}
		return params;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NameExpCS> getBodyExps() {
		if (bodyExps == null) {
			bodyExps = new EObjectContainmentEList<NameExpCS>(NameExpCS.class, this, ClassescsPackage.OPERATION_CS__BODY_EXPS);
		}
		return bodyExps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getResultRef() {
		return resultRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResultRef(PathNameCS newResultRef, NotificationChain msgs) {
		PathNameCS oldResultRef = resultRef;
		resultRef = newResultRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassescsPackage.OPERATION_CS__RESULT_REF, oldResultRef, newResultRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultRef(PathNameCS newResultRef) {
		if (newResultRef != resultRef) {
			NotificationChain msgs = null;
			if (resultRef != null)
				msgs = ((InternalEObject)resultRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassescsPackage.OPERATION_CS__RESULT_REF, null, msgs);
			if (newResultRef != null)
				msgs = ((InternalEObject)newResultRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ClassescsPackage.OPERATION_CS__RESULT_REF, null, msgs);
			msgs = basicSetResultRef(newResultRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassescsPackage.OPERATION_CS__RESULT_REF, newResultRef, newResultRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassescsPackage.OPERATION_CS__BODY_EXPS:
				return ((InternalEList<?>)getBodyExps()).basicRemove(otherEnd, msgs);
			case ClassescsPackage.OPERATION_CS__RESULT_REF:
				return basicSetResultRef(null, msgs);
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
			case ClassescsPackage.OPERATION_CS__PARAMS:
				return getParams();
			case ClassescsPackage.OPERATION_CS__BODY_EXPS:
				return getBodyExps();
			case ClassescsPackage.OPERATION_CS__RESULT_REF:
				return getResultRef();
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
			case ClassescsPackage.OPERATION_CS__PARAMS:
				getParams().clear();
				getParams().addAll((Collection<? extends String>)newValue);
				return;
			case ClassescsPackage.OPERATION_CS__BODY_EXPS:
				getBodyExps().clear();
				getBodyExps().addAll((Collection<? extends NameExpCS>)newValue);
				return;
			case ClassescsPackage.OPERATION_CS__RESULT_REF:
				setResultRef((PathNameCS)newValue);
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
			case ClassescsPackage.OPERATION_CS__PARAMS:
				getParams().clear();
				return;
			case ClassescsPackage.OPERATION_CS__BODY_EXPS:
				getBodyExps().clear();
				return;
			case ClassescsPackage.OPERATION_CS__RESULT_REF:
				setResultRef((PathNameCS)null);
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
			case ClassescsPackage.OPERATION_CS__PARAMS:
				return params != null && !params.isEmpty();
			case ClassescsPackage.OPERATION_CS__BODY_EXPS:
				return bodyExps != null && !bodyExps.isEmpty();
			case ClassescsPackage.OPERATION_CS__RESULT_REF:
				return resultRef != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (params: ");
		result.append(params);
		result.append(')');
		return result.toString();
	}


} //OperationCSImpl
