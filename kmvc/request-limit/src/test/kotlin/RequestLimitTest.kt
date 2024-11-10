import com.mooop.m.feature.manager.UserAccessHistoryInterface
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [RequestLimitTest::class])
class RequestLimitTest {

    @Autowired
    lateinit var userAccessHistoryInterface: UserAccessHistoryInterface


    @Test
    fun requestLimitHistory_테스트(){
//        userAccessHistoryInterface.
    }
}