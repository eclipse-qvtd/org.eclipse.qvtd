/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.editor.ui.format;

import org.eclipse.imp.editor.ModelTreeNode;

public final class FormatModelTreeNode extends AbstractFormatHelper<ModelTreeNode>
{
	public static void initialize(IFormatManager manager) {
		manager.install(new FormatModelTreeNode(manager));		
	}
	
	public FormatModelTreeNode(IFormatManager manager) {
		super(manager, ModelTreeNode.class);
	}

	public void format(IFormatResult s, ModelTreeNode object) {
		s.append("[");
		s.subformat(object.getASTNode());
		s.append("]");
	}
}