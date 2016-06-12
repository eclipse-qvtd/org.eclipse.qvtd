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
package org.eclipse.qvtd.xtext.qvtbase.cs2as;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.scoping.ScopeFilter;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.basecs.ClassCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.xtext.qvtbasecs.AbstractTransformationCS;
import org.eclipse.qvtd.xtext.qvtbasecs.QualifiedPackageCS;
import org.eclipse.qvtd.xtext.qvtbasecs.util.AbstractQVTbaseCSContainmentVisitor;

public class QVTbaseCSContainmentVisitor extends AbstractQVTbaseCSContainmentVisitor
{
	private class PackagePlan
	{		
		/**
		 * The AS root.
		 */
		private final @NonNull Model asModel;
		
		/**
		 * The child packages of the model root.
		 */
		private final @NonNull List<org.eclipse.ocl.pivot.@NonNull Package> asRootPackages = new ArrayList<org.eclipse.ocl.pivot.@NonNull Package>();
		
		/**
		 * The nested child packages of each package.
		 */
		private final @NonNull Map<org.eclipse.ocl.pivot.@NonNull Package, @NonNull List<org.eclipse.ocl.pivot.@NonNull Package>> package2ownedPackages = new HashMap<org.eclipse.ocl.pivot.@NonNull Package, @NonNull List<org.eclipse.ocl.pivot.@NonNull Package>>();
		
		/**
		 * The nested child classes of each package.
		 */
		private final @NonNull Map<org.eclipse.ocl.pivot.@NonNull Package, @NonNull List<org.eclipse.ocl.pivot.@NonNull Class>> package2ownedClasses = new HashMap<org.eclipse.ocl.pivot.@NonNull Package, @NonNull List<org.eclipse.ocl.pivot.@NonNull Class>>();

		public PackagePlan(@NonNull Model asModel) {
			this.asModel = asModel;
		}

		/**
		 * Return the non-null list of child classes of asParent.
		 */
		private @NonNull List<org.eclipse.ocl.pivot.@NonNull Class> getChildClasses(org.eclipse.ocl.pivot.@NonNull Package asParent) {
			List<org.eclipse.ocl.pivot.@NonNull Class> asChildClasses = package2ownedClasses.get(asParent);
			if (asChildClasses == null) {
				asChildClasses = new ArrayList<org.eclipse.ocl.pivot.@NonNull Class>();
				package2ownedClasses.put(asParent, asChildClasses);
			}
			return asChildClasses;
		}

		/**
		 * Return the non-null list of child packages of asParent.
		 */
		private @NonNull List<org.eclipse.ocl.pivot.@NonNull Package> getChildPackages(org.eclipse.ocl.pivot.@NonNull Package asParent) {
			List<org.eclipse.ocl.pivot.@NonNull Package> asChildPackages = package2ownedPackages.get(asParent);
			if (asChildPackages == null) {
				asChildPackages = new ArrayList<org.eclipse.ocl.pivot.@NonNull Package>();
				package2ownedPackages.put(asParent, asChildPackages);
			}
			return asChildPackages;
		}

		/**
		 * Return the subpackage of asParent name name. Re-uses an existing package where possible.
		 * If asParent is null a root package is returned.
		 */
		private org.eclipse.ocl.pivot.@NonNull Package getPackage(org.eclipse.ocl.pivot.@Nullable Package asParent, @NonNull String name) {
			List<org.eclipse.ocl.pivot.@NonNull Package> asOldPackages;
			List<org.eclipse.ocl.pivot.@NonNull Package> asNewPackages;
			if (asParent == null) {
				asOldPackages = ClassUtil.nullFree(asModel.getOwnedPackages());
				asNewPackages = asRootPackages;
			}
			else {
				asOldPackages = ClassUtil.nullFree(asParent.getOwnedPackages());
				asNewPackages = getChildPackages(asParent);
			}
			org.eclipse.ocl.pivot.Package asPackage = NameUtil.getNameable(asNewPackages, name);
			if (asPackage == null) {
				asPackage = NameUtil.getNameable(asOldPackages, name);
				if (asPackage == null) {
					asPackage = context.refreshModelElement(org.eclipse.ocl.pivot.Package.class, PivotPackage.Literals.PACKAGE, null);
					asPackage.setName(name);
				}
				asNewPackages.add(asPackage);
			}
			return asPackage;
		}

