/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.usage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.common.TypedModelConfiguration;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.usage.RootDomainUsageAnalysis.DomainUsageConstant;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;

import com.google.common.collect.Iterables;

public class DirectedDomainUsageAnalysis implements DomainUsageAnalysis.Root
{
	protected final @NonNull RootDomainUsageAnalysis domainUsageAnalysis;
	protected final @NonNull TypedModelsConfiguration typedModelsConfiguration;

	/**
	 * The properties of the input models that are assigned by mappings and which cannot therefore
	 * be trusted to be loaded from the input models.
	 */
	private final @NonNull Set<@NonNull Property> dirtyProperties = new HashSet<>();
	private final @NonNull Set<@NonNull EReference> dirtyEReferences = new HashSet<>();

	/**
	 * The TypedModels that are only checkable.
	 */
	private DomainUsageConstant inputUsage = null;

	/**
	 * The TypedModels that are enforceable and then checkable.
	 */
	private DomainUsageConstant intermediateUsage = null;

	/**
	 * The TypedModels that are only enforceable.
	 */
	private DomainUsageConstant outputUsage = null;

	/**
	 * Direction of each domain.
	 */
	private @NonNull Map<@NonNull Domain, @NonNull Boolean> domain2isOutput = new HashMap<>();

	public DirectedDomainUsageAnalysis(@NonNull RootDomainUsageAnalysis domainUsageAnalysis, @NonNull TypedModelsConfiguration typedModelsConfiguration) {
		this.domainUsageAnalysis = domainUsageAnalysis;
		this.typedModelsConfiguration = typedModelsConfiguration;
	}

	protected void addDirtyProperty(@NonNull Property property) {
		dirtyProperties.add(property);
		EObject eProperty = property.getESObject();
		if (eProperty instanceof EReference) {
			dirtyEReferences.add((EReference) eProperty);
		}
	}

	protected void analyzeIntermediateTypedModels() {		// See Bug 552098 for a full capability
		//		for (@NonNull TypedModelConfiguration typedModelConfiguration : typedModelConfigurations) {
		//
		//		}
	}

	protected void analyzePropertyAssignments(@NonNull Transformation transformation) {
		for (@NonNull Property dirtyProperty : dirtyProperties) {
			if (!dirtyProperty.isIsTransient()) {
				QVTruntimeUtil.errPrintln("Dirty " + dirtyProperty + " is not transient");
			}
			if (dirtyProperty.isIsReadOnly()) {
				QVTruntimeUtil.errPrintln("Dirty " + dirtyProperty + " is readonly");
			}
			if (dirtyProperty.isIsRequired()) {
				QVTruntimeUtil.errPrintln("Dirty " + dirtyProperty + " is required");
			}
		}
	}

	protected @NonNull Map<@NonNull Domain, @NonNull Boolean> analyzeRelations(@NonNull Transformation transformation) {
		Map<@Nullable TypedModel, @NonNull Integer> typedModel2inputDistance = analyzeTypedModelDistances();
		Integer globalOutputDistance = typedModel2inputDistance.get(null);
		assert globalOutputDistance != null;
		Map<@NonNull Domain, @NonNull Boolean> domain2direction = new HashMap<>();
		Iterable<@NonNull TypedModel> outputTypedModels = typedModelsConfiguration.getOutputTypedModels();
		for (@NonNull Rule rule : QVTbaseUtil.getOwnedRules(transformation)) {
			Integer minimumExplicitOutputDistance = null;
			Integer maximumDistance = null;
			boolean hasIntermediate = false;
			for (@NonNull Domain domain : QVTbaseUtil.getOwnedDomains(rule)) {
				TypedModel typedModel = QVTbaseUtil.getTypedModel(domain);
				if (!typedModel.isIsPrimitive() && !typedModel.isIsTrace() && !typedModel.isIsThis()) {
					Boolean isOutput = null;
					Integer distance = typedModel2inputDistance.get(typedModel);
					assert distance != null;
					if (distance >= globalOutputDistance) {
						isOutput = Boolean.TRUE;							// A configured output-only TypedModel
					}
					else if (domain.isNotOutput()) {
						isOutput = Boolean.FALSE;							// A programmed input-only Domain
					}
					else if (distance <= 0) {
						if (!Iterables.contains(outputTypedModels, typedModel)) {
							isOutput = Boolean.FALSE;						// A configured input-only TypedModel
						}
					}
					// else A configured intermediate TypedModel or input_output TypedModel
					if (isOutput == Boolean.TRUE) {
						if ((minimumExplicitOutputDistance == null) || (distance <= minimumExplicitOutputDistance)) {
							minimumExplicitOutputDistance = distance;
						}
					}
					if (isOutput != null) {
						domain2direction.put(domain, isOutput);
					}
					else {
						hasIntermediate = true;
					}
					if ((maximumDistance == null) || (distance > maximumDistance)) {
						maximumDistance = distance;
					}
				}
			}
			if (hasIntermediate) {
				assert maximumDistance != null;
				Integer outputDistance = minimumExplicitOutputDistance != null ? minimumExplicitOutputDistance : maximumDistance;
				for (@NonNull Domain domain : QVTbaseUtil.getOwnedDomains(rule)) {
					if (!domain2direction.containsKey(domain)) {
						TypedModel typedModel = QVTbaseUtil.getTypedModel(domain);
						if (!typedModel.isIsPrimitive() && !typedModel.isIsTrace() && !typedModel.isIsThis()) {
							Integer distance = typedModel2inputDistance.get(typedModel);
							assert distance != null;
							assert distance < globalOutputDistance;
							if (distance == 0) {
								distance = globalOutputDistance;
							}
							Boolean isOutput = distance >= outputDistance;
							domain2direction.put(domain, isOutput);
						}
					}
				}
			}
		}
		return domain2direction;
	}

