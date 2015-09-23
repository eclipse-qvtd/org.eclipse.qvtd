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
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;


/**
 * @author asbh500
 *
 * @param <C>
 */
public class ClassRelationships {

	public static class ContainerClass {
		
		private Class containerClass;
		
		private Property containmentProperty;
		
		public ContainerClass(Class containerClass, Property containmentProperty) {
			this.containerClass = containerClass;
			this.containmentProperty = containmentProperty;
		}
		
		public Class getContainerClass() {
			return containerClass;
		}
		
		public Property getContainmentProperty() {
			return containmentProperty;
		}
		
		@Override
		public String toString() {
			
			return containerClass.getName() + " - " + containmentProperty.getName();
		}
	}
	
	private Map<Class, Set<Class>> class2superClasses = new HashMap<Class, Set<Class>>();
		
	private Map<Class, Set<Class>> class2directSubClasses = new HashMap<Class, Set<Class>>();
	
	private Map<Class, Set<Class>> class2allSubClasses = new HashMap<Class, Set<Class>>();
	
	private Map<Class, Set<Class>> class2containerClasses = new HashMap<Class, Set<Class>>();
	
	private Map<Class, Set<ContainerClass>> class2detailedContainerClasses = new HashMap<Class, Set<ContainerClass>>();
	
	protected MetamodelManager mManager;
	
	private Deque<Package> packageToProcess = new LinkedList<Package>();
	
	private Set<Package> processedPackage = new HashSet<Package>(); 
	
	public ClassRelationships(EnvironmentFactory ocl, ResourceSet rSet) {
		mManager = ocl.getMetamodelManager();
		initializeMaps(rSet);
	}
	
	private void initializeMaps(ResourceSet resourceSet) {
	
		for (Resource resource : resourceSet.getResources()) {
			for (Package aPackage : getInvolvedPackages(resource)) {
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
	
	
	private void computeClass2SuperClasses(Package p) {
				
		if (processedPackage.contains(p)) {
			return;
		}			
		processedPackage.add(p);
		for (Class aClass : p.getOwnedClasses()) {
			computeClass2SuperClasses(aClass);
		}
		for (Package nestedPackage : p.getOwnedPackages()) {
			computeClass2SuperClasses(nestedPackage);
		}
	}
	
	/**
	 * Tranisitively compute
	 * @param aClass
	 * @return a set with all the all classess
	 */
	private Set<Class> computeClass2SuperClasses(Class aClass) {
		
		//aClass = mManager.getPrimaryClass(aClass);
		Set<Class> superRels = class2superClasses.get(aClass);
		if (superRels != null) {
			return superRels;
		} else {
			superRels = new LinkedHashSet<Class>();
			class2superClasses.put(aClass, superRels);
		}
		
		// Super class inheritance might be shortcut 
		for (Class superClass : aClass.getSuperClasses()) {
			//superClass = mManager.getPrimaryClass(superClass);
			superRels.add(superClass);
			superRels.addAll(computeClass2SuperClasses(superClass));
		}
				
		Package classPackage = aClass.getOwningPackage();
		Package pPackage = mManager.getPrimaryPackage(classPackage);
		if (!processedPackage.contains(pPackage) &&
			! packageToProcess.contains(pPackage)) {
			packageToProcess.add(pPackage);
		}
		return superRels;
	}
		
	private void computeClass2SubClasses(Class aClass) {
			 
		for (Class superClass : class2superClasses.get(aClass)) {
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
	
	private void computeClass2ContainerClasses(Class aClass) {
		 
		for (Property property : aClass.getOwnedProperties()) {
			Type propType = getType(property);
			if (property.isIsComposite() && propType instanceof Class) {
				addContainerClassForTypeAndSubtypes(aClass, property, propType.isClass());
			}
		}
	}
	
	
	
//	private void addContainerClassForTypeAndSubtypes(Class containerClass, Property containmentProperty, Class type) {
//		
//		//type = mManager.getPrimaryClass(type);
//		Set<ContainerClass> containerClasses = class2containerClasses.get(type);
//		if (containerClasses == null) {
//			containerClasses = new LinkedHashSet<ContainerClass>();
//			class2containerClasses.put(type, containerClasses);
//		}
//		
//		containerClasses.add(new ContainerClass(containerClass, containmentProperty));
//		
//		Set<Class> subTypes = getDirectSubClasses(type);
//		if (subTypes != null) {
//			for (Class subType : subTypes) {
//				addContainerClassForTypeAndSubtypes(containerClass, containmentProperty, subType);
//			}	
//		}
//	}
	
	
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

	private void addContainerClassForTypeAndSubtypes(Class containerClass, Property containmentProperty, Class type) {
		
		//type = mManager.getPrimaryClass(type);
		Set<ContainerClass> detailedContainerClasses = class2detailedContainerClasses.get(type);
		Set<Class> containerClasses = class2containerClasses.get(type);
		if (detailedContainerClasses == null) {
			detailedContainerClasses = new LinkedHashSet<ContainerClass>();
			class2detailedContainerClasses.put(type, detailedContainerClasses);
		}
		if (containerClasses == null) {
			containerClasses = new LinkedHashSet<Class>();
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

	
	public Set<Class> getAllSuperClasses(Class type) {
		Type primaryType = mManager.getPrimaryClass(type);
		Set<Class> allSuperClasses = class2superClasses.get(primaryType);
		return allSuperClasses == null ? Collections.<Class>emptySet()  
										: Collections.<Class>unmodifiableSet(allSuperClasses);
	}
	
	public Set<Class> getAllSubClasses(Class type) {
		Type primaryType = mManager.getPrimaryClass(type);
		Set<Class> allSubClasses = class2allSubClasses.get(primaryType);
		return allSubClasses == null ? Collections.<Class>emptySet()  
										: Collections.<Class>unmodifiableSet(allSubClasses);
	}
	
	public Set<Class> getDirectSubClasses(Class type) {
		Type primaryType = mManager.getPrimaryClass(type);
		Set<Class> directSubClasses = class2directSubClasses.get(primaryType);
		return directSubClasses == null ? Collections.<Class>emptySet()  
										: Collections.<Class>unmodifiableSet(directSubClasses);
	}
	
	public Set<Class> getContainerClasses(Class type) {
		Type primaryType = mManager.getPrimaryClass(type);
		Set<Class> containerClasses = class2containerClasses.get(primaryType);
		return containerClasses == null ? Collections.<Class>emptySet()
				: Collections.<Class>unmodifiableSet(containerClasses);
	}
	
	public Set<ContainerClass> getDetailedContainerClasses(Class type) {
		Type primaryType = mManager.getPrimaryClass(type);
		Set<ContainerClass> containerClasses = class2detailedContainerClasses.get(primaryType);
		return containerClasses == null ? Collections.<ContainerClass>emptySet()
				: Collections.<ContainerClass>unmodifiableSet(containerClasses);
	}
}
