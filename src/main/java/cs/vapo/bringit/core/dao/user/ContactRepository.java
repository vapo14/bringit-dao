package cs.vapo.bringit.core.dao.user;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<ContactEntity, Long>,
        PagingAndSortingRepository<ContactEntity, Long> {

    List<ContactEntity> findContactsByUserId(final long userId, final Pageable pageable);
}
