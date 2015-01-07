/*******************************************************************************
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.utilities;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.xtext.base.as2cs.AS2CS;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.xtext.qvtcore.as2cs.QVTcoreAS2CS;
import org.eclipse.qvtd.xtext.qvtcore.cs2as.QVTcoreCS2AS;

public class QVTcoreCSResource extends EssentialOCLCSResource
{
	@Override
	public @NonNull CS2AS createCS2AS(
			@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap,
			@NonNull EnvironmentFactoryInternal environmentFactory) {
		return new QVTcoreCS2AS(cs2asResourceMap, environmentFactory);
	}

	@Override
	public @NonNull AS2CS createAS2CS(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap,
			@NonNull EnvironmentFactoryInternal environmentFactory) {
		return new QVTcoreAS2CS(cs2asResourceMap, environmentFactory);
	}

	@Override
	public @NonNull String getASContentType() {
		return QVTcorePackage.eCONTENT_TYPE;
	}

	@Override
	@SuppressWarnings("null")
	public @NonNull URI getASURI(@NonNull URI csURI) {
		return URI.createURI(csURI.toString() + "as");
	}

	@Override
	public @NonNull String getEditorName() {
		return "QVT Core";
	}

	@Override
	public @Nullable NamedElement isPathable(@NonNull EObject element) {
		if (element instanceof FunctionParameter) {
			return (FunctionParameter)element;
		}
		else if (element instanceof RealizedVariable) {
			return (RealizedVariable)element;
		}
		else if ((element instanceof Variable) && (element.eContainer() instanceof CorePattern)) {
			return (Variable)element;
		}
		else {
			return super.isPathable(element);
		}
	}
}
