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
package simpleuml2rdbms.uml2rdbms;

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
 * @see simpleuml2rdbms.uml2rdbms.UML2RDBMSFactory
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
	String eNS_URI = "http://www.eclipse.org/qvt/examples/0.1/SimpleUML2RDBMS";

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
	UML2RDBMSPackage eINSTANCE = simpleuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl.init();

	/**
	 * Returns the meta object for class '{@link simpleuml2rdbms.uml2rdbms.AttributeToColumn <em>Attribute To Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute To Column</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.AttributeToColumn
	 * @generated
	 */
	EClass getAttributeToColumn();

	/**
	 * Returns the meta object for the reference '{@link simpleuml2rdbms.uml2rdbms.AttributeToColumn#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.AttributeToColumn#getType()
	 * @see #getAttributeToColumn()
	 * @generated
	 */
	EReference getAttributeToColumn_Type();

	/**
	 * Returns the meta object for class '{@link simpleuml2rdbms.uml2rdbms.AssociationToForeignKey <em>Association To Foreign Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association To Foreign Key</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.AssociationToForeignKey
	 * @generated
	 */
	EClass getAssociationToForeignKey();

	/**
	 * Returns the meta object for the reference '{@link simpleuml2rdbms.uml2rdbms.AssociationToForeignKey#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Association</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.AssociationToForeignKey#getAssociation()
	 * @see #getAssociationToForeignKey()
	 * @generated
	 */
	EReference getAssociationToForeignKey_Association();

	/**
	 * Returns the meta object for the reference '{@link simpleuml2rdbms.uml2rdbms.AssociationToForeignKey#getForeignKey <em>Foreign Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Foreign Key</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.AssociationToForeignKey#getForeignKey()
	 * @see #getAssociationToForeignKey()
	 * @generated
	 */
	EReference getAssociationToForeignKey_ForeignKey();

	/**
	 * Returns the meta object for the container reference '{@link simpleuml2rdbms.uml2rdbms.AssociationToForeignKey#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.AssociationToForeignKey#getOwner()
	 * @see #getAssociationToForeignKey()
	 * @generated
	 */
	EReference getAssociationToForeignKey_Owner();

	/**
	 * Returns the meta object for the reference '{@link simpleuml2rdbms.uml2rdbms.AssociationToForeignKey#getReferenced <em>Referenced</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.AssociationToForeignKey#getReferenced()
	 * @see #getAssociationToForeignKey()
	 * @generated
	 */
	EReference getAssociationToForeignKey_Referenced();

	/**
	 * Returns the meta object for class '{@link simpleuml2rdbms.uml2rdbms.BooleanToBoolean <em>Boolean To Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean To Boolean</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.BooleanToBoolean
	 * @generated
	 */
	EClass getBooleanToBoolean();

	/**
	 * Returns the meta object for class '{@link simpleuml2rdbms.uml2rdbms.ClassToTable <em>Class To Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class To Table</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.ClassToTable
	 * @generated
	 */
	EClass getClassToTable();

	/**
	 * Returns the meta object for the containment reference list '{@link simpleuml2rdbms.uml2rdbms.ClassToTable#getAssociationsToForeignKeys <em>Associations To Foreign Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Associations To Foreign Keys</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.ClassToTable#getAssociationsToForeignKeys()
	 * @see #getClassToTable()
	 * @generated
	 */
	EReference getClassToTable_AssociationsToForeignKeys();

	/**
	 * Returns the meta object for the container reference '{@link simpleuml2rdbms.uml2rdbms.ClassToTable#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.ClassToTable#getOwner()
	 * @see #getClassToTable()
	 * @generated
	 */
	EReference getClassToTable_Owner();

	/**
	 * Returns the meta object for the reference '{@link simpleuml2rdbms.uml2rdbms.ClassToTable#getPrimaryKey <em>Primary Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primary Key</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.ClassToTable#getPrimaryKey()
	 * @see #getClassToTable()
	 * @generated
	 */
	EReference getClassToTable_PrimaryKey();

	/**
	 * Returns the meta object for the reference '{@link simpleuml2rdbms.uml2rdbms.ClassToTable#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.ClassToTable#getTable()
	 * @see #getClassToTable()
	 * @generated
	 */
	EReference getClassToTable_Table();

	/**
	 * Returns the meta object for the reference '{@link simpleuml2rdbms.uml2rdbms.ClassToTable#getUmlClass <em>Uml Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Uml Class</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.ClassToTable#getUmlClass()
	 * @see #getClassToTable()
	 * @generated
	 */
	EReference getClassToTable_UmlClass();

	/**
	 * Returns the meta object for class '{@link simpleuml2rdbms.uml2rdbms.FromAttribute <em>From Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From Attribute</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.FromAttribute
	 * @generated
	 */
	EClass getFromAttribute();

	/**
	 * Returns the meta object for the attribute '{@link simpleuml2rdbms.uml2rdbms.FromAttribute#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.FromAttribute#getKind()
	 * @see #getFromAttribute()
	 * @generated
	 */
	EAttribute getFromAttribute_Kind();

	/**
	 * Returns the meta object for the reference '{@link simpleuml2rdbms.uml2rdbms.FromAttribute#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.FromAttribute#getAttribute()
	 * @see #getFromAttribute()
	 * @generated
	 */
	EReference getFromAttribute_Attribute();

	/**
	 * Returns the meta object for the reference list '{@link simpleuml2rdbms.uml2rdbms.FromAttribute#getLeafs <em>Leafs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Leafs</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.FromAttribute#getLeafs()
	 * @see #getFromAttribute()
	 * @generated
	 */
	EReference getFromAttribute_Leafs();

	/**
	 * Returns the meta object for the container reference '{@link simpleuml2rdbms.uml2rdbms.FromAttribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.FromAttribute#getOwner()
	 * @see #getFromAttribute()
	 * @generated
	 */
	EReference getFromAttribute_Owner();

	/**
	 * Returns the meta object for class '{@link simpleuml2rdbms.uml2rdbms.FromAttributeOwner <em>From Attribute Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From Attribute Owner</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.FromAttributeOwner
	 * @generated
	 */
	EClass getFromAttributeOwner();

	/**
	 * Returns the meta object for the containment reference list '{@link simpleuml2rdbms.uml2rdbms.FromAttributeOwner#getFromAttributes <em>From Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>From Attributes</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.FromAttributeOwner#getFromAttributes()
	 * @see #getFromAttributeOwner()
	 * @generated
	 */
	EReference getFromAttributeOwner_FromAttributes();

	/**
	 * Returns the meta object for class '{@link simpleuml2rdbms.uml2rdbms.IntegerToNumber <em>Integer To Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer To Number</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.IntegerToNumber
	 * @generated
	 */
	EClass getIntegerToNumber();

	/**
	 * Returns the meta object for class '{@link simpleuml2rdbms.uml2rdbms.NonLeafAttribute <em>Non Leaf Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Leaf Attribute</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.NonLeafAttribute
	 * @generated
	 */
	EClass getNonLeafAttribute();

	/**
	 * Returns the meta object for class '{@link simpleuml2rdbms.uml2rdbms.PackageToSchema <em>Package To Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package To Schema</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.PackageToSchema
	 * @generated
	 */
	EClass getPackageToSchema();

	/**
	 * Returns the meta object for the containment reference list '{@link simpleuml2rdbms.uml2rdbms.PackageToSchema#getClassesToTables <em>Classes To Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes To Tables</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.PackageToSchema#getClassesToTables()
	 * @see #getPackageToSchema()
	 * @generated
	 */
	EReference getPackageToSchema_ClassesToTables();

	/**
	 * Returns the meta object for the containment reference list '{@link simpleuml2rdbms.uml2rdbms.PackageToSchema#getPrimitivesToNames <em>Primitives To Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Primitives To Names</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.PackageToSchema#getPrimitivesToNames()
	 * @see #getPackageToSchema()
	 * @generated
	 */
	EReference getPackageToSchema_PrimitivesToNames();

	/**
	 * Returns the meta object for the reference '{@link simpleuml2rdbms.uml2rdbms.PackageToSchema#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Schema</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.PackageToSchema#getSchema()
	 * @see #getPackageToSchema()
	 * @generated
	 */
	EReference getPackageToSchema_Schema();

	/**
	 * Returns the meta object for the reference '{@link simpleuml2rdbms.uml2rdbms.PackageToSchema#getUmlPackage <em>Uml Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Uml Package</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.PackageToSchema#getUmlPackage()
	 * @see #getPackageToSchema()
	 * @generated
	 */
	EReference getPackageToSchema_UmlPackage();

	/**
	 * Returns the meta object for class '{@link simpleuml2rdbms.uml2rdbms.PrimitiveToName <em>Primitive To Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive To Name</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.PrimitiveToName
	 * @generated
	 */
	EClass getPrimitiveToName();

	/**
	 * Returns the meta object for the attribute '{@link simpleuml2rdbms.uml2rdbms.PrimitiveToName#getTypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Name</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.PrimitiveToName#getTypeName()
	 * @see #getPrimitiveToName()
	 * @generated
	 */
	EAttribute getPrimitiveToName_TypeName();

	/**
	 * Returns the meta object for the container reference '{@link simpleuml2rdbms.uml2rdbms.PrimitiveToName#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.PrimitiveToName#getOwner()
	 * @see #getPrimitiveToName()
	 * @generated
	 */
	EReference getPrimitiveToName_Owner();

	/**
	 * Returns the meta object for the reference '{@link simpleuml2rdbms.uml2rdbms.PrimitiveToName#getPrimitive <em>Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primitive</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.PrimitiveToName#getPrimitive()
	 * @see #getPrimitiveToName()
	 * @generated
	 */
	EReference getPrimitiveToName_Primitive();

	/**
	 * Returns the meta object for class '{@link simpleuml2rdbms.uml2rdbms.StringToVarchar <em>String To Varchar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To Varchar</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.StringToVarchar
	 * @generated
	 */
	EClass getStringToVarchar();

	/**
	 * Returns the meta object for class '{@link simpleuml2rdbms.uml2rdbms.ToColumn <em>To Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To Column</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.ToColumn
	 * @generated
	 */
	EClass getToColumn();

	/**
	 * Returns the meta object for the reference '{@link simpleuml2rdbms.uml2rdbms.ToColumn#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Column</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.ToColumn#getColumn()
	 * @see #getToColumn()
	 * @generated
	 */
	EReference getToColumn_Column();

	/**
	 * Returns the meta object for class '{@link simpleuml2rdbms.uml2rdbms.UmlToRdbmsModelElement <em>Uml To Rdbms Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Uml To Rdbms Model Element</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.UmlToRdbmsModelElement
	 * @generated
	 */
	EClass getUmlToRdbmsModelElement();

	/**
	 * Returns the meta object for the attribute '{@link simpleuml2rdbms.uml2rdbms.UmlToRdbmsModelElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see simpleuml2rdbms.uml2rdbms.UmlToRdbmsModelElement#getName()
	 * @see #getUmlToRdbmsModelElement()
	 * @generated
	 */
	EAttribute getUmlToRdbmsModelElement_Name();

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
		 * The meta object literal for the '{@link simpleuml2rdbms.uml2rdbms.impl.AttributeToColumnImpl <em>Attribute To Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml2rdbms.uml2rdbms.impl.AttributeToColumnImpl
		 * @see simpleuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getAttributeToColumn()
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
		 * The meta object literal for the '{@link simpleuml2rdbms.uml2rdbms.impl.AssociationToForeignKeyImpl <em>Association To Foreign Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml2rdbms.uml2rdbms.impl.AssociationToForeignKeyImpl
		 * @see simpleuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getAssociationToForeignKey()
		 * @generated
		 */
		EClass ASSOCIATION_TO_FOREIGN_KEY = eINSTANCE.getAssociationToForeignKey();

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
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_TO_FOREIGN_KEY__OWNER = eINSTANCE.getAssociationToForeignKey_Owner();

		/**
		 * The meta object literal for the '<em><b>Referenced</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_TO_FOREIGN_KEY__REFERENCED = eINSTANCE.getAssociationToForeignKey_Referenced();

		/**
		 * The meta object literal for the '{@link simpleuml2rdbms.uml2rdbms.impl.BooleanToBooleanImpl <em>Boolean To Boolean</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml2rdbms.uml2rdbms.impl.BooleanToBooleanImpl
		 * @see simpleuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getBooleanToBoolean()
		 * @generated
		 */
		EClass BOOLEAN_TO_BOOLEAN = eINSTANCE.getBooleanToBoolean();

		/**
		 * The meta object literal for the '{@link simpleuml2rdbms.uml2rdbms.impl.ClassToTableImpl <em>Class To Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml2rdbms.uml2rdbms.impl.ClassToTableImpl
		 * @see simpleuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getClassToTable()
		 * @generated
		 */
		EClass CLASS_TO_TABLE = eINSTANCE.getClassToTable();

		/**
		 * The meta object literal for the '<em><b>Associations To Foreign Keys</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TO_TABLE__ASSOCIATIONS_TO_FOREIGN_KEYS = eINSTANCE.getClassToTable_AssociationsToForeignKeys();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TO_TABLE__OWNER = eINSTANCE.getClassToTable_Owner();

		/**
		 * The meta object literal for the '<em><b>Primary Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TO_TABLE__PRIMARY_KEY = eINSTANCE.getClassToTable_PrimaryKey();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TO_TABLE__TABLE = eINSTANCE.getClassToTable_Table();

		/**
		 * The meta object literal for the '<em><b>Uml Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TO_TABLE__UML_CLASS = eINSTANCE.getClassToTable_UmlClass();

		/**
		 * The meta object literal for the '{@link simpleuml2rdbms.uml2rdbms.impl.FromAttributeImpl <em>From Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml2rdbms.uml2rdbms.impl.FromAttributeImpl
		 * @see simpleuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getFromAttribute()
		 * @generated
		 */
		EClass FROM_ATTRIBUTE = eINSTANCE.getFromAttribute();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FROM_ATTRIBUTE__KIND = eINSTANCE.getFromAttribute_Kind();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_ATTRIBUTE__ATTRIBUTE = eINSTANCE.getFromAttribute_Attribute();

		/**
		 * The meta object literal for the '<em><b>Leafs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_ATTRIBUTE__LEAFS = eINSTANCE.getFromAttribute_Leafs();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_ATTRIBUTE__OWNER = eINSTANCE.getFromAttribute_Owner();

		/**
		 * The meta object literal for the '{@link simpleuml2rdbms.uml2rdbms.impl.FromAttributeOwnerImpl <em>From Attribute Owner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml2rdbms.uml2rdbms.impl.FromAttributeOwnerImpl
		 * @see simpleuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getFromAttributeOwner()
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
		 * The meta object literal for the '{@link simpleuml2rdbms.uml2rdbms.impl.IntegerToNumberImpl <em>Integer To Number</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml2rdbms.uml2rdbms.impl.IntegerToNumberImpl
		 * @see simpleuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getIntegerToNumber()
		 * @generated
		 */
		EClass INTEGER_TO_NUMBER = eINSTANCE.getIntegerToNumber();

		/**
		 * The meta object literal for the '{@link simpleuml2rdbms.uml2rdbms.impl.NonLeafAttributeImpl <em>Non Leaf Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml2rdbms.uml2rdbms.impl.NonLeafAttributeImpl
		 * @see simpleuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getNonLeafAttribute()
		 * @generated
		 */
		EClass NON_LEAF_ATTRIBUTE = eINSTANCE.getNonLeafAttribute();

		/**
		 * The meta object literal for the '{@link simpleuml2rdbms.uml2rdbms.impl.PackageToSchemaImpl <em>Package To Schema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml2rdbms.uml2rdbms.impl.PackageToSchemaImpl
		 * @see simpleuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getPackageToSchema()
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
		 * The meta object literal for the '<em><b>Schema</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_TO_SCHEMA__SCHEMA = eINSTANCE.getPackageToSchema_Schema();

		/**
		 * The meta object literal for the '<em><b>Uml Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_TO_SCHEMA__UML_PACKAGE = eINSTANCE.getPackageToSchema_UmlPackage();

		/**
		 * The meta object literal for the '{@link simpleuml2rdbms.uml2rdbms.impl.PrimitiveToNameImpl <em>Primitive To Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml2rdbms.uml2rdbms.impl.PrimitiveToNameImpl
		 * @see simpleuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getPrimitiveToName()
		 * @generated
		 */
		EClass PRIMITIVE_TO_NAME = eINSTANCE.getPrimitiveToName();

		/**
		 * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TO_NAME__TYPE_NAME = eINSTANCE.getPrimitiveToName_TypeName();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_TO_NAME__OWNER = eINSTANCE.getPrimitiveToName_Owner();

		/**
		 * The meta object literal for the '<em><b>Primitive</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_TO_NAME__PRIMITIVE = eINSTANCE.getPrimitiveToName_Primitive();

		/**
		 * The meta object literal for the '{@link simpleuml2rdbms.uml2rdbms.impl.StringToVarcharImpl <em>String To Varchar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml2rdbms.uml2rdbms.impl.StringToVarcharImpl
		 * @see simpleuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getStringToVarchar()
		 * @generated
		 */
		EClass STRING_TO_VARCHAR = eINSTANCE.getStringToVarchar();

		/**
		 * The meta object literal for the '{@link simpleuml2rdbms.uml2rdbms.impl.ToColumnImpl <em>To Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml2rdbms.uml2rdbms.impl.ToColumnImpl
		 * @see simpleuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getToColumn()
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

		/**
		 * The meta object literal for the '{@link simpleuml2rdbms.uml2rdbms.impl.UmlToRdbmsModelElementImpl <em>Uml To Rdbms Model Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml2rdbms.uml2rdbms.impl.UmlToRdbmsModelElementImpl
		 * @see simpleuml2rdbms.uml2rdbms.impl.UML2RDBMSPackageImpl#getUmlToRdbmsModelElement()
		 * @generated
		 */
		EClass UML_TO_RDBMS_MODEL_ELEMENT = eINSTANCE.getUmlToRdbmsModelElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UML_TO_RDBMS_MODEL_ELEMENT__NAME = eINSTANCE.getUmlToRdbmsModelElement_Name();

	}

} //UML2RDBMSPackage
