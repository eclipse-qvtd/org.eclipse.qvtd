/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
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
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.DomainPattern#getTemplateExpression <em>Template Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getDomainPattern()
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
