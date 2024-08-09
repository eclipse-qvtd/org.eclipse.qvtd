/*******************************************************************************
 * Copyright (c) 2017, 2024 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.umlx.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLCSResource;

public class ContextualContextCSAttribution extends org.eclipse.ocl.xtext.essentialocl.attributes.ContextCSAttribution
{
	public static final @NonNull ContextualContextCSAttribution INSTANCE = new ContextualContextCSAttribution();

	@Override
	public @Nullable ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		ScopeView computeLookup = super.computeLookup(target, environmentView, scopeView);
		//
		//	Last, last alternative. If nothing found try the parser context's context.
		//
		if (!environmentView.hasFinalResult()) {// && ((computeLookup == null) || (computeLookup.getTarget() == null))) {
			if (target.eContainer() == null) {
				Resource eResource = target.eResource();
				if (eResource instanceof EssentialOCLCSResource) {
					EssentialOCLCSResource csResource = (EssentialOCLCSResource)eResource;
					ParserContext parserContext = csResource.getParserContext();
					if (parserContext != null) {
						Element asContext = parserContext.getElementContext();
						if ((asContext != null) && (asContext.eResource() != null) && !(asContext instanceof InvalidType)) {
							environmentView.computeLookups(asContext, null); //PivotUtil.getPivot(Element.class, scopeView.getChild());
						}
						if (!environmentView.hasFinalResult()) {
							return scopeView.getParent();
						}
						return scopeView.getParent();

					}
				}
			}
		}
		return computeLookup;
	}
}