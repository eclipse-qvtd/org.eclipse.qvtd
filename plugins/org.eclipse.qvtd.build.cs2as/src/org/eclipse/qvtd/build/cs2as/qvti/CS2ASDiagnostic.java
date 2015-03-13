package org.eclipse.qvtd.build.cs2as.qvti;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class CS2ASDiagnostic extends ExceptionDiagnostic
{
	protected final @NonNull EObject csObject;

	public CS2ASDiagnostic(@NonNull CS2ASException exception) {
		super(exception);
		csObject = exception.getCSObject();
	}
	
	@Override
	public int getLength() {
		ICompositeNode node = NodeModelUtils.getNode(csObject);
		return node != null ? node.getTotalLength() : 0;
	}

	@Override
	public int getOffset() {
		ICompositeNode node = NodeModelUtils.getNode(csObject);
		return node != null ? node.getTotalOffset() : 0;
	}

	@Override
	public int getColumn() {
		return 0;
	}

	@Override
	public int getLine() {
		ICompositeNode node = NodeModelUtils.getNode(csObject);
		return node != null ? node.getTotalStartLine()+1 : 1;
	}

	@Override
	public String getLocation() {
		return null;
	}
	
	@Override
	public String toString() {
		return getMessage();
	}
}
