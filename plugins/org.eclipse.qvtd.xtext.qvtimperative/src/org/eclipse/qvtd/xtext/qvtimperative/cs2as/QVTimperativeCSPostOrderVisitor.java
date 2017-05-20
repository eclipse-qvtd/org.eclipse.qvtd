/*******************************************************************************
 * Copyright (c) 2010, 2017 Willink Transformations and others.
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
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.xtext.qvtimperativecs.AddStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.AppendParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.BufferStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.CheckStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DeclareStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.GuardParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.GuardParameterCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.LoopParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.SimpleParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.SimpleParameterCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.AbstractQVTimperativeCSPostOrderVisitor;

public class QVTimperativeCSPostOrderVisitor extends AbstractQVTimperativeCSPostOrderVisitor
{
	protected static class SimpleParameterBindingCSCompletion extends SingleContinuation<SimpleParameterBindingCS>
	{
		public SimpleParameterBindingCSCompletion(@NonNull CS2ASConversion context, @NonNull SimpleParameterBindingCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			SimpleParameterBinding pBinding = PivotUtil.getPivot(SimpleParameterBinding.class, csElement);
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
	public @Nullable Continuation<?> visitAddStatementCS(@NonNull AddStatementCS csElement) {
		AddStatement asAddStatement = PivotUtil.getPivot(AddStatement.class, csElement);
		if (asAddStatement != null) {
			asAddStatement.setTargetVariable(csElement.getTargetVariable());
			ExpCS csInitializer = csElement.getOwnedExpression();
			if (csInitializer != null) {
				OCLExpression initializer = context.visitLeft2Right(OCLExpression.class, csInitializer);
				asAddStatement.setOwnedExpression(initializer);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitAppendParameterBindingCS(@NonNull AppendParameterBindingCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitBufferStatementCS(@NonNull BufferStatementCS csElement) {
		BufferStatement asOutStatement = PivotUtil.getPivot(BufferStatement.class, csElement);
		if (asOutStatement != null) {
			ExpCS expression = csElement.getOwnedExpression();
			if (expression != null) {
				OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
				asOutStatement.setOwnedExpression(target);
				if ((csElement.getOwnedType() == null) && (target != null)) {
					Type targetType = target.getType();
					boolean isRequired = target.isIsRequired();
					if (targetType instanceof CollectionType) {
						CollectionType collectionType = (CollectionType)targetType;
						targetType = collectionType.getElementType();
						isRequired = collectionType.isIsNullFree();
					}
					// FIXME else => error
					// FIXME !isRequired => error
					// FIXME isStrict
					context.setType(asOutStatement, targetType, isRequired, target.getTypeValue());
				}
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
			asPredicate.setOwnedExpression(asCondition);
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
			ExpCS expression = csElement.getOwnedExpression();
			if (expression != null) {
				OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
				asVariable.setOwnedExpression(target);
				if ((csElement.getOwnedType() == null) && (target != null)) {
					context.setType(asVariable, target.getType(), target.isIsRequired(), target.getTypeValue());
				}
			}
		}
		return null;
	}

	/*	@Override
	public Continuation<?> visitCheckVariableStatementCS(@NonNull CheckVariableStatementCS csElement) {
		ExpCS csTarget = csElement.getOwnedTarget();
		assert csTarget != null;
		OCLExpression target = context.visitLeft2Right(OCLExpression.class, csTarget);
		ExpCS csInitializer = csElement.getOwnedExpression();
		assert csInitializer != null;
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
			OCLExpression initializer = context.visitLeft2Right(OCLExpression.class, csInitializer);
			assignment.setOwnedExpression(initializer);
			//			pAssignments.add(assignment);
		}
		return null;
	} */

	@Override
	public Continuation<?> visitDirectionCS(@NonNull DirectionCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitGuardParameterCS(@NonNull GuardParameterCS csElement) {
		GuardParameter asGuardParameter = PivotUtil.getPivot(GuardParameter.class, csElement);
		if (asGuardParameter != null) {
			asGuardParameter.setReferredTypedModel(csElement.getReferredTypedModel());
			asGuardParameter.setSuccessProperty(csElement.getSuccessProperty());
		}
		return null;
	}

	@Override
	public Continuation<?> visitGuardParameterBindingCS(@NonNull GuardParameterBindingCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitLoopParameterBindingCS(@NonNull LoopParameterBindingCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitMappingCS(@NonNull MappingCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitMappingLoopCS(@NonNull MappingLoopCS csElement) {
		MappingLoop pMappingLoop = PivotUtil.getPivot(MappingLoop.class, csElement);
		if (pMappingLoop != null) {
			ExpCS expression = csElement.getOwnedInExpression();
			if (expression != null) {
				OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
				if (target != null) {
					pMappingLoop.setOwnedExpression(target);
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
			ExpCS expression = csElement.getOwnedExpression();
			if (expression != null) {
				OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
				asNewStatement.setOwnedExpression(target);
			}
		}
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
			ExpCS csInitializer = csElement.getOwnedExpression();
			OCLExpression target = csInitializer != null ? context.visitLeft2Right(OCLExpression.class, csInitializer) : null;
			setStatement.setOwnedExpression(target);
			//				pAssignments.add(assignment);
		}
		return null;
	}

	@Override
	public Continuation<?> visitSimpleParameterCS(@NonNull SimpleParameterCS csElement) {
		SimpleParameter asSimpleParameter = PivotUtil.getPivot(SimpleParameter.class, csElement);
		if (asSimpleParameter != null) {
			asSimpleParameter.setReferredTypedModel(csElement.getReferredTypedModel());
		}
		return null;
	}

	@Override
	public Continuation<?> visitSimpleParameterBindingCS(@NonNull SimpleParameterBindingCS csElement) {
		return new SimpleParameterBindingCSCompletion(context, csElement);		// Must wait till MappingLoop iterators initialized
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
