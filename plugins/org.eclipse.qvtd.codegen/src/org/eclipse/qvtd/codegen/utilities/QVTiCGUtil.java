/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGAccumulator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;

public class QVTiCGUtil extends CGUtil
{
	public static @NonNull Mapping getAST(@NonNull CGMapping cgMapping) {
		return ClassUtil.nonNullState((Mapping) cgMapping.getAst());
	}

	public static @Nullable CGMapping basicGetContainingCGMapping(@NonNull CGElement cgElement) {
		for (EObject eObject = cgElement; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof CGMapping) {
				return (CGMapping)eObject;
			}
		}
		return null;
	}

	public static @NonNull MappingCall getAST(@NonNull CGMappingCall cgMappingCall) {
		return ClassUtil.nonNullState((MappingCall)cgMappingCall.getAst());
	}

	public static @NonNull ImperativeTransformation getAST(@NonNull CGTransformation cgTransformation) {
		return ClassUtil.nonNullState((ImperativeTransformation)cgTransformation.getAst());
	}

	public static @NonNull CGMapping getContainingCGMapping(@NonNull CGElement cgElement) {
		return ClassUtil.nonNullState(basicGetContainingCGMapping(cgElement));
	}

	public static @NonNull EStructuralFeature getEStructuralFeature(@NonNull CGEcoreContainerAssignment cgContainerAssignment) {
		return ClassUtil.nonNullState(cgContainerAssignment.getEStructuralFeature());
	}

	public static @NonNull EStructuralFeature getEStructuralFeature(@NonNull CGEcorePropertyAssignment cgPropertyAssignment) {
		return ClassUtil.nonNullState(cgPropertyAssignment.getEStructuralFeature());
	}

	public static @NonNull EStructuralFeature getEStructuralFeature(@NonNull CGEcorePropertyCallExp cgPropertyCallExp) {
		return ClassUtil.nonNullState(cgPropertyCallExp.getEStructuralFeature());
	}

	public static @NonNull String getName(@NonNull CGMapping cgMapping) {
		return ClassUtil.nonNullState(cgMapping.getName());
	}

	public static @NonNull String getName(@NonNull CGAccumulator cgAccumulator) {
		return ClassUtil.nonNullState(cgAccumulator.getName());
	}

	public static @NonNull Iterable<@NonNull CGMappingCallBinding> getOwnedMappingCallBindings(@NonNull CGMappingCall cgMappingCall) {
		return ClassUtil.nullFree(cgMappingCall.getOwnedMappingCallBindings());
	}

	public static @NonNull Iterable<@NonNull CGMapping> getOwnedMappings(@NonNull CGTransformation cgTransformation) {
		return ClassUtil.nullFree(cgTransformation.getOwnedMappings());
	}

	public static @NonNull CGMapping getRootMapping(@NonNull CGTransformation cgTransformation) {
		CGMapping cgRootMapping = NameUtil.getNameable(cgTransformation.getOwnedMappings(), QVTimperativeUtil.ROOT_MAPPING_NAME);	// Obsolete relic
		for (@NonNull CGMapping cgMapping : getOwnedMappings(cgTransformation)) {
			Mapping asMapping = getAST(cgMapping);
			boolean isRoot = true;
			for (@NonNull MappingParameter asParameter : QVTimperativeUtil.getOwnedMappingParameters(asMapping)) {
				if (asParameter instanceof GuardParameter) {
					isRoot = false;
					break;
				}
				else if (asParameter instanceof SimpleParameter) {
					isRoot = false;
					break;
				}
			}
			if (isRoot) {
				if (cgRootMapping == null) {
					cgRootMapping = cgMapping;
				}
				else if (cgRootMapping != cgMapping) {
					throw new IllegalStateException("Transformation " + cgTransformation.getName() + " has ambiguous root mappings: " + cgRootMapping + ", " + cgMapping);
				}
			}
		}
		if (cgRootMapping  == null) {
			throw new IllegalStateException("Transformation " + cgTransformation.getName() + " has no root mapping");
		}
		return cgRootMapping;
	}
}
