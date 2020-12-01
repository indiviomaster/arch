package ru.indivio.homecrm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.indivio.homecrm.entities.Client;
import ru.indivio.homecrm.entities.DecoMessage;
import ru.indivio.homecrm.repositories.ClientRepository;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    @Transactional
    public Client findOneByLoginName(String username) {
        return clientRepository.findOneByLoginName(username);
    }

    @Override
    public Client findOneByEmail(String email) {
        return clientRepository.findOneByEmail(email);
    }

    @Override
    @Transactional
    public boolean save(Client client) {

        if (findOneByLoginName(client.getLoginName()) != null) {
            return false;
        }
        clientRepository.save(client);
        return true;
    }


    @Transactional
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        clientRepository.delete(clientRepository.findById(id).get());
    }

    public boolean cloneById(Long id) {
        Client client = clientRepository.findById(id).get();
        Client cloneClient = client.clone();
        System.out.println(new DecoMessage("Client cloned:".concat(client.getLoginName())).show());
        clientRepository.save(cloneClient);
        return true;
    }


}
