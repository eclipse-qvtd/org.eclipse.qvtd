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
package manualuml2rdbms.uml2rdbms;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSFactory
 * @model kind="package"
 * @generated
 */
public interface UML2RDBMSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "uml2rdbms";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/examples/0.1/ManualUML2RDBMS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "uml2rdbms";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UML2RDBMSPackage eINSTANCE = manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl.init();

	/**
	 * The meta object id for the '{@link manualuml2rdbms.uml2rdbms.impl.FromAttributeImpl <em>From Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see manualuml2rdbms.uml2rdbms.impl.FromAttributeImpl
	 * @see manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getFromAttribute()
	 * @generated
	 */
	int FROM_ATTRIBUTE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_ATTRIBUTE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_ATTRIBUTE__KIND = 1;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_ATTRIBUTE__OWNER = 2;

	/**
	 * The feature id for the '<em><b>Leafs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_ATTRIBUTE__LEAFS = 3;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_ATTRIBUTE__ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>From Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_ATTRIBUTE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>From Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_ATTRIBUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link manualuml2rdbms.uml2rdbms.impl.AttributeToColumnImpl <em>Attribute To Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see manualuml2rdbms.uml2rdbms.impl.AttributeToColumnImpl
	 * @see manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getAttributeToColumn()
	 * @generated
	 */
	int ATTRIBUTE_TO_COLUMN = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TO_COLUMN__NAME = FROM_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TO_COLUMN__KIND = FROM_ATTRIBUTE__KIND;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TO_COLUMN__OWNER = FROM_ATTRIBUTE__OWNER;

	/**
	 * The feature id for the '<em><b>Leafs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TO_COLUMN__LEAFS = FROM_ATTRIBUTE__LEAFS;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TO_COLUMN__ATTRIBUTE = FROM_ATTRIBUTE__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TO_COLUMN__COLUMN = FROM_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TO_COLUMN__TYPE = FROM_ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute To Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TO_COLUMN_FEATURE_COUNT = FROM_ATTRIBUTE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute To Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TO_COLUMN_OPERATION_COUNT = FROM_ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link manualuml2rdbms.uml2rdbms.impl.ToColumnImpl <em>To Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see manualuml2rdbms.uml2rdbms.impl.ToColumnImpl
	 * @see manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getToColumn()
	 * @generated
	 */
	int TO_COLUMN = 8;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_COLUMN__COLUMN = 0;

	/**
	 * The number of structural features of the '<em>To Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_COLUMN_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>To Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_COLUMN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link manualuml2rdbms.uml2rdbms.impl.AssociationToForeignKeyImpl <em>Association To Foreign Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see manualuml2rdbms.uml2rdbms.impl.AssociationToForeignKeyImpl
	 * @see manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getAssociationToForeignKey()
	 * @generated
	 */
	int ASSOCIATION_TO_FOREIGN_KEY = 1;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_TO_FOREIGN_KEY__COLUMN = TO_COLUMN__COLUMN;

	/**
	 * The feature id for the '<em><b>Referenced</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_TO_FOREIGN_KEY__REFERENCED = TO_COLUMN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_TO_FOREIGN_KEY__OWNER = TO_COLUMN_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_TO_FOREIGN_KEY__NAME = TO_COLUMN_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Association</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_TO_FOREIGN_KEY__ASSOCIATION = TO_COLUMN_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Foreign Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_TO_FOREIGN_KEY__FOREIGN_KEY = TO_COLUMN_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Association To Foreign Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_TO_FOREIGN_KEY_FEATURE_COUNT = TO_COLUMN_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Association To Foreign Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_TO_FOREIGN_KEY_OPERATION_COUNT = TO_COLUMN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link manualuml2rdbms.uml2rdbms.impl.FromAttributeOwnerImpl <em>From Attribute Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see manualuml2rdbms.uml2rdbms.impl.FromAttributeOwnerImpl
	 * @see manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getFromAttributeOwner()
	 * @generated
	 */
	int FROM_ATTRIBUTE_OWNER = 4;

	/**
	 * The feature id for the '<em><b>From Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES = 0;

	/**
	 * The number of structural features of the '<em>From Attribute Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_ATTRIBUTE_OWNER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>From Attribute Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_ATTRIBUTE_OWNER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link manualuml2rdbms.uml2rdbms.impl.ClassToTableImpl <em>Class To Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see manualuml2rdbms.uml2rdbms.impl.ClassToTableImpl
	 * @see manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getClassToTable()
	 * @generated
	 */
	int CLASS_TO_TABLE = 2;

	/**
	 * The feature id for the '<em><b>From Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TO_TABLE__FROM_ATTRIBUTES = FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TO_TABLE__COLUMN = FROM_ATTRIBUTE_OWNER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TO_TABLE__OWNER = FROM_ATTRIBUTE_OWNER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Associations To Foreign Keys</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TO_TABLE__ASSOCIATIONS_TO_FOREIGN_KEYS = FROM_ATTRIBUTE_OWNER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TO_TABLE__NAME = FROM_ATTRIBUTE_OWNER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Uml Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TO_TABLE__UML_CLASS = FROM_ATTRIBUTE_OWNER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TO_TABLE__TABLE = FROM_ATTRIBUTE_OWNER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Primary Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TO_TABLE__PRIMARY_KEY = FROM_ATTRIBUTE_OWNER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Class To Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TO_TABLE_FEATURE_COUNT = FROM_ATTRIBUTE_OWNER_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Class To Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TO_TABLE_OPERATION_COUNT = FROM_ATTRIBUTE_OWNER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link manualuml2rdbms.uml2rdbms.impl.NonLeafAttributeImpl <em>Non Leaf Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see manualuml2rdbms.uml2rdbms.impl.NonLeafAttributeImpl
	 * @see manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getNonLeafAttribute()
	 * @generated
	 */
	int NON_LEAF_ATTRIBUTE = 5;

	/**
	 * The feature id for the '<em><b>From Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_LEAF_ATTRIBUTE__FROM_ATTRIBUTES = FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_LEAF_ATTRIBUTE__NAME = FROM_ATTRIBUTE_OWNER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_LEAF_ATTRIBUTE__KIND = FROM_ATTRIBUTE_OWNER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_LEAF_ATTRIBUTE__OWNER = FROM_ATTRIBUTE_OWNER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Leafs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_LEAF_ATTRIBUTE__LEAFS = FROM_ATTRIBUTE_OWNER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_LEAF_ATTRIBUTE__ATTRIBUTE = FROM_ATTRIBUTE_OWNER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Non Leaf Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_LEAF_ATTRIBUTE_FEATURE_COUNT = FROM_ATTRIBUTE_OWNER_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Non Leaf Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_LEAF_ATTRIBUTE_OPERATION_COUNT = FROM_ATTRIBUTE_OWNER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link manualuml2rdbms.uml2rdbms.impl.PackageToSchemaImpl <em>Package To Schema</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see manualuml2rdbms.uml2rdbms.impl.PackageToSchemaImpl
	 * @see manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getPackageToSchema()
	 * @generated
	 */
	int PACKAGE_TO_SCHEMA = 6;

	/**
	 * The feature id for the '<em><b>Classes To Tables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_TO_SCHEMA__CLASSES_TO_TABLES = 0;

	/**
	 * The feature id for the '<em><b>Primitives To Names</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_TO_SCHEMA__PRIMITIVES_TO_NAMES = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_TO_SCHEMA__NAME = 2;

	/**
	 * The feature id for the '<em><b>Uml Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_TO_SCHEMA__UML_PACKAGE = 3;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_TO_SCHEMA__SCHEMA = 4;

	/**
	 * The number of structural features of the '<em>Package To Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_TO_SCHEMA_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Package To Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_TO_SCHEMA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link manualuml2rdbms.uml2rdbms.impl.PrimitiveToNameImpl <em>Primitive To Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see manualuml2rdbms.uml2rdbms.impl.PrimitiveToNameImpl
	 * @see manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getPrimitiveToName()
	 * @generated
	 */
	int PRIMITIVE_TO_NAME = 7;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TO_NAME__OWNER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TO_NAME__NAME = 1;

	/**
	 * The feature id for the '<em><b>Primitive</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TO_NAME__PRIMITIVE = 2;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TO_NAME__TYPE_NAME = 3;

	/**
	 * The number of structural features of the '<em>Primitive To Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TO_NAME_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Primitive To Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TO_NAME_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link manualuml2rdbms.uml2rdbms.AttributeToColumn <em>Attribute To Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute To Column</em>'.
	 * @see manualuml2rdbms.uml2rdbms.AttributeToColumn
	 * @generated
	 */
	EClass getAttributeToColumn();

	/**
	 * Returns the meta object for the reference '{@link manualuml2rdbms.uml2rdbms.AttributeToColumn#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see manualuml2rdbms.uml2rdbms.AttributeToColumn#getType()
	 * @see #getAttributeToColumn()
	 * @generated
	 */
	EReference getAttributeToColumn_Type();

	/**
	 * Returns the meta object for class '{@link manualuml2rdbms.uml2rdbms.AssociationToForeignKey <em>Association To Foreign Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association To Foreign Key</em>'.
	 * @see manualuml2rdbms.uml2rdbms.AssociationToForeignKey
	 * @generated
	 */
	EClass getAssociationToForeignKey();

	/**
	 * Returns the meta object for the reference '{@link manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getReferenced <em>Referenced</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced</em>'.
	 * @see manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getReferenced()
	 * @see #getAssociationToForeignKey()
	 * @generated
	 */
	EReference getAssociationToForeignKey_Referenced();

	/**
	 * Returns the meta object for the container reference '{@link manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getOwner()
	 * @see #getAssociationToForeignKey()
	 * @generated
	 */
	EReference getAssociationToForeignKey_Owner();

	/**
	 * Returns the meta object for the attribute '{@link manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getName()
	 * @see #getAssociationToForeignKey()
	 * @generated
	 */
	EAttribute getAssociationToForeignKey_Name();

	/**
	 * Returns the meta object for the reference '{@link manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Association</em>'.
	 * @see manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getAssociation()
	 * @see #getAssociationToForeignKey()
	 * @generated
	 */
	EReference getAssociationToForeignKey_Association();

	/**
	 * Returns the meta object for the reference '{@link manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getForeignKey <em>Foreign Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Foreign Key</em>'.
	 * @see manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getForeignKey()
	 * @see #getAssociationToForeignKey()
	 * @generated
	 */
	EReference getAssociationToForeignKey_ForeignKey();

	/**
	 * Returns the meta object for class '{@link manualuml2rdbms.uml2rdbms.ClassToTable <em>Class To Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class To Table</em>'.
	 * @see manualuml2rdbms.uml2rdbms.ClassToTable
	 * @generated
	 */
	EClass getClassToTable();

	/**
	 * Returns the meta object for the container reference '{@link manualuml2rdbms.uml2rdbms.ClassToTable#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see manualuml2rdbms.uml2rdbms.ClassToTable#getOwner()
	 * @see #getClassToTable()
	 * @generated
	 */
	EReference getClassToTable_Owner();

	/**
	 * Returns the meta object for the containment reference list '{@link manualuml2rdbms.uml2rdbms.ClassToTable#getAssociationsToForeignKeys <em>Associations To Foreign Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Associations To Foreign Keys</em>'.
	 * @see manualuml2rdbms.uml2rdbms.ClassToTable#getAssociationsToForeignKeys()
	 * @see #getClassToTable()
	 * @generated
	 */
	EReference getClassToTable_AssociationsToForeignKeys();

	/**
	 * Returns the meta object for the attribute '{@link manualuml2rdbms.uml2rdbms.ClassToTable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see manualuml2rdbms.uml2rdbms.ClassToTable#getName()
	 * @see #getClassToTable()
	 * @generated
	 */
	EAttribute getClassToTable_Name();

	/**
	 * Returns the meta object for the reference '{@link manualuml2rdbms.uml2rdbms.ClassToTable#getUmlClass <em>Uml Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Uml Class</em>'.
	 * @see manualuml2rdbms.uml2rdbms.ClassToTable#getUmlClass()
	 * @see #getClassToTable()
	 * @generated
	 */
	EReference getClassToTable_UmlClass();

	/**
	 * Returns the meta object for the reference '{@link manualuml2rdbms.uml2rdbms.ClassToTable#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see manualuml2rdbms.uml2rdbms.ClassToTable#getTable()
	 * @see #getClassToTable()
	 * @generated
	 */
	EReference getClassToTable_Table();

	/**
	 * Returns the meta object for the reference '{@link manualuml2rdbms.uml2rdbms.ClassToTable#getPrimaryKey <em>Primary Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primary Key</em>'.
	 * @see manualuml2rdbms.uml2rdbms.ClassToTable#getPrimaryKey()
	 * @see #getClassToTable()
	 * @generated
	 */
	EReference getClassToTable_PrimaryKey();

	/**
	 * Returns the meta object for class '{@link manualuml2rdbms.uml2rdbms.FromAttribute <em>From Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From Attribute</em>'.
	 * @see manualuml2rdbms.uml2rdbms.FromAttribute
	 * @generated
	 */
	EClass getFromAttribute();

	/**
	 * Returns the meta object for the attribute '{@link manualuml2rdbms.uml2rdbms.FromAttribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see manualuml2rdbms.uml2rdbms.FromAttribute#getName()
	 * @see #getFromAttribute()
	 * @generated
	 */
	EAttribute getFromAttribute_Name();

	/**
	 * Returns the meta object for the attribute '{@link manualuml2rdbms.uml2rdbms.FromAttribute#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see manualuml2rdbms.uml2rdbms.FromAttribute#getKind()
	 * @see #getFromAttribute()
	 * @generated
	 */
	EAttribute getFromAttribute_Kind();

	/**
	 * Returns the meta object for the container reference '{@link manualuml2rdbms.uml2rdbms.FromAttribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see manualuml2rdbms.uml2rdbms.FromAttribute#getOwner()
	 * @see #getFromAttribute()
	 * @generated
	 */
	EReference getFromAttribute_Owner();

	/**
	 * Returns the meta object for the reference list '{@link manualuml2rdbms.uml2rdbms.FromAttribute#getLeafs <em>Leafs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Leafs</em>'.
	 * @see manualuml2rdbms.uml2rdbms.FromAttribute#getLeafs()
	 * @see #getFromAttribute()
	 * @generated
	 */
	EReference getFromAttribute_Leafs();

	/**
	 * Returns the meta object for the reference '{@link manualuml2rdbms.uml2rdbms.FromAttribute#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see manualuml2rdbms.uml2rdbms.FromAttribute#getAttribute()
	 * @see #getFromAttribute()
	 * @generated
	 */
	EReference getFromAttribute_Attribute();

	/**
	 * Returns the meta object for class '{@link manualuml2rdbms.uml2rdbms.FromAttributeOwner <em>From Attribute Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From Attribute Owner</em>'.
	 * @see manualuml2rdbms.uml2rdbms.FromAttributeOwner
	 * @generated
	 */
	EClass getFromAttributeOwner();

	/**
	 * Returns the meta object for the containment reference list '{@link manualuml2rdbms.uml2rdbms.FromAttributeOwner#getFromAttributes <em>From Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>From Attributes</em>'.
	 * @see manualuml2rdbms.uml2rdbms.FromAttributeOwner#getFromAttributes()
	 * @see #getFromAttributeOwner()
	 * @generated
	 */
	EReference getFromAttributeOwner_FromAttributes();

	/**
	 * Returns the meta object for class '{@link manualuml2rdbms.uml2rdbms.NonLeafAttribute <em>Non Leaf Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Leaf Attribute</em>'.
	 * @see manualuml2rdbms.uml2rdbms.NonLeafAttribute
	 * @generated
	 */
	EClass getNonLeafAttribute();

	/**
	 * Returns the meta object for class '{@link manualuml2rdbms.uml2rdbms.PackageToSchema <em>Package To Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package To Schema</em>'.
	 * @see manualuml2rdbms.uml2rdbms.PackageToSchema
	 * @generated
	 */
	EClass getPackageToSchema();

	/**
	 * Returns the meta object for the containment reference list '{@link manualuml2rdbms.uml2rdbms.PackageToSchema#getClassesToTables <em>Classes To Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes To Tables</em>'.
	 * @see manualuml2rdbms.uml2rdbms.PackageToSchema#getClassesToTables()
	 * @see #getPackageToSchema()
	 * @generated
	 */
	EReference getPackageToSchema_ClassesToTables();

	/**
	 * Returns the meta object for the containment reference list '{@link manualuml2rdbms.uml2rdbms.PackageToSchema#getPrimitivesToNames <em>Primitives To Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Primitives To Names</em>'.
	 * @see manualuml2rdbms.uml2rdbms.PackageToSchema#getPrimitivesToNames()
	 * @see #getPackageToSchema()
	 * @generated
	 */
	EReference getPackageToSchema_PrimitivesToNames();

	/**
	 * Returns the meta object for the attribute '{@link manualuml2rdbms.uml2rdbms.PackageToSchema#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see manualuml2rdbms.uml2rdbms.PackageToSchema#getName()
	 * @see #getPackageToSchema()
	 * @generated
	 */
	EAttribute getPackageToSchema_Name();

	/**
	 * Returns the meta object for the reference '{@link manualuml2rdbms.uml2rdbms.PackageToSchema#getUmlPackage <em>Uml Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Uml Package</em>'.
	 * @see manualuml2rdbms.uml2rdbms.PackageToSchema#getUmlPackage()
	 * @see #getPackageToSchema()
	 * @generated
	 */
	EReference getPackageToSchema_UmlPackage();

	/**
	 * Returns the meta object for the reference '{@link manualuml2rdbms.uml2rdbms.PackageToSchema#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Schema</em>'.
	 * @see manualuml2rdbms.uml2rdbms.PackageToSchema#getSchema()
	 * @see #getPackageToSchema()
	 * @generated
	 */
	EReference getPackageToSchema_Schema();

	/**
	 * Returns the meta object for class '{@link manualuml2rdbms.uml2rdbms.PrimitiveToName <em>Primitive To Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive To Name</em>'.
	 * @see manualuml2rdbms.uml2rdbms.PrimitiveToName
	 * @generated
	 */
	EClass getPrimitiveToName();

	/**
	 * Returns the meta object for the container reference '{@link manualuml2rdbms.uml2rdbms.PrimitiveToName#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see manualuml2rdbms.uml2rdbms.PrimitiveToName#getOwner()
	 * @see #getPrimitiveToName()
	 * @generated
	 */
	EReference getPrimitiveToName_Owner();

	/**
	 * Returns the meta object for the attribute '{@link manualuml2rdbms.uml2rdbms.PrimitiveToName#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see manualuml2rdbms.uml2rdbms.PrimitiveToName#getName()
	 * @see #getPrimitiveToName()
	 * @generated
	 */
	EAttribute getPrimitiveToName_Name();

	/**
	 * Returns the meta object for the reference '{@link manualuml2rdbms.uml2rdbms.PrimitiveToName#getPrimitive <em>Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primitive</em>'.
	 * @see manualuml2rdbms.uml2rdbms.PrimitiveToName#getPrimitive()
	 * @see #getPrimitiveToName()
	 * @generated
	 */
	EReference getPrimitiveToName_Primitive();

	/**
	 * Returns the meta object for the attribute '{@link manualuml2rdbms.uml2rdbms.PrimitiveToName#getTypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Name</em>'.
	 * @see manualuml2rdbms.uml2rdbms.PrimitiveToName#getTypeName()
	 * @see #getPrimitiveToName()
	 * @generated
	 */
	EAttribute getPrimitiveToName_TypeName();

	/**
	 * Returns the meta object for class '{@link manualuml2rdbms.uml2rdbms.ToColumn <em>To Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To Column</em>'.
	 * @see manualuml2rdbms.uml2rdbms.ToColumn
	 * @generated
	 */
	EClass getToColumn();

	/**
	 * Returns the meta object for the reference '{@link manualuml2rdbms.uml2rdbms.ToColumn#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Column</em>'.
	 * @see manualuml2rdbms.uml2rdbms.ToColumn#getColumn()
	 * @see #getToColumn()
	 * @generated
	 */
	EReference getToColumn_Column();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UML2RDBMSFactory getUML2RDBMSFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link manualuml2rdbms.uml2rdbms.impl.AttributeToColumnImpl <em>Attribute To Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see manualuml2rdbms.uml2rdbms.impl.AttributeToColumnImpl
		 * @see manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getAttributeToColumn()
		 * @generated
		 */
		EClass ATTRIBUTE_TO_COLUMN = eINSTANCE.getAttributeToColumn();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_TO_COLUMN__TYPE = eINSTANCE.getAttributeToColumn_Type();

		/**
		 * The meta object literal for the '{@link manualuml2rdbms.uml2rdbms.impl.AssociationToForeignKeyImpl <em>Association To Foreign Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see manualuml2rdbms.uml2rdbms.impl.AssociationToForeignKeyImpl
		 * @see manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getAssociationToForeignKey()
		 * @generated
		 */
		EClass ASSOCIATION_TO_FOREIGN_KEY = eINSTANCE.getAssociationToForeignKey();

		/**
		 * The meta object literal for the '<em><b>Referenced</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_TO_FOREIGN_KEY__REFERENCED = eINSTANCE.getAssociationToForeignKey_Referenced();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_TO_FOREIGN_KEY__OWNER = eINSTANCE.getAssociationToForeignKey_Owner();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSOCIATION_TO_FOREIGN_KEY__NAME = eINSTANCE.getAssociationToForeignKey_Name();

		/**
		 * The meta object literal for the '<em><b>Association</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_TO_FOREIGN_KEY__ASSOCIATION = eINSTANCE.getAssociationToForeignKey_Association();

		/**
		 * The meta object literal for the '<em><b>Foreign Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_TO_FOREIGN_KEY__FOREIGN_KEY = eINSTANCE.getAssociationToForeignKey_ForeignKey();

		/**
		 * The meta object literal for the '{@link manualuml2rdbms.uml2rdbms.impl.ClassToTableImpl <em>Class To Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see manualuml2rdbms.uml2rdbms.impl.ClassToTableImpl
		 * @see manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getClassToTable()
		 * @generated
		 */
		EClass CLASS_TO_TABLE = eINSTANCE.getClassToTable();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TO_TABLE__OWNER = eINSTANCE.getClassToTable_Owner();

		/**
		 * The meta object literal for the '<em><b>Associations To Foreign Keys</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TO_TABLE__ASSOCIATIONS_TO_FOREIGN_KEYS = eINSTANCE.getClassToTable_AssociationsToForeignKeys();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_TO_TABLE__NAME = eINSTANCE.getClassToTable_Name();

		/**
		 * The meta object literal for the '<em><b>Uml Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TO_TABLE__UML_CLASS = eINSTANCE.getClassToTable_UmlClass();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TO_TABLE__TABLE = eINSTANCE.getClassToTable_Table();

		/**
		 * The meta object literal for the '<em><b>Primary Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TO_TABLE__PRIMARY_KEY = eINSTANCE.getClassToTable_PrimaryKey();

		/**
		 * The meta object literal for the '{@link manualuml2rdbms.uml2rdbms.impl.FromAttributeImpl <em>From Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see manualuml2rdbms.uml2rdbms.impl.FromAttributeImpl
		 * @see manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getFromAttribute()
		 * @generated
		 */
		EClass FROM_ATTRIBUTE = eINSTANCE.getFromAttribute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FROM_ATTRIBUTE__NAME = eINSTANCE.getFromAttribute_Name();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FROM_ATTRIBUTE__KIND = eINSTANCE.getFromAttribute_Kind();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_ATTRIBUTE__OWNER = eINSTANCE.getFromAttribute_Owner();

		/**
		 * The meta object literal for the '<em><b>Leafs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_ATTRIBUTE__LEAFS = eINSTANCE.getFromAttribute_Leafs();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_ATTRIBUTE__ATTRIBUTE = eINSTANCE.getFromAttribute_Attribute();

		/**
		 * The meta object literal for the '{@link manualuml2rdbms.uml2rdbms.impl.FromAttributeOwnerImpl <em>From Attribute Owner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see manualuml2rdbms.uml2rdbms.impl.FromAttributeOwnerImpl
		 * @see manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getFromAttributeOwner()
		 * @generated
		 */
		EClass FROM_ATTRIBUTE_OWNER = eINSTANCE.getFromAttributeOwner();

		/**
		 * The meta object literal for the '<em><b>From Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES = eINSTANCE.getFromAttributeOwner_FromAttributes();

		/**
		 * The meta object literal for the '{@link manualuml2rdbms.uml2rdbms.impl.NonLeafAttributeImpl <em>Non Leaf Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see manualuml2rdbms.uml2rdbms.impl.NonLeafAttributeImpl
		 * @see manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getNonLeafAttribute()
		 * @generated
		 */
		EClass NON_LEAF_ATTRIBUTE = eINSTANCE.getNonLeafAttribute();

		/**
		 * The meta object literal for the '{@link manualuml2rdbms.uml2rdbms.impl.PackageToSchemaImpl <em>Package To Schema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see manualuml2rdbms.uml2rdbms.impl.PackageToSchemaImpl
		 * @see manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getPackageToSchema()
		 * @generated
		 */
		EClass PACKAGE_TO_SCHEMA = eINSTANCE.getPackageToSchema();

		/**
		 * The meta object literal for the '<em><b>Classes To Tables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_TO_SCHEMA__CLASSES_TO_TABLES = eINSTANCE.getPackageToSchema_ClassesToTables();

		/**
		 * The meta object literal for the '<em><b>Primitives To Names</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_TO_SCHEMA__PRIMITIVES_TO_NAMES = eINSTANCE.getPackageToSchema_PrimitivesToNames();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_TO_SCHEMA__NAME = eINSTANCE.getPackageToSchema_Name();

		/**
		 * The meta object literal for the '<em><b>Uml Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_TO_SCHEMA__UML_PACKAGE = eINSTANCE.getPackageToSchema_UmlPackage();

		/**
		 * The meta object literal for the '<em><b>Schema</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_TO_SCHEMA__SCHEMA = eINSTANCE.getPackageToSchema_Schema();

		/**
		 * The meta object literal for the '{@link manualuml2rdbms.uml2rdbms.impl.PrimitiveToNameImpl <em>Primitive To Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see manualuml2rdbms.uml2rdbms.impl.PrimitiveToNameImpl
		 * @see manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getPrimitiveToName()
		 * @generated
		 */
		EClass PRIMITIVE_TO_NAME = eINSTANCE.getPrimitiveToName();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_TO_NAME__OWNER = eINSTANCE.getPrimitiveToName_Owner();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TO_NAME__NAME = eINSTANCE.getPrimitiveToName_Name();

		/**
		 * The meta object literal for the '<em><b>Primitive</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_TO_NAME__PRIMITIVE = eINSTANCE.getPrimitiveToName_Primitive();

		/**
		 * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TO_NAME__TYPE_NAME = eINSTANCE.getPrimitiveToName_TypeName();

		/**
		 * The meta object literal for the '{@link manualuml2rdbms.uml2rdbms.impl.ToColumnImpl <em>To Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see manualuml2rdbms.uml2rdbms.impl.ToColumnImpl
		 * @see manualuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getToColumn()
		 * @generated
		 */
		EClass TO_COLUMN = eINSTANCE.getToColumn();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_COLUMN__COLUMN = eINSTANCE.getToColumn_Column();

	}

} //UML2RDBMSPackage
