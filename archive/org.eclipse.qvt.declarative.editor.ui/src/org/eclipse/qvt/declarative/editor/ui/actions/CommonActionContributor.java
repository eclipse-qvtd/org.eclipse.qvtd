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
 * $Id: CommonActionContributor.java,v 1.3 2008/08/24 19:11:44 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.actions;

import java.util.ResourceBundle;

import org.eclipse.imp.services.base.DefaultLanguageActionsContributor;

public class CommonActionContributor extends DefaultLanguageActionsContributor
{
	public CommonActionContributor() {
		super();
	}

	public static ResourceBundle ResBundle = ResourceBundle.getBundle("org.eclipse.qvt.declarative.editor.ui.actions.ActionMessages");
}
