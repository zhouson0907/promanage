//package com.adtec.base.config;
//
//import com.adtec.base.user.dao.PrivilegeMapper;
//import com.adtec.base.user.entity.Privilege;
//import com.adtec.base.user.entity.PrivilegeExample;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.access.SecurityConfig;
//import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//
//public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
//
//    @Autowired
//    PrivilegeMapper privilegeMapper;
//
//    private HashMap<String, Collection<ConfigAttribute>> map = null;
//
//    /**
//     * 加载权限表中所有权限
//     */
//    public void loadResourceDefine() {
//        map = new HashMap<String, Collection<ConfigAttribute>>();
//
//        PrivilegeExample privilegeExample = new PrivilegeExample();
//        PrivilegeExample.Criteria pc = privilegeExample.createCriteria();
//        List<Privilege> permissions = privilegeMapper.selectByExample(privilegeExample);
//        for (Privilege permission : permissions) {
//            ConfigAttribute cfg = new SecurityConfig(permission.getCode());
//            List<ConfigAttribute> list = new ArrayList<>();
//            list.add(cfg);
//            map.put(permission.getUrl(), list);
//        }
//
//    }
//
//    /**
//     * 此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法， 用来判定用户
//     * 是否有此权限。如果不在权限表中则放行。
//     */
//    @Override
//    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
//        return null;
//    }
//
//    @Override
//    public Collection<ConfigAttribute> getAllConfigAttributes() {
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return false;
//    }
//}
