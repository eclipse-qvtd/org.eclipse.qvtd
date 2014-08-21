/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.analyzer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.generator.GenModelException;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Iteration;
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
import org.eclipse.qvtd.codegen.qvti.java.QVTiGlobalContext;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.CGVariablePredicate;
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
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyCallExp;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

public final class QVTiAS2CGVisitor extends AS2CGVisitor implements QVTimperativeVisitor<CGNamedElement>
{
	protected final @NonNull QVTiAnalyzer analyzer;
	protected final @NonNull QVTiGlobalContext globalContext;
	
	public QVTiAS2CGVisitor(@NonNull QVTiAnalyzer analyzer, @NonNull QVTiGlobalContext globalContext) {
		super(analyzer);
		this.analyzer = analyzer;
		this.globalContext = globalContext;
	}

	protected void doBottoms(@NonNull Mapping pMapping, @NonNull CGMappingExp cgMappingExp) {
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
				public int compare(NamedElement o1, NamedElement o2) {
					return o1.getName().compareTo(o2.getName());
				}		
			});
		List<CGValuedElement> cgRealizedVariables = cgMappingExp.getRealizedVariables();
		for (@SuppressWarnings("null")@NonNull RealizedVariable pRealizedVariable : pRealizedVariables) {
			CGRealizedVariable cgVariable = getRealizedVariable(pRealizedVariable);
			cgRealizedVariables.add(cgVariable);
		}
		List<CGPropertyAssignment> cgAssignments = cgMappingExp.getAssignments();
		for (@SuppressWarnings("null")@NonNull BottomPattern pBottomPattern : pBottomPatterns) {
			for (@SuppressWarnings("null")@NonNull Assignment pAssignment : pBottomPattern.getAssignment()) {
				cgAssignments.add(doVisit(CGPropertyAssignment.class, pAssignment));
			}
		}
	}

	protected void doGuards(@NonNull Mapping pMapping, @NonNull CGMapping cgMapping, @NonNull CGMappingExp cgMappingExp) {
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
		Set<Variable> predicatedVariables = new HashSet<Variable>();
		for (@SuppressWarnings("null")@NonNull GuardPattern pGuardPattern : guardPatterns) {
			for (Predicate predicate : pGuardPattern.getPredicate()) {
				if (predicate instanceof VariablePredicate) {
					predicatedVariables.add(((VariablePredicate)predicate).getTargetVariable());
				}
			};
		}
		List<Variable> pGuardVariables = new ArrayList<Variable>();
		for (@SuppressWarnings("null")@NonNull GuardPattern pGuardPattern : guardPatterns) {
			pGuardPattern.getPredicate();
			for (Variable pGuardVariable : pGuardPattern.getVariable()) {
				if (!predicatedVariables.contains(pGuardVariable)) {
					pGuardVariables.add(pGuardVariable);
				}
			}
		}
		Collections.sort(pGuardVariables, new Comparator<NamedElement>()
			{
				public int compare(NamedElement o1, NamedElement o2) {
					return o1.getName().compareTo(o2.getName());
				}		
			});
		List<CGGuardVariable> cgFreeVariables = new ArrayList<CGGuardVariable>();
		List<CGFinalVariable> cgBoundVariables = new ArrayList<CGFinalVariable>();
		for (@SuppressWarnings("null")@NonNull Variable pGuardVariable : pGuardVariables) {
			OCLExpression initExpression = pGuardVariable.getInitExpression();
			if (initExpression == null) {
				CGGuardVariable cgUnboundVariable = getGuardVariable(pGuardVariable);
				cgFreeVariables.add(cgUnboundVariable);
			}
			else {
				CGFinalVariable cgBoundVariable = (CGFinalVariable) getVariable(pGuardVariable);
				CGValuedElement cgInit = doVisit(CGValuedElement.class, initExpression);
				cgBoundVariable.setInit(cgInit);
				JavaLocalContext<?> localContext = globalContext.getLocalContext(cgMapping);
				if (localContext != null) {
// FIXME					localContext.addLocalVariable(cgBoundVariable);
				}
				cgBoundVariables.add(cgBoundVariable);
			}
		}
		Collections.sort(cgFreeVariables, new Comparator<CGGuardVariable>()
		{
			public int compare(CGGuardVariable o1, CGGuardVariable o2) {
				String n1 = o1.getName();
				String n2 = o2.getName();
				return n1.compareTo(n2);
			}
		});
		Collections.sort(cgBoundVariables, new Comparator<CGFinalVariable>()
		{
			public int compare(CGFinalVariable o1, CGFinalVariable o2) {
				String n1 = o1.getName();
				String n2 = o2.getName();
				return n1.compareTo(n2);
			}
		});
		cgMapping.getFreeVariables().addAll(cgFreeVariables);
//		cgMappingExp.getBoundVariables().addAll(cgBoundVariables);
		List<CGPredicate> cgGuardExpressions = cgMappingExp.getPredicates();
		for (@SuppressWarnings("null")@NonNull GuardPattern pGuardPattern : guardPatterns) {
			for (@SuppressWarnings("null")@NonNull Predicate asPredicate : pGuardPattern.getPredicate()) {
				cgGuardExpressions.add(doVisit(CGPredicate.class, asPredicate));
			}
		}
	}

	public @NonNull CGFunctionParameter getFunctionParameter(@NonNull FunctionParameter asFunctionParameter) {
		CGFunctionParameter cgFunctionParameter = (CGFunctionParameter)getVariablesStack().getParameter(asFunctionParameter);
		if (cgFunctionParameter == null) {
			cgFunctionParameter = QVTiCGModelFactory.eINSTANCE.createCGFunctionParameter();
			context.setNames(cgFunctionParameter, asFunctionParameter);
			setAst(cgFunctionParameter, asFunctionParameter);
			cgFunctionParameter.setTypeId(context.getTypeId(asFunctionParameter.getTypeId()));
			addParameter(asFunctionParameter, cgFunctionParameter);
		}
		return cgFunctionParameter;
	}

	public @NonNull CGGuardVariable getGuardVariable(@NonNull Variable asVariable) {
		CGGuardVariable cgGuardVariable = (CGGuardVariable) getVariablesStack().getParameter(asVariable);
			cgGuardVariable = QVTiCGModelFactory.eINSTANCE.createCGGuardVariable();
			context.setNames(cgGuardVariable, asVariable);
			setAst(cgGuardVariable, asVariable);
			cgGuardVariable.setTypeId(context.getTypeId(asVariable.getTypeId()));
			cgGuardVariable.setTypedModel(getTypedModel(asVariable));
			addParameter(asVariable, cgGuardVariable);
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
			setAst(cgVariable, pRealizedVariable);
			cgVariable.setTypedModel(getTypedModel(pRealizedVariable));
			variablesStack.putVariable(pRealizedVariable, cgVariable);
		}
		return cgVariable;
	}

	protected @NonNull CGTypedModel getTypedModel(@NonNull Variable pVariable) {
		Area pArea = DomainUtil.nonNullState(QVTcoreBaseUtil.getContainingArea(pVariable));
		TypedModel asTypedModel = null;
		if (pArea instanceof Domain) {
			asTypedModel = DomainUtil.nonNullState(((Domain)pArea).getTypedModel());
		}
		else {
			Transformation pTransformation = ((Mapping)pArea).getTransformation();
			asTypedModel = DomainUtil.nonNullState(pTransformation.getModelParameter(null));
		}
		return DomainUtil.nonNullState(analyzer.getTypedModel(asTypedModel));
	}

	public @Nullable CGNamedElement visitAssignment(@NonNull Assignment object) {
		return visiting(object);
	}

	public @Nullable CGNamedElement visitBaseModel(@NonNull BaseModel object) {
		return visiting(object);
	}

	public @Nullable CGNamedElement visitBottomPattern(@NonNull BottomPattern object) {
		return visiting(object);
	}

	public @Nullable CGNamedElement visitCoreDomain(@NonNull CoreDomain object) {
		return visiting(object);
	}

	public @Nullable CGNamedElement visitCorePattern(@NonNull CorePattern object) {
		return visiting(object);
	}

	public @Nullable CGNamedElement visitDomain(@NonNull Domain object) {
		return visiting(object);
	}

	public @Nullable CGNamedElement visitEnforcementOperation(@NonNull EnforcementOperation object) {
		return visiting(object);
	}

	public @Nullable CGNamedElement visitFunction(@NonNull Function asFunction) {
		CGFunction cgFunction = QVTiCGModelFactory.eINSTANCE.createCGFunction();
		setAst(cgFunction, asFunction);
		cgFunction.setRequired(asFunction.isRequired());
		for (Parameter pParameter : asFunction.getOwnedParameter()) {
			cgFunction.getParameters().add(doVisit(CGParameter.class, pParameter));
		}
		OpaqueExpression specification = asFunction.getBodyExpression();
		if (specification != null) {
			ExpressionInOCL expressionInOCL = PivotUtil.getExpressionInOCL(metaModelManager, specification);
			if (expressionInOCL != null) {
				Variable contextVariable = expressionInOCL.getContextVariable();
				if (contextVariable != null) {
					getParameter(contextVariable);
				}
				for (@SuppressWarnings("null")@NonNull Variable parameterVariable : expressionInOCL.getParameterVariable()) {
					getParameter(parameterVariable);
				}
				cgFunction.setBody(doVisit(CGValuedElement.class, expressionInOCL.getBodyExpression()));
			}
		}
		analyzer.addFunction(asFunction, cgFunction);
		return cgFunction;
	}

	public @Nullable CGNamedElement visitFunctionParameter(@NonNull FunctionParameter asFunctionParameter) {
		return getFunctionParameter(asFunctionParameter);
	}

	public @Nullable CGNamedElement visitGuardPattern(@NonNull GuardPattern object) {
		return visiting(object);
	}

	public @Nullable CGNamedElement visitImperativeModel(@NonNull ImperativeModel object) {
		return visiting(object);
	}

	public @Nullable CGNamedElement visitMapping(@NonNull Mapping pMapping) {
		CGMapping cgMapping = QVTiCGModelFactory.eINSTANCE.createCGMapping();
		setAst(cgMapping, pMapping);
		analyzer.addMapping(pMapping, cgMapping);
		CGMappingExp cgMappingExp = QVTiCGModelFactory.eINSTANCE.createCGMappingExp();
		setAst(cgMappingExp, pMapping);
		TypeId pivotTypeId = TypeId.BOOLEAN; //pMapping.getTypeId();
		cgMappingExp.setTypeId(context.getTypeId(pivotTypeId));
		cgMapping.setBody(cgMappingExp);
		doGuards(pMapping, cgMapping, cgMappingExp);
		doBottoms(pMapping, cgMappingExp);
		MappingStatement mappingStatements = pMapping.getMappingStatement();
		if (mappingStatements != null) {
			cgMappingExp.setBody(doVisit(CGValuedElement.class, mappingStatements));
		}
		return cgMapping;
	}

	public @Nullable CGNamedElement visitMappingCall(@NonNull MappingCall asMappingCall) {
		CGMappingCall cgMappingCall = QVTiCGModelFactory.eINSTANCE.createCGMappingCall();
		setAst(cgMappingCall, asMappingCall);
		List<CGMappingCallBinding> cgMappingCallBindings = new ArrayList<CGMappingCallBinding>();
		for (MappingCallBinding asMappingCallBinding : asMappingCall.getBinding()) {
			CGMappingCallBinding cgMappingCallBinding = doVisit(CGMappingCallBinding.class, asMappingCallBinding);
			cgMappingCallBindings.add(cgMappingCallBinding);
		}
		Collections.sort(cgMappingCallBindings, new Comparator<CGMappingCallBinding>()
		{
			public int compare(CGMappingCallBinding o1, CGMappingCallBinding o2) {
				String n1 = o1.getName();
				String n2 = o2.getName();
				return n1.compareTo(n2);
			}
		});
		cgMappingCall.getMappingCallBindings().addAll(cgMappingCallBindings);
		return cgMappingCall;
	}

	public @Nullable CGNamedElement visitMappingCallBinding(@NonNull MappingCallBinding asMappingCallBinding) {
		Variable asBoundVariable = asMappingCallBinding.getBoundVariable();
		CGMappingCallBinding cgMappingCallBinding = QVTiCGModelFactory.eINSTANCE.createCGMappingCallBinding();
//		setPivot(cgMappingCallBinding, asMappingCallBinding);
		cgMappingCallBinding.setName(asBoundVariable.getName());
		cgMappingCallBinding.setAst(asMappingCallBinding);
		cgMappingCallBinding.setRequired(asBoundVariable.isRequired());
		cgMappingCallBinding.setValue(doVisit(CGValuedElement.class, asMappingCallBinding.getValue()));
		cgMappingCallBinding.setTypeId(analyzer.getTypeId(asBoundVariable.getTypeId()));
//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		return cgMappingCallBinding;
	}

	public @Nullable CGNamedElement visitMappingLoop(@NonNull MappingLoop asMappingLoop) {
		CGMappingLoop cgMappingLoop = QVTiCGModelFactory.eINSTANCE.createCGMappingLoop();
		List<Variable> asIterators = asMappingLoop.getIterator();
		if (asIterators.size() > 0) {
			Variable asIterator = asIterators.get(0);
			if (asIterator != null) {
				CGIterator cgIterator = getIterator(asIterator);
				cgIterator.setTypeId(context.getTypeId(asIterator.getTypeId()));
				cgIterator.setRequired(asIterator.isRequired());
				if (asIterator.isRequired()) {
					cgIterator.setNonNull();
				}
				cgMappingLoop.getIterators().add(cgIterator);
			}
		}
		cgMappingLoop.setSource(doVisit(CGValuedElement.class, asMappingLoop.getSource()));
//		cgIterator.setNonInvalid();
//		cgIterator.setNonNull();
		cgMappingLoop.setAst(asMappingLoop);
		CollectionType collectionType = metaModelManager.getCollectionType();
		DomainOperation forAllIteration = DomainUtil.getNamedElement(collectionType.getLocalOperations(), "forAll");
		cgMappingLoop.setReferredIteration((Iteration) forAllIteration);
		cgMappingLoop.setBody(doVisit(CGValuedElement.class, asMappingLoop.getBody()));
		return cgMappingLoop;
	}

	public @Nullable CGNamedElement visitMappingSequence(@NonNull MappingSequence asMappingSequence) {
		CGSequence cgSequence = QVTiCGModelFactory.eINSTANCE.createCGSequence();
		List<CGValuedElement> cgMappingStatements = cgSequence.getStatements();
		for (MappingStatement asMappingStatement : asMappingSequence.getMappingStatements()) {
			CGValuedElement cgMappingStatement = doVisit(CGValuedElement.class, asMappingStatement);
			cgMappingStatements.add(cgMappingStatement);
		}
		return cgSequence;
	}
	
	public @Nullable CGNamedElement visitMappingStatement(@NonNull MappingStatement object) {
		return visiting(object);
	}

	public @Nullable CGNamedElement visitMiddlePropertyAssignment(@NonNull MiddlePropertyAssignment asPropertyAssignment) {
//		Property asProperty = DomainUtil.nonNullModel(asPropertyAssignment.getTargetProperty());
		CGMiddlePropertyAssignment cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGMiddlePropertyAssignment();
//		setPivot(cgPropertyAssignment, asPredicate);
		cgPropertyAssignment.setSlotValue(doVisit(CGValuedElement.class, asPropertyAssignment.getSlotExpression()));
		Property asProperty = asPropertyAssignment.getTargetProperty();
		cgPropertyAssignment.setReferredProperty(asProperty);
//		cgPredicate.setName(asPredicate.getName());
		cgPropertyAssignment.setTypeId(analyzer.getTypeId(TypeId.OCL_VOID));
//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		cgPropertyAssignment.setInitValue(doVisit(CGValuedElement.class, asPropertyAssignment.getValue()));
		EStructuralFeature eStructuralFeature = (EStructuralFeature) asProperty.getETarget();
		if (eStructuralFeature != null) {
			try {
				genModelHelper.getGetAccessor(eStructuralFeature);
				cgPropertyAssignment.setEStructuralFeature(eStructuralFeature);
			} catch (GenModelException e) {
			}
		}
		return cgPropertyAssignment;
	}

	public @Nullable CGNamedElement visitMiddlePropertyCallExp(@NonNull MiddlePropertyCallExp asMiddlePropertyCallExp) {
		Property asOppositeProperty = DomainUtil.nonNullModel(asMiddlePropertyCallExp.getReferredProperty());
		Property asProperty = DomainUtil.nonNullModel(asOppositeProperty.getOpposite());
		globalContext.addToMiddleProperty(asOppositeProperty);
//		LibraryProperty libraryProperty = metaModelManager.getImplementation(asProperty);
		CGMiddlePropertyCallExp cgPropertyCallExp = QVTiCGModelFactory.eINSTANCE.createCGMiddlePropertyCallExp();					
//		CGExecutorProperty cgExecutorProperty = context.getExecutorProperty(asProperty);
//		cgExecutorPropertyCallExp.setExecutorProperty(cgExecutorProperty);
//		cgPropertyCallExp = cgExecutorPropertyCallExp;
//		cgPropertyCallExp.getDependsOn().add(cgExecutorProperty);
		cgPropertyCallExp.setReferredProperty(asOppositeProperty);
		setAst(cgPropertyCallExp, asMiddlePropertyCallExp);
		cgPropertyCallExp.setRequired(asProperty.isRequired());
		CGValuedElement cgSource = doVisit(CGValuedElement.class, asMiddlePropertyCallExp.getSource());
		cgPropertyCallExp.setSource(cgSource);
		return cgPropertyCallExp;
	}

	@Override
	public @NonNull
	CGValuedElement visitOperationCallExp(@NonNull OperationCallExp asOperationCallExp) {
		Operation pOperation = asOperationCallExp.getReferredOperation();
		if (pOperation instanceof Function) {
			CGFunctionCallExp cgFunctionCallExp = QVTiCGModelFactory.eINSTANCE.createCGFunctionCallExp();
			cgFunctionCallExp.setReferredOperation(pOperation);
			setAst(cgFunctionCallExp, asOperationCallExp);
			cgFunctionCallExp.setRequired(pOperation.isRequired());
			for (OCLExpression pArgument : asOperationCallExp.getArgument()) {
				CGValuedElement cgArgument = doVisit(CGValuedElement.class, pArgument);
				cgFunctionCallExp.getArguments().add(cgArgument);
			}
//			cgOperationCallExp.setOperation(getOperation(asOperationCallExp.getReferredOperation()));
			return cgFunctionCallExp;
		}
		else {
			return super.visitOperationCallExp(asOperationCallExp);
		}
	}

	public @Nullable CGNamedElement visitPattern(@NonNull Pattern object) {
		return visiting(object);
	}

	public @Nullable CGNamedElement visitPredicate(@NonNull Predicate asPredicate) {
		CGPredicate cgPredicate = QVTiCGModelFactory.eINSTANCE.createCGPredicate();
//		setPivot(cgPredicate, asPredicate);
//		cgPredicate.setName(asPredicate.getName());
		cgPredicate.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		cgPredicate.setConditionExpression(doVisit(CGValuedElement.class, asPredicate.getConditionExpression()));
		return cgPredicate;
	}

	public @Nullable CGNamedElement visitPropertyAssignment(@NonNull PropertyAssignment asPropertyAssignment) {
		Property asTargetProperty = DomainUtil.nonNullModel(asPropertyAssignment.getTargetProperty());
		LibraryProperty libraryProperty = metaModelManager.getImplementation(null, asTargetProperty);
		CGPropertyAssignment cgPropertyAssignment = null;
		if (isEcoreProperty(libraryProperty)) {
			EStructuralFeature eStructuralFeature = (EStructuralFeature) asTargetProperty.getETarget();
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
//		setPivot(cgPropertyAssignment, asPredicate);
		cgPropertyAssignment.setSlotValue(doVisit(CGValuedElement.class, asPropertyAssignment.getSlotExpression()));
		cgPropertyAssignment.setReferredProperty(asTargetProperty);
//		cgPredicate.setName(asPredicate.getName());
		cgPropertyAssignment.setTypeId(analyzer.getTypeId(TypeId.OCL_VOID));
//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		cgPropertyAssignment.setInitValue(doVisit(CGValuedElement.class, asPropertyAssignment.getValue()));

		CGExecutorProperty cgExecutorProperty = context.createExecutorProperty(asTargetProperty);
		cgPropertyAssignment.setExecutorProperty(cgExecutorProperty);
		
		
		return cgPropertyAssignment;
	}

	public @Nullable CGNamedElement visitRealizedVariable(@NonNull RealizedVariable object) {
//		CGExecutorType cgExecutorType = context.createExecutorType(pTypeExp.getReferredType());
//		cgTypeExp.setExecutorType(cgExecutorType);
		return visiting(object);
	}

	public @Nullable CGNamedElement visitRule(@NonNull Rule object) {
		return visiting(object);
	}

	public @Nullable CGNamedElement visitVariableAssignment(@NonNull VariableAssignment object) {
		return visiting(object);
	}

	public @Nullable CGNamedElement visitTransformation(@NonNull Transformation asTransformation) {
		CGTransformation cgTransformation = QVTiCGModelFactory.eINSTANCE.createCGTransformation();
		setAst(cgTransformation, asTransformation);
		List<CGTypedModel> cgTypedModels = cgTransformation.getTypedModels();
		for (TypedModel asTypedModel : asTransformation.getModelParameter()) {
			CGTypedModel cgTypedModel = doVisit(CGTypedModel.class, asTypedModel);
			cgTypedModel.setModelIndex(cgTypedModels.size());
			cgTypedModels.add(cgTypedModel);
		}
		for (Rule asRule : asTransformation.getRule()) {
			CGMapping cgMapping = doVisit(CGMapping.class, asRule);
			cgTransformation.getMappings().add(cgMapping);
		}
		for (Operation asOperation : asTransformation.getOwnedOperation()) {
			CGOperation cgOperation = doVisit(CGOperation.class, asOperation);
			cgTransformation.getOperations().add(cgOperation);
		}
		return cgTransformation;
	}

	public @Nullable CGNamedElement visitTypedModel(@NonNull TypedModel asTypedModel) {
		CGTypedModel cgTypedModel = QVTiCGModelFactory.eINSTANCE.createCGTypedModel();
		setAst(cgTypedModel, asTypedModel);
		analyzer.addTypedModel(asTypedModel, cgTypedModel);
		return cgTypedModel;
	}

	public @Nullable CGNamedElement visitUnit(@NonNull Unit object) {
		return visiting(object);
	}

	public @Nullable CGNamedElement visitVariablePredicate(@NonNull VariablePredicate asPredicate) {
		CGVariablePredicate cgPredicate = QVTiCGModelFactory.eINSTANCE.createCGVariablePredicate();
//		setPivot(cgPredicate, asPredicate);
		cgPredicate.setAst(asPredicate);
//		TypeId pivotTypeId = asPredicate.getTypeId();
//		cgPredicate.setTypeId(context.getTypeId(pivotTypeId));
		Variable targetVariable = asPredicate.getTargetVariable();
		cgPredicate.setName(targetVariable.getName());
		cgPredicate.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		OCLExpression conditionExpression = asPredicate.getConditionExpression();
		cgPredicate.setConditionExpression(doVisit(CGValuedElement.class, conditionExpression));
//		analyzer.ge
		CGVariable cgVariable = createCGVariable(targetVariable);
//		if (conditionExpression.isRequired()) {
//			cgVariable.setNonNull();
//		}
//		cgGuardVariable = QVTiCGModelFactory.eINSTANCE.createCGGuardVariable();
//		context.setNames(cgGuardVariable, pParameter);
//		setPivot(cgGuardVariable, pParameter);
//		cgGuardVariable.setTypeId(context.getTypeId(pParameter.getTypeId()));
//		cgGuardVariable.setTypedModel(getTypedModel(pParameter));
//		addParameter(pParameter, cgGuardVariable);
		cgPredicate.setPredicateVariable(cgVariable);
		return cgPredicate;
	}
}
