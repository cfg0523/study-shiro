package com.techsen.study.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        
        String principal = (String)this.getAvailablePrincipal(principals);
        if ("hayden".equals(principal)) {
            SimpleAuthorizationInfo authz = new SimpleAuthorizationInfo();
            Set<String> perms = new HashSet<String>();
            perms.add("user:*");
            authz.setStringPermissions(perms);
            return authz;
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authToken) throws AuthenticationException {

        if (authToken instanceof UsernamePasswordToken) {
            UsernamePasswordToken token = (UsernamePasswordToken) authToken;
            String username = token.getUsername();
            String password = String.valueOf(token.getPassword());
            if ("hayden".equals(username) && "qiannianhu".equals(password)) {
                return new SimpleAuthenticationInfo(username, password, this.getName());
            }
        }

        return null;
    }

}
