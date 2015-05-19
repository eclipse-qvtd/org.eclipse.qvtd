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
package org.eclipse.qvtd.xtext.qvtrelation.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.essentialocl.attributes.NavigatingArgCSAttribution;
import org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS;

public class QVTrelationNavigatingArgCSAttribution extends NavigatingArgCSAttribution
{
	public static final QVTrelationNavigatingArgCSAttribution INSTANCE = new QVTrelationNavigatingArgCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		NavigatingArgCS fromArgument = (NavigatingArgCS)target;
		RoundBracketedClauseCS csRoundBracketedClause = fromArgument.getOwningRoundBracketedClause();
		AbstractNameExpCS targetElement = csRoundBracketedClause.getOwningNameExp();
		assert targetElement != null;
		OCLExpression pivot = PivotUtil.getPivot(OCLExpression.class, targetElement);
		if (pivot instanceof RelationCallExp) {
			int index = csRoundBracketedClause.getOwnedArguments().indexOf(fromArgument);
			if (index >= 0) {
				for (EObject eObject = csRoundBracketedClause; eObject != null; eObject = eObject.eContainer()) {
					if (eObject instanceof RelationCS) {
						Relation relation = PivotUtil.getPivot(Relation.class, (RelationCS)eObject);
						if (relation != null) {
							int firstIndex = 0;
							for (Domain asDomain : relation.getDomain()) {
								if (asDomain instanceof RelationDomain) {
									List<DomainPattern> asPatterns = ((RelationDomain)asDomain).getPattern();
									int lastIndex = firstIndex + asPatterns.size();
									if ((firstIndex <= index) && (index < lastIndex)) {
										for (DomainPattern asPattern : asPatterns) {
											if (asPattern != null) {
												environmentView.addNamedElements(asPattern.getBindsTo());
											}
										}
										if (environmentView.hasFinalResult()) {
											return null;
										}
									}
									firstIndex = lastIndex;
								}
							}
						}
						break;
					}
				}
			}
		}
		return super.computeLookup(target, environmentView, scopeView);
	}
}
