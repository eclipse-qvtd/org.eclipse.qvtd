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
package org.eclipse.qvtd.pivot.qvtrelation;

import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.DomainPattern#getRelationDomain <em>Relation Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.DomainPattern#getTemplateExpression <em>Template Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getDomainPattern()
 * @model
 * @generated
 */
public interface DomainPattern extends Pattern {
	/**
	 * Returns the value of the '<em><b>Relation Domain</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation Domain</em>' container reference.
	 * @see #setRelationDomain(RelationDomain)
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getDomainPattern_RelationDomain()
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getPattern
	 * @model opposite="pattern" required="true" transient="false"
	 * @generated
	 */
	RelationDomain getRelationDomain();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtrelation.DomainPattern#getRelationDomain <em>Relation Domain</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation Domain</em>' container reference.
	 * @see #getRelationDomain()
	 * @generated
	 */
	void setRelationDomain(RelationDomain value);

	/**
	 * Returns the value of the '<em><b>Template Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Expression</em>' containment reference.
	 * @see #setTemplateExpression(TemplateExp)
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getDomainPattern_TemplateExpression()
	 * @model containment="true"
	 * @generated
	 */
	TemplateExp getTemplateExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtrelation.DomainPattern#getTemplateExpression <em>Template Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Expression</em>' containment reference.
	 * @see #getTemplateExpression()
	 * @generated
	 */
	void setTemplateExpression(TemplateExp value);

} // DomainPattern
