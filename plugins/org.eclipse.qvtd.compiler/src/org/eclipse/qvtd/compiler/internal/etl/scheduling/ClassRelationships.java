package org.eclipse.qvtd.compiler.internal.etl.scheduling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;


/**
 * @author asbh500
 *
 * @param <C>
 */
public class ClassRelationships {
	private static final @NonNull Set<@NonNull Class> EMPTY_CLASS_SET = Collections.<@NonNull Class>emptySet();

	public static class ContainerClass {
		
		private @NonNull Class containerClass;
		
		private @NonNull Property containmentProperty;
		
		public ContainerClass(@NonNull Class containerClass, @NonNull Property containmentProperty) {
			this.containerClass = containerClass;
			this.containmentProperty = containmentProperty;
		}
		
		public @NonNull Class getContainerClass() {
			return containerClass;
		}
		
		public @NonNull Property getContainmentProperty() {
			return containmentProperty;
		}
		
		@Override
		public @NonNull String toString() {
			
			return containerClass.getName() + " - " + containmentProperty.getName();
		}
	}
	
	private @NonNull Map<@NonNull Class, Set<@NonNull Class>> class2superClasses = new HashMap<@NonNull Class, Set<@NonNull Class>>();
		
	private @NonNull Map<@NonNull Class, Set<@NonNull Class>> class2directSubClasses = new HashMap<@NonNull Class, Set<@NonNull Class>>();
	
	private @NonNull Map<@NonNull Class, Set<@NonNull Class>> class2allSubClasses = new HashMap<@NonNull Class, Set<@NonNull Class>>();
	
	private @NonNull Map<@NonNull Class, Set<@NonNull Class>> class2containerClasses = new HashMap<@NonNull Class, Set<@NonNull Class>>();
	
	private @NonNull Map<@NonNull Class, Set<@NonNull ContainerClass>> class2detailedContainerClasses = new HashMap<@NonNull Class, Set<@NonNull ContainerClass>>();
	
	protected @NonNull MetamodelManager mManager;
	
	private Deque<@NonNull Package> packageToProcess = new LinkedList<@NonNull Package>();
	
	private Set<@NonNull Package> processedPackage = new HashSet<@NonNull Package>(); 
	
	public ClassRelationships(@NonNull EnvironmentFactory ocl, @NonNull ResourceSet rSet) {
		mManager = ocl.getMetamodelManager();
		((MetamodelManagerInternal)mManager).getASmetamodel();
		initializeMaps(rSet);
	}
	
	private void initializeMaps(@NonNull ResourceSet resourceSet) {
	
		for (Resource resource : resourceSet.getResources()) {
			for (@SuppressWarnings("null") @NonNull Package aPackage : getInvolvedPackages(resource)) {
				Package pPackage = mManager.getPrimaryPackage(aPackage);
				if (!packageToProcess.contains(pPackage)) {
					packageToProcess.add(pPackage);;
				}
			}
		}
		
		while (!packageToProcess.isEmpty()) {
			Package aPackage = packageToProcess.pop();
			computeClass2SuperClasses(aPackage);
		}
		
		for (Class type : class2superClasses.keySet()) {
			computeClass2SubClasses(type);
		}

		for (Class type : class2superClasses.keySet()) { // subtypes need to be previously computed
			computeClass2ContainerClasses(type);
		}
	}
	
	
	private void computeClass2SuperClasses(@NonNull Package p) {
				
		if (processedPackage.contains(p)) {
			return;
		}			
		processedPackage.add(p);
		for (Class aClass : ClassUtil.nullFree(p.getOwnedClasses())) {
			computeClass2SuperClasses(aClass);
		}
		for (Package nestedPackage : ClassUtil.nullFree(p.getOwnedPackages())) {
			computeClass2SuperClasses(nestedPackage);
		}
	}
	
	/**
	 * Tranisitively compute
	 * @param aClass
	 * @return a set with all the all classess
	 */
	private Set<@NonNull Class> computeClass2SuperClasses(@NonNull Class aClass) {
		
		//aClass = mManager.getPrimaryClass(aClass);
		Set<@NonNull Class> superRels = class2superClasses.get(aClass);
		if (superRels != null) {
			return superRels;
		} else {
			superRels = new LinkedHashSet<@NonNull Class>();
			class2superClasses.put(aClass, superRels);
		}
		
		// Super class inheritance might be shortcut 
		for (Class superClass : ClassUtil.nullFree(aClass.getSuperClasses())) {
			//superClass = mManager.getPrimaryClass(superClass);
			superRels.add(superClass);
			superRels.addAll(computeClass2SuperClasses(superClass));
		}
				
		Package classPackage = ClassUtil.nonNullState(aClass.getOwningPackage());
		Package pPackage = mManager.getPrimaryPackage(classPackage);
		if (!processedPackage.contains(pPackage) &&
			! packageToProcess.contains(pPackage)) {
			packageToProcess.add(pPackage);
		}
		return superRels;
	}
		
