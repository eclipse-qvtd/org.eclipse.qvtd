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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.common.TypedModelConfiguration;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.usage.RootDomainUsageAnalysis.DomainUsageConstant;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;

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
	 * The TypedModels that are not enforceable.
	 */
	private DomainUsageConstant inputUsage = null;

	/**
	 * The TypedModels that are enforceable.
	 */
	private DomainUsageConstant outputUsage = null;

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

	public void analyzeTransformation() {
		int inputMask = 0;
		int outputMask = 0;
		Transformation transformation = domainUsageAnalysis.getTransformation();
		for (@NonNull TypedModel typedModel : QVTbaseUtil.getModelParameters(transformation)) {
			if (!typedModel.isIsPrimitive() && !typedModel.isIsThis() && !typedModel.isIsTrace()) {
				DomainUsage domainUsage = domainUsageAnalysis.getUsage(typedModel);
				int bitMask = domainUsage.getMask();
				TypedModelConfiguration typedModelConfiguration = typedModelsConfiguration.getTypedModelConfiguration(typedModel);
				if (typedModelConfiguration.isInput()) {
					inputMask |= bitMask;
				}
				if (typedModelConfiguration.isOutput()) {
					outputMask |= bitMask;
				}
			}
		}
		setInputUsage(inputMask);
		setOutputUsage(outputMask);
		analyzePropertyAssignments(transformation);
	}

	@Override
	public @Nullable DomainUsage basicGetUsage(@Nullable Element element) {
		return domainUsageAnalysis.basicGetUsage(element);
	}

	public @NonNull DomainUsage getInputUsage() {
		return ClassUtil.nonNullState(inputUsage);
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

	public boolean isOutput(@NonNull DomainUsage usage) {
		return (usage.getMask() & outputUsage.bitMask) != 0;
	}

	protected void setInputUsage(int inputMask) {
		int anyMask = domainUsageAnalysis.getAnyMask();
		inputUsage = domainUsageAnalysis.getConstantUsage(anyMask & inputMask);
	}

	protected void setOutputUsage(int outputMask) {
		int anyMask = domainUsageAnalysis.getAnyMask();
		outputUsage = domainUsageAnalysis.getConstantUsage(anyMask & outputMask);
	}
}
