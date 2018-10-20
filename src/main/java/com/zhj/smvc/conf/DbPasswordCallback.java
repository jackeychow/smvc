package com.zhj.smvc.conf;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.util.DruidPasswordCallback;

import lombok.extern.log4j.Log4j;

import java.util.Properties;

/**
 * Druid加密后的密码和公钥获取类，配合相关类执行解密和认证
 * @author zhj
 *
 */
@Log4j
public class DbPasswordCallback extends DruidPasswordCallback {
 
    private static final long serialVersionUID = -2585858820009845794L;
 
    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        String password = (String) properties.get("password");
        String publickey = (String) properties.get("publickey");
        try {
            String dbpassword = ConfigTools.decrypt(publickey, password);
            setPassword(dbpassword.toCharArray());
        } catch (Exception e) {
            log.error("Druid ConfigTools.decrypt", e);
        }
    }
}
