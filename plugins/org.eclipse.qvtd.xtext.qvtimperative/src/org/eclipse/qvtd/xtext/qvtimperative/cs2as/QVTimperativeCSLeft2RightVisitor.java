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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.AbstractQVTimperativeCSLeft2RightVisitor;

public class QVTimperativeCSLeft2RightVisitor extends AbstractQVTimperativeCSLeft2RightVisitor
{
	public QVTimperativeCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
		super(context);
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
}