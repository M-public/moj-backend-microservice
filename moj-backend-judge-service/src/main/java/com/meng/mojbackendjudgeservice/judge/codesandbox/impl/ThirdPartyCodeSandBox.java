package com.meng.mojbackendjudgeservice.judge.codesandbox.impl;


import com.meng.mojbackendjudgeservice.judge.codesandbox.CodeSandBox;
import com.meng.mojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.meng.mojbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * @DESCRIPTION: 第三方代码沙箱（调用别人实现好的代码沙箱服务）
 * @AUTHOR: MENGLINGQI
 * @TIME: 2024/10/25 10:41
 **/
public class ThirdPartyCodeSandBox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
