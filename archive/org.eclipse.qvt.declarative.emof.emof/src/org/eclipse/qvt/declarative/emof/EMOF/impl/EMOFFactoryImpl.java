/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: EMOFFactoryImpl.java,v 1.1 2008/07/23 09:55:19 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.EMOF.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.qvt.declarative.emof.EMOF.Comment;
import org.eclipse.qvt.declarative.emof.EMOF.DataType;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFFactory;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;
import org.eclipse.qvt.declarative.emof.EMOF.Enumeration;
import org.eclipse.qvt.declarative.emof.EMOF.EnumerationLiteral;
import org.eclipse.qvt.declarative.emof.EMOF.Extent;
import org.eclipse.qvt.declarative.emof.EMOF.Factory;
import org.eclipse.qvt.declarative.emof.EMOF.Operation;
import org.eclipse.qvt.declarative.emof.EMOF.Parameter;
import org.eclipse.qvt.declarative.emof.EMOF.PrimitiveType;
import org.eclipse.qvt.declarative.emof.EMOF.Property;
import org.eclipse.qvt.declarative.emof.EMOF.ReflectiveCollection;
import org.eclipse.qvt.declarative.emof.EMOF.ReflectiveSequence;
import org.eclipse.qvt.declarative.emof.EMOF.Tag;
import org.eclipse.qvt.declarative.emof.EMOF.URIExtent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EMOFFactoryImpl extends EFactoryImpl implements EMOFFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EMOFFactory init() {
		try {
			EMOFFactory theEMOFFactory = (EMOFFactory)EPackage.Registry.INSTANCE.getEFactory("http://schema.omg.org/spec/MOF/2.0/emof.xml"); 
			if (theEMOFFactory != null) {
				return theEMOFFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EMOFFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMOFFactoryImpl() {
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
			case EMOFPackage.CLASS: return createClass();
			case EMOFPackage.COMMENT: return createComment();
			case EMOFPackage.DATA_TYPE: return createDataType();
			case EMOFPackage.ENUMERATION: return createEnumeration();
			case EMOFPackage.ENUMERATION_LITERAL: return createEnumerationLiteral();
			case EMOFPackage.EXTENT: return createExtent();
			case EMOFPackage.FACTORY: return createFactory();
			case EMOFPackage.OBJECT: return createObject();
			case EMOFPackage.OPERATION: return createOperation();
			case EMOFPackage.PACKAGE: return createPackage();
			case EMOFPackage.PARAMETER: return createParameter();
			case EMOFPackage.PRIMITIVE_TYPE: return createPrimitiveType();
			case EMOFPackage.PROPERTY: return createProperty();
			case EMOFPackage.REFLECTIVE_COLLECTION: return createReflectiveCollection();
			case EMOFPackage.REFLECTIVE_SEQUENCE: return createReflectiveSequence();
			case EMOFPackage.TAG: return createTag();
			case EMOFPackage.URI_EXTENT: return createURIExtent();
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
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case EMOFPackage.BOOLEAN:
				return createBooleanFromString(eDataType, initialValue);
			case EMOFPackage.INTEGER:
				return createIntegerFromString(eDataType, initialValue);
			case EMOFPackage.REAL:
				return createRealFromString(eDataType, initialValue);
			case EMOFPackage.STRING:
				return createStringFromString(eDataType, initialValue);
			case EMOFPackage.UNLIMITED_NATURAL:
				return createUnlimitedNaturalFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case EMOFPackage.BOOLEAN:
				return convertBooleanToString(eDataType, instanceValue);
			case EMOFPackage.INTEGER:
				return convertIntegerToString(eDataType, instanceValue);
			case EMOFPackage.REAL:
				return convertRealToString(eDataType, instanceValue);
			case EMOFPackage.STRING:
				return convertStringToString(eDataType, instanceValue);
			case EMOFPackage.UNLIMITED_NATURAL:
				return convertUnlimitedNaturalToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.qvt.declarative.emof.EMOF.Class createClass() {
		ClassImpl class_ = new ClassImpl();
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment createComment() {
		CommentImpl comment = new CommentImpl();
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType createDataType() {
		DataTypeImpl dataType = new DataTypeImpl();
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumeration createEnumeration() {
		EnumerationImpl enumeration = new EnumerationImpl();
		return enumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteral createEnumerationLiteral() {
		EnumerationLiteralImpl enumerationLiteral = new EnumerationLiteralImpl();
		return enumerationLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Extent createExtent() {
		ExtentImpl extent = new ExtentImpl();
		return extent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Factory createFactory() {
		FactoryImpl factory = new FactoryImpl();
		return factory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.qvt.declarative.emof.EMOF.Object createObject() {
		ObjectImpl object = new ObjectImpl();
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.qvt.declarative.emof.EMOF.Package createPackage() {
		PackageImpl package_ = new PackageImpl();
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType createPrimitiveType() {
		PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
		return primitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReflectiveCollection createReflectiveCollection() {
		ReflectiveCollectionImpl reflectiveCollection = new ReflectiveCollectionImpl();
		return reflectiveCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReflectiveSequence createReflectiveSequence() {
		ReflectiveSequenceImpl reflectiveSequence = new ReflectiveSequenceImpl();
		return reflectiveSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tag createTag() {
		TagImpl tag = new TagImpl();
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URIExtent createURIExtent() {
		URIExtentImpl uriExtent = new URIExtentImpl();
		return uriExtent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean createBooleanFromString(EDataType eDataType, String initialValue) {
	    if (initialValue == null)
	    	return null;
	    else if ("true".equalsIgnoreCase(initialValue))
			return Boolean.TRUE;
	    else if ("false".equalsIgnoreCase(initialValue))
	    	return Boolean.FALSE;
	    else
	    	throw new IllegalArgumentException("Expecting true or false");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertBooleanToString(EDataType eDataType, Object instanceValue) {
	    return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String createStringFromString(EDataType eDataType, String initialValue) {
		return initialValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertStringToString(EDataType eDataType, Object instanceValue) {
		return (String)instanceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Integer createUnlimitedNaturalFromString(EDataType eDataType, String initialValue) {
	    if (initialValue == null)
	    	return null;
	    else if ("*".equals(initialValue))
	    	return Integer.valueOf(-1);
	    else
	    	return Integer.valueOf(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertUnlimitedNaturalToString(EDataType eDataType, Object instanceValue) {
	    if (instanceValue == null)
	    	return null;
	    else if (((Integer)instanceValue).intValue() < 0)
	    	return "*";
	    else
	    	return instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Integer createIntegerFromString(EDataType eDataType, String initialValue) {
	    return initialValue == null ? null : Integer.valueOf(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertIntegerToString(EDataType eDataType, Object instanceValue) {
	    return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Float createRealFromString(EDataType eDataType, String initialValue) {
	    return initialValue == null ? null : Float.valueOf(initialValue);		// FIXME bigger
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertRealToString(EDataType eDataType, Object instanceValue) {
	    return instanceValue == null ? null : instanceValue.toString();		// FIXME bigger
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMOFPackage getEMOFPackage() {
		return (EMOFPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EMOFPackage getPackage() {
		return EMOFPackage.eINSTANCE;
	}

} //EMOFFactoryImpl
