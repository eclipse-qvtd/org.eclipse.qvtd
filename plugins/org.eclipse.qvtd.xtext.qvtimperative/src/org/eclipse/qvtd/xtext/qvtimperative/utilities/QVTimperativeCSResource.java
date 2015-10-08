/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.utilities;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.xtext.base.as2cs.AS2CS;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeASResourceFactory;
import org.eclipse.qvtd.xtext.qvtimperative.as2cs.QVTimperativeAS2CS;
import org.eclipse.qvtd.xtext.qvtimperative.cs2as.QVTimperativeCS2AS;

public class QVTimperativeCSResource extends EssentialOCLCSResource
{
	@Override
	public @NonNull AS2CS createAS2CS(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap,
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
	@SuppressWarnings("null")
	public @NonNull URI getASURI(@NonNull URI csURI) {
		return URI.createURI(csURI.toString() + "as");
	}

	@Override
	public @NonNull String getEditorName() {
		return "QVT Imperative";
	}

	@Override
	public @Nullable NamedElement isPathable(@NonNull EObject element) {
		if (element instanceof FunctionParameter) {
			return (FunctionParameter)element;
		}
		else if (element instanceof Mapping) {
			return (Mapping)element;
		}
		else if (element instanceof RealizedVariable) {
			return (RealizedVariable)element;
		}
		else if ((element instanceof Variable) && (element.eContainer() instanceof CorePattern)) {
			return (Variable)element;
		}
		else if ((element instanceof Variable) && (element.eContainer() instanceof MappingLoop)) {
			return (Variable)element;
		}
		else if ((element instanceof Variable) && (element.eContainer() instanceof Transformation)) {
			return (Variable)element;
		}
		else if ((element instanceof Variable) && (element.eContainer() instanceof TypedModel)) {
			return (Variable)element;
		}
		else {
			return super.isPathable(element);
		}
	}
}
