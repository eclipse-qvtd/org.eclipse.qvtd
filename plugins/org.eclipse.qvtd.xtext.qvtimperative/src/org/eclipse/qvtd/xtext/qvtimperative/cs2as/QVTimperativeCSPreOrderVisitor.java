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
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.util.AbstractQVTimperativeCSPreOrderVisitor;

public class QVTimperativeCSPreOrderVisitor extends AbstractQVTimperativeCSPreOrderVisitor
{	
/*	public static class MappingLoopIteratorCompletion extends SingleContinuation<MappingLoopCS>
	{
		protected static PivotDependency[] computeDependencies(@NonNull MappingLoopCS csElement) {
			if (csElement.getOwnedType() != null) {
				return new PivotDependency[]{new PivotDependency(csElement.getOwnedType())};
			}
			else {
				return new PivotDependency[0];
			}
		}

		public MappingLoopIteratorCompletion(@NonNull CS2ASConversion context, @NonNull MappingLoopCS csElement) {
			super(context, null, null, csElement, computeDependencies(csElement));
		}

		@Override
		public BasicContinuation<?> execute() {
			MappingLoop pivotElement = PivotUtil.getPivot(MappingLoop.class, csElement);
			if (pivotElement != null) {
				Variable iterator = pivotElement.getIterator();
				if (iterator != null) {
					Type type = PivotUtil.getPivot(Type.class, csElement.getOwnedType());
					iterator.setType(type);
				}
			}
			return null;
		}
	} */

	public QVTimperativeCSPreOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitMappingCS(@NonNull MappingCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitMappingCallBindingCS(@NonNull MappingCallBindingCS csElement) {
		MappingCallBinding pivotElement = PivotUtil.getPivot(MappingCallBinding.class, csElement);
		if (pivotElement != null) {
			pivotElement.setBoundVariable(csElement.getReferredVariable());
		}
		return null;
	}

	@Override
	public Continuation<?> visitMappingCallCS(@NonNull MappingCallCS csElement) {
		MappingCall pivotElement = PivotUtil.getPivot(MappingCall.class, csElement);
		if (pivotElement != null) {
			pivotElement.setReferredMapping(csElement.getReferredMapping());
		}
		return null;
	}

	@Override
	public Continuation<?> visitMappingLoopCS(@NonNull MappingLoopCS csElement) {
//		return new MappingLoopIteratorCompletion(context, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS csElement) {
		return null;
	}
}