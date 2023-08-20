package cs.vapo.bringit.core.dao.list;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ListRepository extends CrudRepository<ListEntity, String> {

    List<ListEntity> findListByOwnerId(final String ownerId);
}
