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
package org.eclipse.qvtd.pivot.qvtrelation.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.AbstractPivotSaver;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseSaver;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.util.AbstractNullQVTrelationVisitor;
import org.eclipse.qvtd.pivot.qvttemplate.utilities.QVTtemplateSaver;

/**
 * PivotSaver ensures that all references to specialized types are terminated
 * by local copies of the specialization.
 */
public class QVTrelationSaver extends QVTtemplateSaver
{
	private static final class Factory implements AbstractPivotSaver.Factory
	{
		private Factory() {
			QVTbaseSaver.FACTORY.getClass();
			addFactory(this);
		}

		public LocateVisitor createLocateVisitor(AbstractPivotSaver saver) {
			return new LocateVisitor(saver);
		}

		public ResolveVisitor createResolveVisitor(AbstractPivotSaver saver) {
			return new ResolveVisitor(saver);
		}

		public EPackage getEPackage() {
			return QVTrelationPackage.eINSTANCE;
		}
	}

	public static AbstractPivotSaver.Factory FACTORY = new Factory();
	
	/**
	 * LocateVisitor locates references to shared specializations, so that 
	 * local copies can be created and then replaced by the ResolveVisitor.
	 */
	public static class LocateVisitor extends AbstractNullQVTrelationVisitor<Object, AbstractPivotSaver> implements AbstractPivotSaver.LocateVisitor
	{
		protected LocateVisitor(AbstractPivotSaver context) {
			super(context);
		}
		public Object visiting(Visitable visitable) {
			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for PivotSaver Locate pass");
		}
	}
	
	/**
	 * ResolveVisitor converts references to shared specializations
	 * to references to local copies.
	 */
	public static class ResolveVisitor extends AbstractNullQVTrelationVisitor<Object, AbstractPivotSaver> implements AbstractPivotSaver.ResolveVisitor
	{
		protected ResolveVisitor(AbstractPivotSaver saver) {
			super(saver);
		}
		public Object visiting(Visitable visitable) {
			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for PivotSaver Resolve pass");
		}
	}
	
	protected QVTrelationSaver(Resource resource) {
		super(resource);
	}
}