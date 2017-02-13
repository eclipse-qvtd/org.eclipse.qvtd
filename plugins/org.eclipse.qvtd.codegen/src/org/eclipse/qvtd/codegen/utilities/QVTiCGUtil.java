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
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;

public class QVTiCGUtil extends CGUtil
{
	public static @Nullable CGMapping basicGetContainingCGMapping(@NonNull CGElement cgElement) {
		for (EObject eObject = cgElement; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof CGMapping) {
				return (CGMapping)eObject;
			}
		}
		return null;
	}

	public static @NonNull VariableDeclaration getAST(@NonNull CGGuardVariable cgGuardVariable) {
		return ClassUtil.nonNullState((VariableDeclaration)cgGuardVariable.getAst());
	}

	public static @NonNull Mapping getAST(@NonNull CGMapping cgMapping) {
		return ClassUtil.nonNullState((Mapping)cgMapping.getAst());
	}

	public static @NonNull MappingCall getAST(@NonNull CGMappingCall cgMappingCall) {
		return ClassUtil.nonNullState((MappingCall)cgMappingCall.getAst());
	}

	public static @NonNull SetStatement getAST(@NonNull CGPropertyAssignment cgPropertyAssignment) {
		return ClassUtil.nonNullState((SetStatement)cgPropertyAssignment.getAst());
	}

	public static @NonNull NewStatement getAST(@NonNull CGRealizedVariable cgRealizedVariable) {
		return ClassUtil.nonNullState((NewStatement)cgRealizedVariable.getAst());
	}

	public static @NonNull ImperativeTransformation getAST(@NonNull CGTransformation cgTransformation) {
		return ClassUtil.nonNullState((ImperativeTransformation)cgTransformation.getAst());
	}

	public static @NonNull ImperativeTypedModel getAST(@NonNull CGTypedModel cgTypedModel) {
		return ClassUtil.nonNullState((ImperativeTypedModel)cgTypedModel.getAst());
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

	public static @NonNull String getName(@NonNull CGAccumulator cgAccumulator) {
		return ClassUtil.nonNullState(cgAccumulator.getName());
	}

	public static @NonNull String getName(@NonNull CGMapping cgMapping) {
		return ClassUtil.nonNullState(cgMapping.getName());
	}

	public static @NonNull Iterable<@NonNull CGAccumulator> getOwnedAccumulators(@NonNull CGMappingExp cgMappingExp) {
		return ClassUtil.nullFree(cgMappingExp.getOwnedAccumulators());
	}

	public static @NonNull Iterable<@NonNull CGPropertyAssignment> getOwnedAssignments(@NonNull CGMapping cgMapping) {
		return ClassUtil.nullFree(cgMapping.getOwnedAssignments());
	}

	public static @NonNull Iterable<@NonNull CGConnectionAssignment> getOwnedConnectionAssignments(@NonNull CGMapping cgMapping) {
		return ClassUtil.nullFree(cgMapping.getOwnedConnectionAssignments());
	}

	public static @NonNull Iterable<@NonNull CGGuardVariable> getOwnedGuardVariables(@NonNull CGMapping cgRootMapping) {
		return ClassUtil.nullFree(cgRootMapping.getOwnedGuardVariables());
	}

	public static @NonNull CGValuedElement getOwnedInitValue(@NonNull CGConnectionAssignment cgConnectionAssignment) {
		return ClassUtil.nonNullState(cgConnectionAssignment.getOwnedInitValue());
	}

	public static @NonNull CGValuedElement getOwnedInitValue(@NonNull CGPropertyAssignment cgPropertyAssignment) {
		return ClassUtil.nonNullState(cgPropertyAssignment.getOwnedInitValue());
	}

	public static @NonNull Iterable<@NonNull CGMappingCallBinding> getOwnedMappingCallBindings(@NonNull CGMappingCall cgMappingCall) {
		return ClassUtil.nullFree(cgMappingCall.getOwnedMappingCallBindings());
	}

	public static @NonNull Iterable<@NonNull CGMapping> getOwnedMappings(@NonNull CGTransformation cgTransformation) {
		return ClassUtil.nullFree(cgTransformation.getOwnedMappings());
	}

	public static @NonNull Iterable<@NonNull CGRealizedVariable> getOwnedRealizedVariables(@NonNull CGMapping cgMapping) {
		return ClassUtil.nullFree(cgMapping.getOwnedRealizedVariables());
	}

	public static @NonNull CGValuedElement getOwnedSlotValue(@NonNull CGPropertyAssignment cgPropertyAssignment) {
		return ClassUtil.nonNullState(cgPropertyAssignment.getOwnedSlotValue());
	}

	public static @NonNull Iterable<@NonNull CGTypedModel> getOwnedTypedModels(@NonNull CGTransformation cgTransformation) {
		return ClassUtil.nullFree(cgTransformation.getOwnedTypedModels());
	}

	public static @NonNull CGMapping getOwningMapping(@NonNull CGRealizedVariable cgRealizedVariable) {
		return ClassUtil.nonNullState(cgRealizedVariable.getOwningMapping());
	}

	public static @NonNull CGTransformation getOwningTransformation(@NonNull CGMapping cgMapping) {
		return ClassUtil.nonNullState(cgMapping.getOwningTransformation());

	}

	public static @NonNull Property getReferredProperty(@NonNull CGPropertyAssignment cgPropertyAssignment) {
		return ClassUtil.nonNullState(cgPropertyAssignment.getReferredProperty());
	}

	public static @NonNull CGMapping getRootMapping(@NonNull CGTransformation cgTransformation) {
		CGMapping cgRootMapping = NameUtil.getNameable(cgTransformation.getOwnedMappings(), QVTscheduleConstants.ROOT_MAPPING_NAME);	// Obsolete relic
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
