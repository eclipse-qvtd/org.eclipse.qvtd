package org.eclipse.qvtd.compiler.internal.qvts2trace;

import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
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
public class NameGenerator
{
	public static final @NonNull String INVOCATIONCLASS_RESULT_PROPERTY_NAME = "result";
	public static final @NonNull String INVOCATION_GUARD_NAME = "invocationGuard";
	public static final @NonNull String IDENTIFIED_INSTANCE_VARIABLE_NAME = "identifiedInstance";
	public static final @NonNull String KEYED_INSTANCE_PROPERTY_NAME = "instance";
	public static final @NonNull String KEY2INSTANCE_VARIABLE_NAME = "key2instance";
	public static final @NonNull String TRACECLASS_PROPERTY_NAME = "trace";
	public static final @NonNull String TRACECLASS_STATUS_PROPERTY_NAME = "status";

	//	public @NonNull String createWhereTraceClassName(@NonNull Relation invokingRelation, @NonNull Relation invokedRelation) {
	//		return "T" + invokingRelation.getName() + "_where_" + invokedRelation.getName();
	//	} */

	/**
	 * Return a uniqueName for object within the name2object domain.
	 * Returns name if not already in use otherwise a numerically suffixed variant of name.
	 * In either case a new entry is added to name2object for the the returned name mapped to object.
	 */
	public static <T> @NonNull String getUniqueName(@NonNull Map<@NonNull String, T> name2object, @NonNull String name, @NonNull T object) {
		assert !name2object.containsValue(object);
		String uniqueName = name;
		int suffix = 0;
		while (name2object.get(uniqueName) != null) {
			uniqueName = name + ++suffix;
		}
		name2object.put(uniqueName, object);
		return uniqueName;
	}
	public static <T> @NonNull String getUniqueName(@NonNull Set<@NonNull String> names, @NonNull String newName) {
		String uniqueName = newName;
		int suffix = 0;
		while (names.contains(uniqueName)) {
			uniqueName = newName + ++suffix;
		}
		return uniqueName;
	}
	public static <T> @NonNull String getUniqueName(@NonNull Iterable<? extends @NonNull Nameable> nameables, @NonNull String newName) {
		String uniqueName = newName;
		int suffix = 0;
		while (NameUtil.getNameable(nameables, uniqueName) != null) {
			uniqueName = newName + ++suffix;
		}
		return uniqueName;
	}

	//	public @NonNull String createInPropertyName(@NonNull Relation relation) {
	//		return "in_" + QVTbaseUtil.getName(relation);
	//	}

	//	public @NonNull String createSignatureClassName(org.eclipse.ocl.pivot.@NonNull Class signatureClass) {
	//		return "S" + signatureClass.getName().substring(1);
	//	}
	//	public @NonNull String createSignatureClassName(@NonNull Relation relation) {
	//		return "S" + QVTbaseUtil.getName(relation);
	//	}

	public @NonNull String createInvocationClassName(@NonNull Rule rule) {
		return "WC_" + QVTbaseUtil.getName(rule);
	}

	public @NonNull String createInvocationInterfaceName(@NonNull Rule rule) {
		return "WI_" + QVTbaseUtil.getName(rule);
	}

	//	public @NonNull String createKeyFunctionName(@NonNull TypedModel rTypedModel, @NonNull Key rKey) {
	//		org.eclipse.ocl.pivot.@NonNull Class identifiedClass = QVTbaseUtil.getIdentifies(rKey);
	//		return  "Key_" + QVTbaseUtil.getName(rTypedModel) + "_" + QVTbaseUtil.getName(identifiedClass);
	//	}

	//	public @NonNull String createKey2InstanceClassName(org.eclipse.ocl.pivot.@NonNull Class identifiedClass) {
	//		return "Key2" + identifiedClass.getName();
	//	}

	//	public @NonNull String createKey2InstanceMappingName(org.eclipse.ocl.pivot.@NonNull Class identifiedClass, @NonNull TypedModel typedModel) {
	//		String enforcedDomainName = ClassUtil.nonNullState(typedModel.getName());
	//		return "Key2" + identifiedClass.getName() + "_" + enforcedDomainName;
	//	}

	public @NonNull String createKeyedVariableName(@NonNull Variable identifiedVariable) {
		return QVTbaseUtil.getName(identifiedVariable) + "_key";
	}

	public @NonNull String createMappingName(@NonNull Relation rule, @NonNull QVTuConfiguration qvtuConfiguration) {
		StringBuilder s = new StringBuilder();
		s.append(PivotUtil.getName(rule));
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
		return "TC_" + QVTbaseUtil.getName(rule);
	}

	public @NonNull String createTraceInterfaceName(@NonNull Rule rule) {
		return "TI_" + QVTbaseUtil.getName(rule);
	}

	public @NonNull String createTracePropertyName(@NonNull VariableDeclaration variable) {
		return /*"t_" +*/ QVTbaseUtil.getName(variable);
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
