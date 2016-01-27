/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

/**
	 * A HeadNodeGroup groups ClassNodes that appear in 1:1 relationships at the head of a mapping predicate. 
	 * The 1:1 guarantees that if any group member is available, all group members are equally available.
	 * Therefore production/consumption of one is not distinct from production/consumption of another.
	 */
	public class HeadNodeGroup implements Iterable<Map.Entry<MappingRegion, List<Node>>>
	{
//		private @NonNull List<ClassNode> headNodes = new ArrayList<ClassNode>();
		private @NonNull Map<MappingRegion, List<Node>> mappingRegion2headNodes = new HashMap<MappingRegion, List<Node>>();

//		public void add(@NonNull ClassNode headNode) {
//			if (!headNodes.contains(headNode)) {
//				headNodes.add(headNode);
//			}
//		}

		@Override
		public Iterator<Map.Entry<MappingRegion, List<Node>>> iterator() {
			return mappingRegion2headNodes.entrySet().iterator();
		}

		public void addMappingRegion(@NonNull MappingRegion mappingRegion, @NonNull List<Node> headNodes) {
			List<Node> oldHeadNodes = mappingRegion2headNodes.put(mappingRegion, headNodes);
			assert oldHeadNodes == null;
		}

		public @NonNull Collection<MappingRegion> getRegions() {
			return mappingRegion2headNodes.keySet();
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			for (Map.Entry<MappingRegion, List<Node>> entry : this) {
				if (s.length() > 0) {
					s.append("\n\t");
				}
				s.append(entry.getKey().getName());
				s.append("=>");
				s.append(entry.getValue());
			}
			return s.toString();
		}
	}