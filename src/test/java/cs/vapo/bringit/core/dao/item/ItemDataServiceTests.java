package cs.vapo.bringit.core.dao.item;

import cs.vapo.bringit.core.dao.list.ListDataService;
import cs.vapo.bringit.core.dao.model.ItemDM;
import cs.vapo.bringit.core.dao.model.ListDM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class ItemDataServiceTests {

    @Autowired
    private ItemDataService itemDataService;

    @Autowired
    private ListDataService listDataService;

    @Test
    void updateAssignee() {
        final long itemId = 28767;
        final long newAssigneeId = 4234234;

        itemDataService.updateAssignee(itemId, newAssigneeId);
        final ItemDM updatedItem = itemDataService.findById(itemId);

        Assertions.assertNotNull(updatedItem);
        Assertions.assertEquals(updatedItem.getAssignee(), newAssigneeId);
    }
}
