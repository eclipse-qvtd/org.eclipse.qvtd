/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtcore;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.pivot.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.VariableAssignment#getTargetVariable <em>Target Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getVariableAssignment()
 * @model
 * @generated
 */
public interface VariableAssignment extends Assignment {
	/**
	 * Returns the value of the '<em><b>Target Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Variable</em>' reference.
	 * @see #setTargetVariable(Variable)
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getVariableAssignment_TargetVariable()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='assignment'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTcore!VariableAssignment!targetVariable'"
	 * @generated
	 */
	Variable getTargetVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtcore.VariableAssignment#getTargetVariable <em>Target Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Variable</em>' reference.
	 * @see #getTargetVariable()
	 * @generated
	 */
	void setTargetVariable(Variable value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='CompatibleTypeForValue'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='Tuple {\n\tmessage : String = \'VariableAssignment::CompatibleTypeForValue: \' + value.type?.name + \' must conform to \' + targetVariable.type?.name + \' or vice-versa\',\n\tstatus : Boolean = \n\ttargetVariable.type?.conformsTo(value.type)\n\tor value.type?.conformsTo(targetVariable.type)\n\n\n}.status'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='try {\n\t/**\n\t *\n\t * inv CompatibleTypeForValue:\n\t *   let\n\t *     severity : Integer[1] = \'VariableAssignment::CompatibleTypeForValue\'.getSeverity()\n\t *   in\n\t *     if severity &lt;= 0\n\t *     then true\n\t *     else\n\t *       let\n\t *         result : OclAny[1] = let\n\t *           status : Boolean[?] = targetVariable.type?.conformsTo(value.type) or\n\t *           value.type?.conformsTo(targetVariable.type)\n\t *         in\n\t *           if status = true\n\t *           then true\n\t *           else\n\t *             Tuple{message = \'VariableAssignment::CompatibleTypeForValue: \' + value.type?.name + \' must conform to \' + targetVariable.type?.name + \' or vice-versa\', status = status\n\t *             }\n\t *           endif\n\t *       in\n\t *         \'VariableAssignment::CompatibleTypeForValue\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n\t *     endif\n\t \052/\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.utilities.PivotUtil%&gt;.getExecutor(this, context);\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_VariableAssignment_c_c_CompatibleTypeForValue);\n\tfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\t/*@NonInvalid\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; symbol_2;\n\tif (le) {\n\t\tsymbol_2 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t}\n\telse {\n\t\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; CAUGHT_symbol_1;\n\t\ttry {\n\t\t\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Object%&gt; CAUGHT_safe_conformsTo_source;\n\t\t\ttry {\n\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Variable%&gt; targetVariable = this.getTargetVariable();\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Type%&gt; type = targetVariable.getType();\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; conformsTo = type == null;\n\t\t\t\t/*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Boolean%&gt; safe_conformsTo_source;\n\t\t\t\tif (conformsTo == Boolean.TRUE) {\n\t\t\t\t\tsafe_conformsTo_source = null;\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;OCLExpression%&gt; value = this.getValue();\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Type%&gt; type_0 = value.getType();\n\t\t\t\t\tfinal /*@Thrown\052/ boolean conformsTo_0 = &lt;%org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation%&gt;.INSTANCE.evaluate(executor, type, type_0).booleanValue();\n\t\t\t\t\tsafe_conformsTo_source = conformsTo_0;\n\t\t\t\t}\n\t\t\t\tCAUGHT_safe_conformsTo_source = safe_conformsTo_source;\n\t\t\t}\n\t\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\t\tCAUGHT_safe_conformsTo_source = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t\t}\n\t\t\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Object%&gt; CAUGHT_safe_conformsTo_source_0;\n\t\t\ttry {\n\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;OCLExpression%&gt; value_0 = this.getValue();\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Type%&gt; type_1 = value_0.getType();\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; conformsTo_1 = type_1 == null;\n\t\t\t\t/*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Boolean%&gt; safe_conformsTo_source_0;\n\t\t\t\tif (conformsTo_1 == Boolean.TRUE) {\n\t\t\t\t\tsafe_conformsTo_source_0 = null;\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Variable%&gt; targetVariable_0 = this.getTargetVariable();\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Type%&gt; type_2 = targetVariable_0.getType();\n\t\t\t\t\tfinal /*@Thrown\052/ boolean conformsTo_2 = &lt;%org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation%&gt;.INSTANCE.evaluate(executor, type_1, type_2).booleanValue();\n\t\t\t\t\tsafe_conformsTo_source_0 = conformsTo_2;\n\t\t\t\t}\n\t\t\t\tCAUGHT_safe_conformsTo_source_0 = safe_conformsTo_source_0;\n\t\t\t}\n\t\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\t\tCAUGHT_safe_conformsTo_source_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t\t}\n\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Boolean%&gt; status = &lt;%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%&gt;.INSTANCE.evaluate(CAUGHT_safe_conformsTo_source, CAUGHT_safe_conformsTo_source_0);\n\t\t\tfinal /*@Thrown\052/ boolean eq = status == Boolean.TRUE;\n\t\t\t/*@Thrown\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; symbol_1;\n\t\t\tif (eq) {\n\t\t\t\tsymbol_1 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t}\n\t\t\telse {\n\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;OCLExpression%&gt; value_1 = this.getValue();\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Type%&gt; type_3 = value_1.getType();\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; name = type_3 == null;\n\t\t\t\t/*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;String%&gt; safe_name_source;\n\t\t\t\tif (name == Boolean.TRUE) {\n\t\t\t\t\tsafe_name_source = null;\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tassert type_3 != null;\n\t\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;String%&gt; name_0 = type_3.getName();\n\t\t\t\t\tsafe_name_source = name_0;\n\t\t\t\t}\n\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;String%&gt; sum = &lt;%org.eclipse.ocl.pivot.library.string.StringConcatOperation%&gt;.INSTANCE.evaluate(&lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_VariableAssignment_c_c_CompatibleTypeForValue_c_32, safe_name_source);\n\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;String%&gt; sum_0 = &lt;%org.eclipse.ocl.pivot.library.string.StringConcatOperation%&gt;.INSTANCE.evaluate(sum, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR__32_must_32_conform_32_to_32);\n\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Variable%&gt; targetVariable_1 = this.getTargetVariable();\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Type%&gt; type_4 = targetVariable_1.getType();\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; name_1 = type_4 == null;\n\t\t\t\t/*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;String%&gt; safe_name_source_0;\n\t\t\t\tif (name_1 == Boolean.TRUE) {\n\t\t\t\t\tsafe_name_source_0 = null;\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tassert type_4 != null;\n\t\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;String%&gt; name_2 = type_4.getName();\n\t\t\t\t\tsafe_name_source_0 = name_2;\n\t\t\t\t}\n\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;String%&gt; sum_1 = &lt;%org.eclipse.ocl.pivot.library.string.StringConcatOperation%&gt;.INSTANCE.evaluate(sum_0, safe_name_source_0);\n\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;String%&gt; sum_2 = &lt;%org.eclipse.ocl.pivot.library.string.StringConcatOperation%&gt;.INSTANCE.evaluate(sum_1, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR__32_or_32_vice_m_versa);\n\t\t\t\tfinal /*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;TupleValue%&gt; symbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createTupleOfEach(&lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.TUPLid_, sum_2, status);\n\t\t\t\tsymbol_1 = symbol_0;\n\t\t\t}\n\t\t\tCAUGHT_symbol_1 = symbol_1;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_symbol_1 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_VariableAssignment_c_c_CompatibleTypeForValue, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_symbol_1, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\t\tsymbol_2 = logDiagnostic;\n\t}\n\treturn Boolean.TRUE == symbol_2;\n}\ncatch (&lt;%java.lang.Throwable%&gt; e) {\n\treturn &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.validationFailedDiagnostic(\"VariableAssignment::CompatibleTypeForValue\", this, diagnostics, context, e);\n}'"
	 * @generated
	 */
	boolean validateCompatibleTypeForValue(DiagnosticChain diagnostics, Map<Object, Object> context);

} // VariableAssignment
