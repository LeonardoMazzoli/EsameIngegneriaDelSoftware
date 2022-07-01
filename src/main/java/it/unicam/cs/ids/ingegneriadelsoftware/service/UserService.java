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
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.entityManager.createQuery("select u from User u where u.username =: username", User.class)
                .setParameter("username", username).getSingleResult();
    }

    private User getUser(String username) {
        return this.entityManager.createQuery("select u from User u where u.username =: username", User.class)
                .setParameter("username", username).getSingleResult();
    }

    public Set<Trip> getUserTrips() {
        User authentication = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return this.getUser(authentication.getUsername()).getUserTrips();
    }
}