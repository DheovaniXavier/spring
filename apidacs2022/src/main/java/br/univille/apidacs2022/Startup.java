package br.univille.apidacs2022;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.coredacs2022.entity.User;
import br.univille.coredacs2022.repository.UserRepository;

@Component
public class Startup {

    @Autowired
    private UserRepository repository;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (!repository.findByUser("admin").isPresent()) {
            User admin = new User();
            admin.setUser("admin");
            admin.setPassword("admin");
            repository.save(admin);
        }
    }
    
}
