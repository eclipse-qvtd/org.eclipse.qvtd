/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.tests.SimpleUML2RDBMS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import simpleuml2rdbms.rdbms.RDBMSPackage;

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
import org.eclipse.qvtd.xtext.qvtimperative.tests.ModelNormalizer;

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
		protected final @NonNull RModelElementNameComparator rmodelElementNameComparator;

		public TableNormalizer(@NonNull EObject table, @NonNull EReference tableColumn, @NonNull RModelElementNameComparator rmodelElementNameComparator) {
			this.table = table;
			this.tableColumn = tableColumn;
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
		}
	}

	public @NonNull List<Normalizer> normalize(@NonNull Resource resource) {
		EObject eRoot = resource.getContents().get(0);
		EPackage ePackage = eRoot.eClass().getEPackage();
		EClass schemaClass = (EClass) ePackage.getEClassifier(RDBMSPackage.Literals.SCHEMA.getName());
		assert schemaClass != null;
		EClass tableClass = (EClass) ePackage.getEClassifier(RDBMSPackage.Literals.TABLE.getName());
		assert tableClass != null;
		EClass rModelElementClass = (EClass) ePackage.getEClassifier(RDBMSPackage.Literals.RMODEL_ELEMENT.getName());
		assert rModelElementClass != null;
		EReference schemaTables = (EReference) schemaClass.getEStructuralFeature(RDBMSPackage.Literals.SCHEMA__TABLES.getName());
		assert schemaTables != null;
		EReference tableColumn = (EReference) tableClass.getEStructuralFeature(RDBMSPackage.Literals.TABLE__COLUMNS.getName());
		assert tableColumn != null;
		EAttribute rmodelElementName = (EAttribute) tableClass.getEStructuralFeature(RDBMSPackage.Literals.RMODEL_ELEMENT__NAME.getName());
		assert rmodelElementName != null;
		RModelElementNameComparator rmodelElementNameComparator = new RModelElementNameComparator(rmodelElementName);
		List<Normalizer> normalizers = new ArrayList<Normalizer>();
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			EClass eClass = eObject.eClass();
			if (schemaClass.isSuperTypeOf(eClass)) {
				normalizers.add(new SchemaNormalizer(eObject, schemaTables, rmodelElementNameComparator));
			} else {
				if (tableClass.isSuperTypeOf(eClass)) {
					normalizers.add(new TableNormalizer(eObject, tableColumn, rmodelElementNameComparator));
				}
			}
		}
		for (Normalizer normalizer : normalizers) {
			normalizer.normalize();
		}
		return normalizers;
	}
}