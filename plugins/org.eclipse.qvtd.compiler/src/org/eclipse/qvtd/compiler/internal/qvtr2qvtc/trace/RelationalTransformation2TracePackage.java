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
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTc;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;
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
	protected final @NonNull QVTrNameGenerator nameGenerator;
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
	protected final @NonNull Map<@NonNull String, @NonNull Relation2TraceClass> name2relation2traceClass = new HashMap<>();

	/**
	 * Map of relation to trace class. The trace class is set null at the start of conversion enabling cycles to be ddetected.
	 */
	protected final @NonNull Map<@NonNull Relation, @Nullable Relation2TraceClass> relation2relation2traceClass = new HashMap<>();

	private @NonNull Map<@NonNull Type, @NonNull Relation2TraceClass> traceClass2relation2traceClass = new HashMap<>();

	/**
	 * Map of invocation to trace classes.
	 */
	//	protected final @NonNull Map<@NonNull RelationCallExp, @NonNull List<Relation2TraceClass.@NonNull Internal>> invocation2relation2traceClasses = new HashMap<>();

	public RelationalTransformation2TracePackage(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull RelationalTransformation rTransformation) {
		this.qvtr2qvtc = qvtr2qvtc;
		this.nameGenerator = qvtr2qvtc.getNameGenerator();
		this.rTransformation = rTransformation;
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

	protected void analyzeTraceClasses() throws CompilerChainException {
		//
		//	Analyze each Relation2TraceClass
		//
		for (@NonNull Relation2TraceClass relation2TraceClass : name2relation2traceClass.values()) {
			relation2TraceClass.analyzeProperties();
		}
	}

	public org.eclipse.ocl.pivot.@Nullable Class basicGetSignatureClass(@NonNull Relation rRelation) {
		return getRelation2TraceClass(rRelation).basicGetSignatureClass();
	}

	public @Nullable Property basicGetTraceProperty(@NonNull Type aClass, @NonNull VariableDeclaration rVariable) {
		Relation2TraceClass relation2TraceClass = traceClass2relation2traceClass.get(aClass);
		if (relation2TraceClass == null) {
			return null;
		}
		return relation2TraceClass.basicGetTraceProperty(rVariable);
	}

	/**
	 * Build the inter-Relation2TraceClass dependencies.
	 */
	protected void createDependencies() throws CompilerChainException {
		List<@NonNull Relation2TraceClass> relation2TraceClasses2 = new ArrayList<>(name2relation2traceClass.values());
		Collections.sort(relation2TraceClasses2);
		//
		//	Establish the Relation2TraceClass directly consumes Relation2TraceClass dependencies
		//
		for (@NonNull Relation2TraceClass relation2TraceClass : relation2TraceClasses2) {
			relation2TraceClass.installConsumesDependencies();
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
			for (@NonNull Relation2TraceClass relation2TraceClasses : relation2TraceClasses2) {
				s.append("\n\t" + relation2TraceClasses.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Relation2TraceClass> consumedRelation2TraceClasses = Lists.newArrayList(relation2TraceClasses.getConsumedRelation2TraceClasses());
				Collections.sort(consumedRelation2TraceClasses);;
				for (@NonNull Relation2TraceClass consumedRelation2TraceClass : consumedRelation2TraceClasses) {
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
			for (@NonNull Relation2TraceClass relation2TraceClass : relation2TraceClasses2) {
				s.append("\n\t" + relation2TraceClass.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Relation2TraceClass> consumedRelation2TraceClasses = new ArrayList<>(relation2TraceClass.getTransitivelyConsumedRelation2TraceClasses());
				Collections.sort(consumedRelation2TraceClasses);;
				for (@NonNull Relation2TraceClass consumedRelation2TraceClass : consumedRelation2TraceClasses) {
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
			for (@NonNull Relation2TraceClass relation2TraceClasses : relation2TraceClasses2) {
				s.append("\n\t" + relation2TraceClasses.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Relation2TraceClass> consumedByRelation2TraceClasses = Lists.newArrayList(relation2TraceClasses.getConsumedByRelation2TraceClasses());
				Collections.sort(consumedByRelation2TraceClasses);;
				for (@NonNull Relation2TraceClass consumedByRelation2TraceClass : consumedByRelation2TraceClasses) {
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
			for (@NonNull Relation2TraceClass relation2TraceClasses : relation2TraceClasses2) {
				s.append("\n\t" + relation2TraceClasses.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Relation2TraceClass> consumedByRelation2TraceClasses = new ArrayList<>(relation2TraceClasses.getTransitivelyConsumedByRelation2TraceClasses());
				Collections.sort(consumedByRelation2TraceClasses);;
				for (@NonNull Relation2TraceClass consumedByRelation2TraceClass : consumedByRelation2TraceClasses) {
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
			for (@NonNull Relation2TraceClass relation2TraceClasses : relation2TraceClasses2) {
				s.append("\n\t" + relation2TraceClasses.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Relation2TraceClass> cyclicRelation2TraceClasses = Lists.newArrayList(relation2TraceClasses.getCyclicRelation2TraceClasses());
				Collections.sort(cyclicRelation2TraceClasses);;
				for (@NonNull Relation2TraceClass cyclicRelation2TraceClass : cyclicRelation2TraceClasses) {
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
	}

	protected void createRelation2TraceClass(@NonNull Relation rRelation) {
		Relation2TraceClass relation2traceClass = relation2relation2traceClass.get(rRelation);
		assert relation2traceClass == null;
		//		if (relation2relation2traceClass.containsKey(rRelation)) {
		//			throw new CompilerChainException("Overrides cycle detected for " + rRelation);
		//		}
		relation2traceClass = rRelation.isIsTopLevel() ? new TopRelation2TraceClass(this, rRelation) : new NonTopRelation2TraceClass(this, rRelation);
		qvtr2qvtc.putRelationTrace(rRelation, relation2traceClass.getTraceClass());
		//		relation2relation2traceClass.put(rRelation, null);
		//		relation2traceClass.analyze();
		relation2relation2traceClass.put(rRelation, relation2traceClass);
	}

	/**
	 * Create a Relation2TraceClass for every QVTc Mapping and its middle model trace Class to be synthesized.
	 */
	protected void createRelation2TraceClasses() {
		Iterable<@NonNull Relation> rRelations = QVTrelationUtil.getOwnedRelations(rTransformation);
		//
		//	 Create each relation Relation2TraceClass.
		//
		for (@NonNull Relation rRelation : rRelations) {
			createRelation2TraceClass(rRelation);
		}
		//
		//	 Create a trace interface for each override.
		//
		for (@NonNull Relation rRelation : rRelations) {
			Relation2TraceClass relation2TraceClass = getRelation2TraceClass(rRelation);
			relation2TraceClass.analyzeInheritance();
		}
		//
		//	 Create each invocation Relation2TraceClass.
		/*
		for (@NonNull Relation rRelation : rRelations) {
			Relation2TraceClass invokingRelation2TraceClass = getRelation2TraceClass(rRelation);
			for (@NonNull RelationCallExp whenInvocation : invokingRelation2TraceClass.getWhenInvocations()) {
				Relation invokedRelation = QVTrelationUtil.getReferredRelation(whenInvocation);
				if (!invokedRelation.isIsTopLevel()) {
					Relation2TraceClass invokedRelation2TraceClass = getRelation2TraceClass(invokedRelation);
					//					invokedRelation2TraceClass.getSignatureClass();
					//					createWhenInvocation2TraceClass(whenInvocation, invokedRelation);
					//					for (@NonNull Relation overridingInvokedRelation : qvtr2qvtc.getOverridingRelations(invokedRelation)) {
					//						createWhenInvocation2TraceClass(whenInvocation, overridingInvokedRelation);
					//					}
				}
			}
			for (@NonNull RelationCallExp whereInvocation : invokingRelation2TraceClass.getWhereInvocations()) {
				Relation invokedRelation = QVTrelationUtil.getReferredRelation(whereInvocation);
				if (!invokedRelation.isIsTopLevel()) {
					Relation2TraceClass invokedRelation2TraceClass = getRelation2TraceClass(invokedRelation);
					//					invokedRelation2TraceClass.getSignatureClass();
					//					createWhereInvocation2TraceClass(whereInvocation, invokedRelation);
					//					for (@NonNull Relation overridingInvokedRelation : qvtr2qvtc.getOverridingRelations(invokedRelation)) {
					//						createWhereInvocation2TraceClass(whereInvocation, overridingInvokedRelation);
					//					}
				}
			}
		} */
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

	/**
	 * Return the type of a Bag of traceClass for use as the indeterminate opposite property of a trace property.
	 */
	protected org.eclipse.ocl.pivot.@NonNull Class getBagType(org.eclipse.ocl.pivot.@NonNull Class traceClass) {
		return qvtr2qvtc.getEnvironmentFactory().getCompleteEnvironment().getBagType(traceClass, true, null, null);
	}

	public org.eclipse.ocl.pivot.@NonNull Class getBooleanType() {
		return qvtr2qvtc.getStandardLibrary().getBooleanType();
	}

	/*	protected @NonNull Iterable<Relation2TraceClass.@NonNull Internal> getInvocation2TraceClasses(@NonNull RelationCallExp rInvocation) throws CompilerChainException {
		return ClassUtil.nonNullState(invocation2relation2traceClasses.get(rInvocation));
	} */

	public @NonNull QVTrNameGenerator getNameGenerator() {
		return nameGenerator;
	}

	protected @NonNull Relation2TraceClass getRelation2TraceClass(@NonNull Relation rRelation) {
		return ClassUtil.nonNullState(relation2relation2traceClass.get(rRelation));
	}

	public org.eclipse.ocl.pivot.@NonNull Class getSignatureClass(@NonNull Relation rInvokedRelation) {
		return getRelation2TraceClass(rInvokedRelation).getSignatureClass();
	}

	public @NonNull Property getSignatureProperty(@NonNull Relation rInvokedRelation, @NonNull VariableDeclaration rVariable) {
		return getRelation2TraceClass(rInvokedRelation).getSignatureProperty(rVariable);
	}

	public org.eclipse.ocl.pivot.@NonNull Class getTraceClass(@NonNull Relation rRelation) {
		return getRelation2TraceClass(rRelation).getTraceClass();
	}

	public @NonNull Property getTraceProperty(@NonNull RelationCallExp rInvocation) {
		Relation2TraceClass relation2TraceClass = getRelation2TraceClass(QVTrelationUtil.getContainingRelation(rInvocation));
		return relation2TraceClass.getTraceProperty(rInvocation);
	}

	protected @NonNull String getUniqueTraceClassName(@NonNull Relation2TraceClass mapping2traceClass, @NonNull String name) {
		return getNameGenerator().getUniqueName(name2relation2traceClass, name, mapping2traceClass);
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

	public @NonNull VariableDeclaration2TraceProperty getVariableDeclaration2TraceProperty(@NonNull VariableDeclaration rVariable) {
		Relation2TraceClass relation2TraceClass = getRelation2TraceClass(QVTrelationUtil.getContainingRelation(rVariable));
		return relation2TraceClass.getVariableDeclaration2TraceProperty(rVariable);
	}

	protected void synthesizeTraceClasses() {
		//
		//	Create the trace and signature classes
		//
		HashSet<@NonNull Relation2TraceClass> relation2TraceClasses = new HashSet<>(name2relation2traceClass.values());
		for (@NonNull Relation2TraceClass relation2TraceClass : relation2TraceClasses) {
			relation2TraceClass.synthesize();
		}
		List<org.eclipse.ocl.pivot.@NonNull Class> traceClasses = new ArrayList<>(name2relation2traceClass.size());
		for (@NonNull Relation2TraceClass relation2TraceClass : relation2TraceClasses) {
			org.eclipse.ocl.pivot.Class traceClass = relation2TraceClass.getTraceClass();
			traceClasses.add(traceClass);
			traceClass2relation2traceClass.put(traceClass, relation2TraceClass);
			org.eclipse.ocl.pivot.Class signatureClass = relation2TraceClass.basicGetSignatureClass();
			if (signatureClass != null) {
				traceClasses.add(signatureClass);
				traceClass2relation2traceClass.put(signatureClass, relation2TraceClass);
				// FIXME signature inheritance
			}
		}
		CompilerUtil.normalizeNameables(traceClasses);
		tracePackage.getOwnedClasses().addAll(traceClasses);
	}

	@Override
	public String toString() {
		return rTransformation.toString();
	}

	public org.eclipse.ocl.pivot.@NonNull Package transform() throws CompilerChainException {
		//
		//	 Create a Relation2TraceClass for each Relation and each Invocation.
		//
		createRelation2TraceClasses();
		//
		//	Analyze the trace classes and interfaces to determine their properties
		//
		analyzeTraceClasses();
		//
		//	 Create the Relation2TraceClass to Relation2TraceClass dependencies.
		//
		createDependencies();
		//
		//	Create the trace classes and interfaces
		//
		synthesizeTraceClasses();
		return tracePackage;
	}
}
