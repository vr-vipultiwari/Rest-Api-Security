package com.spring.security.restappsecurity.Security;

import com.google.common.collect.Sets;
import com.spring.security.restappsecurity.Security.ApplicationUserPermission ;
import java.util.Set;

public enum ApplicationUserRoles {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(
            ApplicationUserPermission.COURSE_READ,
            ApplicationUserPermission.COURSE_WRITE,
            ApplicationUserPermission.STUDENT_READ,
            ApplicationUserPermission.STUDENT_WRITE
            ));

    private final Set <ApplicationUserPermission> permissions ;

    ApplicationUserRoles(Set<ApplicationUserPermission> permissions ) {
        this.permissions = permissions ;
    }
}
