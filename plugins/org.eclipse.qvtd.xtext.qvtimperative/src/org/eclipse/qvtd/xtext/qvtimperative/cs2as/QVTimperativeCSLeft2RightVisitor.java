/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.essentialocl.cs2as.ImplicitSourceTypeIterator;
import org.eclipse.ocl.xtext.essentialocl.cs2as.ImplicitSourceVariableIterator;
import org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.AbstractQVTimperativeCSLeft2RightVisitor;

public class QVTimperativeCSLeft2RightVisitor extends AbstractQVTimperativeCSLeft2RightVisitor
{
	public QVTimperativeCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	protected ImplicitSourceTypeIterator createImplicitSourceTypeIterator(@NonNull ElementCS csElement) {
		return new ImplicitSourceTypeIterator(csElement)
		{
			@Override
			protected boolean doNext(@NonNull ElementCS csParent, @NonNull ElementCS csChild) {
				if (csParent instanceof MappingCS) {
					Mapping asMapping = PivotUtil.getPivot(Mapping.class, (MappingCS)csParent);
					if (asMapping != null) {
						Transformation asTransformation = QVTbaseUtil.getContainingTransformation(asMapping);
						if (asTransformation != null) {
							next = asTransformation;
						}
					}
					return DONE; // no more parents
				}
				else if (csParent instanceof QueryCS) {
					Function asFunction = PivotUtil.getPivot(Function.class, (QueryCS)csParent);
					if (asFunction != null) {
						Transformation asTransformation = QVTbaseUtil.getContainingTransformation(asFunction);;
						if (asTransformation != null) {
							next = asTransformation;
						}
					}
					return DONE; // no more parents
				}
				else {
					return super.doNext(csParent, csChild);
				}
			}
		};
	}

	@Override
	protected @NonNull ImplicitSourceVariableIterator createImplicitSourceVariableIterator(@NonNull ModelElementCS csExp) {
		return new ImplicitSourceVariableIterator(csExp) {
			@Override
			protected boolean doNext(@NonNull ElementCS csParent, @NonNull ElementCS csChild) {
				if (csParent instanceof MappingCS) {
					Mapping asContext = PivotUtil.getPivot(Mapping.class, (MappingCS)csParent);
					if (asContext != null) {
						Variable asVariable = asContext.getTransformation().getOwnedContext();
						if (asVariable != null) {
							setNext(asVariable);
						}
					}
					return DONE; // no more parents
				}
				return super.doNext(csParent, csChild);
			}

		};
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
			Operation function = NameUtil.getNameable(((Transformation)asType).getOwnedOperations(), name);
			if (function != null) {
				return new ResolvedInvocation(function);
			}
			Iterable<? extends Operation> nonStaticOperations = metamodelManager.getAllOperations(asType, FeatureFilter.SELECT_NON_STATIC, name);
			List<NamedElement> invocations = getInvocationsInternal(null, nonStaticOperations, iteratorCount, expressionCount);
			//			if (asTypeValue != null) {
			//				Iterable<? extends Operation> staticOperations = metamodelManager.getAllOperations(asTypeValue, FeatureFilter.SELECT_STATIC, name);
			//				invocations = getInvocationsInternal(invocations, staticOperations, iteratorCount, expressionCount);
			//			}
			return invocations != null ? new UnresolvedInvocations(asType, invocations) : null;
			//			return null;
		}
		return super.getInvocations(asType, asTypeValue, name, iteratorCount, expressionCount);
	}

	@Override
	protected OCLExpression resolveBestInvocation(@Nullable OCLExpression sourceExp, @NonNull RoundBracketedClauseCS csRoundBracketedClause, @NonNull Invocations invocations) {
		if (sourceExp == null) {
			Function function = getBestFunction(invocations);
			if (function != null) {
				AbstractNameExpCS csNameExp = csRoundBracketedClause.getOwningNameExp();
				//				Operation baseOperation = metamodelManager.resolveBaseOperation(function);
				OperationCallExp operationCallExp = context.refreshModelElement(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csNameExp);
				context.setReferredOperation(operationCallExp, function);
				context.setType(operationCallExp, function.getType(), function.isIsRequired());
				resolveOperationArgumentTypes(function.getOwnedParameters(), csRoundBracketedClause);
				resolveOperationArguments(csRoundBracketedClause, function, operationCallExp);
				return operationCallExp;
			}
		}
		return super.resolveBestInvocation(sourceExp, csRoundBracketedClause, invocations);
	}

	@Override
	protected Type resolvePropertyReturnType(@NonNull NavigationCallExp sourceExp, @NonNull NameExpCS csNameExp, @NonNull Property property) {
		Property oppositeProperty = property.getOpposite();
		if (property.isIsImplicit() && (oppositeProperty != null) && QVTimperativeCS2AS.isMiddle(oppositeProperty.getOwningClass(), csNameExp)) {
			return oppositeProperty.getOwningClass();
		}
		else {
			return super.resolvePropertyReturnType(sourceExp, csNameExp, property);
		}
	}

	@Override
	protected Element resolveSimpleNameExp(@NonNull NameExpCS csNameExp, @NonNull Element element) {
		if (element instanceof Transformation) {
			Variable ownedContext = QVTbaseUtil.getContextVariable(standardLibrary, (Transformation) element);
			return resolveVariableExp(csNameExp, ownedContext);
		}
		else if (element instanceof ImperativeTypedModel) {
			Variable ownedContext = QVTbaseUtil.getContextVariable(standardLibrary, (ImperativeTypedModel) element);
			return resolveVariableExp(csNameExp, ownedContext);
		}
		return super.resolveSimpleNameExp(csNameExp, element);
	}
}