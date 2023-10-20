/**
 * <copyright>
 *
 * Copyright (c) 2013, 2022 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeTables;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class StatementImpl extends NamedElementImpl implements Statement {
	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int STATEMENT_FEATURE_COUNT = NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int STATEMENT_OPERATION_COUNT = NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String joinNames(final EList<String> names) {
		/**
		 * '{' + names->iterate(n; s : String[1] = '' |
		 *   if (s = '')
		 *   then n
		 *   else s + ';' + n
		 *   endif) + '}'
		 */
		assert names != null;
		final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_names = idResolver.createOrderedSetOfAll(QVTimperativeTables.ORD_PRIMid_String, names);
		/*@NonInvalid*/ @NonNull String s = QVTimperativeTables.STR_;
		@NonNull Iterator<Object> ITERATOR_n = BOXED_names.iterator();
		/*@NonInvalid*/ @Nullable String iterate;
		while (true) {
			if (!ITERATOR_n.hasNext()) {
				iterate = s;
				break;
			}
			@SuppressWarnings("null")
			/*@NonInvalid*/ @NonNull String n = (@NonNull String)ITERATOR_n.next();
			/**
			 * if s = '' then n else s + ';' + n endif
			 */
			final /*@NonInvalid*/ boolean eq = s.equals(QVTimperativeTables.STR_);
			/*@NonInvalid*/ @NonNull String IF_eq;
			if (eq) {
				IF_eq = n;
			}
			else {
				final /*@NonInvalid*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(s, QVTimperativeTables.STR__59);
				final /*@NonInvalid*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, n);
				IF_eq = sum_0;
			}
			//
			s = IF_eq;
		}
		final /*@Thrown*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(QVTimperativeTables.STR__123, iterate);
		final /*@Thrown*/ @NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, QVTimperativeTables.STR__125);
		return sum_2;
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
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 0:
				return joinNames((EList<String>)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}


} //StatementImpl
