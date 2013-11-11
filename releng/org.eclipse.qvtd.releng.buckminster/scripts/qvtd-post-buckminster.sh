#!/bin/bash

mv buildroot/buckminster.output/org.eclipse.qvtd.releng.build_*-eclipse.feature/site.p2 MMT-QVTd.p2.repository
mv buildroot/buckminster.output/org.eclipse.qvtd.releng.build_*-eclipse.feature/zips MMT-QVTd.downloads

set

echo cp MMT-QVTd.downloads /home/data/httpd/download.eclipse.org/mmt/qvtd/downloads/drops/0.11.0/
echo cp MMT-QVTd.p2.repository /home/data/httpd/download.eclipse.org/mmt/qvtd/updates/milestones/0.11.0

/opt/public/common/apache-ant-1.8.1/bin/ant -f publishroot/publisher.ant -Dbuild.archives=${WORKSPACE} &> qvtd-publishing-luna.log 

