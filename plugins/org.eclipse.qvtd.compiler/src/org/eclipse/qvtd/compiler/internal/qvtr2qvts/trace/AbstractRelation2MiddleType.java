/*******************************************************************************
 * Copyright (c) 2017, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.HeadNodeGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Rule2MiddleType;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Transformation2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.QVTrelationNameGenerator;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * An AbstractRelation2MiddleType represents the mapping between a QVTr Relation and the trace class for an invoked QVTc Mapping.
 * Derived classes adjust the behaviour for a directly invoked relation or a dispatch of a set of overrides.
 */
abstract class AbstractRelation2MiddleType implements Relation2MiddleType
{
	protected final @NonNull Relation2TraceGroup relation2traceGroup;
	protected final @NonNull ScheduleManager scheduleManager;

	protected final @NonNull Transformation2TracePackage transformation2tracePackage;

	/**
	 * The relation to be mapped to a trace class and mapping.
	 */
	protected final @NonNull Relation relation;

	/**
	 * The Class that realizes the trace class.
	 */
	protected final org.eclipse.ocl.pivot.@NonNull Class middleClass;
	/**
	 * Lazily created null-free Bag of traceClass.
	 */
	private org.eclipse.ocl.pivot.@Nullable Class bagOfMiddleClass = null;

	private final @NonNull Map<@NonNull VariableDeclaration, @NonNull VariableDeclaration2TraceProperty> variable2variableDeclaration2traceProperty = new HashMap<>();

	/**
	 * The future Property that provides the dispatch success/failure/not-ready state of the traced mapping.
	 */
	private @Nullable Relation2SuccessProperty relation2dispatchSuccessProperty = null;
	private boolean frozenRelation2dispatchSuccessProperty = false;			// True once the presence/absence has been tested

	/**
	 * The future Property that provides the global success/failure/not-ready state of the traced mapping.
	 */
	private @Nullable Relation2SuccessProperty relation2globalSuccessProperty = null;
	private boolean frozenRelation2globalSuccessProperty = false;			// True once the presence/absence has been tested

	/**
	 * The future Property that provides the local success/failure/not-ready state of the traced mapping.
	 */
	private @Nullable Relation2SuccessProperty relation2localSuccessProperty = null;
	private boolean frozenRelation2localSuccessProperty = false;			// True once the presence/absence has been tested

	/**
	 * The future Property that provides the result of the invoked mapping.
	 */
	private @Nullable Relation2ResultProperty relation2resultProperty = null;
	private boolean frozenRelation2resultProperty = false;					// True once the presence/absence has been tested

	protected AbstractRelation2MiddleType(@NonNull Relation2TraceGroup relation2traceGroup, @NonNull String middleClassName) {
		this.relation2traceGroup = relation2traceGroup;
		this.scheduleManager = relation2traceGroup.getScheduleManager();
		this.transformation2tracePackage = relation2traceGroup.getTransformation2TracePackage();
		this.relation = relation2traceGroup.getRule();
		this.middleClass = transformation2tracePackage.createClass(this, middleClassName);
		assert scheduleManager.getMultipleScheduleManager() == scheduleManager;
	}

	@Override
	public void analyzeTraceElements(@NonNull List<@NonNull HeadNodeGroup> headNodeGroups, @NonNull RuleAnalysis ruleAnalysis) throws CompilerChainException {}

