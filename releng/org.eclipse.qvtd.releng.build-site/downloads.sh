#!/bin/bash -xv
#*******************************************************************************
# Copyright (c) 2018 Willink Transformations and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v2.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v20.html
#
# Contributors:
#     E.D.Willink - initial API and implementation
#*******************************************************************************
#
#	Promote the PUBLISH__URL to the downloads 'page'.
#
#    -u PUBLISH__URL            The zip to be published e.g. https://ci.eclipse.org/ocl/job/qvtd-master/25/artifact/releng/org.eclipse.qvtd.releng.build-site/target/org.eclipse.qvtd-0.16.0.v20171025-1600.zip
#    -v PUBLISH__VERSION        Unqualified version e.g. 0.16.0
#    -t PUBLISH__BUILD_T        Build type N/I/S/R, blank suppresses promotion
#    -q PUBLISH__QUALIFIER      Version qualifier e.g. v20171025-1600
#    -a PUBLISH__ALIAS          Non blank to use alias as part of final name
#
dropsFolder="/home/data/httpd/download.eclipse.org/mmt/qvtd/downloads/drops/"
group="modeling.mmt.qvtd"
zipPrefix="qvtd-incubation-Update-"

while getopts u:v:t:q:a: option
do
case "${option}"
in
u) PUBLISH__URL=${OPTARG};;
v) PUBLISH__VERSION=${OPTARG};;
t) PUBLISH__BUILD_T=${OPTARG};;
q) PUBLISH__QUALIFIER=${OPTARG};;
a) PUBLISH__ALIAS=${OPTARG};;
esac
done

if [ -n "${PUBLISH__BUILD_T}" ]
then

  tQualifier="${PUBLISH__BUILD_T}${PUBLISH__QUALIFIER:1:8}${PUBLISH__QUALIFIER:10:4}"
  versionFolder="${dropsFolder}${PUBLISH__VERSION}/${tQualifier}"
  if [ ! -d "${versionFolder}" ]
  then
    mkdir -p ${versionFolder}
  fi

  fileStem="${tQualifier}"
  if [ -n "${PUBLISH__ALIAS}" ]
  then
    fileStem=${PUBLISH__ALIAS}
  fi
  zipFile="${zipPrefix}${fileStem}.zip"

  pushd ${versionFolder}
    curl -s -k ${PUBLISH__URL} > ${zipFile}
    md5sum -b ${zipFile} > ${zipFile}.md5
    sha512sum -b ${zipFile} > ${zipFile}.sha1
    # make sure permissions are for the intended group
    chgrp -R ${group} ${zipFile} ${zipFile}.md5 ${zipFile}.sha1
    chmod -R g+w ${zipFile} ${zipFile}.md5 ${zipFile}.sha1
  popd

fi