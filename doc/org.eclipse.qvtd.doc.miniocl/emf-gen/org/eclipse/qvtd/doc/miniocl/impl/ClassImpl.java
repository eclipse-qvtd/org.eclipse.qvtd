/**
 */
package org.eclipse.qvtd.doc.miniocl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.doc.miniocl.Constraint;
import org.eclipse.qvtd.doc.miniocl.MiniOCLPackage;
import org.eclipse.qvtd.doc.miniocl.Operation;
import org.eclipse.qvtd.doc.miniocl.Property;
import org.eclipse.qvtd.doc.miniocl.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.impl.ClassImpl#getSuperClass <em>Super Class</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.impl.ClassImpl#getOwnedOperations <em>Owned Operations</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.impl.ClassImpl#getOwnedProperties <em>Owned Properties</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.impl.ClassImpl#getOwnedInvariants <em>Owned Invariants</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassImpl extends NamedElementImpl implements org.eclipse.qvtd.doc.miniocl.Class {
	/**
	 * The cached value of the '{@link #getSuperClass() <em>Super Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClass()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.qvtd.doc.miniocl.Class superClass;

	/**
	 * The cached value of the '{@link #getOwnedOperations() <em>Owned Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> ownedOperations;

	/**
	 * The cached value of the '{@link #getOwnedProperties() <em>Owned Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> ownedProperties;

	/**
	 * The cached value of the '{@link #getOwnedInvariants() <em>Owned Invariants</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedInvariants()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> ownedInvariants;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.qvtd.doc.miniocl.Class getSuperClass() {
		if (superClass != null && superClass.eIsProxy()) {
			InternalEObject oldSuperClass = (InternalEObject)superClass;
			superClass = (org.eclipse.qvtd.doc.miniocl.Class)eResolveProxy(oldSuperClass);
			if (superClass != oldSuperClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniOCLPackage.CLASS__SUPER_CLASS, oldSuperClass, superClass));
			}
		}
		return superClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.qvtd.doc.miniocl.Class basicGetSuperClass() {
		return superClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperClass(org.eclipse.qvtd.doc.miniocl.Class newSuperClass) {
		org.eclipse.qvtd.doc.miniocl.Class oldSuperClass = superClass;
		superClass = newSuperClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.CLASS__SUPER_CLASS, oldSuperClass, superClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operation> getOwnedOperations() {
		if (ownedOperations == null) {
			ownedOperations = new EObjectContainmentWithInverseEList<Operation>(Operation.class, this, MiniOCLPackage.CLASS__OWNED_OPERATIONS, MiniOCLPackage.OPERATION__OWNING_CLASS);
		}
		return ownedOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getOwnedProperties() {
		if (ownedProperties == null) {
			ownedProperties = new EObjectContainmentEList<Property>(Property.class, this, MiniOCLPackage.CLASS__OWNED_PROPERTIES);
		}
		return ownedProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getOwnedInvariants() {
		if (ownedInvariants == null) {
			ownedInvariants = new EObjectContainmentEList<Constraint>(Constraint.class, this, MiniOCLPackage.CLASS__OWNED_INVARIANTS);
		}
		return ownedInvariants;
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
			case MiniOCLPackage.CLASS__OWNED_OPERATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedOperations()).basicAdd(otherEnd, msgs);
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
			case MiniOCLPackage.CLASS__OWNED_OPERATIONS:
				return ((InternalEList<?>)getOwnedOperations()).basicRemove(otherEnd, msgs);
			case MiniOCLPackage.CLASS__OWNED_PROPERTIES:
				return ((InternalEList<?>)getOwnedProperties()).basicRemove(otherEnd, msgs);
			case MiniOCLPackage.CLASS__OWNED_INVARIANTS:
				return ((InternalEList<?>)getOwnedInvariants()).basicRemove(otherEnd, msgs);
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
			case MiniOCLPackage.CLASS__SUPER_CLASS:
				if (resolve) return getSuperClass();
				return basicGetSuperClass();
			case MiniOCLPackage.CLASS__OWNED_OPERATIONS:
				return getOwnedOperations();
			case MiniOCLPackage.CLASS__OWNED_PROPERTIES:
				return getOwnedProperties();
			case MiniOCLPackage.CLASS__OWNED_INVARIANTS:
				return getOwnedInvariants();
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
			case MiniOCLPackage.CLASS__SUPER_CLASS:
				setSuperClass((org.eclipse.qvtd.doc.miniocl.Class)newValue);
				return;
			case MiniOCLPackage.CLASS__OWNED_OPERATIONS:
				getOwnedOperations().clear();
				getOwnedOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case MiniOCLPackage.CLASS__OWNED_PROPERTIES:
				getOwnedProperties().clear();
				getOwnedProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case MiniOCLPackage.CLASS__OWNED_INVARIANTS:
				getOwnedInvariants().clear();
				getOwnedInvariants().addAll((Collection<? extends Constraint>)newValue);
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
			case MiniOCLPackage.CLASS__SUPER_CLASS:
				setSuperClass((org.eclipse.qvtd.doc.miniocl.Class)null);
				return;
			case MiniOCLPackage.CLASS__OWNED_OPERATIONS:
				getOwnedOperations().clear();
				return;
			case MiniOCLPackage.CLASS__OWNED_PROPERTIES:
				getOwnedProperties().clear();
				return;
			case MiniOCLPackage.CLASS__OWNED_INVARIANTS:
				getOwnedInvariants().clear();
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
			case MiniOCLPackage.CLASS__SUPER_CLASS:
				return superClass != null;
			case MiniOCLPackage.CLASS__OWNED_OPERATIONS:
				return ownedOperations != null && !ownedOperations.isEmpty();
			case MiniOCLPackage.CLASS__OWNED_PROPERTIES:
				return ownedProperties != null && !ownedProperties.isEmpty();
			case MiniOCLPackage.CLASS__OWNED_INVARIANTS:
				return ownedInvariants != null && !ownedInvariants.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitClass(this);
	}

} //ClassImpl
