/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;

/**
 * A NonTopRelation2TraceClass represents the mapping between a non-top level QVTr Relation and the abstract trace class for an invoked QVTc Mapping.
 */
class NonTopRelation2TraceClass extends AbstractRelation2TraceClass
{
	protected NonTopRelation2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage, @NonNull Relation relation) {
		super(relationalTransformation2tracePackage, relation);
		//			traceClass.setIsAbstract(true);
	}
}