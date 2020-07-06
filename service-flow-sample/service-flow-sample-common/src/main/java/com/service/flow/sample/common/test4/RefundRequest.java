package com.service.flow.sample.common.test4;

import com.service.flow.api.DTO;
import com.service.flow.model.BaseInput;

/**
 * @author zhangcb
 * @ClassName RefundRequest.java
 * @Description TODO
 * @createTime 2020年07月06日 07:27:00
 */
@DTO
public class RefundRequest extends BaseInput {

    private String name;

    private String account;

    private String money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "RefundRequest{" +
                "name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
