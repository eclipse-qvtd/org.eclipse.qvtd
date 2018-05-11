/**
 * <copyright>
 *
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.text.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.impl.XMILoadImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.text.StringNode;
import org.eclipse.qvtd.text.TextModelFactory;

/**
 * TextModelResourceImpl saves a model that conforms to http://www.eclipse.org/qvt/2018/Text as a simple String.
 *
 * This allows the Text technology space to be manipulated using Model techology space tooling.
 *
 * TextModelResourceImpl loads from an arbitrary source String, creating a model that conform to
 * http://www.eclipse.org/qvt/2018/Text inferring indentation and hierarchy from leading whitespace and
 * new lines. No inference of separators is made.
 */
public class TextModelResourceImpl extends ResourceImpl
{
	public static class TextModelLoadImpl extends XMILoadImpl
	{
		public TextModelLoadImpl(XMLHelper helper) {
			super(helper);
		}
	}

	public static class TextModelSave
	{
		protected final @NonNull StringBuilder s = new StringBuilder();
		protected final @NonNull Stack<@NonNull String> indentStack = new Stack<>();
		private boolean indentPending = true;			// AT beginning of first line, a first indent is pending

		public TextModelSave() {
			indentStack.push("");
		}

		protected void append(@NonNull String text) {
			int iSize = text.length();
			for (int i = 0; i < iSize; i++) {
				char c = text.charAt(i);
				if (!indentPending) {
					s.append(c);
					if (c == '\n') {
						indentPending = true;
					}
				}
				else if (c != '\n') {
					s.append(indentStack.peek());
					indentPending = false;
					s.append(c);
				}
				else {
					s.append(c);
					indentPending = true;
				}
			}
		}

		@Override
		public @NonNull String toString() {
			return s.toString();
		}

		public void traverse(List<? extends EObject> contents) {
			for (EObject eObject : contents) {
				if (eObject instanceof StringNode) {
					traverseNode((StringNode)eObject);
				}
			}
		}

		protected void traverseNode(@NonNull StringNode node) {
			String childIndent = indentStack.peek() + node.getIndent();
			indentStack.push(childIndent);
			append(node.getText());
			List<StringNode> children = node.getChildren();
			if (children.size() > 0) {
				append(node.getPrefix());
				String separator = null;
				for (StringNode child : children) {
					if (separator != null) {
						append(separator);
					}
					else {
						separator = node.getSeparator();
					}
					traverseNode(child);
				}
				append(node.getSuffix());
			}
			indentStack.pop();
		}
	}

	public TextModelResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	public void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		Reader reader = new InputStreamReader(inputStream);
		doLoad(reader, options);
	}

	public void doLoad(Reader reader, Map<?, ?> options) throws IOException {
		BufferedReader lineReader = new BufferedReader(reader);
		Stack<@NonNull StringNode> treeNodes = new Stack<>();
		Stack<@NonNull String> indentations = new Stack<>();
		StringNode rootNode = TextModelFactory.eINSTANCE.createStringNode();
		rootNode.setSeparator("\n");
		rootNode.setSuffix("\n");
		getContents().add(rootNode);
		treeNodes.push(rootNode);
		indentations.push(rootNode.getIndent());
		for (String line; (line = lineReader.readLine()) != null; ) {
			String indentation = indentations.peek();
			while (!line.startsWith(indentation)) {
				treeNodes.pop();
				indentations.pop();
				indentation = indentations.peek();
			}
			// treeNodes.peek() has shorter/same indentation
			int outerLineStart = indentation.length();
			int innerLineStart = outerLineStart;
			while (innerLineStart < line.length()) {
				char c = line.charAt(innerLineStart);
				if (!Character.isWhitespace(c)) {
					break;
				}
				innerLineStart++;
			}
			StringNode node = TextModelFactory.eINSTANCE.createStringNode();
			node.setText(line.substring(innerLineStart));
			if ((outerLineStart == innerLineStart) && (treeNodes.size() > 1)){		// Same indentation - add a sibling
				StringNode sibling = treeNodes.pop();
				node.setIndent(sibling.getIndent());
			}
			else {										// Extra indentation - add a child
				String extraIndentation = line.substring(outerLineStart, innerLineStart);
				node.setIndent(extraIndentation);
				indentations.push(indentation + extraIndentation);
			}
			StringNode parent = treeNodes.peek();
			if (parent != rootNode) {
				parent.setSeparator("\n");
				parent.setPrefix("\n");
			}
			parent.getChildren().add(node);
			treeNodes.push(node);
		}
	}

	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		OutputStreamWriter writer = new OutputStreamWriter(outputStream);
		doSave(writer, options);
	}

	protected void doSave(Writer writer, Map<?, ?> options) throws IOException {
		TextModelSave saveHelper = new TextModelSave();
		saveHelper.traverse(getContents());
		writer.append(saveHelper.toString());
		writer.flush();
		writer.close();
	}
}
