/**
 * <copyright>
 *
 * Copyright (c) 2018 Willink Transformations and others.
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
package org.eclipse.qvtd.text.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.qvtd.text.StringNode;
import org.eclipse.qvtd.text.TextModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.text.impl.StringNodeImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.qvtd.text.impl.StringNodeImpl#getEndText <em>End Text</em>}</li>
 *   <li>{@link org.eclipse.qvtd.text.impl.StringNodeImpl#getIndent <em>Indent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.text.impl.StringNodeImpl#getNonBreakingSpace <em>Non Breaking Space</em>}</li>
 *   <li>{@link org.eclipse.qvtd.text.impl.StringNodeImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.text.impl.StringNodeImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.qvtd.text.impl.StringNodeImpl#getSeparator <em>Separator</em>}</li>
 *   <li>{@link org.eclipse.qvtd.text.impl.StringNodeImpl#getSuffix <em>Suffix</em>}</li>
 *   <li>{@link org.eclipse.qvtd.text.impl.StringNodeImpl#getText <em>Text</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StringNodeImpl extends MinimalEObjectImpl.Container implements StringNode {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<StringNode> children;

	/**
	 * The default value of the '{@link #getEndText() <em>End Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndText()
	 * @generated
	 * @ordered
	 */
	protected static final String END_TEXT_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getEndText() <em>End Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndText()
	 * @generated
	 * @ordered
	 */
	protected String endText = END_TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndent() <em>Indent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndent()
	 * @generated
	 * @ordered
	 */
	protected static final String INDENT_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getIndent() <em>Indent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndent()
	 * @generated
	 * @ordered
	 */
	protected String indent = INDENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getNonBreakingSpace() <em>Non Breaking Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonBreakingSpace()
	 * @generated
	 * @ordered
	 */
	protected static final char NON_BREAKING_SPACE_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getNonBreakingSpace() <em>Non Breaking Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonBreakingSpace()
	 * @generated
	 * @ordered
	 */
	protected char nonBreakingSpace = NON_BREAKING_SPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String PREFIX_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefix()
	 * @generated
	 * @ordered
	 */
	protected String prefix = PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeparator() <em>Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeparator()
	 * @generated
	 * @ordered
	 */
	protected static final String SEPARATOR_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getSeparator() <em>Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeparator()
	 * @generated
	 * @ordered
	 */
	protected String separator = SEPARATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuffix() <em>Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuffix()
	 * @generated
	 * @ordered
	 */
	protected static final String SUFFIX_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getSuffix() <em>Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuffix()
	 * @generated
	 * @ordered
	 */
	protected String suffix = SUFFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TextModelPackage.Literals.STRING_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<StringNode> getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList<StringNode>(StringNode.class, this, TextModelPackage.STRING_NODE__CHILDREN, TextModelPackage.STRING_NODE__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEndText() {
		return endText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndText(String newEndText) {
		String oldEndText = endText;
		endText = newEndText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextModelPackage.STRING_NODE__END_TEXT, oldEndText, endText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIndent() {
		return indent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIndent(String newIndent) {
		String oldIndent = indent;
		indent = newIndent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextModelPackage.STRING_NODE__INDENT, oldIndent, indent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getNonBreakingSpace() {
		return nonBreakingSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNonBreakingSpace(char newNonBreakingSpace) {
		char oldNonBreakingSpace = nonBreakingSpace;
		nonBreakingSpace = newNonBreakingSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextModelPackage.STRING_NODE__NON_BREAKING_SPACE, oldNonBreakingSpace, nonBreakingSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StringNode getParent() {
		if (eContainerFeatureID() != TextModelPackage.STRING_NODE__PARENT) return null;
		return (StringNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(StringNode newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, TextModelPackage.STRING_NODE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParent(StringNode newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != TextModelPackage.STRING_NODE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, TextModelPackage.STRING_NODE__CHILDREN, StringNode.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextModelPackage.STRING_NODE__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPrefix() {
		return prefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrefix(String newPrefix) {
		String oldPrefix = prefix;
		prefix = newPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextModelPackage.STRING_NODE__PREFIX, oldPrefix, prefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSeparator() {
		return separator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSeparator(String newSeparator) {
		String oldSeparator = separator;
		separator = newSeparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextModelPackage.STRING_NODE__SEPARATOR, oldSeparator, separator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSuffix() {
		return suffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSuffix(String newSuffix) {
		String oldSuffix = suffix;
		suffix = newSuffix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextModelPackage.STRING_NODE__SUFFIX, oldSuffix, suffix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextModelPackage.STRING_NODE__TEXT, oldText, text));
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
			case TextModelPackage.STRING_NODE__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
			case TextModelPackage.STRING_NODE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((StringNode)otherEnd, msgs);
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
			case TextModelPackage.STRING_NODE__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
			case TextModelPackage.STRING_NODE__PARENT:
				return basicSetParent(null, msgs);
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
			case TextModelPackage.STRING_NODE__PARENT:
				return eInternalContainer().eInverseRemove(this, TextModelPackage.STRING_NODE__CHILDREN, StringNode.class, msgs);
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
			case TextModelPackage.STRING_NODE__CHILDREN:
				return getChildren();
			case TextModelPackage.STRING_NODE__END_TEXT:
				return getEndText();
			case TextModelPackage.STRING_NODE__INDENT:
				return getIndent();
			case TextModelPackage.STRING_NODE__NON_BREAKING_SPACE:
				return getNonBreakingSpace();
			case TextModelPackage.STRING_NODE__PARENT:
				return getParent();
			case TextModelPackage.STRING_NODE__PREFIX:
				return getPrefix();
			case TextModelPackage.STRING_NODE__SEPARATOR:
				return getSeparator();
			case TextModelPackage.STRING_NODE__SUFFIX:
				return getSuffix();
			case TextModelPackage.STRING_NODE__TEXT:
				return getText();
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
			case TextModelPackage.STRING_NODE__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends StringNode>)newValue);
				return;
			case TextModelPackage.STRING_NODE__END_TEXT:
				setEndText((String)newValue);
				return;
			case TextModelPackage.STRING_NODE__INDENT:
				setIndent((String)newValue);
				return;
			case TextModelPackage.STRING_NODE__NON_BREAKING_SPACE:
				setNonBreakingSpace((Character)newValue);
				return;
			case TextModelPackage.STRING_NODE__PARENT:
				setParent((StringNode)newValue);
				return;
			case TextModelPackage.STRING_NODE__PREFIX:
				setPrefix((String)newValue);
				return;
			case TextModelPackage.STRING_NODE__SEPARATOR:
				setSeparator((String)newValue);
				return;
			case TextModelPackage.STRING_NODE__SUFFIX:
				setSuffix((String)newValue);
				return;
			case TextModelPackage.STRING_NODE__TEXT:
				setText((String)newValue);
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
			case TextModelPackage.STRING_NODE__CHILDREN:
				getChildren().clear();
				return;
			case TextModelPackage.STRING_NODE__END_TEXT:
				setEndText(END_TEXT_EDEFAULT);
				return;
			case TextModelPackage.STRING_NODE__INDENT:
				setIndent(INDENT_EDEFAULT);
				return;
			case TextModelPackage.STRING_NODE__NON_BREAKING_SPACE:
				setNonBreakingSpace(NON_BREAKING_SPACE_EDEFAULT);
				return;
			case TextModelPackage.STRING_NODE__PARENT:
				setParent((StringNode)null);
				return;
			case TextModelPackage.STRING_NODE__PREFIX:
				setPrefix(PREFIX_EDEFAULT);
				return;
			case TextModelPackage.STRING_NODE__SEPARATOR:
				setSeparator(SEPARATOR_EDEFAULT);
				return;
			case TextModelPackage.STRING_NODE__SUFFIX:
				setSuffix(SUFFIX_EDEFAULT);
				return;
			case TextModelPackage.STRING_NODE__TEXT:
				setText(TEXT_EDEFAULT);
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
			case TextModelPackage.STRING_NODE__CHILDREN:
				return children != null && !children.isEmpty();
			case TextModelPackage.STRING_NODE__END_TEXT:
				return END_TEXT_EDEFAULT == null ? endText != null : !END_TEXT_EDEFAULT.equals(endText);
			case TextModelPackage.STRING_NODE__INDENT:
				return INDENT_EDEFAULT == null ? indent != null : !INDENT_EDEFAULT.equals(indent);
			case TextModelPackage.STRING_NODE__NON_BREAKING_SPACE:
				return nonBreakingSpace != NON_BREAKING_SPACE_EDEFAULT;
			case TextModelPackage.STRING_NODE__PARENT:
				return getParent() != null;
			case TextModelPackage.STRING_NODE__PREFIX:
				return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
			case TextModelPackage.STRING_NODE__SEPARATOR:
				return SEPARATOR_EDEFAULT == null ? separator != null : !SEPARATOR_EDEFAULT.equals(separator);
			case TextModelPackage.STRING_NODE__SUFFIX:
				return SUFFIX_EDEFAULT == null ? suffix != null : !SUFFIX_EDEFAULT.equals(suffix);
			case TextModelPackage.STRING_NODE__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
		}
		return super.eIsSet(featureID);
	}

	private void appendPosition(@NonNull StringBuilder s) {
		StringNode parent = getParent();
		if (parent == null) {
			int position = eResource().getContents().indexOf(this);
			s.append(position);
		}
		else if (parent instanceof StringNodeImpl) {
			((StringNodeImpl)parent).appendPosition(s);
			s.append(".");
			int position = parent.getChildren().indexOf(this);
			s.append(position);
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		appendPosition(s);
		s.append(": '");
		s.append(StringUtil.convertToOCLString(indent));
		s.append("', '");
		s.append(StringUtil.convertToOCLString(text));
		s.append("' {'");
		s.append(StringUtil.convertToOCLString(prefix));
		s.append("', '");
		s.append(StringUtil.convertToOCLString(separator));
		s.append("', '");
		s.append(StringUtil.convertToOCLString(suffix));
		s.append("'}");
		return s.toString();
	}
} //StringNodeImpl
