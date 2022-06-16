package tech.powerjob.samples.canyuan;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import tech.powerjob.samples.MysteryService;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BasicProcessor;
import tech.powerjob.worker.log.OmsLogger;

/**
 * 我的自定义任务
 *
 * @author canyuan
 */
@Component
public class MyTask implements BasicProcessor {

  @Resource
  private MysteryService mysteryService;

  @Override
  public ProcessResult process(TaskContext context) throws Exception {
    // 在线日志功能，可以直接在控制台查看任务日志，非常便捷
    OmsLogger omsLogger = context.getOmsLogger();
    omsLogger.info("BasicProcessorDemo start to process, current JobParams is {}.",
        context.getJobParams());

    System.out.println(context.getJobParams());

    // TaskContext为任务的上下文信息，包含了在控制台录入的任务元数据，常用字段为
    // jobParams（任务参数，在控制台录入），instanceParams（任务实例参数，通过 OpenAPI 触发的任务实例才可能存在该参数）

    // 进行实际处理...
    mysteryService.hasaki();
    System.out.println("我的任务在运行耶");

    // 返回结果，该结果会被持久化到数据库，在前端页面直接查看，极为方便
    return new ProcessResult(true, "result is 我是璨源");
  }
}

