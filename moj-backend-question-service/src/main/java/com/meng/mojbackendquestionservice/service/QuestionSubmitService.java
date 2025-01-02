package com.meng.mojbackendquestionservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.meng.mojbackendmodel.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.meng.mojbackendmodel.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.meng.mojbackendmodel.model.entity.QuestionSubmit;
import com.meng.mojbackendmodel.model.entity.User;
import com.meng.mojbackendmodel.model.vo.QuestionSubmitVO;

/**
* @author menglingqi
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-06-30 22:30:57
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest 题目提交信息
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取题目提交封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目提交封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmit, User loginUser);


}
