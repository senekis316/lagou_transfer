package com.lagou.transfer.service;


public interface TransferService {

    /**
     * 转账
     *
     * @param fromCardNo 转出卡号
     * @param toCardNo   转入卡号
     * @param money      金额
     */
    void transfer(String fromCardNo, String toCardNo, int money) throws Exception;

}
