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
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationAnalysis;

/**
 * A NonTopRelation2SignatureClass represents the mapping between a non-top level QVTr Relation and the abstract siganture class for an invoked QVTc Mapping.
 */
class NonTopRelation2SignatureClass extends AbstractRelation2MiddleClass implements Relation2SignatureClass
{
	protected NonTopRelation2SignatureClass(@NonNull RelationAnalysis relationAnalysis) {
		super(relationAnalysis, relationAnalysis.getNameGenerator().createSignatureClassName(relationAnalysis.getRelation()));
		//			traceClass.setIsAbstract(true);
	}

	@Override
	public void analyzeProperties() throws CompilerChainException {
		boolean manyTraces = true; //analyzeTraceMultiplicity();
		analyzeRootTemplateVariables(manyTraces);
	}
}