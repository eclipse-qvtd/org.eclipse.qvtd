/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcorebase.analysis;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AssociationClassCallExp;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.util.AbstractExtendingQVTcoreBaseVisitor;

/**
 * A DomainUsageVariable identifies a constrained domain result from the DomainUsageAnalysis of an OCL AST node.
 */
public class DomainUsageAnalysis extends AbstractExtendingQVTcoreBaseVisitor<DomainUsage, Transformation>
{
	protected final @NonNull Map<Type, DomainUsage> class2usage = new HashMap<Type, DomainUsage>();
	protected final @NonNull Map<Element, DomainUsage> element2usage = new HashMap<Element, DomainUsage>();
	protected final @NonNull Map<Property, DomainUsage> property2source = new HashMap<Property, DomainUsage>();
	protected final @NonNull Map<Property, DomainUsage> property2target = new HashMap<Property, DomainUsage>();
	
	protected DomainUsageAnalysis(@NonNull Transformation context) {
		super(context);
		for (@SuppressWarnings("null")@NonNull TypedModel typedModel : context.getModelParameter()) {
			boolean isCheckable = false;
			boolean isEnforceable = false;
			for (Rule rule : context.getRule()) {
				for (Domain domain : rule.getDomain()) {
					if (domain.getTypedModel() == typedModel) {
						if (domain.isIsCheckable()) {
							isCheckable = true;
						}
						if (domain.isIsEnforceable()) {
							isEnforceable = true;
						}
					}
				}
			}
			DomainUsage usage = !isCheckable ? DomainUsageConstant.TARGET : !isEnforceable ? DomainUsageConstant.SOURCE : DomainUsageConstant.MIDDLE; 
			for (org.eclipse.ocl.pivot.Package asPackage : QVTbaseUtil.getAllUsedPackages(typedModel)) {
				for (org.eclipse.ocl.pivot.Class asClass : asPackage.getOwnedClasses()) {
					DomainUsage oldUsage = class2usage.get(asClass);
					DomainUsage newUsage = oldUsage != null ? intersection(usage, oldUsage) : usage;
					class2usage.put(asClass, newUsage);
				}
			}
		}
	}

	protected @NonNull DomainUsage getUsage(@Nullable Type type) {
		DomainUsage usage = class2usage.get(type);
		return usage != null ? usage : DomainUsageConstant.PRIMITIVE ;
	}

	protected @NonNull DomainUsage intersection(@NonNull DomainUsage firstUsage, @NonNull DomainUsage secondUsage) {
		int firstMask = firstUsage.getMask();
		int secondMask = secondUsage.getMask();
		if (firstMask == secondMask) {
			if (firstUsage != secondUsage) {
				if (firstUsage instanceof DomainUsageVariable) {
					replace((DomainUsageVariable) firstUsage, secondUsage);
					return secondUsage;
				}
				else if (secondUsage instanceof DomainUsageVariable) {
					replace((DomainUsageVariable) secondUsage, firstUsage);
					return firstUsage;
				}
			}
			return firstUsage;
		}
		else {
			int intersectionMask = firstMask & secondMask;
			DomainUsage usage = DomainUsageConstant.getUsage(intersectionMask);
			if (usage != null) {
				if ((usage != firstUsage) && (firstUsage instanceof DomainUsageVariable)) {
					replace((DomainUsageVariable) firstUsage, usage);
				}
				if ((usage != secondUsage) && (secondUsage instanceof DomainUsageVariable)) {
					replace((DomainUsageVariable) secondUsage, usage);
				}
				return usage;
			}
			else {
				usage = new DomainUsageVariable(intersectionMask);
				if (firstUsage instanceof DomainUsageVariable) {
					replace((DomainUsageVariable) firstUsage, usage);
				}
				if (secondUsage instanceof DomainUsageVariable) {
					replace((DomainUsageVariable) secondUsage, usage);
				}
				return usage;
			}
		}
	}

	protected void replace(@NonNull DomainUsageVariable oldUsage, @NonNull DomainUsage newUsage) {
		Iterable<Element> elements = oldUsage.getElements();
		if (elements != null) {
			for (@SuppressWarnings("null")@NonNull Element element : elements) {
				element2usage.put(element, newUsage);
				newUsage.addUsedBy(element);
			}
		}
	}

/*	protected void unify(@NonNull DomainUsage firstUsage, @NonNull DomainUsage secondUsage) {
		DomainUsage usage = intersection(firstUsage, secondUsage);
		if (firstUsage != usage) {
			Set<Element> elements = firstUsage.getElements();
			if (elements != null) {
				for (@SuppressWarnings("null")@NonNull Element element : elements) {
					element2usage.put(element, usage);
					usage.addUsedBy(element);
				}
			}
		}
		if (secondUsage != usage) {
			Set<Element> elements = secondUsage.getElements();
			if (elements != null) {
				for (@SuppressWarnings("null")@NonNull Element element : elements) {
					element2usage.put(element, usage);
					usage.addUsedBy(element);
				}
			}
		}
	} */

	public @NonNull DomainUsage visit(@Nullable Element element) {
		if (element == null) {
			return DomainUsageConstant.ANY;
		}
		DomainUsage usage = element.accept(this);
		if (usage == null) {
			usage = DomainUsageConstant.ANY;
		}
		element2usage.put(element, usage);
		usage.addUsedBy(element);
		return usage;
	}

