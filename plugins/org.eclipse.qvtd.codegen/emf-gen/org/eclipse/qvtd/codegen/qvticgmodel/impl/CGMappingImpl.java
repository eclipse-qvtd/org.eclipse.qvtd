/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvticgmodel.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGNamedElementImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.ocl.examples.codegen.cse.AbstractPlace;
import org.eclipse.ocl.examples.codegen.cse.OuterStackPlace;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl#getOwnedAssignments <em>Owned Assignments</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl#getOwnedBody <em>Owned Body</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl#getOwnedConnectionAssignments <em>Owned Connection Assignments</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl#getOwnedGuardVariables <em>Owned Guard Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl#getOwnedRealizedVariables <em>Owned Realized Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl#getOwningTransformation <em>Owning Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl#isUseClass <em>Use Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGMappingImpl extends CGNamedElementImpl implements CGMapping {
	/**
	 * The cached value of the '{@link #getOwnedAssignments() <em>Owned Assignments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAssignments()
	 * @generated
	 * @ordered
	 */
	protected EList<CGPropertyAssignment> ownedAssignments;

	/**
	 * The cached value of the '{@link #getOwnedBody() <em>Owned Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBody()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement ownedBody;

	/**
	 * The cached value of the '{@link #getOwnedConnectionAssignments() <em>Owned Connection Assignments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedConnectionAssignments()
	 * @generated
	 * @ordered
	 */
	protected EList<CGConnectionAssignment> ownedConnectionAssignments;

	/**
	 * The cached value of the '{@link #getOwnedGuardVariables() <em>Owned Guard Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedGuardVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<CGGuardVariable> ownedGuardVariables;

	/**
	 * The cached value of the '{@link #getOwnedRealizedVariables() <em>Owned Realized Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRealizedVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<CGRealizedVariable> ownedRealizedVariables;

	/**
	 * The default value of the '{@link #isUseClass() <em>Use Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseClass()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_CLASS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseClass() <em>Use Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseClass()
	 * @generated
	 * @ordered
	 */
	protected boolean useClass = USE_CLASS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTiCGModelPackage.Literals.CG_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<CGPropertyAssignment> getOwnedAssignments() {
		if (ownedAssignments == null) {
			ownedAssignments = new EObjectContainmentWithInverseEList<CGPropertyAssignment>(CGPropertyAssignment.class, this, QVTiCGModelPackage.CG_MAPPING__OWNED_ASSIGNMENTS, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNING_MAPPING);
		}
		return ownedAssignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CGValuedElement getOwnedBody() {
		return ownedBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedBody(CGValuedElement newOwnedBody, NotificationChain msgs) {
		CGValuedElement oldOwnedBody = ownedBody;
		ownedBody = newOwnedBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_MAPPING__OWNED_BODY, oldOwnedBody, newOwnedBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedBody(CGValuedElement newOwnedBody) {
		if (newOwnedBody != ownedBody) {
			NotificationChain msgs = null;
			if (ownedBody != null)
				msgs = ((InternalEObject)ownedBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_MAPPING__OWNED_BODY, null, msgs);
			if (newOwnedBody != null)
				msgs = ((InternalEObject)newOwnedBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_MAPPING__OWNED_BODY, null, msgs);
			msgs = basicSetOwnedBody(newOwnedBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_MAPPING__OWNED_BODY, newOwnedBody, newOwnedBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<CGConnectionAssignment> getOwnedConnectionAssignments() {
		if (ownedConnectionAssignments == null) {
			ownedConnectionAssignments = new EObjectContainmentWithInverseEList<CGConnectionAssignment>(CGConnectionAssignment.class, this, QVTiCGModelPackage.CG_MAPPING__OWNED_CONNECTION_ASSIGNMENTS, QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNING_MAPPING);
		}
		return ownedConnectionAssignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<CGGuardVariable> getOwnedGuardVariables() {
		if (ownedGuardVariables == null) {
			ownedGuardVariables = new EObjectContainmentWithInverseEList<CGGuardVariable>(CGGuardVariable.class, this, QVTiCGModelPackage.CG_MAPPING__OWNED_GUARD_VARIABLES, QVTiCGModelPackage.CG_GUARD_VARIABLE__OWNING_MAPPING);
		}
		return ownedGuardVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<CGRealizedVariable> getOwnedRealizedVariables() {
		if (ownedRealizedVariables == null) {
			ownedRealizedVariables = new EObjectContainmentWithInverseEList<CGRealizedVariable>(CGRealizedVariable.class, this, QVTiCGModelPackage.CG_MAPPING__OWNED_REALIZED_VARIABLES, QVTiCGModelPackage.CG_REALIZED_VARIABLE__OWNING_MAPPING);
		}
		return ownedRealizedVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CGTransformation getOwningTransformation() {
		if (eContainerFeatureID() != QVTiCGModelPackage.CG_MAPPING__OWNING_TRANSFORMATION) return null;
		return (CGTransformation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTransformation(CGTransformation newOwningTransformation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTransformation, QVTiCGModelPackage.CG_MAPPING__OWNING_TRANSFORMATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTransformation(CGTransformation newOwningTransformation) {
		if (newOwningTransformation != eInternalContainer() || (eContainerFeatureID() != QVTiCGModelPackage.CG_MAPPING__OWNING_TRANSFORMATION && newOwningTransformation != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTransformation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTransformation != null)
				msgs = ((InternalEObject)newOwningTransformation).eInverseAdd(this, QVTiCGModelPackage.CG_TRANSFORMATION__OWNED_MAPPINGS, CGTransformation.class, msgs);
			msgs = basicSetOwningTransformation(newOwningTransformation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_MAPPING__OWNING_TRANSFORMATION, newOwningTransformation, newOwningTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isUseClass() {
		return useClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUseClass(boolean newUseClass) {
		boolean oldUseClass = useClass;
		useClass = newUseClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_MAPPING__USE_CLASS, oldUseClass, useClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTiCGModelPackage.CG_MAPPING__OWNED_ASSIGNMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedAssignments()).basicAdd(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING__OWNED_CONNECTION_ASSIGNMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedConnectionAssignments()).basicAdd(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING__OWNED_GUARD_VARIABLES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedGuardVariables()).basicAdd(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING__OWNED_REALIZED_VARIABLES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRealizedVariables()).basicAdd(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING__OWNING_TRANSFORMATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTransformation((CGTransformation)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTiCGModelPackage.CG_MAPPING__OWNED_ASSIGNMENTS:
				return ((InternalEList<?>)getOwnedAssignments()).basicRemove(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING__OWNED_BODY:
				return basicSetOwnedBody(null, msgs);
			case QVTiCGModelPackage.CG_MAPPING__OWNED_CONNECTION_ASSIGNMENTS:
				return ((InternalEList<?>)getOwnedConnectionAssignments()).basicRemove(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING__OWNED_GUARD_VARIABLES:
				return ((InternalEList<?>)getOwnedGuardVariables()).basicRemove(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING__OWNED_REALIZED_VARIABLES:
				return ((InternalEList<?>)getOwnedRealizedVariables()).basicRemove(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING__OWNING_TRANSFORMATION:
				return basicSetOwningTransformation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case QVTiCGModelPackage.CG_MAPPING__OWNING_TRANSFORMATION:
				return eInternalContainer().eInverseRemove(this, QVTiCGModelPackage.CG_TRANSFORMATION__OWNED_MAPPINGS, CGTransformation.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTiCGModelPackage.CG_MAPPING__OWNED_ASSIGNMENTS:
				return getOwnedAssignments();
			case QVTiCGModelPackage.CG_MAPPING__OWNED_BODY:
				return getOwnedBody();
			case QVTiCGModelPackage.CG_MAPPING__OWNED_CONNECTION_ASSIGNMENTS:
				return getOwnedConnectionAssignments();
			case QVTiCGModelPackage.CG_MAPPING__OWNED_GUARD_VARIABLES:
				return getOwnedGuardVariables();
			case QVTiCGModelPackage.CG_MAPPING__OWNED_REALIZED_VARIABLES:
				return getOwnedRealizedVariables();
			case QVTiCGModelPackage.CG_MAPPING__OWNING_TRANSFORMATION:
				return getOwningTransformation();
			case QVTiCGModelPackage.CG_MAPPING__USE_CLASS:
				return isUseClass();
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
			case QVTiCGModelPackage.CG_MAPPING__OWNED_ASSIGNMENTS:
				getOwnedAssignments().clear();
				getOwnedAssignments().addAll((Collection<? extends CGPropertyAssignment>)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING__OWNED_BODY:
				setOwnedBody((CGValuedElement)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING__OWNED_CONNECTION_ASSIGNMENTS:
				getOwnedConnectionAssignments().clear();
				getOwnedConnectionAssignments().addAll((Collection<? extends CGConnectionAssignment>)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING__OWNED_GUARD_VARIABLES:
				getOwnedGuardVariables().clear();
				getOwnedGuardVariables().addAll((Collection<? extends CGGuardVariable>)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING__OWNED_REALIZED_VARIABLES:
				getOwnedRealizedVariables().clear();
				getOwnedRealizedVariables().addAll((Collection<? extends CGRealizedVariable>)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING__OWNING_TRANSFORMATION:
				setOwningTransformation((CGTransformation)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING__USE_CLASS:
				setUseClass((Boolean)newValue);
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
			case QVTiCGModelPackage.CG_MAPPING__OWNED_ASSIGNMENTS:
				getOwnedAssignments().clear();
				return;
			case QVTiCGModelPackage.CG_MAPPING__OWNED_BODY:
				setOwnedBody((CGValuedElement)null);
				return;
			case QVTiCGModelPackage.CG_MAPPING__OWNED_CONNECTION_ASSIGNMENTS:
				getOwnedConnectionAssignments().clear();
				return;
			case QVTiCGModelPackage.CG_MAPPING__OWNED_GUARD_VARIABLES:
				getOwnedGuardVariables().clear();
				return;
			case QVTiCGModelPackage.CG_MAPPING__OWNED_REALIZED_VARIABLES:
				getOwnedRealizedVariables().clear();
				return;
			case QVTiCGModelPackage.CG_MAPPING__OWNING_TRANSFORMATION:
				setOwningTransformation((CGTransformation)null);
				return;
			case QVTiCGModelPackage.CG_MAPPING__USE_CLASS:
				setUseClass(USE_CLASS_EDEFAULT);
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
			case QVTiCGModelPackage.CG_MAPPING__OWNED_ASSIGNMENTS:
				return ownedAssignments != null && !ownedAssignments.isEmpty();
			case QVTiCGModelPackage.CG_MAPPING__OWNED_BODY:
				return ownedBody != null;
			case QVTiCGModelPackage.CG_MAPPING__OWNED_CONNECTION_ASSIGNMENTS:
				return ownedConnectionAssignments != null && !ownedConnectionAssignments.isEmpty();
			case QVTiCGModelPackage.CG_MAPPING__OWNED_GUARD_VARIABLES:
				return ownedGuardVariables != null && !ownedGuardVariables.isEmpty();
			case QVTiCGModelPackage.CG_MAPPING__OWNED_REALIZED_VARIABLES:
				return ownedRealizedVariables != null && !ownedRealizedVariables.isEmpty();
			case QVTiCGModelPackage.CG_MAPPING__OWNING_TRANSFORMATION:
				return getOwningTransformation() != null;
			case QVTiCGModelPackage.CG_MAPPING__USE_CLASS:
				return useClass != USE_CLASS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return (R) ((QVTiCGModelVisitor<?>)visitor).visitCGMapping(this);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable AbstractPlace getPlace(@NonNull Map<@Nullable CGElement, @NonNull AbstractPlace> element2place) {
		return OuterStackPlace.createOuterStackPlace(element2place, this);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isContext() {
		return true;
	}

} //CGMappingImpl
