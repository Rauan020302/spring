package ru.andersen.lets.code.sweater.repos;

import org.springframework.data.repository.CrudRepository;
import ru.andersen.lets.code.sweater.domain.Message;

import java.util.List;

public interface Repository extends CrudRepository<Message,Long> {
    List<Message> findByTag(String tag);
}
