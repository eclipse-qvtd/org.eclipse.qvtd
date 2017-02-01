/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
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
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_names = idResolver.createOrderedSetOfAll(QVTimperativeTables.ORD_PRIMid_String, names);
		/*@NonInvalid*/ java.lang.@NonNull String s = QVTimperativeTables.STR_;
		@NonNull Iterator<Object> ITERATOR_n = BOXED_names.iterator();
		/*@Thrown*/ java.lang.@Nullable String iterate;
		while (true) {
			if (!ITERATOR_n.hasNext()) {
				iterate = s;
				break;
			}
			@SuppressWarnings("null")
			/*@NonInvalid*/ java.lang.@NonNull String n = (String)ITERATOR_n.next();
			/**
			 * if s = '' then n else s + ';' + n endif
			 */
			final /*@NonInvalid*/ boolean eq = s.equals(QVTimperativeTables.STR_);
			/*@NonInvalid*/ java.lang.@NonNull String symbol_0;
			if (eq) {
				symbol_0 = n;
			}
			else {
				final /*@NonInvalid*/ java.lang.@NonNull String sum = StringConcatOperation.INSTANCE.evaluate(s, QVTimperativeTables.STR__59);
				final /*@NonInvalid*/ java.lang.@NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, n);
				symbol_0 = sum_0;
			}
			//
			s = symbol_0;
		}
		final /*@Thrown*/ java.lang.@NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(QVTimperativeTables.STR__123, iterate);
		final /*@Thrown*/ java.lang.@NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, QVTimperativeTables.STR__125);
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
			case QVTimperativePackage.STATEMENT___JOIN_NAMES__ELIST:
				return joinNames((EList<String>)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}


} //StatementImpl
