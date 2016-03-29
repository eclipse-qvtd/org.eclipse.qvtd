/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.internal.cs2as;

import java.util.List;

import org.eclipse.qvtd.runtime.evaluation.Transformer;

public interface CS2ASTransformer extends Transformer {

	public List<CS2ASDiagnostic> getErrors();
}
