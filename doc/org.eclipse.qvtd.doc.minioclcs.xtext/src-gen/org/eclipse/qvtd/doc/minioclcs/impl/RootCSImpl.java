/**
 * generated by Xtext 2.10.0-SNAPSHOT
 */
package org.eclipse.qvtd.doc.minioclcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.doc.minioclcs.ConstraintsDefCS;
import org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage;
import org.eclipse.qvtd.doc.minioclcs.PackageCS;
import org.eclipse.qvtd.doc.minioclcs.RootCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.RootCSImpl#getPackages <em>Packages</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.RootCSImpl#getContraints <em>Contraints</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RootCSImpl extends CSTraceImpl implements RootCS
{
  /**
	 * The cached value of the '{@link #getPackages() <em>Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPackages()
	 * @generated
	 * @ordered
	 */
  protected EList<PackageCS> packages;

  /**
	 * The cached value of the '{@link #getContraints() <em>Contraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getContraints()
	 * @generated
	 * @ordered
	 */
  protected EList<ConstraintsDefCS> contraints;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected RootCSImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass()
  {
		return MinioclcsPackage.Literals.ROOT_CS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<PackageCS> getPackages()
  {
		if (packages == null) {
			packages = new EObjectContainmentEList<PackageCS>(PackageCS.class, this, MinioclcsPackage.ROOT_CS__PACKAGES);
		}
		return packages;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<ConstraintsDefCS> getContraints()
  {
		if (contraints == null) {
			contraints = new EObjectContainmentEList<ConstraintsDefCS>(ConstraintsDefCS.class, this, MinioclcsPackage.ROOT_CS__CONTRAINTS);
		}
		return contraints;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case MinioclcsPackage.ROOT_CS__PACKAGES:
				return ((InternalEList<?>)getPackages()).basicRemove(otherEnd, msgs);
			case MinioclcsPackage.ROOT_CS__CONTRAINTS:
				return ((InternalEList<?>)getContraints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case MinioclcsPackage.ROOT_CS__PACKAGES:
				return getPackages();
			case MinioclcsPackage.ROOT_CS__CONTRAINTS:
				return getContraints();
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
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case MinioclcsPackage.ROOT_CS__PACKAGES:
				getPackages().clear();
				getPackages().addAll((Collection<? extends PackageCS>)newValue);
				return;
			case MinioclcsPackage.ROOT_CS__CONTRAINTS:
				getContraints().clear();
				getContraints().addAll((Collection<? extends ConstraintsDefCS>)newValue);
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
  public void eUnset(int featureID)
  {
		switch (featureID) {
			case MinioclcsPackage.ROOT_CS__PACKAGES:
				getPackages().clear();
				return;
			case MinioclcsPackage.ROOT_CS__CONTRAINTS:
				getContraints().clear();
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
  public boolean eIsSet(int featureID)
  {
		switch (featureID) {
			case MinioclcsPackage.ROOT_CS__PACKAGES:
				return packages != null && !packages.isEmpty();
			case MinioclcsPackage.ROOT_CS__CONTRAINTS:
				return contraints != null && !contraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RootCSImpl
