/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
 * A representation of the model object '<em><b>Opposite Property Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#getTargetProperty <em>Target Property</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getOppositePropertyAssignment()
 * @model
 * @generated
 */
public interface OppositePropertyAssignment extends NavigationAssignment {
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
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getOppositePropertyAssignment_TargetProperty()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='assignment'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTcore!OppositePropertyAssignment!targetProperty'"
	 * @generated
	 */
	Property getTargetProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#getTargetProperty <em>Target Property</em>}' reference.
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
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='targetProperty.opposite\n\n'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * targetProperty.opposite\n \052/\n@SuppressWarnings(\"null\")\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Property%&gt; targetProperty = this.getTargetProperty();\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Property%&gt; opposite = targetProperty.getOpposite();\nif (opposite == null) {\n\tthrow new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(\"Null body for \\\'qvtcore::OppositePropertyAssignment::getReferredTargetProperty() : Property[1]\\\'\");\n}\nreturn opposite;'"
	 * @generated
	 */
	Property getReferredTargetProperty();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='CompatibleTypeForPartialValue'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tisPartial implies\n\t\tlet propertyType = getReferredTargetProperty().type.oclAsType(ocl::CollectionType).elementType in\n\t\tlet valueType = value.type in\n\t\tTuple{\n\t\t\tstatus : Boolean = valueType?.conformsTo(propertyType) or propertyType.conformsTo(valueType),\n\t\t\tmessage : String = \'OppositePropertyAssignment::CompatibleTypeForPartialValue: \' + valueType?.name + \' must conform to \' + propertyType.name + \' or vice-versa\'\n\t\t}.status\n\n'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='try {\n\t/**\n\t *\n\t * inv CompatibleTypeForPartialValue:\n\t *   let\n\t *     severity : Integer[1] = \'OppositePropertyAssignment::CompatibleTypeForPartialValue\'.getSeverity()\n\t *   in\n\t *     if severity &lt;= 0\n\t *     then true\n\t *     else\n\t *       let\n\t *         result : OclAny[1] = if isPartial\n\t *         then\n\t *           let\n\t *             propertyType : Type[1] = getReferredTargetProperty()\n\t *             .type.oclAsType(CollectionType).elementType\n\t *           in\n\t *             let valueType : Type[?] = value.type\n\t *             in\n\t *               let\n\t *                 status : Boolean[?] = valueType?.conformsTo(propertyType) or\n\t *                 propertyType.conformsTo(valueType)\n\t *               in\n\t *                 if status = true\n\t *                 then true\n\t *                 else\n\t *                   Tuple{status = status, message = \'OppositePropertyAssignment::CompatibleTypeForPartialValue: \' + valueType?.name + \' must conform to \' + propertyType.name + \' or vice-versa\'\n\t *                   }\n\t *                 endif\n\t *         else true\n\t *         endif\n\t *       in\n\t *         \'OppositePropertyAssignment::CompatibleTypeForPartialValue\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n\t *     endif\n\t \052/\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.utilities.PivotUtil%&gt;.getExecutor(this, context);\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.ids.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;IdResolver%&gt; idResolver = executor.getIdResolver();\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_OppositePropertyAssignment_c_c_CompatibleTypeForPartialValue);\n\tfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\t/*@NonInvalid\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; symbol_2;\n\tif (le) {\n\t\tsymbol_2 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t}\n\telse {\n\t\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; CAUGHT_result;\n\t\ttry {\n\t\t\tfinal /*@NonInvalid\052/ boolean isPartial = this.isIsPartial();\n\t\t\t/*@Thrown\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; result;\n\t\t\tif (isPartial) {\n\t\t\t\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; CAUGHT_propertyType;\n\t\t\t\ttry {\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Class%&gt; TYP_CollectionType = idResolver.getClass(&lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.CLSSid_CollectionType, null);\n\t\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Property%&gt; getReferredTargetProperty = this.getReferredTargetProperty();\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Type%&gt; type = getReferredTargetProperty.getType();\n\t\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\t\tfinal /*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;CollectionType%&gt; oclAsType = (&lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;CollectionType%&gt;)&lt;%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%&gt;.INSTANCE.evaluate(executor, type, TYP_CollectionType);\n\t\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\t\tfinal /*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Type%&gt; propertyType = oclAsType.getElementType();\n\t\t\t\t\tCAUGHT_propertyType = propertyType;\n\t\t\t\t}\n\t\t\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\t\t\tCAUGHT_propertyType = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t\t\t}\n\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;OCLExpression%&gt; value = this.getValue();\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Type%&gt; valueType = value.getType();\n\t\t\t\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Object%&gt; CAUGHT_safe_conformsTo_source;\n\t\t\t\ttry {\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; conformsTo = valueType == null;\n\t\t\t\t\t/*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Boolean%&gt; safe_conformsTo_source;\n\t\t\t\t\tif (conformsTo == Boolean.TRUE) {\n\t\t\t\t\t\tsafe_conformsTo_source = null;\n\t\t\t\t\t}\n\t\t\t\t\telse {\n\t\t\t\t\t\tif (CAUGHT_propertyType instanceof &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;) {\n\t\t\t\t\t\t\tthrow (&lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;)CAUGHT_propertyType;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tfinal /*@Thrown\052/ boolean conformsTo_0 = &lt;%org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation%&gt;.INSTANCE.evaluate(executor, valueType, CAUGHT_propertyType).booleanValue();\n\t\t\t\t\t\tsafe_conformsTo_source = conformsTo_0;\n\t\t\t\t\t}\n\t\t\t\t\tCAUGHT_safe_conformsTo_source = safe_conformsTo_source;\n\t\t\t\t}\n\t\t\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\t\t\tCAUGHT_safe_conformsTo_source = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t\t\t}\n\t\t\t\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; CAUGHT_conformsTo_1;\n\t\t\t\ttry {\n\t\t\t\t\tif (CAUGHT_propertyType instanceof &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;) {\n\t\t\t\t\t\tthrow (&lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;)CAUGHT_propertyType;\n\t\t\t\t\t}\n\t\t\t\t\tfinal /*@Thrown\052/ boolean conformsTo_1 = &lt;%org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation%&gt;.INSTANCE.evaluate(executor, CAUGHT_propertyType, valueType).booleanValue();\n\t\t\t\t\tCAUGHT_conformsTo_1 = conformsTo_1;\n\t\t\t\t}\n\t\t\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\t\t\tCAUGHT_conformsTo_1 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t\t\t}\n\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Boolean%&gt; status = &lt;%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%&gt;.INSTANCE.evaluate(CAUGHT_safe_conformsTo_source, CAUGHT_conformsTo_1);\n\t\t\t\tfinal /*@Thrown\052/ boolean eq = status == Boolean.TRUE;\n\t\t\t\t/*@Thrown\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; symbol_1;\n\t\t\t\tif (eq) {\n\t\t\t\t\tsymbol_1 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; name = valueType == null;\n\t\t\t\t\t/*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;String%&gt; safe_name_source;\n\t\t\t\t\tif (name == Boolean.TRUE) {\n\t\t\t\t\t\tsafe_name_source = null;\n\t\t\t\t\t}\n\t\t\t\t\telse {\n\t\t\t\t\t\tassert valueType != null;\n\t\t\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;String%&gt; name_0 = valueType.getName();\n\t\t\t\t\t\tsafe_name_source = name_0;\n\t\t\t\t\t}\n\t\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;String%&gt; sum = &lt;%org.eclipse.ocl.pivot.library.string.StringConcatOperation%&gt;.INSTANCE.evaluate(&lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_OppositePropertyAssignment_c_c_CompatibleTypeForPartialValue_c_32, safe_name_source);\n\t\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;String%&gt; sum_0 = &lt;%org.eclipse.ocl.pivot.library.string.StringConcatOperation%&gt;.INSTANCE.evaluate(sum, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR__32_must_32_conform_32_to_32);\n\t\t\t\t\tif (CAUGHT_propertyType instanceof &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;) {\n\t\t\t\t\t\tthrow (&lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;)CAUGHT_propertyType;\n\t\t\t\t\t}\n\t\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;String%&gt; name_1 = ((&lt;%org.eclipse.ocl.pivot.utilities.Nameable%&gt;)CAUGHT_propertyType).getName();\n\t\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;String%&gt; sum_1 = &lt;%org.eclipse.ocl.pivot.library.string.StringConcatOperation%&gt;.INSTANCE.evaluate(sum_0, name_1);\n\t\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;String%&gt; sum_2 = &lt;%org.eclipse.ocl.pivot.library.string.StringConcatOperation%&gt;.INSTANCE.evaluate(sum_1, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR__32_or_32_vice_m_versa);\n\t\t\t\t\tfinal /*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;TupleValue%&gt; symbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createTupleOfEach(&lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.TUPLid_, sum_2, status);\n\t\t\t\t\tsymbol_1 = symbol_0;\n\t\t\t\t}\n\t\t\t\tresult = symbol_1;\n\t\t\t}\n\t\t\telse {\n\t\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t}\n\t\t\tCAUGHT_result = result;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_OppositePropertyAssignment_c_c_CompatibleTypeForPartialValue, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\t\tsymbol_2 = logDiagnostic;\n\t}\n\treturn Boolean.TRUE == symbol_2;\n}\ncatch (&lt;%java.lang.Throwable%&gt; e) {\n\treturn &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.validationFailedDiagnostic(\"OppositePropertyAssignment::CompatibleTypeForPartialValue\", this, diagnostics, context, e);\n}'"
	 * @generated
	 */
	boolean validateCompatibleTypeForPartialValue(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='CompatibleTypeForTotalValue'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tnot isPartial implies\n\t\tlet propertyType = getReferredTargetProperty().type in\n\t\tlet valueType = value.type in\n\t\tTuple{\n\t\t\tstatus : Boolean = valueType?.conformsTo(propertyType) or propertyType?.conformsTo(valueType),\n\t\t\tmessage : String = \'OppositePropertyAssignment::CompatibleTypeForTotalValue: \' + valueType?.name + \' must conform to \' + propertyType?.name + \' or vice-versa\'\n\t\t}.status\n\n'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='try {\n\t/**\n\t *\n\t * inv CompatibleTypeForTotalValue:\n\t *   let\n\t *     severity : Integer[1] = \'OppositePropertyAssignment::CompatibleTypeForTotalValue\'.getSeverity()\n\t *   in\n\t *     if severity &lt;= 0\n\t *     then true\n\t *     else\n\t *       let\n\t *         result : OclAny[1] = if not isPartial\n\t *         then\n\t *           let propertyType : Type[?] = getReferredTargetProperty().type\n\t *           in\n\t *             let valueType : Type[?] = value.type\n\t *             in\n\t *               let\n\t *                 status : Boolean[?] = valueType?.conformsTo(propertyType) or\n\t *                 propertyType?.conformsTo(valueType)\n\t *               in\n\t *                 if status = true\n\t *                 then true\n\t *                 else\n\t *                   Tuple{status = status, message = \'OppositePropertyAssignment::CompatibleTypeForTotalValue: \' + valueType?.name + \' must conform to \' + propertyType?.name + \' or vice-versa\'\n\t *                   }\n\t *                 endif\n\t *         else true\n\t *         endif\n\t *       in\n\t *         \'OppositePropertyAssignment::CompatibleTypeForTotalValue\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n\t *     endif\n\t \052/\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.utilities.PivotUtil%&gt;.getExecutor(this, context);\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_OppositePropertyAssignment_c_c_CompatibleTypeForTotalValue);\n\tfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\t/*@NonInvalid\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; symbol_2;\n\tif (le) {\n\t\tsymbol_2 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t}\n\telse {\n\t\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; CAUGHT_result;\n\t\ttry {\n\t\t\tfinal /*@NonInvalid\052/ boolean isPartial = this.isIsPartial();\n\t\t\tfinal /*@NonInvalid\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Boolean%&gt; not = &lt;%org.eclipse.ocl.pivot.library.logical.BooleanNotOperation%&gt;.INSTANCE.evaluate(isPartial);\n\t\t\tif (not == null) {\n\t\t\t\tthrow new &lt;%org.eclipse.ocl.pivot.values.InvalidValueException%&gt;(\"Null if condition\");\n\t\t\t}\n\t\t\t/*@Thrown\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; result;\n\t\t\tif (not) {\n\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Property%&gt; getReferredTargetProperty = this.getReferredTargetProperty();\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Type%&gt; propertyType = getReferredTargetProperty.getType();\n\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;OCLExpression%&gt; value = this.getValue();\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Type%&gt; valueType = value.getType();\n\t\t\t\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Object%&gt; CAUGHT_safe_conformsTo_source;\n\t\t\t\ttry {\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; conformsTo = valueType == null;\n\t\t\t\t\t/*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Boolean%&gt; safe_conformsTo_source;\n\t\t\t\t\tif (conformsTo == Boolean.TRUE) {\n\t\t\t\t\t\tsafe_conformsTo_source = null;\n\t\t\t\t\t}\n\t\t\t\t\telse {\n\t\t\t\t\t\tfinal /*@Thrown\052/ boolean conformsTo_0 = &lt;%org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation%&gt;.INSTANCE.evaluate(executor, valueType, propertyType).booleanValue();\n\t\t\t\t\t\tsafe_conformsTo_source = conformsTo_0;\n\t\t\t\t\t}\n\t\t\t\t\tCAUGHT_safe_conformsTo_source = safe_conformsTo_source;\n\t\t\t\t}\n\t\t\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\t\t\tCAUGHT_safe_conformsTo_source = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t\t\t}\n\t\t\t\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Object%&gt; CAUGHT_safe_conformsTo_source_0;\n\t\t\t\ttry {\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; conformsTo_1 = propertyType == null;\n\t\t\t\t\t/*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Boolean%&gt; safe_conformsTo_source_0;\n\t\t\t\t\tif (conformsTo_1 == Boolean.TRUE) {\n\t\t\t\t\t\tsafe_conformsTo_source_0 = null;\n\t\t\t\t\t}\n\t\t\t\t\telse {\n\t\t\t\t\t\tfinal /*@Thrown\052/ boolean conformsTo_2 = &lt;%org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation%&gt;.INSTANCE.evaluate(executor, propertyType, valueType).booleanValue();\n\t\t\t\t\t\tsafe_conformsTo_source_0 = conformsTo_2;\n\t\t\t\t\t}\n\t\t\t\t\tCAUGHT_safe_conformsTo_source_0 = safe_conformsTo_source_0;\n\t\t\t\t}\n\t\t\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\t\t\tCAUGHT_safe_conformsTo_source_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t\t\t}\n\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Boolean%&gt; status = &lt;%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%&gt;.INSTANCE.evaluate(CAUGHT_safe_conformsTo_source, CAUGHT_safe_conformsTo_source_0);\n\t\t\t\tfinal /*@Thrown\052/ boolean eq = status == Boolean.TRUE;\n\t\t\t\t/*@Thrown\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; symbol_1;\n\t\t\t\tif (eq) {\n\t\t\t\t\tsymbol_1 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; name = valueType == null;\n\t\t\t\t\t/*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;String%&gt; safe_name_source;\n\t\t\t\t\tif (name == Boolean.TRUE) {\n\t\t\t\t\t\tsafe_name_source = null;\n\t\t\t\t\t}\n\t\t\t\t\telse {\n\t\t\t\t\t\tassert valueType != null;\n\t\t\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;String%&gt; name_0 = valueType.getName();\n\t\t\t\t\t\tsafe_name_source = name_0;\n\t\t\t\t\t}\n\t\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;String%&gt; sum = &lt;%org.eclipse.ocl.pivot.library.string.StringConcatOperation%&gt;.INSTANCE.evaluate(&lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_OppositePropertyAssignment_c_c_CompatibleTypeForTotalValue_c_32, safe_name_source);\n\t\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;String%&gt; sum_0 = &lt;%org.eclipse.ocl.pivot.library.string.StringConcatOperation%&gt;.INSTANCE.evaluate(sum, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR__32_must_32_conform_32_to_32);\n\t\t\t\t\tfinal /*@NonInvalid\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; name_1 = propertyType == null;\n\t\t\t\t\t/*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;String%&gt; safe_name_source_0;\n\t\t\t\t\tif (name_1 == Boolean.TRUE) {\n\t\t\t\t\t\tsafe_name_source_0 = null;\n\t\t\t\t\t}\n\t\t\t\t\telse {\n\t\t\t\t\t\tassert propertyType != null;\n\t\t\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;String%&gt; name_2 = propertyType.getName();\n\t\t\t\t\t\tsafe_name_source_0 = name_2;\n\t\t\t\t\t}\n\t\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;String%&gt; sum_1 = &lt;%org.eclipse.ocl.pivot.library.string.StringConcatOperation%&gt;.INSTANCE.evaluate(sum_0, safe_name_source_0);\n\t\t\t\t\tfinal /*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;String%&gt; sum_2 = &lt;%org.eclipse.ocl.pivot.library.string.StringConcatOperation%&gt;.INSTANCE.evaluate(sum_1, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR__32_or_32_vice_m_versa);\n\t\t\t\t\tfinal /*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;TupleValue%&gt; symbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createTupleOfEach(&lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.TUPLid_, sum_2, status);\n\t\t\t\t\tsymbol_1 = symbol_0;\n\t\t\t\t}\n\t\t\t\tresult = symbol_1;\n\t\t\t}\n\t\t\telse {\n\t\t\t\tresult = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t\t\t}\n\t\t\tCAUGHT_result = result;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_result = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_OppositePropertyAssignment_c_c_CompatibleTypeForTotalValue, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\t\tsymbol_2 = logDiagnostic;\n\t}\n\treturn Boolean.TRUE == symbol_2;\n}\ncatch (&lt;%java.lang.Throwable%&gt; e) {\n\treturn &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.validationFailedDiagnostic(\"OppositePropertyAssignment::CompatibleTypeForTotalValue\", this, diagnostics, context, e);\n}'"
	 * @generated
	 */
	boolean validateCompatibleTypeForTotalValue(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='OppositePropertyIsImplicit'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tgetReferredTargetProperty().isImplicit\n\t\n'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='try {\n\t/**\n\t *\n\t * inv OppositePropertyIsImplicit:\n\t *   let\n\t *     severity : Integer[1] = \'OppositePropertyAssignment::OppositePropertyIsImplicit\'.getSeverity()\n\t *   in\n\t *     if severity &lt;= 0\n\t *     then true\n\t *     else\n\t *       let result : Boolean[1] = getReferredTargetProperty().isImplicit\n\t *       in\n\t *         \'OppositePropertyAssignment::OppositePropertyIsImplicit\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n\t *     endif\n\t \052/\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.utilities.PivotUtil%&gt;.getExecutor(this, context);\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_OppositePropertyAssignment_c_c_OppositePropertyIsImplicit);\n\tfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\t/*@NonInvalid\052/ boolean symbol_0;\n\tif (le) {\n\t\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t}\n\telse {\n\t\t@SuppressWarnings(\"null\")\n\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Property%&gt; getReferredTargetProperty = this.getReferredTargetProperty();\n\t\tfinal /*@NonInvalid\052/ boolean result = getReferredTargetProperty.isIsImplicit();\n\t\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_OppositePropertyAssignment_c_c_OppositePropertyIsImplicit, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\t\tsymbol_0 = logDiagnostic;\n\t}\n\treturn Boolean.TRUE == symbol_0;\n}\ncatch (&lt;%java.lang.Throwable%&gt; e) {\n\treturn &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.validationFailedDiagnostic(\"OppositePropertyAssignment::OppositePropertyIsImplicit\", this, diagnostics, context, e);\n}'"
	 * @generated
	 */
	boolean validateOppositePropertyIsImplicit(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='TargetPropetyIsSlotProperty'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tslotExpression.type?.conformsTo(getReferredTargetProperty().owningClass)\n\n'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='try {\n\t/**\n\t *\n\t * inv TargetPropetyIsSlotProperty:\n\t *   let\n\t *     severity : Integer[1] = \'OppositePropertyAssignment::TargetPropetyIsSlotProperty\'.getSeverity()\n\t *   in\n\t *     if severity &lt;= 0\n\t *     then true\n\t *     else\n\t *       let\n\t *         result : Boolean[?] = slotExpression.type?.conformsTo(\n\t *           getReferredTargetProperty().owningClass)\n\t *       in\n\t *         \'OppositePropertyAssignment::TargetPropetyIsSlotProperty\'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)\n\t *     endif\n\t \052/\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.utilities.PivotUtil%&gt;.getExecutor(this, context);\n\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;IntegerValue%&gt; severity_0 = &lt;%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_OppositePropertyAssignment_c_c_TargetPropetyIsSlotProperty);\n\tfinal /*@NonInvalid\052/ boolean le = &lt;%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%&gt;.INSTANCE.evaluate(executor, severity_0, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\t/*@NonInvalid\052/ boolean symbol_0;\n\tif (le) {\n\t\tsymbol_0 = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.TRUE_VALUE;\n\t}\n\telse {\n\t\t/*@Caught\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Object%&gt; CAUGHT_safe_conformsTo_source;\n\t\ttry {\n\t\t\t@SuppressWarnings(\"null\")\n\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;OCLExpression%&gt; slotExpression = this.getSlotExpression();\n\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Type%&gt; type = slotExpression.getType();\n\t\t\tfinal /*@NonInvalid\052/ &lt;%&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Object%&gt; conformsTo = type == null;\n\t\t\t/*@Thrown\052/ &lt;%java.lang.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Boolean%&gt; safe_conformsTo_source;\n\t\t\tif (conformsTo == Boolean.TRUE) {\n\t\t\t\tsafe_conformsTo_source = null;\n\t\t\t}\n\t\t\telse {\n\t\t\t\t@SuppressWarnings(\"null\")\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Property%&gt; getReferredTargetProperty = this.getReferredTargetProperty();\n\t\t\t\tfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;Class%&gt; owningClass = getReferredTargetProperty.getOwningClass();\n\t\t\t\tfinal /*@Thrown\052/ boolean conformsTo_0 = &lt;%org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation%&gt;.INSTANCE.evaluate(executor, type, owningClass).booleanValue();\n\t\t\t\tsafe_conformsTo_source = conformsTo_0;\n\t\t\t}\n\t\t\tCAUGHT_safe_conformsTo_source = safe_conformsTo_source;\n\t\t}\n\t\tcatch (&lt;%java.lang.Exception%&gt; e) {\n\t\t\tCAUGHT_safe_conformsTo_source = &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.createInvalidValue(e);\n\t\t}\n\t\tfinal /*@NonInvalid\052/ boolean logDiagnostic = &lt;%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.ocl.pivot.ids.TypeId%&gt;.BOOLEAN, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.STR_OppositePropertyAssignment_c_c_TargetPropetyIsSlotProperty, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_safe_conformsTo_source, &lt;%org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables%&gt;.INT_0).booleanValue();\n\t\tsymbol_0 = logDiagnostic;\n\t}\n\treturn Boolean.TRUE == symbol_0;\n}\ncatch (&lt;%java.lang.Throwable%&gt; e) {\n\treturn &lt;%org.eclipse.ocl.pivot.utilities.ValueUtil%&gt;.validationFailedDiagnostic(\"OppositePropertyAssignment::TargetPropetyIsSlotProperty\", this, diagnostics, context, e);\n}'"
	 * @generated
	 */
	boolean validateTargetPropetyIsSlotProperty(DiagnosticChain diagnostics, Map<Object, Object> context);

} // OppositePropertyAssignment
