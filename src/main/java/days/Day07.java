package days;

import java.util.ArrayList;

public class Day07 extends Day {
    public static class Directory {
        public static class Document {
            public int size;
            public String name;

            public Document(String name, int size) {
                this.name = name;
                this.size = size;
            }
        }

        public int size;
        public String name;
        public ArrayList<Directory> directories;
        public ArrayList<Document> documents;
        public Directory parent;
        public int depth;

        public Directory(String name, Directory parent, int depth) {
            this.parent = parent;
            this.name = name;
            this.depth = depth;
            directories = new ArrayList<>();
            documents = new ArrayList<>();
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();

            res.append("- ").append(this.name);

            for (Document doc : documents) {
                res.append("\r\n");
                res.append("\t".repeat(Math.max(0, this.depth + 1)));
                res.append("- ").append(doc.name).append(" (size=").append(doc.size).append(")");
            }

            for (Directory dir : directories) {
                res.append("\r\n");
                res.append("\t".repeat(Math.max(0, dir.depth)));
                res.append(dir.toString());
            }

            return res.toString();
        }

    }

    private static Directory tree;
    private static int i = 1;
    private int result;
    private int min;
    private int toRemove;

    public Day07() {
        super(7, "input_7.txt");
        tree = new Directory("/", null, 0);
        result = 0;
        min = 70000000;
        toRemove = 0;
    }

    public void go() {
        recursiveCreation(tree, i);

        System.out.println(tree.toString());
        dirSize(tree);
        System.out.println("Sommes des dossiers : " + result);

        min = 70000000;
        toRemove = 30000000 - 70000000 + tree.size;
        dirSize(tree);
        System.out.println("Minimum a retirer : " + toRemove);
        System.out.println("Minimum retire : " + min);

    }

    private void recursiveCreation(Directory dir, int i) {
        if (i < input.size()) {
            String line = input.get(i);
            // si on a un ls
            if (line.equals("$ ls")) {
                i++;
                line = input.get(i);
                // tant qu'on a pas de nouvelle commande
                while (i < input.size() && !line.startsWith("$")) {
                    // on crée un répertoire
                    if (line.startsWith("dir"))
                        dir.directories.add(new Directory(line.split(" ")[1], dir, dir.depth + 1));
                        // ou un fichier
                    else
                        dir.documents.add(new Directory.Document(line.split(" ")[1], Integer.parseInt(line.split(" ")[0])));
                    i++;
                    if (i < input.size())
                        line = input.get(i);
                }
                recursiveCreation(dir, i);
                // si on remonte dans l'arbre, on return
            } else if (line.equals("$ cd ..")) {
                i++;
                recursiveCreation(dir.parent, i);
            } else {
                // si on descend dans l'arbre, on rappelle la fonction récursive
                i++;
                String directoryName = line.split(" ")[2];
                Directory nextDir = dir.directories.stream()
                        .filter(directory -> directory.name.equals(directoryName))
                        .findFirst()
                        .orElse(null);
                recursiveCreation(nextDir, i);
            }
        }
    }

    public int dirSize(Directory dir) {
        int docsSize = dir.documents.stream().mapToInt(doc -> doc.size).sum();
        int dirsSize = dir.directories.stream().mapToInt(directory -> dirSize(directory)).sum();
        dir.size = docsSize + dirsSize;
        if (dir.size <= 100000) {
            result += dir.size;
        }
        if (dir.size >= toRemove && dir.size < min)
            min = dir.size;
        return dir.size;
    }

}
