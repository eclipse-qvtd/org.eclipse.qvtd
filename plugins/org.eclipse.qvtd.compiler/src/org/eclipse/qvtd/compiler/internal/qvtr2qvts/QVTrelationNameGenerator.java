package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.NameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtc2qvtu.QVTuConfiguration;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * NameGenerator localizes the name generation functionality to facilitate a chnage / rewrite.
 */
public class QVTrelationNameGenerator extends NameGenerator
{
	public static final @NonNull String DISPATCHCLASS_RESULT_PROPERTY_NAME = "result";
	public static final @NonNull String DISPATCHCLASS_SELF_NAME = "dispatcher";
	public static final @NonNull String INVOCATION_GUARD_NAME = "invocationGuard";
	public static final @NonNull String IDENTIFIED_INSTANCE_VARIABLE_NAME = "identifiedInstance";
	public static final @NonNull String KEYED_INSTANCE_PROPERTY_NAME = "instance";
	public static final @NonNull String KEY2INSTANCE_VARIABLE_NAME = "key2instance";
	public static final @NonNull String TRACE_SUCCESS_PROPERTY_NAME = "success";
	public static final @NonNull String TRACECLASS_PROPERTY_NAME = "trace";

	public @NonNull String createDispatchClassName(@NonNull Rule rule) {
		return "D" + QVTbaseUtil.getName(rule);
	}

	public @NonNull String createDispatchClassDispatchPropertyName(@NonNull Relation relation) {
		String name = QVTrelationUtil.getName(relation);
		return "do" + name;
	}

	public @NonNull String createDispatchClassPropertyName(@NonNull TypedModel typedModel, @NonNull VariableDeclaration variable) {
		int index = QVTbaseUtil.getTypedModelIndex(typedModel);
		String name = QVTrelationUtil.getName(variable);
		return "d" + index + name;
	}

	public @NonNull String createDispatchClassResultPropertyName() {
		return /*"a_" +*/ DISPATCHCLASS_RESULT_PROPERTY_NAME;
	}

	public @NonNull String createInvocationClassName(@NonNull Rule rule) {
		return "C" + QVTbaseUtil.getName(rule);
	}

	public @NonNull String createInvocationClassPropertyName(@NonNull TypedModel typedModel, @NonNull VariableDeclaration variable) {
		int index = QVTbaseUtil.getTypedModelIndex(typedModel);
		String name = QVTrelationUtil.getName(variable);
		return "c" + index + name;
	}



	//	public @NonNull String createKey2InstanceClassName(org.eclipse.ocl.pivot.@NonNull Class identifiedClass) {
	//		return "Key2" + identifiedClass.getName();
	//	}

	//	public @NonNull String createKey2InstanceMappingName(org.eclipse.ocl.pivot.@NonNull Class identifiedClass, @NonNull TypedModel typedModel) {
	//		String enforcedDomainName = ClassUtil.nonNullState(typedModel.getName());
	//		return "Key2" + identifiedClass.getName() + "_" + enforcedDomainName;
	//	}

	public @NonNull String createInvocationTraceProperty(@NonNull Relation invokedRelation) {
		return "w" + invokedRelation.getName();
	}

	public @NonNull String createKeyedVariableName(@NonNull Variable identifiedVariable) {
		return QVTbaseUtil.getName(identifiedVariable) + "_key";
	}

	public @NonNull String createMappingName(@NonNull Relation rule, @Nullable String role, @NonNull QVTuConfiguration qvtuConfiguration) {
		StringBuilder s = new StringBuilder();
		s.append(PivotUtil.getName(rule));
		if (role != null) {
			s.append("_");
			s.append(role);
		}
		for (@NonNull RelationDomain domain : QVTrelationUtil.getOwnedDomains(rule)) {
			TypedModel typedModel = QVTrelationUtil.getTypedModel(domain);
			if (qvtuConfiguration.isOutput(typedModel)) {
				s.append("_");
				s.append(PivotUtil.getName(typedModel));
			}
		}
		return s.toString();
	}

	public @NonNull String createTraceClassName(@NonNull Rule rule) {
		return "T" + QVTbaseUtil.getName(rule);
	}

	public @NonNull String createTraceClassPropertyName(@NonNull TypedModel typedModel, @NonNull VariableDeclaration variable) {
		int index = QVTbaseUtil.getTypedModelIndex(typedModel);
		String name = QVTrelationUtil.getName(variable);
		return "t" + index  + name;
	}

	public @NonNull String createTraceInterfaceName(@NonNull Rule rule) {
		return "I" + QVTbaseUtil.getName(rule);
	}

	public @NonNull String createTraceInterfacePropertyName(@NonNull TypedModel typedModel, @NonNull VariableDeclaration variable) {
		int index = QVTbaseUtil.getTypedModelIndex(typedModel);
		String name = QVTrelationUtil.getName(variable);
		return "i" + index + name;
	}

	public @NonNull String createTraceSuccessPropertyName() {
		return TRACE_SUCCESS_PROPERTY_NAME;
	}

	public @NonNull String createWhenInvocationPropertyName(@NonNull Rule rule) {
		return "when_" + QVTbaseUtil.getName(rule);
	}

	//	public @NonNull String createWhenMappingClassName(@NonNull RelationDomain rInvokedDomain) {
	//		Relation invokedRelation = QVTbaseUtil.getContainingRelation(rInvokedDomain);
	//		return "when_" + invokedRelation.getName() + '_' + rInvokedDomain.getName();
	//	}
	/*	public @NonNull String createWhenMappingClassName(@NonNull Domain rInvokedDomain, @Nullable CallExp rInvocation) {
		Rule invokedRule = QVTbaseUtil.getContainingRule(rInvokedDomain);
		StringBuilder s = new StringBuilder();
		s.append(invokedRule.getName());
		s.append('_');
		s.append(rInvokedDomain.getName());
		s.append("_when");
		if (rInvocation != null) {
			s.append("_");
			s.append(QVTbaseUtil.getReferredRelation(rInvocation).getName());
		}
		return s.toString();
	} */

	//	public @NonNull String createWhenTraceClassName(@NonNull Relation invokingRelation, @NonNull Relation invokedRelation) {
	//		return "T" + invokingRelation.getName() + "_when_" + invokedRelation.getName();
	//	}

	//	public @NonNull String createWhereMappingClassName(@NonNull RelationDomain rInvokedDomain) {
	//		Relation invokedRelation = QVTbaseUtil.getContainingRelation(rInvokedDomain);
	//		return "where_" + invokedRelation.getName() + '_' + rInvokedDomain.getName();
	//	}
	/*	public @NonNull String createWhereMappingClassName(@NonNull Domain rInvokedDomain, @Nullable RelationCallExp rInvocation) {
		Rule invokedRule = QVTbaseUtil.getContainingRule(rInvokedDomain);
		StringBuilder s = new StringBuilder();
		s.append(invokedRule.getName());
		s.append('_');
		s.append(rInvokedDomain.getName());
		s.append("_where");
		if (rInvocation != null) {
			s.append("_");
			s.append(QVTbaseUtil.getReferredRelation(rInvocation).getName());
		}
		return s.toString();
	} */

	public @NonNull String createWhereInvocationPropertyName(@NonNull Rule rule) {
		return "where_" + QVTbaseUtil.getName(rule);
	}
}
