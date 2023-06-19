public class Main {
    public static void main(String[] args) {
        Printer<Integer> printer = new Printer<>(10);
        printer.print();

        show(10);
        show("Hello");
    }

    private static <T> void show(T data) {
        System.out.println("Showing: " + data);
    }
}