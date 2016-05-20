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
