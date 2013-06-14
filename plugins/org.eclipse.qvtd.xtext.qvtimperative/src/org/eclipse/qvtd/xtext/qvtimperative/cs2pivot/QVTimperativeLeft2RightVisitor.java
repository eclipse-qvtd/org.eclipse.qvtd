/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: QVTcoreLeft2RightVisitor.java,v 1.10 2011/05/23 05:51:25 ewillink Exp $
 */
package org.eclipse.qvtd.xtext.qvtimperative.cs2pivot;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyCallExp;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;

public class QVTimperativeLeft2RightVisitor extends AbstractQVTimperativeLeft2RightVisitor
{
	public QVTimperativeLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}
	
	@Override	// FIXME promote replication to OCL
	protected @Nullable OCLExpression resolvePropertyCallExp(@NonNull NameExpCS csNameExp, @NonNull Property property) {
		CallExp outerExpression = null;
		OCLExpression source = resolveNavigationSource(csNameExp, property);
		if (source != null) {
			PropertyCallExp innerExpression = refreshPropertyCallExp(csNameExp, property);
			if (innerExpression != null) {
				innerExpression.setReferredProperty(property);
				resolveAtPre(csNameExp, innerExpression);
				Map<TemplateParameter, ParameterableElement> templateBindings = new HashMap<TemplateParameter, ParameterableElement>();
				Type sourceType = source.getType();
				if (sourceType != null) {
					if (property.isStatic() && (sourceType instanceof Metaclass)) {
						sourceType = ((Metaclass)sourceType).getInstanceType();
					}
					templateBindings.put(null, sourceType);		// Use the null key to pass OclSelf without creating an object
				}
				PivotUtil.getAllTemplateParameterSubstitutions(templateBindings, sourceType);
				Type returnType = null;
				Type behavioralType = PivotUtil.getType(property);
				if (behavioralType != null) {
					returnType = metaModelManager.getSpecializedType(behavioralType, templateBindings);
					if (property.isStatic() && (behavioralType.getOwningTemplateParameter() != null)) {
						returnType = metaModelManager.getMetaclass(returnType);
					}
				}
				context.setType(innerExpression, returnType, property.isRequired());
				outerExpression = resolveNavigationFeature(csNameExp, source, property, innerExpression);
				if (outerExpression != innerExpression) {
					resolveOperationReturnType(outerExpression);
				}
			}
		}
		return outerExpression;
	}

	protected PropertyCallExp refreshPropertyCallExp(@NonNull NameExpCS csNameExp, @NonNull Property property) {
		Property oppositeProperty = property.getOpposite();
		if (property.isImplicit() && (oppositeProperty != null) && QVTimperativeCS2Pivot.isMiddle(oppositeProperty.getOwningType(), csNameExp)) {
			return context.refreshModelElement(MiddlePropertyCallExp.class,
				QVTimperativePackage.Literals.MIDDLE_PROPERTY_CALL_EXP, csNameExp);
		}
		else {
			return context.refreshModelElement(PropertyCallExp.class, PivotPackage.Literals.PROPERTY_CALL_EXP, csNameExp);
		}
	}
}