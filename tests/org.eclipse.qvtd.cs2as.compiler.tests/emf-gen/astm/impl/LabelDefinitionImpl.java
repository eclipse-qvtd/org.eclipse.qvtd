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
import astm.LabelDefinition;
import astm.LabelType;
import astm.Name;

import astm.util.Visitor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Label Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.LabelDefinitionImpl#getLabelName <em>Label Name</em>}</li>
 *   <li>{@link astm.impl.LabelDefinitionImpl#getLabelType <em>Label Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LabelDefinitionImpl extends DefinitionObjectImpl implements LabelDefinition {
	/**
	 * The cached value of the '{@link #getLabelName() <em>Label Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelName()
	 * @generated
	 * @ordered
	 */
	protected Name labelName;

	/**
	 * The cached value of the '{@link #getLabelType() <em>Label Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelType()
	 * @generated
	 * @ordered
	 */
	protected LabelType labelType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LabelDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.LABEL_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Name getLabelName() {
		return labelName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLabelName(Name newLabelName, NotificationChain msgs) {
		Name oldLabelName = labelName;
		labelName = newLabelName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.LABEL_DEFINITION__LABEL_NAME, oldLabelName, newLabelName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabelName(Name newLabelName) {
		if (newLabelName != labelName) {
			NotificationChain msgs = null;
			if (labelName != null)
				msgs = ((InternalEObject)labelName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.LABEL_DEFINITION__LABEL_NAME, null, msgs);
			if (newLabelName != null)
				msgs = ((InternalEObject)newLabelName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.LABEL_DEFINITION__LABEL_NAME, null, msgs);
			msgs = basicSetLabelName(newLabelName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.LABEL_DEFINITION__LABEL_NAME, newLabelName, newLabelName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelType getLabelType() {
		return labelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLabelType(LabelType newLabelType, NotificationChain msgs) {
		LabelType oldLabelType = labelType;
		labelType = newLabelType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.LABEL_DEFINITION__LABEL_TYPE, oldLabelType, newLabelType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabelType(LabelType newLabelType) {
		if (newLabelType != labelType) {
			NotificationChain msgs = null;
			if (labelType != null)
				msgs = ((InternalEObject)labelType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.LABEL_DEFINITION__LABEL_TYPE, null, msgs);
			if (newLabelType != null)
				msgs = ((InternalEObject)newLabelType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.LABEL_DEFINITION__LABEL_TYPE, null, msgs);
			msgs = basicSetLabelType(newLabelType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.LABEL_DEFINITION__LABEL_TYPE, newLabelType, newLabelType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.LABEL_DEFINITION__LABEL_NAME:
				return basicSetLabelName(null, msgs);
			case AstmPackage.LABEL_DEFINITION__LABEL_TYPE:
				return basicSetLabelType(null, msgs);
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
			case AstmPackage.LABEL_DEFINITION__LABEL_NAME:
				return getLabelName();
			case AstmPackage.LABEL_DEFINITION__LABEL_TYPE:
				return getLabelType();
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
			case AstmPackage.LABEL_DEFINITION__LABEL_NAME:
				setLabelName((Name)newValue);
				return;
			case AstmPackage.LABEL_DEFINITION__LABEL_TYPE:
				setLabelType((LabelType)newValue);
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
			case AstmPackage.LABEL_DEFINITION__LABEL_NAME:
				setLabelName((Name)null);
				return;
			case AstmPackage.LABEL_DEFINITION__LABEL_TYPE:
				setLabelType((LabelType)null);
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
			case AstmPackage.LABEL_DEFINITION__LABEL_NAME:
				return labelName != null;
			case AstmPackage.LABEL_DEFINITION__LABEL_TYPE:
				return labelType != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitLabelDefinition(this);
	}

} //LabelDefinitionImpl
