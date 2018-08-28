/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.TransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsageAnalysis;

import com.google.common.collect.Lists;

/**
 * RelationalTransformation2TracePackage performs the first part of the QVTr2QVTc transformation.
 * This involves synthesis of the QVTc middle model that defines the middle classes.
 *
 * A trace class records the progress of a relation execution.
 *
 * Additionally a signature class for each non-top relation mediates between invoking and invoked relations.
 */
public abstract class TransformationAnalysis2TracePackage //extends QVTbaseHelper
{
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull NameGenerator nameGenerator;
	protected final @NonNull TransformationAnalysis transformationAnalysis;
	protected final @NonNull Transformation transformation;
	private final org.eclipse.ocl.pivot.@NonNull Package tracePackage;

	/**
	 * The "Speculatable" class to be added to the trace package.
	 */
	//	private org.eclipse.ocl.pivot.@Nullable Class speculatableClass = null;

	/**
	 * The "Speculation" class to be added to the trace package.
	 */
	//	private org.eclipse.ocl.pivot.@Nullable Class speculationClass = null;

	/**
	 * Name to corresponding trace class
	 */
	protected final @NonNull Map<@NonNull String, @NonNull RuleAnalysis2MiddleType> name2ruleAnalysis2middleType = new HashMap<>();

	/**
	 * Map of relation to trace classes.
	 */
	protected final @NonNull Map<@NonNull Rule, @NonNull RuleAnalysis2TraceGroup> rule2relationAnalysis2traceGroup = new HashMap<>();

	private @NonNull Map<@NonNull Type, @NonNull RuleAnalysis2MiddleType> middleClass2ruleAnalysis2middleType = new HashMap<>();

	private boolean frozen = false;


	static class OverrideDepthComparator implements Comparator<@NonNull RuleAnalysis2TraceGroup>
	{
		public static final @NonNull OverrideDepthComparator INSTANCE = new OverrideDepthComparator();

		@Override
		public int compare(@NonNull RuleAnalysis2TraceGroup o1, @NonNull RuleAnalysis2TraceGroup o2) {
			int d1 = getDepth(o1);
			int d2 = getDepth(o2);
			if (d1 != d2) {
				return d1 - d2;
			}
			String n1 = o1.getName();
			String n2 = o2.getName();
			return n1.compareTo(n2);
		}

		private int getDepth(@NonNull RuleAnalysis2TraceGroup ruleAnalysis2TraceGroup) {
			int depth = 0;
			for (Rule aRule = ruleAnalysis2TraceGroup.getRule(); (aRule = aRule.getOverridden()) != null; ) {
				depth++;
			}
			return depth;
		}
	}

	/**
	 * Map of invocation to trace classes.
	 */
	//	protected final @NonNull Map<@NonNull RelationCallExp, @NonNull List<Relation2TraceClass.@NonNull Internal>> invocation2relation2traceClasses = new HashMap<>();

	protected TransformationAnalysis2TracePackage(@NonNull ScheduleManager scheduleManager, @NonNull TransformationAnalysis transformationAnalysis) {
		//		super(scheduleManager.getEnvironmentFactory());
		this.scheduleManager = scheduleManager;
		this.nameGenerator = scheduleManager.getNameGenerator();
		this.transformationAnalysis = transformationAnalysis;
		this.transformation = transformationAnalysis.getTransformation();
		this.tracePackage = createTracePackage();
	}

	/*	protected void addInvocation2TraceClass(@NonNull RelationCallExp rInvocation, Relation2TraceClass.@NonNull Internal invocation2traceClass) {
		List<Relation2TraceClass.@NonNull Internal> traceClasses = invocation2relation2traceClasses.get(rInvocation);
		if (traceClasses == null) {
			traceClasses = new ArrayList<>();
			invocation2relation2traceClasses.put(rInvocation, traceClasses);
		}
		assert !traceClasses.contains(invocation2traceClass);
		traceClasses.add(invocation2traceClass);
	} */

