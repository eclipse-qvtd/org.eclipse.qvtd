/*******************************************************************************
 * Copyright (c) 2014, 2017 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/*public*/ class RelationalTransformationToMappingTransformation
{
	protected final @NonNull QVTr2QVTc qvtr2qvtc;

	public RelationalTransformationToMappingTransformation(@NonNull QVTr2QVTc qvtr2qvtc) {
		this.qvtr2qvtc = qvtr2qvtc;
	}

	private @NonNull TypedModel createTypedModel(@NonNull Transformation coreTransformation, @Nullable String name, @NonNull List<org.eclipse.ocl.pivot.@NonNull Package> usedPackages) {
		TypedModel coreTypedModel =  QVTbaseFactory.eINSTANCE.createTypedModel();
		coreTypedModel.setName(name);
		coreTypedModel.getUsedPackage().addAll(usedPackages);
		coreTransformation.getModelParameter().add(coreTypedModel);
		return coreTypedModel;
	}

	public @NonNull Transformation doRelationalTransformationToMappingTransformation(@NonNull RelationalTransformation relationalTransformation) {
		//
		//	Create the core Transformation
		//
		Transformation coreTransformation = QVTbaseFactory.eINSTANCE.createTransformation();
		coreTransformation.setName(relationalTransformation.getName());
		qvtr2qvtc.putCoreTransformation(relationalTransformation, coreTransformation);
		//
		//	Create the null-named middle TypedModel
		//
		org.eclipse.ocl.pivot.@NonNull Package corePackage = qvtr2qvtc.getTracePackage(relationalTransformation);
		createTypedModel(coreTransformation, null, Collections.singletonList(corePackage));
		//
		//	Create a non-middle TypedModel per model parameter
		//
		for (@NonNull TypedModel relationTypedModel : ClassUtil.nullFree(relationalTransformation.getModelParameter())) {
			TypedModel coreTypedModel = createTypedModel(coreTransformation, relationTypedModel.getName(), ClassUtil.nullFree(relationTypedModel.getUsedPackage()));
			qvtr2qvtc.putTypedModel(relationTypedModel, coreTypedModel);
		}
		for (@NonNull TypedModel relationTypedModel : ClassUtil.nullFree(relationalTransformation.getModelParameter())) {
			if (relationTypedModel.getDependsOn().size() > 0) {
				TypedModel coreTypedModel = qvtr2qvtc.getCoreTypedModel(relationTypedModel);
				for (@NonNull TypedModel relationDependsOn : QVTrelationUtil.getDependsOns(relationTypedModel)) {
					coreTypedModel.getDependsOn().add(qvtr2qvtc.getCoreTypedModel(relationDependsOn));
				}
			}
		}
		return coreTransformation;
	}
}
