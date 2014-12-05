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
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.utilities.SingletonIterator;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.essentialocl.cs2as.ImplicitSourceTypeIterator;
import org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigationRole;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
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

		public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
			return (object instanceof Operation) || (object instanceof Rule);
		}
	}
	
	public static class ResolvedRuleInvocation implements Invocations
	{
		protected final @NonNull Rule invocation;
		
		public ResolvedRuleInvocation(@NonNull Rule invocation) {
			this.invocation = invocation;
		}

		public @NonNull NamedElement getSingleResult() {
			return invocation;
		}
		
		public @NonNull Type getSourceType() {
			return DomainUtil.nonNullState(invocation.getTransformation());
		}

		public Iterator<NamedElement> iterator() {
			return new SingletonIterator<NamedElement>(invocation);
		}
	}

	public QVTrelationCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
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

	private @Nullable Relation getBestRelation(@NonNull Invocations invocations) {
		for (NamedElement invocation : invocations) {
			if (invocation instanceof Relation) {
				return (Relation)invocation;
			}
		}
		return null;
	}

	private @Nullable Function getBestFunction(@NonNull Invocations invocations) {
		for (NamedElement invocation : invocations) {
			if (invocation instanceof Function) {
				return (Function)invocation;
			}
		}
		return null;
	}

	@Override
	protected @Nullable Invocations getInvocations(@NonNull Type asType, @Nullable Type asTypeValue, @NonNull String name, int iteratorCount, int expressionCount) {
		if (asType instanceof Transformation) {
			Rule rule = DomainUtil.getNamedElement(((Transformation)asType).getRule(), name);
			if (rule != null) {
				return new ResolvedRuleInvocation(rule);
			}
			Operation function = DomainUtil.getNamedElement(((Transformation)asType).getOwnedOperations(), name);
			if (function != null) {
				return new ResolvedInvocation(function);
			}
			return null;
		}
		return super.getInvocations(asType, asTypeValue, name, iteratorCount, expressionCount);
	}

	@Override
	protected @Nullable OCLExpression resolveBestInvocation(@Nullable OCLExpression sourceExp, @NonNull RoundBracketedClauseCS csRoundBracketedClause, @NonNull Invocations invocations) {
		AbstractNameExpCS csNameExp = csRoundBracketedClause.getOwningNameExp();
		if (sourceExp == null) {
			Relation relation = getBestRelation(invocations);
			if (relation != null) {
				@NonNull RelationCallExp relationCallExp = context.refreshModelElement(RelationCallExp.class, QVTrelationPackage.Literals.RELATION_CALL_EXP, csNameExp);
				relationCallExp.setReferredRelation(relation);
				context.setType(relationCallExp, metaModelManager.getStandardLibrary().getBooleanType(), true);
				List<Variable> rootVariables = QVTrelationUtil.getRootVariables(relation);
				resolveRelationArgumentTypes(rootVariables, csRoundBracketedClause);
				resolveRelationArguments(csRoundBracketedClause, null, relation, relationCallExp);
				return relationCallExp;
			}
			Function function = getBestFunction(invocations);
			if (function != null) {
//				Operation baseOperation = metaModelManager.resolveBaseOperation(function);
				OperationCallExp operationCallExp = context.refreshModelElement(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csNameExp);
				context.setReferredOperation(operationCallExp, function);
				context.setType(operationCallExp, function.getType(), function.isRequired());
				resolveOperationArgumentTypes(function.getOwnedParameter(), csRoundBracketedClause);
				resolveOperationArguments(csRoundBracketedClause, function, operationCallExp);
				return operationCallExp;
			}
		}
		return super.resolveBestInvocation(sourceExp, csRoundBracketedClause, invocations);
	}

	@Override
	protected @NonNull OCLExpression resolveInvocation(@Nullable OCLExpression sourceExp,@NonNull RoundBracketedClauseCS csRoundBracketedClause) {
		AbstractNameExpCS csNameExp = csRoundBracketedClause.getOwningNameExp();
		PathNameCS csPathName = csNameExp.getOwnedPathName();
		if (csPathName != null) {	// This isn't actually needed but it should be.
			CS2AS.setElementType(csPathName, PivotPackage.Literals.NAMED_ELEMENT, csNameExp, OperationOrRuleFilter.INSTANCE);
		}
		return super.resolveInvocation(sourceExp, csRoundBracketedClause);
	}

	protected void resolveRelationArguments(@NonNull RoundBracketedClauseCS csRoundBracketedClause, @Nullable OCLExpression source,
			@NonNull Relation relation, @NonNull RelationCallExp relationCallExp) {
		@SuppressWarnings("null")@NonNull AbstractNameExpCS csNameExp = csRoundBracketedClause.getOwningNameExp();
		List<OCLExpression> pivotArguments = new ArrayList<OCLExpression>();
		List<NavigatingArgCS> csArguments = csRoundBracketedClause.getOwnedArguments();
		List<Domain> ownedDomains = relation.getDomain();
		int domainsCount = ownedDomains.size();
		int csArgumentCount = csArguments.size();
		if (csArgumentCount > 0) {
			if (csArguments.get(0).getRole() != NavigationRole.EXPRESSION) {
				context.addDiagnostic(csNameExp, "Relation calls can only specify expressions");			
			}
			for (int argIndex = 0; argIndex < csArgumentCount; argIndex++) {
				NavigatingArgCS csArgument = csArguments.get(argIndex);
				if (csArgument.getOwnedInitExpression() != null) {
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
		if ((csArgumentCount != domainsCount) && (relation != metaModelManager.getStandardLibrary().getOclInvalidOperation())) {
			String boundMessage = DomainUtil.bind(OCLMessages.MismatchedArgumentCount_ERROR_, csArgumentCount, domainsCount);
			context.addDiagnostic(csNameExp, boundMessage);			
		}
		context.refreshList(relationCallExp.getArgument(), pivotArguments);
	}
	
	protected void resolveRelationArgumentTypes(@Nullable List<Variable> rootVariables, @NonNull RoundBracketedClauseCS csRoundBracketedClause) {
		int argIndex = 0;
		for (NavigatingArgCS csArgument : csRoundBracketedClause.getOwnedArguments()) {
			if (csArgument.getRole() == NavigationRole.ITERATOR) {
				break;
			}
			else if (csArgument.getRole() == NavigationRole.ACCUMULATOR) {
				break;
			}
			else if (csArgument.getRole() == NavigationRole.EXPRESSION) {
				ExpCS csName = csArgument.getOwnedNameExpression();
				if (csName != null) {
					OCLExpression arg = null;
					boolean isType = false;
					if (csName instanceof NameExpCS) {
						if ((rootVariables != null) && argIndex < rootVariables.size()) {
							Variable rootVariable = rootVariables.get(argIndex);
							if (/*rootVariable.isTypeof() ||*/ (rootVariable.getTypeId() == standardLibrary.getOclTypeType().getTypeId())) {
								isType = true;
								NameExpCS csNameExp = (NameExpCS)csName;
								PathNameCS csPathName = csNameExp.getOwnedPathName();
								Type type = context.getConverter().lookupType(csNameExp, DomainUtil.nonNullState(csPathName));
								if (type != null) {
									arg = resolveTypeExp(csNameExp, type);
								}
							}
						}
					}
					if (!isType) {
						arg = context.visitLeft2Right(OCLExpression.class, csName);
					}
					if (arg != null) {
						context.installPivotUsage(csArgument, arg);
					}
				}
				argIndex++;
			}
		}
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