		private org.eclipse.ocl.pivot.@Nullable Class installClass(org.eclipse.ocl.pivot.@Nullable Package asContextPackage, @NonNull ClassCS csClass) {
			org.eclipse.ocl.pivot.Class asClass = PivotUtil.getPivot(org.eclipse.ocl.pivot.Class.class, csClass);
			if (asClass != null) {
				org.eclipse.ocl.pivot.Package asParent;
				/*PathNameCS qualifiedPathName = csClass.getOwnedPathName();
				List<@NonNull PathElementCS> ownedPathElements = qualifiedPathName != null ? ClassUtil.nullFree(qualifiedPathName.getOwnedPathElements()) : null;
				if ((ownedPathElements != null) && !ownedPathElements.isEmpty()) {
					asParent = asContextPackage;
					for (@NonNull PathElementCS pathElement : ownedPathElements) {
						@SuppressWarnings("null")@NonNull String name = pathElement.toString();
						org.eclipse.ocl.pivot.Package asPackage = getPackage(asParent, name);
						asParent = asPackage;
					}
					assert asParent != null;
				}
				else*/ if (asContextPackage != null) {
					asParent = asContextPackage;
				}
				else {
					asParent = getPackage(null, "");
				}
				List<org.eclipse.ocl.pivot.@NonNull Class> asChildClasses = getChildClasses(asParent);
				asChildClasses.add(asClass);
			}
			return asClass;
		}

		/**
		 * Install the plan, root packages in model, child packages within parents, child classes within parent.
		 * @param csElement 
		 */
		public void installPackageStructure(@NonNull Iterable<@NonNull PackageCS> csPackages, @NonNull Iterable<? extends @NonNull AbstractTransformationCS> csTransformations) {
			installPackageStructures(null, csPackages);
			for (@NonNull AbstractTransformationCS csTransformation : csTransformations) {
				installTransformation(null, csTransformation);
			}
			PivotUtilInternal.refreshList(asModel.getOwnedPackages(), asRootPackages);
			for (org.eclipse.ocl.pivot.@NonNull Package asPackage : package2ownedPackages.keySet()) {
				PivotUtilInternal.refreshList(asPackage.getOwnedPackages(), package2ownedPackages.get(asPackage));
			}
			for (org.eclipse.ocl.pivot.@NonNull Package asPackage : package2ownedClasses.keySet()) {
				PivotUtilInternal.refreshList(asPackage.getOwnedClasses(), package2ownedClasses.get(asPackage));
			}
		}
		
		private void installPackageStructures(org.eclipse.ocl.pivot.@Nullable Package asContextPackage, @NonNull Iterable<@NonNull PackageCS> csPackages) {
			for (@NonNull PackageCS csPackage : csPackages) {
				org.eclipse.ocl.pivot.Package asPackage = installPackage(asContextPackage, csPackage);
				if (asPackage != null) {
					for (@NonNull ClassCS csClass : ClassUtil.nullFree(csPackage.getOwnedClasses())) {
						if (csClass instanceof AbstractTransformationCS) {
							installTransformation(asPackage, (AbstractTransformationCS)csClass);
						}
						else {
							installClass(asPackage, csClass);
						}
					}
					installPackageStructures(asPackage, ClassUtil.nullFree(csPackage.getOwnedPackages()));
				}
			}
		}

