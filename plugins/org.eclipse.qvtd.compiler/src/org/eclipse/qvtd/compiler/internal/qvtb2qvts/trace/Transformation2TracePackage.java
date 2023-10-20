/*******************************************************************************
 * Copyright (c) 2017, 2021 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.usage.DomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

import com.google.common.collect.Lists;

/**
 * RelationalTransformation2TracePackage performs the first part of the QVTr2QVTc transformation.
 * This involves synthesis of the QVTc middle model that defines the middle classes.
 *
 * A trace class records the progress of a relation execution.
 *
 * Additionally a signature class for each non-top relation mediates between invoking and invoked relations.
 */
public abstract class Transformation2TracePackage
{
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull NameGenerator nameGenerator;
	protected final @NonNull Transformation transformation;
	private final org.eclipse.ocl.pivot.@NonNull Package tracePackage;

	/**
	 * Name to corresponding trace class
	 */
	protected final @NonNull Map<@NonNull String, @NonNull Nameable> name2rule2middleType = new HashMap<>();

	/**
	 * Map of relation to trace classes.
	 */
	protected final @NonNull Map<@NonNull Rule, @NonNull Rule2TraceGroup> rule2rule2traceGroup = new HashMap<>();

	private @NonNull Map<@NonNull Type, @NonNull Rule2MiddleType> middleClass2rule2middleType = new HashMap<>();

	private boolean frozen = false;


	static class OverrideDepthComparator implements Comparator<@NonNull Rule2TraceGroup>
	{
		public static final @NonNull OverrideDepthComparator INSTANCE = new OverrideDepthComparator();

		@Override
		public int compare(@NonNull Rule2TraceGroup o1, @NonNull Rule2TraceGroup o2) {
			int d1 = getDepth(o1);
			int d2 = getDepth(o2);
			if (d1 != d2) {
				return d1 - d2;
			}
			String n1 = o1.getName();
			String n2 = o2.getName();
			return n1.compareTo(n2);
		}

		private int getDepth(@NonNull Rule2TraceGroup rule2traceGroup) {
			int depth = 0;
			for (Rule aRule = rule2traceGroup.getRule(); (aRule = aRule.getOverridden()) != null; ) {
				depth++;
			}
			return depth;
		}
	}

	protected Transformation2TracePackage(@NonNull ScheduleManager scheduleManager, @NonNull Transformation transformation) {
		this.scheduleManager = scheduleManager;
		this.nameGenerator = scheduleManager.getNameGenerator();
		this.transformation = transformation;
		this.tracePackage = createTracePackage();
		assert scheduleManager.getMultipleScheduleManager() == scheduleManager;
		getTransformationTraceClass();
	}

