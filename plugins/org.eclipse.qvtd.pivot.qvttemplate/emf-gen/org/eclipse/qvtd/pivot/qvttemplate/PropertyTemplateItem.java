/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvttemplate;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ReferringElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Template Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getObjContainer <em>Obj Container</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#isIsOpposite <em>Is Opposite</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getResolvedProperty <em>Resolved Property</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getPropertyTemplateItem()
 * @model
 * @generated
 */
public interface PropertyTemplateItem extends Element, ReferringElement {
	/**
	 * Returns the value of the '<em><b>Obj Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Obj Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obj Container</em>' container reference.
	 * @see #setObjContainer(ObjectTemplateExp)
	 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getPropertyTemplateItem_ObjContainer()
	 * @see org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp#getPart
	 * @model opposite="part" required="true"
	 * @generated
	 */
	ObjectTemplateExp getObjContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getObjContainer <em>Obj Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj Container</em>' container reference.
	 * @see #getObjContainer()
	 * @generated
	 */
	void setObjContainer(ObjectTemplateExp value);

	/**
	 * Returns the value of the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Property</em>' reference.
	 * @see #setReferredProperty(Property)
	 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getPropertyTemplateItem_ReferredProperty()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='propertyItem'"
	 * @generated
	 */
	Property getReferredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getReferredProperty <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Property</em>' reference.
	 * @see #getReferredProperty()
	 * @generated
	 */
	void setReferredProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(OCLExpression)
	 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getPropertyTemplateItem_Value()
	 * @model containment="true" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='propertyItem'"
	 * @generated
	 */
	OCLExpression getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Is Opposite</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Opposite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Opposite</em>' attribute.
	 * @see #setIsOpposite(boolean)
	 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getPropertyTemplateItem_IsOpposite()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsOpposite();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#isIsOpposite <em>Is Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Opposite</em>' attribute.
	 * @see #isIsOpposite()
	 * @generated
	 */
	void setIsOpposite(boolean value);

	/**
	 * Returns the value of the '<em><b>Resolved Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolved Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved Property</em>' reference.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getPropertyTemplateItem_ResolvedProperty()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n\tif isOpposite then referredProperty.opposite else referredProperty endif\n\n'"
	 * @generated
	 */
	Property getResolvedProperty();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='CompatibleClassForProperty'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='Tuple {\n\tmessage : String = objContainer.referredClass.name + \' must conform to \' + resolvedProperty.owningClass?.name,\n\tstatus : Boolean = \n\tobjContainer.referredClass.conformsTo(resolvedProperty.owningClass)\n\n\n}.status'"
	 * @generated
	 */
	boolean validateCompatibleClassForProperty(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='CompatibleTypeForObjectValue'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='Tuple {\n\tmessage : String = value.type?.name + \' must conform to \' + resolvedProperty.type?.name + \' or vice-versa\',\n\tstatus : Boolean = \n\tnot resolvedProperty.type.oclIsKindOf(ocl::CollectionType) implies\n\t\tlet propertyType = resolvedProperty.type in\n\t\tlet valueType = value.type in\n\t\t\tvalueType?.conformsTo(propertyType)\n\t\t\tor propertyType?.conformsTo(valueType)\n\n\n}.status'"
	 * @generated
	 */
	boolean validateCompatibleTypeForObjectValue(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='CompatibleTypeForCollectionElementValue'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='Tuple {\n\tmessage : String = value.type?.name + \' must conform to \' + resolvedProperty.type.oclAsType(ocl::CollectionType).elementType.name + \' or vice-versa\',\n\tstatus : Boolean = \n\tresolvedProperty.type.oclIsKindOf(ocl::CollectionType)\n\tand not value.type.oclIsKindOf(ocl::CollectionType) implies\n\t\tlet propertyType = resolvedProperty.type.oclAsType(ocl::CollectionType).elementType in\n\t\tlet valueType = value.type in\n\t\t\tvalueType?.conformsTo(propertyType)\n\t\t\tor propertyType.conformsTo(valueType)\n\n\n}.status'"
	 * @generated
	 */
	boolean validateCompatibleTypeForCollectionElementValue(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='CompatibleTypeForCollectionValue'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='Tuple {\n\tmessage : String = value.type.oclAsType(ocl::CollectionType).elementType.name + \' must conform to \' + resolvedProperty.type.oclAsType(ocl::CollectionType).elementType.name + \' or vice-versa\',\n\tstatus : Boolean = \n\tresolvedProperty.type.oclIsKindOf(ocl::CollectionType)\n\tand value.type.oclIsKindOf(ocl::CollectionType) implies\n\t\tlet propertyType = resolvedProperty.type.oclAsType(ocl::CollectionType).elementType in\n\t\tlet valueType = value.type.oclAsType(ocl::CollectionType).elementType in\n--\t\tTuple {\n--\t\t\tmessage : String = valueType.conformsTo(propertyType) or propertyType.conformsTo(valueType),\n\t\t\t/*status : Boolean =\052/ valueType.conformsTo(propertyType) or propertyType.conformsTo(valueType)\n\n}.status'"
	 * @generated
	 */
	boolean validateCompatibleTypeForCollectionValue(DiagnosticChain diagnostics, Map<Object, Object> context);

} // PropertyTemplateItem
