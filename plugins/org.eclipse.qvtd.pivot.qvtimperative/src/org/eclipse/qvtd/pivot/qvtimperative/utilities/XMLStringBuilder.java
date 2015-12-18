/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import java.util.Stack;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class XMLStringBuilder
{
	private StringBuilder s = new StringBuilder();
	private @NonNull Stack<String> tagStack = new Stack<String>();
	private @Nullable String currentTag = null;

	public XMLStringBuilder() {}
	
	public void appendElement(@NonNull String element, /*@NonNull*/ String value) {
		s.append(" ");
		s.append(element);
		s.append("=\"");
		s.append(value);
		s.append("\"");
	}

	protected void appendIndentation() {
		for (int i = 0; i < tagStack.size(); i++) {
			s.append("  ");
		}
	}

	public void appendNewLineElement(@NonNull String element, @NonNull String value) {
		s.append("\n");
		appendIndentation();
		appendElement(element, value);
	}

	public void appendText(@NonNull String tag, /*@NonNull*/ String text) {
		appendTextBegin(tag);
		appendTextEnd(text);
	}

	public void appendTextBegin(@NonNull String tag) {
		pushTag(tag);
	}

	public void appendTextEnd(/*@NonNull*/ String text) {
		s.append(">");
		s.append(text);
		s.append("</");
		s.append(tagStack.pop());
		s.append(">\n");
		currentTag = null;
	}
	
	// Append value always pops!
	public void appendValueAndPopTag(@Nullable String value) {
		if (currentTag != null) {
			s.append(">");
			currentTag = null;
		}
		if (value == null)
			value = "";
		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			if (c == '\'') { s.append("&apos;"); }
			else if (c == '"') { s.append("&quot;"); }
			else if (c == '&') { s.append("&amp;"); }
			else if (c == '<') { s.append("&lt;"); }
			else if (c == '>') { s.append("&gt;"); }
			else if (c == '\n') { s.append("&#xA;"); }
			else { s.append(c); }
		}
		String topTag = tagStack.pop();
		s.append("</");
		s.append(topTag);
		s.append(">\n");
	}

	public void popTag() {
		String topTag = tagStack.pop();
		if (currentTag != null) {
			s.append("/");
		}
		else {
			appendIndentation();
			s.append("</");
			s.append(topTag);
		}
		s.append(">\n");
		currentTag = null;
	}

	public void pushTag(@NonNull String tag) {
		if (currentTag != null) {
			s.append(">\n");
			currentTag = null;
		}
		appendIndentation();
		tagStack.push(tag);
		currentTag = tag;
		s.append("<" + tag);
	}

	@Override
	public String toString() {
		return s.toString();
	}
}
