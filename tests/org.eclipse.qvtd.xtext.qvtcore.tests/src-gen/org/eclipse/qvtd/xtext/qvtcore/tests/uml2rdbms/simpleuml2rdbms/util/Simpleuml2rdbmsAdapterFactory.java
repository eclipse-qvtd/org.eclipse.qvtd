/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.jdt.annotation.Nullable;

import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage
 * @generated
 */
public class Simpleuml2rdbmsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Simpleuml2rdbmsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Simpleuml2rdbmsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Simpleuml2rdbmsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Simpleuml2rdbmsSwitch<@Nullable Adapter> modelSwitch =
		new Simpleuml2rdbmsSwitch<@Nullable Adapter>() {
			@Override
			public Adapter caseAttributeToColumn(AttributeToColumn object) {
				return createAttributeToColumnAdapter();
			}
			@Override
			public Adapter caseAssociationToForeignKey(AssociationToForeignKey object) {
				return createAssociationToForeignKeyAdapter();
			}
			@Override
			public Adapter caseBooleanToBoolean(BooleanToBoolean object) {
				return createBooleanToBooleanAdapter();
			}
			@Override
			public Adapter caseClassToTable(ClassToTable object) {
				return createClassToTableAdapter();
			}
			@Override
			public Adapter caseFromAttribute(FromAttribute object) {
				return createFromAttributeAdapter();
			}
			@Override
			public Adapter caseFromAttributeOwner(FromAttributeOwner object) {
				return createFromAttributeOwnerAdapter();
			}
			@Override
			public Adapter caseIntegerToNumber(IntegerToNumber object) {
				return createIntegerToNumberAdapter();
			}
			@Override
			public Adapter caseNonLeafAttribute(NonLeafAttribute object) {
				return createNonLeafAttributeAdapter();
			}
			@Override
			public Adapter casePackageToSchema(PackageToSchema object) {
				return createPackageToSchemaAdapter();
			}
			@Override
			public Adapter casePrimitiveToName(PrimitiveToName object) {
				return createPrimitiveToNameAdapter();
			}
			@Override
			public Adapter caseStringToVarchar(StringToVarchar object) {
				return createStringToVarcharAdapter();
			}
			@Override
			public Adapter caseToColumn(ToColumn object) {
				return createToColumnAdapter();
			}
			@Override
			public Adapter caseUmlToRdbmsModelElement(UmlToRdbmsModelElement object) {
				return createUmlToRdbmsModelElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.AttributeToColumn <em>Attribute To Column</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.AttributeToColumn
	 * @generated
	 */
	public Adapter createAttributeToColumnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.AssociationToForeignKey <em>Association To Foreign Key</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.AssociationToForeignKey
	 * @generated
	 */
	public Adapter createAssociationToForeignKeyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.BooleanToBoolean <em>Boolean To Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.BooleanToBoolean
	 * @generated
	 */
	public Adapter createBooleanToBooleanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.ClassToTable <em>Class To Table</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.ClassToTable
	 * @generated
	 */
	public Adapter createClassToTableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.FromAttribute <em>From Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.FromAttribute
	 * @generated
	 */
	public Adapter createFromAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.FromAttributeOwner <em>From Attribute Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.FromAttributeOwner
	 * @generated
	 */
	public Adapter createFromAttributeOwnerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.IntegerToNumber <em>Integer To Number</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.IntegerToNumber
	 * @generated
	 */
	public Adapter createIntegerToNumberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.NonLeafAttribute <em>Non Leaf Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.NonLeafAttribute
	 * @generated
	 */
	public Adapter createNonLeafAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.PackageToSchema <em>Package To Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.PackageToSchema
	 * @generated
	 */
	public Adapter createPackageToSchemaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.PrimitiveToName <em>Primitive To Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.PrimitiveToName
	 * @generated
	 */
	public Adapter createPrimitiveToNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.StringToVarchar <em>String To Varchar</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.StringToVarchar
	 * @generated
	 */
	public Adapter createStringToVarcharAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.ToColumn <em>To Column</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.ToColumn
	 * @generated
	 */
	public Adapter createToColumnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.UmlToRdbmsModelElement <em>Uml To Rdbms Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.UmlToRdbmsModelElement
	 * @generated
	 */
	public Adapter createUmlToRdbmsModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //Simpleuml2rdbmsAdapterFactory
