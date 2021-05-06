################################################################################
#
# libmicroxml.bb
#
# Copyright (c) 2013-2021 Inango Systems LTD.
#
# Author: Inango Systems LTD. <support@inango-systems.com>
# Creation Date: 20 Feb 2021
#
# The author may be reached at support@inango-systems.com
#
# Redistribution and use in source and binary forms, with or without modification,
# are permitted provided that the following conditions are met:
#
# 1. Redistributions of source code must retain the above copyright notice,
# this list of conditions and the following disclaimer.
#
# 2. Redistributions in binary form must reproduce the above copyright notice,
# this list of conditions and the following disclaimer in the documentation
# and/or other materials provided with the distribution.
#
# Subject to the terms and conditions of this license, each copyright holder
# and contributor hereby grants to those receiving rights under this license
# a perpetual, worldwide, non-exclusive, no-charge, royalty-free, irrevocable
# (except for failure to satisfy the conditions of this license) patent license
# to make, have made, use, offer to sell, sell, import, and otherwise transfer
# this software, where such license applies only to those patent claims, already
# acquired or hereafter acquired, licensable by such copyright holder or contributor
# that are necessarily infringed by:
#
# (a) their Contribution(s) (the licensed copyrights of copyright holders and
# non-copyrightable additions of contributors, in source or binary form) alone;
# or
#
# (b) combination of their Contribution(s) with the work of authorship to which
# such Contribution(s) was added by such copyright holder or contributor, if,
# at the time the Contribution is added, such addition causes such combination
# to be necessarily infringed. The patent license shall not apply to any other
# combinations which include the Contribution.
#
# Except as expressly stated above, no rights or licenses from any copyright
# holder or contributor is granted under this license, whether expressly, by
# implication, estoppel or otherwise.
#
# DISCLAIMER
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
# AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
# IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
# ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
# LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
# DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
# SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
# CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
# OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
# USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
#
# NOTE
#
# This is part of a management middleware software package called MMX that was developed by Inango Systems Ltd.
#
# This version of MMX provides web and command-line management interfaces.
#
# Please contact us at Inango at support@inango-systems.com if you would like to hear more about
# - other management packages, such as SNMP, TR-069 or Netconf
# - how we can extend the data model to support all parts of your system
# - professional sub-contract and customization services
################################################################################

DESCRIPTION = "microxml library"
HOMEPAGE = "git://github.com/pivasoftware/microxml"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=85aba3acd06d8e169419ed1a65e40ed8"
SECTION = "libs"
DEPENDS = "libtool-native"

PV = "2015-03-18"

SRC_URI = "git://github.com/pivasoftware/microxml.git;protocol=https;destsuffix=libmicroxml-${PV}"
SRCREV = "80a15162f3a8318c70e8688d8ecbfc38676bd9a2"

S = "${WORKDIR}/libmicroxml-${PV}"

inherit autotools

# Package does not support out of tree builds.
B = "${S}"

# To have GNU_HASH in shared library
TARGET_CC_ARCH += "${LDFLAGS}"

PACKAGECONFIG ??= "static shared"
PACKAGECONFIG[threads] = "--enable-threads,--disable-threads"
PACKAGECONFIG[static] = "--enable-static,--disable-static"
PACKAGECONFIG[shared] = "--enable-shared,--disable-shared"

B = "${S}"

# MicroXML uses autotools but it explicitly states it does not support autoheader.
EXTRA_AUTORECONF = "--exclude=autopoint,autoheader"

do_install() {
    # Package uses DSTROOT instread of standard DESTDIR to specify install location.
    oe_runmake install DSTROOT=${D}
}
