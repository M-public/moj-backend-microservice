package com.meng.mojbackendjudgeservice.judge.codesandbox;

import com.meng.mojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.meng.mojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @DESCRIPTION: 代码沙箱代理类，为了解决所有调用代码沙箱都需要打印日志的问题
 * @AUTHOR: MENGLINGQI
 * @TIME: 2024/10/27 10:06
 **/
@Slf4j
@AllArgsConstructor
public class CodeSandboxProxy implements CodeSandBox {


    private final CodeSandBox codeSandBox;

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest){
        log.info("代码沙箱请求信息：" + executeCodeRequest.toString());
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        log.info("代码沙箱返回信息：" + executeCodeResponse);
        return executeCodeResponse;
    }


}
