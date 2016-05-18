/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;
import org.eclipse.qvtd.pivot.qvtrelation.Key;

/**
 * KeyToMappingForIdentification synthesizes a Core constructor function/querythat enforces the uniqueness of a realized variable
 * with respect to its key parts.
 */
public class KeyToFunctionForIdentification
{
	protected final @NonNull QVTr2QVTc qvtr2qvtc;
	protected final @NonNull Key rKey;
	
	public KeyToFunctionForIdentification(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull Key rKey) {
		this.qvtr2qvtc = qvtr2qvtc;
		this.rKey = rKey;
	}

	public @NonNull Function transform() throws CompilerChainException {
		QVTcoreHelper helper = qvtr2qvtc.getHelper();
		String functionName = qvtr2qvtc.createKeyFunctionName(rKey);
		List<@NonNull FunctionParameter> asParameters = new ArrayList<@NonNull FunctionParameter>();
		List<@NonNull ShadowPart> asShadowParts = new ArrayList<@NonNull ShadowPart>();
		for (@NonNull Property keyProperty : ClassUtil.nullFree(rKey.getPart())) {
			FunctionParameter cParameter = helper.createFunctionParameter(keyProperty);
			asParameters.add(cParameter);
			ShadowPart asShadowPart = helper.createShadowPart(keyProperty, helper.createVariableExp(cParameter));
			asShadowParts.add(asShadowPart);
		}
		for (@NonNull Property keyOppositeProperty : ClassUtil.nullFree(rKey.getOppositePart())) {
			Property keyProperty = ClassUtil.nonNullState(keyOppositeProperty.getOpposite());
			FunctionParameter cParameter = helper.createFunctionParameter(keyProperty);
			asParameters.add(cParameter);
			ShadowPart asShadowPart = helper.createShadowPart(keyProperty, helper.createVariableExp(cParameter));
			asShadowParts.add(asShadowPart);
		}
		Collections.sort(asParameters, NameUtil.NAMEABLE_COMPARATOR);
		org.eclipse.ocl.pivot.@NonNull Class identifiedClass = ClassUtil.nonNullState(rKey.getIdentifies());
		Function cFunction = helper.createFunction(functionName, identifiedClass, true, asParameters);
		OCLExpression asShadowExp = helper.createShadowExp(identifiedClass, asShadowParts);
		cFunction.setQueryExpression(asShadowExp);
		return cFunction;
	}
}
