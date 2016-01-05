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
package simpleuml2rdbms.uml2rdbms.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.jdt.annotation.Nullable;
import simpleuml2rdbms.uml2rdbms.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage
 * @generated
 */
public class UML2RDBMSSwitch<@Nullable T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UML2RDBMSPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UML2RDBMSSwitch() {
		if (modelPackage == null) {
			modelPackage = UML2RDBMSPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case UML2RDBMSPackage.ATTRIBUTE_TO_COLUMN: {
				AttributeToColumn attributeToColumn = (AttributeToColumn)theEObject;
				T result = caseAttributeToColumn(attributeToColumn);
				if (result == null) result = caseFromAttribute(attributeToColumn);
				if (result == null) result = caseToColumn(attributeToColumn);
				if (result == null) result = caseUmlToRdbmsModelElement(attributeToColumn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UML2RDBMSPackage.ASSOCIATION_TO_FOREIGN_KEY: {
				AssociationToForeignKey associationToForeignKey = (AssociationToForeignKey)theEObject;
				T result = caseAssociationToForeignKey(associationToForeignKey);
				if (result == null) result = caseToColumn(associationToForeignKey);
				if (result == null) result = caseUmlToRdbmsModelElement(associationToForeignKey);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UML2RDBMSPackage.BOOLEAN_TO_BOOLEAN: {
				BooleanToBoolean booleanToBoolean = (BooleanToBoolean)theEObject;
				T result = caseBooleanToBoolean(booleanToBoolean);
				if (result == null) result = casePrimitiveToName(booleanToBoolean);
				if (result == null) result = caseUmlToRdbmsModelElement(booleanToBoolean);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UML2RDBMSPackage.CLASS_TO_TABLE: {
				ClassToTable classToTable = (ClassToTable)theEObject;
				T result = caseClassToTable(classToTable);
				if (result == null) result = caseFromAttributeOwner(classToTable);
				if (result == null) result = caseToColumn(classToTable);
				if (result == null) result = caseUmlToRdbmsModelElement(classToTable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UML2RDBMSPackage.FROM_ATTRIBUTE: {
				FromAttribute fromAttribute = (FromAttribute)theEObject;
				T result = caseFromAttribute(fromAttribute);
				if (result == null) result = caseUmlToRdbmsModelElement(fromAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UML2RDBMSPackage.FROM_ATTRIBUTE_OWNER: {
				FromAttributeOwner fromAttributeOwner = (FromAttributeOwner)theEObject;
				T result = caseFromAttributeOwner(fromAttributeOwner);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UML2RDBMSPackage.INTEGER_TO_NUMBER: {
				IntegerToNumber integerToNumber = (IntegerToNumber)theEObject;
				T result = caseIntegerToNumber(integerToNumber);
				if (result == null) result = casePrimitiveToName(integerToNumber);
				if (result == null) result = caseUmlToRdbmsModelElement(integerToNumber);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE: {
				NonLeafAttribute nonLeafAttribute = (NonLeafAttribute)theEObject;
				T result = caseNonLeafAttribute(nonLeafAttribute);
				if (result == null) result = caseFromAttributeOwner(nonLeafAttribute);
				if (result == null) result = caseFromAttribute(nonLeafAttribute);
				if (result == null) result = caseUmlToRdbmsModelElement(nonLeafAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UML2RDBMSPackage.PACKAGE_TO_SCHEMA: {
				PackageToSchema packageToSchema = (PackageToSchema)theEObject;
				T result = casePackageToSchema(packageToSchema);
				if (result == null) result = caseUmlToRdbmsModelElement(packageToSchema);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UML2RDBMSPackage.PRIMITIVE_TO_NAME: {
				PrimitiveToName primitiveToName = (PrimitiveToName)theEObject;
				T result = casePrimitiveToName(primitiveToName);
				if (result == null) result = caseUmlToRdbmsModelElement(primitiveToName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UML2RDBMSPackage.STRING_TO_VARCHAR: {
				StringToVarchar stringToVarchar = (StringToVarchar)theEObject;
				T result = caseStringToVarchar(stringToVarchar);
				if (result == null) result = casePrimitiveToName(stringToVarchar);
				if (result == null) result = caseUmlToRdbmsModelElement(stringToVarchar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UML2RDBMSPackage.TO_COLUMN: {
				ToColumn toColumn = (ToColumn)theEObject;
				T result = caseToColumn(toColumn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UML2RDBMSPackage.UML_TO_RDBMS_MODEL_ELEMENT: {
				UmlToRdbmsModelElement umlToRdbmsModelElement = (UmlToRdbmsModelElement)theEObject;
				T result = caseUmlToRdbmsModelElement(umlToRdbmsModelElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute To Column</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute To Column</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeToColumn(AttributeToColumn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Association To Foreign Key</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Association To Foreign Key</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssociationToForeignKey(AssociationToForeignKey object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean To Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean To Boolean</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanToBoolean(BooleanToBoolean object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class To Table</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class To Table</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassToTable(ClassToTable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>From Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>From Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFromAttribute(FromAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>From Attribute Owner</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>From Attribute Owner</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFromAttributeOwner(FromAttributeOwner object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer To Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer To Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerToNumber(IntegerToNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Leaf Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Leaf Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonLeafAttribute(NonLeafAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package To Schema</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package To Schema</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageToSchema(PackageToSchema object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive To Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive To Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveToName(PrimitiveToName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To Varchar</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To Varchar</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToVarchar(StringToVarchar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>To Column</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>To Column</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToColumn(ToColumn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Uml To Rdbms Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Uml To Rdbms Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUmlToRdbmsModelElement(UmlToRdbmsModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //UML2RDBMSSwitch
