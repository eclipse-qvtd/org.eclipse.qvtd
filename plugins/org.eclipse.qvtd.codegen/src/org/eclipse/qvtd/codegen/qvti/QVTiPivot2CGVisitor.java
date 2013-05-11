/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.Pivot2CGVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.GenModelException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.Unit;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

public final class QVTiPivot2CGVisitor extends Pivot2CGVisitor implements QVTimperativeVisitor<CGNamedElement>
{
	protected final @NonNull QVTiAnalyzer analyzer;
	protected final @NonNull QVTiGlobalContext globalContext;
	
	public QVTiPivot2CGVisitor(@NonNull QVTiAnalyzer analyzer, @NonNull QVTiGlobalContext globalContext) {
		super(analyzer);
		this.analyzer = analyzer;
		this.globalContext = globalContext;
	}

	protected void createMappingCalls(@NonNull Mapping pMapping, @NonNull CGMapping cgMapping) {
		for (MappingCall pMappingCall : pMapping.getMappingCall()) {
			CGMappingCall cgMappingCall = doVisit(CGMappingCall.class, pMappingCall);
			cgMapping.getMappingCalls().add(cgMappingCall);
		}
	}

	protected void doBottoms(@NonNull Mapping pMapping, @NonNull CGMapping cgMapping) {
		List<BottomPattern> pBottomPatterns = new ArrayList<BottomPattern>();
		{
			BottomPattern pBottomPattern = pMapping.getBottomPattern();
			if (pBottomPattern != null) {
				pBottomPatterns.add(pBottomPattern);
			}
			for (@SuppressWarnings("null")@NonNull Domain pDomain : pMapping.getDomain()) {
				if (pDomain instanceof CoreDomain) {
					pBottomPattern = ((CoreDomain)pDomain).getBottomPattern();
					if (pBottomPattern != null) {
						pBottomPatterns.add(pBottomPattern);
					}
				}
			}
		}
		List<RealizedVariable> pRealizedVariables = new ArrayList<RealizedVariable>();
		for (@SuppressWarnings("null")@NonNull BottomPattern pBottomPattern : pBottomPatterns) {
			pRealizedVariables.addAll(pBottomPattern.getRealizedVariable());
		}
		Collections.sort(pRealizedVariables, new Comparator<NamedElement>()
			{
				@Override
				public int compare(NamedElement o1, NamedElement o2) {
					return o1.getName().compareTo(o2.getName());
				}		
			});
		List<CGRealizedVariable> cgRealizedVariables = cgMapping.getRealizedVariables();
		for (@SuppressWarnings("null")@NonNull RealizedVariable pRealizedVariable : pRealizedVariables) {
			CGRealizedVariable cgVariable = getRealizedVariable(pRealizedVariable);
			cgRealizedVariables.add(cgVariable);
		}
		List<CGPropertyAssignment> cgAssignments = cgMapping.getAssignments();
		for (@SuppressWarnings("null")@NonNull BottomPattern pBottomPattern : pBottomPatterns) {
			for (@SuppressWarnings("null")@NonNull Assignment pAssignment : pBottomPattern.getAssignment()) {
				cgAssignments.add(doVisit(CGPropertyAssignment.class, pAssignment));
			}
		}
	}

	protected void doGuards(@NonNull Mapping pMapping, @NonNull CGMapping cgMapping) {
		List<GuardPattern> guardPatterns = new ArrayList<GuardPattern>();
		{
			GuardPattern pGuardPattern = pMapping.getGuardPattern();
			if (pGuardPattern != null) {
				guardPatterns.add(pGuardPattern);
			}
			for (@SuppressWarnings("null")@NonNull Domain pDomain : pMapping.getDomain()) {
				if (pDomain instanceof CoreDomain) {
					GuardPattern guardPattern = ((CoreDomain)pDomain).getGuardPattern();
					if (guardPattern != null) {
						guardPatterns.add(guardPattern);
					}
				}
			}
		}
		List<Variable> pGuardVariables = new ArrayList<Variable>();
		for (@SuppressWarnings("null")@NonNull GuardPattern pGuardPattern : guardPatterns) {
			pGuardVariables.addAll(pGuardPattern.getVariable());
		}
		Collections.sort(pGuardVariables, new Comparator<NamedElement>()
			{
				@Override
				public int compare(NamedElement o1, NamedElement o2) {
					return o1.getName().compareTo(o2.getName());
				}		
			});
		List<CGGuardVariable> cgGuardVariables = new ArrayList<CGGuardVariable>();
		for (@SuppressWarnings("null")@NonNull Variable pGuardVariable : pGuardVariables) {
			CGGuardVariable cgParameter = getGuardVariable(pGuardVariable);
			cgGuardVariables.add(cgParameter);
		}
		Collections.sort(cgGuardVariables, new Comparator<CGGuardVariable>()
		{
			@Override
			public int compare(CGGuardVariable o1, CGGuardVariable o2) {
				String n1 = o1.getName();
				String n2 = o2.getName();
				return n1.compareTo(n2);
			}
		});
		cgMapping.getGuardVariables().addAll(cgGuardVariables);
		List<CGPredicate> cgGuardExpressions = cgMapping.getPredicates();
		for (@SuppressWarnings("null")@NonNull GuardPattern pGuardPattern : guardPatterns) {
			for (@SuppressWarnings("null")@NonNull Predicate pPredicate : pGuardPattern.getPredicate()) {
				cgGuardExpressions.add(doVisit(CGPredicate.class, pPredicate));
			}
		}
	}

