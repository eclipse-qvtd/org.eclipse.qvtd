/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.util.AbstractVisitor;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBasePrettyPrintVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

public class QVTimperativePrettyPrintVisitor extends QVTcoreBasePrettyPrintVisitor implements QVTimperativeVisitor<Object>
{	
	private static final class Factory implements PrettyPrinter.Factory
	{
		private Factory() {
			QVTcoreBasePrettyPrintVisitor.FACTORY.getClass();
			PrettyPrinter.addFactory(QVTimperativePackage.eINSTANCE, this);
		}

		public @NonNull AbstractVisitor<Object, PrettyPrinter> createPrettyPrintVisitor(@NonNull PrettyPrinter printer) {
			return new QVTimperativePrettyPrintVisitor(printer);
		}
	}

	public static @NonNull PrettyPrinter.Factory FACTORY = new Factory();

	public QVTimperativePrettyPrintVisitor(@NonNull PrettyPrinter context) {
		super(context);
	}

	public Object visitImperativeModel(@NonNull ImperativeModel object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitMapping(@NonNull Mapping object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitMappingCall(@NonNull MappingCall object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitMappingCallBinding(@NonNull MappingCallBinding object) {
		// TODO Auto-generated method stub
		return null;
	}
}