	private void computeClass2SubClasses(Class aClass) {
		Set<@NonNull Class> superClasses = class2superClasses.get(aClass);
		if (superClasses != null) {
			for (Class superClass : superClasses) {
				if (aClass.getSuperClasses().contains(superClass)) {
					Set<Class> directSubClasses = class2directSubClasses.get(superClass);
					if (directSubClasses == null) {
						directSubClasses = new LinkedHashSet<Class>();
						class2directSubClasses.put(superClass, directSubClasses);
					}
					directSubClasses.add(aClass);
				}
				
				Set<Class> allSubClasses = class2allSubClasses.get(superClass);
				if (allSubClasses == null) {
					allSubClasses = new LinkedHashSet<Class>();
					class2allSubClasses.put(superClass, allSubClasses);
				}
				allSubClasses.add(aClass);
			}
		}
	}
	
	private void computeClass2ContainerClasses(@NonNull Class aClass) {
		 
		for (Property property : aClass.getOwnedProperties()) {
			Type propType = getType(property);
			if (property.isIsComposite() && propType instanceof Class) {
				Class isClass = propType.isClass();
				assert isClass != null;
				addContainerClassForTypeAndSubtypes(aClass, property, isClass);
			}
		}
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return mManager.getEnvironmentFactory();
	}
		
	private List<Package> getInvolvedPackages(Resource resource) {
	
		List<Model> oclRoots = new ArrayList<Model>();
		for (EObject root : resource.getContents()) {
			if (root instanceof Model) {
				oclRoots.add((Model)root);
			}
		}
		
		List<Package> result = new ArrayList<Package>();
		for (Model root : oclRoots) {
			for (Package pckg : root.getOwnedPackages()) {
				result.add(pckg);
			}
		}
		return result;
	}
	
	protected Type getType(TypedElement typedElement) {
		Type type = typedElement.getType();
		if (type instanceof CollectionType) {
			type = ((CollectionType) type).getElementType();
		}
		return type;
	}

	private void addContainerClassForTypeAndSubtypes(@NonNull Class containerClass, @NonNull Property containmentProperty, @NonNull Class type) {
		
		//type = mManager.getPrimaryClass(type);
		Set<@NonNull ContainerClass> detailedContainerClasses = class2detailedContainerClasses.get(type);
		Set<@NonNull Class> containerClasses = class2containerClasses.get(type);
		if (detailedContainerClasses == null) {
			detailedContainerClasses = new LinkedHashSet<@NonNull ContainerClass>();
			class2detailedContainerClasses.put(type, detailedContainerClasses);
		}
		if (containerClasses == null) {
			containerClasses = new LinkedHashSet<@NonNull Class>();
			class2containerClasses.put(type, containerClasses);
		}
		
		detailedContainerClasses.add(new ContainerClass(containerClass, containmentProperty));
		containerClasses.add(containerClass);
		
		for (Class subType : getDirectSubClasses(type)) {
			addContainerClassForTypeAndSubtypes(containerClass, containmentProperty, subType);
		}	
	}
//	public boolean typeIsSupertypeOf(Class t1, Class t2) {
//		Type primaryT1 = mManager.getPrimaryClass(t1);
//		Type primaryT2 = mManager.getPrimaryClass(t2);
//		return class2superClasses.get(primaryT1).contains(primaryT2);
//	}

	
	public @NonNull Set<@NonNull Class> getAllSuperClasses(@NonNull Class type) {
		Type primaryType = mManager.getPrimaryClass(type);
		Set<@NonNull Class> allSuperClasses = class2superClasses.get(primaryType);
		return allSuperClasses == null ? EMPTY_CLASS_SET  
				: ClassUtil.nonNullState(Collections.<@NonNull Class>unmodifiableSet(allSuperClasses));
	}
	
	public @NonNull Set<@NonNull Class> getAllSubClasses(@NonNull Class type) {
		Type primaryType = mManager.getPrimaryClass(type);
		Set<@NonNull Class> allSubClasses = class2allSubClasses.get(primaryType);
		return allSubClasses == null ? EMPTY_CLASS_SET  
				: ClassUtil.nonNullState(Collections.<@NonNull Class>unmodifiableSet(allSubClasses));
	}
	
	public @NonNull Set<@NonNull Class> getDirectSubClasses(@NonNull Class type) {
		Type primaryType = mManager.getPrimaryClass(type);
		Set<@NonNull Class> directSubClasses = class2directSubClasses.get(primaryType);
		return directSubClasses == null ? EMPTY_CLASS_SET  
				: ClassUtil.nonNullState(Collections.<@NonNull Class>unmodifiableSet(directSubClasses));
	}
	
	public @NonNull Set<@NonNull Class> getContainerClasses(@NonNull Class type) {
		Type primaryType = mManager.getPrimaryClass(type);
		Set<@NonNull Class> containerClasses = class2containerClasses.get(primaryType);
		return containerClasses == null ? EMPTY_CLASS_SET
				: ClassUtil.nonNullState(Collections.<@NonNull Class>unmodifiableSet(containerClasses));
	}
	
	public @NonNull Set<@NonNull ContainerClass> getDetailedContainerClasses(@NonNull Class type) {
		Type primaryType = mManager.getPrimaryClass(type);
		Set<@NonNull ContainerClass> containerClasses = class2detailedContainerClasses.get(primaryType);
		return ClassUtil.nonNullState(containerClasses == null ? Collections.<@NonNull ContainerClass>emptySet()
				: Collections.<@NonNull ContainerClass>unmodifiableSet(containerClasses));
	}
}
