package cs.vapo.bringit.core.dao.list;

import cs.vapo.bringit.core.dao.annotations.DataService;
import cs.vapo.bringit.core.dao.mapper.MapperUtils;
import cs.vapo.bringit.core.dao.model.ListDM;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@DataService
public class ListDataService {

    @Autowired
    private ListRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Retrieves a list given the id
     * @param listId list id
     * @return list if present
     * @throws EntityNotFoundException if list is not found
     */
    public ListDM findListById(final String listId) throws EntityNotFoundException {
        final Optional<ListEntity> entity = repository.findById(listId);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException(String.format("List not found for Id: %s", listId));
        }
        return modelMapper.map(entity.get(), ListDM.class);
    }

    public List<ListDM> findListsByOwnerId(final String ownerId) {
        final List<ListEntity> lists = repository.findListByOwnerId(ownerId);
        return MapperUtils.mapList(lists, ListDM.class);
    }
}
