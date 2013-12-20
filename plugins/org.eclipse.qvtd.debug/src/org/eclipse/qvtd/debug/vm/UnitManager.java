/*******************************************************************************
 * Copyright (c) 2009,2012 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *     Christopher Gerking - bug 394498
 *******************************************************************************/
package org.eclipse.qvtd.debug.vm;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.debug.stubs.ASTBindingHelper;
import org.eclipse.qvtd.debug.stubs.QvtOperationalParserUtil;
import org.eclipse.qvtd.debug.utils.CompiledUnit;
import org.eclipse.qvtd.debug.utils.IModuleSourceInfo;
import org.eclipse.qvtd.debug.utils.LineNumberProvider;
import org.eclipse.qvtd.debug.utils.QVTODebugCore;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public class UnitManager
{
	protected final @NonNull MetaModelManager metaModelManager;
	private final @NonNull CompiledUnit fMainUnit;
	private Map<URI, UnitEntry> fUri2UnitMap;
	
	UnitManager(@NonNull MetaModelManager metaModelManager, @NonNull CompiledUnit mainUnit) {
		if(mainUnit == null) {
			throw new IllegalArgumentException("null main unit"); //$NON-NLS-1$
		}
		this.metaModelManager = metaModelManager;
		fMainUnit = mainUnit;
		try {
			fUri2UnitMap = createURI2UnitMap(mainUnit);
		} catch (IOException e) {
			fUri2UnitMap = Collections.emptyMap();			
			QVTODebugCore.log(e);
		}
	}	
	
	public CompiledUnit getMainUnit() {
		return fMainUnit;
	}
	
	public CompiledUnit getCompiledModule(URI unitURI) {
		UnitEntry numberProvider = fUri2UnitMap.get(unitURI);
		if(numberProvider != null) {
			return numberProvider.getCompiledModule();
		}
		
		return null;
	}
	
	public LineNumberProvider getLineNumberProvider(URI unitURI) {
		return fUri2UnitMap.get(unitURI);
	}
	
    public CompiledUnit findUnitForModule(Transformation module) {
    	return findCompiledModuleRec(fMainUnit, module);
    }

    private CompiledUnit findCompiledModuleRec(CompiledUnit rootModule, Transformation module) {
    	if (rootModule.getModules().contains(module)) {
    		return rootModule;
    	}
    	
    	for (CompiledUnit impModule : rootModule.getCompiledImports()) {
    		CompiledUnit findModule = findCompiledModuleRec(impModule, module);
    		if (findModule != null) {
    			return findModule;
    		}
    	}
    	return null;
    }	
	
	private Map<URI, UnitEntry> createURI2UnitMap(CompiledUnit mainUnit) throws IOException {
		HashSet<CompiledUnit> allUnits = new HashSet<CompiledUnit>();
		allUnits.add(mainUnit);
		QvtOperationalParserUtil.collectAllImports(mainUnit, allUnits);
		Map<URI, UnitEntry> file2Unit = new HashMap<URI, UnitEntry>();
		
		for (CompiledUnit nextUnit : allUnits) {
			// FIXME
			IModuleSourceInfo sourceBinding = ASTBindingHelper.getModuleSourceBinding(nextUnit.getModules().get(0));
			if(sourceBinding != null) {
				UnitEntry entry = new UnitEntry(nextUnit, sourceBinding.getLineNumberProvider());
				file2Unit.put(nextUnit.getURI(), entry);
			}
		}
		
		return file2Unit;
	}
	    
    private static class UnitEntry implements LineNumberProvider {
    	
        private final CompiledUnit fModule;  
        private LineNumberProvider fProvider;    	

        public UnitEntry(CompiledUnit unit, LineNumberProvider lineNumberProvider) {
            fModule = unit;
    		fProvider = lineNumberProvider;
        }
        
        public CompiledUnit getCompiledModule() {
            return fModule;
        }
        
        public int getLineEnd(int lineNumber) {
            return fProvider.getLineEnd(lineNumber);
        }

        public int getLineCount() {
            return fProvider.getLineCount();
        }

        public int getLineNumber(int offset) {
            return fProvider.getLineNumber(offset);
        } 
    }    
}
