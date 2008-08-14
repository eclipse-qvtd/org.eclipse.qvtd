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
 * $Id: OCLHoverHelper.java,v 1.1 2008/08/14 07:51:10 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ocl.ui.imp;

import org.eclipse.qvt.declarative.editor.ocl.ui.OCLPlugin;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonHoverHelper;
import org.eclipse.qvt.declarative.editor.ui.imp.ICommonPlugin;

public class OCLHoverHelper extends CommonHoverHelper
{
	@Override
	protected ICommonPlugin getPlugin() {
		return OCLPlugin.getInstance();
	}
}