	public @NonNull CGFunctionParameter getFunctionParameter(@NonNull FunctionParameter aParameter) {
		CGFunctionParameter cgFunctionParameter = (CGFunctionParameter)getVariablesStack().getParameter(aParameter);
		if (cgFunctionParameter == null) {
			cgFunctionParameter = QVTiCGModelFactory.eINSTANCE.createCGFunctionParameter();
			context.setNames(cgFunctionParameter, aParameter);
			setPivot(cgFunctionParameter, aParameter);
			cgFunctionParameter.setTypeId(context.getTypeId(aParameter.getTypeId()));
			addParameter(aParameter, cgFunctionParameter);
		}
		return cgFunctionParameter;
	}

	public @NonNull CGGuardVariable getGuardVariable(@NonNull Variable pParameter) {
		CGGuardVariable cgGuardVariable = (CGGuardVariable) getVariablesStack().getParameter(pParameter);
		if (cgGuardVariable == null) {
			cgGuardVariable = QVTiCGModelFactory.eINSTANCE.createCGGuardVariable();
			context.setNames(cgGuardVariable, pParameter);
			setPivot(cgGuardVariable, pParameter);
			cgGuardVariable.setTypeId(context.getTypeId(pParameter.getTypeId()));
			cgGuardVariable.setTypedModel(getTypedModel(pParameter));
			addParameter(pParameter, cgGuardVariable);
		}
		return cgGuardVariable;
	}

	public @NonNull CGRealizedVariable getRealizedVariable(@NonNull RealizedVariable pRealizedVariable) {
		Variables variablesStack = getVariablesStack();
		CGRealizedVariable cgVariable = (CGRealizedVariable) variablesStack.getVariable(pRealizedVariable);
		if (cgVariable == null) {
			Type pivotType = DomainUtil.nonNullModel(pRealizedVariable.getType());
			EClassifier eClassifier = (EClassifier) pivotType.getETarget();
			if (eClassifier != null) {
				CGEcoreRealizedVariable cgEcoreRealizedVariable = QVTiCGModelFactory.eINSTANCE.createCGEcoreRealizedVariable();
				cgEcoreRealizedVariable.setEClassifier(eClassifier);
				cgVariable = cgEcoreRealizedVariable;
			}
			if (cgVariable == null) {
				cgVariable = QVTiCGModelFactory.eINSTANCE.createCGRealizedVariable();
			}
			setPivot(cgVariable, pRealizedVariable);
			cgVariable.setTypedModel(getTypedModel(pRealizedVariable));
			variablesStack.putVariable(pRealizedVariable, cgVariable);
		}
		return cgVariable;
	}

	protected @NonNull CGTypedModel getTypedModel(@NonNull Variable pVariable) {
		Area pArea = DomainUtil.nonNullState(QVTcoreBaseUtil.getContainingArea(pVariable));
		TypedModel pTypedModel = null;
		if (pArea instanceof Domain) {
			pTypedModel = DomainUtil.nonNullState(((Domain)pArea).getTypedModel());
		}
		else {
			Transformation pTransformation = ((Mapping)pArea).getTransformation();
			pTypedModel = DomainUtil.nonNullState(pTransformation.getModelParameter(null));
		}
		return DomainUtil.nonNullState(analyzer.getTypedModel(pTypedModel));
	}