	public void analyzeTransformation() {
		//		Iterable<@NonNull TypedModel> outputTypedModels = typedModelsConfiguration.getOutputTypedModels();
		int inputMask = 0;
		int intermediateMask = 0;
		int outputMask = 0;
		//		int inputMask2 = 0;
		//		int intermediateMask2 = 0;
		//		int outputMask2 = 0;
		Transformation transformation = domainUsageAnalysis.getTransformation();
		for (@NonNull TypedModel typedModel : QVTbaseUtil.getModelParameters(transformation)) {
			if (!typedModel.isIsPrimitive() && !typedModel.isIsThis() && !typedModel.isIsTrace()) {
				DomainUsage domainUsage = domainUsageAnalysis.getUsage(typedModel);
				int bitMask = domainUsage.getMask();
				//				if (typedModelsConfiguration != null) {
				TypedModelConfiguration typedModelConfiguration = typedModelsConfiguration.getTypedModelConfiguration(typedModel);
				if (typedModelConfiguration.isInput()) {
					inputMask |= bitMask;
				}
				if (typedModelConfiguration.isIntermediate()) {
					intermediateMask |= bitMask;
				}
				if (typedModelConfiguration.isOutput()) {
					outputMask |= bitMask;
				}
			}
			/*				else {		// FIXME legacy path for MyQVT.checkAnalysis
					boolean isEnforceable = false;
					boolean isUnenforceable = false;
					for (@NonNull Rule rule : QVTbaseUtil.getRule(transformation)) {
						for (@NonNull Domain domain : QVTbaseUtil.getOwnedDomains(rule)) {
							if (domain.getTypedModel() == typedModel) {
								if (domain.isIsEnforceable() && ((outputTypedModels == null) || Iterables.contains(outputTypedModels, typedModel))) {
									isEnforceable = true;
								}
								else {
									isUnenforceable = true;
								}
							}
						}
					}
					if (isEnforceable) {
						outputMask |= bitMask;
					}
					if (isUnenforceable) {
						inputMask |= bitMask;
					}
				}
			} */
		}
		//		if ((inputMask != inputMask2) /*|| (intermediateMask != intermediateMask2)*/ || (outputMask != outputMask2)) {
		//			assert false; //getClass();
		//		}
		setInputUsage(inputMask);
		setIntermediateUsage(intermediateMask);
		setOutputUsage(outputMask);
		analyzePropertyAssignments(transformation);
		if (intermediateMask != 0) {
			analyzeIntermediateTypedModels();
		}
		domain2isOutput = analyzeRelations(transformation);
	}

	/**
	 * Compute the distance of each TypedModel from the inputs. in-out TypedModels are indexed as inputs.
	 * The output distance is available by indexing the null TypedModel.
	 */
	protected @NonNull Map<@Nullable TypedModel, @NonNull Integer> analyzeTypedModelDistances() {
		Map<@Nullable TypedModel, @NonNull Integer> typedModel2inputDistance = new HashMap<>();
		Iterable<@NonNull TypedModel> inputTypedModels = typedModelsConfiguration.getInputTypedModels();
		Iterable<@NonNull TypedModel> intermediateTypedModels = typedModelsConfiguration.getIntermediateTypedModels();
		Iterable<@NonNull TypedModel> outputTypedModels = typedModelsConfiguration.getOutputTypedModels();
		int distance = 0;
		for (@NonNull TypedModel inputTypedModel : inputTypedModels) {
			assert !Iterables.contains(intermediateTypedModels, inputTypedModel);
			// NB there may be input+output TypedModels
			typedModel2inputDistance.put(inputTypedModel, distance);
		}
		for (@NonNull TypedModel intermediateTypedModel : intermediateTypedModels) {
			assert !Iterables.contains(inputTypedModels, intermediateTypedModel);
			assert !Iterables.contains(outputTypedModels, intermediateTypedModel);
			typedModel2inputDistance.put(intermediateTypedModel, ++distance);
		}
		typedModel2inputDistance.put(null, ++distance);
		for (@NonNull TypedModel outputTypedModel : outputTypedModels) {
			assert !Iterables.contains(intermediateTypedModels, outputTypedModel);
			// NB there may be input+output TypedModels
			if (!typedModel2inputDistance.containsKey(outputTypedModel)) {
				typedModel2inputDistance.put(outputTypedModel, distance);
			}
		}
		return typedModel2inputDistance;
	}

