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

import java.time.Duration;
import java.time.LocalTime;
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
        int xPessoas = 1000;
        System.out.println("Criando " + xPessoas + " pessoas...");
        for (int i = 0; i < xPessoas; i++) {
            persons.add(newPerson("Jon Doe", 40));
        }
        System.out.println("Pessoas criadas...");
        LocalTime beforeInsert = LocalTime.now();
        System.out.println("Inserindo dados: " + beforeInsert);
        repository.saveAll(persons);
        LocalTime afterInsert = LocalTime.now();
        System.out.println("Dados inseridos: " + afterInsert);
        Duration duration = Duration.between(beforeInsert, afterInsert);
        System.out.println("Tempo decorrido do insert: " + duration.getSeconds() + " segundos");
    }
}
