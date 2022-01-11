package hello.proxy.pureproxy.proxy.code;

/**
 * Project : proxy
 * Package :hello.proxy.pureproxy.proxy.code
 * Author :  zinnaworks
 * Date : 08/01/2022
 * Desc :
 */
public class ProxyPatternClient {

    Subject subject;
    public ProxyPatternClient(Subject subject){
        this.subject = subject;
    }

    public String execute(){
        return subject.operation();
    }
}
