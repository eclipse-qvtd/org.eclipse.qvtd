/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationalTransformation2TracePackage;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationHelper;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;

/**
 * RelationalTransformationAnalysis provides the QVTr management of ClassDatum and PropertyDatum usage by regions for a RegionsAnalysis.
 */
public class RelationalTransformationAnalysis extends AbstractTransformationAnalysis
{
	protected final @NonNull QVTrelationHelper helper;

	/**
	 * Mapping from each key via the TypedModel in which it is enforced to its corresponding identification constructor function.
	 */
	//	private final @NonNull Map<@NonNull Key, @NonNull Map<@NonNull TypedModel, @NonNull Function>> key2typedModel2function = new HashMap<>();

	/**
	 * The Key that identifies each Class.
	 * Multiple keys per class are prohibited by WFRs. See Bug 512532 for rationale.
	 * Singly-derived keys re-use the ancestral key, with a distinct key-class.
	 * Multiply-derived keys are synthesized lazily.
	 * A null value indicates that no key exists.
	 */
	private final @NonNull Map<@NonNull CompleteClass, @Nullable Key> completeClass2key  = new HashMap<>();

	private static @NonNull Iterable<@NonNull Rule> computeRules(@NonNull TypedModelsConfiguration typedModelsConfiguration, @NonNull Transformation transformation) {
		Iterable<@NonNull TypedModel> outputOnlyTypedModels = typedModelsConfiguration.getOutputOnlyTypedModels();
		Iterable<@NonNull TypedModel> unusedTypedModels = typedModelsConfiguration.getUnusedTypedModels();
		List<@NonNull Rule> rules = new ArrayList<>();
		for (@NonNull Rule asRule : QVTbaseUtil.getOwnedRules(transformation)) {
			boolean isExecutable = true;
			for (@NonNull TypedModel typedModel : outputOnlyTypedModels) {
				Domain domain = QVTrelationUtil.basicGetDomain(asRule, typedModel);
				if ((domain != null) && domain.isNotOutput()) {
					isExecutable = false;
				}
			}
			for (@NonNull TypedModel typedModel : unusedTypedModels) {
				Domain domain = QVTrelationUtil.basicGetDomain(asRule, typedModel);
				if (domain != null) {
					isExecutable = false;
				}
			}
			if (isExecutable) {
				rules.add(asRule);
			}
			else {
				//	System.out.println("Omitting dead rule '" + asRule.getName() + "'");
			}
		}
		return rules;
	}

	public RelationalTransformationAnalysis(@NonNull QVTrelationDirectedScheduleManager directedScheduleManager, @NonNull RelationalTransformation transformation, @NonNull RootRegion rootRegion) {
		super(directedScheduleManager, transformation, computeRules(directedScheduleManager.getTypedModelsConfiguration(), transformation), rootRegion);
		this.helper = new QVTrelationHelper(directedScheduleManager.getEnvironmentFactory());
		QVTbaseUtil.getPrimitiveTypedModel(transformation);		// FIXME debugging the must-exist side effect
		//		transformation.getModelParameter().add(0, directedScheduleManager.getDomainUsageAnalysis().getPrimitiveTypedModel());		// FIXME move to source
	}

	protected void analyzeKey(@NonNull Key key) {
		org.eclipse.ocl.pivot.Class keyedClass = QVTrelationUtil.getIdentifies(key);
		CompleteClass keyedCompleteClass = getCompleteClass(keyedClass);
		completeClass2key.put(keyedCompleteClass, key);
		TypedModel typedModel = scheduleManager.getDomainUsage(key).getTypedModel(transformation);
		assert typedModel != null;
		ClassDatum classDatum = scheduleManager.getClassDatum(typedModel, keyedClass);
		for (@NonNull Property part : QVTrelationUtil.getOwnedParts(key)) {
			PropertyDatum propertyDatum = scheduleManager.getPropertyDatum(classDatum, part);
			propertyDatum.setKey(true);
		}
		for (@NonNull Property oppositePart : QVTrelationUtil.getOwnedOppositeParts(key)) {
			Property part = QVTrelationUtil.getOpposite(oppositePart);
			PropertyDatum propertyDatum = scheduleManager.getPropertyDatum(classDatum, part);
			propertyDatum.setKey(true);
		}
	}

	@Override
	public void analyzeSourceModel(@NonNull ProblemHandler problemHandler) {
		for (@NonNull Key key : QVTrelationUtil.getOwnedKey(getTransformation())) {
			analyzeKey(key);
		}
		super.analyzeSourceModel(problemHandler);
	}

	@Override
	public @Nullable RelationAnalysis basicGetRuleAnalysis(@NonNull Rule rule) {
		return (RelationAnalysis) super.basicGetRuleAnalysis(rule);
	}

	/**
	 * Return the Key for completeClass, returning null if none, or an explicit key if defined,
	 * or a synthesized key if singly/multiply inherited.
	 *
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
				key = helper.createKey(completeClass.getPrimaryClass(), parts);
			}
			completeClass2key.put(completeClass, key);
		}
		return key;
	} */

	/**
	 * Return the Key for type, returning null if none, or an explicit key if defined.
	 * NB there are no inherited keys and no applicability of keys to derived classes.
	 */
	public @Nullable Key getKeyForType(@NonNull Type type) {
		CompleteClass completeClass = getCompleteClass(type);
		return completeClass2key.get(completeClass);
	}

	@Override
	public @NonNull RelationAnalysis getRuleAnalysis(@NonNull Rule rule) {
		return (RelationAnalysis) super.getRuleAnalysis(rule);
	}

	/*	public @NonNull Function getKeyFunction(@NonNull TypedModel rTypedModel, @NonNull Key rKey) {
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
			//			QVTr2QVTc.SYNTHESIS.println("key " + rKey);
			throw new UnsupportedOperationException();
			//			Key2FunctionForIdentification keyToMapping = new Key2FunctionForIdentification(getScheduleManager(), rTypedModel, rKey);
			//			cKeyFunction = keyToMapping.transform();
			//			scheduleManager.getRelationalTransformation2CoreTransformation(this).getCoreTransformation().getOwnedOperations().add(cKeyFunction);
			//			typedModel2function.put(rTypedModel, cKeyFunction);
		}
		return cKeyFunction;
	} */

	@Override
	public @NonNull QVTrelationDirectedScheduleManager getScheduleManager() {
		return (QVTrelationDirectedScheduleManager) scheduleManager;
	}

	@Override
	public @NonNull RelationalTransformation getTransformation() {
		return (RelationalTransformation) super.getTransformation();
	}

	@Override
	public @NonNull RelationalTransformation2TracePackage getTransformation2TracePackage() {
		return (RelationalTransformation2TracePackage)super.getTransformation2TracePackage();
	}
}
