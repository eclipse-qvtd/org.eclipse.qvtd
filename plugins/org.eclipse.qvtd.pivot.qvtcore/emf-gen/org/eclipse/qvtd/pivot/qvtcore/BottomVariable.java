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
 * A representation of the model object '<em><b>Bottom Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getBottomVariable()
 * @model
 * @generated
 */
public interface BottomVariable extends Variable {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='CompatibleTypeForInitializer'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='ownedInit &lt;&gt; null implies ownedInit.type?.conformsTo(type)\n'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='try {\n\t/**\n\t *\n\t * inv CompatibleTypeForInitializer:\n\t *   let\n\t *     severity : Integer[1] = \'BottomVariable::CompatibleTypeForInitializer\'.getSeverity()\n\t *   in\n\t *     if severity &lt;= 0\n\t *     then true\n\t *     else\n\t *       let result : Boolean[?] = ownedInit &lt;&gt; null implies\n\t *         ownedInit.type?.conformsTo(type)\n\t *       in\n\t *         \'BottomVariable::CompatibleTypeForInitializer\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n\t *     endif\n\t \052/\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.utilities.PivotUtil%&gt;.getExecutor(this, context);\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_BottomVariable_c_c_CompatibleTypeForInitializer);\n\tfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\t/*@NonInvalid\052/ boolean symbol_0;\n\tif (le) {\n\t\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t}\n\telse {\n\t\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Object%&gt; CAUGHT_result;\n\t\ttry {\n\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;OCLExpression%&gt; ownedInit = this.getOwnedInit();\n\t\t\tfinal /*@NonInvalid\052/ boolean ne = ownedInit != null;\n\t\t\t/*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Boolean%&gt; result;\n\t\t\tif (ne) {\n\t\t\t\tif (ownedInit == null) {\n\t\t\t\t\tthrow new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(\"Null source for \\\'TypedElement::type\\\'\");\n\t\t\t\t}\n\t\t\t\tfinal /*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Type%&gt; type = ownedInit.getType();\n\t\t\t\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Object%&gt; CAUGHT_type;\n\t\t\t\ttry {\n\t\t\t\t\tCAUGHT_type = type;\n\t\t\t\t}\n\t\t\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\t\t\tCAUGHT_type = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t\t\t}\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; conformsTo = CAUGHT_type == null;\n\t\t\t\t/*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Boolean%&gt; safe_conformsTo_source;\n\t\t\t\tif (conformsTo == Boolean.TRUE) {\n\t\t\t\t\tsafe_conformsTo_source = null;\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Type%&gt; type_0 = this.getType();\n\t\t\t\t\tfinal /*@Thrown\052/ boolean conformsTo_0 = &lt;%org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation%&gt;.INSTANCE.evaluate(executor, type, type_0).booleanValue();\n\t\t\t\t\tsafe_conformsTo_source = conformsTo_0;\n\t\t\t\t}\n\t\t\t\tresult = safe_conformsTo_source;\n\t\t\t}\n\t\t\telse {\n\t\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t}\n\t\t\tCAUGHT_result = result;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_BottomVariable_c_c_CompatibleTypeForInitializer, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\t\tsymbol_0 = logDiagnostic;\n\t}\n\treturn Boolean.TRUE == symbol_0;\n}\ncatch (&lt;%java.lang.Throwable%&gt; e) {\n\treturn &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.validationFailedDiagnostic(\"BottomVariable::CompatibleTypeForInitializer\", this, diagnostics, context, e);\n}'"
	 * @generated
	 */
	boolean validateCompatibleTypeForInitializer(DiagnosticChain diagnostics, Map<Object, Object> context);
} // BottomVariable