	@Override
	public @Nullable CGNamedElement visitAssignment(@NonNull Assignment object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitBaseModel(@NonNull BaseModel object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitBottomPattern(@NonNull BottomPattern object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitCoreDomain(@NonNull CoreDomain object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitCorePattern(@NonNull CorePattern object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitDomain(@NonNull Domain object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitEnforcementOperation(@NonNull EnforcementOperation object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitFunction(@NonNull Function pFunction) {
		CGFunction cgFunction = QVTiCGModelFactory.eINSTANCE.createCGFunction();
		setPivot(cgFunction, pFunction);
		cgFunction.setRequired(pFunction.isRequired());
		for (Parameter pParameter : pFunction.getOwnedParameter()) {
			cgFunction.getParameters().add(doVisit(CGParameter.class, pParameter));
		}
		OpaqueExpression specification = pFunction.getBodyExpression();
		if (specification != null) {
			ExpressionInOCL expressionInOCL = PivotUtil.getExpressionInOCL(pFunction, specification);
			if (expressionInOCL != null) {
				Variable contextVariable = expressionInOCL.getContextVariable();
				if (contextVariable != null) {
					getSelfParameter(contextVariable);
				}
				for (@SuppressWarnings("null")@NonNull Variable parameterVariable : expressionInOCL.getParameterVariable()) {
					getParameter(parameterVariable);
				}
				cgFunction.setBody(doVisit(CGValuedElement.class, expressionInOCL.getBodyExpression()));
			}
		}
		analyzer.addFunction(pFunction, cgFunction);
		return cgFunction;
	}

	@Override
	public @Nullable CGNamedElement visitFunctionParameter(@NonNull FunctionParameter pFunctionParameter) {
		return getFunctionParameter(pFunctionParameter);
	}

	@Override
	public @Nullable CGNamedElement visitGuardPattern(@NonNull GuardPattern object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitImperativeModel(@NonNull ImperativeModel object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitMapping(@NonNull Mapping pMapping) {
		CGMapping cgMapping = QVTiCGModelFactory.eINSTANCE.createCGMapping();
		setPivot(cgMapping, pMapping);
		analyzer.addMapping(pMapping, cgMapping);
		doGuards(pMapping, cgMapping);
		doBottoms(pMapping, cgMapping);
		createMappingCalls(pMapping, cgMapping);
		return cgMapping;
	}

	@Override
	public @Nullable CGNamedElement visitMappingCall(@NonNull MappingCall pMappingCall) {
		CGMappingCall cgMappingCall = QVTiCGModelFactory.eINSTANCE.createCGMappingCall();
		setPivot(cgMappingCall, pMappingCall);
		List<CGMappingCallBinding> cgMappingCallBindings = new ArrayList<CGMappingCallBinding>();
		for (MappingCallBinding pMappingCallBinding : pMappingCall.getBinding()) {
			CGMappingCallBinding cgMappingCallBinding = doVisit(CGMappingCallBinding.class, pMappingCallBinding);
			cgMappingCallBindings.add(cgMappingCallBinding);
		}
		Collections.sort(cgMappingCallBindings, new Comparator<CGMappingCallBinding>()
		{
			@Override
			public int compare(CGMappingCallBinding o1, CGMappingCallBinding o2) {
				String n1 = o1.getName();
				String n2 = o2.getName();
				return n1.compareTo(n2);
			}
		});
		cgMappingCall.getMappingCallBindings().addAll(cgMappingCallBindings);
		return cgMappingCall;
	}

	@Override
	public @Nullable CGNamedElement visitMappingCallBinding(@NonNull MappingCallBinding pMappingCallBinding) {
		CGMappingCallBinding cgMappingCallBinding = QVTiCGModelFactory.eINSTANCE.createCGMappingCallBinding();
//		setPivot(cgMappingCallBinding, pMappingCallBinding);
		cgMappingCallBinding.setName(pMappingCallBinding.getBoundVariable().getName());
		cgMappingCallBinding.setLoop(pMappingCallBinding.isIsLoop());
		cgMappingCallBinding.setValueOrValues(doVisit(CGValuedElement.class, pMappingCallBinding.getValue()));
		cgMappingCallBinding.setTypeId(analyzer.getTypeId(pMappingCallBinding.getBoundVariable().getTypeId()));
//		cgMappingCallBinding.setValueName(localnamepMappingCallBinding.getBoundVariable().getName());
		return cgMappingCallBinding;
	}

	@Override
	public @NonNull
	CGValuedElement visitOperationCallExp(@NonNull OperationCallExp element) {
		Operation pOperation = element.getReferredOperation();
		if (pOperation instanceof Function) {
			CGFunctionCallExp cgFunctionCallExp = QVTiCGModelFactory.eINSTANCE.createCGFunctionCallExp();
			cgFunctionCallExp.setReferredOperation(pOperation);
			setPivot(cgFunctionCallExp, element);
			cgFunctionCallExp.setRequired(pOperation.isRequired());
			for (OCLExpression pArgument : element.getArgument()) {
				CGValuedElement cgArgument = doVisit(CGValuedElement.class, pArgument);
				cgFunctionCallExp.getArguments().add(cgArgument);
			}
//			cgOperationCallExp.setOperation(getOperation(element.getReferredOperation()));
			return cgFunctionCallExp;
		}
		else {
			return super.visitOperationCallExp(element);
		}
	}

	@Override
	public @Nullable CGNamedElement visitPattern(@NonNull Pattern object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitPredicate(@NonNull Predicate pPredicate) {
		CGPredicate cgPredicate = QVTiCGModelFactory.eINSTANCE.createCGPredicate();
//		setPivot(cgPredicate, pPredicate);
//		cgPredicate.setName(pPredicate.getName());
		cgPredicate.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
//		cgMappingCallBinding.setValueName(localnamepMappingCallBinding.getBoundVariable().getName());
		cgPredicate.setConditionExpression(doVisit(CGValuedElement.class, pPredicate.getConditionExpression()));
		return cgPredicate;
	}

	@Override
	public @Nullable CGNamedElement visitPropertyAssignment(@NonNull PropertyAssignment pPropertyAssignment) {
		Property pivotProperty = DomainUtil.nonNullModel(pPropertyAssignment.getTargetProperty());
		LibraryProperty libraryProperty = metaModelManager.getImplementation(pivotProperty);
		CGPropertyAssignment cgPropertyAssignment = null;
		if (isEcoreProperty(libraryProperty)) {
			EStructuralFeature eStructuralFeature = (EStructuralFeature) pivotProperty.getETarget();
			if (eStructuralFeature != null) {
				try {
					genModelHelper.getGetAccessor(eStructuralFeature);
					CGEcorePropertyAssignment cgEcorePropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGEcorePropertyAssignment();
					cgEcorePropertyAssignment.setEStructuralFeature(eStructuralFeature);
					cgPropertyAssignment = cgEcorePropertyAssignment;
				} catch (GenModelException e) {
				}
			}
		}
		if (cgPropertyAssignment == null) {
			cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGPropertyAssignment();
		}
//		setPivot(cgPropertyAssignment, pPredicate);
		cgPropertyAssignment.setSlotValue(doVisit(CGValuedElement.class, pPropertyAssignment.getSlotExpression()));
		cgPropertyAssignment.setReferredProperty(pPropertyAssignment.getTargetProperty());
//		cgPredicate.setName(pPredicate.getName());
		cgPropertyAssignment.setTypeId(analyzer.getTypeId(TypeId.OCL_VOID));
//		cgMappingCallBinding.setValueName(localnamepMappingCallBinding.getBoundVariable().getName());
		cgPropertyAssignment.setInitValue(doVisit(CGValuedElement.class, pPropertyAssignment.getValue()));
		return cgPropertyAssignment;
	}

	@Override
	public @Nullable CGNamedElement visitRealizedVariable(@NonNull RealizedVariable object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitRule(@NonNull Rule object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitVariableAssignment(@NonNull VariableAssignment object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitTransformation(@NonNull Transformation element) {
		CGTransformation cgTransformation = QVTiCGModelFactory.eINSTANCE.createCGTransformation();
		setPivot(cgTransformation, element);
		List<CGTypedModel> cgTypedModels = cgTransformation.getTypedModels();
		for (TypedModel pTypedModel : element.getModelParameter()) {
			CGTypedModel cgTypedModel = doVisit(CGTypedModel.class, pTypedModel);
			cgTypedModel.setModelIndex(cgTypedModels.size());
			cgTypedModels.add(cgTypedModel);
		}
		for (Rule pivotRule : element.getRule()) {
			CGMapping cgMapping = doVisit(CGMapping.class, pivotRule);
			cgTransformation.getMappings().add(cgMapping);
		}
		for (Operation pivotOperation : element.getOwnedOperation()) {
			CGOperation cgOperation = doVisit(CGOperation.class, pivotOperation);
			cgTransformation.getOperations().add(cgOperation);
		}
		return cgTransformation;
	}

	@Override
	public @Nullable CGNamedElement visitTypedModel(@NonNull TypedModel pTypedModel) {
		CGTypedModel cgTypedModel = QVTiCGModelFactory.eINSTANCE.createCGTypedModel();
		setPivot(cgTypedModel, pTypedModel);
		analyzer.addTypedModel(pTypedModel, cgTypedModel);
		return cgTypedModel;
	}

	@Override
	public @Nullable CGNamedElement visitUnit(@NonNull Unit object) {
		return visiting(object);
	}
}
