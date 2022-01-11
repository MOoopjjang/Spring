package hello.proxy.pureproxy.concreateproxy.code;

/**
 * Project : proxy
 * Package :hello.proxy.pureproxy.concreateproxy.code
 * Author :  zinnaworks
 * Date : 10/01/2022
 * Desc :
 */
public class ConcreteClient {
    private ConcreteLogic concreteLogic;

    public ConcreteClient(ConcreteLogic concreteLogic){
        this.concreteLogic = concreteLogic;
    }

    public void execute(){
        concreteLogic.operation();
    }
}
