/*******************************************************************************
 * Copyright (c) 2014, 2015 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/*public*/ class RelationalTransformationToMappingTransformation
{	
	protected final @NonNull QVTrToQVTc qvtr2qvtc;

	public RelationalTransformationToMappingTransformation(@NonNull QVTrToQVTc qvtr2qvtc) {
		this.qvtr2qvtc = qvtr2qvtc;
	}
	
	public @NonNull Transformation doRelationalTransformationToMappingTransformation(@NonNull RelationalTransformation relationalTransformation) {
		org.eclipse.ocl.pivot.@NonNull Package corePackage = qvtr2qvtc.getTracePackage(relationalTransformation);
		//
		//	Create the core Transformation
		//
		@NonNull Transformation coreTransformation = QVTbaseFactory.eINSTANCE.createTransformation();
		coreTransformation.setName(relationalTransformation.getName());
		qvtr2qvtc.putCoreTransformation(relationalTransformation, coreTransformation);
		List<TypedModel> coreModelParameters = coreTransformation.getModelParameter();
		//
		//	Create the middle TypedModel
		//
		@NonNull TypedModel coreMiddleTypedModel =  QVTbaseFactory.eINSTANCE.createTypedModel();
		coreMiddleTypedModel.setName(null);
		coreMiddleTypedModel.getUsedPackage().add(corePackage);
		coreModelParameters.add(coreMiddleTypedModel);
		//
		//	Create a non-middle TypedModel per model parameter
		//
		for (@NonNull TypedModel relationTypedModel : ClassUtil.nullFree(relationalTransformation.getModelParameter())) {
			@NonNull TypedModel coreTypedModel =  QVTbaseFactory.eINSTANCE.createTypedModel();
			coreTypedModel.setName(relationTypedModel.getName());
			coreTypedModel.getUsedPackage().addAll(relationTypedModel.getUsedPackage());
			coreModelParameters.add(coreTypedModel);
		}
		return coreTransformation;
	}
}
