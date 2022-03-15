import java.io.File;

public class VisitorTester {
    public static void main(String[] args) {
        DirectoryNode node = new DirectoryNode(new File(".."));
        node.visit(new PrintVisitor());
    }
}

class PrintVisitor  {
    int level = 0;
    public void visitFileNode(FileNode node) {
        for (int i = 0; i < level; i++)
            System.out.print(" ");
        System.out.println(node.getFile().getName());
    }

    public void visitDirectoryNode(DirectoryNode node) {
        for (int i = 0; i < level; i++)
            System.out.print(" ");
        System.out.println(node.getDirectory().getName());
        level++;
        for (FileSystemNode c : node.getChildren())
            c.visit(this);
        level--;
    }
}

interface FileSystemNode {
    void visit(PrintVisitor v);
}

class FileNode implements FileSystemNode {
    public FileNode(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void visit(PrintVisitor v) {
        v.visitFileNode(this);
    }

    private File file;
}

class DirectoryNode implements FileSystemNode {
    public DirectoryNode(File directory) {
        this.directory = directory;
    }

    public void visit(PrintVisitor v) {
        v.visitDirectoryNode(this);
    }

    public File getDirectory() {
        return directory;
    }

    public FileSystemNode[] getChildren() {
        File[] files = directory.listFiles();
        FileSystemNode[] children = new FileSystemNode[files.length];
        for (int i = 0; i < files.length; i++) {
            File f = files[i];
            if (f.isDirectory())
                children[i] = new DirectoryNode(f);
            else
                children[i] = new FileNode(f);
        }
        return children;
    }

    private File directory;
}
