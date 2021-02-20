################################################################################
#
# mmx-web.bb
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
#
################################################################################

DESCRIPTION = "MMX WEB"
HOMEPAGE = "https://github.com/InangoSystems/feed-mmx"
LICENSE = "BSD-2-Clause-Patent"
LIC_FILES_CHKSUM = "file://${S}/../../LICENSE;md5=3b43fbcd44ec443ceba0ba4ee19519fd"
SECTION = "mng"
DEPENDS = ""
RDEPENDS_${PN} += "lua5.1 luci uhttpd ubus rpcd procd-base-files"

PV = "2.0.1"
SRC_URI = "\
    git://github.com/InangoSystems/feed-mmx.git;protocol=https \
"
SRCREV = "5172c6f7719cb5988f2722442238f400245fb564"

S = "${WORKDIR}/git/mng/mmx-web"

FILES_${PN} += "\
    /www \
    /usr \
    "

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
	install -d ${D}${libdir}/lua/luci/mmx
	install -m 0755 ./src/mmx_web_routines.lua ${D}${libdir}/lua/luci/mmx/mmx_web_routines.lua

	install -d ${D}${libdir}/lua/luci/controller
	install -m 0755 ./src/mmx-controller.lua ${D}${libdir}/lua/luci/controller/mmx.lua

#ifeq ($(CONFIG_PACKAGE_mmx-user-be),y)
#	install -d ${D}${libdir}/lua/luci/view
#	install -m 0755 ${S}/files/sysauth.htm ${D}${libdir}/lua/luci/view/sysauth.htm
#endif

	install -d ${D}${libdir}/lua/mmx
#ifeq ($(CONFIG_PACKAGE_mmx-user-be),y)
#	# patched controller/admin/index.lua to allow Luci login for MMX added users
#	install -m 0755 ./src/mmx_admin_index.lua ${D}${libdir}/lua/mmx
#endif

	#patched network.lua to ignore tap interfaces
	install -m 0755 ./luci/mmx-model-network.lua ${D}${libdir}/lua/mmx

	install -d ${D}/etc/uci-defaults
	install -m 0755 ${S}/files/etc/uci-defaults/mmx-web.init ${D}/etc/uci-defaults

	install -d ${D}${libdir}/lua/luci/view/mmx
	install -m 0755 ${S}/files/view-mmx.htm ${D}${libdir}/lua/luci/view/mmx/mmx.htm
	install -m 0755 ${S}/files/view-mmx-vector.htm ${D}${libdir}/lua/luci/view/mmx/mmx-vector.htm
	install -m 0755 ${S}/files/view-mmx-matrix.htm ${D}${libdir}/lua/luci/view/mmx/mmx-matrix.htm
	install -m 0755 ${S}/files/view-mmx-tablegroup.htm ${D}${libdir}/lua/luci/view/mmx/mmx-tablegroup.htm
	install -m 0755 ${S}/files/view-mmx-field.htm ${D}${libdir}/lua/luci/view/mmx/mmx-field.htm

	install -d ${D}/www/luci-static/resources/
	install -m 0755 ${S}/files/mmx.js ${D}/www/luci-static/resources/mmx.js
	install -m 0755 ${S}/files/jquery-ui-1.10.4.custom.css ${D}/www/luci-static/resources/jquery-ui-1.10.4.custom.css
	install -m 0755 ${S}/files/jquery-ui-1.10.4.custom.min.js ${D}/www/luci-static/resources/jquery-ui-1.10.4.custom.min.js
	install -m 0755 ${S}/files/jquery-1.10.1.min.js ${D}/www/luci-static/resources/jquery-1.10.1.min.js
	install -m 0755 ${S}/files/jquery.fix.clone.js ${D}/www/luci-static/resources/jquery.fix.clone.js
}
