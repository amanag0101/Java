import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddInterfaceImpl extends UnicastRemoteObject implements AddInterface {
    protected AddInterfaceImpl() throws RemoteException {
        super();
    }

    @Override
    public int add(int x, int y) throws Exception {
        return x + y;
    }
}
