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
 * $Id: QVTrSourcePositionLocator.java,v 1.1 2009/05/13 20:24:54 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtrelation.ui.imp;

import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonSourcePositionLocator;

public class QVTrSourcePositionLocator extends CommonSourcePositionLocator
{
	public QVTrSourcePositionLocator(BasicEnvironment environment) {
		super(environment);
	}
}