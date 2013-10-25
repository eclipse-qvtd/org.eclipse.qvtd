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
 * $Id: CompleteOCLPreOrderVisitor.java,v 1.11 2011/05/20 15:26:50 ewillink Exp $
 */
package org.eclipse.qvtd.xtext.qvtrelation.cs2as;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2as.PivotDependency;
import org.eclipse.ocl.examples.xtext.base.cs2as.SingleContinuation;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.CollectionTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.ObjectTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.PropertyTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.util.AbstractQVTrelationCSPreOrderVisitor;

public class QVTrelationCSPreOrderVisitor extends AbstractQVTrelationCSPreOrderVisitor
{	
	public static class CollectionTemplateCompletion extends SingleContinuation<CollectionTemplateCS>
	{
		public CollectionTemplateCompletion(@NonNull CS2PivotConversion context, @NonNull CollectionTemplateCS csElement) {
			super(context, null, null, csElement, new PivotDependency(csElement.getType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			CollectionTemplateExp pivotElement = PivotUtil.getPivot(CollectionTemplateExp.class, csElement);
			if (pivotElement != null) {
				CollectionType type = PivotUtil.getPivot(CollectionType.class, csElement.getType());
				pivotElement.setReferredCollectionType(type);
				pivotElement.setType(type);
				Variable variable = pivotElement.getBindsTo();
				if (variable != null) {
					variable.setType(type);
				}
			}
			return null;
		}
	}

	public static class ObjectTemplateCompletion extends SingleContinuation<ObjectTemplateCS>
	{
		public ObjectTemplateCompletion(@NonNull CS2PivotConversion context, @NonNull ObjectTemplateCS csElement) {
			super(context, null, null, csElement, new PivotDependency(csElement.getType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			ObjectTemplateExp pivotElement = PivotUtil.getPivot(ObjectTemplateExp.class, csElement);
			if (pivotElement != null) {
				org.eclipse.ocl.examples.pivot.Class type = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Class.class, csElement.getType());
				pivotElement.setReferredClass(type);
				pivotElement.setType(type);
				Variable variable = pivotElement.getBindsTo();
				if (variable != null) {
					variable.setType(type);
				}
			}
			return null;
		}
	}

	public static class PropertyTemplateCompletion extends SingleContinuation<PropertyTemplateCS>
	{
		public PropertyTemplateCompletion(@NonNull CS2PivotConversion context, @NonNull PropertyTemplateCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public boolean canExecute() {
			if (!super.canExecute()) {
				return false;
			}
			ObjectTemplateExp pivotElement = PivotUtil.getPivot(ObjectTemplateExp.class, csElement.getObjectTemplate());
			if (pivotElement == null) {
				return false;
			}
			Type type = pivotElement.getType();
			return type != null;
		}

		@Override
		public BasicContinuation<?> execute() {
			PropertyTemplateItem pivotElement = PivotUtil.getPivot(PropertyTemplateItem.class, csElement);
			if (pivotElement != null) {
				Property propertyId = csElement.getPropertyId();
				if (propertyId != null) {
					pivotElement.setReferredProperty(propertyId);
					pivotElement.setIsOpposite(false);
				}
				else {
					PathNameCS oppositePropertyId = csElement.getOppositePropertyId();
					Element element = oppositePropertyId.getElement();
					if (element instanceof Property) {
						pivotElement.setReferredProperty((Property) element);
						pivotElement.setIsOpposite(true);
					}
				}
			}
			return null;
		}
	}

	public QVTrelationCSPreOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitCollectionTemplateCS(@NonNull CollectionTemplateCS csElement) {
		return new CollectionTemplateCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitObjectTemplateCS(@NonNull ObjectTemplateCS csElement) {
		return new ObjectTemplateCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitPropertyTemplateCS(@NonNull PropertyTemplateCS csElement) {
		return new PropertyTemplateCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitTransformationCS(@NonNull TransformationCS csElement) {
		Transformation pivotElement = PivotUtil.getPivot(Transformation.class, csElement);
		if (pivotElement != null) {
			List<Type> superClasses = pivotElement.getSuperClass();
//			context.refreshList(Type.class, superClasses, csElement.getOwnedSuperType());
			if (superClasses.isEmpty()) {
				org.eclipse.ocl.examples.pivot.Class oclElementType = context.getMetaModelManager().getOclElementType();
				pivotElement.getSuperClass().add(oclElementType);
			}
		}
		return null;
	}
}