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
package org.eclipse.qvtd.pivot.qvtcore;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bottom Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getArea <em>Area</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getAssignment <em>Assignment</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getEnforcementOperation <em>Enforcement Operation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getRealizedVariable <em>Realized Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getBottomPattern()
 * @model
 * @generated
 */
public interface BottomPattern extends CorePattern {
	/**
	 * Returns the value of the '<em><b>Area</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtcore.Area#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Area</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Area</em>' container reference.
	 * @see #setArea(Area)
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getBottomPattern_Area()
	 * @see org.eclipse.qvtd.pivot.qvtcore.Area#getBottomPattern
	 * @model opposite="bottomPattern" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTcore!BottomPattern!area'"
	 * @generated
	 */
	@Override
	Area getArea();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getArea <em>Area</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Area</em>' container reference.
	 * @see #getArea()
	 * @generated
	 */
	void setArea(Area value);

	/**
	 * Returns the value of the '<em><b>Assignment</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcore.Assignment}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtcore.Assignment#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignment</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getBottomPattern_Assignment()
	 * @see org.eclipse.qvtd.pivot.qvtcore.Assignment#getBottomPattern
	 * @model opposite="bottomPattern" containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTcore!BottomPattern!assignment'"
	 * @generated
	 */
	EList<Assignment> getAssignment();

	/**
	 * Returns the value of the '<em><b>Enforcement Operation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enforcement Operation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enforcement Operation</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getBottomPattern_EnforcementOperation()
	 * @see org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getBottomPattern
	 * @model opposite="bottomPattern" containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTcore!BottomPattern!enforcementOperation'"
	 * @generated
	 */
	EList<EnforcementOperation> getEnforcementOperation();

	/**
	 * Returns the value of the '<em><b>Realized Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcore.RealizedVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realized Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realized Variable</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getBottomPattern_RealizedVariable()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTcore!BottomPattern!realizedVariable'"
	 * @generated
	 */
	EList<RealizedVariable> getRealizedVariable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='VariablesAreBottomVariables'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv VariablesAreBottomVariables:\n *   let\n *     severity : Integer[1] = \'BottomPattern::VariablesAreBottomVariables\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let\n *         result : Boolean[?] = variable-&gt;forAll(\n *           oclIsKindOf(BottomVariable))\n *       in\n *         \'BottomPattern::VariablesAreBottomVariables\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IdResolver idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_BottomPattern_c_c_VariablesAreBottomVariables);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.lang.Object%&gt; CAUGHT_result;\n\ttry {\n\t\t@SuppressWarnings(\"null\")\n\t\tfinal /*@NonInvalid\052/ java.util.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; List&lt;&lt;%org.eclipse.ocl.pivot.Variable%&gt;&gt; variable = this.getVariable();\n\t\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; SetValue BOXED_variable = idResolver.createSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.SET_CLSSid_Variable, variable);\n\t\t/*@Thrown\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Object accumulator = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.util.Iterator%&gt;&lt;&lt;%java.lang.Object%&gt;&gt; ITERATOR__1 = BOXED_variable.iterator();\n\t\t/*@Thrown\052/ boolean result;\n\t\twhile (true) {\n\t\t\tif (!ITERATOR__1.hasNext()) {\n\t\t\t\tif (accumulator == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\n\t\t\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tthrow (&lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;)accumulator;\n\t\t\t\t}\n\t\t\t\tbreak;\n\t\t\t}\n\t\t\t@SuppressWarnings(\"null\")\n\t\t\t/*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Variable _1 = (&lt;%org.eclipse.ocl.pivot.Variable%&gt;)ITERATOR__1.next();\n\t\t\t/**\n\t\t\t * oclIsKindOf(BottomVariable)\n\t\t\t \052/\n\t\t\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Class TYP_qvtcore_c_c_BottomVariable = idResolver.getClass(&lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.CLSSid_BottomVariable, null);\n\t\t\tfinal /*@NonInvalid\052/ boolean oclIsKindOf = &lt;%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation%&gt;.INSTANCE.evaluate(executor, _1, TYP_qvtcore_c_c_BottomVariable).booleanValue();\n\t\t\t//\n\t\t\tif (oclIsKindOf == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE) {\t\t\t\t\t// Normal unsuccessful body evaluation result\n\t\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE;\n\t\t\t\tbreak;\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Stop immediately\n\t\t\t}\n\t\t\telse if (oclIsKindOf == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\t\t\t\t// Normal successful body evaluation result\n\t\t\t\t;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Carry on\n\t\t\t}\n\t\t\telse {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Impossible badly typed result\n\t\t\t\taccumulator = new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(&lt;%org.eclipse.ocl.pivot.messages.PivotMessages%&gt;.NonBooleanBody, \"forAll\");\n\t\t\t}\n\t\t}\n\t\tCAUGHT_result = result;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_BottomPattern_c_c_VariablesAreBottomVariables, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\tsymbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean validateVariablesAreBottomVariables(DiagnosticChain diagnostics, Map<Object, Object> context);

} // BottomPattern
