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
package org.eclipse.qvtd.pivot.qvtcore;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.qvtd.pivot.qvtbase.Rule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getLocal <em>Local</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getRefinement <em>Refinement</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getSpecification <em>Specification</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getMapping()
 * @model
 * @generated
 */
public interface Mapping extends Rule, Area {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getLocal <em>Local</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' container reference.
	 * @see #setContext(Mapping)
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getMapping_Context()
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getLocal
	 * @model opposite="local" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTcore!Mapping!context'"
	 * @generated
	 */
	Mapping getContext();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getContext <em>Context</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' container reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(Mapping value);

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcore.Mapping}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getRefinement <em>Refinement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getMapping_Specification()
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getRefinement
	 * @model opposite="refinement" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTcore!Mapping!specification'"
	 * @generated
	 */
	EList<Mapping> getSpecification();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='DomainsAreCoreDomains'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tdomain-&gt;forAll(oclIsKindOf(CoreDomain))\n\n'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;String%&gt; constraintName = \"Mapping::DomainsAreCoreDomains\";\ntry {\n\t/**\n\t *\n\t * inv DomainsAreCoreDomains:\n\t *   let severity : Integer[1] = constraintName.getSeverity()\n\t *   in\n\t *     if severity &lt;= 0\n\t *     then true\n\t *     else\n\t *       let\n\t *         result : Boolean[?] = domain-&gt;forAll(oclIsKindOf(CoreDomain))\n\t *       in\n\t *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n\t *     endif\n\t \052/\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.utilities.PivotUtil%&gt;.getExecutor(this, context);\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.ids.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;IdResolver%&gt; idResolver = executor.getIdResolver();\n\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; CAUGHT_severity_0;\n\ttry {\n\t\tfinal /*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage%&gt;.Literals.MAPPING___VALIDATE_DOMAINS_ARE_CORE_DOMAINS__DIAGNOSTICCHAIN_MAP);\n\t\tCAUGHT_severity_0 = severity_0;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_severity_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tif (CAUGHT_severity_0 instanceof &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;) {\n\t\tthrow (&lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;)CAUGHT_severity_0;\n\t}\n\tfinal /*@Thrown\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, CAUGHT_severity_0, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\t/*@NonInvalid\052/ boolean symbol_0;\n\tif (le) {\n\t\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t}\n\telse {\n\t\t@SuppressWarnings(\"null\")\n\t\tfinal /*@NonInvalid\052/ &lt;%java.util.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;List%&gt;&lt;&lt;%org.eclipse.qvtd.pivot.qvtbase.Domain%&gt;&gt; domain = this.getDomain();\n\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;OrderedSetValue%&gt; BOXED_domain = idResolver.createOrderedSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.ORD_CLSSid_Domain, domain);\n\t\t/*@Thrown\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Object%&gt; accumulator = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t&lt;%java.util.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Iterator%&gt;&lt;&lt;%java.lang.Object%&gt;&gt; ITERATOR__1 = BOXED_domain.iterator();\n\t\t/*@NonInvalid\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Boolean%&gt; result;\n\t\twhile (true) {\n\t\t\tif (!ITERATOR__1.hasNext()) {\n\t\t\t\tif (accumulator == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\n\t\t\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tthrow (&lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;)accumulator;\n\t\t\t\t}\n\t\t\t\tbreak;\n\t\t\t}\n\t\t\t@SuppressWarnings(\"null\")\n\t\t\t/*@NonInvalid\052/ &lt;%org.eclipse.qvtd.pivot.qvtbase.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Domain%&gt; _1 = (&lt;%org.eclipse.qvtd.pivot.qvtbase.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Domain%&gt;)ITERATOR__1.next();\n\t\t\t/**\n\t\t\t * oclIsKindOf(CoreDomain)\n\t\t\t \052/\n\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Class%&gt; TYP_qvtcore_c_c_CoreDomain = idResolver.getClass(&lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.CLSSid_CoreDomain, null);\n\t\t\tfinal /*@NonInvalid\052/ boolean oclIsKindOf = &lt;%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation%&gt;.INSTANCE.evaluate(executor, _1, TYP_qvtcore_c_c_CoreDomain).booleanValue();\n\t\t\t//\n\t\t\tif (oclIsKindOf == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE) {\t\t\t\t\t// Normal unsuccessful body evaluation result\n\t\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE;\n\t\t\t\tbreak;\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Stop immediately\n\t\t\t}\n\t\t\telse if (oclIsKindOf == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\t\t\t\t// Normal successful body evaluation result\n\t\t\t\t;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Carry on\n\t\t\t}\n\t\t\telse {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Impossible badly typed result\n\t\t\t\taccumulator = new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(&lt;%org.eclipse.ocl.pivot.messages.PivotMessages%&gt;.NonBooleanBody, \"forAll\");\n\t\t\t}\n\t\t}\n\t\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, CAUGHT_severity_0, result, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\t\tsymbol_0 = logDiagnostic;\n\t}\n\treturn Boolean.TRUE == symbol_0;\n}\ncatch (&lt;%java.lang.Throwable%&gt; e) {\n\treturn &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.validationFailedDiagnostic(constraintName, this, diagnostics, context, e);\n}'"
	 * @generated
	 */
	boolean validateDomainsAreCoreDomains(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='NestedNameIsNull'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\t_context &lt;&gt; null implies name = null\n\n'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;String%&gt; constraintName = \"Mapping::NestedNameIsNull\";\ntry {\n\t/**\n\t *\n\t * inv NestedNameIsNull:\n\t *   let severity : Integer[1] = constraintName.getSeverity()\n\t *   in\n\t *     if severity &lt;= 0\n\t *     then true\n\t *     else\n\t *       let result : Boolean[?] = context &lt;&gt; null implies name = null\n\t *       in\n\t *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n\t *     endif\n\t \052/\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.utilities.PivotUtil%&gt;.getExecutor(this, context);\n\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; CAUGHT_severity_0;\n\ttry {\n\t\tfinal /*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage%&gt;.Literals.MAPPING___VALIDATE_NESTED_NAME_IS_NULL__DIAGNOSTICCHAIN_MAP);\n\t\tCAUGHT_severity_0 = severity_0;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_severity_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tif (CAUGHT_severity_0 instanceof &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;) {\n\t\tthrow (&lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;)CAUGHT_severity_0;\n\t}\n\tfinal /*@Thrown\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, CAUGHT_severity_0, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\t/*@NonInvalid\052/ boolean symbol_0;\n\tif (le) {\n\t\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t}\n\telse {\n\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.qvtd.pivot.qvtcore.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Mapping%&gt; context_0 = this.getContext();\n\t\tfinal /*@NonInvalid\052/ boolean ne = context_0 != null;\n\t\t/*@NonInvalid\052/ boolean result;\n\t\tif (ne) {\n\t\t\tfinal /*@NonInvalid\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;String%&gt; name = this.getName();\n\t\t\tfinal /*@NonInvalid\052/ boolean eq = name == null;\n\t\t\tresult = eq;\n\t\t}\n\t\telse {\n\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t}\n\t\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, CAUGHT_severity_0, result, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\t\tsymbol_0 = logDiagnostic;\n\t}\n\treturn Boolean.TRUE == symbol_0;\n}\ncatch (&lt;%java.lang.Throwable%&gt; e) {\n\treturn &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.validationFailedDiagnostic(constraintName, this, diagnostics, context, e);\n}'"
	 * @generated
	 */
	boolean validateNestedNameIsNull(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='RootNameIsNotNull'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\ttransformation &lt;&gt; null implies name &lt;&gt; null\n\n'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;String%&gt; constraintName = \"Mapping::RootNameIsNotNull\";\ntry {\n\t/**\n\t *\n\t * inv RootNameIsNotNull:\n\t *   let severity : Integer[1] = constraintName.getSeverity()\n\t *   in\n\t *     if severity &lt;= 0\n\t *     then true\n\t *     else\n\t *       let result : Boolean[?] = transformation &lt;&gt; null implies name &lt;&gt; null\n\t *       in\n\t *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n\t *     endif\n\t \052/\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.utilities.PivotUtil%&gt;.getExecutor(this, context);\n\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; CAUGHT_severity_0;\n\ttry {\n\t\tfinal /*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage%&gt;.Literals.MAPPING___VALIDATE_ROOT_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP);\n\t\tCAUGHT_severity_0 = severity_0;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_severity_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tif (CAUGHT_severity_0 instanceof &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;) {\n\t\tthrow (&lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;)CAUGHT_severity_0;\n\t}\n\tfinal /*@Thrown\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, CAUGHT_severity_0, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\t/*@NonInvalid\052/ boolean symbol_0;\n\tif (le) {\n\t\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t}\n\telse {\n\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.qvtd.pivot.qvtbase.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Transformation%&gt; transformation = this.getTransformation();\n\t\tfinal /*@NonInvalid\052/ boolean ne = transformation != null;\n\t\t/*@NonInvalid\052/ boolean result;\n\t\tif (ne) {\n\t\t\tfinal /*@NonInvalid\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;String%&gt; name = this.getName();\n\t\t\tfinal /*@NonInvalid\052/ boolean ne_0 = name != null;\n\t\t\tresult = ne_0;\n\t\t}\n\t\telse {\n\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t}\n\t\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, CAUGHT_severity_0, result, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\t\tsymbol_0 = logDiagnostic;\n\t}\n\treturn Boolean.TRUE == symbol_0;\n}\ncatch (&lt;%java.lang.Throwable%&gt; e) {\n\treturn &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.validationFailedDiagnostic(constraintName, this, diagnostics, context, e);\n}'"
	 * @generated
	 */
	boolean validateRootNameIsNotNull(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * Returns the value of the '<em><b>Local</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcore.Mapping}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getMapping_Local()
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getContext
	 * @model opposite="context" containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTcore!Mapping!local'"
	 * @generated
	 */
	EList<Mapping> getLocal();

	/**
	 * Returns the value of the '<em><b>Refinement</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcore.Mapping}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refinement</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refinement</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getMapping_Refinement()
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getSpecification
	 * @model opposite="specification" ordered="false"
	 */
	EList<Mapping> getRefinement();

} // Mapping
