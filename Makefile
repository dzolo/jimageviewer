################################################################################
#
# FIT VUT - GJA PROJECT 1 2012/2013 - Image viewer
# (c) Ondrej Fibich <xfibic01@stud.fit.vutbr.cz>
#
################################################################################
#
# Make file for make command.
#
################################################################################

# make all by default
default: build

# clean routine
clean:
	ant clean

# make jar
build: clean
	ant jar
	chmod +x jimageviewer
