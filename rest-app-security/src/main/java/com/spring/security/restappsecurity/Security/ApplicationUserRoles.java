package com.spring.security.restappsecurity.Security;

import com.google.common.collect.Sets;
import com.spring.security.restappsecurity.Security.ApplicationUserPermission ;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserRoles {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(
            ApplicationUserPermission.COURSE_READ,
            ApplicationUserPermission.COURSE_WRITE,
            ApplicationUserPermission.STUDENT_READ,
            ApplicationUserPermission.STUDENT_WRITE
            )) ,
    ADMINTRAINNE (Sets.newHashSet(
            ApplicationUserPermission.COURSE_READ ,
            ApplicationUserPermission.STUDENT_READ
    )) ;

    private final Set<ApplicationUserPermission> permissions ;

    ApplicationUserRoles(Set<ApplicationUserPermission> permissions ) {
        this.permissions = permissions ;
    }
    public Set<ApplicationUserPermission> getPermissions(){
        return permissions ;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
        Set<SimpleGrantedAuthority> permissions = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name())) ;
        return permissions ;
    }
}
