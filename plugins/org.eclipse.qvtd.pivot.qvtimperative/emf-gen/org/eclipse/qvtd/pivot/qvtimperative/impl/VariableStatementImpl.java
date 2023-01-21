/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.internal.VariableDeclarationImpl;

import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeSupport;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class VariableStatementImpl extends VariableDeclarationImpl implements VariableStatement {
	/**
	 * The number of structural features of the '<em>Variable Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VARIABLE_STATEMENT_FEATURE_COUNT = VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Variable Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VARIABLE_STATEMENT_OPERATION_COUNT = VariableDeclarationImpl.VARIABLE_DECLARATION_OPERATION_COUNT + 1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.VARIABLE_STATEMENT;
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
		final /*@NonInvalid*/ @Nullable OrderedSetValue BOXED_names = idResolver.createOrderedSetOfAll(QVTimperativeSupport.ORD_PRIMid_String, names);
		/*@NonInvalid*/ @NonNull String s = QVTimperativeSupport.STR_;
		@NonNull Iterator<Object> ITER_n = BOXED_names.iterator();
		/*@NonInvalid*/ @Nullable String iterate;
		while (true) {
			if (!ITER_n.hasNext()) {
				iterate = s;
				break;
			}
			@SuppressWarnings("null")
			/*@NonInvalid*/ @NonNull String n = (@NonNull String)ITER_n.next();
			/**
			 * if s = '' then n else s + ';' + n endif
			 */
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(s, QVTimperativeSupport.STR_);
			/*@NonInvalid*/ @NonNull String IF_IsEQ_;
			if (IsEQ_) {
				IF_IsEQ_ = n;
			}
			else {
				final /*@NonInvalid*/ @NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(s, QVTimperativeSupport.STR__59);
				final /*@NonInvalid*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_2, n);
				IF_IsEQ_ = sum_1;
			}
			//
			s = IF_IsEQ_;
		}
		final /*@NonInvalid*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(QVTimperativeSupport.STR__123, iterate);
		final /*@NonInvalid*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(sum_0, QVTimperativeSupport.STR__125);
		return sum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Statement.class) {
			switch (baseOperationID) {
				case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 0: return VariableDeclarationImpl.VARIABLE_DECLARATION_OPERATION_COUNT + 0;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
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
			case VariableDeclarationImpl.VARIABLE_DECLARATION_OPERATION_COUNT + 0:
				return joinNames((EList<String>)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}


} //VariableStatementImpl
