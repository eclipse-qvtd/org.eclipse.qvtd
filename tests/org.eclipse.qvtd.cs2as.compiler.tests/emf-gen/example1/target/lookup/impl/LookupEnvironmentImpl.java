/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example1.target.lookup.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludingAllOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludingOperation;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import example1.target.NamedElement;
import example1.target.lookup.EnvironmentPackage;
import example1.target.lookup.EnvironmentTables;
import example1.target.lookup.LookupEnvironment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lookup Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example1.target.lookup.impl.LookupEnvironmentImpl#getNamedElements <em>Named Elements</em>}</li>
 *   <li>{@link example1.target.lookup.impl.LookupEnvironmentImpl#getParentEnv <em>Parent Env</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LookupEnvironmentImpl extends MinimalEObjectImpl.Container implements LookupEnvironment {
	/**
	 * The number of structural features of the '<em>Lookup Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOOKUP_ENVIRONMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Lookup Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOOKUP_ENVIRONMENT_OPERATION_COUNT = 4;

	/**
	 * The cached value of the '{@link #getNamedElements() <em>Named Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedElement> namedElements;

	/**
	 * The cached value of the '{@link #getParentEnv() <em>Parent Env</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentEnv()
	 * @generated
	 * @ordered
	 */
	protected LookupEnvironment parentEnv;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LookupEnvironmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.LOOKUP_ENVIRONMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NamedElement> getNamedElements() {
		if (namedElements == null) {
			namedElements = new EObjectResolvingEList<NamedElement>(NamedElement.class, this, 0);
		}
		return namedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LookupEnvironment getParentEnv() {
		if (parentEnv != null && parentEnv.eIsProxy()) {
			InternalEObject oldParentEnv = (InternalEObject)parentEnv;
			parentEnv = (LookupEnvironment)eResolveProxy(oldParentEnv);
			if (parentEnv != oldParentEnv) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 1, oldParentEnv, parentEnv));
			}
		}
		return parentEnv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LookupEnvironment basicGetParentEnv() {
		return parentEnv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentEnv(LookupEnvironment newParentEnv) {
		LookupEnvironment oldParentEnv = parentEnv;
		parentEnv = newParentEnv;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 1, oldParentEnv, parentEnv));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <NE extends NamedElement> LookupEnvironment addElements(final Collection<NE> elements) {
		/**
		 *
		 * LookupEnvironment{
		 *   namedElements = namedElements->includingAll(elements), parentEnv = parentEnv
		 * }
		 */
		assert elements != null;
		final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @NonNull Property CTORid_namedElements = idResolver.getProperty(EnvironmentTables.PROPid_namedElements);
		final /*@NonInvalid*/ @NonNull Property CTORid_parentEnv = idResolver.getProperty(EnvironmentTables.PROPid_parentEnv);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(EnvironmentTables.CLSSid_LookupEnvironment, null);
		final /*@NonInvalid*/ @NonNull LookupEnvironment symbol_0 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull List<NamedElement> namedElements = this.getNamedElements();
		final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(EnvironmentTables.ORD_CLSSid_NamedElement, namedElements);
		final /*@NonInvalid*/ @NonNull CollectionValue BOXED_elements = idResolver.createCollectionOfAll(EnvironmentTables.COL_TMPLid_, elements);
		final /*@NonInvalid*/ @NonNull OrderedSetValue includingAll = (@Nullable OrderedSetValue)CollectionIncludingAllOperation.INSTANCE.evaluate(BOXED_namedElements, BOXED_elements);
		final @NonNull List<NamedElement> UNBOXED_includingAll = includingAll.asEcoreObjects(idResolver, NamedElement.class);
		assert UNBOXED_includingAll != null;
		CTORid_namedElements.initValue(symbol_0, UNBOXED_includingAll);
		final /*@NonInvalid*/ @Nullable LookupEnvironment parentEnv = this.getParentEnv();
		CTORid_parentEnv.initValue(symbol_0, parentEnv);
		return symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LookupEnvironment addElement(final NamedElement element) {
		/**
		 *
		 * LookupEnvironment{
		 *   namedElements = namedElements->including(element), parentEnv = parentEnv
		 * }
		 */
		final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @NonNull Property CTORid_namedElements = idResolver.getProperty(EnvironmentTables.PROPid_namedElements);
		final /*@NonInvalid*/ @NonNull Property CTORid_parentEnv = idResolver.getProperty(EnvironmentTables.PROPid_parentEnv);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(EnvironmentTables.CLSSid_LookupEnvironment, null);
		final /*@Thrown*/ @NonNull LookupEnvironment symbol_0 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull List<NamedElement> namedElements = this.getNamedElements();
		final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(EnvironmentTables.ORD_CLSSid_NamedElement, namedElements);
		final /*@Thrown*/ @NonNull OrderedSetValue including = (@Nullable OrderedSetValue)CollectionIncludingOperation.INSTANCE.evaluate(BOXED_namedElements, element);
		final @NonNull List<NamedElement> UNBOXED_including = including.asEcoreObjects(idResolver, NamedElement.class);
		assert UNBOXED_including != null;
		CTORid_namedElements.initValue(symbol_0, UNBOXED_including);
		final /*@NonInvalid*/ @Nullable LookupEnvironment parentEnv = this.getParentEnv();
		CTORid_parentEnv.initValue(symbol_0, parentEnv);
		return symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean hasFinalResult() {
		throw new UnsupportedOperationException("LookupEnvironment::hasFinalResult() has been created for CG purposes. Don't call this method");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Executor getExecutor() {
		throw new UnsupportedOperationException("LookupEnvironment::getEvaluator() has been created for CG purposes. Don't call this method");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case 0:
				return getNamedElements();
			case 1:
				if (resolve) return getParentEnv();
				return basicGetParentEnv();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case 0:
				getNamedElements().clear();
				getNamedElements().addAll((Collection<? extends NamedElement>)newValue);
				return;
			case 1:
				setParentEnv((LookupEnvironment)newValue);
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
			case 0:
				getNamedElements().clear();
				return;
			case 1:
				setParentEnv((LookupEnvironment)null);
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
			case 0:
				return namedElements != null && !namedElements.isEmpty();
			case 1:
				return parentEnv != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case 2:
				return addElements((Collection)arguments.get(0));
			case 3:
				return addElement((NamedElement)arguments.get(0));
			case 0:
				return hasFinalResult();
			case 1:
				return getExecutor();
		}
		return super.eInvoke(operationID, arguments);
	}


} //LookupEnvironmentImpl
