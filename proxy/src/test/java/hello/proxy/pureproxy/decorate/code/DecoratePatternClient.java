package hello.proxy.pureproxy.decorate.code;

/**
 * Project : proxy
 * Package :hello.proxy.pureproxy.decorate.code
 * Author :  zinnaworks
 * Date : 08/01/2022
 * Desc :
 */
public class DecoratePatternClient {
    Component component;
    public DecoratePatternClient(Component component){
        this.component = component;
    }

    public String execute(){
        return component.operation();
    }
}