	//	public org.eclipse.ocl.pivot.@Nullable Class basicGetSignatureClass(@NonNull Relation rRelation) {
	//		return getRelation2SignatureClass(rRelation).basicGetSignatureClass();
	//	}

	public void analyzeTraceElements() throws CompilerChainException {
		for (@NonNull RuleAnalysis2TraceGroup relationAnalysis2traceGroup : getOrderedRuleAnalysis2TraceGroups()) {
			relationAnalysis2traceGroup.analyzeTraceElements();
		}
	}

	public @Nullable Property basicGetTraceProperty(@NonNull Type aClass, @NonNull VariableDeclaration rVariable) {
		RuleAnalysis2MiddleType relation2TraceClass = middleClass2ruleAnalysis2middleType.get(aClass);
		if (relation2TraceClass == null) {
			return null;
		}
		return relation2TraceClass.basicGetTraceProperty(rVariable);
		//		String name = QVTrelationUtil.getName(rVariable);
		//		CompleteClass completeClass = getCompleteClass(aClass);
		//		return completeClass.getProperty(name);
	}

	public org.eclipse.ocl.pivot.@NonNull Class createClass(@NonNull RuleAnalysis2MiddleType ruleAnalysis2middleType, @NonNull String className) {
		List<org.eclipse.ocl.pivot.@NonNull Class> traceClasses = QVTbaseUtil.Internal.getOwnedClassesList(tracePackage);
		String uniqueName = NameGenerator.getUniqueName(name2ruleAnalysis2middleType, className, ruleAnalysis2middleType);
		org.eclipse.ocl.pivot.Class traceClass = PivotUtil.createClass(uniqueName);
		traceClasses.add(traceClass);
		middleClass2ruleAnalysis2middleType.put(traceClass, ruleAnalysis2middleType);
		name2ruleAnalysis2middleType.put(uniqueName, ruleAnalysis2middleType);
		return traceClass;
	}

	public void createRuleAnalysis2TraceGroups() {
		for (@NonNull Rule rule : QVTbaseUtil.getOwnedRules(transformation)) {
			RuleAnalysis ruleAnalysis = transformationAnalysis.getRuleAnalysis(rule);
			RuleAnalysis2TraceGroup relationAnalysis2traceGroup = scheduleManager.createRuleAnalysis2TraceGroup(ruleAnalysis);
			RuleAnalysis2TraceGroup oldRelationAnalysis2traceGroup = rule2relationAnalysis2traceGroup.put(rule, relationAnalysis2traceGroup);
			assert oldRelationAnalysis2traceGroup == null;
		}
	}

