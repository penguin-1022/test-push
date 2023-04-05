package ducc.demo;

import com.jd.laf.config.demo.log.common.Config1;
import com.jd.laf.config.demo.log.common.Config2;
import com.jd.laf.config.demo.log.common.Config3;
import com.jd.laf.config.demo.log.common.Config4;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date ${DATE}
 * @since todo
 */
@SpringBootApplication(scanBasePackages = "ducc.demo")
public class SepcificDemo {
    public static void main(String[] args) {
        try {
            ConfigurableApplicationContext applicationContext = SpringApplication.run(SepcificDemo.class, args);
            SepcificDemo launcher = applicationContext.getBean(SepcificDemo.class);

            Config1 config1 = new Config1();
            Config2 config2 = new Config2();
            Config3 config3 = new Config3();
            Config4 config4 = new Config4();

            while (true) {
                config1.loggerLevel();
                config2.loggerLevel();
                config3.loggerLevel();
                config4.loggerLevel();
                TimeUnit.SECONDS.sleep(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}