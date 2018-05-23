/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace.RelationalTransformation2TracePackage;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationHelper;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/**
 * A RelationAnalysis accumulates the results of analyzing a Relation and its contents.
 */
public class RelationAnalysis extends QVTrelationHelper
{
	/**
	 * The parent TransformationAnalysis.
	 */
	protected final @NonNull TransformationAnalysis transformationAnalysis;

	/**
	 * The analyzed Relation.
	 */
	protected final @NonNull Relation relation;

	/**
	 * The root variables (in relation call order).
	 */
	private @NonNull List<@NonNull Variable> rootVariables = new ArrayList<>();

	/**
	 * The expressions that call this relation.
	 */
	private @Nullable List<@NonNull RelationCallExp> incomingInvocations = null;

	/**
	 * The expressions that call this relation from a when clause.
	 */
	private @Nullable List<@NonNull RelationCallExp> incomingWhenInvocations = null;

	/**
	 * The expressions that call this relation from a where clause.
	 */
	private @Nullable List<@NonNull RelationCallExp> incomingWhereInvocations = null;

	/**
	 * The expressions that call relations with this relation.
	 */
	private @Nullable List<@NonNull RelationCallExp> outgoingInvocations = null;

	/**
	 * The expressions that call relations with this relation's when clause.
	 */
	private @Nullable List<@NonNull RelationCallExp> outgoingWhenInvocations = null;

	/**
	 * The expressions that call relations with this relation's where clause.
	 */
	private @Nullable List<@NonNull RelationCallExp> outgoingWhereInvocations = null;

	/**
	 * Closure of all overriding relations or null if not overridden.
	 */
	private @Nullable Set<@NonNull RelationAnalysis> overridingRelationAnalyses = null;

	public RelationAnalysis(@NonNull TransformationAnalysis transformationAnalysis, @NonNull Relation relation) {
		super(transformationAnalysis.getEnvironmentFactory());
		this.transformationAnalysis = transformationAnalysis;
		this.relation = relation;
	}

