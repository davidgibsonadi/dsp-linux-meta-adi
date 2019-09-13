require u-boot-adi.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"

PR = "r0"

BRANCH = "develop/yocto-1.0.0-preview"

SRCREV = "${AUTOREV}"

SRC_URI += " \
	file://0001-Remove-mproc-selection-for-Analog-Devices-processors.patch \
	file://0002-Add-compiler-support-for-GCC8.patch \
	file://0003-Pack-some-structures-to-work-properly-with-GCC8.patch \
	file://arm-poky-linux-gnueabi-ldr \
"

FILES_${PN} = " \
	u-boot.ldr \
	u-boot \
"

do_compile_prepend(){
	#Use U-boot's FDT header files, not Linux's (in case they are different)
	cp ${WORKDIR}/git/include/libfdt_env.h ${WORKDIR}/recipe-sysroot-native/usr/include/libfdt_env.h
	cp ${WORKDIR}/git/include/libfdt.h ${WORKDIR}/recipe-sysroot-native/usr/include/libfdt.h

	#Add arm-poky-linux-gnueabi-ldr in to path
	export PATH=$PATH:${WORKDIR}
}

do_install () {
	install ${B}/u-boot.ldr ${D}/u-boot.ldr
	install ${B}/u-boot ${D}/u-boot
}

do_deploy() {
	install ${B}/u-boot.ldr ${DEPLOYDIR}/u-boot.ldr
	install ${B}/u-boot ${DEPLOYDIR}/u-boot
}
