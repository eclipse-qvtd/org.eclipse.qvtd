/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.evaluation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.UniqueList;
import org.eclipse.ocl.pivot.utilities.XMIUtil;

/**
 * The abstract implementation of a typed model instance provides the mandatory shared functionality for maintaining
 * a run-time representation of a typed model.
 */
public abstract class AbstractTypedModelInstance implements TypedModelInstance
{
	private static final @NonNull List<@NonNull Object> EMPTY_EOBJECT_LIST = Collections.emptyList();

	protected final @NonNull ModelsManager modelsManager;
	protected final @NonNull String name;

	/**
	 * The input Resources from which model elements are loaded by analyzeInputResources().
	 */
	private @Nullable List<@NonNull Resource> inputResources = null;

	/**
	 * The input Objects from which model elements are loaded by analyzeInputResources().
	 */
	@Deprecated /* @deprecated put the eRootObject in a Resource */
	private @Nullable List<@NonNull EObject> inputObjects;

	/**
	 * The (input) root objects added explicitly by addRootObjects.
	 */
	protected final @NonNull List<@NonNull EObject> rootObjects = new ArrayList<>();

	private int extentClassIndex = -1;
	protected @Nullable Map<Object, Object> extentOpposites = null;

	/**
	 * All possible allInstances() returns indexed by the ClassIndex of the ClassId for which allInstances() may be invoked.
	 *
	 * Must be set non-null by initConnections() before transformation execution starts.
	 */
	protected @NonNull Connection [] classIndex2connection;

	/**
	 * Unchanging list, in class index order, of the ClassId for which allInstances() may be invoked.
	 */
	protected @NonNull ClassId @Nullable [] classIndex2classId = null;

	/**
	 * Unchanging configured map from the ClassId for which allInstances() may be invoked to the ClassIndex for that ClassId.
	 */
	protected @Nullable Map<@NonNull ClassId, @NonNull Integer> classId2classIndex = null;

	/**
	 * Evolving map from the ClassId of some model object's class to all the ClassIndexes for which the model object
	 * might contribute to an allInstances() return. This is initially populated for the ClassIndexes of the ClassIds
	 * for which allInstances() may be invoked. It evolves lazily to include the ClassIds for all objects in the user
	 * models.
	 */
	private @Nullable Map<@NonNull ClassId, @NonNull Set<@NonNull Integer>> classId2classIndexes = null;

	/**
	 * The objects added by add filtered as defined by trackObjects.
	 */
	private @Nullable List<@NonNull EObject> potentialOrphanObjects = null;

	protected int isContainedCount = 0;
	protected int isNotContainedCount = 0;

	/**
	 * true to add all EObjects to allEObjects unconditionally
	 * false to add no EObjects to allEObjects unconditionally
	 * null to add EObjects to allEObjects unless isContained
	 */
	private @Nullable Boolean trackAdditions = null;

	/**
	 * The output Resources to which model elements are installed by analyzeOutputResources() and saved by saveResources().
	 */
	private @Nullable List<@NonNull Resource> outputResources = null;

	/**
	 * List heads of same-hashed EClassAnalysis singly linked lists.
	 */
	private @Nullable EClassAnalysis eClassAnalysisListHeads @Nullable [];

	protected AbstractTypedModelInstance(@NonNull ModelsManager modelsManager, @NonNull String name) {
		this.modelsManager = modelsManager;
		this.name = name;
		this.eClassAnalysisListHeads = null;
	}

	/**
	 * Add another eObject to the model, which must be distinct from all previously added eObjects.
	 * If isContained, the caller asserts that the caller will define the eObjects eContainer eliminating
	 * the need for the eObject to be tracked as a potential orphan to be assigned to the model root.
	 */
	@Override
	public void add(@NonNull EObject eObject, boolean isContained) {
		if ((trackAdditions == Boolean.FALSE) || (isContained && (trackAdditions == null))) {
			isContainedCount++;
		}
		else {
			isNotContainedCount++;
			List<@NonNull EObject> potentialOrphanObjects2 = potentialOrphanObjects;
			if (potentialOrphanObjects2 == null) {
				potentialOrphanObjects = potentialOrphanObjects2 = new ArrayList<>();
			}
			assert !potentialOrphanObjects2.contains(eObject);
			potentialOrphanObjects2.add(eObject);
		}
		if (classIndex2classId != null) {
			getEClassAnalysis(eObject).propagate(eObject);
		}
	}

