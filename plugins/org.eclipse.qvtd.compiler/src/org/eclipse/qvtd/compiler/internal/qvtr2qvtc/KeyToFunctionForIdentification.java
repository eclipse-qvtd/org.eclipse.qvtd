/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * KeyToMappingForIdentification synthesizes a Core constructor function/query that enforces the uniqueness of a realized variable
 * with respect to its key parts.
 */
public class KeyToFunctionForIdentification
{
	protected final @NonNull QVTr2QVTc qvtr2qvtc;
	protected final @NonNull TypedModel rTypedModel;
	protected final @NonNull Key rKey;

	public KeyToFunctionForIdentification(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull TypedModel rTypedModel, @NonNull Key rKey) {
		this.qvtr2qvtc = qvtr2qvtc;
		this.rTypedModel = rTypedModel;
		this.rKey = rKey;
	}

	public @NonNull Function transform() throws CompilerChainException {
		QVTcoreHelper helper = qvtr2qvtc.getHelper();
		String functionName = qvtr2qvtc.createKeyFunctionName(rTypedModel, rKey);
		List<@NonNull FunctionParameter> asParameters = new ArrayList<>();
		List<@NonNull ShadowPart> asShadowParts = new ArrayList<>();
		//
		//	One shadow part per forward key property
		//
		for (@NonNull Property keyProperty : QVTrelationUtil.getOwnedParts(rKey)) {
			FunctionParameter cParameter = helper.createFunctionParameter(keyProperty);
			asParameters.add(cParameter);
			ShadowPart asShadowPart = helper.createShadowPart(keyProperty, helper.createVariableExp(cParameter));
			asShadowParts.add(asShadowPart);
		}
		//
		//	One shadow part per opposite key property
		//
		for (@NonNull Property keyOppositeProperty : QVTrelationUtil.getOwnedOppositeParts(rKey)) {
			Property keyProperty = QVTrelationUtil.getOpposite(keyOppositeProperty);
			FunctionParameter cParameter = helper.createFunctionParameter(keyProperty);
			asParameters.add(cParameter);
			ShadowPart asShadowPart = helper.createShadowPart(keyProperty, helper.createVariableExp(cParameter));
			asShadowParts.add(asShadowPart);
		}
		Collections.sort(asParameters, NameUtil.NAMEABLE_COMPARATOR);
		org.eclipse.ocl.pivot.@NonNull Class identifiedClass = QVTrelationUtil.getIdentifies(rKey);
		//
		//	One shadow part per uninitialized key property
		//
		CompleteClass completeClass = qvtr2qvtc.getCompleteClass(identifiedClass);
		for (@NonNull Property asProperty : completeClass.getProperties(FeatureFilter.SELECT_NON_STATIC)) {
			if (!asProperty.isIsImplicit() && !asProperty.isIsMany() && (asProperty != qvtr2qvtc.getOclContainerProperty())) {
				boolean gotIt = false;
				for (@NonNull ShadowPart asShadowPart : asShadowParts) {
					if (asShadowPart.getReferredProperty() == asProperty) {
						gotIt = true;
						break;
					}
				}
				if (!gotIt) {
					ShadowPart asShadowPart = helper.createShadowPart(asProperty, helper.createNullLiteralExp());
					asShadowParts.add(asShadowPart);
				}
			}
		}
		Function cFunction = helper.createFunction(functionName, identifiedClass, true, asParameters);
		OCLExpression asShadowExp = helper.createShadowExp(identifiedClass, asShadowParts);
		cFunction.setQueryExpression(asShadowExp);
		return cFunction;
	}
}
