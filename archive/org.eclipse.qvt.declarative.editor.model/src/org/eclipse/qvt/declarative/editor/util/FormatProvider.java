/**
 * <copyright>
 * 
 * Copyright (c) 2009 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: FormatProvider.java,v 1.1 2009/10/31 17:46:03 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.util;

public interface FormatProvider 
{
	public String getFormat(Object object);
}
