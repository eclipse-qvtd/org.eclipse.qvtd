/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.atl.atl2qvtr.utilities;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.m2m.atl.common.ATL.Module;
import org.eclipse.m2m.atl.common.OCL.BooleanType;
import org.eclipse.m2m.atl.common.OCL.IntegerType;
import org.eclipse.m2m.atl.common.OCL.OclModel;
import org.eclipse.m2m.atl.common.OCL.OclModelElement;
import org.eclipse.m2m.atl.common.OCL.OclType;
import org.eclipse.m2m.atl.common.OCL.RealType;
import org.eclipse.m2m.atl.common.OCL.StringType;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.evaluation.Executor;

public class HelperUtils
{
	public static org.eclipse.ocl.pivot.@Nullable Package getPackage(@NonNull Executor executor, @NonNull Module atlModule, @NonNull String packageName) {
		for (String comment : atlModule.getCommentsBefore()) {
			String trimmedComment = comment.trim();
			if (trimmedComment.startsWith("--")) {
				trimmedComment = trimmedComment.substring(2).trim();
				if (trimmedComment.startsWith("@nsURI")) {
					trimmedComment = trimmedComment.substring(6).trim();
					int index = trimmedComment.indexOf("=");
					if (index >= 0) {
						String key = trimmedComment.substring(0, index).trim();
						if (key.equals(packageName)) {
							String value = trimmedComment.substring(index+1).trim();
						}
					}
				}
				else if (trimmedComment.startsWith("@path")) {
					trimmedComment = trimmedComment.substring(5).trim();
					int index = trimmedComment.indexOf("=");
					if (index >= 0) {
						String key = trimmedComment.substring(0, index).trim();
						if (key.equals(packageName)) {
							String value = trimmedComment.substring(index+1).trim();
							URI uri = URI.createPlatformResourceURI(value, true);
							if (!uri.hasFragment()) {
								uri = uri.appendFragment("/");
							}
							EObject eObject = executor.getEnvironmentFactory().getResourceSet().getEObject(uri, true);
							return executor.getEnvironmentFactory().getMetamodelManager().getASOfEcore(org.eclipse.ocl.pivot.Package.class, eObject);
						}
					}
				}
			}
		}
		return null;
	}

	public static org.eclipse.ocl.pivot.@Nullable Class getClass(@NonNull Executor executor, @NonNull Module atlModule,
			@NonNull String packageName, @NonNull String className) {
		org.eclipse.ocl.pivot.@Nullable Package asPackage = getPackage(executor, atlModule, packageName);
		if (asPackage != null) {
			org.eclipse.ocl.pivot.Class asClass = asPackage.getOwnedClass(className);
			if (asClass != null) {
				return asClass;
			}
		}
		return null;
	}

	public static org.eclipse.ocl.pivot.@NonNull Class getType(@NonNull Executor executor, @NonNull OclType atlType) {
		StandardLibrary standardLibrary = executor.getStandardLibrary();
		if (atlType instanceof BooleanType) {
			return standardLibrary.getBooleanType();
		}
		else if (atlType instanceof IntegerType) {
			return standardLibrary.getIntegerType();
		}
		else if (atlType instanceof RealType) {
			return standardLibrary.getRealType();
		}
		else if (atlType instanceof StringType) {
			return standardLibrary.getStringType();
		}
		else if (atlType instanceof OclModelElement) {
			OclModelElement oclModelElement = (OclModelElement)atlType;
			OclModel metamodel = oclModelElement.getModel();
			//			OclModel metamodel = model.getMetamodel();
			Module atlModule = (Module) EcoreUtil.getRootContainer(oclModelElement);
			assert atlModule != null;
			String packageName = metamodel.getName();
			assert packageName != null;
			String className = oclModelElement.getName();
			assert className != null;
			org.eclipse.ocl.pivot.Class asClass = HelperUtils.getClass(executor, atlModule, packageName, className);
			if (asClass != null) {
				return asClass;
			}
			return standardLibrary.getOclInvalidType();
		}
		else {
			return standardLibrary.getOclInvalidType();
		}
	}
}
