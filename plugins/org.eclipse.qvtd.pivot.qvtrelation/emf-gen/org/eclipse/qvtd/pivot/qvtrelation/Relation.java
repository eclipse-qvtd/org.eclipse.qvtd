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
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Rule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#isIsTopLevel <em>Is Top Level</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getOperationalImpl <em>Operational Impl</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getWhen <em>When</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getWhere <em>Where</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelation()
 * @model
 * @generated
 */
public interface Relation extends Rule {
	/**
	 * Returns the value of the '<em><b>Is Top Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Top Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Top Level</em>' attribute.
	 * @see #setIsTopLevel(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelation_IsTopLevel()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTrelation!Relation!isTopLevel'"
	 * @generated
	 */
	boolean isIsTopLevel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#isIsTopLevel <em>Is Top Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Top Level</em>' attribute.
	 * @see #isIsTopLevel()
	 * @generated
	 */
	void setIsTopLevel(boolean value);

	/**
	 * Returns the value of the '<em><b>Operational Impl</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operational Impl</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operational Impl</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelation_OperationalImpl()
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation#getRelation
	 * @model opposite="relation" containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTrelation!Relation!operationalImpl'"
	 * @generated
	 */
	EList<RelationImplementation> getOperationalImpl();

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelation_Variable()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTrelation!Relation!variable'"
	 * @generated
	 */
	EList<Variable> getVariable();

	/**
	 * Returns the value of the '<em><b>When</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When</em>' containment reference.
	 * @see #setWhen(Pattern)
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelation_When()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='whenOwner'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTrelation!Relation!when'"
	 * @generated
	 */
	Pattern getWhen();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getWhen <em>When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>When</em>' containment reference.
	 * @see #getWhen()
	 * @generated
	 */
	void setWhen(Pattern value);