	protected void analyzeRootTemplateVariables(@NonNull List<@NonNull HeadNodeGroup> headNodeGroups) {
		//
		//	For the common case of one input head and one output head, there is a one-to-one-to-one
		//	relationship between input-head, trace and output-head instances.
		//
		//	For the alternate case of more than two domains, or more than two heads per domain, there may be
		//	multiple trace instances per head instance.
		//
		//	The degenerate case of multiple heads and only one domain is not interesting.
		//
		boolean manyTracesPerHead = headNodeGroups.size() > 2;
		//
		//	Prepare a trace property for each root variable.
		//
		for (@NonNull Domain domain : QVTbaseUtil.getOwnedDomains(relation)) {
			TypedModel typedModel = domain.getTypedModel();
			for (@NonNull VariableDeclaration rootVariable : QVTrelationUtil.getRootVariables((RelationDomain)domain)) {
				//				VariableDeclaration2TraceProperty variableDeclaration2traceProperty = basicGetVariableDeclaration2TraceProperty(rootVariable);
				//				assert variableDeclaration2traceProperty == null;
				//					VariableDeclaration2TraceProperty variableDeclaration2traceProperty = createVariableDeclaration2TraceProperty(typedModel, rootVariable, false);
				//					variable2variableDeclaration2traceProperty.put(rootVariable, variableDeclaration2traceProperty);
				getRootVariableDeclaration2TraceProperty(typedModel, rootVariable, manyTracesPerHead);

				//				}
			}
		}
		//		for (@NonNull Domain rDomain : QVTbaseUtil.getOwnedDomains(rule)) {
		//			TypedModel rTypedModel = rDomain.getTypedModel();
		//			for (@NonNull DomainPattern rDomainPattern : QVTrelationUtil.getOwnedPatterns(rDomain)) {
		//				TemplateExp rTemplateExp = QVTrelationUtil.getOwnedTemplateExpression(rDomainPattern);
		//				Variable bindsTo = QVTrelationUtil.getBindsTo(rTemplateExp);
		//				createRootVariableDeclaration2TraceProperty(rTypedModel, bindsTo, manyTraces);
		//			}
		//		}
		//		if (!relation.isIsTopLevel()) {
		//			getRelation2TraceProperty();
		//		}
	}

	@Override
	public @Nullable Relation2SuccessProperty basicGetRelation2DispatchSuccessProperty() {
		frozenRelation2dispatchSuccessProperty = true;
		return relation2dispatchSuccessProperty;
	}

	@Override
	public @Nullable Relation2SuccessProperty basicGetRelation2GlobalSuccessProperty() {
		frozenRelation2globalSuccessProperty = true;
		return relation2globalSuccessProperty;
	}

	@Override
	public @Nullable Relation2SuccessProperty basicGetRelation2LocalSuccessProperty() {
		frozenRelation2localSuccessProperty = true;
		return relation2localSuccessProperty;
	}

	@Override
	public @Nullable Relation2ResultProperty basicGetRelation2ResultProperty() {
		frozenRelation2resultProperty = true;
		return relation2resultProperty;
	}

	@Override
	public @Nullable Property basicGetTraceProperty(@NonNull VariableDeclaration rVariable) {
		VariableDeclaration2TraceProperty variableDeclaration2traceProperty = basicGetVariableDeclaration2TraceProperty(rVariable);
		if (variableDeclaration2traceProperty == null) {
			return null;
		}
		return variableDeclaration2traceProperty.getTraceProperty();
	}