	/**
	 * Build the inter-Relation2TraceClass dependencies.
	 *
	protected void createDependencies() throws CompilerChainException {
		List<@NonNull Relation2TraceClass> relation2traceClasses = Lists.newArrayList(Iterables.filter(name2relation2middleType.values(), Relation2TraceClass.class));
		Collections.sort(relation2traceClasses);
		//
		//	Establish the Relation2TraceClass directly consumes Relation2TraceClass dependencies
		//
		for (@NonNull Relation2TraceClass relation2traceClass : relation2traceClasses) {
			relation2traceClass.installConsumesDependencies();
		}
		//
		//	Identify the dependency cycles
		//
		//		for (@NonNull Relation2TraceClass relation2TraceClass : relation2TraceClasses2) {
		//			relation2TraceClass.installDependencyCycles();
		//		}
		//
		//	Display the dependencies
		//
		if (QVTr2QVTc.CALL_TREE.isActive()) {
			StringBuilder s = new StringBuilder();
			for (@NonNull Relation2TraceClass relation2traceClass : relation2traceClasses) {
				s.append("\n\t" + relation2traceClass.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Relation2TraceClass> consumedRule2TraceGroup = Lists.newArrayList(relation2traceClass.getConsumedRule2TraceGroup());
				Collections.sort(consumedRule2TraceGroup);;
				for (@NonNull Relation2TraceClass consumedRelation2TraceClass : consumedRule2TraceGroup) {
					if (!isFirst) {
						s.append(",");
					}
					s.append(consumedRelation2TraceClass.toString());
					isFirst = false;
				}
				s.append(")");
			}
			QVTr2QVTc.CALL_TREE.println("traceClass(directlyConsumedTraceClasses)" + s.toString());
		}
		if (QVTr2QVTc.CALL_TREE.isActive()) {
			StringBuilder s = new StringBuilder();
			for (@NonNull Relation2TraceClass relation2traceClass : relation2traceClasses) {
				s.append("\n\t" + relation2traceClass.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Relation2TraceClass> consumedRule2TraceGroup = new ArrayList<>(relation2traceClass.getTransitivelyConsumedRule2TraceGroup());
				Collections.sort(consumedRule2TraceGroup);;
				for (@NonNull Relation2TraceClass consumedRelation2TraceClass : consumedRule2TraceGroup) {
					if (!isFirst) {
						s.append(",");
					}
					s.append(consumedRelation2TraceClass.toString());
					isFirst = false;
				}
				s.append(")");
			}
			QVTr2QVTc.CALL_TREE.println("traceClass(transitivelyConsumedTraceClasses)" + s.toString());
		}
		if (QVTr2QVTc.CALL_TREE.isActive()) {
			StringBuilder s = new StringBuilder();
			for (@NonNull Relation2TraceClass relation2traceClass : relation2traceClasses) {
				s.append("\n\t" + relation2traceClass.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Relation2TraceClass> consumedByRule2TraceGroup = Lists.newArrayList(relation2traceClass.getConsumedByRule2TraceGroup());
				Collections.sort(consumedByRule2TraceGroup);;
				for (@NonNull Relation2TraceClass consumedByRelation2TraceClass : consumedByRule2TraceGroup) {
					if (!isFirst) {
						s.append(",");
					}
					s.append(consumedByRelation2TraceClass.toString());
					isFirst = false;
				}
				s.append(")");
			}
			QVTr2QVTc.CALL_TREE.println("traceClass(directlyConsumedByTraceClasses)" + s.toString());
		}
		if (QVTr2QVTc.CALL_TREE.isActive()) {
			StringBuilder s = new StringBuilder();
			for (@NonNull Relation2TraceClass relation2traceClass : relation2traceClasses) {
				s.append("\n\t" + relation2traceClass.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Relation2TraceClass> consumedByRule2TraceGroup = new ArrayList<>(relation2traceClass.getTransitivelyConsumedByRule2TraceGroup());
				Collections.sort(consumedByRule2TraceGroup);;
				for (@NonNull Relation2TraceClass consumedByRelation2TraceClass : consumedByRule2TraceGroup) {
					if (!isFirst) {
						s.append(",");
					}
					s.append(consumedByRelation2TraceClass.toString());
					isFirst = false;
				}
				s.append(")");
			}
			QVTr2QVTc.CALL_TREE.println("traceClass(transitivelyConsumedByTraceClasses)" + s.toString());
		}
		if (QVTr2QVTc.CALL_TREE.isActive()) {
			StringBuilder s = new StringBuilder();
			for (@NonNull Relation2TraceClass relation2traceClass : relation2traceClasses) {
				s.append("\n\t" + relation2traceClass.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Relation2TraceClass> cyclicRule2TraceGroup = Lists.newArrayList(relation2traceClass.getCyclicRule2TraceGroup());
				Collections.sort(cyclicRule2TraceGroup);;
				for (@NonNull Relation2TraceClass cyclicRelation2TraceClass : cyclicRule2TraceGroup) {
					if (!isFirst) {
						s.append(",");
					}
					s.append(cyclicRelation2TraceClass.toString());
					isFirst = false;
				}
				s.append(")");
			}
			QVTr2QVTc.CALL_TREE.println("traceClass(cyclicTraceClasses)" + s.toString());
		}
	} */

