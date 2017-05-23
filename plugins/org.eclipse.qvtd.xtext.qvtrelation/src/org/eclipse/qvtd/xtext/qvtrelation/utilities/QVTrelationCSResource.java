/*******************************************************************************
 * Copyright (c) 2010, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.utilities;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.ParameterVariable;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.xtext.base.as2cs.AS2CS;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationASResourceFactory;
import org.eclipse.qvtd.xtext.qvtbase.utilities.QVTbaseCSResource;
import org.eclipse.qvtd.xtext.qvtrelation.as2cs.QVTrelationAS2CS;
import org.eclipse.qvtd.xtext.qvtrelation.cs2as.QVTrelationCS2AS;

public class QVTrelationCSResource extends QVTbaseCSResource
{
	@Override
	public @NonNull AS2CS createAS2CS(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap,
			@NonNull EnvironmentFactoryInternal environmentFactory) {
		return new QVTrelationAS2CS(cs2asResourceMap, environmentFactory);
	}

	@Override
	public @NonNull CS2AS createCS2AS(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull ASResource asResource) {
		return new QVTrelationCS2AS(environmentFactory, this, asResource);
	}

	@Override
	public @NonNull String getASContentType() {
		return QVTrelationPackage.eCONTENT_TYPE;
	}

	@Override
	public @NonNull ASResourceFactory getASResourceFactory() {
		return QVTrelationASResourceFactory.getInstance();
	}

	@Override
	public @NonNull CS2AS getCS2AS() {
		EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.findEnvironmentFactory(this);
		if (environmentFactory == null) {
			environmentFactory = new QVTrEnvironmentFactory(BasicProjectManager.createDefaultProjectManager(), getResourceSet());
		}
		return super.getCS2AS();
	}

	@Override
	public @NonNull String getEditorName() {
		return "QVT Relation";
	}

	@Override
	public @Nullable NamedElement isPathable(@NonNull EObject element) {
		if (element instanceof FunctionParameter) {
			return (FunctionParameter)element;
		}
		else if (element instanceof Relation) {
			return (Relation)element;
		}
		else if (element instanceof ParameterVariable) {
			return (ParameterVariable)element;
		}
		else if (element instanceof SharedVariable) {
			return (SharedVariable)element;
		}
		else if (element instanceof TemplateVariable) {
			return (TemplateVariable)element;
		}
		//		else if ((element instanceof Variable) && (element.eContainer() instanceof Transformation)) {
		//			return (Variable)element;
		//		}
		//		else if ((element instanceof Variable) && (element.eContainer() instanceof TypedModel)) {
		//			return (Variable)element;
		//		}
		else {
			return super.isPathable(element);
		}
	}
}
