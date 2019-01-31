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
package org.eclipse.qvtd.pivot.qvttemplate;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Template Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp#getMember <em>Member</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp#getReferredCollectionType <em>Referred Collection Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp#getRest <em>Rest</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getCollectionTemplateExp()
 * @model
 * @generated
 */
public interface CollectionTemplateExp extends TemplateExp {
	/**
	 * Returns the value of the '<em><b>Member</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.OCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getCollectionTemplateExp_Member()
	 * @model containment="true" ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='listContainer'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTtemplate!CollectionTemplateExp!member'"
	 * @generated
	 */
	EList<OCLExpression> getMember();

	/**
	 * Returns the value of the '<em><b>Referred Collection Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Collection Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Collection Type</em>' reference.
	 * @see #setReferredCollectionType(CollectionType)
	 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getCollectionTemplateExp_ReferredCollectionType()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTtemplate!CollectionTemplateExp!referredCollectionType'"
	 * @generated
	 */
	CollectionType getReferredCollectionType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp#getReferredCollectionType <em>Referred Collection Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Collection Type</em>' reference.
	 * @see #getReferredCollectionType()
	 * @generated
	 */
	void setReferredCollectionType(CollectionType value);

	/**
	 * Returns the value of the '<em><b>Rest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rest</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rest</em>' reference.
	 * @see #setRest(Variable)
	 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getCollectionTemplateExp_Rest()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='matchingExp'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTtemplate!CollectionTemplateExp!rest'"
	 * @generated
	 */
	Variable getRest();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp#getRest <em>Rest</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rest</em>' reference.
	 * @see #getRest()
	 * @generated
	 */
	void setRest(Variable value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='MemberTypeisCollectionElementType'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tmember-&gt;forAll(type.conformsTo(referredCollectionType.elementType))\n\n'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='try {\n\t/**\n\t *\n\t * inv MemberTypeisCollectionElementType:\n\t *   let\n\t *     severity : Integer[1] = \'CollectionTemplateExp::MemberTypeisCollectionElementType\'.getSeverity()\n\t *   in\n\t *     if severity &lt;= 0\n\t *     then true\n\t *     else\n\t *       let\n\t *         result : Boolean[?] = member-&gt;forAll(\n\t *           type.conformsTo(referredCollectionType.elementType))\n\t *       in\n\t *         \'CollectionTemplateExp::MemberTypeisCollectionElementType\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n\t *     endif\n\t \052/\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.utilities.PivotUtil%&gt;.getExecutor(this, context);\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.ids.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;IdResolver%&gt; idResolver = executor.getIdResolver();\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.STR_CollectionTemplateExp_c_c_MemberTypeisCollectionElementType);\n\tfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.INT_0).booleanValue();\n\t/*@NonInvalid\052/ boolean symbol_0;\n\tif (le) {\n\t\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t}\n\telse {\n\t\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Object%&gt; CAUGHT_result;\n\t\ttry {\n\t\t\t@SuppressWarnings(\"null\")\n\t\t\tfinal /*@NonInvalid\052/ &lt;%java.util.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;List%&gt;&lt;&lt;%org.eclipse.ocl.pivot.OCLExpression%&gt;&gt; member = this.getMember();\n\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;SetValue%&gt; BOXED_member = idResolver.createSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.SET_CLSSid_OCLExpression, member);\n\t\t\t/*@Thrown\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Object%&gt; accumulator = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t&lt;%java.util.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Iterator%&gt;&lt;&lt;%java.lang.Object%&gt;&gt; ITERATOR__1 = BOXED_member.iterator();\n\t\t\t/*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Boolean%&gt; result;\n\t\t\twhile (true) {\n\t\t\t\tif (!ITERATOR__1.hasNext()) {\n\t\t\t\t\tif (accumulator == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\n\t\t\t\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t\t\t}\n\t\t\t\t\telse {\n\t\t\t\t\t\tthrow (&lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;)accumulator;\n\t\t\t\t\t}\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\t/*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;OCLExpression%&gt; _1 = (&lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;OCLExpression%&gt;)ITERATOR__1.next();\n\t\t\t\t/**\n\t\t\t\t *\n\t\t\t\t * type.conformsTo(referredCollectionType.elementType)\n\t\t\t\t \052/\n\t\t\t\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; CAUGHT_conformsTo;\n\t\t\t\ttry {\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Type%&gt; type = _1.getType();\n\t\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;CollectionType%&gt; referredCollectionType = this.getReferredCollectionType();\n\t\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Type%&gt; elementType = referredCollectionType.getElementType();\n\t\t\t\t\tfinal /*@Thrown\052/ boolean conformsTo = &lt;%org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation%&gt;.INSTANCE.evaluate(executor, type, elementType).booleanValue();\n\t\t\t\t\tCAUGHT_conformsTo = conformsTo;\n\t\t\t\t}\n\t\t\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\t\t\tCAUGHT_conformsTo = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t\t\t}\n\t\t\t\t//\n\t\t\t\tif (CAUGHT_conformsTo == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE) {\t\t\t\t\t// Normal unsuccessful body evaluation result\n\t\t\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE;\n\t\t\t\t\tbreak;\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Stop immediately\n\t\t\t\t}\n\t\t\t\telse if (CAUGHT_conformsTo == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\t\t\t\t// Normal successful body evaluation result\n\t\t\t\t\t;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Carry on\n\t\t\t\t}\n\t\t\t\telse if (CAUGHT_conformsTo instanceof &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;) {\t\t// Abnormal exception evaluation result\n\t\t\t\t\taccumulator = CAUGHT_conformsTo;\t\t\t\t\t\t\t\t\t// Cache an exception failure\n\t\t\t\t}\n\t\t\t\telse {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Impossible badly typed result\n\t\t\t\t\taccumulator = new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(&lt;%org.eclipse.ocl.pivot.messages.PivotMessages%&gt;.NonBooleanBody, \"forAll\");\n\t\t\t\t}\n\t\t\t}\n\t\t\tCAUGHT_result = result;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.STR_CollectionTemplateExp_c_c_MemberTypeisCollectionElementType, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.INT_0).booleanValue();\n\t\tsymbol_0 = logDiagnostic;\n\t}\n\treturn Boolean.TRUE == symbol_0;\n}\ncatch (&lt;%java.lang.Throwable%&gt; e) {\n\treturn &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.validationFailedDiagnostic(\"CollectionTemplateExp::MemberTypeisCollectionElementType\", this, diagnostics, context, e);\n}'"
	 * @generated
	 */
	boolean validateMemberTypeisCollectionElementType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='RestTypeisCollectionType'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\trest &lt;&gt; null implies\n\t\trest.type = referredCollectionType\n\n'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='try {\n\t/**\n\t *\n\t * inv RestTypeisCollectionType:\n\t *   let\n\t *     severity : Integer[1] = \'CollectionTemplateExp::RestTypeisCollectionType\'.getSeverity()\n\t *   in\n\t *     if severity &lt;= 0\n\t *     then true\n\t *     else\n\t *       let result : Boolean[?] = rest &lt;&gt; null implies rest.type = referredCollectionType\n\t *       in\n\t *         \'CollectionTemplateExp::RestTypeisCollectionType\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n\t *     endif\n\t \052/\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.utilities.PivotUtil%&gt;.getExecutor(this, context);\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.STR_CollectionTemplateExp_c_c_RestTypeisCollectionType);\n\tfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.INT_0).booleanValue();\n\t/*@NonInvalid\052/ boolean symbol_0;\n\tif (le) {\n\t\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t}\n\telse {\n\t\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; CAUGHT_result;\n\t\ttry {\n\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Variable%&gt; rest = this.getRest();\n\t\t\tfinal /*@NonInvalid\052/ boolean ne = rest != null;\n\t\t\t/*@Thrown\052/ boolean result;\n\t\t\tif (ne) {\n\t\t\t\tif (rest == null) {\n\t\t\t\t\tthrow new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(\"Null source for \\\'TypedElement::type\\\'\");\n\t\t\t\t}\n\t\t\t\tfinal /*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Type%&gt; type = rest.getType();\n\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;CollectionType%&gt; referredCollectionType = this.getReferredCollectionType();\n\t\t\t\tfinal /*@Thrown\052/ boolean eq = (type != null) ? (type.getTypeId() == referredCollectionType.getTypeId()) : false;\n\t\t\t\tresult = eq;\n\t\t\t}\n\t\t\telse {\n\t\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t}\n\t\t\tCAUGHT_result = result;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.STR_CollectionTemplateExp_c_c_RestTypeisCollectionType, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.INT_0).booleanValue();\n\t\tsymbol_0 = logDiagnostic;\n\t}\n\treturn Boolean.TRUE == symbol_0;\n}\ncatch (&lt;%java.lang.Throwable%&gt; e) {\n\treturn &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.validationFailedDiagnostic(\"CollectionTemplateExp::RestTypeisCollectionType\", this, diagnostics, context, e);\n}'"
	 * @generated
	 */
	boolean validateRestTypeisCollectionType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='TypeisCollectionType'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\ttype = referredCollectionType\n\n'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='try {\n\t/**\n\t *\n\t * inv TypeisCollectionType:\n\t *   let\n\t *     severity : Integer[1] = \'CollectionTemplateExp::TypeisCollectionType\'.getSeverity()\n\t *   in\n\t *     if severity &lt;= 0\n\t *     then true\n\t *     else\n\t *       let result : Boolean[1] = type = referredCollectionType\n\t *       in\n\t *         \'CollectionTemplateExp::TypeisCollectionType\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n\t *     endif\n\t \052/\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.utilities.PivotUtil%&gt;.getExecutor(this, context);\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.STR_CollectionTemplateExp_c_c_TypeisCollectionType);\n\tfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.INT_0).booleanValue();\n\t/*@NonInvalid\052/ boolean symbol_0;\n\tif (le) {\n\t\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t}\n\telse {\n\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Type%&gt; type = this.getType();\n\t\t@SuppressWarnings(\"null\")\n\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;CollectionType%&gt; referredCollectionType = this.getReferredCollectionType();\n\t\tfinal /*@NonInvalid\052/ boolean result = (type != null) ? (type.getTypeId() == referredCollectionType.getTypeId()) : false;\n\t\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.STR_CollectionTemplateExp_c_c_TypeisCollectionType, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.INT_0).booleanValue();\n\t\tsymbol_0 = logDiagnostic;\n\t}\n\treturn Boolean.TRUE == symbol_0;\n}\ncatch (&lt;%java.lang.Throwable%&gt; e) {\n\treturn &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.validationFailedDiagnostic(\"CollectionTemplateExp::TypeisCollectionType\", this, diagnostics, context, e);\n}'"
	 * @generated
	 */
	boolean validateTypeisCollectionType(DiagnosticChain diagnostics, Map<Object, Object> context);

} // CollectionTemplateExp
