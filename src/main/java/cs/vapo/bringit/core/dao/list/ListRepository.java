package cs.vapo.bringit.core.dao.list;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ListRepository extends CrudRepository<ListEntity, Long> {

    List<ListEntity> findListByOwnerId(final long ownerId);

    Optional<ListEntity> findOwnerIdById(final long listId);
}