	/*	protected void createRelation2TraceClass(@NonNull Relation rRelation) {
		Relation2TraceClass relation2traceClass = relation2relation2traceClass.get(rRelation);
		assert relation2traceClass == null;
		//		if (relation2relation2traceClass.containsKey(rRelation)) {
		//			throw new CompilerChainException("Overrides cycle detected for " + rRelation);
		//		}
		TransformationAnalysis rTransformationAnalysis = qvtr2qvtc.getTransformationAnalysis(transformation);
		RelationAnalysis relationAnalysis = rTransformationAnalysis.getRelationAnalysis(rRelation);
		relation2traceClass = rRelation.isIsTopLevel() ? new TopRelation2TraceClass(relationAnalysis) : new NonTopRelation2TraceClass(relationAnalysis);
		relation2relation2traceClass.put(rRelation, relation2traceClass);
	} */
	//	protected void createRelation2TraceClass(@NonNull Relation rRelation) {
	//		Relation2TraceClass relation2TraceClass = getRelation2TraceClass(rRelation);
	//		RelationAnalysis relationAnalysis = relation2TraceClass.getRelationAnalysis();
	//		Iterable<@NonNull RelationCallExp> whenInvocations = relationAnalysis.getOutgoingWhenInvocations();
	//		if (whenInvocations != null) {
	//			for (@NonNull RelationCallExp whenInvocation : whenInvocations) {
	//				getRelation2DispatchClass(whenInvocation);
	//			}
	//		}
	//		Iterable<@NonNull RelationCallExp> whereInvocations = relationAnalysis.getOutgoingWhereInvocations();
	//		if (whereInvocations != null) {
	//			for (@NonNull RelationCallExp whereInvocation : whereInvocations) {
	//				getRelation2DispatchClass(whereInvocation);
	//			}
	//		}
	/*		}
		else {
			Relation2SignatureClass relation2signatureClass = relation2relation2signatureClass.get(rRelation);
			assert relation2signatureClass == null;
			relation2signatureClass = new NonTopRelation2SignatureClass(relationAnalysis);
			relation2relation2signatureClass.put(rRelation, relation2signatureClass);
			relation2traceClass = new NonTopRelation2TraceClass(relation2signatureClass);
			//			qvtr2qvtc.putRelationTrace(rRelation, relation2traceClass.getTraceClass());
			relation2relation2traceClass.put(rRelation, relation2traceClass);
			Pattern whenPattern = rRelation.getWhen();
			if (whenPattern != null) {
				for (EObject eObject : new TreeIterable(whenPattern, true)) {
					if (eObject instanceof RelationCallExp) {
						RelationCallExp rInvocation = (RelationCallExp)eObject;
						if (!QVTrelationUtil.getReferredRelation(rInvocation).isIsTopLevel()) {
							//							Invocation2TraceClass invocation2traceClass = new Invocation2TraceClass(relationAnalysis, rInvocation);
							//							relation2traceClass.addInvocation2TraceClass(invocation2traceClass);
							//							qvtr2qvtc.putRelationTrace(rRelation, relation2traceClass.getTraceClass());
							//							relation2relation2traceClass.put(rRelation, relation2traceClass);
						}
					}
				}
			}
		} */
	//	}

	/*	public @NonNull Relation2TraceClass getRelation2DispatchClass(@NonNull RelationCallExp rInvocation) {
		Relation rRelation = QVTrelationUtil.getReferredRelation(rInvocation);
		Relation2TraceClass relation2TraceClass = getRelation2TraceClass(rRelation);
		Relation2TraceClass relation2DispatchClass = relation2TraceClass.getRelation2DispatchClass();
		return relation2DispatchClass != null ? relation2DispatchClass : relation2TraceClass;
	} */

	protected org.eclipse.ocl.pivot.@NonNull Package createTracePackage() {
		org.eclipse.ocl.pivot.Package rPackage = transformation.getOwningPackage();
		org.eclipse.ocl.pivot.Package tracePackage = PivotFactory.eINSTANCE.createPackage();
		tracePackage.setName("trace_" + transformation.getName());
		tracePackage.setNsPrefix("P" + transformation.getName());
		StringBuilder sURI = new StringBuilder();
		getURI(rPackage, sURI);
		tracePackage.setURI(sURI.toString() + "/" + transformation.getName());
		//		qvtr2qvtc.putTracePackage(transformation, tracePackage);
		return tracePackage;
	}

