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
import astm.CompilationUnit;
import astm.GlobalScope;
import astm.Project;

import astm.util.Visitor;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.ProjectImpl#getFiles <em>Files</em>}</li>
 *   <li>{@link astm.impl.ProjectImpl#getOuterScope <em>Outer Scope</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProjectImpl extends GASTMSemanticObjectImpl implements Project {
	/**
	 * The cached value of the '{@link #getFiles() <em>Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<CompilationUnit> files;

	/**
	 * The cached value of the '{@link #getOuterScope() <em>Outer Scope</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOuterScope()
	 * @generated
	 * @ordered
	 */
	protected GlobalScope outerScope;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompilationUnit> getFiles() {
		if (files == null) {
			files = new EObjectContainmentEList<CompilationUnit>(CompilationUnit.class, this, AstmPackage.PROJECT__FILES);
		}
		return files;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalScope getOuterScope() {
		return outerScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOuterScope(GlobalScope newOuterScope, NotificationChain msgs) {
		GlobalScope oldOuterScope = outerScope;
		outerScope = newOuterScope;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.PROJECT__OUTER_SCOPE, oldOuterScope, newOuterScope);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOuterScope(GlobalScope newOuterScope) {
		if (newOuterScope != outerScope) {
			NotificationChain msgs = null;
			if (outerScope != null)
				msgs = ((InternalEObject)outerScope).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.PROJECT__OUTER_SCOPE, null, msgs);
			if (newOuterScope != null)
				msgs = ((InternalEObject)newOuterScope).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.PROJECT__OUTER_SCOPE, null, msgs);
			msgs = basicSetOuterScope(newOuterScope, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.PROJECT__OUTER_SCOPE, newOuterScope, newOuterScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.PROJECT__FILES:
				return ((InternalEList<?>)getFiles()).basicRemove(otherEnd, msgs);
			case AstmPackage.PROJECT__OUTER_SCOPE:
				return basicSetOuterScope(null, msgs);
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
			case AstmPackage.PROJECT__FILES:
				return getFiles();
			case AstmPackage.PROJECT__OUTER_SCOPE:
				return getOuterScope();
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
			case AstmPackage.PROJECT__FILES:
				getFiles().clear();
				getFiles().addAll((Collection<? extends CompilationUnit>)newValue);
				return;
			case AstmPackage.PROJECT__OUTER_SCOPE:
				setOuterScope((GlobalScope)newValue);
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
			case AstmPackage.PROJECT__FILES:
				getFiles().clear();
				return;
			case AstmPackage.PROJECT__OUTER_SCOPE:
				setOuterScope((GlobalScope)null);
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
			case AstmPackage.PROJECT__FILES:
				return files != null && !files.isEmpty();
			case AstmPackage.PROJECT__OUTER_SCOPE:
				return outerScope != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitProject(this);
	}

} //ProjectImpl
