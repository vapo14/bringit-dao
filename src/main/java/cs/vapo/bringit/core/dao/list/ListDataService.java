package cs.vapo.bringit.core.dao.list;

import cs.vapo.bringit.core.dao.annotations.DataService;
import cs.vapo.bringit.core.dao.item.ItemEntity;
import cs.vapo.bringit.core.dao.mapper.MapperUtils;
import cs.vapo.bringit.core.dao.model.ItemDM;
import cs.vapo.bringit.core.dao.model.ListDM;
import cs.vapo.bringit.core.dao.user.UserEntity;
import cs.vapo.bringit.core.dao.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@DataService
public class ListDataService {

    private final ListRepository listRepository;

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public ListDataService(final ListRepository listRepository, final UserRepository userRepository, final ModelMapper modelMapper) {
        this.listRepository = listRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Retrieves a list given the id
     * @param listId list id
     * @return list if present
     * @throws EntityNotFoundException if list is not found
     */
    public ListDM findListById(final long listId) throws EntityNotFoundException {
        final Optional<ListEntity> entity = listRepository.findById(listId);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException(String.format("List not found for Id: %s", listId));
        }
        return modelMapper.map(entity.get(), ListDM.class);
    }

    /**
     * Finds the lists given the owner's id
     * @param ownerId the owner id
     * @return the lists that belong to the owner
     */
    public List<ListDM> findListsByOwnerId(final long ownerId) {
        final List<ListEntity> lists = listRepository.findListByOwnerId(ownerId);
        return MapperUtils.mapList(lists, ListDM.class);
    }

    /**
     * Adds the given item to the list
     * @param listId parent list id
     * @param item the item to add
     */
    public void addItemToList(final long listId, final ItemDM item) {
        final ItemEntity itemEntity = modelMapper.map(item, ItemEntity.class);
        final Optional<ListEntity> listOptional = listRepository.findById(listId);
        if (listOptional.isEmpty()) {
            throw new EntityNotFoundException(String.format("List id %s not found for operation insert item", listId));
        }
        final ListEntity list = listOptional.get();
        list.getItems().add(itemEntity);
    }

    /**
     * Creates a new list item
     * @param list the list information
     */
    public ListDM createList(final long ownerId, final ListDM list) {
        final Optional<UserEntity> userOptional = userRepository.findById(ownerId);
        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException(String.format("User with id: %s not found for operation create list", ownerId));
        }
        final ListEntity newList = new ListEntity();
        newList.setOwner(userOptional.get());
        newList.setTitle(list.getTitle());
        newList.setEventDate(list.getEventDate());
        final ListEntity savedList = listRepository.save(newList);
        return modelMapper.map(savedList, ListDM.class);
    }
}
