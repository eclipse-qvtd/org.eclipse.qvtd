/**
 */
package example2.classes.lookup.impl;

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
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludingAllOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludingOperation;
import org.eclipse.ocl.pivot.values.OrderedSetValue;

import example2.classes.NamedElement;
import example2.classes.lookup.EnvironmentPackage;
import example2.classes.lookup.EnvironmentTables;
import example2.classes.lookup.LookupEnvironment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lookup Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example2.classes.lookup.impl.LookupEnvironmentImpl#getNamedElements <em>Named Elements</em>}</li>
 *   <li>{@link example2.classes.lookup.impl.LookupEnvironmentImpl#getParentEnv <em>Parent Env</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LookupEnvironmentImpl extends MinimalEObjectImpl.Container implements LookupEnvironment {
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
	public EList<NamedElement> getNamedElements() {
		if (namedElements == null) {
			namedElements = new EObjectResolvingEList<NamedElement>(NamedElement.class, this, EnvironmentPackage.LOOKUP_ENVIRONMENT__NAMED_ELEMENTS);
		}
		return namedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LookupEnvironment getParentEnv() {
		if (parentEnv != null && parentEnv.eIsProxy()) {
			InternalEObject oldParentEnv = (InternalEObject)parentEnv;
			parentEnv = (LookupEnvironment)eResolveProxy(oldParentEnv);
			if (parentEnv != oldParentEnv) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EnvironmentPackage.LOOKUP_ENVIRONMENT__PARENT_ENV, oldParentEnv, parentEnv));
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
	public void setParentEnv(LookupEnvironment newParentEnv) {
		LookupEnvironment oldParentEnv = parentEnv;
		parentEnv = newParentEnv;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.LOOKUP_ENVIRONMENT__PARENT_ENV, oldParentEnv, parentEnv));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <NE extends NamedElement> LookupEnvironment addElements(final Collection<NE> elements) {
		/**
		 * 
		 * LookupEnvironment{
		 *   namedElements = namedElements->includingAll(elements), parentEnv = parentEnv
		 * }
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property CTORid_namedElements = idResolver.getProperty(EnvironmentTables.PROPid_namedElements);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property CTORid_parentEnv = idResolver.getProperty(EnvironmentTables.PROPid_parentEnv);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(EnvironmentTables.CLSSid_LookupEnvironment, null);
		final /*@Thrown*/ example2.classes.lookup.@NonNull LookupEnvironment symbol_0 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
		@SuppressWarnings("null")
		final /*@Thrown*/ java.util.@NonNull List<NamedElement> namedElements = this.getNamedElements();
		final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(EnvironmentTables.ORD_CLSSid_NamedElement, namedElements);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull CollectionValue BOXED_elements = idResolver.createCollectionOfAll(EnvironmentTables.COL_TMPLid_, elements);
		final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull CollectionValue includingAll = CollectionIncludingAllOperation.INSTANCE.evaluate(BOXED_namedElements, BOXED_elements);
		final List<? extends Object> UNBOXED_includingAll = includingAll.asEcoreObjects(idResolver, Object.class);
		assert UNBOXED_includingAll != null;
		CTORid_namedElements.initValue(symbol_0, UNBOXED_includingAll);
		final /*@Thrown*/ example2.classes.lookup.@Nullable LookupEnvironment parentEnv = this.getParentEnv();
		CTORid_parentEnv.initValue(symbol_0, parentEnv);
		return symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LookupEnvironment addElement(final NamedElement element) {
		/**
		 * 
		 * LookupEnvironment{
		 *   namedElements = namedElements->including(element), parentEnv = parentEnv
		 * }
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property CTORid_namedElements = idResolver.getProperty(EnvironmentTables.PROPid_namedElements);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property CTORid_parentEnv = idResolver.getProperty(EnvironmentTables.PROPid_parentEnv);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(EnvironmentTables.CLSSid_LookupEnvironment, null);
		final /*@Thrown*/ example2.classes.lookup.@NonNull LookupEnvironment symbol_0 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
		@SuppressWarnings("null")
		final /*@Thrown*/ java.util.@NonNull List<NamedElement> namedElements = this.getNamedElements();
		final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(EnvironmentTables.ORD_CLSSid_NamedElement, namedElements);
		final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue including = (OrderedSetValue)CollectionIncludingOperation.INSTANCE.evaluate(BOXED_namedElements, element);
		final List<NamedElement> UNBOXED_including = including.asEcoreObjects(idResolver, NamedElement.class);
		assert UNBOXED_including != null;
		CTORid_namedElements.initValue(symbol_0, UNBOXED_including);
		final /*@Thrown*/ example2.classes.lookup.@Nullable LookupEnvironment parentEnv = this.getParentEnv();
		CTORid_parentEnv.initValue(symbol_0, parentEnv);
		return symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean hasFinalResult() {
		throw new UnsupportedOperationException("LookupEnvironment::hasFinalResult() has been created for CG purposes. Don't call this method");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
			case EnvironmentPackage.LOOKUP_ENVIRONMENT__NAMED_ELEMENTS:
				return getNamedElements();
			case EnvironmentPackage.LOOKUP_ENVIRONMENT__PARENT_ENV:
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
			case EnvironmentPackage.LOOKUP_ENVIRONMENT__NAMED_ELEMENTS:
				getNamedElements().clear();
				getNamedElements().addAll((Collection<? extends NamedElement>)newValue);
				return;
			case EnvironmentPackage.LOOKUP_ENVIRONMENT__PARENT_ENV:
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
			case EnvironmentPackage.LOOKUP_ENVIRONMENT__NAMED_ELEMENTS:
				getNamedElements().clear();
				return;
			case EnvironmentPackage.LOOKUP_ENVIRONMENT__PARENT_ENV:
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
			case EnvironmentPackage.LOOKUP_ENVIRONMENT__NAMED_ELEMENTS:
				return namedElements != null && !namedElements.isEmpty();
			case EnvironmentPackage.LOOKUP_ENVIRONMENT__PARENT_ENV:
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
			case EnvironmentPackage.LOOKUP_ENVIRONMENT___ADD_ELEMENTS__COLLECTION:
				return addElements((Collection)arguments.get(0));
			case EnvironmentPackage.LOOKUP_ENVIRONMENT___ADD_ELEMENT__NAMEDELEMENT:
				return addElement((NamedElement)arguments.get(0));
			case EnvironmentPackage.LOOKUP_ENVIRONMENT___HAS_FINAL_RESULT:
				return hasFinalResult();
			case EnvironmentPackage.LOOKUP_ENVIRONMENT___GET_EXECUTOR:
				return getExecutor();
		}
		return super.eInvoke(operationID, arguments);
	}


} //LookupEnvironmentImpl
