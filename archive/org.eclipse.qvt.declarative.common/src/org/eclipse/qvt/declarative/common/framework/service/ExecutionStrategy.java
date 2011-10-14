/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * </copyright>
 * 
 * Contributors:
 *     Quentin Glineur - initial API and implementation
 *
 * $Id: ExecutionStrategy.java,v 1.5 2008/10/13 16:01:02 qglineur Exp $
 */
package org.eclipse.qvt.declarative.common.framework.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ExecutionStrategy {
	
	public abstract List<Object> execute (Service service, Operation operation) throws Exception;
	
	public static ExecutionStrategy FIRST = new ExecutionStrategy() {

		@SuppressWarnings("unchecked")
		@Override
		public List<Object> execute(Service service, Operation operation) throws Exception {
			assert null != operation : "null operation"; //$NON-NLS-1$
			Provider provider = service.getFirstProvider(operation);
			if (provider != null) {
				Object result = operation.execute(provider);
				if (result instanceof List<?>) {
					return (List<Object>) result;
				}
				return Collections.singletonList(result);
			}
			return null;
		}
		
	};
	
	public static ExecutionStrategy DESCENDING = new ExecutionStrategy() {

		@Override
		public List<Object> execute(Service service, Operation operation) throws Exception {
			assert null != operation : "null operation"; //$NON-NLS-1$
			List<Provider> providers = service.getProvidersByPriorityDescending(operation);
			List<Object> result = new ArrayList<Object>();
			for (Provider provider : providers) {
				result.add(operation.execute(provider));
			}
			return result;
		}
		
	};

}
