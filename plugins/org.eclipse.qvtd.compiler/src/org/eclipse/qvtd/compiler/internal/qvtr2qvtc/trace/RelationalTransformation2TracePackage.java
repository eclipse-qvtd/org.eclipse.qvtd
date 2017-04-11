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
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTc;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

import com.google.common.collect.Lists;

/**
 * RelationalTransformation2TracePackage performs the first part of the QVTr2QVTc transformation.
 * This involves synthesis of the QVTc middle model that defines the trace classes.
 */
public class RelationalTransformation2TracePackage
{
	protected final @NonNull QVTr2QVTc qvtr2qvtc;
	protected final @NonNull RelationalTransformation rTransformation;
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
	protected final @NonNull Map<@NonNull String, Rule2TraceClass.@NonNull Internal> name2rule2traceClass = new HashMap<>();

	/**
	 * Map of relation to trace class. The trace class is set null at the start of conversion enabling cycles to be ddetected.
	 */
	protected final @NonNull Map<@NonNull Relation, Rule2TraceClass.@Nullable Internal> relation2rule2traceClass = new HashMap<>();

	/**
	 * Map of invocation to trace class. The trace class is set null at the start of conversion enabling cycles to be ddetected.
	 */
	protected final @NonNull Map<@NonNull RelationCallExp, Rule2TraceClass.@NonNull Internal> invocation2rule2traceClass = new HashMap<>();

	public RelationalTransformation2TracePackage(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull RelationalTransformation rTransformation) {
		this.qvtr2qvtc = qvtr2qvtc;
		this.rTransformation = rTransformation;
		this.tracePackage = createTracePackage();
	}

