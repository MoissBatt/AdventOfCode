package days;

import java.util.ArrayList;

public class Day07 extends Day {
    public static class Directory {
        public static class Document {
            protected int size;
            protected String name;

            public Document(String name, int size){
                this.name = name;
                this.size = size;
            }
        }
        protected int size;
        protected String name;
        protected ArrayList<Directory> directories;
        protected ArrayList<Document> documents;

        public Directory(String name){
            this.name = name;
            directories= new ArrayList<>();
            documents= new ArrayList<>();
        }
    }

    private Directory tree;

    public Day07() {
        super(7, "input_7.txt");
        this.tree = new Directory("/");
    }

    public void go() {
        createDir();

    }

    private void createDir() {
        int i = 0;
        recursivCreation(tree, i);
    }

    private void recursivCreation(Directory dir, int i) {
//        if(input.get(i).startsWith("$"))
    }
}
