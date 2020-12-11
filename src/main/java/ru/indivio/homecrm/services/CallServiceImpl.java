package ru.indivio.homecrm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.indivio.homecrm.entities.Call;
import ru.indivio.homecrm.repositories.CallRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CallServiceImpl implements CallService {
    private CallRepository callRepository;

    @Autowired
    public void setCallRepository(CallRepository callRepository) {
        this.callRepository = callRepository;
    }

    @Transactional
    public Optional<Call> findById(Long id) {
        return callRepository.findById(id);
    }

    @Override
    @Transactional
    public boolean save(Call call) {
        callRepository.save(call);
        return true;
    }


    @Override
    public List<Call> findAllByPhone(String phone) {
        return callRepository.findAllByPhone(phone);
    }

    @Transactional
    public Iterable<Call> findAll() {
        return callRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        callRepository.delete(callRepository.findById(id).get());
    }




}
