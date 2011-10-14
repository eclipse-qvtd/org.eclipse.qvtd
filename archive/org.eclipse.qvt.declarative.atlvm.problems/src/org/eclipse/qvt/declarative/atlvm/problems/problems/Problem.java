/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * </copyright>
 * 
 * Contributors:
 *     Quentin Glineur - initial API and implementation
 *
 * $Id: Problem.java,v 1.2 2008/10/09 17:21:15 qglineur Exp $
 */
package org.eclipse.qvt.declarative.atlvm.problems.problems;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Problem</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getStartColumn <em>Start Column</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getEndLine <em>End Line</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getEndColumn <em>End Column</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getSeverity <em>Severity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.ProblemsPackage#getProblem()
 * @model
 * @generated
 */
public interface Problem extends EObject {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.ProblemsPackage#getProblem_Description()
	 * @model required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Start Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Line</em>' attribute.
	 * @see #setStartLine(Integer)
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.ProblemsPackage#getProblem_StartLine()
	 * @model required="true"
	 * @generated
	 */
	Integer getStartLine();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getStartLine <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Line</em>' attribute.
	 * @see #getStartLine()
	 * @generated
	 */
	void setStartLine(Integer value);

	/**
	 * Returns the value of the '<em><b>Start Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Column</em>' attribute.
	 * @see #setStartColumn(Integer)
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.ProblemsPackage#getProblem_StartColumn()
	 * @model required="true"
	 * @generated
	 */
	Integer getStartColumn();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getStartColumn <em>Start Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Column</em>' attribute.
	 * @see #getStartColumn()
	 * @generated
	 */
	void setStartColumn(Integer value);

	/**
	 * Returns the value of the '<em><b>End Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Line</em>' attribute.
	 * @see #setEndLine(Integer)
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.ProblemsPackage#getProblem_EndLine()
	 * @model required="true"
	 * @generated
	 */
	Integer getEndLine();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getEndLine <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Line</em>' attribute.
	 * @see #getEndLine()
	 * @generated
	 */
	void setEndLine(Integer value);

	/**
	 * Returns the value of the '<em><b>End Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Column</em>' attribute.
	 * @see #setEndColumn(Integer)
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.ProblemsPackage#getProblem_EndColumn()
	 * @model required="true"
	 * @generated
	 */
	Integer getEndColumn();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getEndColumn <em>End Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Column</em>' attribute.
	 * @see #getEndColumn()
	 * @generated
	 */
	void setEndColumn(Integer value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.ProblemsPackage#getProblem_Location()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.qvt.declarative.atlvm.problems.problems.Severity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.Severity
	 * @see #setSeverity(Severity)
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.ProblemsPackage#getProblem_Severity()
	 * @model required="true"
	 * @generated
	 */
	Severity getSeverity();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.Severity
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(Severity value);

} // Problem
