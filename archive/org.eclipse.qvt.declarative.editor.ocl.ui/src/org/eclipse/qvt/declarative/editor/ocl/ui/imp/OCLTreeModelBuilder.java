/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLTreeModelBuilder.java,v 1.2 2008/08/24 18:59:25 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ocl.ui.imp;

import org.eclipse.qvt.declarative.editor.ocl.ui.OCLCreationFactory;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonTreeModelBuilder;


public class OCLTreeModelBuilder extends CommonTreeModelBuilder
{
	public OCLTreeModelBuilder() {
		this(true);
	}

	public OCLTreeModelBuilder(boolean showAST) {
		super(OCLCreationFactory.INSTANCE, showAST);
	}
}