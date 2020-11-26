package com.nuesoft.redbag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UserRepositoryTests {
    @Autowired
    private UserRepository repository;

    @Test
    public void save() {
        User user = new User();
        user.setUsername("右子");
        user.setPassword("2622");
        user.setEmail("35175");
        repository.save(user);
    }

    @Test
    public void update() {
        User user = new User();
        user.setId("8a04afc575fe9d3a0175fe9d43090000");
        user.setUsername("哈哈");
        user.setPassword("7777");
        repository.save(user);
    }
    @Test
    public void delete(){
        String id = "8a04afc575fe9d3a0175fe9d43090000";
        repository.deleteById(id);
    }
    @Test
    public void findById(){
        String id = "8a04afc575fe9e9a0175fe9ea3b00000";
        Optional<User> optional = repository.findById(id);
        User user = optional.get();
        System.out.println(user);
    }
    @Test
    public void findAll(){
        List<User> list = repository.findAll();
        for(User u : list){
            System.out.println(u);
        }
    }
}
