/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2013, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.pivot.qvttemplate/model/QVTtemplate.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvttemplate.util;

import java.lang.Object;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseTemplateParameterSubstitutionVisitor;

/**
 * An AbstractQVTtemplateTemplateParameterSubstitutionVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTtemplateTemplateParameterSubstitutionVisitor
	extends QVTbaseTemplateParameterSubstitutionVisitor
	implements QVTtemplateVisitor<Object>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractQVTtemplateTemplateParameterSubstitutionVisitor(@NonNull EnvironmentFactoryInternal environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
		super(environmentFactory, selfType, selfTypeValue);
	}

	@Override
	public @Nullable Object visitCollectionTemplateExp(org.eclipse.qvtd.pivot.qvttemplate.@NonNull CollectionTemplateExp object) {
		return visitTemplateExp(object);
	}

	@Override
	public @Nullable Object visitObjectTemplateExp(org.eclipse.qvtd.pivot.qvttemplate.@NonNull ObjectTemplateExp object) {
		return visitTemplateExp(object);
	}

	@Override
	public @Nullable Object visitPropertyTemplateItem(org.eclipse.qvtd.pivot.qvttemplate.@NonNull PropertyTemplateItem object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitTemplateExp(org.eclipse.qvtd.pivot.qvttemplate.@NonNull TemplateExp object) {
		return visitLiteralExp(object);
	}
}
