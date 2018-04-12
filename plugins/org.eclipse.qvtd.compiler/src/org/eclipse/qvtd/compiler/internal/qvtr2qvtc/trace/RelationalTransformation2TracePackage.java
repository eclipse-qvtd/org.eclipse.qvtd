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
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTc;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.TransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseHelper;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * RelationalTransformation2TracePackage performs the first part of the QVTr2QVTc transformation.
 * This involves synthesis of the QVTc middle model that defines the middle classes.
 *
 * A trace class records the progress of a relation execution.
 *
 * Additionally a signature class for each non-top relation mediates between invoking and invoked relations.
 */
public class RelationalTransformation2TracePackage extends QVTbaseHelper
{
	protected final @NonNull QVTr2QVTc qvtr2qvtc;
	protected final @NonNull QVTrNameGenerator nameGenerator;
	protected final @NonNull TransformationAnalysis transformationAnalysis;
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
	protected final @NonNull Map<@NonNull String, @NonNull Relation2MiddleType> name2relation2middleType = new HashMap<>();

	/**
	 * Map of relation to trace class.
	 */
	protected final @NonNull Map<@NonNull Relation, @NonNull Relation2TraceClass> relation2relation2traceClass = new HashMap<>();

	private @NonNull Map<@NonNull Type, @NonNull Relation2MiddleType> middleClass2relation2middleType = new HashMap<>();

	private boolean frozen = false;


	static class OverrideDepthComparator implements Comparator<@NonNull Relation2MiddleType>
	{
		public static final @NonNull OverrideDepthComparator INSTANCE = new OverrideDepthComparator();

		@Override
		public int compare(@NonNull Relation2MiddleType o1, @NonNull Relation2MiddleType o2) {
			int d1 = getDepth(o1);
			int d2 = getDepth(o2);
			if (d1 != d2) {
				return d1 - d2;
			}
			String n1 = o1.getName();
			String n2 = o2.getName();
			return n1.compareTo(n2);
		}

		private int getDepth(@NonNull Relation2MiddleType relation2middleType) {
			int depth = 0;
			for (Rule aRule = relation2middleType.getRelation(); (aRule = aRule.getOverridden()) != null; ) {
				depth++;
			}
			return depth;
		}
	}

	/**
	 * Map of invocation to trace classes.
	 */
	//	protected final @NonNull Map<@NonNull RelationCallExp, @NonNull List<Relation2TraceClass.@NonNull Internal>> invocation2relation2traceClasses = new HashMap<>();

