package com.codegeekgao.test;

import com.codegeekgao.dao.ActorRepository;
import com.codegeekgao.dao.MovieRepository;
import com.codegeekgao.model.Actor;
import com.codegeekgao.model.Movie;
import com.codegeekgao.model.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * Neo4j测试类
 *
 * @author Denniegao
 * @version Id: Neo4jTest.java, v 0.1 2018/4/12 下午11:29 Denniegao Exp $$
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class Neo4jTest {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ActorRepository actorRepository;


    @Before
    public void init() {
        movieRepository.deleteAll();
        actorRepository.deleteAll();

        Movie firstMovie = new Movie();
        firstMovie.setTitle("Ready Player One");
        firstMovie.setYear("2018-03-30");

        Movie secondMovie = new Movie();
        secondMovie.setTitle("PacificRim: Uprising");
        secondMovie.setYear("2018-03-23");

        Movie thirdMovie = new Movie();
        thirdMovie.setTitle("Tomb Raider");
        thirdMovie.setYear("2018-03-16");

        Actor chineseActor = new Actor();
        chineseActor.setName("Daniel Wu");

        Actor laurence = new Actor();
        laurence.setName("Jing Tian");

        Actor AmericanDirector = new Actor();
        AmericanDirector.setName("Steven Allan Spielberg");

        firstMovie.addRole(chineseActor, "Neo");
        firstMovie.addRole(laurence, "Morpheus");
        firstMovie.addRole(AmericanDirector, "Trinity");
        movieRepository.save(firstMovie);
        Assert.notNull(firstMovie.getId());

        secondMovie.addRole(chineseActor, "Neo");
        secondMovie.addRole(laurence, "Morpheus");
        secondMovie.addRole(AmericanDirector, "Trinity");
        movieRepository.save(secondMovie);
        Assert.notNull(secondMovie.getId());

        thirdMovie.addRole(chineseActor, "Neo");
        thirdMovie.addRole(laurence, "Morpheus");
        thirdMovie.addRole(AmericanDirector, "Trinity");
        movieRepository.save(thirdMovie);
        Assert.notNull(thirdMovie);
    }


    @Test
    public void get() {
        Movie movie = movieRepository.findByTitle("Ready Player One");
        Assert.notNull(movie);
        log.info("===movie=== movie:{}, {}", movie.getTitle(), movie.getYear());
        for (Role role : movie.getRoles()) {
            log.info("====== actor:{}, role:{}", role.getActor().getName(), role.getRole());
        }
    }


    @Test
    public void testLike() {
        Movie readyPlayerOne = movieRepository.findByTitleLike("Ready Player One");
        System.out.println(readyPlayerOne);
    }
}
