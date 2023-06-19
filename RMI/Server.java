import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Server {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        AddInterfaceImpl obAddInterfaceImpl = new AddInterfaceImpl();
        Naming.rebind("ADD", obAddInterfaceImpl);
        System.out.println("Server started...");
    }
}
