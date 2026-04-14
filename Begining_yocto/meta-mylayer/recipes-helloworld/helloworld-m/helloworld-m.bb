SUMMARY = "hellowworld of makefile recipe"  
DESCRIPTION = "My hello world application"
LICENSE = "CLOSED"

#the search path for file
FILESEXTRAPATHS:prepend := "${THISDIR}/:"

#the path of source code
SRC_URI = "file://helloworld/"
S = "${WORKDIR}/helloworld"

#add the information for debug and optimization flags
CFLAGS:append = " -Wall -O -g"

#pass the variable to Makefile
EXTRA_OEMAKE = "'CC=${CC}' 'CFLAGS=${CFLAGS}'"
EXTRA_OEMAKE:append = " 'LDFLAGS=${LDFLAGS}'"
EXTRA_OEMAKE:append = " 'DESTDIR=${D}'"

do_install () {

	oe_runmake install
}

#tell the packaging system which files to include in the installation package
FILES:${PN} = "${bindir}/helloworld"
#PN : package name, bitbake will define the PN value by itself,in this case PN= helloworld-m




#record that at the final part of frase it shouldn't be space, it will cause the error
