package br.com.felipe.cassandra.reactivecassandra.service;

import br.com.felipe.cassandra.reactivecassandra.ReactiveCassandraApplication;
import br.com.felipe.cassandra.reactivecassandra.config.CassandraConfig;
import br.com.felipe.cassandra.reactivecassandra.entity.PersonEntity;
import br.com.felipe.cassandra.reactivecassandra.repository.PersonRepository;
import com.datastax.oss.driver.api.core.CqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReactiveCassandraApplication.class);

    @Autowired
    PersonRepository repository;

    public PersonEntity newPerson(String name, int age) {
        return new PersonEntity(UUID.randomUUID().toString(), name, age);
    }

    public void execute(String[] args) {

        List<PersonEntity> persons = new ArrayList<>();
        System.out.println("Criando pessoas...");
        for (int i = 0; i < 100000; i++) {
            persons.add(newPerson("Jon Doe", 40));
        }
        System.out.println("Pessoas criadas...");
        System.out.println("Inserindo dados...");
        repository.saveAll(persons);
        System.out.println("The end.");
    }
}
