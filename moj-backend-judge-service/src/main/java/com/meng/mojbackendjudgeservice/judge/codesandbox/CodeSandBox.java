package com.meng.mojbackendjudgeservice.judge.codesandbox;

import com.meng.mojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.meng.mojbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * @description: 代码沙箱接口定义
 * @throws:
 * @return:
 */
public interface CodeSandBox {

    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
