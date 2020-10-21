package br.com.felipe.cassandra.reactivecassandra.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table(value = "person")
@RequiredArgsConstructor
public class PersonEntity {

    @PrimaryKey
    private final String id;
    private final String name;
    private final int age;

}

