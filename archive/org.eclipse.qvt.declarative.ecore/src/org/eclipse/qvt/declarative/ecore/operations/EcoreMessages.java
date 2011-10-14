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
 * $Id: EcoreMessages.java,v 1.1 2008/12/31 17:37:48 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.operations;
import org.eclipse.osgi.util.NLS;

public class EcoreMessages extends NLS
{
	public static String _UI_RequiredFeatureMustBeSet_diagnostic;

	static {
		NLS.initializeMessages(EcoreMessages.class.getName(), EcoreMessages.class);
	}
}