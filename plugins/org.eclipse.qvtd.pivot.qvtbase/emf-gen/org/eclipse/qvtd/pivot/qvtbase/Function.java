/*******************************************************************************
 * Copyright (c) 2011, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Function#getQueryExpression <em>Query Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getFunction()
 * @model
 * @generated
 */
public interface Function extends Operation {
	/**
	 * Returns the value of the '<em><b>Query Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Expression</em>' containment reference.
	 * @see #setQueryExpression(OCLExpression)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getFunction_QueryExpression()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTbase!Function!queryExpression'"
	 * @generated
	 */
	OCLExpression getQueryExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.Function#getQueryExpression <em>Query Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Expression</em>' containment reference.
	 * @see #getQueryExpression()
	 * @generated
	 */
	void setQueryExpression(OCLExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='ParametersAreFunctionParameter'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv ParametersAreFunctionParameter:\n *   let\n *     severity : Integer[1] = \'Function::ParametersAreFunctionParameter\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let\n *         status : OclAny[?] = ownedParameters-&gt;forAll(\n *           oclIsKindOf(FunctionParameter))\n *       in\n *         \'Function::ParametersAreFunctionParameter\'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IdResolver idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Function_c_c_ParametersAreFunctionParameter);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.lang.Object%&gt; CAUGHT_status;\n\ttry {\n\t\tfinal /*@Thrown\052/ java.util.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; List&lt;&lt;%org.eclipse.ocl.pivot.Parameter%&gt;&gt; ownedParameters = this.getOwnedParameters();\n\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; OrderedSetValue BOXED_ownedParameters = idResolver.createOrderedSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.ORD_CLSSid_Parameter, ownedParameters);\n\t\t/*@Thrown\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Object accumulator = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.util.Iterator%&gt;&lt;&lt;%java.lang.Object%&gt;&gt; ITERATOR__1 = BOXED_ownedParameters.iterator();\n\t\t/*@Thrown\052/ boolean status;\n\t\twhile (true) {\n\t\t\tif (!ITERATOR__1.hasNext()) {\n\t\t\t\tif (accumulator == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\n\t\t\t\t\tstatus = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tthrow (&lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;)accumulator;\n\t\t\t\t}\n\t\t\t\tbreak;\n\t\t\t}\n\t\t\t@SuppressWarnings(\"null\")\n\t\t\t/*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Parameter _1 = (&lt;%org.eclipse.ocl.pivot.Parameter%&gt;)ITERATOR__1.next();\n\t\t\t/**\n\t\t\t * oclIsKindOf(FunctionParameter)\n\t\t\t \052/\n\t\t\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Class TYP_qvtbase_c_c_FunctionParameter = idResolver.getClass(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.CLSSid_FunctionParameter, null);\n\t\t\tfinal /*@NonInvalid\052/ boolean oclIsKindOf = &lt;%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation%&gt;.INSTANCE.evaluate(executor, _1, TYP_qvtbase_c_c_FunctionParameter).booleanValue();\n\t\t\t//\n\t\t\tif (oclIsKindOf == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE) {\t\t\t\t\t// Normal unsuccessful body evaluation result\n\t\t\t\tstatus = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE;\n\t\t\t\tbreak;\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Stop immediately\n\t\t\t}\n\t\t\telse if (oclIsKindOf == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\t\t\t\t// Normal successful body evaluation result\n\t\t\t\t;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Carry on\n\t\t\t}\n\t\t\telse {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Impossible badly typed result\n\t\t\t\taccumulator = new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(&lt;%org.eclipse.ocl.pivot.messages.PivotMessages%&gt;.NonBooleanBody, \"forAll\");\n\t\t\t}\n\t\t}\n\t\tCAUGHT_status = status;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_status = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Function_c_c_ParametersAreFunctionParameter, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_status, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n\tsymbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean validateParametersAreFunctionParameter(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='ReturnTypeIsQueryType'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv ReturnTypeIsQueryType:\n *   let severity : Integer[1] = \'Function::ReturnTypeIsQueryType\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let status : OclAny[?] = queryExpression &lt;&gt; null implies type = queryExpression.type\n *       in\n *         \'Function::ReturnTypeIsQueryType\'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Function_c_c_ReturnTypeIsQueryType);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.Nullable%&gt; &lt;%java.lang.Object%&gt; CAUGHT_status;\n\ttry {\n\t\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.lang.Object%&gt; CAUGHT_ne;\n\t\ttry {\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; OCLExpression queryExpression = this.getQueryExpression();\n\t\t\tfinal /*@Thrown\052/ boolean ne = queryExpression != null;\n\t\t\tCAUGHT_ne = ne;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_ne = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.lang.Object%&gt; CAUGHT_eq;\n\t\ttry {\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Type type = this.getType();\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; OCLExpression queryExpression_0 = this.getQueryExpression();\n\t\t\tif (queryExpression_0 == null) {\n\t\t\t\tthrow new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(\"Null source for \\\'TypedElement::type\\\'\");\n\t\t\t}\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Type type_0 = queryExpression_0.getType();\n\t\t\tfinal /*@Thrown\052/ boolean eq = (type != null) &amp;&amp; (type_0 != null) ? (type.getTypeId() == type_0.getTypeId()) : false;\n\t\t\tCAUGHT_eq = eq;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_eq = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\tfinal /*@Thrown\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Boolean status = &lt;%org.eclipse.ocl.pivot.library.logical.BooleanImpliesOperation%&gt;.INSTANCE.evaluate(CAUGHT_ne, CAUGHT_eq);\n\t\tCAUGHT_status = status;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_status = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Function_c_c_ReturnTypeIsQueryType, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_status, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n\tsymbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean validateReturnTypeIsQueryType(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Function
