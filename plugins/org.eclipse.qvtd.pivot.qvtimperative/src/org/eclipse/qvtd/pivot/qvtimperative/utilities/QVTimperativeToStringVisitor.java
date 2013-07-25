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
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseToStringVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyCallExp;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 */
public class QVTimperativeToStringVisitor extends QVTcoreBaseToStringVisitor implements QVTimperativeVisitor<String>
{
	protected static class QVTimperativeToStringFactory extends QVTcoreBaseToStringFactory
	{
		protected QVTimperativeToStringFactory() {
//			FACTORY.getClass();
		}

		@Override
		public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
			return new QVTimperativeToStringVisitor(s, getClass());
		}

		@Override
		@SuppressWarnings("null")
		public @NonNull EPackage getEPackage() {
			return QVTimperativePackage.eINSTANCE;
		}
	}

	public static @NonNull ToStringVisitor.Factory FACTORY = new QVTimperativeToStringFactory();

	protected QVTimperativeToStringVisitor(@NonNull StringBuilder s, /*@NonNull*/ Class<? extends ToStringVisitor.Factory> factoryClass) {
		super(s, factoryClass);
	}

	public @Nullable String visitImperativeModel(@NonNull ImperativeModel object) {
		return visitRoot(object);
	}

	public @Nullable String visitMapping(@NonNull Mapping object) {
		append("mapping ");
		appendName(object);
		return null;
	}

	public @Nullable String visitMappingCall(@NonNull MappingCall object) {
		append("mappingCall ");
		appendName(object.getReferredMapping());
		return null;
	}

	public @Nullable String visitMappingCallBinding(@NonNull MappingCallBinding object) {
		appendName(object.getBoundVariable());
		append(" := ");
		appendName(object.getValue());
		return null;
	}

	public @Nullable String visitMiddlePropertyAssignment(@NonNull MiddlePropertyAssignment object) {
		return visitPropertyAssignment(object);
	}

	public @Nullable String visitMiddlePropertyCallExp(@NonNull MiddlePropertyCallExp object) {
		return visitPropertyCallExp(object);
	}
}
