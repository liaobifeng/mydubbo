package pers.bo.zhao.mydubbo.rpc;

import pers.bo.zhao.mydubbo.common.Node;

/**
 * @author Bo.Zhao
 * @since 19/3/8
 */
public interface Invoker<T> extends Node {

    Class<?> getInterface();


}