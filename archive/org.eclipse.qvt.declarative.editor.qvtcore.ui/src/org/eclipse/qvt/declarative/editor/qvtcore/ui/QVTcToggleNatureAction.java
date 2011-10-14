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
 * $Id: QVTcToggleNatureAction.java,v 1.2 2008/08/09 17:56:11 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtcore.ui;

import org.eclipse.qvt.declarative.editor.ui.builder.AbstractToggleNatureAction;

public class QVTcToggleNatureAction extends AbstractToggleNatureAction
{
	public QVTcToggleNatureAction() {
		super(QVTcCreationFactory.INSTANCE);
	}
}