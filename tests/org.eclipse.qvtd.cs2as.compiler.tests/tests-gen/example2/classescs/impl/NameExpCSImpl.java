/**
 */
package example2.classescs.impl;

import example2.classescs.ClassescsPackage;
import example2.classescs.NameExpCS;
import example2.classescs.PathNameCS;
import example2.classescs.RoundedBracketClause;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Name Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example2.classescs.impl.NameExpCSImpl#getName <em>Name</em>}</li>
 *   <li>{@link example2.classescs.impl.NameExpCSImpl#getRoundedBrackets <em>Rounded Brackets</em>}</li>
 *   <li>{@link example2.classescs.impl.NameExpCSImpl#getOwnedNameExp <em>Owned Name Exp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NameExpCSImpl extends ElementCSImpl implements NameExpCS {
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS name;

	/**
	 * The cached value of the '{@link #getRoundedBrackets() <em>Rounded Brackets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoundedBrackets()
	 * @generated
	 * @ordered
	 */
	protected RoundedBracketClause roundedBrackets;

	/**
	 * The cached value of the '{@link #getOwnedNameExp() <em>Owned Name Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedNameExp()
	 * @generated
	 * @ordered
	 */
	protected NameExpCS ownedNameExp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NameExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassescsPackage.Literals.NAME_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetName(PathNameCS newName, NotificationChain msgs) {
		PathNameCS oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassescsPackage.NAME_EXP_CS__NAME, oldName, newName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(PathNameCS newName) {
		if (newName != name) {
			NotificationChain msgs = null;
			if (name != null)
				msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassescsPackage.NAME_EXP_CS__NAME, null, msgs);
			if (newName != null)
				msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ClassescsPackage.NAME_EXP_CS__NAME, null, msgs);
			msgs = basicSetName(newName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassescsPackage.NAME_EXP_CS__NAME, newName, newName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoundedBracketClause getRoundedBrackets() {
		return roundedBrackets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoundedBrackets(RoundedBracketClause newRoundedBrackets, NotificationChain msgs) {
		RoundedBracketClause oldRoundedBrackets = roundedBrackets;
		roundedBrackets = newRoundedBrackets;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassescsPackage.NAME_EXP_CS__ROUNDED_BRACKETS, oldRoundedBrackets, newRoundedBrackets);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoundedBrackets(RoundedBracketClause newRoundedBrackets) {
		if (newRoundedBrackets != roundedBrackets) {
			NotificationChain msgs = null;
			if (roundedBrackets != null)
				msgs = ((InternalEObject)roundedBrackets).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassescsPackage.NAME_EXP_CS__ROUNDED_BRACKETS, null, msgs);
			if (newRoundedBrackets != null)
				msgs = ((InternalEObject)newRoundedBrackets).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ClassescsPackage.NAME_EXP_CS__ROUNDED_BRACKETS, null, msgs);
			msgs = basicSetRoundedBrackets(newRoundedBrackets, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassescsPackage.NAME_EXP_CS__ROUNDED_BRACKETS, newRoundedBrackets, newRoundedBrackets));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpCS getOwnedNameExp() {
		return ownedNameExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedNameExp(NameExpCS newOwnedNameExp, NotificationChain msgs) {
		NameExpCS oldOwnedNameExp = ownedNameExp;
		ownedNameExp = newOwnedNameExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassescsPackage.NAME_EXP_CS__OWNED_NAME_EXP, oldOwnedNameExp, newOwnedNameExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedNameExp(NameExpCS newOwnedNameExp) {
		if (newOwnedNameExp != ownedNameExp) {
			NotificationChain msgs = null;
			if (ownedNameExp != null)
				msgs = ((InternalEObject)ownedNameExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassescsPackage.NAME_EXP_CS__OWNED_NAME_EXP, null, msgs);
			if (newOwnedNameExp != null)
				msgs = ((InternalEObject)newOwnedNameExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ClassescsPackage.NAME_EXP_CS__OWNED_NAME_EXP, null, msgs);
			msgs = basicSetOwnedNameExp(newOwnedNameExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassescsPackage.NAME_EXP_CS__OWNED_NAME_EXP, newOwnedNameExp, newOwnedNameExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassescsPackage.NAME_EXP_CS__NAME:
				return basicSetName(null, msgs);
			case ClassescsPackage.NAME_EXP_CS__ROUNDED_BRACKETS:
				return basicSetRoundedBrackets(null, msgs);
			case ClassescsPackage.NAME_EXP_CS__OWNED_NAME_EXP:
				return basicSetOwnedNameExp(null, msgs);
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
			case ClassescsPackage.NAME_EXP_CS__NAME:
				return getName();
			case ClassescsPackage.NAME_EXP_CS__ROUNDED_BRACKETS:
				return getRoundedBrackets();
			case ClassescsPackage.NAME_EXP_CS__OWNED_NAME_EXP:
				return getOwnedNameExp();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ClassescsPackage.NAME_EXP_CS__NAME:
				setName((PathNameCS)newValue);
				return;
			case ClassescsPackage.NAME_EXP_CS__ROUNDED_BRACKETS:
				setRoundedBrackets((RoundedBracketClause)newValue);
				return;
			case ClassescsPackage.NAME_EXP_CS__OWNED_NAME_EXP:
				setOwnedNameExp((NameExpCS)newValue);
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
			case ClassescsPackage.NAME_EXP_CS__NAME:
				setName((PathNameCS)null);
				return;
			case ClassescsPackage.NAME_EXP_CS__ROUNDED_BRACKETS:
				setRoundedBrackets((RoundedBracketClause)null);
				return;
			case ClassescsPackage.NAME_EXP_CS__OWNED_NAME_EXP:
				setOwnedNameExp((NameExpCS)null);
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
			case ClassescsPackage.NAME_EXP_CS__NAME:
				return name != null;
			case ClassescsPackage.NAME_EXP_CS__ROUNDED_BRACKETS:
				return roundedBrackets != null;
			case ClassescsPackage.NAME_EXP_CS__OWNED_NAME_EXP:
				return ownedNameExp != null;
		}
		return super.eIsSet(featureID);
	}


} //NameExpCSImpl
