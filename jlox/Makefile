# define java complier and flags.
JAVAC = javac
JFLAGS = -g

# source file directory and output directory.
SRCDIR = lox
BINDIR = build

# define source file list.
# SOURCES = $(foreach dir,$(SRCDIR),$(wildcard $(dir)/*.java))
SOURCES = $(wildcard $(SRCDIR)/*.java)
CLASSES = $(patsubst %.java,build/%.class,$(notdir $(SOURCES)))

# default target is compile all java file.
all:
	echo $(CLASSES)

# 编译Java源文件到类文件
$(BINDIR)/%.class: %.java
	@mkdir -p $(BINDIR)
	$(JAVAC) $(JFLAGS) -d $(BINDIR) $<

clean:
	rm -rf $(BINDIR)

run: $(CLASSES)
	java -cp $(BINDIR) HelloWorld

# help message. 
help:
	@echo "Usage:"
	@echo "make        complie all java source file."
	@echo "make run    run java progress."
	@echo "make clean  clean class files."
	@echo "make help   display help message."

# 声明伪目标，防止与文件名冲突
.PHONY: all clean run help
