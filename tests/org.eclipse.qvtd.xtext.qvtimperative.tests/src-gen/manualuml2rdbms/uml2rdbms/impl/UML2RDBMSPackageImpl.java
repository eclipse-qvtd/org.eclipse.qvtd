/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
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
package manualuml2rdbms.uml2rdbms.impl;

import manualuml2rdbms.rdbms.RDBMSPackage;

import manualuml2rdbms.rdbms.impl.RDBMSPackageImpl;

import manualuml2rdbms.uml.UMLPackage;

import manualuml2rdbms.uml.impl.UMLPackageImpl;

import manualuml2rdbms.uml2rdbms.AssociationToForeignKey;
import manualuml2rdbms.uml2rdbms.AttributeToColumn;
import manualuml2rdbms.uml2rdbms.ClassToTable;
import manualuml2rdbms.uml2rdbms.FromAttribute;
import manualuml2rdbms.uml2rdbms.FromAttributeOwner;
import manualuml2rdbms.uml2rdbms.NonLeafAttribute;
import manualuml2rdbms.uml2rdbms.PackageToSchema;
import manualuml2rdbms.uml2rdbms.PrimitiveToName;
import manualuml2rdbms.uml2rdbms.ToColumn;
import manualuml2rdbms.uml2rdbms.UML2RDBMSFactory;
import manualuml2rdbms.uml2rdbms.UML2RDBMSPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UML2RDBMSPackageImpl extends EPackageImpl implements UML2RDBMSPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeToColumnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationToForeignKeyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classToTableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fromAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fromAttributeOwnerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonLeafAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageToSchemaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveToNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toColumnEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UML2RDBMSPackageImpl() {
		super(eNS_URI, UML2RDBMSFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link UML2RDBMSPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UML2RDBMSPackage init() {
		if (isInited) return (UML2RDBMSPackage)EPackage.Registry.INSTANCE.getEPackage(UML2RDBMSPackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		UML2RDBMSPackageImpl theUML2RDBMSPackage = (UML2RDBMSPackageImpl)(ePackage instanceof UML2RDBMSPackageImpl ? ePackage : new UML2RDBMSPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		UMLPackageImpl theUMLPackage = (UMLPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI) instanceof UMLPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI) : UMLPackage.eINSTANCE);
		RDBMSPackageImpl theRDBMSPackage = (RDBMSPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RDBMSPackage.eNS_URI) instanceof RDBMSPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RDBMSPackage.eNS_URI) : RDBMSPackage.eINSTANCE);

		// Create package meta-data objects
		theUML2RDBMSPackage.createPackageContents();
		theUMLPackage.createPackageContents();
		theRDBMSPackage.createPackageContents();

		// Initialize created meta-data
		theUML2RDBMSPackage.initializePackageContents();
		theUMLPackage.initializePackageContents();
		theRDBMSPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUML2RDBMSPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UML2RDBMSPackage.eNS_URI, theUML2RDBMSPackage);
		return theUML2RDBMSPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeToColumn() {
		return attributeToColumnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeToColumn_Type() {
		return (EReference)attributeToColumnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociationToForeignKey() {
		return associationToForeignKeyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociationToForeignKey_Referenced() {
		return (EReference)associationToForeignKeyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociationToForeignKey_Owner() {
		return (EReference)associationToForeignKeyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociationToForeignKey_Name() {
		return (EAttribute)associationToForeignKeyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociationToForeignKey_Association() {
		return (EReference)associationToForeignKeyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociationToForeignKey_ForeignKey() {
		return (EReference)associationToForeignKeyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassToTable() {
		return classToTableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassToTable_Owner() {
		return (EReference)classToTableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassToTable_AssociationsToForeignKeys() {
		return (EReference)classToTableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassToTable_Name() {
		return (EAttribute)classToTableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassToTable_UmlClass() {
		return (EReference)classToTableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassToTable_Table() {
		return (EReference)classToTableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassToTable_PrimaryKey() {
		return (EReference)classToTableEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFromAttribute() {
		return fromAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFromAttribute_Name() {
		return (EAttribute)fromAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFromAttribute_Kind() {
		return (EAttribute)fromAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromAttribute_Owner() {
		return (EReference)fromAttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromAttribute_Leafs() {
		return (EReference)fromAttributeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromAttribute_Attribute() {
		return (EReference)fromAttributeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFromAttributeOwner() {
		return fromAttributeOwnerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromAttributeOwner_FromAttributes() {
		return (EReference)fromAttributeOwnerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNonLeafAttribute() {
		return nonLeafAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageToSchema() {
		return packageToSchemaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageToSchema_ClassesToTables() {
		return (EReference)packageToSchemaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageToSchema_PrimitivesToNames() {
		return (EReference)packageToSchemaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageToSchema_Name() {
		return (EAttribute)packageToSchemaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageToSchema_UmlPackage() {
		return (EReference)packageToSchemaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageToSchema_Schema() {
		return (EReference)packageToSchemaEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveToName() {
		return primitiveToNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimitiveToName_Owner() {
		return (EReference)primitiveToNameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveToName_Name() {
		return (EAttribute)primitiveToNameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimitiveToName_Primitive() {
		return (EReference)primitiveToNameEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveToName_TypeName() {
		return (EAttribute)primitiveToNameEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToColumn() {
		return toColumnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToColumn_Column() {
		return (EReference)toColumnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UML2RDBMSFactory getUML2RDBMSFactory() {
		return (UML2RDBMSFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		attributeToColumnEClass = createEClass(ATTRIBUTE_TO_COLUMN);
		createEReference(attributeToColumnEClass, ATTRIBUTE_TO_COLUMN__TYPE);

		associationToForeignKeyEClass = createEClass(ASSOCIATION_TO_FOREIGN_KEY);
		createEReference(associationToForeignKeyEClass, ASSOCIATION_TO_FOREIGN_KEY__REFERENCED);
		createEReference(associationToForeignKeyEClass, ASSOCIATION_TO_FOREIGN_KEY__OWNER);
		createEAttribute(associationToForeignKeyEClass, ASSOCIATION_TO_FOREIGN_KEY__NAME);
		createEReference(associationToForeignKeyEClass, ASSOCIATION_TO_FOREIGN_KEY__ASSOCIATION);
		createEReference(associationToForeignKeyEClass, ASSOCIATION_TO_FOREIGN_KEY__FOREIGN_KEY);

		classToTableEClass = createEClass(CLASS_TO_TABLE);
		createEReference(classToTableEClass, CLASS_TO_TABLE__OWNER);
		createEReference(classToTableEClass, CLASS_TO_TABLE__ASSOCIATIONS_TO_FOREIGN_KEYS);
		createEAttribute(classToTableEClass, CLASS_TO_TABLE__NAME);
		createEReference(classToTableEClass, CLASS_TO_TABLE__UML_CLASS);
		createEReference(classToTableEClass, CLASS_TO_TABLE__TABLE);
		createEReference(classToTableEClass, CLASS_TO_TABLE__PRIMARY_KEY);

		fromAttributeEClass = createEClass(FROM_ATTRIBUTE);
		createEAttribute(fromAttributeEClass, FROM_ATTRIBUTE__NAME);
		createEAttribute(fromAttributeEClass, FROM_ATTRIBUTE__KIND);
		createEReference(fromAttributeEClass, FROM_ATTRIBUTE__OWNER);
		createEReference(fromAttributeEClass, FROM_ATTRIBUTE__LEAFS);
		createEReference(fromAttributeEClass, FROM_ATTRIBUTE__ATTRIBUTE);

		fromAttributeOwnerEClass = createEClass(FROM_ATTRIBUTE_OWNER);
		createEReference(fromAttributeOwnerEClass, FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES);

		nonLeafAttributeEClass = createEClass(NON_LEAF_ATTRIBUTE);

		packageToSchemaEClass = createEClass(PACKAGE_TO_SCHEMA);
		createEReference(packageToSchemaEClass, PACKAGE_TO_SCHEMA__CLASSES_TO_TABLES);
		createEReference(packageToSchemaEClass, PACKAGE_TO_SCHEMA__PRIMITIVES_TO_NAMES);
		createEAttribute(packageToSchemaEClass, PACKAGE_TO_SCHEMA__NAME);
		createEReference(packageToSchemaEClass, PACKAGE_TO_SCHEMA__UML_PACKAGE);
		createEReference(packageToSchemaEClass, PACKAGE_TO_SCHEMA__SCHEMA);

		primitiveToNameEClass = createEClass(PRIMITIVE_TO_NAME);
		createEReference(primitiveToNameEClass, PRIMITIVE_TO_NAME__OWNER);
		createEAttribute(primitiveToNameEClass, PRIMITIVE_TO_NAME__NAME);
		createEReference(primitiveToNameEClass, PRIMITIVE_TO_NAME__PRIMITIVE);
		createEAttribute(primitiveToNameEClass, PRIMITIVE_TO_NAME__TYPE_NAME);

		toColumnEClass = createEClass(TO_COLUMN);
		createEReference(toColumnEClass, TO_COLUMN__COLUMN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		RDBMSPackage theRDBMSPackage = (RDBMSPackage)EPackage.Registry.INSTANCE.getEPackage(RDBMSPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		attributeToColumnEClass.getESuperTypes().add(this.getFromAttribute());
		attributeToColumnEClass.getESuperTypes().add(this.getToColumn());
		associationToForeignKeyEClass.getESuperTypes().add(this.getToColumn());
		classToTableEClass.getESuperTypes().add(this.getFromAttributeOwner());
		classToTableEClass.getESuperTypes().add(this.getToColumn());
		nonLeafAttributeEClass.getESuperTypes().add(this.getFromAttributeOwner());
		nonLeafAttributeEClass.getESuperTypes().add(this.getFromAttribute());

		// Initialize classes, features, and operations; add parameters
		initEClass(attributeToColumnEClass, AttributeToColumn.class, "AttributeToColumn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeToColumn_Type(), this.getPrimitiveToName(), null, "type", null, 0, 1, AttributeToColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(associationToForeignKeyEClass, AssociationToForeignKey.class, "AssociationToForeignKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssociationToForeignKey_Referenced(), this.getClassToTable(), null, "referenced", null, 0, 1, AssociationToForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociationToForeignKey_Owner(), this.getClassToTable(), this.getClassToTable_AssociationsToForeignKeys(), "owner", null, 0, 1, AssociationToForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssociationToForeignKey_Name(), ecorePackage.getEString(), "name", null, 0, 1, AssociationToForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociationToForeignKey_Association(), theUMLPackage.getAssociation(), null, "association", null, 0, 1, AssociationToForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociationToForeignKey_ForeignKey(), theRDBMSPackage.getForeignKey(), null, "foreignKey", null, 0, 1, AssociationToForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classToTableEClass, ClassToTable.class, "ClassToTable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassToTable_Owner(), this.getPackageToSchema(), this.getPackageToSchema_ClassesToTables(), "owner", null, 0, 1, ClassToTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassToTable_AssociationsToForeignKeys(), this.getAssociationToForeignKey(), this.getAssociationToForeignKey_Owner(), "associationsToForeignKeys", null, 0, -1, ClassToTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassToTable_Name(), ecorePackage.getEString(), "name", null, 0, 1, ClassToTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassToTable_UmlClass(), theUMLPackage.getClass_(), null, "umlClass", null, 0, 1, ClassToTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassToTable_Table(), theRDBMSPackage.getTable(), null, "table", null, 0, 1, ClassToTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassToTable_PrimaryKey(), theRDBMSPackage.getKey(), null, "primaryKey", null, 0, 1, ClassToTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fromAttributeEClass, FromAttribute.class, "FromAttribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFromAttribute_Name(), ecorePackage.getEString(), "name", null, 0, 1, FromAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFromAttribute_Kind(), ecorePackage.getEString(), "kind", null, 0, 1, FromAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFromAttribute_Owner(), this.getFromAttributeOwner(), this.getFromAttributeOwner_FromAttributes(), "owner", null, 0, 1, FromAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFromAttribute_Leafs(), this.getAttributeToColumn(), null, "leafs", null, 0, -1, FromAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFromAttribute_Attribute(), theUMLPackage.getAttribute(), null, "attribute", null, 0, 1, FromAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fromAttributeOwnerEClass, FromAttributeOwner.class, "FromAttributeOwner", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFromAttributeOwner_FromAttributes(), this.getFromAttribute(), this.getFromAttribute_Owner(), "fromAttributes", null, 0, -1, FromAttributeOwner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(nonLeafAttributeEClass, NonLeafAttribute.class, "NonLeafAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(packageToSchemaEClass, PackageToSchema.class, "PackageToSchema", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPackageToSchema_ClassesToTables(), this.getClassToTable(), this.getClassToTable_Owner(), "classesToTables", null, 0, -1, PackageToSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPackageToSchema_PrimitivesToNames(), this.getPrimitiveToName(), this.getPrimitiveToName_Owner(), "primitivesToNames", null, 0, -1, PackageToSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPackageToSchema_Name(), ecorePackage.getEString(), "name", null, 0, 1, PackageToSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageToSchema_UmlPackage(), theUMLPackage.getPackage(), null, "umlPackage", null, 1, 1, PackageToSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageToSchema_Schema(), theRDBMSPackage.getSchema(), null, "schema", null, 1, 1, PackageToSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveToNameEClass, PrimitiveToName.class, "PrimitiveToName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrimitiveToName_Owner(), this.getPackageToSchema(), this.getPackageToSchema_PrimitivesToNames(), "owner", null, 0, 1, PrimitiveToName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimitiveToName_Name(), ecorePackage.getEString(), "name", null, 0, 1, PrimitiveToName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimitiveToName_Primitive(), theUMLPackage.getPrimitiveDataType(), null, "primitive", null, 1, 1, PrimitiveToName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimitiveToName_TypeName(), ecorePackage.getEString(), "typeName", null, 1, 1, PrimitiveToName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(toColumnEClass, ToColumn.class, "ToColumn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getToColumn_Column(), theRDBMSPackage.getColumn(), null, "column", null, 0, 1, ToColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //UML2RDBMSPackageImpl
