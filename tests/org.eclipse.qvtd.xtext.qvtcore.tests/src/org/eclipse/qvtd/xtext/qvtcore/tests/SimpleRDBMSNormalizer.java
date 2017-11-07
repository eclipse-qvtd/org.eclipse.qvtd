/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.tests;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase.Normalizer;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.ModelNormalizer;

public class SimpleRDBMSNormalizer implements ModelNormalizer
{
	public static final @NonNull SimpleRDBMSNormalizer INSTANCE = new SimpleRDBMSNormalizer();

	protected static class RModelElementNameComparator implements Comparator<EObject>
	{
		private final @NonNull EAttribute rmodelElementName;

		public RModelElementNameComparator(@NonNull EAttribute rmodelElementName) {
			this.rmodelElementName = rmodelElementName;
		}

		@Override
		public int compare(EObject o1, EObject o2) {
			String n1 = (String) o1.eGet(rmodelElementName);
			String n2 = (String) o2.eGet(rmodelElementName);
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	protected class SchemaNormalizer implements Normalizer
	{
		protected final @NonNull EObject schema;
		protected final @NonNull EReference schemaTables;
		protected final @NonNull RModelElementNameComparator rmodelElementNameComparator;

		public SchemaNormalizer(@NonNull EObject schema, @NonNull EReference schemaTables, @NonNull RModelElementNameComparator rmodelElementNameComparator) {
			this.schema = schema;
			this.schemaTables = schemaTables;
			this.rmodelElementNameComparator = rmodelElementNameComparator;
		}

		@Override
		public void denormalize() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void normalize() {
			@SuppressWarnings("unchecked")
			EList<EObject> tables = (EList<EObject>) schema.eGet(schemaTables);
			ECollections.sort(tables, rmodelElementNameComparator);
		}
	}

	protected class TableNormalizer implements Normalizer
	{
		protected final @NonNull EObject table;
		protected final @NonNull EReference tableColumn;
		protected final @NonNull EReference tableForeignKeys;
		protected final @NonNull RModelElementNameComparator rmodelElementNameComparator;

		public TableNormalizer(@NonNull EObject table, @NonNull EReference tableColumn, @NonNull EReference tableForeignKeys, @NonNull RModelElementNameComparator rmodelElementNameComparator) {
			this.table = table;
			this.tableColumn = tableColumn;
			this.tableForeignKeys = tableForeignKeys;
			this.rmodelElementNameComparator = rmodelElementNameComparator;
		}

		@Override
		public void denormalize() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void normalize() {
			@SuppressWarnings("unchecked")
			EList<EObject> columns = (EList<EObject>) table.eGet(tableColumn);
			ECollections.sort(columns, rmodelElementNameComparator);
			@SuppressWarnings("unchecked")
			EList<EObject> foreignKeys = (EList<EObject>) table.eGet(tableForeignKeys);
			ECollections.sort(foreignKeys, rmodelElementNameComparator);
		}
	}

	@Override
	public @NonNull List<@NonNull Normalizer> normalize(@NonNull Resource resource) {
		EObject eRoot = resource.getContents().get(0);
		EPackage ePackage = eRoot.eClass().getEPackage();
		EClass schemaClass = (EClass) ePackage.getEClassifier("Schema");
		assert schemaClass != null;
		EClass tableClass = (EClass) ePackage.getEClassifier("Table");
		assert tableClass != null;
		EClass rModelElementClass = (EClass) ePackage.getEClassifier("RModelElement");
		assert rModelElementClass != null;
		EClass columnClass = (EClass) ePackage.getEClassifier("Column");
		assert columnClass != null;
		EReference schemaTables = (EReference) schemaClass.getEStructuralFeature("tables");
		assert schemaTables != null;
		EReference tableColumn = (EReference) tableClass.getEStructuralFeature("columns");
		assert tableColumn != null;
		EAttribute rmodelElementName = (EAttribute) tableClass.getEStructuralFeature("name");
		assert rmodelElementName != null;
		EReference tableForeignKeys = (EReference) tableClass.getEStructuralFeature("foreignKeys");
		assert tableForeignKeys != null;
		RModelElementNameComparator rmodelElementNameComparator = new RModelElementNameComparator(rmodelElementName);
		List<@NonNull Normalizer> normalizers = new ArrayList<>();
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			EClass eClass = eObject.eClass();
			if (schemaClass.isSuperTypeOf(eClass)) {
				normalizers.add(new SchemaNormalizer(eObject, schemaTables, rmodelElementNameComparator));
			} else if (tableClass.isSuperTypeOf(eClass)) {
				normalizers.add(new TableNormalizer(eObject, tableColumn, tableForeignKeys, rmodelElementNameComparator));
			}
		}
		for (Normalizer normalizer : normalizers) {
			normalizer.normalize();
		}
		return normalizers;
	}
}