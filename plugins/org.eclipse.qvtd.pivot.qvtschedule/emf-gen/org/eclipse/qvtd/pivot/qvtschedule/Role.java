/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.ocl.pivot.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * @extends Comparable<Role>
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Role defines which of many possible roles an edge plays
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Role#getPhase <em>Phase</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Role#isConstant <em>Constant</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Role#isLoaded <em>Loaded</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Role#isNew <em>New</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Role#isOld <em>Old</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Role#isPredicated <em>Predicated</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Role#isRealized <em>Realized</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Role#isSpeculated <em>Speculated</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Role#isSpeculation <em>Speculation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRole()
 * @model abstract="true"
 * @generated
 */
public interface Role extends Element, Comparable<Role>
{
	/**
	 * Returns the value of the '<em><b>Phase</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.qvtd.pivot.qvtschedule.Phase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phase</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phase</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Phase
	 * @see #setPhase(Phase)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRole_Phase()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Role!phase'"
	 * @generated
	 */
	Phase getPhase();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Role#getPhase <em>Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phase</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Phase
	 * @see #getPhase()
	 * @generated
	 */
	void setPhase(Phase value);

	/**
	 * Returns the value of the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRole_Constant()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * phase = Phase::CONSTANT\n \052/\n@SuppressWarnings(\"null\")\nfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtschedule.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Phase phase = this.getPhase();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; EnumerationLiteralId BOXED_phase = &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ENUMid_Phase.getEnumerationLiteralId(&lt;%org.eclipse.ocl.pivot.utilities.ClassUtil%&gt;.nonNullState(phase.getName()));\nfinal /*@NonInvalid\052/ boolean eq = BOXED_phase == &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ELITid_CONSTANT;\nreturn eq;'"
	 * @generated
	 */
	boolean isConstant();

	/**
	 * Returns the value of the '<em><b>Loaded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loaded</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loaded</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRole_Loaded()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * phase = Phase::LOADED\n \052/\n@SuppressWarnings(\"null\")\nfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtschedule.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Phase phase = this.getPhase();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; EnumerationLiteralId BOXED_phase = &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ENUMid_Phase.getEnumerationLiteralId(&lt;%org.eclipse.ocl.pivot.utilities.ClassUtil%&gt;.nonNullState(phase.getName()));\nfinal /*@NonInvalid\052/ boolean eq = BOXED_phase == &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ELITid_LOADED;\nreturn eq;'"
	 * @generated
	 */
	boolean isLoaded();

	/**
	 * Returns the value of the '<em><b>New</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRole_New()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * phase = Phase::SPECULATION or phase = Phase::REALIZED\n \052/\n@SuppressWarnings(\"null\")\nfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtschedule.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Phase phase_0 = this.getPhase();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; EnumerationLiteralId BOXED_phase_0 = &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ENUMid_Phase.getEnumerationLiteralId(&lt;%org.eclipse.ocl.pivot.utilities.ClassUtil%&gt;.nonNullState(phase_0.getName()));\nfinal /*@NonInvalid\052/ boolean eq = BOXED_phase_0 == &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ELITid_SPECULATION;\n/*@NonInvalid\052/ boolean or;\nif (eq) {\n\tor = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\tfinal /*@NonInvalid\052/ boolean eq_0 = BOXED_phase_0 == &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ELITid_REALIZED;\n\tor = eq_0;\n}\nreturn or;'"
	 * @generated
	 */
	boolean isNew();

