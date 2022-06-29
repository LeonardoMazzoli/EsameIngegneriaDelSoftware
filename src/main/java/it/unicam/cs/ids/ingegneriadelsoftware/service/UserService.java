package it.unicam.cs.ids.ingegneriadelsoftware.service;

import it.unicam.cs.ids.ingegneriadelsoftware.model.Trip;
import it.unicam.cs.ids.ingegneriadelsoftware.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

}