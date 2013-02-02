/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtrelation.cs2pivot;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationRole;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS;

public class QVTrelationLeft2RightVisitor extends AbstractQVTrelationLeft2RightVisitor
{
	public QVTrelationLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	protected VariableDeclaration getImplicitSource(@NonNull ModelElementCS csExp, @NonNull Feature feature) {
		if (feature instanceof Function) {
			return null;
		}
		return super.getImplicitSource(csExp, feature);
	}

	@Override
	protected @Nullable OCLExpression resolveOperationReference(@NonNull NamedElement namedElement, @NonNull InvocationExpCS csInvocationExp) {
		if (namedElement instanceof Relation) {
			Relation relation = (Relation)namedElement;
			RelationCallExp relationCallExp = context.refreshModelElement(RelationCallExp.class, QVTrelationPackage.Literals.RELATION_CALL_EXP, csInvocationExp);
			if (relationCallExp != null) {
				relationCallExp.setReferredRelation(relation);
				context.setType(relationCallExp, metaModelManager.getBooleanType(), true);
				resolveRelationArguments(csInvocationExp, null, relation, relationCallExp);
				context.installPivotUsage(csInvocationExp, relationCallExp);		
				return relationCallExp;
			}
			else {
				return null;
			}
		}
		else if (namedElement instanceof Function) {
			Function function = (Function)namedElement;
//			Operation baseOperation = metaModelManager.resolveBaseOperation(function);
			OCLExpression source = resolveNavigationSource(csInvocationExp, function);
			if (source == null) {
				OperationCallExp operationCallExp = context.refreshModelElement(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csInvocationExp);
				if (operationCallExp != null) {
					context.setReferredOperation(operationCallExp, function);
					context.setType(operationCallExp, function.getType(), function.isRequired());
					context.installPivotUsage(csInvocationExp, operationCallExp);
					resolveOperationArguments(csInvocationExp, null, function, operationCallExp);
					return operationCallExp;
				}
			}
		}
		return super.resolveOperationReference(namedElement, csInvocationExp);
	}
	
	protected void resolveRelationArguments(@NonNull InvocationExpCS csInvocationExp,
			@Nullable OCLExpression source, @NonNull Relation relation, @NonNull RelationCallExp relationCallExp) {
		List<OCLExpression> pivotArguments = new ArrayList<OCLExpression>();
		List<NavigatingArgCS> csArguments = csInvocationExp.getArgument();
		List<Domain> ownedDomains = relation.getDomain();
		int domainsCount = ownedDomains.size();
		int csArgumentCount = csArguments.size();
		if (csArgumentCount > 0) {
			if (csArguments.get(0).getRole() != NavigationRole.EXPRESSION) {
				context.addDiagnostic(csInvocationExp, "Relation calls can only specify expressions");			
			}
			for (int argIndex = 0; argIndex < csArgumentCount; argIndex++) {
				NavigatingArgCS csArgument = csArguments.get(argIndex);
				if (csArgument.getInit() != null) {
					context.addDiagnostic(csArgument, "Unexpected initializer for expression");
				}
				if (csArgument.getOwnedType() != null) {
					context.addDiagnostic(csArgument, "Unexpected type for expression");
				}
				OCLExpression arg = PivotUtil.getPivot(OCLExpression.class, csArgument);
				if (arg != null) {
					pivotArguments.add(arg);
				}
			}
		}
		if ((csArgumentCount != domainsCount) && (relation != getBadOperation())) {
			String boundMessage = DomainUtil.bind(OCLMessages.MismatchedArgumentCount_ERROR_, csArgumentCount, domainsCount);
			context.addDiagnostic(csInvocationExp, boundMessage);			
		}
		context.refreshList(relationCallExp.getArgument(), pivotArguments);
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