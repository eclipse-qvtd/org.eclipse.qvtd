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
package org.eclipse.qvtd.xtext.qvtimperative.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyCallExp;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.util.AbstractQVTimperativeCSLeft2RightVisitor;

public class QVTimperativeCSLeft2RightVisitor extends AbstractQVTimperativeCSLeft2RightVisitor
{
	public QVTimperativeCSLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	protected Type resolvePropertyReturnType(@NonNull OCLExpression sourceExp, @NonNull NameExpCS csNameExp, @NonNull Property property) {
		Property oppositeProperty = property.getOpposite();
		if (property.isImplicit() && (oppositeProperty != null) && QVTimperativeCS2Pivot.isMiddle(oppositeProperty.getOwningType(), csNameExp)) {
			return oppositeProperty.getOwningType();
		}
		else {
			return super.resolvePropertyReturnType(sourceExp, csNameExp, property);
		}
	}

	@Override
	protected @NonNull OppositePropertyCallExp refreshOppositePropertyCallExp(@NonNull NameExpCS csNameExp, @NonNull OCLExpression sourceExp, @NonNull Property property) {
		Property oppositeProperty = property.getOpposite();
		if (QVTimperativeCS2Pivot.isMiddle(oppositeProperty.getOwningType(), csNameExp)) {
			MiddlePropertyCallExp callExp = context.refreshModelElement(MiddlePropertyCallExp.class, QVTimperativePackage.Literals.MIDDLE_PROPERTY_CALL_EXP, csNameExp);
			callExp.setSource(sourceExp);			
			callExp.setReferredProperty(property.getOpposite());
			return callExp;
		}
		else {
			return super.refreshOppositePropertyCallExp(csNameExp, sourceExp, property);
		}
	}
}