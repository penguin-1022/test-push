package com.jd.laf.config.demo.dict.springboot;

import com.jd.laf.config.demo.dict.common.receiver.DictDataReceiverImplDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Title: todo <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:ronggangping@jd.com>ronggangping</a>
 * @date 2023/1/4
 * @since todo
 */
@SpringBootApplication
public class DictSpringbootLauncher {
    @Bean
    public DictDataReceiverImplDemo dictDataReceiverImplDemoBean(){
        return new DictDataReceiverImplDemo();
    }
    public static void main(String[] args) {
        SpringApplication.run(DictSpringbootLauncher.class, args);
        while (true) {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
