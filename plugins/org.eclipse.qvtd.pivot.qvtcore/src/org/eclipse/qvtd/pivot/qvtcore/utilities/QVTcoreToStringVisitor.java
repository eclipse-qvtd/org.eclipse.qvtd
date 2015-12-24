/*******************************************************************************
 * Copyright (c) 2012, 2014 E.D. Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
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
	protected static class QVTcoreToStringFactory implements QVTcoreBaseToStringVisitor.Factory
	{
		protected QVTcoreToStringFactory() {
			ToStringVisitor.addFactory(this);
			QVTcoreBaseToStringVisitor.FACTORY.getClass();
		}

		@Override
		public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
			return new QVTcoreToStringVisitor(s);
		}

		@Override
		public @NonNull EPackage getEPackage() {
			QVTcorePackage eInstance = QVTcorePackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public static ToStringVisitor.@NonNull Factory FACTORY = new QVTcoreToStringFactory();

	public QVTcoreToStringVisitor(@NonNull StringBuilder s) {
		super(s);
	}

	@Override
	public String visitCoreModel(@NonNull CoreModel object) {
		return visitModel(object);
	}

	@Override
	public String visitMapping(@NonNull Mapping object) {
		append("mapping ");
		appendName(object);
		return null;
	}
}
