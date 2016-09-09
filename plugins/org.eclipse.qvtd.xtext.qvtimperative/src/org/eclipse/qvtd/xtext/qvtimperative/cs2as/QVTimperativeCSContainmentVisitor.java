/*******************************************************************************
 * Copyright (c) 2010, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.cs2as;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Assignment;
import org.eclipse.qvtd.pivot.qvtimperative.BottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.GuardPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableAssignment;
import org.eclipse.qvtd.xtext.qvtimperativecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ConnectionStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.PatternCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.PredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.UnrealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.impl.DomainCSImpl;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.AbstractQVTimperativeCSContainmentVisitor;

import com.google.common.collect.Iterables;

public class QVTimperativeCSContainmentVisitor extends AbstractQVTimperativeCSContainmentVisitor
{
	protected static class IsAssignmentPredicate implements com.google.common.base.Predicate<PredicateOrAssignmentCS>
	{
		public final static @NonNull IsAssignmentPredicate INSTANCE = new IsAssignmentPredicate();

		@Override
		public boolean apply(PredicateOrAssignmentCS csAssignment) {
			return csAssignment.getOwnedInitExpression() != null;
		}
	}

	protected static class IsPredicatePredicate implements com.google.common.base.Predicate<PredicateOrAssignmentCS>
	{
		public final static @NonNull IsPredicatePredicate INSTANCE = new IsPredicatePredicate();

		@Override
		public boolean apply(PredicateOrAssignmentCS csAssignment) {
			return csAssignment.getOwnedInitExpression() == null;
		}
	}

	protected static class DirectionContentContinuation extends SingleContinuation<DirectionCS>
	{
		private DirectionContentContinuation(@NonNull CS2ASConversion context, @NonNull DirectionCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			TypedModel pTypedModel = PivotUtil.getPivot(TypedModel.class, csElement);
			if (pTypedModel != null) {
				PivotUtilInternal.refreshList(pTypedModel.getUsedPackage(), csElement.getImports());
			}
			return null;
		}
	}

	protected static class DomainContentContinuation extends SingleContinuation<DomainCS>
	{
		private DomainContentContinuation(@NonNull CS2ASConversion context, @NonNull DomainCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			ImperativeDomain pDomain = PivotUtil.getPivot(ImperativeDomain.class, csElement);
			if (pDomain != null) {
				TypedModel direction = csElement.getDirection();
				if (direction == null) {
					Transformation transformation = QVTbaseUtil.getContainingTransformation(pDomain);
					if (transformation != null) {
						direction = transformation.getModelParameter(null);
					}
				}
				pDomain.setTypedModel(direction);
			}
			return null;
		}
	}

	public QVTimperativeCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	protected void resolveTransformationMappings(@NonNull Iterable<? extends @NonNull MappingCS> csMappings) {
		Map<@NonNull Transformation, List<@NonNull Mapping>> tx2mappings = new HashMap<@NonNull Transformation, List<@NonNull Mapping>>();
		for (@NonNull MappingCS csMapping : csMappings) {
			PathNameCS csInPathName = csMapping.getOwnedInPathName();
			if (csInPathName != null) {
				Transformation asTransformation = lookupTransformation(csMapping, csInPathName, null);
				if (asTransformation != null) {
					Mapping asMapping = PivotUtil.getPivot(Mapping.class, csMapping);
					if (asMapping != null) {
						List<@NonNull Mapping> asMappings = tx2mappings.get(asTransformation);
						if (asMappings == null) {
							asMappings = new ArrayList<@NonNull Mapping>();
							tx2mappings.put(asTransformation, asMappings);
						}
						asMappings.add(asMapping);
					}
				}
			}
		}
		for (@NonNull Transformation asTransformation : tx2mappings.keySet()) {
			List<@NonNull Mapping> asMappings = tx2mappings.get(asTransformation);
			List<Rule> asRules = asTransformation.getRule();
			if (asMappings != null) {
				PivotUtilInternal.refreshList(asRules, asMappings);
			}
			else {
				asRules.clear();
			}
		}
	}

	protected void resolveTransformationQueries(@NonNull Iterable<@NonNull QueryCS> csQueries) {
		Map<@NonNull Transformation, List<@NonNull Function>> tx2qMap = new HashMap<@NonNull Transformation, List<@NonNull Function>>();
		for (@NonNull QueryCS csQuery : csQueries) {
			Transformation asTransformation = csQuery.getTransformation();
			if (asTransformation != null) {
				Function asQuery = PivotUtil.getPivot(Function.class,  csQuery);
				if (asQuery != null) {
					List<@NonNull Function> asQueries = tx2qMap.get(asTransformation);
					if (asQueries == null) {
						asQueries = new ArrayList<@NonNull Function>();
						tx2qMap.put(asTransformation, asQueries);
					}
					asQueries.add(asQuery);
				}
			}
		}
		for (Transformation asTransformation : tx2qMap.keySet()) {
			List<@NonNull Function> asQueries = tx2qMap.get(asTransformation);
			List<Operation> asOperations = asTransformation.getOwnedOperations();
			if (asQueries != null) {
				PivotUtilInternal.refreshList(asOperations, asQueries);
			}
			else {
				asOperations.clear();
			}
		}
	}

	@Override
	public Continuation<?> visitBottomPatternCS(@NonNull BottomPatternCS csElement) {
		BottomPattern pBottomPattern = context.refreshModelElement(BottomPattern.class, QVTimperativePackage.Literals.BOTTOM_PATTERN, csElement);
		context.refreshPivotList(RealizedVariable.class, pBottomPattern.getRealizedVariable(), csElement.getOwnedRealizedVariables());
		context.refreshPivotList(Variable.class, pBottomPattern.getVariable(), csElement.getOwnedUnrealizedVariables());
		context.refreshPivotList(Assignment.class, pBottomPattern.getAssignment(), Iterables.filter(csElement.getOwnedConstraints(), IsAssignmentPredicate.INSTANCE));
		context.refreshPivotList(Predicate.class, pBottomPattern.getPredicate(), Iterables.filter(csElement.getOwnedConstraints(), IsPredicatePredicate.INSTANCE));
		context.refreshComments(pBottomPattern, csElement);
		return null;
	}

	@Override
	public @Nullable Continuation<?> visitConnectionStatementCS(@NonNull ConnectionStatementCS csElement) {
		context.refreshModelElement(AddStatement.class, QVTimperativePackage.Literals.ADD_STATEMENT, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitDirectionCS(@NonNull DirectionCS csElement) {
		refreshNamedElement(TypedModel.class, QVTbasePackage.Literals.TYPED_MODEL, csElement);
		Continuation<?> continuation = new DirectionContentContinuation(context, csElement);
		TypedModel asTypedModel = PivotUtil.getPivot(TypedModel.class, csElement);
		if (asTypedModel != null) {
			QVTbaseUtil.getContextVariable(standardLibrary, asTypedModel);
		}
		return continuation;
	}

	@Override
	public Continuation<?> visitDomainCS(@NonNull DomainCS csElement) {
		EObject eContainer = csElement.eContainer();
		if ((eContainer instanceof MappingCS) && (((MappingCS)eContainer).getOwnedMiddle() == csElement)) {
			return null;
		}
		ImperativeDomain pivotElement = context.refreshModelElement(ImperativeDomain.class, QVTimperativePackage.Literals.IMPERATIVE_DOMAIN, csElement);
		pivotElement.setIsCheckable(csElement.isIsCheck());
		pivotElement.setIsEnforceable(csElement.isIsEnforce());
		pivotElement.setBottomPattern(PivotUtil.getPivot(BottomPattern.class, csElement.getOwnedBottomPattern()));
		pivotElement.setGuardPattern(PivotUtil.getPivot(GuardPattern.class, csElement.getOwnedGuardPattern()));
		context.refreshComments(pivotElement, csElement);
		return new DomainContentContinuation(context, csElement);
	}

	@Override
	public Continuation<?> visitGuardPatternCS(@NonNull GuardPatternCS csElement) {
		@NonNull GuardPattern pGuardPattern = context.refreshModelElement(GuardPattern.class, QVTimperativePackage.Literals.GUARD_PATTERN, csElement);
		context.refreshPivotList(Variable.class, pGuardPattern.getVariable(), csElement.getOwnedUnrealizedVariables());
		context.refreshPivotList(Predicate.class, pGuardPattern.getPredicate(), csElement.getOwnedPredicates());
		context.refreshComments(pGuardPattern, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitMappingCS(@NonNull MappingCS csElement) {
		@NonNull Mapping pivotElement = refreshNamedElement(Mapping.class, QVTimperativePackage.Literals.MAPPING, csElement);
		DomainCS csMiddle = csElement.getOwnedMiddle();
		if (csMiddle != null) {
			pivotElement.setBottomPattern(PivotUtil.getPivot(BottomPattern.class, csMiddle.getOwnedBottomPattern()));
			pivotElement.setGuardPattern(PivotUtil.getPivot(GuardPattern.class, csMiddle.getOwnedGuardPattern()));
		}
		else {
			BottomPattern bottomPattern = pivotElement.getBottomPattern();
			if (bottomPattern == null) {
				bottomPattern = QVTimperativeFactory.eINSTANCE.createBottomPattern();
				bottomPattern.getAssignment().clear();
				bottomPattern.getBindsTo().clear();
				bottomPattern.getPredicate().clear();
				bottomPattern.getRealizedVariable().clear();
				bottomPattern.getVariable().clear();
				pivotElement.setBottomPattern(bottomPattern);
			}
			GuardPattern guardPattern = pivotElement.getGuardPattern();
			if (guardPattern == null) {
				guardPattern = QVTimperativeFactory.eINSTANCE.createGuardPattern();
				guardPattern.getBindsTo().clear();
				guardPattern.getPredicate().clear();
				guardPattern.getVariable().clear();
				pivotElement.setGuardPattern(guardPattern);
			}
		}
		context.refreshPivotList(ImperativeDomain.class, pivotElement.getDomain(), csElement.getOwnedDomains());
		context.refreshPivotList(Statement.class, pivotElement.getOwnedStatements(), csElement.getOwnedStatements());
		pivotElement.setIsDefault(csElement.isIsDefault());
		return null;
	}

	@Override
	public Continuation<?> visitMappingCallCS(@NonNull MappingCallCS csElement) {
		@NonNull MappingCall pivotElement = context.refreshModelElement(MappingCall.class, QVTimperativePackage.Literals.MAPPING_CALL, csElement);
		context.refreshPivotList(MappingCallBinding.class, pivotElement.getBinding(), csElement.getOwnedBindings());
		pivotElement.setIsInfinite(csElement.isIsInfinite());
		context.refreshComments(pivotElement, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitMappingCallBindingCS(@NonNull MappingCallBindingCS csElement) {
		@NonNull MappingCallBinding pivotElement = context.refreshModelElement(MappingCallBinding.class, QVTimperativePackage.Literals.MAPPING_CALL_BINDING, csElement);
		pivotElement.setIsPolled(csElement.isIsPolled());
		context.refreshComments(pivotElement, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitMappingLoopCS(@NonNull MappingLoopCS csMappingLoop) {
		@NonNull MappingLoop pivotElement = context.refreshModelElement(MappingLoop.class, QVTimperativePackage.Literals.MAPPING_LOOP, csMappingLoop);
		@NonNull Variable iterator = refreshNamedElement(Variable.class, PivotPackage.Literals.VARIABLE, ClassUtil.nonNullState(csMappingLoop.getOwnedIterator()));
		pivotElement.getOwnedIterators().clear();
		pivotElement.getOwnedIterators().add(iterator);
		context.refreshPivotList(MappingStatement.class, pivotElement.getOwnedMappingStatements(), csMappingLoop.getOwnedMappingStatements());
		//		CollectionType collectionType = metamodelManager.getCollectionType();
		//		DomainOperation forAllIteration = ClassUtil.getNamedElement(collectionType.getLocalOperations(), "forAll");
		//		pivotElement.setReferredIteration((Iteration) forAllIteration);
		context.refreshComments(pivotElement, csMappingLoop);
		return null;
	}

	@Override
	public Continuation<?> visitParamDeclarationCS(@NonNull ParamDeclarationCS csElement) {
		refreshNamedElement(FunctionParameter.class, QVTbasePackage.Literals.FUNCTION_PARAMETER, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitPredicateCS(@NonNull PredicateCS csElement) {
		context.refreshModelElement(Predicate.class, QVTbasePackage.Literals.PREDICATE, csElement);
		return null;
	}

	@Override
	public @Nullable Continuation<?> visitPredicateOrAssignmentCS(@NonNull PredicateOrAssignmentCS csElement) {
		ExpCS csTarget = csElement.getOwnedTarget();
		EObject eContainer = csElement.eContainer();
		if ((csElement.getOwnedInitExpression() == null) || (eContainer instanceof GuardPatternCS)) {
			context.refreshModelElement(Predicate.class, QVTbasePackage.Literals.PREDICATE, csElement);
		}
		else if (csTarget instanceof NameExpCS) {
			context.refreshModelElement(VariableAssignment.class, QVTimperativePackage.Literals.VARIABLE_ASSIGNMENT, csElement);
		}
		else {
			throw new IllegalStateException();
		}
		return null;
	}

	@Override
	public Continuation<?> visitQueryCS(@NonNull QueryCS csElement) {
		PathNameCS pathName = csElement.getOwnedPathName();
		if (pathName != null) {
			CS2AS.setElementType(pathName, QVTbasePackage.Literals.TRANSFORMATION, csElement, null);
		}
		@NonNull Function pivotElement = refreshNamedElement(Function.class, QVTbasePackage.Literals.FUNCTION, csElement);
		//		pivotElement.setIsStatic(true);
		pivotElement.setIsTransient(csElement.isIsTransient());
		context.refreshPivotList(FunctionParameter.class, pivotElement.getOwnedParameters(), csElement.getOwnedParameters());
		return null;
	}

	@Override
	public Continuation<?> visitRealizedVariableCS(@NonNull RealizedVariableCS csElement) {
		refreshNamedElement(RealizedVariable.class, QVTimperativePackage.Literals.REALIZED_VARIABLE, csElement);
		return null;
	}

	@Override
	public @Nullable Continuation<?> visitSetStatementCS(@NonNull SetStatementCS csElement) {
		context.refreshModelElement(SetStatement.class, QVTimperativePackage.Literals.SET_STATEMENT, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS csElement) {
		importPackages(csElement);
		@NonNull ImperativeModel asModel = refreshRoot(ImperativeModel.class, QVTimperativePackage.Literals.IMPERATIVE_MODEL, csElement);
		installPackageStructure(asModel, ClassUtil.nullFree(csElement.getOwnedPackages()), ClassUtil.nullFree(csElement.getOwnedTransformations()));
		context.refreshPivotList(Import.class, asModel.getOwnedImports(), csElement.getOwnedImports());
		//
		Resource eResource = csElement.eResource();
		if (eResource instanceof BaseCSResource) {
			context.installRootElement((BaseCSResource)eResource, asModel);		// Ensure containment viable for imported library type references
			//			importPackages(csElement);			// FIXME This has to be after refreshPackage which is irregular and prevents local realization of ImportCS etc
		}
		//
		resolveTransformationMappings(ClassUtil.nullFree(csElement.getOwnedMappings()));
		resolveTransformationQueries(ClassUtil.nullFree(csElement.getOwnedQueries()));
		//		context.addMappings(ClassUtil.nullFree(csElement.getOwnedMappings()));
		//		context.addQueries(ClassUtil.nullFree(csElement.getOwnedQueries()));
		//		context.installTransformationStructure();
		return null;
	}

	@Override
	public Continuation<?> visitTransformationCS(@NonNull TransformationCS csElement) {
		PathNameCS pathName = csElement.getOwnedPathName();
		if (pathName != null) {
			CS2AS.setElementType(pathName, PivotPackage.Literals.NAMESPACE, csElement, null);
		}
		@SuppressWarnings("null") @NonNull EClass eClass = QVTbasePackage.Literals.TRANSFORMATION;
		Transformation asTransformation = refreshNamedElement(Transformation.class, eClass, csElement);
		refreshClassifier(asTransformation, csElement);
		context.refreshPivotList(TypedModel.class, asTransformation.getModelParameter(), csElement.getOwnedDirections());
		QVTbaseUtil.getContextVariable(standardLibrary, asTransformation);
		return null;
	}

	@Override
	public Continuation<?> visitUnrealizedVariableCS(@NonNull UnrealizedVariableCS csElement) {
		EObject eContainer = csElement.eContainer();
		if ((eContainer instanceof PatternCS) && !(csElement.getOwnedType() instanceof PrimitiveTypeRefCS)) {		// FIXME need clearer syntax
			EObject eContainerContainer = eContainer.eContainer();
			if (eContainerContainer instanceof DomainCSImpl) {
				TypedModel typedModel = ((DomainCSImpl)eContainerContainer).basicGetDirection();
				if (typedModel == null) {
					refreshNamedElement(ConnectionVariable.class, QVTimperativePackage.Literals.CONNECTION_VARIABLE, csElement);
					return null;
				}
			}
		}
		refreshNamedElement(Variable.class, PivotPackage.Literals.VARIABLE, csElement);
		return null;
	}

}
