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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Domain Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getValueExp <em>Value Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelationDomainAssignment()
 * @model
 * @generated
 */
public interface RelationDomainAssignment extends Element {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getDefaultAssignment <em>Default Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(RelationDomain)
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelationDomainAssignment_Owner()
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getDefaultAssignment
	 * @model opposite="defaultAssignment" required="true" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTrelation!RelationDomainAssignment!owner'"
	 * @generated
	 */
	RelationDomain getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(RelationDomain value);

	/**
	 * Returns the value of the '<em><b>Value Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Exp</em>' containment reference.
	 * @see #setValueExp(OCLExpression)
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelationDomainAssignment_ValueExp()
	 * @model containment="true" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='domainAssignment'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTrelation!RelationDomainAssignment!valueExp'"
	 * @generated
	 */
	OCLExpression getValueExp();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getValueExp <em>Value Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Exp</em>' containment reference.
	 * @see #getValueExp()
	 * @generated
	 */
	void setValueExp(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(Variable)
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelationDomainAssignment_Variable()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='domainAssignment'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTrelation!RelationDomainAssignment!variable'"
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='CompatibleTypeForValue'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tvalueExp.type.conformsTo(variable.type)\n\n'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='try {\n\t/**\n\t *\n\t * inv CompatibleTypeForValue:\n\t *   let\n\t *     severity : Integer[1] = \'RelationDomainAssignment::CompatibleTypeForValue\'.getSeverity()\n\t *   in\n\t *     if severity &lt;= 0\n\t *     then true\n\t *     else\n\t *       let\n\t *         result : Boolean[1] = valueExp.type.conformsTo(variable.type)\n\t *       in\n\t *         \'RelationDomainAssignment::CompatibleTypeForValue\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n\t *     endif\n\t \052/\n\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\n\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.STR_RelationDomainAssignment_c_c_CompatibleTypeForValue);\n\tfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.INT_0).booleanValue();\n\t/*@NonInvalid\052/ boolean symbol_0;\n\tif (le) {\n\t\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t}\n\telse {\n\t\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Object CAUGHT_result;\n\t\ttry {\n\t\t\t@SuppressWarnings(\"null\")\n\t\t\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; OCLExpression valueExp = this.getValueExp();\n\t\t\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Type type = valueExp.getType();\n\t\t\t@SuppressWarnings(\"null\")\n\t\t\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Variable variable = this.getVariable();\n\t\t\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Type type_0 = variable.getType();\n\t\t\tfinal /*@Thrown\052/ boolean result = &lt;%org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation%&gt;.INSTANCE.evaluate(executor, type, type_0).booleanValue();\n\t\t\tCAUGHT_result = result;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.STR_RelationDomainAssignment_c_c_CompatibleTypeForValue, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.INT_0).booleanValue();\n\t\tsymbol_0 = logDiagnostic;\n\t}\n\treturn Boolean.TRUE == symbol_0;\n}\ncatch (&lt;%java.lang.Throwable%&gt; e) {\n\treturn &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.validationFailedDiagnostic(\"RelationDomainAssignment::CompatibleTypeForValue\", this, diagnostics, context, e);\n}'"
	 * @generated
	 */
	boolean validateCompatibleTypeForValue(DiagnosticChain diagnostics, Map<Object, Object> context);

} // RelationDomainAssignment
