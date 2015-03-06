/**
 */
package example2.env.impl;

import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.collection.CollectionAsSequenceOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludingAllOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludingOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import example2.classes.NamedElement;
import example2.env.Environment;
import example2.env.EnvironmentPackage;
import example2.env.EnvironmentTables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example2.env.impl.EnvironmentImpl#getNamedElements <em>Named Elements</em>}</li>
 *   <li>{@link example2.env.impl.EnvironmentImpl#getParentEnv <em>Parent Env</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnvironmentImpl extends MinimalEObjectImpl.Container implements Environment {
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
	protected Environment parentEnv;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnvironmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.ENVIRONMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getNamedElements() {
		if (namedElements == null) {
			namedElements = new EObjectResolvingEList<NamedElement>(NamedElement.class, this, EnvironmentPackage.ENVIRONMENT__NAMED_ELEMENTS);
		}
		return namedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment getParentEnv() {
		if (parentEnv != null && parentEnv.eIsProxy()) {
			InternalEObject oldParentEnv = (InternalEObject)parentEnv;
			parentEnv = (Environment)eResolveProxy(oldParentEnv);
			if (parentEnv != oldParentEnv) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EnvironmentPackage.ENVIRONMENT__PARENT_ENV, oldParentEnv, parentEnv));
			}
		}
		return parentEnv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment basicGetParentEnv() {
		return parentEnv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentEnv(Environment newParentEnv) {
		Environment oldParentEnv = parentEnv;
		parentEnv = newParentEnv;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.ENVIRONMENT__PARENT_ENV, oldParentEnv, parentEnv));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment addElements(final EList<NamedElement> elements) {
		/**
		 * Environment{
		 *   namedElements = namedElements->asSequence()
		 *   ->includingAll(elements), parentEnv = parentEnv}
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@NonInvalid*/ Property CTORid_namedElements = idResolver.getProperty(EnvironmentTables.PROPid_namedElements);
		final /*@NonNull*/ /*@NonInvalid*/ Property CTORid_parentEnv = idResolver.getProperty(EnvironmentTables.PROPid_parentEnv);
		final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_0 = idResolver.getClass(EnvironmentTables.CLSSid_Environment, null);
		final /*@NonNull*/ /*@Thrown*/ Environment symbol_0 = (Environment)TYP_env_c_c_Environment_0.createInstance();
		final /*@NonNull*/ /*@Thrown*/ List<NamedElement> namedElements = this.getNamedElements();
		final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(EnvironmentTables.ORD_CLSSid_NamedElement, namedElements);
		final /*@NonNull*/ /*@Thrown*/ SequenceValue asSequence = ClassUtil.nonNullState(CollectionAsSequenceOperation.INSTANCE.evaluate(BOXED_namedElements));
		final /*@NonNull*/ /*@NonInvalid*/ OrderedSetValue BOXED_elements = idResolver.createOrderedSetOfAll(EnvironmentTables.ORD_CLSSid_NamedElement, elements);
		final /*@NonNull*/ /*@Thrown*/ CollectionValue includingAll = ClassUtil.nonNullState(CollectionIncludingAllOperation.INSTANCE.evaluate(asSequence, BOXED_elements));
		final List<NamedElement> UNBOXED_includingAll = includingAll.asEcoreObjects(idResolver, example2.classes.NamedElement.class);
		assert UNBOXED_includingAll != null;
		CTORid_namedElements.initValue(symbol_0, UNBOXED_includingAll);
		final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.getParentEnv();
		CTORid_parentEnv.initValue(symbol_0, parentEnv);
		return (Environment)symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment addElement(final NamedElement element) {
		/**
		 * Environment{
		 *   namedElements = namedElements->asSequence()
		 *   ->including(element), parentEnv = parentEnv}
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@NonInvalid*/ Property CTORid_namedElements = idResolver.getProperty(EnvironmentTables.PROPid_namedElements);
		final /*@NonNull*/ /*@NonInvalid*/ Property CTORid_parentEnv = idResolver.getProperty(EnvironmentTables.PROPid_parentEnv);
		final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_0 = idResolver.getClass(EnvironmentTables.CLSSid_Environment, null);
		final /*@NonNull*/ /*@Thrown*/ Environment symbol_0 = (Environment)TYP_env_c_c_Environment_0.createInstance();
		final /*@NonNull*/ /*@Thrown*/ List<NamedElement> namedElements = this.getNamedElements();
		final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(EnvironmentTables.ORD_CLSSid_NamedElement, namedElements);
		final /*@NonNull*/ /*@Thrown*/ SequenceValue asSequence = ClassUtil.nonNullState(CollectionAsSequenceOperation.INSTANCE.evaluate(BOXED_namedElements));
		final /*@NonNull*/ /*@Thrown*/ SequenceValue including = ClassUtil.nonNullState((SequenceValue)CollectionIncludingOperation.INSTANCE.evaluate(asSequence, element));
		final List<NamedElement> UNBOXED_including = including.asEcoreObjects(idResolver, example2.classes.NamedElement.class);
		assert UNBOXED_including != null;
		CTORid_namedElements.initValue(symbol_0, UNBOXED_including);
		final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.getParentEnv();
		CTORid_parentEnv.initValue(symbol_0, parentEnv);
		return (Environment)symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean hasFinalResult() {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example2/env/1.0!Env4CG!hasFinalResult()
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Evaluator getEvaluator() {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example2/env/1.0!Env4CG!getEvaluator()
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EnvironmentPackage.ENVIRONMENT__NAMED_ELEMENTS:
				return getNamedElements();
			case EnvironmentPackage.ENVIRONMENT__PARENT_ENV:
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
			case EnvironmentPackage.ENVIRONMENT__NAMED_ELEMENTS:
				getNamedElements().clear();
				getNamedElements().addAll((Collection<? extends NamedElement>)newValue);
				return;
			case EnvironmentPackage.ENVIRONMENT__PARENT_ENV:
				setParentEnv((Environment)newValue);
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
			case EnvironmentPackage.ENVIRONMENT__NAMED_ELEMENTS:
				getNamedElements().clear();
				return;
			case EnvironmentPackage.ENVIRONMENT__PARENT_ENV:
				setParentEnv((Environment)null);
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
			case EnvironmentPackage.ENVIRONMENT__NAMED_ELEMENTS:
				return namedElements != null && !namedElements.isEmpty();
			case EnvironmentPackage.ENVIRONMENT__PARENT_ENV:
				return parentEnv != null;
		}
		return super.eIsSet(featureID);
	}




} //EnvironmentImpl
