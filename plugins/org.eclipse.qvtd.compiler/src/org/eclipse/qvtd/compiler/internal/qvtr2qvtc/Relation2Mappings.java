/*******************************************************************************
 * Copyright (c) 2014, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;

/*public*/ interface Relation2Mappings
{
	interface EnforceableRelationDomain2CoreMapping
	{
		@NonNull Mapping getCoreMapping();
	}

	interface OtherRelationDomain2CoreDomain
	{
		void synthesize() throws CompilerChainException;
	}

	/**
	 * Create an AbstractEnforceableRelationDomain2CoreMapping for each Core Mapping that is to be synthesized.
	 */
	void analyze() throws CompilerChainException;

	@NonNull Relation getRelation();

	@NonNull EnforceableRelationDomain2CoreMapping getTopRelationDomain2CoreMapping(@NonNull TypedModel rEnforcedTypedModel);

	@NonNull EnforceableRelationDomain2CoreMapping getWhenRelationDomain2CoreMapping(@NonNull TypedModel rEnforcedTypedModel);

	@NonNull EnforceableRelationDomain2CoreMapping getWhereRelationDomain2CoreMapping(@NonNull TypedModel rEnforcedTypedModel);

	void synthesize() throws CompilerChainException;
}
