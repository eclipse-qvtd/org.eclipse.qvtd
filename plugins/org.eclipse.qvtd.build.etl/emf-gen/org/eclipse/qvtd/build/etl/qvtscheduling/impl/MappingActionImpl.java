/**
 */
package org.eclipse.qvtd.build.etl.qvtscheduling.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.build.etl.qvtscheduling.MappingAction;
import org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding;
import org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.MappingActionImpl#getMappingBindings <em>Mapping Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingActionImpl extends AbstractActionImpl implements MappingAction {
	/**
	 * The cached value of the '{@link #getMappingBindings() <em>Mapping Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingBinding> mappingBindings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QvtSchedulingPackage.Literals.MAPPING_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingBinding> getMappingBindings() {
		if (mappingBindings == null) {
			mappingBindings = new EObjectContainmentWithInverseEList<MappingBinding>(MappingBinding.class, this, QvtSchedulingPackage.MAPPING_ACTION__MAPPING_BINDINGS, QvtSchedulingPackage.MAPPING_BINDING__MAPPING_ACTION);
		}
		return mappingBindings;
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
			case QvtSchedulingPackage.MAPPING_ACTION__MAPPING_BINDINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMappingBindings()).basicAdd(otherEnd, msgs);
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
			case QvtSchedulingPackage.MAPPING_ACTION__MAPPING_BINDINGS:
				return ((InternalEList<?>)getMappingBindings()).basicRemove(otherEnd, msgs);
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
			case QvtSchedulingPackage.MAPPING_ACTION__MAPPING_BINDINGS:
				return getMappingBindings();
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
			case QvtSchedulingPackage.MAPPING_ACTION__MAPPING_BINDINGS:
				getMappingBindings().clear();
				getMappingBindings().addAll((Collection<? extends MappingBinding>)newValue);
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
			case QvtSchedulingPackage.MAPPING_ACTION__MAPPING_BINDINGS:
				getMappingBindings().clear();
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
			case QvtSchedulingPackage.MAPPING_ACTION__MAPPING_BINDINGS:
				return mappingBindings != null && !mappingBindings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MappingActionImpl
