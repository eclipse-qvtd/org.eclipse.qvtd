/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package test.umltordbms.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import test.simplerdbms.Schema;
import test.umltordbms.ClassToTable;
import test.umltordbms.PackageToSchema;
import test.umltordbms.PrimitiveToName;
import test.umltordbms.UmltordbmsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package To Schema</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link test.umltordbms.impl.PackageToSchemaImpl#getClassesToTables <em>Classes To Tables</em>}</li>
 *   <li>{@link test.umltordbms.impl.PackageToSchemaImpl#getPrimitivesToNames <em>Primitives To Names</em>}</li>
 *   <li>{@link test.umltordbms.impl.PackageToSchemaImpl#getName <em>Name</em>}</li>
 *   <li>{@link test.umltordbms.impl.PackageToSchemaImpl#getUmlPackage <em>Uml Package</em>}</li>
 *   <li>{@link test.umltordbms.impl.PackageToSchemaImpl#getSchema <em>Schema</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PackageToSchemaImpl extends MinimalEObjectImpl.Container implements PackageToSchema {
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
	protected test.simpleuml.Package umlPackage;

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
		return UmltordbmsPackage.Literals.PACKAGE_TO_SCHEMA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassToTable> getClassesToTables() {
		if (classesToTables == null) {
			classesToTables = new EObjectContainmentWithInverseEList<ClassToTable>(ClassToTable.class, this, UmltordbmsPackage.PACKAGE_TO_SCHEMA__CLASSES_TO_TABLES, UmltordbmsPackage.CLASS_TO_TABLE__OWNER);
		}
		return classesToTables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PrimitiveToName> getPrimitivesToNames() {
		if (primitivesToNames == null) {
			primitivesToNames = new EObjectContainmentWithInverseEList<PrimitiveToName>(PrimitiveToName.class, this, UmltordbmsPackage.PACKAGE_TO_SCHEMA__PRIMITIVES_TO_NAMES, UmltordbmsPackage.PRIMITIVE_TO_NAME__OWNER);
		}
		return primitivesToNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmltordbmsPackage.PACKAGE_TO_SCHEMA__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public test.simpleuml.Package getUmlPackage() {
		if (umlPackage != null && umlPackage.eIsProxy()) {
			InternalEObject oldUmlPackage = (InternalEObject)umlPackage;
			umlPackage = (test.simpleuml.Package)eResolveProxy(oldUmlPackage);
			if (umlPackage != oldUmlPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmltordbmsPackage.PACKAGE_TO_SCHEMA__UML_PACKAGE, oldUmlPackage, umlPackage));
			}
		}
		return umlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public test.simpleuml.Package basicGetUmlPackage() {
		return umlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlPackage(test.simpleuml.Package newUmlPackage) {
		test.simpleuml.Package oldUmlPackage = umlPackage;
		umlPackage = newUmlPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmltordbmsPackage.PACKAGE_TO_SCHEMA__UML_PACKAGE, oldUmlPackage, umlPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Schema getSchema() {
		if (schema != null && schema.eIsProxy()) {
			InternalEObject oldSchema = (InternalEObject)schema;
			schema = (Schema)eResolveProxy(oldSchema);
			if (schema != oldSchema) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmltordbmsPackage.PACKAGE_TO_SCHEMA__SCHEMA, oldSchema, schema));
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
	public void setSchema(Schema newSchema) {
		Schema oldSchema = schema;
		schema = newSchema;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmltordbmsPackage.PACKAGE_TO_SCHEMA__SCHEMA, oldSchema, schema));
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
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__CLASSES_TO_TABLES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getClassesToTables()).basicAdd(otherEnd, msgs);
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__PRIMITIVES_TO_NAMES:
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
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__CLASSES_TO_TABLES:
				return ((InternalEList<?>)getClassesToTables()).basicRemove(otherEnd, msgs);
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__PRIMITIVES_TO_NAMES:
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
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__CLASSES_TO_TABLES:
				return getClassesToTables();
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__PRIMITIVES_TO_NAMES:
				return getPrimitivesToNames();
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__NAME:
				return getName();
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__UML_PACKAGE:
				if (resolve) return getUmlPackage();
				return basicGetUmlPackage();
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__SCHEMA:
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
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__CLASSES_TO_TABLES:
				getClassesToTables().clear();
				getClassesToTables().addAll((Collection<? extends ClassToTable>)newValue);
				return;
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__PRIMITIVES_TO_NAMES:
				getPrimitivesToNames().clear();
				getPrimitivesToNames().addAll((Collection<? extends PrimitiveToName>)newValue);
				return;
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__NAME:
				setName((String)newValue);
				return;
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__UML_PACKAGE:
				setUmlPackage((test.simpleuml.Package)newValue);
				return;
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__SCHEMA:
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
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__CLASSES_TO_TABLES:
				getClassesToTables().clear();
				return;
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__PRIMITIVES_TO_NAMES:
				getPrimitivesToNames().clear();
				return;
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__UML_PACKAGE:
				setUmlPackage((test.simpleuml.Package)null);
				return;
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__SCHEMA:
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
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__CLASSES_TO_TABLES:
				return classesToTables != null && !classesToTables.isEmpty();
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__PRIMITIVES_TO_NAMES:
				return primitivesToNames != null && !primitivesToNames.isEmpty();
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__UML_PACKAGE:
				return umlPackage != null;
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA__SCHEMA:
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //PackageToSchemaImpl
