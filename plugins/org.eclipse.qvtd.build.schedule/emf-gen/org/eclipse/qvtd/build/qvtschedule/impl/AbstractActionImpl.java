/**
 */
package org.eclipse.qvtd.build.qvtschedule.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.build.qvtschedule.AbstractAction;
import org.eclipse.qvtd.build.qvtschedule.AbstractDatum;
import org.eclipse.qvtd.build.qvtschedule.DataParameter;
import org.eclipse.qvtd.build.qvtschedule.ParameterDerivation;
import org.eclipse.qvtd.build.qvtschedule.Schedule;
import org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractActionImpl#getProductions <em>Productions</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractActionImpl#getRequisites <em>Requisites</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractActionImpl#getParameterDerivations <em>Parameter Derivations</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractActionImpl#getOrder <em>Order</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractActionImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractActionImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractActionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractActionImpl#getResults <em>Results</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractActionImpl#getSchedule <em>Schedule</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractActionImpl extends MinimalEObjectImpl.Container implements AbstractAction {
	/**
	 * The cached value of the '{@link #getProductions() <em>Productions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductions()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDatum> productions;

	/**
	 * The cached value of the '{@link #getRequisites() <em>Requisites</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequisites()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDatum> requisites;

	/**
	 * The cached value of the '{@link #getParameterDerivations() <em>Parameter Derivations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterDerivations()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterDerivation> parameterDerivations;

	/**
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final int ORDER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected int order = ORDER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected AbstractAction parent;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractAction> children;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDatum> parameters;

	/**
	 * The cached value of the '{@link #getResults() <em>Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResults()
	 * @generated
	 * @ordered
	 */
	protected EList<DataParameter> results;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return qvtschedulePackage.Literals.ABSTRACT_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractDatum> getProductions() {
		if (productions == null) {
			productions = new EObjectWithInverseResolvingEList.ManyInverse<AbstractDatum>(AbstractDatum.class, this, qvtschedulePackage.ABSTRACT_ACTION__PRODUCTIONS, qvtschedulePackage.ABSTRACT_DATUM__PRODUCED_BY);
		}
		return productions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractDatum> getRequisites() {
		if (requisites == null) {
			requisites = new EObjectWithInverseResolvingEList.ManyInverse<AbstractDatum>(AbstractDatum.class, this, qvtschedulePackage.ABSTRACT_ACTION__REQUISITES, qvtschedulePackage.ABSTRACT_DATUM__REQUIRED_BY);
		}
		return requisites;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterDerivation> getParameterDerivations() {
		if (parameterDerivations == null) {
			parameterDerivations = new EObjectContainmentWithInverseEList<ParameterDerivation>(ParameterDerivation.class, this, qvtschedulePackage.ABSTRACT_ACTION__PARAMETER_DERIVATIONS, qvtschedulePackage.PARAMETER_DERIVATION__TARGET);
		}
		return parameterDerivations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrder(int newOrder) {
		int oldOrder = order;
		order = newOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.ABSTRACT_ACTION__ORDER, oldOrder, order));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAction getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (AbstractAction)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, qvtschedulePackage.ABSTRACT_ACTION__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAction basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(AbstractAction newParent, NotificationChain msgs) {
		AbstractAction oldParent = parent;
		parent = newParent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, qvtschedulePackage.ABSTRACT_ACTION__PARENT, oldParent, newParent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(AbstractAction newParent) {
		if (newParent != parent) {
			NotificationChain msgs = null;
			if (parent != null)
				msgs = ((InternalEObject)parent).eInverseRemove(this, qvtschedulePackage.ABSTRACT_ACTION__CHILDREN, AbstractAction.class, msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, qvtschedulePackage.ABSTRACT_ACTION__CHILDREN, AbstractAction.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.ABSTRACT_ACTION__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractAction> getChildren() {
		if (children == null) {
			children = new EObjectWithInverseResolvingEList<AbstractAction>(AbstractAction.class, this, qvtschedulePackage.ABSTRACT_ACTION__CHILDREN, qvtschedulePackage.ABSTRACT_ACTION__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractDatum> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<AbstractDatum>(AbstractDatum.class, this, qvtschedulePackage.ABSTRACT_ACTION__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataParameter> getResults() {
		if (results == null) {
			results = new EObjectContainmentEList<DataParameter>(DataParameter.class, this, qvtschedulePackage.ABSTRACT_ACTION__RESULTS);
		}
		return results;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Schedule getSchedule() {
		if (eContainerFeatureID() != qvtschedulePackage.ABSTRACT_ACTION__SCHEDULE) return null;
		return (Schedule)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSchedule(Schedule newSchedule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSchedule, qvtschedulePackage.ABSTRACT_ACTION__SCHEDULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedule(Schedule newSchedule) {
		if (newSchedule != eInternalContainer() || (eContainerFeatureID() != qvtschedulePackage.ABSTRACT_ACTION__SCHEDULE && newSchedule != null)) {
			if (EcoreUtil.isAncestor(this, newSchedule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSchedule != null)
				msgs = ((InternalEObject)newSchedule).eInverseAdd(this, qvtschedulePackage.SCHEDULE__ACTIONS, Schedule.class, msgs);
			msgs = basicSetSchedule(newSchedule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.ABSTRACT_ACTION__SCHEDULE, newSchedule, newSchedule));
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
			case qvtschedulePackage.ABSTRACT_ACTION__PRODUCTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProductions()).basicAdd(otherEnd, msgs);
			case qvtschedulePackage.ABSTRACT_ACTION__REQUISITES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequisites()).basicAdd(otherEnd, msgs);
			case qvtschedulePackage.ABSTRACT_ACTION__PARAMETER_DERIVATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameterDerivations()).basicAdd(otherEnd, msgs);
			case qvtschedulePackage.ABSTRACT_ACTION__PARENT:
				if (parent != null)
					msgs = ((InternalEObject)parent).eInverseRemove(this, qvtschedulePackage.ABSTRACT_ACTION__CHILDREN, AbstractAction.class, msgs);
				return basicSetParent((AbstractAction)otherEnd, msgs);
			case qvtschedulePackage.ABSTRACT_ACTION__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
			case qvtschedulePackage.ABSTRACT_ACTION__SCHEDULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSchedule((Schedule)otherEnd, msgs);
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
			case qvtschedulePackage.ABSTRACT_ACTION__PRODUCTIONS:
				return ((InternalEList<?>)getProductions()).basicRemove(otherEnd, msgs);
			case qvtschedulePackage.ABSTRACT_ACTION__REQUISITES:
				return ((InternalEList<?>)getRequisites()).basicRemove(otherEnd, msgs);
			case qvtschedulePackage.ABSTRACT_ACTION__PARAMETER_DERIVATIONS:
				return ((InternalEList<?>)getParameterDerivations()).basicRemove(otherEnd, msgs);
			case qvtschedulePackage.ABSTRACT_ACTION__PARENT:
				return basicSetParent(null, msgs);
			case qvtschedulePackage.ABSTRACT_ACTION__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
			case qvtschedulePackage.ABSTRACT_ACTION__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case qvtschedulePackage.ABSTRACT_ACTION__RESULTS:
				return ((InternalEList<?>)getResults()).basicRemove(otherEnd, msgs);
			case qvtschedulePackage.ABSTRACT_ACTION__SCHEDULE:
				return basicSetSchedule(null, msgs);
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
			case qvtschedulePackage.ABSTRACT_ACTION__SCHEDULE:
				return eInternalContainer().eInverseRemove(this, qvtschedulePackage.SCHEDULE__ACTIONS, Schedule.class, msgs);
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
			case qvtschedulePackage.ABSTRACT_ACTION__PRODUCTIONS:
				return getProductions();
			case qvtschedulePackage.ABSTRACT_ACTION__REQUISITES:
				return getRequisites();
			case qvtschedulePackage.ABSTRACT_ACTION__PARAMETER_DERIVATIONS:
				return getParameterDerivations();
			case qvtschedulePackage.ABSTRACT_ACTION__ORDER:
				return getOrder();
			case qvtschedulePackage.ABSTRACT_ACTION__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case qvtschedulePackage.ABSTRACT_ACTION__CHILDREN:
				return getChildren();
			case qvtschedulePackage.ABSTRACT_ACTION__PARAMETERS:
				return getParameters();
			case qvtschedulePackage.ABSTRACT_ACTION__RESULTS:
				return getResults();
			case qvtschedulePackage.ABSTRACT_ACTION__SCHEDULE:
				return getSchedule();
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
			case qvtschedulePackage.ABSTRACT_ACTION__PRODUCTIONS:
				getProductions().clear();
				getProductions().addAll((Collection<? extends AbstractDatum>)newValue);
				return;
			case qvtschedulePackage.ABSTRACT_ACTION__REQUISITES:
				getRequisites().clear();
				getRequisites().addAll((Collection<? extends AbstractDatum>)newValue);
				return;
			case qvtschedulePackage.ABSTRACT_ACTION__PARAMETER_DERIVATIONS:
				getParameterDerivations().clear();
				getParameterDerivations().addAll((Collection<? extends ParameterDerivation>)newValue);
				return;
			case qvtschedulePackage.ABSTRACT_ACTION__ORDER:
				setOrder((Integer)newValue);
				return;
			case qvtschedulePackage.ABSTRACT_ACTION__PARENT:
				setParent((AbstractAction)newValue);
				return;
			case qvtschedulePackage.ABSTRACT_ACTION__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends AbstractAction>)newValue);
				return;
			case qvtschedulePackage.ABSTRACT_ACTION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends AbstractDatum>)newValue);
				return;
			case qvtschedulePackage.ABSTRACT_ACTION__RESULTS:
				getResults().clear();
				getResults().addAll((Collection<? extends DataParameter>)newValue);
				return;
			case qvtschedulePackage.ABSTRACT_ACTION__SCHEDULE:
				setSchedule((Schedule)newValue);
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
			case qvtschedulePackage.ABSTRACT_ACTION__PRODUCTIONS:
				getProductions().clear();
				return;
			case qvtschedulePackage.ABSTRACT_ACTION__REQUISITES:
				getRequisites().clear();
				return;
			case qvtschedulePackage.ABSTRACT_ACTION__PARAMETER_DERIVATIONS:
				getParameterDerivations().clear();
				return;
			case qvtschedulePackage.ABSTRACT_ACTION__ORDER:
				setOrder(ORDER_EDEFAULT);
				return;
			case qvtschedulePackage.ABSTRACT_ACTION__PARENT:
				setParent((AbstractAction)null);
				return;
			case qvtschedulePackage.ABSTRACT_ACTION__CHILDREN:
				getChildren().clear();
				return;
			case qvtschedulePackage.ABSTRACT_ACTION__PARAMETERS:
				getParameters().clear();
				return;
			case qvtschedulePackage.ABSTRACT_ACTION__RESULTS:
				getResults().clear();
				return;
			case qvtschedulePackage.ABSTRACT_ACTION__SCHEDULE:
				setSchedule((Schedule)null);
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
			case qvtschedulePackage.ABSTRACT_ACTION__PRODUCTIONS:
				return productions != null && !productions.isEmpty();
			case qvtschedulePackage.ABSTRACT_ACTION__REQUISITES:
				return requisites != null && !requisites.isEmpty();
			case qvtschedulePackage.ABSTRACT_ACTION__PARAMETER_DERIVATIONS:
				return parameterDerivations != null && !parameterDerivations.isEmpty();
			case qvtschedulePackage.ABSTRACT_ACTION__ORDER:
				return order != ORDER_EDEFAULT;
			case qvtschedulePackage.ABSTRACT_ACTION__PARENT:
				return parent != null;
			case qvtschedulePackage.ABSTRACT_ACTION__CHILDREN:
				return children != null && !children.isEmpty();
			case qvtschedulePackage.ABSTRACT_ACTION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case qvtschedulePackage.ABSTRACT_ACTION__RESULTS:
				return results != null && !results.isEmpty();
			case qvtschedulePackage.ABSTRACT_ACTION__SCHEDULE:
				return getSchedule() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (order: ");
		result.append(order);
		result.append(')');
		return result.toString();
	}

} //AbstractActionImpl
