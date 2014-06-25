/**
 */
package org.eclipse.qvtd.build.etl.qvtscheduling.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.ocl.examples.pivot.Variable;

import org.eclipse.qvtd.build.etl.qvtscheduling.ClassDatum;
import org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage;

import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Datum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.ClassDatumImpl#getRealizedVariables <em>Realized Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.ClassDatumImpl#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassDatumImpl extends AbstractDatumImpl implements ClassDatum {
	/**
	 * The cached value of the '{@link #getRealizedVariables() <em>Realized Variables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizedVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<RealizedVariable> realizedVariables;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassDatumImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QvtSchedulingPackage.Literals.CLASS_DATUM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RealizedVariable> getRealizedVariables() {
		if (realizedVariables == null) {
			realizedVariables = new EObjectResolvingEList<RealizedVariable>(RealizedVariable.class, this, QvtSchedulingPackage.CLASS_DATUM__REALIZED_VARIABLES);
		}
		return realizedVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getVariables() {
		if (variables == null) {
			variables = new EObjectResolvingEList<Variable>(Variable.class, this, QvtSchedulingPackage.CLASS_DATUM__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QvtSchedulingPackage.CLASS_DATUM__REALIZED_VARIABLES:
				return getRealizedVariables();
			case QvtSchedulingPackage.CLASS_DATUM__VARIABLES:
				return getVariables();
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
			case QvtSchedulingPackage.CLASS_DATUM__REALIZED_VARIABLES:
				getRealizedVariables().clear();
				getRealizedVariables().addAll((Collection<? extends RealizedVariable>)newValue);
				return;
			case QvtSchedulingPackage.CLASS_DATUM__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends Variable>)newValue);
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
			case QvtSchedulingPackage.CLASS_DATUM__REALIZED_VARIABLES:
				getRealizedVariables().clear();
				return;
			case QvtSchedulingPackage.CLASS_DATUM__VARIABLES:
				getVariables().clear();
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
			case QvtSchedulingPackage.CLASS_DATUM__REALIZED_VARIABLES:
				return realizedVariables != null && !realizedVariables.isEmpty();
			case QvtSchedulingPackage.CLASS_DATUM__VARIABLES:
				return variables != null && !variables.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClassDatumImpl
