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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtimperative.AccessStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardVariable;
import org.eclipse.qvtd.pivot.qvtimperative.IfStatement;
import org.eclipse.qvtd.pivot.qvtimperative.InitializeStatement;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.xtext.qvtimperativecs.AccessStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.AddStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.CheckStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.GuardVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.IfStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.InitializeStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.OutVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DeclareStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.AbstractQVTimperativeCSPostOrderVisitor;

public class QVTimperativeCSPostOrderVisitor extends AbstractQVTimperativeCSPostOrderVisitor
{
	protected static class MappingCallBindingCSCompletion extends SingleContinuation<MappingCallBindingCS>
	{
		public MappingCallBindingCSCompletion(@NonNull CS2ASConversion context, @NonNull MappingCallBindingCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			MappingCallBinding pBinding = PivotUtil.getPivot(MappingCallBinding.class, csElement);
			if (pBinding != null) {
				ExpCS expression = csElement.getOwnedValue();
				if (expression != null) {
					OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
					pBinding.setValue(target);
				}
			}
			return null;
		}
	}

	public QVTimperativeCSPostOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	/*	protected @Nullable Statement refreshPropertyAssignment(@NonNull NavigationCallExp propertyCallExp, @NonNull PredicateOrAssignmentCS csConstraint) {
		@Nullable PropertyAssignment propertyAssignment;
		//		Property referredProperty = propertyCallExp.getReferredProperty();
		//		Property oppositeProperty = referredProperty.getOpposite();
		//		if ((oppositeProperty != null) && oppositeProperty.isIsImplicit()) {
		//			propertyAssignment = PivotUtil.getPivot(OppositePropertyAssignment.class, csConstraint);
		//		}
		//		else {
		propertyAssignment = PivotUtil.getPivot(PropertyAssignment.class, csConstraint);
		//		}
		if (propertyAssignment != null) {
			propertyAssignment.setSlotExpression(propertyCallExp.getOwnedSource());
			propertyAssignment.setTargetProperty(PivotUtil.getReferredProperty(propertyCallExp));
			//			propertyAssignment.setIsOpposite(target instanceof FeatureCallExp);		// FIXME isOpposite
		}
		return propertyAssignment;
	} */

	@Override
	public Continuation<?> visitAccessStatementCS(@NonNull AccessStatementCS csElement) {
		AccessStatement accessStatement = PivotUtil.getPivot(AccessStatement.class, csElement);
		if (accessStatement != null) {
			VariableDeclaration sourceVariable = csElement.getSourceVariable();
			assert sourceVariable != null;
			accessStatement.setSourceVariable(sourceVariable);
			Property sourceProperty = csElement.getSourceProperty();
			boolean isImplicit = sourceProperty.isIsImplicit();
			accessStatement.setSourceProperty(isImplicit ? sourceProperty.getOpposite() : sourceProperty);
			accessStatement.setIsOpposite(isImplicit);
		}
		return null;
	}

