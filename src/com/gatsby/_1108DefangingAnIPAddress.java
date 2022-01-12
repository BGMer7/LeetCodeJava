package com.gatsby;

/**
 * @ClassName: _1108DefangingAnIPAddress
 * @Description: leetcode 1108 ip地址无效化
 * @author: Gatsby
 * @date: 2022/1/12 19:24
 */

public class _1108DefangingAnIPAddress {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}


