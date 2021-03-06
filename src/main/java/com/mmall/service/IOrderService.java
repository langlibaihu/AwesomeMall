package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.vo.OrderVo;

import java.util.Map;

/**
 * Created by lkmc2 on 2018/2/20.
 * 订单服务接口
 */

public interface IOrderService {
    /**
     * 创建订单
     * @param userId 用户id
     * @param shippingId 收货地址id
     * @return 带订单值对象的响应
     */
    ServerResponse createOrder(Integer userId, Integer shippingId);

    /**
     * 取消订单
     * @param userId 用户id
     * @param orderNo 订单号
     * @return 是否取消成功的响应
     */
    ServerResponse<String> cancel(Integer userId, Long orderNo);

    /**
     * 获取购物车中已选中的商品详情
     * @param userId 用户id
     * @return 带订单产品值对象的响应
     */
    ServerResponse getOrderCartProduct(Integer userId);

    /**
     * 获取订单详情
     * @param userId 用户id
     * @param orderNo 订单号
     * @return 带订单值对象的响应
     */
    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);

    /**
     * 获取订单列表的分页信息
     * @param userId 用户id
     * @param pageNum 页号
     * @param pageSize 页面展示信息条数
     * @return 带分页信息的响应
     */
    ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize);

    /**
     * 请求支付并生成二维码
     * @param orderNo 订单号
     * @param userId 用户id
     * @param path 上传文件路径
     * @return 带参数信息的响应
     */
    ServerResponse pay(Long orderNo, Integer userId, String path);

    /**
     * 支付宝回调方法
     * @param params 参数
     * @return 是否成功执行回调
     */
    ServerResponse aliCallback(Map<String, String> params);

    /**
     * 查询订单支付状态
     * @param userId 用户id
     * @param orderNo 订单号
     * @return 支付成功或失败的响应
     */
    ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);

    /**
     * 获取用户所有订单的分页信息（后台）
     * @param pageNum 页号
     * @param pageSize 页面展示条数
     * @return 带分页信息的响应
     */
    ServerResponse<PageInfo> manageList(int pageNum, int pageSize);

    /**
     * 获取订单详情（后台）
     * @param orderNo 订单号
     * @return 带订单值对象的响应
     */
    ServerResponse<OrderVo> manageDetail(Long orderNo);

    /**
     * 搜索订单（后台）
     * @param orderNo 订单号
     * @param pageNum 页号
     * @param pageSize 页面展示条数
     * @return 带分页信息的响应
     */
    ServerResponse<PageInfo> manageSearch(Long orderNo, int pageNum, int pageSize);

    /**
     * 设置订单发货（后台）
     * @param orderNo 订单号
     * @return 是否发货成功
     */
    ServerResponse<String> manageSendGoods(Long orderNo);
}
