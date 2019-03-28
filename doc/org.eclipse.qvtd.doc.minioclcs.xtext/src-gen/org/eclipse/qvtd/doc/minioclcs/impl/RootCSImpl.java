/**
 * generated by Xtext 2.16.0
 */
package org.eclipse.qvtd.doc.minioclcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.doc.minioclcs.ConstraintsDefCS;
import org.eclipse.qvtd.doc.minioclcs.ImportCS;
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
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.RootCSImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.RootCSImpl#getPackages <em>Packages</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.RootCSImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RootCSImpl extends CSTraceImpl implements RootCS
{
  /**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
  protected EList<ImportCS> imports;

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
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
  protected EList<ConstraintsDefCS> constraints;

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
  @Override
  public EList<ImportCS> getImports()
  {
		if (imports == null) {
			imports = new EObjectContainmentEList<ImportCS>(ImportCS.class, this, MinioclcsPackage.ROOT_CS__IMPORTS);
		}
		return imports;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
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
  @Override
  public EList<ConstraintsDefCS> getConstraints()
  {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<ConstraintsDefCS>(ConstraintsDefCS.class, this, MinioclcsPackage.ROOT_CS__CONSTRAINTS);
		}
		return constraints;
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
			case MinioclcsPackage.ROOT_CS__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case MinioclcsPackage.ROOT_CS__PACKAGES:
				return ((InternalEList<?>)getPackages()).basicRemove(otherEnd, msgs);
			case MinioclcsPackage.ROOT_CS__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
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
			case MinioclcsPackage.ROOT_CS__IMPORTS:
				return getImports();
			case MinioclcsPackage.ROOT_CS__PACKAGES:
				return getPackages();
			case MinioclcsPackage.ROOT_CS__CONSTRAINTS:
				return getConstraints();
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
			case MinioclcsPackage.ROOT_CS__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends ImportCS>)newValue);
				return;
			case MinioclcsPackage.ROOT_CS__PACKAGES:
				getPackages().clear();
				getPackages().addAll((Collection<? extends PackageCS>)newValue);
				return;
			case MinioclcsPackage.ROOT_CS__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends ConstraintsDefCS>)newValue);
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
			case MinioclcsPackage.ROOT_CS__IMPORTS:
				getImports().clear();
				return;
			case MinioclcsPackage.ROOT_CS__PACKAGES:
				getPackages().clear();
				return;
			case MinioclcsPackage.ROOT_CS__CONSTRAINTS:
				getConstraints().clear();
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
			case MinioclcsPackage.ROOT_CS__IMPORTS:
				return imports != null && !imports.isEmpty();
			case MinioclcsPackage.ROOT_CS__PACKAGES:
				return packages != null && !packages.isEmpty();
			case MinioclcsPackage.ROOT_CS__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RootCSImpl
