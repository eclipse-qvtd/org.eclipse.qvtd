/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: model/QVTrelation.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.pivot.qvtrelation.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullQVTrelationVisitor provides a default implementation for each
 * visitXxx method that returns null.
 */
public abstract class AbstractNullQVTrelationVisitor<R, C>
	extends org.eclipse.qvtd.pivot.qvttemplate.util.AbstractNullQVTtemplateVisitor<R, C> implements QVTrelationVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullQVTrelationVisitor(@NonNull C context) {
	    super(context);
	}	

	public @Nullable R visitDomainPattern(@NonNull org.eclipse.qvtd.pivot.qvtrelation.DomainPattern object) {
		return null;
	}

	public @Nullable R visitKey(@NonNull org.eclipse.qvtd.pivot.qvtrelation.Key object) {
		return null;
	}

	public @Nullable R visitOppositePropertyCallExp(@NonNull org.eclipse.qvtd.pivot.qvtrelation.OppositePropertyCallExp object) {
		return null;
	}

	public @Nullable R visitRelation(@NonNull org.eclipse.qvtd.pivot.qvtrelation.Relation object) {
		return null;
	}

	public @Nullable R visitRelationCallExp(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp object) {
		return null;
	}

	public @Nullable R visitRelationDomain(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationDomain object) {
		return null;
	}

	public @Nullable R visitRelationDomainAssignment(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment object) {
		return null;
	}

	public @Nullable R visitRelationImplementation(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation object) {
		return null;
	}

	public @Nullable R visitRelationModel(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationModel object) {
		return null;
	}

	public @Nullable R visitRelationalTransformation(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation object) {
		return null;
	}
}
