package br.com.felipe.cassandra.reactivecassandra;

import br.com.felipe.cassandra.reactivecassandra.entity.PersonEntity;
import br.com.felipe.cassandra.reactivecassandra.service.PersonService;
import com.datastax.oss.driver.api.core.CqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;

import java.util.UUID;

@SpringBootApplication
public class ReactiveCassandraApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ReactiveCassandraApplication.class, args);
		PersonService personService = (PersonService) context.getBean("personService");
		personService.execute(null);
	}



}
