KERNEL_GIT_URI = "git://github.com/analogdevicesinc/dsp-linux.git"
KERNEL_GIT_PROTOCOL = "https"

BRANCH = "develop/yocto-1.0.0-preview"

SRCREV = "${AUTOREV}"

SRC_URI += " \
	${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
"
