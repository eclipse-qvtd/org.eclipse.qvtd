/**
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 */
package astm.impl;

import astm.AstmPackage;
import astm.FunctionMemberAttributes;
import astm.VirtualSpecification;

import astm.util.Visitor;

import java.lang.Boolean;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Member Attributes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.FunctionMemberAttributesImpl#isIsFriend <em>Is Friend</em>}</li>
 *   <li>{@link astm.impl.FunctionMemberAttributesImpl#isIsInline <em>Is Inline</em>}</li>
 *   <li>{@link astm.impl.FunctionMemberAttributesImpl#isIsThisConst <em>Is This Const</em>}</li>
 *   <li>{@link astm.impl.FunctionMemberAttributesImpl#getVirtualSpecifier <em>Virtual Specifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionMemberAttributesImpl extends MinimalEObjectImpl.Container implements FunctionMemberAttributes {
	/**
	 * The default value of the '{@link #isIsFriend() <em>Is Friend</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsFriend()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_FRIEND_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsFriend() <em>Is Friend</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsFriend()
	 * @generated
	 * @ordered
	 */
	protected boolean isFriend = IS_FRIEND_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsInline() <em>Is Inline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInline()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INLINE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsInline() <em>Is Inline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInline()
	 * @generated
	 * @ordered
	 */
	protected boolean isInline = IS_INLINE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsThisConst() <em>Is This Const</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsThisConst()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_THIS_CONST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsThisConst() <em>Is This Const</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsThisConst()
	 * @generated
	 * @ordered
	 */
	protected boolean isThisConst = IS_THIS_CONST_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVirtualSpecifier() <em>Virtual Specifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtualSpecifier()
	 * @generated
	 * @ordered
	 */
	protected VirtualSpecification virtualSpecifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionMemberAttributesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.FUNCTION_MEMBER_ATTRIBUTES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsFriend() {
		return isFriend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsFriend(boolean newIsFriend) {
		boolean oldIsFriend = isFriend;
		isFriend = newIsFriend;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__IS_FRIEND, oldIsFriend, isFriend));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsInline() {
		return isInline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsInline(boolean newIsInline) {
		boolean oldIsInline = isInline;
		isInline = newIsInline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__IS_INLINE, oldIsInline, isInline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsThisConst() {
		return isThisConst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsThisConst(boolean newIsThisConst) {
		boolean oldIsThisConst = isThisConst;
		isThisConst = newIsThisConst;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__IS_THIS_CONST, oldIsThisConst, isThisConst));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualSpecification getVirtualSpecifier() {
		return virtualSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVirtualSpecifier(VirtualSpecification newVirtualSpecifier, NotificationChain msgs) {
		VirtualSpecification oldVirtualSpecifier = virtualSpecifier;
		virtualSpecifier = newVirtualSpecifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__VIRTUAL_SPECIFIER, oldVirtualSpecifier, newVirtualSpecifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVirtualSpecifier(VirtualSpecification newVirtualSpecifier) {
		if (newVirtualSpecifier != virtualSpecifier) {
			NotificationChain msgs = null;
			if (virtualSpecifier != null)
				msgs = ((InternalEObject)virtualSpecifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__VIRTUAL_SPECIFIER, null, msgs);
			if (newVirtualSpecifier != null)
				msgs = ((InternalEObject)newVirtualSpecifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__VIRTUAL_SPECIFIER, null, msgs);
			msgs = basicSetVirtualSpecifier(newVirtualSpecifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__VIRTUAL_SPECIFIER, newVirtualSpecifier, newVirtualSpecifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__VIRTUAL_SPECIFIER:
				return basicSetVirtualSpecifier(null, msgs);
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
			case AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__IS_FRIEND:
				return isIsFriend();
			case AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__IS_INLINE:
				return isIsInline();
			case AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__IS_THIS_CONST:
				return isIsThisConst();
			case AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__VIRTUAL_SPECIFIER:
				return getVirtualSpecifier();
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
			case AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__IS_FRIEND:
				setIsFriend((Boolean)newValue);
				return;
			case AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__IS_INLINE:
				setIsInline((Boolean)newValue);
				return;
			case AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__IS_THIS_CONST:
				setIsThisConst((Boolean)newValue);
				return;
			case AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__VIRTUAL_SPECIFIER:
				setVirtualSpecifier((VirtualSpecification)newValue);
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
			case AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__IS_FRIEND:
				setIsFriend(IS_FRIEND_EDEFAULT);
				return;
			case AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__IS_INLINE:
				setIsInline(IS_INLINE_EDEFAULT);
				return;
			case AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__IS_THIS_CONST:
				setIsThisConst(IS_THIS_CONST_EDEFAULT);
				return;
			case AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__VIRTUAL_SPECIFIER:
				setVirtualSpecifier((VirtualSpecification)null);
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
			case AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__IS_FRIEND:
				return isFriend != IS_FRIEND_EDEFAULT;
			case AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__IS_INLINE:
				return isInline != IS_INLINE_EDEFAULT;
			case AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__IS_THIS_CONST:
				return isThisConst != IS_THIS_CONST_EDEFAULT;
			case AstmPackage.FUNCTION_MEMBER_ATTRIBUTES__VIRTUAL_SPECIFIER:
				return virtualSpecifier != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isFriend: ");
		result.append(isFriend);
		result.append(", isInline: ");
		result.append(isInline);
		result.append(", isThisConst: ");
		result.append(isThisConst);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitFunctionMemberAttributes(this);
	}

} //FunctionMemberAttributesImpl
