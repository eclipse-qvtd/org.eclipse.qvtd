/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Horacio Hoyos - initial research
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtm2qvtp;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.TreeIterable;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 * QVTm2QVTp is now a compativility NO-OP. Fuctionality moved to a QVTs2QVTs rewrite.
 */
public class QVTm2QVTp
{
	public static final @NonNull TracingOption PARTITIONING = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvtp/partitioning");

	public void transform(@NonNull Resource source, @NonNull Resource target) throws IOException {
		List<@NonNull EObject> sourceContents = source.getContents();
		Collection<@NonNull EObject> targetContents = EcoreUtil.copyAll(sourceContents);
		CoreModel targetModel = (CoreModel)targetContents.iterator().next();
		targetModel.setExternalURI(((CoreModel)sourceContents.iterator().next()).getExternalURI().replace(".qvtm.qvtc", ".qvtp.qvtc"));
		target.getContents().addAll(targetContents);
		for (EObject eObject : new TreeIterable(targetModel, true)) {
			if (eObject instanceof TypedModel) {
				TypedModel typedModel = (TypedModel) eObject;
				if (typedModel.getName() == null) {
					typedModel.setName(QVTimperativeUtil.MIDDLE_DOMAIN_NAME);
				}
			}
		}
	}
}
