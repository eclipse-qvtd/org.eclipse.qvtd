/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGAccumulator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.generator.GenModelException;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.codegen.qvti.java.QVTiGlobalContext;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable;
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
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
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
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

public class QVTiAS2CGVisitor extends AS2CGVisitor implements QVTimperativeVisitor<CGNamedElement>
{
	public static class CGMappingCallBindingComparator implements Comparator<CGMappingCallBinding>
	{
		public static final @NonNull CGMappingCallBindingComparator INSTANCE = new CGMappingCallBindingComparator();

		@Override
		public int compare(CGMappingCallBinding o1, CGMappingCallBinding o2) {
			MappingCallBinding b1 = (MappingCallBinding) o1.getAst();
			MappingCallBinding b2 = (MappingCallBinding) o2.getAst();
			Variable v1 = b1 != null ? b1.getBoundVariable() : null;
			Variable v2 = b2 != null ? b2.getBoundVariable() : null;
			String n1 = v1 != null ? v1.getName() : null;
			String n2 = v2 != null ? v2.getName() : null;
			if (n1 == null) n1 = "";
			if (n2 == null) n2 = "";
			return n1.compareTo(n2);
		}
	}

	public static class CGVariableComparator implements Comparator<CGVariable>
	{
		public static final @NonNull CGVariableComparator INSTANCE = new CGVariableComparator();

		@Override
		public int compare(CGVariable o1, CGVariable o2) {
			Variable v1 = (Variable) o1.getAst();
			Variable v2 = (Variable) o2.getAst();
			String n1 = v1 != null ? v1.getName() : null;
			String n2 = v2 != null ? v2.getName() : null;
			if (n1 == null) n1 = "";
			if (n2 == null) n2 = "";
			return n1.compareTo(n2);
		}
	}

	protected final @NonNull QVTiAnalyzer analyzer;
	protected final @NonNull QVTiGlobalContext globalContext;
	
	public QVTiAS2CGVisitor(@NonNull QVTiAnalyzer analyzer, @NonNull QVTiGlobalContext globalContext) {
		super(analyzer);
		this.analyzer = analyzer;
		this.globalContext = globalContext;
	}

