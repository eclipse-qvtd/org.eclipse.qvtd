/*******************************************************************************
 * Copyright (c) 2014, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.analyzer;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculatePart;
import org.eclipse.qvtd.codegen.qvticgmodel.util.AbstractQVTiReferencesVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;

/**
 * The ReferencesVisitor compute a list of objects referenced by (but not contained by or containing) the visited object
 * that contribute to that objects identity. The computed list may contain null elements to ensure that the returned lists
 * by two different objects exhibit positioanl equivalence.
 */
public class QVTiReferencesVisitor extends AbstractQVTiReferencesVisitor
{
	public static final @NonNull QVTiReferencesVisitor INSTANCE = new QVTiReferencesVisitor(new Object());

	protected QVTiReferencesVisitor(@Nullable Object context) {
		super(context);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGMappingCall(@NonNull CGMappingCall cgMappingCall) {
		List<@Nullable Object> elements = super.visitCGMappingCall(cgMappingCall);
		elements.add(QVTiCGUtil.getReferredMapping(cgMappingCall));
		return elements;
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGPropertyAssignment(@NonNull CGPropertyAssignment cgElement) {
		List<@Nullable Object> elements = super.visitCGPropertyAssignment(cgElement);
		elements.add(cgElement.getReferredProperty());
		return elements;
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGSpeculatePart(@NonNull CGSpeculatePart cgElement) {
		List<@Nullable Object> elements = super.visitCGSpeculatePart(cgElement);
		elements.add(cgElement.getObjectExp());
		return elements;
	}
}