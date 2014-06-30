/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.cs2as;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.ImplicitSourceTypeIterator;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationRole;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.CollectionTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.DefaultValueCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.ObjectTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.util.AbstractQVTrelationCSLeft2RightVisitor;

public class QVTrelationCSLeft2RightVisitor extends AbstractQVTrelationCSLeft2RightVisitor
{
	private static final class OperationOrRuleFilter implements ScopeFilter
	{
		public static OperationOrRuleFilter INSTANCE = new OperationOrRuleFilter();
		
		public int compareMatches(@NonNull MetaModelManager metaModelManager, @NonNull Object match1, @Nullable Map<TemplateParameter, ParameterableElement> bindings1,
				@NonNull Object match2, @Nullable Map<TemplateParameter, ParameterableElement> bindings2) {
			return 0;
		}

		public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
			return (object instanceof Operation) || (object instanceof Rule);
		}
	}

	public QVTrelationCSLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	protected ImplicitSourceTypeIterator createImplicitSourceTypeIterator(@NonNull ElementCS csElement) {
		return new ImplicitSourceTypeIterator(csElement)
		{
			@Override
			protected boolean doNext(@NonNull ElementCS csParent, @NonNull ElementCS csChild) {
				if (csParent instanceof TransformationCS) {
					Transformation asContext = PivotUtil.getPivot(Transformation.class, (TransformationCS)csParent);
					if (asContext != null) {
						next = asContext;
					}
					return DONE; // no more parents
				}
				else {
					return super.doNext(csParent, csChild);
				}
			}
		};
	}

	private @Nullable Relation getBestRelation(@NonNull List<NamedElement> invocations) {
		for (NamedElement invocation : invocations) {
			if (invocation instanceof Relation) {
				return (Relation)invocation;
			}
		}
		return null;
	}

	private @Nullable Function getBestFunction(@NonNull List<NamedElement> invocations) {
		for (NamedElement invocation : invocations) {
			if (invocation instanceof Function) {
				return (Function)invocation;
			}
		}
		return null;
	}

	@Override
	protected @Nullable List<NamedElement> getInvocations(@NonNull Type asType, @NonNull String name, int iteratorCount, int expressionCount) {
		if (asType instanceof Transformation) {
			Rule rule = DomainUtil.getNamedElement(((Transformation)asType).getRule(), name);
			if (rule != null) {
				return Collections.<NamedElement>singletonList(rule);
			}
			Operation function = DomainUtil.getNamedElement(((Transformation)asType).getOwnedOperation(), name);
			if (function != null) {
				return Collections.<NamedElement>singletonList(function);
			}
			return null;
		}
		return super.getInvocations(asType, name, iteratorCount, expressionCount);
	}

	protected void resolveRelationArguments(@NonNull RoundBracketedClauseCS csRoundBracketedClause, @Nullable OCLExpression source,
			@NonNull Relation relation, @NonNull RelationCallExp relationCallExp) {
		@SuppressWarnings("null")@NonNull NameExpCS csNameExp = csRoundBracketedClause.getNameExp();
		List<OCLExpression> pivotArguments = new ArrayList<OCLExpression>();
		List<NavigatingArgCS> csArguments = csRoundBracketedClause.getArguments();
		List<Domain> ownedDomains = relation.getDomain();
		int domainsCount = ownedDomains.size();
		int csArgumentCount = csArguments.size();
		if (csArgumentCount > 0) {
			if (csArguments.get(0).getRole() != NavigationRole.EXPRESSION) {
				context.addDiagnostic(csNameExp, "Relation calls can only specify expressions");			
			}
			for (int argIndex = 0; argIndex < csArgumentCount; argIndex++) {
				NavigatingArgCS csArgument = csArguments.get(argIndex);
				if (csArgument.getInit() != null) {
					context.addDiagnostic(csArgument, "Unexpected initializer for expression");
				}
				if (csArgument.getOwnedType() != null) {
					context.addDiagnostic(csArgument, "Unexpected type for expression");
				}
				OCLExpression arg = context.visitLeft2Right(OCLExpression.class, csArgument);
				if (arg != null) {
					pivotArguments.add(arg);
				}
			}
		}
		if ((csArgumentCount != domainsCount) && (relation != metaModelManager.getOclInvalidOperation())) {
			String boundMessage = DomainUtil.bind(OCLMessages.MismatchedArgumentCount_ERROR_, csArgumentCount, domainsCount);
			context.addDiagnostic(csNameExp, boundMessage);			
		}
		context.refreshList(relationCallExp.getArgument(), pivotArguments);
	}

	@Override
	protected @Nullable OCLExpression resolveBestInvocation(@Nullable OCLExpression sourceExp, @NonNull RoundBracketedClauseCS csRoundBracketedClause, @NonNull List<NamedElement> invocations) {
		NameExpCS csNameExp = csRoundBracketedClause.getNameExp();
		if (sourceExp == null) {
			Relation relation = getBestRelation(invocations);
			if (relation != null) {
				@NonNull RelationCallExp relationCallExp = context.refreshModelElement(RelationCallExp.class, QVTrelationPackage.Literals.RELATION_CALL_EXP, csNameExp);
				relationCallExp.setReferredRelation(relation);
				context.setType(relationCallExp, metaModelManager.getBooleanType(), true);
				resolveOperationArgumentTypes(csRoundBracketedClause);
				resolveRelationArguments(csRoundBracketedClause, null, relation, relationCallExp);
				return relationCallExp;
			}
			Function function = getBestFunction(invocations);
			if (function != null) {
//				Operation baseOperation = metaModelManager.resolveBaseOperation(function);
				OperationCallExp operationCallExp = context.refreshModelElement(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csNameExp);
				context.setReferredOperation(operationCallExp, function);
				context.setType(operationCallExp, function.getType(), function.isRequired());
				resolveOperationArgumentTypes(csRoundBracketedClause);
				resolveOperationArguments(csRoundBracketedClause, function, operationCallExp);
				return operationCallExp;
			}
		}
		return super.resolveBestInvocation(sourceExp, csRoundBracketedClause, invocations);
	}

	@Override
	protected @NonNull OCLExpression resolveInvocation(@Nullable OCLExpression sourceExp,@NonNull RoundBracketedClauseCS csRoundBracketedClause) {
		NameExpCS csNameExp = csRoundBracketedClause.getNameExp();
		PathNameCS csPathName = csNameExp.getPathName();
		if (csPathName != null) {	// This isn't actually needed but it should be.
			CS2Pivot.setElementType(csPathName, PivotPackage.Literals.NAMED_ELEMENT, csNameExp, OperationOrRuleFilter.INSTANCE);
		}
		return super.resolveInvocation(sourceExp, csRoundBracketedClause);
	}

	@Override
	public Element visitCollectionTemplateCS(@NonNull CollectionTemplateCS csElement) {
		return PivotUtil.getPivot(CollectionTemplateExp.class, csElement);
	}

	@Override
	public Element visitDefaultValueCS(@NonNull DefaultValueCS csElement) {
		RelationDomainAssignment pivotElement = PivotUtil.getPivot(RelationDomainAssignment.class, csElement);
		return pivotElement;
	}

	@Override
	public Element visitObjectTemplateCS(@NonNull ObjectTemplateCS csElement) {
		return PivotUtil.getPivot(ObjectTemplateExp.class, csElement);
	}
}