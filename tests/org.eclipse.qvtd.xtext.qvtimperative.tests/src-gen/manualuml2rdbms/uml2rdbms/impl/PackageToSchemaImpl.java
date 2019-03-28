/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package manualuml2rdbms.uml2rdbms.impl;

import java.util.Collection;

import manualuml2rdbms.rdbms.Schema;

import manualuml2rdbms.uml2rdbms.ClassToTable;
import manualuml2rdbms.uml2rdbms.PackageToSchema;
import manualuml2rdbms.uml2rdbms.PrimitiveToName;
import manualuml2rdbms.uml2rdbms.UML2RDBMSPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package To Schema</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link manualuml2rdbms.uml2rdbms.impl.PackageToSchemaImpl#getClassesToTables <em>Classes To Tables</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.impl.PackageToSchemaImpl#getPrimitivesToNames <em>Primitives To Names</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.impl.PackageToSchemaImpl#getName <em>Name</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.impl.PackageToSchemaImpl#getUmlPackage <em>Uml Package</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.impl.PackageToSchemaImpl#getSchema <em>Schema</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PackageToSchemaImpl extends MinimalEObjectImpl.Container implements PackageToSchema {
	/**
	 * The number of structural features of the '<em>Package To Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PACKAGE_TO_SCHEMA_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Package To Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PACKAGE_TO_SCHEMA_OPERATION_COUNT = 0;

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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUmlPackage() <em>Uml Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlPackage()
	 * @generated
	 * @ordered
	 */
	protected manualuml2rdbms.uml.Package umlPackage;

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
		return UML2RDBMSPackage.Literals.PACKAGE_TO_SCHEMA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ClassToTable> getClassesToTables() {
		if (classesToTables == null) {
			classesToTables = new EObjectContainmentWithInverseEList<ClassToTable>(ClassToTable.class, this, 0, 2);
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
			primitivesToNames = new EObjectContainmentWithInverseEList<PrimitiveToName>(PrimitiveToName.class, this, 1, 0);
		}
		return primitivesToNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 2, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public manualuml2rdbms.uml.Package getUmlPackage() {
		if (umlPackage != null && umlPackage.eIsProxy()) {
			InternalEObject oldUmlPackage = (InternalEObject)umlPackage;
			umlPackage = (manualuml2rdbms.uml.Package)eResolveProxy(oldUmlPackage);
			if (umlPackage != oldUmlPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 3, oldUmlPackage, umlPackage));
			}
		}
		return umlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public manualuml2rdbms.uml.Package basicGetUmlPackage() {
		return umlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUmlPackage(manualuml2rdbms.uml.Package newUmlPackage) {
		manualuml2rdbms.uml.Package oldUmlPackage = umlPackage;
		umlPackage = newUmlPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 3, oldUmlPackage, umlPackage));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 4, oldSchema, schema));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 4, oldSchema, schema));
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
			case 0:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getClassesToTables()).basicAdd(otherEnd, msgs);
			case 1:
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
			case 0:
				return ((InternalEList<?>)getClassesToTables()).basicRemove(otherEnd, msgs);
			case 1:
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
			case 0:
				return getClassesToTables();
			case 1:
				return getPrimitivesToNames();
			case 2:
				return getName();
			case 3:
				if (resolve) return getUmlPackage();
				return basicGetUmlPackage();
			case 4:
				if (resolve) return getSchema();
				return basicGetSchema();
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
			case 0:
				getClassesToTables().clear();
				getClassesToTables().addAll((Collection<? extends ClassToTable>)newValue);
				return;
			case 1:
				getPrimitivesToNames().clear();
				getPrimitivesToNames().addAll((Collection<? extends PrimitiveToName>)newValue);
				return;
			case 2:
				setName((String)newValue);
				return;
			case 3:
				setUmlPackage((manualuml2rdbms.uml.Package)newValue);
				return;
			case 4:
				setSchema((Schema)newValue);
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
			case 0:
				getClassesToTables().clear();
				return;
			case 1:
				getPrimitivesToNames().clear();
				return;
			case 2:
				setName(NAME_EDEFAULT);
				return;
			case 3:
				setUmlPackage((manualuml2rdbms.uml.Package)null);
				return;
			case 4:
				setSchema((Schema)null);
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
			case 0:
				return classesToTables != null && !classesToTables.isEmpty();
			case 1:
				return primitivesToNames != null && !primitivesToNames.isEmpty();
			case 2:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case 3:
				return umlPackage != null;
			case 4:
				return schema != null;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //PackageToSchemaImpl