	@Override
	public @Nullable DomainUsage basicGetUsage(@Nullable Element element) {
		return domainUsageAnalysis.basicGetUsage(element);
	}

	public @NonNull DomainUsage getInputUsage() {
		return ClassUtil.nonNullState(inputUsage);
	}

	public @NonNull DomainUsage getIntermediateUsage() {
		return ClassUtil.nonNullState(intermediateUsage);
	}

	public @NonNull DomainUsage getOutputUsage() {
		return ClassUtil.nonNullState(outputUsage);
	}

	@Override
	public @NonNull DomainUsage getUsage(@NonNull Element element) {
		return domainUsageAnalysis.getUsage(element);
	}

	@Deprecated
	@Override
	public @NonNull DomainUsage getConstantUsage(int bitMask) {
		return domainUsageAnalysis.getConstantUsage(bitMask);
	}

	@Override
	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return domainUsageAnalysis.getEnvironmentFactory();
	}

	/**
	 * Return true if a mapping may assign this property in an input model.
	 */
	public boolean isDirty(@NonNull EReference eReference) {
		return dirtyEReferences.contains(eReference);
	}

	/**
	 * Return true if a mapping may assign this property in an input model.
	 */
	public boolean isDirty(@NonNull Property property) {
		return property.isIsTransient() || dirtyProperties.contains(property);
	}

	public boolean isInput(@NonNull DomainUsage usage) {
		return (usage.getMask() & inputUsage.bitMask) != 0;
	}

	public boolean isInputInRule(@NonNull Rule rule, @NonNull Element element) {
		if ((element instanceof Parameter) && QVTbaseUtil.isThis((Parameter)element)) {
			return false;
		}
		assert rule == QVTbaseUtil.getContainingRule(element);
		DomainUsage usage = getUsage(element);
		TypedModel typedModel = usage.getTypedModel(element);
		assert typedModel != null;
		if (typedModel.isIsPrimitive() || typedModel.isIsThis() || typedModel.isIsTrace()) {
			return false;
		}
		Domain domain2 = QVTbaseUtil.getDomain(rule, typedModel);
		//		Boolean isOutput = domain2isOutput.get(element);
		Boolean isOutput2 = domain2isOutput.get(domain2);
		//		assert isOutput != null;
		assert isOutput2 != null;
		//		assert isOutput == isOutput2;
		return !isOutput2;
	}

	public boolean isIntermediate(@NonNull DomainUsage usage) {
		return (usage.getMask() & intermediateUsage.bitMask) != 0;
	}

	public boolean isOutput(@NonNull DomainUsage usage) {
		return (usage.getMask() & outputUsage.bitMask) != 0;
	}

	public boolean isOutputInRule(@NonNull Rule rule, @NonNull Element element) {
		if ((element instanceof Parameter) && QVTbaseUtil.isThis((Parameter)element)) {
			return false;
		}
		assert rule == QVTbaseUtil.basicGetContainingRule(element);
		DomainUsage usage = getUsage(element);
		TypedModel typedModel = usage.getTypedModel(element);
		assert typedModel != null;
		if (typedModel.isIsPrimitive() || typedModel.isIsThis() || typedModel.isIsTrace()) {
			return false;
		}
		Domain domain2 = QVTbaseUtil.getDomain(rule, typedModel);
		//		Boolean isOutput = domain2isOutput.get(element);
		Boolean isOutput2 = domain2isOutput.get(domain2);
		//		assert isOutput != null;
		assert isOutput2 != null;
		//		assert isOutput == isOutput2;
		return isOutput2;
	}

	protected void setInputUsage(int inputMask) {
		int anyMask = domainUsageAnalysis.getAnyMask();
		inputUsage = domainUsageAnalysis.getConstantUsage(anyMask & inputMask);
	}

	protected void setIntermediateUsage(int intermediateMask) {
		int anyMask = domainUsageAnalysis.getAnyMask();
		intermediateUsage = domainUsageAnalysis.getConstantUsage(anyMask & intermediateMask);
	}

	protected void setOutputUsage(int outputMask) {
		int anyMask = domainUsageAnalysis.getAnyMask();
		outputUsage = domainUsageAnalysis.getConstantUsage(anyMask & outputMask);
	}
}
