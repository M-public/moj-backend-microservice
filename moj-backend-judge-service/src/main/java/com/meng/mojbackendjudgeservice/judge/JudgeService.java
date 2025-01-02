package com.meng.mojbackendjudgeservice.judge;


import com.meng.mojbackendmodel.model.entity.QuestionSubmit;

/**
 * @description: 判题服务
 * @throws:
 * @return:
 */
public interface JudgeService {

    /**
     * @description: 判题
     * @throws:
     * @return:
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