	/**
	 * Returns the value of the '<em><b>Old</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRole_Old()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * phase = Phase::CONSTANT or phase = Phase::LOADED or phase = Phase::PREDICATED or phase = Phase::SPECULATED\n \052/\n@SuppressWarnings(\"null\")\nfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtschedule.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Phase phase_2 = this.getPhase();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; EnumerationLiteralId BOXED_phase_2 = &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ENUMid_Phase.getEnumerationLiteralId(&lt;%org.eclipse.ocl.pivot.utilities.ClassUtil%&gt;.nonNullState(phase_2.getName()));\nfinal /*@NonInvalid\052/ boolean eq = BOXED_phase_2 == &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ELITid_CONSTANT;\n/*@NonInvalid\052/ boolean or;\nif (eq) {\n\tor = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\tfinal /*@NonInvalid\052/ boolean eq_0 = BOXED_phase_2 == &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ELITid_LOADED;\n\tor = eq_0;\n}\n/*@NonInvalid\052/ boolean or_0;\nif (or) {\n\tor_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\tfinal /*@NonInvalid\052/ boolean eq_1 = BOXED_phase_2 == &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ELITid_PREDICATED;\n\tor_0 = eq_1;\n}\n/*@NonInvalid\052/ boolean or_1;\nif (or_0) {\n\tor_1 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\tfinal /*@NonInvalid\052/ boolean eq_2 = BOXED_phase_2 == &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ELITid_SPECULATED;\n\tor_1 = eq_2;\n}\nreturn or_1;'"
	 * @generated
	 */
	boolean isOld();

	/**
	 * Returns the value of the '<em><b>Predicated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicated</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRole_Predicated()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * phase = Phase::PREDICATED\n \052/\n@SuppressWarnings(\"null\")\nfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtschedule.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Phase phase = this.getPhase();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; EnumerationLiteralId BOXED_phase = &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ENUMid_Phase.getEnumerationLiteralId(&lt;%org.eclipse.ocl.pivot.utilities.ClassUtil%&gt;.nonNullState(phase.getName()));\nfinal /*@NonInvalid\052/ boolean eq = BOXED_phase == &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ELITid_PREDICATED;\nreturn eq;'"
	 * @generated
	 */
	boolean isPredicated();

	/**
	 * Returns the value of the '<em><b>Realized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realized</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRole_Realized()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * phase = Phase::REALIZED\n \052/\n@SuppressWarnings(\"null\")\nfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtschedule.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Phase phase = this.getPhase();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; EnumerationLiteralId BOXED_phase = &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ENUMid_Phase.getEnumerationLiteralId(&lt;%org.eclipse.ocl.pivot.utilities.ClassUtil%&gt;.nonNullState(phase.getName()));\nfinal /*@NonInvalid\052/ boolean eq = BOXED_phase == &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ELITid_REALIZED;\nreturn eq;'"
	 * @generated
	 */
	boolean isRealized();

	/**
	 * Returns the value of the '<em><b>Speculated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Speculated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speculated</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRole_Speculated()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * phase = Phase::SPECULATED\n \052/\n@SuppressWarnings(\"null\")\nfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtschedule.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Phase phase = this.getPhase();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; EnumerationLiteralId BOXED_phase = &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ENUMid_Phase.getEnumerationLiteralId(&lt;%org.eclipse.ocl.pivot.utilities.ClassUtil%&gt;.nonNullState(phase.getName()));\nfinal /*@NonInvalid\052/ boolean eq = BOXED_phase == &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ELITid_SPECULATED;\nreturn eq;'"
	 * @generated
	 */
	boolean isSpeculated();

	/**
	 * Returns the value of the '<em><b>Speculation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Speculation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speculation</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRole_Speculation()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * phase = Phase::SPECULATION\n \052/\n@SuppressWarnings(\"null\")\nfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtschedule.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Phase phase = this.getPhase();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; EnumerationLiteralId BOXED_phase = &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ENUMid_Phase.getEnumerationLiteralId(&lt;%org.eclipse.ocl.pivot.utilities.ClassUtil%&gt;.nonNullState(phase.getName()));\nfinal /*@NonInvalid\052/ boolean eq = BOXED_phase == &lt;%org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables%&gt;.ELITid_SPECULATION;\nreturn eq;'"
	 * @generated
	 */
	boolean isSpeculation();
} // Role
