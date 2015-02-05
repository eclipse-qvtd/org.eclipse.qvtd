/**
 */
package org.eclipse.qvtd.build.qvtschedule.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.qvtd.build.qvtschedule.AbstractAction;
import org.eclipse.qvtd.build.qvtschedule.DataParameter;
import org.eclipse.qvtd.build.qvtschedule.ParameterDerivation;
import org.eclipse.qvtd.build.qvtschedule.SecondaryParameter;
import org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Derivation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.ParameterDerivationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.ParameterDerivationImpl#getPrimaryParameter <em>Primary Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.ParameterDerivationImpl#getSecondaryParameters <em>Secondary Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParameterDerivationImpl extends MinimalEObjectImpl.Container implements ParameterDerivation {
	/**
	 * The cached value of the '{@link #getPrimaryParameter() <em>Primary Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryParameter()
	 * @generated
	 * @ordered
	 */
	protected DataParameter primaryParameter;

	/**
	 * The cached value of the '{@link #getSecondaryParameters() <em>Secondary Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondaryParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<SecondaryParameter> secondaryParameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterDerivationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return qvtschedulePackage.Literals.PARAMETER_DERIVATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAction getTarget() {
		if (eContainerFeatureID() != qvtschedulePackage.PARAMETER_DERIVATION__TARGET) return null;
		return (AbstractAction)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(AbstractAction newTarget, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTarget, qvtschedulePackage.PARAMETER_DERIVATION__TARGET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(AbstractAction newTarget) {
		if (newTarget != eInternalContainer() || (eContainerFeatureID() != qvtschedulePackage.PARAMETER_DERIVATION__TARGET && newTarget != null)) {
			if (EcoreUtil.isAncestor(this, newTarget))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, qvtschedulePackage.ABSTRACT_ACTION__PARAMETER_DERIVATIONS, AbstractAction.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.PARAMETER_DERIVATION__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataParameter getPrimaryParameter() {
		return primaryParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrimaryParameter(DataParameter newPrimaryParameter, NotificationChain msgs) {
		DataParameter oldPrimaryParameter = primaryParameter;
		primaryParameter = newPrimaryParameter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, qvtschedulePackage.PARAMETER_DERIVATION__PRIMARY_PARAMETER, oldPrimaryParameter, newPrimaryParameter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryParameter(DataParameter newPrimaryParameter) {
		if (newPrimaryParameter != primaryParameter) {
			NotificationChain msgs = null;
			if (primaryParameter != null)
				msgs = ((InternalEObject)primaryParameter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - qvtschedulePackage.PARAMETER_DERIVATION__PRIMARY_PARAMETER, null, msgs);
			if (newPrimaryParameter != null)
				msgs = ((InternalEObject)newPrimaryParameter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - qvtschedulePackage.PARAMETER_DERIVATION__PRIMARY_PARAMETER, null, msgs);
			msgs = basicSetPrimaryParameter(newPrimaryParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.PARAMETER_DERIVATION__PRIMARY_PARAMETER, newPrimaryParameter, newPrimaryParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SecondaryParameter> getSecondaryParameters() {
		if (secondaryParameters == null) {
			secondaryParameters = new EObjectContainmentWithInverseEList<SecondaryParameter>(SecondaryParameter.class, this, qvtschedulePackage.PARAMETER_DERIVATION__SECONDARY_PARAMETERS, qvtschedulePackage.SECONDARY_PARAMETER__DERIVATION);
		}
		return secondaryParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case qvtschedulePackage.PARAMETER_DERIVATION__TARGET:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTarget((AbstractAction)otherEnd, msgs);
			case qvtschedulePackage.PARAMETER_DERIVATION__SECONDARY_PARAMETERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSecondaryParameters()).basicAdd(otherEnd, msgs);
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
			case qvtschedulePackage.PARAMETER_DERIVATION__TARGET:
				return basicSetTarget(null, msgs);
			case qvtschedulePackage.PARAMETER_DERIVATION__PRIMARY_PARAMETER:
				return basicSetPrimaryParameter(null, msgs);
			case qvtschedulePackage.PARAMETER_DERIVATION__SECONDARY_PARAMETERS:
				return ((InternalEList<?>)getSecondaryParameters()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case qvtschedulePackage.PARAMETER_DERIVATION__TARGET:
				return eInternalContainer().eInverseRemove(this, qvtschedulePackage.ABSTRACT_ACTION__PARAMETER_DERIVATIONS, AbstractAction.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case qvtschedulePackage.PARAMETER_DERIVATION__TARGET:
				return getTarget();
			case qvtschedulePackage.PARAMETER_DERIVATION__PRIMARY_PARAMETER:
				return getPrimaryParameter();
			case qvtschedulePackage.PARAMETER_DERIVATION__SECONDARY_PARAMETERS:
				return getSecondaryParameters();
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
			case qvtschedulePackage.PARAMETER_DERIVATION__TARGET:
				setTarget((AbstractAction)newValue);
				return;
			case qvtschedulePackage.PARAMETER_DERIVATION__PRIMARY_PARAMETER:
				setPrimaryParameter((DataParameter)newValue);
				return;
			case qvtschedulePackage.PARAMETER_DERIVATION__SECONDARY_PARAMETERS:
				getSecondaryParameters().clear();
				getSecondaryParameters().addAll((Collection<? extends SecondaryParameter>)newValue);
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
			case qvtschedulePackage.PARAMETER_DERIVATION__TARGET:
				setTarget((AbstractAction)null);
				return;
			case qvtschedulePackage.PARAMETER_DERIVATION__PRIMARY_PARAMETER:
				setPrimaryParameter((DataParameter)null);
				return;
			case qvtschedulePackage.PARAMETER_DERIVATION__SECONDARY_PARAMETERS:
				getSecondaryParameters().clear();
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
			case qvtschedulePackage.PARAMETER_DERIVATION__TARGET:
				return getTarget() != null;
			case qvtschedulePackage.PARAMETER_DERIVATION__PRIMARY_PARAMETER:
				return primaryParameter != null;
			case qvtschedulePackage.PARAMETER_DERIVATION__SECONDARY_PARAMETERS:
				return secondaryParameters != null && !secondaryParameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ParameterDerivationImpl
