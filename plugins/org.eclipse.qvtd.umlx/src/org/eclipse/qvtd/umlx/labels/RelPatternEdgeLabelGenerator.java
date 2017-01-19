/*******************************************************************************
 * Copyright (c) 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.umlx.labels;

import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;
import org.eclipse.qvtd.umlx.RelPatternEdge;

public final class RelPatternEdgeLabelGenerator extends AbstractLabelGenerator<RelPatternEdge>
{
	public static void initialize(@NonNull Registry registry) {
		registry.install(EGenericType.class, new RelPatternEdgeLabelGenerator());
	}

	public RelPatternEdgeLabelGenerator() {
		super(RelPatternEdge.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull RelPatternEdge object) {
		//		EClassifier eClassifier = object.getEClassifier();
		//		if (eClassifier != null) {
		//			labelBuilder.appendObject(eClassifier);
		//		}
		//		else {
		//			ETypeParameter eTypeParameter = object.getETypeParameter();
		//			labelBuilder.appendObject(eTypeParameter);
		//		}
		//		List<EGenericType> eTypeArguments = object.getETypeArguments();
		//		int size = eTypeArguments.size();
		//		if (size > 0) {
		labelBuilder.appendString("<");
		//			for (int i = 0; i < size; i++) {
		//				if (i > 0) {
		//					labelBuilder.appendString(",");
		//				}
		//				labelBuilder.appendObject(eTypeArguments.get(0));
		//			}
		labelBuilder.appendString(">");
		//		}
	}
}