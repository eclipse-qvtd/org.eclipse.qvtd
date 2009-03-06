/**
 * <copyright>
 * 
 * Copyright (c) 2009 E.D.Willink and others.
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
 * $Id: OCLMultiEditor.java,v 1.1 2009/03/06 17:35:55 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ocl.ui;

import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;

public class OCLMultiEditor extends PagedEditor
{
	public OCLMultiEditor() {
		super(OCLCreationFactory.INSTANCE);
	}
}
