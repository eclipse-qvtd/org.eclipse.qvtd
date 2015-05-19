/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.attributes;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;

public class RelationCallExpAttribution extends AbstractAttribution
{
	public static final RelationCallExpAttribution INSTANCE = new RelationCallExpAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		RelationCallExp targetElement = (RelationCallExp)target;
		EObject child = scopeView.getChild();
		int index = targetElement.getArgument().indexOf(child);
		if (index >= 0) {
			for (EObject eObject = targetElement; eObject != null; eObject = eObject.eContainer()) {
				if (eObject instanceof Relation) {
					List<Domain> domains = ((Relation)eObject).getDomain();
					if (index < domains.size()) {
						RelationDomain relationDomain = (RelationDomain)domains.get(index);
						if (relationDomain != null) {
							for (DomainPattern pattern : relationDomain.getPattern()) {
								if (pattern != null) {
									environmentView.addNamedElements(pattern.getBindsTo());
								}
							}
							if (environmentView.hasFinalResult()) {
								return null;
							}
						}
					}
					break;
				}
			}
		}
		return scopeView.getParent();
	}
}