	/*	protected @NonNull WhenInvocation2TraceClass createWhenInvocation2TraceClass(@NonNull RelationCallExp rInvocation, @NonNull Relation invokedRelation) {
		//		Relation invokedRelation = QVTrelationUtil.getReferredRelation(rInvocation);
		Relation invokingRelation = QVTrelationUtil.getContainingRelation(rInvocation);
		assert !invokedRelation.isIsTopLevel();
		WhenInvocation2TraceClass invocation2traceClass = new WhenInvocation2TraceClass(this, invokedRelation, invokingRelation, rInvocation.getReferredRelation() != invokedRelation);
		//		qvtr2qvtc.putInvocationTrace(rInvocation, invocation2traceClass.getTraceClass());
		addInvocation2TraceClass(rInvocation, invocation2traceClass);
		invocation2traceClass.analyzeInheritance();
		return invocation2traceClass;
	} */

	/*	protected @NonNull WhereInvocation2TraceClass createWhereInvocation2TraceClass(@NonNull RelationCallExp rInvocation, @NonNull Relation invokedRelation) {
		//		Relation invokedRelation = QVTrelationUtil.getReferredRelation(rInvocation);
		Relation invokingRelation = QVTrelationUtil.getContainingRelation(rInvocation);
		assert !invokedRelation.isIsTopLevel();
		WhereInvocation2TraceClass invocation2traceClass = new WhereInvocation2TraceClass(this, invokedRelation, invokingRelation, rInvocation.getReferredRelation() != invokedRelation);
		//		qvtr2qvtc.putInvocationTrace(rInvocation, invocation2traceClass.getTraceClass());
		addInvocation2TraceClass(rInvocation, invocation2traceClass);
		invocation2traceClass.analyzeInheritance();
		return invocation2traceClass;
	} */

	public void freeze() {
		this.frozen = true;
	}

	/**
	 * Return the type of a Bag of traceClass for use as the indeterminate opposite property of a trace property.
	 */
	public org.eclipse.ocl.pivot.@NonNull Class getBagType(org.eclipse.ocl.pivot.@NonNull Class traceClass) {
		return scheduleManager.getEnvironmentFactory().getCompleteEnvironment().getBagType(traceClass, true, null, null);
	}

	public org.eclipse.ocl.pivot.@NonNull Class getBooleanType() {
		return scheduleManager.getStandardLibrary().getBooleanType();
	}

	/*	protected @NonNull Iterable<Relation2TraceClass.@NonNull Internal> getInvocation2TraceClasses(@NonNull RelationCallExp rInvocation) throws CompilerChainException {
		return ClassUtil.nonNullState(invocation2relation2traceClasses.get(rInvocation));
	} */

	public @NonNull DomainUsageAnalysis getDomainUsageAnalysis() {
		return scheduleManager.getDomainUsageAnalysis();
	}

	public @NonNull NameGenerator getNameGenerator() {
		return nameGenerator;
	}

	/**
	 * Return the RuleAnalysis2TraceGroup mappings in a deterministic least overridden first alphabetical order.
	 */
	protected @NonNull Iterable<@NonNull RuleAnalysis2TraceGroup> getOrderedRuleAnalysis2TraceGroups() {
		List<@NonNull RuleAnalysis2TraceGroup> relationAnalysis2traceGroups = Lists.newArrayList(rule2relationAnalysis2traceGroup.values());
		Collections.sort(relationAnalysis2traceGroups, OverrideDepthComparator.INSTANCE);
		return relationAnalysis2traceGroups;
	}

	protected @NonNull Property getProperty(/*@NonNull*/ Type aClass, /*@NonNull*/ String name) throws CompilerChainException {
		assert (aClass != null) && (name != null);
		CompleteClass completeClass = scheduleManager.getEnvironmentFactory().getCompleteModel().getCompleteClass(aClass);
		Property p = completeClass.getProperty(name);
		if (p != null)
			return p;
		throw new CompilerChainException("No property '" + name + "' in '" + aClass + "::" + "'");
	}

