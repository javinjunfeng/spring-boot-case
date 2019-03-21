package top.javinjunfeng.core;


import lombok.Data;
import org.apache.commons.lang3.Validate;

/**
 * 执行容器的抽象类，持有该容器全局的配置 configuration
 */
@Data

public abstract class AbstractContainer {
    protected Integer concurrencyNumber;

//    protected AbstractContainerCommunicator containerCommunicator;

    public AbstractContainer(Integer concurrencyNumber) {
        Validate.notNull(concurrencyNumber, "concurrencyNumber can not be null.");

        this.concurrencyNumber = concurrencyNumber;
    }

    public abstract void start();

}
