/**
 * <copyright>
 * 
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.xml;

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
 * @see org.eclipse.qvtd.xml.XMLmodelFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/qvt/2018/PostProcess raw='org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl' processed='org.eclipse.qvtd.xml.utilities.XMLmodelResourceFactoryImpl'"
 * @generated
 */
public interface XMLmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/2018/XML";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sax";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XMLmodelPackage eINSTANCE = org.eclipse.qvtd.xml.impl.XMLmodelPackageImpl.init();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xml.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see org.eclipse.qvtd.xml.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xml.Attribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.xml.Attribute#getName()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xml.Attribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.qvtd.xml.Attribute#getValue()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Value();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xml.Attribute#getEcoreFeature <em>Ecore Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ecore Feature</em>'.
	 * @see org.eclipse.qvtd.xml.Attribute#getEcoreFeature()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_EcoreFeature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xml.CDATA <em>CDATA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CDATA</em>'.
	 * @see org.eclipse.qvtd.xml.CDATA
	 * @generated
	 */
	EClass getCDATA();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xml.Characters <em>Characters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characters</em>'.
	 * @see org.eclipse.qvtd.xml.Characters
	 * @generated
	 */
	EClass getCharacters();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xml.Characters#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.eclipse.qvtd.xml.Characters#getData()
	 * @see #getCharacters()
	 * @generated
	 */
	EAttribute getCharacters_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xml.ClassAttribute <em>Class Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Attribute</em>'.
	 * @see org.eclipse.qvtd.xml.ClassAttribute
	 * @generated
	 */
	EClass getClassAttribute();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xml.ClassAttribute#getEcoreReference <em>Ecore Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ecore Reference</em>'.
	 * @see org.eclipse.qvtd.xml.ClassAttribute#getEcoreReference()
	 * @see #getClassAttribute()
	 * @generated
	 */
	EReference getClassAttribute_EcoreReference();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xml.ClassAttribute#getEObjects <em>EObjects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>EObjects</em>'.
	 * @see org.eclipse.qvtd.xml.ClassAttribute#getEObjects()
	 * @see #getClassAttribute()
	 * @generated
	 */
	EReference getClassAttribute_EObjects();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xml.ClassElement <em>Class Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Element</em>'.
	 * @see org.eclipse.qvtd.xml.ClassElement
	 * @generated
	 */
	EClass getClassElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xml.ClassElement#getEcoreClass <em>Ecore Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ecore Class</em>'.
	 * @see org.eclipse.qvtd.xml.ClassElement#getEcoreClass()
	 * @see #getClassElement()
	 * @generated
	 */
	EReference getClassElement_EcoreClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xml.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see org.eclipse.qvtd.xml.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xml.Comment#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.eclipse.qvtd.xml.Comment#getData()
	 * @see #getComment()
	 * @generated
	 */
	EAttribute getComment_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xml.DTD <em>DTD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DTD</em>'.
	 * @see org.eclipse.qvtd.xml.DTD
	 * @generated
	 */
	EClass getDTD();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xml.DTD#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.xml.DTD#getName()
	 * @see #getDTD()
	 * @generated
	 */
	EAttribute getDTD_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xml.DTD#getPublicId <em>Public Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Public Id</em>'.
	 * @see org.eclipse.qvtd.xml.DTD#getPublicId()
	 * @see #getDTD()
	 * @generated
	 */
	EAttribute getDTD_PublicId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xml.DTD#getSystemId <em>System Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Id</em>'.
	 * @see org.eclipse.qvtd.xml.DTD#getSystemId()
	 * @see #getDTD()
	 * @generated
	 */
	EAttribute getDTD_SystemId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xml.DataTypeAttribute <em>Data Type Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Attribute</em>'.
	 * @see org.eclipse.qvtd.xml.DataTypeAttribute
	 * @generated
	 */
	EClass getDataTypeAttribute();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xml.DataTypeAttribute#getEcoreAttribute <em>Ecore Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ecore Attribute</em>'.
	 * @see org.eclipse.qvtd.xml.DataTypeAttribute#getEcoreAttribute()
	 * @see #getDataTypeAttribute()
	 * @generated
	 */
	EReference getDataTypeAttribute_EcoreAttribute();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xml.DataTypeElement <em>Data Type Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Element</em>'.
	 * @see org.eclipse.qvtd.xml.DataTypeElement
	 * @generated
	 */
	EClass getDataTypeElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xml.DataTypeElement#getEcoreDataType <em>Ecore Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ecore Data Type</em>'.
	 * @see org.eclipse.qvtd.xml.DataTypeElement#getEcoreDataType()
	 * @see #getDataTypeElement()
	 * @generated
	 */
	EReference getDataTypeElement_EcoreDataType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xml.Document <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document</em>'.
	 * @see org.eclipse.qvtd.xml.Document
	 * @generated
	 */
	EClass getDocument();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xml.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.qvtd.xml.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xml.Element#getLocalName <em>Local Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local Name</em>'.
	 * @see org.eclipse.qvtd.xml.Element#getLocalName()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_LocalName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xml.Element#getQName <em>QName</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>QName</em>'.
	 * @see org.eclipse.qvtd.xml.Element#getQName()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_QName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xml.Element#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.qvtd.xml.Element#getUri()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Uri();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xml.Element#getEcoreClassifier <em>Ecore Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ecore Classifier</em>'.
	 * @see org.eclipse.qvtd.xml.Element#getEcoreClassifier()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_EcoreClassifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xml.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see org.eclipse.qvtd.xml.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xml.Entity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.xml.Entity#getName()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xml.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.qvtd.xml.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xml.Node#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.qvtd.xml.Node#getChildren()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Children();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xml.PrefixMapping <em>Prefix Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prefix Mapping</em>'.
	 * @see org.eclipse.qvtd.xml.PrefixMapping
	 * @generated
	 */
	EClass getPrefixMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xml.PrefixMapping#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.eclipse.qvtd.xml.PrefixMapping#getPrefix()
	 * @see #getPrefixMapping()
	 * @generated
	 */
	EAttribute getPrefixMapping_Prefix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xml.PrefixMapping#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.qvtd.xml.PrefixMapping#getUri()
	 * @see #getPrefixMapping()
	 * @generated
	 */
	EAttribute getPrefixMapping_Uri();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xml.ProcessingInstruction <em>Processing Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing Instruction</em>'.
	 * @see org.eclipse.qvtd.xml.ProcessingInstruction
	 * @generated
	 */
	EClass getProcessingInstruction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xml.ProcessingInstruction#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target</em>'.
	 * @see org.eclipse.qvtd.xml.ProcessingInstruction#getTarget()
	 * @see #getProcessingInstruction()
	 * @generated
	 */
	EAttribute getProcessingInstruction_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xml.ProcessingInstruction#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.eclipse.qvtd.xml.ProcessingInstruction#getData()
	 * @see #getProcessingInstruction()
	 * @generated
	 */
	EAttribute getProcessingInstruction_Data();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XMLmodelFactory getXMLmodelFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xml.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xml.impl.AttributeImpl
		 * @see org.eclipse.qvtd.xml.impl.XMLmodelPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

		/**
		 * The meta object literal for the '<em><b>Ecore Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__ECORE_FEATURE = eINSTANCE.getAttribute_EcoreFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xml.impl.CDATAImpl <em>CDATA</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xml.impl.CDATAImpl
		 * @see org.eclipse.qvtd.xml.impl.XMLmodelPackageImpl#getCDATA()
		 * @generated
		 */
		EClass CDATA = eINSTANCE.getCDATA();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xml.impl.CharactersImpl <em>Characters</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xml.impl.CharactersImpl
		 * @see org.eclipse.qvtd.xml.impl.XMLmodelPackageImpl#getCharacters()
		 * @generated
		 */
		EClass CHARACTERS = eINSTANCE.getCharacters();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHARACTERS__DATA = eINSTANCE.getCharacters_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xml.impl.ClassAttributeImpl <em>Class Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xml.impl.ClassAttributeImpl
		 * @see org.eclipse.qvtd.xml.impl.XMLmodelPackageImpl#getClassAttribute()
		 * @generated
		 */
		EClass CLASS_ATTRIBUTE = eINSTANCE.getClassAttribute();

		/**
		 * The meta object literal for the '<em><b>Ecore Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_ATTRIBUTE__ECORE_REFERENCE = eINSTANCE.getClassAttribute_EcoreReference();

		/**
		 * The meta object literal for the '<em><b>EObjects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_ATTRIBUTE__EOBJECTS = eINSTANCE.getClassAttribute_EObjects();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xml.impl.ClassElementImpl <em>Class Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xml.impl.ClassElementImpl
		 * @see org.eclipse.qvtd.xml.impl.XMLmodelPackageImpl#getClassElement()
		 * @generated
		 */
		EClass CLASS_ELEMENT = eINSTANCE.getClassElement();

		/**
		 * The meta object literal for the '<em><b>Ecore Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_ELEMENT__ECORE_CLASS = eINSTANCE.getClassElement_EcoreClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xml.impl.CommentImpl <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xml.impl.CommentImpl
		 * @see org.eclipse.qvtd.xml.impl.XMLmodelPackageImpl#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENT__DATA = eINSTANCE.getComment_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xml.impl.DTDImpl <em>DTD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xml.impl.DTDImpl
		 * @see org.eclipse.qvtd.xml.impl.XMLmodelPackageImpl#getDTD()
		 * @generated
		 */
		EClass DTD = eINSTANCE.getDTD();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DTD__NAME = eINSTANCE.getDTD_Name();

		/**
		 * The meta object literal for the '<em><b>Public Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DTD__PUBLIC_ID = eINSTANCE.getDTD_PublicId();

		/**
		 * The meta object literal for the '<em><b>System Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DTD__SYSTEM_ID = eINSTANCE.getDTD_SystemId();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xml.impl.DataTypeAttributeImpl <em>Data Type Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xml.impl.DataTypeAttributeImpl
		 * @see org.eclipse.qvtd.xml.impl.XMLmodelPackageImpl#getDataTypeAttribute()
		 * @generated
		 */
		EClass DATA_TYPE_ATTRIBUTE = eINSTANCE.getDataTypeAttribute();

		/**
		 * The meta object literal for the '<em><b>Ecore Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_ATTRIBUTE__ECORE_ATTRIBUTE = eINSTANCE.getDataTypeAttribute_EcoreAttribute();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xml.impl.DataTypeElementImpl <em>Data Type Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xml.impl.DataTypeElementImpl
		 * @see org.eclipse.qvtd.xml.impl.XMLmodelPackageImpl#getDataTypeElement()
		 * @generated
		 */
		EClass DATA_TYPE_ELEMENT = eINSTANCE.getDataTypeElement();

		/**
		 * The meta object literal for the '<em><b>Ecore Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_ELEMENT__ECORE_DATA_TYPE = eINSTANCE.getDataTypeElement_EcoreDataType();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xml.impl.DocumentImpl <em>Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xml.impl.DocumentImpl
		 * @see org.eclipse.qvtd.xml.impl.XMLmodelPackageImpl#getDocument()
		 * @generated
		 */
		EClass DOCUMENT = eINSTANCE.getDocument();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xml.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xml.impl.ElementImpl
		 * @see org.eclipse.qvtd.xml.impl.XMLmodelPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Local Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__LOCAL_NAME = eINSTANCE.getElement_LocalName();

		/**
		 * The meta object literal for the '<em><b>QName</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__QNAME = eINSTANCE.getElement_QName();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__URI = eINSTANCE.getElement_Uri();

		/**
		 * The meta object literal for the '<em><b>Ecore Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__ECORE_CLASSIFIER = eINSTANCE.getElement_EcoreClassifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xml.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xml.impl.EntityImpl
		 * @see org.eclipse.qvtd.xml.impl.XMLmodelPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__NAME = eINSTANCE.getEntity_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xml.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xml.impl.NodeImpl
		 * @see org.eclipse.qvtd.xml.impl.XMLmodelPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__CHILDREN = eINSTANCE.getNode_Children();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xml.impl.PrefixMappingImpl <em>Prefix Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xml.impl.PrefixMappingImpl
		 * @see org.eclipse.qvtd.xml.impl.XMLmodelPackageImpl#getPrefixMapping()
		 * @generated
		 */
		EClass PREFIX_MAPPING = eINSTANCE.getPrefixMapping();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFIX_MAPPING__PREFIX = eINSTANCE.getPrefixMapping_Prefix();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFIX_MAPPING__URI = eINSTANCE.getPrefixMapping_Uri();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xml.impl.ProcessingInstructionImpl <em>Processing Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xml.impl.ProcessingInstructionImpl
		 * @see org.eclipse.qvtd.xml.impl.XMLmodelPackageImpl#getProcessingInstruction()
		 * @generated
		 */
		EClass PROCESSING_INSTRUCTION = eINSTANCE.getProcessingInstruction();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSING_INSTRUCTION__TARGET = eINSTANCE.getProcessingInstruction_Target();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSING_INSTRUCTION__DATA = eINSTANCE.getProcessingInstruction_Data();

	}

} //XMLmodelPackage
