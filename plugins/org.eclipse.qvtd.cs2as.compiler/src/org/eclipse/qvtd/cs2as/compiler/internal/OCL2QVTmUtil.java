/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public class OCL2QVTmUtil {
	
	public static Function<EObject, @NonNull Stream<@NonNull EObject>> getAllContents() {
		return eObject -> {
			Iterable<EObject> it = () -> eObject.eAllContents();
			return StreamSupport.stream(it.spliterator(),false);
		};
	}
	
	public static Function<EObject, @NonNull Stream<@NonNull EObject>> getAllContentsIncludingSelf() {
		return eObject -> {
			List<EObject> allContents = new ArrayList<EObject>();
			for (Iterator<EObject> it = eObject.eAllContents(); it.hasNext(); ) {
				allContents.add(it.next());
			}
			allContents.add(eObject);
			return allContents.stream();
		};
	}
	
	public static Function<EObject, @NonNull Stream<@NonNull EObject>> getAllContainers() {
		return eObject -> {
			List<EObject> containers = new ArrayList<EObject>();
			for (EObject container = eObject.eContainer(); container != null; container = container.eContainer()) {
				containers.add(container);
			}
			return containers.stream();
		};
	}
	
	public static Function<ShadowExp, @NonNull Class> getExpressionContextType() {
		return shadowExp -> {
			return (Class) getContainingExpressionInOCL().apply(shadowExp)
					.getOwnedContext().getType();
		};
	}
	
	public static Function<OCLExpression, @NonNull ExpressionInOCL> getContainingExpressionInOCL() {
		return oclExp -> {
			EObject container = oclExp.eContainer();
			while (! (container instanceof ExpressionInOCL)) {
				container = container.eContainer();
			}
			assert(container != null); // Assuming all expression are contained in an ExpressionInOCL
			return (ExpressionInOCL)container;
		};
	}
	

	public static Function<@NonNull String, @NonNull String> firstToLowerCase() {
		return input -> {
			if (input.isEmpty()) {
				return input;
			}
			char c[] = input.toCharArray();
			c[0] = Character.toLowerCase(c[0]);
			return new String(c);
		};
	}
	
	public static Function<@NonNull String, @NonNull String> firstToUpperCase() {
		return input -> {
			if (input.isEmpty()) {
				return input;
			}
			char c[] = input.toCharArray();
			c[0] = Character.toUpperCase(c[0]);
			return new String(c);
		};
	}
	
	public static Function<@NonNull ShadowExp, @NonNull String> getCreationMappingName() { 
		return shadowExp -> {
			return "c" + getExpressionContextType().apply(shadowExp).getName() + "_2_" + getShadowTypeName().apply(shadowExp);
		};
	}
	
	public static Function<@NonNull ShadowPart, @NonNull String> getUpdateMappingName() {
		return shadowPart -> {
			ShadowExp shadowExp = (ShadowExp)shadowPart.eContainer();
		 	Property refProp = shadowPart.getReferredProperty();
			return 'u' + getExpressionContextType().apply(shadowExp).getName() + "_2_" 
		 			+ getShadowTypeName().apply(shadowExp) + '_' + refProp.getName(); 
		};
	}
	
	private static Function<@NonNull ShadowExp, @NonNull String> getShadowTypeName() {
		return shadowExp -> { 
			ExpressionInOCL expInOCL = getContainingExpressionInOCL().apply(shadowExp);
			List<ShadowExp> sameTypeShadowExps = getAllContents().apply(expInOCL)
				.filter(ShadowExp.class::isInstance)
				.map(ShadowExp.class::cast)
				.filter(x -> x.getType() == shadowExp.getType())
				.collect(Collectors.toList());
			if (sameTypeShadowExps.size() > 1) { // If there are more shadow exps returning the same type:
				return shadowExp.getType().getName() + "_" + sameTypeShadowExps.indexOf(shadowExp);
			} else {
				return shadowExp.getType().getName();
			}
		};
	}
	
	
	public static Function<@NonNull Class, @NonNull Package>  getOwningPackage() {
		return aClass -> {
			return aClass.getOwningPackage();
		};
	}
	
	public static Function<@NonNull Class, @NonNull String>  getOwningPackageName() {
		return aClass -> {
			return getName().apply(getOwningPackage().apply(aClass));
		};
	}
	
	private static Function<@NonNull NamedElement, @NonNull String> getName() {
		return namedElement -> { return namedElement == null ? "" : namedElement.getName(); };
	}
	
	public static Function<@NonNull Class, @NonNull Set<@NonNull Class>> getSuperClasses() {
		// FIXME ClassRelantionghip has cashes
		return aClass -> {
			Set<Class> result = new LinkedHashSet<Class>();
			for (Class superClass : ClassUtil.nullFree(aClass.getSuperClasses())) {
				result.add(superClass);
				result.addAll(getSuperClasses().apply(superClass));
			}
			return result;
		};
	}
}