	private void addIncomingRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> incomingInvocations2 = incomingInvocations;
		if (incomingInvocations2 == null) {
			incomingInvocations = incomingInvocations2 = new ArrayList<>();
		}
		incomingInvocations2.add(relationInvocation);
	}

	private void addIncomingWhenRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> incomingWhenInvocations2 = incomingWhenInvocations;
		if (incomingWhenInvocations2 == null) {
			incomingWhenInvocations = incomingWhenInvocations2 = new ArrayList<>();
		}
		incomingWhenInvocations2.add(relationInvocation);
	}

	private void addIncomingWhereRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> incomingWhereInvocations2 = incomingWhereInvocations;
		if (incomingWhereInvocations2 == null) {
			incomingWhereInvocations = incomingWhereInvocations2 = new ArrayList<>();
		}
		incomingWhereInvocations2.add(relationInvocation);
	}

	private void addOutgoingRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> outgoingInvocations2 = outgoingInvocations;
		if (outgoingInvocations2 == null) {
			outgoingInvocations = outgoingInvocations2 = new ArrayList<>();
		}
		outgoingInvocations2.add(relationInvocation);
	}

	private void addOutgoingWhenRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> outgoingWhenInvocations2 = outgoingWhenInvocations;
		if (outgoingWhenInvocations2 == null) {
			outgoingWhenInvocations = outgoingWhenInvocations2 = new ArrayList<>();
		}
		outgoingWhenInvocations2.add(relationInvocation);
	}

	private void addOutgoingWhereRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> outgoingWhereInvocations2 = outgoingWhereInvocations;
		if (outgoingWhereInvocations2 == null) {
			outgoingWhereInvocations = outgoingWhereInvocations2 = new ArrayList<>();
		}
		outgoingWhereInvocations2.add(relationInvocation);
	}

	private boolean addOverridingRelation(@NonNull RelationAnalysis overridingRelationAnalysis) {
		assert overridingRelationAnalysis != this;
		Set<@NonNull RelationAnalysis> overridingRelationAnalyses2 = overridingRelationAnalyses;
		if (overridingRelationAnalyses2 == null) {
			overridingRelationAnalyses = overridingRelationAnalyses2 = new HashSet<>();
		}
		return overridingRelationAnalyses2.add(overridingRelationAnalysis);
	}

	public void analyze() {
		analyzeInvocations();
		analyzeRootVariables();
		analyzeOverriddens();
	}

	protected void analyzeInvocations() {
		for (@NonNull EObject eObject : new TreeIterable(relation, true)) {
			if (eObject instanceof RelationCallExp) {
				RelationCallExp relationInvocation = (RelationCallExp) eObject;
				Relation invokedRelation = QVTrelationUtil.getReferredRelation(relationInvocation);
				RelationAnalysis invokedRelationAnalysis = transformationAnalysis.getRelationAnalysis(invokedRelation);
				RelationAnalysis invokingRelationAnalysis = this;
				invokedRelationAnalysis.addIncomingRelation(relationInvocation);
				invokingRelationAnalysis.addOutgoingRelation(relationInvocation);
			}
		}
		Pattern whenPattern = relation.getWhen();
		if (whenPattern != null) {
			analyzeInvocations(whenPattern, true);
		}
		Pattern wherePattern = relation.getWhere();
		if (wherePattern != null) {
			analyzeInvocations(wherePattern, false);
		}
	}

	protected void analyzeInvocations(@NonNull Pattern pattern, boolean isWhen) {
		for (@NonNull Predicate predicate : QVTrelationUtil.getOwnedPredicates(pattern)) {
			OCLExpression predicateExpression = predicate.getConditionExpression();
			if (predicateExpression instanceof RelationCallExp) {
				RelationCallExp relationInvocation = (RelationCallExp) predicateExpression;
				Relation invokedRelation = QVTrelationUtil.getReferredRelation(relationInvocation);
				RelationAnalysis invokedRelationAnalysis = transformationAnalysis.getRelationAnalysis(invokedRelation);
				RelationAnalysis invokingRelationAnalysis = this;
				if (isWhen) {
					invokedRelationAnalysis.addIncomingWhenRelation(relationInvocation);
					invokingRelationAnalysis.addOutgoingWhenRelation(relationInvocation);
				}
				else {
					invokedRelationAnalysis.addIncomingWhereRelation(relationInvocation);
					invokingRelationAnalysis.addOutgoingWhereRelation(relationInvocation);
				}
			}
		}
	}

	protected void analyzeOverriddens() {
		for (Relation anOverriddenRelation = relation; anOverriddenRelation != null; anOverriddenRelation = QVTrelationUtil.basicGetOverridden(anOverriddenRelation)) {
			if (anOverriddenRelation != relation) {
				RelationAnalysis overriddenRelationAnalysis = transformationAnalysis.getRelationAnalysis(anOverriddenRelation);
				if (!overriddenRelationAnalysis.addOverridingRelation(this)) {
					break;
				}
			}
		}
	}

	protected void analyzeRootVariables() {
		for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(relation)) {
			for (@NonNull DomainPattern rDomainPattern : QVTrelationUtil.getOwnedPatterns(rDomain)) {
				TemplateExp rRootTemplateExpression = rDomainPattern.getTemplateExpression();
				if (rRootTemplateExpression != null) {
					rootVariables.add(QVTrelationUtil.getBindsTo(rRootTemplateExpression));
				}
			}
		}
	}

	public @Nullable Iterable<@NonNull RelationCallExp> getIncomingInvocations() {
		return incomingInvocations;
	}

	public @Nullable Iterable<@NonNull RelationCallExp> getIncomingWhenInvocations() {
		return incomingWhenInvocations;
	}

	public @Nullable Iterable<@NonNull RelationCallExp> getIncomingWhereInvocations() {
		return incomingWhereInvocations;
	}

	public @NonNull QVTrNameGenerator getNameGenerator() {
		return getRelationalTransformation2TracePackage().getNameGenerator();
	}

	public @Nullable Iterable<@NonNull RelationCallExp> getOutgoingInvocations() {
		return outgoingInvocations;
	}

	public @Nullable Iterable<@NonNull RelationCallExp> getOutgoingWhenInvocations() {
		return outgoingWhenInvocations;
	}

	public @Nullable Iterable<@NonNull RelationCallExp> getOutgoingWhereInvocations() {
		return outgoingWhereInvocations;
	}

	public @NonNull Relation getRelation() {
		return relation;
	}

	public @Nullable Iterable<@NonNull RelationAnalysis> getOverridingRelationAnalyses() {
		return overridingRelationAnalyses;
	}

	public @NonNull RelationalTransformation2TracePackage getRelationalTransformation2TracePackage() {
		return transformationAnalysis.getRelationalTransformation2TracePackage();
	}

	public @NonNull List<@NonNull Variable> getRootVariables() {
		return rootVariables;
	}

	public @NonNull TransformationAnalysis getTransformationAnalysis() {
		return transformationAnalysis;
	}

	@Override
	public @NonNull String toString() {
		return String.valueOf(relation);
	}

	public boolean traceIsRealized() {
		if (relation.isIsTopLevel()) {
			return true;			// tops always realize their trace
		}
		if ((relation.getOverridden() != null) || !relation.getOverrides().isEmpty()) {
			return true;			// overrides require invocation (not trace) to be passed from dispatcher.
		}
		//		if ((incomingWhenInvocations != null) && !Iterables.isEmpty(incomingWhenInvocations)) {
		//			return true;
		//		}
		return false;  // nooverrides allows trace to be passed from dispatcher.
	}
}
