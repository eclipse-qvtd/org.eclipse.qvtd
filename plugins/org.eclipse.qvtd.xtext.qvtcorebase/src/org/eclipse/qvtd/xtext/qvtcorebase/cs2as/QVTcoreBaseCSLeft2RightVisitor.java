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

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.ImplicitSourceTypeIterator;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvocationExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.AbstractMapping;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AbstractMappingCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.util.AbstractQVTcoreBaseCSLeft2RightVisitor;

public class QVTcoreBaseCSLeft2RightVisitor extends AbstractQVTcoreBaseCSLeft2RightVisitor
{
	public QVTcoreBaseCSLeft2RightVisitor(@NonNull CS2PivotConversion context) {
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
			Operation function = DomainUtil.getNamedElement(((Transformation)asType).getOwnedOperation(), name);
			if (function != null) {
				return Collections.<NamedElement>singletonList(function);
			}
			return null;
		}
		return super.getInvocations(asType, name, iteratorCount, expressionCount);
	}

	@Override
	protected OCLExpression resolveBestInvocation(@Nullable OCLExpression sourceExp, @NonNull InvocationExpCS csInvocationExp, @NonNull List<NamedElement> invocations) {
		if (sourceExp == null) {
			Function function = getBestFunction(invocations);
			if (function != null) {
//				Operation baseOperation = metaModelManager.resolveBaseOperation(function);
				OperationCallExp operationCallExp = context.refreshModelElement(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csInvocationExp);
				context.setReferredOperation(operationCallExp, function);
				context.setType(operationCallExp, function.getType(), function.isRequired());
				resolveOperationArgumentTypes(csInvocationExp);
				resolveOperationArguments(csInvocationExp, function, operationCallExp);
				return operationCallExp;
			}
		}
		return super.resolveBestInvocation(sourceExp, csInvocationExp, invocations);
	}
}