/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.as2cs;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.xtext.base.as2cs.AS2CS;
import org.eclipse.ocl.xtext.base.as2cs.AS2CSConversion;
import org.eclipse.ocl.xtext.base.as2cs.BaseDeclarationVisitor;
import org.eclipse.ocl.xtext.base.as2cs.BaseReferenceVisitor;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.essentialocl.as2cs.EssentialOCLAS2CS;
import org.eclipse.ocl.xtext.essentialocl.as2cs.EssentialOCLReferenceVisitor;

public class QVTcoreAS2CS extends EssentialOCLAS2CS
{
	private static final class Factory extends AbstractFactory
	{
		private static AS2CS.@NonNull Factory INSTANCE = new Factory();

		@Override
		public @NonNull QVTcoreDeclarationVisitor createDeclarationVisitor(@NonNull AS2CSConversion converter) {
			return new QVTcoreDeclarationVisitor(converter);
		}

		@Override
		public @NonNull BaseReferenceVisitor createReferenceVisitor(@NonNull AS2CSConversion converter, @Nullable Namespace scope) {
			return new EssentialOCLReferenceVisitor(converter, scope);
		}

		@SuppressWarnings("null")
		@Override
		public @NonNull EClass @NonNull [] getEClasses() {
			return new @NonNull EClass[] {
				PivotPackage.Literals.CLASS,
				PivotPackage.Literals.CONSTRAINT,
				PivotPackage.Literals.OPERATION,
				PivotPackage.Literals.PACKAGE,
				PivotPackage.Literals.PARAMETER,
				PivotPackage.Literals.PROPERTY,
				PivotPackage.Literals.TYPE
			};
		}
	}

	public QVTcoreAS2CS(@NonNull Map<@NonNull ? extends BaseCSResource, @NonNull ? extends ASResource> cs2asResourceMap, @NonNull EnvironmentFactoryInternal environmentFactory) {
		super(cs2asResourceMap, environmentFactory);
		addFactory(Factory.INSTANCE);
		for (BaseCSResource csResource : cs2asResourceMap.keySet()) {
			assert csResource != null;
			environmentFactory.adapt(csResource);
		}
	}

	@Override
	public @NonNull BaseDeclarationVisitor createDefaultDeclarationVisitor(@NonNull AS2CSConversion converter) {
		return new QVTcoreDeclarationVisitor(converter);
	}

	@Override
	public @NonNull BaseReferenceVisitor createDefaultReferenceVisitor(@NonNull AS2CSConversion converter) {
		return new EssentialOCLReferenceVisitor(converter, null);
	}
}
