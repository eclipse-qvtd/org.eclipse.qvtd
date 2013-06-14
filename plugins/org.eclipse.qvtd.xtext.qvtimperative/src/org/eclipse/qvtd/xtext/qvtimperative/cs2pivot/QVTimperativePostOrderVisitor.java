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
 * $Id: CompleteOCLPostOrderVisitor.java,v 1.9 2011/05/20 19:51:18 ewillink Exp $
 */
package org.eclipse.qvtd.xtext.qvtimperative.cs2pivot;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.xtext.qvtcorebasecst.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtimperativecst.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecst.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecst.TopLevelCS;

public class QVTimperativePostOrderVisitor extends AbstractQVTimperativePostOrderVisitor
{

	public QVTimperativePostOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	protected @Nullable Assignment refreshPropertyAssignment(@NonNull PropertyCallExp propertyCallExp, @NonNull AssignmentCS csConstraint) {
		PropertyAssignment propertyAssignment = null;
		Property referredProperty = propertyCallExp.getReferredProperty();
		Property oppositeProperty = referredProperty.getOpposite();
		if ((oppositeProperty != null) && oppositeProperty.isImplicit() && QVTimperativeCS2Pivot.isMiddle(referredProperty.getOwningType(), csConstraint)) {
			propertyAssignment = context.refreshModelElement(MiddlePropertyAssignment.class,
				QVTimperativePackage.Literals.MIDDLE_PROPERTY_ASSIGNMENT, csConstraint);
		}
		else {
			propertyAssignment = context.refreshModelElement(PropertyAssignment.class,
				QVTcoreBasePackage.Literals.PROPERTY_ASSIGNMENT, csConstraint);
		}
		if (propertyAssignment == null) {
			return null;
		}
		propertyAssignment.setSlotExpression(propertyCallExp.getSource());
		propertyAssignment.setTargetProperty(propertyCallExp.getReferredProperty());
		return propertyAssignment;
	}

	@Override
	public Continuation<?> visitMappingCS(@NonNull MappingCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitMappingCallBindingCS(@NonNull MappingCallBindingCS csElement) {
		MappingCallBinding pBinding = PivotUtil.getPivot(MappingCallBinding.class, csElement);
		if (pBinding != null) {
			ExpCS expression = csElement.getValue();
			if (expression != null) {
				OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
				pBinding.setValue(target);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS object) {
		return null;
	}
}