package com.saganet.school.database.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.saganet.school.database.entities.security.UsuarioEO;
import com.saganet.school.database.services.security.UsuarioServ;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UsuarioServ usuarioServ;
 
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UsuarioEO User = this.usuarioServ.cargarUsuario(userName);
 
        if (User == null) {
            log.info("Usuario no encontrado " + userName);
            throw new UsernameNotFoundException("Usuario " + userName + " no fue encontrado en la base de datos");
        }
 
        log.info("Usuario encontrado: " + User);
 
        // [ROLE_USER, ROLE_ADMIN,..]
        String rol = User.getRol().getNombre();
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (rol != null) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(rol);
                grantList.add(authority);
        }
 
        UserDetails userDetails = (UserDetails) new User(User.getUsuario(), //
                User.getEncrytedPassword(), grantList);
 
        return userDetails;
    }
 
}
