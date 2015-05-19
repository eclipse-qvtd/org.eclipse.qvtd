/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.ui;

import org.eclipse.qvtd.xtext.qvtrelation.ui.internal.QVTrelationActivator;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Use this class to register components to be used within the IDE.
 */
public class QVTrelationUiModule extends org.eclipse.qvtd.xtext.qvtrelation.ui.AbstractQVTrelationUiModule
{
	public static final String EDITOR_ID = QVTrelationActivator.ORG_ECLIPSE_QVTD_XTEXT_QVTRELATION_QVTRELATION;

	public QVTrelationUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
}
