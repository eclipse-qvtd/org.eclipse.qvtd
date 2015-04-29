package org.eclipse.qvtd.cs2as.compiler.qvti;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.cs2as.runtime.CS2ASException;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class CS2ASExceptionDiagnostic extends ExceptionDiagnostic
{
	protected final @NonNull EObject csObject;
	
	public CS2ASExceptionDiagnostic(@NonNull CS2ASException exception) {
		super(exception);
		csObject = exception.getCSObject();
	}

	
	@Override
	public int getLength() {
		ICompositeNode node = NodeModelUtils.getNode(csObject);
		return node != null ? node.getLength() : 0;
	}

	@Override
	public int getOffset() {
		ICompositeNode node = NodeModelUtils.getNode(csObject);
		return node != null ? node.getOffset() : 0;
	}

	@Override
	public int getLine() {
		ICompositeNode node = NodeModelUtils.getNode(csObject);
		return node != null ? node.getStartLine()+1 : 1;
	}
}
