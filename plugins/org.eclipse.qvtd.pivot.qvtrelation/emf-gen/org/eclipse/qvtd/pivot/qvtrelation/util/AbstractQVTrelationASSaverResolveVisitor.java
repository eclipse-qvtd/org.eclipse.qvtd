/*******************************************************************************
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
 * from: org.eclipse.qvtd.pivot.qvtrelation/model/QVTrelation.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtrelation.util;

import java.lang.Object;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.utilities.ASSaver;
import org.eclipse.qvtd.pivot.qvttemplate.utilities.QVTtemplateASSaverResolveVisitor;

/**
 * An AbstractQVTrelationASSaverResolveVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTrelationASSaverResolveVisitor
	extends QVTtemplateASSaverResolveVisitor
	implements QVTrelationVisitor<Object>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTrelationASSaverResolveVisitor(@NonNull ASSaver context) {
		super(context);
	}	

	public @Nullable Object visitDomainPattern(@NonNull org.eclipse.qvtd.pivot.qvtrelation.DomainPattern object) {
		return visitPattern(object);
	}

	public @Nullable Object visitKey(@NonNull org.eclipse.qvtd.pivot.qvtrelation.Key object) {
		return visitElement(object);
	}

	public @Nullable Object visitOppositePropertyCallExp(@NonNull org.eclipse.qvtd.pivot.qvtrelation.OppositePropertyCallExp object) {
		return visitPropertyCallExp(object);
	}

	public @Nullable Object visitRelation(@NonNull org.eclipse.qvtd.pivot.qvtrelation.Relation object) {
		return visitRule(object);
	}

	public @Nullable Object visitRelationCallExp(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp object) {
		return visitOCLExpression(object);
	}

	public @Nullable Object visitRelationDomain(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationDomain object) {
		return visitDomain(object);
	}

	public @Nullable Object visitRelationDomainAssignment(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment object) {
		return visitElement(object);
	}

	public @Nullable Object visitRelationImplementation(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation object) {
		return visitElement(object);
	}

	public @Nullable Object visitRelationModel(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationModel object) {
		return visitBaseModel(object);
	}

	public @Nullable Object visitRelationalTransformation(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation object) {
		return visitTransformation(object);
	}
}
