package ru.indivio.homecrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.indivio.homecrm.entities.Book;
import ru.indivio.homecrm.entities.Call;
import ru.indivio.homecrm.entities.Client;

import java.util.List;
import java.util.Optional;


@Repository
public interface CallRepository extends JpaRepository<Call, Long> {
    List<Call> findAllByPhone(String phone);
}