	/**
	 * Returns the value of the '<em><b>Where</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Where</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Where</em>' containment reference.
	 * @see #setWhere(Pattern)
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelation_Where()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='whereOwner'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTrelation!Relation!where'"
	 * @generated
	 */
	Pattern getWhere();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getWhere <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Where</em>' containment reference.
	 * @see #getWhere()
	 * @generated
	 */
	void setWhere(Pattern value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='DomainsAreRelationDomains'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tdomain-&gt;forAll(oclIsKindOf(RelationDomain))\n'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='try {\n\t/**\n\t *\n\t * inv DomainsAreRelationDomains:\n\t *   let\n\t *     severity : Integer[1] = \'Relation::DomainsAreRelationDomains\'.getSeverity()\n\t *   in\n\t *     if severity &lt;= 0\n\t *     then true\n\t *     else\n\t *       let\n\t *         result : Boolean[?] = domain-&gt;forAll(\n\t *           oclIsKindOf(RelationDomain))\n\t *       in\n\t *         \'Relation::DomainsAreRelationDomains\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n\t *     endif\n\t \052/\n\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\n\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IdResolver idResolver = executor.getIdResolver();\n\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.STR_Relation_c_c_DomainsAreRelationDomains);\n\tfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.INT_0).booleanValue();\n\t/*@NonInvalid\052/ boolean symbol_0;\n\tif (le) {\n\t\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t}\n\telse {\n\t\t@SuppressWarnings(\"null\")\n\t\tfinal /*@NonInvalid\052/ java.util.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; List&lt;&lt;%org.eclipse.qvtd.pivot.qvtbase.Domain%&gt;&gt; domain = this.getDomain();\n\t\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; OrderedSetValue BOXED_domain = idResolver.createOrderedSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.ORD_CLSSid_Domain, domain);\n\t\t/*@Thrown\052/ @&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Object accumulator = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\tjava.util.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Iterator&lt;&lt;%java.lang.Object%&gt;&gt; ITERATOR__1 = BOXED_domain.iterator();\n\t\t/*@NonInvalid\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Boolean result;\n\t\twhile (true) {\n\t\t\tif (!ITERATOR__1.hasNext()) {\n\t\t\t\tif (accumulator == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\n\t\t\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tthrow (&lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;)accumulator;\n\t\t\t\t}\n\t\t\t\tbreak;\n\t\t\t}\n\t\t\t@SuppressWarnings(\"null\")\n\t\t\t/*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Domain _1 = (org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Domain)ITERATOR__1.next();\n\t\t\t/**\n\t\t\t * oclIsKindOf(RelationDomain)\n\t\t\t \052/\n\t\t\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Class TYP_qvtrelation_c_c_RelationDomain = idResolver.getClass(&lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.CLSSid_RelationDomain, null);\n\t\t\tfinal /*@NonInvalid\052/ boolean oclIsKindOf = &lt;%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation%&gt;.INSTANCE.evaluate(executor, _1, TYP_qvtrelation_c_c_RelationDomain).booleanValue();\n\t\t\t//\n\t\t\tif (oclIsKindOf == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE) {\t\t\t\t\t// Normal unsuccessful body evaluation result\n\t\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE;\n\t\t\t\tbreak;\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Stop immediately\n\t\t\t}\n\t\t\telse if (oclIsKindOf == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\t\t\t\t// Normal successful body evaluation result\n\t\t\t\t;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Carry on\n\t\t\t}\n\t\t\telse {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Impossible badly typed result\n\t\t\t\taccumulator = new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(&lt;%org.eclipse.ocl.pivot.messages.PivotMessages%&gt;.NonBooleanBody, \"forAll\");\n\t\t\t}\n\t\t}\n\t\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.STR_Relation_c_c_DomainsAreRelationDomains, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.INT_0).booleanValue();\n\t\tsymbol_0 = logDiagnostic;\n\t}\n\treturn Boolean.TRUE == symbol_0;\n}\ncatch (&lt;%java.lang.Throwable%&gt; e) {\n\treturn &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.validationFailedDiagnostic(\"Relation::DomainsAreRelationDomains\", this, diagnostics, context, e);\n}'"
	 * @generated
	 */
	boolean validateDomainsAreRelationDomains(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='TopRelationOverriddenByTopRelation'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\toverridden &lt;&gt; null and not overridden.oclAsType(Relation).isTopLevel implies not isTopLevel\n\n'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='try {\n\t/**\n\t *\n\t * inv TopRelationOverriddenByTopRelation:\n\t *   let\n\t *     severity : Integer[1] = \'Relation::TopRelationOverriddenByTopRelation\'.getSeverity()\n\t *   in\n\t *     if severity &lt;= 0\n\t *     then true\n\t *     else\n\t *       let result : Boolean[?] = overridden &lt;&gt; null and\n\t *         not overridden.oclAsType(Relation).isTopLevel implies not isTopLevel\n\t *       in\n\t *         \'Relation::TopRelationOverriddenByTopRelation\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n\t *     endif\n\t \052/\n\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\n\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IdResolver idResolver = executor.getIdResolver();\n\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.STR_Relation_c_c_TopRelationOverriddenByTopRelation);\n\tfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.INT_0).booleanValue();\n\t/*@NonInvalid\052/ boolean symbol_0;\n\tif (le) {\n\t\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t}\n\telse {\n\t\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Object CAUGHT_result;\n\t\ttry {\n\t\t\tfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Rule overridden = this.getOverridden();\n\t\t\tfinal /*@NonInvalid\052/ boolean ne = overridden != null;\n\t\t\t/*@NonInvalid\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Boolean and;\n\t\t\tif (ne) {\n\t\t\t\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Object CAUGHT_isTopLevel;\n\t\t\t\ttry {\n\t\t\t\t\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Class TYP_qvtrelation_c_c_Relation = idResolver.getClass(&lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.CLSSid_Relation, null);\n\t\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\t\tfinal /*@Thrown\052/ org.eclipse.qvtd.pivot.qvtrelation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Relation oclAsType = (org.eclipse.qvtd.pivot.qvtrelation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Relation)&lt;%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%&gt;.INSTANCE.evaluate(executor, overridden, TYP_qvtrelation_c_c_Relation);\n\t\t\t\t\tfinal /*@Thrown\052/ boolean isTopLevel = oclAsType.isIsTopLevel();\n\t\t\t\t\tCAUGHT_isTopLevel = isTopLevel;\n\t\t\t\t}\n\t\t\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\t\t\tCAUGHT_isTopLevel = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t\t\t}\n\t\t\t\tfinal /*@NonInvalid\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Boolean not = &lt;%org.eclipse.ocl.pivot.library.logical.BooleanNotOperation%&gt;.INSTANCE.evaluate(CAUGHT_isTopLevel);\n\t\t\t\tand = not;\n\t\t\t}\n\t\t\telse {\n\t\t\t\tand = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE;\n\t\t\t}\n\t\t\tfinal /*@NonInvalid\052/ boolean isTopLevel_0 = this.isIsTopLevel();\n\t\t\tfinal /*@NonInvalid\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Boolean not_0 = &lt;%org.eclipse.ocl.pivot.library.logical.BooleanNotOperation%&gt;.INSTANCE.evaluate(isTopLevel_0);\n\t\t\tfinal /*@Thrown\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Boolean result = &lt;%org.eclipse.ocl.pivot.library.logical.BooleanImpliesOperation%&gt;.INSTANCE.evaluate(and, not_0);\n\t\t\tCAUGHT_result = result;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.STR_Relation_c_c_TopRelationOverriddenByTopRelation, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.INT_0).booleanValue();\n\t\tsymbol_0 = logDiagnostic;\n\t}\n\treturn Boolean.TRUE == symbol_0;\n}\ncatch (&lt;%java.lang.Throwable%&gt; e) {\n\treturn &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.validationFailedDiagnostic(\"Relation::TopRelationOverriddenByTopRelation\", this, diagnostics, context, e);\n}'"
	 * @generated
	 */
	boolean validateTopRelationOverriddenByTopRelation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='TransformationIsRelationalTransformation'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\ttransformation.oclIsKindOf(RelationalTransformation)\n\n'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='try {\n\t/**\n\t *\n\t * inv TransformationIsRelationalTransformation:\n\t *   let\n\t *     severity : Integer[1] = \'Relation::TransformationIsRelationalTransformation\'.getSeverity()\n\t *   in\n\t *     if severity &lt;= 0\n\t *     then true\n\t *     else\n\t *       let\n\t *         result : Boolean[1] = transformation.oclIsKindOf(RelationalTransformation)\n\t *       in\n\t *         \'Relation::TransformationIsRelationalTransformation\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n\t *     endif\n\t \052/\n\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\n\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IdResolver idResolver = executor.getIdResolver();\n\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.STR_Relation_c_c_TransformationIsRelationalTransformation);\n\tfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.INT_0).booleanValue();\n\t/*@NonInvalid\052/ boolean symbol_0;\n\tif (le) {\n\t\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t}\n\telse {\n\t\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Object CAUGHT_result;\n\t\ttry {\n\t\t\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Class TYP_qvtrelation_c_c_RelationalTransformation = idResolver.getClass(&lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.CLSSid_RelationalTransformation, null);\n\t\t\tfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Transformation transformation = this.getTransformation();\n\t\t\tfinal /*@Thrown\052/ boolean result = &lt;%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation%&gt;.INSTANCE.evaluate(executor, transformation, TYP_qvtrelation_c_c_RelationalTransformation).booleanValue();\n\t\t\tCAUGHT_result = result;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.STR_Relation_c_c_TransformationIsRelationalTransformation, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables%&gt;.INT_0).booleanValue();\n\t\tsymbol_0 = logDiagnostic;\n\t}\n\treturn Boolean.TRUE == symbol_0;\n}\ncatch (&lt;%java.lang.Throwable%&gt; e) {\n\treturn &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.validationFailedDiagnostic(\"Relation::TransformationIsRelationalTransformation\", this, diagnostics, context, e);\n}'"
	 * @generated
	 */
	boolean validateTransformationIsRelationalTransformation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Relation
