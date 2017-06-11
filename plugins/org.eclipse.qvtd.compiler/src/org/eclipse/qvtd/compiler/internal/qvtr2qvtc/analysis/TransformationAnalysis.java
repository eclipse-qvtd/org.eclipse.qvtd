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
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.Key2FunctionForIdentification;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTc;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace.RelationalTransformation2TracePackage;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationHelper;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

import com.google.common.collect.Iterables;

/**
 * A TransformationAnalysis accumulates the tesults of analyzing a RelationalTransformation and its contents.
 */
public class TransformationAnalysis extends QVTrelationHelper implements Nameable
{
	/**
	 * The parent QVTr to QVTc transformation.
	 */
	protected final @NonNull QVTr2QVTc qvtr2qvtc;

	/**
	 * The analyzed RelationalTransformation.
	 */
	protected final @NonNull RelationalTransformation transformation;
	//	protected final @NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage;

	/**
	 * Map from each relation to its analysis.
	 */
	private final @NonNull Map<@NonNull Relation, org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationAnalysis> relation2relationAnalysis = new HashMap<>();

	/**
	 * Mapping from each key via the TYpedModel in which it is enforced to its corresponding identification constructor function.
	 */
	private final @NonNull Map<@NonNull Key, @NonNull Map<@NonNull TypedModel, @NonNull Function>> key2typedModel2function = new HashMap<>();

	/**
	 * The Key that identifies each Class.
	 * Multiple keys per class are prohibited by WFRs. See Bug 512532 for rationale.
	 * Singly-derived keys re-use the ancestral key, with a distinct key-class.
	 * Multiply-derived keys are synthesized lazily.
	 * A null value indicates that no key exists.
	 */
	private final @NonNull Map<@NonNull CompleteClass, @Nullable Key> completeClass2key = new HashMap<>();

	private @Nullable QVTrelationDomainUsageAnalysis domainUsageAnalysis = null;

	public TransformationAnalysis(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull RelationalTransformation rTransformation) {
		super(qvtr2qvtc.getEnvironmentFactory());
		this.qvtr2qvtc = qvtr2qvtc;
		this.transformation = rTransformation;
		for (@NonNull Relation relation : QVTrelationUtil.getOwnedRelations(rTransformation)) {
			relation2relationAnalysis.put(relation, new RelationAnalysis(this, relation));
		}
	}

	public void analyze() {
		for (@NonNull Key key : QVTrelationUtil.getOwnedKey(transformation)) {
			analyzeKey(key);
		}
		for (RelationAnalysis relationAnalysis : relation2relationAnalysis.values()) {
			relationAnalysis.analyze();
		}
	}

	protected void analyzeKey(@NonNull Key key) {
		CompleteClass identifies = getCompleteClass(QVTrelationUtil.getIdentifies(key));
		completeClass2key.put(identifies, key);
	}

	public @NonNull DomainUsageAnalysis getDomainUsageAnalysis() {
		QVTrelationDomainUsageAnalysis domainUsageAnalysis2 = domainUsageAnalysis;
		if (domainUsageAnalysis2 == null) {
			domainUsageAnalysis = domainUsageAnalysis2 = new QVTrelationDomainUsageAnalysis(environmentFactory);
			domainUsageAnalysis2.analyzeTransformation(transformation);
		}
		return domainUsageAnalysis2;
	}

	/**
	 * Return the Key for completeClass, returning null if none, or an explicit key if defined,
	 * or a synthesized key if singly/multiply inherited.
	 */
	public @Nullable Key getKeyForCompleteClass(@NonNull CompleteClass completeClass) {
		Key key = completeClass2key.get(completeClass);
		if ((key == null) && !completeClass2key.containsKey(completeClass)) {
			Set<@NonNull Property> parts = null;
			for (@NonNull CompleteClass superCompleteClass : completeClass.getProperSuperCompleteClasses()) {
				Key superKey = getKeyForCompleteClass(superCompleteClass);
				if (superKey != null) {
					if (parts == null) {
						parts = new HashSet<>();
					}
					for (@NonNull Property property : QVTrelationUtil.getOwnedParts(superKey)) {
						parts.add(property);
					}
					for (@NonNull Property property : QVTrelationUtil.getOwnedOppositeParts(superKey)) {
						parts.add(QVTrelationUtil.getOpposite(property));
					}
				}
			}
			if (parts != null) {
				key = createKey(completeClass.getPrimaryClass(), parts);
			}
			completeClass2key.put(completeClass, key);
		}
		return key;
	}

	public @Nullable Key getKeyForType(@NonNull Type type) {
		CompleteClass completeClass = getCompleteClass(type);
		return getKeyForCompleteClass(completeClass);
	}

	public @NonNull Function getKeyFunction(@NonNull TypedModel rTypedModel, @NonNull Key rKey) {
		Map<@NonNull TypedModel, @NonNull Function> typedModel2function = key2typedModel2function.get(rKey);
		if (typedModel2function == null) {
			typedModel2function = new HashMap<>();
			key2typedModel2function.put(rKey, typedModel2function);
		}
		Function cKeyFunction = typedModel2function.get(rTypedModel);
		if (cKeyFunction == null) {
			Iterable<org.eclipse.ocl.pivot.@NonNull Class> usedClasses = QVTrelationUtil.getUsedClasses(rTypedModel);
			org.eclipse.ocl.pivot.@NonNull Class identifiedClass = QVTrelationUtil.getIdentifies(rKey);
			assert (Iterables.contains(usedClasses, identifiedClass));
			QVTr2QVTc.SYNTHESIS.println("key " + rKey);
			Key2FunctionForIdentification keyToMapping = new Key2FunctionForIdentification(qvtr2qvtc, rTypedModel, rKey);
			cKeyFunction = keyToMapping.transform();
			qvtr2qvtc.getRelationalTransformation2CoreTransformation(this).getCoreTransformation().getOwnedOperations().add(cKeyFunction);
			typedModel2function.put(rTypedModel, cKeyFunction);
		}
		return cKeyFunction;
	}

	@Override
	public String getName() {
		return transformation.getName();
	}

	public @NonNull QVTr2QVTc getQVTr2QVTc() {
		return qvtr2qvtc;
	}

	public @NonNull RelationalTransformation2TracePackage getRelationalTransformation2TracePackage() {
		return qvtr2qvtc.getRelationalTransformation2TracePackage(this);
	}

	public @NonNull RelationAnalysis getRelationAnalysis(@NonNull Relation relation) {
		RelationAnalysis relationAnalysis = relation2relationAnalysis.get(relation);
		if (relationAnalysis != null) {
			return relationAnalysis;
		}
		TransformationAnalysis transformationAnalysis = qvtr2qvtc.getTransformationAnalysis(QVTrelationUtil.getContainingTransformation(relation));
		if (transformationAnalysis != this) {
			return transformationAnalysis.getRelationAnalysis(relation);
		}
		throw new IllegalStateException("No RelationAnalysis for '" + relation + "'");
	}

	public @NonNull RelationalTransformation getTransformation() {
		return transformation;
	}

	@Override
	public @NonNull String toString() {
		return String.valueOf(transformation);
	}
}
