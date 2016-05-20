/**
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 */
package org.eclipse.qvtd.cs2as.xtext.generator;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.ui.outline.OutlineTreeProviderFragment2;

@SuppressWarnings("all")
public class CS2ASOutlineTreeProviderFragment extends OutlineTreeProviderFragment2 {
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  @Inject
  private Grammar grammar;
  
  @Override
  public TypeReference getOutlineTreeProviderClass(final Grammar grammar) {
    String _namespace = GrammarUtil.getNamespace(grammar);
    String _plus = (_namespace + ".ui.outline.");
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "CS2ASOutlineTreeProvider");
    return new TypeReference(_plus_2);
  }
  
  @Override
  public void generateJavaOutlineTreeProvider() {
    TypeReference _outlineTreeProviderClass = this.getOutlineTreeProviderClass(this.grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Customization of the default outline structure.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#outline");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("public class ");
        TypeReference _outlineTreeProviderClass = CS2ASOutlineTreeProviderFragment.this.getOutlineTreeProviderClass(CS2ASOutlineTreeProviderFragment.this.grammar);
        String _simpleName = _outlineTreeProviderClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _namespace = GrammarUtil.getNamespace(CS2ASOutlineTreeProviderFragment.this.grammar);
        String _plus = (_namespace + ".ui.outline.CS2ASOutlineTreeProvider");
        _builder.append(_plus, "\t");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    JavaFileAccess _createJavaFile = this.fileAccessFactory.createJavaFile(_outlineTreeProviderClass, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _src = _eclipsePlugin.getSrc();
    _createJavaFile.writeTo(_src);
  }
  
  @Override
  public void generateXtendOutlineTreeProvider() {
    TypeReference _outlineTreeProviderClass = this.getOutlineTreeProviderClass(this.grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Customization of the default outline structure.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#outline");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("public class ");
        TypeReference _outlineTreeProviderClass = CS2ASOutlineTreeProviderFragment.this.getOutlineTreeProviderClass(CS2ASOutlineTreeProviderFragment.this.grammar);
        String _simpleName = _outlineTreeProviderClass.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _namespace = GrammarUtil.getNamespace(CS2ASOutlineTreeProviderFragment.this.grammar);
        String _plus = (_namespace + ".ui.outline.CS2ASOutlineTreeProvider");
        _builder.append(_plus, "\t");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    XtendFileAccess _createXtendFile = this.fileAccessFactory.createXtendFile(_outlineTreeProviderClass, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _src = _eclipsePlugin.getSrc();
    _createXtendFile.writeTo(_src);
  }
}
