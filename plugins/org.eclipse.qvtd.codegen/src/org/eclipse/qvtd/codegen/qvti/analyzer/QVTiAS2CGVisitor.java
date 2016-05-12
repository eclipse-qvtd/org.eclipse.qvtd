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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGAccumulator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsKindOfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
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
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment;
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
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
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
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
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

	private <T extends CGValuedElement> @NonNull T addLeafExp(@NonNull CGMapping cgMapping, @Nullable CGValuedElement cgLeafExp, @NonNull T cgElement) {
		CGValuedElement cgElementRoot = cgElement;
		while (cgElementRoot.eContainer() != null) {
			cgElementRoot = (CGValuedElement) cgElementRoot.eContainer();
		}
		if (cgMapping.getBody() == null) {
			cgMapping.setBody(cgElementRoot);
		}
		if (cgLeafExp instanceof CGLetExp) {
			((CGLetExp)cgLeafExp).setIn(cgElementRoot);
		}
		else if (cgLeafExp instanceof CGIfExp) {
			((CGIfExp)cgLeafExp).setThenExpression(cgElementRoot);
		}
		else {
			assert cgLeafExp == null;
		}
		return cgElement;
	}

	protected @NonNull CGLetExp createBooleanCGLetExp(@NonNull CGMapping cgMapping, @Nullable CGValuedElement cgLeafExp, @NonNull Variable asVariable, @NonNull OCLExpression asInit) {
		CGValuedElement initExpression = doVisit(CGValuedElement.class, asInit);
		initExpression.setName(asVariable.getName());
		CGFinalVariable cgVariable = (CGFinalVariable) createCGVariable(asVariable);		// FIXME Lose cast
		cgVariable.setInit(initExpression);
		CGLetExp cgLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
		setAst(cgLetExp, asVariable);
		cgLetExp.setInit(cgVariable);
		cgLetExp.setTypeId(context.getTypeId(TypeId.BOOLEAN));
		return addLeafExp(cgMapping, cgLeafExp, cgLetExp);
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
				DomainUsage usage = domainUsageAnalysis.basicGetUsage((Element)prototypeEObject);
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

	protected @Nullable CGValuedElement doBottoms(@NonNull Mapping pMapping, @NonNull CGMapping cgMapping, @NonNull CGMappingExp cgMappingExp, @Nullable CGValuedElement cgGuardExp) {
		CGValuedElement cgLeafExp = cgGuardExp;
		List<@NonNull BottomPattern> pBottomPatterns = new ArrayList<@NonNull BottomPattern>();
		{
			BottomPattern pBottomPattern = pMapping.getBottomPattern();
			if (pBottomPattern != null) {
				pBottomPatterns.add(pBottomPattern);
			}
			for (@NonNull Domain pDomain : ClassUtil.nullFree(pMapping.getDomain())) {
				if (pDomain instanceof CoreDomain) {
					pBottomPattern = ((CoreDomain)pDomain).getBottomPattern();
					if (pBottomPattern != null) {
						pBottomPatterns.add(pBottomPattern);
					}
				}
			}
		}
		for (@NonNull BottomPattern pBottomPattern : pBottomPatterns) {
			for (@NonNull Variable asVariable : ClassUtil.nullFree(pBottomPattern.getVariable())) {
				OCLExpression asInit = asVariable.getOwnedInit();
				if (asVariable instanceof ConnectionVariable) {
					CGAccumulator cgAccumulator = CGModelFactory.eINSTANCE.createCGAccumulator();
					cgAccumulator.setAst(asVariable);
					cgAccumulator.setName(asVariable.getName());
					if (asInit != null) {
						CGValuedElement cgInit = doVisit(CGValuedElement.class, asInit);
						cgAccumulator.setTypeId(cgInit.getTypeId());
						cgAccumulator.setInit(cgInit);
//						cgAccumulator.setRequired(true);
					}
					else {
						cgAccumulator.setTypeId(context.getTypeId(asVariable.getTypeId()));
					}
					cgAccumulator.setNonNull();
					cgMappingExp.getOwnedAccumulators().add(cgAccumulator);
					getVariablesStack().putVariable(asVariable, cgAccumulator);
				}
				else {
					if (asInit != null) {
						cgLeafExp = createBooleanCGLetExp(cgMapping, cgLeafExp, asVariable, asInit);
					}
				}
			}
		}
		for (@NonNull BottomPattern pBottomPattern : pBottomPatterns) {
			List<@NonNull Assignment> assignment = ClassUtil.nullFree(pBottomPattern.getAssignment());
			for (@NonNull Assignment pAssignment : assignment) {
				if (pAssignment instanceof VariableAssignment) {
					VariableAssignment asVariableAssignment = (VariableAssignment) pAssignment;
					Variable asVariable = asVariableAssignment.getTargetVariable();
					OCLExpression asInit = asVariableAssignment.getValue();
					assert (asVariable != null) && (asInit != null);
					cgLeafExp = createBooleanCGLetExp(cgMapping, cgLeafExp, asVariable, asInit);
				}
			}
		}
		for (@NonNull BottomPattern pBottomPattern : pBottomPatterns) {
			for (@NonNull Predicate asPredicate : ClassUtil.nullFree(pBottomPattern.getPredicate())) {
				cgLeafExp = addLeafExp(cgMapping, cgLeafExp, doVisit(CGValuedElement.class, asPredicate));
			}
		}
		List<@NonNull RealizedVariable> pRealizedVariables = new ArrayList<@NonNull RealizedVariable>();
		for (@NonNull BottomPattern pBottomPattern : pBottomPatterns) {
			for (@NonNull RealizedVariable asRealizedVariable : ClassUtil.nullFree(pBottomPattern.getRealizedVariable())) {
				OCLExpression asInit = asRealizedVariable.getOwnedInit();
				if (asInit == null) {
					pRealizedVariables.add(asRealizedVariable);
				}
				else {
					cgLeafExp = createBooleanCGLetExp(cgMapping, cgLeafExp, asRealizedVariable, asInit);
				}
			}
		}
		Collections.sort(pRealizedVariables, NameUtil.NAMEABLE_COMPARATOR);
		List<@NonNull CGValuedElement> cgRealizedVariables = ClassUtil.nullFree(cgMappingExp.getRealizedVariables());
		for (@NonNull RealizedVariable pRealizedVariable : pRealizedVariables) {
			CGRealizedVariable cgVariable = getRealizedVariable(pRealizedVariable);
			cgRealizedVariables.add(cgVariable);
		}
		List<@NonNull CGConnectionAssignment> cgConnectionAssignments = ClassUtil.nullFree(cgMappingExp.getConnectionAssignments());
		List<@NonNull CGPropertyAssignment> cgPropertyAssignments = ClassUtil.nullFree(cgMappingExp.getAssignments());
		for (@NonNull BottomPattern pBottomPattern : pBottomPatterns) {
			List<@NonNull Assignment> assignment = ClassUtil.nullFree(pBottomPattern.getAssignment());
			for (@NonNull Assignment pAssignment : assignment) {
				if (pAssignment instanceof PropertyAssignment) {
					cgPropertyAssignments.add(doVisit(CGPropertyAssignment.class, pAssignment));
				}
				else if (pAssignment instanceof ConnectionAssignment) {
					cgConnectionAssignments.add(doVisit(CGConnectionAssignment.class, pAssignment));
				}
				else {
					assert pAssignment instanceof VariableAssignment;
				}
			}
		}
		return cgLeafExp;
	}

	protected @Nullable CGValuedElement doGuards(@NonNull Mapping pMapping, @NonNull CGMapping cgMapping) {
		CGValuedElement cgLeafExp = null;
		List<@NonNull GuardPattern> guardPatterns = new ArrayList<@NonNull GuardPattern>();
		{
			GuardPattern pGuardPattern = pMapping.getGuardPattern();
			if (pGuardPattern != null) {
				guardPatterns.add(pGuardPattern);
			}
			for (@NonNull Domain pDomain : ClassUtil.nullFree(pMapping.getDomain())) {
				if (pDomain instanceof CoreDomain) {
					GuardPattern guardPattern = ((CoreDomain)pDomain).getGuardPattern();
					if (guardPattern != null) {
						guardPatterns.add(guardPattern);
					}
				}
			}
		}
		Set<@NonNull Variable> predicatedVariables = new HashSet<@NonNull Variable>();
		for (@NonNull GuardPattern pGuardPattern : guardPatterns) {
			for (Predicate predicate : pGuardPattern.getPredicate()) {
				if (predicate instanceof VariablePredicate) {
					Variable targetVariable = ((VariablePredicate)predicate).getTargetVariable();
					assert targetVariable != null;
					predicatedVariables.add(targetVariable);
				}
			};
		}
		List<@NonNull Variable> pGuardVariables = new ArrayList<@NonNull Variable>();
		for (@NonNull GuardPattern pGuardPattern : guardPatterns) {
			pGuardPattern.getPredicate();
			for (@NonNull Variable pGuardVariable : ClassUtil.nullFree(pGuardPattern.getVariable())) {
				if (!predicatedVariables.contains(pGuardVariable)) {
					pGuardVariables.add(pGuardVariable);
				}
			}
		}
		Collections.sort(pGuardVariables, new Comparator<@NonNull NamedElement>()
			{
				@Override
				public int compare(@NonNull NamedElement o1, @NonNull NamedElement o2) {
					return o1.getName().compareTo(o2.getName());
				}		
			});
		List<@NonNull CGGuardVariable> cgFreeVariables = new ArrayList<@NonNull CGGuardVariable>();
//		List<CGFinalVariable> cgBoundVariables = new ArrayList<CGFinalVariable>();
		for (@NonNull Variable pGuardVariable : pGuardVariables) {
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
//				cgBoundVariables.add(cgBoundVariable);
			}
		}
		Collections.sort(cgFreeVariables, new Comparator<@NonNull CGGuardVariable>()
		{
			@Override
			public int compare(@NonNull CGGuardVariable o1, @NonNull CGGuardVariable o2) {
				String n1 = o1.getName();
				String n2 = o2.getName();
				return n1.compareTo(n2);
			}
		});
/*		Collections.sort(cgBoundVariables, new Comparator<CGFinalVariable>()
		{
			@Override
			public int compare(CGFinalVariable o1, CGFinalVariable o2) {
				String n1 = o1.getName();
				String n2 = o2.getName();
				return n1.compareTo(n2);
			}
		}); */
		cgMapping.getFreeVariables().addAll(cgFreeVariables);
//		cgMappingExp.getBoundVariables().addAll(cgBoundVariables);
//		List<CGPredicate> cgGuardExpressions = cgMappingExp.getPredicates();
		for (@NonNull GuardPattern pGuardPattern : guardPatterns) {
			for (@NonNull Predicate asPredicate : ClassUtil.nullFree(pGuardPattern.getPredicate())) {
				cgLeafExp = addLeafExp(cgMapping, cgLeafExp, doVisit(CGValuedElement.class, asPredicate));
			}
		}
		return cgLeafExp;
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
		if (asOppositeProperty.isIsComposite()) {
			return super.generateOppositePropertyCallExp(cgSource, asOppositePropertyCallExp);
		}
		else {
			globalContext.addOppositeProperty(asOppositeProperty);
	//		LibraryProperty libraryProperty = metamodelManager.getImplementation(asProperty);
			CGMiddlePropertyCallExp cgPropertyCallExp = QVTiCGModelFactory.eINSTANCE.createCGMiddlePropertyCallExp();
			cgPropertyCallExp.setAst(asOppositePropertyCallExp);
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
		boolean isConnectionVariable = asVariable instanceof ConnectionVariable;
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
		CGVariable cgVariable2 = variablesStack.getVariable(pRealizedVariable);
		CGRealizedVariable cgVariable = (CGRealizedVariable) cgVariable2;
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
		CGValuedElement initValue = doVisit(CGValuedElement.class, asInitValue);
		CGConnectionAssignment cgConnectionAssignment = QVTiCGModelFactory.eINSTANCE.createCGConnectionAssignment();
		cgConnectionAssignment.setConnectionVariable(cgVariable);
		cgConnectionAssignment.setInitValue(initValue);
		cgConnectionAssignment.setTypeId(initValue.getTypeId());
		cgConnectionAssignment.setRequired(initValue.isRequired());
		return cgConnectionAssignment;
	}

	@Override
	public @Nullable CGNamedElement visitConnectionStatement(@NonNull ConnectionStatement asConnectionStatement) {
		Variable asVariable = asConnectionStatement.getTargetVariable();
		if (asVariable == null) {
			return null;
		}
		CGVariable cgVariable = getVariable(asVariable);
		OCLExpression asInitValue = asConnectionStatement.getValue();
		assert (cgVariable instanceof CGConnectionVariable) || (cgVariable instanceof CGAccumulator);
		CGValuedElement initValue = doVisit(CGValuedElement.class, asInitValue);
		CGConnectionAssignment cgConnectionAssignment = QVTiCGModelFactory.eINSTANCE.createCGConnectionAssignment();
		cgConnectionAssignment.setConnectionVariable(cgVariable);
		cgConnectionAssignment.setInitValue(initValue);
		cgConnectionAssignment.setTypeId(initValue.getTypeId());
		cgConnectionAssignment.setRequired(initValue.isRequired());
		return cgConnectionAssignment;
	}

	@Override
	public @Nullable CGNamedElement visitConnectionVariable(@NonNull ConnectionVariable asConnectionVariable) {
		CGVariable cgVariable = getVariable(asConnectionVariable);
		CGValuedElement initValue = doVisit(CGValuedElement.class, asConnectionVariable.getOwnedInit());
		cgVariable.setInit(initValue);
		cgVariable.setTypeId(initValue.getTypeId());
		cgVariable.setRequired(initValue.isRequired());
		return cgVariable;
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
		@SuppressWarnings("unused")String name = pMapping.getName();
		CGMapping cgMapping = QVTiCGModelFactory.eINSTANCE.createCGMapping();
		setAst(cgMapping, pMapping);
		analyzer.addMapping(pMapping, cgMapping);
		TypeId pivotTypeId = TypeId.BOOLEAN; //pMapping.getTypeId();
		CGMappingExp cgMappingExp = QVTiCGModelFactory.eINSTANCE.createCGMappingExp();
		setAst(cgMappingExp, pMapping);
		cgMappingExp.setTypeId(context.getTypeId(pivotTypeId));
//		cgMapping.setBody(cgMappingExp);
		CGValuedElement cgGuardExp = doGuards(pMapping, cgMapping);
		CGValuedElement cgBottomExp = doBottoms(pMapping, cgMapping, cgMappingExp, cgGuardExp);
		addLeafExp(cgMapping, cgBottomExp, cgMappingExp);
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
	public @Nullable CGNamedElement visitNavigationAssignment(@NonNull NavigationAssignment asNavigationAssignment) {
		Transformation asTransformation = ClassUtil.nonNullModel(QVTbaseUtil.getContainingTransformation(asNavigationAssignment));
		QVTiTransformationAnalysis transformationAnalysis = analyzer.getCodeGenerator().getTransformationAnalysis(asTransformation);
		Integer cacheIndex = transformationAnalysis.getCacheIndex(asNavigationAssignment);
		if (cacheIndex != null) {
//			Property asProperty = ClassUtil.nonNullModel(asPropertyAssignment.getTargetProperty());
			CGMiddlePropertyAssignment cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGMiddlePropertyAssignment();
			setAst(cgPropertyAssignment, asNavigationAssignment);
			cgPropertyAssignment.setSlotValue(doVisit(CGValuedElement.class, asNavigationAssignment.getSlotExpression()));
			Property asProperty = QVTcoreBaseUtil.getTargetProperty(asNavigationAssignment);
			cgPropertyAssignment.setReferredProperty(asProperty);
//			cgPredicate.setName(asPredicate.getName());
			cgPropertyAssignment.setTypeId(analyzer.getTypeId(TypeId.OCL_VOID));
//			cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
			cgPropertyAssignment.setInitValue(doVisit(CGValuedElement.class, asNavigationAssignment.getValue()));
			EStructuralFeature eStructuralFeature = (EStructuralFeature) asProperty.getESObject();
			if (eStructuralFeature != null) {
				try {
					genModelHelper.getGetAccessor(eStructuralFeature);
					cgPropertyAssignment.setEStructuralFeature(eStructuralFeature);
				} catch (GenModelException e) {
					System.out.println("Missing getAccessor for " + eStructuralFeature + "ignored.");
				}
			}
			return cgPropertyAssignment;
		}
		else {
			Property asTargetProperty = QVTcoreBaseUtil.getTargetProperty(asNavigationAssignment);
			LibraryProperty libraryProperty = metamodelManager.getImplementation(asNavigationAssignment, null, asTargetProperty);
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
						System.out.println("Missing getAccessor for " + eStructuralFeature + "ignored.");
					}
				}
				else {
					Property asOppositeProperty = asTargetProperty.getOpposite();
					eStructuralFeature = (EStructuralFeature) (asOppositeProperty != null ? asOppositeProperty.getESObject() : null);
					if (eStructuralFeature != null) {
						assert ((EReference)eStructuralFeature).isContainment();
						try {
							genModelHelper.getGetAccessor(eStructuralFeature);
							CGEcoreContainerAssignment cgEcoreContainerAssignment = QVTiCGModelFactory.eINSTANCE.createCGEcoreContainerAssignment();
							cgEcoreContainerAssignment.setEStructuralFeature(eStructuralFeature);
							cgPropertyAssignment = cgEcoreContainerAssignment;
						} catch (GenModelException e) {
							System.out.println("Missing getAccessor for " + eStructuralFeature + "ignored.");
						}
					}
				}
			}
			if (cgPropertyAssignment == null) {
				cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGPropertyAssignment();
			}
			setAst(cgPropertyAssignment, asNavigationAssignment);
			cgPropertyAssignment.setSlotValue(doVisit(CGValuedElement.class, asNavigationAssignment.getSlotExpression()));
			cgPropertyAssignment.setReferredProperty(asTargetProperty);
	//		cgPredicate.setName(asPredicate.getName());
			cgPropertyAssignment.setTypeId(analyzer.getTypeId(TypeId.OCL_VOID));
	//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
			cgPropertyAssignment.setInitValue(doVisit(CGValuedElement.class, asNavigationAssignment.getValue()));
	
			CGExecutorProperty cgExecutorProperty = context.createExecutorProperty(asTargetProperty);
			cgPropertyAssignment.setExecutorProperty(cgExecutorProperty);
			return cgPropertyAssignment;
		}
	}

	@Override
	public @Nullable CGNamedElement visitPattern(@NonNull Pattern object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGIfExp visitPredicate(@NonNull Predicate asPredicate) {
		CGIfExp cgPredicate = CGModelFactory.eINSTANCE.createCGIfExp();
		cgPredicate.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
		cgPredicate.setRequired(true);
		OCLExpression asConditionExpression = asPredicate.getConditionExpression();
		assert asConditionExpression != null;
		cgPredicate.setCondition(doVisit(CGValuedElement.class, asConditionExpression));
		CGConstantExp cgElse = context.createCGConstantExp(asConditionExpression, context.getBoolean(false));
		setAst(cgElse, asConditionExpression);
		cgElse.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
		cgElse.setRequired(true);
		cgPredicate.setElseExpression(cgElse);
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
	public @Nullable CGNamedElement visitOppositePropertyAssignment(@NonNull OppositePropertyAssignment asPropertyAssignment) {
		return visitNavigationAssignment(asPropertyAssignment);
	}

	@Override
	public @Nullable CGNamedElement visitPropertyAssignment(@NonNull PropertyAssignment asPropertyAssignment) {
		return visitNavigationAssignment(asPropertyAssignment);
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
		OCLExpression asExpression = asPredicate.getConditionExpression();
		assert asExpression != null;
		Variable asVariable = asPredicate.getTargetVariable();
		//
		CGValuedElement cgExpression = doVisit(CGValuedElement.class, asExpression);
		cgExpression.setName("temp1_" + asVariable.getName());
		//
		CGFinalVariable cgUncastVariable = CGModelFactory.eINSTANCE.createCGFinalVariable();
		cgUncastVariable.setName("temp2_" + asVariable.getName());
		cgUncastVariable.setInit(cgExpression);
		cgUncastVariable.setTypeId(cgExpression.getTypeId());
		cgUncastVariable.setRequired(cgExpression.isRequired());
		//
		CGLetExp cgOuterLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
		setAst(cgOuterLetExp, asPredicate);
		cgOuterLetExp.setInit(cgUncastVariable);
		cgOuterLetExp.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
		cgOuterLetExp.setRequired(true);
		//
		CGIfExp cgPredicate = CGModelFactory.eINSTANCE.createCGIfExp();
		cgPredicate.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
		cgPredicate.setRequired(true);
		CGConstantExp cgElse = context.createCGConstantExp(asExpression, context.getBoolean(false));
		setAst(cgElse, asPredicate);
		cgElse.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
		cgElse.setRequired(true);
		cgPredicate.setElseExpression(cgElse);
		CGIsKindOfExp cgIsKindOfExp = CGModelFactory.eINSTANCE.createCGIsKindOfExp();
		cgIsKindOfExp.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
		cgIsKindOfExp.setRequired(true);
		CGVariableExp cgUncastVariableExp1 = CGModelFactory.eINSTANCE.createCGVariableExp();
		setAst(cgUncastVariableExp1, asVariable);
		cgUncastVariableExp1.setReferredVariable(cgUncastVariable);
		cgUncastVariableExp1.setTypeId(cgUncastVariable.getTypeId());
		cgUncastVariableExp1.setRequired(cgUncastVariable.isRequired());
		cgIsKindOfExp.setSource(cgUncastVariableExp1);
		
		CGExecutorType cgExecutorType = context.createExecutorType(ClassUtil.nonNullState(asVariable.getType()));
		cgIsKindOfExp.setExecutorType(cgExecutorType);
		cgPredicate.setCondition(cgIsKindOfExp);
		cgOuterLetExp.setIn(cgPredicate);
		
		CGVariableExp cgUncastVariableExp2 = CGModelFactory.eINSTANCE.createCGVariableExp();
		setAst(cgUncastVariableExp2, asVariable);
		cgUncastVariableExp2.setReferredVariable(cgUncastVariable);
		cgUncastVariableExp2.setTypeId(cgUncastVariable.getTypeId());
		cgUncastVariableExp2.setRequired(cgUncastVariable.isRequired());
		CGCastExp cgCastExp = CGModelFactory.eINSTANCE.createCGCastExp();
		cgCastExp.setSource(cgUncastVariableExp2);
		cgCastExp.setExecutorType(cgExecutorType);
		TypeId asTypeId = cgExecutorType.getASTypeId();
		assert asTypeId != null;
		cgCastExp.setTypeId(context.getTypeId(asTypeId));

		CGFinalVariable cgCastVariable = (CGFinalVariable) createCGVariable(asVariable);		// FIXME Lose cast
		cgCastVariable.setInit(cgCastExp);

		CGLetExp cgCastLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
		setAst(cgCastLetExp, asPredicate);
		cgCastLetExp.setInit(cgCastVariable);
		cgCastLetExp.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
		cgCastLetExp.setRequired(true);
		
		cgPredicate.setThenExpression(cgCastLetExp);
		return cgCastLetExp;
	}
}
