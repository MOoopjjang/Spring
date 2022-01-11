package hello.proxy.app.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Project : proxy
 * Package :hello.proxy.app.v1
 * Author :  zinnaworks
 * Date : 08/01/2022
 * Desc :
 */
@RequestMapping   //스프링은 @Controller 또는 @RequestMapping이 있어야 컨트럴러 인식.
@ResponseBody
public interface OrderControllerV1 {

    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String noLog();
}
