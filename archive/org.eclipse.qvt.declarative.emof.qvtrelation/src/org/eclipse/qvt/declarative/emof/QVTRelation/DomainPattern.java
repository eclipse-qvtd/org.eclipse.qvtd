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
 * $Id: DomainPattern.java,v 1.1 2008/07/23 09:59:44 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.QVTRelation;

import org.eclipse.qvt.declarative.emof.QVTBase.Pattern;

import org.eclipse.qvt.declarative.emof.QVTTemplate.TemplateExp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTRelation.DomainPattern#getTemplateExpression <em>Template Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage#getDomainPattern()
 * @model
 * @generated
 */
public interface DomainPattern extends Pattern {
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
	 * @see org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage#getDomainPattern_TemplateExpression()
	 * @model containment="true"
	 * @generated
	 */
	TemplateExp getTemplateExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTRelation.DomainPattern#getTemplateExpression <em>Template Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Expression</em>' containment reference.
	 * @see #getTemplateExpression()
	 * @generated
	 */
	void setTemplateExpression(TemplateExp value);

} // DomainPattern
