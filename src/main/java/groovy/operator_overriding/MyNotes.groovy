package groovy.operator_overriding

/**
 * Example of implementing '==' and '+' operators
 * */

class MyNotes implements Comparable<MyNotes> {


    String title
    String text
    String label

    MyNotes(String title, String text, String label) {
        this.title = title
        this.text = text
        this.label = label
    }


    MyNotes plus(MyNotes other) {
        return new MyNotes(this.title+other.title,text+other.text,this.label+other.label)
    }

    String getTitle() {
        return title
    }

    String getText() {
        return text
    }

    String getLabel() {
        return label
    }

    @Override
    int compareTo(MyNotes o) {
        return (label <=> o.label) * (text <=> o.text) * (title <=> o.title)
    }

    @Override
    String toString() {
        return "MyNotes{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", label='" + label + '\'' +
                '}'
    }

    static void main(String[] args) {
        MyNotes f = new MyNotes("a","a","a")
        MyNotes g = new MyNotes("a","a","a")
        assert  f == g
        print(f+g)
    }
}
