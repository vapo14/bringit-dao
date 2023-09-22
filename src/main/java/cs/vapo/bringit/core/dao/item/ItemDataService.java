package cs.vapo.bringit.core.dao.item;

import cs.vapo.bringit.core.dao.annotations.DataService;
import cs.vapo.bringit.core.dao.model.ItemDM;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@DataService
public class ItemDataService {

    @Autowired
    private ItemRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Updates an item with the new assignee userId
     * @param itemId the item to update
     * @param userId the userId of the new assignee
     */
    public void updateAssignee(final String itemId, final String userId) {
        final Optional<ItemEntity> itemEntityOptional = repository.findById(itemId);
        if (itemEntityOptional.isEmpty()) {
            throw new EntityNotFoundException(String.format("No item found for id: %s", itemId));
        }
        final ItemEntity item = itemEntityOptional.get();
        item.setAssignee(userId);
    }

    /**
     * Saves an item to the repository
     * @param item the item to save
     */
    public void saveItem(final ItemDM item) {
        final ItemEntity entity = modelMapper.map(item, ItemEntity.class);
        repository.save(entity);
    }
}
