package ru.indivio.homecrm.services;

import ru.indivio.homecrm.entities.Client;




public interface ClientService {
    Client findOneByLoginName(String loginName);
    Client findOneByEmail(String email);
    boolean save(Client client);
    Iterable<Client> findAll();
    void delete(Long id);
    boolean cloneById(Long id);
}
