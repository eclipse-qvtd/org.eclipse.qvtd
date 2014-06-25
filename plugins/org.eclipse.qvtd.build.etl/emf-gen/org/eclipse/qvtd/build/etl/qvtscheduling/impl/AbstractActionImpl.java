/**
 */
package org.eclipse.qvtd.build.etl.qvtscheduling.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction;
import org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum;
import org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData;
import org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractActionImpl#getResults <em>Results</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractActionImpl#getDistinctArguments <em>Distinct Arguments</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractActionImpl#getCount <em>Count</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractActionImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractActionImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractActionImpl#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractActionImpl extends MinimalEObjectImpl.Container implements AbstractAction {
	/**
	 * The cached value of the '{@link #getResults() <em>Results</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResults()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDatum> results;

	/**
	 * The cached value of the '{@link #getDistinctArguments() <em>Distinct Arguments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistinctArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<DistinctData> distinctArguments;

	/**
	 * The default value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected static final int COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected int count = COUNT_EDEFAULT;

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
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDatum> arguments;

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
		return QvtSchedulingPackage.Literals.ABSTRACT_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractDatum> getResults() {
		if (results == null) {
			results = new EObjectWithInverseResolvingEList.ManyInverse<AbstractDatum>(AbstractDatum.class, this, QvtSchedulingPackage.ABSTRACT_ACTION__RESULTS, QvtSchedulingPackage.ABSTRACT_DATUM__SOURCES);
		}
		return results;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DistinctData> getDistinctArguments() {
		if (distinctArguments == null) {
			distinctArguments = new EObjectWithInverseResolvingEList.ManyInverse<DistinctData>(DistinctData.class, this, QvtSchedulingPackage.ABSTRACT_ACTION__DISTINCT_ARGUMENTS, QvtSchedulingPackage.DISTINCT_DATA__TARGETS);
		}
		return distinctArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCount() {
		return count;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCount(int newCount) {
		int oldCount = count;
		count = newCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtSchedulingPackage.ABSTRACT_ACTION__COUNT, oldCount, count));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QvtSchedulingPackage.ABSTRACT_ACTION__PARENT, oldParent, parent));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtSchedulingPackage.ABSTRACT_ACTION__PARENT, oldParent, newParent);
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
				msgs = ((InternalEObject)parent).eInverseRemove(this, QvtSchedulingPackage.ABSTRACT_ACTION__CHILDREN, AbstractAction.class, msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, QvtSchedulingPackage.ABSTRACT_ACTION__CHILDREN, AbstractAction.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtSchedulingPackage.ABSTRACT_ACTION__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractAction> getChildren() {
		if (children == null) {
			children = new EObjectWithInverseResolvingEList<AbstractAction>(AbstractAction.class, this, QvtSchedulingPackage.ABSTRACT_ACTION__CHILDREN, QvtSchedulingPackage.ABSTRACT_ACTION__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractDatum> getArguments() {
		if (arguments == null) {
			arguments = new EObjectWithInverseResolvingEList.ManyInverse<AbstractDatum>(AbstractDatum.class, this, QvtSchedulingPackage.ABSTRACT_ACTION__ARGUMENTS, QvtSchedulingPackage.ABSTRACT_DATUM__TARGETS);
		}
		return arguments;
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
			case QvtSchedulingPackage.ABSTRACT_ACTION__RESULTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getResults()).basicAdd(otherEnd, msgs);
			case QvtSchedulingPackage.ABSTRACT_ACTION__DISTINCT_ARGUMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDistinctArguments()).basicAdd(otherEnd, msgs);
			case QvtSchedulingPackage.ABSTRACT_ACTION__PARENT:
				if (parent != null)
					msgs = ((InternalEObject)parent).eInverseRemove(this, QvtSchedulingPackage.ABSTRACT_ACTION__CHILDREN, AbstractAction.class, msgs);
				return basicSetParent((AbstractAction)otherEnd, msgs);
			case QvtSchedulingPackage.ABSTRACT_ACTION__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
			case QvtSchedulingPackage.ABSTRACT_ACTION__ARGUMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getArguments()).basicAdd(otherEnd, msgs);
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
			case QvtSchedulingPackage.ABSTRACT_ACTION__RESULTS:
				return ((InternalEList<?>)getResults()).basicRemove(otherEnd, msgs);
			case QvtSchedulingPackage.ABSTRACT_ACTION__DISTINCT_ARGUMENTS:
				return ((InternalEList<?>)getDistinctArguments()).basicRemove(otherEnd, msgs);
			case QvtSchedulingPackage.ABSTRACT_ACTION__PARENT:
				return basicSetParent(null, msgs);
			case QvtSchedulingPackage.ABSTRACT_ACTION__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
			case QvtSchedulingPackage.ABSTRACT_ACTION__ARGUMENTS:
				return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
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
			case QvtSchedulingPackage.ABSTRACT_ACTION__RESULTS:
				return getResults();
			case QvtSchedulingPackage.ABSTRACT_ACTION__DISTINCT_ARGUMENTS:
				return getDistinctArguments();
			case QvtSchedulingPackage.ABSTRACT_ACTION__COUNT:
				return getCount();
			case QvtSchedulingPackage.ABSTRACT_ACTION__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case QvtSchedulingPackage.ABSTRACT_ACTION__CHILDREN:
				return getChildren();
			case QvtSchedulingPackage.ABSTRACT_ACTION__ARGUMENTS:
				return getArguments();
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
			case QvtSchedulingPackage.ABSTRACT_ACTION__RESULTS:
				getResults().clear();
				getResults().addAll((Collection<? extends AbstractDatum>)newValue);
				return;
			case QvtSchedulingPackage.ABSTRACT_ACTION__DISTINCT_ARGUMENTS:
				getDistinctArguments().clear();
				getDistinctArguments().addAll((Collection<? extends DistinctData>)newValue);
				return;
			case QvtSchedulingPackage.ABSTRACT_ACTION__COUNT:
				setCount((Integer)newValue);
				return;
			case QvtSchedulingPackage.ABSTRACT_ACTION__PARENT:
				setParent((AbstractAction)newValue);
				return;
			case QvtSchedulingPackage.ABSTRACT_ACTION__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends AbstractAction>)newValue);
				return;
			case QvtSchedulingPackage.ABSTRACT_ACTION__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection<? extends AbstractDatum>)newValue);
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
			case QvtSchedulingPackage.ABSTRACT_ACTION__RESULTS:
				getResults().clear();
				return;
			case QvtSchedulingPackage.ABSTRACT_ACTION__DISTINCT_ARGUMENTS:
				getDistinctArguments().clear();
				return;
			case QvtSchedulingPackage.ABSTRACT_ACTION__COUNT:
				setCount(COUNT_EDEFAULT);
				return;
			case QvtSchedulingPackage.ABSTRACT_ACTION__PARENT:
				setParent((AbstractAction)null);
				return;
			case QvtSchedulingPackage.ABSTRACT_ACTION__CHILDREN:
				getChildren().clear();
				return;
			case QvtSchedulingPackage.ABSTRACT_ACTION__ARGUMENTS:
				getArguments().clear();
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
			case QvtSchedulingPackage.ABSTRACT_ACTION__RESULTS:
				return results != null && !results.isEmpty();
			case QvtSchedulingPackage.ABSTRACT_ACTION__DISTINCT_ARGUMENTS:
				return distinctArguments != null && !distinctArguments.isEmpty();
			case QvtSchedulingPackage.ABSTRACT_ACTION__COUNT:
				return count != COUNT_EDEFAULT;
			case QvtSchedulingPackage.ABSTRACT_ACTION__PARENT:
				return parent != null;
			case QvtSchedulingPackage.ABSTRACT_ACTION__CHILDREN:
				return children != null && !children.isEmpty();
			case QvtSchedulingPackage.ABSTRACT_ACTION__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
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
		result.append(" (count: ");
		result.append(count);
		result.append(')');
		return result.toString();
	}

} //AbstractActionImpl
