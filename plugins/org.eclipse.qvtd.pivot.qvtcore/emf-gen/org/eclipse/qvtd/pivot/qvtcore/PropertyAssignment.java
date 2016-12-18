/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtcore;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.pivot.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#getTargetProperty <em>Target Property</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getPropertyAssignment()
 * @model
 * @generated
 */
public interface PropertyAssignment extends NavigationAssignment {
	/**
	 * Returns the value of the '<em><b>Target Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Property</em>' reference.
	 * @see #setTargetProperty(Property)
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getPropertyAssignment_TargetProperty()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='assignment'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTcore!PropertyAssignment!targetProperty'"
	 * @generated
	 */
	Property getTargetProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#getTargetProperty <em>Target Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Property</em>' reference.
	 * @see #getTargetProperty()
	 * @generated
	 */
	void setTargetProperty(Property value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * targetProperty\n \052/\n@SuppressWarnings(\"null\")\nfinal /*@Thrown\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Property targetProperty = this.getTargetProperty();\nreturn targetProperty;'"
	 * @generated
	 */
	Property getReferredTargetProperty();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='CompatibleTypeForValue'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv CompatibleTypeForValue:\n *   let\n *     severity : Integer[1] = \'PropertyAssignment::CompatibleTypeForValue\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let\n *         result : OclAny[1] = let\n *           status : Boolean[?] = let\n *             propertyType : Type[?] = getReferredTargetProperty().type\n *           in\n *             let valueType : Type[?] = value.type\n *             in\n *               valueType.conformsTo(propertyType) or\n *               propertyType.conformsTo(valueType)\n *         in\n *           if status = true\n *           then true\n *           else\n *             Tuple{message = \'PropertyAssignment::CompatibleTypeForValue: \' + value.type.name + \' must conform to \' +\n *               getReferredTargetProperty().type.name + \' or vice-versa\', status = status\n *             }\n *           endif\n *       in\n *         \'PropertyAssignment::CompatibleTypeForValue\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_PropertyAssignment_c_c_CompatibleTypeForValue);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Object symbol_3;\nif (le) {\n\tsymbol_3 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.lang.Object%&gt; CAUGHT_symbol_2;\n\ttry {\n\t\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.Nullable%&gt; &lt;%java.lang.Object%&gt; CAUGHT_propertyType;\n\t\ttry {\n\t\t\t@SuppressWarnings(\"null\")\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Property getReferredTargetProperty = this.getReferredTargetProperty();\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Type propertyType = getReferredTargetProperty.getType();\n\t\t\tCAUGHT_propertyType = propertyType;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_propertyType = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.Nullable%&gt; &lt;%java.lang.Object%&gt; CAUGHT_valueType;\n\t\ttry {\n\t\t\t@SuppressWarnings(\"null\")\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; OCLExpression value = this.getValue();\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Type valueType = value.getType();\n\t\t\tCAUGHT_valueType = valueType;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_valueType = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.lang.Object%&gt; CAUGHT_conformsTo;\n\t\ttry {\n\t\t\tif (CAUGHT_valueType instanceof &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;) {\n\t\t\t\tthrow (&lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;)CAUGHT_valueType;\n\t\t\t}\n\t\t\tif (CAUGHT_propertyType instanceof &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;) {\n\t\t\t\tthrow (&lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;)CAUGHT_propertyType;\n\t\t\t}\n\t\t\tfinal /*@Thrown\052/ boolean conformsTo = &lt;%org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation%&gt;.INSTANCE.evaluate(executor, CAUGHT_valueType, CAUGHT_propertyType).booleanValue();\n\t\t\tCAUGHT_conformsTo = conformsTo;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_conformsTo = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.lang.Object%&gt; CAUGHT_conformsTo_0;\n\t\ttry {\n\t\t\tif (CAUGHT_propertyType instanceof &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;) {\n\t\t\t\tthrow (&lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;)CAUGHT_propertyType;\n\t\t\t}\n\t\t\tif (CAUGHT_valueType instanceof &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;) {\n\t\t\t\tthrow (&lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;)CAUGHT_valueType;\n\t\t\t}\n\t\t\tfinal /*@Thrown\052/ boolean conformsTo_0 = &lt;%org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation%&gt;.INSTANCE.evaluate(executor, CAUGHT_propertyType, CAUGHT_valueType).booleanValue();\n\t\t\tCAUGHT_conformsTo_0 = conformsTo_0;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_conformsTo_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\tfinal /*@Thrown\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Boolean or = &lt;%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%&gt;.INSTANCE.evaluate(CAUGHT_conformsTo, CAUGHT_conformsTo_0);\n\t\tfinal /*@Thrown\052/ boolean symbol_0 = or == Boolean.TRUE;\n\t\t/*@Thrown\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Object symbol_2;\n\t\tif (symbol_0) {\n\t\t\tsymbol_2 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t}\n\t\telse {\n\t\t\t@SuppressWarnings(\"null\")\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; OCLExpression value_0 = this.getValue();\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Type type = value_0.getType();\n\t\t\tif (type == null) {\n\t\t\t\tthrow new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(\"Null source for \\\'NamedElement::name\\\'\");\n\t\t\t}\n\t\t\tfinal /*@Thrown\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; String name = type.getName();\n\t\t\tfinal /*@NonInvalid\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; String sum = &lt;%org.eclipse.ocl.pivot.library.string.StringConcatOperation%&gt;.INSTANCE.evaluate(&lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_PropertyAssignment_c_c_CompatibleTypeForValue_c_32, name);\n\t\t\tfinal /*@NonInvalid\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; String sum_0 = &lt;%org.eclipse.ocl.pivot.library.string.StringConcatOperation%&gt;.INSTANCE.evaluate(sum, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR__32_must_32_conform_32_to_32);\n\t\t\t@SuppressWarnings(\"null\")\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Property getReferredTargetProperty_0 = this.getReferredTargetProperty();\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Type type_0 = getReferredTargetProperty_0.getType();\n\t\t\tif (type_0 == null) {\n\t\t\t\tthrow new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(\"Null source for \\\'NamedElement::name\\\'\");\n\t\t\t}\n\t\t\tfinal /*@Thrown\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; String name_0 = type_0.getName();\n\t\t\tfinal /*@NonInvalid\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; String sum_1 = &lt;%org.eclipse.ocl.pivot.library.string.StringConcatOperation%&gt;.INSTANCE.evaluate(sum_0, name_0);\n\t\t\tfinal /*@NonInvalid\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; String sum_2 = &lt;%org.eclipse.ocl.pivot.library.string.StringConcatOperation%&gt;.INSTANCE.evaluate(sum_1, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR__32_or_32_vice_m_versa);\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; TupleValue symbol_1 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createTupleOfEach(&lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.TUPLid_, sum_2, or);\n\t\t\tsymbol_2 = symbol_1;\n\t\t}\n\t\tCAUGHT_symbol_2 = symbol_2;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_symbol_2 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_PropertyAssignment_c_c_CompatibleTypeForValue, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_symbol_2, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\tsymbol_3 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_3;'"
	 * @generated
	 */
	boolean validateCompatibleTypeForValue(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='PropertyIsNotImplicit'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv PropertyIsNotImplicit:\n *   let\n *     severity : Integer[1] = \'PropertyAssignment::PropertyIsNotImplicit\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let result : Boolean[?] = not targetProperty.isImplicit\n *       in\n *         \'PropertyAssignment::PropertyIsNotImplicit\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_PropertyAssignment_c_c_PropertyIsNotImplicit);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.Nullable%&gt; &lt;%java.lang.Object%&gt; CAUGHT_result;\n\ttry {\n\t\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.Nullable%&gt; &lt;%java.lang.Object%&gt; CAUGHT_isImplicit;\n\t\ttry {\n\t\t\t@SuppressWarnings(\"null\")\n\t\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Property targetProperty = this.getTargetProperty();\n\t\t\tfinal /*@Thrown\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Boolean isImplicit = targetProperty.isIsImplicit();\n\t\t\tCAUGHT_isImplicit = isImplicit;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_isImplicit = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\tfinal /*@Thrown\052/ java.lang.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Boolean result = &lt;%org.eclipse.ocl.pivot.library.logical.BooleanNotOperation%&gt;.INSTANCE.evaluate(CAUGHT_isImplicit);\n\t\tCAUGHT_result = result;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_PropertyAssignment_c_c_PropertyIsNotImplicit, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\tsymbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean validatePropertyIsNotImplicit(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='TargetPropetyIsSlotProperty'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * inv TargetPropetyIsSlotProperty:\n *   let\n *     severity : Integer[1] = \'PropertyAssignment::TargetPropetyIsSlotProperty\'.getSeverity()\n *   in\n *     if severity &lt;= 0\n *     then true\n *     else\n *       let\n *         result : Boolean[1] = slotExpression.type.conformsTo(\n *           getReferredTargetProperty().owningClass)\n *       in\n *         \'PropertyAssignment::TargetPropetyIsSlotProperty\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n *     endif\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IntegerValue severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_PropertyAssignment_c_c_TargetPropetyIsSlotProperty);\nfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n}\nelse {\n\t/*@Caught\052/ @&lt;%org.eclipse.jdt.annotation.NonNull%&gt; &lt;%java.lang.Object%&gt; CAUGHT_result;\n\ttry {\n\t\t@SuppressWarnings(\"null\")\n\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; OCLExpression slotExpression = this.getSlotExpression();\n\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Type type = slotExpression.getType();\n\t\t@SuppressWarnings(\"null\")\n\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Property getReferredTargetProperty = this.getReferredTargetProperty();\n\t\tfinal /*@Thrown\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; Class owningClass = getReferredTargetProperty.getOwningClass();\n\t\tfinal /*@Thrown\052/ boolean result = &lt;%org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation%&gt;.INSTANCE.evaluate(executor, type, owningClass).booleanValue();\n\t\tCAUGHT_result = result;\n\t}\n\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t}\n\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_PropertyAssignment_c_c_TargetPropetyIsSlotProperty, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\tsymbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean validateTargetPropetyIsSlotProperty(DiagnosticChain diagnostics, Map<Object, Object> context);

} // PropertyAssignment
