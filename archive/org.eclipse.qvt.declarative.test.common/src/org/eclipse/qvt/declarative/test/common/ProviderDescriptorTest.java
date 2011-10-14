package org.eclipse.qvt.declarative.test.common;

import junit.framework.Assert;

import org.eclipse.qvt.declarative.common.framework.service.ProviderDescriptor;
import org.eclipse.qvt.declarative.test.common.mock.DummyProvider;
import org.eclipse.qvt.declarative.test.common.mock.FakeOperation;
import org.eclipse.qvt.declarative.test.common.mock.FalseOperation;
import org.junit.Test;

public class ProviderDescriptorTest extends ProviderDescriptor {
	
	public ProviderDescriptorTest() {
		super(ServiceTest.CONFIGURATION_ELEMENTS[0]);
	}

	@Test
	public void testGetConfigurationElement() {
		Assert.assertEquals(ServiceTest.CONFIGURATION_ELEMENTS[0], getConfigurationElement());
	}

	@Test
	public void testGetDescribedProvider() {
		Assert.assertTrue(getDescribedProvider() instanceof DummyProvider);
	}

	@Test
	public void testGetPriority() {
		Assert.assertEquals(getPriority(), Priority.normal);
	}

	@Test
	public void testGetProviderClassName() {
		Assert.assertEquals("org.eclipse.qvt.declarative.test.common.mock.DummyProvider", getProviderClassName());
	}

	@Test
	public void testProvides() {
		Assert.assertTrue(provides(new FakeOperation()));
		Assert.assertFalse(provides(new FalseOperation()));
	}

}
