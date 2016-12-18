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
package org.eclipse.qvtd.pivot.qvtrelation;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#getReferredRelation <em>Referred Relation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelationCallExp()
 * @model
 * @generated
 */
public interface RelationCallExp extends OCLExpression {
	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.OCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelationCallExp_Argument()
	 * @model containment="true" lower="2"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='relationCallExp'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTrelation!RelationCallExp!argument'"
	 * @generated
	 */
	EList<OCLExpression> getArgument();

	/**
	 * Returns the value of the '<em><b>Referred Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Relation</em>' reference.
	 * @see #setReferredRelation(Relation)
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelationCallExp_ReferredRelation()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='relationCallExp'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTrelation!RelationCallExp!referredRelation'"
	 * @generated
	 */
	Relation getReferredRelation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#getReferredRelation <em>Referred Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Relation</em>' reference.
	 * @see #getReferredRelation()
	 * @generated
	 */
	void setReferredRelation(Relation value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='MatchingArgumentCount'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv MatchingArgumentCount:\n *   let\n *     severity : Integer[1] = \'RelationCallExp::MatchingArgumentCount\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let\n *         result : Boolean[1] = self.argument-&gt;size() =\n *         self.referredRelation.domain.oclAsType(RelationDomain)\n *         .rootVariable-&gt;size()\n *       in\n *         \'RelationCallExp::MatchingArgumentCount\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IdResolver idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.STR_RelationCallExp_c_c_MatchingArgumentCount);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.lang.Object%&gt; CAUGHT_result;\n\ttry {\n\t\t@SuppressWarnings(\"null\")\n\t\tfinal /*@Thrown\052/ java.util.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; List&lt;&lt;%org.eclipse.ocl.pivot.OCLExpression%&gt;&gt; argument = this.getArgument();\n\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; OrderedSetValue BOXED_argument = idResolver.createOrderedSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.ORD_CLSSid_OCLExpression, argument);\n\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue size = &lt;%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%&gt;.INSTANCE.evaluate(BOXED_argument);\n\t\t@SuppressWarnings(\"null\")\n\t\tfinal /*@Thrown\052/ org.eclipse.qvtd.pivot.qvtrelation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Relation referredRelation = this.getReferredRelation();\n\t\t@SuppressWarnings(\"null\")\n\t\tfinal /*@Thrown\052/ java.util.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; List&lt;&lt;%org.eclipse.qvtd.pivot.qvtbase.Domain%&gt;&gt; domain = referredRelation.getDomain();\n\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; OrderedSetValue BOXED_domain = idResolver.createOrderedSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.ORD_CLSSid_Domain, domain);\n\t\t/*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.SequenceValue%&gt;.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createSequenceAccumulatorValue(&lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.SEQ_CLSSid_RelationDomain);\n\t\t@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.util.Iterator%&gt;&lt;&lt;%java.lang.Object%&gt;&gt; ITERATOR__1 = BOXED_domain.iterator();\n\t\t/*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; SequenceValue collect_0;\n\t\twhile (true) {\n\t\t\tif (!ITERATOR__1.hasNext()) {\n\t\t\t\tcollect_0 = accumulator;\n\t\t\t\tbreak;\n\t\t\t}\n\t\t\t@SuppressWarnings(\"null\")\n\t\t\t/*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Domain _1 = (&lt;%org.eclipse.qvtd.pivot.qvtbase.Domain%&gt;)ITERATOR__1.next();\n\t\t\t/**\n\t\t\t * oclAsType(RelationDomain)\n\t\t\t \052/\n\t\t\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Class TYP_qvtrelation_c_c_RelationDomain_0 = idResolver.getClass(&lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.CLSSid_RelationDomain, null);\n\t\t\tfinal /*@Thrown\052/ org.eclipse.qvtd.pivot.qvtrelation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; RelationDomain oclAsType = &lt;%org.eclipse.ocl.pivot.utilities.ClassUtil%&gt;.nonNullState((&lt;%org.eclipse.qvtd.pivot.qvtrelation.RelationDomain%&gt;)&lt;%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%&gt;.INSTANCE.evaluate(executor, _1, TYP_qvtrelation_c_c_RelationDomain_0));\n\t\t\t//\n\t\t\taccumulator.add(oclAsType);\n\t\t}\n\t\t/*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.SequenceValue%&gt;.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createSequenceAccumulatorValue(&lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.SEQ_CLSSid_Variable);\n\t\t@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.util.Iterator%&gt;&lt;&lt;%java.lang.Object%&gt;&gt; ITERATOR__1_0 = collect_0.iterator();\n\t\t/*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; SequenceValue collect;\n\t\twhile (true) {\n\t\t\tif (!ITERATOR__1_0.hasNext()) {\n\t\t\t\tcollect = accumulator_0;\n\t\t\t\tbreak;\n\t\t\t}\n\t\t\t@SuppressWarnings(\"null\")\n\t\t\t/*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtrelation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; RelationDomain _1_0 = (&lt;%org.eclipse.qvtd.pivot.qvtrelation.RelationDomain%&gt;)ITERATOR__1_0.next();\n\t\t\t/**\n\t\t\t * rootVariable\n\t\t\t \052/\n\t\t\tfinal /*@Thrown\052/ java.util.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; List&lt;&lt;%org.eclipse.ocl.pivot.Variable%&gt;&gt; rootVariable = _1_0.getRootVariable();\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; OrderedSetValue BOXED_rootVariable = idResolver.createOrderedSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.ORD_CLSSid_Variable, rootVariable);\n\t\t\t//\n\t\t\tfor (Object value : BOXED_rootVariable.flatten().getElements()) {\n\t\t\t\taccumulator_0.add(value);\n\t\t\t}\n\t\t}\n\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue size_0 = &lt;%org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation%&gt;.INSTANCE.evaluate(collect);\n\t\tfinal /*@Thrown\052/ boolean result = size.equals(size_0);\n\t\tCAUGHT_result = result;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.STR_RelationCallExp_c_c_MatchingArgumentCount, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.INT_0).booleanValue();\n\tsymbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean validateMatchingArgumentCount(DiagnosticChain diagnostics, Map<Object, Object> context);

} // RelationCallExp
