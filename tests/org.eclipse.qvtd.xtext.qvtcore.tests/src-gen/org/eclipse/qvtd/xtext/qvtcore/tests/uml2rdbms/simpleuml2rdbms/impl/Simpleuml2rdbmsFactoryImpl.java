/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
			case 0: return createAttributeToColumn();
			case 1: return createAssociationToForeignKey();
			case 2: return createBooleanToBoolean();
			case 3: return createClassToTable();
			case 6: return createIntegerToNumber();
			case 7: return createNonLeafAttribute();
			case 8: return createPackageToSchema();
			case 10: return createStringToVarchar();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeToColumn createAttributeToColumn() {
		AttributeToColumnImpl attributeToColumn = new AttributeToColumnImpl();
		return attributeToColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssociationToForeignKey createAssociationToForeignKey() {
		AssociationToForeignKeyImpl associationToForeignKey = new AssociationToForeignKeyImpl();
		return associationToForeignKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BooleanToBoolean createBooleanToBoolean() {
		BooleanToBooleanImpl booleanToBoolean = new BooleanToBooleanImpl();
		return booleanToBoolean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassToTable createClassToTable() {
		ClassToTableImpl classToTable = new ClassToTableImpl();
		return classToTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntegerToNumber createIntegerToNumber() {
		IntegerToNumberImpl integerToNumber = new IntegerToNumberImpl();
		return integerToNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NonLeafAttribute createNonLeafAttribute() {
		NonLeafAttributeImpl nonLeafAttribute = new NonLeafAttributeImpl();
		return nonLeafAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PackageToSchema createPackageToSchema() {
		PackageToSchemaImpl packageToSchema = new PackageToSchemaImpl();
		return packageToSchema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StringToVarchar createStringToVarchar() {
		StringToVarcharImpl stringToVarchar = new StringToVarcharImpl();
		return stringToVarchar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
