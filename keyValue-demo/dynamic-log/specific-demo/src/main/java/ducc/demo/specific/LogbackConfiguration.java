//package ducc.demo.specific;
//
//import ch.qos.logback.classic.Level;
//import ch.qos.logback.classic.Logger;
//import com.jd.laf.config.spring.boot.log.LogAutoConfiguration;
//import com.jd.laf.config.spring.boot.log.LogConfigure;
//import com.jd.laf.config.spring.boot.log.LogPropertyListener;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Conditional;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@ConditionalOnClass(Logger.class)
//@Conditional(LogbackConfiguration.LogbackCondition.class)
//public class LogbackConfiguration {
//
//    @Value("${laf.config.logger.key}")
//    private String key;
//
//    @Bean
//    public LogPropertyListener log4jListener() {
//        return new LogPropertyListener(key, new LogConfigure() {
//            @Override
//            public void setLevel(final String loggerName, final String levelName) {
//                Logger logger = loggerName == null || loggerName.isEmpty() ?
//                        (Logger) LoggerFactory.getLogger("ROOT") : (Logger) LoggerFactory.getLogger(loggerName);
//                logger.setLevel(Level.toLevel(levelName));
//            }
//        });
//    }
//
//
//    static class LogbackCondition extends AnyNestedCondition {
//
//        public LogbackCondition() {
//            super(ConfigurationPhase.REGISTER_BEAN);
//        }
//
//        @ConditionalOnProperty(prefix = "laf.config.logger", name = "type", havingValue = "logback")
//        static class LogbackPropertyCondition {
//        }
//
//        @ConditionalOnProperty(prefix = "laf.config.logger", name = "type", matchIfMissing = true)
//        @ConditionalOnMissingClass({
//                LogAutoConfiguration.LOG4J2_CLASS,
//                LogAutoConfiguration.LOG4J_CLASS
//        })
//        static class OnlyLogbackOnClasspathCondition {
//        }
//    }
//}
