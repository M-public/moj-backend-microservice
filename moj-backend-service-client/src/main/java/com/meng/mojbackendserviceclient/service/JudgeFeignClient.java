package com.meng.mojbackendserviceclient.service;

import com.meng.mojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: 判题服务
 * @throws:
 * @return:
 */
@FeignClient(name = "moj-backend-judge-service", path = "/api/judge/inner")
public interface JudgeFeignClient {

    /**
     * @description: 判题
     * @throws:
     * @return:
     */
    @PostMapping("/do")
    QuestionSubmit doJudge(@RequestParam("questionSubmitId") long questionSubmitId);
}
