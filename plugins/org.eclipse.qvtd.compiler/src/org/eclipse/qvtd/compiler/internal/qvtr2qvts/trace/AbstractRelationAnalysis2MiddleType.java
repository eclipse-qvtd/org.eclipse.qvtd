/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.RuleAnalysis2MiddleType;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.RelationAnalysis;
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
abstract class AbstractRelationAnalysis2MiddleType implements RelationAnalysis2MiddleType
{
	protected final @NonNull RelationAnalysis2TraceGroup relationAnalysis2traceGroup;
	protected final @NonNull RelationAnalysis relationAnalysis;
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull RelationalTransformationAnalysis2TracePackage transformationAnalysis2tracePackage;

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
	 * The future Property that provides the global success/failure/not-ready state of the traced mapping.
	 */
	private @Nullable Element2MiddleProperty relation2globalSuccessProperty = null;

	/**
	 * The future Property that provides the local success/failure/not-ready state of the traced mapping.
	 */
	private @Nullable Element2MiddleProperty relation2localSuccessProperty = null;

	/**
	 * The future Property that provides the result of the invoked mapping.
	 */
	private @Nullable Relation2ResultProperty relation2resultProperty = null;

	protected AbstractRelationAnalysis2MiddleType(@NonNull RelationAnalysis2TraceGroup relationAnalysis2traceGroup, @NonNull String middleClassName) {
		this.relationAnalysis2traceGroup = relationAnalysis2traceGroup;
		this.relationAnalysis = relationAnalysis2traceGroup.getRuleAnalysis();
		this.scheduleManager = relationAnalysis.getScheduleManager();
		this.transformationAnalysis2tracePackage = relationAnalysis.getTransformationAnalysis2TracePackage();
		this.relation = relationAnalysis.getRule();
		this.middleClass = transformationAnalysis2tracePackage.createClass(this, middleClassName);
	}

