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
package org.eclipse.qvtd.pivot.qvttemplate;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.examples.pivot.LiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.TemplateExp#getBindsTo <em>Binds To</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.TemplateExp#getWhere <em>Where</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getTemplateExp()
 * @model abstract="true"
 * @generated
 */
public interface TemplateExp extends EObject, LiteralExp {
	/**
	 * Returns the value of the '<em><b>Binds To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binds To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binds To</em>' reference.
	 * @see #setBindsTo(Variable)
	 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getTemplateExp_BindsTo()
	 * @model
	 * @generated
	 */
	Variable getBindsTo();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvttemplate.TemplateExp#getBindsTo <em>Binds To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binds To</em>' reference.
	 * @see #getBindsTo()
	 * @generated
	 */
	void setBindsTo(Variable value);

	/**
	 * Returns the value of the '<em><b>Where</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Where</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Where</em>' containment reference.
	 * @see #setWhere(OCLExpression)
	 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getTemplateExp_Where()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='owner'"
	 * @generated
	 */
	OCLExpression getWhere();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvttemplate.TemplateExp#getWhere <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Where</em>' containment reference.
	 * @see #getWhere()
	 * @generated
	 */
	void setWhere(OCLExpression value);

} // TemplateExp
