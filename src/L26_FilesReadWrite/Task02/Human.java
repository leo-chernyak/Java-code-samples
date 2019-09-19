package L26_FilesReadWrite.Task02;

abstract class Human {
    final String name;
    final String sex;
    int x;
    int y;

    Human(String name, String sex, int x, int y) {
        this.name = name;
        this.sex = sex;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return name + "\t" + x + "\t" + y;
    }
}