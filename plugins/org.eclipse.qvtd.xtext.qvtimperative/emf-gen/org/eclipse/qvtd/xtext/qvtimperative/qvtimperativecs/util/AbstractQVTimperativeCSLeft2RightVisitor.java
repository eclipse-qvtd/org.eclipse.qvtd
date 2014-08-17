/*******************************************************************************
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
 * from: org.eclipse.qvtd.xtext.qvtimperative/model/QVTimperativeCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.qvtd.xtext.qvtcorebase.cs2as.QVTcoreBaseCSLeft2RightVisitor;
import org.eclipse.ocl.examples.pivot.Element;

/**
 * An AbstractQVTimperativeCSLeft2RightVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTimperativeCSLeft2RightVisitor
	extends QVTcoreBaseCSLeft2RightVisitor
	implements QVTimperativeCSVisitor<Element>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTimperativeCSLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	public @Nullable Element visitMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCS csElement) {
		return visitAbstractMappingCS(csElement);
	}

	public @Nullable Element visitMappingCallBindingCS(@NonNull org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Element visitMappingCallCS(@NonNull org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallCS csElement) {
		return visitMappingStatementCS(csElement);
	}

	public @Nullable Element visitMappingLoopCS(@NonNull org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingLoopCS csElement) {
		return visitMappingStatementCS(csElement);
	}

	public @Nullable Element visitMappingSequenceCS(@NonNull org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingSequenceCS csElement) {
		return visitMappingStatementCS(csElement);
	}

	public @Nullable Element visitMappingStatementCS(@NonNull org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingStatementCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Element visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.TopLevelCS csElement) {
		return visitRootPackageCS(csElement);
	}
}
