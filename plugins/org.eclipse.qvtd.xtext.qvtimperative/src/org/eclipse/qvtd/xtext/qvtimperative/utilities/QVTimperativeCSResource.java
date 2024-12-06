/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.utilities;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.xtext.base.as2cs.AS2CS;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.xtext.qvtbase.utilities.QVTbaseCSResource;
import org.eclipse.qvtd.xtext.qvtimperative.as2cs.QVTimperativeAS2CS;
import org.eclipse.qvtd.xtext.qvtimperative.cs2as.QVTimperativeCS2AS;

public class QVTimperativeCSResource extends QVTbaseCSResource
{
	/**
	 * A QVTimperativeCSResourceLoadFactory supports creation of a BaseCSXMIResource that supports persistence of the CS model directly as XMI
	 * rather than exploiting Xtext to serialize to / parse from a text file.
	 */
	public static class QVTimperativeCSResourceLoadFactory extends OCLCSResourceLoadFactory
	{
		public QVTimperativeCSResourceLoadFactory() {
			super(QVTimperativeASResourceFactory.getInstance());
		}
	}

	@Override
	public @NonNull AS2CS createAS2CS(@NonNull Map<@NonNull ? extends BaseCSResource, @NonNull ? extends ASResource> cs2asResourceMap,
			@NonNull EnvironmentFactoryInternal environmentFactory) {
		return new QVTimperativeAS2CS(cs2asResourceMap, environmentFactory);
	}

	@Override
	public @NonNull CS2AS createCS2AS(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull ASResource asResource) {
		return new QVTimperativeCS2AS(environmentFactory, this, asResource);
	}

	@Override
	public @NonNull String getASContentType() {
		return QVTimperativePackage.eCONTENT_TYPE;
	}

	@Override
	public @NonNull ASResourceFactory getASResourceFactory() {
		return QVTimperativeASResourceFactory.getInstance();
	}

	@Override
	public @NonNull CS2AS getCS2AS() {
		EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.findEnvironmentFactory(this);
		if (environmentFactory == null) {
			environmentFactory = new QVTiEnvironmentFactory(BasicProjectManager.createDefaultProjectManager(), getResourceSet());
		}
		return super.getCS2AS();
	}

	@Override
	public @NonNull String getEditorName() {
		return "QVT Imperative";
	}

	@Override
	public @Nullable NamedElement isPathable(@NonNull EObject element) {
		if (element instanceof Mapping) {
			return (Mapping)element;
		}
		else if (element instanceof VariableStatement) {	// NewStatement, PredicateVariable, OutConnectionVariable
			return (VariableStatement)element;
		}
		else if (element instanceof MappingParameter) {
			return (MappingParameter)element;
		}
		else if (element instanceof LoopVariable) {
			return (LoopVariable)element;
		}
		else {
			return super.isPathable(element);
		}
	}
}
