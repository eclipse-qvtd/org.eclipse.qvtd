/*******************************************************************************
 * Copyright (c) 2010, 2014 Willink Transformations and others.
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
 * This code is auto-generated
 * from: org.eclipse.qvtd.xtext.qvtimperative/model/QVTimperativeCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtimperativecs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.qvtd.xtext.qvtcorebase.cs2as.QVTcoreBaseCSPreOrderVisitor;

/**
 * An AbstractQVTimperativeCSPreOrderVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTimperativeCSPreOrderVisitor
	extends QVTcoreBaseCSPreOrderVisitor
	implements QVTimperativeCSVisitor<Continuation<?>>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTimperativeCSPreOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Continuation<?> visitImperativeDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecs.ImperativeDomainCS csElement) {
		return visitDomainCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitImperativePredicateOrAssignmentCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecs.ImperativePredicateOrAssignmentCS csElement) {
		return visitPredicateOrAssignmentCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS csElement) {
		return visitAbstractMappingCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMappingCallBindingCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMappingCallCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS csElement) {
		return visitMappingStatementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMappingLoopCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS csElement) {
		return visitMappingStatementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMappingSequenceCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecs.MappingSequenceCS csElement) {
		return visitMappingStatementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMappingStatementCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecs.MappingStatementCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS csElement) {
		return visitRootPackageCS(csElement);
	}
}
