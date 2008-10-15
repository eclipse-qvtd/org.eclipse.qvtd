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
 * $Id: ICommonProposal.java,v 1.2 2008/10/15 20:00:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import org.eclipse.jface.text.contentassist.ICompletionProposal;

public interface ICommonProposal extends ICompletionProposal, Comparable<ICommonProposal> {}