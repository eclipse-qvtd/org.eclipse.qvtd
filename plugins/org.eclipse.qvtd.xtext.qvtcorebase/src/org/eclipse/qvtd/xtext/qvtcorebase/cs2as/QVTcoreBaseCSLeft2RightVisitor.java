/*******************************************************************************
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcorebase.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.essentialocl.cs2as.ImplicitSourceTypeIterator;
import org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.AbstractMapping;
import org.eclipse.qvtd.xtext.qvtcorebasecs.AbstractMappingCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.util.AbstractQVTcoreBaseCSLeft2RightVisitor;

public class QVTcoreBaseCSLeft2RightVisitor extends AbstractQVTcoreBaseCSLeft2RightVisitor
{
	public QVTcoreBaseCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	protected ImplicitSourceTypeIterator createImplicitSourceTypeIterator(@NonNull ElementCS csElement) {
		return new ImplicitSourceTypeIterator(csElement)
		{
			@Override
			protected boolean doNext(@NonNull ElementCS csParent, @NonNull ElementCS csChild) {
				if (csParent instanceof AbstractMappingCS) {
					AbstractMapping asMapping = PivotUtil.getPivot(AbstractMapping.class, (AbstractMappingCS)csParent);
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
			return null;
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
				context.setType(operationCallExp, function.getType(), function.isRequired());
				resolveOperationArgumentTypes(function.getOwnedParameters(), csRoundBracketedClause);
				resolveOperationArguments(csRoundBracketedClause, function, operationCallExp);
				return operationCallExp;
			}
		}
		return super.resolveBestInvocation(sourceExp, csRoundBracketedClause, invocations);
	}
}