	/**
	 * Addthe Extent EObject wih all rootEObjects as its elements.
	 */
	protected abstract void addExtent();

	protected void addExtent(@NonNull EObject extent, @NonNull List<Object> elements) {
		elements.addAll(rootObjects);
		getEClassAnalysis(extent).propagate(extent);
		Map<Object, Object> extentOpposites2 = extentOpposites;
		if (extentOpposites2 != null) {
			for (Object object : elements) {
				extentOpposites2.put(object, extent);
			}
		}
	}

	@Override
	public void addInputResource(@NonNull Resource inputResource) {
		List<@NonNull Resource> inputResources2 = inputResources;
		if (inputResources2 == null) {
			inputResources = inputResources2 = new UniqueList<>();
		}
		inputResources2.add(inputResource);
	}

	@Override
	public void addOutputResource(@NonNull Resource outputResource) {
		List<@NonNull Resource> outputResources2 = outputResources;
		if (outputResources2 == null) {
			outputResources = outputResources2 = new UniqueList<>();
		}
		outputResources2.add(outputResource);
	}

	/**
	 * Add eRootObjects to the model.
	 */
	@Override
	@Deprecated /* @deprecated put the eRootObject in a Resource */
	public void addRootObjects(@NonNull Iterable<@NonNull ? extends Object> eRootObjects) {
		List<@NonNull EObject> inputObjects2 = inputObjects;
		if (inputObjects2 == null) {
			inputObjects = inputObjects2 = new ArrayList<>();
		}
		for (@NonNull Object eRootObject : eRootObjects) {
			if (eRootObject instanceof EObject) {
				inputObjects2.add((EObject)eRootObject);
			}
		}
	}

	@Override
	public void analyzeInputResources() {
		List<@NonNull Resource> inputResources2 = inputResources;
		if (inputResources2 != null) {
			for (int i = 0; i < inputResources2.size(); i++) {				// Avoid CME from recursive proxies
				@NonNull Resource inputResource = inputResources2.get(i);
				for (@NonNull EObject eRootObject : inputResource.getContents()) {
					rootObjects.add(eRootObject);
					EClassAnalysis eClassAnalysis = getEClassAnalysis(eRootObject);
					eClassAnalysis.traverseChild(eRootObject);
				}
			}
		}
		if (inputObjects != null) {
			for (@NonNull EObject eRootObject : inputObjects) {
				rootObjects.add(eRootObject);
				EClassAnalysis eClassAnalysis = getEClassAnalysis(eRootObject);
				eClassAnalysis.traverseChild(eRootObject);
			}
		}
		if (extentClassIndex >= 0) {
			addExtent();
		}
	}

	@Override
	public void analyzeOutputResources() {
		if (outputResources != null) {
			EList<@NonNull EObject> contents = outputResources.get(0).getContents();
			contents.clear();			// FIXME incremental update
			contents.addAll(getRootEObjects());
		}
	}

	protected @Nullable List<@NonNull Resource> basicGetInputResources() {
		return inputResources;
	}

	/**
	 * Dispose.
	 */
	public void dispose() {
		if (potentialOrphanObjects != null) {
			potentialOrphanObjects.clear();
		}
		inputResources = null;
	}

