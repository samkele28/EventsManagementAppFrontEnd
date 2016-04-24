package za.samkele.com.eventsmanagementsystem.repository;

import java.util.Set;

/**
 * Created by Samkele on 4/23/2016.
 */
public interface Repository<E,ID> {
    E findById(ID id);

    E save(E entity);

    E update(E entity);

    E delete(E entity);

    Set<E> findAll();
}
