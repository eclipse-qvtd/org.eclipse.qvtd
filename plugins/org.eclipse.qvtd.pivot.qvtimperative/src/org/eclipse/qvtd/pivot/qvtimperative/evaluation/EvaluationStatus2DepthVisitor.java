/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationElement;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.util.AbstractExtendingEvaluationStatusVisitor;

public class EvaluationStatus2DepthVisitor extends AbstractExtendingEvaluationStatusVisitor<@NonNull Integer, Object>
{
	public static final @NonNull EvaluationStatus2DepthVisitor INSTANCE = new EvaluationStatus2DepthVisitor(EvaluationStatus2DepthVisitor.class);
	
	private EvaluationStatus2DepthVisitor(@NonNull Object context) {
		super(context);
	}

	@Override
	public @NonNull Integer visiting(@NonNull EvaluationElement visitable) {
		throw new UnsupportedOperationException("Unsupported visit" + visitable.eClass().getName() + " for " + getClass().getSimpleName());
	}

	@Override
	public @NonNull Integer visitAssociationStatus(@NonNull AssociationStatus object) {
		Integer depth = object.getDepth();
		if (depth == null) {
			depth = 0;
			for (ClassStatus classStatus : object.getFromClassStatuses()) {
				if (classStatus != null) {
					Integer thisDepth = visit(classStatus);
					if (thisDepth > depth) {
						depth = thisDepth;
					}
				}
			}
			for (ClassStatus classStatus : object.getToClassStatuses()) {
				if (classStatus != null) {
					Integer thisDepth = visit(classStatus);
					if (thisDepth > depth) {
						depth = thisDepth;
					}
				}
			}
			object.setDepth(++depth);
		}
		return depth;
	}

	@Override
	public @NonNull Integer visitAttributeStatus(@NonNull AttributeStatus object) {
		Integer depth = object.getDepth();
		if (depth == null) {
			ClassStatus classStatus = object.getOwningClassStatus();
			if (classStatus != null) {
				depth = visit(classStatus);
				object.setDepth(++depth);
			}
			else depth = -1;
		}
		return depth;
	}

	@Override
	public @NonNull Integer visitClassStatus(@NonNull ClassStatus object) {
		Integer depth = object.getDepth();
		if (depth == null) {
			depth = 0;
			for (MappingStatus mappingStatus : object.getSources()) {
				if (mappingStatus != null) {
					Integer thisDepth = visit(mappingStatus);
					if (thisDepth > depth) {
						depth = thisDepth;
					}
				}
			}
			object.setDepth(++depth);
		}
		return depth;
	}

	@Override
	public @NonNull Integer visitMappingStatus(@NonNull MappingStatus object) {
		Integer depth = object.getDepth();
		if (depth == null) {
			depth = 0;
			for (ElementStatus inputStatus : object.getInputs()) {
				if (inputStatus != null) {
					Integer thisDepth = visit(inputStatus);
					if (thisDepth > depth) {
						depth = thisDepth;
					}
				}
			}
			object.setDepth(++depth);
		}
		return depth;
	}
}
