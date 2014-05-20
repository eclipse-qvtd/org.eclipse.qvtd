/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.xtext.qvtimperative/model/QVTimperativeCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractExtendingQVTimperativeCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTimperativeCSVisitor<R, C>
	extends org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.util.AbstractExtendingQVTcoreBaseCSVisitor<R, C>
	implements QVTimperativeCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingQVTimperativeCSVisitor(@NonNull C context) {
		super(context);
	}	

	public @Nullable R visitMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCS object) {
		return visitAbstractMappingCS(object);
	}

	public @Nullable R visitMappingCallBindingCS(@NonNull org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitMappingCallCS(@NonNull org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.TopLevelCS object) {
		return visitRootPackageCS(object);
	}
}
