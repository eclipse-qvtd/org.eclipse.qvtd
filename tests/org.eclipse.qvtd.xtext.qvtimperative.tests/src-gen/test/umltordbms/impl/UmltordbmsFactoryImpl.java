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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import test.umltordbms.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UmltordbmsFactoryImpl extends EFactoryImpl implements UmltordbmsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UmltordbmsFactory init() {
		try {
			UmltordbmsFactory theUmltordbmsFactory = (UmltordbmsFactory)EPackage.Registry.INSTANCE.getEFactory(UmltordbmsPackage.eNS_URI);
			if (theUmltordbmsFactory != null) {
				return theUmltordbmsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UmltordbmsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmltordbmsFactoryImpl() {
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
			case UmltordbmsPackage.ATTRIBUTE_TO_COLUMN: return createAttributeToColumn();
			case UmltordbmsPackage.ASSOCIATION_TO_FOREIGN_KEY: return createAssociationToForeignKey();
			case UmltordbmsPackage.CLASS_TO_TABLE: return createClassToTable();
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE: return createNonLeafAttribute();
			case UmltordbmsPackage.PACKAGE_TO_SCHEMA: return createPackageToSchema();
			case UmltordbmsPackage.PRIMITIVE_TO_NAME: return createPrimitiveToName();
			case UmltordbmsPackage.TO_COLUMN: return createToColumn();
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
	public UmltordbmsPackage getUmltordbmsPackage() {
		return (UmltordbmsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UmltordbmsPackage getPackage() {
		return UmltordbmsPackage.eINSTANCE;
	}

} //UmltordbmsFactoryImpl
