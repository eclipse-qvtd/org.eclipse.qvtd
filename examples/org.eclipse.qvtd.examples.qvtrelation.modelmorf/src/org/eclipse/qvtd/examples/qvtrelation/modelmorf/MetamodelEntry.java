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

public class MetamodelEntry {
	
	private String alias;
	private String file;
	private String reference;
	private boolean relative = false;
	
	
	public MetamodelEntry() {
	}
	
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
		setRelative(false);
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
		setRelative(true);
	}
	
	public boolean isRelative() {
		return relative;
	}
	
	public void setRelative(boolean relative) {
		this.relative = relative;
	}
	
}