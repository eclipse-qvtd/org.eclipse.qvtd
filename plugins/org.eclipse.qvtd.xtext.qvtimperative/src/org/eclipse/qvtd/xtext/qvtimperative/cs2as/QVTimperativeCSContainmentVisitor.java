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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
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
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardVariable;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.InConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.OutConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.PredicateVariable;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.xtext.qvtimperativecs.AddStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.CheckStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.GuardVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.InoutVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.OutVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.PredicateVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.AbstractQVTimperativeCSContainmentVisitor;

public class QVTimperativeCSContainmentVisitor extends AbstractQVTimperativeCSContainmentVisitor
{
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
	public @Nullable Continuation<?> visitAddStatementCS(@NonNull AddStatementCS csElement) {
		context.refreshModelElement(AddStatement.class, QVTimperativePackage.Literals.ADD_STATEMENT, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitCheckStatementCS(@NonNull CheckStatementCS csElement) {
		context.refreshModelElement(CheckStatement.class, QVTimperativePackage.Literals.CHECK_STATEMENT, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitDirectionCS(@NonNull DirectionCS csElement) {
		ImperativeTypedModel asTypedModel = refreshNamedElement(ImperativeTypedModel.class, QVTimperativePackage.Literals.IMPERATIVE_TYPED_MODEL, csElement);
		Continuation<?> continuation = new DirectionContentContinuation(context, csElement);
		asTypedModel.setIsChecked(csElement.isIsChecked());
		asTypedModel.setIsEnforced(csElement.isIsEnforced());
		QVTbaseUtil.getContextVariable(standardLibrary, asTypedModel);
		return continuation;
	}

	@Override
	public Continuation<?> visitDomainCS(@NonNull DomainCS csElement) {
		ImperativeDomain pivotElement = context.refreshModelElement(ImperativeDomain.class, QVTimperativePackage.Literals.IMPERATIVE_DOMAIN, csElement);
		pivotElement.setIsCheckable(csElement.isIsCheck());
		pivotElement.setIsEnforceable(csElement.isIsEnforce());
		context.refreshPivotList(GuardVariable.class, pivotElement.getOwnedGuardVariables(), csElement.getOwnedGuardVariables());
		context.refreshComments(pivotElement, csElement);
		return new DomainContentContinuation(context, csElement);
	}

	@Override
	public Continuation<?> visitGuardVariableCS(@NonNull GuardVariableCS csElement) {
		refreshNamedElement(GuardVariable.class, QVTimperativePackage.Literals.GUARD_VARIABLE, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitInoutVariableCS(@NonNull InoutVariableCS csElement) {
		refreshNamedElement(InConnectionVariable.class, QVTimperativePackage.Literals.IN_CONNECTION_VARIABLE, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitMappingCS(@NonNull MappingCS csElement) {
		@NonNull Mapping pivotElement = refreshNamedElement(Mapping.class, QVTimperativePackage.Literals.MAPPING, csElement);
		//		DomainCS csMiddle = csElement.getOwnedMiddle();
		//		context.refreshPivotList(GuardVariable.class, pivotElement.getOwnedGuardVariables(), csMiddle.getOwnedGuardVariables());
		context.refreshPivotList(InConnectionVariable.class, pivotElement.getInoutVariables(), csElement.getOwnedInoutVariables());
		context.refreshPivotList(ImperativeDomain.class, pivotElement.getDomain(), csElement.getOwnedDomains());
		context.refreshPivotList(Statement.class, pivotElement.getOwnedStatements(), csElement.getOwnedStatements());
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
		@NonNull LoopVariable iterator = refreshNamedElement(LoopVariable.class, QVTimperativePackage.Literals.LOOP_VARIABLE, ClassUtil.nonNullState(csMappingLoop.getOwnedIterator()));
		pivotElement.getOwnedIterators().clear();
		pivotElement.getOwnedIterators().add(iterator);
		context.refreshPivotList(MappingStatement.class, pivotElement.getOwnedMappingStatements(), csMappingLoop.getOwnedMappingStatements());
		context.refreshComments(pivotElement, csMappingLoop);
		return null;
	}

	@Override
	public Continuation<?> visitNewStatementCS(@NonNull NewStatementCS csElement) {
		refreshNamedElement(NewStatement.class, QVTimperativePackage.Literals.NEW_STATEMENT, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitOutVariableCS(@NonNull OutVariableCS csElement) {
		refreshNamedElement(OutConnectionVariable.class, QVTimperativePackage.Literals.OUT_CONNECTION_VARIABLE, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitParamDeclarationCS(@NonNull ParamDeclarationCS csElement) {
		refreshNamedElement(FunctionParameter.class, QVTbasePackage.Literals.FUNCTION_PARAMETER, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitPredicateVariableCS(@NonNull PredicateVariableCS csElement) {
		PredicateVariable asElement = refreshNamedElement(PredicateVariable.class, QVTimperativePackage.Literals.PREDICATE_VARIABLE, csElement);
		asElement.setIsChecked(csElement.isIsChecked());
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
	public @Nullable Continuation<?> visitSetStatementCS(@NonNull SetStatementCS csSetStatement) {
		SetStatement asSetStatement = context.refreshModelElement(SetStatement.class, QVTimperativePackage.Literals.SET_STATEMENT, csSetStatement);
		asSetStatement.setIsEmit(csSetStatement.isIsEmit());
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
}
