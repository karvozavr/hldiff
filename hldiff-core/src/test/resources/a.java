class Foo {

    public int taskDecorator(int a, int b) {
        return 0;
    }

    public void execute(int a) {

    }

    public void decoratedTaskMap(int a, int b, int c) {

    }

    int decorate = 0;
    int command = 0;
    int put = 0;

    public void foo() {
        execute(taskDecorator(decorate, command));
    }
}
