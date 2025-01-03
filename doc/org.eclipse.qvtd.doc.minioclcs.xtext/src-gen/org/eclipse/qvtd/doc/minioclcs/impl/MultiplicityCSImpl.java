/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 * generated by Xtext 2.16.0
 */
package org.eclipse.qvtd.doc.minioclcs.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage;
import org.eclipse.qvtd.doc.minioclcs.MultiplicityCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicity CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.MultiplicityCSImpl#isOpt <em>Opt</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.MultiplicityCSImpl#isMult <em>Mult</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.MultiplicityCSImpl#getMandatory <em>Mandatory</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.MultiplicityCSImpl#getLowerInt <em>Lower Int</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.MultiplicityCSImpl#getUpperInt <em>Upper Int</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.MultiplicityCSImpl#isUpperMult <em>Upper Mult</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MultiplicityCSImpl extends CSTraceImpl implements MultiplicityCS
{
  /**
	 * The default value of the '{@link #isOpt() <em>Opt</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isOpt()
	 * @generated
	 * @ordered
	 */
  protected static final boolean OPT_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isOpt() <em>Opt</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isOpt()
	 * @generated
	 * @ordered
	 */
  protected boolean opt = OPT_EDEFAULT;

  /**
	 * The default value of the '{@link #isMult() <em>Mult</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isMult()
	 * @generated
	 * @ordered
	 */
  protected static final boolean MULT_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isMult() <em>Mult</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isMult()
	 * @generated
	 * @ordered
	 */
  protected boolean mult = MULT_EDEFAULT;

  /**
	 * The default value of the '{@link #getMandatory() <em>Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMandatory()
	 * @generated
	 * @ordered
	 */
  protected static final int MANDATORY_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getMandatory() <em>Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMandatory()
	 * @generated
	 * @ordered
	 */
  protected int mandatory = MANDATORY_EDEFAULT;

  /**
	 * The default value of the '{@link #getLowerInt() <em>Lower Int</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLowerInt()
	 * @generated
	 * @ordered
	 */
  protected static final int LOWER_INT_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getLowerInt() <em>Lower Int</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLowerInt()
	 * @generated
	 * @ordered
	 */
  protected int lowerInt = LOWER_INT_EDEFAULT;

  /**
	 * The default value of the '{@link #getUpperInt() <em>Upper Int</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getUpperInt()
	 * @generated
	 * @ordered
	 */
  protected static final int UPPER_INT_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getUpperInt() <em>Upper Int</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getUpperInt()
	 * @generated
	 * @ordered
	 */
  protected int upperInt = UPPER_INT_EDEFAULT;

  /**
	 * The default value of the '{@link #isUpperMult() <em>Upper Mult</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isUpperMult()
	 * @generated
	 * @ordered
	 */
  protected static final boolean UPPER_MULT_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isUpperMult() <em>Upper Mult</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isUpperMult()
	 * @generated
	 * @ordered
	 */
  protected boolean upperMult = UPPER_MULT_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected MultiplicityCSImpl()
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
		return MinioclcsPackage.Literals.MULTIPLICITY_CS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public boolean isOpt()
  {
		return opt;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setOpt(boolean newOpt)
  {
		boolean oldOpt = opt;
		opt = newOpt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinioclcsPackage.MULTIPLICITY_CS__OPT, oldOpt, opt));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public boolean isMult()
  {
		return mult;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setMult(boolean newMult)
  {
		boolean oldMult = mult;
		mult = newMult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinioclcsPackage.MULTIPLICITY_CS__MULT, oldMult, mult));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public int getMandatory()
  {
		return mandatory;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setMandatory(int newMandatory)
  {
		int oldMandatory = mandatory;
		mandatory = newMandatory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinioclcsPackage.MULTIPLICITY_CS__MANDATORY, oldMandatory, mandatory));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public int getLowerInt()
  {
		return lowerInt;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setLowerInt(int newLowerInt)
  {
		int oldLowerInt = lowerInt;
		lowerInt = newLowerInt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinioclcsPackage.MULTIPLICITY_CS__LOWER_INT, oldLowerInt, lowerInt));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public int getUpperInt()
  {
		return upperInt;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setUpperInt(int newUpperInt)
  {
		int oldUpperInt = upperInt;
		upperInt = newUpperInt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinioclcsPackage.MULTIPLICITY_CS__UPPER_INT, oldUpperInt, upperInt));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public boolean isUpperMult()
  {
		return upperMult;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setUpperMult(boolean newUpperMult)
  {
		boolean oldUpperMult = upperMult;
		upperMult = newUpperMult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinioclcsPackage.MULTIPLICITY_CS__UPPER_MULT, oldUpperMult, upperMult));
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
			case MinioclcsPackage.MULTIPLICITY_CS__OPT:
				return isOpt();
			case MinioclcsPackage.MULTIPLICITY_CS__MULT:
				return isMult();
			case MinioclcsPackage.MULTIPLICITY_CS__MANDATORY:
				return getMandatory();
			case MinioclcsPackage.MULTIPLICITY_CS__LOWER_INT:
				return getLowerInt();
			case MinioclcsPackage.MULTIPLICITY_CS__UPPER_INT:
				return getUpperInt();
			case MinioclcsPackage.MULTIPLICITY_CS__UPPER_MULT:
				return isUpperMult();
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
			case MinioclcsPackage.MULTIPLICITY_CS__OPT:
				setOpt((Boolean)newValue);
				return;
			case MinioclcsPackage.MULTIPLICITY_CS__MULT:
				setMult((Boolean)newValue);
				return;
			case MinioclcsPackage.MULTIPLICITY_CS__MANDATORY:
				setMandatory((Integer)newValue);
				return;
			case MinioclcsPackage.MULTIPLICITY_CS__LOWER_INT:
				setLowerInt((Integer)newValue);
				return;
			case MinioclcsPackage.MULTIPLICITY_CS__UPPER_INT:
				setUpperInt((Integer)newValue);
				return;
			case MinioclcsPackage.MULTIPLICITY_CS__UPPER_MULT:
				setUpperMult((Boolean)newValue);
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
			case MinioclcsPackage.MULTIPLICITY_CS__OPT:
				setOpt(OPT_EDEFAULT);
				return;
			case MinioclcsPackage.MULTIPLICITY_CS__MULT:
				setMult(MULT_EDEFAULT);
				return;
			case MinioclcsPackage.MULTIPLICITY_CS__MANDATORY:
				setMandatory(MANDATORY_EDEFAULT);
				return;
			case MinioclcsPackage.MULTIPLICITY_CS__LOWER_INT:
				setLowerInt(LOWER_INT_EDEFAULT);
				return;
			case MinioclcsPackage.MULTIPLICITY_CS__UPPER_INT:
				setUpperInt(UPPER_INT_EDEFAULT);
				return;
			case MinioclcsPackage.MULTIPLICITY_CS__UPPER_MULT:
				setUpperMult(UPPER_MULT_EDEFAULT);
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
			case MinioclcsPackage.MULTIPLICITY_CS__OPT:
				return opt != OPT_EDEFAULT;
			case MinioclcsPackage.MULTIPLICITY_CS__MULT:
				return mult != MULT_EDEFAULT;
			case MinioclcsPackage.MULTIPLICITY_CS__MANDATORY:
				return mandatory != MANDATORY_EDEFAULT;
			case MinioclcsPackage.MULTIPLICITY_CS__LOWER_INT:
				return lowerInt != LOWER_INT_EDEFAULT;
			case MinioclcsPackage.MULTIPLICITY_CS__UPPER_INT:
				return upperInt != UPPER_INT_EDEFAULT;
			case MinioclcsPackage.MULTIPLICITY_CS__UPPER_MULT:
				return upperMult != UPPER_MULT_EDEFAULT;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (opt: ");
		result.append(opt);
		result.append(", mult: ");
		result.append(mult);
		result.append(", mandatory: ");
		result.append(mandatory);
		result.append(", lowerInt: ");
		result.append(lowerInt);
		result.append(", upperInt: ");
		result.append(upperInt);
		result.append(", upperMult: ");
		result.append(upperMult);
		result.append(')');
		return result.toString();
	}

} //MultiplicityCSImpl
