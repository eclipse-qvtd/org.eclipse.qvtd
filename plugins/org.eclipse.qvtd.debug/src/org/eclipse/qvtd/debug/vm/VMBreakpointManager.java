/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.vm;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.debug.utils.CompiledUnit;
import org.eclipse.qvtd.debug.utils.LineNumberProvider;
import org.eclipse.qvtd.debug.vm.protocol.BreakpointData;
import org.eclipse.qvtd.debug.vm.protocol.NewBreakpointData;


public class VMBreakpointManager {
    
	private final Map<EObject, VMBreakpoint> fElement2Breakpoint;
	
	protected final @NonNull MetaModelManager metaModelManager;
	private final UnitManager fUnitManager;
	
    // FIXME - Simulates an fBreakpointID that does not come from the VM client
    // based on the knowledge that marker long fBreakpointID is used (positive number)
	// this one will be negative long
    long fPrivateBreakpointID = 0;


	public VMBreakpointManager(@NonNull MetaModelManager metaModelManager, @NonNull CompiledUnit mainUnit) {
		if(mainUnit == null) {
			throw new IllegalArgumentException("null main unit"); //$NON-NLS-1$
		}
		this.metaModelManager = metaModelManager;
		fUnitManager = new UnitManager(metaModelManager, mainUnit);
		fElement2Breakpoint = new HashMap<EObject, VMBreakpoint>();
	}
			
	public UnitManager getUnitManager() {
		return fUnitManager;
	}
	
	public synchronized List<VMBreakpoint> getBreakpoints(Element e) {
		VMBreakpoint breakpoint = fElement2Breakpoint.get(e);
		return (breakpoint != null) ? Collections.singletonList(breakpoint) : Collections.<VMBreakpoint>emptyList();
	}
	
	
	public synchronized VMBreakpoint createBreakpoint(NewBreakpointData data) {
    	// FIXME - raise CoreEXxc... for invalid uris
    	URI uri = URI.createURI(data.targetURI);
    	
    	// FIXME - a temp hack to get correct source URI when running a separate VM
    	if(uri.isPlatformResource() && isPlatformDeployed()) {
    		uri = URI.createPlatformPluginURI(uri.toPlatformString(true), true);
    	} 

    	if(fUnitManager.getCompiledModule(uri) == null) {
    		// FIXME - unify on using encoded form, only UI should receive decoded
    		uri = URI.createURI(URI.decode(uri.toString()));
    	}
    	
    	int line = data.line;
    	Element targetElement = getBreakpointableElement(uri, line);
        if(targetElement == null) {
            return null;
        }

        VMBreakpoint vmBreakpoint = new VMBreakpoint(targetElement, data, false);
        fElement2Breakpoint.put(targetElement, vmBreakpoint);
        return vmBreakpoint;
    }

    
    public synchronized VMBreakpoint createVMPrivateBreakpoint(URI unitURI, Element element, int line, boolean isTemporary) throws CoreException {
        NewBreakpointData bpData = new NewBreakpointData();
        bpData.ID = --fPrivateBreakpointID;
        bpData.targetURI = unitURI.toString();
        bpData.line = line;
        
        VMBreakpoint breakpoint = new VMBreakpoint(element, bpData, isTemporary);        
        fElement2Breakpoint.put(element, breakpoint);
        return breakpoint;
    }
    

	public synchronized VMBreakpoint[] getAllBreakpoints() {
		return fElement2Breakpoint.values().toArray(new VMBreakpoint[fElement2Breakpoint.size()]);
	}
    
	public synchronized Element getBreakpointableElement(URI targetURI, int lineNumber) {
        LineNumberProvider lineNumberProvider = fUnitManager.getLineNumberProvider(targetURI);
        if(lineNumberProvider == null) {
        	return null;
        }
        
		CompiledUnit unit = fUnitManager.getCompiledModule(targetURI);
        List<Element> elements = ValidBreakpointLocator.getBreakpointableElementsForLine(unit, lineNumberProvider, lineNumber);
        if(elements.isEmpty()) {
            return null;
        }
        
        return elements.get(0);
    }
	

    public boolean removeBreakpoint(VMBreakpoint breakpoint) {
    	return removeBreakpoint(breakpoint.getID());
    }
		
    public synchronized boolean removeBreakpoint(long breakpointID) {
        for(Map.Entry<EObject, VMBreakpoint> entry : fElement2Breakpoint.entrySet()) {
            VMBreakpoint next = entry.getValue();
            if(breakpointID == next.getID()) {
                fElement2Breakpoint.remove(entry.getKey());
                return true;
            }
        }
        return false;
    }

 
    public synchronized boolean changeBreakpoint(long breakpointID, BreakpointData data) {
    	NewBreakpointData newBreakpointData = null;
    	
        for(Map.Entry<EObject, VMBreakpoint> entry : fElement2Breakpoint.entrySet()) {
            VMBreakpoint next = entry.getValue();
            if(breakpointID == next.getID()) {
            	fElement2Breakpoint.remove(entry.getKey());

            	
            	newBreakpointData = new NewBreakpointData(
						breakpointID, next.getLineNumber(), next.getUri(), data);
            	break;
            }
        }	
        
        if(newBreakpointData != null) {
        	createBreakpoint(newBreakpointData);
        	return true;
        }
        
        return false;
    }
    
	private boolean isPlatformDeployed() {
		CompiledUnit mainUnit = getUnitManager().getMainUnit();
		return mainUnit.getURI().isPlatformPlugin();
	}    
}
