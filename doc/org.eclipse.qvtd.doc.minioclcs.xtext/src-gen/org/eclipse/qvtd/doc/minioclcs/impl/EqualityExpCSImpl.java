/**
 * generated by Xtext 2.10.0
 */
package org.eclipse.qvtd.doc.minioclcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.qvtd.doc.minioclcs.CallExpCS;
import org.eclipse.qvtd.doc.minioclcs.EqualityExpCS;
import org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equality Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.EqualityExpCSImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.EqualityExpCSImpl#getOpName <em>Op Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.EqualityExpCSImpl#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EqualityExpCSImpl extends ExpCSImpl implements EqualityExpCS
{
  /**
	 * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLeft()
	 * @generated
	 * @ordered
	 */
  protected EqualityExpCS left;

  /**
	 * The default value of the '{@link #getOpName() <em>Op Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOpName()
	 * @generated
	 * @ordered
	 */
  protected static final String OP_NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getOpName() <em>Op Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOpName()
	 * @generated
	 * @ordered
	 */
  protected String opName = OP_NAME_EDEFAULT;

  /**
	 * The cached value of the '{@link #getRight() <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRight()
	 * @generated
	 * @ordered
	 */
  protected CallExpCS right;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EqualityExpCSImpl()
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
		return MinioclcsPackage.Literals.EQUALITY_EXP_CS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EqualityExpCS getLeft()
  {
		return left;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetLeft(EqualityExpCS newLeft, NotificationChain msgs)
  {
		EqualityExpCS oldLeft = left;
		left = newLeft;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MinioclcsPackage.EQUALITY_EXP_CS__LEFT, oldLeft, newLeft);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLeft(EqualityExpCS newLeft)
  {
		if (newLeft != left) {
			NotificationChain msgs = null;
			if (left != null)
				msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MinioclcsPackage.EQUALITY_EXP_CS__LEFT, null, msgs);
			if (newLeft != null)
				msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MinioclcsPackage.EQUALITY_EXP_CS__LEFT, null, msgs);
			msgs = basicSetLeft(newLeft, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinioclcsPackage.EQUALITY_EXP_CS__LEFT, newLeft, newLeft));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getOpName()
  {
		return opName;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setOpName(String newOpName)
  {
		String oldOpName = opName;
		opName = newOpName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinioclcsPackage.EQUALITY_EXP_CS__OP_NAME, oldOpName, opName));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CallExpCS getRight()
  {
		return right;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetRight(CallExpCS newRight, NotificationChain msgs)
  {
		CallExpCS oldRight = right;
		right = newRight;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MinioclcsPackage.EQUALITY_EXP_CS__RIGHT, oldRight, newRight);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setRight(CallExpCS newRight)
  {
		if (newRight != right) {
			NotificationChain msgs = null;
			if (right != null)
				msgs = ((InternalEObject)right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MinioclcsPackage.EQUALITY_EXP_CS__RIGHT, null, msgs);
			if (newRight != null)
				msgs = ((InternalEObject)newRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MinioclcsPackage.EQUALITY_EXP_CS__RIGHT, null, msgs);
			msgs = basicSetRight(newRight, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinioclcsPackage.EQUALITY_EXP_CS__RIGHT, newRight, newRight));
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
			case MinioclcsPackage.EQUALITY_EXP_CS__LEFT:
				return basicSetLeft(null, msgs);
			case MinioclcsPackage.EQUALITY_EXP_CS__RIGHT:
				return basicSetRight(null, msgs);
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
			case MinioclcsPackage.EQUALITY_EXP_CS__LEFT:
				return getLeft();
			case MinioclcsPackage.EQUALITY_EXP_CS__OP_NAME:
				return getOpName();
			case MinioclcsPackage.EQUALITY_EXP_CS__RIGHT:
				return getRight();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case MinioclcsPackage.EQUALITY_EXP_CS__LEFT:
				setLeft((EqualityExpCS)newValue);
				return;
			case MinioclcsPackage.EQUALITY_EXP_CS__OP_NAME:
				setOpName((String)newValue);
				return;
			case MinioclcsPackage.EQUALITY_EXP_CS__RIGHT:
				setRight((CallExpCS)newValue);
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
			case MinioclcsPackage.EQUALITY_EXP_CS__LEFT:
				setLeft((EqualityExpCS)null);
				return;
			case MinioclcsPackage.EQUALITY_EXP_CS__OP_NAME:
				setOpName(OP_NAME_EDEFAULT);
				return;
			case MinioclcsPackage.EQUALITY_EXP_CS__RIGHT:
				setRight((CallExpCS)null);
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
			case MinioclcsPackage.EQUALITY_EXP_CS__LEFT:
				return left != null;
			case MinioclcsPackage.EQUALITY_EXP_CS__OP_NAME:
				return OP_NAME_EDEFAULT == null ? opName != null : !OP_NAME_EDEFAULT.equals(opName);
			case MinioclcsPackage.EQUALITY_EXP_CS__RIGHT:
				return right != null;
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
		result.append(" (opName: ");
		result.append(opName);
		result.append(')');
		return result.toString();
	}

} //EqualityExpCSImpl