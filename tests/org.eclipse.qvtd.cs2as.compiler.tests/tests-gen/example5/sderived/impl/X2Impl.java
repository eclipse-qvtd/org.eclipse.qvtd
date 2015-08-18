/**
 */
package example5.sderived.impl;

import example5.sbase.impl.XImpl;

import example5.sderived.SderivedPackage;
import example5.sderived.W;
import example5.sderived.X2;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>X2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example5.sderived.impl.X2Impl#getOwnsW <em>Owns W</em>}</li>
 * </ul>
 *
 * @generated
 */
public class X2Impl extends XImpl implements X2 {
	/**
	 * The cached value of the '{@link #getOwnsW() <em>Owns W</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnsW()
	 * @generated
	 * @ordered
	 */
	protected EList<W> ownsW;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected X2Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SderivedPackage.Literals.X2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<W> getOwnsW() {
		if (ownsW == null) {
			ownsW = new EObjectContainmentEList<W>(W.class, this, SderivedPackage.X2__OWNS_W);
		}
		return ownsW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SderivedPackage.X2__OWNS_W:
				return ((InternalEList<?>)getOwnsW()).basicRemove(otherEnd, msgs);
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
			case SderivedPackage.X2__OWNS_W:
				return getOwnsW();
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
			case SderivedPackage.X2__OWNS_W:
				getOwnsW().clear();
				getOwnsW().addAll((Collection<? extends W>)newValue);
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
			case SderivedPackage.X2__OWNS_W:
				getOwnsW().clear();
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
			case SderivedPackage.X2__OWNS_W:
				return ownsW != null && !ownsW.isEmpty();
		}
		return super.eIsSet(featureID);
	}


} //X2Impl
