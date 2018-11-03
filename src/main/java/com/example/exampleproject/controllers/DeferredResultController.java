package com.example.exampleproject.controllers;

import com.example.exampleproject.TaskService.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;

@RestController
public class DeferredResultController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final TaskService taskService;

    @Autowired
    public DeferredResultController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/deferred", method = RequestMethod.GET, produces = "text/html")
    public DeferredResult<String> executeSlowTask() {
        logger.info("Request received");
        DeferredResult<String> deferredResult = new DeferredResult<>();
        CompletableFuture.supplyAsync(taskService::execute)
                .whenCompleteAsync((result, throwable) -> deferredResult.setResult(result));
        logger.info("Servlet thread released");
        //System.out.print(deferredResult);
        return deferredResult;
    }
}