	public void addDirectedRule(@NonNull Rule rule, @NonNull Rule2TraceGroup relation2traceGroup) {
		Rule2TraceGroup oldrelation2traceGroup = rule2rule2traceGroup.put(rule, relation2traceGroup);
		assert oldrelation2traceGroup == null;
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

	public @Nullable Property basicGetTraceProperty(@NonNull Type aClass, @NonNull VariableDeclaration rVariable) {
		Rule2MiddleType relation2TraceClass = middleClass2rule2middleType.get(aClass);
		if (relation2TraceClass == null) {
			return null;
		}
		return relation2TraceClass.basicGetTraceProperty(rVariable);
		//		String name = QVTrelationUtil.getName(rVariable);
		//		CompleteClass completeClass = getCompleteClass(aClass);
		//		return completeClass.getProperty(name);
	}

	public org.eclipse.ocl.pivot.@NonNull Class createClass(@NonNull Transformation transformation, @NonNull String className) {
		List<org.eclipse.ocl.pivot.@NonNull Class> traceClasses = QVTbaseUtil.Internal.getOwnedClassesList(tracePackage);
		String uniqueName = NameGenerator.getUniqueName(name2rule2middleType, className, transformation);
		org.eclipse.ocl.pivot.Class traceClass = PivotUtil.createClass(uniqueName);
		traceClasses.add(traceClass);
		//		middleClass2rule2middleType.put(traceClass, rule2middleType);
		name2rule2middleType.put(uniqueName, transformation);
		return traceClass;
	}

	public org.eclipse.ocl.pivot.@NonNull Class createClass(@NonNull Rule2MiddleType rule2middleType, @NonNull String className) {
		List<org.eclipse.ocl.pivot.@NonNull Class> traceClasses = QVTbaseUtil.Internal.getOwnedClassesList(tracePackage);
		String uniqueName = NameGenerator.getUniqueName(name2rule2middleType, className, rule2middleType);
		org.eclipse.ocl.pivot.Class traceClass = PivotUtil.createClass(uniqueName);
		traceClasses.add(traceClass);
		middleClass2rule2middleType.put(traceClass, rule2middleType);
		name2rule2middleType.put(uniqueName, rule2middleType);
		return traceClass;
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
		String txName = transformation.getName();
		String traceTxName = "trace_" + txName;
		String traceTxNsPrefix = "P" + txName;
		StringBuilder s = new StringBuilder();
		getURI(rPackage, s);
		s.append("/" + txName);
		return PivotUtil.createPackage(traceTxName, traceTxNsPrefix, s.toString(), null);
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
	 * Return the Rule2TraceGroup mappings in a deterministic least overridden first alphabetical order.
	 */
	protected @NonNull Iterable<@NonNull Rule2TraceGroup> getOrderedRule2TraceGroups() {
		List<@NonNull Rule2TraceGroup> relation2traceGroups = Lists.newArrayList(rule2rule2traceGroup.values());
		Collections.sort(relation2traceGroups, OverrideDepthComparator.INSTANCE);
		return relation2traceGroups;
	}

	protected @NonNull Property getProperty(/*@NonNull*/ Type aClass, /*@NonNull*/ String name) throws CompilerChainException {
		assert (aClass != null) && (name != null);
		CompleteClass completeClass = scheduleManager.getEnvironmentFactory().getCompleteModel().getCompleteClass(aClass);
		Property p = completeClass.getProperty(name);
		if (p != null)
			return p;
		throw new CompilerChainException("No property '" + name + "' in '" + aClass + "::" + "'");
	}

	public @NonNull Rule2TraceGroup getRule2TraceGroup(@NonNull Rule rule) {
		Rule2TraceGroup rule2TraceGroup = rule2rule2traceGroup.get(rule);
		if (rule2TraceGroup == null) {
			rule2TraceGroup = scheduleManager.createRule2TraceGroup(this, rule);
			rule2rule2traceGroup.put(rule, rule2TraceGroup);
		}
		return rule2TraceGroup;
	}

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	public @NonNull Property getSignatureProperty(@NonNull Rule invokedRule, @NonNull VariableDeclaration variable) {
		//		return getRelation2SignatureClass(rInvokedRelation).getMiddleProperty(rVariable);
		throw new UnsupportedOperationException();	// FIXME Dispatcher WIP
	}

	public org.eclipse.ocl.pivot.@NonNull Class getTraceClass(@NonNull Rule rule) {
		return getRule2TraceGroup(rule).getTraceClass();
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

	//	public @NonNull AbstractTransformationAnalysis getTransformationAnalysis() {
	//		return transformationAnalysis;
	//	}

	public abstract org.eclipse.ocl.pivot.@Nullable Class getTransformationTraceClass();

	private void getURI(org.eclipse.ocl.pivot.Package rPackage, @NonNull StringBuilder s) {
		if (rPackage == null) {
			s.append(scheduleManager.getTraceBaseURI());
		}
		else if (rPackage.getURI() != null) {
			s.append(rPackage.getURI());
		}
		else {
			getURI(rPackage.getOwningPackage(), s);
			String name = rPackage.getName();
			if (name.length() > 0) {
				s.append("/");
				s.append(name);
			}
		}
	}

	/*	public @NonNull VariableDeclaration2TraceProperty getVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable) {
		Rule rule = QVTbaseUtil.getContainingRule(variable);
		Rule2TraceGroup rule2traceGroup = getRule2TraceGroup(rule);
		Rule2MiddleType rule2traceGroup2TraceClass = rule2traceGroup.getAnalysis2TraceClass();
		return rule2traceGroup2TraceClass.getVariableDeclaration2TraceProperty(variable);
	} */

	public boolean isFrozen() {
		return frozen;
	}

	/**
	 * Create and return the trace Package containing all the trace Classes and trace Properties for the
	 * transformation.
	 *
	public org.eclipse.ocl.pivot.@NonNull Package synthesizeTraceModel() throws CompilerChainException {
		//
		//	Create the trace classes and their properties.
		//
		for (@NonNull Rule2TraceGroup relation2traceGroup : getOrderedRule2TraceGroups()) {
			relation2traceGroup.synthesizeTraceModel();
		}
		CompilerUtil.normalizeNameables(QVTbaseUtil.Internal.getOwnedClassesList(tracePackage));
		for (org.eclipse.ocl.pivot.@NonNull Class traceClass : QVTbaseUtil.getOwnedClasses(tracePackage)) {
			CompilerUtil.normalizeNameables(QVTbaseUtil.Internal.getOwnedPropertiesList(traceClass));
		}
		return tracePackage;
	} */

	@Override
	public @NonNull String toString() {
		return String.valueOf(transformation);
	}
}
