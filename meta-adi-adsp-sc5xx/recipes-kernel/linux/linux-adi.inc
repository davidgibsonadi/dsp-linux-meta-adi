SECTION = "kernel"
DESCRIPTION = "Linux kernel for Analog Devices ADSP-5xx processors"

inherit kernel

require linux-adi-src.inc

# Pull in the devicetree files into the rootfs
# RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/git"


# Append to the MACHINE_KERNEL_PR so that a new SRCREV will cause a rebuild
MACHINE_KERNEL_PR_append = "a"
PR = "${MACHINE_KERNEL_PR}"

do_configure_append(){
	make ${KERNEL_MACHINE}
}

COMPATIBLE_MACHINE = "adsp-sc584-ezkit|adsp-sc589-ezkit|adsp-sc589-mini|adsp-sc573-ezkit"