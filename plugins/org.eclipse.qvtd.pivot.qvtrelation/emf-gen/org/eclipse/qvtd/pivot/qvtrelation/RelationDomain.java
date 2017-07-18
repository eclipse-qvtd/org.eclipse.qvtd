/*******************************************************************************
 * Copyright (c) 2011, 2017 Willink Transformations and others.
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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.qvtd.pivot.qvtbase.Domain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getDefaultAssignment <em>Default Assignment</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getRootVariable <em>Root Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelationDomain()
 * @model
 * @generated
 */
public interface RelationDomain extends Domain {
	/**
	 * Returns the value of the '<em><b>Default Assignment</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Assignment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Assignment</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelationDomain_DefaultAssignment()
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getOwner
	 * @model opposite="owner" containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTrelation!RelationDomain!defaultAssignment'"
	 * @generated
	 */
	@NonNull EList<RelationDomainAssignment> getDefaultAssignment();

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtrelation.DomainPattern}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtrelation.DomainPattern#getRelationDomain <em>Relation Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelationDomain_Pattern()
	 * @see org.eclipse.qvtd.pivot.qvtrelation.DomainPattern#getRelationDomain
	 * @model opposite="relationDomain" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTrelation!RelationDomain!pattern'"
	 * @generated
	 */
	@NonNull EList<DomainPattern> getPattern();

	/**
	 * Returns the value of the '<em><b>Root Variable</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Variable</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelationDomain_RootVariable()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTrelation!RelationDomain!rootVariable'"
	 * @generated
	 */
	@NonNull EList<Variable> getRootVariable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='RelationDomainAssignmentsAreUnique'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv RelationDomainAssignmentsAreUnique:\n *   let\n *     severity : Integer[1] = \'RelationDomain::RelationDomainAssignmentsAreUnique\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let result : Boolean[1] = defaultAssignment-&gt;isUnique(variable)\n *       in\n *         \'RelationDomain::RelationDomainAssignmentsAreUnique\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IdResolver idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.STR_RelationDomain_c_c_RelationDomainAssignmentsAreUnique);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\tfinal /*@NonInvalid\052/ java.util.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; List&lt;&lt;%org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment%&gt;&gt; defaultAssignment = this.getDefaultAssignment();\n\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; SetValue BOXED_defaultAssignment = idResolver.createSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.SET_CLSSid_RelationDomainAssignment, defaultAssignment);\n\t/*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.SetValue%&gt;.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createSetAccumulatorValue(&lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.SET_CLSSid_RelationDomainAssignment);\n\t@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.util.Iterator%&gt;&lt;&lt;%java.lang.Object%&gt;&gt; ITERATOR__1 = BOXED_defaultAssignment.iterator();\n\t/*@NonInvalid\052/ boolean result;\n\twhile (true) {\n\t\tif (!ITERATOR__1.hasNext()) {\n\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\tbreak;\n\t\t}\n\t\t@SuppressWarnings(\"null\")\n\t\t/*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtrelation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; RelationDomainAssignment _1 = (&lt;%org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment%&gt;)ITERATOR__1.next();\n\t\t/**\n\t\t * variable\n\t\t \052/\n\t\t@SuppressWarnings(\"null\")\n\t\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Variable variable = _1.getVariable();\n\t\t//\n\t\tif (accumulator.includes(variable) == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\n\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE;\t\t\t// Abort after second find\n\t\t\tbreak;\n\t\t}\n\t\telse {\n\t\t\taccumulator.add(variable);\n\t\t}\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.STR_RelationDomain_c_c_RelationDomainAssignmentsAreUnique, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.INT_0).booleanValue();\n\tsymbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean validateRelationDomainAssignmentsAreUnique(DiagnosticChain diagnostics, Map<Object, Object> context);

} // RelationDomain
