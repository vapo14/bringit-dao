package cs.vapo.bringit.core.dao.item;

import cs.vapo.bringit.core.dao.annotations.DataService;
import cs.vapo.bringit.core.dao.model.ItemDM;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
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
     * Returns the item by the given id
     * @param itemId the item id to look for
     * @return the item if present, null otherwise
     */
    @Nullable
    public ItemDM findById(@Nonnull final String itemId) {
        final Optional<ItemEntity> itemEntityOptional = repository.findById(itemId);
        if (itemEntityOptional.isEmpty()) {
            throw new EntityNotFoundException(String.format("No item found for id: %s", itemId));
        }
        final ItemEntity item = itemEntityOptional.get();
        return modelMapper.map(item, ItemDM.class);
    }
}
