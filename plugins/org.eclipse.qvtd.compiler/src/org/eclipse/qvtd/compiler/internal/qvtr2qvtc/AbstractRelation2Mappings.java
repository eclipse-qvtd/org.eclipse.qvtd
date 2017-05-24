/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * AbstractRelation2Mappings providides abstract support for conversion of a relation.
 */
/*public*/ abstract class AbstractRelation2Mappings extends QVTcoreHelper implements Relation2Mappings
{
	/**
	 * The overall QVTr2QVTc transformation
	 */
	protected @NonNull final QVTr2QVTc qvtr2qvtc;
	// Relations
	/**
	 * r: The relation being transformed
	 */
	protected final @NonNull Relation rRelation;
	/**
	 * The transformation containing the rRelation. i.e. rRelation.getOwningTransformation()
	 */
	protected final @NonNull RelationalTransformation rTransformation;
	/**
	 * The name of the rRelation. i.e. rRelation.getName()
	 */
	protected final @NonNull String rRelationName;

	// Core
	/**
	 * mt: The transformation containing the result mapping
	 */
	protected final @NonNull Transformation cTransformation;

	public AbstractRelation2Mappings(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull Relation rRelation) {
		super(qvtr2qvtc.getEnvironmentFactory());
		this.qvtr2qvtc = qvtr2qvtc;
		this.rRelation = rRelation;
		this.rTransformation = QVTrelationUtil.getTransformation(rRelation);
		this.rRelationName = PivotUtil.getName(rRelation);
		//
		this.cTransformation = qvtr2qvtc.getCoreTransformation(rTransformation);
	}

	@Override
	public @NonNull Relation getRelation() {
		return rRelation;
	}

	@Override
	public @NonNull EnforceableRelationDomain2CoreMapping getTopRelationDomain2CoreMapping(@NonNull TypedModel rEnforcedTypedModel) {
		throw new IllegalStateException();
	}

	@Override
	public @NonNull EnforceableRelationDomain2CoreMapping getWhenRelationDomain2CoreMapping(@NonNull TypedModel rEnforcedTypedModel) {
		throw new IllegalStateException();
	}

	@Override
	public @NonNull EnforceableRelationDomain2CoreMapping getWhereRelationDomain2CoreMapping(@NonNull TypedModel rEnforcedTypedModel) {
		throw new IllegalStateException();
	}

	@Override
	public @NonNull String toString() {
		return PivotUtil.getName(rTransformation) + "::" + rRelationName;
	}
}
