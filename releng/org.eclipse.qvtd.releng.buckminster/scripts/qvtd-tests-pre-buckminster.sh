#!/bin/bash

rm -rf buildroot MMT-QVTd.*
mkdir buildroot
:
COMPACT_BUILD_ID="${BUILD_ID//[-_]}"
COMPACT_BUILD_ID="${COMPACT_BUILD_ID:0:12}"
:
{
	cat "${WORKSPACE}/org.eclipse.qvtd.git/releng/org.eclipse.qvtd.releng.buckminster/releng/qvtd-build.properties"

	echo
	echo "# Define the Build Type (added by Hudson job definition)"
	echo "build.type=N"

	echo
	echo "# Define the Build ID (added by Hudson job definition)"
	echo "build.id=${BUILD_TYPE}${COMPACT_BUILD_ID}"

	echo
	echo "# Define the timestamp to use for changed components (added by Hudson job definition)"
	echo "buckminster.build.timestamp=${BUILD_ID}"

	echo
	echo "# Define Hudson Build ID (added by Hudson job definition)"
	echo "hudson.build.id=${BUILD_ID}"

	echo
	echo "# Override default locations (added by Hudson job definition)"
	echo "buckminster.output.root=${WORKSPACE}/buildroot/buckminster.output"
	echo "buckminster.temp.root=${WORKSPACE}/buildroot/buckminster.temp"
	echo "eclipse.staging.area=/shared/download-staging.priv/modeling/mmt/qvtd"
	echo "git.qvtd.local.repository.location=${WORKSPACE}/org.eclipse.qvtd.git"

	echo
	echo "# Sign the jars (added by Hudson job definition)"    
	echo "site.signing=false"

	echo
	echo "# Eclipse local download area (added by Hudson job definition"
	echo "eclipse.download=file:/home/data/httpd/download.eclipse.org"
	echo
	echo "# Required Properties for Publishing (added by Hudson job definition)"
	echo "packages.base=MMT-QVTd.downloads"
	echo "tests.base=MMT-QVTd.test.results"
	echo "version=0.9.0"
	echo "downloads.area=/home/data/httpd/download.eclipse.org/modeling/mmt/qvtd"


} > buildroot/build.properties
:
{
	echo "# Define the Build ID to use for tagging (added by Hudson job definition)"
	echo "build.id=${COMPACT_BUILD_ID}"

} > buildroot/tagging.properties
: