#!/bin/bash

mv buildroot/buckminster.output/org.eclipse.qvtd.releng.build_*-eclipse.feature/site.p2 MMT-QVTd.p2.repository
mv buildroot/buckminster.output/org.eclipse.qvtd.releng.build_*-eclipse.feature/zips MMT-QVTd.downloads

/opt/public/common/apache-ant-1.8.1/bin/ant -f publishroot/publisher.ant -Dbuild.archives=${WORKSPACE} 
