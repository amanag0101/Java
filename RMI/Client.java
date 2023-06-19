import java.rmi.Naming;

public class Client {
    public static void main(String[] args) throws Exception {
        AddInterface obj = (AddInterface) Naming.lookup("ADD");
        int sum = obj.add(10, 20);
        System.out.println("Sum = " + sum);
    }   
}