	@Override
	public void analyzeTraceElements(@NonNull List<@NonNull HeadNodeGroup> headNodeGroups) throws CompilerChainException {}

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
			TypedModel typedModel = QVTbaseUtil.getTypedModel(domain);
			for (@NonNull VariableDeclaration rootVariable : QVTrelationUtil.getRootVariables((RelationDomain)domain)) {
				//				VariableDeclaration2TraceProperty variableDeclaration2traceProperty = basicGetVariableDeclaration2TraceProperty(rootVariable);
				//				assert variableDeclaration2traceProperty == null;
				//					VariableDeclaration2TraceProperty variableDeclaration2traceProperty = createVariableDeclaration2TraceProperty(typedModel, rootVariable, false);
				//					variable2variableDeclaration2traceProperty.put(rootVariable, variableDeclaration2traceProperty);
				createRootVariableDeclaration2TraceProperty(typedModel, rootVariable, manyTracesPerHead);

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
	public @Nullable Element2MiddleProperty basicGetRelation2GlobalSuccessProperty() {
		return relation2globalSuccessProperty;
	}

	@Override
	public @Nullable Element2MiddleProperty basicGetRelation2LocalSuccessProperty() {
		return relation2localSuccessProperty;
	}

	@Override
	public @Nullable Relation2ResultProperty basicGetRelation2ResultProperty() {
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
	public int compareTo(@NonNull RuleAnalysis2MiddleType that) {
		return ClassUtil.safeCompareTo(this.middleClass.getName(), that.getMiddleClass().getName());
	}

	public void createRelation2ResultProperty(@NonNull String nameHint) {
		assert relation2resultProperty == null;
		relation2resultProperty = new Relation2ResultProperty(this, nameHint, getRuleAnalysis2TraceGroup().getTraceInterface());
	}

	public @NonNull Element2MiddleProperty createRelation2GlobalSuccessProperty(@NonNull String nameHint) {
		assert relation2globalSuccessProperty == null;
		relation2globalSuccessProperty = new Relation2SuccessProperty(this, nameHint);
		return relation2globalSuccessProperty;
	}

	public @NonNull Element2MiddleProperty createRelation2GlobalSuccessProperty(@NonNull Property property) {
		assert relation2globalSuccessProperty == null;
		relation2globalSuccessProperty = new Relation2InheritedProperty(this, property);
		return relation2globalSuccessProperty;
	}

	public @NonNull Element2MiddleProperty createRelation2LocalSuccessProperty(@NonNull String nameHint) {
		assert relation2localSuccessProperty == null;
		relation2localSuccessProperty = new Relation2SuccessProperty(this, nameHint);
		return relation2localSuccessProperty;
	}

	public @NonNull Element2MiddleProperty createRelation2LocalSuccessProperty(@NonNull Property property) {
		assert relation2localSuccessProperty == null;
		relation2localSuccessProperty = new Relation2InheritedProperty(this, property);
		return relation2localSuccessProperty;
	}

	@Override
	public void createRootVariableDeclaration2TraceProperty(@NonNull TypedModel typedModel, @NonNull VariableDeclaration variable, boolean manyTraces) {
		//		VariableDeclaration2TraceProperty variableDeclaration2traceProperty = variable2variableDeclaration2traceProperty.get(variable);
		//		assert variableDeclaration2traceProperty == null;
		/*variableDeclaration2traceProperty =*/ createVariableDeclaration2TraceProperty(typedModel, variable, !manyTraces);
		//		variable2variableDeclaration2traceProperty.put(variable, variableDeclaration2traceProperty);
	}

	protected abstract @NonNull String createTracePropertyName(@NonNull TypedModel typedModel, @NonNull VariableDeclaration variable);

	protected @NonNull VariableDeclaration2TraceProperty createVariableDeclaration2TraceProperty(@NonNull TypedModel typedModel, @NonNull VariableDeclaration variable, boolean unitOpposite) {
		String nameHint = createTracePropertyName(typedModel, variable);
		OverrideableVariableDeclaration2TraceProperty variableDeclaration2TraceProperty = new OverrideableVariableDeclaration2TraceProperty(this, nameHint, typedModel, variable, unitOpposite);
		VariableDeclaration2TraceProperty oldVariableDeclaration2TraceProperty = variable2variableDeclaration2traceProperty.put(variable, variableDeclaration2TraceProperty);
		assert oldVariableDeclaration2TraceProperty == null;
		return variableDeclaration2TraceProperty;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getBagOfMiddleClass() {
		Class bagOfMiddleClass2 = bagOfMiddleClass;
		if (bagOfMiddleClass2 == null) {
			bagOfMiddleClass = bagOfMiddleClass2 = transformationAnalysis2tracePackage.getBagType(middleClass);
		}
		return bagOfMiddleClass2;
	}

	@Override
	public @NonNull Property getGlobalSuccessProperty() {
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

	public @NonNull Relation2ResultProperty getRelation2ResultProperty() {
		//		Relation2ResultProperty relation2resultProperty2 = relation2resultProperty;
		//		if (relation2resultProperty2 == null) {
		//			relation2resultProperty = relation2resultProperty2 = new Relation2ResultProperty(this, relationAnalysis2traceGroup.getTraceInterface());
		//		}
		//		return relation2resultProperty2;
		return ClassUtil.nonNullState(relation2resultProperty);
	}

	public @NonNull Element2MiddleProperty getRelation2GlobalSuccessProperty() {
		return ClassUtil.nonNullState(relation2globalSuccessProperty);
	}

	public @NonNull Element2MiddleProperty getRelation2LocalSuccessProperty() {
		return ClassUtil.nonNullState(relation2localSuccessProperty);
	}

	@Override
	public @NonNull Property getResultProperty() {
		return ClassUtil.nonNullState(relation2resultProperty).getTraceProperty();
	}

	@Override
	public @NonNull Relation getRule() {
		return relation;
	}

	public @NonNull RelationAnalysis2MiddleType getRule2TraceInterface() {
		return this;
	}

	@Override
	public @NonNull RelationAnalysis getRuleAnalysis() {
		return relationAnalysis;
	}

	@Override
	public @NonNull RelationAnalysis2TraceGroup getRuleAnalysis2TraceGroup() {
		return relationAnalysis2traceGroup;
	}

	//	protected abstract @Nullable RelationAnalysis2MiddleType getSuperRuleAnalysis2MiddleType();

	@Override
	public @NonNull Property getTraceProperty(@NonNull VariableDeclaration rVariable) {
		VariableDeclaration2TraceProperty variableDeclaration2traceProperty = getVariableDeclaration2TraceProperty(rVariable);
		return variableDeclaration2traceProperty.getTraceProperty();
	}

	@Override
	public @NonNull RelationalTransformationAnalysis2TracePackage getTransformation2TracePackage() {
		return transformationAnalysis2tracePackage;
	}

	public @NonNull TypedModel getTraceTypedModel() {
		return scheduleManager.getTraceTypedModel();
	}

	/*	@Override
	public @NonNull String getUniquePropertyName(@NonNull Element2MiddleProperty element2traceProperty, @NonNull String name) {
		return getRuleAnalysis2TraceGroup().getUniquePropertyName(element2traceProperty, name);
	} */

	public @NonNull Iterable<@NonNull VariableDeclaration2TraceProperty> getVariableDeclaration2TraceProperties() {
		return variable2variableDeclaration2traceProperty.values();
	}

	@Override
	public final @NonNull VariableDeclaration2TraceProperty getVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable) {
		VariableDeclaration2TraceProperty variableDeclaration2TraceProperty = basicGetVariableDeclaration2TraceProperty(variable);
		return ClassUtil.nonNullState(variableDeclaration2TraceProperty);
	}

	/*	protected void installRootVariableTraceProperties() {
		Relation overriddenRelation = QVTrelationUtil.getBaseRelation(relation);
		if (overriddenRelation != relation) {
			RelationAnalysis overriddenRelationAnalysis = relationAnalysis2traceGroup.getRuleAnalysis().getScheduleManager().getRuleAnalysis(overriddenRelation);
			RelationAnalysis2TraceGroup overriddenRelationAnalysis2TraceGroup = overriddenRelationAnalysis.getRuleAnalysis2TraceGroup();
			RelationAnalysis2TraceClass overriddenRelationAnalysis2TraceClass = overriddenRelationAnalysis2TraceGroup.getRuleAnalysis2TraceClass();
			for (@NonNull VariableDeclaration rootVariable : QVTrelationUtil.getRootVariables(relation)) {
				Variable overriddenRootVariable = QVTrelationUtil.getOverriddenVariable(overriddenRelation, rootVariable);
				OverrideableVariableDeclaration2TraceProperty overriddenVariableDeclaration2traceProperty = (OverrideableVariableDeclaration2TraceProperty) overriddenRelationAnalysis2TraceClass.basicGetVariableDeclaration2TraceProperty(overriddenRootVariable);
				assert overriddenVariableDeclaration2traceProperty != null;
				variable2variableDeclaration2traceProperty.put(rootVariable, new OverridingVariableDeclaration2TraceProperty(rootVariable, overriddenVariableDeclaration2traceProperty));
			}
		}
	} */

	@Override
	public void synthesizeTraceModel() {
		if (relation2localSuccessProperty != null) {
			relation2localSuccessProperty.getTraceProperty();
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