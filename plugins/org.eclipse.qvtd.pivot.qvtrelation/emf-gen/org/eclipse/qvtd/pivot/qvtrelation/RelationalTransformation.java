/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relational Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation#getOwnedKey <em>Owned Key</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelationalTransformation()
 * @model
 * @generated
 */
public interface RelationalTransformation extends Transformation {
	/**
	 * Returns the value of the '<em><b>Owned Key</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtrelation.Key}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Key</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Key</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelationalTransformation_OwnedKey()
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#getTransformation
	 * @model opposite="transformation" containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTrelation!RelationalTransformation!ownedKey'"
	 * @generated
	 */
	EList<Key> getOwnedKey();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='RulesAreRelations'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv RulesAreRelations:\n *   let\n *     severity : Integer[1] = \'RelationalTransformation::RulesAreRelations\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let\n *         result : Boolean[?] = rule-&gt;forAll(oclIsKindOf(Relation))\n *       in\n *         \'RelationalTransformation::RulesAreRelations\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.@org.eclipse.jdt.annotation.NonNull Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver%&gt; idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.STR_RelationalTransformation_c_c_RulesAreRelations);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\tfinal /*@NonInvalid\052/ &lt;%java.util.@org.eclipse.jdt.annotation.NonNull List%&gt;&lt;&lt;%org.eclipse.qvtd.pivot.qvtbase.Rule%&gt;&gt; rule = this.getRule();\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue%&gt; BOXED_rule = idResolver.createSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.SET_CLSSid_Rule, rule);\n\t/*@Thrown\052/ &lt;%@org.eclipse.jdt.annotation.Nullable Object%&gt; accumulator = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t&lt;%java.util.@org.eclipse.jdt.annotation.NonNull Iterator%&gt;&lt;&lt;%java.lang.Object%&gt;&gt; ITERATOR__1 = BOXED_rule.iterator();\n\t/*@NonInvalid\052/ &lt;%java.lang.@org.eclipse.jdt.annotation.Nullable Boolean%&gt; result;\n\twhile (true) {\n\t\tif (!ITERATOR__1.hasNext()) {\n\t\t\tif (accumulator == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\n\t\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t}\n\t\t\telse {\n\t\t\t\tthrow (&lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;)accumulator;\n\t\t\t}\n\t\t\tbreak;\n\t\t}\n\t\t@SuppressWarnings(\"null\")\n\t\t/*@NonInvalid\052/ &lt;%org.eclipse.qvtd.pivot.qvtbase.@org.eclipse.jdt.annotation.NonNull Rule%&gt; _1 = (&lt;%org.eclipse.qvtd.pivot.qvtbase.@org.eclipse.jdt.annotation.NonNull Rule%&gt;)ITERATOR__1.next();\n\t\t/**\n\t\t * oclIsKindOf(Relation)\n\t\t \052/\n\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class%&gt; TYP_qvtrelation_c_c_Relation_0 = idResolver.getClass(&lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.CLSSid_Relation, null);\n\t\tfinal /*@NonInvalid\052/ boolean oclIsKindOf = &lt;%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation%&gt;.INSTANCE.evaluate(executor, _1, TYP_qvtrelation_c_c_Relation_0).booleanValue();\n\t\t//\n\t\tif (oclIsKindOf == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE) {\t\t\t\t\t// Normal unsuccessful body evaluation result\n\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE;\n\t\t\tbreak;\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Stop immediately\n\t\t}\n\t\telse if (oclIsKindOf == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\t\t\t\t// Normal successful body evaluation result\n\t\t\t;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Carry on\n\t\t}\n\t\telse {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Impossible badly typed result\n\t\t\taccumulator = new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(&lt;%org.eclipse.ocl.pivot.messages.PivotMessages%&gt;.NonBooleanBody, \"forAll\");\n\t\t}\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.STR_RelationalTransformation_c_c_RulesAreRelations, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.INT_0).booleanValue();\n\tsymbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean validateRulesAreRelations(DiagnosticChain diagnostics, Map<Object, Object> context);

} // RelationalTransformation
