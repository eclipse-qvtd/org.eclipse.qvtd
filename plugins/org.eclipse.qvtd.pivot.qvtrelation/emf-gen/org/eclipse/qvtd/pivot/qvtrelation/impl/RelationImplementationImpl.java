/*******************************************************************************
 * Copyright (c) 2011, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationVisitor;
import com.google.common.collect.Lists;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImplementationImpl#getImpl <em>Impl</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImplementationImpl#getInDirectionOf <em>In Direction Of</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImplementationImpl#getRelation <em>Relation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationImplementationImpl extends ElementImpl implements RelationImplementation {
	/**
	 * The cached value of the '{@link #getImpl() <em>Impl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImpl()
	 * @generated
	 * @ordered
	 */
	protected Operation impl;

	/**
	 * The cached value of the '{@link #getInDirectionOf() <em>In Direction Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInDirectionOf()
	 * @generated
	 * @ordered
	 */
	protected TypedModel inDirectionOf;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationPackage.Literals.RELATION_IMPLEMENTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operation getImpl() {
		if (impl != null && impl.eIsProxy()) {
			InternalEObject oldImpl = (InternalEObject)impl;
			impl = (Operation)eResolveProxy(oldImpl);
			if (impl != oldImpl) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTrelationPackage.RELATION_IMPLEMENTATION__IMPL, oldImpl, impl));
			}
		}
		return impl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetImpl() {
		return impl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImpl(Operation newImpl) {
		Operation oldImpl = impl;
		impl = newImpl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationPackage.RELATION_IMPLEMENTATION__IMPL, oldImpl, impl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedModel getInDirectionOf() {
		if (inDirectionOf != null && inDirectionOf.eIsProxy()) {
			InternalEObject oldInDirectionOf = (InternalEObject)inDirectionOf;
			inDirectionOf = (TypedModel)eResolveProxy(oldInDirectionOf);
			if (inDirectionOf != oldInDirectionOf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTrelationPackage.RELATION_IMPLEMENTATION__IN_DIRECTION_OF, oldInDirectionOf, inDirectionOf));
			}
		}
		return inDirectionOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel basicGetInDirectionOf() {
		return inDirectionOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInDirectionOf(TypedModel newInDirectionOf) {
		TypedModel oldInDirectionOf = inDirectionOf;
		inDirectionOf = newInDirectionOf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationPackage.RELATION_IMPLEMENTATION__IN_DIRECTION_OF, oldInDirectionOf, inDirectionOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getRelation() {
		if (eContainerFeatureID() != QVTrelationPackage.RELATION_IMPLEMENTATION__RELATION) return null;
		return (Relation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRelation(Relation newRelation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRelation, QVTrelationPackage.RELATION_IMPLEMENTATION__RELATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelation(Relation newRelation) {
		if (newRelation != eInternalContainer() || (eContainerFeatureID() != QVTrelationPackage.RELATION_IMPLEMENTATION__RELATION && newRelation != null)) {
			if (EcoreUtil.isAncestor(this, newRelation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRelation != null)
				msgs = ((InternalEObject)newRelation).eInverseAdd(this, QVTrelationPackage.RELATION__OPERATIONAL_IMPL, Relation.class, msgs);
			msgs = basicSetRelation(newRelation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationPackage.RELATION_IMPLEMENTATION__RELATION, newRelation, newRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationPackage.RELATION_IMPLEMENTATION__RELATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRelation((Relation)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationPackage.RELATION_IMPLEMENTATION__RELATION:
				return basicSetRelation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case QVTrelationPackage.RELATION_IMPLEMENTATION__RELATION:
				return eInternalContainer().eInverseRemove(this, QVTrelationPackage.RELATION__OPERATIONAL_IMPL, Relation.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTrelationPackage.RELATION_IMPLEMENTATION__IMPL:
				if (resolve) return getImpl();
				return basicGetImpl();
			case QVTrelationPackage.RELATION_IMPLEMENTATION__IN_DIRECTION_OF:
				if (resolve) return getInDirectionOf();
				return basicGetInDirectionOf();
			case QVTrelationPackage.RELATION_IMPLEMENTATION__RELATION:
				return getRelation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QVTrelationPackage.RELATION_IMPLEMENTATION__IMPL:
				setImpl((Operation)newValue);
				return;
			case QVTrelationPackage.RELATION_IMPLEMENTATION__IN_DIRECTION_OF:
				setInDirectionOf((TypedModel)newValue);
				return;
			case QVTrelationPackage.RELATION_IMPLEMENTATION__RELATION:
				setRelation((Relation)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case QVTrelationPackage.RELATION_IMPLEMENTATION__IMPL:
				setImpl((Operation)null);
				return;
			case QVTrelationPackage.RELATION_IMPLEMENTATION__IN_DIRECTION_OF:
				setInDirectionOf((TypedModel)null);
				return;
			case QVTrelationPackage.RELATION_IMPLEMENTATION__RELATION:
				setRelation((Relation)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QVTrelationPackage.RELATION_IMPLEMENTATION__IMPL:
				return impl != null;
			case QVTrelationPackage.RELATION_IMPLEMENTATION__IN_DIRECTION_OF:
				return inDirectionOf != null;
			case QVTrelationPackage.RELATION_IMPLEMENTATION__RELATION:
				return getRelation() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTrelationVisitor<?>)visitor).visitRelationImplementation(this);
	}

	private OCL ocl = null;
	private Map<@NonNull String, @NonNull String> importName2importURI = null;
	private Set<@NonNull String> allImportURIs = null;

	public void dispose() {
		eResource().getContents().remove(this);
		ocl.dispose();
		ocl = null;
		importName2importURI = null;
		allImportURIs = null;
	}

	protected OCL getOCL() {
		if (ocl == null) {
			QVTrelationPivotStandaloneSetup.init();
			ocl = OCL.newInstance();
			importName2importURI = new HashMap<>();
			allImportURIs = new HashSet<>();
		}
		return ocl;
	}

	public @Nullable Type getCommonType(@NonNull Type leftType, @NonNull Type rightType) {
		return getMetamodelManager().getCommonType(leftType, TemplateParameterSubstitutions.EMPTY, rightType, TemplateParameterSubstitutions.EMPTY);
	}

	public @Nullable Type getLibraryType1(@NonNull Type unspecializedType, @NonNull Type parameterType1) {
		List<@NonNull Type> list = Lists.newArrayList(parameterType1);
		return getMetamodelManager().getLibraryType((org.eclipse.ocl.pivot.@NonNull Class)unspecializedType, list);
	}

	public @Nullable Type getLibraryType2(@NonNull Type unspecializedType, @NonNull Type parameterType1, @NonNull Type parameterType2) {
		List<@NonNull Type> list = Lists.newArrayList(parameterType1, parameterType2);
		return getMetamodelManager().getLibraryType((org.eclipse.ocl.pivot.@NonNull Class)unspecializedType, list);
	}

	//	public @Nullable Type getLibraryType(org.eclipse.ocl.pivot.@NonNull Class unspecializedType, @NonNull Type... parameterTypes) {
	//		List<@NonNull Type> list = Lists.newArrayList(parameterTypes);
	//		return getMetamodelManager().getLibraryType(unspecializedType, list);
	//	}

	protected @NonNull PivotMetamodelManager getMetamodelManager() {
		return (PivotMetamodelManager) getOCL().getEnvironmentFactory().getMetamodelManager();			// FIXME avoid this cast
	}

	public @Nullable Element getType(@NonNull String modelName, @NonNull String typeName) {
		String importURI = getImportName2ImportURI().get(modelName);
		if (importURI != null) {
			org.eclipse.ocl.pivot.Package asPackage = resolveURI(importURI);
			if (asPackage != null) {
				org.eclipse.ocl.pivot.Class asClass = NameUtil.getNameable(asPackage.getOwnedClasses(), typeName);
				if (asClass != null) {
					return asClass;
				}
			}
		}
		HashSet<@NonNull String> otherURIs = new HashSet<>(getAllImportURIs());
		//		otherURIs.removeAll(getImportName2ImportURI().values());
		for (String anyURI : otherURIs) {
			org.eclipse.ocl.pivot.Package asPackage = resolveURI(anyURI);
			if (asPackage != null) {
				org.eclipse.ocl.pivot.Class asClass = NameUtil.getNameable(asPackage.getOwnedClasses(), typeName);
				if (asClass != null) {
					return asClass;
				}
			}
		}
		return null;
	}

	public @Nullable Iteration computeReferredIteration(@NonNull Type sourceType, @NonNull String opName, int itSize) {
		CompleteClass sourceCompleteClass = getOCL().getEnvironmentFactory().getCompleteModel().getCompleteClass(sourceType);
		Iterable<@NonNull Operation> operations = sourceCompleteClass.getOperations(FeatureFilter.SELECT_NON_STATIC, opName);
		for (@NonNull Operation op : operations) {
			if (op instanceof Iteration) {
				Iteration it = (Iteration)op;
				if (it.getOwnedIterators().size() == itSize) {
					return it;
				}
			}
		}
		return null;
	}

	public @Nullable Operation computeReferredOperation(@NonNull Type sourceType, @NonNull String opName, @NonNull List<Type> argTypes) {
		//		@NonNull Type[] argTypeArray = argTypes.toArray(new @NonNull Type[argTypes.size()]);
		//		OperationId operationId = sourceType.getTypeId().getOperationId(0, opName, IdManager.getParametersId(argTypeArray));
		CompleteClass sourceCompleteClass = getOCL().getEnvironmentFactory().getCompleteModel().getCompleteClass(sourceType);
		//		return sourceCompleteClass.getOperation(operationId);
		Iterable<@NonNull Operation> operations = sourceCompleteClass.getOperations(FeatureFilter.SELECT_NON_STATIC, opName);
		// FIXME resolve correct overload
		return operations.iterator().next();
	}

	public @Nullable Property computeReferredProperty(@NonNull Type sourceType, @NonNull String propName) {
		CompleteClass sourceCompleteClass = getOCL().getEnvironmentFactory().getCompleteModel().getCompleteClass(sourceType);
		return sourceCompleteClass.getProperty(propName);
	}

	//	public @NonNull List<@NonNull String> getImports() {
	//		return new ArrayList<>(getImportName2ImportURI().keySet());
	//	}

	private @NonNull Set<@NonNull String> getAllImportURIs() {
		getOCL();
		Set<@NonNull String> allImportURIs2 = allImportURIs;
		assert allImportURIs2 != null;;
		return allImportURIs2;
	}

	private @NonNull Map<@NonNull String, @NonNull String> getImportName2ImportURI() {
		getOCL();
		Map<@NonNull String, @NonNull String> importName2importURI2 = importName2importURI;
		assert importName2importURI2 != null;;
		return importName2importURI2;
	}

	public Boolean loadImports(@NonNull EObject module, @NonNull List<@NonNull String> commentsBefore) {
		Set<@NonNull String> allImportURIs2 = getAllImportURIs();
		Map<@NonNull String, @NonNull String> importName2importURI2 = getImportName2ImportURI();
		for (@NonNull String comment : commentsBefore) {
			String trimmedComment = comment.trim();
			if (trimmedComment.startsWith("--")) {
				trimmedComment = trimmedComment.substring(2).trim();
				if (trimmedComment.startsWith("@nsURI")) {
					trimmedComment = trimmedComment.substring(6).trim();
					int index = trimmedComment.indexOf("=");
					if (index >= 0) {
						String key = trimmedComment.substring(0, index).trim();
						String value = trimmedComment.substring(index+1).trim();
						importName2importURI2.put(key, value);
						if (!allImportURIs.contains(value)) {
							allImportURIs2.add(value);
						}
					}
				}
			}
		}
		return true;
	}

	public org.eclipse.ocl.pivot.Package resolveImport(@NonNull String key) {
		Map<@NonNull String, @NonNull String> importName2importURI2 = getImportName2ImportURI();
		String nsURI = importName2importURI2.get(key);
		return nsURI != null ? resolveURI(nsURI) : null;
	}

	public org.eclipse.ocl.pivot.Package resolveURI(@NonNull String nsURI) {
		EPackage ePackage = getOCL().getResourceSet().getPackageRegistry().getEPackage(nsURI);
		org.eclipse.ocl.pivot.Package asPackage = getOCL().getMetamodelManager().getASOfEcore(org.eclipse.ocl.pivot.Package.class, ePackage);
		return asPackage;
	}
} //RelationImplementationImpl
