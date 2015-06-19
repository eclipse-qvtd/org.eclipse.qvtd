/*******************************************************************************
 * Copyright (c) 2013, 2015 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

public interface IQVTiEvaluationVisitor extends QVTimperativeVisitor<Object>, EvaluationVisitor.EvaluationVisitorExtension
{
	Object safeVisit(@Nullable Visitable v);
}
