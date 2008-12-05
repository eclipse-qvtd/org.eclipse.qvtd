/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
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
 * $Id: TextProvider.java,v 1.1 2008/12/05 22:20:01 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.util;

public interface TextProvider 
{
	public String getText(Object object);
}
