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
package org.eclipse.qvtd.pivot.qvtbase;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.ReferringElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Domain#isIsCheckable <em>Is Checkable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Domain#isIsEnforceable <em>Is Enforceable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Domain#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Domain#getTypedModel <em>Typed Model</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getDomain()
 * @model abstract="true"
 * @generated
 */
public interface Domain extends NamedElement, ReferringElement {
	/**
	 * Returns the value of the '<em><b>Is Checkable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Checkable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Checkable</em>' attribute.
	 * @see #isSetIsCheckable()
	 * @see #unsetIsCheckable()
	 * @see #setIsCheckable(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getDomain_IsCheckable()
	 * @model unsettable="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTbase!Domain!isCheckable'"
	 * @generated
	 */
	boolean isIsCheckable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.Domain#isIsCheckable <em>Is Checkable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Checkable</em>' attribute.
	 * @see #isSetIsCheckable()
	 * @see #unsetIsCheckable()
	 * @see #isIsCheckable()
	 * @generated
	 */
	void setIsCheckable(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.Domain#isIsCheckable <em>Is Checkable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsCheckable()
	 * @see #isIsCheckable()
	 * @see #setIsCheckable(boolean)
	 * @generated
	 */
	void unsetIsCheckable();

	/**
	 * Returns whether the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.Domain#isIsCheckable <em>Is Checkable</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Checkable</em>' attribute is set.
	 * @see #unsetIsCheckable()
	 * @see #isIsCheckable()
	 * @see #setIsCheckable(boolean)
	 * @generated
	 */
	boolean isSetIsCheckable();

	/**
	 * Returns the value of the '<em><b>Is Enforceable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Enforceable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Enforceable</em>' attribute.
	 * @see #isSetIsEnforceable()
	 * @see #unsetIsEnforceable()
	 * @see #setIsEnforceable(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getDomain_IsEnforceable()
	 * @model unsettable="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTbase!Domain!isEnforceable'"
	 * @generated
	 */
	boolean isIsEnforceable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.Domain#isIsEnforceable <em>Is Enforceable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Enforceable</em>' attribute.
	 * @see #isSetIsEnforceable()
	 * @see #unsetIsEnforceable()
	 * @see #isIsEnforceable()
	 * @generated
	 */
	void setIsEnforceable(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.Domain#isIsEnforceable <em>Is Enforceable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsEnforceable()
	 * @see #isIsEnforceable()
	 * @see #setIsEnforceable(boolean)
	 * @generated
	 */
	void unsetIsEnforceable();

	/**
	 * Returns whether the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.Domain#isIsEnforceable <em>Is Enforceable</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Enforceable</em>' attribute is set.
	 * @see #unsetIsEnforceable()
	 * @see #isIsEnforceable()
	 * @see #setIsEnforceable(boolean)
	 * @generated
	 */
	boolean isSetIsEnforceable();

	/**
	 * Returns the value of the '<em><b>Rule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtbase.Rule#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' container reference.
	 * @see #setRule(Rule)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getDomain_Rule()
	 * @see org.eclipse.qvtd.pivot.qvtbase.Rule#getDomain
	 * @model opposite="domain" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTbase!Domain!rule'"
	 * @generated
	 */
	Rule getRule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.Domain#getRule <em>Rule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' container reference.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(Rule value);

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
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getDomain_TypedModel()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTbase!Domain!typedModel'"
	 * @generated
	 */
	TypedModel getTypedModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.Domain#getTypedModel <em>Typed Model</em>}' reference.
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
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='NameIsTypedModelName'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv NameIsTypedModelName:\n *   let severity : Integer[1] = \'Domain::NameIsTypedModelName\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let result : Boolean[?] = typedModel &lt;&gt; null implies name = typedModel.name\n *       in\n *         \'Domain::NameIsTypedModelName\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Domain_c_c_NameIsTypedModelName);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.lang.Object%&gt; CAUGHT_result;\n\ttry {\n\t\tfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; TypedModel typedModel = this.getTypedModel();\n\t\tfinal /*@NonInvalid\052/ boolean ne = typedModel != null;\n\t\t/*@Thrown\052/ boolean result;\n\t\tif (ne) {\n\t\t\tfinal /*@NonInvalid\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; String name = this.getName();\n\t\t\tif (typedModel == null) {\n\t\t\t\tthrow new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(\"Null source for \\\'NamedElement::name\\\'\");\n\t\t\t}\n\t\t\tfinal /*@Thrown\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; String name_0 = typedModel.getName();\n\t\t\tfinal /*@Thrown\052/ boolean eq = (name != null) ? name.equals(name_0) : (name_0 == null);\n\t\t\tresult = eq;\n\t\t}\n\t\telse {\n\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t}\n\t\tCAUGHT_result = result;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Domain_c_c_NameIsTypedModelName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n\tsymbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean validateNameIsTypedModelName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='TypedModelIsTransformationModelParameter'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv TypedModelIsTransformationModelParameter:\n *   let\n *     severity : Integer[1] = \'Domain::TypedModelIsTransformationModelParameter\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let\n *         result : Boolean[?] = oclContainer()\n *         .oclIsKindOf(Transformation) and typedModel &lt;&gt; null implies\n *         oclContainer()\n *         .oclAsType(Transformation)\n *         .modelParameter-&gt;includes(typedModel)\n *       in\n *         \'Domain::TypedModelIsTransformationModelParameter\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IdResolver idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Domain_c_c_TypedModelIsTransformationModelParameter);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.Nullable%&gt; &lt;%java.lang.Object%&gt; CAUGHT_result;\n\ttry {\n\t\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.Nullable%&gt; &lt;%java.lang.Object%&gt; CAUGHT_and;\n\t\ttry {\n\t\t\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.lang.Object%&gt; CAUGHT_oclIsKindOf;\n\t\t\ttry {\n\t\t\t\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Class TYP_qvtbase_c_c_Transformation = idResolver.getClass(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.CLSSid_Transformation, null);\n\t\t\t\tfinal /*@NonInvalid\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Object oclContainer = &lt;%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%&gt;.INSTANCE.evaluate(executor, this);\n\t\t\t\tfinal /*@Thrown\052/ boolean oclIsKindOf = &lt;%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation%&gt;.INSTANCE.evaluate(executor, oclContainer, TYP_qvtbase_c_c_Transformation).booleanValue();\n\t\t\t\tCAUGHT_oclIsKindOf = oclIsKindOf;\n\t\t\t}\n\t\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\t\tCAUGHT_oclIsKindOf = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t\t}\n\t\t\tfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; TypedModel typedModel = this.getTypedModel();\n\t\t\tfinal /*@NonInvalid\052/ boolean ne = typedModel != null;\n\t\t\tfinal /*@Thrown\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Boolean and = &lt;%org.eclipse.ocl.pivot.library.logical.BooleanAndOperation%&gt;.INSTANCE.evaluate(CAUGHT_oclIsKindOf, ne);\n\t\t\tCAUGHT_and = and;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_and = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.lang.Object%&gt; CAUGHT_includes;\n\t\ttry {\n\t\t\tfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Class TYP_qvtbase_c_c_Transformation_0 = idResolver.getClass(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.CLSSid_Transformation, null);\n\t\t\tfinal /*@NonInvalid\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Object oclContainer_0 = &lt;%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%&gt;.INSTANCE.evaluate(executor, this);\n\t\t\tfinal /*@Thrown\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Transformation oclAsType = &lt;%org.eclipse.ocl.pivot.utilities.ClassUtil%&gt;.nonNullState((&lt;%org.eclipse.qvtd.pivot.qvtbase.Transformation%&gt;)&lt;%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%&gt;.INSTANCE.evaluate(executor, oclContainer_0, TYP_qvtbase_c_c_Transformation_0));\n\t\t\tfinal /*@Thrown\052/ java.util.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; List&lt;&lt;%org.eclipse.qvtd.pivot.qvtbase.TypedModel%&gt;&gt; modelParameter = oclAsType.getModelParameter();\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; OrderedSetValue BOXED_modelParameter = idResolver.createOrderedSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.ORD_CLSSid_TypedModel, modelParameter);\n\t\t\tfinal /*@NonInvalid\052/ org.eclipse.qvtd.pivot.qvtbase.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; TypedModel typedModel_0 = this.getTypedModel();\n\t\t\tfinal /*@Thrown\052/ boolean includes = &lt;%org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation%&gt;.INSTANCE.evaluate(BOXED_modelParameter, typedModel_0).booleanValue();\n\t\t\tCAUGHT_includes = includes;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_includes = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\tfinal /*@Thrown\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Boolean result = &lt;%org.eclipse.ocl.pivot.library.logical.BooleanImpliesOperation%&gt;.INSTANCE.evaluate(CAUGHT_and, CAUGHT_includes);\n\t\tCAUGHT_result = result;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.STR_Domain_c_c_TypedModelIsTransformationModelParameter, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables%&gt;.INT_0).booleanValue();\n\tsymbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean validateTypedModelIsTransformationModelParameter(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Domain
