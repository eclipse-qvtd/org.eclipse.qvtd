/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGClassImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGParameterImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGVariableImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.ocl.examples.codegen.cse.AbstractPlace;
import org.eclipse.ocl.examples.codegen.cse.OuterStackPlace;
import org.eclipse.ocl.pivot.ids.TypeId;
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
public class CGMappingImpl extends CGValuedElementImpl implements CGMapping {
	/**
	 * The number of structural features of the '<em>CG Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CG_MAPPING_FEATURE_COUNT = CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 6;

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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0, oldOwnedBody, newOwnedBody);
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
				msgs = ((InternalEObject)ownedBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0), null, msgs);
			if (newOwnedBody != null)
				msgs = ((InternalEObject)newOwnedBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0), null, msgs);
			msgs = basicSetOwnedBody(newOwnedBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0, newOwnedBody, newOwnedBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<CGConnectionAssignment> getOwnedConnectionAssignments() {
		if (ownedConnectionAssignments == null) {
			ownedConnectionAssignments = new EObjectContainmentWithInverseEList<CGConnectionAssignment>(CGConnectionAssignment.class, this, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 2);
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
			ownedGuardVariables = new EObjectContainmentWithInverseEList<CGGuardVariable>(CGGuardVariable.class, this, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 2, CGParameterImpl.CG_PARAMETER_FEATURE_COUNT + 0);
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
			ownedRealizedVariables = new EObjectContainmentWithInverseEList<CGRealizedVariable>(CGRealizedVariable.class, this, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 3, CGVariableImpl.CG_VARIABLE_FEATURE_COUNT + 1);
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
		if (eContainerFeatureID() != (CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 4)) return null;
		return (CGTransformation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTransformation(CGTransformation newOwningTransformation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTransformation, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 4, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTransformation(CGTransformation newOwningTransformation) {
		if (newOwningTransformation != eInternalContainer() || (eContainerFeatureID() != (CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 4) && newOwningTransformation != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTransformation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTransformation != null)
				msgs = ((InternalEObject)newOwningTransformation).eInverseAdd(this, CGClassImpl.CG_CLASS_FEATURE_COUNT + 0, CGTransformation.class, msgs);
			msgs = basicSetOwningTransformation(newOwningTransformation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 4, newOwningTransformation, newOwningTransformation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 5, oldUseClass, useClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (useClass: ");
		result.append(useClass);
		result.append(')');
		return result.toString();
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
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedConnectionAssignments()).basicAdd(otherEnd, msgs);
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 2:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedGuardVariables()).basicAdd(otherEnd, msgs);
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 3:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRealizedVariables()).basicAdd(otherEnd, msgs);
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 4:
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
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0:
				return basicSetOwnedBody(null, msgs);
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1:
				return ((InternalEList<?>)getOwnedConnectionAssignments()).basicRemove(otherEnd, msgs);
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 2:
				return ((InternalEList<?>)getOwnedGuardVariables()).basicRemove(otherEnd, msgs);
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 3:
				return ((InternalEList<?>)getOwnedRealizedVariables()).basicRemove(otherEnd, msgs);
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 4:
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
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 4:
				return eInternalContainer().eInverseRemove(this, CGClassImpl.CG_CLASS_FEATURE_COUNT + 0, CGTransformation.class, msgs);
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
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0:
				return getOwnedBody();
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1:
				return getOwnedConnectionAssignments();
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 2:
				return getOwnedGuardVariables();
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 3:
				return getOwnedRealizedVariables();
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 4:
				return getOwningTransformation();
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 5:
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
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0:
				setOwnedBody((CGValuedElement)newValue);
				return;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1:
				getOwnedConnectionAssignments().clear();
				getOwnedConnectionAssignments().addAll((Collection<? extends CGConnectionAssignment>)newValue);
				return;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 2:
				getOwnedGuardVariables().clear();
				getOwnedGuardVariables().addAll((Collection<? extends CGGuardVariable>)newValue);
				return;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 3:
				getOwnedRealizedVariables().clear();
				getOwnedRealizedVariables().addAll((Collection<? extends CGRealizedVariable>)newValue);
				return;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 4:
				setOwningTransformation((CGTransformation)newValue);
				return;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 5:
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
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0:
				setOwnedBody((CGValuedElement)null);
				return;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1:
				getOwnedConnectionAssignments().clear();
				return;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 2:
				getOwnedGuardVariables().clear();
				return;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 3:
				getOwnedRealizedVariables().clear();
				return;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 4:
				setOwningTransformation((CGTransformation)null);
				return;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 5:
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
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0:
				return ownedBody != null;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1:
				return ownedConnectionAssignments != null && !ownedConnectionAssignments.isEmpty();
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 2:
				return ownedGuardVariables != null && !ownedGuardVariables.isEmpty();
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 3:
				return ownedRealizedVariables != null && !ownedRealizedVariables.isEmpty();
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 4:
				return getOwningTransformation() != null;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 5:
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
		if (visitor instanceof QVTiCGModelVisitor) {
			return (R) ((QVTiCGModelVisitor<?>)visitor).visitCGMapping(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable TypeId getASTypeId() {
		return TypeId.BOOLEAN;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable EClassifier getEcoreClassifier() {
		return null;
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
	public boolean isBoxed() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isConstant() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isContext() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isEcore() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable Boolean isEquivalentToInternal(@NonNull CGValuedElement thatValue) {
		throw new UnsupportedOperationException(getClass().getName() + ".isEquivalentToInternal()");
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isInlined() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isUnboxed() {
		return true;
	}

} //CGMappingImpl
