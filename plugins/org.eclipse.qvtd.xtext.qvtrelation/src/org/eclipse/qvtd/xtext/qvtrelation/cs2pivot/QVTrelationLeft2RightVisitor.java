/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtrelation.cs2pivot;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS;

public class QVTrelationLeft2RightVisitor extends AbstractQVTrelationLeft2RightVisitor
{
	public QVTrelationLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	protected VariableDeclaration getImplicitSource(@NonNull ModelElementCS csExp, @NonNull Feature feature) {
		if (feature instanceof Function) {
			return null;
		}
		return super.getImplicitSource(csExp, feature);
	}

	@Override
	protected OCLExpression resolveUnknownOperation(@NonNull NamedExpCS csNamedExp) {
		NamedElement namedElement = csNamedExp.getNamedElement();
		if (namedElement instanceof Relation) {
			Relation relation = (Relation)namedElement;
//			Operation baseOperation = metaModelManager.resolveBaseOperation(operation);
//			OCLExpression source = resolveNavigationSource(csNavigatingExp, operation);
//			CallExp outerExpression;
//			CallExp innerExpression;
			RelationCallExp relationCallExp = context.refreshModelElement(RelationCallExp.class, QVTrelationPackage.Literals.RELATION_CALL_EXP, csNamedExp);
			if (relationCallExp != null) {
				relationCallExp.setReferredRelation(relation);
				context.installPivotUsage(csNamedExp, relationCallExp);		
//				innerExpression = operationCallExp;
//				outerExpression = resolveNavigationFeature(csNavigatingExp, source, baseOperation, innerExpression);
//				resolveOperationArguments(csNavigatingExp, source, operation, operationCallExp);
//				resolveOperationReturnType(innerExpression);
//				if (outerExpression != innerExpression) {
//					resolveOperationReturnType(outerExpression);
//				}
//				return checkImplementation(csNavigatingExp, operation, innerExpression, outerExpression);
				return relationCallExp;
			}
		}
		return super.resolveUnknownOperation(csNamedExp);
	}

	@Override
	public Element visitCollectionTemplateCS(@NonNull CollectionTemplateCS csElement) {
		return PivotUtil.getPivot(CollectionTemplateExp.class, csElement);
	}

	@Override
	public Element visitObjectTemplateCS(@NonNull ObjectTemplateCS csElement) {
		return PivotUtil.getPivot(ObjectTemplateExp.class, csElement);
	}
}