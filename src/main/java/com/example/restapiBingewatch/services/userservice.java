package com.example.restapiBingewatch.services;

import com.example.restapiBingewatch.models.userrepo;
import com.example.restapiBingewatch.models.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class userservice implements UserDetailsService {

    @Autowired
    private userrepo usrepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public void insertUser(users usr)
    {
        String newpass = passwordEncoder.encode(usr.getPassword());
        usr.setPassword(newpass);

        usrepo.insert(usr);
    }

    public Optional<users> getuser(String id) throws Exception {
            Optional<users> findhim = usrepo.findById(id);
            if(!findhim.isPresent())
            {
                throw new Exception ("User with id "+id+" not found!!!");
            }
            return findhim;
    }

    public List<users> getAll()
    {
        return usrepo.findAll();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        users founduser = usrepo.findByUsername(username);

        String uname = founduser.getUsername();
        String password = founduser.getPassword();

        return new User(uname,password, new ArrayList<>());
    }
}
