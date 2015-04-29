package org.eclipse.qvtd.cs2as.compiler.qvti;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class CS2ASDiagnostic extends AbstractDiagnostic{

	private INode node; 
	private String message;
	
	public CS2ASDiagnostic(EObject csObject, String message) {
		this.node = NodeModelUtils.findActualNodeFor(csObject);
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}

	@Override
	protected INode getNode() {
		return node;
	}

	@Override
	public String getCode() {
		return "CS2AS";
	}

	@Override
	public String[] getData() {
		return null;
	}

}