	public @NonNull RuleAnalysis2TraceGroup getRuleAnalysis2TraceGroup(@NonNull Rule rule) {
		return ClassUtil.nonNullState(rule2relationAnalysis2traceGroup.get(rule));
	}

	public @NonNull Property getSignatureProperty(@NonNull Rule invokedRule, @NonNull VariableDeclaration variable) {
		//		return getRelation2SignatureClass(rInvokedRelation).getMiddleProperty(rVariable);
		throw new UnsupportedOperationException();	// FIXME Dispatcher WIP
	}

	public org.eclipse.ocl.pivot.@NonNull Class getTraceClass(@NonNull Rule rule) {
		return getRuleAnalysis2TraceGroup(rule).getTraceClass();
	}

	public org.eclipse.ocl.pivot.@NonNull Package getTracePackage() {
		return tracePackage;
	}

	/**
	 * Return the trace property of aClass whose name corresponds to rNamedElement.
	 * @throws CompilerChainException if no such property
	 */
	public @NonNull Property getTraceProperty(@NonNull Type aClass, @NonNull VariableDeclaration rVariable) throws CompilerChainException {
		Property property = basicGetTraceProperty(aClass, rVariable);
		if (property != null) {
			return property;
		}
		//		property = basicGetTraceProperty(aClass, rVariable);
		property = getProperty(aClass, rVariable.getName());		// FIXME above should be non-null to ensure uniquely named property is in use
		if (rVariable instanceof Property) {
			assert rVariable == property;
		}
		return property;
	}

	public @NonNull TransformationAnalysis getTransformationAnalysis() {
		return transformationAnalysis;
	}

	private String getURI(org.eclipse.ocl.pivot.Package rPackage, @NonNull StringBuilder s) {
		if (rPackage == null) {
			s.append("http://www.eclipse.org/qvtd-example");
		}
		else if (rPackage.getURI() != null) {
			s.append(rPackage.getURI());
		}
		else {
			getURI(rPackage.getOwningPackage(), s);
			s.append("/");
			s.append(rPackage.getName());
		}
		return null;
	}

	/*	public @NonNull VariableDeclaration2TraceProperty getVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable) {
		Rule rule = QVTbaseUtil.getContainingRule(variable);
		RuleAnalysis2TraceGroup ruleAnalysis2TraceGroup = getRuleAnalysis2TraceGroup(rule);
		RuleAnalysis2MiddleType ruleAnalysis2TraceGroup2TraceClass = ruleAnalysis2TraceGroup.getRuleAnalysis2TraceClass();
		return ruleAnalysis2TraceGroup2TraceClass.getVariableDeclaration2TraceProperty(variable);
	} */

	public boolean isFrozen() {
		return frozen;
	}

	/**
	 * Create and return the trace Package containing all the trace Classes and trace Properties for the
	 * transformation.
	 */
	public org.eclipse.ocl.pivot.@NonNull Package synthesizeTraceModel() throws CompilerChainException {
		//
		//	Create the trace classes and their properties.
		//
		for (@NonNull RuleAnalysis2TraceGroup relationAnalysis2traceGroup : getOrderedRuleAnalysis2TraceGroups()) {
			relationAnalysis2traceGroup.synthesizeTraceModel();
		}
		CompilerUtil.normalizeNameables(QVTbaseUtil.Internal.getOwnedClassesList(tracePackage));
		for (org.eclipse.ocl.pivot.@NonNull Class traceClass : QVTbaseUtil.getOwnedClasses(tracePackage)) {
			CompilerUtil.normalizeNameables(QVTbaseUtil.Internal.getOwnedPropertiesList(traceClass));
		}
		return tracePackage;
	}

	public void synthesizeTraceElements() throws CompilerChainException {
		for (@NonNull RuleAnalysis2TraceGroup relationAnalysis2traceGroup : getOrderedRuleAnalysis2TraceGroups()) {
			relationAnalysis2traceGroup.synthesizeTraceElements();
		}
	}

	@Override
	public @NonNull String toString() {
		return String.valueOf(transformation);
	}
}
