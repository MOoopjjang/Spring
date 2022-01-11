package hello.proxy.app.v1;

/**
 * Project : proxy
 * Package :hello.proxy.app.v1
 * Author :  zinnaworks
 * Date : 08/01/2022
 * Desc :
 */
public class OrderRepositoryV1Impl implements OrderRepositoryV1{
    @Override
    public void save(String itemId) {
        //저장로직
        if(itemId.equals("ex")){
            throw new IllegalStateException("예외 발생");
        }
        sleep(1000);

    }

    private void sleep(int mil){
        try {
            Thread.sleep(mil);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
