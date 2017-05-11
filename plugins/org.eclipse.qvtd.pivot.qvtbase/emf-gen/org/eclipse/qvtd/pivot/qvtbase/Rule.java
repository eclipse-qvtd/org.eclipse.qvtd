/*******************************************************************************
 * Copyright (c) 2011, 2015 Willink Transformations and others.
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
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Rule#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Rule#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Rule#getOverrides <em>Overrides</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Rule#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Rule#getOverridden <em>Overridden</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getRule()
 * @model abstract="true"
 * @generated
 */
public interface Rule extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Domain</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.Domain}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtbase.Domain#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getRule_Domain()
	 * @see org.eclipse.qvtd.pivot.qvtbase.Domain#getRule
	 * @model opposite="rule" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTbase!Rule!domain'"
	 * @generated
	 */
	EList<Domain> getDomain();

	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getRule_IsAbstract()
	 * @model default="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTbase!Rule!isAbstract'"
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.Rule#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Overrides</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtbase.Rule#getOverridden <em>Overridden</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overrides</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overrides</em>' reference.
	 * @see #setOverrides(Rule)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getRule_Overrides()
	 * @see org.eclipse.qvtd.pivot.qvtbase.Rule#getOverridden
	 * @model opposite="overridden"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTbase!Rule!overrides'"
	 * @generated
	 */
	Rule getOverrides();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.Rule#getOverrides <em>Overrides</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overrides</em>' reference.
	 * @see #getOverrides()
	 * @generated
	 */
	void setOverrides(Rule value);

	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' container reference.
	 * @see #setTransformation(Transformation)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getRule_Transformation()
	 * @see org.eclipse.qvtd.pivot.qvtbase.Transformation#getRule
	 * @model opposite="rule" resolveProxies="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTbase!Rule!transformation'"
	 * @generated
	 */
	Transformation getTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.Rule#getTransformation <em>Transformation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' container reference.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(Transformation value);

	/**
	 * Returns the value of the '<em><b>Overridden</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.Rule}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtbase.Rule#getOverrides <em>Overrides</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overridden</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overridden</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getRule_Overridden()
	 * @see org.eclipse.qvtd.pivot.qvtbase.Rule#getOverrides
	 * @model opposite="overrides" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTbase!Rule!overridden'"
	 * @generated
	 */
	EList<Rule> getOverridden();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='DomainNameIsUnique'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv DomainNameIsUnique:\n *   let severity : Integer[1] = \'Rule::DomainNameIsUnique\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let result : Boolean[1] = domain-&gt;isUnique(name)\n *       in\n *         \'Rule::DomainNameIsUnique\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IdResolver idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Rule_c_c_DomainNameIsUnique);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.lang.Object%&gt; CAUGHT_result;\n\ttry {\n\t\t@SuppressWarnings(\"null\")\n\t\tfinal /*@NonInvalid\052/ java.util.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; List&lt;&lt;%org.eclipse.qvtd.pivot.qvtbase.Domain%&gt;&gt; domain = this.getDomain();\n\t\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; OrderedSetValue BOXED_domain = idResolver.createOrderedSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.ORD_CLSSid_Domain, domain);\n\t\t/*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.SetValue%&gt;.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createSetAccumulatorValue(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.ORD_CLSSid_Domain);\n\t\t@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.util.Iterator%&gt;&lt;&lt;%java.lang.Object%&gt;&gt; ITERATOR__1 = BOXED_domain.iterator();\n\t\t/*@Thrown\052/ boolean result;\n\t\twhile (true) {\n\t\t\tif (!ITERATOR__1.hasNext()) {\n\t\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t\tbreak;\n\t\t\t}\n\t\t\t@SuppressWarnings(\"null\")\n\t\t\t/*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Domain _1 = (&lt;%org.eclipse.qvtd.pivot.qvtbase.Domain%&gt;)ITERATOR__1.next();\n\t\t\t/**\n\t\t\t * name\n\t\t\t \052/\n\t\t\tfinal /*@NonInvalid\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; String name = _1.getName();\n\t\t\t//\n\t\t\tif (accumulator.includes(name) == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\n\t\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE;\t\t\t// Abort after second find\n\t\t\t\tbreak;\n\t\t\t}\n\t\t\telse {\n\t\t\t\taccumulator.add(name);\n\t\t\t}\n\t\t}\n\t\tCAUGHT_result = result;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Rule_c_c_DomainNameIsUnique, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n\tsymbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean validateDomainNameIsUnique(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='NoOverridesCycle'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv NoOverridesCycle:\n *   let severity : Integer[1] = \'Rule::NoOverridesCycle\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let\n *         result : Boolean[1] = overrides-&gt;closure(overrides)\n *         -&gt;excludes(self)\n *       in\n *         \'Rule::NoOverridesCycle\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IdResolver idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; StandardLibrary standardLibrary = idResolver.getStandardLibrary();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Rule_c_c_NoOverridesCycle);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_1;\nif (le) {\n\tsymbol_1 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.lang.Object%&gt; CAUGHT_result;\n\ttry {\n\t\tfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Rule overrides = this.getOverrides();\n\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; SetValue oclAsSet = &lt;%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.SET_CLSSid_Rule, overrides);\n\t\tfinal org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Class TYPE_closure_0 = executor.getStaticTypeOf(oclAsSet);\n\t\tfinal &lt;%org.eclipse.ocl.pivot.library.LibraryIteration%&gt;.@org.eclipse.jdt.annotation.NonNull LibraryIterationExtension IMPL_closure_0 = (&lt;%org.eclipse.ocl.pivot.library.LibraryIteration%&gt;.LibraryIterationExtension)TYPE_closure_0.lookupImplementation(standardLibrary, &lt;%org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables%&gt;.Operations._Set__closure);\n\t\tfinal @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Object ACC_closure_0 = IMPL_closure_0.createAccumulatorValue(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.SET_CLSSid_Rule, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.CLSSid_Rule);\n\t\t/**\n\t\t * Implementation of the iterator body.\n\t\t \052/\n\t\tfinal @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%org.eclipse.ocl.pivot.library.AbstractBinaryOperation%&gt; BODY_closure_0 = new &lt;%org.eclipse.ocl.pivot.library.AbstractBinaryOperation%&gt;()\n\t\t{\n\t\t\t/**\n\t\t\t * overrides\n\t\t\t \052/\n\t\t\t@Override\n\t\t\tpublic @&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Object evaluate(final @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%org.eclipse.ocl.pivot.evaluation.Executor%&gt; executor, final @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt; typeId, final @&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Object oclAsSet, final /*@NonInvalid\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Object _1) {\n\t\t\t\tfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Rule symbol_0 = (&lt;%org.eclipse.qvtd.pivot.qvtbase.Rule%&gt;)_1;\n\t\t\t\tif (symbol_0 == null) {\n\t\t\t\t\tthrow new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(\"Null source for \\\'\\\'http://www.eclipse.org/qvt/2015/QVTbase\\\'::Rule::overrides\\\'\");\n\t\t\t\t}\n\t\t\t\tfinal /*@Thrown\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Rule overrides_0 = symbol_0.getOverrides();\n\t\t\t\treturn overrides_0;\n\t\t\t}\n\t\t};\n\t\tfinal @&lt;%org.eclipse.jdt.annotation.NonNull%&gt;  &lt;%org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager%&gt; MGR_closure_0 = new &lt;%org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager%&gt;(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.SET_CLSSid_Rule, BODY_closure_0, oclAsSet, ACC_closure_0);\n\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; SetValue closure = &lt;%org.eclipse.ocl.pivot.utilities.ClassUtil%&gt;.nonNullState((&lt;%org.eclipse.ocl.pivot.values.SetValue%&gt;)IMPL_closure_0.evaluateIteration(MGR_closure_0));\n\t\tfinal /*@Thrown\052/ boolean result = &lt;%org.eclipse.ocl.pivot.library.collection.CollectionExcludesOperation%&gt;.INSTANCE.evaluate(closure, this).booleanValue();\n\t\tCAUGHT_result = result;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Rule_c_c_NoOverridesCycle, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n\tsymbol_1 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_1;'"
	 * @generated
	 */
	boolean validateNoOverridesCycle(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='OverridesRuleIsExtendedRule'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv OverridesRuleIsExtendedRule:\n *   let\n *     severity : Integer[1] = \'Rule::OverridesRuleIsExtendedRule\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let result : Boolean[?] = overrides &lt;&gt; null and transformation &lt;&gt; null implies\n *         let\n *           extendedRules : Bag(qvtbase::Rule) = transformation-&gt;closure(extends)\n *           -&gt;excluding(transformation)\n *           ?-&gt;collect(rule)\n *         in extendedRules-&gt;includes(overrides)\n *       in\n *         \'Rule::OverridesRuleIsExtendedRule\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IdResolver idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; StandardLibrary standardLibrary = idResolver.getStandardLibrary();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Rule_c_c_OverridesRuleIsExtendedRule);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_2;\nif (le) {\n\tsymbol_2 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.lang.Object%&gt; CAUGHT_result;\n\ttry {\n\t\tfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Rule overrides_0 = this.getOverrides();\n\t\tfinal /*@NonInvalid\052/ boolean ne = overrides_0 != null;\n\t\t/*@NonInvalid\052/ boolean and;\n\t\tif (ne) {\n\t\t\tfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Transformation transformation = this.getTransformation();\n\t\t\tfinal /*@NonInvalid\052/ boolean ne_0 = transformation != null;\n\t\t\tand = ne_0;\n\t\t}\n\t\telse {\n\t\t\tand = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE;\n\t\t}\n\t\t/*@Thrown\052/ boolean result;\n\t\tif (and) {\n\t\t\tfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Transformation transformation_1 = this.getTransformation();\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; SetValue oclAsSet = &lt;%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.SET_CLSSid_Transformation, transformation_1);\n\t\t\tfinal org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Class TYPE_closure_0 = executor.getStaticTypeOf(oclAsSet);\n\t\t\tfinal &lt;%org.eclipse.ocl.pivot.library.LibraryIteration%&gt;.@org.eclipse.jdt.annotation.NonNull LibraryIterationExtension IMPL_closure_0 = (&lt;%org.eclipse.ocl.pivot.library.LibraryIteration%&gt;.LibraryIterationExtension)TYPE_closure_0.lookupImplementation(standardLibrary, &lt;%org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables%&gt;.Operations._Set__closure);\n\t\t\tfinal @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Object ACC_closure_0 = IMPL_closure_0.createAccumulatorValue(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.SET_CLSSid_Transformation, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.CLSSid_Transformation);\n\t\t\t/**\n\t\t\t * Implementation of the iterator body.\n\t\t\t \052/\n\t\t\tfinal @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%org.eclipse.ocl.pivot.library.AbstractBinaryOperation%&gt; BODY_closure_0 = new &lt;%org.eclipse.ocl.pivot.library.AbstractBinaryOperation%&gt;()\n\t\t\t{\n\t\t\t\t/**\n\t\t\t\t * extends\n\t\t\t\t \052/\n\t\t\t\t@Override\n\t\t\t\tpublic @&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Object evaluate(final @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%org.eclipse.ocl.pivot.evaluation.Executor%&gt; executor, final @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt; typeId, final @&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Object oclAsSet, final /*@NonInvalid\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Object _1) {\n\t\t\t\t\tfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Transformation symbol_0 = (&lt;%org.eclipse.qvtd.pivot.qvtbase.Transformation%&gt;)_1;\n\t\t\t\t\tif (symbol_0 == null) {\n\t\t\t\t\t\tthrow new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(\"Null source for \\\'\\\'http://www.eclipse.org/qvt/2015/QVTbase\\\'::Transformation::extends\\\'\");\n\t\t\t\t\t}\n\t\t\t\t\tfinal /*@Thrown\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Transformation symbol_1 = symbol_0.getExtends();\n\t\t\t\t\treturn symbol_1;\n\t\t\t\t}\n\t\t\t};\n\t\t\tfinal @&lt;%org.eclipse.jdt.annotation.NonNull%&gt;  &lt;%org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager%&gt; MGR_closure_0 = new &lt;%org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager%&gt;(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.SET_CLSSid_Transformation, BODY_closure_0, oclAsSet, ACC_closure_0);\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; SetValue closure = &lt;%org.eclipse.ocl.pivot.utilities.ClassUtil%&gt;.nonNullState((&lt;%org.eclipse.ocl.pivot.values.SetValue%&gt;)IMPL_closure_0.evaluateIteration(MGR_closure_0));\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; SetValue excluding = (&lt;%org.eclipse.ocl.pivot.values.SetValue%&gt;)&lt;%org.eclipse.ocl.pivot.library.collection.CollectionExcludingOperation%&gt;.INSTANCE.evaluate(closure, transformation_1);\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; SetValue safe_null_sources = (&lt;%org.eclipse.ocl.pivot.values.SetValue%&gt;)&lt;%org.eclipse.ocl.pivot.library.collection.CollectionExcludingOperation%&gt;.INSTANCE.evaluate(excluding, (Object)null);\n\t\t\t/*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.BagValue%&gt;.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createBagAccumulatorValue(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.BAG_CLSSid_Rule);\n\t\t\t@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.util.Iterator%&gt;&lt;&lt;%java.lang.Object%&gt;&gt; ITERATOR__1_0 = safe_null_sources.iterator();\n\t\t\t/*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; BagValue extendedRules;\n\t\t\twhile (true) {\n\t\t\t\tif (!ITERATOR__1_0.hasNext()) {\n\t\t\t\t\textendedRules = accumulator;\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\t/*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Transformation _1_0 = (&lt;%org.eclipse.qvtd.pivot.qvtbase.Transformation%&gt;)ITERATOR__1_0.next();\n\t\t\t\t/**\n\t\t\t\t * rule\n\t\t\t\t \052/\n\t\t\t\tfinal /*@NonInvalid\052/ java.util.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; List&lt;&lt;%org.eclipse.qvtd.pivot.qvtbase.Rule%&gt;&gt; rule = _1_0.getRule();\n\t\t\t\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; SetValue BOXED_rule = idResolver.createSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.SET_CLSSid_Rule, rule);\n\t\t\t\t//\n\t\t\t\tfor (Object value : BOXED_rule.flatten().getElements()) {\n\t\t\t\t\taccumulator.add(value);\n\t\t\t\t}\n\t\t\t}\n\t\t\tfinal /*@Thrown\052/ boolean includes = &lt;%org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation%&gt;.INSTANCE.evaluate(extendedRules, overrides_0).booleanValue();\n\t\t\tresult = includes;\n\t\t}\n\t\telse {\n\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t}\n\t\tCAUGHT_result = result;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Rule_c_c_OverridesRuleIsExtendedRule, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n\tsymbol_2 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_2;'"
	 * @generated
	 */
	boolean validateOverridesRuleIsExtendedRule(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='OverridesRuleOverridesAllDomains'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv OverridesRuleOverridesAllDomains:\n *   let\n *     severity : Integer[1] = \'Rule::OverridesRuleOverridesAllDomains\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let result : Boolean[?] = overrides &lt;&gt; null implies\n *         overrides.domain-&gt;forAll(od |\n *           self.domain.name-&gt;includes(od.name))\n *       in\n *         \'Rule::OverridesRuleOverridesAllDomains\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IdResolver idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Rule_c_c_OverridesRuleOverridesAllDomains);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.lang.Object%&gt; CAUGHT_result;\n\ttry {\n\t\tfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Rule overrides = this.getOverrides();\n\t\tfinal /*@NonInvalid\052/ boolean ne = overrides != null;\n\t\t/*@Thrown\052/ boolean result;\n\t\tif (ne) {\n\t\t\tif (overrides == null) {\n\t\t\t\tthrow new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(\"Null source for \\\'\\\'http://www.eclipse.org/qvt/2015/QVTbase\\\'::Rule::domain\\\'\");\n\t\t\t}\n\t\t\t@SuppressWarnings(\"null\")\n\t\t\tfinal /*@Thrown\052/ java.util.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; List&lt;&lt;%org.eclipse.qvtd.pivot.qvtbase.Domain%&gt;&gt; domain = overrides.getDomain();\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; OrderedSetValue BOXED_domain = idResolver.createOrderedSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.ORD_CLSSid_Domain, domain);\n\t\t\t/*@Thrown\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Object accumulator = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.util.Iterator%&gt;&lt;&lt;%java.lang.Object%&gt;&gt; ITERATOR_od = BOXED_domain.iterator();\n\t\t\t/*@Thrown\052/ boolean forAll;\n\t\t\twhile (true) {\n\t\t\t\tif (!ITERATOR_od.hasNext()) {\n\t\t\t\t\tif (accumulator == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\n\t\t\t\t\t\tforAll = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t\t\t}\n\t\t\t\t\telse {\n\t\t\t\t\t\tthrow (&lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;)accumulator;\n\t\t\t\t\t}\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\t/*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Domain od = (&lt;%org.eclipse.qvtd.pivot.qvtbase.Domain%&gt;)ITERATOR_od.next();\n\t\t\t\t/**\n\t\t\t\t * self.domain.name-&gt;includes(od.name)\n\t\t\t\t \052/\n\t\t\t\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.lang.Object%&gt; CAUGHT_includes;\n\t\t\t\ttry {\n\t\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\t\tfinal /*@NonInvalid\052/ java.util.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; List&lt;&lt;%org.eclipse.qvtd.pivot.qvtbase.Domain%&gt;&gt; domain_0 = this.getDomain();\n\t\t\t\t\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; OrderedSetValue BOXED_domain_0 = idResolver.createOrderedSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.ORD_CLSSid_Domain, domain_0);\n\t\t\t\t\t/*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.SequenceValue%&gt;.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createSequenceAccumulatorValue(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.SEQ_PRIMid_String);\n\t\t\t\t\t@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.util.Iterator%&gt;&lt;&lt;%java.lang.Object%&gt;&gt; ITERATOR__1 = BOXED_domain_0.iterator();\n\t\t\t\t\t/*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; SequenceValue collect;\n\t\t\t\t\twhile (true) {\n\t\t\t\t\t\tif (!ITERATOR__1.hasNext()) {\n\t\t\t\t\t\t\tcollect = accumulator_0;\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t}\n\t\t\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\t\t\t/*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Domain _1 = (&lt;%org.eclipse.qvtd.pivot.qvtbase.Domain%&gt;)ITERATOR__1.next();\n\t\t\t\t\t\t/**\n\t\t\t\t\t\t * name\n\t\t\t\t\t\t \052/\n\t\t\t\t\t\tfinal /*@NonInvalid\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; String name = _1.getName();\n\t\t\t\t\t\t//\n\t\t\t\t\t\taccumulator_0.add(name);\n\t\t\t\t\t}\n\t\t\t\t\tfinal /*@NonInvalid\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; String name_0 = od.getName();\n\t\t\t\t\tfinal /*@Thrown\052/ boolean includes = &lt;%org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation%&gt;.INSTANCE.evaluate(collect, name_0).booleanValue();\n\t\t\t\t\tCAUGHT_includes = includes;\n\t\t\t\t}\n\t\t\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\t\t\tCAUGHT_includes = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t\t\t}\n\t\t\t\t//\n\t\t\t\tif (CAUGHT_includes == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE) {\t\t\t\t\t// Normal unsuccessful body evaluation result\n\t\t\t\t\tforAll = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE;\n\t\t\t\t\tbreak;\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Stop immediately\n\t\t\t\t}\n\t\t\t\telse if (CAUGHT_includes == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\t\t\t\t// Normal successful body evaluation result\n\t\t\t\t\t;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Carry on\n\t\t\t\t}\n\t\t\t\telse if (CAUGHT_includes instanceof &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;) {\t\t// Abnormal exception evaluation result\n\t\t\t\t\taccumulator = CAUGHT_includes;\t\t\t\t\t\t\t\t\t// Cache an exception failure\n\t\t\t\t}\n\t\t\t\telse {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Impossible badly typed result\n\t\t\t\t\taccumulator = new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(&lt;%org.eclipse.ocl.pivot.messages.PivotMessages%&gt;.NonBooleanBody, \"forAll\");\n\t\t\t\t}\n\t\t\t}\n\t\t\tresult = forAll;\n\t\t}\n\t\telse {\n\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t}\n\t\tCAUGHT_result = result;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Rule_c_c_OverridesRuleOverridesAllDomains, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n\tsymbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean validateOverridesRuleOverridesAllDomains(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Rule
