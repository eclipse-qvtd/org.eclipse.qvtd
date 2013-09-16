/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: QVTcoreLeft2RightVisitor.java,v 1.10 2011/05/23 05:51:25 ewillink Exp $
 */
package org.eclipse.qvtd.xtext.qvtcorebase.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvocationExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.xtext.qvtcorebasecst.util.AbstractQVTcoreBaseLeft2RightVisitor;

public class QVTcoreBaseLeft2RightVisitor extends AbstractQVTcoreBaseLeft2RightVisitor
{
	public QVTcoreBaseLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	protected @Nullable OCLExpression resolveOperationReference(@NonNull NamedElement namedElement, @NonNull InvocationExpCS csInvocationExp) {
		if (namedElement instanceof Function) {
			Function function = (Function)namedElement;
//			Function baseFunction = function; //metaModelManager.resolveBaseOperation(function);
			CallExp outerExpression = null;
//			CallExp innerExpression = null;
			OperationCallExp operationCallExp = context.refreshModelElement(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csInvocationExp);
			if (operationCallExp != null) {
				context.setReferredOperation(operationCallExp, function);
				resolveAtPre(csInvocationExp.getNameExp(), operationCallExp);
				context.setType(operationCallExp, function.getType(), function.isRequired());
				context.installPivotUsage(csInvocationExp, operationCallExp);
//				innerExpression = operationCallExp;
				outerExpression = operationCallExp;
				resolveOperationArguments(csInvocationExp, null, function, operationCallExp);
			}
			return outerExpression;
		}
		else {
			return super.resolveOperationReference(namedElement, csInvocationExp);
		}
	}
}