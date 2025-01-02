package com.meng.mojbackendjudgeservice.judge;

import com.meng.mojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.meng.mojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStratedy;
import com.meng.mojbackendjudgeservice.judge.strategy.JudgeContext;
import com.meng.mojbackendjudgeservice.judge.strategy.JudgeStrategy;
import com.meng.mojbackendmodel.model.codesandbox.JudgeInfo;
import com.meng.mojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * @DESCRIPTION: 判题策略管理 简化调用，解决因判断使用哪种策略逻辑复杂引起的调用代码臃肿问题
 * @AUTHOR: MENGLINGQI
 * @TIME: 2024/10/27 14:31
 **/
@Service
public class JudgeManager {

    JudgeInfo doJudge(JudgeContext judgeContext){
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();

        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();

        if ("java".equals(language))
            judgeStrategy = new JavaLanguageJudgeStratedy();

        return judgeStrategy.doJudge(judgeContext);
    }

}