		private org.eclipse.ocl.pivot.@Nullable Package installPackage(org.eclipse.ocl.pivot.@Nullable Package asContextPackage, @NonNull PackageCS csPackage) {
			org.eclipse.ocl.pivot.Package asPackage = PivotUtil.getPivot(org.eclipse.ocl.pivot.Package.class, csPackage);
			if (asPackage != null) {
				org.eclipse.ocl.pivot.Package asParent;
				PathNameCS qualifiedPathName = csPackage instanceof QualifiedPackageCS ? ((QualifiedPackageCS)csPackage).getOwnedPathName() : null;
				List<@NonNull PathElementCS> ownedPathElements = qualifiedPathName != null ? ClassUtil.nullFree(qualifiedPathName.getOwnedPathElements()) : null;
				if ((ownedPathElements != null) && !ownedPathElements.isEmpty()) {
					asParent = asContextPackage;
					for (@NonNull PathElementCS pathElement : ownedPathElements) {
						@SuppressWarnings("null")@NonNull String name = pathElement.toString();
						org.eclipse.ocl.pivot.Package asPackage2 = getPackage(asParent, name);
						asParent = asPackage2;
					}
					assert asParent != null;
				}
				else {
					asParent = asContextPackage;
				}
				if (asParent != null) {
					getChildPackages(asParent).add(asPackage);
				}
				else {
					asRootPackages.add(asPackage);
				}
			}
			return asPackage;
		}

		private @Nullable Transformation installTransformation(org.eclipse.ocl.pivot.@Nullable Package asContextPackage, @NonNull AbstractTransformationCS csTransformation) {
			Transformation asTransformation = PivotUtil.getPivot(Transformation.class, csTransformation);
			if (asTransformation != null) {
				PathNameCS qualifiedPathName = csTransformation.getOwnedPathName();
				org.eclipse.ocl.pivot.Package asParent;
				List<@NonNull PathElementCS> ownedPathElements = qualifiedPathName != null ? ClassUtil.nullFree(qualifiedPathName.getOwnedPathElements()) : null;
				if ((ownedPathElements != null) && !ownedPathElements.isEmpty()) {
					asParent = asContextPackage;
					for (@NonNull PathElementCS pathElement : ownedPathElements) {
						@SuppressWarnings("null")@NonNull String name = pathElement.toString();
						org.eclipse.ocl.pivot.Package asPackage = getPackage(asParent, name);
						asParent = asPackage;
					}
					assert asParent != null;
				}
				else if (asContextPackage != null) {
					asParent = asContextPackage;
				}
				else {
					asParent = getPackage(null, "");
				}
				List<org.eclipse.ocl.pivot.@NonNull Class> asChildClasses = getChildClasses(asParent);
				asChildClasses.add(asTransformation);
			}
			return asTransformation;
		}
	}
	
	public QVTbaseCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}	

	protected void installPackageStructure(@NonNull Model asModel, @NonNull Iterable<@NonNull PackageCS> csPackages, @NonNull Iterable<? extends @NonNull AbstractTransformationCS> csTransformations) {
		PackagePlan packagePlan = new PackagePlan(asModel);
		packagePlan.installPackageStructure(csPackages, csTransformations);
	}
	
	protected @Nullable Transformation lookupTransformation(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName, @Nullable ScopeFilter scopeFilter) {
		CS2AS.setElementType(csPathName, QVTbasePackage.Literals.TRANSFORMATION, csElement, scopeFilter);
		Element namedElement = csPathName.getReferredElement();
		if (namedElement instanceof Transformation) {
			return (Transformation) namedElement;
		}
		else {
			return null;
		}
	}

	@Override
	public @Nullable Continuation<?> visitQualifiedPackageCS(@NonNull QualifiedPackageCS csElement) {
		PathNameCS pathName = csElement.getOwnedPathName();
		if (pathName != null) {
			CS2AS.setElementType(pathName, PivotPackage.Literals.NAMESPACE, csElement, null);
		}
		refreshPackage(org.eclipse.ocl.pivot.Package.class, PivotPackage.Literals.PACKAGE, csElement);
		return null;
	}
}
