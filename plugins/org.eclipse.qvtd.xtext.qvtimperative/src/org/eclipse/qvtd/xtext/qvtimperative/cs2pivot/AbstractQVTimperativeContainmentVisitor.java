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
 * $Id: CompleteOCLPreOrderVisitor.java,v 1.11 2011/05/20 15:26:50 ewillink Exp $
 */
package org.eclipse.qvtd.xtext.qvtimperative.cs2pivot;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.qvtd.xtext.qvtcorebase.cs2pivot.QVTcoreBaseContainmentVisitor;
import org.eclipse.qvtd.xtext.qvtimperativecst.util.QVTimperativeCSVisitor;

public class AbstractQVTimperativeContainmentVisitor extends QVTcoreBaseContainmentVisitor implements QVTimperativeCSVisitor<Continuation<?>>
{
	//
	//	This file is maintained by copying from AbstractExtendingQVTcoreCSVisitor and changing R to Continuation<?>.
	//
	public AbstractQVTimperativeContainmentVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}	

	public Continuation<?> visitMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecst.MappingCS object) {
		return visitAbstractMappingCS(object);
	}

	public Continuation<?> visitMappingCallBindingCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecst.MappingCallBindingCS object) {
		return visitExpCS(object);
	}

	public Continuation<?> visitMappingCallCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecst.MappingCallCS object) {
		return visitModelElementCS(object);
	}

	public Continuation<?> visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecst.TopLevelCS object) {
		return visitRootPackageCS(object);
	}
}