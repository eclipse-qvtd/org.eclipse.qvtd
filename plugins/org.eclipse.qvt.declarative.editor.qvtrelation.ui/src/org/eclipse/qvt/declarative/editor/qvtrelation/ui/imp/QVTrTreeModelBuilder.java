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
 * $Id: QVTrTreeModelBuilder.java,v 1.2 2008/08/24 18:59:24 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtrelation.ui.imp;

import org.eclipse.qvt.declarative.editor.qvtrelation.ui.QVTrCreationFactory;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonTreeModelBuilder;

public class QVTrTreeModelBuilder extends CommonTreeModelBuilder
{
	public QVTrTreeModelBuilder() {
		this(true);
	}

	public QVTrTreeModelBuilder(boolean showAST) {
		super(QVTrCreationFactory.INSTANCE, showAST);
	}
}