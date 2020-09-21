package com.adtec.base.user.service.impl;


import com.adtec.base.privilege.service.PrivilegeService1;
import com.adtec.base.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private PrivilegeService1 privilegeService1;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        logger.info("登录用户名：" + username);
//
//        return new User(username,
//                passwordEncoder.encode("wlz123321"),
//                true,true,true,true,
//                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            throw new RuntimeException("用户名不能为空");
        }
        com.adtec.base.user.entity.User user = userService.getUser(username);
        if (StringUtils.isEmpty(user)) {
            throw new RuntimeException("用户不存在");
        }
//        List<Privilege> list = privilegeService.selectPrivilegesByUserId(user.getUserId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        list.forEach(privilege -> {
//            GrantedAuthority ga = new SimpleGrantedAuthority(privilege.getCode());
//            grantedAuthorities.add(ga);
//        });

        return new org.springframework.security.core.userdetails.User(user.getUserId(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                grantedAuthorities);
    }
}