	@Override
	public @Nullable VariableDeclaration2TraceProperty basicGetVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable) {
		return variable2variableDeclaration2traceProperty.get(variable);
	}

	@Override
	public int compareTo(@NonNull Rule2MiddleType that) {
		return ClassUtil.safeCompareTo(this.middleClass.getName(), that.getMiddleClass().getName());
	}

	protected abstract @NonNull String createTracePropertyName(@Nullable TypedModel typedModel, @NonNull VariableDeclaration variable);

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getBagOfMiddleClass() {
		Class bagOfMiddleClass2 = bagOfMiddleClass;
		if (bagOfMiddleClass2 == null) {
			bagOfMiddleClass = bagOfMiddleClass2 = transformation2tracePackage.getBagType(middleClass);
		}
		return bagOfMiddleClass2;
	}

	@Override
	public @NonNull Property getDispatchSuccessProperty() {		// FIXME the resolution in super classes requires an earlier getRelation2DispatchSuccessProperty
		return ClassUtil.nonNullState(basicGetRelation2DispatchSuccessProperty()).getTraceProperty();
	}

	@Override
	public @NonNull Property getGlobalSuccessProperty() {		// FIXME the resolution in super classes requires an earlier getRelation2GlobalSuccessProperty
		return ClassUtil.nonNullState(basicGetRelation2GlobalSuccessProperty()).getTraceProperty();
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getMiddleClass() {
		return middleClass;
	}

	@Override
	public @NonNull String getName() {
		return QVTrelationUtil.getName(relation);
	}

	public @NonNull Relation2SuccessProperty getRelation2DispatchSuccessProperty() {
		Relation2SuccessProperty relation2dispatchSuccessProperty2 = relation2dispatchSuccessProperty;
		if (relation2dispatchSuccessProperty2 == null) {
			assert !frozenRelation2dispatchSuccessProperty;
			//	org.eclipse.ocl.pivot.Class dispatchClass = getTransformation2TracePackage().getDispatchClass();
			//	Property dispatchSuccessProperty = NameUtil.getNameable(QVTbaseUtil.getOwnedProperties(dispatchClass), QVTrelationNameGenerator.TRACE_DISPATCH_SUCCESS_PROPERTY_NAME);
			//	assert dispatchSuccessProperty != null;
			//	relation2dispatchSuccessProperty = relation2dispatchSuccessProperty2 = new Relation2InheritedProperty(this, dispatchSuccessProperty);
			relation2dispatchSuccessProperty = relation2dispatchSuccessProperty2 = getRelation2GlobalSuccessProperty();
		}
		return relation2dispatchSuccessProperty2;
	}

	@Override
	public @NonNull Relation2SuccessProperty getRelation2GlobalSuccessProperty() {
		Relation2SuccessProperty relation2globalSuccessProperty2 = relation2globalSuccessProperty;
		if (relation2globalSuccessProperty2 == null) {
			assert !frozenRelation2globalSuccessProperty;
			QVTrelationNameGenerator nameGenerator = relation2traceGroup.getNameGenerator();
			String globalSuccessPropertyName = nameGenerator.createTraceGlobalSuccessPropertyName();
			relation2globalSuccessProperty = relation2globalSuccessProperty2 = new Relation2SuccessProperty(this, globalSuccessPropertyName);
		}
		return relation2globalSuccessProperty2;
	}

	@Override
	public @NonNull Relation2SuccessProperty getRelation2LocalSuccessProperty() {
		Relation2SuccessProperty relation2localSuccessProperty2 = relation2localSuccessProperty;
		if (relation2localSuccessProperty2 == null) {
			assert !frozenRelation2localSuccessProperty;
			QVTrelationNameGenerator nameGenerator = relation2traceGroup.getNameGenerator();
			String localSuccessPropertyName = nameGenerator.createTraceLocalSuccessPropertyName();
			relation2localSuccessProperty = relation2localSuccessProperty2 = new Relation2SuccessProperty(this, localSuccessPropertyName);
		}
		return relation2localSuccessProperty2;
	}

	public @NonNull Relation2ResultProperty getRelation2ResultProperty() {
		Relation2ResultProperty relation2resultProperty2 = relation2resultProperty;
		if (relation2resultProperty2 == null) {
			assert !frozenRelation2resultProperty;
			QVTrelationNameGenerator nameGenerator = relation2traceGroup.getNameGenerator();
			String resultPropertyName = nameGenerator.createDispatchClassResultPropertyName();
			relation2resultProperty = relation2resultProperty2 = new Relation2ResultProperty(this, resultPropertyName, relation2traceGroup.getTraceInterface());
		}
		return relation2resultProperty2;
	}

	@Override
	public @NonNull Property getResultProperty() {
		return ClassUtil.nonNullState(relation2resultProperty).getTraceProperty();
	}

	@Override
	public void getRootVariableDeclaration2TraceProperty(@Nullable TypedModel typedModel, @NonNull VariableDeclaration variable, boolean manyTraces) {
		//		VariableDeclaration2TraceProperty variableDeclaration2traceProperty = variable2variableDeclaration2traceProperty.get(variable);
		//		assert variableDeclaration2traceProperty == null;
		/*variableDeclaration2traceProperty =*/ getVariableDeclaration2TraceProperty(typedModel, variable, !manyTraces);
		//		variable2variableDeclaration2traceProperty.put(variable, variableDeclaration2traceProperty);
	}

	@Override
	public @NonNull Relation getRule() {
		return relation;
	}

	public @NonNull Relation2MiddleType getRule2TraceInterface() {
		return this;
	}

	@Override
	public @NonNull Relation2TraceGroup getRule2TraceGroup() {
		return relation2traceGroup;
	}

	@Override
	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	//	protected abstract @Nullable Relation2MiddleType getSuperRule2MiddleType();

	@Override
	public @NonNull Property getTraceProperty(@NonNull VariableDeclaration rVariable) {
		VariableDeclaration2TraceProperty variableDeclaration2traceProperty = getVariableDeclaration2TraceProperty(rVariable);
		return variableDeclaration2traceProperty.getTraceProperty();
	}

	@Override
	public @NonNull RelationalTransformation2TracePackage getTransformation2TracePackage() {
		return (RelationalTransformation2TracePackage) transformation2tracePackage;
	}

	public @NonNull TypedModel getTraceTypedModel() {
		return scheduleManager.getTraceTypedModel();
	}

	/*	@Override
	public @NonNull String getUniquePropertyName(@NonNull Element2MiddleProperty element2traceProperty, @NonNull String name) {
		return getRule2TraceGroup().getUniquePropertyName(element2traceProperty, name);
	} */

	public @NonNull Iterable<@NonNull VariableDeclaration2TraceProperty> getVariableDeclaration2TraceProperties() {
		return variable2variableDeclaration2traceProperty.values();
	}

	@Override
	public final @NonNull VariableDeclaration2TraceProperty getVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable) {
		VariableDeclaration2TraceProperty variableDeclaration2TraceProperty = basicGetVariableDeclaration2TraceProperty(variable);
		return ClassUtil.nonNullState(variableDeclaration2TraceProperty);
	}

	public @NonNull VariableDeclaration2TraceProperty getVariableDeclaration2TraceProperty(@Nullable TypedModel typedModel, @NonNull VariableDeclaration variable, boolean unitOpposite) {
		VariableDeclaration2TraceProperty variableDeclaration2TraceProperty = variable2variableDeclaration2traceProperty.get(variable);
		if (variableDeclaration2TraceProperty == null) {
			String nameHint = createTracePropertyName(typedModel, variable);
			variableDeclaration2TraceProperty = new OverrideableVariableDeclaration2TraceProperty(this, nameHint, typedModel, variable, unitOpposite);
			variable2variableDeclaration2traceProperty.put(variable, variableDeclaration2TraceProperty);
		}
		else {
			assert variableDeclaration2TraceProperty instanceof OverrideableVariableDeclaration2TraceProperty;
			assert variableDeclaration2TraceProperty.getTypedModel() == typedModel;
			assert ((OverrideableVariableDeclaration2TraceProperty)variableDeclaration2TraceProperty).isUnitOpposite() == unitOpposite;
		}
		return variableDeclaration2TraceProperty;
	}

	/*	protected void installRootVariableTraceProperties() {
		Relation overriddenRelation = QVTrelationUtil.getBaseRelation(relation);
		if (overriddenRelation != relation) {
			RelationAnalysis overriddenRelationAnalysis = relation2traceGroup.getRuleAnalysis().getScheduleManager().getRuleAnalysis(overriddenRelation);
			relation2traceGroup overriddenrelation2traceGroup = overriddenRelationAnalysis.getRule2TraceGroup();
			Relation2TraceClass overriddenRelation2TraceClass = overriddenrelation2traceGroup.getRule2TraceClass();
			for (@NonNull VariableDeclaration rootVariable : QVTrelationUtil.getRootVariables(relation)) {
				Variable overriddenRootVariable = QVTrelationUtil.getOverriddenVariable(overriddenRelation, rootVariable);
				OverrideableVariableDeclaration2TraceProperty overriddenVariableDeclaration2traceProperty = (OverrideableVariableDeclaration2TraceProperty) overriddenRelation2TraceClass.basicGetVariableDeclaration2TraceProperty(overriddenRootVariable);
				assert overriddenVariableDeclaration2traceProperty != null;
				variable2variableDeclaration2traceProperty.put(rootVariable, new OverridingVariableDeclaration2TraceProperty(rootVariable, overriddenVariableDeclaration2traceProperty));
			}
		}
	} */

	@Override
	public void synthesizeTraceModel(@NonNull RuleAnalysis ruleAnalysis) {
		if (relation2localSuccessProperty != null) {
			relation2localSuccessProperty.getTraceProperty();
		}
		if (relation2dispatchSuccessProperty != null) {
			relation2dispatchSuccessProperty.getTraceProperty();
		}
		if (relation2globalSuccessProperty != null) {
			relation2globalSuccessProperty.getTraceProperty();
		}
		if (relation2resultProperty != null) {
			relation2resultProperty.getTraceProperty();
		}
		//
		//	Create a trace property for each prepared trace property.
		//
		for (@NonNull VariableDeclaration2TraceProperty variableDeclaration2traceProperty : variable2variableDeclaration2traceProperty.values()) {
			@SuppressWarnings("unused")
			@NonNull Property traceProperty = variableDeclaration2traceProperty.synthesizeTraceModel();
		}
		CompilerUtil.normalizeNameables(QVTrelationUtil.Internal.getOwnedPropertiesList(middleClass));
	}

	@Override
	public @NonNull String toString() {
		return String.valueOf(middleClass.getName());
	}
}