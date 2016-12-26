/*******************************************************************************
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models/companies/Company.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	cs2as.company.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullVisitor provides a default implementation for each
 * visitXxx method that returns null.
 *
 * @deprecated Explicit 'Null' functionality is obsolete with Java 8 @Nullable annotations.
 */
 @Deprecated
public abstract class AbstractNullVisitor<@Nullable R, C>
	extends AbstractVisitor<R, C>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractNullVisitor(C context) {
		super(context);
	}

	@Override
	public R visitCompany(cs2as.company.@NonNull Company object) {
		return null;
	}

	@Override
	public R visitDepartment(cs2as.company.@NonNull Department object) {
		return null;
	}

	@Override
	public R visitEmployee(cs2as.company.@NonNull Employee object) {
		return null;
	}
}