	/**
	 * Build the inter-Rule2TraceClass dependencies.
	 */
	protected void createDependencies() throws CompilerChainException {
		List<Rule2TraceClass.@NonNull Internal> rule2TraceClasses2 = new ArrayList<>(name2rule2traceClass.values());
		Collections.sort(rule2TraceClasses2);
		//
		//	Establish the Rule2TraceClass directly consumes Rule2TraceClass dependencies
		//
		for (Rule2TraceClass.@NonNull Internal rule2TraceClass : rule2TraceClasses2) {
			rule2TraceClass.installConsumesDependencies();
		}
		//
		//	Identify the dependency cycles
		//
		//		for (@NonNull Rule2TraceClass rule2TraceClass : rule2TraceClasses2) {
		//			rule2TraceClass.installDependencyCycles();
		//		}
		//
		//	Display the dependencies
		//
		if (QVTr2QVTc.CALL_TREE.isActive()) {
			StringBuilder s = new StringBuilder();
			for (Rule2TraceClass.@NonNull Internal rule2TraceClasses : rule2TraceClasses2) {
				s.append("\n\t" + rule2TraceClasses.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Rule2TraceClass> consumedRule2traceClasses = Lists.newArrayList(rule2TraceClasses.getConsumedRule2traceClasses());
				Collections.sort(consumedRule2traceClasses);;
				for (@NonNull Rule2TraceClass consumedRule2traceClass : consumedRule2traceClasses) {
					if (!isFirst) {
						s.append(",");
					}
					s.append(consumedRule2traceClass.toString());
					isFirst = false;
				}
				s.append(")");
			}
			QVTr2QVTc.CALL_TREE.println("traceClass(directlyConsumedTraceClasses)" + s.toString());
		}
		if (QVTr2QVTc.CALL_TREE.isActive()) {
			StringBuilder s = new StringBuilder();
			for (Rule2TraceClass.@NonNull Internal rule2TraceClass : rule2TraceClasses2) {
				s.append("\n\t" + rule2TraceClass.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Rule2TraceClass> consumedRule2traceClasses = new ArrayList<>(rule2TraceClass.getTransitivelyConsumedRule2traceClasses());
				Collections.sort(consumedRule2traceClasses);;
				for (@NonNull Rule2TraceClass consumedRule2traceClass : consumedRule2traceClasses) {
					if (!isFirst) {
						s.append(",");
					}
					s.append(consumedRule2traceClass.toString());
					isFirst = false;
				}
				s.append(")");
			}
			QVTr2QVTc.CALL_TREE.println("traceClass(transitivelyConsumedTraceClasses)" + s.toString());
		}
		if (QVTr2QVTc.CALL_TREE.isActive()) {
			StringBuilder s = new StringBuilder();
			for (Rule2TraceClass.@NonNull Internal rule2TraceClasses : rule2TraceClasses2) {
				s.append("\n\t" + rule2TraceClasses.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Rule2TraceClass> consumedByRule2traceClasses = Lists.newArrayList(rule2TraceClasses.getConsumedByRule2traceClasses());
				Collections.sort(consumedByRule2traceClasses);;
				for (@NonNull Rule2TraceClass consumedByRule2traceClass : consumedByRule2traceClasses) {
					if (!isFirst) {
						s.append(",");
					}
					s.append(consumedByRule2traceClass.toString());
					isFirst = false;
				}
				s.append(")");
			}
			QVTr2QVTc.CALL_TREE.println("traceClass(directlyConsumedByTraceClasses)" + s.toString());
		}
		if (QVTr2QVTc.CALL_TREE.isActive()) {
			StringBuilder s = new StringBuilder();
			for (Rule2TraceClass.@NonNull Internal rule2TraceClasses : rule2TraceClasses2) {
				s.append("\n\t" + rule2TraceClasses.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Rule2TraceClass> consumedByRule2traceClasses = new ArrayList<>(rule2TraceClasses.getTransitivelyConsumedByRule2traceClasses());
				Collections.sort(consumedByRule2traceClasses);;
				for (@NonNull Rule2TraceClass consumedByRule2traceClass : consumedByRule2traceClasses) {
					if (!isFirst) {
						s.append(",");
					}
					s.append(consumedByRule2traceClass.toString());
					isFirst = false;
				}
				s.append(")");
			}
			QVTr2QVTc.CALL_TREE.println("traceClass(transitivelyConsumedByTraceClasses)" + s.toString());
		}
		if (QVTr2QVTc.CALL_TREE.isActive()) {
			StringBuilder s = new StringBuilder();
			for (Rule2TraceClass.@NonNull Internal rule2TraceClasses : rule2TraceClasses2) {
				s.append("\n\t" + rule2TraceClasses.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Rule2TraceClass> cyclicRule2traceClasses = Lists.newArrayList(rule2TraceClasses.getCyclicRule2traceClasses());
				Collections.sort(cyclicRule2traceClasses);;
				for (@NonNull Rule2TraceClass cyclicRule2traceClass : cyclicRule2traceClasses) {
					if (!isFirst) {
						s.append(",");
					}
					s.append(cyclicRule2traceClass.toString());
					isFirst = false;
				}
				s.append(")");
			}
			QVTr2QVTc.CALL_TREE.println("traceClass(cyclicTraceClasses)" + s.toString());
		}
	}

	protected void createRelation2TraceClass(@NonNull Relation rRelation) throws CompilerChainException {
		Rule2TraceClass.Internal rule2traceClass = relation2rule2traceClass.get(rRelation);
		assert rule2traceClass == null;
		if (relation2rule2traceClass.containsKey(rRelation)) {
			throw new CompilerChainException("Overrides cycle detected for " + rRelation);
		}
		rule2traceClass = rRelation.isIsTopLevel() ? new TopRelation2TraceClass(this, rRelation) : new NonTopRelation2TraceClass(this, rRelation);
		qvtr2qvtc.putRelationTrace(rRelation, rule2traceClass.getTraceClass());
		relation2rule2traceClass.put(rRelation, null);
		rule2traceClass.transform();
		relation2rule2traceClass.put(rRelation, rule2traceClass);
	}

	/**
	 * Create a Rule2TraceClass for every QVTc Mapping and its middle model trace Class to be synthesized.
	 */
	protected void createRule2TraceClasses() throws CompilerChainException {
		Iterable<@NonNull Relation> rRelations = QVTrelationUtil.getOwnedRelations(rTransformation);
		//
		//	 Create each relation Rule2TraceClass.
		//
		for (@NonNull Relation rRelation : rRelations) {
			createRelation2TraceClass(rRelation);
		}
		//
		//	 Create each invocation Rule2TraceClass.
		//
		for (@NonNull Relation rRelation : rRelations) {
			Rule2TraceClass.Internal relation2TraceClass = getRule2TraceClass(rRelation);
			for (@NonNull RelationCallExp whenInvocation : relation2TraceClass.getWhenInvocations()) {
				Relation whenInvokedRelation = QVTrelationUtil.getReferredRelation(whenInvocation);
				if (!whenInvokedRelation.isIsTopLevel()) {
					createWhenInvocation2TraceClass(whenInvocation);
				}
			}
			for (@NonNull RelationCallExp whereInvocation : relation2TraceClass.getWhereInvocations()) {
				Relation whereInvokedRelation = QVTrelationUtil.getReferredRelation(whereInvocation);
				if (!whereInvokedRelation.isIsTopLevel()) {
					createWhereInvocation2TraceClass(whereInvocation);
				}
			}
		}
	}

	protected void createTraceClasses() {
		//
		//	Create the trace classes
		//
		List<org.eclipse.ocl.pivot.@NonNull Class> traceClasses = new ArrayList<>(name2rule2traceClass.size());
		for (@NonNull Rule2TraceClass rule2TraceClass : name2rule2traceClass.values()) {
			traceClasses.add(rule2TraceClass.getTraceClass());
		}
		CompilerUtil.normalizeNameables(traceClasses);
		tracePackage.getOwnedClasses().addAll(traceClasses);
	}

	protected org.eclipse.ocl.pivot.@NonNull Package createTracePackage() {
		org.eclipse.ocl.pivot.Package rPackage = rTransformation.getOwningPackage();
		org.eclipse.ocl.pivot.Package tracePackage = PivotFactory.eINSTANCE.createPackage();
		tracePackage.setName("P" + rTransformation.getName());
		tracePackage.setNsPrefix("P" + rTransformation.getName());
		StringBuilder sURI = new StringBuilder();
		getURI(rPackage, sURI);
		tracePackage.setURI(sURI.toString() + "/" + rTransformation.getName());
		qvtr2qvtc.putTracePackage(rTransformation, tracePackage);
		return tracePackage;
	}

	protected void createWhenInvocation2TraceClass(@NonNull RelationCallExp rInvocation) throws CompilerChainException {
		Relation invokedRelation = QVTrelationUtil.getReferredRelation(rInvocation);
		Relation invokingRelation = QVTrelationUtil.getContainingRelation(rInvocation);
		assert !invokedRelation.isIsTopLevel();
		WhenInvocation2TraceClass invocation2traceClass = new WhenInvocation2TraceClass(this, invokedRelation, invokingRelation);
		qvtr2qvtc.putInvocationTrace(rInvocation, invocation2traceClass.getTraceClass());
		Rule2TraceClass oldRule2traceClass = invocation2rule2traceClass.put(rInvocation, invocation2traceClass);
		assert oldRule2traceClass == null;
		invocation2traceClass.transform();
	}

	protected void createWhereInvocation2TraceClass(@NonNull RelationCallExp rInvocation) throws CompilerChainException {
		Relation invokedRelation = QVTrelationUtil.getReferredRelation(rInvocation);
		Relation invokingRelation = QVTrelationUtil.getContainingRelation(rInvocation);
		assert !invokedRelation.isIsTopLevel();
		WhereInvocation2TraceClass invocation2traceClass = new WhereInvocation2TraceClass(this, invokedRelation, invokingRelation);
		qvtr2qvtc.putInvocationTrace(rInvocation, invocation2traceClass.getTraceClass());
		Rule2TraceClass oldRule2traceClass = invocation2rule2traceClass.put(rInvocation, invocation2traceClass);
		assert oldRule2traceClass == null;
		invocation2traceClass.transform();
	}

	/**
	 * Return the type of a Bag of traceClass for use as the indeterminate opposite property of a trace property.
	 */
	protected org.eclipse.ocl.pivot.@NonNull Class getBagType(org.eclipse.ocl.pivot.@NonNull Class traceClass) {
		return qvtr2qvtc.getEnvironmentFactory().getCompleteEnvironment().getBagType(traceClass, true, null, null);
	}

	protected Rule2TraceClass.@NonNull Internal getInvocation2TraceClass(@NonNull RelationCallExp rInvocation) throws CompilerChainException {
		return ClassUtil.nonNullState(invocation2rule2traceClass.get(rInvocation));
	}

	protected Rule2TraceClass.@NonNull Internal getRule2TraceClass(@NonNull Relation rRelation) throws CompilerChainException {
		return ClassUtil.nonNullState(relation2rule2traceClass.get(rRelation));
	}

	/*	protected org.eclipse.ocl.pivot.@NonNull Class getSpeculatableClass() {
		org.eclipse.ocl.pivot.Class speculatableClass2 = speculatableClass;
		if (speculatableClass2 == null) {
			//			org.eclipse.ocl.pivot.Class speculationClass2 = getSpeculationClass();
			org.eclipse.ocl.pivot.Class speculatableInterface = PivotUtil.createClass(Speculatable.class.getSimpleName());
			speculatableInterface.setInstanceClassName(Speculatable.class.getName());
			speculatableInterface.setIsAbstract(true);
			speculatableInterface.setIsInterface(true);
			tracePackage.getOwnedClasses().add(speculatableInterface);
			speculatableClass2 = speculatableClass = PivotUtil.createClass("Abstract" + Speculatable.class.getSimpleName());
			speculatableClass2.setIsAbstract(true);
			speculatableClass2.setIsInterface(false);
			speculatableClass2.getSuperClasses().add(speculatableInterface);
			Type speculationClass = getSpeculationClass();
			Type speculationsType = qvtr2qvtc.getEnvironmentFactory().getCompleteEnvironment().getBagType(speculationClass, true, null, null);
			Property referredSpeculationsProperty = PivotUtil.createProperty(QVTrNameGenerator.TRACECLASS_REFERRED_SPECULATIONS_PROPERTY_NAME, speculationsType);
			referredSpeculationsProperty.setIsRequired(true);
			referredSpeculationsProperty.setIsResolveProxies(false);
			speculatableClass2.getOwnedProperties().add(referredSpeculationsProperty);
			Property speculationProperty = PivotUtil.createProperty(QVTrNameGenerator.TRACECLASS_SPECULATION_PROPERTY_NAME, speculationClass);
			speculationProperty.setIsRequired(false);
			speculationProperty.setIsResolveProxies(false);
			speculatableClass2.getOwnedProperties().add(speculationProperty);
			Type booleanType = qvtr2qvtc.getStandardLibrary().getBooleanType();
			Property successProperty = PivotUtil.createProperty(QVTrNameGenerator.TRACECLASS_SUCCESS_PROPERTY_NAME, booleanType);
			successProperty.setIsRequired(true);
			speculatableClass2.getOwnedProperties().add(successProperty);
			tracePackage.getOwnedClasses().add(speculatableClass2);
		}
		return speculatableClass2;
	} */

	/*	protected org.eclipse.ocl.pivot.@NonNull Class getSpeculationClass() {
		org.eclipse.ocl.pivot.Class speculationClass2 = speculationClass;
		if (speculationClass2 == null) {
			speculationClass2 = speculationClass = PivotUtil.createClass(Speculation.class.getSimpleName());
			speculationClass2.setInstanceClassName(Speculation.class.getName());
			speculationClass2.setIsAbstract(true);
			speculationClass2.setIsInterface(true);
			tracePackage.getOwnedClasses().add(speculationClass2);
		}
		return speculationClass2;
	} */

	protected @NonNull String getUniqueTraceClassName(Rule2TraceClass.@NonNull Internal mapping2traceClass, @NonNull String name) {
		String uniqueName = name;
		int suffix = 0;
		while (name2rule2traceClass.get(uniqueName) != null) {
			uniqueName = name + ++suffix;
		}
		name2rule2traceClass.put(uniqueName, mapping2traceClass);
		return uniqueName;
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

	@Override
	public String toString() {
		return rTransformation.toString();
	}

	public org.eclipse.ocl.pivot.@NonNull Package transform() throws CompilerChainException {
		//
		//	 Create a Rule2TraceClass for each Relation and each Invocation.
		//
		createRule2TraceClasses();
		//
		//	 Create the Rule2TraceClass to Rule2TraceClass dependencies.
		//
		createDependencies();
		//
		//	Create the trace package
		//
		createTraceClasses();
		return tracePackage;
	}
}
