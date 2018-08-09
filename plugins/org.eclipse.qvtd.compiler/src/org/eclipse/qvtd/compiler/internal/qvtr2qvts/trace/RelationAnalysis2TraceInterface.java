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
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.HeadNodeGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.QVTrelationNameGenerator;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * A RelationAnalysis2TraceInterface supervises the creation of a trace interface for the base relation
 * in an override hierarchy.
 *
 * The trace interface provides a trace property for each root variable.
 *
 * RelationAnalysis2TraceInterface instances do not form a polymorphic hierarchy mirroring the relation
 * override hierarchy since mirroring a N-deep hierarchy would require N copies of each root variable,
 * one for each potentially distinct relation root variable type. THe minimal two level hierarchy comprising
 * a root relation interface and a concrete relation class minimises the overheads while retaining navigability.
 */
public class RelationAnalysis2TraceInterface extends AbstractRelationAnalysis2MiddleType
{
	/**
	 * Name to corresponding future trace property
	 */
	private final @NonNull Map<@NonNull String, /*@NonNull*/ Element2MiddleProperty> name2element2traceProperty = new HashMap<>();

	public RelationAnalysis2TraceInterface(@NonNull RelationAnalysis2TraceGroup relationAnalysis2traceGroup, @NonNull String middleClassName) {
		super(relationAnalysis2traceGroup, middleClassName);
		middleClass.setIsAbstract(true);
	}

	@Override
	public void analyzeTraceElements(@NonNull List<@NonNull HeadNodeGroup> headNodeGroups) throws CompilerChainException {
		//
		// The AbstractTrace clast is the superclass.
		//
		middleClass.getSuperClasses().add(getTransformation2TracePackage().getExecutionClass());
		//
		// There is always a trace interface success
		//
		createRelation2GlobalSuccessProperty(relationAnalysis2traceGroup.getNameGenerator().createTraceGlobalSuccessPropertyName());
		//
		//	No result property.
		//
		//
		//	One trace property per root variable.
		//
		if (!QVTrelationUtil.hasOverrides(relation)) {
			analyzeRootTemplateVariables(headNodeGroups);
		}
	}

	@Override
	protected @NonNull String createTracePropertyName(@NonNull TypedModel typedModel, @NonNull VariableDeclaration variable) {
		return getTransformation2TracePackage().getNameGenerator().createTraceInterfacePropertyName(typedModel, variable);
	}

	@Override
	public @NonNull String getUniquePropertyName(@NonNull Element2MiddleProperty element2traceProperty, @NonNull String name) {
		return QVTrelationNameGenerator.getUniqueName(name2element2traceProperty, name, element2traceProperty);
	}
}