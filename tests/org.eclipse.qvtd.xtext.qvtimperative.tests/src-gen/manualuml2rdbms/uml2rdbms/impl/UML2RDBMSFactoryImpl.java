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

import manualuml2rdbms.uml2rdbms.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UML2RDBMSFactoryImpl extends EFactoryImpl implements UML2RDBMSFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UML2RDBMSFactory init() {
		try {
			UML2RDBMSFactory theUML2RDBMSFactory = (UML2RDBMSFactory)EPackage.Registry.INSTANCE.getEFactory(UML2RDBMSPackage.eNS_URI);
			if (theUML2RDBMSFactory != null) {
				return theUML2RDBMSFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UML2RDBMSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UML2RDBMSFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UML2RDBMSPackage.ATTRIBUTE_TO_COLUMN: return createAttributeToColumn();
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY: return createAssociationToForeignKey();
			case UML2RDBMSPackage.CLASS_TO_TABLE: return createClassToTable();
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE: return createNonLeafAttribute();
			case UML2RDBMSPackage.PACKAGE_TO_SCHEMA: return createPackageToSchema();
			case UML2RDBMSPackage.PRIMITIVE_TO_NAME: return createPrimitiveToName();
			case UML2RDBMSPackage.TO_COLUMN: return createToColumn();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeToColumn createAttributeToColumn() {
		AttributeToColumnImpl attributeToColumn = new AttributeToColumnImpl();
		return attributeToColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationToForeignKey createAssociationToForeignKey() {
		AssociationToForeignKeyImpl associationToForeignKey = new AssociationToForeignKeyImpl();
		return associationToForeignKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassToTable createClassToTable() {
		ClassToTableImpl classToTable = new ClassToTableImpl();
		return classToTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonLeafAttribute createNonLeafAttribute() {
		NonLeafAttributeImpl nonLeafAttribute = new NonLeafAttributeImpl();
		return nonLeafAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageToSchema createPackageToSchema() {
		PackageToSchemaImpl packageToSchema = new PackageToSchemaImpl();
		return packageToSchema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveToName createPrimitiveToName() {
		PrimitiveToNameImpl primitiveToName = new PrimitiveToNameImpl();
		return primitiveToName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToColumn createToColumn() {
		ToColumnImpl toColumn = new ToColumnImpl();
		return toColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UML2RDBMSPackage getUML2RDBMSPackage() {
		return (UML2RDBMSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UML2RDBMSPackage getPackage() {
		return UML2RDBMSPackage.eINSTANCE;
	}

} //UML2RDBMSFactoryImpl
