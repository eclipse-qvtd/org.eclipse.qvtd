/**
 * generated by Xtext 2.12.0
 */
package org.eclipse.qvtd.doc.minioclcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.doc.minioclcs.ClassCS;
import org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage;
import org.eclipse.qvtd.doc.minioclcs.PackageCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.PackageCSImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.PackageCSImpl#getPackages <em>Packages</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.PackageCSImpl#getClasses <em>Classes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PackageCSImpl extends CSTraceImpl implements PackageCS
{
  /**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
  protected static final String NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
  protected String name = NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
  protected EList<ClassCS> classes;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected PackageCSImpl()
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
		return MinioclcsPackage.Literals.PACKAGE_CS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getName()
  {
		return name;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setName(String newName)
  {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinioclcsPackage.PACKAGE_CS__NAME, oldName, name));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<PackageCS> getPackages()
  {
		if (packages == null) {
			packages = new EObjectContainmentEList<PackageCS>(PackageCS.class, this, MinioclcsPackage.PACKAGE_CS__PACKAGES);
		}
		return packages;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<ClassCS> getClasses()
  {
		if (classes == null) {
			classes = new EObjectContainmentEList<ClassCS>(ClassCS.class, this, MinioclcsPackage.PACKAGE_CS__CLASSES);
		}
		return classes;
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
			case MinioclcsPackage.PACKAGE_CS__PACKAGES:
				return ((InternalEList<?>)getPackages()).basicRemove(otherEnd, msgs);
			case MinioclcsPackage.PACKAGE_CS__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
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
			case MinioclcsPackage.PACKAGE_CS__NAME:
				return getName();
			case MinioclcsPackage.PACKAGE_CS__PACKAGES:
				return getPackages();
			case MinioclcsPackage.PACKAGE_CS__CLASSES:
				return getClasses();
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
			case MinioclcsPackage.PACKAGE_CS__NAME:
				setName((String)newValue);
				return;
			case MinioclcsPackage.PACKAGE_CS__PACKAGES:
				getPackages().clear();
				getPackages().addAll((Collection<? extends PackageCS>)newValue);
				return;
			case MinioclcsPackage.PACKAGE_CS__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends ClassCS>)newValue);
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
			case MinioclcsPackage.PACKAGE_CS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MinioclcsPackage.PACKAGE_CS__PACKAGES:
				getPackages().clear();
				return;
			case MinioclcsPackage.PACKAGE_CS__CLASSES:
				getClasses().clear();
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
			case MinioclcsPackage.PACKAGE_CS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MinioclcsPackage.PACKAGE_CS__PACKAGES:
				return packages != null && !packages.isEmpty();
			case MinioclcsPackage.PACKAGE_CS__CLASSES:
				return classes != null && !classes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString()
  {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //PackageCSImpl
