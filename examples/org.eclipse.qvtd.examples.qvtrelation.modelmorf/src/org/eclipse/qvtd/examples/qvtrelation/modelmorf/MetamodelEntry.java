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