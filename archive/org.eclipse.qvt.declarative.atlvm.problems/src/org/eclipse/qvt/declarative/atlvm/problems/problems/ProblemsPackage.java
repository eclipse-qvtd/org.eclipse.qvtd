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
 * $Id: ProblemsPackage.java,v 1.2 2008/10/09 17:21:15 qglineur Exp $
 */
package org.eclipse.qvt.declarative.atlvm.problems.problems;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.ProblemsFactory
 * @model kind="package"
 * @generated
 */
public interface ProblemsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "problems";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/2008/atlvm/problems";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "problems";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProblemsPackage eINSTANCE = org.eclipse.qvt.declarative.atlvm.problems.problems.impl.ProblemsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.impl.ProblemImpl <em>Problem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.impl.ProblemImpl
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.impl.ProblemsPackageImpl#getProblem()
	 * @generated
	 */
	int PROBLEM = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Start Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__START_LINE = 1;

	/**
	 * The feature id for the '<em><b>Start Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__START_COLUMN = 2;

	/**
	 * The feature id for the '<em><b>End Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__END_LINE = 3;

	/**
	 * The feature id for the '<em><b>End Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__END_COLUMN = 4;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__LOCATION = 5;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__SEVERITY = 6;

	/**
	 * The number of structural features of the '<em>Problem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Severity <em>Severity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.Severity
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.impl.ProblemsPackageImpl#getSeverity()
	 * @generated
	 */
	int SEVERITY = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem <em>Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Problem</em>'.
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.Problem
	 * @generated
	 */
	EClass getProblem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getDescription()
	 * @see #getProblem()
	 * @generated
	 */
	EAttribute getProblem_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getStartLine <em>Start Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Line</em>'.
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getStartLine()
	 * @see #getProblem()
	 * @generated
	 */
	EAttribute getProblem_StartLine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getStartColumn <em>Start Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Column</em>'.
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getStartColumn()
	 * @see #getProblem()
	 * @generated
	 */
	EAttribute getProblem_StartColumn();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getEndLine <em>End Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Line</em>'.
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getEndLine()
	 * @see #getProblem()
	 * @generated
	 */
	EAttribute getProblem_EndLine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getEndColumn <em>End Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Column</em>'.
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getEndColumn()
	 * @see #getProblem()
	 * @generated
	 */
	EAttribute getProblem_EndColumn();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getLocation()
	 * @see #getProblem()
	 * @generated
	 */
	EAttribute getProblem_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.Problem#getSeverity()
	 * @see #getProblem()
	 * @generated
	 */
	EAttribute getProblem_Severity();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Severity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Severity</em>'.
	 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.Severity
	 * @generated
	 */
	EEnum getSeverity();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProblemsFactory getProblemsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.impl.ProblemImpl <em>Problem</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.impl.ProblemImpl
		 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.impl.ProblemsPackageImpl#getProblem()
		 * @generated
		 */
		EClass PROBLEM = eINSTANCE.getProblem();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM__DESCRIPTION = eINSTANCE.getProblem_Description();

		/**
		 * The meta object literal for the '<em><b>Start Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM__START_LINE = eINSTANCE.getProblem_StartLine();

		/**
		 * The meta object literal for the '<em><b>Start Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM__START_COLUMN = eINSTANCE.getProblem_StartColumn();

		/**
		 * The meta object literal for the '<em><b>End Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM__END_LINE = eINSTANCE.getProblem_EndLine();

		/**
		 * The meta object literal for the '<em><b>End Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM__END_COLUMN = eINSTANCE.getProblem_EndColumn();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM__LOCATION = eINSTANCE.getProblem_Location();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM__SEVERITY = eINSTANCE.getProblem_Severity();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.atlvm.problems.problems.Severity <em>Severity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.Severity
		 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.impl.ProblemsPackageImpl#getSeverity()
		 * @generated
		 */
		EEnum SEVERITY = eINSTANCE.getSeverity();

	}

} //ProblemsPackage
