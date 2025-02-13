package tech.powerjob.server.remote.server.redirector;

import tech.powerjob.common.PowerSerializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 原创执行命令
 *
 * @author tjq
 * @since 12/13/20
 */
@Getter
@Setter
@Accessors(chain = true) // https://blog.csdn.net/weixin_38229356/article/details/82937420
public class RemoteProcessReq implements PowerSerializable {

    private String className;
    private String methodName;
    private String[] parameterTypes;

    private Object[] args;

}
