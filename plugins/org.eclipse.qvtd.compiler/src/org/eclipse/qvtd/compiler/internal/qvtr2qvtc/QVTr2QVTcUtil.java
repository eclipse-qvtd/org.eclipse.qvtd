/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

public class QVTr2QVTcUtil
{
	/**
	 * Return the variables to which pattern variables are bound by a relation domain. This is a prototype
	 * for the resolution of the lack of specification / implementation of RelationDomain::bindsTo.
	 *
	 * root variables are bound
	 * ObjectTemplateExp bound variables are bound
	 * CollectionTemplateExp bound variables, members but not rest are bound
	 */
	public static @NonNull Iterable<@NonNull Variable> getRelationDomainBindsTo(@NonNull RelationDomain rDomain) {
		List<@NonNull Variable> bindsTo = new ArrayList<>();
		for (@NonNull Pattern rPattern : ClassUtil.nullFree(rDomain.getPattern())) {
			getRelationDomainBindsTo(bindsTo, ClassUtil.nonNullState(((DomainPattern)rPattern).getTemplateExpression()));
		}
		return bindsTo;
	}
	private static void getRelationDomainBindsTo(@NonNull List<@NonNull Variable> bindsTo, @NonNull OCLExpression oclExpression) {
		if (oclExpression instanceof ObjectTemplateExp) {
			ObjectTemplateExp objectTemplateExp = (ObjectTemplateExp)oclExpression;
			bindsTo.add(ClassUtil.nonNullState(objectTemplateExp.getBindsTo()));
			for (@NonNull PropertyTemplateItem part : ClassUtil.nullFree(objectTemplateExp.getPart())) {
				getRelationDomainBindsTo(bindsTo, ClassUtil.nonNullState(part.getValue()));
			}
		}
		else if (oclExpression instanceof CollectionTemplateExp) {
			CollectionTemplateExp collectionTemplateExp = (CollectionTemplateExp)oclExpression;
			bindsTo.add(ClassUtil.nonNullState(collectionTemplateExp.getBindsTo()));
			for (@NonNull OCLExpression member : ClassUtil.nullFree(collectionTemplateExp.getMember())) {
				if (member instanceof VariableExp) {
					bindsTo.add((Variable)ClassUtil.nonNullState(((VariableExp)member).getReferredVariable()));
				}
				else {
					getRelationDomainBindsTo(bindsTo, ClassUtil.nonNullState(member));
				}
			}
		}
	}
}
