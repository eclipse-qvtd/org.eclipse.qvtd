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
import astm.DelphiImplementationSection;
import astm.NamedTypeReference;

import astm.util.Visitor;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delphi Implementation Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.DelphiImplementationSectionImpl#getUses <em>Uses</em>}</li>
 *   <li>{@link astm.impl.DelphiImplementationSectionImpl#getExports <em>Exports</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DelphiImplementationSectionImpl extends CompilationUnitImpl implements DelphiImplementationSection {
	/**
	 * The cached value of the '{@link #getUses() <em>Uses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUses()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedTypeReference> uses;

	/**
	 * The cached value of the '{@link #getExports() <em>Exports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExports()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedTypeReference> exports;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DelphiImplementationSectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.DELPHI_IMPLEMENTATION_SECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedTypeReference> getUses() {
		if (uses == null) {
			uses = new EObjectContainmentEList<NamedTypeReference>(NamedTypeReference.class, this, AstmPackage.DELPHI_IMPLEMENTATION_SECTION__USES);
		}
		return uses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedTypeReference> getExports() {
		if (exports == null) {
			exports = new EObjectContainmentEList<NamedTypeReference>(NamedTypeReference.class, this, AstmPackage.DELPHI_IMPLEMENTATION_SECTION__EXPORTS);
		}
		return exports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.DELPHI_IMPLEMENTATION_SECTION__USES:
				return ((InternalEList<?>)getUses()).basicRemove(otherEnd, msgs);
			case AstmPackage.DELPHI_IMPLEMENTATION_SECTION__EXPORTS:
				return ((InternalEList<?>)getExports()).basicRemove(otherEnd, msgs);
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
			case AstmPackage.DELPHI_IMPLEMENTATION_SECTION__USES:
				return getUses();
			case AstmPackage.DELPHI_IMPLEMENTATION_SECTION__EXPORTS:
				return getExports();
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
			case AstmPackage.DELPHI_IMPLEMENTATION_SECTION__USES:
				getUses().clear();
				getUses().addAll((Collection<? extends NamedTypeReference>)newValue);
				return;
			case AstmPackage.DELPHI_IMPLEMENTATION_SECTION__EXPORTS:
				getExports().clear();
				getExports().addAll((Collection<? extends NamedTypeReference>)newValue);
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
			case AstmPackage.DELPHI_IMPLEMENTATION_SECTION__USES:
				getUses().clear();
				return;
			case AstmPackage.DELPHI_IMPLEMENTATION_SECTION__EXPORTS:
				getExports().clear();
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
			case AstmPackage.DELPHI_IMPLEMENTATION_SECTION__USES:
				return uses != null && !uses.isEmpty();
			case AstmPackage.DELPHI_IMPLEMENTATION_SECTION__EXPORTS:
				return exports != null && !exports.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitDelphiImplementationSection(this);
	}

} //DelphiImplementationSectionImpl
