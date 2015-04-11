/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcorebase.analysis;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;

/**
 * DomainUsage or rather the derived DomainUsageConstant and DomainUsageVariable identify the results of
 * the DomainUsageAnalysis of an OCL AST node.
 */
public interface DomainUsage
{
	void addUsedBy(@NonNull Element element);
	@Nullable Iterable<Element> getElements();
	int getMask();
}
