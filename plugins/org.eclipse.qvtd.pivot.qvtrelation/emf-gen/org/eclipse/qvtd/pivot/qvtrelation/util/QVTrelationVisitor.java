/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: /org.eclipse.qvtd.pivot.qvtrelation/model/QVTrelation.ecore
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
 */
public interface QVTrelationVisitor<R> extends org.eclipse.qvtd.pivot.qvttemplate.util.QVTtemplateVisitor<R>
{
	@Nullable R visitDomainPattern(@NonNull org.eclipse.qvtd.pivot.qvtrelation.DomainPattern object);
	@Nullable R visitKey(@NonNull org.eclipse.qvtd.pivot.qvtrelation.Key object);
	@Nullable R visitOppositePropertyCallExp(@NonNull org.eclipse.qvtd.pivot.qvtrelation.OppositePropertyCallExp object);
	@Nullable R visitRelation(@NonNull org.eclipse.qvtd.pivot.qvtrelation.Relation object);
	@Nullable R visitRelationCallExp(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp object);
	@Nullable R visitRelationDomain(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationDomain object);
	@Nullable R visitRelationDomainAssignment(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment object);
	@Nullable R visitRelationImplementation(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation object);
	@Nullable R visitRelationModel(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationModel object);
	@Nullable R visitRelationalTransformation(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation object);
}
