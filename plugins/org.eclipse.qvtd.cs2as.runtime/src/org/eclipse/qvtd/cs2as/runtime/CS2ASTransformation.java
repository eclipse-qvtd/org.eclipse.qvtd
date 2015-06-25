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
package org.eclipse.qvtd.cs2as.runtime;

import java.util.List;

import org.eclipse.qvtd.pivot.qvtbase.evaluation.Transformer;

public interface CS2ASTransformation extends Transformer {

	public List<EObjectDiagnostic> getErrors();
}
