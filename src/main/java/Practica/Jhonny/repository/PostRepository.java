package Practica.Jhonny.repository;

import Practica.Jhonny.entity.Post;
import Practica.Jhonny.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {



}
