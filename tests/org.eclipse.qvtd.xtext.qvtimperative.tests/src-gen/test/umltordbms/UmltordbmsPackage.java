/**
 */
package test.umltordbms;

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
 * @see test.umltordbms.UmltordbmsFactory
 * @model kind="package"
 * @generated
 */
public interface UmltordbmsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "umltordbms";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/examples/0.1/UMLtoRDBMS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "umltordbms";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UmltordbmsPackage eINSTANCE = test.umltordbms.impl.UmltordbmsPackageImpl.init();

	/**
	 * The meta object id for the '{@link test.umltordbms.impl.FromAttributeImpl <em>From Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test.umltordbms.impl.FromAttributeImpl
	 * @see test.umltordbms.impl.UmltordbmsPackageImpl#getFromAttribute()
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
	 * The meta object id for the '{@link test.umltordbms.impl.AttributeToColumnImpl <em>Attribute To Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test.umltordbms.impl.AttributeToColumnImpl
	 * @see test.umltordbms.impl.UmltordbmsPackageImpl#getAttributeToColumn()
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
	 * The meta object id for the '{@link test.umltordbms.impl.ToColumnImpl <em>To Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test.umltordbms.impl.ToColumnImpl
	 * @see test.umltordbms.impl.UmltordbmsPackageImpl#getToColumn()
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
	 * The meta object id for the '{@link test.umltordbms.impl.AssociationToForeignKeyImpl <em>Association To Foreign Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test.umltordbms.impl.AssociationToForeignKeyImpl
	 * @see test.umltordbms.impl.UmltordbmsPackageImpl#getAssociationToForeignKey()
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
	 * The meta object id for the '{@link test.umltordbms.impl.FromAttributeOwnerImpl <em>From Attribute Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test.umltordbms.impl.FromAttributeOwnerImpl
	 * @see test.umltordbms.impl.UmltordbmsPackageImpl#getFromAttributeOwner()
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
	 * The meta object id for the '{@link test.umltordbms.impl.ClassToTableImpl <em>Class To Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test.umltordbms.impl.ClassToTableImpl
	 * @see test.umltordbms.impl.UmltordbmsPackageImpl#getClassToTable()
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
	 * The meta object id for the '{@link test.umltordbms.impl.NonLeafAttributeImpl <em>Non Leaf Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test.umltordbms.impl.NonLeafAttributeImpl
	 * @see test.umltordbms.impl.UmltordbmsPackageImpl#getNonLeafAttribute()
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
	 * The meta object id for the '{@link test.umltordbms.impl.PackageToSchemaImpl <em>Package To Schema</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test.umltordbms.impl.PackageToSchemaImpl
	 * @see test.umltordbms.impl.UmltordbmsPackageImpl#getPackageToSchema()
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
	 * The meta object id for the '{@link test.umltordbms.impl.PrimitiveToNameImpl <em>Primitive To Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test.umltordbms.impl.PrimitiveToNameImpl
	 * @see test.umltordbms.impl.UmltordbmsPackageImpl#getPrimitiveToName()
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
	 * Returns the meta object for class '{@link test.umltordbms.AttributeToColumn <em>Attribute To Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute To Column</em>'.
	 * @see test.umltordbms.AttributeToColumn
	 * @generated
	 */
	EClass getAttributeToColumn();

	/**
	 * Returns the meta object for the reference '{@link test.umltordbms.AttributeToColumn#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see test.umltordbms.AttributeToColumn#getType()
	 * @see #getAttributeToColumn()
	 * @generated
	 */
	EReference getAttributeToColumn_Type();

	/**
	 * Returns the meta object for class '{@link test.umltordbms.AssociationToForeignKey <em>Association To Foreign Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association To Foreign Key</em>'.
	 * @see test.umltordbms.AssociationToForeignKey
	 * @generated
	 */
	EClass getAssociationToForeignKey();

	/**
	 * Returns the meta object for the reference '{@link test.umltordbms.AssociationToForeignKey#getReferenced <em>Referenced</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced</em>'.
	 * @see test.umltordbms.AssociationToForeignKey#getReferenced()
	 * @see #getAssociationToForeignKey()
	 * @generated
	 */
	EReference getAssociationToForeignKey_Referenced();

	/**
	 * Returns the meta object for the container reference '{@link test.umltordbms.AssociationToForeignKey#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see test.umltordbms.AssociationToForeignKey#getOwner()
	 * @see #getAssociationToForeignKey()
	 * @generated
	 */
	EReference getAssociationToForeignKey_Owner();

	/**
	 * Returns the meta object for the attribute '{@link test.umltordbms.AssociationToForeignKey#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see test.umltordbms.AssociationToForeignKey#getName()
	 * @see #getAssociationToForeignKey()
	 * @generated
	 */
	EAttribute getAssociationToForeignKey_Name();

	/**
	 * Returns the meta object for the reference '{@link test.umltordbms.AssociationToForeignKey#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Association</em>'.
	 * @see test.umltordbms.AssociationToForeignKey#getAssociation()
	 * @see #getAssociationToForeignKey()
	 * @generated
	 */
	EReference getAssociationToForeignKey_Association();

	/**
	 * Returns the meta object for the reference '{@link test.umltordbms.AssociationToForeignKey#getForeignKey <em>Foreign Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Foreign Key</em>'.
	 * @see test.umltordbms.AssociationToForeignKey#getForeignKey()
	 * @see #getAssociationToForeignKey()
	 * @generated
	 */
	EReference getAssociationToForeignKey_ForeignKey();

	/**
	 * Returns the meta object for class '{@link test.umltordbms.ClassToTable <em>Class To Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class To Table</em>'.
	 * @see test.umltordbms.ClassToTable
	 * @generated
	 */
	EClass getClassToTable();

	/**
	 * Returns the meta object for the container reference '{@link test.umltordbms.ClassToTable#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see test.umltordbms.ClassToTable#getOwner()
	 * @see #getClassToTable()
	 * @generated
	 */
	EReference getClassToTable_Owner();

	/**
	 * Returns the meta object for the containment reference list '{@link test.umltordbms.ClassToTable#getAssociationsToForeignKeys <em>Associations To Foreign Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Associations To Foreign Keys</em>'.
	 * @see test.umltordbms.ClassToTable#getAssociationsToForeignKeys()
	 * @see #getClassToTable()
	 * @generated
	 */
	EReference getClassToTable_AssociationsToForeignKeys();

	/**
	 * Returns the meta object for the attribute '{@link test.umltordbms.ClassToTable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see test.umltordbms.ClassToTable#getName()
	 * @see #getClassToTable()
	 * @generated
	 */
	EAttribute getClassToTable_Name();

	/**
	 * Returns the meta object for the reference '{@link test.umltordbms.ClassToTable#getUmlClass <em>Uml Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Uml Class</em>'.
	 * @see test.umltordbms.ClassToTable#getUmlClass()
	 * @see #getClassToTable()
	 * @generated
	 */
	EReference getClassToTable_UmlClass();

	/**
	 * Returns the meta object for the reference '{@link test.umltordbms.ClassToTable#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see test.umltordbms.ClassToTable#getTable()
	 * @see #getClassToTable()
	 * @generated
	 */
	EReference getClassToTable_Table();

	/**
	 * Returns the meta object for the reference '{@link test.umltordbms.ClassToTable#getPrimaryKey <em>Primary Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primary Key</em>'.
	 * @see test.umltordbms.ClassToTable#getPrimaryKey()
	 * @see #getClassToTable()
	 * @generated
	 */
	EReference getClassToTable_PrimaryKey();

	/**
	 * Returns the meta object for class '{@link test.umltordbms.FromAttribute <em>From Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From Attribute</em>'.
	 * @see test.umltordbms.FromAttribute
	 * @generated
	 */
	EClass getFromAttribute();

	/**
	 * Returns the meta object for the attribute '{@link test.umltordbms.FromAttribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see test.umltordbms.FromAttribute#getName()
	 * @see #getFromAttribute()
	 * @generated
	 */
	EAttribute getFromAttribute_Name();

	/**
	 * Returns the meta object for the attribute '{@link test.umltordbms.FromAttribute#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see test.umltordbms.FromAttribute#getKind()
	 * @see #getFromAttribute()
	 * @generated
	 */
	EAttribute getFromAttribute_Kind();

	/**
	 * Returns the meta object for the container reference '{@link test.umltordbms.FromAttribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see test.umltordbms.FromAttribute#getOwner()
	 * @see #getFromAttribute()
	 * @generated
	 */
	EReference getFromAttribute_Owner();

	/**
	 * Returns the meta object for the reference list '{@link test.umltordbms.FromAttribute#getLeafs <em>Leafs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Leafs</em>'.
	 * @see test.umltordbms.FromAttribute#getLeafs()
	 * @see #getFromAttribute()
	 * @generated
	 */
	EReference getFromAttribute_Leafs();

	/**
	 * Returns the meta object for the reference '{@link test.umltordbms.FromAttribute#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see test.umltordbms.FromAttribute#getAttribute()
	 * @see #getFromAttribute()
	 * @generated
	 */
	EReference getFromAttribute_Attribute();

	/**
	 * Returns the meta object for class '{@link test.umltordbms.FromAttributeOwner <em>From Attribute Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From Attribute Owner</em>'.
	 * @see test.umltordbms.FromAttributeOwner
	 * @generated
	 */
	EClass getFromAttributeOwner();

	/**
	 * Returns the meta object for the containment reference list '{@link test.umltordbms.FromAttributeOwner#getFromAttributes <em>From Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>From Attributes</em>'.
	 * @see test.umltordbms.FromAttributeOwner#getFromAttributes()
	 * @see #getFromAttributeOwner()
	 * @generated
	 */
	EReference getFromAttributeOwner_FromAttributes();

	/**
	 * Returns the meta object for class '{@link test.umltordbms.NonLeafAttribute <em>Non Leaf Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Leaf Attribute</em>'.
	 * @see test.umltordbms.NonLeafAttribute
	 * @generated
	 */
	EClass getNonLeafAttribute();

	/**
	 * Returns the meta object for class '{@link test.umltordbms.PackageToSchema <em>Package To Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package To Schema</em>'.
	 * @see test.umltordbms.PackageToSchema
	 * @generated
	 */
	EClass getPackageToSchema();

	/**
	 * Returns the meta object for the containment reference list '{@link test.umltordbms.PackageToSchema#getClassesToTables <em>Classes To Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes To Tables</em>'.
	 * @see test.umltordbms.PackageToSchema#getClassesToTables()
	 * @see #getPackageToSchema()
	 * @generated
	 */
	EReference getPackageToSchema_ClassesToTables();

	/**
	 * Returns the meta object for the containment reference list '{@link test.umltordbms.PackageToSchema#getPrimitivesToNames <em>Primitives To Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Primitives To Names</em>'.
	 * @see test.umltordbms.PackageToSchema#getPrimitivesToNames()
	 * @see #getPackageToSchema()
	 * @generated
	 */
	EReference getPackageToSchema_PrimitivesToNames();

	/**
	 * Returns the meta object for the attribute '{@link test.umltordbms.PackageToSchema#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see test.umltordbms.PackageToSchema#getName()
	 * @see #getPackageToSchema()
	 * @generated
	 */
	EAttribute getPackageToSchema_Name();

	/**
	 * Returns the meta object for the reference '{@link test.umltordbms.PackageToSchema#getUmlPackage <em>Uml Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Uml Package</em>'.
	 * @see test.umltordbms.PackageToSchema#getUmlPackage()
	 * @see #getPackageToSchema()
	 * @generated
	 */
	EReference getPackageToSchema_UmlPackage();

	/**
	 * Returns the meta object for the reference '{@link test.umltordbms.PackageToSchema#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Schema</em>'.
	 * @see test.umltordbms.PackageToSchema#getSchema()
	 * @see #getPackageToSchema()
	 * @generated
	 */
	EReference getPackageToSchema_Schema();

	/**
	 * Returns the meta object for class '{@link test.umltordbms.PrimitiveToName <em>Primitive To Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive To Name</em>'.
	 * @see test.umltordbms.PrimitiveToName
	 * @generated
	 */
	EClass getPrimitiveToName();

	/**
	 * Returns the meta object for the container reference '{@link test.umltordbms.PrimitiveToName#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see test.umltordbms.PrimitiveToName#getOwner()
	 * @see #getPrimitiveToName()
	 * @generated
	 */
	EReference getPrimitiveToName_Owner();

	/**
	 * Returns the meta object for the attribute '{@link test.umltordbms.PrimitiveToName#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see test.umltordbms.PrimitiveToName#getName()
	 * @see #getPrimitiveToName()
	 * @generated
	 */
	EAttribute getPrimitiveToName_Name();

	/**
	 * Returns the meta object for the reference '{@link test.umltordbms.PrimitiveToName#getPrimitive <em>Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primitive</em>'.
	 * @see test.umltordbms.PrimitiveToName#getPrimitive()
	 * @see #getPrimitiveToName()
	 * @generated
	 */
	EReference getPrimitiveToName_Primitive();

	/**
	 * Returns the meta object for the attribute '{@link test.umltordbms.PrimitiveToName#getTypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Name</em>'.
	 * @see test.umltordbms.PrimitiveToName#getTypeName()
	 * @see #getPrimitiveToName()
	 * @generated
	 */
	EAttribute getPrimitiveToName_TypeName();

	/**
	 * Returns the meta object for class '{@link test.umltordbms.ToColumn <em>To Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To Column</em>'.
	 * @see test.umltordbms.ToColumn
	 * @generated
	 */
	EClass getToColumn();

	/**
	 * Returns the meta object for the reference '{@link test.umltordbms.ToColumn#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Column</em>'.
	 * @see test.umltordbms.ToColumn#getColumn()
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
	UmltordbmsFactory getUmltordbmsFactory();

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
		 * The meta object literal for the '{@link test.umltordbms.impl.AttributeToColumnImpl <em>Attribute To Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test.umltordbms.impl.AttributeToColumnImpl
		 * @see test.umltordbms.impl.UmltordbmsPackageImpl#getAttributeToColumn()
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
		 * The meta object literal for the '{@link test.umltordbms.impl.AssociationToForeignKeyImpl <em>Association To Foreign Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test.umltordbms.impl.AssociationToForeignKeyImpl
		 * @see test.umltordbms.impl.UmltordbmsPackageImpl#getAssociationToForeignKey()
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
		 * The meta object literal for the '{@link test.umltordbms.impl.ClassToTableImpl <em>Class To Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test.umltordbms.impl.ClassToTableImpl
		 * @see test.umltordbms.impl.UmltordbmsPackageImpl#getClassToTable()
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
		 * The meta object literal for the '{@link test.umltordbms.impl.FromAttributeImpl <em>From Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test.umltordbms.impl.FromAttributeImpl
		 * @see test.umltordbms.impl.UmltordbmsPackageImpl#getFromAttribute()
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
		 * The meta object literal for the '{@link test.umltordbms.impl.FromAttributeOwnerImpl <em>From Attribute Owner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test.umltordbms.impl.FromAttributeOwnerImpl
		 * @see test.umltordbms.impl.UmltordbmsPackageImpl#getFromAttributeOwner()
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
		 * The meta object literal for the '{@link test.umltordbms.impl.NonLeafAttributeImpl <em>Non Leaf Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test.umltordbms.impl.NonLeafAttributeImpl
		 * @see test.umltordbms.impl.UmltordbmsPackageImpl#getNonLeafAttribute()
		 * @generated
		 */
		EClass NON_LEAF_ATTRIBUTE = eINSTANCE.getNonLeafAttribute();

		/**
		 * The meta object literal for the '{@link test.umltordbms.impl.PackageToSchemaImpl <em>Package To Schema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test.umltordbms.impl.PackageToSchemaImpl
		 * @see test.umltordbms.impl.UmltordbmsPackageImpl#getPackageToSchema()
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
		 * The meta object literal for the '{@link test.umltordbms.impl.PrimitiveToNameImpl <em>Primitive To Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test.umltordbms.impl.PrimitiveToNameImpl
		 * @see test.umltordbms.impl.UmltordbmsPackageImpl#getPrimitiveToName()
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
		 * The meta object literal for the '{@link test.umltordbms.impl.ToColumnImpl <em>To Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test.umltordbms.impl.ToColumnImpl
		 * @see test.umltordbms.impl.UmltordbmsPackageImpl#getToColumn()
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

} //UmltordbmsPackage
