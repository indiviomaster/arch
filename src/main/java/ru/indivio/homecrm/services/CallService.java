package ru.indivio.homecrm.services;

import ru.indivio.homecrm.entities.Call;

import java.util.List;


public interface CallService {
    List<Call> findAllByPhone(String phone);
    Iterable<Call> findAll();
    boolean save(Call call);
    void delete(Long id);
}
