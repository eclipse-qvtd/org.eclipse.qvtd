/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.evaluation.AbstractExecutor;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.AbstractInterpretedInvocation;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;
import org.eclipse.qvtd.runtime.evaluation.InvocationManager;
import org.eclipse.qvtd.runtime.evaluation.SimpleConnection;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractInvocationConstructor;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractInvocationManagerInternal;
import org.junit.Test;

import junit.framework.TestCase;


public class RuntimeConnectionTests extends TestCase
{
	public static final class Tester
	{
		protected final @NonNull OCL ocl;
		protected final @NonNull TestExecutor executor;
		protected final @NonNull TestInvocationManager invocationManager;
		protected final @NonNull TestInvocationConstructor invocationConstructor;
		protected final @NonNull List<@NonNull TestConnection> testConnections = new ArrayList<>();

		public Tester() {
			ocl = OCL.newInstance();
			executor = new TestExecutor(ocl.getEnvironmentFactory());
			invocationManager = new TestInvocationManager(executor);
			invocationConstructor = new TestInvocationConstructor(invocationManager, "name", false);
		}

		public void addConsumedConnection(@NonNull TestConnection testConnection) {
			invocationConstructor.addConsumedConnection(testConnection);
			testConnections.add(testConnection);
		}

		public void check() {
			StringBuilder s = new StringBuilder();
			check(0, "9", s);
			check(s.toString());
		}

		private void check(int connectionIndex, @NonNull String partialString, @NonNull StringBuilder s) {
			if (connectionIndex < testConnections.size()) {
				for (int i = 0; i < testConnections.get(connectionIndex).counter; i++) {
					check(connectionIndex+1, partialString + i, s);
				}
			}
			else {
				if (s.length() > 0) {
					s.append(",");
				}
				s.append(partialString);
			}
		}

		public void check(@Nullable String stringValue) {
			invocationManager.flush();
			if (stringValue != null) {
				assertEquals(stringValue, invocationConstructor.stringValue());
			}
			int product = 1;
			for (@NonNull TestConnection testConnection : testConnections) {
				product *= testConnection.counter;
			}
			TestCase.assertEquals(product, invocationConstructor.allValues.size());
			@NonNull Object[] values = new @NonNull Object[testConnections.size()];
			invocationConstructor.check(0, values, testConnections);
		}

		public @NonNull TestConnection createConsumedConnection() {
			String name = "connection" + testConnections.size();
			TestConnection testConnection = new TestConnection(invocationManager.getRootInterval(), name, TypeId.INTEGER);
			addConsumedConnection(testConnection);
			return testConnection;
		}

		public void dispose() {
			ocl.dispose();
		}

		public @NonNull TestInvocationConstructor getInvocationConstructor() {
			return invocationConstructor;
		}
	}

	public static final class TestExecutor extends AbstractExecutor
	{
		public TestExecutor(@NonNull EnvironmentFactory environmentFactory) {
			super((@NonNull EnvironmentFactoryInternalExtension) environmentFactory);
		}

		@Override
		public @NonNull ModelManager getModelManager() {
			throw new UnsupportedOperationException();
		}
	}

	public static final class TestInvocationManager extends AbstractInvocationManagerInternal
	{
		public TestInvocationManager(@NonNull Executor executor) {
			super(executor);
		}
	}

	public static final class TestInvocationConstructor extends AbstractInvocationConstructor
	{
		protected final @NonNull Set<@NonNull Integer> allValues = new HashSet<>();

		public TestInvocationConstructor(@NonNull InvocationManager invocationManager, @NonNull String name, boolean isStrict) {
			super(invocationManager, name, isStrict);
		}

		public void executed(@NonNull Object @NonNull [] values) {
			int intValue = compositeValue(values);
			boolean wasAdded = allValues.add(intValue);
			TestCase.assertTrue(wasAdded);
		}

		public void check(int consumerIndex, @NonNull Object @NonNull [] values, @NonNull List<@NonNull TestConnection> testConnections) {
			if (consumerIndex >= testConnections.size()) {
				int intValue = compositeValue(values);
				TestCase.assertTrue(allValues.contains(intValue));
			}
			else {
				for (int i = 0; i < testConnections.get(consumerIndex).counter; i++) {
					values[consumerIndex] = i;
					check(consumerIndex+1, values, testConnections);
				}
			}
		}

		private int compositeValue(@NonNull Object @NonNull [] values) {
			int intValue = 9;
			for (@NonNull Object value : values) {
				intValue = 10 * intValue + ((Integer)value).intValue();
			}
			return intValue;
		}

		@Override
		public @NonNull Invocation newInstance(@NonNull Object @NonNull [] values) {
			return new TestInvocation(this, values);
		}

