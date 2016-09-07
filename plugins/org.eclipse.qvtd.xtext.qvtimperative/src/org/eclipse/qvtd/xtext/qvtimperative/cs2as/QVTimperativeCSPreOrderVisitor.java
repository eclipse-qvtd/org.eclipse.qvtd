/*******************************************************************************
 * Copyright (c) 2010, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.cs2as;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.scoping.ScopeFilter;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.PivotDependency;
import org.eclipse.ocl.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ImperativeDomainCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.PredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.RealizeableVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.AbstractQVTimperativeCSPreOrderVisitor;

public class QVTimperativeCSPreOrderVisitor extends AbstractQVTimperativeCSPreOrderVisitor
{
	public static class MappingLoopIteratorCompletion extends SingleContinuation<MappingLoopCS>
	{
		protected static PivotDependency[] computeDependencies(@NonNull MappingLoopCS csElement) {
			VariableCS csIterator = csElement.getOwnedIterator();
			if (csIterator != null) {
				TypedRefCS ownedType = csIterator.getOwnedType();
				if (ownedType != null) {
					return new PivotDependency[]{new PivotDependency(ownedType)};
				}
			}
			return new PivotDependency[0];
		}

		public MappingLoopIteratorCompletion(@NonNull CS2ASConversion context, @NonNull MappingLoopCS csElement) {
			super(context, null, null, csElement, computeDependencies(csElement));
		}

		@Override
		public BasicContinuation<?> execute() {
			MappingLoop pivotElement = PivotUtil.getPivot(MappingLoop.class, csElement);
			if (pivotElement != null) {
				Variable iterator = pivotElement.getOwnedIterators().get(0);
				if (iterator != null) {
					VariableCS csIterator = csElement.getOwnedIterator();
					if (csIterator != null) {
						Type type = PivotUtil.getPivot(Type.class, csIterator.getOwnedType());
						iterator.setType(type);
					}
				}
			}
			return null;
		}
	}

	public static class ParamDeclarationCompletion extends SingleContinuation<ParamDeclarationCS>
	{
		public ParamDeclarationCompletion(@NonNull CS2ASConversion context, @NonNull ParamDeclarationCS csElement) {
			super(context, null, null, csElement, new PivotDependency(csElement.getOwnedType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			FunctionParameter pivotElement = PivotUtil.getPivot(FunctionParameter.class, csElement);
			if (pivotElement != null) {
				context.refreshRequiredType(pivotElement, csElement);
			}
			return null;
		}
	}

	public static class QueryCompletion extends SingleContinuation<QueryCS>
	{
		public QueryCompletion(@NonNull CS2ASConversion context, @NonNull QueryCS csElement) {
			super(context, null, null, csElement, new PivotDependency(csElement.getOwnedType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			Function pivotElement = PivotUtil.getPivot(Function.class, csElement);
			if (pivotElement != null) {
				context.refreshRequiredType(pivotElement, csElement);
			}
			return null;
		}
	}

	public static class RealizeableVariableCompletion extends SingleContinuation<RealizeableVariableCS>
	{
		public RealizeableVariableCompletion(@NonNull CS2ASConversion context, @NonNull RealizeableVariableCS csElement) {
			super(context, null, null, csElement, new PivotDependency(csElement.getOwnedType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			Variable pivotElement = PivotUtil.getPivot(Variable.class, csElement);
			if (pivotElement != null) {
				context.refreshRequiredType(pivotElement, csElement);
			}
			return null;
		}
	}

	public QVTimperativeCSPreOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	protected org.eclipse.ocl.pivot.@Nullable Class lookupClass(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName, @Nullable ScopeFilter scopeFilter) {
		CS2AS.setElementType(csPathName, PivotPackage.Literals.CLASS, csElement, scopeFilter);
		Element namedElement = csPathName.getReferredElement();
		if (namedElement instanceof org.eclipse.ocl.pivot.Class) {
			return (org.eclipse.ocl.pivot.Class) namedElement;
		}
		else {
			return null;
		}
	}

	protected @Nullable Mapping lookupMapping(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName, @Nullable ScopeFilter scopeFilter) {
		CS2AS.setElementType(csPathName, QVTimperativePackage.Literals.MAPPING, csElement, scopeFilter);
		Element namedElement = csPathName.getReferredElement();
		if (namedElement instanceof Mapping) {
			return (Mapping) namedElement;
		}
		else {
			return null;
		}
	}



	protected @Nullable Property lookupProperty(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName, @Nullable ScopeFilter scopeFilter) {
		CS2AS.setElementType(csPathName, PivotPackage.Literals.PROPERTY, csElement, scopeFilter);
		Element namedElement = csPathName.getReferredElement();
		if (namedElement instanceof Property) {
			return (Property) namedElement;
		}
		else {
			return null;
		}
	}

	private void refreshUsedProperties(@NonNull ImperativeDomainCS csImperativeDomain,
			/*@NonNull*/ List<Property> asProperties, /*@NonNull*/ List<PathNameCS> csProperties) {
		List<Property> properties = new ArrayList<Property>();
		for (PathNameCS csPathName : csProperties) {
			if (csPathName != null) {
				Property asProperty = lookupProperty(csImperativeDomain, csPathName, null);
				if (asProperty != null) {
					properties.add(asProperty);
				}
			}
		}
		context.refreshList(asProperties, properties);
	}

	@Override
	public Continuation<?> visitBottomPatternCS(@NonNull BottomPatternCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitDirectionCS(@NonNull DirectionCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitDomainCS(@NonNull DomainCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitEnforcementOperationCS(@NonNull EnforcementOperationCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitGuardPatternCS(@NonNull GuardPatternCS csElement) {
		return null;
	}

	@Override
	public @Nullable Continuation<?> visitImperativeDomainCS(@NonNull ImperativeDomainCS csImperativeDomain) {
		ImperativeArea asArea = PivotUtil.getPivot(ImperativeArea.class, csImperativeDomain);
		if (asArea != null) {
			refreshUsedProperties(csImperativeDomain, asArea.getCheckedProperties(), csImperativeDomain.getCheckedProperties());
			refreshUsedProperties(csImperativeDomain, asArea.getEnforcedProperties(), csImperativeDomain.getEnforcedProperties());
		}
		return null;
	}

	@Override
	public Continuation<?> visitMappingCS(@NonNull MappingCS csMapping) {
		Mapping asMapping = PivotUtil.getPivot(Mapping.class, csMapping);
		if (asMapping != null) {
			List<org.eclipse.ocl.pivot.Class> asClasses = new ArrayList<org.eclipse.ocl.pivot.Class>();
			for (PathNameCS csPathName : csMapping.getOwnedUsesPathNames()) {
				if (csPathName != null) {
					org.eclipse.ocl.pivot.Class asClass = lookupClass(csMapping, csPathName, null);
					if (asClass != null) {
						asClasses.add(asClass);
					}
				}
			}
			context.refreshList(asMapping.getPolledClasses(), asClasses);
		}
		return null;
	}

	@Override
	public Continuation<?> visitMappingCallBindingCS(@NonNull MappingCallBindingCS csElement) {
		MappingCallBinding pivotElement = PivotUtil.getPivot(MappingCallBinding.class, csElement);
		if (pivotElement != null) {
			pivotElement.setBoundVariable(csElement.getReferredVariable());
		}
		return null;
	}

	@Override
	public Continuation<?> visitMappingCallCS(@NonNull MappingCallCS csElement) {
		MappingCall pivotElement = PivotUtil.getPivot(MappingCall.class, csElement);
		if (pivotElement != null) {
			PathNameCS csPathName = csElement.getOwnedPathName();
			if (csPathName != null) {
				Mapping asMapping = lookupMapping(csElement, csPathName, null);
				pivotElement.setReferredMapping(asMapping);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitMappingLoopCS(@NonNull MappingLoopCS csElement) {
		return new MappingLoopIteratorCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitParamDeclarationCS(@NonNull ParamDeclarationCS csElement) {
		return new ParamDeclarationCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitPredicateCS(@NonNull PredicateCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPredicateOrAssignmentCS(@NonNull PredicateOrAssignmentCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitQueryCS(@NonNull QueryCS csElement) {
		return new QueryCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitRealizeableVariableCS(@NonNull RealizeableVariableCS csElement) {
		return new RealizeableVariableCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS csElement) {
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