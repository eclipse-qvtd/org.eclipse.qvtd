/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.utilities;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGAccumulator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGShadowExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;

public class QVTiCGUtil extends CGUtil
{
	public static @Nullable CGShadowExp basicGetCGShadowExp(@NonNull CGFunction cgFunction) {
		CGValuedElement cgBody = cgFunction.getBody();
		while (cgBody instanceof CGLetExp) {
			cgBody = ((CGLetExp)cgBody).getIn();
		}
		if (cgBody instanceof CGShadowExp) {			// QVTr Key
			//		Type type = ((TypedElement)cgBody.getAst()).getType();
			//		if (type instanceof DataType) {
			return (CGShadowExp) cgBody;		// FIXME replace with clearer strategy
			//		}
			//		else {
			//			return (CGShadowExp) cgBody;		// FIXME replace with clearer strategy
			//		}
		}
		return null;
	}

	public static @Nullable CGMapping basicGetContainingCGMapping(@NonNull CGElement cgElement) {
		for (EObject eObject = cgElement; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof CGMapping) {
				return (CGMapping)eObject;
			}
		}
		return null;
	}

	public static @Nullable CGTransformation basicGetContainingCGTransformation(@NonNull CGElement cgElement) {
		for (EObject eObject = cgElement; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof CGTransformation) {
				return (CGTransformation)eObject;
			}
		}
		return null;
	}

	public static @NonNull Property getAST(@NonNull CGExecutorProperty cgProperty) {
		return ClassUtil.nonNullState((Property)cgProperty.getAst());
	}

	public static @NonNull Function getAST(@NonNull CGFunction cgFunction) {
		return ClassUtil.nonNullState((Function)cgFunction.getAst());
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

	public static @NonNull MappingParameterBinding getAST(@NonNull CGMappingCallBinding cgMappingCallBinding) {
		return ClassUtil.nonNullState((MappingParameterBinding)cgMappingCallBinding.getAst());
	}

	public static @NonNull SetStatement getAST(@NonNull CGPropertyAssignment cgPropertyAssignment) {
		return ClassUtil.nonNullState((SetStatement)cgPropertyAssignment.getAst());
	}

	public static @NonNull NewStatement getAST(@NonNull CGRealizedVariable cgRealizedVariable) {
		return ClassUtil.nonNullState((NewStatement)cgRealizedVariable.getAst());
	}

	public static @NonNull NewStatementPart getAST(@NonNull CGRealizedVariablePart cgRealizedVariablePart) {
		return ClassUtil.nonNullState((NewStatementPart)cgRealizedVariablePart.getAst());
	}

	public static @NonNull ImperativeTransformation getAST(@NonNull CGTransformation cgTransformation) {
		return ClassUtil.nonNullState((ImperativeTransformation)cgTransformation.getAst());
	}

	public static @NonNull TypedModel getAST(@NonNull CGTypedModel cgTypedModel) {
		return ClassUtil.nonNullState((TypedModel)cgTypedModel.getAst());
	}

	public static @NonNull VariableExp getAST(@NonNull CGVariableExp cgVariableExp) {
		return ClassUtil.nonNullState((VariableExp)cgVariableExp.getAst());
	}

	public static @NonNull Property getAsProperty(@NonNull CGPropertyAssignment cgPropertyAssignment) {
		return ClassUtil.nonNullState(cgPropertyAssignment.getAsProperty());
	}

	public static @NonNull CGValuedElement getBody(@NonNull CGMappingLoop cgMappingLoop) {
		return ClassUtil.nonNullState(cgMappingLoop.getBody());
	}

	public static @NonNull CGClass getContainingCGClass(@NonNull CGFunction cgFunction) {
		return ClassUtil.nonNullState(cgFunction.getContainingClass());
	}

	public static @NonNull CGMapping getContainingCGMapping(@NonNull CGElement cgElement) {
		return ClassUtil.nonNullState(basicGetContainingCGMapping(cgElement));
	}

	public static @NonNull CGTransformation getContainingCGTransformation(@NonNull CGElement cgElement) {
		return ClassUtil.nonNullState(basicGetContainingCGTransformation(cgElement));
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

	public static @NonNull CGExecutorType getExecutorType(@NonNull CGRealizedVariable cgRealizedVariable) {
		return ClassUtil.nonNullState(cgRealizedVariable.getExecutorType());
	}

	public static @NonNull CGValuedElement getIn(@NonNull CGLetExp cgLetExp) {	// FIXME move to CGUtil
		return ClassUtil.nonNullState(cgLetExp.getIn());
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

	public static @NonNull Iterable<@NonNull CGRealizedVariablePart> getOwnedParts(@NonNull CGRealizedVariable cgRealizedVariable) {
		return ClassUtil.nullFree(cgRealizedVariable.getOwnedParts());
	}

	public static @NonNull Iterable<@NonNull CGRealizedVariable> getOwnedRealizedVariables(@NonNull CGMapping cgMapping) {
		return ClassUtil.nullFree(cgMapping.getOwnedRealizedVariables());
	}

	public static @NonNull CGValuedElement getOwnedSlotValue(@NonNull CGPropertyAssignment cgPropertyAssignment) {
		return ClassUtil.nonNullState(cgPropertyAssignment.getOwnedSlotValue());
	}

	public static @NonNull Iterable<@NonNull CGValuedElement> getOwnedStatements(@NonNull CGSequence cgSequence) {
		return ClassUtil.nullFree(cgSequence.getOwnedStatements());
	}

	public static @NonNull List<@NonNull CGValuedElement> getOwnedStatementsList(@NonNull CGSequence cgSequence) {
		return ClassUtil.nullFree(cgSequence.getOwnedStatements());
	}

	public static @NonNull Iterable<@NonNull CGTypedModel> getOwnedTypedModels(@NonNull CGTransformation cgTransformation) {
		return ClassUtil.nullFree(cgTransformation.getOwnedTypedModels());
	}

	public static @NonNull Function getOwningFunction(@NonNull FunctionParameter asFunctionParameter) {
		return (Function)ClassUtil.nonNullState(asFunctionParameter.getOwningOperation());
	}

	public static @NonNull CGMapping getOwningMapping(@NonNull CGRealizedVariable cgRealizedVariable) {
		return ClassUtil.nonNullState(cgRealizedVariable.getOwningMapping());
	}

	public static @NonNull CGTransformation getOwningTransformation(@NonNull CGMapping cgMapping) {
		return ClassUtil.nonNullState(cgMapping.getOwningTransformation());
	}

	public static @NonNull Iterable<@NonNull CGParameter> getParameters(@NonNull CGFunction cgFunction) {
		return ClassUtil.nullFree(cgFunction.getParameters());
	}

	public static @NonNull CGMapping getReferredMapping(@NonNull CGMappingCall cgMappingCall) {
		return ClassUtil.nonNullState(cgMappingCall.getReferredMapping());
	}

	public static @NonNull CGProperty getReferredProperty(@NonNull CGRealizedVariablePart cgRealizedVariablePart) {
		return ClassUtil.nonNullState(cgRealizedVariablePart.getReferredProperty());
	}

	public static @NonNull CGProperty getReferredProperty(@NonNull CGPropertyAssignment cgPropertyAssignment) {
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

	public static @Nullable CGGuardVariable getTraceParameter(@NonNull CGMapping cgMapping) {
		CGGuardVariable cgTraceParameter = null;
		for (@NonNull CGGuardVariable cgGuardVariable : getOwnedGuardVariables(cgMapping)) {
			VariableDeclaration asGuardVariable = getAST(cgGuardVariable);
			if (asGuardVariable instanceof GuardParameter) {
				GuardParameter asGuardParameter = (GuardParameter)asGuardVariable;
				Property successProperty = asGuardParameter.getSuccessProperty();
				if (successProperty != null) {
					assert cgTraceParameter == null;
					cgTraceParameter = cgGuardVariable;
				}
			}
		}
		return cgTraceParameter;
	}
}