		public @NonNull String stringValue() {
			List<@NonNull Integer> intValues = new ArrayList<>(allValues);
			Collections.sort(intValues);
			StringBuilder s = new StringBuilder();
			for (int i = 0; i < intValues.size(); i++) {
				if (i != 0) {
					s.append(",");
				}
				s.append(intValues.get(i));
			}
			return s.toString();
		}
	}

	public static final class TestInvocation extends AbstractInterpretedInvocation
	{
		protected final @NonNull TestInvocationConstructor invocationConstructor;

		public TestInvocation(@NonNull TestInvocationConstructor invocationConstructor, @NonNull Object @NonNull [] values) {
			super(invocationConstructor, values);
			this.invocationConstructor = invocationConstructor;
		}

		@Override
		public boolean execute() throws InvocationFailedException {
			invocationConstructor.executed(values);
			return false;
		}
	}

	public static final class TestConnection extends SimpleConnection
	{
		private Integer counter = 0;

		public TestConnection(@NonNull Interval interval, @NonNull String name, @NonNull TypeId typeId) {
			super(interval, name, typeId);
		}

		public void append() {
			append(counter++);
		}
	}

	@Test
	public void testRuntime_DoubleSimpleConnection() {
		Tester tester = new Tester();
		TestConnection connection0  = tester.createConsumedConnection();
		TestConnection connection1  = tester.createConsumedConnection();
		//
		tester.check("");
		//
		tester.check("");
		//
		connection0.append();
		tester.check("");
		//
		connection1.append();
		tester.check("900");
		//
		tester.check("900");
		//
		connection1.append();
		tester.check("900,901");
		//
		connection1.append();
		tester.check("900,901,902");
		//
		connection0.append();
		tester.check("900,901,902,910,911,912");
		//
		connection1.append();
		tester.check("900,901,902,903,910,911,912,913");
		//
		connection0.append();
		connection0.append();
		connection0.append();
		tester.check();
		//
		connection1.append();
		connection1.append();
		tester.check();
		//
		tester.check();
		//
		tester.dispose();
	}

	@Test
	public void testRuntime_RedundantDoubleSimpleConnection() {
		Tester tester = new Tester();
		TestConnection connection0  = tester.createConsumedConnection();
		tester.addConsumedConnection(connection0);
		//
		tester.check("");
		//
		tester.check("");
		//
		connection0.append();
		tester.check("900");
		//
		tester.check("900");
		//
		connection0.append();
		tester.check("900,901,910,911");
		//
		connection0.append();
		tester.check("900,901,902,910,911,912,920,921,922");
		//
		connection0.append();
		tester.check();
		//
		connection0.append();
		tester.check();
		//
		connection0.append();
		connection0.append();
		connection0.append();
		tester.check();
		//
		connection0.append();
		connection0.append();
		tester.check();
		//
		tester.check();
		//
		tester.dispose();
	}

	@Test
	public void testRuntime_SingleSimpleConnection() {
		Tester tester = new Tester();
		TestConnection connection0  = tester.createConsumedConnection();
		//
		tester.check("");
		//
		tester.check("");
		//
		connection0.append();
		tester.check("90");
		//
		tester.check("90");
		//
		connection0.append();
		connection0.append();
		tester.check("90,91,92");
		//
		connection0.append();
		tester.check("90,91,92,93");
		//
		connection0.append();
		connection0.append();
		connection0.append();
		tester.check("90,91,92,93,94,95,96");
		//
		tester.check();
		//
		tester.dispose();
	}

	@Test
	public void testRuntime_TripleSimpleConnection() {
		Tester tester = new Tester();
		TestConnection connection0  = tester.createConsumedConnection();
		TestConnection connection1  = tester.createConsumedConnection();
		TestConnection connection2  = tester.createConsumedConnection();
		//
		tester.check("");
		//
		tester.check("");
		//
		connection0.append();
		tester.check("");
		//
		connection1.append();
		tester.check("");
		//
		connection2.append();
		tester.check("9000");
		//
		tester.check("9000");
		//
		connection1.append();
		tester.check("9000,9010");
		//
		connection1.append();
		tester.check("9000,9010,9020");
		//
		connection0.append();
		tester.check("9000,9010,9020,9100,9110,9120");
		//
		connection2.append();
		tester.check("9000,9001,9010,9011,9020,9021,9100,9101,9110,9111,9120,9121");
		//
		connection0.append();
		connection1.append();
		connection0.append();
		tester.check();
		//
		connection1.append();
		connection1.append();
		tester.check();
		//
		connection2.append();
		connection2.append();
		tester.check();
		//
		connection0.append();
		tester.check();
		//
		tester.check();
		//
		tester.dispose();
	}
}
