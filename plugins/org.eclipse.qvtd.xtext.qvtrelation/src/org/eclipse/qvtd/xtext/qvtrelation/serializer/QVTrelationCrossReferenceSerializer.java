/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.xtext.base.serializer.BaseCrossReferenceSerializer;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;
import org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;

@SuppressWarnings("restriction")
public class QVTrelationCrossReferenceSerializer extends BaseCrossReferenceSerializer
{
	@Override
	protected String getCrossReferenceNameFromScope(EObject semanticObject,
			CrossReference crossref, EObject target, IScope scope, Acceptor errors) {
		if (semanticObject instanceof ElementTemplateCS) {
			Element asElement = ((ElementTemplateCS)semanticObject).getPivot();
			if (asElement instanceof VariableExp) {
				asElement = ((VariableExp)asElement).getReferredVariable();
			}
			if ((asElement instanceof SharedVariable) && ((SharedVariable)asElement).isIsImplicit()) {
				return "_";
			}
		}
		return super.getCrossReferenceNameFromScope(semanticObject, crossref, target, scope, errors);
	}
}
