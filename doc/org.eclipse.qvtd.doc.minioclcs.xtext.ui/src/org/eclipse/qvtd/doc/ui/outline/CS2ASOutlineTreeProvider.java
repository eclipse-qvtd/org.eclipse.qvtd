/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.ui.outline;

import org.eclipse.qvtd.doc.minioclcs.CSTrace;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;

// TODO This should be auto generated in the src-gen folder
public class CS2ASOutlineTreeProvider extends DefaultOutlineTreeProvider {
		
	protected void _createNode(IOutlineNode parentNode, CSTrace csElement) {
		super._createNode(parentNode, csElement.getAst()); // FIXME this requirse manual addition of .miniocl to the manifest 
	}
}
