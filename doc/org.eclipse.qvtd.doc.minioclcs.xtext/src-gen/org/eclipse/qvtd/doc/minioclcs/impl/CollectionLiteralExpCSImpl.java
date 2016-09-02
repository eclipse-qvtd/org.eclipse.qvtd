/**
 * generated by Xtext 2.10.0
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

import org.eclipse.qvtd.doc.minioclcs.CollectionKindCS;
import org.eclipse.qvtd.doc.minioclcs.CollectionLiteralExpCS;
import org.eclipse.qvtd.doc.minioclcs.CollectionLiteralPartCS;
import org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.CollectionLiteralExpCSImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.CollectionLiteralExpCSImpl#getParts <em>Parts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionLiteralExpCSImpl extends LiteralExpCSImpl implements CollectionLiteralExpCS
{
  /**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
  protected static final CollectionKindCS KIND_EDEFAULT = CollectionKindCS.COLLECTION;

  /**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
  protected CollectionKindCS kind = KIND_EDEFAULT;

  /**
	 * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getParts()
	 * @generated
	 * @ordered
	 */
  protected EList<CollectionLiteralPartCS> parts;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected CollectionLiteralExpCSImpl()
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
		return MinioclcsPackage.Literals.COLLECTION_LITERAL_EXP_CS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CollectionKindCS getKind()
  {
		return kind;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setKind(CollectionKindCS newKind)
  {
		CollectionKindCS oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinioclcsPackage.COLLECTION_LITERAL_EXP_CS__KIND, oldKind, kind));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<CollectionLiteralPartCS> getParts()
  {
		if (parts == null) {
			parts = new EObjectContainmentEList<CollectionLiteralPartCS>(CollectionLiteralPartCS.class, this, MinioclcsPackage.COLLECTION_LITERAL_EXP_CS__PARTS);
		}
		return parts;
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
			case MinioclcsPackage.COLLECTION_LITERAL_EXP_CS__PARTS:
				return ((InternalEList<?>)getParts()).basicRemove(otherEnd, msgs);
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
			case MinioclcsPackage.COLLECTION_LITERAL_EXP_CS__KIND:
				return getKind();
			case MinioclcsPackage.COLLECTION_LITERAL_EXP_CS__PARTS:
				return getParts();
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
			case MinioclcsPackage.COLLECTION_LITERAL_EXP_CS__KIND:
				setKind((CollectionKindCS)newValue);
				return;
			case MinioclcsPackage.COLLECTION_LITERAL_EXP_CS__PARTS:
				getParts().clear();
				getParts().addAll((Collection<? extends CollectionLiteralPartCS>)newValue);
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
			case MinioclcsPackage.COLLECTION_LITERAL_EXP_CS__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case MinioclcsPackage.COLLECTION_LITERAL_EXP_CS__PARTS:
				getParts().clear();
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
			case MinioclcsPackage.COLLECTION_LITERAL_EXP_CS__KIND:
				return kind != KIND_EDEFAULT;
			case MinioclcsPackage.COLLECTION_LITERAL_EXP_CS__PARTS:
				return parts != null && !parts.isEmpty();
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //CollectionLiteralExpCSImpl