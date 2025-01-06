package com.meng.mojbackendquestionservice.controller.inner;

import com.meng.mojbackendmodel.model.entity.Question;
import com.meng.mojbackendmodel.model.entity.QuestionSubmit;
import com.meng.mojbackendquestionservice.service.QuestionService;
import com.meng.mojbackendquestionservice.service.QuestionSubmitService;
import com.meng.mojbackendserviceclient.service.QuestionFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @DESCRIPTION: 该服务仅内部调用
 * @AUTHOR: MENGLINGQI
 * @TIME: 2025/1/4 15:29
 **/
@RestController
@RequestMapping("/inner")
public class QuestionInnerController implements QuestionFeignClient {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;

    /**
     * 根据id获取题目信息
     *
     * @param questionId
     */
    @GetMapping("/get/id")
    @Override
    public Question getQuestionById(@RequestParam("questionId") long questionId){
        return questionService.getById(questionId);
    }

    /**
     * 根据id获取题目提交信息
     *
     * @param questionSubmitId
     */
    @GetMapping("/question_submit/get/id")
    @Override
    public QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") long questionSubmitId) {
        return questionSubmitService.getById(questionSubmitId);
    }

    @PostMapping("/question_submit/update")
    @Override
    public boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmit) {
        return questionSubmitService.updateById(questionSubmit);
    }
}

