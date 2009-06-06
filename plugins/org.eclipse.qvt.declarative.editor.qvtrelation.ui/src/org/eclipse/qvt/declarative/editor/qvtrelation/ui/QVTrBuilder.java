/**
 * <copyright>
 * 
 * Copyright (c) 2007,2008 E.D.Willink and others.
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
 * $Id: QVTrBuilder.java,v 1.4 2009/06/06 15:10:38 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtrelation.ui;

import org.eclipse.imp.runtime.PluginBase;
import org.eclipse.qvt.declarative.editor.ui.builder.CommonBuilder;

public class QVTrBuilder extends CommonBuilder
{
	public QVTrBuilder() {
		super(QVTrCreationFactory.INSTANCE);
	}

	// FIXME This is only required to workaround IMP bug 279350
	@Override
	public PluginBase getPlugin() {
		return QVTrCreationFactory.INSTANCE.getPlugin();
	}
}
