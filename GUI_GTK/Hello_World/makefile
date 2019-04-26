GTKLIB=/usr/share/java/gtk-4.1.jar
MAINCL=Hello
OUTEXC=HelloWorld.jar

all: dir compile run

dir:
	@mkdir Release

compile:
    @javac -classpath $(GTKLIB) -d Release $(MAINCL).java

run:
    @java -classpath $(GTKLIB):Release $(MAINCL)

compress:
    @jar cvmf MANIFEST.MF $(OUTEXC) Release/$(MAINCL).class

run_jar:
    @java -jar $(OUTEXC)
