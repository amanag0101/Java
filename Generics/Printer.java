public class Printer <T> {
    T data;

    public Printer(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void print() {
        System.out.println(data);
    }
}
