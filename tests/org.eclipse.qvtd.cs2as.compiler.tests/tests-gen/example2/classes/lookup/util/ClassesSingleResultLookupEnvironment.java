/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models/example2/Classes.genmodel
 * template: org.eclipse.ocl.examples.build.xtend.GenerateAutoLookupInfrastructureXtend
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	example2.classes.lookup.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;

import example2.classes.NamedElement;
import example2.classes.lookup.LookupEnvironment;
import example2.classes.lookup.impl.LookupEnvironmentImpl;

public class ClassesSingleResultLookupEnvironment extends LookupEnvironmentImpl   {
	
	private @NonNull Executor executor;
	private @NonNull String name;
	private @NonNull EClass typeFilter;
	private @NonNull Map<@NonNull String, List<NamedElement>> entries = new LinkedHashMap<@NonNull String,List<NamedElement>>();
	private @Nullable ClassesLookupFilter expFilter;
	
	
	public ClassesSingleResultLookupEnvironment(@NonNull Executor executor, @NonNull EClass typeFilter, @NonNull String name,  @Nullable ClassesLookupFilter expFilter) {
		this.executor = executor;
		this.name = name;
		this.typeFilter = typeFilter;
		this.expFilter = expFilter;
	}

	public ClassesSingleResultLookupEnvironment(@NonNull Executor executor, @NonNull EClass typeFilter, @NonNull String name) {
		this(executor,typeFilter, name, null);
	}
	
	@Override
	@NonNull
	public Executor getExecutor() {
		return executor;
	}
	
	@Override
	public boolean hasFinalResult() {
		return getNamedElements(name).size() > 0;
	}
	
	@Override
	@NonNull
	public LookupEnvironment addElement(@Nullable NamedElement namedElement) {
		if (namedElement == null) {
			return this;
		}
		return addElementWithName(namedElement.getName(), namedElement);
	}
	
	@Override
	@NonNull
	public <NE extends NamedElement > LookupEnvironment addElements(
			@Nullable Collection<NE> namedElements) {
		
		if (namedElements != null) {
			for (NamedElement namedElement : namedElements) {
				addElement(namedElement);
			}	
		}
		return this;
	}
	
	
	@Override
	@NonNull
	public LookupEnvironment addElementWithName(String entryName, NamedElement namedElement) {
		if (namedElement != null) {
			if (name.equals(entryName)) {
				if (typeFilter.isInstance(namedElement)) {
				    ClassesLookupFilter expFilter2 = expFilter;
					if (expFilter2 == null || expFilter2.matches(namedElement)) {
						List<NamedElement> elements = getNamedElements(entryName);
						if (!elements.contains(namedElement)) { 	// FIXME use a set ?
							elements.add(namedElement);
						}
					}
				}
			}
		}
		return this;
	}
	
	@Override
	@NonNull
	@SuppressWarnings("null")
	public EList<NamedElement> getNamedElements(String entryName) {
		List<NamedElement> namedElements = entries.get(entryName);
		return namedElements == null ? ECollections.emptyEList() : ECollections.asEList(namedElements);
	}
	
	@NonNull
	@SuppressWarnings("unchecked")
	public <NE extends NamedElement> List<NE> getNamedElementsByKind(Class<NE> class_) {
		List<NE> result = new ArrayList<NE>(); 
		for (NamedElement namedElement : getNamedElements(name)) {
			if (class_.isAssignableFrom(namedElement.getClass())) {
				result.add((NE)namedElement);
			}
		}
		return result;
	}
}
