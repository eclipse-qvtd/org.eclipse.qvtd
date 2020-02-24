/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.HeadNodeGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.QVTrelationNameGenerator;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

/**
 * A Relation2WrapperClass supervises the creation of multiple traces to bridge the gap
 * from declared root variables to actula head variables.
 */
public class Relation2WrapperClass extends AbstractRelation2MiddleType
{
	/**
	 * Name to corresponding future trace property
	 */
	private final @NonNull Map<@NonNull String, /*@NonNull*/ Element2MiddleProperty> name2element2traceProperty = new HashMap<>();

	private final @NonNull Map<@NonNull VariableDeclaration, @NonNull Node> rootVariable2headNode;

	/**
	 * The future Property that provides the result of the invoked mapping.
	 */
	private @Nullable Relation2ResultProperty relation2doesProperty = null;
	private boolean frozenRelation2doesProperty = false;					// True once the presence/absence has been tested

	public Relation2WrapperClass(@NonNull Relation2TraceGroup relation2traceGroup, @NonNull String middleClassName,
			@NonNull Map<@NonNull VariableDeclaration, @NonNull Node> rootVariable2headNode) {
		super(relation2traceGroup, middleClassName);
		//		middleClass.setIsAbstract(true);
		this.rootVariable2headNode = rootVariable2headNode;
	}

	@Override
	public void analyzeTraceElements(@NonNull List<@NonNull HeadNodeGroup> headNodeGroups, @NonNull RuleAnalysis ruleAnalysis) throws CompilerChainException {
		//
		// The AbstractTrace clast is the superclass.
		//
		middleClass.getSuperClasses().add(getTransformation2TracePackage().getExecutionClass());
		//
		//
		//
		//	QVTrelationNameGenerator nameGenerator = relation2traceGroup.getNameGenerator();
		//	for (@NonNull VariableDeclaration rootVariable : rootVariable2headNode.keySet()) {
		//		Node node = rootVariable2headNode.get(rootVariable);
		//		assert node != null;
		//	createTracePropertyName(outgoingWhereInvocationAnalysis);
		//	createVariableDeclaration2TraceProperty(node, rootVariables, allHeadGroupNodes, manyTracesPerHead);
		//		getVariableDeclaration2TraceProperty(node.getClassDatum().getReferredTypedModel(), rootVariable, false/*unitOpposite*/);
		//	}
		//
		//	No result property.
		//
		getRelation2DoesProperty();
		//
		//	One trace property per root variable.
		//
		analyzeRootTemplateVariables(headNodeGroups);
		//
		//	One trace property per root variable.
		//
		//	if (!QVTrelationUtil.hasOverrides(relation)) {
		//		analyzeRootTemplateVariables(headNodeGroups);
		//	}
	}

	@Override
	protected @NonNull String createTracePropertyName(@Nullable TypedModel typedModel, @NonNull VariableDeclaration variable) {
		return getTransformation2TracePackage().getNameGenerator().createWrapperClassPropertyName(typedModel, variable);
	}

	public @NonNull Relation2ResultProperty getRelation2DoesProperty() {
		Relation2ResultProperty relation2doesProperty2 = relation2doesProperty;
		if (relation2doesProperty2 == null) {
			assert !frozenRelation2doesProperty;
			QVTrelationNameGenerator nameGenerator = relation2traceGroup.getNameGenerator();
			String resultPropertyName = "does"; //nameGenerator.createDispatchClassResultPropertyName();
			relation2doesProperty = relation2doesProperty2 = new Relation2ResultProperty(this, resultPropertyName, relation2traceGroup.getTraceInterface());
		}
		return relation2doesProperty2;
	}

	@Override
	public @NonNull String getUniquePropertyName(@NonNull Element2MiddleProperty element2traceProperty, @NonNull String name) {
		return QVTrelationNameGenerator.getUniqueName(name2element2traceProperty, name, element2traceProperty);
	}

	@Override
	public void synthesizeTraceModel(@NonNull RuleAnalysis ruleAnalysis) {
		super.synthesizeTraceModel(ruleAnalysis);
		if (relation2doesProperty != null) {
			relation2doesProperty.getTraceProperty();
		}
	}
}