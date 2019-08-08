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

	public DirectedDomainUsageAnalysis(@NonNull RootDomainUsageAnalysis domainUsageAnalysis) {
		this.domainUsageAnalysis = domainUsageAnalysis;
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

	public void analyzeTransformation(@Nullable Iterable<@NonNull TypedModel> outputTypedModels) {
		int unenforceableMask = 0;
		int enforceableMask = 0;
		Transformation transformation = domainUsageAnalysis.getTransformation();
		for (@NonNull TypedModel typedModel : QVTbaseUtil.getModelParameters(transformation)) {
			if (!typedModel.isIsPrimitive()) {
				DomainUsage domainUsage = domainUsageAnalysis.getUsage(typedModel);
				int bitMask = domainUsage.getMask();
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
					enforceableMask |= bitMask;
				}
				if (isUnenforceable) {
					unenforceableMask |= bitMask;
				}
			}
		}
		setInputUsage(unenforceableMask);
		setOutputUsage(enforceableMask);
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
