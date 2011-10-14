package org.eclipse.qvt.declarative.test.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.qvt.declarative.common.framework.service.ExecutionStrategy;
import org.eclipse.qvt.declarative.common.framework.service.Provider;
import org.eclipse.qvt.declarative.common.framework.service.ProviderDescriptor;
import org.eclipse.qvt.declarative.common.framework.service.Service;
import org.eclipse.qvt.declarative.common.framework.service.ProviderDescriptor.Priority;
import org.eclipse.qvt.declarative.test.common.mock.DummyProvider;
import org.eclipse.qvt.declarative.test.common.mock.FakeOperation;
import org.eclipse.qvt.declarative.test.common.mock.LowerDummyProvider;
import org.junit.Before;
import org.junit.Test;

public class ServiceTest extends Service {
	
	protected static final String EXTENSION_POINT_NAME = "useless_extension";
	
	protected static final IConfigurationElement[] CONFIGURATION_ELEMENTS = Platform.getExtensionRegistry().getExtensionPoint(Activator.PLUGIN_ID, EXTENSION_POINT_NAME).getConfigurationElements();
	
	@Before
	public void setUp() throws Exception {
		for (Map.Entry<ProviderDescriptor.Priority, ArrayList<Provider>> entry : providers.entrySet()) {
			entry.getValue().clear();
		}
	}

	@Test
	public void testExecute() throws Exception {
		providers.get(Priority.highest).add(new DummyProvider());
		Object result = execute(ExecutionStrategy.FIRST, new FakeOperation());
		if (result instanceof List<?>) {
			List<?> resultList = (List<?>) result;
			Assert.assertEquals(1, resultList.size());
			Object object = resultList.get(0);
			if (object instanceof String) {
				String resultString = (String) object;
				Assert.assertEquals(FakeOperation.OPERATION_NAME+DummyProvider.ACCOMPLISHMENT, resultString);
			} else {
				Assert.fail();
			}
			
		} else {
			Assert.fail();
		}
	}

	@Test
	public void testService() {
		Assert.assertNotNull(providers);
	}

	@Test
	public void testProvides() {
		providers.get(Priority.highest).add(new DummyProvider());
		Assert.assertTrue(provides(new FakeOperation()));
	}

	@Test
	public void testRegisterProvidersIConfigurationElement() {
		registerProviders(CONFIGURATION_ELEMENTS);
		List<Provider> normalProviders = providers.get(Priority.normal);
		Assert.assertEquals(1, normalProviders.size());
		Provider provider = normalProviders.get(0);
		if (provider instanceof ProviderDescriptor) {
			ProviderDescriptor descriptor = (ProviderDescriptor) provider;
			Assert.assertTrue(descriptor.getDescribedProvider() instanceof DummyProvider);
		} else {
			Assert.fail();
		}
	}
	
	@Test
	public void testRegisterProvidersStringString() {
		registerProviders(Activator.PLUGIN_ID, EXTENSION_POINT_NAME);
		List<Provider> normalProviders = providers.get(Priority.normal);
		Assert.assertEquals(1, normalProviders.size());
		Provider provider = normalProviders.get(0);
		if (provider instanceof ProviderDescriptor) {
			ProviderDescriptor descriptor = (ProviderDescriptor) provider;
			Assert.assertTrue(descriptor.getDescribedProvider() instanceof DummyProvider);
		} else {
			Assert.fail();
		}
	}

	@Test
	public void testAddProvider() {
		addProvider(Priority.highest, new ProviderDescriptor(CONFIGURATION_ELEMENTS[0]));
		List<Provider> highestProviders = providers.get(Priority.highest);
		Assert.assertEquals(1, highestProviders.size());
		Provider provider = highestProviders.get(0);
		if (provider instanceof ProviderDescriptor) {
			ProviderDescriptor descriptor = (ProviderDescriptor) provider;
			Assert.assertTrue(descriptor.getDescribedProvider() instanceof DummyProvider);
		} else {
			Assert.fail();
		}
	}

	@Test
	public void testGetFirstProvider() {
		providers.get(Priority.highest).add(new DummyProvider());
		providers.get(Priority.high).add(new LowerDummyProvider());
		Provider provider = getFirstProvider(new FakeOperation());
		Assert.assertTrue(provider instanceof DummyProvider);
	}

	@Test
	public void testGetProvidersByPriorityDescending() {
		providers.get(Priority.highest).add(new DummyProvider());
		providers.get(Priority.high).add(new LowerDummyProvider());
		List<Provider> providers = getProvidersByPriorityDescending(new FakeOperation());
		Assert.assertEquals(2, providers.size());
		Assert.assertTrue(providers.get(0) instanceof DummyProvider);
		Assert.assertTrue(providers.get(1) instanceof LowerDummyProvider);
	}

}
