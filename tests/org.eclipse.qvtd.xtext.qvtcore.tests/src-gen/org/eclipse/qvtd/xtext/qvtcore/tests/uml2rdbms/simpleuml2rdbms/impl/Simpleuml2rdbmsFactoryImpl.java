/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Simpleuml2rdbmsFactoryImpl extends EFactoryImpl implements Simpleuml2rdbmsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Simpleuml2rdbmsFactory init() {
		try {
			Simpleuml2rdbmsFactory theSimpleuml2rdbmsFactory = (Simpleuml2rdbmsFactory)EPackage.Registry.INSTANCE.getEFactory(Simpleuml2rdbmsPackage.eNS_URI);
			if (theSimpleuml2rdbmsFactory != null) {
				return theSimpleuml2rdbmsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Simpleuml2rdbmsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Simpleuml2rdbmsFactoryImpl() {
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
			case Simpleuml2rdbmsPackage.ATTRIBUTE_TO_COLUMN: return createAttributeToColumn();
			case Simpleuml2rdbmsPackage.ASSOCIATION_TO_FOREIGN_KEY: return createAssociationToForeignKey();
			case Simpleuml2rdbmsPackage.BOOLEAN_TO_BOOLEAN: return createBooleanToBoolean();
			case Simpleuml2rdbmsPackage.CLASS_TO_TABLE: return createClassToTable();
			case Simpleuml2rdbmsPackage.INTEGER_TO_NUMBER: return createIntegerToNumber();
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE: return createNonLeafAttribute();
			case Simpleuml2rdbmsPackage.PACKAGE_TO_SCHEMA: return createPackageToSchema();
			case Simpleuml2rdbmsPackage.STRING_TO_VARCHAR: return createStringToVarchar();
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
	public BooleanToBoolean createBooleanToBoolean() {
		BooleanToBooleanImpl booleanToBoolean = new BooleanToBooleanImpl();
		return booleanToBoolean;
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
	public IntegerToNumber createIntegerToNumber() {
		IntegerToNumberImpl integerToNumber = new IntegerToNumberImpl();
		return integerToNumber;
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
	public StringToVarchar createStringToVarchar() {
		StringToVarcharImpl stringToVarchar = new StringToVarcharImpl();
		return stringToVarchar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Simpleuml2rdbmsPackage getSimpleuml2rdbmsPackage() {
		return (Simpleuml2rdbmsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Simpleuml2rdbmsPackage getPackage() {
		return Simpleuml2rdbmsPackage.eINSTANCE;
	}

} //Simpleuml2rdbmsFactoryImpl
