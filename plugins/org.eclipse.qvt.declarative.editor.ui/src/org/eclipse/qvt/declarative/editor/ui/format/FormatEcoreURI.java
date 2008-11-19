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

import org.eclipse.emf.common.util.URI;

public final class FormatEcoreURI extends AbstractFormatHelper<URI>
{
	public static void initialize(IFormatManager manager) {
		manager.install(new FormatEcoreURI(manager));		
	}
	
	public FormatEcoreURI(IFormatManager manager) {
		super(manager, URI.class);
	}

	public void format(IFormatResult s, URI object) {
		manager.subformat(s, object.toString());
	}
}