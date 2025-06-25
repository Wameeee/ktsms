package cn.wameeee.cond;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;


@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ConditionOnPropertyEnable {
    String enableProperty();

    public class OnEnableCondition implements Condition {
        private static final Logger LOGGER = LoggerFactory.getLogger(ConditionOnPropertyEnable.class);

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

            Map<String,Object> attrs = metadata.getAnnotationAttributes(ConditionOnPropertyEnable.class.getName());
            String enableProperty = (String) attrs.get("enableProperty");
            LOGGER.info("当前读取到的属性名称:{}", enableProperty);
            String propertyValue = context.getEnvironment().getProperty(enableProperty);
            LOGGER.info("从配置文件中获取属性值:{}",enableProperty,propertyValue);
            Boolean needRegister = Boolean.valueOf(propertyValue);
            LOGGER.info("标注的Bean是否需要注册:{}",needRegister);
            return needRegister;
        }
    }
}
