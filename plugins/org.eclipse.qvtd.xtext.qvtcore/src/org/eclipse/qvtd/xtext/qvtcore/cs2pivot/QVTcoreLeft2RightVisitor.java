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
 * $Id: QVTcoreLeft2RightVisitor.java,v 1.10 2011/05/23 05:51:25 ewillink Exp $
 */
package org.eclipse.qvtd.xtext.qvtcore.cs2pivot;

import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLLeft2RightVisitor;
import org.eclipse.qvtd.xtext.qvtcorecst.util.AbstractExtendingDelegatingQVTcoreCSVisitor;

public class QVTcoreLeft2RightVisitor
	extends AbstractExtendingDelegatingQVTcoreCSVisitor<Element, CS2PivotConversion, EssentialOCLLeft2RightVisitor>
{
	public QVTcoreLeft2RightVisitor(CS2PivotConversion context) {
		super(new EssentialOCLLeft2RightVisitor(context), context);
	}
}