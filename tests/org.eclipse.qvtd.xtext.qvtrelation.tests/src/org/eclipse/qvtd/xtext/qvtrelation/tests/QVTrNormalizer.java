/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase.Normalizer;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;

public class QVTrNormalizer extends PivotNormalizer
{
	public static final @NonNull QVTrNormalizer INSTANCE = new QVTrNormalizer();

	public static final class DomainComparator implements Comparator<@NonNull Domain>
	{
		public static final @NonNull DomainComparator INSTANCE = new DomainComparator();

		@Override
		public int compare(@NonNull Domain o1, @NonNull Domain o2) {
			TypedModel tm1 = QVTbaseUtil.getTypedModel(o1);
			TypedModel tm2 = QVTbaseUtil.getTypedModel(o2);
			Transformation tx = tm1.getTransformation();
			int x1 = tx.getModelParameter().indexOf(tm1);
			int x2 = tx.getModelParameter().indexOf(tm2);
			return x1 - x2;
		}
	}

	protected class RelationNormalizer implements Normalizer
	{
		protected final @NonNull Relation asRelation;

		public RelationNormalizer(@NonNull Relation asRelation) {
			this.asRelation = asRelation;
		}

		@Override
		public void denormalize() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void normalize() {
			@SuppressWarnings("null")
			EList<@NonNull Domain> domains = (EList<@NonNull Domain>)asRelation.getDomain();
			ECollections.sort(domains, DomainComparator.INSTANCE);
			ECollections.sort(asRelation.getVariable(), NameUtil.NAMEABLE_COMPARATOR);
		}
	}

	protected class TransformationNormalizer extends ClassNormalizer
	{
		public TransformationNormalizer(@NonNull Transformation asTransformation) {
			super(asTransformation);
		}

		@Override
		public void normalize() {
			super.normalize();
			ECollections.sort(((Transformation)asClass).getModelParameter(), NameUtil.NAMEABLE_COMPARATOR);
			ECollections.sort(((Transformation)asClass).getRule(), NameUtil.NAMEABLE_COMPARATOR);
		}
	}

	@Override
	public @NonNull List<@NonNull Normalizer> normalize(@NonNull Resource resource) {
		List<@NonNull Normalizer> normalizers = new ArrayList<>();
		for (@NonNull EObject eObject : new TreeIterable(resource)) {
			if (eObject instanceof Model) {
				normalizers.add(new ModelNormalizer((Model)eObject));
			}
			else if (eObject instanceof org.eclipse.ocl.pivot.Package) {
				normalizers.add(new PackageNormalizer((org.eclipse.ocl.pivot.Package)eObject));
			}
			else if (eObject instanceof Transformation) {
				((Transformation)eObject).setUnspecializedElement(null);		// Suppress transient value
				normalizers.add(new TransformationNormalizer((Transformation)eObject));
			}
			else if (eObject instanceof org.eclipse.ocl.pivot.Class) {
				((org.eclipse.ocl.pivot.Class)eObject).setUnspecializedElement(null);		// Suppress transient value
				normalizers.add(new ClassNormalizer((org.eclipse.ocl.pivot.Class)eObject));
			}
			else if (eObject instanceof Relation) {
				//	((Relation)eObject).setUnspecializedElement(null);		// Suppress transient value
				normalizers.add(new RelationNormalizer((Relation)eObject));
			}
		}
		//		EList<NamedElement> contents = (EList<NamedElement>)(Object)resource.getContents();
		//		ECollections.sort(contents, ToStringComparator.INSTANCE);
		for (Normalizer normalizer : normalizers) {
			normalizer.normalize();
		}
		return normalizers;
	}
}