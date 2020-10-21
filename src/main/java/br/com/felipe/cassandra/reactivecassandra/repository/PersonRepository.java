package br.com.felipe.cassandra.reactivecassandra.repository;

import br.com.felipe.cassandra.reactivecassandra.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, String> {
}
