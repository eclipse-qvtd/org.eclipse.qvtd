/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler.internal.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.CG2StringVisitor;
import org.eclipse.qvtd.cs2as.compiler.cgmodel.CS2ASCGPackage;
import org.eclipse.qvtd.cs2as.compiler.cgmodel.util.AbstractCS2ASCGCG2StringVisitor;

public class CS2ASCG2StringVisitor extends AbstractCS2ASCGCG2StringVisitor
{
	private static final class MyFactory extends AbstractFactory
	{
		private MyFactory() {
			CG2StringVisitor.addFactory(this);
		}

		@Override
		public @NonNull CG2StringVisitor createToStringVisitor() {
			return new CS2ASCG2StringVisitor();
		}

		@Override
		public @NonNull EPackage getEPackage() {
			CS2ASCGPackage eInstance = CS2ASCGPackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public static CS2ASCG2StringVisitor.@NonNull Factory FACTORY = new MyFactory();

	public CS2ASCG2StringVisitor() {}
}
