package com.meng.mojbackendjudgeservice.contoller.inner;

import com.meng.mojbackendjudgeservice.judge.JudgeService;
import com.meng.mojbackendmodel.model.entity.QuestionSubmit;
import com.meng.mojbackendserviceclient.service.JudgeFeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @DESCRIPTION: 该服务仅内部调用
 * @AUTHOR: MENGLINGQI
 * @TIME: 2025/1/4 15:29
 **/
@RestController
@RequestMapping("/inner")
public class JudgeInnerController implements JudgeFeignClient {

    @Resource
    private JudgeService judgeService;

    /**
     * @description: 判题
     * @throws:
     * @return:
     */
    @PostMapping("/do")
    @Override
    public QuestionSubmit doJudge(@RequestParam("questionSubmitId") long questionSubmitId) {
        return judgeService.doJudge(questionSubmitId);
    }

}

