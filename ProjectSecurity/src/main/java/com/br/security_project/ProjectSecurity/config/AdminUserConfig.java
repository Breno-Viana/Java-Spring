package com.br.security_project.ProjectSecurity.config;

import com.br.security_project.ProjectSecurity.entities.Role;
import com.br.security_project.ProjectSecurity.entities.User;
import com.br.security_project.ProjectSecurity.repository.RoleRepository;
import com.br.security_project.ProjectSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private RoleRepository repository;


    @Transactional
   @Override
    public void run(String... args) throws Exception {
        var role = repository.findByname(Role.Values.ADMIN.name()).orElseThrow();
        var role2 = repository.findByname(Role.Values.BASIC.name()).orElseThrow();
        var admin = userRepository.findByuserName("admin");

        admin.ifPresentOrElse(
                i -> {
                    System.out.println("usuario ja existe");
                },
                ()->{
                    var user = new User();
                    user.setUserName("admin");
                    user.setPassWord(encoder.encode("12345678910"));
                    user.setRoles(Set.of(role,role2));
                    userRepository.save(user);
                }
        );
    }
}
