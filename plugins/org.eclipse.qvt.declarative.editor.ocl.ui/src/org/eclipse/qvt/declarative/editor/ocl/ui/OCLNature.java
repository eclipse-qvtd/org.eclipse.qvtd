/**
 * <copyright>
 * 
 * Copyright (c) 2007,2008 E.D.Willink and others.
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
 * $Id: OCLNature.java,v 1.1 2008/08/18 07:41:47 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ocl.ui;

import org.eclipse.qvt.declarative.editor.ui.builder.CommonNature;

public class OCLNature extends CommonNature
{
	public OCLNature() {
		super(OCLCreationFactory.INSTANCE);
	}
}
