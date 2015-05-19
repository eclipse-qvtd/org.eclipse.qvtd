@rem ***************************************************************************
@rem Copyright (c) 2015 Willink Transformations and others.
@rem All rights reserved. This program and the accompanying materials
@rem are made available under the terms of the Eclipse Public License v1.0
@rem which accompanies this distribution, and is available at
@rem http://www.eclipse.org/legal/epl-v10.html
@rem
@rem Contributors:
@rem     E.D.Willink - initial API and implementation
@rem ***************************************************************************
del CoreUM.xml /Q
CALL C:\Tools\ModelMorf\pre-beta-4\modelmorf.bat -m QVTMM -mf FlatQVT.xml  -c FlatRelToCore.qvt -u relations -f RelUM.xml -u core -f CoreUM.xml -t relToCore -d core -q enforce
pause