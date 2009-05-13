/**
 * <copyright>
 * 
 * Copyright (c) 2008,2009 E.D.Willink and others.
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
 * $Id: CommonNodeLocator.java,v 1.7 2009/05/13 20:24:49 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import org.eclipse.ocl.lpg.BasicEnvironment;

/**
 *
 */
@Deprecated // Use CommonSourcePositionLocator directly
public class CommonNodeLocator extends CommonSourcePositionLocator
{
	protected CommonNodeLocator(BasicEnvironment environment) {
		super(environment);
	}
}
