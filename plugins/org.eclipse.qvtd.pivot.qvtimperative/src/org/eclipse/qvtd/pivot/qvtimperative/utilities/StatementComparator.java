/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;

/**
 * StatementComparator supports sorting a list of Statements into a least dependent first then alphabetical order.
 */
public class StatementComparator implements Comparator<@NonNull Statement>
{
	private final @NonNull List<@NonNull Statement> statements;
	private @Nullable Map<@NonNull Statement, @NonNull Set<@NonNull VariableDeclaration>> statement2referencedVariables = null;

	public StatementComparator(@NonNull List<@NonNull Statement> statements) {
		this.statements = statements;
	}

	@Override
	public int compare(@NonNull Statement o1, @NonNull Statement o2) {
		boolean isOk = (o2 instanceof MappingLoop);
		if (isOk != (o1 instanceof MappingLoop)) {
			return isOk ? -1 : 1;
		}
		isOk = (o2 instanceof SetStatement);
		if (isOk != (o1 instanceof SetStatement)) {
			return isOk ? -1 : 1;
		}
		isOk = (o2 instanceof NewStatement);
		if (isOk != (o1 instanceof NewStatement)) {
			return isOk ? -1 : 1;
		}
		isOk = (o2 instanceof CheckStatement);
		if (isOk != (o1 instanceof CheckStatement)) {
			toString();
		}
		Map<@NonNull Statement, @NonNull Set<@NonNull VariableDeclaration>> statement2referencedVariables2 = statement2referencedVariables;
		if (statement2referencedVariables2 == null) {
			statement2referencedVariables2 = statement2referencedVariables = computeReferencedVariableClosure();
		}
		Set<@NonNull VariableDeclaration> r1 = statement2referencedVariables2.get(o1);
		Set<@NonNull VariableDeclaration> r2 = statement2referencedVariables2.get(o2);
		assert ((r1 != null) && (r2 != null));
		int diff = r1.size() - r2.size();
		if (diff != 0) {
			return diff;
		}
		//		}
		//		else {
		//			System.out.println(o1 + " wrt " + o2);
		//		}
		String n1 = o1.getName();
		String n2 = o2.getName();
		return ClassUtil.safeCompareTo(n1, n2);
	}

	private @NonNull Map<@NonNull Statement, @NonNull Set<@NonNull VariableDeclaration>> computeReferencedVariableClosure() {
		Map<@NonNull Statement, @NonNull Set<@NonNull VariableDeclaration>> statement2referencedVariables2 = new HashMap<>();
		Map<@NonNull VariableDeclaration, @NonNull Statement> variable2statement = new HashMap<>();
		//
		//	Compute the direct references of each variable
		//
		for (@NonNull Statement statement : statements) {
			if (statement instanceof VariableStatement) {
				variable2statement.put((VariableStatement)statement, statement);
			}
			Set<@NonNull VariableDeclaration> referencedVariables = new HashSet<>();
			for (EObject eObject : new TreeIterable(statement, false)) {
				if (eObject instanceof VariableExp) {
					VariableDeclaration referredVariable = ((VariableExp)eObject).getReferredVariable();
					assert referredVariable != null;
					referencedVariables.add(referredVariable);
				}
				else if (eObject instanceof VariableDeclaration) {
					referencedVariables.add((VariableDeclaration)eObject);
				}
			}
			statement2referencedVariables2.put(statement, referencedVariables);
		}
		//		}
		//
		//	Aggregate the closure
		//
		while (true) {
			boolean more = false;
			for (@NonNull Statement statement : statement2referencedVariables2.keySet()) {
				Set<@NonNull VariableDeclaration> referencedVariables = statement2referencedVariables2.get(statement);
				assert referencedVariables != null;
				for (@NonNull VariableDeclaration referencedVariable : new ArrayList<>(referencedVariables)) {
					Statement referencedStatement = variable2statement.get(referencedVariable);
					if (referencedStatement != null) {
						Set<@NonNull VariableDeclaration> referencedReferencedVariables = statement2referencedVariables2.get(referencedStatement);
						if ((referencedReferencedVariables != null) && referencedVariables.addAll(referencedReferencedVariables)) {
							more = true;
						}
					}
				}
			}
			if (!more) {
				break;
			}
		}
		return statement2referencedVariables2;
	}
}