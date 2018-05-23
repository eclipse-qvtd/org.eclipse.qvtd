/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.cs2as;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.Pivotable;
import org.eclipse.ocl.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.xtext.qvtbasecs.JavaClassCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ObjectTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainPatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.util.AbstractQVTrelationCSPreOrderVisitor;

public class QVTrelationCSPreOrderVisitor extends AbstractQVTrelationCSPreOrderVisitor
{
	public static class CollectionTemplateCompletion extends SingleContinuation<CollectionTemplateCS>
	{
		public CollectionTemplateCompletion(@NonNull CS2ASConversion context, @NonNull CollectionTemplateCS csElement) {
			super(context, null, null, csElement, createDependencies(csElement.getOwnedType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			CollectionTemplateExp pivotElement = PivotUtil.getPivot(CollectionTemplateExp.class, csElement);
			if (pivotElement != null) {
				CollectionType collectionType = PivotUtil.getPivot(CollectionType.class, csElement.getOwnedType());
				if (collectionType != null) {
					pivotElement.setReferredCollectionType(collectionType);
					pivotElement.setType(collectionType);
					Variable asVariable = pivotElement.getBindsTo();
					asVariable.setType(collectionType);
					asVariable.setTypeValue(null);
					asVariable.setIsRequired(true);
				}
			}
			return null;
		}
	}

	public static class ElementTemplateCompletion extends SingleContinuation<ElementTemplateCS>
	{
		public ElementTemplateCompletion(@NonNull CS2ASConversion context, @NonNull ElementTemplateCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public boolean canExecute() {
			if (!super.canExecute()) {
				return false;
			}
			CollectionTemplateExp pivotElement = PivotUtil.getPivot(CollectionTemplateExp.class, (Pivotable)csElement.getParent());
			if (pivotElement == null) {
				return false;
			}
			Type type = pivotElement.getType();
			return type != null;
		}

		@Override
		public BasicContinuation<?> execute() {
			Element asElement = PivotUtil.getPivot(Element.class, csElement);
			CollectionTemplateCS csCollectionTemplate = (CollectionTemplateCS)csElement.getParent();
			CollectionTemplateExp asCollectionTemplateExp = PivotUtil.getPivot(CollectionTemplateExp.class, csCollectionTemplate);
			assert asCollectionTemplateExp != null;
			CollectionType asCollectionType = (CollectionType) asCollectionTemplateExp.getType();
			if (asElement instanceof Variable) {
				assert csCollectionTemplate.getOwnedRestIdentifier() == csElement;
				Variable asVariable = (Variable)asElement;
				if (asVariable.isIsImplicit()) {
					asVariable.setType(asCollectionType);
					asVariable.setTypeValue(null);
					asVariable.setIsRequired(true);
				}
			}
			else if (asElement instanceof VariableExp) {
				assert csCollectionTemplate.getOwnedMemberIdentifiers().contains(csElement);
				VariableExp asVariableExp = (VariableExp)asElement;
				Variable asVariable = (Variable)asVariableExp.getReferredVariable();
				Type elementType = asCollectionType.getElementType();
				boolean isNullFree = asCollectionType.isIsNullFree();
				if ((asVariable != null) && asVariable.isIsImplicit()) {
					context.getHelper().setType(asVariable, elementType, isNullFree);
				}
				context.getHelper().setType(asVariableExp, elementType, isNullFree);
			}
			return null;
		}
	}

	public static class ObjectTemplateCompletion extends SingleContinuation<ObjectTemplateCS>
	{
		public ObjectTemplateCompletion(@NonNull CS2ASConversion context, @NonNull ObjectTemplateCS csElement) {
			super(context, null, null, csElement, createDependencies(csElement.getOwnedType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			ObjectTemplateExp pivotElement = PivotUtil.getPivot(ObjectTemplateExp.class, csElement);
			if (pivotElement != null) {
				TypedRefCS csType = csElement.getOwnedType();
				Boolean isRequired = null;
				org.eclipse.ocl.pivot.Class type = null;
				if (csType != null) {
					type = PivotUtil.getPivot(org.eclipse.ocl.pivot.Class.class, csType);
					isRequired = context.isRequired(csType);
				}
				pivotElement.setReferredClass(type);
				context.getHelper().setType(pivotElement, type, isRequired != Boolean.FALSE);
				Variable variable = pivotElement.getBindsTo();
				if (variable != null) {
					context.getHelper().setType(variable, type, isRequired != Boolean.FALSE);
				}
				assert pivotElement.getType() != null;
			}
			return null;
		}
	}

	public static class PropertyTemplateCompletion extends SingleContinuation<PropertyTemplateCS>
	{
		public PropertyTemplateCompletion(@NonNull CS2ASConversion context, @NonNull PropertyTemplateCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public boolean canExecute() {
			if (!super.canExecute()) {
				return false;
			}
			ObjectTemplateExp pivotElement = PivotUtil.getPivot(ObjectTemplateExp.class, csElement.getOwningObjectTemplate());
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
					boolean isOpposite = propertyId.isIsImplicit();
					pivotElement.setIsOpposite(isOpposite);
					pivotElement.setReferredProperty(isOpposite ? propertyId.getOpposite() : propertyId);
				}
				else {
					PathNameCS oppositePropertyId = csElement.getOwnedOppositePropertyId();
					Element element = oppositePropertyId.getReferredElement();
					if (element instanceof Property) {
						pivotElement.setReferredProperty((Property) element);
						pivotElement.setIsOpposite(true);
					}
				}
			}
			return null;
		}
	}

	public static class PrimitiveTypeDomainPatternCompletion extends SingleContinuation<PrimitiveTypeDomainPatternCS>
	{
		public PrimitiveTypeDomainPatternCompletion(@NonNull CS2ASConversion context, @NonNull PrimitiveTypeDomainPatternCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public boolean canExecute() {
			if (!super.canExecute()) {
				return false;
			}
			org.eclipse.ocl.pivot.Class type = PivotUtil.getPivot(org.eclipse.ocl.pivot.Class.class, csElement.getOwnedType());
			return type != null;
		}

		@Override
		public BasicContinuation<?> execute() {
			DomainPattern domainPattern = PivotUtil.getPivot(DomainPattern.class, csElement);
			if (domainPattern != null) {
				TypedRefCS csTypeRef = csElement.getOwnedType();
				if (csTypeRef != null) {
					TemplateExp templateExpression = domainPattern.getTemplateExpression();
					if (templateExpression != null) {
						context.refreshRequiredType(templateExpression, csTypeRef);
						Variable bindsTo = templateExpression.getBindsTo();
						if (bindsTo != null) {
							context.refreshRequiredType(bindsTo, csTypeRef);
						}
					}
				}
			}
			return null;
		}
	}

	public QVTrelationCSPreOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitCollectionTemplateCS(@NonNull CollectionTemplateCS csElement) {
		return new CollectionTemplateCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitDefaultValueCS(@NonNull DefaultValueCS csElement) {
		RelationDomainAssignment pivotElement = PivotUtil.getPivot(RelationDomainAssignment.class, csElement);
		if (pivotElement != null) {
			pivotElement.setVariable(csElement.getPropertyId());
		}
		return null;
	}

	@Override
	public Continuation<?> visitElementTemplateCS(@NonNull ElementTemplateCS csElement) {
		return new ElementTemplateCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitObjectTemplateCS(@NonNull ObjectTemplateCS csElement) {
		return new ObjectTemplateCompletion(context, csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPrimitiveTypeDomainCS(@NonNull PrimitiveTypeDomainCS csElement) {
		return null;
	}

	@Override
	public @Nullable Continuation<?> visitPrimitiveTypeDomainPatternCS(@NonNull PrimitiveTypeDomainPatternCS csElement) {
		return new PrimitiveTypeDomainPatternCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitPropertyTemplateCS(@NonNull PropertyTemplateCS csElement) {
		return new PropertyTemplateCompletion(context, csElement);
	}

	@Override
	public @Nullable Continuation<?> visitQueryCS(@NonNull QueryCS csElement) {
		Function pivotElement = PivotUtil.getPivot(Function.class, csElement);
		if (pivotElement != null) {
			JavaClassCS implementation = csElement.getImplementation();
			if ((implementation != null) && !implementation.eIsProxy()) {
				pivotElement.setImplementationClass(implementation.getName());
			}
		}
		return super.visitQueryCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitRelationCS(@NonNull RelationCS csElement) {
		Relation pivotElement = PivotUtil.getPivot(Relation.class, csElement);
		if (pivotElement != null) {
			pivotElement.setOverridden(csElement.getOverridden());
		}
		return null;
	}

	@Override
	public Continuation<?> visitTransformationCS(@NonNull TransformationCS csElement) {
		Transformation pivotElement = PivotUtil.getPivot(Transformation.class, csElement);
		if (pivotElement != null) {
			List<org.eclipse.ocl.pivot.Class> superClasses = pivotElement.getSuperClasses();
			//			context.refreshList(Type.class, superClasses, csElement.getOwnedSuperType());
			if (superClasses.isEmpty()) {
				org.eclipse.ocl.pivot.Class oclElementType = context.getMetamodelManager().getStandardLibrary().getOclElementType();
				pivotElement.getSuperClasses().add(oclElementType);
			}
		}
		return null;
	}
}