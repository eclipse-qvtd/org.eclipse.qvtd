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
 * $Id: PivotSaver.java,v 1.8 2011/04/25 09:49:15 ewillink Exp $
 */
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.AbstractPivotSaver;
import org.eclipse.ocl.examples.pivot.utilities.PivotSaver;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.util.AbstractNullQVTbaseVisitor;

/**
 * PivotSaver ensures that all references to specialized types are terminated
 * by local copies of the specialization.
 */
public class QVTbaseSaver extends PivotSaver
{
	private static final class Factory implements AbstractPivotSaver.Factory
	{
		private Factory() {
			PivotSaver.FACTORY.getClass();
			addFactory(this);
		}

		public @NonNull LocateVisitor createLocateVisitor(@NonNull AbstractPivotSaver saver) {
			return new LocateVisitor(saver);
		}

		public @NonNull ResolveVisitor createResolveVisitor(@NonNull AbstractPivotSaver saver) {
			return new ResolveVisitor(saver);
		}

		@SuppressWarnings("null")
		public @NonNull EPackage getEPackage() {
			return QVTbasePackage.eINSTANCE;
		}
	}

	public static @NonNull AbstractPivotSaver.Factory FACTORY = new Factory();
	
	/**
	 * LocateVisitor locates references to shared specializations, so that 
	 * local copies can be created and then replaced by the ResolveVisitor.
	 */
	public static class LocateVisitor extends AbstractNullQVTbaseVisitor<Object, AbstractPivotSaver> implements AbstractPivotSaver.LocateVisitor
	{
		protected LocateVisitor(@NonNull AbstractPivotSaver context) {
			super(context);
		}
		public Object visiting(@NonNull Visitable visitable) {
			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for PivotSaver Locate pass");
		}
	}
	
	/**
	 * ResolveVisitor converts references to shared specializations
	 * to references to local copies.
	 */
	public static class ResolveVisitor extends AbstractNullQVTbaseVisitor<Object, AbstractPivotSaver> implements AbstractPivotSaver.ResolveVisitor
	{
		protected ResolveVisitor(@NonNull AbstractPivotSaver saver) {
			super(saver);
		}
		public Object visiting(@NonNull Visitable visitable) {
			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for PivotSaver Resolve pass");
		}
	}
	
	protected QVTbaseSaver(Resource resource) {
		super(resource);
	}
}