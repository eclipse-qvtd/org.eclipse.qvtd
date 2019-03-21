/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2MiddleType;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

/**
 * An AbstractWhenInvocationAnalysis identifies the invocation of one Relation from the when clause of another.
 */
public abstract class AbstractWhenInvocationAnalysis extends AbstractInvocationAnalysis
{
	public AbstractWhenInvocationAnalysis(@NonNull RelationAnalysis invokingRelationAnalysis, @NonNull RelationAnalysis invokedRelationAnalysis) {
		super(invokingRelationAnalysis, invokedRelationAnalysis);
	}

	@Override
	protected void createGlobalSuccessNodeAndEdge(@NonNull Node invokedNode) {
		RelationAnalysis2MiddleType invokedRelationAnalysis2InvocationInterface = getInvokedRelationAnalysis2InvocationInterface();
		Element2MiddleProperty relation2globalSuccessProperty = invokedRelationAnalysis2InvocationInterface.basicGetRelation2GlobalSuccessProperty();
		if (relation2globalSuccessProperty != null) {
			Property globalSuccessProperty = relation2globalSuccessProperty.getTraceProperty();
			invokingRelationAnalysis.createPredicatedSuccess(invokedNode, globalSuccessProperty, true);
		}
	}

	@Override
	protected @NonNull Node createInvocationNode(@NonNull Node invokingTraceNode) {
		QVTrelationNameGenerator nameGenerator = scheduleManager.getNameGenerator();	// FIXME unique names
		Relation invokedRelation = invokedRelationAnalysis.getRule();
		String name = nameGenerator.createWhenInvocationPropertyName(invokedRelation);
		ClassDatum classDatum = getInvokedClassDatum();
		boolean isMatched = isMatched();
		return invokingRelationAnalysis.createPredicatedNode(name, classDatum, isMatched);
	}

	@Override
	protected void createInvokingTraceEdge(@NonNull Node invokedNode, @NonNull Node invokingTraceNode) {
		Relation invokingRelation = invokingRelationAnalysis.getRule();
		if (invokingRelation.isIsTopLevel()) {
			super.createInvokingTraceEdge(invokedNode, invokingTraceNode);
		}
	}

	@Override
	public final boolean isWhen() {
		return true;
	}
}