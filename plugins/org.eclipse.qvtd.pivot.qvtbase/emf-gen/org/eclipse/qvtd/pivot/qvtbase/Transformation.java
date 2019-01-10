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
package org.eclipse.qvtd.pivot.qvtbase;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getOwnedTag <em>Owned Tag</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getModelParameter <em>Model Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getOwnedContext <em>Owned Context</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTransformation()
 * @model
 * @generated
 */
public interface Transformation extends org.eclipse.ocl.pivot.Class {
	/**
	 * Returns the value of the '<em><b>Owned Tag</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Annotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Tag</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Tag</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTransformation_OwnedTag()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTbase!Transformation!ownedTag'"
	 * @generated
	 */
	@NonNull EList<Annotation> getOwnedTag();

	/**
	 * Returns the value of the '<em><b>Model Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.TypedModel}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Parameter</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTransformation_ModelParameter()
	 * @see org.eclipse.qvtd.pivot.qvtbase.TypedModel#getTransformation
	 * @model opposite="transformation" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTbase!Transformation!modelParameter'"
	 * @generated
	 */
	@NonNull EList<TypedModel> getModelParameter();

	/**
	 * Returns the value of the '<em><b>Rule</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.Rule}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtbase.Rule#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTransformation_Rule()
	 * @see org.eclipse.qvtd.pivot.qvtbase.Rule#getTransformation
	 * @model opposite="transformation" containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTbase!Transformation!rule'"
	 * @generated
	 */
	@NonNull EList<Rule> getRule();

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' reference.
	 * @see #setExtends(Transformation)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTransformation_Extends()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='extendedBy'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTbase!Transformation!extends'"
	 * @generated
	 */
	Transformation getExtends();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getExtends <em>Extends</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' reference.
	 * @see #getExtends()
	 * @generated
	 */
	void setExtends(Transformation value);

