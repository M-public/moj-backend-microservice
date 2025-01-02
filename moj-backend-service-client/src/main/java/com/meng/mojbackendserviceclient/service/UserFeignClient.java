package com.meng.mojbackendserviceclient.service;

import com.meng.mojbackendcommon.common.ErrorCode;
import com.meng.mojbackendcommon.exception.BusinessException;
import com.meng.mojbackendmodel.model.entity.User;
import com.meng.mojbackendmodel.model.enums.UserRoleEnum;
import com.meng.mojbackendmodel.model.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

import static com.meng.mojbackendcommon.constant.UserConstant.USER_LOGIN_STATE;

/**
 * 用户服务
 *
 */
@FeignClient(name = "moj-backend-user-service", path = "/api/user/inner")
public interface UserFeignClient {

    /**
     * @description:  根据id获取用户信息
     * * @param[1] userId
     * @return:
     */
    @GetMapping("/get/id")
    User getById(@RequestParam("userId") long userId);


    /**
     * @description:  根据id获取用户信息列表
     * * @param[1] userIdList
     * @return:
     */
    @GetMapping("/get/ids")
    List<User> listByIds(@RequestParam("userIdList") Collection<Long> userIdList);

    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    default User getLoginUser(HttpServletRequest request){
        // 先判断是否已登录
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser = (User) userObj;
        if (currentUser == null || currentUser.getId() == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        return currentUser;
    };

    /**
     * 是否为管理员
     *
     * @param user
     * @return
     */
    default boolean isAdmin(User user){
        return user != null && UserRoleEnum.ADMIN.getValue().equals(user.getUserRole());
    };

    /**
     * 获取脱敏的用户信息
     *
     * @param user
     * @return
     */
    default UserVO getUserVO(User user){
        if (user == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    };

}
