package com.hf.aicodebackend.service;

import com.hf.aicodebackend.model.dto.app.AppQueryRequest;
import com.hf.aicodebackend.model.entity.User;
import com.hf.aicodebackend.model.vo.AppVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.hf.aicodebackend.model.entity.App;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author <a href="https://github.com/QWQHF">HF</a>
 */
public interface AppService extends IService<App> {


    /**
     * 获取应用视图对象
     *
     * @param app 应用
     * @return AppVO
     */
    AppVO getAppVO(App app);

    /**
     * 获取查询条件
     *
     * @param appQueryRequest 应用查询参数
     * @return QueryWrapper
     */
    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    /**
     * 获取应用视图对象列表
     *
     * @param appList 应用列表
     * @return AppVO列表
     */
    List<AppVO> getAppVOList(List<App> appList);

    /**
     * 聊天生成代码
     * @param appId     应用ID
     * @param message   用户消息
     * @param loginUser 登录用户
     * @return Flux
     */
    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    /**
     * 部署应用
     * @param appId     应用ID
     * @param loginUser 登录用户
     * @return 部署结果
     */
    String deployApp(Long appId, User loginUser);

    /**
     * 异步生成应用截图并更新封面
     *
     * @param appId  应用ID
     * @param appUrl 应用访问URL
     */
    void generateAppScreenshotAsync(Long appId, String appUrl);
}
