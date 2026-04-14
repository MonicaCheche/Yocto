SUMMARY = "Modern CMake project with GTest"
DESCRIPTION = "helloworld-m using CMake and calculation"
LICENSE = "CLOSED"

#the search path for file
FILESEXTRAPATHS:prepend := "${THISDIR}:"

# Point to the directory containing your src, tests, and CMakeLists.txt
SRC_URI = "file://helloworld"

# Set the Source directory (where CMakeLists.txt is located)
S = "${WORKDIR}/helloworld"

#add the information for debug and optimization flags
TARGET_CXXFLAGS:append = " -Wall -O2 -g"

# This is the magic part that handles the Toolchain automatically
inherit cmake

# This satisfies your find_package(GTest REQUIRED)
DEPENDS += "googletest"

# Optional: Ensure the executable is installed in the final image
do_install() {
    install -d ${D}${bindir}
    install -m 0755 MyExecutable ${D}${bindir}/MyExecutable
    
    #add also test program
    install -m 0755 TestMyLib ${D}${bindir}/TestMyLib
}


#tell the packaging system which files to include in the installation package
FILES:${PN} = "${bindir}/MyExecutable"

#in case there is test program packaged
PACKAGES =+ "${PN}-tests"
FILES:${PN}-tests = "${bindir}/TestMyLib"
