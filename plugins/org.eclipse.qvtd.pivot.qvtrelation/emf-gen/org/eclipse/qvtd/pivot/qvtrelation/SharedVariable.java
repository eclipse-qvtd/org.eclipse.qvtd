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
package org.eclipse.qvtd.pivot.qvtrelation;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shared Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.SharedVariable#getTypedModel <em>Typed Model</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getSharedVariable()
 * @model
 * @generated
 */
public interface SharedVariable extends Variable {

	/**
	 * Returns the value of the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typed Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typed Model</em>' reference.
	 * @see #setTypedModel(TypedModel)
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getSharedVariable_TypedModel()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTrelation!SharedVariable!typedModel'"
	 * @generated
	 */
	TypedModel getTypedModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtrelation.SharedVariable#getTypedModel <em>Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typed Model</em>' reference.
	 * @see #getTypedModel()
	 * @generated
	 */
	void setTypedModel(TypedModel value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='CompatibleTypeForInitializer'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv CompatibleTypeForInitializer:\n *   let\n *     severity : Integer[1] = \'SharedVariable::CompatibleTypeForInitializer\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let result : Boolean[?] = ownedInit &lt;&gt; null implies\n *         ownedInit.type?.conformsTo(type)\n *       in\n *         \'SharedVariable::CompatibleTypeForInitializer\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.@org.eclipse.jdt.annotation.NonNull Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.STR_SharedVariable_c_c_CompatibleTypeForInitializer);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ &lt;%@org.eclipse.jdt.annotation.Nullable Object%&gt; CAUGHT_result;\n\ttry {\n\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable OCLExpression%&gt; ownedInit = this.getOwnedInit();\n\t\tfinal /*@NonInvalid\052/ boolean ne = ownedInit != null;\n\t\t/*@Thrown\052/ &lt;%java.lang.@org.eclipse.jdt.annotation.Nullable Boolean%&gt; result;\n\t\tif (ne) {\n\t\t\tif (ownedInit == null) {\n\t\t\t\tthrow new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(\"Null source for \\\'TypedElement::type\\\'\");\n\t\t\t}\n\t\t\tfinal /*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Type%&gt; type = ownedInit.getType();\n\t\t\t/*@Caught\052/ &lt;%@org.eclipse.jdt.annotation.Nullable Object%&gt; CAUGHT_type;\n\t\t\ttry {\n\t\t\t\tCAUGHT_type = type;\n\t\t\t}\n\t\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\t\tCAUGHT_type = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t\t}\n\t\t\tfinal /*@NonInvalid\052/ &lt;%@org.eclipse.jdt.annotation.NonNull Object%&gt; conformsTo = CAUGHT_type == null;\n\t\t\t/*@Thrown\052/ &lt;%java.lang.@org.eclipse.jdt.annotation.Nullable Boolean%&gt; safe_conformsTo_source;\n\t\t\tif (conformsTo == Boolean.TRUE) {\n\t\t\t\tsafe_conformsTo_source = null;\n\t\t\t}\n\t\t\telse {\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Type%&gt; type_0 = this.getType();\n\t\t\t\tfinal /*@Thrown\052/ boolean conformsTo_0 = &lt;%org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation%&gt;.INSTANCE.evaluate(executor, type, type_0).booleanValue();\n\t\t\t\tsafe_conformsTo_source = conformsTo_0;\n\t\t\t}\n\t\t\tresult = safe_conformsTo_source;\n\t\t}\n\t\telse {\n\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t}\n\t\tCAUGHT_result = result;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.STR_SharedVariable_c_c_CompatibleTypeForInitializer, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.INT_0).booleanValue();\n\tsymbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean validateCompatibleTypeForInitializer(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='CompatibleNullityForInitializer'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv CompatibleNullityForInitializer:\n *   let\n *     severity : Integer[1] = \'SharedVariable::CompatibleNullityForInitializer\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let result : Boolean[?] = ownedInit &lt;&gt; null implies ownedInit.isRequired = isRequired\n *       in\n *         \'SharedVariable::CompatibleNullityForInitializer\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.@org.eclipse.jdt.annotation.NonNull Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.STR_SharedVariable_c_c_CompatibleNullityForInitializer);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ &lt;%@org.eclipse.jdt.annotation.NonNull Object%&gt; CAUGHT_result;\n\ttry {\n\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable OCLExpression%&gt; ownedInit = this.getOwnedInit();\n\t\tfinal /*@NonInvalid\052/ boolean ne = ownedInit != null;\n\t\t/*@Thrown\052/ boolean result;\n\t\tif (ne) {\n\t\t\tif (ownedInit == null) {\n\t\t\t\tthrow new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(\"Null source for \\\'TypedElement::isRequired\\\'\");\n\t\t\t}\n\t\t\tfinal /*@Thrown\052/ boolean isRequired = ownedInit.isIsRequired();\n\t\t\tfinal /*@NonInvalid\052/ boolean isRequired_0 = this.isIsRequired();\n\t\t\tfinal /*@Thrown\052/ boolean eq = isRequired == isRequired_0;\n\t\t\tresult = eq;\n\t\t}\n\t\telse {\n\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t}\n\t\tCAUGHT_result = result;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.STR_SharedVariable_c_c_CompatibleNullityForInitializer, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.INT_0).booleanValue();\n\tsymbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean validateCompatibleNullityForInitializer(DiagnosticChain diagnostics, Map<Object, Object> context);
} // SharedVariable
