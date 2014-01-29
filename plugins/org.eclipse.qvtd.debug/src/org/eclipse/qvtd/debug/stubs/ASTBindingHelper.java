package org.eclipse.qvtd.debug.stubs;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.qvtd.debug.utils.IModuleSourceInfo;
import org.eclipse.qvtd.debug.utils.LineNumberProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class ASTBindingHelper
{
	private static final class UnitLocation2 implements IModuleSourceInfo, LineNumberProvider		// FIXME Unify with UnitLocation/INode
	{
//		private @NonNull Element asElement;
		private @Nullable ModelElementCS csElement;
		private @Nullable ICompositeNode node;
		
		private UnitLocation2(@NonNull Element asElement) {
//			this.asElement = asElement;
			this.csElement = ElementUtil.getCsElement(asElement);
			if (csElement != null) {
				this.node = NodeModelUtils.getNode(csElement);
			}
		}
		
		@Override
		public int getLineCount() {
			ICompositeNode node2 = node;
			return node2 != null ? node2.getStartLine() : 0;
		}

		@Override
		public int getLineEnd(int lineNumber) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int getLineNumber(int offset) {
			ICompositeNode node2 = node;
			if (node2 != null) {
				int nodeOffset = node2.getOffset();
				if (offset == nodeOffset) {
					return node2.getStartLine();
				}
				ICompositeNode rootNode = node2.getRootNode();
				if (rootNode != null) {
					ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(rootNode, offset);
					if (leafNode != null) {
						return leafNode.getStartLine();
					}
				}
			}
			throw new UnsupportedOperationException();
		}

		@Override
		public LineNumberProvider getLineNumberProvider() {
			return this;
		}

		@Override
		public URI getSourceURI() {
			ModelElementCS csElement2 = csElement;
			return csElement2 != null ? csElement2.eResource().getURI() : null;
		}
	}


	public static int getEndPosition(@NonNull Element element) {
		ModelElementCS csElement = ElementUtil.getCsElement(element);
		if (csElement == null) {
			return 0;
		}
		ICompositeNode node = NodeModelUtils.getNode(csElement);
		if (node == null) {
			return 0;
		}
		return node.getEndOffset();
	}
	
//	private static int getNodeLength(@NonNull Element element) {
//		return getEndPosition(element) - getStartPosition(element);
//	}
	
	public static int getStartPosition(@NonNull Element element) {
		ModelElementCS csElement = ElementUtil.getCsElement(element);
		if (csElement == null) {
			return 0;
		}
		ICompositeNode node = NodeModelUtils.getNode(csElement);
		if (node == null) {
			return 0;
		}
		return node.getOffset();
	}

	public static IModuleSourceInfo getModuleSourceBinding(@NonNull Element element) {
		return new UnitLocation2(element);
	}
}
