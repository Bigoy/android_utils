package com.bigoy.android.util.utils;

/**
 * 对获取到的资源进行二次处理
 *
 * @param <ResourceType> 获取到的资源类型
 * @author TaoShuai
 * @createTime 2019/9/7
 */
@SuppressWarnings("WeakerAccess")
public abstract class ResourceProcessor<ResourceType> {

    public abstract ResourceType processResource(ResourceType resource);
}
