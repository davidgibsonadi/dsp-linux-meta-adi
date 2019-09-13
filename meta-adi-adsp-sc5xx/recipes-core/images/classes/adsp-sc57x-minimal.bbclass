inherit core-image extrausers

SUMMARY = "Minimal image for Analog Devices ADSP-SC57x boards"
LICENSE = "MIT"

OPROFILE_PERFORMANCE_BENCHMARK = "\
	oprofile  \
	dhrystone \
	whetstone-adi \
"

IMAGE_INSTALL = " \
    packagegroup-core-boot \
    packagegroup-base \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    ${OPROFILE_PERFORMANCE_BENCHMARK} \
"

COMPATIBLE_MACHINE = "(adsp-sc573-ezkit)"

EXTRA_USERS_PARAMS = "usermod -P adi root;"

#BR2_PACKAGE_BUSYBOX_CONFIG="board/AnalogDevices/arm/busybox.config"
#BR2_PACKAGE_BUSYBOX_WATCHDOG=y
#BR2_PACKAGE_OPENSSL_BIN=y
#BR2_PACKAGE_LIBTIRPC=y
#BR2_PACKAGE_OPENSSH=y
#BR2_TARGET_ROOTFS_EXT2=y
#BR2_TARGET_ROOTFS_EXT2_3=y
#BR2_TARGET_ROOTFS_INITRAMFS=y




