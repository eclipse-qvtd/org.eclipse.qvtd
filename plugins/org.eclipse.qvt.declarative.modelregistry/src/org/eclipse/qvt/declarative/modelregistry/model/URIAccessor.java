/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.modelregistry.model;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * A URIAccesor defines a key to access model registry entries by a URI.
 */
public class URIAccessor implements Accessor
{
	public static final String KIND = "URI";

	private static URI createPrototypeURI() {
		try {
			return new URI("/prototype/");
		} catch (URISyntaxException e) {
			return null;
		}
	}

	private final URI uri;

	public URIAccessor() {
		this(createPrototypeURI());
	}
	
	public URIAccessor(URI uri) {
		this.uri = uri;
	}

	@Override public boolean equals(Object object) {
		if (!(object instanceof URIAccessor))
			return false;
		return uri.equals(((URIAccessor)object).getURI());
	}

	public String getKind() { return KIND; }
	public String getName() { return uri.toString(); }
	public URI getURI() { return uri; }

	public URIAccessor newInstance(String name) throws URISyntaxException {
		return new URIAccessor(new URI(name));
	}

	@Override public String toString() { return getName(); }
}
