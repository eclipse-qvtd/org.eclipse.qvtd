/**
 * <copyright>
 *
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToGraphHelper;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.Utility;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Navigation Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigationEdgeImpl#getOppositeEdge <em>Opposite Edge</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigationEdgeImpl#isPartial <em>Partial</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigationEdgeImpl#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigationEdgeImpl#isSecondary <em>Secondary</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NavigationEdgeImpl extends NavigableEdgeImpl implements NavigationEdge {
	/**
	 * The number of structural features of the '<em>Navigation Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NAVIGATION_EDGE_FEATURE_COUNT = NavigableEdgeImpl.NAVIGABLE_EDGE_FEATURE_COUNT + 4;
	/**
	 * The number of operations of the '<em>Navigation Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NAVIGATION_EDGE_OPERATION_COUNT = NavigableEdgeImpl.NAVIGABLE_EDGE_OPERATION_COUNT + 0;
	/**
	 * The cached value of the '{@link #getOppositeEdge() <em>Opposite Edge</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOppositeEdge()
	 * @generated
	 * @ordered
	 */
	protected NavigationEdge oppositeEdge;
	/**
	 * The default value of the '{@link #isPartial() <em>Partial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartial()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PARTIAL_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isPartial() <em>Partial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartial()
	 * @generated
	 * @ordered
	 */
	protected boolean partial = PARTIAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferredProperty() <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredProperty()
	 * @generated
	 * @ordered
	 */
	protected Property referredProperty;
	/**
	 * The default value of the '{@link #isSecondary() <em>Secondary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSecondary()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SECONDARY_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isSecondary() <em>Secondary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSecondary()
	 * @generated
	 * @ordered
	 */
	protected boolean secondary = SECONDARY_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NavigationEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.NAVIGATION_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NavigationEdge getOppositeEdge() {
		if (oppositeEdge != null && oppositeEdge.eIsProxy()) {
			InternalEObject oldOppositeEdge = (InternalEObject)oppositeEdge;
			oppositeEdge = (NavigationEdge)eResolveProxy(oldOppositeEdge);
			if (oppositeEdge != oldOppositeEdge) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 9, oldOppositeEdge, oppositeEdge));
			}
		}
		return oppositeEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigationEdge basicGetOppositeEdge() {
		return oppositeEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOppositeEdge(NavigationEdge newOppositeEdge) {
		NavigationEdge oldOppositeEdge = oppositeEdge;
		oppositeEdge = newOppositeEdge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 9, oldOppositeEdge, oppositeEdge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPartial() {
		return partial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private void setPartialGen(boolean newPartial) {
		boolean oldPartial = partial;
		partial = newPartial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 10, oldPartial, partial));
	}
	@Override
	public void setPartial(boolean newPartial) {
		if (eContainer() != null) {				// null while loading from XML
			checkIsPartial(newPartial);
		}
		setPartialGen(newPartial);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getReferredProperty() {
		if (referredProperty != null && referredProperty.eIsProxy()) {
			InternalEObject oldReferredProperty = (InternalEObject)referredProperty;
			referredProperty = (Property)eResolveProxy(oldReferredProperty);
			if (referredProperty != oldReferredProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 11, oldReferredProperty, referredProperty));
			}
		}
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetReferredProperty() {
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredProperty(Property newReferredProperty) {
		Property oldReferredProperty = referredProperty;
		referredProperty = newReferredProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 11, oldReferredProperty, referredProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSecondary() {
		return secondary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecondary(boolean newSecondary) {
		boolean oldSecondary = secondary;
		secondary = newSecondary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 12, oldSecondary, secondary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 9:
				if (resolve) return getOppositeEdge();
				return basicGetOppositeEdge();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 10:
				return isPartial();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 11:
				if (resolve) return getReferredProperty();
				return basicGetReferredProperty();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 12:
				return isSecondary();
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 9:
				setOppositeEdge((NavigationEdge)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 10:
				setPartial((Boolean)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 11:
				setReferredProperty((Property)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 12:
				setSecondary((Boolean)newValue);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 9:
				setOppositeEdge((NavigationEdge)null);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 10:
				setPartial(PARTIAL_EDEFAULT);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 11:
				setReferredProperty((Property)null);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 12:
				setSecondary(SECONDARY_EDEFAULT);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 9:
				return oppositeEdge != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 10:
				return partial != PARTIAL_EDEFAULT;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 11:
				return referredProperty != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 12:
				return secondary != SECONDARY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public @NonNull String toString() {
		return super.toString();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		if (visitor instanceof QVTscheduleVisitor) {
			return (R) ((QVTscheduleVisitor<?>)visitor).visitNavigationEdge(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	@Override
	public void appendEdgeAttributes(@NonNull ToGraphHelper toGraphHelper, @NonNull String sourceName, @NonNull String targetName) {
		GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
		toGraphHelper.setColor(this);
		NavigationEdge oppositeEdge2 = oppositeEdge;
		if (oppositeEdge2 != null) {
			String oppositeName = oppositeEdge2.getReferredProperty().getName();
			String oppositeLabel = oppositeEdge2.getLabel();
			ClassDatum sourceClassDatum = QVTscheduleUtil.getClassDatum(QVTscheduleUtil.getSourceNode(this));
			for (@NonNull CompleteClass completeClass : QVTscheduleUtil.getCompleteClasses(sourceClassDatum)) {
				if ((oppositeLabel != null) && !oppositeName.equals(completeClass.getName())) {
					s.setTaillabel(oppositeLabel);
					break;
				}
			}
		}
		String label = getLabel();
		if (label != null) {
			s.setHeadlabel(label);
		}
		String style = getStyle();
		if (style != null) {
			s.setStyle(style);
		}
		boolean isComposite = (referredProperty != null) && referredProperty.isIsComposite();
		if (isComposite) {
			s.setDir("both");
			s.setArrowtail("diamond");
		}
		else if (!isSecondary() && (oppositeEdge2 != null)) {
			s.setDir("both");
			s.setArrowtail(oppositeEdge2.isPartial() ? "none" : "vee");
		}
		boolean isOppositeComposite = (referredProperty != null) && (referredProperty.getOpposite() != null) && referredProperty.getOpposite().isIsComposite();
		s.setArrowhead(partial ? "none" : isOppositeComposite ? "diamond" : "normal");
		s.setPenwidth(getPenwidth());
		s.appendAttributedEdge(sourceName, this, targetName);
	}

	private void checkIsPartial(boolean isPartial) {
		Node targetNode = QVTscheduleUtil.getTargetNode(this);
		ClassDatum targetClassDatum = QVTscheduleUtil.getClassDatum(targetNode);
		Property property = QVTscheduleUtil.getReferredProperty(this);
		boolean isComputedPartial = false;
		Type propertyTargetType = PivotUtil.getType(property);
		if (!conformsTo(targetClassDatum, propertyTargetType)) {
			if (propertyTargetType instanceof CollectionType) {
				Type elementType = PivotUtil.getElementType(((CollectionType)propertyTargetType));
				if (conformsTo(targetClassDatum, elementType)) {
					isComputedPartial = true;
				}
			}
		}
		assert isPartial == isComputedPartial;
	}

	/**
	 * Return true if thisClassDatum conforms to, i.e can be used as, thatType.
	 *
	 * If the ClassDatum is a multi-CompleteClass it is sufficient that any one of thisClassDatum's CompleteClasses conforms to thatType.
	 *
	 * This provate version of QVTscheduleUtil.comformsTo worksound the lack of access to a scheduleManager tyo create the property's CompleteClass.
	 */
	private boolean conformsTo(@NonNull ClassDatum thisClassDatum, @NonNull Type thatType) {
		List<@NonNull CompleteClass> theseCompleteClasses = thisClassDatum.basicGetCompleteClasses();
		if (theseCompleteClasses == null) {
			return false;
		}
		for (@NonNull CompleteClass thisCompleteClass : theseCompleteClasses) {
			if (thisCompleteClass.conformsTo(thatType)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public @NonNull NavigableEdge createEdge(@NonNull Role edgeRole, @NonNull Utility utility, @NonNull Node sourceNode, @NonNull Node targetNode) {
		NavigationEdge edge = (NavigationEdge)super.createEdge(edgeRole, utility, sourceNode, targetNode);
		edge.initializeProperty(QVTscheduleUtil.getReferredProperty(this), utility, isPartial());
		return edge;
	}

	@Override
	public void destroy() {
		NavigableEdge oppositeEdge = this.oppositeEdge;
		if (oppositeEdge != null) {
			this.oppositeEdge = null;
			oppositeEdge.destroy();
		}
		else {
			super.destroy();
		}
	}

	@Override
	public @NonNull String getDisplayName() {
		Property source2targetProperty2 = getReferredProperty();
		if (source2targetProperty2 != null) {
			org.eclipse.ocl.pivot.Class owningClass = source2targetProperty2.getOwningClass();
			if (owningClass != null) {
				return owningClass.getName() + "::" + source2targetProperty2.getName();
			}
			else {
				return "" + source2targetProperty2.getName();
			}
		}
		else {
			return "null";
		}
	}

	@Override
	public @NonNull String getEdgeName() {
		return PivotUtil.getName(QVTscheduleUtil.getReferredProperty(this));
	}

	@Override
	public @NonNull NavigableEdge getForwardEdge() {
		if (secondary) {
			assert oppositeEdge != null;
			return oppositeEdge;
		}
		else {
			return this;
		}
	}

	@Override
	public @Nullable String getLabel() {
		Property source2targetProperty2 = getReferredProperty();
		if (source2targetProperty2 == null) {
			return "null";
		}
		if (partial) {
			String multiplicityString = PivotUtil.getMultiplicity(source2targetProperty2);
			return super.getLabel() + "\\n" + multiplicityString.substring(0, 1) + "1 of " + multiplicityString.substring(1);
		}
		else {
			if (source2targetProperty2.eContainer() != null) {
				return source2targetProperty2.getName() + "\\n" + PivotUtil.getMultiplicity(source2targetProperty2);
			}
			else {
				return source2targetProperty2.getName();
			}
		}
	}

	//	@Override
	//	public Property getProperty() {
	//		return getReferredProperty();
	//	}

	protected void initializeOpposite(@NonNull NavigationEdge oppositeEdge) {
		this.oppositeEdge = oppositeEdge;
		((NavigationEdgeImpl)oppositeEdge).oppositeEdge = this;
		// This differs from QVTscheduleUtil.getPrimaryProperty(property) which returns a context-independent forward/reverse choice as a baseProperty.
		// The secondary here favours the calling usage as primary unlss it must be reversed.
		// This makes a difference for the StructuredCladsses JUnit test that gets an NPE when assigning a not-null/null containment relationship backwards.
		if (this.getReferredProperty().isIsImplicit()) {
			this.secondary = true;
		}
		else if (partial && !((NavigationEdgeImpl)oppositeEdge).partial) {
			this.secondary = true;
		}
		else {
			((NavigationEdgeImpl)oppositeEdge).secondary = true;
		}
	}

	@Override
	public void initializeProperty(@NonNull Property property, @NonNull Utility utility, boolean isPartial) {
		setReferredProperty(property);
		setPartial(isPartial);
		Property target2sourceProperty = property.getOpposite();
		if (target2sourceProperty != null)  {
			Node targetNode2 = targetNode;
			assert targetNode2 != null;
			if (!targetNode2.isNullLiteral()) {
				assert (targetNode2.getOutgoingNavigableEdge(target2sourceProperty) == null) || target2sourceProperty.isIsMany() || (isPartial() == Boolean.TRUE);
				boolean isClassComposite = property.isIsComposite() && targetNode.isClass();
				boolean isBidirectionalOneToOne = !property.isIsMany() && !target2sourceProperty.isIsMany();
				if (isClassComposite || isBidirectionalOneToOne /*&& target2sourceProperty.isIsRequired()*/) {		// FIXME do we need stronger type conformance here ??
					Role edgeRole2 = edgeRole;
					Node sourceNode2 = sourceNode;
					assert (edgeRole2 != null) && (sourceNode2 != null);
					NavigationEdge reverseEdge = QVTscheduleFactory.eINSTANCE.createNavigationEdge();
					reverseEdge.initialize(edgeRole2, utility, targetNode2, target2sourceProperty.getName(), sourceNode2);
					reverseEdge.setReferredProperty(target2sourceProperty);
					reverseEdge.setPartial(false /*isPartial()*/);			// FIXME assert false not isPartial()
					initializeOpposite(reverseEdge);
				}
			}
		}
	}

	@Override
	public final boolean isNavigation() {
		return true;
	}

	@Override
	public void setSource(@Nullable Node sourceNode) {
		assert (sourceNode == null) || !sourceNode.isNullLiteral();
		super.setSource(sourceNode);
	}

} //NavigationEdgeImpl