	@Override
	protected <T extends EObject> @NonNull T createCopy(@NonNull T aPrototype) {
	    Copier copier = new EcoreUtil.Copier();
	    EObject aCopy = copier.copy(aPrototype);
	    assert aCopy != null;
	    copier.copyReferences();
		Transformation asTransformation = QVTbaseUtil.getContainingTransformation(aPrototype);
		if (asTransformation != null) {
//			System.out.println("Copying " + aPrototype);
			QVTiCodeGenerator codeGenerator = analyzer.getCodeGenerator();
			QVTiTransformationAnalysis transformationAnalysis = codeGenerator.getTransformationAnalysis(asTransformation);
			QVTimperativeDomainUsageAnalysis domainUsageAnalysis = transformationAnalysis.getDomainUsageAnalysis();
			for (EObject prototypeEObject : copier.keySet()) {
				EObject clonedEObject = copier.get(prototypeEObject);
				assert clonedEObject != null;
				DomainUsage usage = domainUsageAnalysis.basicGetUsage(prototypeEObject);
//				System.out.println("    " + prototypeEObject.eClass().getName() + "@" + Integer.toHexString(System.identityHashCode(prototypeEObject)) + " => " + usage + " : " + prototypeEObject);
				if (usage != null) {
//					System.out.println("    " + clonedEObject.eClass().getName() + "@" + Integer.toHexString(System.identityHashCode(clonedEObject)) + " <= " + usage + " : " + clonedEObject);
					domainUsageAnalysis.setUsage((Element) clonedEObject, usage);
				}
			}
		}
		@SuppressWarnings("unchecked") T castCopy = (T) aCopy;
		return castCopy;
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
		List<CGFinalVariable> cgVariableAssignments = cgMappingExp.getVariableAssignments();
		List<RealizedVariable> pRealizedVariables = new ArrayList<RealizedVariable>();
		for (@SuppressWarnings("null")@NonNull BottomPattern pBottomPattern : pBottomPatterns) {
			pRealizedVariables.addAll(pBottomPattern.getRealizedVariable());
			for (@SuppressWarnings("null")@NonNull Variable asVariable : pBottomPattern.getVariable()) {
				if (QVTimperativeUtil.isConnectionAccumulator(asVariable)) {
					if (asVariable.getOwnedInit() != null) {
						CGValuedElement cgInit = doVisit(CGValuedElement.class, asVariable.getOwnedInit());
						CGAccumulator cgAccumulator = CGModelFactory.eINSTANCE.createCGAccumulator();
						cgAccumulator.setName(asVariable.getName());
						cgAccumulator.setTypeId(cgInit.getTypeId());
						cgAccumulator.setInit(cgInit);
//						cgAccumulator.setRequired(true);
						cgAccumulator.setNonNull();
						cgMappingExp.getOwnedAccumulators().add(cgAccumulator);
						getVariablesStack().putVariable(asVariable, cgAccumulator);
					}
				}
				else {
					if (asVariable.getOwnedInit() != null) {
						cgVariableAssignments.add(doVisit(CGFinalVariable.class, asVariable));
					}
				}
			}
		}
		Collections.sort(pRealizedVariables, new Comparator<NamedElement>()
			{
				@Override
				public int compare(NamedElement o1, NamedElement o2) {
					return o1.getName().compareTo(o2.getName());
				}		
			});
		List<CGValuedElement> cgRealizedVariables = cgMappingExp.getRealizedVariables();
		for (@SuppressWarnings("null")@NonNull RealizedVariable pRealizedVariable : pRealizedVariables) {
			CGRealizedVariable cgVariable = getRealizedVariable(pRealizedVariable);
			cgRealizedVariables.add(cgVariable);
		}
		List<CGConnectionAssignment> cgConnectionAssignments = cgMappingExp.getConnectionAssignments();
		List<CGPropertyAssignment> cgPropertyAssignments = cgMappingExp.getAssignments();
		for (@SuppressWarnings("null")@NonNull BottomPattern pBottomPattern : pBottomPatterns) {
			EList<Assignment> assignment = pBottomPattern.getAssignment();
			for (@SuppressWarnings("null")@NonNull Assignment pAssignment : assignment) {
				if (pAssignment instanceof PropertyAssignment) {
					cgPropertyAssignments.add(doVisit(CGPropertyAssignment.class, pAssignment));
				}
				else if (pAssignment instanceof ConnectionAssignment) {
					cgConnectionAssignments.add(doVisit(CGConnectionAssignment.class, pAssignment));
				}
				else {
					cgVariableAssignments.add(doVisit(CGFinalVariable.class, pAssignment));
				}
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
				@Override
				public int compare(NamedElement o1, NamedElement o2) {
					return o1.getName().compareTo(o2.getName());
				}		
			});
		List<CGGuardVariable> cgFreeVariables = new ArrayList<CGGuardVariable>();
		List<CGFinalVariable> cgBoundVariables = new ArrayList<CGFinalVariable>();
		for (@SuppressWarnings("null")@NonNull Variable pGuardVariable : pGuardVariables) {
			OCLExpression initExpression = pGuardVariable.getOwnedInit();
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
			@Override
			public int compare(CGGuardVariable o1, CGGuardVariable o2) {
				String n1 = o1.getName();
				String n2 = o2.getName();
				return n1.compareTo(n2);
			}
		});
		Collections.sort(cgBoundVariables, new Comparator<CGFinalVariable>()
		{
			@Override
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

/*	protected @NonNull CGValuedElement generateMiddlePropertyCallExp(@NonNull CGValuedElement cgSource, @NonNull MiddlePropertyCallExp asMiddlePropertyCallExp) {
		Property asOppositeProperty = ClassUtil.nonNullModel(asMiddlePropertyCallExp.getReferredProperty());
		Property asProperty = ClassUtil.nonNullModel(asOppositeProperty.getOpposite());
		globalContext.addToMiddleProperty(asOppositeProperty);
//		LibraryProperty libraryProperty = metamodelManager.getImplementation(asProperty);
		CGMiddlePropertyCallExp cgPropertyCallExp = QVTiCGModelFactory.eINSTANCE.createCGMiddlePropertyCallExp();					
//		CGExecutorProperty cgExecutorProperty = context.getExecutorProperty(asProperty);
//		cgExecutorPropertyCallExp.setExecutorProperty(cgExecutorProperty);
//		cgPropertyCallExp = cgExecutorPropertyCallExp;
//		cgPropertyCallExp.getDependsOn().add(cgExecutorProperty);
		cgPropertyCallExp.setReferredProperty(asOppositeProperty);
		setAst(cgPropertyCallExp, asMiddlePropertyCallExp);
		cgPropertyCallExp.setRequired(asProperty.isIsRequired());
		cgPropertyCallExp.setSource(cgSource);
		return cgPropertyCallExp;
	} */

	@Override
	protected @NonNull CGValuedElement generateOperationCallExp(@Nullable CGValuedElement cgSource, @NonNull OperationCallExp asOperationCallExp) {
		Operation pOperation = asOperationCallExp.getReferredOperation();
		if (pOperation instanceof Function) {
			if (cgSource == null) {			// FIXME workaround for BUG 481664
				Transformation asTransformation = QVTbaseUtil.getContainingTransformation(asOperationCallExp);
				if (asTransformation != null) {
					Variable asThis = QVTbaseUtil.getContextVariable(metamodelManager.getStandardLibrary(), asTransformation);
					VariableExp asThisExp = PivotUtil.createVariableExp(asThis);
					cgSource = doVisit(CGValuedElement.class, asThisExp);
				}
			}
			CGFunctionCallExp cgFunctionCallExp = QVTiCGModelFactory.eINSTANCE.createCGFunctionCallExp();
			cgFunctionCallExp.setReferredOperation(pOperation);
			setAst(cgFunctionCallExp, asOperationCallExp);
			cgFunctionCallExp.setRequired(pOperation.isIsRequired());
			cgFunctionCallExp.setSource(cgSource);
			for (OCLExpression pArgument : asOperationCallExp.getOwnedArguments()) {
				CGValuedElement cgArgument = doVisit(CGValuedElement.class, pArgument);
				cgFunctionCallExp.getArguments().add(cgArgument);
			}
//			cgOperationCallExp.setOperation(getOperation(asOperationCallExp.getReferredOperation()));
			return cgFunctionCallExp;
		}
		else {
			return super.generateOperationCallExp(cgSource, asOperationCallExp);
		}
	}

	@Override
	protected @NonNull CGValuedElement generateOppositePropertyCallExp(@NonNull CGValuedElement cgSource, @NonNull OppositePropertyCallExp asOppositePropertyCallExp) {
		Property asOppositeProperty = ClassUtil.nonNullModel(asOppositePropertyCallExp.getReferredProperty());
		Property asProperty = ClassUtil.nonNullModel(asOppositeProperty.getOpposite());
		globalContext.addOppositeProperty(asOppositeProperty);
//		LibraryProperty libraryProperty = metamodelManager.getImplementation(asProperty);
		CGMiddlePropertyCallExp cgPropertyCallExp = QVTiCGModelFactory.eINSTANCE.createCGMiddlePropertyCallExp();					
//		CGExecutorProperty cgExecutorProperty = context.getExecutorProperty(asProperty);
//		cgExecutorPropertyCallExp.setExecutorProperty(cgExecutorProperty);
//		cgPropertyCallExp = cgExecutorPropertyCallExp;
//		cgPropertyCallExp.getDependsOn().add(cgExecutorProperty);
		cgPropertyCallExp.setReferredProperty(asOppositeProperty);
		setAst(cgPropertyCallExp, asOppositePropertyCallExp);
		cgPropertyCallExp.setRequired(asProperty.isIsRequired());
		cgPropertyCallExp.setSource(cgSource);
		return cgPropertyCallExp;
	}

	protected @Nullable EClassifier getEClassifier(@Nullable Type type) {
		if (type == null) {
			return null;
		}
		CompleteClass completeClass = environmentFactory.getCompleteModel().getCompleteClass(type);
		for (Type partialClass : completeClass.getPartialClasses()) {
			EObject esObject = partialClass.getESObject();
			if (esObject instanceof EClassifier) {
				return (EClassifier) esObject;
			}
		}
		return null;
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
		assert cgGuardVariable == null;
		boolean isConnectionVariable = QVTimperativeUtil.isConnectionVariable(asVariable);
		boolean isPrimitiveVariable = QVTimperativeUtil.isPrimitiveVariable(asVariable);
		if (isConnectionVariable) {
			cgGuardVariable = QVTiCGModelFactory.eINSTANCE.createCGConnectionVariable();
		}
		else {
			cgGuardVariable = QVTiCGModelFactory.eINSTANCE.createCGGuardVariable();
		}
		context.setNames(cgGuardVariable, asVariable);
		setAst(cgGuardVariable, asVariable);
		cgGuardVariable.setTypeId(context.getTypeId(asVariable.getTypeId()));
		if (!isConnectionVariable && !isPrimitiveVariable) {
			cgGuardVariable.setTypedModel(getTypedModel(asVariable));
		}
		addParameter(asVariable, cgGuardVariable);
		return cgGuardVariable;
	}

	public @NonNull CGRealizedVariable getRealizedVariable(@NonNull RealizedVariable pRealizedVariable) {
		Variables variablesStack = getVariablesStack();
		CGRealizedVariable cgVariable = (CGRealizedVariable) variablesStack.getVariable(pRealizedVariable);
		if (cgVariable == null) {
			EClassifier eClassifier = getEClassifier(pRealizedVariable.getType());
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
		Area pArea = ClassUtil.nonNullState(QVTcoreBaseUtil.getContainingArea(pVariable));
		TypedModel asTypedModel = null;
		if (pArea instanceof Domain) {
			asTypedModel = ClassUtil.nonNullState(((Domain)pArea).getTypedModel());
		}
		else {
			Transformation pTransformation = ((Mapping)pArea).getTransformation();
			asTypedModel = ClassUtil.nonNullState(pTransformation.getModelParameter(null));
		}
		return ClassUtil.nonNullState(analyzer.getTypedModel(asTypedModel));
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
	public @Nullable CGNamedElement visitConnectionAssignment(@NonNull ConnectionAssignment asConnectionAssignment) {
		Variable asVariable = asConnectionAssignment.getTargetVariable();
		if (asVariable == null) {
			return null;
		}
		CGVariable cgVariable = getVariable(asVariable);
		OCLExpression asInitValue = asConnectionAssignment.getValue();
		assert cgVariable instanceof CGConnectionVariable;
		CGValuedElement initValue = doVisit(CGValuedElement.class, asInitValue);
		CGConnectionAssignment cgConnectionAssignment = QVTiCGModelFactory.eINSTANCE.createCGConnectionAssignment();
		cgConnectionAssignment.setConnectionVariable((CGConnectionVariable) cgVariable);
		cgConnectionAssignment.setInitValue(initValue);
		cgConnectionAssignment.setTypeId(initValue.getTypeId());
		cgConnectionAssignment.setRequired(initValue.isRequired());
		return cgConnectionAssignment;
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
	public @Nullable CGNamedElement visitFunction(@NonNull Function asFunction) {
		CGFunction cgFunction = QVTiCGModelFactory.eINSTANCE.createCGFunction();
		setAst(cgFunction, asFunction);
		cgFunction.setRequired(asFunction.isIsRequired());
		for (Parameter pParameter : asFunction.getOwnedParameters()) {
			cgFunction.getParameters().add(doVisit(CGParameter.class, pParameter));
		}
		OCLExpression query = asFunction.getQueryExpression(); //getBodyExpression();
		if (query != null) {
//			try {
//				ExpressionInOCL query = metamodelManager.parseSpecification(specification);
//				Variable contextVariable = query.getOwnedContext();
//				if (contextVariable != null) {
//					getParameter(contextVariable);
//				}
//				for (@SuppressWarnings("null")@NonNull Variable parameterVariable : query.getOwnedParameters()) {
//					getParameter(parameterVariable);
//				}
				cgFunction.setBody(doVisit(CGValuedElement.class, query)); //.getOwnedBody()));
//			} catch (ParserException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		analyzer.addFunction(asFunction, cgFunction);
		return cgFunction;
	}

	@Override
	public @Nullable CGNamedElement visitFunctionParameter(@NonNull FunctionParameter asFunctionParameter) {
		return getFunctionParameter(asFunctionParameter);
	}

	@Override
	public @Nullable CGNamedElement visitGuardPattern(@NonNull GuardPattern object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitImperativeBottomPattern(@NonNull ImperativeBottomPattern object) {
		return visitBottomPattern(object);
	}

	@Override
	public @Nullable CGNamedElement visitImperativeDomain(@NonNull ImperativeDomain object) {
		return visitCoreDomain(object);
	}

	@Override
	public @Nullable CGNamedElement visitImperativeModel(@NonNull ImperativeModel object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitImport(@NonNull Import object) {
		return visiting(object);
	}

	@Override
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
		List<CGGuardVariable> cgFreeVariables = cgMapping.getFreeVariables();
		List<CGGuardVariable> sortedVariables = new ArrayList<CGGuardVariable>(cgFreeVariables);
		Collections.sort(sortedVariables, CGVariableComparator.INSTANCE);
		cgFreeVariables.clear();
		cgFreeVariables.addAll(sortedVariables);
		return cgMapping;
	}

	@Override
	public @Nullable CGNamedElement visitMappingCall(@NonNull MappingCall asMappingCall) {
		CGMappingCall cgMappingCall = QVTiCGModelFactory.eINSTANCE.createCGMappingCall();
		setAst(cgMappingCall, asMappingCall);
		List<CGMappingCallBinding> cgMappingCallBindings = new ArrayList<CGMappingCallBinding>();
		for (MappingCallBinding asMappingCallBinding : asMappingCall.getBinding()) {
			CGMappingCallBinding cgMappingCallBinding = doVisit(CGMappingCallBinding.class, asMappingCallBinding);
			cgMappingCallBindings.add(cgMappingCallBinding);
		}
		Collections.sort(cgMappingCallBindings, CGMappingCallBindingComparator.INSTANCE);
		cgMappingCall.getMappingCallBindings().addAll(cgMappingCallBindings);
		return cgMappingCall;
	}

	@Override
	public @Nullable CGNamedElement visitMappingCallBinding(@NonNull MappingCallBinding asMappingCallBinding) {
		Variable asBoundVariable = asMappingCallBinding.getBoundVariable();
		CGMappingCallBinding cgMappingCallBinding = QVTiCGModelFactory.eINSTANCE.createCGMappingCallBinding();
//		setPivot(cgMappingCallBinding, asMappingCallBinding);
		cgMappingCallBinding.setName(asBoundVariable.getName());
		cgMappingCallBinding.setAst(asMappingCallBinding);
		cgMappingCallBinding.setRequired(asBoundVariable.isIsRequired());
		cgMappingCallBinding.setValue(doVisit(CGValuedElement.class, asMappingCallBinding.getValue()));
		cgMappingCallBinding.setTypeId(analyzer.getTypeId(asBoundVariable.getTypeId()));
//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		return cgMappingCallBinding;
	}

	@Override
	public @Nullable CGNamedElement visitMappingLoop(@NonNull MappingLoop asMappingLoop) {
		CGMappingLoop cgMappingLoop = QVTiCGModelFactory.eINSTANCE.createCGMappingLoop();
		List<Variable> asIterators = asMappingLoop.getOwnedIterators();
		if (asIterators.size() > 0) {
			Variable asIterator = asIterators.get(0);
			if (asIterator != null) {
				CGIterator cgIterator = getIterator(asIterator);
				cgIterator.setTypeId(context.getTypeId(asIterator.getTypeId()));
				cgIterator.setRequired(asIterator.isIsRequired());
				if (asIterator.isIsRequired()) {
					cgIterator.setNonNull();
				}
				cgMappingLoop.getIterators().add(cgIterator);
			}
		}
		cgMappingLoop.setSource(doVisit(CGValuedElement.class, asMappingLoop.getOwnedSource()));
//		cgIterator.setNonInvalid();
//		cgIterator.setNonNull();
		cgMappingLoop.setAst(asMappingLoop);
		CollectionType collectionType = metamodelManager.getStandardLibrary().getCollectionType();
		Operation forAllIteration = NameUtil.getNameable(collectionType.getOwnedOperations(), "forAll");
		cgMappingLoop.setReferredIteration((Iteration) forAllIteration);
		cgMappingLoop.setBody(doVisit(CGValuedElement.class, asMappingLoop.getOwnedBody()));
		return cgMappingLoop;
	}

	@Override
	public @Nullable CGNamedElement visitMappingSequence(@NonNull MappingSequence asMappingSequence) {
		CGSequence cgSequence = QVTiCGModelFactory.eINSTANCE.createCGSequence();
		List<CGValuedElement> cgMappingStatements = cgSequence.getStatements();
		for (MappingStatement asMappingStatement : asMappingSequence.getMappingStatements()) {
			CGValuedElement cgMappingStatement = doVisit(CGValuedElement.class, asMappingStatement);
			cgMappingStatements.add(cgMappingStatement);
		}
		return cgSequence;
	}
	
	@Override
	public @Nullable CGNamedElement visitMappingStatement(@NonNull MappingStatement object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitPattern(@NonNull Pattern object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitPredicate(@NonNull Predicate asPredicate) {
		CGPredicate cgPredicate = QVTiCGModelFactory.eINSTANCE.createCGPredicate();
//		setPivot(cgPredicate, asPredicate);
//		cgPredicate.setName(asPredicate.getName());
		cgPredicate.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		cgPredicate.setConditionExpression(doVisit(CGValuedElement.class, asPredicate.getConditionExpression()));
		return cgPredicate;
	}

/*	@Override
	public @Nullable CGNamedElement visitMiddlePropertyAssignment(@NonNull MiddlePropertyAssignment asPropertyAssignment) {
//		Property asProperty = ClassUtil.nonNullModel(asPropertyAssignment.getTargetProperty());
		CGMiddlePropertyAssignment cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGMiddlePropertyAssignment();
//		setPivot(cgPropertyAssignment, asPredicate);
		cgPropertyAssignment.setSlotValue(doVisit(CGValuedElement.class, asPropertyAssignment.getSlotExpression()));
		Property asProperty = asPropertyAssignment.getTargetProperty();
		cgPropertyAssignment.setReferredProperty(asProperty);
//		cgPredicate.setName(asPredicate.getName());
		cgPropertyAssignment.setTypeId(analyzer.getTypeId(TypeId.OCL_VOID));
//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		cgPropertyAssignment.setInitValue(doVisit(CGValuedElement.class, asPropertyAssignment.getValue()));
		EStructuralFeature eStructuralFeature = (EStructuralFeature) asProperty.getESObject();
		if (eStructuralFeature != null) {
			try {
				genModelHelper.getGetAccessor(eStructuralFeature);
				cgPropertyAssignment.setEStructuralFeature(eStructuralFeature);
			} catch (GenModelException e) {
			}
		}
		return cgPropertyAssignment;
	} */

	@Override
	public @Nullable CGNamedElement visitPropertyAssignment(@NonNull PropertyAssignment asPropertyAssignment) {
		Transformation asTransformation = ClassUtil.nonNullModel(QVTbaseUtil.getContainingTransformation(asPropertyAssignment));
		QVTiTransformationAnalysis transformationAnalysis = analyzer.getCodeGenerator().getTransformationAnalysis(asTransformation);
		Integer cacheIndex = transformationAnalysis.getCacheIndex(asPropertyAssignment);
		if (cacheIndex != null) {
//			Property asProperty = ClassUtil.nonNullModel(asPropertyAssignment.getTargetProperty());
			CGMiddlePropertyAssignment cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGMiddlePropertyAssignment();
//			setAst(cgPropertyAssignment, asPropertyAssignment);
			cgPropertyAssignment.setSlotValue(doVisit(CGValuedElement.class, asPropertyAssignment.getSlotExpression()));
			Property asProperty = asPropertyAssignment.getTargetProperty();
			cgPropertyAssignment.setReferredProperty(asProperty);
//			cgPredicate.setName(asPredicate.getName());
			cgPropertyAssignment.setTypeId(analyzer.getTypeId(TypeId.OCL_VOID));
//			cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
			cgPropertyAssignment.setInitValue(doVisit(CGValuedElement.class, asPropertyAssignment.getValue()));
			EStructuralFeature eStructuralFeature = (EStructuralFeature) asProperty.getESObject();
			if (eStructuralFeature != null) {
				try {
					genModelHelper.getGetAccessor(eStructuralFeature);
					cgPropertyAssignment.setEStructuralFeature(eStructuralFeature);
				} catch (GenModelException e) {
				}
			}
			return cgPropertyAssignment;
		}
		else {
			Property asTargetProperty = ClassUtil.nonNullModel(asPropertyAssignment.getTargetProperty());
			LibraryProperty libraryProperty = metamodelManager.getImplementation(asPropertyAssignment, null, asTargetProperty);
			CGPropertyAssignment cgPropertyAssignment = null;
			if (isEcoreProperty(libraryProperty)) {
				EStructuralFeature eStructuralFeature = (EStructuralFeature) asTargetProperty.getESObject();
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
			setAst(cgPropertyAssignment, asPropertyAssignment);
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
	}

	@Override
	public @Nullable CGNamedElement visitRealizedVariable(@NonNull RealizedVariable object) {
//		CGExecutorType cgExecutorType = context.createExecutorType(pTypeExp.getReferredType());
//		cgTypeExp.setExecutorType(cgExecutorType);
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitRule(@NonNull Rule object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitTransformation(@NonNull Transformation asTransformation) {
		/*QVTiTransformationAnalysis transformationAnalysis =*/ analyzer.getCodeGenerator().getTransformationAnalysis(asTransformation);
		CGTransformation cgTransformation = QVTiCGModelFactory.eINSTANCE.createCGTransformation();
		setAst(cgTransformation, asTransformation);
		pushCurrentClass(cgTransformation);
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
		for (Operation asOperation : asTransformation.getOwnedOperations()) {
			CGOperation cgOperation = doVisit(CGOperation.class, asOperation);
			cgTransformation.getOperations().add(cgOperation);
		}
		popCurrentClass(cgTransformation);
		return cgTransformation;
	}

	@Override
	public @Nullable CGNamedElement visitTypedModel(@NonNull TypedModel asTypedModel) {
		CGTypedModel cgTypedModel = QVTiCGModelFactory.eINSTANCE.createCGTypedModel();
		setAst(cgTypedModel, asTypedModel);
		analyzer.addTypedModel(asTypedModel, cgTypedModel);
		return cgTypedModel;
	}

	@Override
	public @Nullable CGNamedElement visitVariable(@NonNull Variable asVariable) {
		CGVariable cgVariable = getVariable(asVariable);
		CGValuedElement initValue = doVisit(CGValuedElement.class, asVariable.getOwnedInit());
		cgVariable.setInit(initValue);
		cgVariable.setTypeId(initValue.getTypeId());
		cgVariable.setRequired(initValue.isRequired());
		return cgVariable;
	}

	@Override
	public @Nullable CGNamedElement visitVariableAssignment(@NonNull VariableAssignment asVariableAssignment) {
		Variable asVariable = asVariableAssignment.getTargetVariable();
		if (asVariable == null) {
			return null;
		}
		CGVariable cgVariable = getVariable(asVariable);
		OCLExpression asInitValue = asVariableAssignment.getValue();
		assert !(cgVariable instanceof CGConnectionVariable);
		CGValuedElement initValue = doVisit(CGValuedElement.class, asInitValue);
		cgVariable.setInit(initValue);
		cgVariable.setTypeId(initValue.getTypeId());
		cgVariable.setRequired(initValue.isRequired());
		return cgVariable;
	}

	@Override
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