	/**
	 * This is solely used by the Model::allObjects Operation which is not needed by synthesized QVTr.
	 * @deprecated
	 */
	@Deprecated
	@Override
	public @NonNull Collection<@NonNull EObject> getAllObjects() {
		/*			List<@NonNull Object> allEObjects2 = allEObjects;
		if (allEObjects2 == null) {
			allEObjects = allEObjects2 = new ArrayList<>();
			List<@NonNull Object> rootEObjects2 = rootEObjects;
			if (rootEObjects2 != null) {
				for (@NonNull Object eRootObject : rootEObjects2) {
					assert !allEObjects2.contains(eRootObject);
					allEObjects2.add(eRootObject);
					for (TreeIterator<? extends Object> tit = transformer.eAllContents(eRootObject); tit.hasNext(); ) {
						Object eObject = tit.next();
						if (eObject != null) {
							assert !allEObjects2.contains(eObject);
							allEObjects2.add(eObject);
						}
					}
				}
			}
		} */
		return potentialOrphanObjects != null ? potentialOrphanObjects : Collections.emptyList();
	}

	/**
	 * Return the Set of all ClassIndexes to which an EClass instance contributes to allInstances() returns.
	 */
	@NonNull Set<@NonNull Integer> getClassIndexes(@NonNull EClass eClass) {
		ClassId classId = IdManager.getClassId(eClass);
		Map<@NonNull ClassId, @NonNull Set<@NonNull Integer>> classId2classIndexes2 = classId2classIndexes;
		assert classId2classIndexes2 != null;
		Set<@NonNull Integer> classIndexes = classId2classIndexes2.get(classId);
		if (classIndexes == null) {
			classIndexes = new HashSet<>();
			for (@NonNull EClass eSuperClass : ClassUtil.nullFree(eClass.getESuperTypes())) {
				Set<@NonNull Integer> partialResult = getClassIndexes(eSuperClass);
				classIndexes.addAll(partialResult);
			}
			classId2classIndexes2.put(classId, classIndexes);
		}
		return classIndexes;
	}

	@Override
	public @NonNull Connection getConnection(int classIndex) {
		assert classIndex2connection != null;
		return classIndex2connection[classIndex];
	}

	/**
	 * Return the EClassAnalysis corresponding to eObject's eClass().
	 *
	 * The EClass lookup used a 256 singly linked lists selected from the EClass' identityHashCode.
	 * For small metaamodels, the required EClass will be found at the list head. For larger metamodels
	 * a short list search may be necessary. When a longer than two entry search is required the hit
	 * is promoted to the list head in the hope that most recently accessed classes are also the most likley
	 * next accesses.
	 */
	// FIXME synchronized / simple grow if not synchronized
	protected @NonNull EClassAnalysis getEClassAnalysis(@NonNull EObject eObject) {			// This code is tested by setting ECLASS_IDENTITIES to 16 and using a bigger model like ATL2QVTr
		final int ECLASS_IDENTITIES = 1 << 8;
		final int ECLASS_IDENTITY_MASK = ECLASS_IDENTITIES-1;
		@Nullable EClassAnalysis [] eClassAnalysisListHeads2 = eClassAnalysisListHeads;
		if (eClassAnalysisListHeads2 == null) {
			this.eClassAnalysisListHeads = eClassAnalysisListHeads2 = new @Nullable EClassAnalysis[ECLASS_IDENTITIES];
			for (int i = 0; i < ECLASS_IDENTITIES; i++) {
				eClassAnalysisListHeads2[i] = null;
			}
		}
		EClass eClass = eObject.eClass();
		assert eClass != null;
		int hashCode = (System.identityHashCode(eClass) >> 8) & ECLASS_IDENTITY_MASK;		// EClassImpl is approximately 256 bytes so avoid less-random bits.
		EClassAnalysis eClassAnalysisListHead = eClassAnalysisListHeads2[hashCode];
		for (EClassAnalysis eClassAnalysis = eClassAnalysisListHead, prevEClassAnalysis = null;
				eClassAnalysis != null;
				prevEClassAnalysis = eClassAnalysis, eClassAnalysis = eClassAnalysis.nextEClassAnalysis) {
			if (eClassAnalysis.getEClass() == eClass) {
				if ((prevEClassAnalysis != null) && (prevEClassAnalysis != eClassAnalysisListHead)) {		// pull to front if third or later in list
					assert eClassAnalysisListHead != null;													// don't pull to front for second to reduce thrashing
					assert prevEClassAnalysis.nextEClassAnalysis == eClassAnalysis;
					prevEClassAnalysis.nextEClassAnalysis = eClassAnalysis.nextEClassAnalysis;
					eClassAnalysis.nextEClassAnalysis = eClassAnalysisListHead;
					eClassAnalysisListHeads2[hashCode] = eClassAnalysis;
				}
				return eClassAnalysis;
			}
		}
		EClassAnalysis eClassAnalysis = new EClassAnalysis(this, eClass, eClassAnalysisListHead);			// create new analysis at front of list
		eClassAnalysisListHeads2[hashCode] = eClassAnalysis;
		return eClassAnalysis;
	}

