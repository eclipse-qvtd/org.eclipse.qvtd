/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtrelation.cs2pivot;

import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLLeft2RightVisitor;
import org.eclipse.qvtd.xtext.qvtrelationcst.util.AbstractExtendingDelegatingQVTrelationCSVisitor;

public class QVTrelationLeft2RightVisitor
	extends AbstractExtendingDelegatingQVTrelationCSVisitor<Element, CS2PivotConversion, EssentialOCLLeft2RightVisitor>
{
	public QVTrelationLeft2RightVisitor(CS2PivotConversion context) {
		super(new EssentialOCLLeft2RightVisitor(context), context);
	}
}