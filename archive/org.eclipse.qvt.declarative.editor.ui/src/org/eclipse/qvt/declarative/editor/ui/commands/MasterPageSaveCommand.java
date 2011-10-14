/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.editor.ui.commands;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;

public class MasterPageSaveCommand extends PageSaveCommand
{
	public MasterPageSaveCommand(PagedEditor pagedEditor, IProgressMonitor monitor) {
		super(pagedEditor, "Master Page Save", monitor);
	}

	public void execute() {
		pagedEditor.doSaveCommand(monitor);
	}
}