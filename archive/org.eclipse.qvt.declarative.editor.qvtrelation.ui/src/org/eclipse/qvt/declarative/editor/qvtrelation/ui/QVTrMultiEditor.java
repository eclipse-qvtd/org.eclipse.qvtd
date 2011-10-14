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
 * $Id: QVTrMultiEditor.java,v 1.1 2008/09/28 12:17:09 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtrelation.ui;

import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;

public class QVTrMultiEditor extends PagedEditor
{
	public QVTrMultiEditor() {
		super(QVTrCreationFactory.INSTANCE);
	}
}
