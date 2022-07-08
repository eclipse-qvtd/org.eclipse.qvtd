/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2013, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 *   /org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ecore
 * using:
 *   /org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative;

import java.lang.String;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreLibraryOppositeProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorFragment;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorOperation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorPropertyWithImplementation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSpecializedType;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorType;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.AbstractTables;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables;
// import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
// import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeTables;

/**
 * QVTimperativeTables provides the dispatch tables for the qvtimperative for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
public class QVTimperativeTables extends AbstractTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final @NonNull EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(QVTimperativePackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final @NonNull ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", null, QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2016/QVTimperative", null, QVTimperativePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_PRIMid_String = TypeId.BAG.getSpecializedId(TypeId.STRING);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_AddStatement = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("AddStatement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_AppendParameterBinding = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("AppendParameterBinding", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BooleanType = QVTimperativeTables.PACKid_$metamodel$.getClassId("BooleanType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BufferStatement = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("BufferStatement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CallExp = QVTimperativeTables.PACKid_$metamodel$.getClassId("CallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CheckStatement = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("CheckStatement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = QVTimperativeTables.PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CollectionType = QVTimperativeTables.PACKid_$metamodel$.getClassId("CollectionType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ConnectionVariable = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("ConnectionVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DataType = QVTimperativeTables.PACKid_$metamodel$.getClassId("DataType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DeclareStatement = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("DeclareStatement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_EntryPoint = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("EntryPoint", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_GuardParameterBinding = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("GuardParameterBinding", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ImperativeTransformation = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("ImperativeTransformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_LoopParameterBinding = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("LoopParameterBinding", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_LoopVariable = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("LoopVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Mapping = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("Mapping", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MappingCall = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("MappingCall", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MappingLoop = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("MappingLoop", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MappingParameter = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("MappingParameter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MappingParameterBinding = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("MappingParameterBinding", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MappingStatement = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("MappingStatement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_NewStatement = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("NewStatement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_NewStatementPart = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("NewStatementPart", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OCLExpression = QVTimperativeTables.PACKid_$metamodel$.getClassId("OCLExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclElement = QVTimperativeTables.PACKid_$metamodel$.getClassId("OclElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Property = QVTimperativeTables.PACKid_$metamodel$.getClassId("Property", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Rule = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Rule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_SetStatement = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("SetStatement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_SimpleParameterBinding = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("SimpleParameterBinding", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Statement = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("Statement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Type = QVTimperativeTables.PACKid_$metamodel$.getClassId("Type", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TypedModel = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TypedModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableDeclaration = QVTimperativeTables.PACKid_$metamodel$.getClassId("VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableExp = QVTimperativeTables.PACKid_$metamodel$.getClassId("VariableExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableStatement = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("VariableStatement", 0);
	public static final /*@NonInvalid*/ @NonNull DataTypeId DATAid_EIntegerObject = QVTimperativeTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EIntegerObject", 0);
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_0 = ValueUtil.integerValueOf("0");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_PRIMid_String = TypeId.ORDERED_SET.getSpecializedId(TypeId.STRING);
	public static final /*@NonInvalid*/ @NonNull TuplePartId PARTid_ = IdManager.getTuplePartId(0, "message", TypeId.STRING);
	public static final /*@NonInvalid*/ @NonNull TuplePartId PARTid__0 = IdManager.getTuplePartId(1, "status", TypeId.BOOLEAN);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_PRIMid_String = TypeId.SEQUENCE.getSpecializedId(TypeId.STRING);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_PRIMid_String = TypeId.SET.getSpecializedId(TypeId.STRING);
	public static final /*@NonInvalid*/ @NonNull String STR_ = "";
	public static final /*@NonInvalid*/ @NonNull String STR_MappingCall_c_c_MatchingCallBindings_c_32 = "MappingCall::MatchingCallBindings: ";
	public static final /*@NonInvalid*/ @NonNull String STR_SetStatement_c_c_CompatibleClassForProperty_c_32 = "SetStatement::CompatibleClassForProperty: ";
	public static final /*@NonInvalid*/ @NonNull String STR_SetStatement_c_c_CompatibleTypeForPartialValue_c_32 = "SetStatement::CompatibleTypeForPartialValue: ";
	public static final /*@NonInvalid*/ @NonNull String STR_SetStatement_c_c_CompatibleTypeForTotalValue_c_32 = "SetStatement::CompatibleTypeForTotalValue: ";
	public static final /*@NonInvalid*/ @NonNull String STR__123 = "{";
	public static final /*@NonInvalid*/ @NonNull String STR__125 = "}";
	public static final /*@NonInvalid*/ @NonNull String STR__32 = " ";
	public static final /*@NonInvalid*/ @NonNull String STR__32_l_g_32 = " <> ";
	public static final /*@NonInvalid*/ @NonNull String STR__32_must_32_conform_32_to_32 = " must conform to ";
	public static final /*@NonInvalid*/ @NonNull String STR__59 = ";";
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_AddStatement = TypeId.BAG.getSpecializedId(QVTimperativeTables.CLSSid_AddStatement);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_AppendParameterBinding = TypeId.BAG.getSpecializedId(QVTimperativeTables.CLSSid_AppendParameterBinding);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_GuardParameterBinding = TypeId.BAG.getSpecializedId(QVTimperativeTables.CLSSid_GuardParameterBinding);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_LoopParameterBinding = TypeId.BAG.getSpecializedId(QVTimperativeTables.CLSSid_LoopParameterBinding);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_MappingCall = TypeId.BAG.getSpecializedId(QVTimperativeTables.CLSSid_MappingCall);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_MappingParameterBinding = TypeId.BAG.getSpecializedId(QVTimperativeTables.CLSSid_MappingParameterBinding);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_LoopVariable = TypeId.ORDERED_SET.getSpecializedId(QVTimperativeTables.CLSSid_LoopVariable);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_MappingParameterBinding = TypeId.ORDERED_SET.getSpecializedId(QVTimperativeTables.CLSSid_MappingParameterBinding);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_MappingStatement = TypeId.ORDERED_SET.getSpecializedId(QVTimperativeTables.CLSSid_MappingStatement);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_OCLExpression = TypeId.ORDERED_SET.getSpecializedId(QVTimperativeTables.CLSSid_OCLExpression);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Statement = TypeId.ORDERED_SET.getSpecializedId(QVTimperativeTables.CLSSid_Statement);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_TypedModel = TypeId.ORDERED_SET.getSpecializedId(QVTimperativeTables.CLSSid_TypedModel);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_VariableStatement = TypeId.ORDERED_SET.getSpecializedId(QVTimperativeTables.CLSSid_VariableStatement);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_MappingParameter = TypeId.SEQUENCE.getSpecializedId(QVTimperativeTables.CLSSid_MappingParameter);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_EntryPoint = TypeId.SET.getSpecializedId(QVTimperativeTables.CLSSid_EntryPoint);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_MappingParameter = TypeId.SET.getSpecializedId(QVTimperativeTables.CLSSid_MappingParameter);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_NewStatementPart = TypeId.SET.getSpecializedId(QVTimperativeTables.CLSSid_NewStatementPart);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_OCLExpression = TypeId.SET.getSpecializedId(QVTimperativeTables.CLSSid_OCLExpression);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_OclElement = TypeId.SET.getSpecializedId(QVTimperativeTables.CLSSid_OclElement);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Property = TypeId.SET.getSpecializedId(QVTimperativeTables.CLSSid_Property);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Rule = TypeId.SET.getSpecializedId(QVTimperativeTables.CLSSid_Rule);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_VariableDeclaration = TypeId.SET.getSpecializedId(QVTimperativeTables.CLSSid_VariableDeclaration);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_VariableExp = TypeId.SET.getSpecializedId(QVTimperativeTables.CLSSid_VariableExp);
	public static final /*@NonInvalid*/ @NonNull TupleTypeId TUPLid_ = IdManager.getTupleTypeId("Tuple", QVTimperativeTables.PARTid_, QVTimperativeTables.PARTid__0);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			QVTimperativeTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTimperativeTables::TypeParameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The type descriptors for each type.
	 */
	public static class Types {
		static {
			Init.initStart();
			TypeParameters.init();
		}

		public static final @NonNull EcoreExecutorType _AddStatement = new EcoreExecutorType(QVTimperativePackage.Literals.ADD_STATEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _AppendParameter = new EcoreExecutorType(QVTimperativePackage.Literals.APPEND_PARAMETER, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _AppendParameterBinding = new EcoreExecutorType(QVTimperativePackage.Literals.APPEND_PARAMETER_BINDING, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _BufferStatement = new EcoreExecutorType(QVTimperativePackage.Literals.BUFFER_STATEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CheckStatement = new EcoreExecutorType(QVTimperativePackage.Literals.CHECK_STATEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ConnectionVariable = new EcoreExecutorType(QVTimperativePackage.Literals.CONNECTION_VARIABLE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _DeclareStatement = new EcoreExecutorType(QVTimperativePackage.Literals.DECLARE_STATEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _EntryPoint = new EcoreExecutorType(QVTimperativePackage.Literals.ENTRY_POINT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _GuardParameter = new EcoreExecutorType(QVTimperativePackage.Literals.GUARD_PARAMETER, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _GuardParameterBinding = new EcoreExecutorType(QVTimperativePackage.Literals.GUARD_PARAMETER_BINDING, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ImperativeModel = new EcoreExecutorType(QVTimperativePackage.Literals.IMPERATIVE_MODEL, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ImperativeTransformation = new EcoreExecutorType(QVTimperativePackage.Literals.IMPERATIVE_TRANSFORMATION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _LoopParameterBinding = new EcoreExecutorType(QVTimperativePackage.Literals.LOOP_PARAMETER_BINDING, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _LoopVariable = new EcoreExecutorType(QVTimperativePackage.Literals.LOOP_VARIABLE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Mapping = new EcoreExecutorType(QVTimperativePackage.Literals.MAPPING, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _MappingCall = new EcoreExecutorType(QVTimperativePackage.Literals.MAPPING_CALL, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _MappingLoop = new EcoreExecutorType(QVTimperativePackage.Literals.MAPPING_LOOP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _MappingParameter = new EcoreExecutorType(QVTimperativePackage.Literals.MAPPING_PARAMETER, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _MappingParameterBinding = new EcoreExecutorType(QVTimperativePackage.Literals.MAPPING_PARAMETER_BINDING, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _MappingStatement = new EcoreExecutorType(QVTimperativePackage.Literals.MAPPING_STATEMENT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _NewStatement = new EcoreExecutorType(QVTimperativePackage.Literals.NEW_STATEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NewStatementPart = new EcoreExecutorType(QVTimperativePackage.Literals.NEW_STATEMENT_PART, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ObservableStatement = new EcoreExecutorType(QVTimperativePackage.Literals.OBSERVABLE_STATEMENT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _SetStatement = new EcoreExecutorType(QVTimperativePackage.Literals.SET_STATEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _SimpleParameter = new EcoreExecutorType(QVTimperativePackage.Literals.SIMPLE_PARAMETER, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _SimpleParameterBinding = new EcoreExecutorType(QVTimperativePackage.Literals.SIMPLE_PARAMETER_BINDING, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _SpeculateStatement = new EcoreExecutorType(QVTimperativePackage.Literals.SPECULATE_STATEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Statement = new EcoreExecutorType(QVTimperativePackage.Literals.STATEMENT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _VariableStatement = new EcoreExecutorType(QVTimperativePackage.Literals.VARIABLE_STATEMENT, PACKAGE, 0 | ExecutorType.ABSTRACT);

		private static final @NonNull EcoreExecutorType @NonNull [] types = {
			_AddStatement,
			_AppendParameter,
			_AppendParameterBinding,
			_BufferStatement,
			_CheckStatement,
			_ConnectionVariable,
			_DeclareStatement,
			_EntryPoint,
			_GuardParameter,
			_GuardParameterBinding,
			_ImperativeModel,
			_ImperativeTransformation,
			_LoopParameterBinding,
			_LoopVariable,
			_Mapping,
			_MappingCall,
			_MappingLoop,
			_MappingParameter,
			_MappingParameterBinding,
			_MappingStatement,
			_NewStatement,
			_NewStatementPart,
			_ObservableStatement,
			_SetStatement,
			_SimpleParameter,
			_SimpleParameterBinding,
			_SpeculateStatement,
			_Statement,
			_VariableStatement
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTimperativeTables::Types and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragment descriptors for the local elements of each type and its supertypes.
	 */
	public static class Fragments {
		static {
			Init.initStart();
			Types.init();
		}

		private static final @NonNull ExecutorFragment _AddStatement__AddStatement = new ExecutorFragment(Types._AddStatement, QVTimperativeTables.Types._AddStatement);
		private static final @NonNull ExecutorFragment _AddStatement__Element = new ExecutorFragment(Types._AddStatement, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _AddStatement__MappingStatement = new ExecutorFragment(Types._AddStatement, QVTimperativeTables.Types._MappingStatement);
		private static final @NonNull ExecutorFragment _AddStatement__NamedElement = new ExecutorFragment(Types._AddStatement, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _AddStatement__ObservableStatement = new ExecutorFragment(Types._AddStatement, QVTimperativeTables.Types._ObservableStatement);
		private static final @NonNull ExecutorFragment _AddStatement__OclAny = new ExecutorFragment(Types._AddStatement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _AddStatement__OclElement = new ExecutorFragment(Types._AddStatement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _AddStatement__Statement = new ExecutorFragment(Types._AddStatement, QVTimperativeTables.Types._Statement);

		private static final @NonNull ExecutorFragment _AppendParameter__AppendParameter = new ExecutorFragment(Types._AppendParameter, QVTimperativeTables.Types._AppendParameter);
		private static final @NonNull ExecutorFragment _AppendParameter__ConnectionVariable = new ExecutorFragment(Types._AppendParameter, QVTimperativeTables.Types._ConnectionVariable);
		private static final @NonNull ExecutorFragment _AppendParameter__Element = new ExecutorFragment(Types._AppendParameter, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _AppendParameter__MappingParameter = new ExecutorFragment(Types._AppendParameter, QVTimperativeTables.Types._MappingParameter);
		private static final @NonNull ExecutorFragment _AppendParameter__NamedElement = new ExecutorFragment(Types._AppendParameter, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _AppendParameter__OclAny = new ExecutorFragment(Types._AppendParameter, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _AppendParameter__OclElement = new ExecutorFragment(Types._AppendParameter, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _AppendParameter__TypedElement = new ExecutorFragment(Types._AppendParameter, PivotTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _AppendParameter__VariableDeclaration = new ExecutorFragment(Types._AppendParameter, PivotTables.Types._VariableDeclaration);

		private static final @NonNull ExecutorFragment _AppendParameterBinding__AppendParameterBinding = new ExecutorFragment(Types._AppendParameterBinding, QVTimperativeTables.Types._AppendParameterBinding);
		private static final @NonNull ExecutorFragment _AppendParameterBinding__Element = new ExecutorFragment(Types._AppendParameterBinding, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _AppendParameterBinding__MappingParameterBinding = new ExecutorFragment(Types._AppendParameterBinding, QVTimperativeTables.Types._MappingParameterBinding);
		private static final @NonNull ExecutorFragment _AppendParameterBinding__OclAny = new ExecutorFragment(Types._AppendParameterBinding, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _AppendParameterBinding__OclElement = new ExecutorFragment(Types._AppendParameterBinding, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _BufferStatement__BufferStatement = new ExecutorFragment(Types._BufferStatement, QVTimperativeTables.Types._BufferStatement);
		private static final @NonNull ExecutorFragment _BufferStatement__ConnectionVariable = new ExecutorFragment(Types._BufferStatement, QVTimperativeTables.Types._ConnectionVariable);
		private static final @NonNull ExecutorFragment _BufferStatement__Element = new ExecutorFragment(Types._BufferStatement, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _BufferStatement__NamedElement = new ExecutorFragment(Types._BufferStatement, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _BufferStatement__ObservableStatement = new ExecutorFragment(Types._BufferStatement, QVTimperativeTables.Types._ObservableStatement);
		private static final @NonNull ExecutorFragment _BufferStatement__OclAny = new ExecutorFragment(Types._BufferStatement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _BufferStatement__OclElement = new ExecutorFragment(Types._BufferStatement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _BufferStatement__Statement = new ExecutorFragment(Types._BufferStatement, QVTimperativeTables.Types._Statement);
		private static final @NonNull ExecutorFragment _BufferStatement__TypedElement = new ExecutorFragment(Types._BufferStatement, PivotTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _BufferStatement__VariableDeclaration = new ExecutorFragment(Types._BufferStatement, PivotTables.Types._VariableDeclaration);
		private static final @NonNull ExecutorFragment _BufferStatement__VariableStatement = new ExecutorFragment(Types._BufferStatement, QVTimperativeTables.Types._VariableStatement);

		private static final @NonNull ExecutorFragment _CheckStatement__CheckStatement = new ExecutorFragment(Types._CheckStatement, QVTimperativeTables.Types._CheckStatement);
		private static final @NonNull ExecutorFragment _CheckStatement__Element = new ExecutorFragment(Types._CheckStatement, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _CheckStatement__NamedElement = new ExecutorFragment(Types._CheckStatement, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _CheckStatement__ObservableStatement = new ExecutorFragment(Types._CheckStatement, QVTimperativeTables.Types._ObservableStatement);
		private static final @NonNull ExecutorFragment _CheckStatement__OclAny = new ExecutorFragment(Types._CheckStatement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _CheckStatement__OclElement = new ExecutorFragment(Types._CheckStatement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _CheckStatement__Statement = new ExecutorFragment(Types._CheckStatement, QVTimperativeTables.Types._Statement);

		private static final @NonNull ExecutorFragment _ConnectionVariable__ConnectionVariable = new ExecutorFragment(Types._ConnectionVariable, QVTimperativeTables.Types._ConnectionVariable);
		private static final @NonNull ExecutorFragment _ConnectionVariable__Element = new ExecutorFragment(Types._ConnectionVariable, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ConnectionVariable__NamedElement = new ExecutorFragment(Types._ConnectionVariable, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _ConnectionVariable__OclAny = new ExecutorFragment(Types._ConnectionVariable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ConnectionVariable__OclElement = new ExecutorFragment(Types._ConnectionVariable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _ConnectionVariable__TypedElement = new ExecutorFragment(Types._ConnectionVariable, PivotTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _ConnectionVariable__VariableDeclaration = new ExecutorFragment(Types._ConnectionVariable, PivotTables.Types._VariableDeclaration);

		private static final @NonNull ExecutorFragment _DeclareStatement__DeclareStatement = new ExecutorFragment(Types._DeclareStatement, QVTimperativeTables.Types._DeclareStatement);
		private static final @NonNull ExecutorFragment _DeclareStatement__Element = new ExecutorFragment(Types._DeclareStatement, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _DeclareStatement__NamedElement = new ExecutorFragment(Types._DeclareStatement, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _DeclareStatement__ObservableStatement = new ExecutorFragment(Types._DeclareStatement, QVTimperativeTables.Types._ObservableStatement);
		private static final @NonNull ExecutorFragment _DeclareStatement__OclAny = new ExecutorFragment(Types._DeclareStatement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _DeclareStatement__OclElement = new ExecutorFragment(Types._DeclareStatement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _DeclareStatement__Statement = new ExecutorFragment(Types._DeclareStatement, QVTimperativeTables.Types._Statement);
		private static final @NonNull ExecutorFragment _DeclareStatement__TypedElement = new ExecutorFragment(Types._DeclareStatement, PivotTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _DeclareStatement__VariableDeclaration = new ExecutorFragment(Types._DeclareStatement, PivotTables.Types._VariableDeclaration);
		private static final @NonNull ExecutorFragment _DeclareStatement__VariableStatement = new ExecutorFragment(Types._DeclareStatement, QVTimperativeTables.Types._VariableStatement);

		private static final @NonNull ExecutorFragment _EntryPoint__Element = new ExecutorFragment(Types._EntryPoint, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _EntryPoint__EntryPoint = new ExecutorFragment(Types._EntryPoint, QVTimperativeTables.Types._EntryPoint);
		private static final @NonNull ExecutorFragment _EntryPoint__Mapping = new ExecutorFragment(Types._EntryPoint, QVTimperativeTables.Types._Mapping);
		private static final @NonNull ExecutorFragment _EntryPoint__NamedElement = new ExecutorFragment(Types._EntryPoint, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _EntryPoint__OclAny = new ExecutorFragment(Types._EntryPoint, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _EntryPoint__OclElement = new ExecutorFragment(Types._EntryPoint, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _EntryPoint__Rule = new ExecutorFragment(Types._EntryPoint, QVTbaseTables.Types._Rule);

		private static final @NonNull ExecutorFragment _GuardParameter__Element = new ExecutorFragment(Types._GuardParameter, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _GuardParameter__GuardParameter = new ExecutorFragment(Types._GuardParameter, QVTimperativeTables.Types._GuardParameter);
		private static final @NonNull ExecutorFragment _GuardParameter__MappingParameter = new ExecutorFragment(Types._GuardParameter, QVTimperativeTables.Types._MappingParameter);
		private static final @NonNull ExecutorFragment _GuardParameter__NamedElement = new ExecutorFragment(Types._GuardParameter, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _GuardParameter__OclAny = new ExecutorFragment(Types._GuardParameter, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _GuardParameter__OclElement = new ExecutorFragment(Types._GuardParameter, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _GuardParameter__TypedElement = new ExecutorFragment(Types._GuardParameter, PivotTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _GuardParameter__VariableDeclaration = new ExecutorFragment(Types._GuardParameter, PivotTables.Types._VariableDeclaration);

		private static final @NonNull ExecutorFragment _GuardParameterBinding__Element = new ExecutorFragment(Types._GuardParameterBinding, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _GuardParameterBinding__GuardParameterBinding = new ExecutorFragment(Types._GuardParameterBinding, QVTimperativeTables.Types._GuardParameterBinding);
		private static final @NonNull ExecutorFragment _GuardParameterBinding__MappingParameterBinding = new ExecutorFragment(Types._GuardParameterBinding, QVTimperativeTables.Types._MappingParameterBinding);
		private static final @NonNull ExecutorFragment _GuardParameterBinding__OclAny = new ExecutorFragment(Types._GuardParameterBinding, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _GuardParameterBinding__OclElement = new ExecutorFragment(Types._GuardParameterBinding, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _ImperativeModel__BaseModel = new ExecutorFragment(Types._ImperativeModel, QVTbaseTables.Types._BaseModel);
		private static final @NonNull ExecutorFragment _ImperativeModel__Element = new ExecutorFragment(Types._ImperativeModel, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ImperativeModel__ImperativeModel = new ExecutorFragment(Types._ImperativeModel, QVTimperativeTables.Types._ImperativeModel);
		private static final @NonNull ExecutorFragment _ImperativeModel__Model = new ExecutorFragment(Types._ImperativeModel, PivotTables.Types._Model);
		private static final @NonNull ExecutorFragment _ImperativeModel__NamedElement = new ExecutorFragment(Types._ImperativeModel, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _ImperativeModel__Namespace = new ExecutorFragment(Types._ImperativeModel, PivotTables.Types._Namespace);
		private static final @NonNull ExecutorFragment _ImperativeModel__OclAny = new ExecutorFragment(Types._ImperativeModel, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ImperativeModel__OclElement = new ExecutorFragment(Types._ImperativeModel, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _ImperativeTransformation__Class = new ExecutorFragment(Types._ImperativeTransformation, PivotTables.Types._Class);
		private static final @NonNull ExecutorFragment _ImperativeTransformation__Element = new ExecutorFragment(Types._ImperativeTransformation, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ImperativeTransformation__ImperativeTransformation = new ExecutorFragment(Types._ImperativeTransformation, QVTimperativeTables.Types._ImperativeTransformation);
		private static final @NonNull ExecutorFragment _ImperativeTransformation__NamedElement = new ExecutorFragment(Types._ImperativeTransformation, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _ImperativeTransformation__Namespace = new ExecutorFragment(Types._ImperativeTransformation, PivotTables.Types._Namespace);
		private static final @NonNull ExecutorFragment _ImperativeTransformation__OclAny = new ExecutorFragment(Types._ImperativeTransformation, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ImperativeTransformation__OclElement = new ExecutorFragment(Types._ImperativeTransformation, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _ImperativeTransformation__OclType = new ExecutorFragment(Types._ImperativeTransformation, OCLstdlibTables.Types._OclType);
		private static final @NonNull ExecutorFragment _ImperativeTransformation__TemplateableElement = new ExecutorFragment(Types._ImperativeTransformation, PivotTables.Types._TemplateableElement);
		private static final @NonNull ExecutorFragment _ImperativeTransformation__Transformation = new ExecutorFragment(Types._ImperativeTransformation, QVTbaseTables.Types._Transformation);
		private static final @NonNull ExecutorFragment _ImperativeTransformation__Type = new ExecutorFragment(Types._ImperativeTransformation, PivotTables.Types._Type);

		private static final @NonNull ExecutorFragment _LoopParameterBinding__Element = new ExecutorFragment(Types._LoopParameterBinding, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _LoopParameterBinding__LoopParameterBinding = new ExecutorFragment(Types._LoopParameterBinding, QVTimperativeTables.Types._LoopParameterBinding);
		private static final @NonNull ExecutorFragment _LoopParameterBinding__MappingParameterBinding = new ExecutorFragment(Types._LoopParameterBinding, QVTimperativeTables.Types._MappingParameterBinding);
		private static final @NonNull ExecutorFragment _LoopParameterBinding__OclAny = new ExecutorFragment(Types._LoopParameterBinding, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _LoopParameterBinding__OclElement = new ExecutorFragment(Types._LoopParameterBinding, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _LoopVariable__Element = new ExecutorFragment(Types._LoopVariable, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _LoopVariable__LoopVariable = new ExecutorFragment(Types._LoopVariable, QVTimperativeTables.Types._LoopVariable);
		private static final @NonNull ExecutorFragment _LoopVariable__NamedElement = new ExecutorFragment(Types._LoopVariable, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _LoopVariable__OclAny = new ExecutorFragment(Types._LoopVariable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _LoopVariable__OclElement = new ExecutorFragment(Types._LoopVariable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _LoopVariable__TypedElement = new ExecutorFragment(Types._LoopVariable, PivotTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _LoopVariable__VariableDeclaration = new ExecutorFragment(Types._LoopVariable, PivotTables.Types._VariableDeclaration);

		private static final @NonNull ExecutorFragment _Mapping__Element = new ExecutorFragment(Types._Mapping, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Mapping__Mapping = new ExecutorFragment(Types._Mapping, QVTimperativeTables.Types._Mapping);
		private static final @NonNull ExecutorFragment _Mapping__NamedElement = new ExecutorFragment(Types._Mapping, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Mapping__OclAny = new ExecutorFragment(Types._Mapping, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Mapping__OclElement = new ExecutorFragment(Types._Mapping, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Mapping__Rule = new ExecutorFragment(Types._Mapping, QVTbaseTables.Types._Rule);

		private static final @NonNull ExecutorFragment _MappingCall__Element = new ExecutorFragment(Types._MappingCall, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _MappingCall__MappingCall = new ExecutorFragment(Types._MappingCall, QVTimperativeTables.Types._MappingCall);
		private static final @NonNull ExecutorFragment _MappingCall__MappingStatement = new ExecutorFragment(Types._MappingCall, QVTimperativeTables.Types._MappingStatement);
		private static final @NonNull ExecutorFragment _MappingCall__NamedElement = new ExecutorFragment(Types._MappingCall, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _MappingCall__OclAny = new ExecutorFragment(Types._MappingCall, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _MappingCall__OclElement = new ExecutorFragment(Types._MappingCall, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _MappingCall__ReferringElement = new ExecutorFragment(Types._MappingCall, PivotTables.Types._ReferringElement);
		private static final @NonNull ExecutorFragment _MappingCall__Statement = new ExecutorFragment(Types._MappingCall, QVTimperativeTables.Types._Statement);

		private static final @NonNull ExecutorFragment _MappingLoop__Element = new ExecutorFragment(Types._MappingLoop, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _MappingLoop__MappingLoop = new ExecutorFragment(Types._MappingLoop, QVTimperativeTables.Types._MappingLoop);
		private static final @NonNull ExecutorFragment _MappingLoop__MappingStatement = new ExecutorFragment(Types._MappingLoop, QVTimperativeTables.Types._MappingStatement);
		private static final @NonNull ExecutorFragment _MappingLoop__NamedElement = new ExecutorFragment(Types._MappingLoop, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _MappingLoop__ObservableStatement = new ExecutorFragment(Types._MappingLoop, QVTimperativeTables.Types._ObservableStatement);
		private static final @NonNull ExecutorFragment _MappingLoop__OclAny = new ExecutorFragment(Types._MappingLoop, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _MappingLoop__OclElement = new ExecutorFragment(Types._MappingLoop, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _MappingLoop__Statement = new ExecutorFragment(Types._MappingLoop, QVTimperativeTables.Types._Statement);

		private static final @NonNull ExecutorFragment _MappingParameter__Element = new ExecutorFragment(Types._MappingParameter, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _MappingParameter__MappingParameter = new ExecutorFragment(Types._MappingParameter, QVTimperativeTables.Types._MappingParameter);
		private static final @NonNull ExecutorFragment _MappingParameter__NamedElement = new ExecutorFragment(Types._MappingParameter, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _MappingParameter__OclAny = new ExecutorFragment(Types._MappingParameter, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _MappingParameter__OclElement = new ExecutorFragment(Types._MappingParameter, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _MappingParameter__TypedElement = new ExecutorFragment(Types._MappingParameter, PivotTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _MappingParameter__VariableDeclaration = new ExecutorFragment(Types._MappingParameter, PivotTables.Types._VariableDeclaration);

		private static final @NonNull ExecutorFragment _MappingParameterBinding__Element = new ExecutorFragment(Types._MappingParameterBinding, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _MappingParameterBinding__MappingParameterBinding = new ExecutorFragment(Types._MappingParameterBinding, QVTimperativeTables.Types._MappingParameterBinding);
		private static final @NonNull ExecutorFragment _MappingParameterBinding__OclAny = new ExecutorFragment(Types._MappingParameterBinding, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _MappingParameterBinding__OclElement = new ExecutorFragment(Types._MappingParameterBinding, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _MappingStatement__Element = new ExecutorFragment(Types._MappingStatement, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _MappingStatement__MappingStatement = new ExecutorFragment(Types._MappingStatement, QVTimperativeTables.Types._MappingStatement);
		private static final @NonNull ExecutorFragment _MappingStatement__NamedElement = new ExecutorFragment(Types._MappingStatement, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _MappingStatement__OclAny = new ExecutorFragment(Types._MappingStatement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _MappingStatement__OclElement = new ExecutorFragment(Types._MappingStatement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _MappingStatement__Statement = new ExecutorFragment(Types._MappingStatement, QVTimperativeTables.Types._Statement);

		private static final @NonNull ExecutorFragment _NewStatement__Element = new ExecutorFragment(Types._NewStatement, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _NewStatement__NamedElement = new ExecutorFragment(Types._NewStatement, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _NewStatement__NewStatement = new ExecutorFragment(Types._NewStatement, QVTimperativeTables.Types._NewStatement);
		private static final @NonNull ExecutorFragment _NewStatement__ObservableStatement = new ExecutorFragment(Types._NewStatement, QVTimperativeTables.Types._ObservableStatement);
		private static final @NonNull ExecutorFragment _NewStatement__OclAny = new ExecutorFragment(Types._NewStatement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NewStatement__OclElement = new ExecutorFragment(Types._NewStatement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _NewStatement__Statement = new ExecutorFragment(Types._NewStatement, QVTimperativeTables.Types._Statement);
		private static final @NonNull ExecutorFragment _NewStatement__TypedElement = new ExecutorFragment(Types._NewStatement, PivotTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _NewStatement__VariableDeclaration = new ExecutorFragment(Types._NewStatement, PivotTables.Types._VariableDeclaration);
		private static final @NonNull ExecutorFragment _NewStatement__VariableStatement = new ExecutorFragment(Types._NewStatement, QVTimperativeTables.Types._VariableStatement);

		private static final @NonNull ExecutorFragment _NewStatementPart__Element = new ExecutorFragment(Types._NewStatementPart, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _NewStatementPart__NamedElement = new ExecutorFragment(Types._NewStatementPart, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _NewStatementPart__NewStatementPart = new ExecutorFragment(Types._NewStatementPart, QVTimperativeTables.Types._NewStatementPart);
		private static final @NonNull ExecutorFragment _NewStatementPart__OclAny = new ExecutorFragment(Types._NewStatementPart, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NewStatementPart__OclElement = new ExecutorFragment(Types._NewStatementPart, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _ObservableStatement__Element = new ExecutorFragment(Types._ObservableStatement, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ObservableStatement__NamedElement = new ExecutorFragment(Types._ObservableStatement, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _ObservableStatement__ObservableStatement = new ExecutorFragment(Types._ObservableStatement, QVTimperativeTables.Types._ObservableStatement);
		private static final @NonNull ExecutorFragment _ObservableStatement__OclAny = new ExecutorFragment(Types._ObservableStatement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ObservableStatement__OclElement = new ExecutorFragment(Types._ObservableStatement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _ObservableStatement__Statement = new ExecutorFragment(Types._ObservableStatement, QVTimperativeTables.Types._Statement);

		private static final @NonNull ExecutorFragment _SetStatement__Element = new ExecutorFragment(Types._SetStatement, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _SetStatement__NamedElement = new ExecutorFragment(Types._SetStatement, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _SetStatement__ObservableStatement = new ExecutorFragment(Types._SetStatement, QVTimperativeTables.Types._ObservableStatement);
		private static final @NonNull ExecutorFragment _SetStatement__OclAny = new ExecutorFragment(Types._SetStatement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _SetStatement__OclElement = new ExecutorFragment(Types._SetStatement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _SetStatement__SetStatement = new ExecutorFragment(Types._SetStatement, QVTimperativeTables.Types._SetStatement);
		private static final @NonNull ExecutorFragment _SetStatement__Statement = new ExecutorFragment(Types._SetStatement, QVTimperativeTables.Types._Statement);

		private static final @NonNull ExecutorFragment _SimpleParameter__Element = new ExecutorFragment(Types._SimpleParameter, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _SimpleParameter__MappingParameter = new ExecutorFragment(Types._SimpleParameter, QVTimperativeTables.Types._MappingParameter);
		private static final @NonNull ExecutorFragment _SimpleParameter__NamedElement = new ExecutorFragment(Types._SimpleParameter, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _SimpleParameter__OclAny = new ExecutorFragment(Types._SimpleParameter, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _SimpleParameter__OclElement = new ExecutorFragment(Types._SimpleParameter, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _SimpleParameter__SimpleParameter = new ExecutorFragment(Types._SimpleParameter, QVTimperativeTables.Types._SimpleParameter);
		private static final @NonNull ExecutorFragment _SimpleParameter__TypedElement = new ExecutorFragment(Types._SimpleParameter, PivotTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _SimpleParameter__VariableDeclaration = new ExecutorFragment(Types._SimpleParameter, PivotTables.Types._VariableDeclaration);

		private static final @NonNull ExecutorFragment _SimpleParameterBinding__Element = new ExecutorFragment(Types._SimpleParameterBinding, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _SimpleParameterBinding__MappingParameterBinding = new ExecutorFragment(Types._SimpleParameterBinding, QVTimperativeTables.Types._MappingParameterBinding);
		private static final @NonNull ExecutorFragment _SimpleParameterBinding__OclAny = new ExecutorFragment(Types._SimpleParameterBinding, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _SimpleParameterBinding__OclElement = new ExecutorFragment(Types._SimpleParameterBinding, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _SimpleParameterBinding__SimpleParameterBinding = new ExecutorFragment(Types._SimpleParameterBinding, QVTimperativeTables.Types._SimpleParameterBinding);

		private static final @NonNull ExecutorFragment _SpeculateStatement__Element = new ExecutorFragment(Types._SpeculateStatement, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _SpeculateStatement__NamedElement = new ExecutorFragment(Types._SpeculateStatement, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _SpeculateStatement__OclAny = new ExecutorFragment(Types._SpeculateStatement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _SpeculateStatement__OclElement = new ExecutorFragment(Types._SpeculateStatement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _SpeculateStatement__SpeculateStatement = new ExecutorFragment(Types._SpeculateStatement, QVTimperativeTables.Types._SpeculateStatement);
		private static final @NonNull ExecutorFragment _SpeculateStatement__Statement = new ExecutorFragment(Types._SpeculateStatement, QVTimperativeTables.Types._Statement);

		private static final @NonNull ExecutorFragment _Statement__Element = new ExecutorFragment(Types._Statement, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Statement__NamedElement = new ExecutorFragment(Types._Statement, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Statement__OclAny = new ExecutorFragment(Types._Statement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Statement__OclElement = new ExecutorFragment(Types._Statement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Statement__Statement = new ExecutorFragment(Types._Statement, QVTimperativeTables.Types._Statement);

		private static final @NonNull ExecutorFragment _VariableStatement__Element = new ExecutorFragment(Types._VariableStatement, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _VariableStatement__NamedElement = new ExecutorFragment(Types._VariableStatement, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _VariableStatement__OclAny = new ExecutorFragment(Types._VariableStatement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _VariableStatement__OclElement = new ExecutorFragment(Types._VariableStatement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _VariableStatement__Statement = new ExecutorFragment(Types._VariableStatement, QVTimperativeTables.Types._Statement);
		private static final @NonNull ExecutorFragment _VariableStatement__TypedElement = new ExecutorFragment(Types._VariableStatement, PivotTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _VariableStatement__VariableDeclaration = new ExecutorFragment(Types._VariableStatement, PivotTables.Types._VariableDeclaration);
		private static final @NonNull ExecutorFragment _VariableStatement__VariableStatement = new ExecutorFragment(Types._VariableStatement, QVTimperativeTables.Types._VariableStatement);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTimperativeTables::Fragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The parameter lists shared by operations.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Parameters {
		static {
			Init.initStart();
			Fragments.init();
		}

		public static final @NonNull ParameterTypes _OrderedSet__String__ = TypeUtil.createParameterTypes(new ExecutorSpecializedType("OrderedSet", OCLstdlibTables.Types._String));

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTimperativeTables::Parameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The operation descriptors for each operation of each type.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Operations {
		static {
			Init.initStart();
			Parameters.init();
		}

		public static final @NonNull ExecutorOperation _Statement__joinNames = new ExecutorOperation("joinNames", Parameters._OrderedSet__String__, Types._Statement,
			0, TemplateParameters.EMPTY_LIST, null);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTimperativeTables::Operations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The property descriptors for each property of each type.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Properties {
		static {
			Init.initStart();
			Operations.init();
		}

		public static final @NonNull ExecutorProperty _AddStatement__isEnforcedUnique = new EcoreExecutorProperty(QVTimperativePackage.Literals.ADD_STATEMENT__IS_ENFORCED_UNIQUE, Types._AddStatement, 0);
		public static final @NonNull ExecutorProperty _AddStatement__ownedExpression = new EcoreExecutorProperty(QVTimperativePackage.Literals.ADD_STATEMENT__OWNED_EXPRESSION, Types._AddStatement, 1);
		public static final @NonNull ExecutorProperty _AddStatement__targetVariable = new EcoreExecutorProperty(QVTimperativePackage.Literals.ADD_STATEMENT__TARGET_VARIABLE, Types._AddStatement, 2);

		public static final @NonNull ExecutorProperty _AppendParameterBinding__value = new EcoreExecutorProperty(QVTimperativePackage.Literals.APPEND_PARAMETER_BINDING__VALUE, Types._AppendParameterBinding, 0);

		public static final @NonNull ExecutorProperty _BufferStatement__firstPass = new EcoreExecutorProperty(QVTimperativePackage.Literals.BUFFER_STATEMENT__FIRST_PASS, Types._BufferStatement, 0);
		public static final @NonNull ExecutorProperty _BufferStatement__lastPass = new EcoreExecutorProperty(QVTimperativePackage.Literals.BUFFER_STATEMENT__LAST_PASS, Types._BufferStatement, 1);
		public static final @NonNull ExecutorProperty _BufferStatement__ownedExpression = new EcoreExecutorProperty(QVTimperativePackage.Literals.BUFFER_STATEMENT__OWNED_EXPRESSION, Types._BufferStatement, 2);

		public static final @NonNull ExecutorProperty _CheckStatement__ownedExpression = new EcoreExecutorProperty(QVTimperativePackage.Literals.CHECK_STATEMENT__OWNED_EXPRESSION, Types._CheckStatement, 0);

		public static final @NonNull ExecutorProperty _ConnectionVariable__isStrict = new EcoreExecutorProperty(QVTimperativePackage.Literals.CONNECTION_VARIABLE__IS_STRICT, Types._ConnectionVariable, 0);
		public static final @NonNull ExecutorProperty _ConnectionVariable__AddStatement__targetVariable = new ExecutorPropertyWithImplementation("AddStatement", Types._ConnectionVariable, 1, new EcoreLibraryOppositeProperty(QVTimperativePackage.Literals.ADD_STATEMENT__TARGET_VARIABLE));
		public static final @NonNull ExecutorProperty _ConnectionVariable__AppendParameterBinding__value = new ExecutorPropertyWithImplementation("AppendParameterBinding", Types._ConnectionVariable, 2, new EcoreLibraryOppositeProperty(QVTimperativePackage.Literals.APPEND_PARAMETER_BINDING__VALUE));
		public static final @NonNull ExecutorProperty _ConnectionVariable__GuardParameterBinding__value = new ExecutorPropertyWithImplementation("GuardParameterBinding", Types._ConnectionVariable, 3, new EcoreLibraryOppositeProperty(QVTimperativePackage.Literals.GUARD_PARAMETER_BINDING__VALUE));

		public static final @NonNull ExecutorProperty _DeclareStatement__isCheck = new EcoreExecutorProperty(QVTimperativePackage.Literals.DECLARE_STATEMENT__IS_CHECK, Types._DeclareStatement, 0);
		public static final @NonNull ExecutorProperty _DeclareStatement__ownedExpression = new EcoreExecutorProperty(QVTimperativePackage.Literals.DECLARE_STATEMENT__OWNED_EXPRESSION, Types._DeclareStatement, 1);

		public static final @NonNull ExecutorProperty _EntryPoint__inputTypedModels = new EcoreExecutorProperty(QVTimperativePackage.Literals.ENTRY_POINT__INPUT_TYPED_MODELS, Types._EntryPoint, 0);
		public static final @NonNull ExecutorProperty _EntryPoint__outputTypedModels = new EcoreExecutorProperty(QVTimperativePackage.Literals.ENTRY_POINT__OUTPUT_TYPED_MODELS, Types._EntryPoint, 1);
		public static final @NonNull ExecutorProperty _EntryPoint__targetName = new EcoreExecutorProperty(QVTimperativePackage.Literals.ENTRY_POINT__TARGET_NAME, Types._EntryPoint, 2);

		public static final @NonNull ExecutorProperty _GuardParameter__referredTypedModel = new EcoreExecutorProperty(QVTimperativePackage.Literals.GUARD_PARAMETER__REFERRED_TYPED_MODEL, Types._GuardParameter, 0);
		public static final @NonNull ExecutorProperty _GuardParameter__successProperty = new EcoreExecutorProperty(QVTimperativePackage.Literals.GUARD_PARAMETER__SUCCESS_PROPERTY, Types._GuardParameter, 1);

		public static final @NonNull ExecutorProperty _GuardParameterBinding__isCheck = new EcoreExecutorProperty(QVTimperativePackage.Literals.GUARD_PARAMETER_BINDING__IS_CHECK, Types._GuardParameterBinding, 0);
		public static final @NonNull ExecutorProperty _GuardParameterBinding__value = new EcoreExecutorProperty(QVTimperativePackage.Literals.GUARD_PARAMETER_BINDING__VALUE, Types._GuardParameterBinding, 1);

		public static final @NonNull ExecutorProperty _ImperativeTransformation__contextType = new EcoreExecutorProperty(QVTimperativePackage.Literals.IMPERATIVE_TRANSFORMATION__CONTEXT_TYPE, Types._ImperativeTransformation, 0);

		public static final @NonNull ExecutorProperty _LoopParameterBinding__isCheck = new EcoreExecutorProperty(QVTimperativePackage.Literals.LOOP_PARAMETER_BINDING__IS_CHECK, Types._LoopParameterBinding, 0);
		public static final @NonNull ExecutorProperty _LoopParameterBinding__value = new EcoreExecutorProperty(QVTimperativePackage.Literals.LOOP_PARAMETER_BINDING__VALUE, Types._LoopParameterBinding, 1);

		public static final @NonNull ExecutorProperty _LoopVariable__owningMappingLoop = new EcoreExecutorProperty(QVTimperativePackage.Literals.LOOP_VARIABLE__OWNING_MAPPING_LOOP, Types._LoopVariable, 0);
		public static final @NonNull ExecutorProperty _LoopVariable__LoopParameterBinding__value = new ExecutorPropertyWithImplementation("LoopParameterBinding", Types._LoopVariable, 1, new EcoreLibraryOppositeProperty(QVTimperativePackage.Literals.LOOP_PARAMETER_BINDING__VALUE));

		public static final @NonNull ExecutorProperty _Mapping__firstPass = new EcoreExecutorProperty(QVTimperativePackage.Literals.MAPPING__FIRST_PASS, Types._Mapping, 0);
		public static final @NonNull ExecutorProperty _Mapping__isStrict = new EcoreExecutorProperty(QVTimperativePackage.Literals.MAPPING__IS_STRICT, Types._Mapping, 1);
		public static final @NonNull ExecutorProperty _Mapping__lastPass = new EcoreExecutorProperty(QVTimperativePackage.Literals.MAPPING__LAST_PASS, Types._Mapping, 2);
		public static final @NonNull ExecutorProperty _Mapping__ownedMappingParameters = new EcoreExecutorProperty(QVTimperativePackage.Literals.MAPPING__OWNED_MAPPING_PARAMETERS, Types._Mapping, 3);
		public static final @NonNull ExecutorProperty _Mapping__ownedStatements = new EcoreExecutorProperty(QVTimperativePackage.Literals.MAPPING__OWNED_STATEMENTS, Types._Mapping, 4);
		public static final @NonNull ExecutorProperty _Mapping__MappingCall__referredMapping = new ExecutorPropertyWithImplementation("MappingCall", Types._Mapping, 5, new EcoreLibraryOppositeProperty(QVTimperativePackage.Literals.MAPPING_CALL__REFERRED_MAPPING));

		public static final @NonNull ExecutorProperty _MappingCall__bindingNames = new EcoreExecutorProperty(QVTimperativePackage.Literals.MAPPING_CALL__BINDING_NAMES, Types._MappingCall, 0);
		public static final @NonNull ExecutorProperty _MappingCall__isInstall = new EcoreExecutorProperty(QVTimperativePackage.Literals.MAPPING_CALL__IS_INSTALL, Types._MappingCall, 1);
		public static final @NonNull ExecutorProperty _MappingCall__isInvoke = new EcoreExecutorProperty(QVTimperativePackage.Literals.MAPPING_CALL__IS_INVOKE, Types._MappingCall, 2);
		public static final @NonNull ExecutorProperty _MappingCall__ownedMappingParameterBindings = new EcoreExecutorProperty(QVTimperativePackage.Literals.MAPPING_CALL__OWNED_MAPPING_PARAMETER_BINDINGS, Types._MappingCall, 3);
		public static final @NonNull ExecutorProperty _MappingCall__referredMapping = new EcoreExecutorProperty(QVTimperativePackage.Literals.MAPPING_CALL__REFERRED_MAPPING, Types._MappingCall, 4);
		public static final @NonNull ExecutorProperty _MappingCall__referredNames = new EcoreExecutorProperty(QVTimperativePackage.Literals.MAPPING_CALL__REFERRED_NAMES, Types._MappingCall, 5);

		public static final @NonNull ExecutorProperty _MappingLoop__ownedExpression = new EcoreExecutorProperty(QVTimperativePackage.Literals.MAPPING_LOOP__OWNED_EXPRESSION, Types._MappingLoop, 0);
		public static final @NonNull ExecutorProperty _MappingLoop__ownedIterators = new EcoreExecutorProperty(QVTimperativePackage.Literals.MAPPING_LOOP__OWNED_ITERATORS, Types._MappingLoop, 1);
		public static final @NonNull ExecutorProperty _MappingLoop__ownedMappingStatements = new EcoreExecutorProperty(QVTimperativePackage.Literals.MAPPING_LOOP__OWNED_MAPPING_STATEMENTS, Types._MappingLoop, 2);

		public static final @NonNull ExecutorProperty _MappingParameter__owningMapping = new EcoreExecutorProperty(QVTimperativePackage.Literals.MAPPING_PARAMETER__OWNING_MAPPING, Types._MappingParameter, 0);
		public static final @NonNull ExecutorProperty _MappingParameter__MappingParameterBinding__boundVariable = new ExecutorPropertyWithImplementation("MappingParameterBinding", Types._MappingParameter, 1, new EcoreLibraryOppositeProperty(QVTimperativePackage.Literals.MAPPING_PARAMETER_BINDING__BOUND_VARIABLE));

		public static final @NonNull ExecutorProperty _MappingParameterBinding__boundVariable = new EcoreExecutorProperty(QVTimperativePackage.Literals.MAPPING_PARAMETER_BINDING__BOUND_VARIABLE, Types._MappingParameterBinding, 0);
		public static final @NonNull ExecutorProperty _MappingParameterBinding__owningMappingCall = new EcoreExecutorProperty(QVTimperativePackage.Literals.MAPPING_PARAMETER_BINDING__OWNING_MAPPING_CALL, Types._MappingParameterBinding, 1);

		public static final @NonNull ExecutorProperty _MappingStatement__MappingLoop__ownedMappingStatements = new ExecutorPropertyWithImplementation("MappingLoop", Types._MappingStatement, 0, new EcoreLibraryOppositeProperty(QVTimperativePackage.Literals.MAPPING_LOOP__OWNED_MAPPING_STATEMENTS));

		public static final @NonNull ExecutorProperty _NewStatement__isContained = new EcoreExecutorProperty(QVTimperativePackage.Literals.NEW_STATEMENT__IS_CONTAINED, Types._NewStatement, 0);
		public static final @NonNull ExecutorProperty _NewStatement__ownedExpression = new EcoreExecutorProperty(QVTimperativePackage.Literals.NEW_STATEMENT__OWNED_EXPRESSION, Types._NewStatement, 1);
		public static final @NonNull ExecutorProperty _NewStatement__ownedParts = new EcoreExecutorProperty(QVTimperativePackage.Literals.NEW_STATEMENT__OWNED_PARTS, Types._NewStatement, 2);
		public static final @NonNull ExecutorProperty _NewStatement__referredTypedModel = new EcoreExecutorProperty(QVTimperativePackage.Literals.NEW_STATEMENT__REFERRED_TYPED_MODEL, Types._NewStatement, 3);

		public static final @NonNull ExecutorProperty _NewStatementPart__ownedExpression = new EcoreExecutorProperty(QVTimperativePackage.Literals.NEW_STATEMENT_PART__OWNED_EXPRESSION, Types._NewStatementPart, 0);
		public static final @NonNull ExecutorProperty _NewStatementPart__owningNewStatement = new EcoreExecutorProperty(QVTimperativePackage.Literals.NEW_STATEMENT_PART__OWNING_NEW_STATEMENT, Types._NewStatementPart, 1);
		public static final @NonNull ExecutorProperty _NewStatementPart__referredProperty = new EcoreExecutorProperty(QVTimperativePackage.Literals.NEW_STATEMENT_PART__REFERRED_PROPERTY, Types._NewStatementPart, 2);

		public static final @NonNull ExecutorProperty _ObservableStatement__observedProperties = new EcoreExecutorProperty(QVTimperativePackage.Literals.OBSERVABLE_STATEMENT__OBSERVED_PROPERTIES, Types._ObservableStatement, 0);

		public static final @NonNull ExecutorProperty _SetStatement__isNotify = new EcoreExecutorProperty(QVTimperativePackage.Literals.SET_STATEMENT__IS_NOTIFY, Types._SetStatement, 0);
		public static final @NonNull ExecutorProperty _SetStatement__isOpposite = new EcoreExecutorProperty(QVTimperativePackage.Literals.SET_STATEMENT__IS_OPPOSITE, Types._SetStatement, 1);
		public static final @NonNull ExecutorProperty _SetStatement__isPartial = new EcoreExecutorProperty(QVTimperativePackage.Literals.SET_STATEMENT__IS_PARTIAL, Types._SetStatement, 2);
		public static final @NonNull ExecutorProperty _SetStatement__ownedExpression = new EcoreExecutorProperty(QVTimperativePackage.Literals.SET_STATEMENT__OWNED_EXPRESSION, Types._SetStatement, 3);
		public static final @NonNull ExecutorProperty _SetStatement__resolvedProperty = new EcoreExecutorProperty(QVTimperativePackage.Literals.SET_STATEMENT__RESOLVED_PROPERTY, Types._SetStatement, 4);
		public static final @NonNull ExecutorProperty _SetStatement__targetProperty = new EcoreExecutorProperty(QVTimperativePackage.Literals.SET_STATEMENT__TARGET_PROPERTY, Types._SetStatement, 5);
		public static final @NonNull ExecutorProperty _SetStatement__targetVariable = new EcoreExecutorProperty(QVTimperativePackage.Literals.SET_STATEMENT__TARGET_VARIABLE, Types._SetStatement, 6);

		public static final @NonNull ExecutorProperty _SimpleParameter__referredTypedModel = new EcoreExecutorProperty(QVTimperativePackage.Literals.SIMPLE_PARAMETER__REFERRED_TYPED_MODEL, Types._SimpleParameter, 0);

		public static final @NonNull ExecutorProperty _SimpleParameterBinding__isCheck = new EcoreExecutorProperty(QVTimperativePackage.Literals.SIMPLE_PARAMETER_BINDING__IS_CHECK, Types._SimpleParameterBinding, 0);
		public static final @NonNull ExecutorProperty _SimpleParameterBinding__value = new EcoreExecutorProperty(QVTimperativePackage.Literals.SIMPLE_PARAMETER_BINDING__VALUE, Types._SimpleParameterBinding, 1);

		public static final @NonNull ExecutorProperty _SpeculateStatement__ownedExpressions = new EcoreExecutorProperty(QVTimperativePackage.Literals.SPECULATE_STATEMENT__OWNED_EXPRESSIONS, Types._SpeculateStatement, 0);

		public static final @NonNull ExecutorProperty _Statement__Mapping__ownedStatements = new ExecutorPropertyWithImplementation("Mapping", Types._Statement, 0, new EcoreLibraryOppositeProperty(QVTimperativePackage.Literals.MAPPING__OWNED_STATEMENTS));
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTimperativeTables::Properties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragments for all base types in depth order: OclAny first, OclSelf last.
	 */
	public static class TypeFragments {
		static {
			Init.initStart();
			Properties.init();
		}

		private static final @NonNull ExecutorFragment @NonNull [] _AddStatement =
			{
				Fragments._AddStatement__OclAny /* 0 */,
				Fragments._AddStatement__OclElement /* 1 */,
				Fragments._AddStatement__Element /* 2 */,
				Fragments._AddStatement__NamedElement /* 3 */,
				Fragments._AddStatement__Statement /* 4 */,
				Fragments._AddStatement__MappingStatement /* 5 */,
				Fragments._AddStatement__ObservableStatement /* 5 */,
				Fragments._AddStatement__AddStatement /* 6 */
			};
		private static final int @NonNull [] __AddStatement = { 1,1,1,1,1,2,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _AppendParameter =
			{
				Fragments._AppendParameter__OclAny /* 0 */,
				Fragments._AppendParameter__OclElement /* 1 */,
				Fragments._AppendParameter__Element /* 2 */,
				Fragments._AppendParameter__NamedElement /* 3 */,
				Fragments._AppendParameter__TypedElement /* 4 */,
				Fragments._AppendParameter__VariableDeclaration /* 5 */,
				Fragments._AppendParameter__ConnectionVariable /* 6 */,
				Fragments._AppendParameter__MappingParameter /* 6 */,
				Fragments._AppendParameter__AppendParameter /* 7 */
			};
		private static final int @NonNull [] __AppendParameter = { 1,1,1,1,1,1,2,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _AppendParameterBinding =
			{
				Fragments._AppendParameterBinding__OclAny /* 0 */,
				Fragments._AppendParameterBinding__OclElement /* 1 */,
				Fragments._AppendParameterBinding__Element /* 2 */,
				Fragments._AppendParameterBinding__MappingParameterBinding /* 3 */,
				Fragments._AppendParameterBinding__AppendParameterBinding /* 4 */
			};
		private static final int @NonNull [] __AppendParameterBinding = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _BufferStatement =
			{
				Fragments._BufferStatement__OclAny /* 0 */,
				Fragments._BufferStatement__OclElement /* 1 */,
				Fragments._BufferStatement__Element /* 2 */,
				Fragments._BufferStatement__NamedElement /* 3 */,
				Fragments._BufferStatement__Statement /* 4 */,
				Fragments._BufferStatement__TypedElement /* 4 */,
				Fragments._BufferStatement__ObservableStatement /* 5 */,
				Fragments._BufferStatement__VariableDeclaration /* 5 */,
				Fragments._BufferStatement__ConnectionVariable /* 6 */,
				Fragments._BufferStatement__VariableStatement /* 6 */,
				Fragments._BufferStatement__BufferStatement /* 7 */
			};
		private static final int @NonNull [] __BufferStatement = { 1,1,1,1,2,2,2,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _CheckStatement =
			{
				Fragments._CheckStatement__OclAny /* 0 */,
				Fragments._CheckStatement__OclElement /* 1 */,
				Fragments._CheckStatement__Element /* 2 */,
				Fragments._CheckStatement__NamedElement /* 3 */,
				Fragments._CheckStatement__Statement /* 4 */,
				Fragments._CheckStatement__ObservableStatement /* 5 */,
				Fragments._CheckStatement__CheckStatement /* 6 */
			};
		private static final int @NonNull [] __CheckStatement = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ConnectionVariable =
			{
				Fragments._ConnectionVariable__OclAny /* 0 */,
				Fragments._ConnectionVariable__OclElement /* 1 */,
				Fragments._ConnectionVariable__Element /* 2 */,
				Fragments._ConnectionVariable__NamedElement /* 3 */,
				Fragments._ConnectionVariable__TypedElement /* 4 */,
				Fragments._ConnectionVariable__VariableDeclaration /* 5 */,
				Fragments._ConnectionVariable__ConnectionVariable /* 6 */
			};
		private static final int @NonNull [] __ConnectionVariable = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _DeclareStatement =
			{
				Fragments._DeclareStatement__OclAny /* 0 */,
				Fragments._DeclareStatement__OclElement /* 1 */,
				Fragments._DeclareStatement__Element /* 2 */,
				Fragments._DeclareStatement__NamedElement /* 3 */,
				Fragments._DeclareStatement__Statement /* 4 */,
				Fragments._DeclareStatement__TypedElement /* 4 */,
				Fragments._DeclareStatement__ObservableStatement /* 5 */,
				Fragments._DeclareStatement__VariableDeclaration /* 5 */,
				Fragments._DeclareStatement__VariableStatement /* 6 */,
				Fragments._DeclareStatement__DeclareStatement /* 7 */
			};
		private static final int @NonNull [] __DeclareStatement = { 1,1,1,1,2,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _EntryPoint =
			{
				Fragments._EntryPoint__OclAny /* 0 */,
				Fragments._EntryPoint__OclElement /* 1 */,
				Fragments._EntryPoint__Element /* 2 */,
				Fragments._EntryPoint__NamedElement /* 3 */,
				Fragments._EntryPoint__Rule /* 4 */,
				Fragments._EntryPoint__Mapping /* 5 */,
				Fragments._EntryPoint__EntryPoint /* 6 */
			};
		private static final int @NonNull [] __EntryPoint = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _GuardParameter =
			{
				Fragments._GuardParameter__OclAny /* 0 */,
				Fragments._GuardParameter__OclElement /* 1 */,
				Fragments._GuardParameter__Element /* 2 */,
				Fragments._GuardParameter__NamedElement /* 3 */,
				Fragments._GuardParameter__TypedElement /* 4 */,
				Fragments._GuardParameter__VariableDeclaration /* 5 */,
				Fragments._GuardParameter__MappingParameter /* 6 */,
				Fragments._GuardParameter__GuardParameter /* 7 */
			};
		private static final int @NonNull [] __GuardParameter = { 1,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _GuardParameterBinding =
			{
				Fragments._GuardParameterBinding__OclAny /* 0 */,
				Fragments._GuardParameterBinding__OclElement /* 1 */,
				Fragments._GuardParameterBinding__Element /* 2 */,
				Fragments._GuardParameterBinding__MappingParameterBinding /* 3 */,
				Fragments._GuardParameterBinding__GuardParameterBinding /* 4 */
			};
		private static final int @NonNull [] __GuardParameterBinding = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ImperativeModel =
			{
				Fragments._ImperativeModel__OclAny /* 0 */,
				Fragments._ImperativeModel__OclElement /* 1 */,
				Fragments._ImperativeModel__Element /* 2 */,
				Fragments._ImperativeModel__NamedElement /* 3 */,
				Fragments._ImperativeModel__Namespace /* 4 */,
				Fragments._ImperativeModel__Model /* 5 */,
				Fragments._ImperativeModel__BaseModel /* 6 */,
				Fragments._ImperativeModel__ImperativeModel /* 7 */
			};
		private static final int @NonNull [] __ImperativeModel = { 1,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ImperativeTransformation =
			{
				Fragments._ImperativeTransformation__OclAny /* 0 */,
				Fragments._ImperativeTransformation__OclElement /* 1 */,
				Fragments._ImperativeTransformation__Element /* 2 */,
				Fragments._ImperativeTransformation__OclType /* 2 */,
				Fragments._ImperativeTransformation__NamedElement /* 3 */,
				Fragments._ImperativeTransformation__TemplateableElement /* 3 */,
				Fragments._ImperativeTransformation__Namespace /* 4 */,
				Fragments._ImperativeTransformation__Type /* 4 */,
				Fragments._ImperativeTransformation__Class /* 5 */,
				Fragments._ImperativeTransformation__Transformation /* 6 */,
				Fragments._ImperativeTransformation__ImperativeTransformation /* 7 */
			};
		private static final int @NonNull [] __ImperativeTransformation = { 1,1,2,2,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _LoopParameterBinding =
			{
				Fragments._LoopParameterBinding__OclAny /* 0 */,
				Fragments._LoopParameterBinding__OclElement /* 1 */,
				Fragments._LoopParameterBinding__Element /* 2 */,
				Fragments._LoopParameterBinding__MappingParameterBinding /* 3 */,
				Fragments._LoopParameterBinding__LoopParameterBinding /* 4 */
			};
		private static final int @NonNull [] __LoopParameterBinding = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _LoopVariable =
			{
				Fragments._LoopVariable__OclAny /* 0 */,
				Fragments._LoopVariable__OclElement /* 1 */,
				Fragments._LoopVariable__Element /* 2 */,
				Fragments._LoopVariable__NamedElement /* 3 */,
				Fragments._LoopVariable__TypedElement /* 4 */,
				Fragments._LoopVariable__VariableDeclaration /* 5 */,
				Fragments._LoopVariable__LoopVariable /* 6 */
			};
		private static final int @NonNull [] __LoopVariable = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Mapping =
			{
				Fragments._Mapping__OclAny /* 0 */,
				Fragments._Mapping__OclElement /* 1 */,
				Fragments._Mapping__Element /* 2 */,
				Fragments._Mapping__NamedElement /* 3 */,
				Fragments._Mapping__Rule /* 4 */,
				Fragments._Mapping__Mapping /* 5 */
			};
		private static final int @NonNull [] __Mapping = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _MappingCall =
			{
				Fragments._MappingCall__OclAny /* 0 */,
				Fragments._MappingCall__OclElement /* 1 */,
				Fragments._MappingCall__Element /* 2 */,
				Fragments._MappingCall__ReferringElement /* 2 */,
				Fragments._MappingCall__NamedElement /* 3 */,
				Fragments._MappingCall__Statement /* 4 */,
				Fragments._MappingCall__MappingStatement /* 5 */,
				Fragments._MappingCall__MappingCall /* 6 */
			};
		private static final int @NonNull [] __MappingCall = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _MappingLoop =
			{
				Fragments._MappingLoop__OclAny /* 0 */,
				Fragments._MappingLoop__OclElement /* 1 */,
				Fragments._MappingLoop__Element /* 2 */,
				Fragments._MappingLoop__NamedElement /* 3 */,
				Fragments._MappingLoop__Statement /* 4 */,
				Fragments._MappingLoop__MappingStatement /* 5 */,
				Fragments._MappingLoop__ObservableStatement /* 5 */,
				Fragments._MappingLoop__MappingLoop /* 6 */
			};
		private static final int @NonNull [] __MappingLoop = { 1,1,1,1,1,2,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _MappingParameter =
			{
				Fragments._MappingParameter__OclAny /* 0 */,
				Fragments._MappingParameter__OclElement /* 1 */,
				Fragments._MappingParameter__Element /* 2 */,
				Fragments._MappingParameter__NamedElement /* 3 */,
				Fragments._MappingParameter__TypedElement /* 4 */,
				Fragments._MappingParameter__VariableDeclaration /* 5 */,
				Fragments._MappingParameter__MappingParameter /* 6 */
			};
		private static final int @NonNull [] __MappingParameter = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _MappingParameterBinding =
			{
				Fragments._MappingParameterBinding__OclAny /* 0 */,
				Fragments._MappingParameterBinding__OclElement /* 1 */,
				Fragments._MappingParameterBinding__Element /* 2 */,
				Fragments._MappingParameterBinding__MappingParameterBinding /* 3 */
			};
		private static final int @NonNull [] __MappingParameterBinding = { 1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _MappingStatement =
			{
				Fragments._MappingStatement__OclAny /* 0 */,
				Fragments._MappingStatement__OclElement /* 1 */,
				Fragments._MappingStatement__Element /* 2 */,
				Fragments._MappingStatement__NamedElement /* 3 */,
				Fragments._MappingStatement__Statement /* 4 */,
				Fragments._MappingStatement__MappingStatement /* 5 */
			};
		private static final int @NonNull [] __MappingStatement = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _NewStatement =
			{
				Fragments._NewStatement__OclAny /* 0 */,
				Fragments._NewStatement__OclElement /* 1 */,
				Fragments._NewStatement__Element /* 2 */,
				Fragments._NewStatement__NamedElement /* 3 */,
				Fragments._NewStatement__Statement /* 4 */,
				Fragments._NewStatement__TypedElement /* 4 */,
				Fragments._NewStatement__ObservableStatement /* 5 */,
				Fragments._NewStatement__VariableDeclaration /* 5 */,
				Fragments._NewStatement__VariableStatement /* 6 */,
				Fragments._NewStatement__NewStatement /* 7 */
			};
		private static final int @NonNull [] __NewStatement = { 1,1,1,1,2,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _NewStatementPart =
			{
				Fragments._NewStatementPart__OclAny /* 0 */,
				Fragments._NewStatementPart__OclElement /* 1 */,
				Fragments._NewStatementPart__Element /* 2 */,
				Fragments._NewStatementPart__NamedElement /* 3 */,
				Fragments._NewStatementPart__NewStatementPart /* 4 */
			};
		private static final int @NonNull [] __NewStatementPart = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ObservableStatement =
			{
				Fragments._ObservableStatement__OclAny /* 0 */,
				Fragments._ObservableStatement__OclElement /* 1 */,
				Fragments._ObservableStatement__Element /* 2 */,
				Fragments._ObservableStatement__NamedElement /* 3 */,
				Fragments._ObservableStatement__Statement /* 4 */,
				Fragments._ObservableStatement__ObservableStatement /* 5 */
			};
		private static final int @NonNull [] __ObservableStatement = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _SetStatement =
			{
				Fragments._SetStatement__OclAny /* 0 */,
				Fragments._SetStatement__OclElement /* 1 */,
				Fragments._SetStatement__Element /* 2 */,
				Fragments._SetStatement__NamedElement /* 3 */,
				Fragments._SetStatement__Statement /* 4 */,
				Fragments._SetStatement__ObservableStatement /* 5 */,
				Fragments._SetStatement__SetStatement /* 6 */
			};
		private static final int @NonNull [] __SetStatement = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _SimpleParameter =
			{
				Fragments._SimpleParameter__OclAny /* 0 */,
				Fragments._SimpleParameter__OclElement /* 1 */,
				Fragments._SimpleParameter__Element /* 2 */,
				Fragments._SimpleParameter__NamedElement /* 3 */,
				Fragments._SimpleParameter__TypedElement /* 4 */,
				Fragments._SimpleParameter__VariableDeclaration /* 5 */,
				Fragments._SimpleParameter__MappingParameter /* 6 */,
				Fragments._SimpleParameter__SimpleParameter /* 7 */
			};
		private static final int @NonNull [] __SimpleParameter = { 1,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _SimpleParameterBinding =
			{
				Fragments._SimpleParameterBinding__OclAny /* 0 */,
				Fragments._SimpleParameterBinding__OclElement /* 1 */,
				Fragments._SimpleParameterBinding__Element /* 2 */,
				Fragments._SimpleParameterBinding__MappingParameterBinding /* 3 */,
				Fragments._SimpleParameterBinding__SimpleParameterBinding /* 4 */
			};
		private static final int @NonNull [] __SimpleParameterBinding = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _SpeculateStatement =
			{
				Fragments._SpeculateStatement__OclAny /* 0 */,
				Fragments._SpeculateStatement__OclElement /* 1 */,
				Fragments._SpeculateStatement__Element /* 2 */,
				Fragments._SpeculateStatement__NamedElement /* 3 */,
				Fragments._SpeculateStatement__Statement /* 4 */,
				Fragments._SpeculateStatement__SpeculateStatement /* 5 */
			};
		private static final int @NonNull [] __SpeculateStatement = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Statement =
			{
				Fragments._Statement__OclAny /* 0 */,
				Fragments._Statement__OclElement /* 1 */,
				Fragments._Statement__Element /* 2 */,
				Fragments._Statement__NamedElement /* 3 */,
				Fragments._Statement__Statement /* 4 */
			};
		private static final int @NonNull [] __Statement = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _VariableStatement =
			{
				Fragments._VariableStatement__OclAny /* 0 */,
				Fragments._VariableStatement__OclElement /* 1 */,
				Fragments._VariableStatement__Element /* 2 */,
				Fragments._VariableStatement__NamedElement /* 3 */,
				Fragments._VariableStatement__Statement /* 4 */,
				Fragments._VariableStatement__TypedElement /* 4 */,
				Fragments._VariableStatement__VariableDeclaration /* 5 */,
				Fragments._VariableStatement__VariableStatement /* 6 */
			};
		private static final int @NonNull [] __VariableStatement = { 1,1,1,1,2,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._AddStatement.initFragments(_AddStatement, __AddStatement);
			Types._AppendParameter.initFragments(_AppendParameter, __AppendParameter);
			Types._AppendParameterBinding.initFragments(_AppendParameterBinding, __AppendParameterBinding);
			Types._BufferStatement.initFragments(_BufferStatement, __BufferStatement);
			Types._CheckStatement.initFragments(_CheckStatement, __CheckStatement);
			Types._ConnectionVariable.initFragments(_ConnectionVariable, __ConnectionVariable);
			Types._DeclareStatement.initFragments(_DeclareStatement, __DeclareStatement);
			Types._EntryPoint.initFragments(_EntryPoint, __EntryPoint);
			Types._GuardParameter.initFragments(_GuardParameter, __GuardParameter);
			Types._GuardParameterBinding.initFragments(_GuardParameterBinding, __GuardParameterBinding);
			Types._ImperativeModel.initFragments(_ImperativeModel, __ImperativeModel);
			Types._ImperativeTransformation.initFragments(_ImperativeTransformation, __ImperativeTransformation);
			Types._LoopParameterBinding.initFragments(_LoopParameterBinding, __LoopParameterBinding);
			Types._LoopVariable.initFragments(_LoopVariable, __LoopVariable);
			Types._Mapping.initFragments(_Mapping, __Mapping);
			Types._MappingCall.initFragments(_MappingCall, __MappingCall);
			Types._MappingLoop.initFragments(_MappingLoop, __MappingLoop);
			Types._MappingParameter.initFragments(_MappingParameter, __MappingParameter);
			Types._MappingParameterBinding.initFragments(_MappingParameterBinding, __MappingParameterBinding);
			Types._MappingStatement.initFragments(_MappingStatement, __MappingStatement);
			Types._NewStatement.initFragments(_NewStatement, __NewStatement);
			Types._NewStatementPart.initFragments(_NewStatementPart, __NewStatementPart);
			Types._ObservableStatement.initFragments(_ObservableStatement, __ObservableStatement);
			Types._SetStatement.initFragments(_SetStatement, __SetStatement);
			Types._SimpleParameter.initFragments(_SimpleParameter, __SimpleParameter);
			Types._SimpleParameterBinding.initFragments(_SimpleParameterBinding, __SimpleParameterBinding);
			Types._SpeculateStatement.initFragments(_SpeculateStatement, __SpeculateStatement);
			Types._Statement.initFragments(_Statement, __Statement);
			Types._VariableStatement.initFragments(_VariableStatement, __VariableStatement);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTimperativeTables::TypeFragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local operations or local operation overrides for each fragment of each type.
	 */
	public static class FragmentOperations {
		static {
			Init.initStart();
			TypeFragments.init();
		}

		private static final @NonNull ExecutorOperation @NonNull [] _AddStatement__AddStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _AddStatement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _AddStatement__MappingStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _AddStatement__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _AddStatement__ObservableStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _AddStatement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _AddStatement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _AddStatement__Statement = {
			QVTimperativeTables.Operations._Statement__joinNames /* joinNames(OrderedSet(String)) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _AppendParameter__AppendParameter = {};
		private static final @NonNull ExecutorOperation @NonNull [] _AppendParameter__ConnectionVariable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _AppendParameter__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _AppendParameter__MappingParameter = {};
		private static final @NonNull ExecutorOperation @NonNull [] _AppendParameter__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _AppendParameter__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _AppendParameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _AppendParameter__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _AppendParameter__VariableDeclaration = {};

		private static final @NonNull ExecutorOperation @NonNull [] _AppendParameterBinding__AppendParameterBinding = {};
		private static final @NonNull ExecutorOperation @NonNull [] _AppendParameterBinding__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _AppendParameterBinding__MappingParameterBinding = {};
		private static final @NonNull ExecutorOperation @NonNull [] _AppendParameterBinding__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _AppendParameterBinding__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _BufferStatement__BufferStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BufferStatement__ConnectionVariable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BufferStatement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _BufferStatement__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BufferStatement__ObservableStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BufferStatement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _BufferStatement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _BufferStatement__Statement = {
			QVTimperativeTables.Operations._Statement__joinNames /* joinNames(OrderedSet(String)) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _BufferStatement__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _BufferStatement__VariableDeclaration = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BufferStatement__VariableStatement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _CheckStatement__CheckStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CheckStatement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CheckStatement__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CheckStatement__ObservableStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CheckStatement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CheckStatement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CheckStatement__Statement = {
			QVTimperativeTables.Operations._Statement__joinNames /* joinNames(OrderedSet(String)) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionVariable__ConnectionVariable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionVariable__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionVariable__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionVariable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionVariable__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionVariable__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionVariable__VariableDeclaration = {};

		private static final @NonNull ExecutorOperation @NonNull [] _DeclareStatement__DeclareStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DeclareStatement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _DeclareStatement__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DeclareStatement__ObservableStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DeclareStatement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _DeclareStatement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _DeclareStatement__Statement = {
			QVTimperativeTables.Operations._Statement__joinNames /* joinNames(OrderedSet(String)) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _DeclareStatement__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _DeclareStatement__VariableDeclaration = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DeclareStatement__VariableStatement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _EntryPoint__EntryPoint = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EntryPoint__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _EntryPoint__Mapping = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EntryPoint__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EntryPoint__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _EntryPoint__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _EntryPoint__Rule = {};

		private static final @NonNull ExecutorOperation @NonNull [] _GuardParameter__GuardParameter = {};
		private static final @NonNull ExecutorOperation @NonNull [] _GuardParameter__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _GuardParameter__MappingParameter = {};
		private static final @NonNull ExecutorOperation @NonNull [] _GuardParameter__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _GuardParameter__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _GuardParameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _GuardParameter__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _GuardParameter__VariableDeclaration = {};

		private static final @NonNull ExecutorOperation @NonNull [] _GuardParameterBinding__GuardParameterBinding = {};
		private static final @NonNull ExecutorOperation @NonNull [] _GuardParameterBinding__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _GuardParameterBinding__MappingParameterBinding = {};
		private static final @NonNull ExecutorOperation @NonNull [] _GuardParameterBinding__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _GuardParameterBinding__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeModel__ImperativeModel = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeModel__BaseModel = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeModel__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeModel__Model = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeModel__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeModel__Namespace = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeModel__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeModel__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeTransformation__ImperativeTransformation = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeTransformation__Class = {
			PivotTables.Operations._Class__allInstances /* allInstances() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeTransformation__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeTransformation__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeTransformation__Namespace = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeTransformation__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeTransformation__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeTransformation__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeTransformation__TemplateableElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeTransformation__Transformation = {
			QVTbaseTables.Operations._Transformation__getFunction /* getFunction(String[1]) */,
			QVTbaseTables.Operations._Transformation__getModelParameter /* getModelParameter(String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ImperativeTransformation__Type = {
			PivotTables.Operations._Type__conformsTo /* conformsTo(Type[?]) */,
			PivotTables.Operations._Type__flattenedType /* flattenedType() */,
			PivotTables.Operations._Type__isClass /* isClass() */,
			PivotTables.Operations._Type__isTemplateParameter /* isTemplateParameter() */,
			PivotTables.Operations._Type__specializeIn /* specializeIn(CallExp[1],Type[1]) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _LoopParameterBinding__LoopParameterBinding = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LoopParameterBinding__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _LoopParameterBinding__MappingParameterBinding = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LoopParameterBinding__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _LoopParameterBinding__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _LoopVariable__LoopVariable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LoopVariable__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _LoopVariable__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LoopVariable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _LoopVariable__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _LoopVariable__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _LoopVariable__VariableDeclaration = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Mapping__Mapping = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Mapping__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Mapping__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Mapping__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Mapping__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Mapping__Rule = {};

		private static final @NonNull ExecutorOperation @NonNull [] _MappingCall__MappingCall = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingCall__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingCall__MappingStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingCall__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingCall__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingCall__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingCall__ReferringElement = {
			PivotTables.Operations._ReferringElement__getReferredElement /* getReferredElement() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingCall__Statement = {
			QVTimperativeTables.Operations._Statement__joinNames /* joinNames(OrderedSet(String)) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _MappingLoop__MappingLoop = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingLoop__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingLoop__MappingStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingLoop__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingLoop__ObservableStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingLoop__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingLoop__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingLoop__Statement = {
			QVTimperativeTables.Operations._Statement__joinNames /* joinNames(OrderedSet(String)) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _MappingParameter__MappingParameter = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingParameter__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingParameter__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingParameter__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingParameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingParameter__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingParameter__VariableDeclaration = {};

		private static final @NonNull ExecutorOperation @NonNull [] _MappingParameterBinding__MappingParameterBinding = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingParameterBinding__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingParameterBinding__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingParameterBinding__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _MappingStatement__MappingStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingStatement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingStatement__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingStatement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingStatement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingStatement__Statement = {
			QVTimperativeTables.Operations._Statement__joinNames /* joinNames(OrderedSet(String)) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _NewStatement__NewStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NewStatement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NewStatement__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NewStatement__ObservableStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NewStatement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NewStatement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NewStatement__Statement = {
			QVTimperativeTables.Operations._Statement__joinNames /* joinNames(OrderedSet(String)) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NewStatement__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NewStatement__VariableDeclaration = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NewStatement__VariableStatement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _NewStatementPart__NewStatementPart = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NewStatementPart__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NewStatementPart__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NewStatementPart__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NewStatementPart__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _ObservableStatement__ObservableStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ObservableStatement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ObservableStatement__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ObservableStatement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ObservableStatement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ObservableStatement__Statement = {
			QVTimperativeTables.Operations._Statement__joinNames /* joinNames(OrderedSet(String)) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _SetStatement__SetStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SetStatement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SetStatement__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SetStatement__ObservableStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SetStatement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SetStatement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SetStatement__Statement = {
			QVTimperativeTables.Operations._Statement__joinNames /* joinNames(OrderedSet(String)) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _SimpleParameter__SimpleParameter = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SimpleParameter__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SimpleParameter__MappingParameter = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SimpleParameter__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SimpleParameter__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SimpleParameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SimpleParameter__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SimpleParameter__VariableDeclaration = {};

		private static final @NonNull ExecutorOperation @NonNull [] _SimpleParameterBinding__SimpleParameterBinding = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SimpleParameterBinding__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SimpleParameterBinding__MappingParameterBinding = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SimpleParameterBinding__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SimpleParameterBinding__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _SpeculateStatement__SpeculateStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SpeculateStatement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SpeculateStatement__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SpeculateStatement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SpeculateStatement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SpeculateStatement__Statement = {
			QVTimperativeTables.Operations._Statement__joinNames /* joinNames(OrderedSet(String)) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Statement__Statement = {
			QVTimperativeTables.Operations._Statement__joinNames /* joinNames(OrderedSet(String)) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Statement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Statement__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Statement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Statement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _VariableStatement__VariableStatement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableStatement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableStatement__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableStatement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableStatement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableStatement__Statement = {
			QVTimperativeTables.Operations._Statement__joinNames /* joinNames(OrderedSet(String)) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableStatement__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableStatement__VariableDeclaration = {};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._AddStatement__AddStatement.initOperations(_AddStatement__AddStatement);
			Fragments._AddStatement__Element.initOperations(_AddStatement__Element);
			Fragments._AddStatement__MappingStatement.initOperations(_AddStatement__MappingStatement);
			Fragments._AddStatement__NamedElement.initOperations(_AddStatement__NamedElement);
			Fragments._AddStatement__ObservableStatement.initOperations(_AddStatement__ObservableStatement);
			Fragments._AddStatement__OclAny.initOperations(_AddStatement__OclAny);
			Fragments._AddStatement__OclElement.initOperations(_AddStatement__OclElement);
			Fragments._AddStatement__Statement.initOperations(_AddStatement__Statement);

			Fragments._AppendParameter__AppendParameter.initOperations(_AppendParameter__AppendParameter);
			Fragments._AppendParameter__ConnectionVariable.initOperations(_AppendParameter__ConnectionVariable);
			Fragments._AppendParameter__Element.initOperations(_AppendParameter__Element);
			Fragments._AppendParameter__MappingParameter.initOperations(_AppendParameter__MappingParameter);
			Fragments._AppendParameter__NamedElement.initOperations(_AppendParameter__NamedElement);
			Fragments._AppendParameter__OclAny.initOperations(_AppendParameter__OclAny);
			Fragments._AppendParameter__OclElement.initOperations(_AppendParameter__OclElement);
			Fragments._AppendParameter__TypedElement.initOperations(_AppendParameter__TypedElement);
			Fragments._AppendParameter__VariableDeclaration.initOperations(_AppendParameter__VariableDeclaration);

			Fragments._AppendParameterBinding__AppendParameterBinding.initOperations(_AppendParameterBinding__AppendParameterBinding);
			Fragments._AppendParameterBinding__Element.initOperations(_AppendParameterBinding__Element);
			Fragments._AppendParameterBinding__MappingParameterBinding.initOperations(_AppendParameterBinding__MappingParameterBinding);
			Fragments._AppendParameterBinding__OclAny.initOperations(_AppendParameterBinding__OclAny);
			Fragments._AppendParameterBinding__OclElement.initOperations(_AppendParameterBinding__OclElement);

			Fragments._BufferStatement__BufferStatement.initOperations(_BufferStatement__BufferStatement);
			Fragments._BufferStatement__ConnectionVariable.initOperations(_BufferStatement__ConnectionVariable);
			Fragments._BufferStatement__Element.initOperations(_BufferStatement__Element);
			Fragments._BufferStatement__NamedElement.initOperations(_BufferStatement__NamedElement);
			Fragments._BufferStatement__ObservableStatement.initOperations(_BufferStatement__ObservableStatement);
			Fragments._BufferStatement__OclAny.initOperations(_BufferStatement__OclAny);
			Fragments._BufferStatement__OclElement.initOperations(_BufferStatement__OclElement);
			Fragments._BufferStatement__Statement.initOperations(_BufferStatement__Statement);
			Fragments._BufferStatement__TypedElement.initOperations(_BufferStatement__TypedElement);
			Fragments._BufferStatement__VariableDeclaration.initOperations(_BufferStatement__VariableDeclaration);
			Fragments._BufferStatement__VariableStatement.initOperations(_BufferStatement__VariableStatement);

			Fragments._CheckStatement__CheckStatement.initOperations(_CheckStatement__CheckStatement);
			Fragments._CheckStatement__Element.initOperations(_CheckStatement__Element);
			Fragments._CheckStatement__NamedElement.initOperations(_CheckStatement__NamedElement);
			Fragments._CheckStatement__ObservableStatement.initOperations(_CheckStatement__ObservableStatement);
			Fragments._CheckStatement__OclAny.initOperations(_CheckStatement__OclAny);
			Fragments._CheckStatement__OclElement.initOperations(_CheckStatement__OclElement);
			Fragments._CheckStatement__Statement.initOperations(_CheckStatement__Statement);

			Fragments._ConnectionVariable__ConnectionVariable.initOperations(_ConnectionVariable__ConnectionVariable);
			Fragments._ConnectionVariable__Element.initOperations(_ConnectionVariable__Element);
			Fragments._ConnectionVariable__NamedElement.initOperations(_ConnectionVariable__NamedElement);
			Fragments._ConnectionVariable__OclAny.initOperations(_ConnectionVariable__OclAny);
			Fragments._ConnectionVariable__OclElement.initOperations(_ConnectionVariable__OclElement);
			Fragments._ConnectionVariable__TypedElement.initOperations(_ConnectionVariable__TypedElement);
			Fragments._ConnectionVariable__VariableDeclaration.initOperations(_ConnectionVariable__VariableDeclaration);

			Fragments._DeclareStatement__DeclareStatement.initOperations(_DeclareStatement__DeclareStatement);
			Fragments._DeclareStatement__Element.initOperations(_DeclareStatement__Element);
			Fragments._DeclareStatement__NamedElement.initOperations(_DeclareStatement__NamedElement);
			Fragments._DeclareStatement__ObservableStatement.initOperations(_DeclareStatement__ObservableStatement);
			Fragments._DeclareStatement__OclAny.initOperations(_DeclareStatement__OclAny);
			Fragments._DeclareStatement__OclElement.initOperations(_DeclareStatement__OclElement);
			Fragments._DeclareStatement__Statement.initOperations(_DeclareStatement__Statement);
			Fragments._DeclareStatement__TypedElement.initOperations(_DeclareStatement__TypedElement);
			Fragments._DeclareStatement__VariableDeclaration.initOperations(_DeclareStatement__VariableDeclaration);
			Fragments._DeclareStatement__VariableStatement.initOperations(_DeclareStatement__VariableStatement);

			Fragments._EntryPoint__Element.initOperations(_EntryPoint__Element);
			Fragments._EntryPoint__EntryPoint.initOperations(_EntryPoint__EntryPoint);
			Fragments._EntryPoint__Mapping.initOperations(_EntryPoint__Mapping);
			Fragments._EntryPoint__NamedElement.initOperations(_EntryPoint__NamedElement);
			Fragments._EntryPoint__OclAny.initOperations(_EntryPoint__OclAny);
			Fragments._EntryPoint__OclElement.initOperations(_EntryPoint__OclElement);
			Fragments._EntryPoint__Rule.initOperations(_EntryPoint__Rule);

			Fragments._GuardParameter__Element.initOperations(_GuardParameter__Element);
			Fragments._GuardParameter__GuardParameter.initOperations(_GuardParameter__GuardParameter);
			Fragments._GuardParameter__MappingParameter.initOperations(_GuardParameter__MappingParameter);
			Fragments._GuardParameter__NamedElement.initOperations(_GuardParameter__NamedElement);
			Fragments._GuardParameter__OclAny.initOperations(_GuardParameter__OclAny);
			Fragments._GuardParameter__OclElement.initOperations(_GuardParameter__OclElement);
			Fragments._GuardParameter__TypedElement.initOperations(_GuardParameter__TypedElement);
			Fragments._GuardParameter__VariableDeclaration.initOperations(_GuardParameter__VariableDeclaration);

			Fragments._GuardParameterBinding__Element.initOperations(_GuardParameterBinding__Element);
			Fragments._GuardParameterBinding__GuardParameterBinding.initOperations(_GuardParameterBinding__GuardParameterBinding);
			Fragments._GuardParameterBinding__MappingParameterBinding.initOperations(_GuardParameterBinding__MappingParameterBinding);
			Fragments._GuardParameterBinding__OclAny.initOperations(_GuardParameterBinding__OclAny);
			Fragments._GuardParameterBinding__OclElement.initOperations(_GuardParameterBinding__OclElement);

			Fragments._ImperativeModel__BaseModel.initOperations(_ImperativeModel__BaseModel);
			Fragments._ImperativeModel__Element.initOperations(_ImperativeModel__Element);
			Fragments._ImperativeModel__ImperativeModel.initOperations(_ImperativeModel__ImperativeModel);
			Fragments._ImperativeModel__Model.initOperations(_ImperativeModel__Model);
			Fragments._ImperativeModel__NamedElement.initOperations(_ImperativeModel__NamedElement);
			Fragments._ImperativeModel__Namespace.initOperations(_ImperativeModel__Namespace);
			Fragments._ImperativeModel__OclAny.initOperations(_ImperativeModel__OclAny);
			Fragments._ImperativeModel__OclElement.initOperations(_ImperativeModel__OclElement);

			Fragments._ImperativeTransformation__Class.initOperations(_ImperativeTransformation__Class);
			Fragments._ImperativeTransformation__Element.initOperations(_ImperativeTransformation__Element);
			Fragments._ImperativeTransformation__ImperativeTransformation.initOperations(_ImperativeTransformation__ImperativeTransformation);
			Fragments._ImperativeTransformation__NamedElement.initOperations(_ImperativeTransformation__NamedElement);
			Fragments._ImperativeTransformation__Namespace.initOperations(_ImperativeTransformation__Namespace);
			Fragments._ImperativeTransformation__OclAny.initOperations(_ImperativeTransformation__OclAny);
			Fragments._ImperativeTransformation__OclElement.initOperations(_ImperativeTransformation__OclElement);
			Fragments._ImperativeTransformation__OclType.initOperations(_ImperativeTransformation__OclType);
			Fragments._ImperativeTransformation__TemplateableElement.initOperations(_ImperativeTransformation__TemplateableElement);
			Fragments._ImperativeTransformation__Transformation.initOperations(_ImperativeTransformation__Transformation);
			Fragments._ImperativeTransformation__Type.initOperations(_ImperativeTransformation__Type);

			Fragments._LoopParameterBinding__Element.initOperations(_LoopParameterBinding__Element);
			Fragments._LoopParameterBinding__LoopParameterBinding.initOperations(_LoopParameterBinding__LoopParameterBinding);
			Fragments._LoopParameterBinding__MappingParameterBinding.initOperations(_LoopParameterBinding__MappingParameterBinding);
			Fragments._LoopParameterBinding__OclAny.initOperations(_LoopParameterBinding__OclAny);
			Fragments._LoopParameterBinding__OclElement.initOperations(_LoopParameterBinding__OclElement);

			Fragments._LoopVariable__Element.initOperations(_LoopVariable__Element);
			Fragments._LoopVariable__LoopVariable.initOperations(_LoopVariable__LoopVariable);
			Fragments._LoopVariable__NamedElement.initOperations(_LoopVariable__NamedElement);
			Fragments._LoopVariable__OclAny.initOperations(_LoopVariable__OclAny);
			Fragments._LoopVariable__OclElement.initOperations(_LoopVariable__OclElement);
			Fragments._LoopVariable__TypedElement.initOperations(_LoopVariable__TypedElement);
			Fragments._LoopVariable__VariableDeclaration.initOperations(_LoopVariable__VariableDeclaration);

			Fragments._Mapping__Element.initOperations(_Mapping__Element);
			Fragments._Mapping__Mapping.initOperations(_Mapping__Mapping);
			Fragments._Mapping__NamedElement.initOperations(_Mapping__NamedElement);
			Fragments._Mapping__OclAny.initOperations(_Mapping__OclAny);
			Fragments._Mapping__OclElement.initOperations(_Mapping__OclElement);
			Fragments._Mapping__Rule.initOperations(_Mapping__Rule);

			Fragments._MappingCall__Element.initOperations(_MappingCall__Element);
			Fragments._MappingCall__MappingCall.initOperations(_MappingCall__MappingCall);
			Fragments._MappingCall__MappingStatement.initOperations(_MappingCall__MappingStatement);
			Fragments._MappingCall__NamedElement.initOperations(_MappingCall__NamedElement);
			Fragments._MappingCall__OclAny.initOperations(_MappingCall__OclAny);
			Fragments._MappingCall__OclElement.initOperations(_MappingCall__OclElement);
			Fragments._MappingCall__ReferringElement.initOperations(_MappingCall__ReferringElement);
			Fragments._MappingCall__Statement.initOperations(_MappingCall__Statement);

			Fragments._MappingLoop__Element.initOperations(_MappingLoop__Element);
			Fragments._MappingLoop__MappingLoop.initOperations(_MappingLoop__MappingLoop);
			Fragments._MappingLoop__MappingStatement.initOperations(_MappingLoop__MappingStatement);
			Fragments._MappingLoop__NamedElement.initOperations(_MappingLoop__NamedElement);
			Fragments._MappingLoop__ObservableStatement.initOperations(_MappingLoop__ObservableStatement);
			Fragments._MappingLoop__OclAny.initOperations(_MappingLoop__OclAny);
			Fragments._MappingLoop__OclElement.initOperations(_MappingLoop__OclElement);
			Fragments._MappingLoop__Statement.initOperations(_MappingLoop__Statement);

			Fragments._MappingParameter__Element.initOperations(_MappingParameter__Element);
			Fragments._MappingParameter__MappingParameter.initOperations(_MappingParameter__MappingParameter);
			Fragments._MappingParameter__NamedElement.initOperations(_MappingParameter__NamedElement);
			Fragments._MappingParameter__OclAny.initOperations(_MappingParameter__OclAny);
			Fragments._MappingParameter__OclElement.initOperations(_MappingParameter__OclElement);
			Fragments._MappingParameter__TypedElement.initOperations(_MappingParameter__TypedElement);
			Fragments._MappingParameter__VariableDeclaration.initOperations(_MappingParameter__VariableDeclaration);

			Fragments._MappingParameterBinding__Element.initOperations(_MappingParameterBinding__Element);
			Fragments._MappingParameterBinding__MappingParameterBinding.initOperations(_MappingParameterBinding__MappingParameterBinding);
			Fragments._MappingParameterBinding__OclAny.initOperations(_MappingParameterBinding__OclAny);
			Fragments._MappingParameterBinding__OclElement.initOperations(_MappingParameterBinding__OclElement);

			Fragments._MappingStatement__Element.initOperations(_MappingStatement__Element);
			Fragments._MappingStatement__MappingStatement.initOperations(_MappingStatement__MappingStatement);
			Fragments._MappingStatement__NamedElement.initOperations(_MappingStatement__NamedElement);
			Fragments._MappingStatement__OclAny.initOperations(_MappingStatement__OclAny);
			Fragments._MappingStatement__OclElement.initOperations(_MappingStatement__OclElement);
			Fragments._MappingStatement__Statement.initOperations(_MappingStatement__Statement);

			Fragments._NewStatement__Element.initOperations(_NewStatement__Element);
			Fragments._NewStatement__NamedElement.initOperations(_NewStatement__NamedElement);
			Fragments._NewStatement__NewStatement.initOperations(_NewStatement__NewStatement);
			Fragments._NewStatement__ObservableStatement.initOperations(_NewStatement__ObservableStatement);
			Fragments._NewStatement__OclAny.initOperations(_NewStatement__OclAny);
			Fragments._NewStatement__OclElement.initOperations(_NewStatement__OclElement);
			Fragments._NewStatement__Statement.initOperations(_NewStatement__Statement);
			Fragments._NewStatement__TypedElement.initOperations(_NewStatement__TypedElement);
			Fragments._NewStatement__VariableDeclaration.initOperations(_NewStatement__VariableDeclaration);
			Fragments._NewStatement__VariableStatement.initOperations(_NewStatement__VariableStatement);

			Fragments._NewStatementPart__Element.initOperations(_NewStatementPart__Element);
			Fragments._NewStatementPart__NamedElement.initOperations(_NewStatementPart__NamedElement);
			Fragments._NewStatementPart__NewStatementPart.initOperations(_NewStatementPart__NewStatementPart);
			Fragments._NewStatementPart__OclAny.initOperations(_NewStatementPart__OclAny);
			Fragments._NewStatementPart__OclElement.initOperations(_NewStatementPart__OclElement);

			Fragments._ObservableStatement__Element.initOperations(_ObservableStatement__Element);
			Fragments._ObservableStatement__NamedElement.initOperations(_ObservableStatement__NamedElement);
			Fragments._ObservableStatement__ObservableStatement.initOperations(_ObservableStatement__ObservableStatement);
			Fragments._ObservableStatement__OclAny.initOperations(_ObservableStatement__OclAny);
			Fragments._ObservableStatement__OclElement.initOperations(_ObservableStatement__OclElement);
			Fragments._ObservableStatement__Statement.initOperations(_ObservableStatement__Statement);

			Fragments._SetStatement__Element.initOperations(_SetStatement__Element);
			Fragments._SetStatement__NamedElement.initOperations(_SetStatement__NamedElement);
			Fragments._SetStatement__ObservableStatement.initOperations(_SetStatement__ObservableStatement);
			Fragments._SetStatement__OclAny.initOperations(_SetStatement__OclAny);
			Fragments._SetStatement__OclElement.initOperations(_SetStatement__OclElement);
			Fragments._SetStatement__SetStatement.initOperations(_SetStatement__SetStatement);
			Fragments._SetStatement__Statement.initOperations(_SetStatement__Statement);

			Fragments._SimpleParameter__Element.initOperations(_SimpleParameter__Element);
			Fragments._SimpleParameter__MappingParameter.initOperations(_SimpleParameter__MappingParameter);
			Fragments._SimpleParameter__NamedElement.initOperations(_SimpleParameter__NamedElement);
			Fragments._SimpleParameter__OclAny.initOperations(_SimpleParameter__OclAny);
			Fragments._SimpleParameter__OclElement.initOperations(_SimpleParameter__OclElement);
			Fragments._SimpleParameter__SimpleParameter.initOperations(_SimpleParameter__SimpleParameter);
			Fragments._SimpleParameter__TypedElement.initOperations(_SimpleParameter__TypedElement);
			Fragments._SimpleParameter__VariableDeclaration.initOperations(_SimpleParameter__VariableDeclaration);

			Fragments._SimpleParameterBinding__Element.initOperations(_SimpleParameterBinding__Element);
			Fragments._SimpleParameterBinding__MappingParameterBinding.initOperations(_SimpleParameterBinding__MappingParameterBinding);
			Fragments._SimpleParameterBinding__OclAny.initOperations(_SimpleParameterBinding__OclAny);
			Fragments._SimpleParameterBinding__OclElement.initOperations(_SimpleParameterBinding__OclElement);
			Fragments._SimpleParameterBinding__SimpleParameterBinding.initOperations(_SimpleParameterBinding__SimpleParameterBinding);

			Fragments._SpeculateStatement__Element.initOperations(_SpeculateStatement__Element);
			Fragments._SpeculateStatement__NamedElement.initOperations(_SpeculateStatement__NamedElement);
			Fragments._SpeculateStatement__OclAny.initOperations(_SpeculateStatement__OclAny);
			Fragments._SpeculateStatement__OclElement.initOperations(_SpeculateStatement__OclElement);
			Fragments._SpeculateStatement__SpeculateStatement.initOperations(_SpeculateStatement__SpeculateStatement);
			Fragments._SpeculateStatement__Statement.initOperations(_SpeculateStatement__Statement);

			Fragments._Statement__Element.initOperations(_Statement__Element);
			Fragments._Statement__NamedElement.initOperations(_Statement__NamedElement);
			Fragments._Statement__OclAny.initOperations(_Statement__OclAny);
			Fragments._Statement__OclElement.initOperations(_Statement__OclElement);
			Fragments._Statement__Statement.initOperations(_Statement__Statement);

			Fragments._VariableStatement__Element.initOperations(_VariableStatement__Element);
			Fragments._VariableStatement__NamedElement.initOperations(_VariableStatement__NamedElement);
			Fragments._VariableStatement__OclAny.initOperations(_VariableStatement__OclAny);
			Fragments._VariableStatement__OclElement.initOperations(_VariableStatement__OclElement);
			Fragments._VariableStatement__Statement.initOperations(_VariableStatement__Statement);
			Fragments._VariableStatement__TypedElement.initOperations(_VariableStatement__TypedElement);
			Fragments._VariableStatement__VariableDeclaration.initOperations(_VariableStatement__VariableDeclaration);
			Fragments._VariableStatement__VariableStatement.initOperations(_VariableStatement__VariableStatement);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTimperativeTables::FragmentOperations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local properties for the local fragment of each type.
	 */
	public static class FragmentProperties {
		static {
			Init.initStart();
			FragmentOperations.init();
		}

		private static final @NonNull ExecutorProperty @NonNull [] _AddStatement = {
			PivotTables.Properties._Element__annotatingComments,
			QVTimperativeTables.Properties._AddStatement__isEnforcedUnique,
			PivotTables.Properties._NamedElement__name,
			QVTimperativeTables.Properties._ObservableStatement__observedProperties,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			QVTimperativeTables.Properties._AddStatement__ownedExpression,
			PivotTables.Properties._Element__ownedExtensions,
			QVTimperativeTables.Properties._AddStatement__targetVariable
		};

		private static final @NonNull ExecutorProperty @NonNull [] _AppendParameter = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			QVTimperativeTables.Properties._ConnectionVariable__isStrict,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTimperativeTables.Properties._MappingParameter__owningMapping,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._VariableDeclaration__typeValue
		};

		private static final @NonNull ExecutorProperty @NonNull [] _AppendParameterBinding = {
			PivotTables.Properties._Element__annotatingComments,
			QVTimperativeTables.Properties._MappingParameterBinding__boundVariable,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTimperativeTables.Properties._MappingParameterBinding__owningMappingCall,
			QVTimperativeTables.Properties._AppendParameterBinding__value
		};

		private static final @NonNull ExecutorProperty @NonNull [] _BufferStatement = {
			PivotTables.Properties._Element__annotatingComments,
			QVTimperativeTables.Properties._BufferStatement__firstPass,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			QVTimperativeTables.Properties._ConnectionVariable__isStrict,
			QVTimperativeTables.Properties._BufferStatement__lastPass,
			PivotTables.Properties._NamedElement__name,
			QVTimperativeTables.Properties._ObservableStatement__observedProperties,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			QVTimperativeTables.Properties._BufferStatement__ownedExpression,
			PivotTables.Properties._Element__ownedExtensions,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._VariableDeclaration__typeValue
		};

		private static final @NonNull ExecutorProperty @NonNull [] _CheckStatement = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._NamedElement__name,
			QVTimperativeTables.Properties._ObservableStatement__observedProperties,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			QVTimperativeTables.Properties._CheckStatement__ownedExpression,
			PivotTables.Properties._Element__ownedExtensions
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ConnectionVariable = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			QVTimperativeTables.Properties._ConnectionVariable__isStrict,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._VariableDeclaration__typeValue
		};

		private static final @NonNull ExecutorProperty @NonNull [] _DeclareStatement = {
			PivotTables.Properties._Element__annotatingComments,
			QVTimperativeTables.Properties._DeclareStatement__isCheck,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			QVTimperativeTables.Properties._ObservableStatement__observedProperties,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			QVTimperativeTables.Properties._DeclareStatement__ownedExpression,
			PivotTables.Properties._Element__ownedExtensions,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._VariableDeclaration__typeValue
		};

		private static final @NonNull ExecutorProperty @NonNull [] _EntryPoint = {
			PivotTables.Properties._Element__annotatingComments,
			QVTbaseTables.Properties._Rule__domain,
			QVTimperativeTables.Properties._Mapping__firstPass,
			QVTimperativeTables.Properties._EntryPoint__inputTypedModels,
			QVTbaseTables.Properties._Rule__isAbstract,
			QVTimperativeTables.Properties._Mapping__isStrict,
			QVTimperativeTables.Properties._Mapping__lastPass,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			QVTimperativeTables.Properties._EntryPoint__outputTypedModels,
			QVTbaseTables.Properties._Rule__overridden,
			QVTbaseTables.Properties._Rule__overrides,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			QVTbaseTables.Properties._Rule__ownedContext,
			PivotTables.Properties._Element__ownedExtensions,
			QVTimperativeTables.Properties._Mapping__ownedMappingParameters,
			QVTimperativeTables.Properties._Mapping__ownedStatements,
			QVTimperativeTables.Properties._EntryPoint__targetName,
			QVTbaseTables.Properties._Rule__transformation
		};

		private static final @NonNull ExecutorProperty @NonNull [] _GuardParameter = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTimperativeTables.Properties._MappingParameter__owningMapping,
			QVTimperativeTables.Properties._GuardParameter__referredTypedModel,
			QVTimperativeTables.Properties._GuardParameter__successProperty,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._VariableDeclaration__typeValue
		};

		private static final @NonNull ExecutorProperty @NonNull [] _GuardParameterBinding = {
			PivotTables.Properties._Element__annotatingComments,
			QVTimperativeTables.Properties._MappingParameterBinding__boundVariable,
			QVTimperativeTables.Properties._GuardParameterBinding__isCheck,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTimperativeTables.Properties._MappingParameterBinding__owningMappingCall,
			QVTimperativeTables.Properties._GuardParameterBinding__value
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ImperativeModel = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._Model__externalURI,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Namespace__ownedConstraints,
			PivotTables.Properties._Element__ownedExtensions,
			PivotTables.Properties._Model__ownedImports,
			PivotTables.Properties._Model__ownedPackages,
			PivotTables.Properties._Model__xmiidVersion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ImperativeTransformation = {
			PivotTables.Properties._Element__annotatingComments,
			QVTimperativeTables.Properties._ImperativeTransformation__contextType,
			PivotTables.Properties._Class__extenders,
			QVTbaseTables.Properties._Transformation__extends,
			PivotTables.Properties._Class__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isActive,
			PivotTables.Properties._Class__isInterface,
			QVTbaseTables.Properties._Transformation__modelParameter,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Class__ownedBehaviors,
			PivotTables.Properties._TemplateableElement__ownedBindings,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Namespace__ownedConstraints,
			QVTbaseTables.Properties._Transformation__ownedContext,
			PivotTables.Properties._Element__ownedExtensions,
			PivotTables.Properties._Class__ownedInvariants,
			PivotTables.Properties._Class__ownedOperations,
			PivotTables.Properties._Class__ownedProperties,
			PivotTables.Properties._TemplateableElement__ownedSignature,
			QVTbaseTables.Properties._Transformation__ownedTag,
			QVTbaseTables.Properties._Transformation__ownedTargets,
			PivotTables.Properties._Class__owningPackage,
			QVTbaseTables.Properties._Transformation__rule,
			PivotTables.Properties._Class__superClasses,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty @NonNull [] _LoopParameterBinding = {
			PivotTables.Properties._Element__annotatingComments,
			QVTimperativeTables.Properties._MappingParameterBinding__boundVariable,
			QVTimperativeTables.Properties._LoopParameterBinding__isCheck,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTimperativeTables.Properties._MappingParameterBinding__owningMappingCall,
			QVTimperativeTables.Properties._LoopParameterBinding__value
		};

		private static final @NonNull ExecutorProperty @NonNull [] _LoopVariable = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTimperativeTables.Properties._LoopVariable__owningMappingLoop,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._VariableDeclaration__typeValue
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Mapping = {
			PivotTables.Properties._Element__annotatingComments,
			QVTbaseTables.Properties._Rule__domain,
			QVTimperativeTables.Properties._Mapping__firstPass,
			QVTbaseTables.Properties._Rule__isAbstract,
			QVTimperativeTables.Properties._Mapping__isStrict,
			QVTimperativeTables.Properties._Mapping__lastPass,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			QVTbaseTables.Properties._Rule__overridden,
			QVTbaseTables.Properties._Rule__overrides,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			QVTbaseTables.Properties._Rule__ownedContext,
			PivotTables.Properties._Element__ownedExtensions,
			QVTimperativeTables.Properties._Mapping__ownedMappingParameters,
			QVTimperativeTables.Properties._Mapping__ownedStatements,
			QVTbaseTables.Properties._Rule__transformation
		};

		private static final @NonNull ExecutorProperty @NonNull [] _MappingCall = {
			PivotTables.Properties._Element__annotatingComments,
			QVTimperativeTables.Properties._MappingCall__bindingNames,
			QVTimperativeTables.Properties._MappingCall__isInstall,
			QVTimperativeTables.Properties._MappingCall__isInvoke,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTimperativeTables.Properties._MappingCall__ownedMappingParameterBindings,
			QVTimperativeTables.Properties._MappingCall__referredMapping,
			QVTimperativeTables.Properties._MappingCall__referredNames
		};

		private static final @NonNull ExecutorProperty @NonNull [] _MappingLoop = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._NamedElement__name,
			QVTimperativeTables.Properties._ObservableStatement__observedProperties,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			QVTimperativeTables.Properties._MappingLoop__ownedExpression,
			PivotTables.Properties._Element__ownedExtensions,
			QVTimperativeTables.Properties._MappingLoop__ownedIterators,
			QVTimperativeTables.Properties._MappingLoop__ownedMappingStatements
		};

		private static final @NonNull ExecutorProperty @NonNull [] _MappingParameter = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTimperativeTables.Properties._MappingParameter__owningMapping,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._VariableDeclaration__typeValue
		};

		private static final @NonNull ExecutorProperty @NonNull [] _MappingParameterBinding = {
			PivotTables.Properties._Element__annotatingComments,
			QVTimperativeTables.Properties._MappingParameterBinding__boundVariable,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTimperativeTables.Properties._MappingParameterBinding__owningMappingCall
		};

		private static final @NonNull ExecutorProperty @NonNull [] _MappingStatement = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions
		};

		private static final @NonNull ExecutorProperty @NonNull [] _NewStatement = {
			PivotTables.Properties._Element__annotatingComments,
			QVTimperativeTables.Properties._NewStatement__isContained,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			QVTimperativeTables.Properties._ObservableStatement__observedProperties,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			QVTimperativeTables.Properties._NewStatement__ownedExpression,
			PivotTables.Properties._Element__ownedExtensions,
			QVTimperativeTables.Properties._NewStatement__ownedParts,
			QVTimperativeTables.Properties._NewStatement__referredTypedModel,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._VariableDeclaration__typeValue
		};

		private static final @NonNull ExecutorProperty @NonNull [] _NewStatementPart = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			QVTimperativeTables.Properties._NewStatementPart__ownedExpression,
			PivotTables.Properties._Element__ownedExtensions,
			QVTimperativeTables.Properties._NewStatementPart__owningNewStatement,
			QVTimperativeTables.Properties._NewStatementPart__referredProperty
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ObservableStatement = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._NamedElement__name,
			QVTimperativeTables.Properties._ObservableStatement__observedProperties,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions
		};

		private static final @NonNull ExecutorProperty @NonNull [] _SetStatement = {
			PivotTables.Properties._Element__annotatingComments,
			QVTimperativeTables.Properties._SetStatement__isNotify,
			QVTimperativeTables.Properties._SetStatement__isOpposite,
			QVTimperativeTables.Properties._SetStatement__isPartial,
			PivotTables.Properties._NamedElement__name,
			QVTimperativeTables.Properties._ObservableStatement__observedProperties,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			QVTimperativeTables.Properties._SetStatement__ownedExpression,
			PivotTables.Properties._Element__ownedExtensions,
			QVTimperativeTables.Properties._SetStatement__resolvedProperty,
			QVTimperativeTables.Properties._SetStatement__targetProperty,
			QVTimperativeTables.Properties._SetStatement__targetVariable
		};

		private static final @NonNull ExecutorProperty @NonNull [] _SimpleParameter = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTimperativeTables.Properties._MappingParameter__owningMapping,
			QVTimperativeTables.Properties._SimpleParameter__referredTypedModel,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._VariableDeclaration__typeValue
		};

		private static final @NonNull ExecutorProperty @NonNull [] _SimpleParameterBinding = {
			PivotTables.Properties._Element__annotatingComments,
			QVTimperativeTables.Properties._MappingParameterBinding__boundVariable,
			QVTimperativeTables.Properties._SimpleParameterBinding__isCheck,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTimperativeTables.Properties._MappingParameterBinding__owningMappingCall,
			QVTimperativeTables.Properties._SimpleParameterBinding__value
		};

		private static final @NonNull ExecutorProperty @NonNull [] _SpeculateStatement = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			QVTimperativeTables.Properties._SpeculateStatement__ownedExpressions,
			PivotTables.Properties._Element__ownedExtensions
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Statement = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions
		};

		private static final @NonNull ExecutorProperty @NonNull [] _VariableStatement = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._VariableDeclaration__typeValue
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._AddStatement__AddStatement.initProperties(_AddStatement);
			Fragments._AppendParameter__AppendParameter.initProperties(_AppendParameter);
			Fragments._AppendParameterBinding__AppendParameterBinding.initProperties(_AppendParameterBinding);
			Fragments._BufferStatement__BufferStatement.initProperties(_BufferStatement);
			Fragments._CheckStatement__CheckStatement.initProperties(_CheckStatement);
			Fragments._ConnectionVariable__ConnectionVariable.initProperties(_ConnectionVariable);
			Fragments._DeclareStatement__DeclareStatement.initProperties(_DeclareStatement);
			Fragments._EntryPoint__EntryPoint.initProperties(_EntryPoint);
			Fragments._GuardParameter__GuardParameter.initProperties(_GuardParameter);
			Fragments._GuardParameterBinding__GuardParameterBinding.initProperties(_GuardParameterBinding);
			Fragments._ImperativeModel__ImperativeModel.initProperties(_ImperativeModel);
			Fragments._ImperativeTransformation__ImperativeTransformation.initProperties(_ImperativeTransformation);
			Fragments._LoopParameterBinding__LoopParameterBinding.initProperties(_LoopParameterBinding);
			Fragments._LoopVariable__LoopVariable.initProperties(_LoopVariable);
			Fragments._Mapping__Mapping.initProperties(_Mapping);
			Fragments._MappingCall__MappingCall.initProperties(_MappingCall);
			Fragments._MappingLoop__MappingLoop.initProperties(_MappingLoop);
			Fragments._MappingParameter__MappingParameter.initProperties(_MappingParameter);
			Fragments._MappingParameterBinding__MappingParameterBinding.initProperties(_MappingParameterBinding);
			Fragments._MappingStatement__MappingStatement.initProperties(_MappingStatement);
			Fragments._NewStatement__NewStatement.initProperties(_NewStatement);
			Fragments._NewStatementPart__NewStatementPart.initProperties(_NewStatementPart);
			Fragments._ObservableStatement__ObservableStatement.initProperties(_ObservableStatement);
			Fragments._SetStatement__SetStatement.initProperties(_SetStatement);
			Fragments._SimpleParameter__SimpleParameter.initProperties(_SimpleParameter);
			Fragments._SimpleParameterBinding__SimpleParameterBinding.initProperties(_SimpleParameterBinding);
			Fragments._SpeculateStatement__SpeculateStatement.initProperties(_SpeculateStatement);
			Fragments._Statement__Statement.initProperties(_Statement);
			Fragments._VariableStatement__VariableStatement.initProperties(_VariableStatement);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTimperativeTables::FragmentProperties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of enumeration literals for each enumeration.
	 */
	public static class EnumerationLiterals {
		static {
			Init.initStart();
			FragmentProperties.init();
		}

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTimperativeTables::EnumerationLiterals and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 * The multiple packages above avoid problems with the Java 65536 byte limit but introduce a difficulty in ensuring that
	 * static construction occurs in the disciplined order of the packages when construction may start in any of the packages.
	 * The problem is resolved by ensuring that the static construction of each package first initializes its immediate predecessor.
	 * On completion of predecessor initialization, the residual packages are initialized by starting an initialization in the last package.
	 * This class maintains a count so that the various predecessors can distinguish whether they are the starting point and so
	 * ensure that residual construction occurs just once after all predecessors.
	 */
	private static class Init {
		/**
		 * Counter of nested static constructions. On return to zero residual construction starts. -ve once residual construction started.
		 */
		private static int initCount = 0;

		/**
		 * Invoked at the start of a static construction to defer residual construction until primary constructions complete.
		 */
		private static void initStart() {
			if (initCount >= 0) {
				initCount++;
			}
		}

		/**
		 * Invoked at the end of a static construction to activate residual construction once primary constructions complete.
		 */
		private static void initEnd() {
			if (initCount > 0) {
				if (--initCount == 0) {
					initCount = -1;
					EnumerationLiterals.init();
				}
			}
		}
	}

	static {
		Init.initEnd();
	}

	/*
	 * Force initialization of outer fields. Inner fields are lazily initialized.
	 */
	public static void init() {
		new QVTimperativeTables();
	}

	private QVTimperativeTables() {
		super(QVTimperativePackage.eNS_URI);
	}
}
