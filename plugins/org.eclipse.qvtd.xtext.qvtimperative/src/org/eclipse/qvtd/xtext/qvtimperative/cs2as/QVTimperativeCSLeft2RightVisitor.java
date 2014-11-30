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
package org.eclipse.qvtd.xtext.qvtimperative.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.NavigationCallExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyCallExp;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.util.AbstractQVTimperativeCSLeft2RightVisitor;

public class QVTimperativeCSLeft2RightVisitor extends AbstractQVTimperativeCSLeft2RightVisitor
{
	public QVTimperativeCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	protected Type resolvePropertyReturnType(@NonNull NavigationCallExp sourceExp, @NonNull NameExpCS csNameExp, @NonNull Property property) {
		Property oppositeProperty = property.getOpposite();
		if (property.isImplicit() && (oppositeProperty != null) && QVTimperativeCS2AS.isMiddle(oppositeProperty.getOwningClass(), csNameExp)) {
			return oppositeProperty.getOwningClass();
		}
		else {
			return super.resolvePropertyReturnType(sourceExp, csNameExp, property);
		}
	}

	@Override
	protected @NonNull OppositePropertyCallExp refreshOppositePropertyCallExp(@NonNull NameExpCS csNameExp, @NonNull OCLExpression sourceExp, @NonNull Property property) {
		Property oppositeProperty = property.getOpposite();
		if (QVTimperativeCS2AS.isMiddle(oppositeProperty.getOwningClass(), csNameExp)) {
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