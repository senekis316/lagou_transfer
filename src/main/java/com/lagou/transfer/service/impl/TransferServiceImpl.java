package com.lagou.transfer.service.impl;

import com.lagou.transfer.annotation.Autowired;
import com.lagou.transfer.annotation.Service;
import com.lagou.transfer.annotation.Transactional;
import com.lagou.transfer.dao.AccountDao;
import com.lagou.transfer.pojo.Account;
import com.lagou.transfer.service.TransferService;


@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    @Transactional
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {

        Account from = accountDao.queryAccountByCardNo(fromCardNo);
        Account to = accountDao.queryAccountByCardNo(toCardNo);

        from.setMoney(from.getMoney() - money);
        to.setMoney(to.getMoney() + money);

        accountDao.updateAccountByCardNo(to);
        accountDao.updateAccountByCardNo(from);

    }

}
