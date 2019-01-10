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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Template Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp#getPart <em>Part</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp#getReferredClass <em>Referred Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getObjectTemplateExp()
 * @model
 * @generated
 */
public interface ObjectTemplateExp extends TemplateExp {
	/**
	 * Returns the value of the '<em><b>Part</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getObjContainer <em>Obj Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getObjectTemplateExp_Part()
	 * @see org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getObjContainer
	 * @model opposite="objContainer" containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTtemplate!ObjectTemplateExp!part'"
	 * @generated
	 */
	EList<PropertyTemplateItem> getPart();

	/**
	 * Returns the value of the '<em><b>Referred Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Class</em>' reference.
	 * @see #setReferredClass(org.eclipse.ocl.pivot.Class)
	 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getObjectTemplateExp_ReferredClass()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTtemplate!ObjectTemplateExp!referredClass'"
	 * @generated
	 */
	org.eclipse.ocl.pivot.Class getReferredClass();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp#getReferredClass <em>Referred Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Class</em>' reference.
	 * @see #getReferredClass()
	 * @generated
	 */
	void setReferredClass(org.eclipse.ocl.pivot.Class value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='PartPropertyIsUnique'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv PartPropertyIsUnique:\n *   let\n *     severity : Integer[1] = \'ObjectTemplateExp::PartPropertyIsUnique\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let\n *         result : Boolean[1] = part-&gt;isUnique(resolvedProperty)\n *       in\n *         \'ObjectTemplateExp::PartPropertyIsUnique\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.@org.eclipse.jdt.annotation.NonNull Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver%&gt; idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.STR_ObjectTemplateExp_c_c_PartPropertyIsUnique);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t@SuppressWarnings(\"null\")\n\tfinal /*@NonInvalid\052/ &lt;%java.util.@org.eclipse.jdt.annotation.NonNull List%&gt;&lt;&lt;%org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem%&gt;&gt; part = this.getPart();\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue%&gt; BOXED_part = idResolver.createSetOfAll(&lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.SET_CLSSid_PropertyTemplateItem, part);\n\t/*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.SetValue.@org.eclipse.jdt.annotation.NonNull Accumulator%&gt; accumulator = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createSetAccumulatorValue(&lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.SET_CLSSid_PropertyTemplateItem);\n\t&lt;%java.util.@org.eclipse.jdt.annotation.NonNull Iterator%&gt;&lt;&lt;%java.lang.Object%&gt;&gt; ITERATOR__1 = BOXED_part.iterator();\n\t/*@NonInvalid\052/ boolean result;\n\twhile (true) {\n\t\tif (!ITERATOR__1.hasNext()) {\n\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\tbreak;\n\t\t}\n\t\t@SuppressWarnings(\"null\")\n\t\t/*@NonInvalid\052/ &lt;%org.eclipse.qvtd.pivot.qvttemplate.@org.eclipse.jdt.annotation.NonNull PropertyTemplateItem%&gt; _1 = (&lt;%org.eclipse.qvtd.pivot.qvttemplate.@org.eclipse.jdt.annotation.NonNull PropertyTemplateItem%&gt;)ITERATOR__1.next();\n\t\t/**\n\t\t * resolvedProperty\n\t\t \052/\n\t\t@SuppressWarnings(\"null\")\n\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property%&gt; resolvedProperty = _1.getResolvedProperty();\n\t\t//\n\t\tif (accumulator.includes(resolvedProperty) == &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE) {\n\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.FALSE_VALUE;\t\t\t// Abort after second find\n\t\t\tbreak;\n\t\t}\n\t\telse {\n\t\t\taccumulator.add(resolvedProperty);\n\t\t}\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.STR_ObjectTemplateExp_c_c_PartPropertyIsUnique, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.INT_0).booleanValue();\n\tsymbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean validatePartPropertyIsUnique(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='TypeisObjectType'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv TypeisObjectType:\n *   let\n *     severity : Integer[1] = \'ObjectTemplateExp::TypeisObjectType\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let result : Boolean[1] = type = referredClass\n *       in\n *         \'ObjectTemplateExp::TypeisObjectType\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.@org.eclipse.jdt.annotation.NonNull Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.STR_ObjectTemplateExp_c_c_TypeisObjectType);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.Nullable Type%&gt; type = this.getType();\n\t@SuppressWarnings(\"null\")\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class%&gt; referredClass = this.getReferredClass();\n\tfinal /*@NonInvalid\052/ boolean result = (type != null) ? (type.getTypeId() == referredClass.getTypeId()) : false;\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.STR_ObjectTemplateExp_c_c_TypeisObjectType, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, &lt;%org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables%&gt;.INT_0).booleanValue();\n\tsymbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean validateTypeisObjectType(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ObjectTemplateExp