	/**
	 * Returns the value of the '<em><b>Owned Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Context</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Context</em>' containment reference.
	 * @see #setOwnedContext(Variable)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTransformation_OwnedContext()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTbase!Transformation!ownedContext'"
	 * @generated
	 */
	Variable getOwnedContext();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getOwnedContext <em>Owned Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Context</em>' containment reference.
	 * @see #getOwnedContext()
	 * @generated
	 */
	void setOwnedContext(Variable value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" nameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTbase!Transformation!getFunction(String)'"
	 * @generated
	 */
	Function getFunction(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" nameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTbase!Transformation!getModelParameter(String)'"
	 * @generated
	 */
	TypedModel getModelParameter(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='ContextTypeIsTransformation'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv ContextTypeIsTransformation:\n *   let\n *     severity : Integer[1] = \'Transformation::ContextTypeIsTransformation\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let result : Boolean[?] = ownedContext &lt;&gt; null implies ownedContext.type = self\n *       in\n *         \'Transformation::ContextTypeIsTransformation\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.@org.eclipse.jdt.annotation.NonNull Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Transformation_c_c_ContextTypeIsTransformation);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ &lt;%@org.eclipse.jdt.annotation.NonNull Object%&gt; CAUGHT_result;\n\ttry {\n\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Variable%&gt; ownedContext = this.getOwnedContext();\n\t\tfinal /*@NonInvalid\052/ boolean ne = ownedContext != null;\n\t\t/*@Thrown\052/ boolean result;\n\t\tif (ne) {\n\t\t\tif (ownedContext == null) {\n\t\t\t\tthrow new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(\"Null source for \\\'TypedElement::type\\\'\");\n\t\t\t}\n\t\t\tfinal /*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Type%&gt; type = ownedContext.getType();\n\t\t\tfinal /*@Thrown\052/ boolean eq = (type != null) ? (type.getTypeId() == this.getTypeId()) : false;\n\t\t\tresult = eq;\n\t\t}\n\t\telse {\n\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t}\n\t\tCAUGHT_result = result;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Transformation_c_c_ContextTypeIsTransformation, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n\tsymbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean validateContextTypeIsTransformation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='ExtendedTypedModelIsExtended'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv ExtendedTypedModelIsExtended:\n *   let\n *     severity : Integer[1] = \'Transformation::ExtendedTypedModelIsExtended\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let result : Boolean[?] = extends &lt;&gt; null implies\n *         extends.modelParameter-&gt;forAll(etm |\n *           self.modelParameter-&gt;select(name = etm.name)\n *           .usedPackage-&gt;includesAll(etm.usedPackage))\n *       in\n *         \'Transformation::ExtendedTypedModelIsExtended\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.@org.eclipse.jdt.annotation.NonNull Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver%&gt; idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Transformation_c_c_ExtendedTypedModelIsExtended);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_2;\nif (le) {\n\tsymbol_2 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ &lt;%@org.eclipse.jdt.annotation.Nullable Object%&gt; CAUGHT_result;\n\ttry {\n\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.qvtd.pivot.qvtbase.@org.eclipse.jdt.annotation.Nullable Transformation%&gt; symbol_0 = this.getExtends();\n\t\tfinal /*@NonInvalid\052/ boolean ne = symbol_0 != null;\n\t\t/*@Thrown\052/ &lt;%java.lang.@org.eclipse.jdt.annotation.Nullable Boolean%&gt; result;\n\t\tif (ne) {\n\t\t\tif (symbol_0 == null) {\n\t\t\t\tthrow new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(\"Null source for \\\'\\\'http://www.eclipse.org/qvt/2015/QVTbase\\\'::Transformation::modelParameter\\\'\");\n\t\t\t}\n\t\t\tfinal /*@Thrown\052/ &lt;%java.util.@org.eclipse.jdt.annotation.NonNull List%&gt;&lt;&lt;%org.eclipse.qvtd.pivot.qvtbase.TypedModel%&gt;&gt; modelParameter = symbol_0.getModelParameter();\n\t\t\tfinal /*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue%&gt; BOXED_modelParameter = idResolver.createOrderedSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.ORD_CLSSid_TypedModel, modelParameter);\n\t\t\t/*@Thrown\052/ &lt;%@org.eclipse.jdt.annotation.Nullable Object%&gt; accumulator = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t&lt;%java.util.@org.eclipse.jdt.annotation.NonNull Iterator%&gt;&lt;&lt;%java.lang.Object%&gt;&gt; ITERATOR_etm = BOXED_modelParameter.iterator();\n\t\t\t/*@Thrown\052/ &lt;%java.lang.@org.eclipse.jdt.annotation.Nullable Boolean%&gt; forAll;\n\t\t\twhile (true) {\n\t\t\t\tif (!ITERATOR_etm.hasNext()) {\n\t\t\t\t\tif (accumulator == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\n\t\t\t\t\t\tforAll = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t\t\t}\n\t\t\t\t\telse {\n\t\t\t\t\t\tthrow (&lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;)accumulator;\n\t\t\t\t\t}\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\t/*@NonInvalid\052/ &lt;%org.eclipse.qvtd.pivot.qvtbase.@org.eclipse.jdt.annotation.NonNull TypedModel%&gt; etm = (&lt;%org.eclipse.qvtd.pivot.qvtbase.@org.eclipse.jdt.annotation.NonNull TypedModel%&gt;)ITERATOR_etm.next();\n\t\t\t\t/**\n\t\t\t\t *\n\t\t\t\t * self.modelParameter-&gt;select(name = etm.name)\n\t\t\t\t * .usedPackage-&gt;includesAll(etm.usedPackage)\n\t\t\t\t \052/\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%java.util.@org.eclipse.jdt.annotation.NonNull List%&gt;&lt;&lt;%org.eclipse.qvtd.pivot.qvtbase.TypedModel%&gt;&gt; modelParameter_0 = this.getModelParameter();\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue%&gt; BOXED_modelParameter_0 = idResolver.createOrderedSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.ORD_CLSSid_TypedModel, modelParameter_0);\n\t\t\t\t/*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.OrderedSetValue.@org.eclipse.jdt.annotation.NonNull Accumulator%&gt; accumulator_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createOrderedSetAccumulatorValue(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.ORD_CLSSid_TypedModel);\n\t\t\t\t&lt;%java.util.@org.eclipse.jdt.annotation.NonNull Iterator%&gt;&lt;&lt;%java.lang.Object%&gt;&gt; ITERATOR__1 = BOXED_modelParameter_0.iterator();\n\t\t\t\t/*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue%&gt; select;\n\t\t\t\twhile (true) {\n\t\t\t\t\tif (!ITERATOR__1.hasNext()) {\n\t\t\t\t\t\tselect = accumulator_0;\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t}\n\t\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\t\t/*@NonInvalid\052/ &lt;%org.eclipse.qvtd.pivot.qvtbase.@org.eclipse.jdt.annotation.NonNull TypedModel%&gt; _1 = (&lt;%org.eclipse.qvtd.pivot.qvtbase.@org.eclipse.jdt.annotation.NonNull TypedModel%&gt;)ITERATOR__1.next();\n\t\t\t\t\t/**\n\t\t\t\t\t * name = etm.name\n\t\t\t\t\t \052/\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%java.lang.@org.eclipse.jdt.annotation.Nullable String%&gt; name = _1.getName();\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%java.lang.@org.eclipse.jdt.annotation.Nullable String%&gt; name_0 = etm.getName();\n\t\t\t\t\tfinal /*@NonInvalid\052/ boolean eq = (name != null) ? name.equals(name_0) : (name_0 == null);\n\t\t\t\t\t//\n\t\t\t\t\tif (eq == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\n\t\t\t\t\t\taccumulator_0.add(_1);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t/*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator%&gt; accumulator_1 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createSequenceAccumulatorValue(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.SEQ_CLSSid_Package);\n\t\t\t\t&lt;%java.util.@org.eclipse.jdt.annotation.NonNull Iterator%&gt;&lt;&lt;%java.lang.Object%&gt;&gt; ITERATOR__1_0 = select.iterator();\n\t\t\t\t/*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue%&gt; collect;\n\t\t\t\twhile (true) {\n\t\t\t\t\tif (!ITERATOR__1_0.hasNext()) {\n\t\t\t\t\t\tcollect = accumulator_1;\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t}\n\t\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\t\t/*@NonInvalid\052/ &lt;%org.eclipse.qvtd.pivot.qvtbase.@org.eclipse.jdt.annotation.NonNull TypedModel%&gt; _1_0 = (&lt;%org.eclipse.qvtd.pivot.qvtbase.@org.eclipse.jdt.annotation.NonNull TypedModel%&gt;)ITERATOR__1_0.next();\n\t\t\t\t\t/**\n\t\t\t\t\t * usedPackage\n\t\t\t\t\t \052/\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%java.util.@org.eclipse.jdt.annotation.NonNull List%&gt;&lt;&lt;%org.eclipse.ocl.pivot.Package%&gt;&gt; usedPackage = _1_0.getUsedPackage();\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue%&gt; BOXED_usedPackage = idResolver.createSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.SET_CLSSid_Package, usedPackage);\n\t\t\t\t\t//\n\t\t\t\t\tfor (Object value : BOXED_usedPackage.flatten().getElements()) {\n\t\t\t\t\t\taccumulator_1.add(value);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%java.util.@org.eclipse.jdt.annotation.NonNull List%&gt;&lt;&lt;%org.eclipse.ocl.pivot.Package%&gt;&gt; usedPackage_0 = etm.getUsedPackage();\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue%&gt; BOXED_usedPackage_0 = idResolver.createSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.SET_CLSSid_Package, usedPackage_0);\n\t\t\t\tfinal /*@NonInvalid\052/ boolean includesAll = &lt;%org.eclipse.ocl.pivot.library.collection.CollectionIncludesAllOperation%&gt;.INSTANCE.evaluate(collect, BOXED_usedPackage_0).booleanValue();\n\t\t\t\t//\n\t\t\t\tif (includesAll == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE) {\t\t\t\t\t// Normal unsuccessful body evaluation result\n\t\t\t\t\tforAll = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE;\n\t\t\t\t\tbreak;\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Stop immediately\n\t\t\t\t}\n\t\t\t\telse if (includesAll == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\t\t\t\t// Normal successful body evaluation result\n\t\t\t\t\t;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Carry on\n\t\t\t\t}\n\t\t\t\telse {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Impossible badly typed result\n\t\t\t\t\taccumulator = new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(&lt;%org.eclipse.ocl.pivot.messages.PivotMessages%&gt;.NonBooleanBody, \"forAll\");\n\t\t\t\t}\n\t\t\t}\n\t\t\tresult = forAll;\n\t\t}\n\t\telse {\n\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t}\n\t\tCAUGHT_result = result;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Transformation_c_c_ExtendedTypedModelIsExtended, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n\tsymbol_2 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_2;'"
	 * @generated
	 */
	boolean validateExtendedTypedModelIsExtended(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='ModelParameterIsUnique'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv ModelParameterIsUnique:\n *   let\n *     severity : Integer[1] = \'Transformation::ModelParameterIsUnique\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let result : Boolean[1] = modelParameter-&gt;isUnique(name)\n *       in\n *         \'Transformation::ModelParameterIsUnique\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.@org.eclipse.jdt.annotation.NonNull Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver%&gt; idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Transformation_c_c_ModelParameterIsUnique);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ &lt;%@org.eclipse.jdt.annotation.NonNull Object%&gt; CAUGHT_result;\n\ttry {\n\t\tfinal /*@NonInvalid\052/ &lt;%java.util.@org.eclipse.jdt.annotation.NonNull List%&gt;&lt;&lt;%org.eclipse.qvtd.pivot.qvtbase.TypedModel%&gt;&gt; modelParameter = this.getModelParameter();\n\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue%&gt; BOXED_modelParameter = idResolver.createOrderedSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.ORD_CLSSid_TypedModel, modelParameter);\n\t\t/*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.SetValue.@org.eclipse.jdt.annotation.NonNull Accumulator%&gt; accumulator = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createSetAccumulatorValue(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.ORD_CLSSid_TypedModel);\n\t\t&lt;%java.util.@org.eclipse.jdt.annotation.NonNull Iterator%&gt;&lt;&lt;%java.lang.Object%&gt;&gt; ITERATOR__1 = BOXED_modelParameter.iterator();\n\t\t/*@Thrown\052/ boolean result;\n\t\twhile (true) {\n\t\t\tif (!ITERATOR__1.hasNext()) {\n\t\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t\tbreak;\n\t\t\t}\n\t\t\t@SuppressWarnings(\"null\")\n\t\t\t/*@NonInvalid\052/ &lt;%org.eclipse.qvtd.pivot.qvtbase.@org.eclipse.jdt.annotation.NonNull TypedModel%&gt; _1 = (&lt;%org.eclipse.qvtd.pivot.qvtbase.@org.eclipse.jdt.annotation.NonNull TypedModel%&gt;)ITERATOR__1.next();\n\t\t\t/**\n\t\t\t * name\n\t\t\t \052/\n\t\t\tfinal /*@NonInvalid\052/ &lt;%java.lang.@org.eclipse.jdt.annotation.Nullable String%&gt; name = _1.getName();\n\t\t\t//\n\t\t\tif (accumulator.includes(name) == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\n\t\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE;\t\t\t// Abort after second find\n\t\t\t\tbreak;\n\t\t\t}\n\t\t\telse {\n\t\t\t\taccumulator.add(name);\n\t\t\t}\n\t\t}\n\t\tCAUGHT_result = result;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Transformation_c_c_ModelParameterIsUnique, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n\tsymbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean validateModelParameterIsUnique(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='NoExtendsCycle'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv NoExtendsCycle:\n *   let severity : Integer[1] = \'Transformation::NoExtendsCycle\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let\n *         result : Boolean[1] = extends-&gt;closure(extends)\n *         -&gt;excludes(self)\n *       in\n *         \'Transformation::NoExtendsCycle\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.@org.eclipse.jdt.annotation.NonNull Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver%&gt; idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull StandardLibrary%&gt; standardLibrary = idResolver.getStandardLibrary();\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Transformation_c_c_NoExtendsCycle);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_3;\nif (le) {\n\tsymbol_3 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ &lt;%@org.eclipse.jdt.annotation.NonNull Object%&gt; CAUGHT_result;\n\ttry {\n\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.qvtd.pivot.qvtbase.@org.eclipse.jdt.annotation.Nullable Transformation%&gt; symbol_0 = this.getExtends();\n\t\tfinal /*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue%&gt; oclAsSet = &lt;%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.SET_CLSSid_Transformation, symbol_0);\n\t\tfinal &lt;%org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class%&gt; TYPE_closure_0 = executor.getStaticTypeOf(oclAsSet);\n\t\tfinal &lt;%org.eclipse.ocl.pivot.library.LibraryIteration.@org.eclipse.jdt.annotation.NonNull LibraryIterationExtension%&gt; IMPL_closure_0 = (&lt;%org.eclipse.ocl.pivot.library.LibraryIteration.LibraryIterationExtension%&gt;)TYPE_closure_0.lookupImplementation(standardLibrary, &lt;%org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables%&gt;.Operations._Set__closure);\n\t\tfinal @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Object ACC_closure_0 = IMPL_closure_0.createAccumulatorValue(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.SET_CLSSid_Transformation, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.CLSSid_Transformation);\n\t\t/**\n\t\t * Implementation of the iterator body.\n\t\t \052/\n\t\tfinal &lt;%org.eclipse.ocl.pivot.library.@org.eclipse.jdt.annotation.NonNull AbstractBinaryOperation%&gt; BODY_closure_0 = new &lt;%org.eclipse.ocl.pivot.library.AbstractBinaryOperation%&gt;()\n\t\t{\n\t\t\t/**\n\t\t\t * extends\n\t\t\t \052/\n\t\t\t@Override\n\t\t\tpublic @&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Object evaluate(final &lt;%org.eclipse.ocl.pivot.evaluation.@org.eclipse.jdt.annotation.NonNull Executor%&gt; executor, final &lt;%org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull TypeId%&gt; typeId, final @&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Object oclAsSet, final /*@NonInvalid\052/ &lt;%@org.eclipse.jdt.annotation.Nullable Object%&gt; _1) {\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.qvtd.pivot.qvtbase.@org.eclipse.jdt.annotation.Nullable Transformation%&gt; symbol_1 = (&lt;%org.eclipse.qvtd.pivot.qvtbase.Transformation%&gt;)_1;\n\t\t\t\tif (symbol_1 == null) {\n\t\t\t\t\tthrow new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(\"Null source for \\\'\\\'http://www.eclipse.org/qvt/2015/QVTbase\\\'::Transformation::extends\\\'\");\n\t\t\t\t}\n\t\t\t\tfinal /*@Thrown\052/ &lt;%org.eclipse.qvtd.pivot.qvtbase.@org.eclipse.jdt.annotation.Nullable Transformation%&gt; symbol_2 = symbol_1.getExtends();\n\t\t\t\treturn symbol_2;\n\t\t\t}\n\t\t};\n\t\tfinal &lt;%org.eclipse.ocl.pivot.internal.library.executor.@org.eclipse.jdt.annotation.NonNull ExecutorSingleIterationManager%&gt; MGR_closure_0 = new &lt;%org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager%&gt;(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.SET_CLSSid_Transformation, BODY_closure_0, oclAsSet, ACC_closure_0);\n\t\tfinal /*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue%&gt; closure = (&lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue%&gt;)IMPL_closure_0.evaluateIteration(MGR_closure_0);\n\t\tfinal /*@Thrown\052/ boolean result = &lt;%org.eclipse.ocl.pivot.library.collection.CollectionExcludesOperation%&gt;.INSTANCE.evaluate(closure, this).booleanValue();\n\t\tCAUGHT_result = result;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Transformation_c_c_NoExtendsCycle, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n\tsymbol_3 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_3;'"
	 * @generated
	 */
	boolean validateNoExtendsCycle(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Transformation
