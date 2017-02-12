/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtschedule.NodeRole;
import org.eclipse.qvtd.pivot.qvtschedule.Phase;
import org.eclipse.qvtd.pivot.qvtschedule.Role;

public class QVTscheduleUtil extends QVTscheduleConstants
{
	public static @NonNull NodeRole asPhase(@NonNull NodeRole nodeRole, @NonNull Phase phase) {
		return getNodeRole(phase);
	}

	public static @NonNull NodeRole asPredicated(@NonNull NodeRole nodeRole) {
		return asPhase(nodeRole, Phase.PREDICATED);
	}

	public static @NonNull NodeRole asSpeculated(@NonNull NodeRole nodeRole) {
		return asPhase(nodeRole, Phase.SPECULATED);
	}

	public static @NonNull NodeRole asSpeculation(@NonNull NodeRole nodeRole) {
		return asPhase(nodeRole, Phase.SPECULATION);
	}

	public static @NonNull String getColor(@NonNull Role role) {
		switch (role.getPhase()) {
			case CONSTANT: return QVTscheduleConstants.CONSTANT_COLOR;
			case LOADED: return QVTscheduleConstants.LOADED_COLOR;
			case PREDICATED: return QVTscheduleConstants.PREDICATED_COLOR;
			case REALIZED: return QVTscheduleConstants.REALIZED_COLOR;
			case SPECULATION: return QVTscheduleConstants.SPECULATION_COLOR;
			case SPECULATED: return QVTscheduleConstants.SPECULATED_COLOR;
			default: return QVTscheduleConstants.OTHER_COLOR;
		}
	}

	public static @NonNull String getFillColor(@NonNull NodeRole nodeRole) {
		switch (nodeRole.getPhase()) {
			case CONSTANT: return LIGHT_CONSTANT_COLOR;
			case LOADED: return LIGHT_LOADED_COLOR;
			case PREDICATED: return LIGHT_PREDICATED_COLOR;
			case REALIZED: return LIGHT_REALIZED_COLOR;
			case SPECULATION: return LIGHT_SPECULATION_COLOR;
			case SPECULATED: return LIGHT_SPECULATED_COLOR;
			default: return LIGHT_OTHER_COLOR;
		}
	}

	public static @NonNull Phase getPhase(@NonNull Role role) {
		return ClassUtil.nonNullState(role.getPhase());
	}

	public static <@NonNull R extends Role> R mergeToLessKnownPhase(R firstRole, R secondRole) {
		if (firstRole.isRealized()) {
			return firstRole;
		}
		else if (secondRole.isRealized()) {
			return secondRole;
		}
		else if (firstRole.isPredicated()){
			return firstRole;
		}
		else if (secondRole.isPredicated()){
			return secondRole;
		}
		else if (firstRole.isLoaded()) {
			return firstRole;
		}
		else if (secondRole.isLoaded()) {
			return secondRole;
		}
		else if (firstRole.isConstant()) {
			return firstRole;
		}
		else if (secondRole.isConstant()) {
			return secondRole;
		}
		throw new UnsupportedOperationException();
	}

	public static <@NonNull R extends Role> R mergeToMoreKnownPhase(@NonNull R firstRole, @NonNull R secondRole) {
		if (firstRole.isConstant()) {
			return firstRole;
		}
		else if (secondRole.isConstant()) {
			return secondRole;
		}
		else if (firstRole.isLoaded()) {
			return firstRole;
		}
		else if (secondRole.isLoaded()) {
			return secondRole;
		}
		else if (firstRole.isRealized()) {
			return firstRole;
		}
		else if (secondRole.isRealized()) {
			return secondRole;
		}
		else if (firstRole.isSpeculated()) {
			return firstRole;
		}
		else if (secondRole.isSpeculated()) {
			return secondRole;
		}
		else if (firstRole.isSpeculation()) {
			return firstRole;
		}
		else if (secondRole.isSpeculation()) {
			return secondRole;
		}
		else if (firstRole.isPredicated()) {
			return firstRole;
		}
		else if (secondRole.isPredicated()) {
			return secondRole;
		}
		throw new UnsupportedOperationException();
	}
}