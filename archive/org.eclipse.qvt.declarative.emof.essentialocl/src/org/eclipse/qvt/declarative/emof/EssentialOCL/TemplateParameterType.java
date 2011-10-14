/**
 * <copyright>
 * </copyright>
 *
 * $Id: TemplateParameterType.java,v 1.1 2009/11/19 10:29:31 ewillink Exp $
 */
package org.eclipse.qvt.declarative.emof.EssentialOCL;

import org.eclipse.qvt.declarative.emof.EMOF.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Parameter Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.EssentialOCL.TemplateParameterType#getSpecification <em>Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage#getTemplateParameterType()
 * @model
 * @generated
 */
public interface TemplateParameterType extends Type {
	/**
	 * Returns the value of the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' attribute.
	 * @see #setSpecification(String)
	 * @see org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage#getTemplateParameterType_Specification()
	 * @model dataType="org.eclipse.qvt.declarative.emof.EMOF.String"
	 * @generated
	 */
	String getSpecification();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.EssentialOCL.TemplateParameterType#getSpecification <em>Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' attribute.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(String value);

} // TemplateParameterType