	public RelationalTransformation2TracePackage(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull TransformationAnalysis transformationAnalysis) {
		super(qvtr2qvtc.getEnvironmentFactory());
		this.qvtr2qvtc = qvtr2qvtc;
		this.nameGenerator = qvtr2qvtc.getNameGenerator();
		this.transformationAnalysis = transformationAnalysis;
		this.rTransformation = transformationAnalysis.getTransformation();
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

	public @Nullable Property basicGetTraceProperty(@NonNull Type aClass, @NonNull VariableDeclaration rVariable) {
		Relation2MiddleType relation2TraceClass = middleClass2relation2middleType.get(aClass);
		if (relation2TraceClass == null) {
			return null;
		}
		return relation2TraceClass.basicGetTraceProperty(rVariable);
		//		String name = QVTrelationUtil.getName(rVariable);
		//		CompleteClass completeClass = getCompleteClass(aClass);
		//		return completeClass.getProperty(name);
	}

	public org.eclipse.ocl.pivot.@NonNull Class createClass(@NonNull Relation2MiddleType relation2middleType, @NonNull String className) {
		List<org.eclipse.ocl.pivot.@NonNull Class> traceClasses = QVTrelationUtil.Internal.getOwnedClassesList(tracePackage);
		String uniqueName = QVTrNameGenerator.getUniqueName(name2relation2middleType, className, relation2middleType);
		org.eclipse.ocl.pivot.Class traceClass = PivotUtil.createClass(uniqueName);
		traceClasses.add(traceClass);
		middleClass2relation2middleType.put(traceClass, relation2middleType);
		name2relation2middleType.put(uniqueName, relation2middleType);
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
		TransformationAnalysis rTransformationAnalysis = qvtr2qvtc.getTransformationAnalysis(rTransformation);
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
		org.eclipse.ocl.pivot.Package rPackage = rTransformation.getOwningPackage();
		org.eclipse.ocl.pivot.Package tracePackage = PivotFactory.eINSTANCE.createPackage();
		tracePackage.setName("trace_" + rTransformation.getName());
		tracePackage.setNsPrefix("P" + rTransformation.getName());
		StringBuilder sURI = new StringBuilder();
		getURI(rPackage, sURI);
		tracePackage.setURI(sURI.toString() + "/" + rTransformation.getName());
		//		qvtr2qvtc.putTracePackage(rTransformation, tracePackage);
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
	protected org.eclipse.ocl.pivot.@NonNull Class getBagType(org.eclipse.ocl.pivot.@NonNull Class traceClass) {
		return qvtr2qvtc.getEnvironmentFactory().getCompleteEnvironment().getBagType(traceClass, true, null, null);
	}

	public org.eclipse.ocl.pivot.@NonNull Class getBooleanType() {
		return qvtr2qvtc.getStandardLibrary().getBooleanType();
	}

	/*	protected @NonNull Iterable<Relation2TraceClass.@NonNull Internal> getInvocation2TraceClasses(@NonNull RelationCallExp rInvocation) throws CompilerChainException {
		return ClassUtil.nonNullState(invocation2relation2traceClasses.get(rInvocation));
	} */

	public @NonNull DomainUsageAnalysis getDomainUsageAnalysis() {
		return transformationAnalysis.getDomainUsageAnalysis();
	}

	public @NonNull QVTrNameGenerator getNameGenerator() {
		return nameGenerator;
	}

	protected @NonNull Property getProperty(/*@NonNull*/ Type aClass, /*@NonNull*/ String name) throws CompilerChainException {
		assert (aClass != null) && (name != null);
		CompleteClass completeClass = getCompleteClass(aClass);
		Property p = completeClass.getProperty(name);
		if (p != null)
			return p;
		throw new CompilerChainException("No property '" + name + "' in '" + aClass + "::" + "'");
	}

	public @NonNull Relation2TraceClass getRelation2TraceClass(@NonNull Relation rRelation) {
		Relation2TraceClass relation2traceClass = relation2relation2traceClass.get(rRelation);
		if (relation2traceClass == null) {
			TransformationAnalysis rTransformationAnalysis = qvtr2qvtc.getTransformationAnalysis(rTransformation);
			RelationAnalysis relationAnalysis = rTransformationAnalysis.getRelationAnalysis(rRelation);
			if (!QVTrelationUtil.hasOverrides(rRelation)) {
				relation2traceClass = new NonOverrideRelation2TraceClass(relationAnalysis);
			}
			else if (rRelation.isIsTopLevel()) {
				relation2traceClass = new TopOverrideRelation2TraceClass(relationAnalysis);
			}
			else {
				relation2traceClass = new NonTopOverrideRelation2TraceClass(relationAnalysis);
			}
			relation2relation2traceClass.put(rRelation, relation2traceClass);
		}
		return relation2traceClass;
	}

	public @NonNull Property getSignatureProperty(@NonNull Relation rInvokedRelation, @NonNull VariableDeclaration rVariable) {
		//		return getRelation2SignatureClass(rInvokedRelation).getMiddleProperty(rVariable);
		throw new UnsupportedOperationException();	// FIXME Dispatcher WIP
	}

	public org.eclipse.ocl.pivot.@NonNull Class getTraceClass(@NonNull Relation rRelation) {
		return getRelation2TraceClass(rRelation).getMiddleClass();
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

	public boolean isFrozen() {
		return frozen;
	}

	@Override
	public @NonNull String toString() {
		return String.valueOf(rTransformation);
	}

	/**
	 * Create and return the TracePackage containing all the TraceClasses and TraceProperties for the QVTr
	 * transformation.
	 */
	public org.eclipse.ocl.pivot.@NonNull Package transform() throws CompilerChainException {
		//
		//	Create a Relation2TraceClass for each Relation
		//	and a Relation2DispatchClass for each invoked Relation.
		//
		for (@NonNull Relation rRelation : QVTrelationUtil.getOwnedRelations(rTransformation)) {
			getRelation2TraceClass(rRelation);
		}
		List<@NonNull Relation2MiddleType> relation2middleTypes = new ArrayList<>(name2relation2middleType.values());
		Collections.sort(relation2middleTypes, OverrideDepthComparator.INSTANCE);
		//
		//	Analyze the trace classes and interfaces to determine their properties
		//
		for (@NonNull Relation2MiddleType relation2middleType : relation2middleTypes) {
			relation2middleType.analyze();
		}
		//
		//	Create the trace classes
		//
		for (@NonNull Relation2MiddleType relation2middleType : relation2middleTypes) {
			relation2middleType.synthesize();
		}
		CompilerUtil.normalizeNameables(QVTrelationUtil.Internal.getOwnedClassesList(tracePackage));
		return tracePackage;
	}
}
