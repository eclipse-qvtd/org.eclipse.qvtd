/**
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simplerdbms.Schema;

import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.ClassToTable;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.PackageToSchema;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.PrimitiveToName;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package To Schema</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.impl.PackageToSchemaImpl#getClassesToTables <em>Classes To Tables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.impl.PackageToSchemaImpl#getPrimitivesToNames <em>Primitives To Names</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.impl.PackageToSchemaImpl#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.impl.PackageToSchemaImpl#getUmlPackage <em>Uml Package</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PackageToSchemaImpl extends UmlToRdbmsModelElementImpl implements PackageToSchema {
	/**
	 * The number of structural features of the '<em>Package To Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PACKAGE_TO_SCHEMA_FEATURE_COUNT = UmlToRdbmsModelElementImpl.UML_TO_RDBMS_MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Package To Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PACKAGE_TO_SCHEMA_OPERATION_COUNT = UmlToRdbmsModelElementImpl.UML_TO_RDBMS_MODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The cached value of the '{@link #getClassesToTables() <em>Classes To Tables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassesToTables()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassToTable> classesToTables;

	/**
	 * The cached value of the '{@link #getPrimitivesToNames() <em>Primitives To Names</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitivesToNames()
	 * @generated
	 * @ordered
	 */
	protected EList<PrimitiveToName> primitivesToNames;

	/**
	 * The cached value of the '{@link #getSchema() <em>Schema</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchema()
	 * @generated
	 * @ordered
	 */
	protected Schema schema;

	/**
	 * The cached value of the '{@link #getUmlPackage() <em>Uml Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlPackage()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Package umlPackage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageToSchemaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Simpleuml2rdbmsPackage.Literals.PACKAGE_TO_SCHEMA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ClassToTable> getClassesToTables() {
		if (classesToTables == null) {
			classesToTables = new EObjectContainmentWithInverseEList<ClassToTable>(ClassToTable.class, this, 1, 4);
		}
		return classesToTables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PrimitiveToName> getPrimitivesToNames() {
		if (primitivesToNames == null) {
			primitivesToNames = new EObjectContainmentWithInverseEList<PrimitiveToName>(PrimitiveToName.class, this, 2, 2);
		}
		return primitivesToNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Schema getSchema() {
		if (schema != null && schema.eIsProxy()) {
			InternalEObject oldSchema = (InternalEObject)schema;
			schema = (Schema)eResolveProxy(oldSchema);
			if (schema != oldSchema) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 3, oldSchema, schema));
			}
		}
		return schema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Schema basicGetSchema() {
		return schema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSchema(Schema newSchema) {
		Schema oldSchema = schema;
		schema = newSchema;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 3, oldSchema, schema));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Package getUmlPackage() {
		if (umlPackage != null && umlPackage.eIsProxy()) {
			InternalEObject oldUmlPackage = (InternalEObject)umlPackage;
			umlPackage = (org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Package)eResolveProxy(oldUmlPackage);
			if (umlPackage != oldUmlPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 4, oldUmlPackage, umlPackage));
			}
		}
		return umlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Package basicGetUmlPackage() {
		return umlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUmlPackage(org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Package newUmlPackage) {
		org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Package oldUmlPackage = umlPackage;
		umlPackage = newUmlPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 4, oldUmlPackage, umlPackage));
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
			case 1:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getClassesToTables()).basicAdd(otherEnd, msgs);
			case 2:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPrimitivesToNames()).basicAdd(otherEnd, msgs);
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
			case 1:
				return ((InternalEList<?>)getClassesToTables()).basicRemove(otherEnd, msgs);
			case 2:
				return ((InternalEList<?>)getPrimitivesToNames()).basicRemove(otherEnd, msgs);
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
			case 1:
				return getClassesToTables();
			case 2:
				return getPrimitivesToNames();
			case 3:
				if (resolve) return getSchema();
				return basicGetSchema();
			case 4:
				if (resolve) return getUmlPackage();
				return basicGetUmlPackage();
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
			case 1:
				getClassesToTables().clear();
				getClassesToTables().addAll((Collection<? extends ClassToTable>)newValue);
				return;
			case 2:
				getPrimitivesToNames().clear();
				getPrimitivesToNames().addAll((Collection<? extends PrimitiveToName>)newValue);
				return;
			case 3:
				setSchema((Schema)newValue);
				return;
			case 4:
				setUmlPackage((org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Package)newValue);
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
			case 1:
				getClassesToTables().clear();
				return;
			case 2:
				getPrimitivesToNames().clear();
				return;
			case 3:
				setSchema((Schema)null);
				return;
			case 4:
				setUmlPackage((org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Package)null);
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
			case 1:
				return classesToTables != null && !classesToTables.isEmpty();
			case 2:
				return primitivesToNames != null && !primitivesToNames.isEmpty();
			case 3:
				return schema != null;
			case 4:
				return umlPackage != null;
		}
		return super.eIsSet(featureID);
	}


} //PackageToSchemaImpl
