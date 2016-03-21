/**
 */
package example2.classes.lookup.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.collection.CollectionExcludingOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludingOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;

import example2.classes.NamedElement;
import example2.classes.lookup.EnvEntry;
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
 *   <li>{@link example2.classes.lookup.impl.LookupEnvironmentImpl#getEntries <em>Entries</em>}</li>
 *   <li>{@link example2.classes.lookup.impl.LookupEnvironmentImpl#getParentEnv <em>Parent Env</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LookupEnvironmentImpl extends MinimalEObjectImpl.Container implements LookupEnvironment {
	/**
	 * The cached value of the '{@link #getEntries() <em>Entries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntries()
	 * @generated
	 * @ordered
	 */
	protected EList<EnvEntry> entries;

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
	public EList<EnvEntry> getEntries() {
		if (entries == null) {
			entries = new EObjectContainmentWithInverseEList<EnvEntry>(EnvEntry.class, this, EnvironmentPackage.LOOKUP_ENVIRONMENT__ENTRIES, EnvironmentPackage.ENV_ENTRY__ENV);
		}
		return entries;
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
		 * elements->iterate(x; acc : LookupEnvironment[?] = self |
		 *   acc.addElement(x))
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull CollectionValue BOXED_elements = idResolver.createCollectionOfAll(EnvironmentTables.COL_TMPLid_, elements);
		/*@NonInvalid*/ example2.classes.lookup.@NonNull LookupEnvironment acc = this;
		@Nullable Iterator<?> ITERATOR_x = BOXED_elements.iterator();
		/*@Thrown*/ example2.classes.lookup.@Nullable LookupEnvironment iterate;
		while (true) {
		    if (!ITERATOR_x.hasNext()) {
		        iterate = acc;
		        break;
		    }
		    /*@NonInvalid*/ example2.classes.@Nullable NamedElement x = (NamedElement)ITERATOR_x.next();
		    /**
		     * acc.addElement(x)
		     */
		    @SuppressWarnings("null")
		    final /*@Thrown*/ example2.classes.lookup.@NonNull LookupEnvironment addElement = acc.addElement(x);
		    //
		    acc = addElement;
		}
		if (iterate == null) {
		    throw new InvalidValueException("Null body for \'lookup::LookupEnvironment::addElements(NE)(Collection(addElements.NE)) : lookup::LookupEnvironment[1]\'");
		}
		return iterate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LookupEnvironment addElement(final NamedElement element) {
		/**
		 * addElementWithName(element.name, element)
		 */
		final /*@Thrown*/ java.lang.@Nullable String name = element.getName();
		@SuppressWarnings("null")
		final /*@Thrown*/ example2.classes.lookup.@NonNull LookupEnvironment addElementWithName = this.addElementWithName(name, element);
		return addElementWithName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LookupEnvironment addElementWithName(final String entryName, final NamedElement element) {
		/**
		 * 
		 * let entry : OrderedSet(lookup::EnvEntry) = entries->select(name = entryName)
		 * in
		 *   LookupEnvironment{
		 *     entries = if entry = null
		 *     then
		 *       entries->including(
		 *         EnvEntry{name = entryName, namedElements = OrderedSet{element}
		 *         })
		 *     else
		 *       entries->excluding(entry)
		 *       ->including(
		 *         EnvEntry{
		 *           name = entryName, namedElements = entry.namedElements->including(element)
		 *         })
		 *     endif
		 *   }
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@Thrown*/ java.util.@NonNull List<EnvEntry> entries = this.getEntries();
		final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_entries = idResolver.createOrderedSetOfAll(EnvironmentTables.ORD_CLSSid_EnvEntry, entries);
		/*@Thrown*/ OrderedSetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(EnvironmentTables.ORD_CLSSid_EnvEntry);
		@Nullable Iterator<?> ITERATOR__1 = BOXED_entries.iterator();
		/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue entry;
		while (true) {
		    if (!ITERATOR__1.hasNext()) {
		        entry = accumulator;
		        break;
		    }
		    /*@NonInvalid*/ example2.classes.lookup.@Nullable EnvEntry _1 = (EnvEntry)ITERATOR__1.next();
		    /**
		     * name = entryName
		     */
		    if (_1 == null) {
		        throw new InvalidValueException("Null source for \'\'http://cs2as/tests/example2/env/1.0\'::EnvEntry::name\'");
		    }
		    final /*@Thrown*/ java.lang.@Nullable String name = _1.getName();
		    final /*@Thrown*/ boolean eq = (name != null) ? name.equals(entryName) : (entryName == null);
		    //
		    if (eq == ValueUtil.TRUE_VALUE) {
		        accumulator.add(_1);
		    }
		}
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property CTORid_name_0 = idResolver.getProperty(EnvironmentTables.PROPid_name);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_EnvEntry_1 = idResolver.getClass(EnvironmentTables.CLSSid_EnvEntry, null);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(EnvironmentTables.CLSSid_LookupEnvironment, null);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property CTORid_entries = idResolver.getProperty(EnvironmentTables.PROPid_entries);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property CTORid_namedElements_0 = idResolver.getProperty(EnvironmentTables.PROPid_namedElements);
		final /*@Thrown*/ example2.classes.lookup.@NonNull LookupEnvironment symbol_3 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
		final /*@Thrown*/ boolean eq_0 = false;
		/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue symbol_2;
		if (eq_0) {
		    final /*@Thrown*/ example2.classes.lookup.@NonNull EnvEntry symbol_0 = (EnvEntry)TYP_lookup_c_c_EnvEntry_1.createInstance();
		    CTORid_name_0.initValue(symbol_0, entryName);
		    final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue OrderedSet = ValueUtil.createOrderedSetOfEach(EnvironmentTables.ORD_CLSSid_NamedElement, element);
		    final List<NamedElement> UNBOXED_OrderedSet = OrderedSet.asEcoreObjects(idResolver, NamedElement.class);
		    assert UNBOXED_OrderedSet != null;
		    CTORid_namedElements_0.initValue(symbol_0, UNBOXED_OrderedSet);
		    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue including = (OrderedSetValue)CollectionIncludingOperation.INSTANCE.evaluate(BOXED_entries, symbol_0);
		    symbol_2 = including;
		}
		else {
		    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue excluding = (OrderedSetValue)CollectionExcludingOperation.INSTANCE.evaluate(BOXED_entries, entry);
		    final /*@Thrown*/ example2.classes.lookup.@NonNull EnvEntry symbol_1 = (EnvEntry)TYP_lookup_c_c_EnvEntry_1.createInstance();
		    CTORid_name_0.initValue(symbol_1, entryName);
		    /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(EnvironmentTables.SEQ_CLSSid_NamedElement);
		    @Nullable Iterator<?> ITERATOR__1_0 = entry.iterator();
		    /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SequenceValue collect;
		    while (true) {
		        if (!ITERATOR__1_0.hasNext()) {
		            collect = accumulator_0;
		            break;
		        }
		        /*@NonInvalid*/ example2.classes.lookup.@Nullable EnvEntry _1_0 = (EnvEntry)ITERATOR__1_0.next();
		        /**
		         * namedElements
		         */
		        if (_1_0 == null) {
		            throw new InvalidValueException("Null source for \'\'http://cs2as/tests/example2/env/1.0\'::EnvEntry::namedElements\'");
		        }
		        @SuppressWarnings("null")
		        final /*@Thrown*/ java.util.@NonNull List<NamedElement> namedElements_0 = _1_0.getNamedElements();
		        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_namedElements_0 = idResolver.createOrderedSetOfAll(EnvironmentTables.ORD_CLSSid_NamedElement, namedElements_0);
		        //
		        for (Object value : BOXED_namedElements_0.flatten().getElements()) {
		            accumulator_0.add(value);
		        }
		    }
		    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SequenceValue including_0 = (SequenceValue)CollectionIncludingOperation.INSTANCE.evaluate(collect, element);
		    final List<NamedElement> UNBOXED_including_0 = including_0.asEcoreObjects(idResolver, NamedElement.class);
		    assert UNBOXED_including_0 != null;
		    CTORid_namedElements_0.initValue(symbol_1, UNBOXED_including_0);
		    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue including_1 = (OrderedSetValue)CollectionIncludingOperation.INSTANCE.evaluate(excluding, symbol_1);
		    symbol_2 = including_1;
		}
		final List<EnvEntry> UNBOXED_symbol_2 = symbol_2.asEcoreObjects(idResolver, EnvEntry.class);
		assert UNBOXED_symbol_2 != null;
		CTORid_entries.initValue(symbol_3, UNBOXED_symbol_2);
		return symbol_3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NamedElement> getNamedElements(final String entryName) {
		/**
		 * 
		 * let entry : OrderedSet(lookup::EnvEntry) = entries->select(name = entryName)
		 * in if entry = null then OrderedSet{} else entry.namedElements endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@Thrown*/ java.util.@NonNull List<EnvEntry> entries = this.getEntries();
		final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_entries = idResolver.createOrderedSetOfAll(EnvironmentTables.ORD_CLSSid_EnvEntry, entries);
		/*@Thrown*/ OrderedSetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(EnvironmentTables.ORD_CLSSid_EnvEntry);
		@Nullable Iterator<?> ITERATOR__1 = BOXED_entries.iterator();
		/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue entry;
		while (true) {
		    if (!ITERATOR__1.hasNext()) {
		        entry = accumulator;
		        break;
		    }
		    /*@NonInvalid*/ example2.classes.lookup.@Nullable EnvEntry _1 = (EnvEntry)ITERATOR__1.next();
		    /**
		     * name = entryName
		     */
		    if (_1 == null) {
		        throw new InvalidValueException("Null source for \'\'http://cs2as/tests/example2/env/1.0\'::EnvEntry::name\'");
		    }
		    final /*@Thrown*/ java.lang.@Nullable String name = _1.getName();
		    final /*@Thrown*/ boolean eq = (name != null) ? name.equals(entryName) : (entryName == null);
		    //
		    if (eq == ValueUtil.TRUE_VALUE) {
		        accumulator.add(_1);
		    }
		}
		/*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(EnvironmentTables.SEQ_CLSSid_NamedElement);
		@Nullable Iterator<?> ITERATOR__1_0 = entry.iterator();
		/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SequenceValue collect;
		while (true) {
		    if (!ITERATOR__1_0.hasNext()) {
		        collect = accumulator_0;
		        break;
		    }
		    /*@NonInvalid*/ example2.classes.lookup.@Nullable EnvEntry _1_0 = (EnvEntry)ITERATOR__1_0.next();
		    /**
		     * namedElements
		     */
		    if (_1_0 == null) {
		        throw new InvalidValueException("Null source for \'\'http://cs2as/tests/example2/env/1.0\'::EnvEntry::namedElements\'");
		    }
		    @SuppressWarnings("null")
		    final /*@Thrown*/ java.util.@NonNull List<NamedElement> namedElements = _1_0.getNamedElements();
		    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(EnvironmentTables.ORD_CLSSid_NamedElement, namedElements);
		    //
		    for (Object value : BOXED_namedElements.flatten().getElements()) {
		        accumulator_0.add(value);
		    }
		}
		final /*@Thrown*/ java.util.@NonNull List<NamedElement> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(NamedElement.class, collect);
		return (EList<NamedElement>)ECORE_collect;
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EnvironmentPackage.LOOKUP_ENVIRONMENT__ENTRIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEntries()).basicAdd(otherEnd, msgs);
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
			case EnvironmentPackage.LOOKUP_ENVIRONMENT__ENTRIES:
				return ((InternalEList<?>)getEntries()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EnvironmentPackage.LOOKUP_ENVIRONMENT__ENTRIES:
				return getEntries();
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
			case EnvironmentPackage.LOOKUP_ENVIRONMENT__ENTRIES:
				getEntries().clear();
				getEntries().addAll((Collection<? extends EnvEntry>)newValue);
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
			case EnvironmentPackage.LOOKUP_ENVIRONMENT__ENTRIES:
				getEntries().clear();
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
			case EnvironmentPackage.LOOKUP_ENVIRONMENT__ENTRIES:
				return entries != null && !entries.isEmpty();
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
			case EnvironmentPackage.LOOKUP_ENVIRONMENT___ADD_ELEMENT_WITH_NAME__STRING_NAMEDELEMENT:
				return addElementWithName((String)arguments.get(0), (NamedElement)arguments.get(1));
			case EnvironmentPackage.LOOKUP_ENVIRONMENT___GET_NAMED_ELEMENTS__STRING:
				return getNamedElements((String)arguments.get(0));
			case EnvironmentPackage.LOOKUP_ENVIRONMENT___HAS_FINAL_RESULT:
				return hasFinalResult();
			case EnvironmentPackage.LOOKUP_ENVIRONMENT___GET_EXECUTOR:
				return getExecutor();
		}
		return super.eInvoke(operationID, arguments);
	}


} //LookupEnvironmentImpl
