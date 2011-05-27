module conjure.patterns.message;

class Message
{
private:
    final char[] name;
    final char[] contents;
    final Object auxillary;

public:
    this(char[] name, char[] contents, Object auxillary) {
        this.name = name;
        this.contents = contents;
        this.auxillary = auxillary;
    }

    this(char[] name, char[] contents) {

        this.name = name;
        this.contents = contents;
        this.auxillary = null;
    }

    this(char[] name) {

        this.name = name;
        this.contents = null;
        this.auxillary = null;
    }

    char[] getName() {
        return this.name;
    }

    char[] getContents() {
        return this.contents;
    }

    Object getAuxillary() {
        return this.auxillary;
    }
}