	@Override
	public @Nullable DomainUsage visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
	}

	@Override
	public @Nullable DomainUsage visitAssociationClassCallExp(@NonNull AssociationClassCallExp object) {
		// TODO Auto-generated method stub
		return super.visitAssociationClassCallExp(object);
	}

	@Override
	public @Nullable DomainUsage visitCollectionItem(@NonNull CollectionItem object) {
		return visit(object.getOwnedItem());
	}

	@Override
	public @Nullable DomainUsage visitCollectionLiteralExp(@NonNull CollectionLiteralExp object) {
		DomainUsage usage = DomainUsageConstant.ANY;
		for (@SuppressWarnings("null")@NonNull CollectionLiteralPart part : object.getOwnedParts()) {
			usage = intersection(usage, visit(part));
		}
		return usage;
	}

	@Override
	public @Nullable DomainUsage visitCollectionRange(@NonNull CollectionRange object) {
		DomainUsage firstUsage = visit(object.getOwnedFirst());
		DomainUsage lastUsage = visit(object.getOwnedLast());
		return intersection(firstUsage, lastUsage);
	}

	@Override
	public @Nullable DomainUsage visitIfExp(@NonNull IfExp object) {
		DomainUsage thenUsage = visit(object.getOwnedThen());
		DomainUsage elseUsage = visit(object.getOwnedElse());
		return intersection(thenUsage, elseUsage);
	}

	@Override
	public @Nullable DomainUsage visitIterateExp(@NonNull IterateExp object) {
		// TODO Auto-generated method stub
		return super.visitIterateExp(object);
	}

	@Override
	public @Nullable DomainUsage visitIteratorExp(@NonNull IteratorExp object) {
		// TODO Auto-generated method stub
		return super.visitIteratorExp(object);
	}

	@Override
	public @Nullable DomainUsage visitLetExp(@NonNull LetExp object) {
		visit(object.getOwnedVariable());
		return visit(object.getOwnedIn());
	}

	@Override
	public @Nullable DomainUsage visitLiteralExp(@NonNull LiteralExp object) {
		return DomainUsageConstant.PRIMITIVE;
	}

	@Override
	public @Nullable DomainUsage visitMapLiteralExp(@NonNull MapLiteralExp object) {
		DomainUsage usage = DomainUsageConstant.ANY;
		for (@SuppressWarnings("null")@NonNull MapLiteralPart part : object.getOwnedParts()) {
			usage = intersection(usage, visit(part));
		}
		return usage;
	}

	@Override
	public @Nullable DomainUsage visitMapLiteralPart(@NonNull MapLiteralPart object) {
		DomainUsage keyUsage = visit(object.getOwnedKey());
		DomainUsage valueUsage = visit(object.getOwnedValue());
		return intersection(keyUsage, valueUsage);
	}

	@Override
	public @Nullable DomainUsage visitNavigationCallExp(@NonNull NavigationCallExp object) {
		// TODO Auto-generated method stub
		return super.visitNavigationCallExp(object);
	}

	@Override
	public @Nullable DomainUsage visitOperationCallExp(@NonNull OperationCallExp object) {
		// TODO Auto-generated method stub
		return super.visitOperationCallExp(object);
	}

	@Override
	public @Nullable DomainUsage visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp object) {
		// TODO Auto-generated method stub
		return super.visitOppositePropertyCallExp(object);
	}

	@Override
	public @Nullable DomainUsage visitPropertyCallExp(@NonNull PropertyCallExp object) {
		DomainUsage actualSourceUsage = visit(object.getOwnedSource());
		Property property = object.getReferredProperty();
		DomainUsage knownSourceUsage = property2source.get(property);
		if (knownSourceUsage != null) {
			DomainUsage knownTargetUsage = property2target.get(property);
			intersection(knownSourceUsage, actualSourceUsage);
			return knownTargetUsage;
		}
		else {
			return actualSourceUsage;
		}
	}

	@Override
	public @Nullable DomainUsage visitShadowExp(@NonNull ShadowExp object) {
		DomainUsage usage = DomainUsageConstant.ANY;
		for (@SuppressWarnings("null")@NonNull ShadowPart part : object.getOwnedParts()) {
			usage = intersection(usage, visit(part));
		}
		return usage;
	}

	@Override
	public @Nullable DomainUsage visitShadowPart(@NonNull ShadowPart object) {
		return getUsage(object.getType());
	}

	@Override
	public @Nullable DomainUsage visitTupleLiteralExp(@NonNull TupleLiteralExp object) {
		DomainUsage usage = DomainUsageConstant.ANY;
		for (@SuppressWarnings("null")@NonNull TupleLiteralPart part : object.getOwnedParts()) {
			usage = intersection(usage, visit(part));
		}
		return usage;
	}

	@Override
	public @Nullable DomainUsage visitTupleLiteralPart(@NonNull TupleLiteralPart object) {
		return getUsage(object.getType());
	}

	@Override
	public @Nullable DomainUsage visitTypeExp(@NonNull TypeExp object) {
		return getUsage(object.getReferredType());
	}

	@Override
	public @Nullable DomainUsage visitVariable(@NonNull Variable object) {
		return visit(object.getOwnedInit());
	}

	@Override
	public @Nullable DomainUsage visitVariableExp(@NonNull VariableExp object) {
		DomainUsage usage = element2usage.get(object.getReferredVariable());
		assert usage != null : object.getReferredVariable() + " usage not defined";
		return usage;
	}
}