	@Override
	public @Nullable Continuation<?> visitAddStatementCS(@NonNull AddStatementCS csElement) {
		AddStatement asAddStatement = PivotUtil.getPivot(AddStatement.class, csElement);
		if (asAddStatement != null) {
			asAddStatement.setTargetVariable(csElement.getTargetVariable());
			ExpCS csInitialiser = csElement.getOwnedExpression();
			if (csInitialiser != null) {
				OCLExpression initialiser = context.visitLeft2Right(OCLExpression.class, csInitialiser);
				asAddStatement.setOwnedInit(initialiser);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitCheckStatementCS(@NonNull CheckStatementCS csElement) {
		CheckStatement asPredicate = PivotUtil.getPivot(CheckStatement.class, csElement);
		if (asPredicate != null) {
			OCLExpression asCondition = null;
			ExpCS csCondition = csElement.getOwnedCondition();
			if (csCondition != null) {
				asCondition = context.visitLeft2Right(OCLExpression.class, csCondition);
			}
			asPredicate.setOwnedCondition(asCondition);
		}
		return null;
	}

	@Override
	public Continuation<?> visitConstraintCS(@NonNull ConstraintCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitDeclareStatementCS(@NonNull DeclareStatementCS csElement) {
		DeclareStatement asVariable = PivotUtil.getPivot(DeclareStatement.class, csElement);
		if (asVariable != null) {
			ExpCS expression = csElement.getOwnedInit();
			if (expression != null) {
				OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
				asVariable.setOwnedInit(target);
			}
		}
		return null;
	}

	/*	@Override
	public Continuation<?> visitCheckVariableStatementCS(@NonNull CheckVariableStatementCS csElement) {
		ExpCS csTarget = csElement.getOwnedTarget();
		assert csTarget != null;
		OCLExpression target = context.visitLeft2Right(OCLExpression.class, csTarget);
		ExpCS csInitialiser = csElement.getOwnedInit();
		assert csInitialiser != null;
		CheckVariableStatement assignment = null;
		if (target instanceof NavigationCallExp) {
			throw new IllegalStateException();
		}
		else if (target instanceof VariableExp) {
			CheckVariableStatement variableAssignment = PivotUtil.getPivot(CheckVariableStatement.class, csElement);
			if (variableAssignment != null) {
				variableAssignment.setTargetVariable(((VariableExp)target).getReferredVariable());
			}
		}
		else if (target != null) {
			context.addDiagnostic(csElement, "unrecognised Constraint target " + target.eClass().getName());
		}
		if (assignment != null) {
			OCLExpression initialiser = context.visitLeft2Right(OCLExpression.class, csInitialiser);
			assignment.setOwnedInit(initialiser);
			//			pAssignments.add(assignment);
		}
		return null;
	} */

	@Override
	public Continuation<?> visitDirectionCS(@NonNull DirectionCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitDomainCS(@NonNull DomainCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitGuardVariableCS(@NonNull GuardVariableCS csElement) {
		GuardVariable asGuardVariable = PivotUtil.getPivot(GuardVariable.class, csElement);
		if (asGuardVariable != null) {
			asGuardVariable.setReferredTypedModel(csElement.getReferredTypedModel());
		}
		return null;
	}

	@Override
	public Continuation<?> visitIfStatementCS(@NonNull IfStatementCS csIfStatement) {
		IfStatement asIfStatement = PivotUtil.getPivot(IfStatement.class, csIfStatement);
		if (asIfStatement != null) {
			OCLExpression asCondition = null;
			ExpCS csCondition = csIfStatement.getOwnedCondition();
			if (csCondition != null) {
				asCondition = context.visitLeft2Right(OCLExpression.class, csCondition);
			}
			asIfStatement.setOwnedCondition(asCondition);
		}
		return null;
	}

	@Override
	public Continuation<?> visitInitializeStatementCS(@NonNull InitializeStatementCS csElement) {
		InitializeStatement asVariable = PivotUtil.getPivot(InitializeStatement.class, csElement);
		if (asVariable != null) {
			ExpCS expression = csElement.getOwnedInit();
			if (expression != null) {
				OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
				asVariable.setOwnedInit(target);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitMappingCS(@NonNull MappingCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitMappingCallBindingCS(@NonNull MappingCallBindingCS csElement) {
		return new MappingCallBindingCSCompletion(context, csElement);		// Must wait till MappingLoop iterators initialized
	}

	@Override
	public Continuation<?> visitMappingLoopCS(@NonNull MappingLoopCS csElement) {
		MappingLoop pMappingLoop = PivotUtil.getPivot(MappingLoop.class, csElement);
		if (pMappingLoop != null) {
			ExpCS expression = csElement.getOwnedInExpression();
			if (expression != null) {
				OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
				if (target != null) {
					pMappingLoop.setOwnedSource(target);
					List<LoopVariable> iterators = pMappingLoop.getOwnedIterators();
					if (iterators.size() > 0) {
						LoopVariable iterator = iterators.get(0);
						if (iterator.getType() == null) {
							Type type = target.getType();
							if (type instanceof CollectionType) {
								type = ((CollectionType)type).getElementType();
							}
							iterator.setType(type);
						}
					}
				}
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitNewStatementCS(@NonNull NewStatementCS csElement) {
		NewStatement asNewStatement = PivotUtil.getPivot(NewStatement.class, csElement);
		if (asNewStatement != null) {
			asNewStatement.setReferredTypedModel(csElement.getReferredTypedModel());
			ExpCS expression = csElement.getOwnedInit();
			if (expression != null) {
				OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
				asNewStatement.setOwnedInit(target);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitOutVariableCS(@NonNull OutVariableCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitParamDeclarationCS(@NonNull ParamDeclarationCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitQueryCS(@NonNull QueryCS csElement) {
		Function pFunction = PivotUtil.getPivot(Function.class, csElement);
		if (pFunction != null) {
			ExpCS expression = csElement.getOwnedExpression();
			if (expression != null) {
				OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
				pFunction.setQueryExpression(target);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitSetStatementCS(@NonNull SetStatementCS csElement) {
		SetStatement setStatement = PivotUtil.getPivot(SetStatement.class, csElement);
		if (setStatement != null) {
			VariableDeclaration targetVariable = csElement.getReferredVariable();
			assert targetVariable != null;
			setStatement.setTargetVariable(targetVariable);
			Property targetProperty = csElement.getReferredProperty();
			boolean isImplicit = targetProperty.isIsImplicit();
			setStatement.setTargetProperty(isImplicit ? targetProperty.getOpposite() : targetProperty);
			setStatement.setIsOpposite(isImplicit);
			ExpCS csInitialiser = csElement.getOwnedInit();
			OCLExpression target = csInitialiser != null ? context.visitLeft2Right(OCLExpression.class, csInitialiser) : null;
			setStatement.setTargetProperty(targetProperty);
			//			propertyAssignment.setIsOpposite(target instanceof FeatureCallExp);		// FIXME isOpposite
			setStatement.setOwnedInit(target);
			//				pAssignments.add(assignment);
		}
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitTransformationCS(@NonNull TransformationCS object) {
		return null;
	}
}
