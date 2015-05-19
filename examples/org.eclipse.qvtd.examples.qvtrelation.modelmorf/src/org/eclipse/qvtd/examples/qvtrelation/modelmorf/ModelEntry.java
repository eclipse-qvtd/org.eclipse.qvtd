/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.examples.qvtrelation.modelmorf;

public class ModelEntry {
	private String variable;
	private String file;
	private String variableRef;
	private String deltaFile;
	private boolean bound  = false;
	private boolean delta = false;
	public String getVariable() {
		return variable;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
		setBound(false);
	}
	public String getVariableRef() {
		return variableRef;
	}
	public void setVariableRef(String variableRef) {
		this.variableRef = variableRef;
		setBound(true);
	}
	public String getDeltaFile() {
		return deltaFile;
	}
	public void setDeltaFile(String deltaFile) {
		this.deltaFile = deltaFile;
		setDelta(true);
	}
	public boolean isBound() {
		return bound;
	}
	public void setBound(boolean bound) {
		this.bound = bound;
	}
	public boolean hasDelta() {
		return delta;
	}
	public void setDelta(boolean delta) {
		this.delta = delta;
	}
	
	
	
}