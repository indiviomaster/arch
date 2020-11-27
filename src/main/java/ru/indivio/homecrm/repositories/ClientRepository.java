package ru.indivio.homecrm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.indivio.homecrm.entities.Client;


@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    Client findOneByLoginName(String username);
    Client findOneByEmail(String email);
}
