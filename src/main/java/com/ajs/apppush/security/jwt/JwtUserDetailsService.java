package com.ajs.apppush.security.jwt;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.ajs.apppush.entity.User;
import com.ajs.apppush.repository.UserRepository;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        logger.info("load user...");
        Optional<User> user = userRepository.findById(username);
        if (user.isPresent()) {
            logger.info("user:: {}", user.get().getUserId());
            return getJwtUser(user.get());
        } else {
            logger.info("user not found");
            //throw new UsernameNotFoundException(String.format("User not found with username '%s'.", username));
            return null;
        }
    }


    public JwtUser getJwtUser(User user) {
    	
    	List<SimpleGrantedAuthority> list = new ArrayList<>();
    	
    	list.add(new SimpleGrantedAuthority("user"));
    	
        return new JwtUser(
                user.getUserId(),
                user.getEmail(),
                list
        );
    }
}
