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
 * This code is auto-generated
 * from: org.eclipse.qvtd.xtext.qvtimperative/model/QVTimperativeCST.genmodel
 *
 * Do not edit it.
 */
package	org.eclipse.qvtd.xtext.qvtimperativecst.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.qvtd.xtext.qvtcorebase.cs2as.QVTcoreBaseLeft2RightVisitor;
import org.eclipse.ocl.examples.pivot.Element;

/**
 * An AbstractQVTimperativeLeft2RightVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTimperativeLeft2RightVisitor
	extends QVTcoreBaseLeft2RightVisitor
	implements QVTimperativeCSVisitor<Element>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTimperativeLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	public @Nullable Element visitMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecst.MappingCS csElement) {
		return visitAbstractMappingCS(csElement);
	}

	public @Nullable Element visitMappingCallBindingCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecst.MappingCallBindingCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Element visitMappingCallCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecst.MappingCallCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Element visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecst.TopLevelCS csElement) {
		return visitRootPackageCS(csElement);
	}
}
