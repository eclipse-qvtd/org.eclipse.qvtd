/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D. Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtcore.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseToStringVisitor;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 */
public class QVTcoreToStringVisitor extends QVTcoreBaseToStringVisitor implements QVTcoreVisitor<String>
{
	protected static class QVTcoreToStringFactory extends QVTcoreBaseToStringFactory
	{
		protected QVTcoreToStringFactory() {
//			FACTORY.getClass();
		}

		@Override
		public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
			return new QVTcoreToStringVisitor(s, getClass());
		}

		@Override
		@SuppressWarnings("null")
		public @NonNull EPackage getEPackage() {
			return QVTcorePackage.eINSTANCE;
		}
	}

	public static @NonNull ToStringVisitor.Factory FACTORY = new QVTcoreToStringFactory();

	protected QVTcoreToStringVisitor(@NonNull StringBuilder s, /*@NonNull*/ Class<? extends ToStringVisitor.Factory> factoryClass) {
		super(s, factoryClass);
	}

	public String visitCoreModel(@NonNull CoreModel object) {
		return visitRoot(object);
	}

	public String visitMapping(@NonNull Mapping object) {
		append("mapping ");
		appendName(object);
		return null;
	}
}