	/**
	 * Return the elements of a root Extent object, iff rootObject is an Extent.
	 * Return null otherwise.
	 */
	protected abstract @Nullable Iterable<@NonNull EObject> getExtentElements(@NonNull EObject rootObject);

	@Override
	public @NonNull ModelsManager getModelsManager() {
		return modelsManager;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	/**
	 * This is solely used by the Model::objectsOfKind Operation which is not needed by synthesized QVTr,
	 * but which continues to be used by a number of legacy QVTi tests. It exploits a connection to which
	 * all objects of the required type have been appended. The connection may or may not have other purposes,
	 */
	@Override
	public @NonNull Iterable<@NonNull Object> getObjectsOfKind(org.eclipse.ocl.pivot.@NonNull Class type) {
		assert classIndex2connection != null;
		TypeId classId = type.getTypeId();
		assert classId != null;
		if (classId2classIndex != null) {
			Integer classIndex = classId2classIndex.get(classId);
			if (classIndex != null) {
				Connection connection = classIndex2connection[classIndex];
				assert connection != null;
				return connection.typedIterable(Object.class);
			}
		}
		return EMPTY_EOBJECT_LIST;
	}

	/**
	 * This is solely used by the Model::objectsOfType Operation which is not needed by synthesized QVTr.
	 * @deprecated
	 */
	@Deprecated
	@Override
	public @NonNull Collection<@NonNull Object> getObjectsOfType(org.eclipse.ocl.pivot.@NonNull Class type) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Return all the container-less objects in the modelName model.
	 */
	@Override
	public @NonNull Collection<@NonNull EObject> getRootEObjects() {
		boolean hasExtent = false;
		List<@NonNull EObject> rootEObjects = new ArrayList<>();
		Iterable<@NonNull EObject> rootEObjects2 = getRootEObjects2();
		for (@NonNull EObject rootObject : rootEObjects2) {
			Iterable<@NonNull EObject> extentElements = getExtentElements(rootObject);
			if (extentElements != null) {
				hasExtent = true;
				for (@NonNull Object object : extentElements) {
					rootEObjects.add((EObject)object);
				}
			}
		}
		if (!hasExtent) {
			for (@NonNull EObject rootObject : rootEObjects2) {
				rootEObjects.add(rootObject);
			}
		}
		return rootEObjects;
	}

	protected @NonNull Collection<@NonNull EObject> getRootEObjects2() {
		if (rootObjects.size() > 0) {		// If we have explicit (input) roots
			return rootObjects;
		}
		List<@NonNull EObject> rootObjects2 = new ArrayList<>();
		if (potentialOrphanObjects != null) {
			for (@NonNull EObject eObject : potentialOrphanObjects) {
				if (eObject.eContainer() == null) {
					rootObjects2.add(eObject);
				}
			}
		}
		if (AbstractTransformer.CONTAINMENTS.isActive()) {
			AbstractTransformer.CONTAINMENTS.println(name + " " + isContainedCount + "/" + (isContainedCount + isNotContainedCount));
		}
		return rootObjects2;
	}

	@Override
	public @NonNull TypedModelInstance initClassIds(@NonNull ClassId @NonNull [] classIndex2classId, int @Nullable [] @NonNull [] classIndex2allClassIndexes) {
		this.classIndex2classId = classIndex2classId;
		//
		//	Prepare the allInstances() fields
		//
		assert classIndex2allClassIndexes != null;
		int classIds = classIndex2classId.length;
		Map<@NonNull ClassId, @NonNull Integer> classId2classIndex = this.classId2classIndex = new HashMap<>(classIds);
		Map<@NonNull ClassId, @NonNull Set<@NonNull Integer>> classId2classIndexes = this.classId2classIndexes = new HashMap<>(classIds);
		for (int classIndex = 0; classIndex < classIds; classIndex++) {
			ClassId classId = classIndex2classId[classIndex];
			classId2classIndex.put(classId, classIndex);
			Set<@NonNull Integer> superClassIndexes = new HashSet<>();
			for (int allClassIndex : classIndex2allClassIndexes[classIndex]) {
				superClassIndexes.add(allClassIndex);
			}
			classId2classIndexes.put(classId, superClassIndexes);
		}
		return this;
	}

	@Override
	public void initConnections(@NonNull Interval rootInterval, @NonNull ModeFactory modeFactory) {
		@NonNull ClassId[] classIndex2classId2 = classIndex2classId;
		if (classIndex2classId2 != null) {
			@NonNull Connection [] classIndex2connection = this.classIndex2connection = new @NonNull Connection[classIndex2classId2.length];
			int classIndex = 0;
			for (@NonNull ClassId classId : classIndex2classId2) {
				String connectionName = name + "!" + classId.getName();
				classIndex2connection[classIndex] = rootInterval.createConnection(connectionName, classId, false, modeFactory);
				classIndex++;
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <K,V> void initExtent(int extentClassIndex, @Nullable Map<K, V> extentOpposites) {
		this.extentClassIndex = extentClassIndex;
		this.extentOpposites = (Map<Object, Object>) extentOpposites;
	}

	public void remove(@NonNull EObject eObject) {
		if (potentialOrphanObjects != null) {
			potentialOrphanObjects.remove(eObject);
		}
	}

	@Deprecated /* @deprecated removing resources is a dubious experimental capability */
	@Override
	public void removeInputResources() {
		if (inputResources != null) {
			inputResources.clear();
		}
		rootObjects.clear();
		if (classIndex2connection != null) {
			for (@NonNull Connection connection : classIndex2connection) {
				connection.clear();
			}
		}
	}

	@Deprecated /* @deprecated removing resources is a dubious experimental capability */
	@Override
	public void removeOutputResources() {
		isContainedCount = 0;
		isNotContainedCount = 0;
		if (outputResources != null) {
			outputResources.clear();
		}
		if (potentialOrphanObjects != null) {
			potentialOrphanObjects.clear();
		}
		rootObjects.clear();
	}

	@Override
	public void saveResources(@Nullable Map<?, ?> saveOptions) throws IOException {
		List<@NonNull Resource> outputResources2 = outputResources;
		if (outputResources2 != null) {
			if (saveOptions == null) {
				saveOptions = XMIUtil.createSaveOptions();
				@SuppressWarnings("unchecked") Map<Object, Object> castSaveOptions = (Map<Object,Object>)saveOptions;
				castSaveOptions.put(XMIResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
			}
			for (@NonNull Resource outputResource : outputResources2) {
				outputResource.save(saveOptions);
			}
		}
	}

	/**
	 * Set the behavior of add(eObject,isContained),
	 * true to add all EObjects to allEObjects unconditionally,
	 * false to add no EObjects to allEObjects unconditionally,
	 * null to add EObjects to allEObjects unless isContained
	 */
	public void setTrackAdditions(@Nullable Boolean trackAdditions) {
		this.trackAdditions = trackAdditions;
	}

	@Override
	public String toString() {
		return name + " " + rootObjects.size() + " (" + (potentialOrphanObjects != null ? potentialOrphanObjects.size() : 0) + ")";
	}

	public <@NonNull T> Iterable<T> typedIterable(Class<T> javaClass, org.eclipse.ocl.pivot.@NonNull Class pivotType) {
		assert classIndex2connection != null;
		TypeId typeId = pivotType.getTypeId();
		Integer classIndex = classId2classIndex != null ? classId2classIndex.get(typeId) : null;
		if (classIndex != null) {
			Connection connection = classIndex2connection[classIndex];
			return connection.typedIterable(javaClass);
		}
		return null;
	}
}
