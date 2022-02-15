package com.example.demo.auth;

import com.example.demo.security.ApplicationUserRole;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao{
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> getApplicationUserByUsername(String username) {
        return getApplicationUsers().stream().filter(applicationUser -> username.equals(applicationUser.getUsername())).findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        return Lists.newArrayList(
                new ApplicationUser(ApplicationUserRole.STUDENT.getGrantedAuthorities(), passwordEncoder.encode("password"), "annasmith", true, true, true, true),
                new ApplicationUser(ApplicationUserRole.ADMIN.getGrantedAuthorities(), passwordEncoder.encode("password"), "linda", true, true, true, true),
                new ApplicationUser(ApplicationUserRole.ADMIN_TRAINEE.getGrantedAuthorities(), passwordEncoder.encode("password"), "tom", true, true, true, true)
        );
    }
}
